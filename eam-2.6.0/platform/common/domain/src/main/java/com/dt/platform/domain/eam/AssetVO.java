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
import com.dt.platform.domain.eam.meta.AssetVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产VO类型
 * <p>资产 , 数据表 eam_asset 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 18:19:38
 * @sign C05127D02CE5B4FBBB8CDA17B7C59FAA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产VO类型 ; 资产 , 数据表 eam_asset 的通用VO类型" , parent = Asset.class)
public class AssetVO extends Asset {

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
	public AssetVO setPageIndex(Integer pageIndex) {
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
	public AssetVO setPageSize(Integer pageSize) {
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
	public AssetVO setSearchField(String searchField) {
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
	public AssetVO setFuzzyField(String fuzzyField) {
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
	public AssetVO setSearchValue(String searchValue) {
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
	public AssetVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetVO addDirtyField(String... dirtyField) {
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
	public AssetVO setSortField(String sortField) {
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
	public AssetVO setSortType(String sortType) {
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
	public AssetVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetVO addId(String... id) {
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
	 * @return AssetVO , 转换好的 AssetVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetVO , 转换好的 PoJo 对象
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
	public AssetVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetVOMeta.$$proxy$$();
		inst.setEquipmentCode(this.getEquipmentCode());
		inst.setCustomerInfo(this.getCustomerInfo());
		inst.setPurchaseUnitPrice(this.getPurchaseUnitPrice());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setNavPrice(this.getNavPrice());
		inst.setLabel4(this.getLabel4());
		inst.setLabel5(this.getLabel5());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setScrapId(this.getScrapId());
		inst.setEquipmentEnvironmentCode(this.getEquipmentEnvironmentCode());
		inst.setDirector(this.getDirector());
		inst.setMonthDepreciationPrice(this.getMonthDepreciationPrice());
		inst.setVersion(this.getVersion());
		inst.setSafetyLevelCode(this.getSafetyLevelCode());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setEntryTime(this.getEntryTime());
		inst.setManageIp(this.getManageIp());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFinancialNotes(this.getFinancialNotes());
		inst.setMaintenanceMethod(this.getMaintenanceMethod());
		inst.setFinancialOption(this.getFinancialOption());
		inst.setStatus(this.getStatus());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setRemainNumber(this.getRemainNumber());
		inst.setGoodsId(this.getGoodsId());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setEquipmentConf(this.getEquipmentConf());
		inst.setAssetNotes(this.getAssetNotes());
		inst.setOriginalUnitPrice(this.getOriginalUnitPrice());
		inst.setDepreciationId(this.getDepreciationId());
		inst.setPictureId(this.getPictureId());
		inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
		inst.setTotalAmountPrice(this.getTotalAmountPrice());
		inst.setServiceLife(this.getServiceLife());
		inst.setAttach(this.getAttach());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setCleanOut(this.getCleanOut());
		inst.setRackId(this.getRackId());
		inst.setDisplay(this.getDisplay());
		inst.setManufacturerId(this.getManufacturerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCategoryCode(this.getCategoryCode());
		inst.setManagerId(this.getManagerId());
		inst.setAccumulatedDepreciation(this.getAccumulatedDepreciation());
		inst.setLabel2(this.getLabel2());
		inst.setLabel3(this.getLabel3());
		inst.setAssetSelectedData(this.getAssetSelectedData());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setRfid(this.getRfid());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setLastVerificationDate(this.getLastVerificationDate());
		inst.setUseUserId(this.getUseUserId());
		inst.setContacts(this.getContacts());
		inst.setSourceId(this.getSourceId());
		inst.setProcId(this.getProcId());
		inst.setFinancialCategoryId(this.getFinancialCategoryId());
		inst.setMaintenancePrice(this.getMaintenancePrice());
		inst.setEquipmentIp(this.getEquipmentIp());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setDepreciationOperTime(this.getDepreciationOperTime());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setAssetCode(this.getAssetCode());
		inst.setSerialNumber(this.getSerialNumber());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setGoodsStockId(this.getGoodsStockId());
		inst.setTaxAmountRate(this.getTaxAmountRate());
		inst.setCurrentYearDepreciation(this.getCurrentYearDepreciation());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setEquipmentLabel(this.getEquipmentLabel());
		inst.setUnit(this.getUnit());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setBillId(this.getBillId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFinancialCode(this.getFinancialCode());
		inst.setRackUpNumber(this.getRackUpNumber());
		inst.setResidualsRate(this.getResidualsRate());
		inst.setAssetStatus(this.getAssetStatus());
		inst.setExpenseItem(this.getExpenseItem());
		inst.setChsVersion(this.getChsVersion());
		inst.setSupplierId(this.getSupplierId());
		inst.setPurpose(this.getPurpose());
		inst.setResidualsPrice(this.getResidualsPrice());
		inst.setInternalControlLabel(this.getInternalControlLabel());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setAssetUsedServiceLife(this.getAssetUsedServiceLife());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setChsStatus(this.getChsStatus());
		inst.setProductionDate(this.getProductionDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setCollectionId(this.getCollectionId());
		inst.setRegisterDate(this.getRegisterDate());
		inst.setSummary(this.getSummary());
		inst.setEquipmentSerialNumber(this.getEquipmentSerialNumber());
		inst.setBatchCode(this.getBatchCode());
		inst.setEquipmentCpu(this.getEquipmentCpu());
		inst.setEquipmentMemory(this.getEquipmentMemory());
		inst.setLabel(this.getLabel());
		inst.setEquipmentStatus(this.getEquipmentStatus());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setDepreciationYear(this.getDepreciationYear());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setTaxAmountPrice(this.getTaxAmountPrice());
		inst.setRegionId(this.getRegionId());
		inst.setChsType(this.getChsType());
		inst.setRackDownNumber(this.getRackDownNumber());
		inst.setBorrowId(this.getBorrowId());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
			inst.setSafetyLevel(this.getSafetyLevel());
			inst.setSearchField(this.getSearchField());
			inst.setCategoryFinance(this.getCategoryFinance());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoods(this.getGoods());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setSource(this.getSource());
			inst.setFinancialOptionDict(this.getFinancialOptionDict());
			inst.setManufacturer(this.getManufacturer());
			inst.setCatalogAttribute(this.getCatalogAttribute());
			inst.setExpenseItemDict(this.getExpenseItemDict());
			inst.setSupplier(this.getSupplier());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
			inst.setUseUser(this.getUseUser());
			inst.setEquipmentEnvironment(this.getEquipmentEnvironment());
			inst.setAssetCycleStatus(this.getAssetCycleStatus());
			inst.setRack(this.getRack());
			inst.setManager(this.getManager());
			inst.setWarehouse(this.getWarehouse());
			inst.setPcmData(this.getPcmData());
			inst.setGoodsStock(this.getGoodsStock());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setAssetCollection(this.getAssetCollection());
			inst.setChangeInstance(this.getChangeInstance());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setExtData(this.getExtData());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setIds(this.getIds());
			inst.setPosition(this.getPosition());
			inst.setAssetBorrow(this.getAssetBorrow());
			inst.setCategory(this.getCategory());
			inst.setRegion(this.getRegion());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetVO clone(boolean deep) {
		return EntityContext.clone(AssetVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetVO
	 * @param assetMap 包含实体信息的 Map 对象
	 * @return AssetVO , 转换好的的 Asset 对象
	*/
	@Transient
	public static AssetVO createFrom(Map<String,Object> assetMap) {
		if(assetMap==null) return null;
		AssetVO vo = create();
		EntityContext.copyProperties(vo,assetMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetVO , 转换好的的 Asset 对象
	*/
	@Transient
	public static AssetVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetVO，等同于 new
	 * @return AssetVO 对象
	*/
	@Transient
	public static AssetVO create() {
		return new com.dt.platform.domain.eam.meta.AssetVOMeta.$$proxy$$();
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
			this.setEquipmentCode(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_CODE)));
			this.setCustomerInfo(DataParser.parse(String.class, map.get(AssetVOMeta.CUSTOMER_INFO)));
			this.setPurchaseUnitPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.PURCHASE_UNIT_PRICE)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetVOMeta.APPROVAL_OPINION)));
			this.setMaintenanceStatus(DataParser.parse(String.class, map.get(AssetVOMeta.MAINTENANCE_STATUS)));
			this.setNavPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.NAV_PRICE)));
			this.setLabel4(DataParser.parse(String.class, map.get(AssetVOMeta.LABEL4)));
			this.setLabel5(DataParser.parse(String.class, map.get(AssetVOMeta.LABEL5)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetVOMeta.BUSINESS_CODE)));
			this.setAssetNumber(DataParser.parse(Integer.class, map.get(AssetVOMeta.ASSET_NUMBER)));
			this.setModel(DataParser.parse(String.class, map.get(AssetVOMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(AssetVOMeta.ID)));
			this.setScrapId(DataParser.parse(String.class, map.get(AssetVOMeta.SCRAP_ID)));
			this.setEquipmentEnvironmentCode(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE)));
			this.setDirector(DataParser.parse(String.class, map.get(AssetVOMeta.DIRECTOR)));
			this.setMonthDepreciationPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.MONTH_DEPRECIATION_PRICE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetVOMeta.VERSION)));
			this.setSafetyLevelCode(DataParser.parse(String.class, map.get(AssetVOMeta.SAFETY_LEVEL_CODE)));
			this.setMaintainerId(DataParser.parse(String.class, map.get(AssetVOMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, map.get(AssetVOMeta.MAINTENANCE_NOTES)));
			this.setEntryTime(DataParser.parse(Date.class, map.get(AssetVOMeta.ENTRY_TIME)));
			this.setManageIp(DataParser.parse(String.class, map.get(AssetVOMeta.MANAGE_IP)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetVOMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetVOMeta.DELETE_TIME)));
			this.setFinancialNotes(DataParser.parse(String.class, map.get(AssetVOMeta.FINANCIAL_NOTES)));
			this.setMaintenanceMethod(DataParser.parse(String.class, map.get(AssetVOMeta.MAINTENANCE_METHOD)));
			this.setFinancialOption(DataParser.parse(String.class, map.get(AssetVOMeta.FINANCIAL_OPTION)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetVOMeta.STATUS)));
			this.setPurchaseDate(DataParser.parse(Date.class, map.get(AssetVOMeta.PURCHASE_DATE)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetVOMeta.OWNER_CODE)));
			this.setRemainNumber(DataParser.parse(Integer.class, map.get(AssetVOMeta.REMAIN_NUMBER)));
			this.setGoodsId(DataParser.parse(String.class, map.get(AssetVOMeta.GOODS_ID)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetVOMeta.CHANGE_INSTANCE_ID)));
			this.setEquipmentConf(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_CONF)));
			this.setAssetNotes(DataParser.parse(String.class, map.get(AssetVOMeta.ASSET_NOTES)));
			this.setOriginalUnitPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.ORIGINAL_UNIT_PRICE)));
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetVOMeta.DEPRECIATION_ID)));
			this.setPictureId(DataParser.parse(String.class, map.get(AssetVOMeta.PICTURE_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetVOMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setTotalAmountPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.TOTAL_AMOUNT_PRICE)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.SERVICE_LIFE)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetVOMeta.ATTACH)));
			this.setMaintainerName(DataParser.parse(String.class, map.get(AssetVOMeta.MAINTAINER_NAME)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetVOMeta.ORIGINATOR_ID)));
			this.setCleanOut(DataParser.parse(String.class, map.get(AssetVOMeta.CLEAN_OUT)));
			this.setRackId(DataParser.parse(String.class, map.get(AssetVOMeta.RACK_ID)));
			this.setDisplay(DataParser.parse(String.class, map.get(AssetVOMeta.DISPLAY)));
			this.setManufacturerId(DataParser.parse(String.class, map.get(AssetVOMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetVOMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, map.get(AssetVOMeta.CATEGORY_CODE)));
			this.setManagerId(DataParser.parse(String.class, map.get(AssetVOMeta.MANAGER_ID)));
			this.setAccumulatedDepreciation(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.ACCUMULATED_DEPRECIATION)));
			this.setLabel2(DataParser.parse(String.class, map.get(AssetVOMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, map.get(AssetVOMeta.LABEL3)));
			this.setAssetSelectedData(DataParser.parse(String.class, map.get(AssetVOMeta.ASSET_SELECTED_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(AssetVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetVOMeta.TENANT_ID)));
			this.setRfid(DataParser.parse(String.class, map.get(AssetVOMeta.RFID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, map.get(AssetVOMeta.MAINTENANCE_START_DATE)));
			this.setLastVerificationDate(DataParser.parse(Date.class, map.get(AssetVOMeta.LAST_VERIFICATION_DATE)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetVOMeta.USE_USER_ID)));
			this.setContacts(DataParser.parse(String.class, map.get(AssetVOMeta.CONTACTS)));
			this.setSourceId(DataParser.parse(String.class, map.get(AssetVOMeta.SOURCE_ID)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetVOMeta.PROC_ID)));
			this.setFinancialCategoryId(DataParser.parse(String.class, map.get(AssetVOMeta.FINANCIAL_CATEGORY_ID)));
			this.setMaintenancePrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.MAINTENANCE_PRICE)));
			this.setEquipmentIp(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_IP)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, map.get(AssetVOMeta.MAINTENANCE_END_DATE)));
			this.setDepreciationOperTime(DataParser.parse(Date.class, map.get(AssetVOMeta.DEPRECIATION_OPER_TIME)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetVOMeta.NEXT_APPROVER_NAMES)));
			this.setAssetCode(DataParser.parse(String.class, map.get(AssetVOMeta.ASSET_CODE)));
			this.setSerialNumber(DataParser.parse(String.class, map.get(AssetVOMeta.SERIAL_NUMBER)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetVOMeta.LATEST_APPROVER_ID)));
			this.setGoodsStockId(DataParser.parse(String.class, map.get(AssetVOMeta.GOODS_STOCK_ID)));
			this.setTaxAmountRate(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.TAX_AMOUNT_RATE)));
			this.setCurrentYearDepreciation(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.CURRENT_YEAR_DEPRECIATION)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetVOMeta.USE_ORGANIZATION_ID)));
			this.setEquipmentLabel(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_LABEL)));
			this.setUnit(DataParser.parse(String.class, map.get(AssetVOMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetVOMeta.OWN_COMPANY_ID)));
			this.setBillId(DataParser.parse(String.class, map.get(AssetVOMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, map.get(AssetVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetVOMeta.DELETE_BY)));
			this.setFinancialCode(DataParser.parse(String.class, map.get(AssetVOMeta.FINANCIAL_CODE)));
			this.setRackUpNumber(DataParser.parse(Integer.class, map.get(AssetVOMeta.RACK_UP_NUMBER)));
			this.setResidualsRate(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.RESIDUALS_RATE)));
			this.setAssetStatus(DataParser.parse(String.class, map.get(AssetVOMeta.ASSET_STATUS)));
			this.setExpenseItem(DataParser.parse(String.class, map.get(AssetVOMeta.EXPENSE_ITEM)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetVOMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, map.get(AssetVOMeta.SUPPLIER_ID)));
			this.setPurpose(DataParser.parse(String.class, map.get(AssetVOMeta.PURPOSE)));
			this.setResidualsPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.RESIDUALS_PRICE)));
			this.setInternalControlLabel(DataParser.parse(String.class, map.get(AssetVOMeta.INTERNAL_CONTROL_LABEL)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetVOMeta.LATEST_APPROVER_NAME)));
			this.setAssetUsedServiceLife(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.ASSET_USED_SERVICE_LIFE)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetVOMeta.NEXT_APPROVER_IDS)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetVOMeta.CHS_STATUS)));
			this.setProductionDate(DataParser.parse(Date.class, map.get(AssetVOMeta.PRODUCTION_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetVOMeta.UPDATE_BY)));
			this.setCollectionId(DataParser.parse(String.class, map.get(AssetVOMeta.COLLECTION_ID)));
			this.setRegisterDate(DataParser.parse(Date.class, map.get(AssetVOMeta.REGISTER_DATE)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetVOMeta.SUMMARY)));
			this.setEquipmentSerialNumber(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_SERIAL_NUMBER)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AssetVOMeta.BATCH_CODE)));
			this.setEquipmentCpu(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_CPU)));
			this.setEquipmentMemory(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_MEMORY)));
			this.setLabel(DataParser.parse(String.class, map.get(AssetVOMeta.LABEL)));
			this.setEquipmentStatus(DataParser.parse(String.class, map.get(AssetVOMeta.EQUIPMENT_STATUS)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetVOMeta.POSITION_DETAIL)));
			this.setDepreciationYear(DataParser.parse(Integer.class, map.get(AssetVOMeta.DEPRECIATION_YEAR)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(AssetVOMeta.CONTACT_INFORMATION)));
			this.setTaxAmountPrice(DataParser.parse(BigDecimal.class, map.get(AssetVOMeta.TAX_AMOUNT_PRICE)));
			this.setRegionId(DataParser.parse(String.class, map.get(AssetVOMeta.REGION_ID)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetVOMeta.CHS_TYPE)));
			this.setRackDownNumber(DataParser.parse(Integer.class, map.get(AssetVOMeta.RACK_DOWN_NUMBER)));
			this.setBorrowId(DataParser.parse(String.class, map.get(AssetVOMeta.BORROW_ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(AssetVOMeta.CATEGORY_ID)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetVOMeta.OWNER_COMPANY)));
			this.setSuggestMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetVOMeta.SUGGEST_MAINTENANCE_METHOD_DATA)));
			this.setSafetyLevel(DataParser.parse(DictItem.class, map.get(AssetVOMeta.SAFETY_LEVEL)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetVOMeta.SEARCH_FIELD)));
			this.setCategoryFinance(DataParser.parse(CategoryFinance.class, map.get(AssetVOMeta.CATEGORY_FINANCE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetVOMeta.FUZZY_FIELD)));
			this.setGoods(DataParser.parse(Goods.class, map.get(AssetVOMeta.GOODS)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetVOMeta.ORIGINATOR)));
			this.setSource(DataParser.parse(DictItem.class, map.get(AssetVOMeta.SOURCE)));
			this.setFinancialOptionDict(DataParser.parse(DictItem.class, map.get(AssetVOMeta.FINANCIAL_OPTION_DICT)));
			this.setManufacturer(DataParser.parse(Manufacturer.class, map.get(AssetVOMeta.MANUFACTURER)));
			this.setExpenseItemDict(DataParser.parse(DictItem.class, map.get(AssetVOMeta.EXPENSE_ITEM_DICT)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(AssetVOMeta.SUPPLIER)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetVOMeta.SORT_FIELD)));
			this.setMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetVOMeta.MAINTENANCE_METHOD_DATA)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(AssetVOMeta.USE_USER)));
			this.setEquipmentEnvironment(DataParser.parse(DictItem.class, map.get(AssetVOMeta.EQUIPMENT_ENVIRONMENT)));
			this.setAssetCycleStatus(DataParser.parse(AssetStatus.class, map.get(AssetVOMeta.ASSET_CYCLE_STATUS)));
			this.setRack(DataParser.parse(AssetRack.class, map.get(AssetVOMeta.RACK)));
			this.setManager(DataParser.parse(Employee.class, map.get(AssetVOMeta.MANAGER)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetVOMeta.WAREHOUSE)));
			this.setGoodsStock(DataParser.parse(GoodsStock.class, map.get(AssetVOMeta.GOODS_STOCK)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetVOMeta.USE_ORGANIZATION)));
			this.setAssetCollection(DataParser.parse(AssetCollection.class, map.get(AssetVOMeta.ASSET_COLLECTION)));
			this.setChangeInstance(DataParser.parse(ChangeInstance.class, map.get(AssetVOMeta.CHANGE_INSTANCE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetVOMeta.SORT_TYPE)));
			this.setExtData(DataParser.parse(AssetExtData.class, map.get(AssetVOMeta.EXT_DATA)));
			this.setMaintnainer(DataParser.parse(Maintainer.class, map.get(AssetVOMeta.MAINTNAINER)));
			this.setAssetMaintenanceStatus(DataParser.parse(DictItem.class, map.get(AssetVOMeta.ASSET_MAINTENANCE_STATUS)));
			this.setPosition(DataParser.parse(Position.class, map.get(AssetVOMeta.POSITION)));
			this.setAssetBorrow(DataParser.parse(AssetBorrow.class, map.get(AssetVOMeta.ASSET_BORROW)));
			this.setCategory(DataParser.parse(Catalog.class, map.get(AssetVOMeta.CATEGORY)));
			this.setRegion(DataParser.parse(AssetRegion.class, map.get(AssetVOMeta.REGION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setEquipmentCode( (String)map.get(AssetVOMeta.EQUIPMENT_CODE));
				this.setCustomerInfo( (String)map.get(AssetVOMeta.CUSTOMER_INFO));
				this.setPurchaseUnitPrice( (BigDecimal)map.get(AssetVOMeta.PURCHASE_UNIT_PRICE));
				this.setApprovalOpinion( (String)map.get(AssetVOMeta.APPROVAL_OPINION));
				this.setMaintenanceStatus( (String)map.get(AssetVOMeta.MAINTENANCE_STATUS));
				this.setNavPrice( (BigDecimal)map.get(AssetVOMeta.NAV_PRICE));
				this.setLabel4( (String)map.get(AssetVOMeta.LABEL4));
				this.setLabel5( (String)map.get(AssetVOMeta.LABEL5));
				this.setBusinessCode( (String)map.get(AssetVOMeta.BUSINESS_CODE));
				this.setAssetNumber( (Integer)map.get(AssetVOMeta.ASSET_NUMBER));
				this.setModel( (String)map.get(AssetVOMeta.MODEL));
				this.setId( (String)map.get(AssetVOMeta.ID));
				this.setScrapId( (String)map.get(AssetVOMeta.SCRAP_ID));
				this.setEquipmentEnvironmentCode( (String)map.get(AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE));
				this.setDirector( (String)map.get(AssetVOMeta.DIRECTOR));
				this.setMonthDepreciationPrice( (BigDecimal)map.get(AssetVOMeta.MONTH_DEPRECIATION_PRICE));
				this.setVersion( (Integer)map.get(AssetVOMeta.VERSION));
				this.setSafetyLevelCode( (String)map.get(AssetVOMeta.SAFETY_LEVEL_CODE));
				this.setMaintainerId( (String)map.get(AssetVOMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)map.get(AssetVOMeta.MAINTENANCE_NOTES));
				this.setEntryTime( (Date)map.get(AssetVOMeta.ENTRY_TIME));
				this.setManageIp( (String)map.get(AssetVOMeta.MANAGE_IP));
				this.setWarehouseId( (String)map.get(AssetVOMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)map.get(AssetVOMeta.DELETE_TIME));
				this.setFinancialNotes( (String)map.get(AssetVOMeta.FINANCIAL_NOTES));
				this.setMaintenanceMethod( (String)map.get(AssetVOMeta.MAINTENANCE_METHOD));
				this.setFinancialOption( (String)map.get(AssetVOMeta.FINANCIAL_OPTION));
				this.setStatus( (String)map.get(AssetVOMeta.STATUS));
				this.setPurchaseDate( (Date)map.get(AssetVOMeta.PURCHASE_DATE));
				this.setOwnerCode( (String)map.get(AssetVOMeta.OWNER_CODE));
				this.setRemainNumber( (Integer)map.get(AssetVOMeta.REMAIN_NUMBER));
				this.setGoodsId( (String)map.get(AssetVOMeta.GOODS_ID));
				this.setChangeInstanceId( (String)map.get(AssetVOMeta.CHANGE_INSTANCE_ID));
				this.setEquipmentConf( (String)map.get(AssetVOMeta.EQUIPMENT_CONF));
				this.setAssetNotes( (String)map.get(AssetVOMeta.ASSET_NOTES));
				this.setOriginalUnitPrice( (BigDecimal)map.get(AssetVOMeta.ORIGINAL_UNIT_PRICE));
				this.setDepreciationId( (String)map.get(AssetVOMeta.DEPRECIATION_ID));
				this.setPictureId( (String)map.get(AssetVOMeta.PICTURE_ID));
				this.setSuggestMaintenanceMethod( (String)map.get(AssetVOMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setTotalAmountPrice( (BigDecimal)map.get(AssetVOMeta.TOTAL_AMOUNT_PRICE));
				this.setServiceLife( (BigDecimal)map.get(AssetVOMeta.SERVICE_LIFE));
				this.setAttach( (String)map.get(AssetVOMeta.ATTACH));
				this.setMaintainerName( (String)map.get(AssetVOMeta.MAINTAINER_NAME));
				this.setOriginatorId( (String)map.get(AssetVOMeta.ORIGINATOR_ID));
				this.setCleanOut( (String)map.get(AssetVOMeta.CLEAN_OUT));
				this.setRackId( (String)map.get(AssetVOMeta.RACK_ID));
				this.setDisplay( (String)map.get(AssetVOMeta.DISPLAY));
				this.setManufacturerId( (String)map.get(AssetVOMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)map.get(AssetVOMeta.UPDATE_TIME));
				this.setCategoryCode( (String)map.get(AssetVOMeta.CATEGORY_CODE));
				this.setManagerId( (String)map.get(AssetVOMeta.MANAGER_ID));
				this.setAccumulatedDepreciation( (BigDecimal)map.get(AssetVOMeta.ACCUMULATED_DEPRECIATION));
				this.setLabel2( (String)map.get(AssetVOMeta.LABEL2));
				this.setLabel3( (String)map.get(AssetVOMeta.LABEL3));
				this.setAssetSelectedData( (String)map.get(AssetVOMeta.ASSET_SELECTED_DATA));
				this.setDeleted( (Integer)map.get(AssetVOMeta.DELETED));
				this.setPositionId( (String)map.get(AssetVOMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(AssetVOMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(AssetVOMeta.TENANT_ID));
				this.setRfid( (String)map.get(AssetVOMeta.RFID));
				this.setMaintenanceStartDate( (Date)map.get(AssetVOMeta.MAINTENANCE_START_DATE));
				this.setLastVerificationDate( (Date)map.get(AssetVOMeta.LAST_VERIFICATION_DATE));
				this.setUseUserId( (String)map.get(AssetVOMeta.USE_USER_ID));
				this.setContacts( (String)map.get(AssetVOMeta.CONTACTS));
				this.setSourceId( (String)map.get(AssetVOMeta.SOURCE_ID));
				this.setProcId( (String)map.get(AssetVOMeta.PROC_ID));
				this.setFinancialCategoryId( (String)map.get(AssetVOMeta.FINANCIAL_CATEGORY_ID));
				this.setMaintenancePrice( (BigDecimal)map.get(AssetVOMeta.MAINTENANCE_PRICE));
				this.setEquipmentIp( (String)map.get(AssetVOMeta.EQUIPMENT_IP));
				this.setMaintenanceEndDate( (Date)map.get(AssetVOMeta.MAINTENANCE_END_DATE));
				this.setDepreciationOperTime( (Date)map.get(AssetVOMeta.DEPRECIATION_OPER_TIME));
				this.setNextApproverNames( (String)map.get(AssetVOMeta.NEXT_APPROVER_NAMES));
				this.setAssetCode( (String)map.get(AssetVOMeta.ASSET_CODE));
				this.setSerialNumber( (String)map.get(AssetVOMeta.SERIAL_NUMBER));
				this.setLatestApproverId( (String)map.get(AssetVOMeta.LATEST_APPROVER_ID));
				this.setGoodsStockId( (String)map.get(AssetVOMeta.GOODS_STOCK_ID));
				this.setTaxAmountRate( (BigDecimal)map.get(AssetVOMeta.TAX_AMOUNT_RATE));
				this.setCurrentYearDepreciation( (BigDecimal)map.get(AssetVOMeta.CURRENT_YEAR_DEPRECIATION));
				this.setUseOrganizationId( (String)map.get(AssetVOMeta.USE_ORGANIZATION_ID));
				this.setEquipmentLabel( (String)map.get(AssetVOMeta.EQUIPMENT_LABEL));
				this.setUnit( (String)map.get(AssetVOMeta.UNIT));
				this.setOwnCompanyId( (String)map.get(AssetVOMeta.OWN_COMPANY_ID));
				this.setBillId( (String)map.get(AssetVOMeta.BILL_ID));
				this.setName( (String)map.get(AssetVOMeta.NAME));
				this.setDeleteBy( (String)map.get(AssetVOMeta.DELETE_BY));
				this.setFinancialCode( (String)map.get(AssetVOMeta.FINANCIAL_CODE));
				this.setRackUpNumber( (Integer)map.get(AssetVOMeta.RACK_UP_NUMBER));
				this.setResidualsRate( (BigDecimal)map.get(AssetVOMeta.RESIDUALS_RATE));
				this.setAssetStatus( (String)map.get(AssetVOMeta.ASSET_STATUS));
				this.setExpenseItem( (String)map.get(AssetVOMeta.EXPENSE_ITEM));
				this.setChsVersion( (String)map.get(AssetVOMeta.CHS_VERSION));
				this.setSupplierId( (String)map.get(AssetVOMeta.SUPPLIER_ID));
				this.setPurpose( (String)map.get(AssetVOMeta.PURPOSE));
				this.setResidualsPrice( (BigDecimal)map.get(AssetVOMeta.RESIDUALS_PRICE));
				this.setInternalControlLabel( (String)map.get(AssetVOMeta.INTERNAL_CONTROL_LABEL));
				this.setLatestApproverName( (String)map.get(AssetVOMeta.LATEST_APPROVER_NAME));
				this.setAssetUsedServiceLife( (BigDecimal)map.get(AssetVOMeta.ASSET_USED_SERVICE_LIFE));
				this.setNextApproverIds( (String)map.get(AssetVOMeta.NEXT_APPROVER_IDS));
				this.setChsStatus( (String)map.get(AssetVOMeta.CHS_STATUS));
				this.setProductionDate( (Date)map.get(AssetVOMeta.PRODUCTION_DATE));
				this.setUpdateBy( (String)map.get(AssetVOMeta.UPDATE_BY));
				this.setCollectionId( (String)map.get(AssetVOMeta.COLLECTION_ID));
				this.setRegisterDate( (Date)map.get(AssetVOMeta.REGISTER_DATE));
				this.setSummary( (String)map.get(AssetVOMeta.SUMMARY));
				this.setEquipmentSerialNumber( (String)map.get(AssetVOMeta.EQUIPMENT_SERIAL_NUMBER));
				this.setBatchCode( (String)map.get(AssetVOMeta.BATCH_CODE));
				this.setEquipmentCpu( (String)map.get(AssetVOMeta.EQUIPMENT_CPU));
				this.setEquipmentMemory( (String)map.get(AssetVOMeta.EQUIPMENT_MEMORY));
				this.setLabel( (String)map.get(AssetVOMeta.LABEL));
				this.setEquipmentStatus( (String)map.get(AssetVOMeta.EQUIPMENT_STATUS));
				this.setPositionDetail( (String)map.get(AssetVOMeta.POSITION_DETAIL));
				this.setDepreciationYear( (Integer)map.get(AssetVOMeta.DEPRECIATION_YEAR));
				this.setCreateBy( (String)map.get(AssetVOMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(AssetVOMeta.CONTACT_INFORMATION));
				this.setTaxAmountPrice( (BigDecimal)map.get(AssetVOMeta.TAX_AMOUNT_PRICE));
				this.setRegionId( (String)map.get(AssetVOMeta.REGION_ID));
				this.setChsType( (String)map.get(AssetVOMeta.CHS_TYPE));
				this.setRackDownNumber( (Integer)map.get(AssetVOMeta.RACK_DOWN_NUMBER));
				this.setBorrowId( (String)map.get(AssetVOMeta.BORROW_ID));
				this.setCategoryId( (String)map.get(AssetVOMeta.CATEGORY_ID));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetVOMeta.OWNER_COMPANY));
				this.setSuggestMaintenanceMethodData( (DictItem)map.get(AssetVOMeta.SUGGEST_MAINTENANCE_METHOD_DATA));
				this.setSafetyLevel( (DictItem)map.get(AssetVOMeta.SAFETY_LEVEL));
				this.setSearchField( (String)map.get(AssetVOMeta.SEARCH_FIELD));
				this.setCategoryFinance( (CategoryFinance)map.get(AssetVOMeta.CATEGORY_FINANCE));
				this.setFuzzyField( (String)map.get(AssetVOMeta.FUZZY_FIELD));
				this.setGoods( (Goods)map.get(AssetVOMeta.GOODS));
				this.setPageSize( (Integer)map.get(AssetVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetVOMeta.ORIGINATOR));
				this.setSource( (DictItem)map.get(AssetVOMeta.SOURCE));
				this.setFinancialOptionDict( (DictItem)map.get(AssetVOMeta.FINANCIAL_OPTION_DICT));
				this.setManufacturer( (Manufacturer)map.get(AssetVOMeta.MANUFACTURER));
				this.setExpenseItemDict( (DictItem)map.get(AssetVOMeta.EXPENSE_ITEM_DICT));
				this.setSupplier( (Supplier)map.get(AssetVOMeta.SUPPLIER));
				this.setSortField( (String)map.get(AssetVOMeta.SORT_FIELD));
				this.setMaintenanceMethodData( (DictItem)map.get(AssetVOMeta.MAINTENANCE_METHOD_DATA));
				this.setUseUser( (Employee)map.get(AssetVOMeta.USE_USER));
				this.setEquipmentEnvironment( (DictItem)map.get(AssetVOMeta.EQUIPMENT_ENVIRONMENT));
				this.setAssetCycleStatus( (AssetStatus)map.get(AssetVOMeta.ASSET_CYCLE_STATUS));
				this.setRack( (AssetRack)map.get(AssetVOMeta.RACK));
				this.setManager( (Employee)map.get(AssetVOMeta.MANAGER));
				this.setWarehouse( (Warehouse)map.get(AssetVOMeta.WAREHOUSE));
				this.setGoodsStock( (GoodsStock)map.get(AssetVOMeta.GOODS_STOCK));
				this.setUseOrganization( (Organization)map.get(AssetVOMeta.USE_ORGANIZATION));
				this.setAssetCollection( (AssetCollection)map.get(AssetVOMeta.ASSET_COLLECTION));
				this.setChangeInstance( (ChangeInstance)map.get(AssetVOMeta.CHANGE_INSTANCE));
				this.setPageIndex( (Integer)map.get(AssetVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetVOMeta.SORT_TYPE));
				this.setExtData( (AssetExtData)map.get(AssetVOMeta.EXT_DATA));
				this.setMaintnainer( (Maintainer)map.get(AssetVOMeta.MAINTNAINER));
				this.setAssetMaintenanceStatus( (DictItem)map.get(AssetVOMeta.ASSET_MAINTENANCE_STATUS));
				this.setPosition( (Position)map.get(AssetVOMeta.POSITION));
				this.setAssetBorrow( (AssetBorrow)map.get(AssetVOMeta.ASSET_BORROW));
				this.setCategory( (Catalog)map.get(AssetVOMeta.CATEGORY));
				this.setRegion( (AssetRegion)map.get(AssetVOMeta.REGION));
				this.setSearchValue( (String)map.get(AssetVOMeta.SEARCH_VALUE));
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
			this.setEquipmentCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_CODE)));
			this.setCustomerInfo(DataParser.parse(String.class, r.getValue(AssetVOMeta.CUSTOMER_INFO)));
			this.setPurchaseUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.PURCHASE_UNIT_PRICE)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetVOMeta.APPROVAL_OPINION)));
			this.setMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetVOMeta.MAINTENANCE_STATUS)));
			this.setNavPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.NAV_PRICE)));
			this.setLabel4(DataParser.parse(String.class, r.getValue(AssetVOMeta.LABEL4)));
			this.setLabel5(DataParser.parse(String.class, r.getValue(AssetVOMeta.LABEL5)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.BUSINESS_CODE)));
			this.setAssetNumber(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.ASSET_NUMBER)));
			this.setModel(DataParser.parse(String.class, r.getValue(AssetVOMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetVOMeta.ID)));
			this.setScrapId(DataParser.parse(String.class, r.getValue(AssetVOMeta.SCRAP_ID)));
			this.setEquipmentEnvironmentCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE)));
			this.setDirector(DataParser.parse(String.class, r.getValue(AssetVOMeta.DIRECTOR)));
			this.setMonthDepreciationPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.MONTH_DEPRECIATION_PRICE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.VERSION)));
			this.setSafetyLevelCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.SAFETY_LEVEL_CODE)));
			this.setMaintainerId(DataParser.parse(String.class, r.getValue(AssetVOMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetVOMeta.MAINTENANCE_NOTES)));
			this.setEntryTime(DataParser.parse(Date.class, r.getValue(AssetVOMeta.ENTRY_TIME)));
			this.setManageIp(DataParser.parse(String.class, r.getValue(AssetVOMeta.MANAGE_IP)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetVOMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetVOMeta.DELETE_TIME)));
			this.setFinancialNotes(DataParser.parse(String.class, r.getValue(AssetVOMeta.FINANCIAL_NOTES)));
			this.setMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetVOMeta.MAINTENANCE_METHOD)));
			this.setFinancialOption(DataParser.parse(String.class, r.getValue(AssetVOMeta.FINANCIAL_OPTION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetVOMeta.STATUS)));
			this.setPurchaseDate(DataParser.parse(Date.class, r.getValue(AssetVOMeta.PURCHASE_DATE)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.OWNER_CODE)));
			this.setRemainNumber(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.REMAIN_NUMBER)));
			this.setGoodsId(DataParser.parse(String.class, r.getValue(AssetVOMeta.GOODS_ID)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetVOMeta.CHANGE_INSTANCE_ID)));
			this.setEquipmentConf(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_CONF)));
			this.setAssetNotes(DataParser.parse(String.class, r.getValue(AssetVOMeta.ASSET_NOTES)));
			this.setOriginalUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.ORIGINAL_UNIT_PRICE)));
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetVOMeta.DEPRECIATION_ID)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(AssetVOMeta.PICTURE_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetVOMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setTotalAmountPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.TOTAL_AMOUNT_PRICE)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.SERVICE_LIFE)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetVOMeta.ATTACH)));
			this.setMaintainerName(DataParser.parse(String.class, r.getValue(AssetVOMeta.MAINTAINER_NAME)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetVOMeta.ORIGINATOR_ID)));
			this.setCleanOut(DataParser.parse(String.class, r.getValue(AssetVOMeta.CLEAN_OUT)));
			this.setRackId(DataParser.parse(String.class, r.getValue(AssetVOMeta.RACK_ID)));
			this.setDisplay(DataParser.parse(String.class, r.getValue(AssetVOMeta.DISPLAY)));
			this.setManufacturerId(DataParser.parse(String.class, r.getValue(AssetVOMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetVOMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.CATEGORY_CODE)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(AssetVOMeta.MANAGER_ID)));
			this.setAccumulatedDepreciation(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.ACCUMULATED_DEPRECIATION)));
			this.setLabel2(DataParser.parse(String.class, r.getValue(AssetVOMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, r.getValue(AssetVOMeta.LABEL3)));
			this.setAssetSelectedData(DataParser.parse(String.class, r.getValue(AssetVOMeta.ASSET_SELECTED_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(AssetVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetVOMeta.TENANT_ID)));
			this.setRfid(DataParser.parse(String.class, r.getValue(AssetVOMeta.RFID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, r.getValue(AssetVOMeta.MAINTENANCE_START_DATE)));
			this.setLastVerificationDate(DataParser.parse(Date.class, r.getValue(AssetVOMeta.LAST_VERIFICATION_DATE)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetVOMeta.USE_USER_ID)));
			this.setContacts(DataParser.parse(String.class, r.getValue(AssetVOMeta.CONTACTS)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(AssetVOMeta.SOURCE_ID)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetVOMeta.PROC_ID)));
			this.setFinancialCategoryId(DataParser.parse(String.class, r.getValue(AssetVOMeta.FINANCIAL_CATEGORY_ID)));
			this.setMaintenancePrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.MAINTENANCE_PRICE)));
			this.setEquipmentIp(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_IP)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, r.getValue(AssetVOMeta.MAINTENANCE_END_DATE)));
			this.setDepreciationOperTime(DataParser.parse(Date.class, r.getValue(AssetVOMeta.DEPRECIATION_OPER_TIME)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetVOMeta.NEXT_APPROVER_NAMES)));
			this.setAssetCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.ASSET_CODE)));
			this.setSerialNumber(DataParser.parse(String.class, r.getValue(AssetVOMeta.SERIAL_NUMBER)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetVOMeta.LATEST_APPROVER_ID)));
			this.setGoodsStockId(DataParser.parse(String.class, r.getValue(AssetVOMeta.GOODS_STOCK_ID)));
			this.setTaxAmountRate(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.TAX_AMOUNT_RATE)));
			this.setCurrentYearDepreciation(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.CURRENT_YEAR_DEPRECIATION)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetVOMeta.USE_ORGANIZATION_ID)));
			this.setEquipmentLabel(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_LABEL)));
			this.setUnit(DataParser.parse(String.class, r.getValue(AssetVOMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetVOMeta.OWN_COMPANY_ID)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssetVOMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetVOMeta.DELETE_BY)));
			this.setFinancialCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.FINANCIAL_CODE)));
			this.setRackUpNumber(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.RACK_UP_NUMBER)));
			this.setResidualsRate(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.RESIDUALS_RATE)));
			this.setAssetStatus(DataParser.parse(String.class, r.getValue(AssetVOMeta.ASSET_STATUS)));
			this.setExpenseItem(DataParser.parse(String.class, r.getValue(AssetVOMeta.EXPENSE_ITEM)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetVOMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, r.getValue(AssetVOMeta.SUPPLIER_ID)));
			this.setPurpose(DataParser.parse(String.class, r.getValue(AssetVOMeta.PURPOSE)));
			this.setResidualsPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.RESIDUALS_PRICE)));
			this.setInternalControlLabel(DataParser.parse(String.class, r.getValue(AssetVOMeta.INTERNAL_CONTROL_LABEL)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetVOMeta.LATEST_APPROVER_NAME)));
			this.setAssetUsedServiceLife(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.ASSET_USED_SERVICE_LIFE)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetVOMeta.NEXT_APPROVER_IDS)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetVOMeta.CHS_STATUS)));
			this.setProductionDate(DataParser.parse(Date.class, r.getValue(AssetVOMeta.PRODUCTION_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetVOMeta.UPDATE_BY)));
			this.setCollectionId(DataParser.parse(String.class, r.getValue(AssetVOMeta.COLLECTION_ID)));
			this.setRegisterDate(DataParser.parse(Date.class, r.getValue(AssetVOMeta.REGISTER_DATE)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetVOMeta.SUMMARY)));
			this.setEquipmentSerialNumber(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_SERIAL_NUMBER)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AssetVOMeta.BATCH_CODE)));
			this.setEquipmentCpu(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_CPU)));
			this.setEquipmentMemory(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_MEMORY)));
			this.setLabel(DataParser.parse(String.class, r.getValue(AssetVOMeta.LABEL)));
			this.setEquipmentStatus(DataParser.parse(String.class, r.getValue(AssetVOMeta.EQUIPMENT_STATUS)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetVOMeta.POSITION_DETAIL)));
			this.setDepreciationYear(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.DEPRECIATION_YEAR)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(AssetVOMeta.CONTACT_INFORMATION)));
			this.setTaxAmountPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetVOMeta.TAX_AMOUNT_PRICE)));
			this.setRegionId(DataParser.parse(String.class, r.getValue(AssetVOMeta.REGION_ID)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetVOMeta.CHS_TYPE)));
			this.setRackDownNumber(DataParser.parse(Integer.class, r.getValue(AssetVOMeta.RACK_DOWN_NUMBER)));
			this.setBorrowId(DataParser.parse(String.class, r.getValue(AssetVOMeta.BORROW_ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(AssetVOMeta.CATEGORY_ID)));
			return true;
		} else {
			try {
				this.setEquipmentCode( (String)r.getValue(AssetVOMeta.EQUIPMENT_CODE));
				this.setCustomerInfo( (String)r.getValue(AssetVOMeta.CUSTOMER_INFO));
				this.setPurchaseUnitPrice( (BigDecimal)r.getValue(AssetVOMeta.PURCHASE_UNIT_PRICE));
				this.setApprovalOpinion( (String)r.getValue(AssetVOMeta.APPROVAL_OPINION));
				this.setMaintenanceStatus( (String)r.getValue(AssetVOMeta.MAINTENANCE_STATUS));
				this.setNavPrice( (BigDecimal)r.getValue(AssetVOMeta.NAV_PRICE));
				this.setLabel4( (String)r.getValue(AssetVOMeta.LABEL4));
				this.setLabel5( (String)r.getValue(AssetVOMeta.LABEL5));
				this.setBusinessCode( (String)r.getValue(AssetVOMeta.BUSINESS_CODE));
				this.setAssetNumber( (Integer)r.getValue(AssetVOMeta.ASSET_NUMBER));
				this.setModel( (String)r.getValue(AssetVOMeta.MODEL));
				this.setId( (String)r.getValue(AssetVOMeta.ID));
				this.setScrapId( (String)r.getValue(AssetVOMeta.SCRAP_ID));
				this.setEquipmentEnvironmentCode( (String)r.getValue(AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE));
				this.setDirector( (String)r.getValue(AssetVOMeta.DIRECTOR));
				this.setMonthDepreciationPrice( (BigDecimal)r.getValue(AssetVOMeta.MONTH_DEPRECIATION_PRICE));
				this.setVersion( (Integer)r.getValue(AssetVOMeta.VERSION));
				this.setSafetyLevelCode( (String)r.getValue(AssetVOMeta.SAFETY_LEVEL_CODE));
				this.setMaintainerId( (String)r.getValue(AssetVOMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)r.getValue(AssetVOMeta.MAINTENANCE_NOTES));
				this.setEntryTime( (Date)r.getValue(AssetVOMeta.ENTRY_TIME));
				this.setManageIp( (String)r.getValue(AssetVOMeta.MANAGE_IP));
				this.setWarehouseId( (String)r.getValue(AssetVOMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)r.getValue(AssetVOMeta.DELETE_TIME));
				this.setFinancialNotes( (String)r.getValue(AssetVOMeta.FINANCIAL_NOTES));
				this.setMaintenanceMethod( (String)r.getValue(AssetVOMeta.MAINTENANCE_METHOD));
				this.setFinancialOption( (String)r.getValue(AssetVOMeta.FINANCIAL_OPTION));
				this.setStatus( (String)r.getValue(AssetVOMeta.STATUS));
				this.setPurchaseDate( (Date)r.getValue(AssetVOMeta.PURCHASE_DATE));
				this.setOwnerCode( (String)r.getValue(AssetVOMeta.OWNER_CODE));
				this.setRemainNumber( (Integer)r.getValue(AssetVOMeta.REMAIN_NUMBER));
				this.setGoodsId( (String)r.getValue(AssetVOMeta.GOODS_ID));
				this.setChangeInstanceId( (String)r.getValue(AssetVOMeta.CHANGE_INSTANCE_ID));
				this.setEquipmentConf( (String)r.getValue(AssetVOMeta.EQUIPMENT_CONF));
				this.setAssetNotes( (String)r.getValue(AssetVOMeta.ASSET_NOTES));
				this.setOriginalUnitPrice( (BigDecimal)r.getValue(AssetVOMeta.ORIGINAL_UNIT_PRICE));
				this.setDepreciationId( (String)r.getValue(AssetVOMeta.DEPRECIATION_ID));
				this.setPictureId( (String)r.getValue(AssetVOMeta.PICTURE_ID));
				this.setSuggestMaintenanceMethod( (String)r.getValue(AssetVOMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setTotalAmountPrice( (BigDecimal)r.getValue(AssetVOMeta.TOTAL_AMOUNT_PRICE));
				this.setServiceLife( (BigDecimal)r.getValue(AssetVOMeta.SERVICE_LIFE));
				this.setAttach( (String)r.getValue(AssetVOMeta.ATTACH));
				this.setMaintainerName( (String)r.getValue(AssetVOMeta.MAINTAINER_NAME));
				this.setOriginatorId( (String)r.getValue(AssetVOMeta.ORIGINATOR_ID));
				this.setCleanOut( (String)r.getValue(AssetVOMeta.CLEAN_OUT));
				this.setRackId( (String)r.getValue(AssetVOMeta.RACK_ID));
				this.setDisplay( (String)r.getValue(AssetVOMeta.DISPLAY));
				this.setManufacturerId( (String)r.getValue(AssetVOMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetVOMeta.UPDATE_TIME));
				this.setCategoryCode( (String)r.getValue(AssetVOMeta.CATEGORY_CODE));
				this.setManagerId( (String)r.getValue(AssetVOMeta.MANAGER_ID));
				this.setAccumulatedDepreciation( (BigDecimal)r.getValue(AssetVOMeta.ACCUMULATED_DEPRECIATION));
				this.setLabel2( (String)r.getValue(AssetVOMeta.LABEL2));
				this.setLabel3( (String)r.getValue(AssetVOMeta.LABEL3));
				this.setAssetSelectedData( (String)r.getValue(AssetVOMeta.ASSET_SELECTED_DATA));
				this.setDeleted( (Integer)r.getValue(AssetVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(AssetVOMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(AssetVOMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(AssetVOMeta.TENANT_ID));
				this.setRfid( (String)r.getValue(AssetVOMeta.RFID));
				this.setMaintenanceStartDate( (Date)r.getValue(AssetVOMeta.MAINTENANCE_START_DATE));
				this.setLastVerificationDate( (Date)r.getValue(AssetVOMeta.LAST_VERIFICATION_DATE));
				this.setUseUserId( (String)r.getValue(AssetVOMeta.USE_USER_ID));
				this.setContacts( (String)r.getValue(AssetVOMeta.CONTACTS));
				this.setSourceId( (String)r.getValue(AssetVOMeta.SOURCE_ID));
				this.setProcId( (String)r.getValue(AssetVOMeta.PROC_ID));
				this.setFinancialCategoryId( (String)r.getValue(AssetVOMeta.FINANCIAL_CATEGORY_ID));
				this.setMaintenancePrice( (BigDecimal)r.getValue(AssetVOMeta.MAINTENANCE_PRICE));
				this.setEquipmentIp( (String)r.getValue(AssetVOMeta.EQUIPMENT_IP));
				this.setMaintenanceEndDate( (Date)r.getValue(AssetVOMeta.MAINTENANCE_END_DATE));
				this.setDepreciationOperTime( (Date)r.getValue(AssetVOMeta.DEPRECIATION_OPER_TIME));
				this.setNextApproverNames( (String)r.getValue(AssetVOMeta.NEXT_APPROVER_NAMES));
				this.setAssetCode( (String)r.getValue(AssetVOMeta.ASSET_CODE));
				this.setSerialNumber( (String)r.getValue(AssetVOMeta.SERIAL_NUMBER));
				this.setLatestApproverId( (String)r.getValue(AssetVOMeta.LATEST_APPROVER_ID));
				this.setGoodsStockId( (String)r.getValue(AssetVOMeta.GOODS_STOCK_ID));
				this.setTaxAmountRate( (BigDecimal)r.getValue(AssetVOMeta.TAX_AMOUNT_RATE));
				this.setCurrentYearDepreciation( (BigDecimal)r.getValue(AssetVOMeta.CURRENT_YEAR_DEPRECIATION));
				this.setUseOrganizationId( (String)r.getValue(AssetVOMeta.USE_ORGANIZATION_ID));
				this.setEquipmentLabel( (String)r.getValue(AssetVOMeta.EQUIPMENT_LABEL));
				this.setUnit( (String)r.getValue(AssetVOMeta.UNIT));
				this.setOwnCompanyId( (String)r.getValue(AssetVOMeta.OWN_COMPANY_ID));
				this.setBillId( (String)r.getValue(AssetVOMeta.BILL_ID));
				this.setName( (String)r.getValue(AssetVOMeta.NAME));
				this.setDeleteBy( (String)r.getValue(AssetVOMeta.DELETE_BY));
				this.setFinancialCode( (String)r.getValue(AssetVOMeta.FINANCIAL_CODE));
				this.setRackUpNumber( (Integer)r.getValue(AssetVOMeta.RACK_UP_NUMBER));
				this.setResidualsRate( (BigDecimal)r.getValue(AssetVOMeta.RESIDUALS_RATE));
				this.setAssetStatus( (String)r.getValue(AssetVOMeta.ASSET_STATUS));
				this.setExpenseItem( (String)r.getValue(AssetVOMeta.EXPENSE_ITEM));
				this.setChsVersion( (String)r.getValue(AssetVOMeta.CHS_VERSION));
				this.setSupplierId( (String)r.getValue(AssetVOMeta.SUPPLIER_ID));
				this.setPurpose( (String)r.getValue(AssetVOMeta.PURPOSE));
				this.setResidualsPrice( (BigDecimal)r.getValue(AssetVOMeta.RESIDUALS_PRICE));
				this.setInternalControlLabel( (String)r.getValue(AssetVOMeta.INTERNAL_CONTROL_LABEL));
				this.setLatestApproverName( (String)r.getValue(AssetVOMeta.LATEST_APPROVER_NAME));
				this.setAssetUsedServiceLife( (BigDecimal)r.getValue(AssetVOMeta.ASSET_USED_SERVICE_LIFE));
				this.setNextApproverIds( (String)r.getValue(AssetVOMeta.NEXT_APPROVER_IDS));
				this.setChsStatus( (String)r.getValue(AssetVOMeta.CHS_STATUS));
				this.setProductionDate( (Date)r.getValue(AssetVOMeta.PRODUCTION_DATE));
				this.setUpdateBy( (String)r.getValue(AssetVOMeta.UPDATE_BY));
				this.setCollectionId( (String)r.getValue(AssetVOMeta.COLLECTION_ID));
				this.setRegisterDate( (Date)r.getValue(AssetVOMeta.REGISTER_DATE));
				this.setSummary( (String)r.getValue(AssetVOMeta.SUMMARY));
				this.setEquipmentSerialNumber( (String)r.getValue(AssetVOMeta.EQUIPMENT_SERIAL_NUMBER));
				this.setBatchCode( (String)r.getValue(AssetVOMeta.BATCH_CODE));
				this.setEquipmentCpu( (String)r.getValue(AssetVOMeta.EQUIPMENT_CPU));
				this.setEquipmentMemory( (String)r.getValue(AssetVOMeta.EQUIPMENT_MEMORY));
				this.setLabel( (String)r.getValue(AssetVOMeta.LABEL));
				this.setEquipmentStatus( (String)r.getValue(AssetVOMeta.EQUIPMENT_STATUS));
				this.setPositionDetail( (String)r.getValue(AssetVOMeta.POSITION_DETAIL));
				this.setDepreciationYear( (Integer)r.getValue(AssetVOMeta.DEPRECIATION_YEAR));
				this.setCreateBy( (String)r.getValue(AssetVOMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(AssetVOMeta.CONTACT_INFORMATION));
				this.setTaxAmountPrice( (BigDecimal)r.getValue(AssetVOMeta.TAX_AMOUNT_PRICE));
				this.setRegionId( (String)r.getValue(AssetVOMeta.REGION_ID));
				this.setChsType( (String)r.getValue(AssetVOMeta.CHS_TYPE));
				this.setRackDownNumber( (Integer)r.getValue(AssetVOMeta.RACK_DOWN_NUMBER));
				this.setBorrowId( (String)r.getValue(AssetVOMeta.BORROW_ID));
				this.setCategoryId( (String)r.getValue(AssetVOMeta.CATEGORY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}