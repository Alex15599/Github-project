package com.dt.platform.domain.knowledgebase;

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
import com.dt.platform.domain.knowledgebase.meta.ContentVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 知识库内容VO类型
 * <p>知识库内容 , 数据表 kn_content 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 18:39:15
 * @sign F08FBC51D56381143EFEB65C4A6A64BF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "知识库内容VO类型 ; 知识库内容 , 数据表 kn_content 的通用VO类型" , parent = Content.class)
public class ContentVO extends Content {

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
	public ContentVO setPageIndex(Integer pageIndex) {
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
	public ContentVO setPageSize(Integer pageSize) {
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
	public ContentVO setSearchField(String searchField) {
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
	public ContentVO setFuzzyField(String fuzzyField) {
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
	public ContentVO setSearchValue(String searchValue) {
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
	public ContentVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ContentVO addDirtyField(String... dirtyField) {
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
	public ContentVO setSortField(String sortField) {
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
	public ContentVO setSortType(String sortType) {
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
	public ContentVO setDataOrigin(String dataOrigin) {
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
	public ContentVO setQueryLogic(String queryLogic) {
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
	public ContentVO setRequestAction(String requestAction) {
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
	public ContentVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ContentVO addId(String... id) {
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
	 * @return ContentVO , 转换好的 ContentVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ContentVO , 转换好的 PoJo 对象
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
	public ContentVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ContentVO duplicate(boolean all) {
		com.dt.platform.domain.knowledgebase.meta.ContentVOMeta.$$proxy$$ inst = new com.dt.platform.domain.knowledgebase.meta.ContentVOMeta.$$proxy$$();
		inst.setKeyWords(this.getKeyWords());
		inst.setEditorId(this.getEditorId());
		inst.setGradeId(this.getGradeId());
		inst.setNotes(this.getNotes());
		inst.setProfile(this.getProfile());
		inst.setDisplay(this.getDisplay());
		inst.setLinkAddress(this.getLinkAddress());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setReviewCount(this.getReviewCount());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setContentType(this.getContentType());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setEditor(this.getEditor());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setCategory(this.getCategory());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ContentVO clone(boolean deep) {
		return EntityContext.clone(ContentVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ContentVO
	 * @param contentMap 包含实体信息的 Map 对象
	 * @return ContentVO , 转换好的的 Content 对象
	*/
	@Transient
	public static ContentVO createFrom(Map<String,Object> contentMap) {
		if(contentMap==null) return null;
		ContentVO vo = create();
		EntityContext.copyProperties(vo,contentMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ContentVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ContentVO , 转换好的的 Content 对象
	*/
	@Transient
	public static ContentVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ContentVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ContentVO，等同于 new
	 * @return ContentVO 对象
	*/
	@Transient
	public static ContentVO create() {
		return new com.dt.platform.domain.knowledgebase.meta.ContentVOMeta.$$proxy$$();
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
			this.setKeyWords(DataParser.parse(String.class, map.get(ContentVOMeta.KEY_WORDS)));
			this.setEditorId(DataParser.parse(String.class, map.get(ContentVOMeta.EDITOR_ID)));
			this.setGradeId(DataParser.parse(String.class, map.get(ContentVOMeta.GRADE_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(ContentVOMeta.NOTES)));
			this.setProfile(DataParser.parse(String.class, map.get(ContentVOMeta.PROFILE)));
			this.setDisplay(DataParser.parse(Integer.class, map.get(ContentVOMeta.DISPLAY)));
			this.setLinkAddress(DataParser.parse(String.class, map.get(ContentVOMeta.LINK_ADDRESS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ContentVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(ContentVOMeta.LABEL)));
			this.setTitle(DataParser.parse(String.class, map.get(ContentVOMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ContentVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(ContentVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ContentVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ContentVOMeta.DELETED)));
			this.setReviewCount(DataParser.parse(BigDecimal.class, map.get(ContentVOMeta.REVIEW_COUNT)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ContentVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ContentVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ContentVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ContentVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ContentVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ContentVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(ContentVOMeta.ATTACH)));
			this.setContentType(DataParser.parse(String.class, map.get(ContentVOMeta.CONTENT_TYPE)));
			this.setCategoryId(DataParser.parse(String.class, map.get(ContentVOMeta.CATEGORY_ID)));
			// others
			this.setEditor(DataParser.parse(Employee.class, map.get(ContentVOMeta.EDITOR)));
			this.setSearchField(DataParser.parse(String.class, map.get(ContentVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(ContentVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ContentVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ContentVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ContentVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ContentVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(ContentVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(ContentVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(ContentVOMeta.QUERY_LOGIC)));
			this.setCategory(DataParser.parse(Category.class, map.get(ContentVOMeta.CATEGORY)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ContentVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setKeyWords( (String)map.get(ContentVOMeta.KEY_WORDS));
				this.setEditorId( (String)map.get(ContentVOMeta.EDITOR_ID));
				this.setGradeId( (String)map.get(ContentVOMeta.GRADE_ID));
				this.setNotes( (String)map.get(ContentVOMeta.NOTES));
				this.setProfile( (String)map.get(ContentVOMeta.PROFILE));
				this.setDisplay( (Integer)map.get(ContentVOMeta.DISPLAY));
				this.setLinkAddress( (String)map.get(ContentVOMeta.LINK_ADDRESS));
				this.setUpdateTime( (Date)map.get(ContentVOMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(ContentVOMeta.LABEL));
				this.setTitle( (String)map.get(ContentVOMeta.TITLE));
				this.setVersion( (Integer)map.get(ContentVOMeta.VERSION));
				this.setContent( (String)map.get(ContentVOMeta.CONTENT));
				this.setCreateBy( (String)map.get(ContentVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ContentVOMeta.DELETED));
				this.setReviewCount( (BigDecimal)map.get(ContentVOMeta.REVIEW_COUNT));
				this.setCreateTime( (Date)map.get(ContentVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ContentVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ContentVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ContentVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ContentVOMeta.DELETE_BY));
				this.setId( (String)map.get(ContentVOMeta.ID));
				this.setAttach( (String)map.get(ContentVOMeta.ATTACH));
				this.setContentType( (String)map.get(ContentVOMeta.CONTENT_TYPE));
				this.setCategoryId( (String)map.get(ContentVOMeta.CATEGORY_ID));
				// others
				this.setEditor( (Employee)map.get(ContentVOMeta.EDITOR));
				this.setSearchField( (String)map.get(ContentVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(ContentVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(ContentVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(ContentVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(ContentVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ContentVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(ContentVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(ContentVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(ContentVOMeta.QUERY_LOGIC));
				this.setCategory( (Category)map.get(ContentVOMeta.CATEGORY));
				this.setSearchValue( (String)map.get(ContentVOMeta.SEARCH_VALUE));
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
			this.setKeyWords(DataParser.parse(String.class, r.getValue(ContentVOMeta.KEY_WORDS)));
			this.setEditorId(DataParser.parse(String.class, r.getValue(ContentVOMeta.EDITOR_ID)));
			this.setGradeId(DataParser.parse(String.class, r.getValue(ContentVOMeta.GRADE_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ContentVOMeta.NOTES)));
			this.setProfile(DataParser.parse(String.class, r.getValue(ContentVOMeta.PROFILE)));
			this.setDisplay(DataParser.parse(Integer.class, r.getValue(ContentVOMeta.DISPLAY)));
			this.setLinkAddress(DataParser.parse(String.class, r.getValue(ContentVOMeta.LINK_ADDRESS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ContentVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(ContentVOMeta.LABEL)));
			this.setTitle(DataParser.parse(String.class, r.getValue(ContentVOMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ContentVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(ContentVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ContentVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ContentVOMeta.DELETED)));
			this.setReviewCount(DataParser.parse(BigDecimal.class, r.getValue(ContentVOMeta.REVIEW_COUNT)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ContentVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ContentVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ContentVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ContentVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ContentVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ContentVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(ContentVOMeta.ATTACH)));
			this.setContentType(DataParser.parse(String.class, r.getValue(ContentVOMeta.CONTENT_TYPE)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(ContentVOMeta.CATEGORY_ID)));
			return true;
		} else {
			try {
				this.setKeyWords( (String)r.getValue(ContentVOMeta.KEY_WORDS));
				this.setEditorId( (String)r.getValue(ContentVOMeta.EDITOR_ID));
				this.setGradeId( (String)r.getValue(ContentVOMeta.GRADE_ID));
				this.setNotes( (String)r.getValue(ContentVOMeta.NOTES));
				this.setProfile( (String)r.getValue(ContentVOMeta.PROFILE));
				this.setDisplay( (Integer)r.getValue(ContentVOMeta.DISPLAY));
				this.setLinkAddress( (String)r.getValue(ContentVOMeta.LINK_ADDRESS));
				this.setUpdateTime( (Date)r.getValue(ContentVOMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(ContentVOMeta.LABEL));
				this.setTitle( (String)r.getValue(ContentVOMeta.TITLE));
				this.setVersion( (Integer)r.getValue(ContentVOMeta.VERSION));
				this.setContent( (String)r.getValue(ContentVOMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(ContentVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ContentVOMeta.DELETED));
				this.setReviewCount( (BigDecimal)r.getValue(ContentVOMeta.REVIEW_COUNT));
				this.setCreateTime( (Date)r.getValue(ContentVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ContentVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ContentVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ContentVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ContentVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(ContentVOMeta.ID));
				this.setAttach( (String)r.getValue(ContentVOMeta.ATTACH));
				this.setContentType( (String)r.getValue(ContentVOMeta.CONTENT_TYPE));
				this.setCategoryId( (String)r.getValue(ContentVOMeta.CATEGORY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}