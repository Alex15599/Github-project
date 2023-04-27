package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.AssetProcessRecord;
import com.dt.platform.domain.eam.AssetRepair;
import com.dt.platform.domain.eam.meta.AssetRepairMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.eam.service.bpm.AssetRepairBpmEventAdaptor;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.framework.bpm.BpmAssistant;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 资产报修 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 21:17:05
*/


@Service("EamAssetRepairService")
public class AssetRepairServiceImpl extends SuperService<AssetRepair> implements IAssetRepairService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	private IAssetService assetService;

	@Autowired
	private AssetItemServiceImpl assetItemService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;


	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;



	/**
	 * 处理流程回调
	 * */
	public BpmActionResult onProcessCallback(BpmEvent event) {
		return (new AssetRepairBpmEventAdaptor(this)).onProcessCallback(event);
	}

	@Override
	public void joinProcess(AssetRepair assetRepair) {
		this.joinProcess(Arrays.asList(assetRepair));
	}

	@Override
	public void joinProcess(List<AssetRepair> assetRepairList) {
		BpmAssistant.joinProcess(assetRepairList, IAssetAllocationService.FORM_DEFINITION_CODE);
	}

	@Override
	public void joinProcess(PagedList<AssetRepair> assetRepairList) {
		this.joinProcess(assetRepairList.getList());
	}



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}



	@Override
	public Map<String, Object> getBill(String id) {

		AssetRepair data= AssetRepairServiceProxy.api().getById(id).getData();
		join(data, AssetRepairMeta.ASSET_LIST);
		Map<String, Object> map= BeanUtil.toMap(data);
		if(data.getStatus()!=null){
			CodeTextEnum en= EnumUtil.parseByCode(AssetHandleStatusEnum.class,data.getStatus());
			map.put("statusName", en==null?data.getStatus():en.text());
		}
		return map;
	}

	private void syncBill(String id, ChangeEvent event) {
		AssetRepair asset4Update=AssetRepair.create();
//		asset4Update.setId(id)
//				//设置变更ID
//				.setChangeInstanceId(event.getInstance().getId())
//				//更新状态
//				.setChsStatus(event.getInstance().getStatusEnum().code())
//				//更新最后审批人
//				.setLatestApproverId(event.getApproverId())
//				.setLatestApproverName(event.getApproverName())
//				//设置下一节点审批人
//				.setNextApproverIds(event.getSimpleNextApproverIds())
//				.setNextApproverNames(event.getSimpleNextApproverNames())
//				//更新流程概要
//				.setSummary(event.getDefinition().getName()+","+event.getApproveActionEnum().text());
		//执行更新
		this.update(asset4Update,SaveMode.BESET_FIELDS);
	}






	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(String id,String result,String status,String message) {
		AssetRepair repair=this.getById(id);
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			Result verifyResult= verifyBillData(id);
			if(!verifyResult.isSuccess()) return verifyResult;

			Result applayResult=applyChange(id);
			if(!applayResult.isSuccess()) return applayResult;
			AssetRepair bill=new AssetRepair();
			bill.setId(id);
			bill.setStatus(status);

			Result r=super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
			if(r.isSuccess()){
				this.join(repair,AssetRepairMeta.ASSET_LIST);
				List<Asset> assetList=repair.getAssetList();
				if(assetList!=null&&assetList.size()>0){
					for(Asset asset:assetList){
						AssetProcessRecord assetProcessRecord=new AssetProcessRecord();
						assetProcessRecord.setContent("资产维修操作完成");
						assetProcessRecord.setAssetId(asset.getId());
						assetProcessRecord.setBusinessCode(repair.getBusinessCode());
						assetProcessRecord.setProcessType(AssetOperateEnum.EAM_ASSET_REPAIR.code());
						assetProcessRecord.setProcessdTime(new Date());
						assetProcessRecordService.insert(assetProcessRecord);
					}
				}
			}
			return r;
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	/**
	 * 确认操作
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result confirmOperation(String id) {
		AssetRepair billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_REPAIR.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}




	private Result applyChange(String id){
		AssetRepair billData=getById(id);
		join(billData, AssetRepairMeta.ASSET_LIST);
		//维修前状态
		dao.execute("update eam_asset_item a,eam_asset b set a.before_asset_status=b.asset_status where a.asset_id=b.id and a.handle_id=?",id);
		HashMap<String,Object> map=new HashMap<>();
		map.put("asset_status", AssetStatusEnum.REPAIR.code());
		HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(billData.getAssetList(),map,billData.getBusinessCode(),AssetOperateEnum.EAM_ASSET_REPAIR.code(),"维修中");
		for(String key:resultMap.keySet()){
			List<SQL> sqls=resultMap.get(key);
			if(sqls.size()>0){
				dao.batchExecute(sqls);
			}
		}
		billData.setRepairStatus(AssetRepairStatusEnum.REPAIRING.code());
		super.update(billData,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.success();
	}


	@Override
	public Result finishRepair(String id){
		AssetRepair billData=getById(id);
		if(!AssetHandleStatusEnum.COMPLETE.code().equals( billData.getStatus() )){
			return ErrorDesc.failureMessage("当前单据办理状态不能进行结束维修操作");
		}
		if(!AssetRepairStatusEnum.REPAIRING.code().equals( billData.getRepairStatus() )){
			return ErrorDesc.failureMessage("当前单据维修状态不能进行结束维修操作");
		}
		join(billData, AssetRepairMeta.ASSET_LIST);
		HashMap<String,Object> map=new HashMap<>();
		for(Asset asset:billData.getAssetList()){
			List<Asset> list=new ArrayList<>();
			list.add(asset);
			Rcd rs=dao.queryRecord("select * from eam_asset_item where deleted=0 and crd='r' and handle_id=? and asset_id=?",id,asset.getId());
			map.put("asset_status",rs.getString("before_asset_status"));
			HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(list,map,billData.getBusinessCode(),AssetOperateEnum.EAM_ASSET_REPAIR.code(),"维修结束");
			for(String key:resultMap.keySet()){
				List<SQL> sqls=resultMap.get(key);
				if(sqls.size()>0){
					dao.batchExecute(sqls);
				}
			}
		}
		billData.setActualFinishDate(new Date());
		billData.setRepairStatus(AssetRepairStatusEnum.FINISH.code());
		super.update(billData,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.success();
	}


	/**
	 * 插入实体
	 * @param assetRepair 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(AssetRepair assetRepair) {

		if(assetRepair.getAssetIds()==null||assetRepair.getAssetIds().size()==0){
			String assetSelectedCode=assetRepair.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetRepair.setAssetIds(list);
		}

		//校验数据资产
		if(assetRepair.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusinessAction(AssetOperateEnum.EAM_ASSET_REPAIR.code(),assetRepair.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}


		//制单人
		if(StringUtil.isBlank(assetRepair.getOriginatorId())){
			assetRepair.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//报修人
		if(StringUtil.isBlank(assetRepair.getReportUserId())){
			assetRepair.setReportUserId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(assetRepair.getBusinessDate())){
			assetRepair.setBusinessDate(new Date());
		}


		//办理状态
		if(StringUtil.isBlank(assetRepair.getStatus())){
			assetRepair.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}
		assetRepair.setRepairStatus(AssetRepairStatusEnum.WAIT_REPAIR.code());

		//生成编码规则
		//编码
		if(StringUtil.isBlank(assetRepair.getBusinessCode())){
			Result codeResult=CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_REPAIR.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetRepair.setBusinessCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(assetRepair);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetRepair.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetRepair.getId());
				asset.setAssetId(assetRepair.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
		}
		//保存关系
		return r;
	}

	
	/**
	 * 按主键删除 资产报修
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetRepair assetRepair = new AssetRepair();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetRepair.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetRepair);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产报修
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetRepair assetRepair = new AssetRepair();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetRepair.setId(id);
		assetRepair.setDeleted(true);
		assetRepair.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetRepair.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetRepair,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	private Result verifyBillData(String handleId){
		//c  新建,r  原纪录,d  删除,cd 新建删除
		//验证数据
		ConditionExpr itemRecordcondition=new ConditionExpr();
		itemRecordcondition.andIn("handle_id",handleId);
		itemRecordcondition.andIn("crd","c","r");
		List<String> ckDatalist=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordcondition);
		if(ckDatalist.size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		return assetService.checkAssetDataForBusinessAction(CodeModuleEnum.EAM_ASSET_REPAIR.code(),ckDatalist);
	}


	/**
	 * 更新实体
	 * @param assetRepair 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetRepair assetRepair , SaveMode mode) {

		Result verifyResult = verifyBillData(assetRepair.getId());
		if(!verifyResult.isSuccess())return verifyResult;
		Result r=super.update(assetRepair,mode);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",assetRepair.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",assetRepair.getId());
		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetRepairList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetRepair> assetRepairList , SaveMode mode) {
		return super.updateList(assetRepairList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产报修
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 资产报修
	 *
	 * @param id 主键
	 * @return AssetRepair 数据对象
	 */
	public AssetRepair getById(String id) {
		AssetRepair sample = new AssetRepair();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetRepair> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetRepair> queryList(AssetRepair sample) {
		return super.queryList(sample);
	}
	
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<AssetRepair> queryPagedList(AssetRepair sample, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_REPAIR.code();
		return super.queryPagedList(sample, pageSize, pageIndex,dp);
	}
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<AssetRepair> queryPagedList(AssetRepair sample, ConditionExpr condition, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_REPAIR.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetRepair 数据对象
	 * @return 判断结果
	 */
	public Result<AssetRepair> checkExists(AssetRepair assetRepair) {
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetRepair sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
