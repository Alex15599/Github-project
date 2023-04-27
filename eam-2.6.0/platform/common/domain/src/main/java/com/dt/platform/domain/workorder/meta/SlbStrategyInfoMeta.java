package com.dt.platform.domain.workorder.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.workorder.SlbStrategyInfo;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-27 20:38:50
 * @sign 4FEE2B400C4C835965FD09FB6D2BAF36
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SlbStrategyInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 服务名称 , 类型: java.lang.String
	*/
	public static final String SERVICE_NAME="serviceName";
	
	/**
	 * 服务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> SERVICE_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,SERVICE_NAME, java.lang.String.class, "服务名称", "服务名称", java.lang.String.class, null);
	
	/**
	 * 服务IP , 类型: java.lang.String
	*/
	public static final String SERVICE_IP="serviceIp";
	
	/**
	 * 服务IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> SERVICE_IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,SERVICE_IP, java.lang.String.class, "服务IP", "服务IP", java.lang.String.class, null);
	
	/**
	 * 节点IP , 类型: java.lang.String
	*/
	public static final String NODE_IP="nodeIp";
	
	/**
	 * 节点IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> NODE_IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,NODE_IP, java.lang.String.class, "节点IP", "节点IP", java.lang.String.class, null);
	
	/**
	 * 端口 , 类型: java.lang.String
	*/
	public static final String PORT="port";
	
	/**
	 * 端口 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> PORT_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,PORT, java.lang.String.class, "端口", "端口", java.lang.String.class, null);
	
	/**
	 * 均衡策略 , 类型: java.lang.String
	*/
	public static final String BALANCE_STRATEGY="balanceStrategy";
	
	/**
	 * 均衡策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> BALANCE_STRATEGY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,BALANCE_STRATEGY, java.lang.String.class, "均衡策略", "均衡策略", java.lang.String.class, null);
	
	/**
	 * 会话保持 , 类型: java.lang.String
	*/
	public static final String SESSION_KEEP="sessionKeep";
	
	/**
	 * 会话保持 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> SESSION_KEEP_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,SESSION_KEEP, java.lang.String.class, "会话保持", "会话保持", java.lang.String.class, null);
	
	/**
	 * 保持方式 , 类型: java.lang.String
	*/
	public static final String SESSION_KEEP_METHOD="sessionKeepMethod";
	
	/**
	 * 保持方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> SESSION_KEEP_METHOD_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,SESSION_KEEP_METHOD, java.lang.String.class, "保持方式", "保持方式", java.lang.String.class, null);
	
	/**
	 * 使用协议 , 类型: java.lang.String
	*/
	public static final String USED_PROTOCOL_TYPE="usedProtocolType";
	
	/**
	 * 使用协议 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> USED_PROTOCOL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,USED_PROTOCOL_TYPE, java.lang.String.class, "使用协议", "使用协议", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_ID , SERVICE_NAME , SERVICE_IP , NODE_IP , PORT , BALANCE_STRATEGY , SESSION_KEEP , SESSION_KEEP_METHOD , USED_PROTOCOL_TYPE , SELECTED_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.workorder.SlbStrategyInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SlbStrategyInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public SlbStrategyInfo setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 服务名称
		 * @param serviceName 服务名称
		 * @return 当前对象
		*/
		public SlbStrategyInfo setServiceName(String serviceName) {
			super.change(SERVICE_NAME,super.getServiceName(),serviceName);
			super.setServiceName(serviceName);
			return this;
		}
		
		/**
		 * 设置 服务IP
		 * @param serviceIp 服务IP
		 * @return 当前对象
		*/
		public SlbStrategyInfo setServiceIp(String serviceIp) {
			super.change(SERVICE_IP,super.getServiceIp(),serviceIp);
			super.setServiceIp(serviceIp);
			return this;
		}
		
		/**
		 * 设置 节点IP
		 * @param nodeIp 节点IP
		 * @return 当前对象
		*/
		public SlbStrategyInfo setNodeIp(String nodeIp) {
			super.change(NODE_IP,super.getNodeIp(),nodeIp);
			super.setNodeIp(nodeIp);
			return this;
		}
		
		/**
		 * 设置 端口
		 * @param port 端口
		 * @return 当前对象
		*/
		public SlbStrategyInfo setPort(String port) {
			super.change(PORT,super.getPort(),port);
			super.setPort(port);
			return this;
		}
		
		/**
		 * 设置 均衡策略
		 * @param balanceStrategy 均衡策略
		 * @return 当前对象
		*/
		public SlbStrategyInfo setBalanceStrategy(String balanceStrategy) {
			super.change(BALANCE_STRATEGY,super.getBalanceStrategy(),balanceStrategy);
			super.setBalanceStrategy(balanceStrategy);
			return this;
		}
		
		/**
		 * 设置 会话保持
		 * @param sessionKeep 会话保持
		 * @return 当前对象
		*/
		public SlbStrategyInfo setSessionKeep(String sessionKeep) {
			super.change(SESSION_KEEP,super.getSessionKeep(),sessionKeep);
			super.setSessionKeep(sessionKeep);
			return this;
		}
		
		/**
		 * 设置 保持方式
		 * @param sessionKeepMethod 保持方式
		 * @return 当前对象
		*/
		public SlbStrategyInfo setSessionKeepMethod(String sessionKeepMethod) {
			super.change(SESSION_KEEP_METHOD,super.getSessionKeepMethod(),sessionKeepMethod);
			super.setSessionKeepMethod(sessionKeepMethod);
			return this;
		}
		
		/**
		 * 设置 使用协议
		 * @param usedProtocolType 使用协议
		 * @return 当前对象
		*/
		public SlbStrategyInfo setUsedProtocolType(String usedProtocolType) {
			super.change(USED_PROTOCOL_TYPE,super.getUsedProtocolType(),usedProtocolType);
			super.setUsedProtocolType(usedProtocolType);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public SlbStrategyInfo setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SlbStrategyInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SlbStrategyInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SlbStrategyInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SlbStrategyInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SlbStrategyInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SlbStrategyInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SlbStrategyInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SlbStrategyInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SlbStrategyInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}