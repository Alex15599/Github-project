package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskPointStatusEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskStatusEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskStatusEnum;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import com.dt.platform.domain.eam.meta.CCustInspectTaskMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import com.dt.platform.eam.service.IInspectionTaskPointService;
import com.dt.platform.eam.service.IInspectionTaskService;
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
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Update;
import com.github.foxnic.sql.meta.DBField;
import jdk.nashorn.internal.scripts.JO;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巡检任务 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-13 10:28:04
*/


@Service("EamInspectionTaskService")
public class InspectionTaskServiceImpl extends SuperService<InspectionTask> implements IInspectionTaskService {



	@Autowired
	private IInspectionTaskPointService inspectionTaskPointService;

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
	 * @param inspectionTask  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(InspectionTask inspectionTask,boolean throwsException) {

		if(StringUtil.isBlank(inspectionTask.getPlanId())){
			return ErrorDesc.failureMessage("计划未选择");
		}

		if(StringUtil.isBlank(inspectionTask.getTaskStatus())){
			inspectionTask.setTaskStatus(MaintainTaskStatusEnum.WAIT.code());
		}

		//生成编码规则
		//编码
		if(StringUtil.isBlank(inspectionTask.getTaskCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INSPECTION_TASK.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				inspectionTask.setTaskCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(inspectionTask,throwsException);
		return r;
	}

	@Override
	public Result<JSONObject> check(String taskId, String pointCode) {
		if(StringUtil.isBlank(taskId)){
			return ErrorDesc.failureMessage("taskId缺失");
		}
		if(StringUtil.isBlank(pointCode)){
			return ErrorDesc.failureMessage("pointCode缺失");
		}

		InspectionTask task=this.getById(taskId);
		if(task==null){
			return ErrorDesc.failureMessage("未找到本次巡检任务");
		}

		//是否可以巡检
		String curId= SessionUser.getCurrent().getActivatedEmployeeId();
		//判断巡检人员,如果巡检人员为空，则所有人都可以巡检，如果有指定巡检人员，必须是选择中的巡检人员才能进行巡检
		dao().fill(task)
				.with(InspectionTaskMeta.INSPECT_USER_LIST)
				.execute();
		//判断本人是否可以进行巡检操作
		List<Employee> userList=task.getInspectUserList();
		if(userList==null||userList.size()==0){
			System.out.println("可以运行");
		}else{
			String sql="select 1 from eam_inspection_task a,eam_inspection_group b,eam_inspection_group_user c where a.group_id=b.id and b.id=c.group_id and a.deleted=0 and a.id=? and c.user_id=?";
			if(dao.queryRecord(sql,taskId,curId)==null){
				return ErrorDesc.failureMessage("当前没有权限进行巡检操作");
			}
		}

		InspectionTaskPoint pointQuery=new InspectionTaskPoint();
		pointQuery.setTaskId(taskId);
		pointQuery.setPointCode(pointCode);
		List<InspectionTaskPoint> pointList= inspectionTaskPointService.queryList(pointQuery);
		if(pointList==null&&pointList.size()==0){
			return ErrorDesc.failureMessage("未在本次巡检任务中找到该巡检点");
		}

		if(pointList.size()>2){
			return ErrorDesc.failureMessage("本次巡检有重复的巡检点");
		}

		JSONObject obj=new JSONObject();
		obj.put("taskId",taskId);
		obj.put("pointStatus",pointList.get(0).getPointStatus());
		obj.put("pointCode",pointCode);
		obj.put("pointName",pointList.get(0).getPointName());
		obj.put("pointContent",pointList.get(0).getPointContent());
		obj.put("content",pointList.get(0).getContent());
		Result<JSONObject> result=new Result<>();
		result.success(true);
		result.data(obj);
		return result;
	}


	@Override
	public Result execute(String taskId, String pointCode, String status, String ct, String pics) {

		Result<JSONObject> checkResult=check(taskId,pointCode);
		if(!checkResult.isSuccess()){
			return checkResult;
		}
		String curId= SessionUser.getCurrent().getActivatedEmployeeId();


		InspectionTask task=this.getById(taskId);
		if(InspectionTaskStatusEnum.ACTING.code().equals(task.getTaskStatus())){
			System.out.println("可以进行巡检");
		}else if(InspectionTaskStatusEnum.WAIT.code().equals(task.getTaskStatus())){
			//更新巡检状态
			InspectionTask taskUps=new InspectionTask();
			taskUps.setTaskStatus(InspectionTaskStatusEnum.ACTING.code());
			taskUps.setId(taskId);
			taskUps.setActStartTime(new Date());
			this.update(taskUps,SaveMode.NOT_NULL_FIELDS,false);
		 }else{
			return ErrorDesc.failureMessage("当前巡检任务状态不能进行巡检操作");
		}

		InspectionTaskPoint pointQuery=new InspectionTaskPoint();
		pointQuery.setTaskId(taskId);
		pointQuery.setPointCode(pointCode);
		List<InspectionTaskPoint> pointList= inspectionTaskPointService.queryList(pointQuery);
		if(pointList==null&&pointList.size()==0){
			return ErrorDesc.failureMessage("未在本次巡检任务中找到该巡检点");
		}

		if(pointList.size()>2){
			return ErrorDesc.failureMessage("本次巡检有重复的巡检点");
		}

		String taskPointId=pointList.get(0).getId();
		InspectionTaskPoint point=new InspectionTaskPoint();
		point.setId(taskPointId);
		point.setTaskId(taskId);
		point.setPointCode(pointCode);
		point.setOperTime(new Date());
		point.setOperId(curId);
		point.setPointStatus(status);
		point.setContent(ct);
		inspectionTaskPointService.update(point,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}




	@Override
	public Result cancel(String id) {
		InspectionTask task=this.getById(id);
		if(InspectionTaskStatusEnum.CANCEL.code().equals(task.getTaskStatus())||
				InspectionTaskStatusEnum.FINISH.code().equals(task.getTaskStatus())
		){
			return ErrorDesc.failureMessage("当前保养任务状态异常，不能进行完成任务操作");
		}
		task.setTaskStatus(InspectionTaskStatusEnum.CANCEL.code());
		super.update(task,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}

	@Override
	public Result finish(String id) {

		InspectionTask inspectionTask=this.getById(id);
		this.dao().fill(inspectionTask)
				.with(InspectionTaskMeta.INSPECTION_TASK_POINT_LIST)
				.execute();
		List<InspectionTaskPoint> list=inspectionTask.getInspectionTaskPointList();

		if(list==null||list.size()==0){
			return ErrorDesc.failureMessage("当前没有巡检点需要巡检");
		}

		double sumDiffTime=0.0;
		Date minDate=null;
		Date maxDate=null;;

		for(int i=0;i<list.size();i++){
			InspectionTaskPoint inspectionTaskPoint=list.get(i);

			if(InspectionTaskPointStatusEnum.WAIT.code().equals(inspectionTaskPoint.getPointStatus())){
				return ErrorDesc.failureMessage("巡检点:"+inspectionTaskPoint.getPointName()+"未做巡检");
			}

			if(inspectionTaskPoint.getOperTime()==null){
				return ErrorDesc.failureMessage("巡检点:"+inspectionTaskPoint.getPointName()+"未做巡检");
			}else{
				if(minDate==null){
					minDate=inspectionTaskPoint.getOperTime();
				}
				if(maxDate==null){
					maxDate=inspectionTaskPoint.getOperTime();
				}
				if(inspectionTaskPoint.getOperTime().getTime()<minDate.getTime()){
					minDate=inspectionTaskPoint.getOperTime();
				}
				if(inspectionTaskPoint.getOperTime().getTime()>maxDate.getTime()){
					maxDate=inspectionTaskPoint.getOperTime();
				}
			}
		}
		inspectionTask.setActStartTime(minDate);
		inspectionTask.setActFinishTime(maxDate);
		inspectionTask.setTaskStatus(InspectionTaskStatusEnum.FINISH.code());
		inspectionTask.setExecutorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());

		long times = maxDate.getTime() - minDate.getTime();
		double hours = (double) times/(60*60*1000);
		BigDecimal a= BigDecimal.valueOf(hours);
		double diffTime = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		inspectionTask.setActTotalCost(new BigDecimal(diffTime));

		super.update(inspectionTask,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inspectionTask 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(InspectionTask inspectionTask) {
		return this.insert(inspectionTask,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inspectionTaskList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<InspectionTask> inspectionTaskList) {
		return super.insertList(inspectionTaskList);
	}

	
	/**
	 * 按主键删除 巡检任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		InspectionTask inspectionTask = new InspectionTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionTask.setId(id);
		try {
			boolean suc = dao.deleteEntity(inspectionTask);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 巡检任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		InspectionTask inspectionTask = new InspectionTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionTask.setId(id);
		inspectionTask.setDeleted(true);
		inspectionTask.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inspectionTask.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inspectionTask,SaveMode.NOT_NULL_FIELDS);
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
	 * @param inspectionTask 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionTask inspectionTask , SaveMode mode) {
		return this.update(inspectionTask,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inspectionTask 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionTask inspectionTask , SaveMode mode,boolean throwsException) {
		inspectionTask.setTaskStatus(InspectionTaskStatusEnum.ACTING.code());
		Result r=super.update(inspectionTask , mode , throwsException);
		return r;

	}

	/**
	 * 更新实体集，事务内
	 * @param inspectionTaskList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<InspectionTask> inspectionTaskList , SaveMode mode) {
		return super.updateList(inspectionTaskList , mode);
	}

	
	/**
	 * 按主键更新字段 巡检任务
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
	 * 按主键获取 巡检任务
	 *
	 * @param id 主键
	 * @return InspectionTask 数据对象
	 */
	public InspectionTask getById(String id) {
		InspectionTask sample = new InspectionTask();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<InspectionTask> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, InspectionTask> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, InspectionTask::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InspectionTask> queryList(InspectionTask sample) {
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
	public PagedList<InspectionTask> queryPagedList(InspectionTask sample, int pageSize, int pageIndex) {
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
	public PagedList<InspectionTask> queryPagedList(InspectionTask sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param inspectionTask 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(InspectionTask inspectionTask) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(inspectionTask, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(InspectionTask sample) {
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