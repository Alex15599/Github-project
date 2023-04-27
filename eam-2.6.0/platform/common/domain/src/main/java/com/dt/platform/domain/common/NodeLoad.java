package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_NODE_LOAD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.NodeLoadMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 节点负载
 * <p>节点负载 , 数据表 sys_node_load 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 16:58:48
 * @sign BBB7E3F51D7D0477C46725E0D8CC2B25
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_node_load")
@ApiModel(description = "节点负载 ; 节点负载 , 数据表 sys_node_load 的PO类型")
public class NodeLoad extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_NODE_LOAD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点")
	private String node;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP")
	private String ip;
	
	/**
	 * 用户使用率：用户使用率
	*/
	@ApiModelProperty(required = false,value="用户使用率" , notes = "用户使用率")
	private BigDecimal user;
	
	/**
	 * 系统使用率：系统使用率
	*/
	@ApiModelProperty(required = false,value="系统使用率" , notes = "系统使用率")
	private BigDecimal sys;
	
	/**
	 * 空闲使用率：空闲使用率
	*/
	@ApiModelProperty(required = false,value="空闲使用率" , notes = "空闲使用率")
	private BigDecimal idle;
	
	/**
	 * wio：wio
	*/
	@ApiModelProperty(required = false,value="wio" , notes = "wio")
	private BigDecimal wio;
	
	/**
	 * load1：load1
	*/
	@ApiModelProperty(required = false,value="load1" , notes = "load1")
	private BigDecimal load1;
	
	/**
	 * load5：load5
	*/
	@ApiModelProperty(required = false,value="load5" , notes = "load5")
	private BigDecimal load5;
	
	/**
	 * load15：load15
	*/
	@ApiModelProperty(required = false,value="load15" , notes = "load15")
	private BigDecimal load15;
	
	/**
	 * 内存使用：内存使用
	*/
	@ApiModelProperty(required = false,value="内存使用" , notes = "内存使用")
	private BigDecimal memoryUsed;
	
	/**
	 * 内存使用率：内存使用率
	*/
	@ApiModelProperty(required = false,value="内存使用率" , notes = "内存使用率")
	private BigDecimal memoryUsedPct;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
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
	public NodeLoad setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 节点<br>
	 * 节点
	 * @return 节点
	*/
	public String getNode() {
		return node;
	}
	
	/**
	 * 设置 节点
	 * @param node 节点
	 * @return 当前对象
	*/
	public NodeLoad setNode(String node) {
		this.node=node;
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
	public NodeLoad setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 用户使用率<br>
	 * 用户使用率
	 * @return 用户使用率
	*/
	public BigDecimal getUser() {
		return user;
	}
	
	/**
	 * 设置 用户使用率
	 * @param user 用户使用率
	 * @return 当前对象
	*/
	public NodeLoad setUser(BigDecimal user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 系统使用率<br>
	 * 系统使用率
	 * @return 系统使用率
	*/
	public BigDecimal getSys() {
		return sys;
	}
	
	/**
	 * 设置 系统使用率
	 * @param sys 系统使用率
	 * @return 当前对象
	*/
	public NodeLoad setSys(BigDecimal sys) {
		this.sys=sys;
		return this;
	}
	
	/**
	 * 获得 空闲使用率<br>
	 * 空闲使用率
	 * @return 空闲使用率
	*/
	public BigDecimal getIdle() {
		return idle;
	}
	
	/**
	 * 设置 空闲使用率
	 * @param idle 空闲使用率
	 * @return 当前对象
	*/
	public NodeLoad setIdle(BigDecimal idle) {
		this.idle=idle;
		return this;
	}
	
	/**
	 * 获得 wio<br>
	 * wio
	 * @return wio
	*/
	public BigDecimal getWio() {
		return wio;
	}
	
	/**
	 * 设置 wio
	 * @param wio wio
	 * @return 当前对象
	*/
	public NodeLoad setWio(BigDecimal wio) {
		this.wio=wio;
		return this;
	}
	
	/**
	 * 获得 load1<br>
	 * load1
	 * @return load1
	*/
	public BigDecimal getLoad1() {
		return load1;
	}
	
	/**
	 * 设置 load1
	 * @param load1 load1
	 * @return 当前对象
	*/
	public NodeLoad setLoad1(BigDecimal load1) {
		this.load1=load1;
		return this;
	}
	
	/**
	 * 获得 load5<br>
	 * load5
	 * @return load5
	*/
	public BigDecimal getLoad5() {
		return load5;
	}
	
	/**
	 * 设置 load5
	 * @param load5 load5
	 * @return 当前对象
	*/
	public NodeLoad setLoad5(BigDecimal load5) {
		this.load5=load5;
		return this;
	}
	
	/**
	 * 获得 load15<br>
	 * load15
	 * @return load15
	*/
	public BigDecimal getLoad15() {
		return load15;
	}
	
	/**
	 * 设置 load15
	 * @param load15 load15
	 * @return 当前对象
	*/
	public NodeLoad setLoad15(BigDecimal load15) {
		this.load15=load15;
		return this;
	}
	
	/**
	 * 获得 内存使用<br>
	 * 内存使用
	 * @return 内存使用
	*/
	public BigDecimal getMemoryUsed() {
		return memoryUsed;
	}
	
	/**
	 * 设置 内存使用
	 * @param memoryUsed 内存使用
	 * @return 当前对象
	*/
	public NodeLoad setMemoryUsed(BigDecimal memoryUsed) {
		this.memoryUsed=memoryUsed;
		return this;
	}
	
	/**
	 * 获得 内存使用率<br>
	 * 内存使用率
	 * @return 内存使用率
	*/
	public BigDecimal getMemoryUsedPct() {
		return memoryUsedPct;
	}
	
	/**
	 * 设置 内存使用率
	 * @param memoryUsedPct 内存使用率
	 * @return 当前对象
	*/
	public NodeLoad setMemoryUsedPct(BigDecimal memoryUsedPct) {
		this.memoryUsedPct=memoryUsedPct;
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
	public NodeLoad setCreateTime(Date createTime) {
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
	public NodeLoad setUpdateBy(String updateBy) {
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
	public NodeLoad setUpdateTime(Date updateTime) {
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
	public NodeLoad setDeleted(Integer deleted) {
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
	public NodeLoad setDeleted(Boolean deletedBool) {
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
	public NodeLoad setDeleteBy(String deleteBy) {
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
	public NodeLoad setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public NodeLoad setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NodeLoad , 转换好的 NodeLoad 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NodeLoad , 转换好的 PoJo 对象
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
	public NodeLoad clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NodeLoad duplicate(boolean all) {
		com.dt.platform.domain.common.meta.NodeLoadMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.NodeLoadMeta.$$proxy$$();
		inst.setIdle(this.getIdle());
		inst.setIp(this.getIp());
		inst.setLoad5(this.getLoad5());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSys(this.getSys());
		inst.setMemoryUsed(this.getMemoryUsed());
		inst.setVersion(this.getVersion());
		inst.setLoad1(this.getLoad1());
		inst.setMemoryUsedPct(this.getMemoryUsedPct());
		inst.setNode(this.getNode());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setWio(this.getWio());
		inst.setUser(this.getUser());
		inst.setLoad15(this.getLoad15());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NodeLoad clone(boolean deep) {
		return EntityContext.clone(NodeLoad.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NodeLoad
	 * @param nodeLoadMap 包含实体信息的 Map 对象
	 * @return NodeLoad , 转换好的的 NodeLoad 对象
	*/
	@Transient
	public static NodeLoad createFrom(Map<String,Object> nodeLoadMap) {
		if(nodeLoadMap==null) return null;
		NodeLoad po = create();
		EntityContext.copyProperties(po,nodeLoadMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NodeLoad
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NodeLoad , 转换好的的 NodeLoad 对象
	*/
	@Transient
	public static NodeLoad createFrom(Object pojo) {
		if(pojo==null) return null;
		NodeLoad po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NodeLoad，等同于 new
	 * @return NodeLoad 对象
	*/
	@Transient
	public static NodeLoad create() {
		return new com.dt.platform.domain.common.meta.NodeLoadMeta.$$proxy$$();
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
			this.setIdle(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.IDLE)));
			this.setIp(DataParser.parse(String.class, map.get(NodeLoadMeta.IP)));
			this.setLoad5(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.LOAD5)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NodeLoadMeta.UPDATE_TIME)));
			this.setSys(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.SYS)));
			this.setMemoryUsed(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.MEMORY_USED)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NodeLoadMeta.VERSION)));
			this.setLoad1(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.LOAD1)));
			this.setMemoryUsedPct(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.MEMORY_USED_PCT)));
			this.setNode(DataParser.parse(String.class, map.get(NodeLoadMeta.NODE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NodeLoadMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NodeLoadMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NodeLoadMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NodeLoadMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NodeLoadMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NodeLoadMeta.ID)));
			this.setWio(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.WIO)));
			this.setUser(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.USER)));
			this.setLoad15(DataParser.parse(BigDecimal.class, map.get(NodeLoadMeta.LOAD15)));
			// others
			return true;
		} else {
			try {
				this.setIdle( (BigDecimal)map.get(NodeLoadMeta.IDLE));
				this.setIp( (String)map.get(NodeLoadMeta.IP));
				this.setLoad5( (BigDecimal)map.get(NodeLoadMeta.LOAD5));
				this.setUpdateTime( (Date)map.get(NodeLoadMeta.UPDATE_TIME));
				this.setSys( (BigDecimal)map.get(NodeLoadMeta.SYS));
				this.setMemoryUsed( (BigDecimal)map.get(NodeLoadMeta.MEMORY_USED));
				this.setVersion( (Integer)map.get(NodeLoadMeta.VERSION));
				this.setLoad1( (BigDecimal)map.get(NodeLoadMeta.LOAD1));
				this.setMemoryUsedPct( (BigDecimal)map.get(NodeLoadMeta.MEMORY_USED_PCT));
				this.setNode( (String)map.get(NodeLoadMeta.NODE));
				this.setDeleted( (Integer)map.get(NodeLoadMeta.DELETED));
				this.setCreateTime( (Date)map.get(NodeLoadMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NodeLoadMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NodeLoadMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(NodeLoadMeta.DELETE_BY));
				this.setId( (String)map.get(NodeLoadMeta.ID));
				this.setWio( (BigDecimal)map.get(NodeLoadMeta.WIO));
				this.setUser( (BigDecimal)map.get(NodeLoadMeta.USER));
				this.setLoad15( (BigDecimal)map.get(NodeLoadMeta.LOAD15));
				// others
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
			this.setIdle(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.IDLE)));
			this.setIp(DataParser.parse(String.class, r.getValue(NodeLoadMeta.IP)));
			this.setLoad5(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.LOAD5)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NodeLoadMeta.UPDATE_TIME)));
			this.setSys(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.SYS)));
			this.setMemoryUsed(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.MEMORY_USED)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NodeLoadMeta.VERSION)));
			this.setLoad1(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.LOAD1)));
			this.setMemoryUsedPct(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.MEMORY_USED_PCT)));
			this.setNode(DataParser.parse(String.class, r.getValue(NodeLoadMeta.NODE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NodeLoadMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NodeLoadMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NodeLoadMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NodeLoadMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NodeLoadMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NodeLoadMeta.ID)));
			this.setWio(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.WIO)));
			this.setUser(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.USER)));
			this.setLoad15(DataParser.parse(BigDecimal.class, r.getValue(NodeLoadMeta.LOAD15)));
			return true;
		} else {
			try {
				this.setIdle( (BigDecimal)r.getValue(NodeLoadMeta.IDLE));
				this.setIp( (String)r.getValue(NodeLoadMeta.IP));
				this.setLoad5( (BigDecimal)r.getValue(NodeLoadMeta.LOAD5));
				this.setUpdateTime( (Date)r.getValue(NodeLoadMeta.UPDATE_TIME));
				this.setSys( (BigDecimal)r.getValue(NodeLoadMeta.SYS));
				this.setMemoryUsed( (BigDecimal)r.getValue(NodeLoadMeta.MEMORY_USED));
				this.setVersion( (Integer)r.getValue(NodeLoadMeta.VERSION));
				this.setLoad1( (BigDecimal)r.getValue(NodeLoadMeta.LOAD1));
				this.setMemoryUsedPct( (BigDecimal)r.getValue(NodeLoadMeta.MEMORY_USED_PCT));
				this.setNode( (String)r.getValue(NodeLoadMeta.NODE));
				this.setDeleted( (Integer)r.getValue(NodeLoadMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NodeLoadMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NodeLoadMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NodeLoadMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(NodeLoadMeta.DELETE_BY));
				this.setId( (String)r.getValue(NodeLoadMeta.ID));
				this.setWio( (BigDecimal)r.getValue(NodeLoadMeta.WIO));
				this.setUser( (BigDecimal)r.getValue(NodeLoadMeta.USER));
				this.setLoad15( (BigDecimal)r.getValue(NodeLoadMeta.LOAD15));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}