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
import com.dt.platform.domain.ops.meta.DbBackupLogVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备份日志VO类型
 * <p>备份日志 , 数据表 ops_db_backup_log 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 23:12:44
 * @sign 26DBFF3DAC514CCA0BDC78009120394F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "备份日志VO类型 ; 备份日志 , 数据表 ops_db_backup_log 的通用VO类型" , parent = DbBackupLog.class)
public class DbBackupLogVO extends DbBackupLog {

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
	public DbBackupLogVO setPageIndex(Integer pageIndex) {
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
	public DbBackupLogVO setPageSize(Integer pageSize) {
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
	public DbBackupLogVO setSearchField(String searchField) {
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
	public DbBackupLogVO setFuzzyField(String fuzzyField) {
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
	public DbBackupLogVO setSearchValue(String searchValue) {
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
	public DbBackupLogVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DbBackupLogVO addDirtyField(String... dirtyField) {
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
	public DbBackupLogVO setSortField(String sortField) {
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
	public DbBackupLogVO setSortType(String sortType) {
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
	public DbBackupLogVO setDataOrigin(String dataOrigin) {
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
	public DbBackupLogVO setQueryLogic(String queryLogic) {
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
	public DbBackupLogVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DbBackupLogVO addId(String... id) {
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
	 * @return DbBackupLogVO , 转换好的 DbBackupLogVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbBackupLogVO , 转换好的 PoJo 对象
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
	public DbBackupLogVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbBackupLogVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbBackupLogVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbBackupLogVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDbName(this.getDbName());
		inst.setStime(this.getStime());
		inst.setSource(this.getSource());
		inst.setResult(this.getResult());
		inst.setUid(this.getUid());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setLastProcessTime(this.getLastProcessTime());
		inst.setDbId(this.getDbId());
		inst.setAction(this.getAction());
		inst.setId(this.getId());
		inst.setMethod(this.getMethod());
		inst.setIp(this.getIp());
		inst.setProcessResult(this.getProcessResult());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setProcessed(this.getProcessed());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setSize(this.getSize());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setEtime(this.getEtime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbBackupLogVO clone(boolean deep) {
		return EntityContext.clone(DbBackupLogVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbBackupLogVO
	 * @param dbBackupLogMap 包含实体信息的 Map 对象
	 * @return DbBackupLogVO , 转换好的的 DbBackupLog 对象
	*/
	@Transient
	public static DbBackupLogVO createFrom(Map<String,Object> dbBackupLogMap) {
		if(dbBackupLogMap==null) return null;
		DbBackupLogVO vo = create();
		EntityContext.copyProperties(vo,dbBackupLogMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DbBackupLogVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbBackupLogVO , 转换好的的 DbBackupLog 对象
	*/
	@Transient
	public static DbBackupLogVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DbBackupLogVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DbBackupLogVO，等同于 new
	 * @return DbBackupLogVO 对象
	*/
	@Transient
	public static DbBackupLogVO create() {
		return new com.dt.platform.domain.ops.meta.DbBackupLogVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.NOTES)));
			this.setDbName(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.DB_NAME)));
			this.setStime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.STIME)));
			this.setSource(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.SOURCE)));
			this.setResult(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.RESULT)));
			this.setUid(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.UID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.UPDATE_BY)));
			this.setLastProcessTime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.LAST_PROCESS_TIME)));
			this.setDbId(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.DB_ID)));
			this.setAction(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.ACTION)));
			this.setId(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.ID)));
			this.setMethod(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.METHOD)));
			this.setIp(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.IP)));
			this.setProcessResult(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.PROCESS_RESULT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbBackupLogVOMeta.VERSION)));
			this.setProcessed(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.PROCESSED)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbBackupLogVOMeta.DELETED)));
			this.setSize(DataParser.parse(BigDecimal.class, map.get(DbBackupLogVOMeta.SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(DbBackupLogVOMeta.ETIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DbBackupLogVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DbBackupLogVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DbBackupLogVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbBackupLogVOMeta.NOTES));
				this.setDbName( (String)map.get(DbBackupLogVOMeta.DB_NAME));
				this.setStime( (Date)map.get(DbBackupLogVOMeta.STIME));
				this.setSource( (String)map.get(DbBackupLogVOMeta.SOURCE));
				this.setResult( (String)map.get(DbBackupLogVOMeta.RESULT));
				this.setUid( (String)map.get(DbBackupLogVOMeta.UID));
				this.setUpdateBy( (String)map.get(DbBackupLogVOMeta.UPDATE_BY));
				this.setLastProcessTime( (Date)map.get(DbBackupLogVOMeta.LAST_PROCESS_TIME));
				this.setDbId( (String)map.get(DbBackupLogVOMeta.DB_ID));
				this.setAction( (String)map.get(DbBackupLogVOMeta.ACTION));
				this.setId( (String)map.get(DbBackupLogVOMeta.ID));
				this.setMethod( (String)map.get(DbBackupLogVOMeta.METHOD));
				this.setIp( (String)map.get(DbBackupLogVOMeta.IP));
				this.setProcessResult( (String)map.get(DbBackupLogVOMeta.PROCESS_RESULT));
				this.setUpdateTime( (Date)map.get(DbBackupLogVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DbBackupLogVOMeta.VERSION));
				this.setProcessed( (String)map.get(DbBackupLogVOMeta.PROCESSED));
				this.setCreateBy( (String)map.get(DbBackupLogVOMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(DbBackupLogVOMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(DbBackupLogVOMeta.DELETED));
				this.setSize( (BigDecimal)map.get(DbBackupLogVOMeta.SIZE));
				this.setCreateTime( (Date)map.get(DbBackupLogVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(DbBackupLogVOMeta.DELETE_TIME));
				this.setEtime( (Date)map.get(DbBackupLogVOMeta.ETIME));
				this.setDeleteBy( (String)map.get(DbBackupLogVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(DbBackupLogVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(DbBackupLogVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(DbBackupLogVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DbBackupLogVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(DbBackupLogVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(DbBackupLogVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(DbBackupLogVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(DbBackupLogVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(DbBackupLogVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(DbBackupLogVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.NOTES)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.DB_NAME)));
			this.setStime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.STIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.SOURCE)));
			this.setResult(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.RESULT)));
			this.setUid(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.UID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.UPDATE_BY)));
			this.setLastProcessTime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.LAST_PROCESS_TIME)));
			this.setDbId(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.DB_ID)));
			this.setAction(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.ACTION)));
			this.setId(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.ID)));
			this.setMethod(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.METHOD)));
			this.setIp(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.IP)));
			this.setProcessResult(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.PROCESS_RESULT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbBackupLogVOMeta.VERSION)));
			this.setProcessed(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.PROCESSED)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbBackupLogVOMeta.DELETED)));
			this.setSize(DataParser.parse(BigDecimal.class, r.getValue(DbBackupLogVOMeta.SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(DbBackupLogVOMeta.ETIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DbBackupLogVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbBackupLogVOMeta.NOTES));
				this.setDbName( (String)r.getValue(DbBackupLogVOMeta.DB_NAME));
				this.setStime( (Date)r.getValue(DbBackupLogVOMeta.STIME));
				this.setSource( (String)r.getValue(DbBackupLogVOMeta.SOURCE));
				this.setResult( (String)r.getValue(DbBackupLogVOMeta.RESULT));
				this.setUid( (String)r.getValue(DbBackupLogVOMeta.UID));
				this.setUpdateBy( (String)r.getValue(DbBackupLogVOMeta.UPDATE_BY));
				this.setLastProcessTime( (Date)r.getValue(DbBackupLogVOMeta.LAST_PROCESS_TIME));
				this.setDbId( (String)r.getValue(DbBackupLogVOMeta.DB_ID));
				this.setAction( (String)r.getValue(DbBackupLogVOMeta.ACTION));
				this.setId( (String)r.getValue(DbBackupLogVOMeta.ID));
				this.setMethod( (String)r.getValue(DbBackupLogVOMeta.METHOD));
				this.setIp( (String)r.getValue(DbBackupLogVOMeta.IP));
				this.setProcessResult( (String)r.getValue(DbBackupLogVOMeta.PROCESS_RESULT));
				this.setUpdateTime( (Date)r.getValue(DbBackupLogVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DbBackupLogVOMeta.VERSION));
				this.setProcessed( (String)r.getValue(DbBackupLogVOMeta.PROCESSED));
				this.setCreateBy( (String)r.getValue(DbBackupLogVOMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(DbBackupLogVOMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(DbBackupLogVOMeta.DELETED));
				this.setSize( (BigDecimal)r.getValue(DbBackupLogVOMeta.SIZE));
				this.setCreateTime( (Date)r.getValue(DbBackupLogVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(DbBackupLogVOMeta.DELETE_TIME));
				this.setEtime( (Date)r.getValue(DbBackupLogVOMeta.ETIME));
				this.setDeleteBy( (String)r.getValue(DbBackupLogVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DbBackupLogVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}