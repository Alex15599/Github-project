package com.dt.platform.eam.service.impl;


import com.dt.platform.domain.eam.GroupUser;
import com.dt.platform.domain.eam.MaintainGroup;
import com.dt.platform.eam.service.IGroupUserService;
import com.dt.platform.eam.service.IInspectionGroupUserService;
import com.dt.platform.eam.service.IMaintainGroupService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 保养班组 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 19:14:18
*/


@Service("EamMaintainGroupService")
public class MaintainGroupServiceImpl extends SuperService<MaintainGroup> implements IMaintainGroupService {

	@Autowired
	private IGroupUserService groupUserService;

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
	private IInspectionGroupUserService inspectionGroupUserService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param maintainGroup  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MaintainGroup maintainGroup,boolean throwsException) {


		Result r=super.insert(maintainGroup,throwsException);
		if(r.isSuccess()){
			if(maintainGroup.getMemberIds()!=null&&maintainGroup.getMemberIds().size()>0){
				List<GroupUser> list=new ArrayList<>();
				for(String id:maintainGroup.getMemberIds()){
					GroupUser user=new GroupUser();
					user.setUserId(id);
					user.setGroupId(maintainGroup.getId());
					list.add(user);
				}
				groupUserService.insertList(list);
			}
		}
		return r;

	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param maintainGroup 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MaintainGroup maintainGroup) {
		return this.insert(maintainGroup,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param maintainGroupList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MaintainGroup> maintainGroupList) {
		return super.insertList(maintainGroupList);
	}

	
	/**
	 * 按主键删除 保养班组
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MaintainGroup maintainGroup = new MaintainGroup();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainGroup.setId(id);
		try {
			boolean suc = dao.deleteEntity(maintainGroup);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 保养班组
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MaintainGroup maintainGroup = new MaintainGroup();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainGroup.setId(id);
		maintainGroup.setDeleted(true);
		maintainGroup.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		maintainGroup.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(maintainGroup,SaveMode.NOT_NULL_FIELDS);
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
	 * @param maintainGroup 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainGroup maintainGroup , SaveMode mode) {
		return this.update(maintainGroup,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param maintainGroup 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainGroup maintainGroup , SaveMode mode,boolean throwsException) {
		Result r=super.update(maintainGroup , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from eam_inspection_group_user where group_id=?",maintainGroup.getId());
			if(maintainGroup.getMemberIds()!=null&&maintainGroup.getMemberIds().size()>0){
				List<GroupUser> list=new ArrayList<>();
				for(String id:maintainGroup.getMemberIds()){
					GroupUser user=new GroupUser();
					user.setUserId(id);
					user.setGroupId(maintainGroup.getId());
					list.add(user);
				}
				groupUserService.insertList(list);
			}
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param maintainGroupList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MaintainGroup> maintainGroupList , SaveMode mode) {
		return super.updateList(maintainGroupList , mode);
	}

	
	/**
	 * 按主键更新字段 保养班组
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
	 * 按主键获取 保养班组
	 *
	 * @param id 主键
	 * @return MaintainGroup 数据对象
	 */
	public MaintainGroup getById(String id) {
		MaintainGroup sample = new MaintainGroup();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<MaintainGroup> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MaintainGroup> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MaintainGroup::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MaintainGroup> queryList(MaintainGroup sample) {
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
	public PagedList<MaintainGroup> queryPagedList(MaintainGroup sample, int pageSize, int pageIndex) {
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
	public PagedList<MaintainGroup> queryPagedList(MaintainGroup sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param maintainGroup 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MaintainGroup maintainGroup) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(maintainGroup, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(MaintainGroup sample) {
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