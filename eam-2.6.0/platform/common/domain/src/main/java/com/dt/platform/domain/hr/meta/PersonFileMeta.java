package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonFile;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:18:21
 * @sign 57BD3B68577C069CF6EFD1ACE6C89E41
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonFileMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 档案编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 档案编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,CODE, java.lang.String.class, "档案编号", "档案编号", java.lang.String.class, null);
	
	/**
	 * 档案状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 档案状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,STATUS, java.lang.String.class, "档案状态", "档案状态", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,USER_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 是否新建档 , 类型: java.lang.String
	*/
	public static final String IF_NEW="ifNew";
	
	/**
	 * 是否新建档 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> IF_NEW_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,IF_NEW, java.lang.String.class, "是否新建档", "是否新建档", java.lang.String.class, null);
	
	/**
	 * 档案保管地 , 类型: java.lang.String
	*/
	public static final String SAVE_LOC="saveLoc";
	
	/**
	 * 档案保管地 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> SAVE_LOC_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,SAVE_LOC, java.lang.String.class, "档案保管地", "档案保管地", java.lang.String.class, null);
	
	/**
	 * 参加工作时间 , 类型: java.lang.String
	*/
	public static final String WORK_START_DATE="workStartDate";
	
	/**
	 * 参加工作时间 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> WORK_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,WORK_START_DATE, java.lang.String.class, "参加工作时间", "参加工作时间", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE="file";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> FILE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,FILE, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> NOTE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonFile,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonFile.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , STATUS , USER_ID , IF_NEW , SAVE_LOC , WORK_START_DATE , FILE , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonFile {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonFile setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 档案编号
		 * @param code 档案编号
		 * @return 当前对象
		*/
		public PersonFile setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 档案状态
		 * @param status 档案状态
		 * @return 当前对象
		*/
		public PersonFile setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param userId 人员
		 * @return 当前对象
		*/
		public PersonFile setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 是否新建档
		 * @param ifNew 是否新建档
		 * @return 当前对象
		*/
		public PersonFile setIfNew(String ifNew) {
			super.change(IF_NEW,super.getIfNew(),ifNew);
			super.setIfNew(ifNew);
			return this;
		}
		
		/**
		 * 设置 档案保管地
		 * @param saveLoc 档案保管地
		 * @return 当前对象
		*/
		public PersonFile setSaveLoc(String saveLoc) {
			super.change(SAVE_LOC,super.getSaveLoc(),saveLoc);
			super.setSaveLoc(saveLoc);
			return this;
		}
		
		/**
		 * 设置 参加工作时间
		 * @param workStartDate 参加工作时间
		 * @return 当前对象
		*/
		public PersonFile setWorkStartDate(String workStartDate) {
			super.change(WORK_START_DATE,super.getWorkStartDate(),workStartDate);
			super.setWorkStartDate(workStartDate);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param file 附件
		 * @return 当前对象
		*/
		public PersonFile setFile(String file) {
			super.change(FILE,super.getFile(),file);
			super.setFile(file);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public PersonFile setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonFile setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonFile setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonFile setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonFile setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonFile setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonFile setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonFile setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonFile setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonFile setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonFile clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonFile duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNote(this.getNote());
			inst.setCode(this.getCode());
			inst.setSaveLoc(this.getSaveLoc());
			inst.setWorkStartDate(this.getWorkStartDate());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setFile(this.getFile());
			inst.setDeleted(this.getDeleted());
			inst.setIfNew(this.getIfNew());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}