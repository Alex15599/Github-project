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
import com.dt.platform.domain.eam.meta.MaintainTaskProjectVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 保养项目VO类型
 * <p>保养项目 , 数据表 eam_maintain_task_project 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:42:51
 * @sign 405854482C050162614726994D692BB5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "保养项目VO类型 ; 保养项目 , 数据表 eam_maintain_task_project 的通用VO类型" , parent = MaintainTaskProject.class)
public class MaintainTaskProjectVO extends MaintainTaskProject {

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
	public MaintainTaskProjectVO setPageIndex(Integer pageIndex) {
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
	public MaintainTaskProjectVO setPageSize(Integer pageSize) {
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
	public MaintainTaskProjectVO setSearchField(String searchField) {
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
	public MaintainTaskProjectVO setFuzzyField(String fuzzyField) {
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
	public MaintainTaskProjectVO setSearchValue(String searchValue) {
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
	public MaintainTaskProjectVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MaintainTaskProjectVO addDirtyField(String... dirtyField) {
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
	public MaintainTaskProjectVO setSortField(String sortField) {
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
	public MaintainTaskProjectVO setSortType(String sortType) {
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
	public MaintainTaskProjectVO setDataOrigin(String dataOrigin) {
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
	public MaintainTaskProjectVO setQueryLogic(String queryLogic) {
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
	public MaintainTaskProjectVO setRequestAction(String requestAction) {
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
	public MaintainTaskProjectVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MaintainTaskProjectVO addId(String... id) {
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
	 * @return MaintainTaskProjectVO , 转换好的 MaintainTaskProjectVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainTaskProjectVO , 转换好的 PoJo 对象
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
	public MaintainTaskProjectVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaintainTaskProjectVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.MaintainTaskProjectVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.MaintainTaskProjectVOMeta.$$proxy$$();
		inst.setProjectAttachId(this.getProjectAttachId());
		inst.setBaseCost(this.getBaseCost());
		inst.setProjectNotes(this.getProjectNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setProjectBaseCost(this.getProjectBaseCost());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setProjectCode(this.getProjectCode());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setProjectMaintainType(this.getProjectMaintainType());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setEndTime(this.getEndTime());
		inst.setProjectName(this.getProjectName());
		inst.setProjectId(this.getProjectId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setMaintainTypeDict(this.getMaintainTypeDict());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
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
	public MaintainTaskProjectVO clone(boolean deep) {
		return EntityContext.clone(MaintainTaskProjectVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaintainTaskProjectVO
	 * @param maintainTaskProjectMap 包含实体信息的 Map 对象
	 * @return MaintainTaskProjectVO , 转换好的的 MaintainTaskProject 对象
	*/
	@Transient
	public static MaintainTaskProjectVO createFrom(Map<String,Object> maintainTaskProjectMap) {
		if(maintainTaskProjectMap==null) return null;
		MaintainTaskProjectVO vo = create();
		EntityContext.copyProperties(vo,maintainTaskProjectMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MaintainTaskProjectVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainTaskProjectVO , 转换好的的 MaintainTaskProject 对象
	*/
	@Transient
	public static MaintainTaskProjectVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainTaskProjectVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MaintainTaskProjectVO，等同于 new
	 * @return MaintainTaskProjectVO 对象
	*/
	@Transient
	public static MaintainTaskProjectVO create() {
		return new com.dt.platform.domain.eam.meta.MaintainTaskProjectVOMeta.$$proxy$$();
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
			this.setProjectAttachId(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID)));
			this.setBaseCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskProjectVOMeta.BASE_COST)));
			this.setProjectNotes(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.PROJECT_NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaintainTaskProjectVOMeta.UPDATE_TIME)));
			this.setProjectBaseCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskProjectVOMeta.PROJECT_BASE_COST)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaintainTaskProjectVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaintainTaskProjectVOMeta.DELETED)));
			this.setProjectCode(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.PROJECT_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaintainTaskProjectVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaintainTaskProjectVOMeta.DELETE_TIME)));
			this.setProjectMaintainType(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(MaintainTaskProjectVOMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.ID)));
			this.setEndTime(DataParser.parse(Date.class, map.get(MaintainTaskProjectVOMeta.END_TIME)));
			this.setProjectName(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.PROJECT_NAME)));
			this.setProjectId(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.PROJECT_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MaintainTaskProjectVOMeta.PAGE_SIZE)));
			this.setMaintainTypeDict(DataParser.parse(DictItem.class, map.get(MaintainTaskProjectVOMeta.MAINTAIN_TYPE_DICT)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MaintainTaskProjectVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MaintainTaskProjectVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProjectAttachId( (String)map.get(MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID));
				this.setBaseCost( (BigDecimal)map.get(MaintainTaskProjectVOMeta.BASE_COST));
				this.setProjectNotes( (String)map.get(MaintainTaskProjectVOMeta.PROJECT_NOTES));
				this.setUpdateTime( (Date)map.get(MaintainTaskProjectVOMeta.UPDATE_TIME));
				this.setProjectBaseCost( (BigDecimal)map.get(MaintainTaskProjectVOMeta.PROJECT_BASE_COST));
				this.setSelectedCode( (String)map.get(MaintainTaskProjectVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(MaintainTaskProjectVOMeta.VERSION));
				this.setContent( (String)map.get(MaintainTaskProjectVOMeta.CONTENT));
				this.setCreateBy( (String)map.get(MaintainTaskProjectVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaintainTaskProjectVOMeta.DELETED));
				this.setProjectCode( (String)map.get(MaintainTaskProjectVOMeta.PROJECT_CODE));
				this.setCreateTime( (Date)map.get(MaintainTaskProjectVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MaintainTaskProjectVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MaintainTaskProjectVOMeta.DELETE_TIME));
				this.setProjectMaintainType( (String)map.get(MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE));
				this.setTenantId( (String)map.get(MaintainTaskProjectVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MaintainTaskProjectVOMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(MaintainTaskProjectVOMeta.START_TIME));
				this.setId( (String)map.get(MaintainTaskProjectVOMeta.ID));
				this.setEndTime( (Date)map.get(MaintainTaskProjectVOMeta.END_TIME));
				this.setProjectName( (String)map.get(MaintainTaskProjectVOMeta.PROJECT_NAME));
				this.setProjectId( (String)map.get(MaintainTaskProjectVOMeta.PROJECT_ID));
				this.setTaskId( (String)map.get(MaintainTaskProjectVOMeta.TASK_ID));
				this.setStatus( (String)map.get(MaintainTaskProjectVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(MaintainTaskProjectVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MaintainTaskProjectVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MaintainTaskProjectVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(MaintainTaskProjectVOMeta.PAGE_SIZE));
				this.setMaintainTypeDict( (DictItem)map.get(MaintainTaskProjectVOMeta.MAINTAIN_TYPE_DICT));
				this.setPageIndex( (Integer)map.get(MaintainTaskProjectVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MaintainTaskProjectVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(MaintainTaskProjectVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(MaintainTaskProjectVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MaintainTaskProjectVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(MaintainTaskProjectVOMeta.SEARCH_VALUE));
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
			this.setProjectAttachId(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID)));
			this.setBaseCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskProjectVOMeta.BASE_COST)));
			this.setProjectNotes(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaintainTaskProjectVOMeta.UPDATE_TIME)));
			this.setProjectBaseCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_BASE_COST)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaintainTaskProjectVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaintainTaskProjectVOMeta.DELETED)));
			this.setProjectCode(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaintainTaskProjectVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaintainTaskProjectVOMeta.DELETE_TIME)));
			this.setProjectMaintainType(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(MaintainTaskProjectVOMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.ID)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(MaintainTaskProjectVOMeta.END_TIME)));
			this.setProjectName(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_NAME)));
			this.setProjectId(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.PROJECT_ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MaintainTaskProjectVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProjectAttachId( (String)r.getValue(MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID));
				this.setBaseCost( (BigDecimal)r.getValue(MaintainTaskProjectVOMeta.BASE_COST));
				this.setProjectNotes( (String)r.getValue(MaintainTaskProjectVOMeta.PROJECT_NOTES));
				this.setUpdateTime( (Date)r.getValue(MaintainTaskProjectVOMeta.UPDATE_TIME));
				this.setProjectBaseCost( (BigDecimal)r.getValue(MaintainTaskProjectVOMeta.PROJECT_BASE_COST));
				this.setSelectedCode( (String)r.getValue(MaintainTaskProjectVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(MaintainTaskProjectVOMeta.VERSION));
				this.setContent( (String)r.getValue(MaintainTaskProjectVOMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(MaintainTaskProjectVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaintainTaskProjectVOMeta.DELETED));
				this.setProjectCode( (String)r.getValue(MaintainTaskProjectVOMeta.PROJECT_CODE));
				this.setCreateTime( (Date)r.getValue(MaintainTaskProjectVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MaintainTaskProjectVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MaintainTaskProjectVOMeta.DELETE_TIME));
				this.setProjectMaintainType( (String)r.getValue(MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE));
				this.setTenantId( (String)r.getValue(MaintainTaskProjectVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MaintainTaskProjectVOMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(MaintainTaskProjectVOMeta.START_TIME));
				this.setId( (String)r.getValue(MaintainTaskProjectVOMeta.ID));
				this.setEndTime( (Date)r.getValue(MaintainTaskProjectVOMeta.END_TIME));
				this.setProjectName( (String)r.getValue(MaintainTaskProjectVOMeta.PROJECT_NAME));
				this.setProjectId( (String)r.getValue(MaintainTaskProjectVOMeta.PROJECT_ID));
				this.setTaskId( (String)r.getValue(MaintainTaskProjectVOMeta.TASK_ID));
				this.setStatus( (String)r.getValue(MaintainTaskProjectVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}