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
import com.dt.platform.domain.ops.meta.InformationSystemVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 信息系统VO类型
 * <p>信息系统 , 数据表 ops_information_system 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-03 16:00:36
 * @sign A4760002E2C46A63027FD19148F51477
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "信息系统VO类型 ; 信息系统 , 数据表 ops_information_system 的通用VO类型" , parent = InformationSystem.class)
public class InformationSystemVO extends InformationSystem {

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
	 * 数据来源：前端指定不同的来源，后端按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
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
	public InformationSystemVO setPageIndex(Integer pageIndex) {
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
	public InformationSystemVO setPageSize(Integer pageSize) {
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
	public InformationSystemVO setSearchField(String searchField) {
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
	public InformationSystemVO setFuzzyField(String fuzzyField) {
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
	public InformationSystemVO setSearchValue(String searchValue) {
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
	public InformationSystemVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InformationSystemVO addDirtyField(String... dirtyField) {
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
	public InformationSystemVO setSortField(String sortField) {
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
	public InformationSystemVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端按来源执行不同的逻辑
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
	public InformationSystemVO setDataOrigin(String dataOrigin) {
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
	public InformationSystemVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
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
	public InformationSystemVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InformationSystemVO addId(String... id) {
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
	 * @return InformationSystemVO , 转换好的 InformationSystemVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InformationSystemVO , 转换好的 PoJo 对象
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
	public InformationSystemVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InformationSystemVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.InformationSystemVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.InformationSystemVOMeta.$$proxy$$();
		inst.setSameplaceBacupInfo(this.getSameplaceBacupInfo());
		inst.setArchMethod(this.getArchMethod());
		inst.setNotes(this.getNotes());
		inst.setAppInfo(this.getAppInfo());
		inst.setPid(this.getPid());
		inst.setDevMethod(this.getDevMethod());
		inst.setTechnicalContact(this.getTechnicalContact());
		inst.setOsInfo(this.getOsInfo());
		inst.setHardwareInfo(this.getHardwareInfo());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setBackupInfo(this.getBackupInfo());
		inst.setDbInfo(this.getDbInfo());
		inst.setDiffplaceBackupInfo(this.getDiffplaceBackupInfo());
		inst.setAddress(this.getAddress());
		inst.setBelongOrgId(this.getBelongOrgId());
		inst.setProfile(this.getProfile());
		inst.setBusinessContact(this.getBusinessContact());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setRto(this.getRto());
		inst.setVersion(this.getVersion());
		inst.setLabels(this.getLabels());
		inst.setOnlineDate(this.getOnlineDate());
		inst.setRpo(this.getRpo());
		inst.setCreateBy(this.getCreateBy());
		inst.setOfflineDate(this.getOfflineDate());
		inst.setDeleted(this.getDeleted());
		inst.setOpsMethod(this.getOpsMethod());
		inst.setLastdrillDate(this.getLastdrillDate());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setGrade(this.getGrade());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setInfoSystemStatus(this.getInfoSystemStatus());
			inst.setSearchField(this.getSearchField());
			inst.setVoucherList(this.getVoucherList());
			inst.setInfoSystemDevMethod(this.getInfoSystemDevMethod());
			inst.setInfoSystemGrade(this.getInfoSystemGrade());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setBelongOrganization(this.getBelongOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setInfoSystemOpsMethod(this.getInfoSystemOpsMethod());
			inst.setSearchValue(this.getSearchValue());
			inst.setVoucherIds(this.getVoucherIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InformationSystemVO clone(boolean deep) {
		return EntityContext.clone(InformationSystemVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InformationSystemVO
	 * @param informationSystemMap 包含实体信息的 Map 对象
	 * @return InformationSystemVO , 转换好的的 InformationSystem 对象
	*/
	@Transient
	public static InformationSystemVO createFrom(Map<String,Object> informationSystemMap) {
		if(informationSystemMap==null) return null;
		InformationSystemVO vo = create();
		EntityContext.copyProperties(vo,informationSystemMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InformationSystemVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InformationSystemVO , 转换好的的 InformationSystem 对象
	*/
	@Transient
	public static InformationSystemVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InformationSystemVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InformationSystemVO，等同于 new
	 * @return InformationSystemVO 对象
	*/
	@Transient
	public static InformationSystemVO create() {
		return new com.dt.platform.domain.ops.meta.InformationSystemVOMeta.$$proxy$$();
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
			this.setSameplaceBacupInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.SAMEPLACE_BACUP_INFO)));
			this.setArchMethod(DataParser.parse(String.class, map.get(InformationSystemVOMeta.ARCH_METHOD)));
			this.setNotes(DataParser.parse(String.class, map.get(InformationSystemVOMeta.NOTES)));
			this.setAppInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.APP_INFO)));
			this.setPid(DataParser.parse(String.class, map.get(InformationSystemVOMeta.PID)));
			this.setDevMethod(DataParser.parse(String.class, map.get(InformationSystemVOMeta.DEV_METHOD)));
			this.setTechnicalContact(DataParser.parse(String.class, map.get(InformationSystemVOMeta.TECHNICAL_CONTACT)));
			this.setOsInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.OS_INFO)));
			this.setHardwareInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.HARDWARE_INFO)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InformationSystemVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InformationSystemVOMeta.ID)));
			this.setBackupInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.BACKUP_INFO)));
			this.setDbInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.DB_INFO)));
			this.setDiffplaceBackupInfo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO)));
			this.setAddress(DataParser.parse(String.class, map.get(InformationSystemVOMeta.ADDRESS)));
			this.setBelongOrgId(DataParser.parse(String.class, map.get(InformationSystemVOMeta.BELONG_ORG_ID)));
			this.setProfile(DataParser.parse(String.class, map.get(InformationSystemVOMeta.PROFILE)));
			this.setBusinessContact(DataParser.parse(String.class, map.get(InformationSystemVOMeta.BUSINESS_CONTACT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InformationSystemVOMeta.UPDATE_TIME)));
			this.setRto(DataParser.parse(String.class, map.get(InformationSystemVOMeta.RTO)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InformationSystemVOMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, map.get(InformationSystemVOMeta.LABELS)));
			this.setOnlineDate(DataParser.parse(Date.class, map.get(InformationSystemVOMeta.ONLINE_DATE)));
			this.setRpo(DataParser.parse(String.class, map.get(InformationSystemVOMeta.RPO)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InformationSystemVOMeta.CREATE_BY)));
			this.setOfflineDate(DataParser.parse(Date.class, map.get(InformationSystemVOMeta.OFFLINE_DATE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InformationSystemVOMeta.DELETED)));
			this.setOpsMethod(DataParser.parse(String.class, map.get(InformationSystemVOMeta.OPS_METHOD)));
			this.setLastdrillDate(DataParser.parse(Date.class, map.get(InformationSystemVOMeta.LASTDRILL_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InformationSystemVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InformationSystemVOMeta.DELETE_TIME)));
			this.setGrade(DataParser.parse(String.class, map.get(InformationSystemVOMeta.GRADE)));
			this.setName(DataParser.parse(String.class, map.get(InformationSystemVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InformationSystemVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InformationSystemVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(InformationSystemVOMeta.STATUS)));
			// others
			this.setInfoSystemStatus(DataParser.parse(DictItem.class, map.get(InformationSystemVOMeta.INFO_SYSTEM_STATUS)));
			this.setSearchField(DataParser.parse(String.class, map.get(InformationSystemVOMeta.SEARCH_FIELD)));
			this.setInfoSystemDevMethod(DataParser.parse(DictItem.class, map.get(InformationSystemVOMeta.INFO_SYSTEM_DEV_METHOD)));
			this.setInfoSystemGrade(DataParser.parse(DictItem.class, map.get(InformationSystemVOMeta.INFO_SYSTEM_GRADE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InformationSystemVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InformationSystemVOMeta.PAGE_SIZE)));
			this.setBelongOrganization(DataParser.parse(Organization.class, map.get(InformationSystemVOMeta.BELONG_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InformationSystemVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InformationSystemVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(InformationSystemVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InformationSystemVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InformationSystemVOMeta.QUERY_LOGIC)));
			this.setInfoSystemOpsMethod(DataParser.parse(DictItem.class, map.get(InformationSystemVOMeta.INFO_SYSTEM_OPS_METHOD)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InformationSystemVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setSameplaceBacupInfo( (String)map.get(InformationSystemVOMeta.SAMEPLACE_BACUP_INFO));
				this.setArchMethod( (String)map.get(InformationSystemVOMeta.ARCH_METHOD));
				this.setNotes( (String)map.get(InformationSystemVOMeta.NOTES));
				this.setAppInfo( (String)map.get(InformationSystemVOMeta.APP_INFO));
				this.setPid( (String)map.get(InformationSystemVOMeta.PID));
				this.setDevMethod( (String)map.get(InformationSystemVOMeta.DEV_METHOD));
				this.setTechnicalContact( (String)map.get(InformationSystemVOMeta.TECHNICAL_CONTACT));
				this.setOsInfo( (String)map.get(InformationSystemVOMeta.OS_INFO));
				this.setHardwareInfo( (String)map.get(InformationSystemVOMeta.HARDWARE_INFO));
				this.setUpdateBy( (String)map.get(InformationSystemVOMeta.UPDATE_BY));
				this.setId( (String)map.get(InformationSystemVOMeta.ID));
				this.setBackupInfo( (String)map.get(InformationSystemVOMeta.BACKUP_INFO));
				this.setDbInfo( (String)map.get(InformationSystemVOMeta.DB_INFO));
				this.setDiffplaceBackupInfo( (String)map.get(InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO));
				this.setAddress( (String)map.get(InformationSystemVOMeta.ADDRESS));
				this.setBelongOrgId( (String)map.get(InformationSystemVOMeta.BELONG_ORG_ID));
				this.setProfile( (String)map.get(InformationSystemVOMeta.PROFILE));
				this.setBusinessContact( (String)map.get(InformationSystemVOMeta.BUSINESS_CONTACT));
				this.setUpdateTime( (Date)map.get(InformationSystemVOMeta.UPDATE_TIME));
				this.setRto( (String)map.get(InformationSystemVOMeta.RTO));
				this.setVersion( (Integer)map.get(InformationSystemVOMeta.VERSION));
				this.setLabels( (String)map.get(InformationSystemVOMeta.LABELS));
				this.setOnlineDate( (Date)map.get(InformationSystemVOMeta.ONLINE_DATE));
				this.setRpo( (String)map.get(InformationSystemVOMeta.RPO));
				this.setCreateBy( (String)map.get(InformationSystemVOMeta.CREATE_BY));
				this.setOfflineDate( (Date)map.get(InformationSystemVOMeta.OFFLINE_DATE));
				this.setDeleted( (Integer)map.get(InformationSystemVOMeta.DELETED));
				this.setOpsMethod( (String)map.get(InformationSystemVOMeta.OPS_METHOD));
				this.setLastdrillDate( (Date)map.get(InformationSystemVOMeta.LASTDRILL_DATE));
				this.setCreateTime( (Date)map.get(InformationSystemVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InformationSystemVOMeta.DELETE_TIME));
				this.setGrade( (String)map.get(InformationSystemVOMeta.GRADE));
				this.setName( (String)map.get(InformationSystemVOMeta.NAME));
				this.setTenantId( (String)map.get(InformationSystemVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InformationSystemVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(InformationSystemVOMeta.STATUS));
				// others
				this.setInfoSystemStatus( (DictItem)map.get(InformationSystemVOMeta.INFO_SYSTEM_STATUS));
				this.setSearchField( (String)map.get(InformationSystemVOMeta.SEARCH_FIELD));
				this.setInfoSystemDevMethod( (DictItem)map.get(InformationSystemVOMeta.INFO_SYSTEM_DEV_METHOD));
				this.setInfoSystemGrade( (DictItem)map.get(InformationSystemVOMeta.INFO_SYSTEM_GRADE));
				this.setFuzzyField( (String)map.get(InformationSystemVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(InformationSystemVOMeta.PAGE_SIZE));
				this.setBelongOrganization( (Organization)map.get(InformationSystemVOMeta.BELONG_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(InformationSystemVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InformationSystemVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(InformationSystemVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(InformationSystemVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InformationSystemVOMeta.QUERY_LOGIC));
				this.setInfoSystemOpsMethod( (DictItem)map.get(InformationSystemVOMeta.INFO_SYSTEM_OPS_METHOD));
				this.setSearchValue( (String)map.get(InformationSystemVOMeta.SEARCH_VALUE));
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
			this.setSameplaceBacupInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.SAMEPLACE_BACUP_INFO)));
			this.setArchMethod(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.ARCH_METHOD)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.NOTES)));
			this.setAppInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.APP_INFO)));
			this.setPid(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.PID)));
			this.setDevMethod(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.DEV_METHOD)));
			this.setTechnicalContact(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.TECHNICAL_CONTACT)));
			this.setOsInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.OS_INFO)));
			this.setHardwareInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.HARDWARE_INFO)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.ID)));
			this.setBackupInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.BACKUP_INFO)));
			this.setDbInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.DB_INFO)));
			this.setDiffplaceBackupInfo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO)));
			this.setAddress(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.ADDRESS)));
			this.setBelongOrgId(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.BELONG_ORG_ID)));
			this.setProfile(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.PROFILE)));
			this.setBusinessContact(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.BUSINESS_CONTACT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InformationSystemVOMeta.UPDATE_TIME)));
			this.setRto(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.RTO)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InformationSystemVOMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.LABELS)));
			this.setOnlineDate(DataParser.parse(Date.class, r.getValue(InformationSystemVOMeta.ONLINE_DATE)));
			this.setRpo(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.RPO)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.CREATE_BY)));
			this.setOfflineDate(DataParser.parse(Date.class, r.getValue(InformationSystemVOMeta.OFFLINE_DATE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InformationSystemVOMeta.DELETED)));
			this.setOpsMethod(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.OPS_METHOD)));
			this.setLastdrillDate(DataParser.parse(Date.class, r.getValue(InformationSystemVOMeta.LASTDRILL_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InformationSystemVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InformationSystemVOMeta.DELETE_TIME)));
			this.setGrade(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.GRADE)));
			this.setName(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InformationSystemVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSameplaceBacupInfo( (String)r.getValue(InformationSystemVOMeta.SAMEPLACE_BACUP_INFO));
				this.setArchMethod( (String)r.getValue(InformationSystemVOMeta.ARCH_METHOD));
				this.setNotes( (String)r.getValue(InformationSystemVOMeta.NOTES));
				this.setAppInfo( (String)r.getValue(InformationSystemVOMeta.APP_INFO));
				this.setPid( (String)r.getValue(InformationSystemVOMeta.PID));
				this.setDevMethod( (String)r.getValue(InformationSystemVOMeta.DEV_METHOD));
				this.setTechnicalContact( (String)r.getValue(InformationSystemVOMeta.TECHNICAL_CONTACT));
				this.setOsInfo( (String)r.getValue(InformationSystemVOMeta.OS_INFO));
				this.setHardwareInfo( (String)r.getValue(InformationSystemVOMeta.HARDWARE_INFO));
				this.setUpdateBy( (String)r.getValue(InformationSystemVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(InformationSystemVOMeta.ID));
				this.setBackupInfo( (String)r.getValue(InformationSystemVOMeta.BACKUP_INFO));
				this.setDbInfo( (String)r.getValue(InformationSystemVOMeta.DB_INFO));
				this.setDiffplaceBackupInfo( (String)r.getValue(InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO));
				this.setAddress( (String)r.getValue(InformationSystemVOMeta.ADDRESS));
				this.setBelongOrgId( (String)r.getValue(InformationSystemVOMeta.BELONG_ORG_ID));
				this.setProfile( (String)r.getValue(InformationSystemVOMeta.PROFILE));
				this.setBusinessContact( (String)r.getValue(InformationSystemVOMeta.BUSINESS_CONTACT));
				this.setUpdateTime( (Date)r.getValue(InformationSystemVOMeta.UPDATE_TIME));
				this.setRto( (String)r.getValue(InformationSystemVOMeta.RTO));
				this.setVersion( (Integer)r.getValue(InformationSystemVOMeta.VERSION));
				this.setLabels( (String)r.getValue(InformationSystemVOMeta.LABELS));
				this.setOnlineDate( (Date)r.getValue(InformationSystemVOMeta.ONLINE_DATE));
				this.setRpo( (String)r.getValue(InformationSystemVOMeta.RPO));
				this.setCreateBy( (String)r.getValue(InformationSystemVOMeta.CREATE_BY));
				this.setOfflineDate( (Date)r.getValue(InformationSystemVOMeta.OFFLINE_DATE));
				this.setDeleted( (Integer)r.getValue(InformationSystemVOMeta.DELETED));
				this.setOpsMethod( (String)r.getValue(InformationSystemVOMeta.OPS_METHOD));
				this.setLastdrillDate( (Date)r.getValue(InformationSystemVOMeta.LASTDRILL_DATE));
				this.setCreateTime( (Date)r.getValue(InformationSystemVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InformationSystemVOMeta.DELETE_TIME));
				this.setGrade( (String)r.getValue(InformationSystemVOMeta.GRADE));
				this.setName( (String)r.getValue(InformationSystemVOMeta.NAME));
				this.setTenantId( (String)r.getValue(InformationSystemVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InformationSystemVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(InformationSystemVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}