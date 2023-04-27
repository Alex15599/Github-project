package com.dt.platform.domain.workorder;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WorkorderTables.WO_NETWORK_STRATEGY_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 网络策略申请
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 20:03:46
 * @sign 557083E0BA8A168071216D83D96A558E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wo_network_strategy_apply")
public class NetworkStrategyApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WO_NETWORK_STRATEGY_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private String projectName;
	
	/**
	 * 运行环境：运行环境
	*/
	@ApiModelProperty(required = false,value="运行环境" , notes = "运行环境")
	private String environmentId;
	
	/**
	 * 有效期：有效期
	*/
	@ApiModelProperty(required = false,value="有效期" , notes = "有效期")
	private String periodType;
	
	/**
	 * 过期日期：过期日期
	*/
	@ApiModelProperty(required = false,value="过期日期" , notes = "过期日期")
	private Date expirationDate;
	
	/**
	 * 申请日期：申请日期
	*/
	@ApiModelProperty(required = false,value="申请日期" , notes = "申请日期")
	private Date applyDate;
	
	/**
	 * 期望日期：期望日期
	*/
	@ApiModelProperty(required = false,value="期望日期" , notes = "期望日期")
	private Date expectedCompletionDate;
	
	/**
	 * 申请原因：申请原因
	*/
	@ApiModelProperty(required = false,value="申请原因" , notes = "申请原因")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * networkStrategyInfoList：networkStrategyInfoList
	*/
	@ApiModelProperty(required = false,value="networkStrategyInfoList" , notes = "networkStrategyInfoList")
	private List<NetworkStrategyInfo> networkStrategyInfoList;
	
	/**
	 * NetworkStrategyIds：NetworkStrategyIds
	*/
	@ApiModelProperty(required = false,value="NetworkStrategyIds" , notes = "NetworkStrategyIds")
	private List<String> networkStrategyIds;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorUserName;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public NetworkStrategyApply setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public NetworkStrategyApply setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public NetworkStrategyApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public NetworkStrategyApply setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * 设置 项目
	 * @param projectName 项目
	 * @return 当前对象
	*/
	public NetworkStrategyApply setProjectName(String projectName) {
		this.projectName=projectName;
		return this;
	}
	
	/**
	 * 获得 运行环境<br>
	 * 运行环境
	 * @return 运行环境
	*/
	public String getEnvironmentId() {
		return environmentId;
	}
	
	/**
	 * 设置 运行环境
	 * @param environmentId 运行环境
	 * @return 当前对象
	*/
	public NetworkStrategyApply setEnvironmentId(String environmentId) {
		this.environmentId=environmentId;
		return this;
	}
	
	/**
	 * 获得 有效期<br>
	 * 有效期
	 * @return 有效期
	*/
	public String getPeriodType() {
		return periodType;
	}
	
	/**
	 * 设置 有效期
	 * @param periodType 有效期
	 * @return 当前对象
	*/
	public NetworkStrategyApply setPeriodType(String periodType) {
		this.periodType=periodType;
		return this;
	}
	
	/**
	 * 获得 过期日期<br>
	 * 过期日期
	 * @return 过期日期
	*/
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * 设置 过期日期
	 * @param expirationDate 过期日期
	 * @return 当前对象
	*/
	public NetworkStrategyApply setExpirationDate(Date expirationDate) {
		this.expirationDate=expirationDate;
		return this;
	}
	
	/**
	 * 获得 申请日期<br>
	 * 申请日期
	 * @return 申请日期
	*/
	public Date getApplyDate() {
		return applyDate;
	}
	
	/**
	 * 设置 申请日期
	 * @param applyDate 申请日期
	 * @return 当前对象
	*/
	public NetworkStrategyApply setApplyDate(Date applyDate) {
		this.applyDate=applyDate;
		return this;
	}
	
	/**
	 * 获得 期望日期<br>
	 * 期望日期
	 * @return 期望日期
	*/
	public Date getExpectedCompletionDate() {
		return expectedCompletionDate;
	}
	
	/**
	 * 设置 期望日期
	 * @param expectedCompletionDate 期望日期
	 * @return 当前对象
	*/
	public NetworkStrategyApply setExpectedCompletionDate(Date expectedCompletionDate) {
		this.expectedCompletionDate=expectedCompletionDate;
		return this;
	}
	
	/**
	 * 获得 申请原因<br>
	 * 申请原因
	 * @return 申请原因
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 申请原因
	 * @param content 申请原因
	 * @return 当前对象
	*/
	public NetworkStrategyApply setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public NetworkStrategyApply setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 申请人
	 * @param originatorId 申请人
	 * @return 当前对象
	*/
	public NetworkStrategyApply setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public NetworkStrategyApply setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public NetworkStrategyApply setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public NetworkStrategyApply setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public NetworkStrategyApply setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public NetworkStrategyApply setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public NetworkStrategyApply setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public NetworkStrategyApply setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public NetworkStrategyApply setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public NetworkStrategyApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public NetworkStrategyApply setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 networkStrategyInfoList<br>
	 * networkStrategyInfoList
	 * @return networkStrategyInfoList
	*/
	public List<NetworkStrategyInfo> getNetworkStrategyInfoList() {
		return networkStrategyInfoList;
	}
	
	/**
	 * 设置 networkStrategyInfoList
	 * @param networkStrategyInfoList networkStrategyInfoList
	 * @return 当前对象
	*/
	public NetworkStrategyApply setNetworkStrategyInfoList(List<NetworkStrategyInfo> networkStrategyInfoList) {
		this.networkStrategyInfoList=networkStrategyInfoList;
		return this;
	}
	
	/**
	 * 添加 networkStrategyInfoList
	 * @param networkStrategyInfo networkStrategyInfoList
	 * @return 当前对象
	*/
	public NetworkStrategyApply addNetworkStrategyInfo(NetworkStrategyInfo... networkStrategyInfo) {
		if(this.networkStrategyInfoList==null) networkStrategyInfoList=new ArrayList<>();
		this.networkStrategyInfoList.addAll(Arrays.asList(networkStrategyInfo));
		return this;
	}
	
	/**
	 * 获得 NetworkStrategyIds<br>
	 * NetworkStrategyIds
	 * @return NetworkStrategyIds
	*/
	public List<String> getNetworkStrategyIds() {
		return networkStrategyIds;
	}
	
	/**
	 * 设置 NetworkStrategyIds
	 * @param networkStrategyIds NetworkStrategyIds
	 * @return 当前对象
	*/
	public NetworkStrategyApply setNetworkStrategyIds(List<String> networkStrategyIds) {
		this.networkStrategyIds=networkStrategyIds;
		return this;
	}
	
	/**
	 * 添加 NetworkStrategyIds
	 * @param networkStrategyId NetworkStrategyIds
	 * @return 当前对象
	*/
	public NetworkStrategyApply addNetworkStrategyId(String... networkStrategyId) {
		if(this.networkStrategyIds==null) networkStrategyIds=new ArrayList<>();
		this.networkStrategyIds.addAll(Arrays.asList(networkStrategyId));
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public NetworkStrategyApply setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getOriginatorUserName() {
		return originatorUserName;
	}
	
	/**
	 * 设置 申请人
	 * @param originatorUserName 申请人
	 * @return 当前对象
	*/
	public NetworkStrategyApply setOriginatorUserName(String originatorUserName) {
		this.originatorUserName=originatorUserName;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public NetworkStrategyApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public NetworkStrategyApply addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public NetworkStrategyApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public NetworkStrategyApply addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public NetworkStrategyApply setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetworkStrategyApply , 转换好的 NetworkStrategyApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetworkStrategyApply , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 NetworkStrategyApply
	 * @param networkStrategyApplyMap 包含实体信息的 Map 对象
	 * @return NetworkStrategyApply , 转换好的的 NetworkStrategyApply 对象
	*/
	@Transient
	public static NetworkStrategyApply createFrom(Map<String,Object> networkStrategyApplyMap) {
		if(networkStrategyApplyMap==null) return null;
		NetworkStrategyApply po = EntityContext.create(NetworkStrategyApply.class, networkStrategyApplyMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetworkStrategyApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetworkStrategyApply , 转换好的的 NetworkStrategyApply 对象
	*/
	@Transient
	public static NetworkStrategyApply createFrom(Object pojo) {
		if(pojo==null) return null;
		NetworkStrategyApply po = EntityContext.create(NetworkStrategyApply.class,pojo);
		return po;
	}

	/**
	 * 创建一个 NetworkStrategyApply，等同于 new
	 * @return NetworkStrategyApply 对象
	*/
	@Transient
	public static NetworkStrategyApply create() {
		return EntityContext.create(NetworkStrategyApply.class);
	}
}