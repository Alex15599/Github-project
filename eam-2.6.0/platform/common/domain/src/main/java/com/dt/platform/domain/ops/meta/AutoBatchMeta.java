package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.AutoBatch;
import java.util.Date;
import com.dt.platform.domain.ops.AutoNode;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-23 10:28:37
 * @sign 43D1CBDA67D6FD2AE67205D54C67EAB2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoBatchMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoNode
	*/
	public static final String NODE_LIST="nodeList";
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,com.dt.platform.domain.ops.AutoNode> NODE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,NODE_LIST, java.util.List.class, "nodeList", "nodeList", com.dt.platform.domain.ops.AutoNode.class, null);
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String NODE_IDS="nodeIds";
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoBatch,java.lang.String> NODE_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoBatch.class ,NODE_IDS, java.util.List.class, "nodeIds", "nodeIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , STATUS , NOTES , SELECTED_CODE , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , NODE_LIST , NODE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.AutoBatch {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoBatch setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AutoBatch setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AutoBatch setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AutoBatch setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public AutoBatch setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoBatch setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoBatch setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoBatch setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoBatch setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoBatch setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AutoBatch setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AutoBatch setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 nodeList
		 * @param nodeList nodeList
		 * @return 当前对象
		*/
		public AutoBatch setNodeList(List<AutoNode> nodeList) {
			super.change(NODE_LIST,super.getNodeList(),nodeList);
			super.setNodeList(nodeList);
			return this;
		}
		
		/**
		 * 设置 nodeIds
		 * @param nodeIds nodeIds
		 * @return 当前对象
		*/
		public AutoBatch setNodeIds(List<String> nodeIds) {
			super.change(NODE_IDS,super.getNodeIds(),nodeIds);
			super.setNodeIds(nodeIds);
			return this;
		}
	}
}