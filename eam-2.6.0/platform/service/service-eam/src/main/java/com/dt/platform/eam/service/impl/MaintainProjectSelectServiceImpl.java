package com.dt.platform.eam.service.impl;


import com.dt.platform.domain.eam.MaintainProjectSelect;
import com.dt.platform.eam.service.IMaintainProjectSelectService;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-07 06:54:18
*/


@Service("EamMaintainProjectSelectService")
public class MaintainProjectSelectServiceImpl extends SuperService<MaintainProjectSelect> implements IMaintainProjectSelectService {

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
	 * @param maintainProjectSelect  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MaintainProjectSelect maintainProjectSelect,boolean throwsException) {
		Result r=super.insert(maintainProjectSelect,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param maintainProjectSelect 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MaintainProjectSelect maintainProjectSelect) {
		return this.insert(maintainProjectSelect,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param maintainProjectSelectList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MaintainProjectSelect> maintainProjectSelectList) {
		return super.insertList(maintainProjectSelectList);
	}

	
	/**
	 * 按主键删除 项目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MaintainProjectSelect maintainProjectSelect = new MaintainProjectSelect();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainProjectSelect.setId(id);
		try {
			boolean suc = dao.deleteEntity(maintainProjectSelect);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 项目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MaintainProjectSelect maintainProjectSelect = new MaintainProjectSelect();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainProjectSelect.setId(id);
		maintainProjectSelect.setDeleted(true);
		maintainProjectSelect.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		maintainProjectSelect.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(maintainProjectSelect,SaveMode.NOT_NULL_FIELDS);
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
	 * @param maintainProjectSelect 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainProjectSelect maintainProjectSelect , SaveMode mode) {
		return this.update(maintainProjectSelect,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param maintainProjectSelect 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainProjectSelect maintainProjectSelect , SaveMode mode,boolean throwsException) {
		Result r=super.update(maintainProjectSelect , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param maintainProjectSelectList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MaintainProjectSelect> maintainProjectSelectList , SaveMode mode) {
		return super.updateList(maintainProjectSelectList , mode);
	}

	
	/**
	 * 按主键更新字段 项目
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
	 * 按主键获取 项目
	 *
	 * @param id 主键
	 * @return MaintainProjectSelect 数据对象
	 */
	public MaintainProjectSelect getById(String id) {
		MaintainProjectSelect sample = new MaintainProjectSelect();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<MaintainProjectSelect> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MaintainProjectSelect> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MaintainProjectSelect::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MaintainProjectSelect> queryList(MaintainProjectSelect sample) {
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
	public PagedList<MaintainProjectSelect> queryPagedList(MaintainProjectSelect sample, int pageSize, int pageIndex) {
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
	public PagedList<MaintainProjectSelect> queryPagedList(MaintainProjectSelect sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param maintainProjectSelect 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MaintainProjectSelect maintainProjectSelect) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(maintainProjectSelect, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(MaintainProjectSelect sample) {
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