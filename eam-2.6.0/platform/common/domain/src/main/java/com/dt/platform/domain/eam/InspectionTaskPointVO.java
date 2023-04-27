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
import com.dt.platform.domain.eam.meta.InspectionTaskPointVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检点VO类型
 * <p>巡检点 , 数据表 eam_inspection_task_point 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 12:47:53
 * @sign 651D328B81E70EC1A0B8941BD7D880C5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "巡检点VO类型 ; 巡检点 , 数据表 eam_inspection_task_point 的通用VO类型" , parent = InspectionTaskPoint.class)
public class InspectionTaskPointVO extends InspectionTaskPoint {

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
	public InspectionTaskPointVO setPageIndex(Integer pageIndex) {
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
	public InspectionTaskPointVO setPageSize(Integer pageSize) {
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
	public InspectionTaskPointVO setSearchField(String searchField) {
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
	public InspectionTaskPointVO setFuzzyField(String fuzzyField) {
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
	public InspectionTaskPointVO setSearchValue(String searchValue) {
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
	public InspectionTaskPointVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InspectionTaskPointVO addDirtyField(String... dirtyField) {
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
	public InspectionTaskPointVO setSortField(String sortField) {
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
	public InspectionTaskPointVO setSortType(String sortType) {
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
	public InspectionTaskPointVO setDataOrigin(String dataOrigin) {
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
	public InspectionTaskPointVO setQueryLogic(String queryLogic) {
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
	public InspectionTaskPointVO setRequestAction(String requestAction) {
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
	public InspectionTaskPointVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InspectionTaskPointVO addId(String... id) {
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
	 * @return InspectionTaskPointVO , 转换好的 InspectionTaskPointVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTaskPointVO , 转换好的 PoJo 对象
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
	public InspectionTaskPointVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionTaskPointVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionTaskPointVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionTaskPointVOMeta.$$proxy$$();
		inst.setPointRfid(this.getPointRfid());
		inst.setNotes(this.getNotes());
		inst.setPointName(this.getPointName());
		inst.setOperId(this.getOperId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setPointId(this.getPointId());
		inst.setPointRouteId(this.getPointRouteId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setPointNotes(this.getPointNotes());
		inst.setId(this.getId());
		inst.setPointStatus(this.getPointStatus());
		inst.setOperTime(this.getOperTime());
		inst.setPointCode(this.getPointCode());
		inst.setPointContent(this.getPointContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setPointPos(this.getPointPos());
		inst.setPointPosLongitude(this.getPointPosLongitude());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPointPosId(this.getPointPosId());
		inst.setPointPosLatitude(this.getPointPosLatitude());
		inst.setTaskId(this.getTaskId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setInspectionPointPos(this.getInspectionPointPos());
			inst.setRoute(this.getRoute());
			inst.setTask(this.getTask());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setOperUser(this.getOperUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionTaskPointVO clone(boolean deep) {
		return EntityContext.clone(InspectionTaskPointVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionTaskPointVO
	 * @param inspectionTaskPointMap 包含实体信息的 Map 对象
	 * @return InspectionTaskPointVO , 转换好的的 InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPointVO createFrom(Map<String,Object> inspectionTaskPointMap) {
		if(inspectionTaskPointMap==null) return null;
		InspectionTaskPointVO vo = create();
		EntityContext.copyProperties(vo,inspectionTaskPointMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InspectionTaskPointVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTaskPointVO , 转换好的的 InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPointVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTaskPointVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InspectionTaskPointVO，等同于 new
	 * @return InspectionTaskPointVO 对象
	*/
	@Transient
	public static InspectionTaskPointVO create() {
		return new com.dt.platform.domain.eam.meta.InspectionTaskPointVOMeta.$$proxy$$();
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
			this.setPointRfid(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_RFID)));
			this.setNotes(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.NOTES)));
			this.setPointName(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_NAME)));
			this.setOperId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.OPER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.CONTENT)));
			this.setPointId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_ID)));
			this.setPointRouteId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_ROUTE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.UPDATE_BY)));
			this.setPointNotes(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_NOTES)));
			this.setId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.ID)));
			this.setPointStatus(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_STATUS)));
			this.setOperTime(DataParser.parse(Date.class, map.get(InspectionTaskPointVOMeta.OPER_TIME)));
			this.setPointCode(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_CODE)));
			this.setPointContent(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionTaskPointVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(InspectionTaskPointVOMeta.SORT)));
			this.setPointPos(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_POS)));
			this.setPointPosLongitude(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_POS_LONGITUDE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionTaskPointVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionTaskPointVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionTaskPointVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionTaskPointVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.DELETE_BY)));
			this.setPointPosId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_POS_ID)));
			this.setPointPosLatitude(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.POINT_POS_LATITUDE)));
			this.setTaskId(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.TASK_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InspectionTaskPointVOMeta.PAGE_SIZE)));
			this.setInspectionPointPos(DataParser.parse(InspectionPointPos.class, map.get(InspectionTaskPointVOMeta.INSPECTION_POINT_POS)));
			this.setRoute(DataParser.parse(InspectionRoute.class, map.get(InspectionTaskPointVOMeta.ROUTE)));
			this.setTask(DataParser.parse(InspectionTask.class, map.get(InspectionTaskPointVOMeta.TASK)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InspectionTaskPointVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.QUERY_LOGIC)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(InspectionTaskPointVOMeta.OPER_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InspectionTaskPointVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setPointRfid( (String)map.get(InspectionTaskPointVOMeta.POINT_RFID));
				this.setNotes( (String)map.get(InspectionTaskPointVOMeta.NOTES));
				this.setPointName( (String)map.get(InspectionTaskPointVOMeta.POINT_NAME));
				this.setOperId( (String)map.get(InspectionTaskPointVOMeta.OPER_ID));
				this.setSelectedCode( (String)map.get(InspectionTaskPointVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(InspectionTaskPointVOMeta.CONTENT));
				this.setPointId( (String)map.get(InspectionTaskPointVOMeta.POINT_ID));
				this.setPointRouteId( (String)map.get(InspectionTaskPointVOMeta.POINT_ROUTE_ID));
				this.setUpdateBy( (String)map.get(InspectionTaskPointVOMeta.UPDATE_BY));
				this.setPointNotes( (String)map.get(InspectionTaskPointVOMeta.POINT_NOTES));
				this.setId( (String)map.get(InspectionTaskPointVOMeta.ID));
				this.setPointStatus( (String)map.get(InspectionTaskPointVOMeta.POINT_STATUS));
				this.setOperTime( (Date)map.get(InspectionTaskPointVOMeta.OPER_TIME));
				this.setPointCode( (String)map.get(InspectionTaskPointVOMeta.POINT_CODE));
				this.setPointContent( (String)map.get(InspectionTaskPointVOMeta.POINT_CONTENT));
				this.setUpdateTime( (Date)map.get(InspectionTaskPointVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(InspectionTaskPointVOMeta.SORT));
				this.setPointPos( (String)map.get(InspectionTaskPointVOMeta.POINT_POS));
				this.setPointPosLongitude( (String)map.get(InspectionTaskPointVOMeta.POINT_POS_LONGITUDE));
				this.setVersion( (Integer)map.get(InspectionTaskPointVOMeta.VERSION));
				this.setCreateBy( (String)map.get(InspectionTaskPointVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionTaskPointVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionTaskPointVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InspectionTaskPointVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(InspectionTaskPointVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionTaskPointVOMeta.DELETE_BY));
				this.setPointPosId( (String)map.get(InspectionTaskPointVOMeta.POINT_POS_ID));
				this.setPointPosLatitude( (String)map.get(InspectionTaskPointVOMeta.POINT_POS_LATITUDE));
				this.setTaskId( (String)map.get(InspectionTaskPointVOMeta.TASK_ID));
				// others
				this.setSearchField( (String)map.get(InspectionTaskPointVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(InspectionTaskPointVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(InspectionTaskPointVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(InspectionTaskPointVOMeta.PAGE_SIZE));
				this.setInspectionPointPos( (InspectionPointPos)map.get(InspectionTaskPointVOMeta.INSPECTION_POINT_POS));
				this.setRoute( (InspectionRoute)map.get(InspectionTaskPointVOMeta.ROUTE));
				this.setTask( (InspectionTask)map.get(InspectionTaskPointVOMeta.TASK));
				this.setPageIndex( (Integer)map.get(InspectionTaskPointVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InspectionTaskPointVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(InspectionTaskPointVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(InspectionTaskPointVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InspectionTaskPointVOMeta.QUERY_LOGIC));
				this.setOperUser( (Employee)map.get(InspectionTaskPointVOMeta.OPER_USER));
				this.setSearchValue( (String)map.get(InspectionTaskPointVOMeta.SEARCH_VALUE));
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
			this.setPointRfid(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_RFID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.NOTES)));
			this.setPointName(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_NAME)));
			this.setOperId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.OPER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.CONTENT)));
			this.setPointId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_ID)));
			this.setPointRouteId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_ROUTE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.UPDATE_BY)));
			this.setPointNotes(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_NOTES)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.ID)));
			this.setPointStatus(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_STATUS)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointVOMeta.OPER_TIME)));
			this.setPointCode(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_CODE)));
			this.setPointContent(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointVOMeta.SORT)));
			this.setPointPos(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_POS)));
			this.setPointPosLongitude(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_POS_LONGITUDE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.DELETE_BY)));
			this.setPointPosId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_POS_ID)));
			this.setPointPosLatitude(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.POINT_POS_LATITUDE)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(InspectionTaskPointVOMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setPointRfid( (String)r.getValue(InspectionTaskPointVOMeta.POINT_RFID));
				this.setNotes( (String)r.getValue(InspectionTaskPointVOMeta.NOTES));
				this.setPointName( (String)r.getValue(InspectionTaskPointVOMeta.POINT_NAME));
				this.setOperId( (String)r.getValue(InspectionTaskPointVOMeta.OPER_ID));
				this.setSelectedCode( (String)r.getValue(InspectionTaskPointVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(InspectionTaskPointVOMeta.CONTENT));
				this.setPointId( (String)r.getValue(InspectionTaskPointVOMeta.POINT_ID));
				this.setPointRouteId( (String)r.getValue(InspectionTaskPointVOMeta.POINT_ROUTE_ID));
				this.setUpdateBy( (String)r.getValue(InspectionTaskPointVOMeta.UPDATE_BY));
				this.setPointNotes( (String)r.getValue(InspectionTaskPointVOMeta.POINT_NOTES));
				this.setId( (String)r.getValue(InspectionTaskPointVOMeta.ID));
				this.setPointStatus( (String)r.getValue(InspectionTaskPointVOMeta.POINT_STATUS));
				this.setOperTime( (Date)r.getValue(InspectionTaskPointVOMeta.OPER_TIME));
				this.setPointCode( (String)r.getValue(InspectionTaskPointVOMeta.POINT_CODE));
				this.setPointContent( (String)r.getValue(InspectionTaskPointVOMeta.POINT_CONTENT));
				this.setUpdateTime( (Date)r.getValue(InspectionTaskPointVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(InspectionTaskPointVOMeta.SORT));
				this.setPointPos( (String)r.getValue(InspectionTaskPointVOMeta.POINT_POS));
				this.setPointPosLongitude( (String)r.getValue(InspectionTaskPointVOMeta.POINT_POS_LONGITUDE));
				this.setVersion( (Integer)r.getValue(InspectionTaskPointVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(InspectionTaskPointVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionTaskPointVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionTaskPointVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InspectionTaskPointVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(InspectionTaskPointVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionTaskPointVOMeta.DELETE_BY));
				this.setPointPosId( (String)r.getValue(InspectionTaskPointVOMeta.POINT_POS_ID));
				this.setPointPosLatitude( (String)r.getValue(InspectionTaskPointVOMeta.POINT_POS_LATITUDE));
				this.setTaskId( (String)r.getValue(InspectionTaskPointVOMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}