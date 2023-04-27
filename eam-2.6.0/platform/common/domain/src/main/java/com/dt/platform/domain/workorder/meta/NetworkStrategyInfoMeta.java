package com.dt.platform.domain.workorder.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.workorder.NetworkStrategyInfo;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-06 06:16:46
 * @sign 68905C1676F1D6517B0DBC155EDAC4EE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetworkStrategyInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 源名称 , 类型: java.lang.String
	*/
	public static final String SOURCE_NAME="sourceName";
	
	/**
	 * 源名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> SOURCE_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,SOURCE_NAME, java.lang.String.class, "源名称", "源名称", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 源IP , 类型: java.lang.String
	*/
	public static final String SOURCE_IP="sourceIp";
	
	/**
	 * 源IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> SOURCE_IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,SOURCE_IP, java.lang.String.class, "源IP", "源IP", java.lang.String.class, null);
	
	/**
	 * 目标名称 , 类型: java.lang.String
	*/
	public static final String TARGET_NAME="targetName";
	
	/**
	 * 目标名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> TARGET_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,TARGET_NAME, java.lang.String.class, "目标名称", "目标名称", java.lang.String.class, null);
	
	/**
	 * 目标IP , 类型: java.lang.String
	*/
	public static final String TARGET_IP="targetIp";
	
	/**
	 * 目标IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> TARGET_IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,TARGET_IP, java.lang.String.class, "目标IP", "目标IP", java.lang.String.class, null);
	
	/**
	 * 目标端口 , 类型: java.lang.String
	*/
	public static final String TARGET_PORTS="targetPorts";
	
	/**
	 * 目标端口 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> TARGET_PORTS_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,TARGET_PORTS, java.lang.String.class, "目标端口", "目标端口", java.lang.String.class, null);
	
	/**
	 * 使用协议 , 类型: java.lang.String
	*/
	public static final String USED_PROTOCOL_TYPE="usedProtocolType";
	
	/**
	 * 使用协议 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> USED_PROTOCOL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,USED_PROTOCOL_TYPE, java.lang.String.class, "使用协议", "使用协议", java.lang.String.class, null);
	
	/**
	 * 连接类型 , 类型: java.lang.String
	*/
	public static final String SESSION_TYPE="sessionType";
	
	/**
	 * 连接类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> SESSION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,SESSION_TYPE, java.lang.String.class, "连接类型", "连接类型", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.NetworkStrategyInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.NetworkStrategyInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SOURCE_NAME , OWNER_ID , SOURCE_IP , TARGET_NAME , TARGET_IP , TARGET_PORTS , USED_PROTOCOL_TYPE , SESSION_TYPE , NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.workorder.NetworkStrategyInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 源名称
		 * @param sourceName 源名称
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setSourceName(String sourceName) {
			super.change(SOURCE_NAME,super.getSourceName(),sourceName);
			super.setSourceName(sourceName);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 源IP
		 * @param sourceIp 源IP
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setSourceIp(String sourceIp) {
			super.change(SOURCE_IP,super.getSourceIp(),sourceIp);
			super.setSourceIp(sourceIp);
			return this;
		}
		
		/**
		 * 设置 目标名称
		 * @param targetName 目标名称
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setTargetName(String targetName) {
			super.change(TARGET_NAME,super.getTargetName(),targetName);
			super.setTargetName(targetName);
			return this;
		}
		
		/**
		 * 设置 目标IP
		 * @param targetIp 目标IP
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setTargetIp(String targetIp) {
			super.change(TARGET_IP,super.getTargetIp(),targetIp);
			super.setTargetIp(targetIp);
			return this;
		}
		
		/**
		 * 设置 目标端口
		 * @param targetPorts 目标端口
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setTargetPorts(String targetPorts) {
			super.change(TARGET_PORTS,super.getTargetPorts(),targetPorts);
			super.setTargetPorts(targetPorts);
			return this;
		}
		
		/**
		 * 设置 使用协议
		 * @param usedProtocolType 使用协议
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setUsedProtocolType(String usedProtocolType) {
			super.change(USED_PROTOCOL_TYPE,super.getUsedProtocolType(),usedProtocolType);
			super.setUsedProtocolType(usedProtocolType);
			return this;
		}
		
		/**
		 * 设置 连接类型
		 * @param sessionType 连接类型
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setSessionType(String sessionType) {
			super.change(SESSION_TYPE,super.getSessionType(),sessionType);
			super.setSessionType(sessionType);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public NetworkStrategyInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}