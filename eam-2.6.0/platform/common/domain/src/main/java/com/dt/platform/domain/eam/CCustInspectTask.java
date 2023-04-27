package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_INSPECT_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CCustInspectTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检任务单
 * <p>巡检任务单 , 数据表 eam_c_cust_inspect_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-09 16:41:06
 * @sign A744688E190667D3CE7697A5EF2C7F29
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_inspect_task")
@ApiModel(description = "巡检任务单 ; 巡检任务单 , 数据表 eam_c_cust_inspect_task 的PO类型")
public class CCustInspectTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_INSPECT_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697144405307424768")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号")
	private String code;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题" , example = "巡检计划")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "wait")
	private String status;
	
	/**
	 * 追加：追加
	*/
	@ApiModelProperty(required = false,value="追加" , notes = "追加" , example = "yes")
	private String actionAdd;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startTime;
	
	/**
	 * 完成时间：完成时间
	*/
	@ApiModelProperty(required = false,value="完成时间" , notes = "完成时间")
	private Date finishTime;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人" , example = "581798649571311616")
	private String inspectUserId;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版" , example = "696311000567119872")
	private String tplId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-08 06:02:59")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-08 06:34:08")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * custInspectTpl：custInspectTpl
	*/
	@ApiModelProperty(required = false,value="custInspectTpl" , notes = "custInspectTpl")
	private CCustInspectTpl custInspectTpl;
	
	/**
	 * leader：leader
	*/
	@ApiModelProperty(required = false,value="leader" , notes = "leader")
	private Employee leader;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private List<Employee> memberList;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private List<String> memberIds;
	
	/**
	 * assetInTplList：assetInTplList
	*/
	@ApiModelProperty(required = false,value="assetInTplList" , notes = "assetInTplList")
	private List<Asset> assetInTplList;
	
	/**
	 * custInspectItemList：custInspectItemList
	*/
	@ApiModelProperty(required = false,value="custInspectItemList" , notes = "custInspectItemList")
	private List<CCustInspectItem> custInspectItemList;
	
	/**
	 * custInspectItemIds：custInspectItemIds
	*/
	@ApiModelProperty(required = false,value="custInspectItemIds" , notes = "custInspectItemIds")
	private List<String> custInspectItemIds;
	
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
	public CCustInspectTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编号
	 * @param code 编号
	 * @return 当前对象
	*/
	public CCustInspectTask setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 标题
	 * @param name 标题
	 * @return 当前对象
	*/
	public CCustInspectTask setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public CCustInspectTask setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 追加<br>
	 * 追加
	 * @return 追加
	*/
	public String getActionAdd() {
		return actionAdd;
	}
	
	/**
	 * 设置 追加
	 * @param actionAdd 追加
	 * @return 当前对象
	*/
	public CCustInspectTask setActionAdd(String actionAdd) {
		this.actionAdd=actionAdd;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public CCustInspectTask setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 完成时间<br>
	 * 完成时间
	 * @return 完成时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 完成时间
	 * @param finishTime 完成时间
	 * @return 当前对象
	*/
	public CCustInspectTask setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getInspectUserId() {
		return inspectUserId;
	}
	
	/**
	 * 设置 负责人
	 * @param inspectUserId 负责人
	 * @return 当前对象
	*/
	public CCustInspectTask setInspectUserId(String inspectUserId) {
		this.inspectUserId=inspectUserId;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模版
	 * @param tplId 模版
	 * @return 当前对象
	*/
	public CCustInspectTask setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public CCustInspectTask setNotes(String notes) {
		this.notes=notes;
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
	public CCustInspectTask setCreateBy(String createBy) {
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
	public CCustInspectTask setCreateTime(Date createTime) {
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
	public CCustInspectTask setUpdateBy(String updateBy) {
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
	public CCustInspectTask setUpdateTime(Date updateTime) {
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
	public CCustInspectTask setDeleted(Integer deleted) {
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
	public CCustInspectTask setDeleted(Boolean deletedBool) {
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
	public CCustInspectTask setDeleteBy(String deleteBy) {
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
	public CCustInspectTask setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public CCustInspectTask setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public CCustInspectTask setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 custInspectTpl<br>
	 * custInspectTpl
	 * @return custInspectTpl
	*/
	public CCustInspectTpl getCustInspectTpl() {
		return custInspectTpl;
	}
	
	/**
	 * 设置 custInspectTpl
	 * @param custInspectTpl custInspectTpl
	 * @return 当前对象
	*/
	public CCustInspectTask setCustInspectTpl(CCustInspectTpl custInspectTpl) {
		this.custInspectTpl=custInspectTpl;
		return this;
	}
	
	/**
	 * 获得 leader<br>
	 * leader
	 * @return leader
	*/
	public Employee getLeader() {
		return leader;
	}
	
	/**
	 * 设置 leader
	 * @param leader leader
	 * @return 当前对象
	*/
	public CCustInspectTask setLeader(Employee leader) {
		this.leader=leader;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public List<Employee> getMemberList() {
		return memberList;
	}
	
	/**
	 * 设置 巡检人
	 * @param memberList 巡检人
	 * @return 当前对象
	*/
	public CCustInspectTask setMemberList(List<Employee> memberList) {
		this.memberList=memberList;
		return this;
	}
	
	/**
	 * 添加 巡检人
	 * @param member 巡检人
	 * @return 当前对象
	*/
	public CCustInspectTask addMember(Employee... member) {
		if(this.memberList==null) memberList=new ArrayList<>();
		this.memberList.addAll(Arrays.asList(member));
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public List<String> getMemberIds() {
		return memberIds;
	}
	
	/**
	 * 设置 巡检人
	 * @param memberIds 巡检人
	 * @return 当前对象
	*/
	public CCustInspectTask setMemberIds(List<String> memberIds) {
		this.memberIds=memberIds;
		return this;
	}
	
	/**
	 * 添加 巡检人
	 * @param memberId 巡检人
	 * @return 当前对象
	*/
	public CCustInspectTask addMemberId(String... memberId) {
		if(this.memberIds==null) memberIds=new ArrayList<>();
		this.memberIds.addAll(Arrays.asList(memberId));
		return this;
	}
	
	/**
	 * 获得 assetInTplList<br>
	 * assetInTplList
	 * @return assetInTplList
	*/
	public List<Asset> getAssetInTplList() {
		return assetInTplList;
	}
	
	/**
	 * 设置 assetInTplList
	 * @param assetInTplList assetInTplList
	 * @return 当前对象
	*/
	public CCustInspectTask setAssetInTplList(List<Asset> assetInTplList) {
		this.assetInTplList=assetInTplList;
		return this;
	}
	
	/**
	 * 添加 assetInTplList
	 * @param assetInTpl assetInTplList
	 * @return 当前对象
	*/
	public CCustInspectTask addAssetInTpl(Asset... assetInTpl) {
		if(this.assetInTplList==null) assetInTplList=new ArrayList<>();
		this.assetInTplList.addAll(Arrays.asList(assetInTpl));
		return this;
	}
	
	/**
	 * 获得 custInspectItemList<br>
	 * custInspectItemList
	 * @return custInspectItemList
	*/
	public List<CCustInspectItem> getCustInspectItemList() {
		return custInspectItemList;
	}
	
	/**
	 * 设置 custInspectItemList
	 * @param custInspectItemList custInspectItemList
	 * @return 当前对象
	*/
	public CCustInspectTask setCustInspectItemList(List<CCustInspectItem> custInspectItemList) {
		this.custInspectItemList=custInspectItemList;
		return this;
	}
	
	/**
	 * 添加 custInspectItemList
	 * @param custInspectItem custInspectItemList
	 * @return 当前对象
	*/
	public CCustInspectTask addCustInspectItem(CCustInspectItem... custInspectItem) {
		if(this.custInspectItemList==null) custInspectItemList=new ArrayList<>();
		this.custInspectItemList.addAll(Arrays.asList(custInspectItem));
		return this;
	}
	
	/**
	 * 获得 custInspectItemIds<br>
	 * custInspectItemIds
	 * @return custInspectItemIds
	*/
	public List<String> getCustInspectItemIds() {
		return custInspectItemIds;
	}
	
	/**
	 * 设置 custInspectItemIds
	 * @param custInspectItemIds custInspectItemIds
	 * @return 当前对象
	*/
	public CCustInspectTask setCustInspectItemIds(List<String> custInspectItemIds) {
		this.custInspectItemIds=custInspectItemIds;
		return this;
	}
	
	/**
	 * 添加 custInspectItemIds
	 * @param custInspectItemId custInspectItemIds
	 * @return 当前对象
	*/
	public CCustInspectTask addCustInspectItemId(String... custInspectItemId) {
		if(this.custInspectItemIds==null) custInspectItemIds=new ArrayList<>();
		this.custInspectItemIds.addAll(Arrays.asList(custInspectItemId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustInspectTask , 转换好的 CCustInspectTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustInspectTask , 转换好的 PoJo 对象
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
	public CCustInspectTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustInspectTask duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustInspectTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustInspectTaskMeta.$$proxy$$();
		inst.setFinishTime(this.getFinishTime());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setActionAdd(this.getActionAdd());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setInspectUserId(this.getInspectUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetInTplList(this.getAssetInTplList());
			inst.setLeader(this.getLeader());
			inst.setCustInspectItemList(this.getCustInspectItemList());
			inst.setMemberList(this.getMemberList());
			inst.setCustInspectTpl(this.getCustInspectTpl());
			inst.setMemberIds(this.getMemberIds());
			inst.setCustInspectItemIds(this.getCustInspectItemIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustInspectTask clone(boolean deep) {
		return EntityContext.clone(CCustInspectTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustInspectTask
	 * @param cCustInspectTaskMap 包含实体信息的 Map 对象
	 * @return CCustInspectTask , 转换好的的 CCustInspectTask 对象
	*/
	@Transient
	public static CCustInspectTask createFrom(Map<String,Object> cCustInspectTaskMap) {
		if(cCustInspectTaskMap==null) return null;
		CCustInspectTask po = create();
		EntityContext.copyProperties(po,cCustInspectTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustInspectTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustInspectTask , 转换好的的 CCustInspectTask 对象
	*/
	@Transient
	public static CCustInspectTask createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustInspectTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustInspectTask，等同于 new
	 * @return CCustInspectTask 对象
	*/
	@Transient
	public static CCustInspectTask create() {
		return new com.dt.platform.domain.eam.meta.CCustInspectTaskMeta.$$proxy$$();
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
			this.setFinishTime(DataParser.parse(Date.class, map.get(CCustInspectTaskMeta.FINISH_TIME)));
			this.setCode(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustInspectTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustInspectTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustInspectTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustInspectTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustInspectTaskMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.DELETE_BY)));
			this.setActionAdd(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.ACTION_ADD)));
			this.setStartTime(DataParser.parse(Date.class, map.get(CCustInspectTaskMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.TPL_ID)));
			this.setInspectUserId(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.INSPECT_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(CCustInspectTaskMeta.STATUS)));
			// others
			this.setLeader(DataParser.parse(Employee.class, map.get(CCustInspectTaskMeta.LEADER)));
			this.setCustInspectTpl(DataParser.parse(CCustInspectTpl.class, map.get(CCustInspectTaskMeta.CUST_INSPECT_TPL)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)map.get(CCustInspectTaskMeta.FINISH_TIME));
				this.setCode( (String)map.get(CCustInspectTaskMeta.CODE));
				this.setNotes( (String)map.get(CCustInspectTaskMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CCustInspectTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CCustInspectTaskMeta.VERSION));
				this.setCreateBy( (String)map.get(CCustInspectTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CCustInspectTaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(CCustInspectTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustInspectTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustInspectTaskMeta.DELETE_TIME));
				this.setName( (String)map.get(CCustInspectTaskMeta.NAME));
				this.setTenantId( (String)map.get(CCustInspectTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CCustInspectTaskMeta.DELETE_BY));
				this.setActionAdd( (String)map.get(CCustInspectTaskMeta.ACTION_ADD));
				this.setStartTime( (Date)map.get(CCustInspectTaskMeta.START_TIME));
				this.setId( (String)map.get(CCustInspectTaskMeta.ID));
				this.setTplId( (String)map.get(CCustInspectTaskMeta.TPL_ID));
				this.setInspectUserId( (String)map.get(CCustInspectTaskMeta.INSPECT_USER_ID));
				this.setStatus( (String)map.get(CCustInspectTaskMeta.STATUS));
				// others
				this.setLeader( (Employee)map.get(CCustInspectTaskMeta.LEADER));
				this.setCustInspectTpl( (CCustInspectTpl)map.get(CCustInspectTaskMeta.CUST_INSPECT_TPL));
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
			this.setFinishTime(DataParser.parse(Date.class, r.getValue(CCustInspectTaskMeta.FINISH_TIME)));
			this.setCode(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustInspectTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustInspectTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustInspectTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustInspectTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustInspectTaskMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.DELETE_BY)));
			this.setActionAdd(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.ACTION_ADD)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(CCustInspectTaskMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.TPL_ID)));
			this.setInspectUserId(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.INSPECT_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CCustInspectTaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)r.getValue(CCustInspectTaskMeta.FINISH_TIME));
				this.setCode( (String)r.getValue(CCustInspectTaskMeta.CODE));
				this.setNotes( (String)r.getValue(CCustInspectTaskMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CCustInspectTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CCustInspectTaskMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CCustInspectTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CCustInspectTaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CCustInspectTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustInspectTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustInspectTaskMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CCustInspectTaskMeta.NAME));
				this.setTenantId( (String)r.getValue(CCustInspectTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CCustInspectTaskMeta.DELETE_BY));
				this.setActionAdd( (String)r.getValue(CCustInspectTaskMeta.ACTION_ADD));
				this.setStartTime( (Date)r.getValue(CCustInspectTaskMeta.START_TIME));
				this.setId( (String)r.getValue(CCustInspectTaskMeta.ID));
				this.setTplId( (String)r.getValue(CCustInspectTaskMeta.TPL_ID));
				this.setInspectUserId( (String)r.getValue(CCustInspectTaskMeta.INSPECT_USER_ID));
				this.setStatus( (String)r.getValue(CCustInspectTaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}