package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_FILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonFileMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员档案
 * <p>人员档案 , 数据表 hr_person_file 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:18:21
 * @sign 57BD3B68577C069CF6EFD1ACE6C89E41
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_file")
@ApiModel(description = "人员档案 ; 人员档案 , 数据表 hr_person_file 的PO类型")
public class PersonFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_FILE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 档案编号：档案编号
	*/
	@ApiModelProperty(required = false,value="档案编号" , notes = "档案编号")
	private String code;
	
	/**
	 * 档案状态：档案状态
	*/
	@ApiModelProperty(required = false,value="档案状态" , notes = "档案状态")
	private String status;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String userId;
	
	/**
	 * 是否新建档：是否新建档
	*/
	@ApiModelProperty(required = false,value="是否新建档" , notes = "是否新建档")
	private String ifNew;
	
	/**
	 * 档案保管地：档案保管地
	*/
	@ApiModelProperty(required = false,value="档案保管地" , notes = "档案保管地")
	private String saveLoc;
	
	/**
	 * 参加工作时间：参加工作时间
	*/
	@ApiModelProperty(required = false,value="参加工作时间" , notes = "参加工作时间")
	private String workStartDate;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String file;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
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
	@EnumFor("deleted")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
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
	public PersonFile setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 档案编号<br>
	 * 档案编号
	 * @return 档案编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 档案编号
	 * @param code 档案编号
	 * @return 当前对象
	*/
	public PersonFile setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 档案状态<br>
	 * 档案状态
	 * @return 档案状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 档案状态
	 * @param status 档案状态
	 * @return 当前对象
	*/
	public PersonFile setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 人员
	 * @param userId 人员
	 * @return 当前对象
	*/
	public PersonFile setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 是否新建档<br>
	 * 是否新建档
	 * @return 是否新建档
	*/
	public String getIfNew() {
		return ifNew;
	}
	
	/**
	 * 设置 是否新建档
	 * @param ifNew 是否新建档
	 * @return 当前对象
	*/
	public PersonFile setIfNew(String ifNew) {
		this.ifNew=ifNew;
		return this;
	}
	
	/**
	 * 获得 档案保管地<br>
	 * 档案保管地
	 * @return 档案保管地
	*/
	public String getSaveLoc() {
		return saveLoc;
	}
	
	/**
	 * 设置 档案保管地
	 * @param saveLoc 档案保管地
	 * @return 当前对象
	*/
	public PersonFile setSaveLoc(String saveLoc) {
		this.saveLoc=saveLoc;
		return this;
	}
	
	/**
	 * 获得 参加工作时间<br>
	 * 参加工作时间
	 * @return 参加工作时间
	*/
	public String getWorkStartDate() {
		return workStartDate;
	}
	
	/**
	 * 设置 参加工作时间
	 * @param workStartDate 参加工作时间
	 * @return 当前对象
	*/
	public PersonFile setWorkStartDate(String workStartDate) {
		this.workStartDate=workStartDate;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFile() {
		return file;
	}
	
	/**
	 * 设置 附件
	 * @param file 附件
	 * @return 当前对象
	*/
	public PersonFile setFile(String file) {
		this.file=file;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public PersonFile setNote(String note) {
		this.note=note;
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
	public PersonFile setCreateBy(String createBy) {
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
	public PersonFile setCreateTime(Date createTime) {
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
	public PersonFile setUpdateBy(String updateBy) {
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
	public PersonFile setUpdateTime(Date updateTime) {
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
	@JsonProperty("deleted")
	public PersonFile setDeleted(Integer deleted) {
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
	public PersonFile setDeleted(Boolean deletedBool) {
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
	public PersonFile setDeleteBy(String deleteBy) {
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
	public PersonFile setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public PersonFile setVersion(Integer version) {
		this.version=version;
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
	public PersonFile setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonFile , 转换好的 PersonFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonFile , 转换好的 PoJo 对象
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
	public PersonFile clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonFile duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonFileMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonFileMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonFile clone(boolean deep) {
		return EntityContext.clone(PersonFile.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonFile
	 * @param personFileMap 包含实体信息的 Map 对象
	 * @return PersonFile , 转换好的的 PersonFile 对象
	*/
	@Transient
	public static PersonFile createFrom(Map<String,Object> personFileMap) {
		if(personFileMap==null) return null;
		PersonFile po = create();
		EntityContext.copyProperties(po,personFileMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonFile , 转换好的的 PersonFile 对象
	*/
	@Transient
	public static PersonFile createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonFile po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonFile，等同于 new
	 * @return PersonFile 对象
	*/
	@Transient
	public static PersonFile create() {
		return new com.dt.platform.domain.hr.meta.PersonFileMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonFileMeta.NOTE)));
			this.setCode(DataParser.parse(String.class, map.get(PersonFileMeta.CODE)));
			this.setSaveLoc(DataParser.parse(String.class, map.get(PersonFileMeta.SAVE_LOC)));
			this.setWorkStartDate(DataParser.parse(String.class, map.get(PersonFileMeta.WORK_START_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonFileMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(PersonFileMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonFileMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonFileMeta.CREATE_BY)));
			this.setFile(DataParser.parse(String.class, map.get(PersonFileMeta.FILE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonFileMeta.DELETED)));
			this.setIfNew(DataParser.parse(String.class, map.get(PersonFileMeta.IF_NEW)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonFileMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonFileMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonFileMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonFileMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonFileMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonFileMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonFileMeta.NOTE));
				this.setCode( (String)map.get(PersonFileMeta.CODE));
				this.setSaveLoc( (String)map.get(PersonFileMeta.SAVE_LOC));
				this.setWorkStartDate( (String)map.get(PersonFileMeta.WORK_START_DATE));
				this.setUpdateTime( (Date)map.get(PersonFileMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(PersonFileMeta.USER_ID));
				this.setVersion( (Integer)map.get(PersonFileMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonFileMeta.CREATE_BY));
				this.setFile( (String)map.get(PersonFileMeta.FILE));
				this.setDeleted( (Integer)map.get(PersonFileMeta.DELETED));
				this.setIfNew( (String)map.get(PersonFileMeta.IF_NEW));
				this.setCreateTime( (Date)map.get(PersonFileMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonFileMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonFileMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonFileMeta.DELETE_BY));
				this.setId( (String)map.get(PersonFileMeta.ID));
				this.setStatus( (String)map.get(PersonFileMeta.STATUS));
				// others
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonFileMeta.NOTE)));
			this.setCode(DataParser.parse(String.class, r.getValue(PersonFileMeta.CODE)));
			this.setSaveLoc(DataParser.parse(String.class, r.getValue(PersonFileMeta.SAVE_LOC)));
			this.setWorkStartDate(DataParser.parse(String.class, r.getValue(PersonFileMeta.WORK_START_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonFileMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(PersonFileMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonFileMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonFileMeta.CREATE_BY)));
			this.setFile(DataParser.parse(String.class, r.getValue(PersonFileMeta.FILE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonFileMeta.DELETED)));
			this.setIfNew(DataParser.parse(String.class, r.getValue(PersonFileMeta.IF_NEW)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonFileMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonFileMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonFileMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonFileMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonFileMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonFileMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonFileMeta.NOTE));
				this.setCode( (String)r.getValue(PersonFileMeta.CODE));
				this.setSaveLoc( (String)r.getValue(PersonFileMeta.SAVE_LOC));
				this.setWorkStartDate( (String)r.getValue(PersonFileMeta.WORK_START_DATE));
				this.setUpdateTime( (Date)r.getValue(PersonFileMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(PersonFileMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(PersonFileMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonFileMeta.CREATE_BY));
				this.setFile( (String)r.getValue(PersonFileMeta.FILE));
				this.setDeleted( (Integer)r.getValue(PersonFileMeta.DELETED));
				this.setIfNew( (String)r.getValue(PersonFileMeta.IF_NEW));
				this.setCreateTime( (Date)r.getValue(PersonFileMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonFileMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonFileMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonFileMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonFileMeta.ID));
				this.setStatus( (String)r.getValue(PersonFileMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}