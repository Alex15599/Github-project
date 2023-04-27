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
import com.dt.platform.domain.eam.meta.FeedbackVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 反馈信息VO类型
 * <p>反馈信息 , 数据表 eam_feedback 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:50:48
 * @sign 99E654BE1D29DA37B0512DFA1A9C65F6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "反馈信息VO类型 ; 反馈信息 , 数据表 eam_feedback 的通用VO类型" , parent = Feedback.class)
public class FeedbackVO extends Feedback {

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
	public FeedbackVO setPageIndex(Integer pageIndex) {
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
	public FeedbackVO setPageSize(Integer pageSize) {
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
	public FeedbackVO setSearchField(String searchField) {
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
	public FeedbackVO setFuzzyField(String fuzzyField) {
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
	public FeedbackVO setSearchValue(String searchValue) {
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
	public FeedbackVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public FeedbackVO addDirtyField(String... dirtyField) {
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
	public FeedbackVO setSortField(String sortField) {
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
	public FeedbackVO setSortType(String sortType) {
		this.sortType=sortType;
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
	public FeedbackVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public FeedbackVO addId(String... id) {
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
	 * @return FeedbackVO , 转换好的 FeedbackVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FeedbackVO , 转换好的 PoJo 对象
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
	public FeedbackVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FeedbackVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.FeedbackVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.FeedbackVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
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
	public FeedbackVO clone(boolean deep) {
		return EntityContext.clone(FeedbackVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FeedbackVO
	 * @param feedbackMap 包含实体信息的 Map 对象
	 * @return FeedbackVO , 转换好的的 Feedback 对象
	*/
	@Transient
	public static FeedbackVO createFrom(Map<String,Object> feedbackMap) {
		if(feedbackMap==null) return null;
		FeedbackVO vo = create();
		EntityContext.copyProperties(vo,feedbackMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 FeedbackVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FeedbackVO , 转换好的的 Feedback 对象
	*/
	@Transient
	public static FeedbackVO createFrom(Object pojo) {
		if(pojo==null) return null;
		FeedbackVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 FeedbackVO，等同于 new
	 * @return FeedbackVO 对象
	*/
	@Transient
	public static FeedbackVO create() {
		return new com.dt.platform.domain.eam.meta.FeedbackVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(FeedbackVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FeedbackVOMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(FeedbackVOMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FeedbackVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(FeedbackVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FeedbackVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FeedbackVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FeedbackVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FeedbackVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FeedbackVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(FeedbackVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FeedbackVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FeedbackVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(FeedbackVOMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(FeedbackVOMeta.ORIGINATOR_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(FeedbackVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(FeedbackVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(FeedbackVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(FeedbackVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(FeedbackVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(FeedbackVOMeta.PAGE_SIZE)));
			this.setUser(DataParser.parse(Employee.class, map.get(FeedbackVOMeta.USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(FeedbackVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(FeedbackVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(FeedbackVOMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(FeedbackVOMeta.TITLE));
				this.setVersion( (Integer)map.get(FeedbackVOMeta.VERSION));
				this.setContent( (String)map.get(FeedbackVOMeta.CONTENT));
				this.setCreateBy( (String)map.get(FeedbackVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FeedbackVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(FeedbackVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FeedbackVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FeedbackVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(FeedbackVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(FeedbackVOMeta.DELETE_BY));
				this.setId( (String)map.get(FeedbackVOMeta.ID));
				this.setAttach( (String)map.get(FeedbackVOMeta.ATTACH));
				this.setOriginatorId( (String)map.get(FeedbackVOMeta.ORIGINATOR_ID));
				// others
				this.setSearchField( (String)map.get(FeedbackVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(FeedbackVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(FeedbackVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(FeedbackVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(FeedbackVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(FeedbackVOMeta.PAGE_SIZE));
				this.setUser( (Employee)map.get(FeedbackVOMeta.USER));
				this.setSearchValue( (String)map.get(FeedbackVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FeedbackVOMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FeedbackVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FeedbackVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FeedbackVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FeedbackVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(FeedbackVOMeta.ORIGINATOR_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(FeedbackVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(FeedbackVOMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(FeedbackVOMeta.TITLE));
				this.setVersion( (Integer)r.getValue(FeedbackVOMeta.VERSION));
				this.setContent( (String)r.getValue(FeedbackVOMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(FeedbackVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FeedbackVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FeedbackVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FeedbackVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FeedbackVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(FeedbackVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(FeedbackVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(FeedbackVOMeta.ID));
				this.setAttach( (String)r.getValue(FeedbackVOMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(FeedbackVOMeta.ORIGINATOR_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}