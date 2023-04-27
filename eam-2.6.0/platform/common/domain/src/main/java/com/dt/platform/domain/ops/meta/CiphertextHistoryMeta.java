package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CiphertextHistory;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 14:16:45
 * @sign 4C8E99230F8B93AB9E44AF2623C2C755
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CiphertextHistoryMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 密文箱类型 , 类型: java.lang.String
	*/
	public static final String BOX_TYPE="boxType";
	
	/**
	 * 密文箱类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> BOX_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,BOX_TYPE, java.lang.String.class, "密文箱类型", "密文箱类型", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_VALUE="sourceValue";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> SOURCE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,SOURCE_VALUE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 加密内容 , 类型: java.lang.String
	*/
	public static final String ENCRYPTION_CONTENT="encryptionContent";
	
	/**
	 * 加密内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> ENCRYPTION_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,ENCRYPTION_CONTENT, java.lang.String.class, "加密内容", "加密内容", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextHistory,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextHistory.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , BOX_TYPE , SOURCE_VALUE , CONTENT , ENCRYPTION_CONTENT , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CiphertextHistory {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CiphertextHistory setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public CiphertextHistory setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 密文箱类型
		 * @param boxType 密文箱类型
		 * @return 当前对象
		*/
		public CiphertextHistory setBoxType(String boxType) {
			super.change(BOX_TYPE,super.getBoxType(),boxType);
			super.setBoxType(boxType);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceValue 来源
		 * @return 当前对象
		*/
		public CiphertextHistory setSourceValue(String sourceValue) {
			super.change(SOURCE_VALUE,super.getSourceValue(),sourceValue);
			super.setSourceValue(sourceValue);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public CiphertextHistory setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 加密内容
		 * @param encryptionContent 加密内容
		 * @return 当前对象
		*/
		public CiphertextHistory setEncryptionContent(String encryptionContent) {
			super.change(ENCRYPTION_CONTENT,super.getEncryptionContent(),encryptionContent);
			super.setEncryptionContent(encryptionContent);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CiphertextHistory setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CiphertextHistory setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CiphertextHistory setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CiphertextHistory setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CiphertextHistory setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CiphertextHistory setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CiphertextHistory setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CiphertextHistory clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CiphertextHistory duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setEncryptionContent(this.getEncryptionContent());
			inst.setBoxType(this.getBoxType());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setSourceValue(this.getSourceValue());
			inst.clearModifies();
			return inst;
		}

	}
}