package com.dt.platform.domain.workorder.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.workorder.SlbStrategyApply;
import java.util.Date;
import com.dt.platform.domain.workorder.SlbStrategyInfo;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 20:04:21
 * @sign 6FCB7C6CE5367D0B1E32C33449C01F7E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SlbStrategyApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 项目名称 , 类型: java.lang.String
	*/
	public static final String PROJECT_NAME="projectName";
	
	/**
	 * 项目名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> PROJECT_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,PROJECT_NAME, java.lang.String.class, "项目名称", "项目名称", java.lang.String.class, null);
	
	/**
	 * 运行环境 , 类型: java.lang.String
	*/
	public static final String ENVIRONMENT_ID="environmentId";
	
	/**
	 * 运行环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> ENVIRONMENT_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,ENVIRONMENT_ID, java.lang.String.class, "运行环境", "运行环境", java.lang.String.class, null);
	
	/**
	 * 有效期 , 类型: java.lang.String
	*/
	public static final String PERIOD_TYPE="periodType";
	
	/**
	 * 有效期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> PERIOD_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,PERIOD_TYPE, java.lang.String.class, "有效期", "有效期", java.lang.String.class, null);
	
	/**
	 * 过期日期 , 类型: java.util.Date
	*/
	public static final String EXPIRATION_DATE="expirationDate";
	
	/**
	 * 过期日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.util.Date> EXPIRATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,EXPIRATION_DATE, java.util.Date.class, "过期日期", "过期日期", java.util.Date.class, null);
	
	/**
	 * 申请日期 , 类型: java.util.Date
	*/
	public static final String APPLY_DATE="applyDate";
	
	/**
	 * 申请日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.util.Date> APPLY_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,APPLY_DATE, java.util.Date.class, "申请日期", "申请日期", java.util.Date.class, null);
	
	/**
	 * 期望日期 , 类型: java.util.Date
	*/
	public static final String EXPECTED_COMPLETION_DATE="expectedCompletionDate";
	
	/**
	 * 期望日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.util.Date> EXPECTED_COMPLETION_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,EXPECTED_COMPLETION_DATE, java.util.Date.class, "期望日期", "期望日期", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,ORIGINATOR_ID, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * slbStrategyInfoList , 集合类型: LIST , 类型: com.dt.platform.domain.workorder.SlbStrategyInfo
	*/
	public static final String SLB_STRATEGY_INFO_LIST="slbStrategyInfoList";
	
	/**
	 * slbStrategyInfoList , 集合类型: LIST , 类型: com.dt.platform.domain.workorder.SlbStrategyInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,com.dt.platform.domain.workorder.SlbStrategyInfo> SLB_STRATEGY_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,SLB_STRATEGY_INFO_LIST, java.util.List.class, "slbStrategyInfoList", "slbStrategyInfoList", com.dt.platform.domain.workorder.SlbStrategyInfo.class, null);
	
	/**
	 * slbStrategyInfoIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SLB_STRATEGY_INFO_IDS="slbStrategyInfoIds";
	
	/**
	 * slbStrategyInfoIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> SLB_STRATEGY_INFO_IDS_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,SLB_STRATEGY_INFO_IDS, java.util.List.class, "slbStrategyInfoIds", "slbStrategyInfoIds", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_USER_NAME="originatorUserName";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,java.lang.String> ORIGINATOR_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,ORIGINATOR_USER_NAME, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyApply,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyApply.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , STATUS , NAME , PROJECT_NAME , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , CONTENT , FILE_ID , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SLB_STRATEGY_INFO_LIST , SLB_STRATEGY_INFO_IDS , ORIGINATOR , ORIGINATOR_USER_NAME , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.workorder.SlbStrategyApply {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SlbStrategyApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public SlbStrategyApply setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public SlbStrategyApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SlbStrategyApply setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 项目名称
		 * @param projectName 项目名称
		 * @return 当前对象
		*/
		public SlbStrategyApply setProjectName(String projectName) {
			super.change(PROJECT_NAME,super.getProjectName(),projectName);
			super.setProjectName(projectName);
			return this;
		}
		
		/**
		 * 设置 运行环境
		 * @param environmentId 运行环境
		 * @return 当前对象
		*/
		public SlbStrategyApply setEnvironmentId(String environmentId) {
			super.change(ENVIRONMENT_ID,super.getEnvironmentId(),environmentId);
			super.setEnvironmentId(environmentId);
			return this;
		}
		
		/**
		 * 设置 有效期
		 * @param periodType 有效期
		 * @return 当前对象
		*/
		public SlbStrategyApply setPeriodType(String periodType) {
			super.change(PERIOD_TYPE,super.getPeriodType(),periodType);
			super.setPeriodType(periodType);
			return this;
		}
		
		/**
		 * 设置 过期日期
		 * @param expirationDate 过期日期
		 * @return 当前对象
		*/
		public SlbStrategyApply setExpirationDate(Date expirationDate) {
			super.change(EXPIRATION_DATE,super.getExpirationDate(),expirationDate);
			super.setExpirationDate(expirationDate);
			return this;
		}
		
		/**
		 * 设置 申请日期
		 * @param applyDate 申请日期
		 * @return 当前对象
		*/
		public SlbStrategyApply setApplyDate(Date applyDate) {
			super.change(APPLY_DATE,super.getApplyDate(),applyDate);
			super.setApplyDate(applyDate);
			return this;
		}
		
		/**
		 * 设置 期望日期
		 * @param expectedCompletionDate 期望日期
		 * @return 当前对象
		*/
		public SlbStrategyApply setExpectedCompletionDate(Date expectedCompletionDate) {
			super.change(EXPECTED_COMPLETION_DATE,super.getExpectedCompletionDate(),expectedCompletionDate);
			super.setExpectedCompletionDate(expectedCompletionDate);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public SlbStrategyApply setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public SlbStrategyApply setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SlbStrategyApply setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorId 申请人
		 * @return 当前对象
		*/
		public SlbStrategyApply setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SlbStrategyApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SlbStrategyApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SlbStrategyApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SlbStrategyApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SlbStrategyApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SlbStrategyApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SlbStrategyApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SlbStrategyApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SlbStrategyApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 slbStrategyInfoList
		 * @param slbStrategyInfoList slbStrategyInfoList
		 * @return 当前对象
		*/
		public SlbStrategyApply setSlbStrategyInfoList(List<SlbStrategyInfo> slbStrategyInfoList) {
			super.change(SLB_STRATEGY_INFO_LIST,super.getSlbStrategyInfoList(),slbStrategyInfoList);
			super.setSlbStrategyInfoList(slbStrategyInfoList);
			return this;
		}
		
		/**
		 * 设置 slbStrategyInfoIds
		 * @param slbStrategyInfoIds slbStrategyInfoIds
		 * @return 当前对象
		*/
		public SlbStrategyApply setSlbStrategyInfoIds(List<String> slbStrategyInfoIds) {
			super.change(SLB_STRATEGY_INFO_IDS,super.getSlbStrategyInfoIds(),slbStrategyInfoIds);
			super.setSlbStrategyInfoIds(slbStrategyInfoIds);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public SlbStrategyApply setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorUserName 申请人
		 * @return 当前对象
		*/
		public SlbStrategyApply setOriginatorUserName(String originatorUserName) {
			super.change(ORIGINATOR_USER_NAME,super.getOriginatorUserName(),originatorUserName);
			super.setOriginatorUserName(originatorUserName);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public SlbStrategyApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public SlbStrategyApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public SlbStrategyApply setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}
	}
}