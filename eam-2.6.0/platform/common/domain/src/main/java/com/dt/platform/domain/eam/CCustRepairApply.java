package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_REPAIR_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CCustRepairApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 报修申请
 * <p>报修申请 , 数据表 eam_c_cust_repair_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-10 21:55:57
 * @sign D614BD0FC4572664F377C28CB5E998FA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_repair_apply")
@ApiModel(description = "报修申请 ; 报修申请 , 数据表 eam_c_cust_repair_apply 的PO类型")
public class CCustRepairApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_REPAIR_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697140768753582080")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "SW202304081704619")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "processing")
	private String status;
	
	/**
	 * 报修标题：报修标题
	*/
	@ApiModelProperty(required = false,value="报修标题" , notes = "报修标题" , example = "1212")
	private String name;
	
	/**
	 * 报修时间：报修时间
	*/
	@ApiModelProperty(required = false,value="报修时间" , notes = "报修时间")
	private Date planFinishDate;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置" , example = "1212121212")
	private String pos;
	
	/**
	 * 发起人：发起人
	*/
	@ApiModelProperty(required = false,value="发起人" , notes = "发起人" , example = "12")
	private String reportUserName;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String reportUserId;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contact;
	
	/**
	 * 报修内容：报修内容
	*/
	@ApiModelProperty(required = false,value="报修内容" , notes = "报修内容")
	private String content;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 处理人：处理人
	*/
	@ApiModelProperty(required = false,value="处理人" , notes = "处理人")
	private String processUserId;
	
	/**
	 * 发起时间：发起时间
	*/
	@ApiModelProperty(required = false,value="发起时间" , notes = "发起时间" , example = "2023-04-08 12:00:00")
	private Date startDate;
	
	/**
	 * 完成时间：完成时间
	*/
	@ApiModelProperty(required = false,value="完成时间" , notes = "完成时间")
	private Date finishDate;
	
	/**
	 * 处理结果：处理结果
	*/
	@ApiModelProperty(required = false,value="处理结果" , notes = "处理结果")
	private String result;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-08 05:48:32")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-08 05:48:41")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * repiarItemData：repiarItemData
	*/
	@ApiModelProperty(required = false,value="repiarItemData" , notes = "repiarItemData")
	private List<CCustRepiarItem> repiarItemData;
	
	/**
	 * 处理人：制单人
	*/
	@ApiModelProperty(required = false,value="处理人" , notes = "制单人")
	private Employee processUser;
	
	/**
	 * 发起人：发起人
	*/
	@ApiModelProperty(required = false,value="发起人" , notes = "发起人")
	private Employee reportUser;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
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
	public CCustRepairApply setId(String id) {
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
	public CCustRepairApply setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public CCustRepairApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 报修标题<br>
	 * 报修标题
	 * @return 报修标题
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 报修标题
	 * @param name 报修标题
	 * @return 当前对象
	*/
	public CCustRepairApply setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 报修时间<br>
	 * 报修时间
	 * @return 报修时间
	*/
	public Date getPlanFinishDate() {
		return planFinishDate;
	}
	
	/**
	 * 设置 报修时间
	 * @param planFinishDate 报修时间
	 * @return 当前对象
	*/
	public CCustRepairApply setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate=planFinishDate;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPos() {
		return pos;
	}
	
	/**
	 * 设置 位置
	 * @param pos 位置
	 * @return 当前对象
	*/
	public CCustRepairApply setPos(String pos) {
		this.pos=pos;
		return this;
	}
	
	/**
	 * 获得 发起人<br>
	 * 发起人
	 * @return 发起人
	*/
	public String getReportUserName() {
		return reportUserName;
	}
	
	/**
	 * 设置 发起人
	 * @param reportUserName 发起人
	 * @return 当前对象
	*/
	public CCustRepairApply setReportUserName(String reportUserName) {
		this.reportUserName=reportUserName;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getReportUserId() {
		return reportUserId;
	}
	
	/**
	 * 设置 使用人
	 * @param reportUserId 使用人
	 * @return 当前对象
	*/
	public CCustRepairApply setReportUserId(String reportUserId) {
		this.reportUserId=reportUserId;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContact() {
		return contact;
	}
	
	/**
	 * 设置 联系方式
	 * @param contact 联系方式
	 * @return 当前对象
	*/
	public CCustRepairApply setContact(String contact) {
		this.contact=contact;
		return this;
	}
	
	/**
	 * 获得 报修内容<br>
	 * 报修内容
	 * @return 报修内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 报修内容
	 * @param content 报修内容
	 * @return 当前对象
	*/
	public CCustRepairApply setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public CCustRepairApply setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 处理人<br>
	 * 处理人
	 * @return 处理人
	*/
	public String getProcessUserId() {
		return processUserId;
	}
	
	/**
	 * 设置 处理人
	 * @param processUserId 处理人
	 * @return 当前对象
	*/
	public CCustRepairApply setProcessUserId(String processUserId) {
		this.processUserId=processUserId;
		return this;
	}
	
	/**
	 * 获得 发起时间<br>
	 * 发起时间
	 * @return 发起时间
	*/
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 设置 发起时间
	 * @param startDate 发起时间
	 * @return 当前对象
	*/
	public CCustRepairApply setStartDate(Date startDate) {
		this.startDate=startDate;
		return this;
	}
	
	/**
	 * 获得 完成时间<br>
	 * 完成时间
	 * @return 完成时间
	*/
	public Date getFinishDate() {
		return finishDate;
	}
	
	/**
	 * 设置 完成时间
	 * @param finishDate 完成时间
	 * @return 当前对象
	*/
	public CCustRepairApply setFinishDate(Date finishDate) {
		this.finishDate=finishDate;
		return this;
	}
	
	/**
	 * 获得 处理结果<br>
	 * 处理结果
	 * @return 处理结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 处理结果
	 * @param result 处理结果
	 * @return 当前对象
	*/
	public CCustRepairApply setResult(String result) {
		this.result=result;
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
	public CCustRepairApply setCreateBy(String createBy) {
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
	public CCustRepairApply setCreateTime(Date createTime) {
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
	public CCustRepairApply setUpdateBy(String updateBy) {
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
	public CCustRepairApply setUpdateTime(Date updateTime) {
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
	public CCustRepairApply setDeleted(Integer deleted) {
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
	public CCustRepairApply setDeleted(Boolean deletedBool) {
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
	public CCustRepairApply setDeleteBy(String deleteBy) {
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
	public CCustRepairApply setDeleteTime(Date deleteTime) {
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
	public CCustRepairApply setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 repiarItemData<br>
	 * repiarItemData
	 * @return repiarItemData
	*/
	public List<CCustRepiarItem> getRepiarItemData() {
		return repiarItemData;
	}
	
	/**
	 * 设置 repiarItemData
	 * @param repiarItemData repiarItemData
	 * @return 当前对象
	*/
	public CCustRepairApply setRepiarItemData(List<CCustRepiarItem> repiarItemData) {
		this.repiarItemData=repiarItemData;
		return this;
	}
	
	/**
	 * 添加 repiarItemData
	 * @param entity repiarItemData
	 * @return 当前对象
	*/
	public CCustRepairApply addRepiarItemData(CCustRepiarItem... entity) {
		if(this.repiarItemData==null) repiarItemData=new ArrayList<>();
		this.repiarItemData.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 处理人<br>
	 * 制单人
	 * @return 处理人
	*/
	public Employee getProcessUser() {
		return processUser;
	}
	
	/**
	 * 设置 处理人
	 * @param processUser 处理人
	 * @return 当前对象
	*/
	public CCustRepairApply setProcessUser(Employee processUser) {
		this.processUser=processUser;
		return this;
	}
	
	/**
	 * 获得 发起人<br>
	 * 发起人
	 * @return 发起人
	*/
	public Employee getReportUser() {
		return reportUser;
	}
	
	/**
	 * 设置 发起人
	 * @param reportUser 发起人
	 * @return 当前对象
	*/
	public CCustRepairApply setReportUser(Employee reportUser) {
		this.reportUser=reportUser;
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetList 资产列表
	 * @return 当前对象
	*/
	public CCustRepairApply setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param asset 资产列表
	 * @return 当前对象
	*/
	public CCustRepairApply addAsset(Asset... asset) {
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
	public CCustRepairApply setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public CCustRepairApply addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustRepairApply , 转换好的 CCustRepairApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustRepairApply , 转换好的 PoJo 对象
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
	public CCustRepairApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustRepairApply duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustRepairApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustRepairApplyMeta.$$proxy$$();
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
			inst.setRepiarItemData(this.getRepiarItemData());
			inst.setReportUser(this.getReportUser());
			inst.setProcessUser(this.getProcessUser());
			inst.setAssetIds(this.getAssetIds());
			inst.setAssetList(this.getAssetList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustRepairApply clone(boolean deep) {
		return EntityContext.clone(CCustRepairApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustRepairApply
	 * @param cCustRepairApplyMap 包含实体信息的 Map 对象
	 * @return CCustRepairApply , 转换好的的 CCustRepairApply 对象
	*/
	@Transient
	public static CCustRepairApply createFrom(Map<String,Object> cCustRepairApplyMap) {
		if(cCustRepairApplyMap==null) return null;
		CCustRepairApply po = create();
		EntityContext.copyProperties(po,cCustRepairApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustRepairApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustRepairApply , 转换好的的 CCustRepairApply 对象
	*/
	@Transient
	public static CCustRepairApply createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustRepairApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustRepairApply，等同于 new
	 * @return CCustRepairApply 对象
	*/
	@Transient
	public static CCustRepairApply create() {
		return new com.dt.platform.domain.eam.meta.CCustRepairApplyMeta.$$proxy$$();
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
			this.setReportUserName(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.REPORT_USER_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustRepairApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustRepairApplyMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.CONTENT)));
			this.setResult(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.RESULT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustRepairApplyMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustRepairApplyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustRepairApplyMeta.DELETE_TIME)));
			this.setReportUserId(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.REPORT_USER_ID)));
			this.setContact(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.CONTACT)));
			this.setProcessUserId(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.PROCESS_USER_ID)));
			this.setName(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(CCustRepairApplyMeta.PLAN_FINISH_DATE)));
			this.setFinishDate(DataParser.parse(Date.class, map.get(CCustRepairApplyMeta.FINISH_DATE)));
			this.setId(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.ID)));
			this.setStartDate(DataParser.parse(Date.class, map.get(CCustRepairApplyMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(CCustRepairApplyMeta.STATUS)));
			// others
			this.setReportUser(DataParser.parse(Employee.class, map.get(CCustRepairApplyMeta.REPORT_USER)));
			this.setProcessUser(DataParser.parse(Employee.class, map.get(CCustRepairApplyMeta.PROCESS_USER)));
			return true;
		} else {
			try {
				this.setReportUserName( (String)map.get(CCustRepairApplyMeta.REPORT_USER_NAME));
				this.setUpdateTime( (Date)map.get(CCustRepairApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CCustRepairApplyMeta.VERSION));
				this.setContent( (String)map.get(CCustRepairApplyMeta.CONTENT));
				this.setResult( (String)map.get(CCustRepairApplyMeta.RESULT));
				this.setBusinessCode( (String)map.get(CCustRepairApplyMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(CCustRepairApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CCustRepairApplyMeta.DELETED));
				this.setPictureId( (String)map.get(CCustRepairApplyMeta.PICTURE_ID));
				this.setPos( (String)map.get(CCustRepairApplyMeta.POS));
				this.setCreateTime( (Date)map.get(CCustRepairApplyMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustRepairApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustRepairApplyMeta.DELETE_TIME));
				this.setReportUserId( (String)map.get(CCustRepairApplyMeta.REPORT_USER_ID));
				this.setContact( (String)map.get(CCustRepairApplyMeta.CONTACT));
				this.setProcessUserId( (String)map.get(CCustRepairApplyMeta.PROCESS_USER_ID));
				this.setName( (String)map.get(CCustRepairApplyMeta.NAME));
				this.setDeleteBy( (String)map.get(CCustRepairApplyMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(CCustRepairApplyMeta.PLAN_FINISH_DATE));
				this.setFinishDate( (Date)map.get(CCustRepairApplyMeta.FINISH_DATE));
				this.setId( (String)map.get(CCustRepairApplyMeta.ID));
				this.setStartDate( (Date)map.get(CCustRepairApplyMeta.START_DATE));
				this.setStatus( (String)map.get(CCustRepairApplyMeta.STATUS));
				// others
				this.setReportUser( (Employee)map.get(CCustRepairApplyMeta.REPORT_USER));
				this.setProcessUser( (Employee)map.get(CCustRepairApplyMeta.PROCESS_USER));
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
			this.setReportUserName(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.REPORT_USER_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustRepairApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustRepairApplyMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.CONTENT)));
			this.setResult(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.RESULT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustRepairApplyMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustRepairApplyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustRepairApplyMeta.DELETE_TIME)));
			this.setReportUserId(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.REPORT_USER_ID)));
			this.setContact(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.CONTACT)));
			this.setProcessUserId(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.PROCESS_USER_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(CCustRepairApplyMeta.PLAN_FINISH_DATE)));
			this.setFinishDate(DataParser.parse(Date.class, r.getValue(CCustRepairApplyMeta.FINISH_DATE)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.ID)));
			this.setStartDate(DataParser.parse(Date.class, r.getValue(CCustRepairApplyMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CCustRepairApplyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReportUserName( (String)r.getValue(CCustRepairApplyMeta.REPORT_USER_NAME));
				this.setUpdateTime( (Date)r.getValue(CCustRepairApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CCustRepairApplyMeta.VERSION));
				this.setContent( (String)r.getValue(CCustRepairApplyMeta.CONTENT));
				this.setResult( (String)r.getValue(CCustRepairApplyMeta.RESULT));
				this.setBusinessCode( (String)r.getValue(CCustRepairApplyMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(CCustRepairApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CCustRepairApplyMeta.DELETED));
				this.setPictureId( (String)r.getValue(CCustRepairApplyMeta.PICTURE_ID));
				this.setPos( (String)r.getValue(CCustRepairApplyMeta.POS));
				this.setCreateTime( (Date)r.getValue(CCustRepairApplyMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustRepairApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustRepairApplyMeta.DELETE_TIME));
				this.setReportUserId( (String)r.getValue(CCustRepairApplyMeta.REPORT_USER_ID));
				this.setContact( (String)r.getValue(CCustRepairApplyMeta.CONTACT));
				this.setProcessUserId( (String)r.getValue(CCustRepairApplyMeta.PROCESS_USER_ID));
				this.setName( (String)r.getValue(CCustRepairApplyMeta.NAME));
				this.setDeleteBy( (String)r.getValue(CCustRepairApplyMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(CCustRepairApplyMeta.PLAN_FINISH_DATE));
				this.setFinishDate( (Date)r.getValue(CCustRepairApplyMeta.FINISH_DATE));
				this.setId( (String)r.getValue(CCustRepairApplyMeta.ID));
				this.setStartDate( (Date)r.getValue(CCustRepairApplyMeta.START_DATE));
				this.setStatus( (String)r.getValue(CCustRepairApplyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}