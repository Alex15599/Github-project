package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_PUBLIC_CONTENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.PublicContentMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 开放列
 * <p>开放列 , 数据表 ops_public_content 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-04 15:55:13
 * @sign 8669399B4E39FAFF0BF1B08C538CEFFA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_public_content")
@ApiModel(description = "开放列 ; 开放列 , 数据表 ops_public_content 的PO类型")
public class PublicContent extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_PUBLIC_CONTENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "673971266721415168")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "list")
	private String type;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "(仅内部使用误外传)-数据库例列表-(生产环境)")
	private String name;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址" , example = "http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html")
	private String address;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件")
	private String files;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询")
	private String notes;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "100")
	private Integer sort;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-02-03 07:21:12")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-02-04 12:34:38")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "10")
	private Integer version;
	
	/**
	 * typeData：typeData
	*/
	@ApiModelProperty(required = false,value="typeData" , notes = "typeData")
	private List<DictItem> typeData;
	
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
	public PublicContent setId(String id) {
		this.id=id;
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
	public PublicContent setStatus(String status) {
		this.status=status;
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
	public PublicContent setType(String type) {
		this.type=type;
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
	public PublicContent setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 地址
	 * @param address 地址
	 * @return 当前对象
	*/
	public PublicContent setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getFiles() {
		return files;
	}
	
	/**
	 * 设置 文件
	 * @param files 文件
	 * @return 当前对象
	*/
	public PublicContent setFiles(String files) {
		this.files=files;
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
	public PublicContent setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public PublicContent setSort(Integer sort) {
		this.sort=sort;
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
	public PublicContent setCreateBy(String createBy) {
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
	public PublicContent setCreateTime(Date createTime) {
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
	public PublicContent setUpdateBy(String updateBy) {
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
	public PublicContent setUpdateTime(Date updateTime) {
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
	public PublicContent setDeleted(Integer deleted) {
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
	public PublicContent setDeleted(Boolean deletedBool) {
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
	public PublicContent setDeleteBy(String deleteBy) {
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
	public PublicContent setDeleteTime(Date deleteTime) {
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
	public PublicContent setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 typeData<br>
	 * typeData
	 * @return typeData
	*/
	public List<DictItem> getTypeData() {
		return typeData;
	}
	
	/**
	 * 设置 typeData
	 * @param typeData typeData
	 * @return 当前对象
	*/
	public PublicContent setTypeData(List<DictItem> typeData) {
		this.typeData=typeData;
		return this;
	}
	
	/**
	 * 添加 typeData
	 * @param entity typeData
	 * @return 当前对象
	*/
	public PublicContent addTypeData(DictItem... entity) {
		if(this.typeData==null) typeData=new ArrayList<>();
		this.typeData.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PublicContent , 转换好的 PublicContent 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PublicContent , 转换好的 PoJo 对象
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
	public PublicContent clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PublicContent duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.PublicContentMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.PublicContentMeta.$$proxy$$();
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setFiles(this.getFiles());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
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
	public PublicContent clone(boolean deep) {
		return EntityContext.clone(PublicContent.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PublicContent
	 * @param publicContentMap 包含实体信息的 Map 对象
	 * @return PublicContent , 转换好的的 PublicContent 对象
	*/
	@Transient
	public static PublicContent createFrom(Map<String,Object> publicContentMap) {
		if(publicContentMap==null) return null;
		PublicContent po = create();
		EntityContext.copyProperties(po,publicContentMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PublicContent
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PublicContent , 转换好的的 PublicContent 对象
	*/
	@Transient
	public static PublicContent createFrom(Object pojo) {
		if(pojo==null) return null;
		PublicContent po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PublicContent，等同于 new
	 * @return PublicContent 对象
	*/
	@Transient
	public static PublicContent create() {
		return new com.dt.platform.domain.ops.meta.PublicContentMeta.$$proxy$$();
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
			this.setAddress(DataParser.parse(String.class, map.get(PublicContentMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(PublicContentMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PublicContentMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(PublicContentMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(PublicContentMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PublicContentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PublicContentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PublicContentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PublicContentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PublicContentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PublicContentMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PublicContentMeta.NAME)));
			this.setFiles(DataParser.parse(String.class, map.get(PublicContentMeta.FILES)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PublicContentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PublicContentMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PublicContentMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setAddress( (String)map.get(PublicContentMeta.ADDRESS));
				this.setNotes( (String)map.get(PublicContentMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PublicContentMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(PublicContentMeta.SORT));
				this.setType( (String)map.get(PublicContentMeta.TYPE));
				this.setVersion( (Integer)map.get(PublicContentMeta.VERSION));
				this.setCreateBy( (String)map.get(PublicContentMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PublicContentMeta.DELETED));
				this.setCreateTime( (Date)map.get(PublicContentMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PublicContentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PublicContentMeta.DELETE_TIME));
				this.setName( (String)map.get(PublicContentMeta.NAME));
				this.setFiles( (String)map.get(PublicContentMeta.FILES));
				this.setDeleteBy( (String)map.get(PublicContentMeta.DELETE_BY));
				this.setId( (String)map.get(PublicContentMeta.ID));
				this.setStatus( (String)map.get(PublicContentMeta.STATUS));
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
			this.setAddress(DataParser.parse(String.class, r.getValue(PublicContentMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PublicContentMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PublicContentMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(PublicContentMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(PublicContentMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PublicContentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PublicContentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PublicContentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PublicContentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PublicContentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PublicContentMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PublicContentMeta.NAME)));
			this.setFiles(DataParser.parse(String.class, r.getValue(PublicContentMeta.FILES)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PublicContentMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PublicContentMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PublicContentMeta.STATUS)));
			return true;
		} else {
			try {
				this.setAddress( (String)r.getValue(PublicContentMeta.ADDRESS));
				this.setNotes( (String)r.getValue(PublicContentMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PublicContentMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(PublicContentMeta.SORT));
				this.setType( (String)r.getValue(PublicContentMeta.TYPE));
				this.setVersion( (Integer)r.getValue(PublicContentMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PublicContentMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PublicContentMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PublicContentMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PublicContentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PublicContentMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PublicContentMeta.NAME));
				this.setFiles( (String)r.getValue(PublicContentMeta.FILES));
				this.setDeleteBy( (String)r.getValue(PublicContentMeta.DELETE_BY));
				this.setId( (String)r.getValue(PublicContentMeta.ID));
				this.setStatus( (String)r.getValue(PublicContentMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}