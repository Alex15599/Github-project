package com.dt.platform.domain.workorder;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WorkorderTables.WO_SLB_STRATEGY_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 负载策略
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-27 20:38:50
 * @sign 4FEE2B400C4C835965FD09FB6D2BAF36
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wo_slb_strategy_info")
public class SlbStrategyInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WO_SLB_STRATEGY_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerId;
	
	/**
	 * 服务名称：服务名称
	*/
	@ApiModelProperty(required = false,value="服务名称" , notes = "服务名称")
	private String serviceName;
	
	/**
	 * 服务IP：服务IP
	*/
	@ApiModelProperty(required = false,value="服务IP" , notes = "服务IP")
	private String serviceIp;
	
	/**
	 * 节点IP：节点IP
	*/
	@ApiModelProperty(required = false,value="节点IP" , notes = "节点IP")
	private String nodeIp;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口")
	private String port;
	
	/**
	 * 均衡策略：均衡策略
	*/
	@ApiModelProperty(required = false,value="均衡策略" , notes = "均衡策略")
	private String balanceStrategy;
	
	/**
	 * 会话保持：会话保持
	*/
	@ApiModelProperty(required = false,value="会话保持" , notes = "会话保持")
	private String sessionKeep;
	
	/**
	 * 保持方式：保持方式
	*/
	@ApiModelProperty(required = false,value="保持方式" , notes = "保持方式")
	private String sessionKeepMethod;
	
	/**
	 * 使用协议：使用协议
	*/
	@ApiModelProperty(required = false,value="使用协议" , notes = "使用协议")
	private String usedProtocolType;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
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
	public SlbStrategyInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public SlbStrategyInfo setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 服务名称<br>
	 * 服务名称
	 * @return 服务名称
	*/
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * 设置 服务名称
	 * @param serviceName 服务名称
	 * @return 当前对象
	*/
	public SlbStrategyInfo setServiceName(String serviceName) {
		this.serviceName=serviceName;
		return this;
	}
	
	/**
	 * 获得 服务IP<br>
	 * 服务IP
	 * @return 服务IP
	*/
	public String getServiceIp() {
		return serviceIp;
	}
	
	/**
	 * 设置 服务IP
	 * @param serviceIp 服务IP
	 * @return 当前对象
	*/
	public SlbStrategyInfo setServiceIp(String serviceIp) {
		this.serviceIp=serviceIp;
		return this;
	}
	
	/**
	 * 获得 节点IP<br>
	 * 节点IP
	 * @return 节点IP
	*/
	public String getNodeIp() {
		return nodeIp;
	}
	
	/**
	 * 设置 节点IP
	 * @param nodeIp 节点IP
	 * @return 当前对象
	*/
	public SlbStrategyInfo setNodeIp(String nodeIp) {
		this.nodeIp=nodeIp;
		return this;
	}
	
	/**
	 * 获得 端口<br>
	 * 端口
	 * @return 端口
	*/
	public String getPort() {
		return port;
	}
	
	/**
	 * 设置 端口
	 * @param port 端口
	 * @return 当前对象
	*/
	public SlbStrategyInfo setPort(String port) {
		this.port=port;
		return this;
	}
	
	/**
	 * 获得 均衡策略<br>
	 * 均衡策略
	 * @return 均衡策略
	*/
	public String getBalanceStrategy() {
		return balanceStrategy;
	}
	
	/**
	 * 设置 均衡策略
	 * @param balanceStrategy 均衡策略
	 * @return 当前对象
	*/
	public SlbStrategyInfo setBalanceStrategy(String balanceStrategy) {
		this.balanceStrategy=balanceStrategy;
		return this;
	}
	
	/**
	 * 获得 会话保持<br>
	 * 会话保持
	 * @return 会话保持
	*/
	public String getSessionKeep() {
		return sessionKeep;
	}
	
	/**
	 * 设置 会话保持
	 * @param sessionKeep 会话保持
	 * @return 当前对象
	*/
	public SlbStrategyInfo setSessionKeep(String sessionKeep) {
		this.sessionKeep=sessionKeep;
		return this;
	}
	
	/**
	 * 获得 保持方式<br>
	 * 保持方式
	 * @return 保持方式
	*/
	public String getSessionKeepMethod() {
		return sessionKeepMethod;
	}
	
	/**
	 * 设置 保持方式
	 * @param sessionKeepMethod 保持方式
	 * @return 当前对象
	*/
	public SlbStrategyInfo setSessionKeepMethod(String sessionKeepMethod) {
		this.sessionKeepMethod=sessionKeepMethod;
		return this;
	}
	
	/**
	 * 获得 使用协议<br>
	 * 使用协议
	 * @return 使用协议
	*/
	public String getUsedProtocolType() {
		return usedProtocolType;
	}
	
	/**
	 * 设置 使用协议
	 * @param usedProtocolType 使用协议
	 * @return 当前对象
	*/
	public SlbStrategyInfo setUsedProtocolType(String usedProtocolType) {
		this.usedProtocolType=usedProtocolType;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public SlbStrategyInfo setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public SlbStrategyInfo setNotes(String notes) {
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
	public SlbStrategyInfo setCreateBy(String createBy) {
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
	public SlbStrategyInfo setCreateTime(Date createTime) {
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
	public SlbStrategyInfo setUpdateBy(String updateBy) {
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
	public SlbStrategyInfo setUpdateTime(Date updateTime) {
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
	public SlbStrategyInfo setDeleted(Integer deleted) {
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
	public SlbStrategyInfo setDeleted(Boolean deletedBool) {
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
	public SlbStrategyInfo setDeleteBy(String deleteBy) {
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
	public SlbStrategyInfo setDeleteTime(Date deleteTime) {
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
	public SlbStrategyInfo setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SlbStrategyInfo , 转换好的 SlbStrategyInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SlbStrategyInfo , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 SlbStrategyInfo
	 * @param slbStrategyInfoMap 包含实体信息的 Map 对象
	 * @return SlbStrategyInfo , 转换好的的 SlbStrategyInfo 对象
	*/
	@Transient
	public static SlbStrategyInfo createFrom(Map<String,Object> slbStrategyInfoMap) {
		if(slbStrategyInfoMap==null) return null;
		SlbStrategyInfo po = EntityContext.create(SlbStrategyInfo.class, slbStrategyInfoMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 SlbStrategyInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SlbStrategyInfo , 转换好的的 SlbStrategyInfo 对象
	*/
	@Transient
	public static SlbStrategyInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		SlbStrategyInfo po = EntityContext.create(SlbStrategyInfo.class,pojo);
		return po;
	}

	/**
	 * 创建一个 SlbStrategyInfo，等同于 new
	 * @return SlbStrategyInfo 对象
	*/
	@Transient
	public static SlbStrategyInfo create() {
		return EntityContext.create(SlbStrategyInfo.class);
	}
}