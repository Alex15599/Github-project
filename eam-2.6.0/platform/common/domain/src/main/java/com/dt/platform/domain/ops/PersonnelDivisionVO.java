package com.dt.platform.domain.ops;

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
import com.dt.platform.domain.ops.meta.PersonnelDivisionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员分工VO类型
 * <p>人员分工 , 数据表 ops_personnel_division 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 20:39:58
 * @sign 3BA4182588DF8420B1233C8731F25291
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "人员分工VO类型 ; 人员分工 , 数据表 ops_personnel_division 的通用VO类型" , parent = PersonnelDivision.class)
public class PersonnelDivisionVO extends PersonnelDivision {

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
	public PersonnelDivisionVO setPageIndex(Integer pageIndex) {
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
	public PersonnelDivisionVO setPageSize(Integer pageSize) {
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
	public PersonnelDivisionVO setSearchField(String searchField) {
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
	public PersonnelDivisionVO setFuzzyField(String fuzzyField) {
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
	public PersonnelDivisionVO setSearchValue(String searchValue) {
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
	public PersonnelDivisionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PersonnelDivisionVO addDirtyField(String... dirtyField) {
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
	public PersonnelDivisionVO setSortField(String sortField) {
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
	public PersonnelDivisionVO setSortType(String sortType) {
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
	public PersonnelDivisionVO setDataOrigin(String dataOrigin) {
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
	public PersonnelDivisionVO setQueryLogic(String queryLogic) {
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
	public PersonnelDivisionVO setRequestAction(String requestAction) {
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
	public PersonnelDivisionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PersonnelDivisionVO addId(String... id) {
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
	 * @return PersonnelDivisionVO , 转换好的 PersonnelDivisionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonnelDivisionVO , 转换好的 PoJo 对象
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
	public PersonnelDivisionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonnelDivisionVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.PersonnelDivisionVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.PersonnelDivisionVOMeta.$$proxy$$();
		inst.setOwner(this.getOwner());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setJobContent(this.getJobContent());
		inst.setSort(this.getSort());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPos(this.getPos());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setResponsibleContent(this.getResponsibleContent());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setOwnerData(this.getOwnerData());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setUser(this.getUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonnelDivisionVO clone(boolean deep) {
		return EntityContext.clone(PersonnelDivisionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonnelDivisionVO
	 * @param personnelDivisionMap 包含实体信息的 Map 对象
	 * @return PersonnelDivisionVO , 转换好的的 PersonnelDivision 对象
	*/
	@Transient
	public static PersonnelDivisionVO createFrom(Map<String,Object> personnelDivisionMap) {
		if(personnelDivisionMap==null) return null;
		PersonnelDivisionVO vo = create();
		EntityContext.copyProperties(vo,personnelDivisionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PersonnelDivisionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonnelDivisionVO , 转换好的的 PersonnelDivision 对象
	*/
	@Transient
	public static PersonnelDivisionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonnelDivisionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PersonnelDivisionVO，等同于 new
	 * @return PersonnelDivisionVO 对象
	*/
	@Transient
	public static PersonnelDivisionVO create() {
		return new com.dt.platform.domain.ops.meta.PersonnelDivisionVOMeta.$$proxy$$();
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
			this.setOwner(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.OWNER)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonnelDivisionVOMeta.UPDATE_TIME)));
			this.setJobContent(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.JOB_CONTENT)));
			this.setSort(DataParser.parse(Integer.class, map.get(PersonnelDivisionVOMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonnelDivisionVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonnelDivisionVOMeta.DELETED)));
			this.setPos(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonnelDivisionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonnelDivisionVOMeta.DELETE_TIME)));
			this.setResponsibleContent(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PersonnelDivisionVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PersonnelDivisionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.SORT_TYPE)));
			this.setOwnerData(DataParser.parse(DictItem.class, map.get(PersonnelDivisionVOMeta.OWNER_DATA)));
			this.setSortField(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.QUERY_LOGIC)));
			this.setUser(DataParser.parse(Employee.class, map.get(PersonnelDivisionVOMeta.USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PersonnelDivisionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOwner( (String)map.get(PersonnelDivisionVOMeta.OWNER));
				this.setNotes( (String)map.get(PersonnelDivisionVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PersonnelDivisionVOMeta.UPDATE_TIME));
				this.setJobContent( (String)map.get(PersonnelDivisionVOMeta.JOB_CONTENT));
				this.setSort( (Integer)map.get(PersonnelDivisionVOMeta.SORT));
				this.setUserId( (String)map.get(PersonnelDivisionVOMeta.USER_ID));
				this.setVersion( (Integer)map.get(PersonnelDivisionVOMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonnelDivisionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonnelDivisionVOMeta.DELETED));
				this.setPos( (String)map.get(PersonnelDivisionVOMeta.POS));
				this.setCreateTime( (Date)map.get(PersonnelDivisionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonnelDivisionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonnelDivisionVOMeta.DELETE_TIME));
				this.setResponsibleContent( (String)map.get(PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT));
				this.setDeleteBy( (String)map.get(PersonnelDivisionVOMeta.DELETE_BY));
				this.setId( (String)map.get(PersonnelDivisionVOMeta.ID));
				this.setStatus( (String)map.get(PersonnelDivisionVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(PersonnelDivisionVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PersonnelDivisionVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PersonnelDivisionVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PersonnelDivisionVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(PersonnelDivisionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PersonnelDivisionVOMeta.SORT_TYPE));
				this.setOwnerData( (DictItem)map.get(PersonnelDivisionVOMeta.OWNER_DATA));
				this.setSortField( (String)map.get(PersonnelDivisionVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PersonnelDivisionVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PersonnelDivisionVOMeta.QUERY_LOGIC));
				this.setUser( (Employee)map.get(PersonnelDivisionVOMeta.USER));
				this.setSearchValue( (String)map.get(PersonnelDivisionVOMeta.SEARCH_VALUE));
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
			this.setOwner(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.OWNER)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonnelDivisionVOMeta.UPDATE_TIME)));
			this.setJobContent(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.JOB_CONTENT)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(PersonnelDivisionVOMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonnelDivisionVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonnelDivisionVOMeta.DELETED)));
			this.setPos(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonnelDivisionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonnelDivisionVOMeta.DELETE_TIME)));
			this.setResponsibleContent(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonnelDivisionVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwner( (String)r.getValue(PersonnelDivisionVOMeta.OWNER));
				this.setNotes( (String)r.getValue(PersonnelDivisionVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PersonnelDivisionVOMeta.UPDATE_TIME));
				this.setJobContent( (String)r.getValue(PersonnelDivisionVOMeta.JOB_CONTENT));
				this.setSort( (Integer)r.getValue(PersonnelDivisionVOMeta.SORT));
				this.setUserId( (String)r.getValue(PersonnelDivisionVOMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(PersonnelDivisionVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonnelDivisionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonnelDivisionVOMeta.DELETED));
				this.setPos( (String)r.getValue(PersonnelDivisionVOMeta.POS));
				this.setCreateTime( (Date)r.getValue(PersonnelDivisionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonnelDivisionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonnelDivisionVOMeta.DELETE_TIME));
				this.setResponsibleContent( (String)r.getValue(PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT));
				this.setDeleteBy( (String)r.getValue(PersonnelDivisionVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonnelDivisionVOMeta.ID));
				this.setStatus( (String)r.getValue(PersonnelDivisionVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}