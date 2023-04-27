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



/**
 * 软件资产VO类型
 * <p>软件资产 , 数据表 eam_asset_software 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 20:03:27
 * @sign 4506D0BBC2724FEB7CBD11EBAA7BE3E2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "软件资产VO类型 ; 软件资产 , 数据表 eam_asset_software 的通用VO类型" , parent = AssetSoftware.class)
public class AssetSoftwareVO extends AssetSoftware {

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
	public AssetSoftwareVO setPageIndex(Integer pageIndex) {
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
	public AssetSoftwareVO setPageSize(Integer pageSize) {
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
	public AssetSoftwareVO setSearchField(String searchField) {
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
	public AssetSoftwareVO setFuzzyField(String fuzzyField) {
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
	public AssetSoftwareVO setSearchValue(String searchValue) {
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
	public AssetSoftwareVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetSoftwareVO addDirtyField(String... dirtyField) {
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
	public AssetSoftwareVO setSortField(String sortField) {
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
	public AssetSoftwareVO setSortType(String sortType) {
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
	public AssetSoftwareVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetSoftwareVO addId(String... id) {
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
	 * @return AssetSoftwareVO , 转换好的 AssetSoftwareVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetSoftwareVO , 转换好的 PoJo 对象
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
	public AssetSoftwareVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetSoftwareVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetSoftwareVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetSoftwareVOMeta.$$proxy$$();
		inst.setSourceId(this.getSourceId());
		inst.setAuthorizationInfo(this.getAuthorizationInfo());
		inst.setAuthorizedNumberUnlimit(this.getAuthorizedNumberUnlimit());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setLabel4(this.getLabel4());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setAuthorizationExpirationDate(this.getAuthorizationExpirationDate());
		inst.setCtl(this.getCtl());
		inst.setId(this.getId());
		inst.setAuthorizedNumber(this.getAuthorizedNumber());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setNeedMaintenance(this.getNeedMaintenance());
		inst.setVersion(this.getVersion());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setSoftwareVersion(this.getSoftwareVersion());
		inst.setStatus(this.getStatus());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setChsVersion(this.getChsVersion());
		inst.setCode(this.getCode());
		inst.setLicenseMode(this.getLicenseMode());
		inst.setSupplierId(this.getSupplierId());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setAuthorizationCode(this.getAuthorizationCode());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setChsStatus(this.getChsStatus());
		inst.setCopyrightType(this.getCopyrightType());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setAuthorizationExpirationUnlimit(this.getAuthorizationExpirationUnlimit());
		inst.setRegisterDate(this.getRegisterDate());
		inst.setSummary(this.getSummary());
		inst.setCostPrice(this.getCostPrice());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setLabel1(this.getLabel1());
		inst.setLabel2(this.getLabel2());
		inst.setLabel3(this.getLabel3());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setSourceDetail(this.getSourceDetail());
		inst.setAuthorizedAvailableNumber(this.getAuthorizedAvailableNumber());
		inst.setCreateTime(this.getCreateTime());
		inst.setChsType(this.getChsType());
		inst.setTenantId(this.getTenantId());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setManager(this.getManager());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setSource(this.getSource());
			inst.setOriginator(this.getOriginator());
			inst.setMaintainer(this.getMaintainer());
			inst.setCopyrightTypeDict(this.getCopyrightTypeDict());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setLicenseModeDict(this.getLicenseModeDict());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setSupplier(this.getSupplier());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
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
	public AssetSoftwareVO clone(boolean deep) {
		return EntityContext.clone(AssetSoftwareVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetSoftwareVO
	 * @param assetSoftwareMap 包含实体信息的 Map 对象
	 * @return AssetSoftwareVO , 转换好的的 AssetSoftware 对象
	*/
	@Transient
	public static AssetSoftwareVO createFrom(Map<String,Object> assetSoftwareMap) {
		if(assetSoftwareMap==null) return null;
		AssetSoftwareVO vo = create();
		EntityContext.copyProperties(vo,assetSoftwareMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetSoftwareVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetSoftwareVO , 转换好的的 AssetSoftware 对象
	*/
	@Transient
	public static AssetSoftwareVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetSoftwareVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetSoftwareVO，等同于 new
	 * @return AssetSoftwareVO 对象
	*/
	@Transient
	public static AssetSoftwareVO create() {
		return new com.dt.platform.domain.eam.meta.AssetSoftwareVOMeta.$$proxy$$();
	}
}