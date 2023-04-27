package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.PersonnelDivision;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 20:39:58
 * @sign 0032BADDAD5811889AD0B644278D7AF6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonnelDivisionMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER="owner";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> OWNER_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,OWNER, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final String POS="pos";
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> POS_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,POS, java.lang.String.class, "岗位", "岗位", java.lang.String.class, null);
	
	/**
	 * 负责内容 , 类型: java.lang.String
	*/
	public static final String RESPONSIBLE_CONTENT="responsibleContent";
	
	/**
	 * 负责内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> RESPONSIBLE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,RESPONSIBLE_CONTENT, java.lang.String.class, "负责内容", "负责内容", java.lang.String.class, null);
	
	/**
	 * 工作内容 , 类型: java.lang.String
	*/
	public static final String JOB_CONTENT="jobContent";
	
	/**
	 * 工作内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> JOB_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,JOB_CONTENT, java.lang.String.class, "工作内容", "工作内容", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * ownerData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String OWNER_DATA="ownerData";
	
	/**
	 * ownerData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,org.github.foxnic.web.domain.system.DictItem> OWNER_DATA_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,OWNER_DATA, org.github.foxnic.web.domain.system.DictItem.class, "ownerData", "ownerData", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivision,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivision.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , OWNER , USER_ID , POS , RESPONSIBLE_CONTENT , JOB_CONTENT , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , OWNER_DATA , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.PersonnelDivision {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonnelDivision setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PersonnelDivision setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param owner 所属
		 * @return 当前对象
		*/
		public PersonnelDivision setOwner(String owner) {
			super.change(OWNER,super.getOwner(),owner);
			super.setOwner(owner);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public PersonnelDivision setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 岗位
		 * @param pos 岗位
		 * @return 当前对象
		*/
		public PersonnelDivision setPos(String pos) {
			super.change(POS,super.getPos(),pos);
			super.setPos(pos);
			return this;
		}
		
		/**
		 * 设置 负责内容
		 * @param responsibleContent 负责内容
		 * @return 当前对象
		*/
		public PersonnelDivision setResponsibleContent(String responsibleContent) {
			super.change(RESPONSIBLE_CONTENT,super.getResponsibleContent(),responsibleContent);
			super.setResponsibleContent(responsibleContent);
			return this;
		}
		
		/**
		 * 设置 工作内容
		 * @param jobContent 工作内容
		 * @return 当前对象
		*/
		public PersonnelDivision setJobContent(String jobContent) {
			super.change(JOB_CONTENT,super.getJobContent(),jobContent);
			super.setJobContent(jobContent);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonnelDivision setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public PersonnelDivision setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonnelDivision setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonnelDivision setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonnelDivision setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonnelDivision setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonnelDivision setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonnelDivision setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonnelDivision setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonnelDivision setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 ownerData
		 * @param ownerData ownerData
		 * @return 当前对象
		*/
		public PersonnelDivision setOwnerData(DictItem ownerData) {
			super.change(OWNER_DATA,super.getOwnerData(),ownerData);
			super.setOwnerData(ownerData);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public PersonnelDivision setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonnelDivision clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonnelDivision duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOwner(this.getOwner());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setJobContent(this.getJobContent());
			inst.setSort(this.getSort());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPos(this.getPos());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setResponsibleContent(this.getResponsibleContent());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setOwnerData(this.getOwnerData());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}