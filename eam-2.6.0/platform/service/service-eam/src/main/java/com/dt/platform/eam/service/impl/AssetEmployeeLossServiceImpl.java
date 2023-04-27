package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.AssetEmployeeLoss;
import com.dt.platform.domain.eam.AssetEmployeeLossVO;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.eam.service.*;
import com.dt.platform.eam.service.bpm.AssetEmployeeLossBpmEventAdaptor;
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

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 资产报失 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 22:09:17
*/


@Service("EamAssetEmployeeLossService")
public class AssetEmployeeLossServiceImpl extends SuperService<AssetEmployeeLoss> implements IAssetEmployeeLossService {

	@Autowired
	private IAssetItemService assetItemService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;

	@Autowired
	private IAssetService assetService;

	@Autowired
	private IOperateService operateService;

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

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
	 * @param assetEmployeeLoss  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetEmployeeLoss assetEmployeeLoss,boolean throwsException) {

		if(assetEmployeeLoss.getAssetIds()==null||assetEmployeeLoss.getAssetIds().size()==0){
			String assetSelectedCode=assetEmployeeLoss.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetEmployeeLoss.setAssetIds(list);
		}

		//制单人
		if(StringUtil.isBlank(assetEmployeeLoss.getOriginatorId())){
			assetEmployeeLoss.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}
		//办理状态
		if(StringUtil.isBlank(assetEmployeeLoss.getStatus())){
			assetEmployeeLoss.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetEmployeeLoss.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_EMPLOYEE_LOSS.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetEmployeeLoss.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(assetEmployeeLoss,throwsException);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetEmployeeLoss.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetEmployeeLoss.getId());
				asset.setAssetId(assetEmployeeLoss.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetEmployeeLoss 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetEmployeeLoss assetEmployeeLoss) {
		return this.insert(assetEmployeeLoss,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetEmployeeLossList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetEmployeeLoss> assetEmployeeLossList) {
		return super.insertList(assetEmployeeLossList);
	}

	
	/**
	 * 按主键删除 资产报失
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetEmployeeLoss assetEmployeeLoss = new AssetEmployeeLoss();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetEmployeeLoss.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetEmployeeLoss);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产报失
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetEmployeeLoss assetEmployeeLoss = new AssetEmployeeLoss();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetEmployeeLoss.setId(id);
		assetEmployeeLoss.setDeleted(true);
		assetEmployeeLoss.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetEmployeeLoss.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetEmployeeLoss,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetEmployeeLoss 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetEmployeeLoss assetEmployeeLoss , SaveMode mode) {
		return this.update(assetEmployeeLoss,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetEmployeeLoss 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetEmployeeLoss assetEmployeeLoss , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetEmployeeLoss , mode , throwsException);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",assetEmployeeLoss.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",assetEmployeeLoss.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetEmployeeLossList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetEmployeeLoss> assetEmployeeLossList , SaveMode mode) {
		return super.updateList(assetEmployeeLossList , mode);
	}

	
	/**
	 * 按主键更新字段 资产报失
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
	 * 按主键获取 资产报失
	 *
	 * @param id 主键
	 * @return AssetEmployeeLoss 数据对象
	 */
	public AssetEmployeeLoss getById(String id) {
		AssetEmployeeLoss sample = new AssetEmployeeLoss();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssetEmployeeLoss> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssetEmployeeLoss> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetEmployeeLoss> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetEmployeeLoss::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetEmployeeLoss> queryList(AssetEmployeeLossVO sample) {
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
	public PagedList<AssetEmployeeLoss> queryPagedList(AssetEmployeeLossVO sample, int pageSize, int pageIndex) {

		String dp=AssetOperateEnum.EAM_ASSET_EMPLOYEE_LOSS.code();
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
	public PagedList<AssetEmployeeLoss> queryPagedList(AssetEmployeeLoss sample, ConditionExpr condition, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_EMPLOYEE_LOSS.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetEmployeeLoss 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetEmployeeLoss assetEmployeeLoss) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetEmployeeLoss, SYS_ROLE.NAME);
		//return exists;
		return false;
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
	public ExcelWriter exportExcel(AssetEmployeeLoss sample) {
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

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


	/**
	 * 处理流程回调
	 * */
	public  BpmActionResult onProcessCallback(BpmEvent event) {
		return (new AssetEmployeeLossBpmEventAdaptor(this)).onProcessCallback(event);
	}

	@Override
	public void joinProcess(AssetEmployeeLoss assetEmployeeLoss) {
		this.joinProcess(Arrays.asList(assetEmployeeLoss));
	}

	@Override
	public void joinProcess(List<AssetEmployeeLoss> assetEmployeeLossList) {
		BpmAssistant.joinProcess(assetEmployeeLossList,IAssetEmployeeLossService.FORM_DEFINITION_CODE);
	}

	@Override
	public void joinProcess(PagedList<AssetEmployeeLoss> assetEmployeeLossList) {
		this.joinProcess(assetEmployeeLossList.getList());
	}


}