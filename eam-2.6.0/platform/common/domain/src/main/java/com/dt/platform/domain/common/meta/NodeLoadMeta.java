package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.NodeLoad;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 16:58:48
 * @sign BBB7E3F51D7D0477C46725E0D8CC2B25
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NodeLoadMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE="node";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.String> NODE_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,NODE, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 用户使用率 , 类型: java.math.BigDecimal
	*/
	public static final String USER="user";
	
	/**
	 * 用户使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> USER_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,USER, java.math.BigDecimal.class, "用户使用率", "用户使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 系统使用率 , 类型: java.math.BigDecimal
	*/
	public static final String SYS="sys";
	
	/**
	 * 系统使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> SYS_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,SYS, java.math.BigDecimal.class, "系统使用率", "系统使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 空闲使用率 , 类型: java.math.BigDecimal
	*/
	public static final String IDLE="idle";
	
	/**
	 * 空闲使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> IDLE_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,IDLE, java.math.BigDecimal.class, "空闲使用率", "空闲使用率", java.math.BigDecimal.class, null);
	
	/**
	 * wio , 类型: java.math.BigDecimal
	*/
	public static final String WIO="wio";
	
	/**
	 * wio , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> WIO_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,WIO, java.math.BigDecimal.class, "wio", "wio", java.math.BigDecimal.class, null);
	
	/**
	 * load1 , 类型: java.math.BigDecimal
	*/
	public static final String LOAD1="load1";
	
	/**
	 * load1 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> LOAD1_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,LOAD1, java.math.BigDecimal.class, "load1", "load1", java.math.BigDecimal.class, null);
	
	/**
	 * load5 , 类型: java.math.BigDecimal
	*/
	public static final String LOAD5="load5";
	
	/**
	 * load5 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> LOAD5_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,LOAD5, java.math.BigDecimal.class, "load5", "load5", java.math.BigDecimal.class, null);
	
	/**
	 * load15 , 类型: java.math.BigDecimal
	*/
	public static final String LOAD15="load15";
	
	/**
	 * load15 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> LOAD15_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,LOAD15, java.math.BigDecimal.class, "load15", "load15", java.math.BigDecimal.class, null);
	
	/**
	 * 内存使用 , 类型: java.math.BigDecimal
	*/
	public static final String MEMORY_USED="memoryUsed";
	
	/**
	 * 内存使用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> MEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,MEMORY_USED, java.math.BigDecimal.class, "内存使用", "内存使用", java.math.BigDecimal.class, null);
	
	/**
	 * 内存使用率 , 类型: java.math.BigDecimal
	*/
	public static final String MEMORY_USED_PCT="memoryUsedPct";
	
	/**
	 * 内存使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.math.BigDecimal> MEMORY_USED_PCT_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,MEMORY_USED_PCT, java.math.BigDecimal.class, "内存使用率", "内存使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.NodeLoad,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.NodeLoad.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NODE , IP , USER , SYS , IDLE , WIO , LOAD1 , LOAD5 , LOAD15 , MEMORY_USED , MEMORY_USED_PCT , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.NodeLoad {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NodeLoad setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param node 节点
		 * @return 当前对象
		*/
		public NodeLoad setNode(String node) {
			super.change(NODE,super.getNode(),node);
			super.setNode(node);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param ip IP
		 * @return 当前对象
		*/
		public NodeLoad setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 用户使用率
		 * @param user 用户使用率
		 * @return 当前对象
		*/
		public NodeLoad setUser(BigDecimal user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 系统使用率
		 * @param sys 系统使用率
		 * @return 当前对象
		*/
		public NodeLoad setSys(BigDecimal sys) {
			super.change(SYS,super.getSys(),sys);
			super.setSys(sys);
			return this;
		}
		
		/**
		 * 设置 空闲使用率
		 * @param idle 空闲使用率
		 * @return 当前对象
		*/
		public NodeLoad setIdle(BigDecimal idle) {
			super.change(IDLE,super.getIdle(),idle);
			super.setIdle(idle);
			return this;
		}
		
		/**
		 * 设置 wio
		 * @param wio wio
		 * @return 当前对象
		*/
		public NodeLoad setWio(BigDecimal wio) {
			super.change(WIO,super.getWio(),wio);
			super.setWio(wio);
			return this;
		}
		
		/**
		 * 设置 load1
		 * @param load1 load1
		 * @return 当前对象
		*/
		public NodeLoad setLoad1(BigDecimal load1) {
			super.change(LOAD1,super.getLoad1(),load1);
			super.setLoad1(load1);
			return this;
		}
		
		/**
		 * 设置 load5
		 * @param load5 load5
		 * @return 当前对象
		*/
		public NodeLoad setLoad5(BigDecimal load5) {
			super.change(LOAD5,super.getLoad5(),load5);
			super.setLoad5(load5);
			return this;
		}
		
		/**
		 * 设置 load15
		 * @param load15 load15
		 * @return 当前对象
		*/
		public NodeLoad setLoad15(BigDecimal load15) {
			super.change(LOAD15,super.getLoad15(),load15);
			super.setLoad15(load15);
			return this;
		}
		
		/**
		 * 设置 内存使用
		 * @param memoryUsed 内存使用
		 * @return 当前对象
		*/
		public NodeLoad setMemoryUsed(BigDecimal memoryUsed) {
			super.change(MEMORY_USED,super.getMemoryUsed(),memoryUsed);
			super.setMemoryUsed(memoryUsed);
			return this;
		}
		
		/**
		 * 设置 内存使用率
		 * @param memoryUsedPct 内存使用率
		 * @return 当前对象
		*/
		public NodeLoad setMemoryUsedPct(BigDecimal memoryUsedPct) {
			super.change(MEMORY_USED_PCT,super.getMemoryUsedPct(),memoryUsedPct);
			super.setMemoryUsedPct(memoryUsedPct);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NodeLoad setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NodeLoad setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NodeLoad setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NodeLoad setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NodeLoad setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NodeLoad setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public NodeLoad setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}