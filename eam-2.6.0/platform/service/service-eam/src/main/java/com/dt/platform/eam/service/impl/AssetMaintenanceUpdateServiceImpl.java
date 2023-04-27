package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetMaintenanceUpdateHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta;
import com.dt.platform.eam.service.IAssetMaintenanceRecordService;
import com.dt.platform.eam.service.IAssetMaintenanceUpdateService;
import com.dt.platform.eam.service.IAssetProcessRecordService;
import com.dt.platform.eam.service.IAssetSelectedDataService;
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
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维保更新服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 20:11:34
*/


@Service("EamAssetMaintenanceUpdateService")
public class AssetMaintenanceUpdateServiceImpl extends SuperService<AssetMaintenanceUpdate> implements IAssetMaintenanceUpdateService {

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
	private IAssetProcessRecordService assetProcessRecordService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;

	@Autowired
	private IAssetMaintenanceRecordService assetMaintenanceRecordService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}



	@Override
	public Result fillData(List<String> ids) {
		for(String id:ids){
			fillDataById(id);
		}
		return ErrorDesc.success();
	}

	public Result fillDataById(String id) {
		String sql="update eam_asset_maintenance_record a,eam_asset b set \n" +
				"a.maintainer_id=b.maintainer_id,\n" +
				"a.maintainer_name=b.maintainer_name,\n" +
				"a.maintenance_status=b.maintenance_status,\n" +
				"a.maintenance_method=b.maintenance_method,\n" +
				"a.suggest_maintenance_method=b.suggest_maintenance_method,\n" +
				"a.contacts=b.contacts,\n" +
				"a.contact_information=b.contact_information,\n" +
				"a.director=b.director,\n" +
				"a.maintenance_start_date=b.maintenance_start_date,\n" +
				"a.maintenance_end_date=b.maintenance_end_date,\n" +
				"a.maintenance_notes=b.maintenance_notes\n" +
				"where a.asset_id=b.id and a.id=?";
		dao.execute(sql,id);
		return ErrorDesc.success();
	}


	@Override
	public Result actionUpdate(String id) {
		AssetMaintenanceUpdate data=this.getById(id);
		if(!AssetMaintenanceUpdateHandleStatusEnum.DRAFT.code().equals(data.getHandleStatus())){
			return ErrorDesc.failureMessage("当前业务状态不允许操作");
		}
		AssetMaintenanceRecord recordQuery=new AssetMaintenanceRecord();
		recordQuery.setMaintenanceUpdateId(id);
		List<AssetMaintenanceRecord> list=assetMaintenanceRecordService.queryList(recordQuery);
		assetMaintenanceRecordService.dao().fill(list).with(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_UPDATE).execute();
		if(list!=null&&list.size()>0){
			for(AssetMaintenanceRecord record:list){

				updateAssetMaintenanceData(record);
			}
		}else{
			return ErrorDesc.failureMessage("没有可操作的资产数据");
		}
		data.setHandleStatus(AssetMaintenanceUpdateHandleStatusEnum.FINISH.code());
		this.update(data,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.success();
	}



	private Result updateAssetMaintenanceData(AssetMaintenanceRecord record){
		List<String> colList=new ArrayList<>();

		AssetMaintenanceUpdate assetMaintenanceUpdate=record.getAssetMaintenanceUpdate();
		if(assetMaintenanceUpdate==null){
			assetMaintenanceUpdate=this.getById(record.getMaintenanceUpdateId());
		}
		colList.add("maintainer_id");
		colList.add("maintainer_name");
		colList.add("maintenance_status");
		colList.add("maintenance_method");
		colList.add("suggest_maintenance_method");
		colList.add("contacts");
		colList.add("contact_information");
		colList.add("director");
		colList.add("maintenance_start_date");
		colList.add("maintenance_end_date");
		colList.add("maintenance_notes");
		for(String col:colList){
			String sql="update eam_asset a,eam_asset_maintenance_record b set a."+col+"=b."+col+" where a.id=b.asset_id and b.s_"+col+"='enable' and b.deleted=0 and b.id=?";
			dao.execute(sql,record.getId());
		}
		AssetProcessRecord actionRecord=new AssetProcessRecord();
		actionRecord.setAssetId(record.getAssetId());
		actionRecord.setProcessdTime(new Date());
		actionRecord.setBusinessCode(assetMaintenanceUpdate.getBusinessCode());
		actionRecord.setContent("维保数据变更");
		actionRecord.setProcessType(AssetOperateEnum.EAM_ASSET_CHANGE_MAINTENANCE_2 .code());
		assetProcessRecordService.insert(actionRecord);
		return ErrorDesc.success();
	}



	@Override
	public Result batchOper(String id) {


		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id){

		AssetMaintenanceUpdate assetMaintenanceUpdate=this.getById(id);
		dao.execute("update eam_asset_maintenance_update set handle_status=? where id=?",AssetMaintenanceUpdateHandleStatusEnum.CANCEL.code(),id);
		return ErrorDesc.success();
	}

	@Override
	public Result insertAsset(String id,String selectedCode){

		if(StringUtil.isBlank(id)){
			return ErrorDesc.failureMessage("ID不能为空");
		}

		if(StringUtil.isBlank(selectedCode)){
			return ErrorDesc.failureMessage("selectedCode不能为空");
		}

		AssetMaintenanceUpdate assetMaintenanceUpdate=this.getById(id);
		if(!AssetMaintenanceUpdateHandleStatusEnum.DRAFT.code().equals( assetMaintenanceUpdate.getHandleStatus())  ){
			return ErrorDesc.failureMessage("当前业务状态不能进行操作");
		}

		AssetSelectedData assetSelectedDataQuery=new AssetSelectedData();
		assetSelectedDataQuery.setAssetSelectedCode(selectedCode);
		List<AssetSelectedData> list=assetSelectedDataService.queryList(assetSelectedDataQuery);

		if(list!=null&&list.size()>0){
			for(AssetSelectedData e:list){
				insertAssetToRecord(id,e.getAssetId());
			}
		}
		return ErrorDesc.success();
	}


	public Result insertAssetToRecord(String id,String assetId){

		AssetMaintenanceRecord assetMaintenanceRecordQuery=new AssetMaintenanceRecord();
		assetMaintenanceRecordQuery.setAssetId(assetId);
		assetMaintenanceRecordQuery.setMaintenanceUpdateId(id);
		AssetMaintenanceRecord data=assetMaintenanceRecordService.queryEntity(assetMaintenanceRecordQuery);
		if(data!=null){
			//已存在
			return ErrorDesc.success();
		}

		assetMaintenanceRecordService.insert(assetMaintenanceRecordQuery);
		return ErrorDesc.success();
	}


	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetMaintenanceUpdate  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetMaintenanceUpdate assetMaintenanceUpdate,boolean throwsException) {
		assetMaintenanceUpdate.setHandleStatus(AssetMaintenanceUpdateHandleStatusEnum.DRAFT.code());
		//生成编码规则
		if(StringUtil.isBlank(assetMaintenanceUpdate.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.COMMON_CODE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetMaintenanceUpdate.setBusinessCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(assetMaintenanceUpdate,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetMaintenanceUpdate 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetMaintenanceUpdate assetMaintenanceUpdate) {

		return this.insert(assetMaintenanceUpdate,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetMaintenanceUpdateList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetMaintenanceUpdate> assetMaintenanceUpdateList) {
		return super.insertList(assetMaintenanceUpdateList);
	}

	
	/**
	 * 按主键删除维保更新
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetMaintenanceUpdate assetMaintenanceUpdate = new AssetMaintenanceUpdate();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetMaintenanceUpdate.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetMaintenanceUpdate);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除维保更新
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetMaintenanceUpdate assetMaintenanceUpdate = new AssetMaintenanceUpdate();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetMaintenanceUpdate.setId(id);
		assetMaintenanceUpdate.setDeleted(true);
		assetMaintenanceUpdate.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetMaintenanceUpdate.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetMaintenanceUpdate,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetMaintenanceUpdate 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetMaintenanceUpdate assetMaintenanceUpdate , SaveMode mode) {
		return this.update(assetMaintenanceUpdate,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetMaintenanceUpdate 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetMaintenanceUpdate assetMaintenanceUpdate , SaveMode mode,boolean throwsException) {

		AssetMaintenanceUpdate sourceData=this.getById(assetMaintenanceUpdate.getId());
		if(!AssetMaintenanceUpdateHandleStatusEnum.DRAFT.code().equals(sourceData.getHandleStatus())){
			return ErrorDesc.failureMessage("当前业务状态不能进行修改操作");
		}
		assetMaintenanceUpdate.setBusinessCode(null);
		Result r=super.update(assetMaintenanceUpdate , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetMaintenanceUpdateList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetMaintenanceUpdate> assetMaintenanceUpdateList , SaveMode mode) {
		return super.updateList(assetMaintenanceUpdateList , mode);
	}

	
	/**
	 * 按主键更新维保更新
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
	 * 按主键获取维保更新
	 *
	 * @param id 主键
	 * @return AssetMaintenanceUpdate 数据对象
	 */
	public AssetMaintenanceUpdate getById(String id) {
		AssetMaintenanceUpdate sample = new AssetMaintenanceUpdate();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssetMaintenanceUpdate> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssetMaintenanceUpdate> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetMaintenanceUpdate> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetMaintenanceUpdate::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetMaintenanceUpdate> queryList(AssetMaintenanceUpdateVO sample) {
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
	public PagedList<AssetMaintenanceUpdate> queryPagedList(AssetMaintenanceUpdateVO sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
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
	public PagedList<AssetMaintenanceUpdate> queryPagedList(AssetMaintenanceUpdate sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetMaintenanceUpdate 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetMaintenanceUpdate assetMaintenanceUpdate) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetMaintenanceUpdate, SYS_ROLE.NAME);
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






}