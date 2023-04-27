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
import com.dt.platform.domain.eam.meta.MaintainTaskVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 保养任务VO类型
 * <p>保养任务 , 数据表 eam_maintain_task 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:30:10
 * @sign 8B3D8B895A93C4002249F053A1457FB2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "保养任务VO类型 ; 保养任务 , 数据表 eam_maintain_task 的通用VO类型" , parent = MaintainTask.class)
public class MaintainTaskVO extends MaintainTask {

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
	public MaintainTaskVO setPageIndex(Integer pageIndex) {
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
	public MaintainTaskVO setPageSize(Integer pageSize) {
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
	public MaintainTaskVO setSearchField(String searchField) {
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
	public MaintainTaskVO setFuzzyField(String fuzzyField) {
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
	public MaintainTaskVO setSearchValue(String searchValue) {
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
	public MaintainTaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MaintainTaskVO addDirtyField(String... dirtyField) {
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
	public MaintainTaskVO setSortField(String sortField) {
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
	public MaintainTaskVO setSortType(String sortType) {
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
	public MaintainTaskVO setDataOrigin(String dataOrigin) {
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
	public MaintainTaskVO setQueryLogic(String queryLogic) {
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
	public MaintainTaskVO setRequestAction(String requestAction) {
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
	public MaintainTaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MaintainTaskVO addId(String... id) {
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
	 * @return MaintainTaskVO , 转换好的 MaintainTaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainTaskVO , 转换好的 PoJo 对象
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
	public MaintainTaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaintainTaskVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.MaintainTaskVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.MaintainTaskVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setAssetPos(this.getAssetPos());
		inst.setGroupId(this.getGroupId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setTimeout(this.getTimeout());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setActStartTime(this.getActStartTime());
		inst.setOverdue(this.getOverdue());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAssetId(this.getAssetId());
		inst.setAssetSn(this.getAssetSn());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setMaintainType(this.getMaintainType());
		inst.setActFinishTime(this.getActFinishTime());
		inst.setAssetCode(this.getAssetCode());
		inst.setCost(this.getCost());
		inst.setPlanStartTime(this.getPlanStartTime());
		inst.setExecutorId(this.getExecutorId());
		inst.setAssetModel(this.getAssetModel());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActTotalCost(this.getActTotalCost());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setAssetName(this.getAssetName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setAssetStatus(this.getAssetStatus());
		inst.setTotalCost(this.getTotalCost());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setProjectList(this.getProjectList());
			inst.setTaskProjectList(this.getTaskProjectList());
			inst.setMaintainPlan(this.getMaintainPlan());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setProjectIds(this.getProjectIds());
			inst.setTaskProjectIds(this.getTaskProjectIds());
			inst.setOriginator(this.getOriginator());
			inst.setMaintainTypeDict(this.getMaintainTypeDict());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setExecutor(this.getExecutor());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setAsset(this.getAsset());
			inst.setSearchValue(this.getSearchValue());
			inst.setMaintainGroup(this.getMaintainGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MaintainTaskVO clone(boolean deep) {
		return EntityContext.clone(MaintainTaskVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaintainTaskVO
	 * @param maintainTaskMap 包含实体信息的 Map 对象
	 * @return MaintainTaskVO , 转换好的的 MaintainTask 对象
	*/
	@Transient
	public static MaintainTaskVO createFrom(Map<String,Object> maintainTaskMap) {
		if(maintainTaskMap==null) return null;
		MaintainTaskVO vo = create();
		EntityContext.copyProperties(vo,maintainTaskMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MaintainTaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainTaskVO , 转换好的的 MaintainTask 对象
	*/
	@Transient
	public static MaintainTaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainTaskVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MaintainTaskVO，等同于 new
	 * @return MaintainTaskVO 对象
	*/
	@Transient
	public static MaintainTaskVO create() {
		return new com.dt.platform.domain.eam.meta.MaintainTaskVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.NOTES)));
			this.setAssetPos(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_POS)));
			this.setGroupId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.GROUP_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.CONTENT)));
			this.setTimeout(DataParser.parse(BigDecimal.class, map.get(MaintainTaskVOMeta.TIMEOUT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.BUSINESS_CODE)));
			this.setActStartTime(DataParser.parse(Date.class, map.get(MaintainTaskVOMeta.ACT_START_TIME)));
			this.setOverdue(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.OVERDUE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_ID)));
			this.setAssetSn(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_SN)));
			this.setPlanId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ORIGINATOR_ID)));
			this.setMaintainType(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.MAINTAIN_TYPE)));
			this.setActFinishTime(DataParser.parse(Date.class, map.get(MaintainTaskVOMeta.ACT_FINISH_TIME)));
			this.setAssetCode(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_CODE)));
			this.setCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskVOMeta.COST)));
			this.setPlanStartTime(DataParser.parse(Date.class, map.get(MaintainTaskVOMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.EXECUTOR_ID)));
			this.setAssetModel(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_MODEL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaintainTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaintainTaskVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaintainTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaintainTaskVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaintainTaskVOMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskVOMeta.ACT_TOTAL_COST)));
			this.setName(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.TENANT_ID)));
			this.setAssetName(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.DELETE_BY)));
			this.setAssetStatus(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.ASSET_STATUS)));
			this.setTotalCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskVOMeta.TOTAL_COST)));
			this.setStatus(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.STATUS)));
			// others
			this.setMaintainPlan(DataParser.parse(MaintainPlan.class, map.get(MaintainTaskVOMeta.MAINTAIN_PLAN)));
			this.setSearchField(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MaintainTaskVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(MaintainTaskVOMeta.ORIGINATOR)));
			this.setMaintainTypeDict(DataParser.parse(DictItem.class, map.get(MaintainTaskVOMeta.MAINTAIN_TYPE_DICT)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MaintainTaskVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.SORT_TYPE)));
			this.setExecutor(DataParser.parse(Employee.class, map.get(MaintainTaskVOMeta.EXECUTOR)));
			this.setSortField(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.QUERY_LOGIC)));
			this.setAsset(DataParser.parse(Asset.class, map.get(MaintainTaskVOMeta.ASSET)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MaintainTaskVOMeta.SEARCH_VALUE)));
			this.setMaintainGroup(DataParser.parse(MaintainGroup.class, map.get(MaintainTaskVOMeta.MAINTAIN_GROUP)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MaintainTaskVOMeta.NOTES));
				this.setAssetPos( (String)map.get(MaintainTaskVOMeta.ASSET_POS));
				this.setGroupId( (String)map.get(MaintainTaskVOMeta.GROUP_ID));
				this.setSelectedCode( (String)map.get(MaintainTaskVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(MaintainTaskVOMeta.CONTENT));
				this.setTimeout( (BigDecimal)map.get(MaintainTaskVOMeta.TIMEOUT));
				this.setBusinessCode( (String)map.get(MaintainTaskVOMeta.BUSINESS_CODE));
				this.setActStartTime( (Date)map.get(MaintainTaskVOMeta.ACT_START_TIME));
				this.setOverdue( (String)map.get(MaintainTaskVOMeta.OVERDUE));
				this.setUpdateBy( (String)map.get(MaintainTaskVOMeta.UPDATE_BY));
				this.setAssetId( (String)map.get(MaintainTaskVOMeta.ASSET_ID));
				this.setAssetSn( (String)map.get(MaintainTaskVOMeta.ASSET_SN));
				this.setPlanId( (String)map.get(MaintainTaskVOMeta.PLAN_ID));
				this.setId( (String)map.get(MaintainTaskVOMeta.ID));
				this.setOriginatorId( (String)map.get(MaintainTaskVOMeta.ORIGINATOR_ID));
				this.setMaintainType( (String)map.get(MaintainTaskVOMeta.MAINTAIN_TYPE));
				this.setActFinishTime( (Date)map.get(MaintainTaskVOMeta.ACT_FINISH_TIME));
				this.setAssetCode( (String)map.get(MaintainTaskVOMeta.ASSET_CODE));
				this.setCost( (BigDecimal)map.get(MaintainTaskVOMeta.COST));
				this.setPlanStartTime( (Date)map.get(MaintainTaskVOMeta.PLAN_START_TIME));
				this.setExecutorId( (String)map.get(MaintainTaskVOMeta.EXECUTOR_ID));
				this.setAssetModel( (String)map.get(MaintainTaskVOMeta.ASSET_MODEL));
				this.setUpdateTime( (Date)map.get(MaintainTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MaintainTaskVOMeta.VERSION));
				this.setCreateBy( (String)map.get(MaintainTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaintainTaskVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(MaintainTaskVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MaintainTaskVOMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)map.get(MaintainTaskVOMeta.ACT_TOTAL_COST));
				this.setName( (String)map.get(MaintainTaskVOMeta.NAME));
				this.setTenantId( (String)map.get(MaintainTaskVOMeta.TENANT_ID));
				this.setAssetName( (String)map.get(MaintainTaskVOMeta.ASSET_NAME));
				this.setDeleteBy( (String)map.get(MaintainTaskVOMeta.DELETE_BY));
				this.setAssetStatus( (String)map.get(MaintainTaskVOMeta.ASSET_STATUS));
				this.setTotalCost( (BigDecimal)map.get(MaintainTaskVOMeta.TOTAL_COST));
				this.setStatus( (String)map.get(MaintainTaskVOMeta.STATUS));
				// others
				this.setMaintainPlan( (MaintainPlan)map.get(MaintainTaskVOMeta.MAINTAIN_PLAN));
				this.setSearchField( (String)map.get(MaintainTaskVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MaintainTaskVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MaintainTaskVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(MaintainTaskVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(MaintainTaskVOMeta.ORIGINATOR));
				this.setMaintainTypeDict( (DictItem)map.get(MaintainTaskVOMeta.MAINTAIN_TYPE_DICT));
				this.setPageIndex( (Integer)map.get(MaintainTaskVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MaintainTaskVOMeta.SORT_TYPE));
				this.setExecutor( (Employee)map.get(MaintainTaskVOMeta.EXECUTOR));
				this.setSortField( (String)map.get(MaintainTaskVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(MaintainTaskVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MaintainTaskVOMeta.QUERY_LOGIC));
				this.setAsset( (Asset)map.get(MaintainTaskVOMeta.ASSET));
				this.setSearchValue( (String)map.get(MaintainTaskVOMeta.SEARCH_VALUE));
				this.setMaintainGroup( (MaintainGroup)map.get(MaintainTaskVOMeta.MAINTAIN_GROUP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.NOTES)));
			this.setAssetPos(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_POS)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.GROUP_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.CONTENT)));
			this.setTimeout(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskVOMeta.TIMEOUT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.BUSINESS_CODE)));
			this.setActStartTime(DataParser.parse(Date.class, r.getValue(MaintainTaskVOMeta.ACT_START_TIME)));
			this.setOverdue(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.OVERDUE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_ID)));
			this.setAssetSn(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_SN)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ORIGINATOR_ID)));
			this.setMaintainType(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.MAINTAIN_TYPE)));
			this.setActFinishTime(DataParser.parse(Date.class, r.getValue(MaintainTaskVOMeta.ACT_FINISH_TIME)));
			this.setAssetCode(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_CODE)));
			this.setCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskVOMeta.COST)));
			this.setPlanStartTime(DataParser.parse(Date.class, r.getValue(MaintainTaskVOMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.EXECUTOR_ID)));
			this.setAssetModel(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_MODEL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaintainTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaintainTaskVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaintainTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaintainTaskVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaintainTaskVOMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskVOMeta.ACT_TOTAL_COST)));
			this.setName(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.TENANT_ID)));
			this.setAssetName(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.DELETE_BY)));
			this.setAssetStatus(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.ASSET_STATUS)));
			this.setTotalCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskVOMeta.TOTAL_COST)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MaintainTaskVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MaintainTaskVOMeta.NOTES));
				this.setAssetPos( (String)r.getValue(MaintainTaskVOMeta.ASSET_POS));
				this.setGroupId( (String)r.getValue(MaintainTaskVOMeta.GROUP_ID));
				this.setSelectedCode( (String)r.getValue(MaintainTaskVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(MaintainTaskVOMeta.CONTENT));
				this.setTimeout( (BigDecimal)r.getValue(MaintainTaskVOMeta.TIMEOUT));
				this.setBusinessCode( (String)r.getValue(MaintainTaskVOMeta.BUSINESS_CODE));
				this.setActStartTime( (Date)r.getValue(MaintainTaskVOMeta.ACT_START_TIME));
				this.setOverdue( (String)r.getValue(MaintainTaskVOMeta.OVERDUE));
				this.setUpdateBy( (String)r.getValue(MaintainTaskVOMeta.UPDATE_BY));
				this.setAssetId( (String)r.getValue(MaintainTaskVOMeta.ASSET_ID));
				this.setAssetSn( (String)r.getValue(MaintainTaskVOMeta.ASSET_SN));
				this.setPlanId( (String)r.getValue(MaintainTaskVOMeta.PLAN_ID));
				this.setId( (String)r.getValue(MaintainTaskVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(MaintainTaskVOMeta.ORIGINATOR_ID));
				this.setMaintainType( (String)r.getValue(MaintainTaskVOMeta.MAINTAIN_TYPE));
				this.setActFinishTime( (Date)r.getValue(MaintainTaskVOMeta.ACT_FINISH_TIME));
				this.setAssetCode( (String)r.getValue(MaintainTaskVOMeta.ASSET_CODE));
				this.setCost( (BigDecimal)r.getValue(MaintainTaskVOMeta.COST));
				this.setPlanStartTime( (Date)r.getValue(MaintainTaskVOMeta.PLAN_START_TIME));
				this.setExecutorId( (String)r.getValue(MaintainTaskVOMeta.EXECUTOR_ID));
				this.setAssetModel( (String)r.getValue(MaintainTaskVOMeta.ASSET_MODEL));
				this.setUpdateTime( (Date)r.getValue(MaintainTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MaintainTaskVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MaintainTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaintainTaskVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MaintainTaskVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MaintainTaskVOMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)r.getValue(MaintainTaskVOMeta.ACT_TOTAL_COST));
				this.setName( (String)r.getValue(MaintainTaskVOMeta.NAME));
				this.setTenantId( (String)r.getValue(MaintainTaskVOMeta.TENANT_ID));
				this.setAssetName( (String)r.getValue(MaintainTaskVOMeta.ASSET_NAME));
				this.setDeleteBy( (String)r.getValue(MaintainTaskVOMeta.DELETE_BY));
				this.setAssetStatus( (String)r.getValue(MaintainTaskVOMeta.ASSET_STATUS));
				this.setTotalCost( (BigDecimal)r.getValue(MaintainTaskVOMeta.TOTAL_COST));
				this.setStatus( (String)r.getValue(MaintainTaskVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}