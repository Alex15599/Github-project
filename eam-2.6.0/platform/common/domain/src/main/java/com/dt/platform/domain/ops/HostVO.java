package com.dt.platform.domain.ops;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 主机VO类型
 * <p>主机 , 数据表 ops_host 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-18 11:19:27
 * @sign F07C13ABD65C13FE1F53CCD7CE6DBBE5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "主机VO类型 ; 主机 , 数据表 ops_host 的通用VO类型" , parent = Host.class)
public class HostVO extends Host {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public HostVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public HostVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public HostVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public HostVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public HostVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public HostVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public HostVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public HostVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public HostVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public HostVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public HostVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public HostVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public HostVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return HostVO , 转换好的 HostVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return HostVO , 转换好的 PoJo 对象
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
	 * 克隆当前对象
	*/
	@Transient
	public HostVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public HostVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.HostVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.HostVOMeta.$$proxy$$();
		inst.setHostName(this.getHostName());
		inst.setUserDbUsed(this.getUserDbUsed());
		inst.setUserDbAdmin(this.getUserDbAdmin());
		inst.setPasswordStrategyId(this.getPasswordStrategyId());
		inst.setDirectorUsername(this.getDirectorUsername());
		inst.setUserOsAdmin(this.getUserOsAdmin());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setHostType(this.getHostType());
		inst.setPortList(this.getPortList());
		inst.setOnlineTime(this.getOnlineTime());
		inst.setOfflineTime(this.getOfflineTime());
		inst.setId(this.getId());
		inst.setHostCpu(this.getHostCpu());
		inst.setUserAppUsed(this.getUserAppUsed());
		inst.setUserOther(this.getUserOther());
		inst.setHostBackupInfo(this.getHostBackupInfo());
		inst.setSystemId(this.getSystemId());
		inst.setHostConf(this.getHostConf());
		inst.setHostBackupMethod(this.getHostBackupMethod());
		inst.setHostIp(this.getHostIp());
		inst.setHostVip(this.getHostVip());
		inst.setHostMemory(this.getHostMemory());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setLabels(this.getLabels());
		inst.setEnvironment(this.getEnvironment());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setHostNotes(this.getHostNotes());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUserOpsOper(this.getUserOpsOper());
		inst.setArch(this.getArch());
		inst.setMonitorStatus(this.getMonitorStatus());
		inst.setStatus(this.getStatus());
		inst.setHostIpv6(this.getHostIpv6());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setVoucherList(this.getVoucherList());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setHostDbIds(this.getHostDbIds());
			inst.setInfoSystem(this.getInfoSystem());
			inst.setHostOsList(this.getHostOsList());
			inst.setPageSize(this.getPageSize());
			inst.setHostDbList(this.getHostDbList());
			inst.setHostMiddlewareIds(this.getHostMiddlewareIds());
			inst.setHostOsIds(this.getHostOsIds());
			inst.setHostMiddlewareList(this.getHostMiddlewareList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setPosition(this.getPosition());
			inst.setBackupMethod(this.getBackupMethod());
			inst.setSearchValue(this.getSearchValue());
			inst.setVoucherIds(this.getVoucherIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public HostVO clone(boolean deep) {
		return EntityContext.clone(HostVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 HostVO
	 * @param hostMap 包含实体信息的 Map 对象
	 * @return HostVO , 转换好的的 Host 对象
	*/
	@Transient
	public static HostVO createFrom(Map<String,Object> hostMap) {
		if(hostMap==null) return null;
		HostVO vo = create();
		EntityContext.copyProperties(vo,hostMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 HostVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return HostVO , 转换好的的 Host 对象
	*/
	@Transient
	public static HostVO createFrom(Object pojo) {
		if(pojo==null) return null;
		HostVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 HostVO，等同于 new
	 * @return HostVO 对象
	*/
	@Transient
	public static HostVO create() {
		return new com.dt.platform.domain.ops.meta.HostVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setHostName(DataParser.parse(String.class, map.get(HostVOMeta.HOST_NAME)));
			this.setUserDbUsed(DataParser.parse(String.class, map.get(HostVOMeta.USER_DB_USED)));
			this.setUserDbAdmin(DataParser.parse(String.class, map.get(HostVOMeta.USER_DB_ADMIN)));
			this.setPasswordStrategyId(DataParser.parse(String.class, map.get(HostVOMeta.PASSWORD_STRATEGY_ID)));
			this.setDirectorUsername(DataParser.parse(String.class, map.get(HostVOMeta.DIRECTOR_USERNAME)));
			this.setUserOsAdmin(DataParser.parse(String.class, map.get(HostVOMeta.USER_OS_ADMIN)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(HostVOMeta.UPDATE_BY)));
			this.setHostType(DataParser.parse(String.class, map.get(HostVOMeta.HOST_TYPE)));
			this.setPortList(DataParser.parse(String.class, map.get(HostVOMeta.PORT_LIST)));
			this.setOnlineTime(DataParser.parse(Date.class, map.get(HostVOMeta.ONLINE_TIME)));
			this.setOfflineTime(DataParser.parse(Date.class, map.get(HostVOMeta.OFFLINE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(HostVOMeta.ID)));
			this.setHostCpu(DataParser.parse(BigDecimal.class, map.get(HostVOMeta.HOST_CPU)));
			this.setUserAppUsed(DataParser.parse(String.class, map.get(HostVOMeta.USER_APP_USED)));
			this.setUserOther(DataParser.parse(String.class, map.get(HostVOMeta.USER_OTHER)));
			this.setHostBackupInfo(DataParser.parse(String.class, map.get(HostVOMeta.HOST_BACKUP_INFO)));
			this.setSystemId(DataParser.parse(String.class, map.get(HostVOMeta.SYSTEM_ID)));
			this.setHostConf(DataParser.parse(String.class, map.get(HostVOMeta.HOST_CONF)));
			this.setHostBackupMethod(DataParser.parse(String.class, map.get(HostVOMeta.HOST_BACKUP_METHOD)));
			this.setHostIp(DataParser.parse(String.class, map.get(HostVOMeta.HOST_IP)));
			this.setHostVip(DataParser.parse(String.class, map.get(HostVOMeta.HOST_VIP)));
			this.setHostMemory(DataParser.parse(BigDecimal.class, map.get(HostVOMeta.HOST_MEMORY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(HostVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(HostVOMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, map.get(HostVOMeta.LABELS)));
			this.setEnvironment(DataParser.parse(String.class, map.get(HostVOMeta.ENVIRONMENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(HostVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(HostVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(HostVOMeta.POSITION_ID)));
			this.setHostNotes(DataParser.parse(String.class, map.get(HostVOMeta.HOST_NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(HostVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(HostVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(HostVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(HostVOMeta.DELETE_BY)));
			this.setUserOpsOper(DataParser.parse(String.class, map.get(HostVOMeta.USER_OPS_OPER)));
			this.setArch(DataParser.parse(String.class, map.get(HostVOMeta.ARCH)));
			this.setMonitorStatus(DataParser.parse(String.class, map.get(HostVOMeta.MONITOR_STATUS)));
			this.setStatus(DataParser.parse(String.class, map.get(HostVOMeta.STATUS)));
			this.setHostIpv6(DataParser.parse(String.class, map.get(HostVOMeta.HOST_IPV6)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(HostVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(HostVOMeta.FUZZY_FIELD)));
			this.setInfoSystem(DataParser.parse(InformationSystem.class, map.get(HostVOMeta.INFO_SYSTEM)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(HostVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(HostVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(HostVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(HostVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(HostVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(HostVOMeta.QUERY_LOGIC)));
			this.setPosition(DataParser.parse(HostPosition.class, map.get(HostVOMeta.POSITION)));
			this.setBackupMethod(DataParser.parse(DictItem.class, map.get(HostVOMeta.BACKUP_METHOD)));
			this.setSearchValue(DataParser.parse(String.class, map.get(HostVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setHostName( (String)map.get(HostVOMeta.HOST_NAME));
				this.setUserDbUsed( (String)map.get(HostVOMeta.USER_DB_USED));
				this.setUserDbAdmin( (String)map.get(HostVOMeta.USER_DB_ADMIN));
				this.setPasswordStrategyId( (String)map.get(HostVOMeta.PASSWORD_STRATEGY_ID));
				this.setDirectorUsername( (String)map.get(HostVOMeta.DIRECTOR_USERNAME));
				this.setUserOsAdmin( (String)map.get(HostVOMeta.USER_OS_ADMIN));
				this.setUpdateBy( (String)map.get(HostVOMeta.UPDATE_BY));
				this.setHostType( (String)map.get(HostVOMeta.HOST_TYPE));
				this.setPortList( (String)map.get(HostVOMeta.PORT_LIST));
				this.setOnlineTime( (Date)map.get(HostVOMeta.ONLINE_TIME));
				this.setOfflineTime( (Date)map.get(HostVOMeta.OFFLINE_TIME));
				this.setId( (String)map.get(HostVOMeta.ID));
				this.setHostCpu( (BigDecimal)map.get(HostVOMeta.HOST_CPU));
				this.setUserAppUsed( (String)map.get(HostVOMeta.USER_APP_USED));
				this.setUserOther( (String)map.get(HostVOMeta.USER_OTHER));
				this.setHostBackupInfo( (String)map.get(HostVOMeta.HOST_BACKUP_INFO));
				this.setSystemId( (String)map.get(HostVOMeta.SYSTEM_ID));
				this.setHostConf( (String)map.get(HostVOMeta.HOST_CONF));
				this.setHostBackupMethod( (String)map.get(HostVOMeta.HOST_BACKUP_METHOD));
				this.setHostIp( (String)map.get(HostVOMeta.HOST_IP));
				this.setHostVip( (String)map.get(HostVOMeta.HOST_VIP));
				this.setHostMemory( (BigDecimal)map.get(HostVOMeta.HOST_MEMORY));
				this.setUpdateTime( (Date)map.get(HostVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(HostVOMeta.VERSION));
				this.setLabels( (String)map.get(HostVOMeta.LABELS));
				this.setEnvironment( (String)map.get(HostVOMeta.ENVIRONMENT));
				this.setCreateBy( (String)map.get(HostVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(HostVOMeta.DELETED));
				this.setPositionId( (String)map.get(HostVOMeta.POSITION_ID));
				this.setHostNotes( (String)map.get(HostVOMeta.HOST_NOTES));
				this.setCreateTime( (Date)map.get(HostVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(HostVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(HostVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(HostVOMeta.DELETE_BY));
				this.setUserOpsOper( (String)map.get(HostVOMeta.USER_OPS_OPER));
				this.setArch( (String)map.get(HostVOMeta.ARCH));
				this.setMonitorStatus( (String)map.get(HostVOMeta.MONITOR_STATUS));
				this.setStatus( (String)map.get(HostVOMeta.STATUS));
				this.setHostIpv6( (String)map.get(HostVOMeta.HOST_IPV6));
				// others
				this.setSearchField( (String)map.get(HostVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(HostVOMeta.FUZZY_FIELD));
				this.setInfoSystem( (InformationSystem)map.get(HostVOMeta.INFO_SYSTEM));
				this.setPageSize( (Integer)map.get(HostVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(HostVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(HostVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(HostVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(HostVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(HostVOMeta.QUERY_LOGIC));
				this.setPosition( (HostPosition)map.get(HostVOMeta.POSITION));
				this.setBackupMethod( (DictItem)map.get(HostVOMeta.BACKUP_METHOD));
				this.setSearchValue( (String)map.get(HostVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setHostName(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_NAME)));
			this.setUserDbUsed(DataParser.parse(String.class, r.getValue(HostVOMeta.USER_DB_USED)));
			this.setUserDbAdmin(DataParser.parse(String.class, r.getValue(HostVOMeta.USER_DB_ADMIN)));
			this.setPasswordStrategyId(DataParser.parse(String.class, r.getValue(HostVOMeta.PASSWORD_STRATEGY_ID)));
			this.setDirectorUsername(DataParser.parse(String.class, r.getValue(HostVOMeta.DIRECTOR_USERNAME)));
			this.setUserOsAdmin(DataParser.parse(String.class, r.getValue(HostVOMeta.USER_OS_ADMIN)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(HostVOMeta.UPDATE_BY)));
			this.setHostType(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_TYPE)));
			this.setPortList(DataParser.parse(String.class, r.getValue(HostVOMeta.PORT_LIST)));
			this.setOnlineTime(DataParser.parse(Date.class, r.getValue(HostVOMeta.ONLINE_TIME)));
			this.setOfflineTime(DataParser.parse(Date.class, r.getValue(HostVOMeta.OFFLINE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(HostVOMeta.ID)));
			this.setHostCpu(DataParser.parse(BigDecimal.class, r.getValue(HostVOMeta.HOST_CPU)));
			this.setUserAppUsed(DataParser.parse(String.class, r.getValue(HostVOMeta.USER_APP_USED)));
			this.setUserOther(DataParser.parse(String.class, r.getValue(HostVOMeta.USER_OTHER)));
			this.setHostBackupInfo(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_BACKUP_INFO)));
			this.setSystemId(DataParser.parse(String.class, r.getValue(HostVOMeta.SYSTEM_ID)));
			this.setHostConf(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_CONF)));
			this.setHostBackupMethod(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_BACKUP_METHOD)));
			this.setHostIp(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_IP)));
			this.setHostVip(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_VIP)));
			this.setHostMemory(DataParser.parse(BigDecimal.class, r.getValue(HostVOMeta.HOST_MEMORY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(HostVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(HostVOMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, r.getValue(HostVOMeta.LABELS)));
			this.setEnvironment(DataParser.parse(String.class, r.getValue(HostVOMeta.ENVIRONMENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(HostVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(HostVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(HostVOMeta.POSITION_ID)));
			this.setHostNotes(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(HostVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(HostVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(HostVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(HostVOMeta.DELETE_BY)));
			this.setUserOpsOper(DataParser.parse(String.class, r.getValue(HostVOMeta.USER_OPS_OPER)));
			this.setArch(DataParser.parse(String.class, r.getValue(HostVOMeta.ARCH)));
			this.setMonitorStatus(DataParser.parse(String.class, r.getValue(HostVOMeta.MONITOR_STATUS)));
			this.setStatus(DataParser.parse(String.class, r.getValue(HostVOMeta.STATUS)));
			this.setHostIpv6(DataParser.parse(String.class, r.getValue(HostVOMeta.HOST_IPV6)));
			return true;
		} else {
			try {
				this.setHostName( (String)r.getValue(HostVOMeta.HOST_NAME));
				this.setUserDbUsed( (String)r.getValue(HostVOMeta.USER_DB_USED));
				this.setUserDbAdmin( (String)r.getValue(HostVOMeta.USER_DB_ADMIN));
				this.setPasswordStrategyId( (String)r.getValue(HostVOMeta.PASSWORD_STRATEGY_ID));
				this.setDirectorUsername( (String)r.getValue(HostVOMeta.DIRECTOR_USERNAME));
				this.setUserOsAdmin( (String)r.getValue(HostVOMeta.USER_OS_ADMIN));
				this.setUpdateBy( (String)r.getValue(HostVOMeta.UPDATE_BY));
				this.setHostType( (String)r.getValue(HostVOMeta.HOST_TYPE));
				this.setPortList( (String)r.getValue(HostVOMeta.PORT_LIST));
				this.setOnlineTime( (Date)r.getValue(HostVOMeta.ONLINE_TIME));
				this.setOfflineTime( (Date)r.getValue(HostVOMeta.OFFLINE_TIME));
				this.setId( (String)r.getValue(HostVOMeta.ID));
				this.setHostCpu( (BigDecimal)r.getValue(HostVOMeta.HOST_CPU));
				this.setUserAppUsed( (String)r.getValue(HostVOMeta.USER_APP_USED));
				this.setUserOther( (String)r.getValue(HostVOMeta.USER_OTHER));
				this.setHostBackupInfo( (String)r.getValue(HostVOMeta.HOST_BACKUP_INFO));
				this.setSystemId( (String)r.getValue(HostVOMeta.SYSTEM_ID));
				this.setHostConf( (String)r.getValue(HostVOMeta.HOST_CONF));
				this.setHostBackupMethod( (String)r.getValue(HostVOMeta.HOST_BACKUP_METHOD));
				this.setHostIp( (String)r.getValue(HostVOMeta.HOST_IP));
				this.setHostVip( (String)r.getValue(HostVOMeta.HOST_VIP));
				this.setHostMemory( (BigDecimal)r.getValue(HostVOMeta.HOST_MEMORY));
				this.setUpdateTime( (Date)r.getValue(HostVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(HostVOMeta.VERSION));
				this.setLabels( (String)r.getValue(HostVOMeta.LABELS));
				this.setEnvironment( (String)r.getValue(HostVOMeta.ENVIRONMENT));
				this.setCreateBy( (String)r.getValue(HostVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(HostVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(HostVOMeta.POSITION_ID));
				this.setHostNotes( (String)r.getValue(HostVOMeta.HOST_NOTES));
				this.setCreateTime( (Date)r.getValue(HostVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(HostVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(HostVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(HostVOMeta.DELETE_BY));
				this.setUserOpsOper( (String)r.getValue(HostVOMeta.USER_OPS_OPER));
				this.setArch( (String)r.getValue(HostVOMeta.ARCH));
				this.setMonitorStatus( (String)r.getValue(HostVOMeta.MONITOR_STATUS));
				this.setStatus( (String)r.getValue(HostVOMeta.STATUS));
				this.setHostIpv6( (String)r.getValue(HostVOMeta.HOST_IPV6));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}