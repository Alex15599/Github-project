package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CMDB_MODEL_V_H;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 配置值
 * <p>配置值 , 数据表 ops_cmdb_model_v_h 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:34:04
 * @sign 0D0BD55239724D7D4439E4E97D5B6F22
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_cmdb_model_v_h")
@ApiModel(description = "配置值 ; 配置值 , 数据表 ops_cmdb_model_v_h 的PO类型")
public class CmdbModelVH extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CMDB_MODEL_V_H.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 父：父
	*/
	@ApiModelProperty(required = false,value="父" , notes = "父")
	private String pid;
	
	/**
	 * 模型：模型
	*/
	@ApiModelProperty(required = false,value="模型" , notes = "模型")
	private String modelId;
	
	/**
	 * 模型编码：模型编码
	*/
	@ApiModelProperty(required = false,value="模型编码" , notes = "模型编码")
	private String modelCode;
	
	/**
	 * 数据跟踪：数据跟踪
	*/
	@ApiModelProperty(required = false,value="数据跟踪" , notes = "数据跟踪")
	private String dataTraceCode;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String vStatus;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = false,value="版本" , notes = "版本")
	private String vVersion;
	
	/**
	 * 对象：对象
	*/
	@ApiModelProperty(required = false,value="对象" , notes = "对象")
	private String objSourceId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 描述：描述
	*/
	@ApiModelProperty(required = false,value="描述" , notes = "描述")
	private String desc;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s1;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s2;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s3;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s4;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s5;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s6;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s7;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String s8;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m1;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m2;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m3;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m4;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m5;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m6;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m7;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m8;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m9;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String m10;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String bs1;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String bs2;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String bs3;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i1;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i2;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i3;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i4;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i5;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i6;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i7;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i8;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i9;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Integer i10;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d1;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d2;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d3;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d4;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d5;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d6;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d7;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private BigDecimal d8;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Date da1;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Date da2;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private Date da3;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * cmdbModel：cmdbModel
	*/
	@ApiModelProperty(required = false,value="cmdbModel" , notes = "cmdbModel")
	private CmdbModel cmdbModel;
	
	/**
	 * cmdbObjAttributeList：cmdbObjAttributeList
	*/
	@ApiModelProperty(required = false,value="cmdbObjAttributeList" , notes = "cmdbObjAttributeList")
	private List<CmdbObjAttribute> cmdbObjAttributeList;
	
	/**
	 * cmdbModelVParent：cmdbModelVParent
	*/
	@ApiModelProperty(required = false,value="cmdbModelVParent" , notes = "cmdbModelVParent")
	private CmdbModelV cmdbModelVParent;
	
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
	public CmdbModelVH setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 父<br>
	 * 父
	 * @return 父
	*/
	public String getPid() {
		return pid;
	}
	
	/**
	 * 设置 父
	 * @param pid 父
	 * @return 当前对象
	*/
	public CmdbModelVH setPid(String pid) {
		this.pid=pid;
		return this;
	}
	
	/**
	 * 获得 模型<br>
	 * 模型
	 * @return 模型
	*/
	public String getModelId() {
		return modelId;
	}
	
	/**
	 * 设置 模型
	 * @param modelId 模型
	 * @return 当前对象
	*/
	public CmdbModelVH setModelId(String modelId) {
		this.modelId=modelId;
		return this;
	}
	
	/**
	 * 获得 模型编码<br>
	 * 模型编码
	 * @return 模型编码
	*/
	public String getModelCode() {
		return modelCode;
	}
	
	/**
	 * 设置 模型编码
	 * @param modelCode 模型编码
	 * @return 当前对象
	*/
	public CmdbModelVH setModelCode(String modelCode) {
		this.modelCode=modelCode;
		return this;
	}
	
	/**
	 * 获得 数据跟踪<br>
	 * 数据跟踪
	 * @return 数据跟踪
	*/
	public String getDataTraceCode() {
		return dataTraceCode;
	}
	
	/**
	 * 设置 数据跟踪
	 * @param dataTraceCode 数据跟踪
	 * @return 当前对象
	*/
	public CmdbModelVH setDataTraceCode(String dataTraceCode) {
		this.dataTraceCode=dataTraceCode;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getVStatus() {
		return vStatus;
	}
	
	/**
	 * 设置 状态
	 * @param vStatus 状态
	 * @return 当前对象
	*/
	public CmdbModelVH setVStatus(String vStatus) {
		this.vStatus=vStatus;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public String getVVersion() {
		return vVersion;
	}
	
	/**
	 * 设置 版本
	 * @param vVersion 版本
	 * @return 当前对象
	*/
	public CmdbModelVH setVVersion(String vVersion) {
		this.vVersion=vVersion;
		return this;
	}
	
	/**
	 * 获得 对象<br>
	 * 对象
	 * @return 对象
	*/
	public String getObjSourceId() {
		return objSourceId;
	}
	
	/**
	 * 设置 对象
	 * @param objSourceId 对象
	 * @return 当前对象
	*/
	public CmdbModelVH setObjSourceId(String objSourceId) {
		this.objSourceId=objSourceId;
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
	public CmdbModelVH setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 描述<br>
	 * 描述
	 * @return 描述
	*/
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 设置 描述
	 * @param desc 描述
	 * @return 当前对象
	*/
	public CmdbModelVH setDesc(String desc) {
		this.desc=desc;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS1() {
		return s1;
	}
	
	/**
	 * 设置 内容
	 * @param s1 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS1(String s1) {
		this.s1=s1;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS2() {
		return s2;
	}
	
	/**
	 * 设置 内容
	 * @param s2 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS2(String s2) {
		this.s2=s2;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS3() {
		return s3;
	}
	
	/**
	 * 设置 内容
	 * @param s3 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS3(String s3) {
		this.s3=s3;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS4() {
		return s4;
	}
	
	/**
	 * 设置 内容
	 * @param s4 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS4(String s4) {
		this.s4=s4;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS5() {
		return s5;
	}
	
	/**
	 * 设置 内容
	 * @param s5 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS5(String s5) {
		this.s5=s5;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS6() {
		return s6;
	}
	
	/**
	 * 设置 内容
	 * @param s6 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS6(String s6) {
		this.s6=s6;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS7() {
		return s7;
	}
	
	/**
	 * 设置 内容
	 * @param s7 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS7(String s7) {
		this.s7=s7;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getS8() {
		return s8;
	}
	
	/**
	 * 设置 内容
	 * @param s8 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setS8(String s8) {
		this.s8=s8;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM1() {
		return m1;
	}
	
	/**
	 * 设置 内容
	 * @param m1 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM1(String m1) {
		this.m1=m1;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM2() {
		return m2;
	}
	
	/**
	 * 设置 内容
	 * @param m2 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM2(String m2) {
		this.m2=m2;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM3() {
		return m3;
	}
	
	/**
	 * 设置 内容
	 * @param m3 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM3(String m3) {
		this.m3=m3;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM4() {
		return m4;
	}
	
	/**
	 * 设置 内容
	 * @param m4 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM4(String m4) {
		this.m4=m4;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM5() {
		return m5;
	}
	
	/**
	 * 设置 内容
	 * @param m5 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM5(String m5) {
		this.m5=m5;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM6() {
		return m6;
	}
	
	/**
	 * 设置 内容
	 * @param m6 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM6(String m6) {
		this.m6=m6;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM7() {
		return m7;
	}
	
	/**
	 * 设置 内容
	 * @param m7 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM7(String m7) {
		this.m7=m7;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM8() {
		return m8;
	}
	
	/**
	 * 设置 内容
	 * @param m8 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM8(String m8) {
		this.m8=m8;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM9() {
		return m9;
	}
	
	/**
	 * 设置 内容
	 * @param m9 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM9(String m9) {
		this.m9=m9;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getM10() {
		return m10;
	}
	
	/**
	 * 设置 内容
	 * @param m10 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setM10(String m10) {
		this.m10=m10;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getBs1() {
		return bs1;
	}
	
	/**
	 * 设置 内容
	 * @param bs1 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setBs1(String bs1) {
		this.bs1=bs1;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getBs2() {
		return bs2;
	}
	
	/**
	 * 设置 内容
	 * @param bs2 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setBs2(String bs2) {
		this.bs2=bs2;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getBs3() {
		return bs3;
	}
	
	/**
	 * 设置 内容
	 * @param bs3 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setBs3(String bs3) {
		this.bs3=bs3;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI1() {
		return i1;
	}
	
	/**
	 * 设置 内容
	 * @param i1 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI1(Integer i1) {
		this.i1=i1;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI2() {
		return i2;
	}
	
	/**
	 * 设置 内容
	 * @param i2 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI2(Integer i2) {
		this.i2=i2;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI3() {
		return i3;
	}
	
	/**
	 * 设置 内容
	 * @param i3 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI3(Integer i3) {
		this.i3=i3;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI4() {
		return i4;
	}
	
	/**
	 * 设置 内容
	 * @param i4 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI4(Integer i4) {
		this.i4=i4;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI5() {
		return i5;
	}
	
	/**
	 * 设置 内容
	 * @param i5 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI5(Integer i5) {
		this.i5=i5;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI6() {
		return i6;
	}
	
	/**
	 * 设置 内容
	 * @param i6 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI6(Integer i6) {
		this.i6=i6;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI7() {
		return i7;
	}
	
	/**
	 * 设置 内容
	 * @param i7 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI7(Integer i7) {
		this.i7=i7;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI8() {
		return i8;
	}
	
	/**
	 * 设置 内容
	 * @param i8 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI8(Integer i8) {
		this.i8=i8;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI9() {
		return i9;
	}
	
	/**
	 * 设置 内容
	 * @param i9 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI9(Integer i9) {
		this.i9=i9;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Integer getI10() {
		return i10;
	}
	
	/**
	 * 设置 内容
	 * @param i10 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setI10(Integer i10) {
		this.i10=i10;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD1() {
		return d1;
	}
	
	/**
	 * 设置 内容
	 * @param d1 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD1(BigDecimal d1) {
		this.d1=d1;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD2() {
		return d2;
	}
	
	/**
	 * 设置 内容
	 * @param d2 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD2(BigDecimal d2) {
		this.d2=d2;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD3() {
		return d3;
	}
	
	/**
	 * 设置 内容
	 * @param d3 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD3(BigDecimal d3) {
		this.d3=d3;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD4() {
		return d4;
	}
	
	/**
	 * 设置 内容
	 * @param d4 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD4(BigDecimal d4) {
		this.d4=d4;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD5() {
		return d5;
	}
	
	/**
	 * 设置 内容
	 * @param d5 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD5(BigDecimal d5) {
		this.d5=d5;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD6() {
		return d6;
	}
	
	/**
	 * 设置 内容
	 * @param d6 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD6(BigDecimal d6) {
		this.d6=d6;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD7() {
		return d7;
	}
	
	/**
	 * 设置 内容
	 * @param d7 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD7(BigDecimal d7) {
		this.d7=d7;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public BigDecimal getD8() {
		return d8;
	}
	
	/**
	 * 设置 内容
	 * @param d8 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setD8(BigDecimal d8) {
		this.d8=d8;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Date getDa1() {
		return da1;
	}
	
	/**
	 * 设置 内容
	 * @param da1 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setDa1(Date da1) {
		this.da1=da1;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Date getDa2() {
		return da2;
	}
	
	/**
	 * 设置 内容
	 * @param da2 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setDa2(Date da2) {
		this.da2=da2;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public Date getDa3() {
		return da3;
	}
	
	/**
	 * 设置 内容
	 * @param da3 内容
	 * @return 当前对象
	*/
	public CmdbModelVH setDa3(Date da3) {
		this.da3=da3;
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
	public CmdbModelVH setNotes(String notes) {
		this.notes=notes;
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
	public CmdbModelVH setCreateBy(String createBy) {
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
	public CmdbModelVH setCreateTime(Date createTime) {
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
	public CmdbModelVH setUpdateBy(String updateBy) {
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
	public CmdbModelVH setUpdateTime(Date updateTime) {
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
	public CmdbModelVH setDeleted(Integer deleted) {
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
	public CmdbModelVH setDeleted(Boolean deletedBool) {
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
	public CmdbModelVH setDeleteBy(String deleteBy) {
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
	public CmdbModelVH setDeleteTime(Date deleteTime) {
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
	public CmdbModelVH setVersion(Integer version) {
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
	public CmdbModelVH setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 cmdbModel<br>
	 * cmdbModel
	 * @return cmdbModel
	*/
	public CmdbModel getCmdbModel() {
		return cmdbModel;
	}
	
	/**
	 * 设置 cmdbModel
	 * @param cmdbModel cmdbModel
	 * @return 当前对象
	*/
	public CmdbModelVH setCmdbModel(CmdbModel cmdbModel) {
		this.cmdbModel=cmdbModel;
		return this;
	}
	
	/**
	 * 获得 cmdbObjAttributeList<br>
	 * cmdbObjAttributeList
	 * @return cmdbObjAttributeList
	*/
	public List<CmdbObjAttribute> getCmdbObjAttributeList() {
		return cmdbObjAttributeList;
	}
	
	/**
	 * 设置 cmdbObjAttributeList
	 * @param cmdbObjAttributeList cmdbObjAttributeList
	 * @return 当前对象
	*/
	public CmdbModelVH setCmdbObjAttributeList(List<CmdbObjAttribute> cmdbObjAttributeList) {
		this.cmdbObjAttributeList=cmdbObjAttributeList;
		return this;
	}
	
	/**
	 * 添加 cmdbObjAttributeList
	 * @param cmdbObjAttribute cmdbObjAttributeList
	 * @return 当前对象
	*/
	public CmdbModelVH addCmdbObjAttribute(CmdbObjAttribute... cmdbObjAttribute) {
		if(this.cmdbObjAttributeList==null) cmdbObjAttributeList=new ArrayList<>();
		this.cmdbObjAttributeList.addAll(Arrays.asList(cmdbObjAttribute));
		return this;
	}
	
	/**
	 * 获得 cmdbModelVParent<br>
	 * cmdbModelVParent
	 * @return cmdbModelVParent
	*/
	public CmdbModelV getCmdbModelVParent() {
		return cmdbModelVParent;
	}
	
	/**
	 * 设置 cmdbModelVParent
	 * @param cmdbModelVParent cmdbModelVParent
	 * @return 当前对象
	*/
	public CmdbModelVH setCmdbModelVParent(CmdbModelV cmdbModelVParent) {
		this.cmdbModelVParent=cmdbModelVParent;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CmdbModelVH , 转换好的 CmdbModelVH 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CmdbModelVH , 转换好的 PoJo 对象
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
	public CmdbModelVH clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CmdbModelVH duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CmdbModelVHMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CmdbModelVHMeta.$$proxy$$();
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
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CmdbModelVH clone(boolean deep) {
		return EntityContext.clone(CmdbModelVH.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CmdbModelVH
	 * @param cmdbModelVHMap 包含实体信息的 Map 对象
	 * @return CmdbModelVH , 转换好的的 CmdbModelVH 对象
	*/
	@Transient
	public static CmdbModelVH createFrom(Map<String,Object> cmdbModelVHMap) {
		if(cmdbModelVHMap==null) return null;
		CmdbModelVH po = create();
		EntityContext.copyProperties(po,cmdbModelVHMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CmdbModelVH
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CmdbModelVH , 转换好的的 CmdbModelVH 对象
	*/
	@Transient
	public static CmdbModelVH createFrom(Object pojo) {
		if(pojo==null) return null;
		CmdbModelVH po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CmdbModelVH，等同于 new
	 * @return CmdbModelVH 对象
	*/
	@Transient
	public static CmdbModelVH create() {
		return new com.dt.platform.domain.ops.meta.CmdbModelVHMeta.$$proxy$$();
	}
}