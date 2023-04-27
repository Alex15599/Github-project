package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_SOFTWARE_MEDIA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.SoftwareMediaMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 软件介质
 * <p>软件介质 , 数据表 ops_software_media 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-29 22:53:53
 * @sign 7F6593B19D27AB719B04A0CCB16A58F1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_software_media")
@ApiModel(description = "软件介质 ; 软件介质 , 数据表 ops_software_media 的PO类型")
public class SoftwareMedia extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_SOFTWARE_MEDIA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "672189298241437696")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "1")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "Redis客户端")
	private String name;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "db")
	private String type;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "672189289701834752")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "支持单节点、哨兵模式、集群模式")
	private String notes;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-01-29 10:52:43")
	private Date recTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-01-29 09:20:17")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-01-29 10:52:43")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * typeData：typeData
	*/
	@ApiModelProperty(required = false,value="typeData" , notes = "typeData")
	private DictItem typeData;
	
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
	public SoftwareMedia setId(String id) {
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
	public SoftwareMedia setCode(String code) {
		this.code=code;
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
	public SoftwareMedia setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public SoftwareMedia setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public SoftwareMedia setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 文件
	 * @param fileId 文件
	 * @return 当前对象
	*/
	public SoftwareMedia setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public SoftwareMedia setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getRecTime() {
		return recTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param recTime 修改时间
	 * @return 当前对象
	*/
	public SoftwareMedia setRecTime(Date recTime) {
		this.recTime=recTime;
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
	public SoftwareMedia setCreateBy(String createBy) {
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
	public SoftwareMedia setCreateTime(Date createTime) {
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
	public SoftwareMedia setUpdateBy(String updateBy) {
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
	public SoftwareMedia setUpdateTime(Date updateTime) {
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
	public SoftwareMedia setDeleted(Integer deleted) {
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
	public SoftwareMedia setDeleted(Boolean deletedBool) {
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
	public SoftwareMedia setDeleteBy(String deleteBy) {
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
	public SoftwareMedia setDeleteTime(Date deleteTime) {
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
	public SoftwareMedia setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 typeData<br>
	 * typeData
	 * @return typeData
	*/
	public DictItem getTypeData() {
		return typeData;
	}
	
	/**
	 * 设置 typeData
	 * @param typeData typeData
	 * @return 当前对象
	*/
	public SoftwareMedia setTypeData(DictItem typeData) {
		this.typeData=typeData;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SoftwareMedia , 转换好的 SoftwareMedia 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SoftwareMedia , 转换好的 PoJo 对象
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
	public SoftwareMedia clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SoftwareMedia duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.SoftwareMediaMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.SoftwareMediaMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setRecTime(this.getRecTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setTypeData(this.getTypeData());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SoftwareMedia clone(boolean deep) {
		return EntityContext.clone(SoftwareMedia.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SoftwareMedia
	 * @param softwareMediaMap 包含实体信息的 Map 对象
	 * @return SoftwareMedia , 转换好的的 SoftwareMedia 对象
	*/
	@Transient
	public static SoftwareMedia createFrom(Map<String,Object> softwareMediaMap) {
		if(softwareMediaMap==null) return null;
		SoftwareMedia po = create();
		EntityContext.copyProperties(po,softwareMediaMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SoftwareMedia
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SoftwareMedia , 转换好的的 SoftwareMedia 对象
	*/
	@Transient
	public static SoftwareMedia createFrom(Object pojo) {
		if(pojo==null) return null;
		SoftwareMedia po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SoftwareMedia，等同于 new
	 * @return SoftwareMedia 对象
	*/
	@Transient
	public static SoftwareMedia create() {
		return new com.dt.platform.domain.ops.meta.SoftwareMediaMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(SoftwareMediaMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(SoftwareMediaMeta.NOTES)));
			this.setRecTime(DataParser.parse(Date.class, map.get(SoftwareMediaMeta.REC_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SoftwareMediaMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(SoftwareMediaMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SoftwareMediaMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SoftwareMediaMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SoftwareMediaMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SoftwareMediaMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SoftwareMediaMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SoftwareMediaMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SoftwareMediaMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SoftwareMediaMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SoftwareMediaMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(SoftwareMediaMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(SoftwareMediaMeta.FILE_ID)));
			// others
			this.setTypeData(DataParser.parse(DictItem.class, map.get(SoftwareMediaMeta.TYPE_DATA)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(SoftwareMediaMeta.CODE));
				this.setNotes( (String)map.get(SoftwareMediaMeta.NOTES));
				this.setRecTime( (Date)map.get(SoftwareMediaMeta.REC_TIME));
				this.setUpdateTime( (Date)map.get(SoftwareMediaMeta.UPDATE_TIME));
				this.setType( (String)map.get(SoftwareMediaMeta.TYPE));
				this.setVersion( (Integer)map.get(SoftwareMediaMeta.VERSION));
				this.setCreateBy( (String)map.get(SoftwareMediaMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SoftwareMediaMeta.DELETED));
				this.setCreateTime( (Date)map.get(SoftwareMediaMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SoftwareMediaMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SoftwareMediaMeta.DELETE_TIME));
				this.setName( (String)map.get(SoftwareMediaMeta.NAME));
				this.setDeleteBy( (String)map.get(SoftwareMediaMeta.DELETE_BY));
				this.setId( (String)map.get(SoftwareMediaMeta.ID));
				this.setStatus( (String)map.get(SoftwareMediaMeta.STATUS));
				this.setFileId( (String)map.get(SoftwareMediaMeta.FILE_ID));
				// others
				this.setTypeData( (DictItem)map.get(SoftwareMediaMeta.TYPE_DATA));
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
			this.setCode(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.NOTES)));
			this.setRecTime(DataParser.parse(Date.class, r.getValue(SoftwareMediaMeta.REC_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SoftwareMediaMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SoftwareMediaMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SoftwareMediaMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SoftwareMediaMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SoftwareMediaMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(SoftwareMediaMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(SoftwareMediaMeta.CODE));
				this.setNotes( (String)r.getValue(SoftwareMediaMeta.NOTES));
				this.setRecTime( (Date)r.getValue(SoftwareMediaMeta.REC_TIME));
				this.setUpdateTime( (Date)r.getValue(SoftwareMediaMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(SoftwareMediaMeta.TYPE));
				this.setVersion( (Integer)r.getValue(SoftwareMediaMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SoftwareMediaMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SoftwareMediaMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SoftwareMediaMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SoftwareMediaMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SoftwareMediaMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SoftwareMediaMeta.NAME));
				this.setDeleteBy( (String)r.getValue(SoftwareMediaMeta.DELETE_BY));
				this.setId( (String)r.getValue(SoftwareMediaMeta.ID));
				this.setStatus( (String)r.getValue(SoftwareMediaMeta.STATUS));
				this.setFileId( (String)r.getValue(SoftwareMediaMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}