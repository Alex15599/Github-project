package com.dt.platform.domain.workorder.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.workorder.ServerApply;
import java.util.Date;
import com.dt.platform.domain.workorder.ServerInfo;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 20:04:01
 * @sign 467338BB2B362B870B413CBE43D6D71B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ServerApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 项目名称 , 类型: java.lang.String
	*/
	public static final String PROJECT_NAME="projectName";
	
	/**
	 * 项目名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> PROJECT_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,PROJECT_NAME, java.lang.String.class, "项目名称", "项目名称", java.lang.String.class, null);
	
	/**
	 * 运行环境 , 类型: java.lang.String
	*/
	public static final String ENVIRONMENT_ID="environmentId";
	
	/**
	 * 运行环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> ENVIRONMENT_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,ENVIRONMENT_ID, java.lang.String.class, "运行环境", "运行环境", java.lang.String.class, null);
	
	/**
	 * 有效期 , 类型: java.lang.String
	*/
	public static final String PERIOD_TYPE="periodType";
	
	/**
	 * 有效期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> PERIOD_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,PERIOD_TYPE, java.lang.String.class, "有效期", "有效期", java.lang.String.class, null);
	
	/**
	 * 过期日期 , 类型: java.util.Date
	*/
	public static final String EXPIRATION_DATE="expirationDate";
	
	/**
	 * 过期日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> EXPIRATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,EXPIRATION_DATE, java.util.Date.class, "过期日期", "过期日期", java.util.Date.class, null);
	
	/**
	 * 申请日期 , 类型: java.util.Date
	*/
	public static final String APPLY_DATE="applyDate";
	
	/**
	 * 申请日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> APPLY_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,APPLY_DATE, java.util.Date.class, "申请日期", "申请日期", java.util.Date.class, null);
	
	/**
	 * 期望日期 , 类型: java.util.Date
	*/
	public static final String EXPECTED_COMPLETION_DATE="expectedCompletionDate";
	
	/**
	 * 期望日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> EXPECTED_COMPLETION_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,EXPECTED_COMPLETION_DATE, java.util.Date.class, "期望日期", "期望日期", java.util.Date.class, null);
	
	/**
	 * 系统域名 , 类型: java.lang.String
	*/
	public static final String DOMAIN_NAME="domainName";
	
	/**
	 * 系统域名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> DOMAIN_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,DOMAIN_NAME, java.lang.String.class, "系统域名", "系统域名", java.lang.String.class, null);
	
	/**
	 * 申请原因 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 申请原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,CONTENT, java.lang.String.class, "申请原因", "申请原因", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,ORIGINATOR_ID, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 完成日期 , 类型: java.util.Date
	*/
	public static final String COMPLETION_DATE="completionDate";
	
	/**
	 * 完成日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> COMPLETION_DATE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,COMPLETION_DATE, java.util.Date.class, "完成日期", "完成日期", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * serverInfoList , 集合类型: LIST , 类型: com.dt.platform.domain.workorder.ServerInfo
	*/
	public static final String SERVER_INFO_LIST="serverInfoList";
	
	/**
	 * serverInfoList , 集合类型: LIST , 类型: com.dt.platform.domain.workorder.ServerInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,com.dt.platform.domain.workorder.ServerInfo> SERVER_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,SERVER_INFO_LIST, java.util.List.class, "serverInfoList", "serverInfoList", com.dt.platform.domain.workorder.ServerInfo.class, null);
	
	/**
	 * serverInfoIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String SERVER_INFO_IDS="serverInfoIds";
	
	/**
	 * serverInfoIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> SERVER_INFO_IDS_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,SERVER_INFO_IDS, java.util.List.class, "serverInfoIds", "serverInfoIds", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_USER_NAME="originatorUserName";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,java.lang.String> ORIGINATOR_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,ORIGINATOR_USER_NAME, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerApply,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerApply.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , STATUS , NAME , PROJECT_NAME , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , DOMAIN_NAME , CONTENT , FILE_ID , ORIGINATOR_ID , COMPLETION_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SERVER_INFO_LIST , SERVER_INFO_IDS , ORIGINATOR , ORIGINATOR_USER_NAME , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.workorder.ServerApply {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ServerApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public ServerApply setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public ServerApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ServerApply setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 项目名称
		 * @param projectName 项目名称
		 * @return 当前对象
		*/
		public ServerApply setProjectName(String projectName) {
			super.change(PROJECT_NAME,super.getProjectName(),projectName);
			super.setProjectName(projectName);
			return this;
		}
		
		/**
		 * 设置 运行环境
		 * @param environmentId 运行环境
		 * @return 当前对象
		*/
		public ServerApply setEnvironmentId(String environmentId) {
			super.change(ENVIRONMENT_ID,super.getEnvironmentId(),environmentId);
			super.setEnvironmentId(environmentId);
			return this;
		}
		
		/**
		 * 设置 有效期
		 * @param periodType 有效期
		 * @return 当前对象
		*/
		public ServerApply setPeriodType(String periodType) {
			super.change(PERIOD_TYPE,super.getPeriodType(),periodType);
			super.setPeriodType(periodType);
			return this;
		}
		
		/**
		 * 设置 过期日期
		 * @param expirationDate 过期日期
		 * @return 当前对象
		*/
		public ServerApply setExpirationDate(Date expirationDate) {
			super.change(EXPIRATION_DATE,super.getExpirationDate(),expirationDate);
			super.setExpirationDate(expirationDate);
			return this;
		}
		
		/**
		 * 设置 申请日期
		 * @param applyDate 申请日期
		 * @return 当前对象
		*/
		public ServerApply setApplyDate(Date applyDate) {
			super.change(APPLY_DATE,super.getApplyDate(),applyDate);
			super.setApplyDate(applyDate);
			return this;
		}
		
		/**
		 * 设置 期望日期
		 * @param expectedCompletionDate 期望日期
		 * @return 当前对象
		*/
		public ServerApply setExpectedCompletionDate(Date expectedCompletionDate) {
			super.change(EXPECTED_COMPLETION_DATE,super.getExpectedCompletionDate(),expectedCompletionDate);
			super.setExpectedCompletionDate(expectedCompletionDate);
			return this;
		}
		
		/**
		 * 设置 系统域名
		 * @param domainName 系统域名
		 * @return 当前对象
		*/
		public ServerApply setDomainName(String domainName) {
			super.change(DOMAIN_NAME,super.getDomainName(),domainName);
			super.setDomainName(domainName);
			return this;
		}
		
		/**
		 * 设置 申请原因
		 * @param content 申请原因
		 * @return 当前对象
		*/
		public ServerApply setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public ServerApply setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorId 申请人
		 * @return 当前对象
		*/
		public ServerApply setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 完成日期
		 * @param completionDate 完成日期
		 * @return 当前对象
		*/
		public ServerApply setCompletionDate(Date completionDate) {
			super.change(COMPLETION_DATE,super.getCompletionDate(),completionDate);
			super.setCompletionDate(completionDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ServerApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ServerApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ServerApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ServerApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ServerApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ServerApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ServerApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ServerApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ServerApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 serverInfoList
		 * @param serverInfoList serverInfoList
		 * @return 当前对象
		*/
		public ServerApply setServerInfoList(List<ServerInfo> serverInfoList) {
			super.change(SERVER_INFO_LIST,super.getServerInfoList(),serverInfoList);
			super.setServerInfoList(serverInfoList);
			return this;
		}
		
		/**
		 * 设置 serverInfoIds
		 * @param serverInfoIds serverInfoIds
		 * @return 当前对象
		*/
		public ServerApply setServerInfoIds(List<String> serverInfoIds) {
			super.change(SERVER_INFO_IDS,super.getServerInfoIds(),serverInfoIds);
			super.setServerInfoIds(serverInfoIds);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public ServerApply setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorUserName 申请人
		 * @return 当前对象
		*/
		public ServerApply setOriginatorUserName(String originatorUserName) {
			super.change(ORIGINATOR_USER_NAME,super.getOriginatorUserName(),originatorUserName);
			super.setOriginatorUserName(originatorUserName);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public ServerApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public ServerApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public ServerApply setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}
	}
}