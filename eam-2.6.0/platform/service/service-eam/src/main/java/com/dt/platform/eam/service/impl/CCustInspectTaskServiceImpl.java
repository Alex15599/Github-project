package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.CCustInspectAssetAddEnum;
import com.dt.platform.constants.enums.eam.CCustInspectItemStatusEnum;
import com.dt.platform.constants.enums.eam.CCustInspectTaskStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.CCustInspectTaskMeta;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.ICCustInspectItemService;
import com.dt.platform.eam.service.ICCustInspectUserSService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.eam.service.ICCustInspectTaskService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 巡检任务单服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 10:32:46
*/


@Service("EamCCustInspectTaskService")

public class CCustInspectTaskServiceImpl extends SuperService<CCustInspectTask> implements ICCustInspectTaskService {

	@Autowired
	private ICCustInspectUserSService cCustInspectUserSService;

	@Autowired
	private ICCustInspectItemService cCustInspectItemService;

	@Autowired
	private IAssetService assetService;


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
	 * @param cCustInspectTask  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CCustInspectTask cCustInspectTask,boolean throwsException) {

		if(cCustInspectTask.getCode()==null){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_SOFTWARE_INSERT.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				cCustInspectTask.setCode(codeResult.getData().toString());
			}
		}
		cCustInspectTask.setStatus(CCustInspectTaskStatusEnum.WAIT.code());
		Result r=super.insert(cCustInspectTask,throwsException);
		if(r.isSuccess()){
			List<String> userIds=cCustInspectTask.getMemberIds();
			if(userIds!=null){
				for(String userId:userIds){
					CCustInspectUserS u=new CCustInspectUserS();
					u.setUserId(userId);
					u.setOwnerId(cCustInspectTask.getId());
					cCustInspectUserSService.insert(u,false);
				}
			}
			//获取模版的资产数据
			dao().fill(cCustInspectTask).with(CCustInspectTaskMeta.ASSET_IN_TPL_LIST).execute();
			List<Asset> assetList=cCustInspectTask.getAssetInTplList();
			if(assetList!=null&&assetList.size()>0){
				for(Asset asset:assetList){
					CCustInspectItem item =new CCustInspectItem();
					item.setStatus(CCustInspectItemStatusEnum.WAIT.code());
					item.setOwnerId(cCustInspectTask.getId());
					item.setAssetId(asset.getId());
					item.setAssetCode(asset.getAssetCode());
					item.setAssetName(asset.getName());
					item.setAssetModel(asset.getModel());
					item.setAssetSeq(asset.getSerialNumber());
					cCustInspectItemService.insert(item,false);
				}
			}
		}
		return r;
	}

	@Override
	public Result<JSONObject> inspectScan(String taskId, String assetCode) {

		if(StringUtil.isBlank(taskId)){
			return ErrorDesc.failureMessage("taskId未设置");
		}
		CCustInspectTask task =this.getById(taskId);
		if(task==null){
			return ErrorDesc.failureMessage("未查询到本次巡检任务");
		}
		if(CCustInspectTaskStatusEnum.CANCEL.code().equals(task.getStatus())||
				CCustInspectTaskStatusEnum.FINISH.code().equals(task.getStatus())){
			return ErrorDesc.failureMessage("当前巡检任务已结束");
		}
		if(StringUtil.isBlank(assetCode)){
			return ErrorDesc.failureMessage("二维码扫描结果为空");
		}
		Asset assetQuery=new Asset();
		assetQuery.setAssetCode(assetCode);
		assetQuery.setOwnerCode("asset");
		List<Asset> assetList=assetService.queryList(assetQuery);
		if(assetList==null){
			return ErrorDesc.failureMessage("当前设备编号为找到资产");
		}
		if(assetList.size()==0){
			return ErrorDesc.failureMessage("当前设备编号为找到资产");
		}
		if(assetList.size()>1){
			return ErrorDesc.failureMessage("当前设备编号找到多个设备,请先在后台对设备编号进行确认");
		}
		String assetId=assetList.get(0).getId();
		CCustInspectItem cCustInspectItemQuery=new CCustInspectItem();
		cCustInspectItemQuery.setAssetId(assetId);
		cCustInspectItemQuery.setOwnerId(taskId);
		List<CCustInspectItem> cCustInspectItemList=cCustInspectItemService.queryList(cCustInspectItemQuery);

		if(cCustInspectItemList!=null&&cCustInspectItemList.size()>1){
			return ErrorDesc.failureMessage("当前设备编号找到多个设备,请先在后台对设备编号进行确认");
		}

		JSONObject resultObj=new JSONObject();
		resultObj.put("assetId",assetId);
		resultObj.put("assetCode",assetList.get(0).getAssetCode());
		resultObj.put("assetName",assetList.get(0).getName());
		resultObj.put("assetModel",assetList.get(0).getModel());
		resultObj.put("taskId",taskId);
		if(CCustInspectAssetAddEnum.YES.code().equals(task.getActionAdd())){
			//可以追加的情况
			resultObj.put("taskItemId",cCustInspectItemList.get(0).getId());
		}else{
			//不可以追加的情况
			if(cCustInspectItemList==null||cCustInspectItemList.size()==0){
				return ErrorDesc.failureMessage("当前设备不在本次巡检清单中");
			}
		}
		Result<JSONObject> r=new Result<>();
		r.success(true);
		r.data(resultObj);
		return r;
	}

	@Override
	public Result inspect(String taskId, String assetId,String status,String ct,String picIds) {

		CCustInspectTask task =this.getById(taskId);
		//巡检状态
		if(CCustInspectTaskStatusEnum.WAIT.code().equals(task.getStatus())
		|| CCustInspectTaskStatusEnum.INSPECTING.code().equals(task.getStatus())){
		 	System.out.println("可以进行操作");
			if(CCustInspectTaskStatusEnum.WAIT.code().equals(task.getStatus())){
				task.setStartTime(new Date());
				task.setStatus(CCustInspectTaskStatusEnum.INSPECTING.code());
				this.update(task,SaveMode.NOT_NULL_FIELDS,false);
			}
		}else{
			return ErrorDesc.failureMessage("当前状态无法进行该操作");
		}

		String curId= SessionUser.getCurrent().getActivatedEmployeeId();
		//判断巡检人员,如果巡检人员为空，则所有人都可以巡检，如果有指定巡检人员，必须是选择中的巡检人员才能进行巡检
		dao().fill(task)
				.with("leader")
				.with(CCustInspectTaskMeta.MEMBER_LIST)
				.execute();
		//判断本人是否可以进行巡检操作
		List<Employee> userList=task.getMemberList();
		if(userList==null||userList.size()==0){
			System.out.println("可以运行");
		}else{
			String sql="select 1 from eam_c_cust_inspect_user_s where owner_id=? and user_id=?";
			if(dao.queryRecord(sql,taskId,curId)==null){
				return ErrorDesc.failureMessage("当前没有权限进行巡检操作");
			}
		}

		//进行巡检操作cCustInspectItemService
		CCustInspectItem itemQuery=new CCustInspectItem();
		itemQuery.setOwnerId(taskId);
		itemQuery.setAssetId(assetId);
		CCustInspectItem cCustInspectItem=cCustInspectItemService.queryEntity(itemQuery);
		if(cCustInspectItem==null){
			if(CCustInspectAssetAddEnum.YES.code().equals(task.getActionAdd())){
				//可以追加
				CCustInspectItem item=new CCustInspectItem();
				Asset asset=assetService.getById(assetId);
				item.setOwnerId(taskId);
				item.setAssetId(assetId);
				item.setAssetName(asset.getName());
				item.setAssetCode(asset.getAssetCode());
				item.setAssetModel(asset.getModel());
				item.setAssetSeq(asset.getSerialNumber());
				item.setStatus(status);
				item.setCt(ct);
				item.setRecordTime(new Date());
				item.setInspectUserId(curId);
				cCustInspectItemService.insert(item,false);


			}
		}else{
			cCustInspectItem.setStatus(status);
			cCustInspectItem.setCt(ct);
			cCustInspectItem.setRecordTime(new Date());
			cCustInspectItem.setInspectUserId(curId);
			cCustInspectItemService.update(cCustInspectItem,SaveMode.NOT_NULL_FIELDS);
		}


		return ErrorDesc.success();
	}

	@Override
	public Result finish(String id) {
		CCustInspectTask task=this.getById(id);
		if(!CCustInspectTaskStatusEnum.INSPECTING.code().equals(task.getStatus())){
			return ErrorDesc.failureMessage("当前状态无法进行该操作");
		}
		if(dao.queryRecord("select count(1) cnt from eam_c_cust_inspect_item where deleted=0 and status='wait' and owner_id=?",id).getInteger("cnt")>0){
			return ErrorDesc.failureMessage("有未完成的巡检设备，请完成所有巡检后在进行本次巡检确认");
		}
		task.setFinishTime(new Date());
		task.setStatus(CCustInspectTaskStatusEnum.FINISH.code());
		this.update(task,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}

	@Override
	public Result start(String id) {
		CCustInspectTask task=this.getById(id);
		task.getStatus();
		if(!CCustInspectTaskStatusEnum.WAIT.code().equals(task.getStatus())){
			return ErrorDesc.failureMessage("当前状态无法进行该操作");
		}
		task.setStartTime(new Date());
		task.setStatus(CCustInspectTaskStatusEnum.INSPECTING.code());
		this.update(task,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id) {
		CCustInspectTask task=this.getById(id);
		task.getStatus();
		if(CCustInspectTaskStatusEnum.FINISH.code().equals(task.getStatus())){
			return ErrorDesc.failureMessage("当前状态无法进行该操作");
		}
		dao.execute("update eam_c_cust_inspect_task set status=? where id=?",CCustInspectTaskStatusEnum.CANCEL.code(),id);
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param cCustInspectTask 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CCustInspectTask cCustInspectTask) {
		return this.insert(cCustInspectTask,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param cCustInspectTaskList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CCustInspectTask> cCustInspectTaskList) {
		return super.insertList(cCustInspectTaskList);
	}

	
	/**
	 * 按主键删除巡检任务单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CCustInspectTask cCustInspectTask = new CCustInspectTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		cCustInspectTask.setId(id);
		try {
			boolean suc = dao.deleteEntity(cCustInspectTask);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除巡检任务单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CCustInspectTask cCustInspectTask = new CCustInspectTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		cCustInspectTask.setId(id);
		cCustInspectTask.setDeleted(true);
		cCustInspectTask.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		cCustInspectTask.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(cCustInspectTask,SaveMode.NOT_NULL_FIELDS);
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
	 * @param cCustInspectTask 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CCustInspectTask cCustInspectTask , SaveMode mode) {
		return this.update(cCustInspectTask,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param cCustInspectTask 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CCustInspectTask cCustInspectTask , SaveMode mode,boolean throwsException) {
		Result r=super.update(cCustInspectTask , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from eam_c_cust_inspect_user_s where owner_id=?",cCustInspectTask.getId());
			List<String> userIds=cCustInspectTask.getMemberIds();
			if(userIds!=null){
				for(String userId:userIds){
					CCustInspectUserS u=new CCustInspectUserS();
					u.setUserId(userId);
					u.setOwnerId(cCustInspectTask.getId());
					cCustInspectUserSService.insert(u,false);
				}
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param cCustInspectTaskList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CCustInspectTask> cCustInspectTaskList , SaveMode mode) {
		return super.updateList(cCustInspectTaskList , mode);
	}

	
	/**
	 * 按主键更新巡检任务单
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
	 * 按主键获取巡检任务单
	 *
	 * @param id 主键
	 * @return CCustInspectTask 数据对象
	 */
	public CCustInspectTask getById(String id) {
		CCustInspectTask sample = new CCustInspectTask();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<CCustInspectTask> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<CCustInspectTask> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CCustInspectTask> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CCustInspectTask::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CCustInspectTask> queryList(CCustInspectTaskVO sample) {
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
	public PagedList<CCustInspectTask> queryPagedList(CCustInspectTaskVO sample, int pageSize, int pageIndex) {
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
	public PagedList<CCustInspectTask> queryPagedList(CCustInspectTask sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param cCustInspectTask 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CCustInspectTask cCustInspectTask) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(cCustInspectTask, SYS_ROLE.NAME);
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