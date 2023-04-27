package com.dt.platform.domain.mobile.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.mobile.SoftwareGroup;
import java.util.Date;
import com.dt.platform.domain.mobile.SoftwareInfo;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 13:58:51
 * @sign 514FA5004EB67753723AE9C7811D0EF1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SoftwareGroupMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * softwareInfoList , 集合类型: LIST , 类型: com.dt.platform.domain.mobile.SoftwareInfo
	*/
	public static final String SOFTWARE_INFO_LIST="softwareInfoList";
	
	/**
	 * softwareInfoList , 集合类型: LIST , 类型: com.dt.platform.domain.mobile.SoftwareInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareGroup,com.dt.platform.domain.mobile.SoftwareInfo> SOFTWARE_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareGroup.class ,SOFTWARE_INFO_LIST, java.util.List.class, "softwareInfoList", "softwareInfoList", com.dt.platform.domain.mobile.SoftwareInfo.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SOFTWARE_INFO_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.mobile.SoftwareGroup {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SoftwareGroup setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public SoftwareGroup setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SoftwareGroup setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SoftwareGroup setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SoftwareGroup setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SoftwareGroup setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SoftwareGroup setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SoftwareGroup setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SoftwareGroup setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SoftwareGroup setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SoftwareGroup setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SoftwareGroup setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SoftwareGroup setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 softwareInfoList
		 * @param softwareInfoList softwareInfoList
		 * @return 当前对象
		*/
		public SoftwareGroup setSoftwareInfoList(List<SoftwareInfo> softwareInfoList) {
			super.change(SOFTWARE_INFO_LIST,super.getSoftwareInfoList(),softwareInfoList);
			super.setSoftwareInfoList(softwareInfoList);
			return this;
		}
	}
}