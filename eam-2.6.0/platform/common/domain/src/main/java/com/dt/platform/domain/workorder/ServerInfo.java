package com.dt.platform.domain.workorder;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WorkorderTables.WO_SERVER_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 服务器资源
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-22 06:38:45
 * @sign DEE89AC6709AAFB0CB71F04221D27DAA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wo_server_info")
public class ServerInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WO_SERVER_INFO.$TABLE;
	
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
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 服务器类型：服务器类型
	*/
	@ApiModelProperty(required = false,value="服务器类型" , notes = "服务器类型")
	private String serverType;
	
	/**
	 * 系统版本：系统版本
	*/
	@ApiModelProperty(required = false,value="系统版本" , notes = "系统版本")
	private String osVersion;
	
	/**
	 * IP地址：IP地址
	*/
	@ApiModelProperty(required = false,value="IP地址" , notes = "IP地址")
	private String ip;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String databaseVersion;
	
	/**
	 * 中间件：中间件
	*/
	@ApiModelProperty(required = false,value="中间件" , notes = "中间件")
	private String middlewareVersion;
	
	/**
	 * CPU数：CPU数
	*/
	@ApiModelProperty(required = false,value="CPU数" , notes = "CPU数")
	private Integer cpu;
	
	/**
	 * 内存(G)：内存(G)
	*/
	@ApiModelProperty(required = false,value="内存(G)" , notes = "内存(G)")
	private Integer memory;
	
	/**
	 * 空间(G)：空间(G)
	*/
	@ApiModelProperty(required = false,value="空间(G)" , notes = "空间(G)")
	private Integer spaceSize;
	
	/**
	 * 数量：数量
	*/
	@ApiModelProperty(required = false,value="数量" , notes = "数量")
	private Integer serverNumber;
	
	/**
	 * 用户列表：用户列表
	*/
	@ApiModelProperty(required = false,value="用户列表" , notes = "用户列表")
	private String userlist;
	
	/**
	 * 端口列表：端口列表
	*/
	@ApiModelProperty(required = false,value="端口列表" , notes = "端口列表")
	private String portlist;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
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
	 * serverOsType：serverOsType
	*/
	@ApiModelProperty(required = false,value="serverOsType" , notes = "serverOsType")
	private ServerOsType serverOsType;
	
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
	public ServerInfo setId(String id) {
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
	public ServerInfo setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public ServerInfo setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 服务器类型<br>
	 * 服务器类型
	 * @return 服务器类型
	*/
	public String getServerType() {
		return serverType;
	}
	
	/**
	 * 设置 服务器类型
	 * @param serverType 服务器类型
	 * @return 当前对象
	*/
	public ServerInfo setServerType(String serverType) {
		this.serverType=serverType;
		return this;
	}
	
	/**
	 * 获得 系统版本<br>
	 * 系统版本
	 * @return 系统版本
	*/
	public String getOsVersion() {
		return osVersion;
	}
	
	/**
	 * 设置 系统版本
	 * @param osVersion 系统版本
	 * @return 当前对象
	*/
	public ServerInfo setOsVersion(String osVersion) {
		this.osVersion=osVersion;
		return this;
	}
	
	/**
	 * 获得 IP地址<br>
	 * IP地址
	 * @return IP地址
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 IP地址
	 * @param ip IP地址
	 * @return 当前对象
	*/
	public ServerInfo setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDatabaseVersion() {
		return databaseVersion;
	}
	
	/**
	 * 设置 数据库
	 * @param databaseVersion 数据库
	 * @return 当前对象
	*/
	public ServerInfo setDatabaseVersion(String databaseVersion) {
		this.databaseVersion=databaseVersion;
		return this;
	}
	
	/**
	 * 获得 中间件<br>
	 * 中间件
	 * @return 中间件
	*/
	public String getMiddlewareVersion() {
		return middlewareVersion;
	}
	
	/**
	 * 设置 中间件
	 * @param middlewareVersion 中间件
	 * @return 当前对象
	*/
	public ServerInfo setMiddlewareVersion(String middlewareVersion) {
		this.middlewareVersion=middlewareVersion;
		return this;
	}
	
	/**
	 * 获得 CPU数<br>
	 * CPU数
	 * @return CPU数
	*/
	public Integer getCpu() {
		return cpu;
	}
	
	/**
	 * 设置 CPU数
	 * @param cpu CPU数
	 * @return 当前对象
	*/
	public ServerInfo setCpu(Integer cpu) {
		this.cpu=cpu;
		return this;
	}
	
	/**
	 * 获得 内存(G)<br>
	 * 内存(G)
	 * @return 内存(G)
	*/
	public Integer getMemory() {
		return memory;
	}
	
	/**
	 * 设置 内存(G)
	 * @param memory 内存(G)
	 * @return 当前对象
	*/
	public ServerInfo setMemory(Integer memory) {
		this.memory=memory;
		return this;
	}
	
	/**
	 * 获得 空间(G)<br>
	 * 空间(G)
	 * @return 空间(G)
	*/
	public Integer getSpaceSize() {
		return spaceSize;
	}
	
	/**
	 * 设置 空间(G)
	 * @param spaceSize 空间(G)
	 * @return 当前对象
	*/
	public ServerInfo setSpaceSize(Integer spaceSize) {
		this.spaceSize=spaceSize;
		return this;
	}
	
	/**
	 * 获得 数量<br>
	 * 数量
	 * @return 数量
	*/
	public Integer getServerNumber() {
		return serverNumber;
	}
	
	/**
	 * 设置 数量
	 * @param serverNumber 数量
	 * @return 当前对象
	*/
	public ServerInfo setServerNumber(Integer serverNumber) {
		this.serverNumber=serverNumber;
		return this;
	}
	
	/**
	 * 获得 用户列表<br>
	 * 用户列表
	 * @return 用户列表
	*/
	public String getUserlist() {
		return userlist;
	}
	
	/**
	 * 设置 用户列表
	 * @param userlist 用户列表
	 * @return 当前对象
	*/
	public ServerInfo setUserlist(String userlist) {
		this.userlist=userlist;
		return this;
	}
	
	/**
	 * 获得 端口列表<br>
	 * 端口列表
	 * @return 端口列表
	*/
	public String getPortlist() {
		return portlist;
	}
	
	/**
	 * 设置 端口列表
	 * @param portlist 端口列表
	 * @return 当前对象
	*/
	public ServerInfo setPortlist(String portlist) {
		this.portlist=portlist;
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
	public ServerInfo setNotes(String notes) {
		this.notes=notes;
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
	public ServerInfo setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public ServerInfo setCreateBy(String createBy) {
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
	public ServerInfo setCreateTime(Date createTime) {
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
	public ServerInfo setUpdateBy(String updateBy) {
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
	public ServerInfo setUpdateTime(Date updateTime) {
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
	public ServerInfo setDeleted(Integer deleted) {
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
	public ServerInfo setDeleted(Boolean deletedBool) {
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
	public ServerInfo setDeleteBy(String deleteBy) {
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
	public ServerInfo setDeleteTime(Date deleteTime) {
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
	public ServerInfo setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 serverOsType<br>
	 * serverOsType
	 * @return serverOsType
	*/
	public ServerOsType getServerOsType() {
		return serverOsType;
	}
	
	/**
	 * 设置 serverOsType
	 * @param serverOsType serverOsType
	 * @return 当前对象
	*/
	public ServerInfo setServerOsType(ServerOsType serverOsType) {
		this.serverOsType=serverOsType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ServerInfo , 转换好的 ServerInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ServerInfo , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ServerInfo
	 * @param serverInfoMap 包含实体信息的 Map 对象
	 * @return ServerInfo , 转换好的的 ServerInfo 对象
	*/
	@Transient
	public static ServerInfo createFrom(Map<String,Object> serverInfoMap) {
		if(serverInfoMap==null) return null;
		ServerInfo po = EntityContext.create(ServerInfo.class, serverInfoMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ServerInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ServerInfo , 转换好的的 ServerInfo 对象
	*/
	@Transient
	public static ServerInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		ServerInfo po = EntityContext.create(ServerInfo.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ServerInfo，等同于 new
	 * @return ServerInfo 对象
	*/
	@Transient
	public static ServerInfo create() {
		return EntityContext.create(ServerInfo.class);
	}
}