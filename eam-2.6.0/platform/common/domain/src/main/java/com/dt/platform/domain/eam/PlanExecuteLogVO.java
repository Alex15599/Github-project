package com.dt.platform.domain.eam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.dt.platform.domain.eam.meta.PlanExecuteLogVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行日志VO类型
 * <p>执行日志 , 数据表 eam_plan_execute_log 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:35:39
 * @sign 558BFD8703C4D13FFD001044E331EDDE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "执行日志VO类型 ; 执行日志 , 数据表 eam_plan_execute_log 的通用VO类型" , parent = PlanExecuteLog.class)
public class PlanExecuteLogVO extends PlanExecuteLog {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PlanExecuteLogVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public PlanExecuteLogVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PlanExecuteLogVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PlanExecuteLogVO , 转换好的 PlanExecuteLogVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PlanExecuteLogVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PlanExecuteLogVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PlanExecuteLogVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PlanExecuteLogVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PlanExecuteLogVOMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setExecuted(this.getExecuted());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setErrors(this.getErrors());
		inst.setExecuteTime(this.getExecuteTime());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PlanExecuteLogVO clone(boolean deep) {
		return EntityContext.clone(PlanExecuteLogVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PlanExecuteLogVO
	 * @param planExecuteLogMap 包含实体信息的 Map 对象
	 * @return PlanExecuteLogVO , 转换好的的 PlanExecuteLog 对象
	*/
	@Transient
	public static PlanExecuteLogVO createFrom(Map<String,Object> planExecuteLogMap) {
		if(planExecuteLogMap==null) return null;
		PlanExecuteLogVO vo = create();
		EntityContext.copyProperties(vo,planExecuteLogMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PlanExecuteLogVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PlanExecuteLogVO , 转换好的的 PlanExecuteLog 对象
	*/
	@Transient
	public static PlanExecuteLogVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PlanExecuteLogVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PlanExecuteLogVO，等同于 new
	 * @return PlanExecuteLogVO 对象
	*/
	@Transient
	public static PlanExecuteLogVO create() {
		return new com.dt.platform.domain.eam.meta.PlanExecuteLogVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PlanExecuteLogVOMeta.UPDATE_TIME)));
			this.setExecuted(DataParser.parse(Integer.class, map.get(PlanExecuteLogVOMeta.EXECUTED)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PlanExecuteLogVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PlanExecuteLogVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PlanExecuteLogVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PlanExecuteLogVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.DELETE_BY)));
			this.setPlanId(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.ID)));
			this.setErrors(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.ERRORS)));
			this.setExecuteTime(DataParser.parse(Date.class, map.get(PlanExecuteLogVOMeta.EXECUTE_TIME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PlanExecuteLogVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PlanExecuteLogVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PlanExecuteLogVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(PlanExecuteLogVOMeta.UPDATE_TIME));
				this.setExecuted( (Integer)map.get(PlanExecuteLogVOMeta.EXECUTED));
				this.setVersion( (Integer)map.get(PlanExecuteLogVOMeta.VERSION));
				this.setCreateBy( (String)map.get(PlanExecuteLogVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PlanExecuteLogVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PlanExecuteLogVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PlanExecuteLogVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PlanExecuteLogVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(PlanExecuteLogVOMeta.DELETE_BY));
				this.setPlanId( (String)map.get(PlanExecuteLogVOMeta.PLAN_ID));
				this.setId( (String)map.get(PlanExecuteLogVOMeta.ID));
				this.setErrors( (String)map.get(PlanExecuteLogVOMeta.ERRORS));
				this.setExecuteTime( (Date)map.get(PlanExecuteLogVOMeta.EXECUTE_TIME));
				// others
				this.setSearchField( (String)map.get(PlanExecuteLogVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(PlanExecuteLogVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PlanExecuteLogVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(PlanExecuteLogVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PlanExecuteLogVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(PlanExecuteLogVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(PlanExecuteLogVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(PlanExecuteLogVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PlanExecuteLogVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(PlanExecuteLogVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogVOMeta.UPDATE_TIME)));
			this.setExecuted(DataParser.parse(Integer.class, r.getValue(PlanExecuteLogVOMeta.EXECUTED)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PlanExecuteLogVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PlanExecuteLogVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PlanExecuteLogVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PlanExecuteLogVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PlanExecuteLogVOMeta.DELETE_BY)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(PlanExecuteLogVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PlanExecuteLogVOMeta.ID)));
			this.setErrors(DataParser.parse(String.class, r.getValue(PlanExecuteLogVOMeta.ERRORS)));
			this.setExecuteTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogVOMeta.EXECUTE_TIME)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(PlanExecuteLogVOMeta.UPDATE_TIME));
				this.setExecuted( (Integer)r.getValue(PlanExecuteLogVOMeta.EXECUTED));
				this.setVersion( (Integer)r.getValue(PlanExecuteLogVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PlanExecuteLogVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PlanExecuteLogVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PlanExecuteLogVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PlanExecuteLogVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PlanExecuteLogVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(PlanExecuteLogVOMeta.DELETE_BY));
				this.setPlanId( (String)r.getValue(PlanExecuteLogVOMeta.PLAN_ID));
				this.setId( (String)r.getValue(PlanExecuteLogVOMeta.ID));
				this.setErrors( (String)r.getValue(PlanExecuteLogVOMeta.ERRORS));
				this.setExecuteTime( (Date)r.getValue(PlanExecuteLogVOMeta.EXECUTE_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}