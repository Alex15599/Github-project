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
import com.dt.platform.domain.eam.meta.InspectionTaskVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检任务VO类型
 * <p>巡检任务 , 数据表 eam_inspection_task 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:30:19
 * @sign FC0E307EB7CDFD362C699424737E2FFB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "巡检任务VO类型 ; 巡检任务 , 数据表 eam_inspection_task 的通用VO类型" , parent = InspectionTask.class)
public class InspectionTaskVO extends InspectionTask {

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
	public InspectionTaskVO setPageIndex(Integer pageIndex) {
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
	public InspectionTaskVO setPageSize(Integer pageSize) {
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
	public InspectionTaskVO setSearchField(String searchField) {
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
	public InspectionTaskVO setFuzzyField(String fuzzyField) {
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
	public InspectionTaskVO setSearchValue(String searchValue) {
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
	public InspectionTaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InspectionTaskVO addDirtyField(String... dirtyField) {
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
	public InspectionTaskVO setSortField(String sortField) {
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
	public InspectionTaskVO setSortType(String sortType) {
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
	public InspectionTaskVO setDataOrigin(String dataOrigin) {
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
	public InspectionTaskVO setQueryLogic(String queryLogic) {
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
	public InspectionTaskVO setRequestAction(String requestAction) {
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
	public InspectionTaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InspectionTaskVO addId(String... id) {
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
	 * @return InspectionTaskVO , 转换好的 InspectionTaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTaskVO , 转换好的 PoJo 对象
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
	public InspectionTaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionTaskVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionTaskVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionTaskVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setPlanName(this.getPlanName());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setActStartTime(this.getActStartTime());
		inst.setTaskCode(this.getTaskCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setPlanInspectionMethod(this.getPlanInspectionMethod());
		inst.setActFinishTime(this.getActFinishTime());
		inst.setTaskStatus(this.getTaskStatus());
		inst.setPlanStartTime(this.getPlanStartTime());
		inst.setExecutorId(this.getExecutorId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setPlanCode(this.getPlanCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActTotalCost(this.getActTotalCost());
		inst.setPlanNotes(this.getPlanNotes());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanCompletionTime(this.getPlanCompletionTime());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setTimeDict(this.getTimeDict());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setInspectionTaskPointList(this.getInspectionTaskPointList());
			inst.setPageSize(this.getPageSize());
			inst.setInspectionTaskPointIds(this.getInspectionTaskPointIds());
			inst.setInspectUserList(this.getInspectUserList());
			inst.setOriginator(this.getOriginator());
			inst.setInspectionPointIds(this.getInspectionPointIds());
			inst.setInspectionGroup(this.getInspectionGroup());
			inst.setInspectionPointList(this.getInspectionPointList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setExecutor(this.getExecutor());
			inst.setInspectionTypeDict(this.getInspectionTypeDict());
			inst.setInspectionPlan(this.getInspectionPlan());
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
	public InspectionTaskVO clone(boolean deep) {
		return EntityContext.clone(InspectionTaskVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionTaskVO
	 * @param inspectionTaskMap 包含实体信息的 Map 对象
	 * @return InspectionTaskVO , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTaskVO createFrom(Map<String,Object> inspectionTaskMap) {
		if(inspectionTaskMap==null) return null;
		InspectionTaskVO vo = create();
		EntityContext.copyProperties(vo,inspectionTaskMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InspectionTaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTaskVO , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTaskVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InspectionTaskVO，等同于 new
	 * @return InspectionTaskVO 对象
	*/
	@Transient
	public static InspectionTaskVO create() {
		return new com.dt.platform.domain.eam.meta.InspectionTaskVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.GROUP_ID)));
			this.setPlanName(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.PLAN_NAME)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.CONTENT)));
			this.setActStartTime(DataParser.parse(Date.class, map.get(InspectionTaskVOMeta.ACT_START_TIME)));
			this.setTaskCode(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.TASK_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.UPDATE_BY)));
			this.setPlanId(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.ORIGINATOR_ID)));
			this.setPlanInspectionMethod(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.PLAN_INSPECTION_METHOD)));
			this.setActFinishTime(DataParser.parse(Date.class, map.get(InspectionTaskVOMeta.ACT_FINISH_TIME)));
			this.setTaskStatus(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.TASK_STATUS)));
			this.setPlanStartTime(DataParser.parse(Date.class, map.get(InspectionTaskVOMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.EXECUTOR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionTaskVOMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionTaskVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionTaskVOMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, map.get(InspectionTaskVOMeta.ACT_TOTAL_COST)));
			this.setPlanNotes(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.PLAN_NOTES)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.DELETE_BY)));
			this.setPlanCompletionTime(DataParser.parse(BigDecimal.class, map.get(InspectionTaskVOMeta.PLAN_COMPLETION_TIME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.SEARCH_FIELD)));
			this.setTimeDict(DataParser.parse(DictItem.class, map.get(InspectionTaskVOMeta.TIME_DICT)));
			this.setRequestAction(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InspectionTaskVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(InspectionTaskVOMeta.ORIGINATOR)));
			this.setInspectionGroup(DataParser.parse(InspectionGroup.class, map.get(InspectionTaskVOMeta.INSPECTION_GROUP)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InspectionTaskVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.SORT_TYPE)));
			this.setExecutor(DataParser.parse(Employee.class, map.get(InspectionTaskVOMeta.EXECUTOR)));
			this.setInspectionTypeDict(DataParser.parse(DictItem.class, map.get(InspectionTaskVOMeta.INSPECTION_TYPE_DICT)));
			this.setInspectionPlan(DataParser.parse(InspectionPlan.class, map.get(InspectionTaskVOMeta.INSPECTION_PLAN)));
			this.setSortField(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InspectionTaskVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InspectionTaskVOMeta.NOTES));
				this.setGroupId( (String)map.get(InspectionTaskVOMeta.GROUP_ID));
				this.setPlanName( (String)map.get(InspectionTaskVOMeta.PLAN_NAME));
				this.setSelectedCode( (String)map.get(InspectionTaskVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(InspectionTaskVOMeta.CONTENT));
				this.setActStartTime( (Date)map.get(InspectionTaskVOMeta.ACT_START_TIME));
				this.setTaskCode( (String)map.get(InspectionTaskVOMeta.TASK_CODE));
				this.setUpdateBy( (String)map.get(InspectionTaskVOMeta.UPDATE_BY));
				this.setPlanId( (String)map.get(InspectionTaskVOMeta.PLAN_ID));
				this.setId( (String)map.get(InspectionTaskVOMeta.ID));
				this.setOriginatorId( (String)map.get(InspectionTaskVOMeta.ORIGINATOR_ID));
				this.setPlanInspectionMethod( (String)map.get(InspectionTaskVOMeta.PLAN_INSPECTION_METHOD));
				this.setActFinishTime( (Date)map.get(InspectionTaskVOMeta.ACT_FINISH_TIME));
				this.setTaskStatus( (String)map.get(InspectionTaskVOMeta.TASK_STATUS));
				this.setPlanStartTime( (Date)map.get(InspectionTaskVOMeta.PLAN_START_TIME));
				this.setExecutorId( (String)map.get(InspectionTaskVOMeta.EXECUTOR_ID));
				this.setUpdateTime( (Date)map.get(InspectionTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(InspectionTaskVOMeta.VERSION));
				this.setPlanCode( (String)map.get(InspectionTaskVOMeta.PLAN_CODE));
				this.setCreateBy( (String)map.get(InspectionTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionTaskVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionTaskVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InspectionTaskVOMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)map.get(InspectionTaskVOMeta.ACT_TOTAL_COST));
				this.setPlanNotes( (String)map.get(InspectionTaskVOMeta.PLAN_NOTES));
				this.setTenantId( (String)map.get(InspectionTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionTaskVOMeta.DELETE_BY));
				this.setPlanCompletionTime( (BigDecimal)map.get(InspectionTaskVOMeta.PLAN_COMPLETION_TIME));
				// others
				this.setSearchField( (String)map.get(InspectionTaskVOMeta.SEARCH_FIELD));
				this.setTimeDict( (DictItem)map.get(InspectionTaskVOMeta.TIME_DICT));
				this.setRequestAction( (String)map.get(InspectionTaskVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(InspectionTaskVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(InspectionTaskVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(InspectionTaskVOMeta.ORIGINATOR));
				this.setInspectionGroup( (InspectionGroup)map.get(InspectionTaskVOMeta.INSPECTION_GROUP));
				this.setPageIndex( (Integer)map.get(InspectionTaskVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InspectionTaskVOMeta.SORT_TYPE));
				this.setExecutor( (Employee)map.get(InspectionTaskVOMeta.EXECUTOR));
				this.setInspectionTypeDict( (DictItem)map.get(InspectionTaskVOMeta.INSPECTION_TYPE_DICT));
				this.setInspectionPlan( (InspectionPlan)map.get(InspectionTaskVOMeta.INSPECTION_PLAN));
				this.setSortField( (String)map.get(InspectionTaskVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(InspectionTaskVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InspectionTaskVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(InspectionTaskVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.GROUP_ID)));
			this.setPlanName(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.PLAN_NAME)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.CONTENT)));
			this.setActStartTime(DataParser.parse(Date.class, r.getValue(InspectionTaskVOMeta.ACT_START_TIME)));
			this.setTaskCode(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.TASK_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.UPDATE_BY)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.ORIGINATOR_ID)));
			this.setPlanInspectionMethod(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.PLAN_INSPECTION_METHOD)));
			this.setActFinishTime(DataParser.parse(Date.class, r.getValue(InspectionTaskVOMeta.ACT_FINISH_TIME)));
			this.setTaskStatus(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.TASK_STATUS)));
			this.setPlanStartTime(DataParser.parse(Date.class, r.getValue(InspectionTaskVOMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.EXECUTOR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionTaskVOMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionTaskVOMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, r.getValue(InspectionTaskVOMeta.ACT_TOTAL_COST)));
			this.setPlanNotes(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.PLAN_NOTES)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionTaskVOMeta.DELETE_BY)));
			this.setPlanCompletionTime(DataParser.parse(BigDecimal.class, r.getValue(InspectionTaskVOMeta.PLAN_COMPLETION_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InspectionTaskVOMeta.NOTES));
				this.setGroupId( (String)r.getValue(InspectionTaskVOMeta.GROUP_ID));
				this.setPlanName( (String)r.getValue(InspectionTaskVOMeta.PLAN_NAME));
				this.setSelectedCode( (String)r.getValue(InspectionTaskVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(InspectionTaskVOMeta.CONTENT));
				this.setActStartTime( (Date)r.getValue(InspectionTaskVOMeta.ACT_START_TIME));
				this.setTaskCode( (String)r.getValue(InspectionTaskVOMeta.TASK_CODE));
				this.setUpdateBy( (String)r.getValue(InspectionTaskVOMeta.UPDATE_BY));
				this.setPlanId( (String)r.getValue(InspectionTaskVOMeta.PLAN_ID));
				this.setId( (String)r.getValue(InspectionTaskVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(InspectionTaskVOMeta.ORIGINATOR_ID));
				this.setPlanInspectionMethod( (String)r.getValue(InspectionTaskVOMeta.PLAN_INSPECTION_METHOD));
				this.setActFinishTime( (Date)r.getValue(InspectionTaskVOMeta.ACT_FINISH_TIME));
				this.setTaskStatus( (String)r.getValue(InspectionTaskVOMeta.TASK_STATUS));
				this.setPlanStartTime( (Date)r.getValue(InspectionTaskVOMeta.PLAN_START_TIME));
				this.setExecutorId( (String)r.getValue(InspectionTaskVOMeta.EXECUTOR_ID));
				this.setUpdateTime( (Date)r.getValue(InspectionTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(InspectionTaskVOMeta.VERSION));
				this.setPlanCode( (String)r.getValue(InspectionTaskVOMeta.PLAN_CODE));
				this.setCreateBy( (String)r.getValue(InspectionTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionTaskVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionTaskVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InspectionTaskVOMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)r.getValue(InspectionTaskVOMeta.ACT_TOTAL_COST));
				this.setPlanNotes( (String)r.getValue(InspectionTaskVOMeta.PLAN_NOTES));
				this.setTenantId( (String)r.getValue(InspectionTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionTaskVOMeta.DELETE_BY));
				this.setPlanCompletionTime( (BigDecimal)r.getValue(InspectionTaskVOMeta.PLAN_COMPLETION_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}