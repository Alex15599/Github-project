package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_COLLECTION_RETURN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetCollectionReturnMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产退库
 * <p>资产退库 , 数据表 eam_asset_collection_return 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-12 20:49:26
 * @sign C86555EC97ABE3539CA9936314C3C9FD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_collection_return")
@ApiModel(description = "资产退库 ; 资产退库 , 数据表 eam_asset_collection_return 的PO类型")
public class AssetCollectionReturn extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_COLLECTION_RETURN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "604777423912841216")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "RE202207272007533")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "complete")
	private String status;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "1212")
	private String name;
	
	/**
	 * 退库后公司/部门：退库后公司/部门
	*/
	@ApiModelProperty(required = false,value="退库后公司/部门" , notes = "退库后公司/部门" , example = "2")
	private String useOrganizationId;
	
	/**
	 * 退库后位置：退库后位置
	*/
	@ApiModelProperty(required = false,value="退库后位置" , notes = "退库后位置" , example = "472024543184027649")
	private String positionId;
	
	/**
	 * 详细位置：详细位置
	*/
	@ApiModelProperty(required = false,value="详细位置" , notes = "详细位置")
	private String positionDetail;
	
	/**
	 * 退库说明：退库说明
	*/
	@ApiModelProperty(required = false,value="退库说明" , notes = "退库说明" , example = "1212")
	private String content;
	
	/**
	 * 退库日期：退库日期
	*/
	@ApiModelProperty(required = false,value="退库日期" , notes = "退库日期" , example = "2022-07-27 12:00:00")
	private Date returnDate;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2022-07-27 12:00:00")
	private Date businessDate;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-07-27 08:49:34")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-07-27 08:49:36")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1658926163000")
	private String selectedCode;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorUserName;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 退库公司：退库公司
	*/
	@ApiModelProperty(required = false,value="退库公司" , notes = "退库公司")
	private Organization useOrganization;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AssetCollectionReturn setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public AssetCollectionReturn setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public AssetCollectionReturn setProcId(String procId) {
		this.procId=procId;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public AssetCollectionReturn setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 业务名称<br>
	 * 业务名称
	 * @return 业务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 业务名称
	 * @param name 业务名称
	 * @return 当前对象
	*/
	public AssetCollectionReturn setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 退库后公司/部门<br>
	 * 退库后公司/部门
	 * @return 退库后公司/部门
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 退库后公司/部门
	 * @param useOrganizationId 退库后公司/部门
	 * @return 当前对象
	*/
	public AssetCollectionReturn setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 退库后位置<br>
	 * 退库后位置
	 * @return 退库后位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 退库后位置
	 * @param positionId 退库后位置
	 * @return 当前对象
	*/
	public AssetCollectionReturn setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 详细位置<br>
	 * 详细位置
	 * @return 详细位置
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 详细位置
	 * @param positionDetail 详细位置
	 * @return 当前对象
	*/
	public AssetCollectionReturn setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 退库说明<br>
	 * 退库说明
	 * @return 退库说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 退库说明
	 * @param content 退库说明
	 * @return 当前对象
	*/
	public AssetCollectionReturn setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 退库日期<br>
	 * 退库日期
	 * @return 退库日期
	*/
	public Date getReturnDate() {
		return returnDate;
	}
	
	/**
	 * 设置 退库日期
	 * @param returnDate 退库日期
	 * @return 当前对象
	*/
	public AssetCollectionReturn setReturnDate(Date returnDate) {
		this.returnDate=returnDate;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public AssetCollectionReturn setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public AssetCollectionReturn setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public AssetCollectionReturn setAttach(String attach) {
		this.attach=attach;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public AssetCollectionReturn setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public AssetCollectionReturn setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public AssetCollectionReturn setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public AssetCollectionReturn setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public AssetCollectionReturn setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public AssetCollectionReturn setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public AssetCollectionReturn setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public AssetCollectionReturn setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public AssetCollectionReturn setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public AssetCollectionReturn setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public AssetCollectionReturn setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public AssetCollectionReturn setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetList 资产
	 * @return 当前对象
	*/
	public AssetCollectionReturn setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetCollectionReturn addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetIds 资产列表
	 * @return 当前对象
	*/
	public AssetCollectionReturn setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetCollectionReturn addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getOriginatorUserName() {
		return originatorUserName;
	}
	
	/**
	 * 设置 申请人
	 * @param originatorUserName 申请人
	 * @return 当前对象
	*/
	public AssetCollectionReturn setOriginatorUserName(String originatorUserName) {
		this.originatorUserName=originatorUserName;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public AssetCollectionReturn setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 退库公司<br>
	 * 退库公司
	 * @return 退库公司
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 退库公司
	 * @param useOrganization 退库公司
	 * @return 当前对象
	*/
	public AssetCollectionReturn setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetCollectionReturn , 转换好的 AssetCollectionReturn 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetCollectionReturn , 转换好的 PoJo 对象
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
	public AssetCollectionReturn clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetCollectionReturn duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetCollectionReturnMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetCollectionReturnMeta.$$proxy$$();
		inst.setProcId(this.getProcId());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReturnDate(this.getReturnDate());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setUseOrganization(this.getUseOrganization());
			inst.setAssetIds(this.getAssetIds());
			inst.setPosition(this.getPosition());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetCollectionReturn clone(boolean deep) {
		return EntityContext.clone(AssetCollectionReturn.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetCollectionReturn
	 * @param assetCollectionReturnMap 包含实体信息的 Map 对象
	 * @return AssetCollectionReturn , 转换好的的 AssetCollectionReturn 对象
	*/
	@Transient
	public static AssetCollectionReturn createFrom(Map<String,Object> assetCollectionReturnMap) {
		if(assetCollectionReturnMap==null) return null;
		AssetCollectionReturn po = create();
		EntityContext.copyProperties(po,assetCollectionReturnMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetCollectionReturn
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetCollectionReturn , 转换好的的 AssetCollectionReturn 对象
	*/
	@Transient
	public static AssetCollectionReturn createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetCollectionReturn po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetCollectionReturn，等同于 new
	 * @return AssetCollectionReturn 对象
	*/
	@Transient
	public static AssetCollectionReturn create() {
		return new com.dt.platform.domain.eam.meta.AssetCollectionReturnMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.PROC_ID)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetCollectionReturnMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetCollectionReturnMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.CONTENT)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.POSITION_DETAIL)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetCollectionReturnMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, map.get(AssetCollectionReturnMeta.RETURN_DATE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetCollectionReturnMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetCollectionReturnMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetCollectionReturnMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.STATUS)));
			// others
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetCollectionReturnMeta.USE_ORGANIZATION)));
			this.setPosition(DataParser.parse(Position.class, map.get(AssetCollectionReturnMeta.POSITION)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetCollectionReturnMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetCollectionReturnMeta.ORIGINATOR_USER_NAME)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(AssetCollectionReturnMeta.PROC_ID));
				this.setUseOrganizationId( (String)map.get(AssetCollectionReturnMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)map.get(AssetCollectionReturnMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetCollectionReturnMeta.VERSION));
				this.setSelectedCode( (String)map.get(AssetCollectionReturnMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetCollectionReturnMeta.CONTENT));
				this.setPositionDetail( (String)map.get(AssetCollectionReturnMeta.POSITION_DETAIL));
				this.setBusinessDate( (Date)map.get(AssetCollectionReturnMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetCollectionReturnMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)map.get(AssetCollectionReturnMeta.RETURN_DATE));
				this.setCreateBy( (String)map.get(AssetCollectionReturnMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetCollectionReturnMeta.DELETED));
				this.setPositionId( (String)map.get(AssetCollectionReturnMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(AssetCollectionReturnMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetCollectionReturnMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetCollectionReturnMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetCollectionReturnMeta.NAME));
				this.setTenantId( (String)map.get(AssetCollectionReturnMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetCollectionReturnMeta.DELETE_BY));
				this.setId( (String)map.get(AssetCollectionReturnMeta.ID));
				this.setOriginatorId( (String)map.get(AssetCollectionReturnMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetCollectionReturnMeta.ATTACH));
				this.setStatus( (String)map.get(AssetCollectionReturnMeta.STATUS));
				// others
				this.setUseOrganization( (Organization)map.get(AssetCollectionReturnMeta.USE_ORGANIZATION));
				this.setPosition( (Position)map.get(AssetCollectionReturnMeta.POSITION));
				this.setOriginator( (Employee)map.get(AssetCollectionReturnMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetCollectionReturnMeta.ORIGINATOR_USER_NAME));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.PROC_ID)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetCollectionReturnMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetCollectionReturnMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.CONTENT)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.POSITION_DETAIL)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetCollectionReturnMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, r.getValue(AssetCollectionReturnMeta.RETURN_DATE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetCollectionReturnMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetCollectionReturnMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetCollectionReturnMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetCollectionReturnMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(AssetCollectionReturnMeta.PROC_ID));
				this.setUseOrganizationId( (String)r.getValue(AssetCollectionReturnMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)r.getValue(AssetCollectionReturnMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetCollectionReturnMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(AssetCollectionReturnMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetCollectionReturnMeta.CONTENT));
				this.setPositionDetail( (String)r.getValue(AssetCollectionReturnMeta.POSITION_DETAIL));
				this.setBusinessDate( (Date)r.getValue(AssetCollectionReturnMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetCollectionReturnMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)r.getValue(AssetCollectionReturnMeta.RETURN_DATE));
				this.setCreateBy( (String)r.getValue(AssetCollectionReturnMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetCollectionReturnMeta.DELETED));
				this.setPositionId( (String)r.getValue(AssetCollectionReturnMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(AssetCollectionReturnMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetCollectionReturnMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetCollectionReturnMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetCollectionReturnMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetCollectionReturnMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetCollectionReturnMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetCollectionReturnMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetCollectionReturnMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetCollectionReturnMeta.ATTACH));
				this.setStatus( (String)r.getValue(AssetCollectionReturnMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}