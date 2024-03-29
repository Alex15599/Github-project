package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.CCustRepairStatusEnum;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.CCustRepiarItem;
import com.dt.platform.eam.service.IAssetItemService;
import com.dt.platform.eam.service.ICCustRepiarItemService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.eam.CCustRepairApply;
import com.dt.platform.domain.eam.CCustRepairApplyVO;
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
import com.dt.platform.eam.service.ICCustRepairApplyService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 报修申请服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 13:45:49
*/


@Service("EamCCustRepairApplyService")

public class CCustRepairApplyServiceImpl extends SuperService<CCustRepairApply> implements ICCustRepairApplyService {

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
	private ICCustRepiarItemService cCustRepiarItemService;

	@Autowired
	private IAssetItemService assetItemService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param cCustRepairApply  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CCustRepairApply cCustRepairApply,boolean throwsException) {
		cCustRepairApply.setStatus(CCustRepairStatusEnum.WAIT.code());
		cCustRepairApply.setStartDate(new Date());
		if(StringUtil.isBlank(cCustRepairApply.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_SOFTWARE_INSERT.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				cCustRepairApply.setBusinessCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(cCustRepairApply,throwsException);
		if (r.isSuccess()){
			List<String> ids=cCustRepairApply.getAssetIds();
			if(ids!=null){
				for(int i=0;i<ids.size();i++){
					AssetItem item=new AssetItem();
					item.setAssetId(ids.get(i));
					item.setHandleId(cCustRepairApply.getId());
					assetItemService.insert(item);
				}
			}
		}
		return r;
	}


	private boolean isInCustRepairRole(){
		String sql="select * from sys_busi_role_member a,sys_busi_role b where a.role_id=b.id and b.deleted=0 and a.member_type='employee' and b.code='eam_cust_repair' and a.member_id=?";
		String userId= SessionUser.getCurrent().getActivatedEmployeeId();
		if(dao.query(sql,userId).size()>0){
			return true;
		}
		return false;
	}


	//
	@Override
	public Result cancel(String id) {
		return null;
	}

	@Override
	public Result receive(String id) {
		String userId=SessionUser.getCurrent().getActivatedEmployeeId();
		if(!isInCustRepairRole()){
			return ErrorDesc.failureMessage("当前没有处理的权限,请先将处理人员加入到eam_cust_repair的业务角色中");
		}

		CCustRepairApply apply=this.getById(id);
		if(!CCustRepairStatusEnum.WAIT.code().equals(apply.getStatus())){
			return ErrorDesc.failureMessage("当前状态，不能进行接单操作");
		}

		apply.setStatus(CCustRepairStatusEnum.PROCESSING.code());
		Result r=this.update(apply,SaveMode.NOT_NULL_FIELDS);
		if(r.isSuccess()){
			CCustRepiarItem item=new CCustRepiarItem();
			item.setRepairId(id);
			item.setCt("开始处理");
			item.setProcessUserId(userId);
			item.setRecordTime(new Date());
			cCustRepiarItemService.insert(item);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result answer(CCustRepiarItem data) {
		String userId= SessionUser.getCurrent().getActivatedEmployeeId();
		if(!isInCustRepairRole()){
			return ErrorDesc.failureMessage("当前没有处理的权限,请先将处理人员加入到eam_cust_repair的业务角色中");
		}
		String repairId=data.getRepairId();
		CCustRepairApply apply=this.getById(repairId);
		if(!CCustRepairStatusEnum.PROCESSING.code().equals(apply.getStatus())){
			return ErrorDesc.failureMessage("当前状态，不能进行该操作");
		}
		data.setProcessUserId(userId);
		data.setRecordTime(new Date());
		cCustRepiarItemService.insert(data);
		return ErrorDesc.success();
	}


	@Override
	public Result finish(String id,String ct) {
		String userId=SessionUser.getCurrent().getActivatedEmployeeId();
		if(!isInCustRepairRole()){
			return ErrorDesc.failureMessage("当前没有处理的权限,请先将处理人员加入到eam_cust_repair的业务角色中");
		}

		CCustRepairApply apply=this.getById(id);
		if(!CCustRepairStatusEnum.PROCESSING.code().equals(apply.getStatus())){
			return ErrorDesc.failureMessage("当前状态，不能进行该操作");
		}
		apply.setFinishDate(new Date());
		apply.setStatus(CCustRepairStatusEnum.FINISH.code());
		if(!StringUtil.isBlank(ct)){
			apply.setResult(ct);
		}
		Result r=this.update(apply,SaveMode.NOT_NULL_FIELDS);
		if(r.isSuccess()){
			CCustRepiarItem item=new CCustRepiarItem();
			item.setRepairId(id);
			item.setCt("完成本次处理");
			item.setProcessUserId(userId);
			item.setRecordTime(new Date());
			cCustRepiarItemService.insert(item);
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param cCustRepairApply 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CCustRepairApply cCustRepairApply) {
		return this.insert(cCustRepairApply,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param cCustRepairApplyList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CCustRepairApply> cCustRepairApplyList) {
		return super.insertList(cCustRepairApplyList);
	}

	
	/**
	 * 按主键删除报修申请
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CCustRepairApply cCustRepairApply = new CCustRepairApply();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		cCustRepairApply.setId(id);
		try {
			boolean suc = dao.deleteEntity(cCustRepairApply);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除报修申请
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CCustRepairApply cCustRepairApply = new CCustRepairApply();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		cCustRepairApply.setId(id);
		cCustRepairApply.setDeleted(true);
		cCustRepairApply.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		cCustRepairApply.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(cCustRepairApply,SaveMode.NOT_NULL_FIELDS);
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
	 * @param cCustRepairApply 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CCustRepairApply cCustRepairApply , SaveMode mode) {
		return this.update(cCustRepairApply,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param cCustRepairApply 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CCustRepairApply cCustRepairApply , SaveMode mode,boolean throwsException) {
		Result r=super.update(cCustRepairApply , mode , throwsException);
		this.dao.execute("delete from eam_asset_item where handle_id=?",cCustRepairApply.getId());
		if (r.isSuccess()){
			List<String> ids=cCustRepairApply.getAssetIds();
			if(ids!=null){
				for(int i=0;i<ids.size();i++){
					AssetItem item=new AssetItem();
					item.setAssetId(ids.get(i));
					item.setHandleId(cCustRepairApply.getId());
					assetItemService.insert(item);
				}
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param cCustRepairApplyList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CCustRepairApply> cCustRepairApplyList , SaveMode mode) {
		return super.updateList(cCustRepairApplyList , mode);
	}

	
	/**
	 * 按主键更新报修申请
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
	 * 按主键获取报修申请
	 *
	 * @param id 主键
	 * @return CCustRepairApply 数据对象
	 */
	public CCustRepairApply getById(String id) {
		CCustRepairApply sample = new CCustRepairApply();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<CCustRepairApply> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<CCustRepairApply> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CCustRepairApply> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CCustRepairApply::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CCustRepairApply> queryList(CCustRepairApplyVO sample) {
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
	public PagedList<CCustRepairApply> queryPagedList(CCustRepairApplyVO sample, int pageSize, int pageIndex) {
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
	public PagedList<CCustRepairApply> queryPagedList(CCustRepairApply sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param cCustRepairApply 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CCustRepairApply cCustRepairApply) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(cCustRepairApply, SYS_ROLE.NAME);
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