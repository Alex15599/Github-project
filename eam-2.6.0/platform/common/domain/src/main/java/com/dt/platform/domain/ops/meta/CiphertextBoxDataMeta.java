package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CiphertextBoxData;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 20:34:32
 * @sign C7AEFC0615F0BF8CC26CFD4F5CA8E2CC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CiphertextBoxDataMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 密文箱 , 类型: java.lang.String
	*/
	public static final String BOX_ID="boxId";
	
	/**
	 * 密文箱 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> BOX_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,BOX_ID, java.lang.String.class, "密文箱", "密文箱", java.lang.String.class, null);
	
	/**
	 * 密文类型 , 类型: java.lang.String
	*/
	public static final String BOX_TYPE="boxType";
	
	/**
	 * 密文类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> BOX_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,BOX_TYPE, java.lang.String.class, "密文类型", "密文类型", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 加密 , 类型: java.lang.String
	*/
	public static final String PLAINTEXT="plaintext";
	
	/**
	 * 加密 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> PLAINTEXT_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,PLAINTEXT, java.lang.String.class, "加密", "加密", java.lang.String.class, null);
	
	/**
	 * 密文 , 类型: java.lang.String
	*/
	public static final String CIPHERTEXT="ciphertext";
	
	/**
	 * 密文 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> CIPHERTEXT_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,CIPHERTEXT, java.lang.String.class, "密文", "密文", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextBoxData,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextBoxData.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SOURCE_ID , BOX_ID , BOX_TYPE , NAME , CONTENT , PLAINTEXT , CIPHERTEXT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CiphertextBoxData {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CiphertextBoxData setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public CiphertextBoxData setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 密文箱
		 * @param boxId 密文箱
		 * @return 当前对象
		*/
		public CiphertextBoxData setBoxId(String boxId) {
			super.change(BOX_ID,super.getBoxId(),boxId);
			super.setBoxId(boxId);
			return this;
		}
		
		/**
		 * 设置 密文类型
		 * @param boxType 密文类型
		 * @return 当前对象
		*/
		public CiphertextBoxData setBoxType(String boxType) {
			super.change(BOX_TYPE,super.getBoxType(),boxType);
			super.setBoxType(boxType);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CiphertextBoxData setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public CiphertextBoxData setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 加密
		 * @param plaintext 加密
		 * @return 当前对象
		*/
		public CiphertextBoxData setPlaintext(String plaintext) {
			super.change(PLAINTEXT,super.getPlaintext(),plaintext);
			super.setPlaintext(plaintext);
			return this;
		}
		
		/**
		 * 设置 密文
		 * @param ciphertext 密文
		 * @return 当前对象
		*/
		public CiphertextBoxData setCiphertext(String ciphertext) {
			super.change(CIPHERTEXT,super.getCiphertext(),ciphertext);
			super.setCiphertext(ciphertext);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CiphertextBoxData setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CiphertextBoxData setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CiphertextBoxData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CiphertextBoxData setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CiphertextBoxData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CiphertextBoxData setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CiphertextBoxData setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CiphertextBoxData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CiphertextBoxData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CiphertextBoxData clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CiphertextBoxData duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSourceId(this.getSourceId());
			inst.setCiphertext(this.getCiphertext());
			inst.setNotes(this.getNotes());
			inst.setBoxType(this.getBoxType());
			inst.setPlaintext(this.getPlaintext());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setBoxId(this.getBoxId());
			inst.clearModifies();
			return inst;
		}

	}
}