package com.dt.platform.vehicle.service.impl;


import com.dt.platform.constants.enums.vehicle.VehicleHandleStatusEnum;
import com.dt.platform.constants.enums.vehicle.VehicleOperationEnum;
import com.dt.platform.constants.enums.vehicle.VehicleRepairStatusEnum;
import com.dt.platform.domain.vehicle.Maintenance;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.vehicle.service.IMaintenanceService;
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
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆维修保养 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:58:38
*/


@Service("VehicleMaintenanceService")
public class MaintenanceServiceImpl extends SuperService<Maintenance> implements IMaintenanceService {

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
	private MSelectItemServiceImpl mSelectItemServiceImpl;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Override
	public Result confirm(String id) {
		Maintenance data=this.getById(id);
		if(VehicleRepairStatusEnum.WAIT_REPAIR.code().equals(data.getRepairStatus())){
			data.setRepairStatus(VehicleRepairStatusEnum.REPAIRING.code());
			return super.update(data,SaveMode.NOT_NULL_FIELDS,true);
		}else{
			return ErrorDesc.failureMessage("当前状态不能进行该操作");
		}
	}

	@Override
	public Result cancel(String id) {
		Maintenance data=this.getById(id);
		if(VehicleRepairStatusEnum.REPAIRING.code().equals(data.getRepairStatus())){
			data.setRepairStatus(VehicleRepairStatusEnum.CANCEL.code());
			return super.update(data,SaveMode.NOT_NULL_FIELDS,true);
		}else{
			return ErrorDesc.failureMessage("当前状态不能进行该操作");
		}
	}

	@Override
	public Result finish(String id) {
		Maintenance data=this.getById(id);
		if(VehicleRepairStatusEnum.REPAIRING.code().equals(data.getRepairStatus())){
			data.setRepairStatus(VehicleRepairStatusEnum.FINISH.code());
			return super.update(data,SaveMode.NOT_NULL_FIELDS,true);
		}else{
			return ErrorDesc.failureMessage("当前状态不能进行该操作");
		}
	}




	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param maintenance  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	@Transactional
	public Result insert(Maintenance maintenance,boolean throwsException) {

		//校验数据资产
//		if(maintenance.getVehicleInfoIds().size()==0){
//			return ErrorDesc.failure().message("请选择车辆");
//		}

		//制单人
		if(StringUtil.isBlank(maintenance.getOriginatorId())){
			maintenance.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理状态
		if(StringUtil.isBlank(maintenance.getStatus())){
			maintenance.setStatus(VehicleHandleStatusEnum.INCOMPLETE.code());
		}

		//维修状态
		if(StringUtil.isBlank(maintenance.getRepairStatus())){
			maintenance.setRepairStatus(VehicleRepairStatusEnum.WAIT_REPAIR.code());
		}


		//生成编码规则
		if(StringUtil.isBlank(maintenance.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(VehicleOperationEnum.VEHICLE_MAINTENANCE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				maintenance.setBusinessCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(maintenance,throwsException);
		//保存关系

		if(r.success()) {
			mSelectItemServiceImpl.saveRelation(maintenance.getId(), maintenance.getVehicleInfoIds());
		}
		return r;
	}


	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param maintenance 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(Maintenance maintenance) {
		return this.insert(maintenance,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param maintenanceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Maintenance> maintenanceList) {
		return super.insertList(maintenanceList);
	}

	
	/**
	 * 按主键删除 车辆维修保养
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Maintenance maintenance = new Maintenance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintenance.setId(id);
		try {
			boolean suc = dao.deleteEntity(maintenance);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 车辆维修保养
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Maintenance maintenance = new Maintenance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintenance.setId(id);
		maintenance.setDeleted(dao.getDBTreaty().getTrueValue());
		maintenance.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		maintenance.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(maintenance,SaveMode.NOT_NULL_FIELDS);
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
	 * @param maintenance 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Maintenance maintenance , SaveMode mode) {
		return this.update(maintenance,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param maintenance 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Maintenance maintenance , SaveMode mode,boolean throwsException) {
		Result r=super.update(maintenance , mode , throwsException);
		//保存关系
		if(r.success()) {
			mSelectItemServiceImpl.saveRelation(maintenance.getId(), maintenance.getVehicleInfoIds());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param maintenanceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Maintenance> maintenanceList , SaveMode mode) {
		return super.updateList(maintenanceList , mode);
	}

	
	/**
	 * 按主键更新字段 车辆维修保养
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
	 * 按主键获取 车辆维修保养
	 *
	 * @param id 主键
	 * @return Maintenance 数据对象
	 */
	public Maintenance getById(String id) {
		Maintenance sample = new Maintenance();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Maintenance> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Maintenance> queryList(Maintenance sample) {
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
	public PagedList<Maintenance> queryPagedList(Maintenance sample, int pageSize, int pageIndex) {
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
	public PagedList<Maintenance> queryPagedList(Maintenance sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param maintenance 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Maintenance maintenance) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(maintenance, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(Maintenance sample) {
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
