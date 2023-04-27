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
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产盘点VO类型
 * <p>资产盘点 , 数据表 eam_inventory 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-10 20:58:09
 * @sign E971F667921333F851B3A0377700592E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产盘点VO类型 ; 资产盘点 , 数据表 eam_inventory 的通用VO类型" , parent = Inventory.class)
public class InventoryVO extends Inventory {

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
	public InventoryVO setPageIndex(Integer pageIndex) {
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
	public InventoryVO setPageSize(Integer pageSize) {
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
	public InventoryVO setSearchField(String searchField) {
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
	public InventoryVO setFuzzyField(String fuzzyField) {
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
	public InventoryVO setSearchValue(String searchValue) {
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
	public InventoryVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InventoryVO addDirtyField(String... dirtyField) {
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
	public InventoryVO setSortField(String sortField) {
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
	public InventoryVO setSortType(String sortType) {
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
	public InventoryVO setDataOrigin(String dataOrigin) {
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
	public InventoryVO setQueryLogic(String queryLogic) {
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
	public InventoryVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InventoryVO addId(String... id) {
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
	 * @return InventoryVO , 转换好的 InventoryVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryVO , 转换好的 PoJo 对象
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
	public InventoryVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InventoryVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InventoryVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InventoryVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setType(this.getType());
		inst.setAllEmployee(this.getAllEmployee());
		inst.setInventoryRepeat(this.getInventoryRepeat());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setPurchaseStartDate(this.getPurchaseStartDate());
		inst.setStartTime(this.getStartTime());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setFinishTime(this.getFinishTime());
		inst.setInventoryStatus(this.getInventoryStatus());
		inst.setDataStatus(this.getDataStatus());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPurchaseEndDate(this.getPurchaseEndDate());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setAssetStatus(this.getAssetStatus());
		inst.setCategoryId(this.getCategoryId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setInventoryUserIds(this.getInventoryUserIds());
			inst.setPositionIds(this.getPositionIds());
			inst.setSearchField(this.getSearchField());
			inst.setInventoryAssetCountByLoss(this.getInventoryAssetCountByLoss());
			inst.setInventoryAssetCountByException(this.getInventoryAssetCountByException());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setInventoryAssetCountByCounted(this.getInventoryAssetCountByCounted());
			inst.setOriginator(this.getOriginator());
			inst.setInventoryAssetInfoList(this.getInventoryAssetInfoList());
			inst.setInventoryAssetCountByNotCounted(this.getInventoryAssetCountByNotCounted());
			inst.setInventoryUser(this.getInventoryUser());
			inst.setInventoryAssetCountBySurplus(this.getInventoryAssetCountBySurplus());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setWarehouseIds(this.getWarehouseIds());
			inst.setManager(this.getManager());
			inst.setDirector(this.getDirector());
			inst.setWarehouse(this.getWarehouse());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setCategoryIds(this.getCategoryIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setInventoryManagerIds(this.getInventoryManagerIds());
			inst.setInventoryDirectorIds(this.getInventoryDirectorIds());
			inst.setIds(this.getIds());
			inst.setPosition(this.getPosition());
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
	public InventoryVO clone(boolean deep) {
		return EntityContext.clone(InventoryVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InventoryVO
	 * @param inventoryMap 包含实体信息的 Map 对象
	 * @return InventoryVO , 转换好的的 Inventory 对象
	*/
	@Transient
	public static InventoryVO createFrom(Map<String,Object> inventoryMap) {
		if(inventoryMap==null) return null;
		InventoryVO vo = create();
		EntityContext.copyProperties(vo,inventoryMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InventoryVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryVO , 转换好的的 Inventory 对象
	*/
	@Transient
	public static InventoryVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InventoryVO，等同于 new
	 * @return InventoryVO 对象
	*/
	@Transient
	public static InventoryVO create() {
		return new com.dt.platform.domain.eam.meta.InventoryVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InventoryVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(InventoryVOMeta.OWNER_CODE)));
			this.setType(DataParser.parse(String.class, map.get(InventoryVOMeta.TYPE)));
			this.setAllEmployee(DataParser.parse(String.class, map.get(InventoryVOMeta.ALL_EMPLOYEE)));
			this.setInventoryRepeat(DataParser.parse(String.class, map.get(InventoryVOMeta.INVENTORY_REPEAT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(InventoryVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(InventoryVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InventoryVOMeta.UPDATE_BY)));
			this.setPurchaseStartDate(DataParser.parse(Date.class, map.get(InventoryVOMeta.PURCHASE_START_DATE)));
			this.setStartTime(DataParser.parse(Date.class, map.get(InventoryVOMeta.START_TIME)));
			this.setPlanId(DataParser.parse(String.class, map.get(InventoryVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(InventoryVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(InventoryVOMeta.ORIGINATOR_ID)));
			this.setFinishTime(DataParser.parse(Date.class, map.get(InventoryVOMeta.FINISH_TIME)));
			this.setInventoryStatus(DataParser.parse(String.class, map.get(InventoryVOMeta.INVENTORY_STATUS)));
			this.setDataStatus(DataParser.parse(String.class, map.get(InventoryVOMeta.DATA_STATUS)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(InventoryVOMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InventoryVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InventoryVOMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(InventoryVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InventoryVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InventoryVOMeta.DELETED)));
			this.setPurchaseEndDate(DataParser.parse(Date.class, map.get(InventoryVOMeta.PURCHASE_END_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InventoryVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InventoryVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(InventoryVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InventoryVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InventoryVOMeta.DELETE_BY)));
			this.setAssetStatus(DataParser.parse(String.class, map.get(InventoryVOMeta.ASSET_STATUS)));
			this.setCategoryId(DataParser.parse(String.class, map.get(InventoryVOMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InventoryVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(InventoryVOMeta.SEARCH_FIELD)));
			this.setInventoryAssetCountByLoss(DataParser.parse(Integer.class, map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_LOSS)));
			this.setInventoryAssetCountByException(DataParser.parse(Integer.class, map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InventoryVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InventoryVOMeta.PAGE_SIZE)));
			this.setInventoryAssetCountByCounted(DataParser.parse(Integer.class, map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_COUNTED)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(InventoryVOMeta.ORIGINATOR)));
			this.setInventoryAssetCountByNotCounted(DataParser.parse(Integer.class, map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED)));
			this.setInventoryAssetCountBySurplus(DataParser.parse(Integer.class, map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS)));
			this.setSortField(DataParser.parse(String.class, map.get(InventoryVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InventoryVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InventoryVOMeta.QUERY_LOGIC)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InventoryVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InventoryVOMeta.SORT_TYPE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InventoryVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InventoryVOMeta.NOTES));
				this.setOwnerCode( (String)map.get(InventoryVOMeta.OWNER_CODE));
				this.setType( (String)map.get(InventoryVOMeta.TYPE));
				this.setAllEmployee( (String)map.get(InventoryVOMeta.ALL_EMPLOYEE));
				this.setInventoryRepeat( (String)map.get(InventoryVOMeta.INVENTORY_REPEAT));
				this.setBusinessDate( (Date)map.get(InventoryVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(InventoryVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(InventoryVOMeta.UPDATE_BY));
				this.setPurchaseStartDate( (Date)map.get(InventoryVOMeta.PURCHASE_START_DATE));
				this.setStartTime( (Date)map.get(InventoryVOMeta.START_TIME));
				this.setPlanId( (String)map.get(InventoryVOMeta.PLAN_ID));
				this.setId( (String)map.get(InventoryVOMeta.ID));
				this.setOriginatorId( (String)map.get(InventoryVOMeta.ORIGINATOR_ID));
				this.setFinishTime( (Date)map.get(InventoryVOMeta.FINISH_TIME));
				this.setInventoryStatus( (String)map.get(InventoryVOMeta.INVENTORY_STATUS));
				this.setDataStatus( (String)map.get(InventoryVOMeta.DATA_STATUS));
				this.setUseOrganizationId( (String)map.get(InventoryVOMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)map.get(InventoryVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(InventoryVOMeta.VERSION));
				this.setOwnCompanyId( (String)map.get(InventoryVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(InventoryVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InventoryVOMeta.DELETED));
				this.setPurchaseEndDate( (Date)map.get(InventoryVOMeta.PURCHASE_END_DATE));
				this.setCreateTime( (Date)map.get(InventoryVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InventoryVOMeta.DELETE_TIME));
				this.setName( (String)map.get(InventoryVOMeta.NAME));
				this.setTenantId( (String)map.get(InventoryVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InventoryVOMeta.DELETE_BY));
				this.setAssetStatus( (String)map.get(InventoryVOMeta.ASSET_STATUS));
				this.setCategoryId( (String)map.get(InventoryVOMeta.CATEGORY_ID));
				this.setStatus( (String)map.get(InventoryVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(InventoryVOMeta.SEARCH_FIELD));
				this.setInventoryAssetCountByLoss( (Integer)map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_LOSS));
				this.setInventoryAssetCountByException( (Integer)map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION));
				this.setFuzzyField( (String)map.get(InventoryVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(InventoryVOMeta.PAGE_SIZE));
				this.setInventoryAssetCountByCounted( (Integer)map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_COUNTED));
				this.setOriginator( (Employee)map.get(InventoryVOMeta.ORIGINATOR));
				this.setInventoryAssetCountByNotCounted( (Integer)map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED));
				this.setInventoryAssetCountBySurplus( (Integer)map.get(InventoryVOMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS));
				this.setSortField( (String)map.get(InventoryVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(InventoryVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InventoryVOMeta.QUERY_LOGIC));
				this.setPageIndex( (Integer)map.get(InventoryVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InventoryVOMeta.SORT_TYPE));
				this.setSearchValue( (String)map.get(InventoryVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InventoryVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(InventoryVOMeta.OWNER_CODE)));
			this.setType(DataParser.parse(String.class, r.getValue(InventoryVOMeta.TYPE)));
			this.setAllEmployee(DataParser.parse(String.class, r.getValue(InventoryVOMeta.ALL_EMPLOYEE)));
			this.setInventoryRepeat(DataParser.parse(String.class, r.getValue(InventoryVOMeta.INVENTORY_REPEAT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(InventoryVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InventoryVOMeta.UPDATE_BY)));
			this.setPurchaseStartDate(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.PURCHASE_START_DATE)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.START_TIME)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.ORIGINATOR_ID)));
			this.setFinishTime(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.FINISH_TIME)));
			this.setInventoryStatus(DataParser.parse(String.class, r.getValue(InventoryVOMeta.INVENTORY_STATUS)));
			this.setDataStatus(DataParser.parse(String.class, r.getValue(InventoryVOMeta.DATA_STATUS)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InventoryVOMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InventoryVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InventoryVOMeta.DELETED)));
			this.setPurchaseEndDate(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.PURCHASE_END_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InventoryVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(InventoryVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InventoryVOMeta.DELETE_BY)));
			this.setAssetStatus(DataParser.parse(String.class, r.getValue(InventoryVOMeta.ASSET_STATUS)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(InventoryVOMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InventoryVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InventoryVOMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(InventoryVOMeta.OWNER_CODE));
				this.setType( (String)r.getValue(InventoryVOMeta.TYPE));
				this.setAllEmployee( (String)r.getValue(InventoryVOMeta.ALL_EMPLOYEE));
				this.setInventoryRepeat( (String)r.getValue(InventoryVOMeta.INVENTORY_REPEAT));
				this.setBusinessDate( (Date)r.getValue(InventoryVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(InventoryVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(InventoryVOMeta.UPDATE_BY));
				this.setPurchaseStartDate( (Date)r.getValue(InventoryVOMeta.PURCHASE_START_DATE));
				this.setStartTime( (Date)r.getValue(InventoryVOMeta.START_TIME));
				this.setPlanId( (String)r.getValue(InventoryVOMeta.PLAN_ID));
				this.setId( (String)r.getValue(InventoryVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(InventoryVOMeta.ORIGINATOR_ID));
				this.setFinishTime( (Date)r.getValue(InventoryVOMeta.FINISH_TIME));
				this.setInventoryStatus( (String)r.getValue(InventoryVOMeta.INVENTORY_STATUS));
				this.setDataStatus( (String)r.getValue(InventoryVOMeta.DATA_STATUS));
				this.setUseOrganizationId( (String)r.getValue(InventoryVOMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)r.getValue(InventoryVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(InventoryVOMeta.VERSION));
				this.setOwnCompanyId( (String)r.getValue(InventoryVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(InventoryVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InventoryVOMeta.DELETED));
				this.setPurchaseEndDate( (Date)r.getValue(InventoryVOMeta.PURCHASE_END_DATE));
				this.setCreateTime( (Date)r.getValue(InventoryVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InventoryVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(InventoryVOMeta.NAME));
				this.setTenantId( (String)r.getValue(InventoryVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InventoryVOMeta.DELETE_BY));
				this.setAssetStatus( (String)r.getValue(InventoryVOMeta.ASSET_STATUS));
				this.setCategoryId( (String)r.getValue(InventoryVOMeta.CATEGORY_ID));
				this.setStatus( (String)r.getValue(InventoryVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}