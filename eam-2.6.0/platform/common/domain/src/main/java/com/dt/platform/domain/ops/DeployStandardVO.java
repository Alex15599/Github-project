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
import com.dt.platform.domain.ops.meta.DeployStandardVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 部署标准VO类型
 * <p>部署标准 , 数据表 ops_deploy_standard 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 09:20:27
 * @sign C094A3BE4C2171427E1A416FA9983B5A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "部署标准VO类型 ; 部署标准 , 数据表 ops_deploy_standard 的通用VO类型" , parent = DeployStandard.class)
public class DeployStandardVO extends DeployStandard {

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
	public DeployStandardVO setPageIndex(Integer pageIndex) {
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
	public DeployStandardVO setPageSize(Integer pageSize) {
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
	public DeployStandardVO setSearchField(String searchField) {
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
	public DeployStandardVO setFuzzyField(String fuzzyField) {
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
	public DeployStandardVO setSearchValue(String searchValue) {
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
	public DeployStandardVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DeployStandardVO addDirtyField(String... dirtyField) {
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
	public DeployStandardVO setSortField(String sortField) {
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
	public DeployStandardVO setSortType(String sortType) {
		this.sortType=sortType;
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
	public DeployStandardVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DeployStandardVO addId(String... id) {
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
	 * @return DeployStandardVO , 转换好的 DeployStandardVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeployStandardVO , 转换好的 PoJo 对象
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
	public DeployStandardVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeployStandardVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DeployStandardVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DeployStandardVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setReleaseVersion(this.getReleaseVersion());
		inst.setMaintenanceContent(this.getMaintenanceContent());
		inst.setDeployContent(this.getDeployContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateDbContent(this.getCreateDbContent());
		inst.setBackupScript(this.getBackupScript());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setUserContent(this.getUserContent());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTypeId(this.getTypeId());
		inst.setId(this.getId());
		inst.setDirContent(this.getDirContent());
		inst.setAttachId(this.getAttachId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeployStandardVO clone(boolean deep) {
		return EntityContext.clone(DeployStandardVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeployStandardVO
	 * @param deployStandardMap 包含实体信息的 Map 对象
	 * @return DeployStandardVO , 转换好的的 DeployStandard 对象
	*/
	@Transient
	public static DeployStandardVO createFrom(Map<String,Object> deployStandardMap) {
		if(deployStandardMap==null) return null;
		DeployStandardVO vo = create();
		EntityContext.copyProperties(vo,deployStandardMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DeployStandardVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeployStandardVO , 转换好的的 DeployStandard 对象
	*/
	@Transient
	public static DeployStandardVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DeployStandardVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DeployStandardVO，等同于 new
	 * @return DeployStandardVO 对象
	*/
	@Transient
	public static DeployStandardVO create() {
		return new com.dt.platform.domain.ops.meta.DeployStandardVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DeployStandardVOMeta.NOTES)));
			this.setReleaseVersion(DataParser.parse(String.class, map.get(DeployStandardVOMeta.RELEASE_VERSION)));
			this.setMaintenanceContent(DataParser.parse(String.class, map.get(DeployStandardVOMeta.MAINTENANCE_CONTENT)));
			this.setDeployContent(DataParser.parse(String.class, map.get(DeployStandardVOMeta.DEPLOY_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeployStandardVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeployStandardVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeployStandardVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeployStandardVOMeta.DELETED)));
			this.setCreateDbContent(DataParser.parse(String.class, map.get(DeployStandardVOMeta.CREATE_DB_CONTENT)));
			this.setBackupScript(DataParser.parse(String.class, map.get(DeployStandardVOMeta.BACKUP_SCRIPT)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeployStandardVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeployStandardVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeployStandardVOMeta.DELETE_TIME)));
			this.setUserContent(DataParser.parse(String.class, map.get(DeployStandardVOMeta.USER_CONTENT)));
			this.setName(DataParser.parse(String.class, map.get(DeployStandardVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DeployStandardVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeployStandardVOMeta.DELETE_BY)));
			this.setTypeId(DataParser.parse(String.class, map.get(DeployStandardVOMeta.TYPE_ID)));
			this.setId(DataParser.parse(String.class, map.get(DeployStandardVOMeta.ID)));
			this.setDirContent(DataParser.parse(String.class, map.get(DeployStandardVOMeta.DIR_CONTENT)));
			this.setAttachId(DataParser.parse(String.class, map.get(DeployStandardVOMeta.ATTACH_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(DeployStandardVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DeployStandardVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DeployStandardVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DeployStandardVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(DeployStandardVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DeployStandardVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DeployStandardVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DeployStandardVOMeta.NOTES));
				this.setReleaseVersion( (String)map.get(DeployStandardVOMeta.RELEASE_VERSION));
				this.setMaintenanceContent( (String)map.get(DeployStandardVOMeta.MAINTENANCE_CONTENT));
				this.setDeployContent( (String)map.get(DeployStandardVOMeta.DEPLOY_CONTENT));
				this.setUpdateTime( (Date)map.get(DeployStandardVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DeployStandardVOMeta.VERSION));
				this.setCreateBy( (String)map.get(DeployStandardVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeployStandardVOMeta.DELETED));
				this.setCreateDbContent( (String)map.get(DeployStandardVOMeta.CREATE_DB_CONTENT));
				this.setBackupScript( (String)map.get(DeployStandardVOMeta.BACKUP_SCRIPT));
				this.setCreateTime( (Date)map.get(DeployStandardVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeployStandardVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeployStandardVOMeta.DELETE_TIME));
				this.setUserContent( (String)map.get(DeployStandardVOMeta.USER_CONTENT));
				this.setName( (String)map.get(DeployStandardVOMeta.NAME));
				this.setTenantId( (String)map.get(DeployStandardVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DeployStandardVOMeta.DELETE_BY));
				this.setTypeId( (String)map.get(DeployStandardVOMeta.TYPE_ID));
				this.setId( (String)map.get(DeployStandardVOMeta.ID));
				this.setDirContent( (String)map.get(DeployStandardVOMeta.DIR_CONTENT));
				this.setAttachId( (String)map.get(DeployStandardVOMeta.ATTACH_ID));
				// others
				this.setSearchField( (String)map.get(DeployStandardVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(DeployStandardVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DeployStandardVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(DeployStandardVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(DeployStandardVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(DeployStandardVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(DeployStandardVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.NOTES)));
			this.setReleaseVersion(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.RELEASE_VERSION)));
			this.setMaintenanceContent(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.MAINTENANCE_CONTENT)));
			this.setDeployContent(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.DEPLOY_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeployStandardVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeployStandardVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeployStandardVOMeta.DELETED)));
			this.setCreateDbContent(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.CREATE_DB_CONTENT)));
			this.setBackupScript(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.BACKUP_SCRIPT)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeployStandardVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeployStandardVOMeta.DELETE_TIME)));
			this.setUserContent(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.USER_CONTENT)));
			this.setName(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.DELETE_BY)));
			this.setTypeId(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.TYPE_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.ID)));
			this.setDirContent(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.DIR_CONTENT)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(DeployStandardVOMeta.ATTACH_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DeployStandardVOMeta.NOTES));
				this.setReleaseVersion( (String)r.getValue(DeployStandardVOMeta.RELEASE_VERSION));
				this.setMaintenanceContent( (String)r.getValue(DeployStandardVOMeta.MAINTENANCE_CONTENT));
				this.setDeployContent( (String)r.getValue(DeployStandardVOMeta.DEPLOY_CONTENT));
				this.setUpdateTime( (Date)r.getValue(DeployStandardVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DeployStandardVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(DeployStandardVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeployStandardVOMeta.DELETED));
				this.setCreateDbContent( (String)r.getValue(DeployStandardVOMeta.CREATE_DB_CONTENT));
				this.setBackupScript( (String)r.getValue(DeployStandardVOMeta.BACKUP_SCRIPT));
				this.setCreateTime( (Date)r.getValue(DeployStandardVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeployStandardVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeployStandardVOMeta.DELETE_TIME));
				this.setUserContent( (String)r.getValue(DeployStandardVOMeta.USER_CONTENT));
				this.setName( (String)r.getValue(DeployStandardVOMeta.NAME));
				this.setTenantId( (String)r.getValue(DeployStandardVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DeployStandardVOMeta.DELETE_BY));
				this.setTypeId( (String)r.getValue(DeployStandardVOMeta.TYPE_ID));
				this.setId( (String)r.getValue(DeployStandardVOMeta.ID));
				this.setDirContent( (String)r.getValue(DeployStandardVOMeta.DIR_CONTENT));
				this.setAttachId( (String)r.getValue(DeployStandardVOMeta.ATTACH_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}