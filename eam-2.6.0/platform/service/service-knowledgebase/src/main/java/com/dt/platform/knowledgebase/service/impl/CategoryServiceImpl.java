package com.dt.platform.knowledgebase.service.impl;


import com.dt.platform.domain.knowledgebase.Category;
import com.dt.platform.knowledgebase.service.ICategoryService;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Update;
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
 * 知识分类 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-26 09:23:37
*/


@Service("KnCategoryService")
public class CategoryServiceImpl extends SuperService<Category> implements ICategoryService {
	
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
	 * 更新分类路径及名称
	 * @param id 主键
	 * @return 插入是否成功
	 * */
	@Override
	public Result updateHierarchy(String id) {
		Rcd category_rs = dao.queryRecord("select id,category_name categoryName,hierarchy from kn_category where deleted=0 and id=?", id);
		String hierarchy=category_rs.getString("hierarchy");
		String split="/";
		String afterHierarchyName="";
		String[] ids = hierarchy.split(split);
		for (int i = 0; i < ids.length;i++) {
			afterHierarchyName = afterHierarchyName + split+ dao.queryRecord("select category_name categoryName from kn_category where deleted=0 and id=?", ids[i]).getString("categoryName");
		}
		afterHierarchyName = afterHierarchyName.replaceFirst(split, "");
		Update ups = new Update("kn_category");
		ups.set("hierarchy_name", afterHierarchyName);
		ups.where().and("id=?", id);
		dao.execute(ups);
		RcdSet rds = dao.query("select id,category_name categoryName,hierarchy from kn_category where deleted=0 and parent_id=?", id);
		for (int j = 0; j < rds.size(); j++) {
			updateHierarchy(rds.getRcd(j).getString("id"));
		}
		Result r=new Result();
		r.success(true);
		r.message(CommonError.SUCCESS_TEXT);
		return r;
	}


	/**
	 * 插入实体
	 * @param category 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Category category) {
		Result r=super.insert(category);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param categoryList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Category> categoryList) {
		return super.insertList(categoryList);
	}
	
	
	/**
	 * 按主键删除 知识分类
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Category category = new Category();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		category.setId(id);
		try {
			boolean suc = dao.deleteEntity(category);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 知识分类
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Category category = new Category();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		category.setId(id);
		category.setDeleted(dao.getDBTreaty().getTrueValue());
		category.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		category.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(category,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 更新实体
	 * @param category 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Category category , SaveMode mode) {
		Result r=super.update(category , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param categoryList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Category> categoryList , SaveMode mode) {
		return super.updateList(categoryList , mode);
	}
	
	
	/**
	 * 按主键更新字段 知识分类
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
	 * 按主键获取 知识分类
	 *
	 * @param id 主键
	 * @return Category 数据对象
	 */
	public Category getById(String id) {
		Category sample = new Category();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Category> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Category> queryList(Category sample) {
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
	public PagedList<Category> queryPagedList(Category sample, int pageSize, int pageIndex) {
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
	public PagedList<Category> queryPagedList(Category sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param category 数据对象
	 * @return 判断结果
	 */
	public Result<Category> checkExists(Category category) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(category, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Category sample) {
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
