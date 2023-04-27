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
import com.dt.platform.domain.eam.meta.InspectionPlanVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检计划VO类型
 * <p>巡检计划 , 数据表 eam_inspection_plan 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-12 21:22:49
 * @sign EC46F8F634C939A1F754AC634AAD5555
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "巡检计划VO类型 ; 巡检计划 , 数据表 eam_inspection_plan 的通用VO类型" , parent = InspectionPlan.class)
public class InspectionPlanVO extends InspectionPlan {

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
	public InspectionPlanVO setPageIndex(Integer pageIndex) {
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
	public InspectionPlanVO setPageSize(Integer pageSize) {
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
	public InspectionPlanVO setSearchField(String searchField) {
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
	public InspectionPlanVO setFuzzyField(String fuzzyField) {
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
	public InspectionPlanVO setSearchValue(String searchValue) {
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
	public InspectionPlanVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InspectionPlanVO addDirtyField(String... dirtyField) {
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
	public InspectionPlanVO setSortField(String sortField) {
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
	public InspectionPlanVO setSortType(String sortType) {
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
	public InspectionPlanVO setDataOrigin(String dataOrigin) {
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
	public InspectionPlanVO setQueryLogic(String queryLogic) {
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
	public InspectionPlanVO setRequestAction(String requestAction) {
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
	public InspectionPlanVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InspectionPlanVO addId(String... id) {
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
	 * @return InspectionPlanVO , 转换好的 InspectionPlanVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionPlanVO , 转换好的 PoJo 对象
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
	public InspectionPlanVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionPlanVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionPlanVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionPlanVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setEndDate(this.getEndDate());
		inst.setGroupId(this.getGroupId());
		inst.setPlanStatus(this.getPlanStatus());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setLeaderId(this.getLeaderId());
		inst.setCompletionTime(this.getCompletionTime());
		inst.setRemindTime(this.getRemindTime());
		inst.setOvertimeMethod(this.getOvertimeMethod());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setInspectionMethod(this.getInspectionMethod());
		inst.setPlanType(this.getPlanType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setActionCycleId(this.getActionCycleId());
		inst.setVersion(this.getVersion());
		inst.setPlanCode(this.getPlanCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartDate(this.getStartDate());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setInspectionPointOwnerIds(this.getInspectionPointOwnerIds());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setInspectionPointOwnerList(this.getInspectionPointOwnerList());
			inst.setInspectionPlanPointList(this.getInspectionPlanPointList());
			inst.setInspectionGroup(this.getInspectionGroup());
			inst.setActionCrontab(this.getActionCrontab());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setInspectionTypeDict(this.getInspectionTypeDict());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setInspectionPlanPointIds(this.getInspectionPlanPointIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionPlanVO clone(boolean deep) {
		return EntityContext.clone(InspectionPlanVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionPlanVO
	 * @param inspectionPlanMap 包含实体信息的 Map 对象
	 * @return InspectionPlanVO , 转换好的的 InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlanVO createFrom(Map<String,Object> inspectionPlanMap) {
		if(inspectionPlanMap==null) return null;
		InspectionPlanVO vo = create();
		EntityContext.copyProperties(vo,inspectionPlanMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InspectionPlanVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionPlanVO , 转换好的的 InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlanVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionPlanVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InspectionPlanVO，等同于 new
	 * @return InspectionPlanVO 对象
	*/
	@Transient
	public static InspectionPlanVO create() {
		return new com.dt.platform.domain.eam.meta.InspectionPlanVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.NOTES)));
			this.setEndDate(DataParser.parse(Date.class, map.get(InspectionPlanVOMeta.END_DATE)));
			this.setGroupId(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.GROUP_ID)));
			this.setPlanStatus(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.PLAN_STATUS)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.SELECTED_CODE)));
			this.setLeaderId(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.LEADER_ID)));
			this.setCompletionTime(DataParser.parse(BigDecimal.class, map.get(InspectionPlanVOMeta.COMPLETION_TIME)));
			this.setRemindTime(DataParser.parse(BigDecimal.class, map.get(InspectionPlanVOMeta.REMIND_TIME)));
			this.setOvertimeMethod(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.OVERTIME_METHOD)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.ID)));
			this.setInspectionMethod(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.INSPECTION_METHOD)));
			this.setPlanType(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.PLAN_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionPlanVOMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.ACTION_CYCLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionPlanVOMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionPlanVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionPlanVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionPlanVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.DELETE_BY)));
			this.setStartDate(DataParser.parse(Date.class, map.get(InspectionPlanVOMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InspectionPlanVOMeta.PAGE_SIZE)));
			this.setInspectionGroup(DataParser.parse(InspectionGroup.class, map.get(InspectionPlanVOMeta.INSPECTION_GROUP)));
			this.setActionCrontab(DataParser.parse(ActionCrontab.class, map.get(InspectionPlanVOMeta.ACTION_CRONTAB)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InspectionPlanVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.SORT_TYPE)));
			this.setInspectionTypeDict(DataParser.parse(DictItem.class, map.get(InspectionPlanVOMeta.INSPECTION_TYPE_DICT)));
			this.setSortField(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InspectionPlanVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InspectionPlanVOMeta.NOTES));
				this.setEndDate( (Date)map.get(InspectionPlanVOMeta.END_DATE));
				this.setGroupId( (String)map.get(InspectionPlanVOMeta.GROUP_ID));
				this.setPlanStatus( (String)map.get(InspectionPlanVOMeta.PLAN_STATUS));
				this.setSelectedCode( (String)map.get(InspectionPlanVOMeta.SELECTED_CODE));
				this.setLeaderId( (String)map.get(InspectionPlanVOMeta.LEADER_ID));
				this.setCompletionTime( (BigDecimal)map.get(InspectionPlanVOMeta.COMPLETION_TIME));
				this.setRemindTime( (BigDecimal)map.get(InspectionPlanVOMeta.REMIND_TIME));
				this.setOvertimeMethod( (String)map.get(InspectionPlanVOMeta.OVERTIME_METHOD));
				this.setUpdateBy( (String)map.get(InspectionPlanVOMeta.UPDATE_BY));
				this.setId( (String)map.get(InspectionPlanVOMeta.ID));
				this.setInspectionMethod( (String)map.get(InspectionPlanVOMeta.INSPECTION_METHOD));
				this.setPlanType( (String)map.get(InspectionPlanVOMeta.PLAN_TYPE));
				this.setUpdateTime( (Date)map.get(InspectionPlanVOMeta.UPDATE_TIME));
				this.setActionCycleId( (String)map.get(InspectionPlanVOMeta.ACTION_CYCLE_ID));
				this.setVersion( (Integer)map.get(InspectionPlanVOMeta.VERSION));
				this.setPlanCode( (String)map.get(InspectionPlanVOMeta.PLAN_CODE));
				this.setCreateBy( (String)map.get(InspectionPlanVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionPlanVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionPlanVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InspectionPlanVOMeta.DELETE_TIME));
				this.setName( (String)map.get(InspectionPlanVOMeta.NAME));
				this.setTenantId( (String)map.get(InspectionPlanVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionPlanVOMeta.DELETE_BY));
				this.setStartDate( (Date)map.get(InspectionPlanVOMeta.START_DATE));
				this.setStatus( (String)map.get(InspectionPlanVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(InspectionPlanVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(InspectionPlanVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(InspectionPlanVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(InspectionPlanVOMeta.PAGE_SIZE));
				this.setInspectionGroup( (InspectionGroup)map.get(InspectionPlanVOMeta.INSPECTION_GROUP));
				this.setActionCrontab( (ActionCrontab)map.get(InspectionPlanVOMeta.ACTION_CRONTAB));
				this.setPageIndex( (Integer)map.get(InspectionPlanVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InspectionPlanVOMeta.SORT_TYPE));
				this.setInspectionTypeDict( (DictItem)map.get(InspectionPlanVOMeta.INSPECTION_TYPE_DICT));
				this.setSortField( (String)map.get(InspectionPlanVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(InspectionPlanVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InspectionPlanVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(InspectionPlanVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.NOTES)));
			this.setEndDate(DataParser.parse(Date.class, r.getValue(InspectionPlanVOMeta.END_DATE)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.GROUP_ID)));
			this.setPlanStatus(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.PLAN_STATUS)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.SELECTED_CODE)));
			this.setLeaderId(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.LEADER_ID)));
			this.setCompletionTime(DataParser.parse(BigDecimal.class, r.getValue(InspectionPlanVOMeta.COMPLETION_TIME)));
			this.setRemindTime(DataParser.parse(BigDecimal.class, r.getValue(InspectionPlanVOMeta.REMIND_TIME)));
			this.setOvertimeMethod(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.OVERTIME_METHOD)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.ID)));
			this.setInspectionMethod(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.INSPECTION_METHOD)));
			this.setPlanType(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.PLAN_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionPlanVOMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.ACTION_CYCLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionPlanVOMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionPlanVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionPlanVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionPlanVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.DELETE_BY)));
			this.setStartDate(DataParser.parse(Date.class, r.getValue(InspectionPlanVOMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InspectionPlanVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InspectionPlanVOMeta.NOTES));
				this.setEndDate( (Date)r.getValue(InspectionPlanVOMeta.END_DATE));
				this.setGroupId( (String)r.getValue(InspectionPlanVOMeta.GROUP_ID));
				this.setPlanStatus( (String)r.getValue(InspectionPlanVOMeta.PLAN_STATUS));
				this.setSelectedCode( (String)r.getValue(InspectionPlanVOMeta.SELECTED_CODE));
				this.setLeaderId( (String)r.getValue(InspectionPlanVOMeta.LEADER_ID));
				this.setCompletionTime( (BigDecimal)r.getValue(InspectionPlanVOMeta.COMPLETION_TIME));
				this.setRemindTime( (BigDecimal)r.getValue(InspectionPlanVOMeta.REMIND_TIME));
				this.setOvertimeMethod( (String)r.getValue(InspectionPlanVOMeta.OVERTIME_METHOD));
				this.setUpdateBy( (String)r.getValue(InspectionPlanVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(InspectionPlanVOMeta.ID));
				this.setInspectionMethod( (String)r.getValue(InspectionPlanVOMeta.INSPECTION_METHOD));
				this.setPlanType( (String)r.getValue(InspectionPlanVOMeta.PLAN_TYPE));
				this.setUpdateTime( (Date)r.getValue(InspectionPlanVOMeta.UPDATE_TIME));
				this.setActionCycleId( (String)r.getValue(InspectionPlanVOMeta.ACTION_CYCLE_ID));
				this.setVersion( (Integer)r.getValue(InspectionPlanVOMeta.VERSION));
				this.setPlanCode( (String)r.getValue(InspectionPlanVOMeta.PLAN_CODE));
				this.setCreateBy( (String)r.getValue(InspectionPlanVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionPlanVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionPlanVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InspectionPlanVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(InspectionPlanVOMeta.NAME));
				this.setTenantId( (String)r.getValue(InspectionPlanVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionPlanVOMeta.DELETE_BY));
				this.setStartDate( (Date)r.getValue(InspectionPlanVOMeta.START_DATE));
				this.setStatus( (String)r.getValue(InspectionPlanVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}