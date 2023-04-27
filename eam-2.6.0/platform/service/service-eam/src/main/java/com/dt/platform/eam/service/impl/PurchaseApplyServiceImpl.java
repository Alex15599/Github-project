package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.eam.AssetApplyCheckStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleConfirmOperationEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.PurchaseApply;
import com.dt.platform.domain.eam.PurchaseCheck;
import com.dt.platform.domain.eam.PurchaseOrder;
import com.dt.platform.eam.service.IOperateService;
import com.dt.platform.eam.service.IPurchaseApplyService;
import com.dt.platform.eam.service.IPurchaseCheckService;
import com.dt.platform.eam.service.IPurchaseOrderService;
import com.dt.platform.eam.service.bpm.PurchaseApplyBpmEventAdaptor;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
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
 * 采购申请 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-14 21:29:05
*/


@Service("EamPurchaseApplyService")
public class PurchaseApplyServiceImpl extends SuperService<PurchaseApply> implements IPurchaseApplyService {

	@Autowired
	private IPurchaseCheckService purchaseCheckService;


	@Autowired
	private IPurchaseOrderService purchaseOrderService;


	@Autowired
	private IOperateService operateService;

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 处理流程回调
	 * */
	public BpmActionResult onProcessCallback(BpmEvent event) {
		return (new PurchaseApplyBpmEventAdaptor(this)).onProcessCallback(event);
	}

	@Override
	public void joinProcess(PurchaseApply purchaseApply) {
		this.joinProcess(Arrays.asList(purchaseApply));
	}


	@Override
	public void joinProcess(List<PurchaseApply> purchaseApplyList) {
		BpmAssistant.joinProcess(purchaseApplyList, IPurchaseApplyService.FORM_DEFINITION_CODE);
	}

	@Override
	public void joinProcess(PagedList<PurchaseApply> purchaseApplyList) {
		this.joinProcess(purchaseApplyList.getList());
	}



	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param purchaseApply  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(PurchaseApply purchaseApply,boolean throwsException) {


		//制单人
		if(StringUtil.isBlank(purchaseApply.getOriginatorId())){
			purchaseApply.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//验收状态
		if(StringUtil.isBlank(purchaseApply.getAssetCheck())){
			purchaseApply.setAssetCheck(AssetApplyCheckStatusEnum.NOT_CHECK.code());
		}

		//办理状态
		if(StringUtil.isBlank(purchaseApply.getStatus())){
			purchaseApply.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}



		//生成编码规则
		if(StringUtil.isBlank(purchaseApply.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_PURCHASE_APPLY.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				purchaseApply.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(purchaseApply,throwsException);

		if(r.isSuccess()){
			//更新订单
			String applyId=purchaseApply.getId();
			List<PurchaseOrder> orderList=new ArrayList<>();
			for(int i=0;i<purchaseApply.getOrderIds().size();i++){
				PurchaseOrder e=new PurchaseOrder();
				e.setId(purchaseApply.getOrderIds().get(i));
				e.setApplyId(applyId);
				orderList.add(e);
			}
			purchaseOrderService.updateList(orderList,SaveMode.NOT_NULL_FIELDS);
		}
		return r;
	}


	@Override
	public Map<String, Object> getBill(String id) {
		return null;
	}

	@Override
	public Result check(String id,String checkId) {
		PurchaseApply obj=new PurchaseApply();
		obj.setId(id);
		obj.setAssetCheck(AssetApplyCheckStatusEnum.CHECKED.code());
		PurchaseCheck check=purchaseCheckService.getById(checkId);
		obj.setCheckCode(check.getBusinessCode());
		return super.update(obj,SaveMode.NOT_NULL_FIELDS,false);
	}



	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	@Transactional
	Result operateResult(String id,String result,String status,String message) {
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			PurchaseApply bill=new PurchaseApply();
			bill.setId(id);
			bill.setStatus(status);
			return super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}


	@Override
	public Result confirmOperation(String id) {
		PurchaseApply billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_PURCHASE_APPLY.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id, AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param purchaseApply 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(PurchaseApply purchaseApply) {
		return this.insert(purchaseApply,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param purchaseApplyList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<PurchaseApply> purchaseApplyList) {
		return super.insertList(purchaseApplyList);
	}

	
	/**
	 * 按主键删除 采购申请
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		PurchaseApply purchaseApply = new PurchaseApply();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		purchaseApply.setId(id);
		try {
			boolean suc = dao.deleteEntity(purchaseApply);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 采购申请
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		PurchaseApply purchaseApply = new PurchaseApply();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		purchaseApply.setId(id);
		purchaseApply.setDeleted(1);
		purchaseApply.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		purchaseApply.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(purchaseApply,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param purchaseApply 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PurchaseApply purchaseApply , SaveMode mode) {
		return this.update(purchaseApply,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param purchaseApply 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PurchaseApply purchaseApply , SaveMode mode,boolean throwsException) {
		Result r=super.update(purchaseApply , mode , throwsException);
		if(r.isSuccess()){
			//更新订单
			String applyId=purchaseApply.getId();
			List<PurchaseOrder> orderList=new ArrayList<>();
			for(int i=0;i<purchaseApply.getOrderIds().size();i++){
				PurchaseOrder e=new PurchaseOrder();
				e.setId(purchaseApply.getOrderIds().get(i));
				e.setApplyId(applyId);
				orderList.add(e);
			}
			purchaseOrderService.updateList(orderList,SaveMode.NOT_NULL_FIELDS);
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param purchaseApplyList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<PurchaseApply> purchaseApplyList , SaveMode mode) {
		return super.updateList(purchaseApplyList , mode);
	}

	
	/**
	 * 按主键更新字段 采购申请
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
	 * 按主键获取 采购申请
	 *
	 * @param id 主键
	 * @return PurchaseApply 数据对象
	 */
	public PurchaseApply getById(String id) {
		PurchaseApply sample = new PurchaseApply();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<PurchaseApply> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<PurchaseApply> queryList(PurchaseApply sample) {
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
	public PagedList<PurchaseApply> queryPagedList(PurchaseApply sample, int pageSize, int pageIndex) {
		String dp= AssetOperateEnum.EAM_ASSET_PURCHASE_APPLY.code();
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
	public PagedList<PurchaseApply> queryPagedList(PurchaseApply sample, ConditionExpr condition, int pageSize, int pageIndex) {
		String dp= AssetOperateEnum.EAM_ASSET_PURCHASE_APPLY.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param purchaseApply 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(PurchaseApply purchaseApply) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(purchaseApply, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(PurchaseApply sample) {
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
