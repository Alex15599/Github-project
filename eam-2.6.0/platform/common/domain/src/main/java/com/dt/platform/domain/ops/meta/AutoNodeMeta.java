package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.AutoNode;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.ops.AutoGroup;
import com.dt.platform.domain.ops.AutoVoucher;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-23 19:42:29
 * @sign 74E387C482F2748EBDAC9F33F1BE0C90
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoNodeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,OWNER_CODE, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,GROUP_ID, java.lang.String.class, "分组", "分组", java.lang.String.class, null);
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,TYPE, java.lang.String.class, "节点类型", "节点类型", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 端口 , 类型: java.lang.Integer
	*/
	public static final String PORT="port";
	
	/**
	 * 端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.Integer> PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,PORT, java.lang.Integer.class, "端口", "端口", java.lang.Integer.class, null);
	
	/**
	 * 认证方式 , 类型: java.lang.String
	*/
	public static final String AUTHENTICATION_METHOD="authenticationMethod";
	
	/**
	 * 认证方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> AUTHENTICATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,AUTHENTICATION_METHOD, java.lang.String.class, "认证方式", "认证方式", java.lang.String.class, null);
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final String VOUCHER_ID="voucherId";
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> VOUCHER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,VOUCHER_ID, java.lang.String.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,USER_NAME, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final String PASSWORD="password";
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> PASSWORD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,PASSWORD, java.lang.String.class, "密码", "密码", java.lang.String.class, null);
	
	/**
	 * 公钥 , 类型: java.lang.String
	*/
	public static final String PUB_KEY="pubKey";
	
	/**
	 * 公钥 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> PUB_KEY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,PUB_KEY, java.lang.String.class, "公钥", "公钥", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "typeDict", "typeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * group , 类型: com.dt.platform.domain.ops.AutoGroup
	*/
	public static final String GROUP="group";
	
	/**
	 * group , 类型: com.dt.platform.domain.ops.AutoGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,com.dt.platform.domain.ops.AutoGroup> GROUP_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,GROUP, com.dt.platform.domain.ops.AutoGroup.class, "group", "group", com.dt.platform.domain.ops.AutoGroup.class, null);
	
	/**
	 * voucher , 类型: com.dt.platform.domain.ops.AutoVoucher
	*/
	public static final String VOUCHER="voucher";
	
	/**
	 * voucher , 类型: com.dt.platform.domain.ops.AutoVoucher
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoNode,com.dt.platform.domain.ops.AutoVoucher> VOUCHER_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoNode.class ,VOUCHER, com.dt.platform.domain.ops.AutoVoucher.class, "voucher", "voucher", com.dt.platform.domain.ops.AutoVoucher.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_CODE , NAME , GROUP_ID , TYPE , STATUS , IP , PORT , AUTHENTICATION_METHOD , VOUCHER_ID , USER_NAME , PASSWORD , PUB_KEY , NOTES , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TYPE_DICT , GROUP , VOUCHER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.AutoNode {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoNode setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerCode 归属
		 * @return 当前对象
		*/
		public AutoNode setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AutoNode setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 分组
		 * @param groupId 分组
		 * @return 当前对象
		*/
		public AutoNode setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param type 节点类型
		 * @return 当前对象
		*/
		public AutoNode setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AutoNode setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param ip IP
		 * @return 当前对象
		*/
		public AutoNode setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 端口
		 * @param port 端口
		 * @return 当前对象
		*/
		public AutoNode setPort(Integer port) {
			super.change(PORT,super.getPort(),port);
			super.setPort(port);
			return this;
		}
		
		/**
		 * 设置 认证方式
		 * @param authenticationMethod 认证方式
		 * @return 当前对象
		*/
		public AutoNode setAuthenticationMethod(String authenticationMethod) {
			super.change(AUTHENTICATION_METHOD,super.getAuthenticationMethod(),authenticationMethod);
			super.setAuthenticationMethod(authenticationMethod);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherId 凭证
		 * @return 当前对象
		*/
		public AutoNode setVoucherId(String voucherId) {
			super.change(VOUCHER_ID,super.getVoucherId(),voucherId);
			super.setVoucherId(voucherId);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param userName 账户
		 * @return 当前对象
		*/
		public AutoNode setUserName(String userName) {
			super.change(USER_NAME,super.getUserName(),userName);
			super.setUserName(userName);
			return this;
		}
		
		/**
		 * 设置 密码
		 * @param password 密码
		 * @return 当前对象
		*/
		public AutoNode setPassword(String password) {
			super.change(PASSWORD,super.getPassword(),password);
			super.setPassword(password);
			return this;
		}
		
		/**
		 * 设置 公钥
		 * @param pubKey 公钥
		 * @return 当前对象
		*/
		public AutoNode setPubKey(String pubKey) {
			super.change(PUB_KEY,super.getPubKey(),pubKey);
			super.setPubKey(pubKey);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AutoNode setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoNode setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoNode setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoNode setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoNode setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoNode setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AutoNode setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AutoNode setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 typeDict
		 * @param typeDict typeDict
		 * @return 当前对象
		*/
		public AutoNode setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}
		
		/**
		 * 设置 group
		 * @param group group
		 * @return 当前对象
		*/
		public AutoNode setGroup(AutoGroup group) {
			super.change(GROUP,super.getGroup(),group);
			super.setGroup(group);
			return this;
		}
		
		/**
		 * 设置 voucher
		 * @param voucher voucher
		 * @return 当前对象
		*/
		public AutoNode setVoucher(AutoVoucher voucher) {
			super.change(VOUCHER,super.getVoucher(),voucher);
			super.setVoucher(voucher);
			return this;
		}
	}
}