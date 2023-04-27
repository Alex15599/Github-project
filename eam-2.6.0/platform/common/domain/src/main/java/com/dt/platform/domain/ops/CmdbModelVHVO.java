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



/**
 * 配置值VO类型
 * <p>配置值 , 数据表 ops_cmdb_model_v_h 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:34:04
 * @sign 0CD26D04A224A5CFD1796BDBD9049868
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "配置值VO类型 ; 配置值 , 数据表 ops_cmdb_model_v_h 的通用VO类型" , parent = CmdbModelVH.class)
public class CmdbModelVHVO extends CmdbModelVH {

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
	public CmdbModelVHVO setPageIndex(Integer pageIndex) {
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
	public CmdbModelVHVO setPageSize(Integer pageSize) {
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
	public CmdbModelVHVO setSearchField(String searchField) {
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
	public CmdbModelVHVO setFuzzyField(String fuzzyField) {
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
	public CmdbModelVHVO setSearchValue(String searchValue) {
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
	public CmdbModelVHVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CmdbModelVHVO addDirtyField(String... dirtyField) {
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
	public CmdbModelVHVO setSortField(String sortField) {
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
	public CmdbModelVHVO setSortType(String sortType) {
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
	public CmdbModelVHVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CmdbModelVHVO addId(String... id) {
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
	 * @return CmdbModelVHVO , 转换好的 CmdbModelVHVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CmdbModelVHVO , 转换好的 PoJo 对象
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
	public CmdbModelVHVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CmdbModelVHVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CmdbModelVHVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CmdbModelVHVOMeta.$$proxy$$();
		inst.setBs2(this.getBs2());
		inst.setBs1(this.getBs1());
		inst.setBs3(this.getBs3());
		inst.setNotes(this.getNotes());
		inst.setModelId(this.getModelId());
		inst.setPid(this.getPid());
		inst.setModelCode(this.getModelCode());
		inst.setId(this.getId());
		inst.setS1(this.getS1());
		inst.setS2(this.getS2());
		inst.setS3(this.getS3());
		inst.setS4(this.getS4());
		inst.setS5(this.getS5());
		inst.setObjSourceId(this.getObjSourceId());
		inst.setS6(this.getS6());
		inst.setS7(this.getS7());
		inst.setS8(this.getS8());
		inst.setVersion(this.getVersion());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setDesc(this.getDesc());
		inst.setDataTraceCode(this.getDataTraceCode());
		inst.setI10(this.getI10());
		inst.setM10(this.getM10());
		inst.setD1(this.getD1());
		inst.setD2(this.getD2());
		inst.setD3(this.getD3());
		inst.setD4(this.getD4());
		inst.setD5(this.getD5());
		inst.setD6(this.getD6());
		inst.setD7(this.getD7());
		inst.setD8(this.getD8());
		inst.setDa2(this.getDa2());
		inst.setDa1(this.getDa1());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDa3(this.getDa3());
		inst.setVStatus(this.getVStatus());
		inst.setM1(this.getM1());
		inst.setM2(this.getM2());
		inst.setM3(this.getM3());
		inst.setM4(this.getM4());
		inst.setM5(this.getM5());
		inst.setI1(this.getI1());
		inst.setM6(this.getM6());
		inst.setI2(this.getI2());
		inst.setM7(this.getM7());
		inst.setI3(this.getI3());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setM8(this.getM8());
		inst.setI4(this.getI4());
		inst.setM9(this.getM9());
		inst.setI5(this.getI5());
		inst.setI6(this.getI6());
		inst.setI7(this.getI7());
		inst.setI8(this.getI8());
		inst.setI9(this.getI9());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setVVersion(this.getVVersion());
		if(all) {
			inst.setCmdbModelVParent(this.getCmdbModelVParent());
			inst.setCmdbModel(this.getCmdbModel());
			inst.setCmdbObjAttributeList(this.getCmdbObjAttributeList());
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
	public CmdbModelVHVO clone(boolean deep) {
		return EntityContext.clone(CmdbModelVHVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CmdbModelVHVO
	 * @param cmdbModelVHMap 包含实体信息的 Map 对象
	 * @return CmdbModelVHVO , 转换好的的 CmdbModelVH 对象
	*/
	@Transient
	public static CmdbModelVHVO createFrom(Map<String,Object> cmdbModelVHMap) {
		if(cmdbModelVHMap==null) return null;
		CmdbModelVHVO vo = create();
		EntityContext.copyProperties(vo,cmdbModelVHMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CmdbModelVHVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CmdbModelVHVO , 转换好的的 CmdbModelVH 对象
	*/
	@Transient
	public static CmdbModelVHVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CmdbModelVHVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CmdbModelVHVO，等同于 new
	 * @return CmdbModelVHVO 对象
	*/
	@Transient
	public static CmdbModelVHVO create() {
		return new com.dt.platform.domain.ops.meta.CmdbModelVHVOMeta.$$proxy$$();
	}
}