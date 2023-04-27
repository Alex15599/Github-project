package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-23 19:42:29
 * @sign 74E387C482F2748EBDAC9F33F1BE0C90
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_node")
public class AutoNode extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_NODE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String ownerCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 分组：分组
	*/
	@ApiModelProperty(required = false,value="分组" , notes = "分组")
	private String groupId;
	
	/**
	 * 节点类型：节点类型
	*/
	@ApiModelProperty(required = false,value="节点类型" , notes = "节点类型")
	private String type;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP")
	private String ip;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口")
	private Integer port;
	
	/**
	 * 认证方式：认证方式
	*/
	@ApiModelProperty(required = false,value="认证方式" , notes = "认证方式")
	private String authenticationMethod;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private String voucherId;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户")
	private String userName;
	
	/**
	 * 密码：密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "密码")
	private String password;
	
	/**
	 * 公钥：公钥
	*/
	@ApiModelProperty(required = false,value="公钥" , notes = "公钥")
	private String pubKey;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * typeDict：typeDict
	*/
	@ApiModelProperty(required = false,value="typeDict" , notes = "typeDict")
	private DictItem typeDict;
	
	/**
	 * group：group
	*/
	@ApiModelProperty(required = false,value="group" , notes = "group")
	private AutoGroup group;
	
	/**
	 * voucher：voucher
	*/
	@ApiModelProperty(required = false,value="voucher" , notes = "voucher")
	private AutoVoucher voucher;
	
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
	public AutoNode setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public AutoNode setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
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
	public AutoNode setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 分组<br>
	 * 分组
	 * @return 分组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 分组
	 * @param groupId 分组
	 * @return 当前对象
	*/
	public AutoNode setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 节点类型<br>
	 * 节点类型
	 * @return 节点类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 节点类型
	 * @param type 节点类型
	 * @return 当前对象
	*/
	public AutoNode setType(String type) {
		this.type=type;
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
	public AutoNode setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 IP<br>
	 * IP
	 * @return IP
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 IP
	 * @param ip IP
	 * @return 当前对象
	*/
	public AutoNode setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 端口<br>
	 * 端口
	 * @return 端口
	*/
	public Integer getPort() {
		return port;
	}
	
	/**
	 * 设置 端口
	 * @param port 端口
	 * @return 当前对象
	*/
	public AutoNode setPort(Integer port) {
		this.port=port;
		return this;
	}
	
	/**
	 * 获得 认证方式<br>
	 * 认证方式
	 * @return 认证方式
	*/
	public String getAuthenticationMethod() {
		return authenticationMethod;
	}
	
	/**
	 * 设置 认证方式
	 * @param authenticationMethod 认证方式
	 * @return 当前对象
	*/
	public AutoNode setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod=authenticationMethod;
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public String getVoucherId() {
		return voucherId;
	}
	
	/**
	 * 设置 凭证
	 * @param voucherId 凭证
	 * @return 当前对象
	*/
	public AutoNode setVoucherId(String voucherId) {
		this.voucherId=voucherId;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 账户
	 * @param userName 账户
	 * @return 当前对象
	*/
	public AutoNode setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * 密码
	 * @return 密码
	*/
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置 密码
	 * @param password 密码
	 * @return 当前对象
	*/
	public AutoNode setPassword(String password) {
		this.password=password;
		return this;
	}
	
	/**
	 * 获得 公钥<br>
	 * 公钥
	 * @return 公钥
	*/
	public String getPubKey() {
		return pubKey;
	}
	
	/**
	 * 设置 公钥
	 * @param pubKey 公钥
	 * @return 当前对象
	*/
	public AutoNode setPubKey(String pubKey) {
		this.pubKey=pubKey;
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
	public AutoNode setNotes(String notes) {
		this.notes=notes;
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
	public AutoNode setUpdateBy(String updateBy) {
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
	public AutoNode setUpdateTime(Date updateTime) {
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
	public AutoNode setDeleted(Integer deleted) {
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
	public AutoNode setDeleted(Boolean deletedBool) {
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
	public AutoNode setDeleteBy(String deleteBy) {
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
	public AutoNode setDeleteTime(Date deleteTime) {
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
	public AutoNode setVersion(Integer version) {
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
	public AutoNode setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 typeDict<br>
	 * typeDict
	 * @return typeDict
	*/
	public DictItem getTypeDict() {
		return typeDict;
	}
	
	/**
	 * 设置 typeDict
	 * @param typeDict typeDict
	 * @return 当前对象
	*/
	public AutoNode setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
		return this;
	}
	
	/**
	 * 获得 group<br>
	 * group
	 * @return group
	*/
	public AutoGroup getGroup() {
		return group;
	}
	
	/**
	 * 设置 group
	 * @param group group
	 * @return 当前对象
	*/
	public AutoNode setGroup(AutoGroup group) {
		this.group=group;
		return this;
	}
	
	/**
	 * 获得 voucher<br>
	 * voucher
	 * @return voucher
	*/
	public AutoVoucher getVoucher() {
		return voucher;
	}
	
	/**
	 * 设置 voucher
	 * @param voucher voucher
	 * @return 当前对象
	*/
	public AutoNode setVoucher(AutoVoucher voucher) {
		this.voucher=voucher;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoNode , 转换好的 AutoNode 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoNode , 转换好的 PoJo 对象
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
	public AutoNode clone() {
		return EntityContext.clone(AutoNode.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoNode clone(boolean deep) {
		return EntityContext.clone(AutoNode.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoNode
	 * @param autoNodeMap 包含实体信息的 Map 对象
	 * @return AutoNode , 转换好的的 AutoNode 对象
	*/
	@Transient
	public static AutoNode createFrom(Map<String,Object> autoNodeMap) {
		if(autoNodeMap==null) return null;
		AutoNode po = EntityContext.create(AutoNode.class, autoNodeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoNode
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoNode , 转换好的的 AutoNode 对象
	*/
	@Transient
	public static AutoNode createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoNode po = EntityContext.create(AutoNode.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AutoNode，等同于 new
	 * @return AutoNode 对象
	*/
	@Transient
	public static AutoNode create() {
		return EntityContext.create(AutoNode.class);
	}
}