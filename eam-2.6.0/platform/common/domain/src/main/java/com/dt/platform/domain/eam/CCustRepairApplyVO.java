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
import com.dt.platform.domain.eam.meta.CCustRepairApplyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 报修申请VO类型
 * <p>报修申请 , 数据表 eam_c_cust_repair_apply 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-10 21:55:57
 * @sign 012982E9B91E0B544F134116D5324C43
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "报修申请VO类型 ; 报修申请 , 数据表 eam_c_cust_repair_apply 的通用VO类型" , parent = CCustRepairApply.class)
public class CCustRepairApplyVO extends CCustRepairApply {

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
	public CCustRepairApplyVO setPageIndex(Integer pageIndex) {
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
	public CCustRepairApplyVO setPageSize(Integer pageSize) {
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
	public CCustRepairApplyVO setSearchField(String searchField) {
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
	public CCustRepairApplyVO setFuzzyField(String fuzzyField) {
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
	public CCustRepairApplyVO setSearchValue(String searchValue) {
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
	public CCustRepairApplyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CCustRepairApplyVO addDirtyField(String... dirtyField) {
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
	public CCustRepairApplyVO setSortField(String sortField) {
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
	public CCustRepairApplyVO setSortType(String sortType) {
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
	public CCustRepairApplyVO setDataOrigin(String dataOrigin) {
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
	public CCustRepairApplyVO setQueryLogic(String queryLogic) {
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
	public CCustRepairApplyVO setRequestAction(String requestAction) {
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
	public CCustRepairApplyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CCustRepairApplyVO addId(String... id) {
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
	 * @return CCustRepairApplyVO , 转换好的 CCustRepairApplyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustRepairApplyVO , 转换好的 PoJo 对象
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
	public CCustRepairApplyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustRepairApplyVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustRepairApplyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustRepairApplyVOMeta.$$proxy$$();
		inst.setReportUserName(this.getReportUserName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setResult(this.getResult());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setPos(this.getPos());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setReportUserId(this.getReportUserId());
		inst.setContact(this.getContact());
		inst.setProcessUserId(this.getProcessUserId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanFinishDate(this.getPlanFinishDate());
		inst.setFinishDate(this.getFinishDate());
		inst.setId(this.getId());
		inst.setStartDate(this.getStartDate());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setReportUser(this.getReportUser());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setProcessUser(this.getProcessUser());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setAssetList(this.getAssetList());
			inst.setRepiarItemData(this.getRepiarItemData());
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
	public CCustRepairApplyVO clone(boolean deep) {
		return EntityContext.clone(CCustRepairApplyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustRepairApplyVO
	 * @param cCustRepairApplyMap 包含实体信息的 Map 对象
	 * @return CCustRepairApplyVO , 转换好的的 CCustRepairApply 对象
	*/
	@Transient
	public static CCustRepairApplyVO createFrom(Map<String,Object> cCustRepairApplyMap) {
		if(cCustRepairApplyMap==null) return null;
		CCustRepairApplyVO vo = create();
		EntityContext.copyProperties(vo,cCustRepairApplyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CCustRepairApplyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustRepairApplyVO , 转换好的的 CCustRepairApply 对象
	*/
	@Transient
	public static CCustRepairApplyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustRepairApplyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CCustRepairApplyVO，等同于 new
	 * @return CCustRepairApplyVO 对象
	*/
	@Transient
	public static CCustRepairApplyVO create() {
		return new com.dt.platform.domain.eam.meta.CCustRepairApplyVOMeta.$$proxy$$();
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
			this.setReportUserName(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.REPORT_USER_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustRepairApplyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustRepairApplyVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.CONTENT)));
			this.setResult(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.RESULT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustRepairApplyVOMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustRepairApplyVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustRepairApplyVOMeta.DELETE_TIME)));
			this.setReportUserId(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.REPORT_USER_ID)));
			this.setContact(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.CONTACT)));
			this.setProcessUserId(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.PROCESS_USER_ID)));
			this.setName(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(CCustRepairApplyVOMeta.PLAN_FINISH_DATE)));
			this.setFinishDate(DataParser.parse(Date.class, map.get(CCustRepairApplyVOMeta.FINISH_DATE)));
			this.setId(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.ID)));
			this.setStartDate(DataParser.parse(Date.class, map.get(CCustRepairApplyVOMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.STATUS)));
			// others
			this.setReportUser(DataParser.parse(Employee.class, map.get(CCustRepairApplyVOMeta.REPORT_USER)));
			this.setSearchField(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.FUZZY_FIELD)));
			this.setProcessUser(DataParser.parse(Employee.class, map.get(CCustRepairApplyVOMeta.PROCESS_USER)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CCustRepairApplyVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CCustRepairApplyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(CCustRepairApplyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setReportUserName( (String)map.get(CCustRepairApplyVOMeta.REPORT_USER_NAME));
				this.setUpdateTime( (Date)map.get(CCustRepairApplyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CCustRepairApplyVOMeta.VERSION));
				this.setContent( (String)map.get(CCustRepairApplyVOMeta.CONTENT));
				this.setResult( (String)map.get(CCustRepairApplyVOMeta.RESULT));
				this.setBusinessCode( (String)map.get(CCustRepairApplyVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(CCustRepairApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CCustRepairApplyVOMeta.DELETED));
				this.setPictureId( (String)map.get(CCustRepairApplyVOMeta.PICTURE_ID));
				this.setPos( (String)map.get(CCustRepairApplyVOMeta.POS));
				this.setCreateTime( (Date)map.get(CCustRepairApplyVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustRepairApplyVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustRepairApplyVOMeta.DELETE_TIME));
				this.setReportUserId( (String)map.get(CCustRepairApplyVOMeta.REPORT_USER_ID));
				this.setContact( (String)map.get(CCustRepairApplyVOMeta.CONTACT));
				this.setProcessUserId( (String)map.get(CCustRepairApplyVOMeta.PROCESS_USER_ID));
				this.setName( (String)map.get(CCustRepairApplyVOMeta.NAME));
				this.setDeleteBy( (String)map.get(CCustRepairApplyVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(CCustRepairApplyVOMeta.PLAN_FINISH_DATE));
				this.setFinishDate( (Date)map.get(CCustRepairApplyVOMeta.FINISH_DATE));
				this.setId( (String)map.get(CCustRepairApplyVOMeta.ID));
				this.setStartDate( (Date)map.get(CCustRepairApplyVOMeta.START_DATE));
				this.setStatus( (String)map.get(CCustRepairApplyVOMeta.STATUS));
				// others
				this.setReportUser( (Employee)map.get(CCustRepairApplyVOMeta.REPORT_USER));
				this.setSearchField( (String)map.get(CCustRepairApplyVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(CCustRepairApplyVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(CCustRepairApplyVOMeta.FUZZY_FIELD));
				this.setProcessUser( (Employee)map.get(CCustRepairApplyVOMeta.PROCESS_USER));
				this.setPageSize( (Integer)map.get(CCustRepairApplyVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(CCustRepairApplyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(CCustRepairApplyVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(CCustRepairApplyVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(CCustRepairApplyVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(CCustRepairApplyVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(CCustRepairApplyVOMeta.SEARCH_VALUE));
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
			this.setReportUserName(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.REPORT_USER_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustRepairApplyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustRepairApplyVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.CONTENT)));
			this.setResult(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.RESULT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustRepairApplyVOMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustRepairApplyVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustRepairApplyVOMeta.DELETE_TIME)));
			this.setReportUserId(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.REPORT_USER_ID)));
			this.setContact(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.CONTACT)));
			this.setProcessUserId(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.PROCESS_USER_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(CCustRepairApplyVOMeta.PLAN_FINISH_DATE)));
			this.setFinishDate(DataParser.parse(Date.class, r.getValue(CCustRepairApplyVOMeta.FINISH_DATE)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.ID)));
			this.setStartDate(DataParser.parse(Date.class, r.getValue(CCustRepairApplyVOMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CCustRepairApplyVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReportUserName( (String)r.getValue(CCustRepairApplyVOMeta.REPORT_USER_NAME));
				this.setUpdateTime( (Date)r.getValue(CCustRepairApplyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CCustRepairApplyVOMeta.VERSION));
				this.setContent( (String)r.getValue(CCustRepairApplyVOMeta.CONTENT));
				this.setResult( (String)r.getValue(CCustRepairApplyVOMeta.RESULT));
				this.setBusinessCode( (String)r.getValue(CCustRepairApplyVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(CCustRepairApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CCustRepairApplyVOMeta.DELETED));
				this.setPictureId( (String)r.getValue(CCustRepairApplyVOMeta.PICTURE_ID));
				this.setPos( (String)r.getValue(CCustRepairApplyVOMeta.POS));
				this.setCreateTime( (Date)r.getValue(CCustRepairApplyVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustRepairApplyVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustRepairApplyVOMeta.DELETE_TIME));
				this.setReportUserId( (String)r.getValue(CCustRepairApplyVOMeta.REPORT_USER_ID));
				this.setContact( (String)r.getValue(CCustRepairApplyVOMeta.CONTACT));
				this.setProcessUserId( (String)r.getValue(CCustRepairApplyVOMeta.PROCESS_USER_ID));
				this.setName( (String)r.getValue(CCustRepairApplyVOMeta.NAME));
				this.setDeleteBy( (String)r.getValue(CCustRepairApplyVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(CCustRepairApplyVOMeta.PLAN_FINISH_DATE));
				this.setFinishDate( (Date)r.getValue(CCustRepairApplyVOMeta.FINISH_DATE));
				this.setId( (String)r.getValue(CCustRepairApplyVOMeta.ID));
				this.setStartDate( (Date)r.getValue(CCustRepairApplyVOMeta.START_DATE));
				this.setStatus( (String)r.getValue(CCustRepairApplyVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}