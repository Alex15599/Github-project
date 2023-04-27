package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CmdbModelV;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:33:56
 * @sign 8D55CBDC18C89225C5BF7F137B352574
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CmdbModelVMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 父 , 类型: java.lang.String
	*/
	public static final String PID="pid";
	
	/**
	 * 父 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> PID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,PID, java.lang.String.class, "父", "父", java.lang.String.class, null);
	
	/**
	 * 模型 , 类型: java.lang.String
	*/
	public static final String MODEL_ID="modelId";
	
	/**
	 * 模型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> MODEL_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,MODEL_ID, java.lang.String.class, "模型", "模型", java.lang.String.class, null);
	
	/**
	 * 模型编码 , 类型: java.lang.String
	*/
	public static final String MODEL_CODE="modelCode";
	
	/**
	 * 模型编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> MODEL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,MODEL_CODE, java.lang.String.class, "模型编码", "模型编码", java.lang.String.class, null);
	
	/**
	 * 数据跟踪 , 类型: java.lang.String
	*/
	public static final String DATA_TRACE_CODE="dataTraceCode";
	
	/**
	 * 数据跟踪 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> DATA_TRACE_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DATA_TRACE_CODE, java.lang.String.class, "数据跟踪", "数据跟踪", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String V_STATUS="vStatus";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> V_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,V_STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final String V_VERSION="vVersion";
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> V_VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,V_VERSION, java.lang.String.class, "版本", "版本", java.lang.String.class, null);
	
	/**
	 * 对象 , 类型: java.lang.String
	*/
	public static final String OBJ_SOURCE_ID="objSourceId";
	
	/**
	 * 对象 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> OBJ_SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,OBJ_SOURCE_ID, java.lang.String.class, "对象", "对象", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String DESC="desc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> DESC_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S1="s1";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S1_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S1, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S2="s2";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S2_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S2, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S3="s3";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S3_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S3, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S4="s4";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S4_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S4, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S5="s5";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S5_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S5, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S6="s6";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S6_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S6, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S7="s7";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S7_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S7, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String S8="s8";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> S8_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,S8, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M1="m1";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M1_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M1, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M2="m2";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M2_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M2, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M3="m3";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M3_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M3, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M4="m4";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M4_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M4, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M5="m5";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M5_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M5, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M6="m6";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M6_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M6, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M7="m7";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M7_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M7, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M8="m8";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M8_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M8, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M9="m9";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M9_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M9, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String M10="m10";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> M10_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,M10, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String BS1="bs1";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> BS1_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,BS1, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String BS2="bs2";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> BS2_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,BS2, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String BS3="bs3";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> BS3_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,BS3, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I1="i1";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I1_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I1, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I2="i2";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I2_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I2, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I3="i3";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I3_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I3, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I4="i4";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I4_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I4, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I5="i5";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I5_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I5, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I6="i6";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I6_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I6, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I7="i7";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I7_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I7, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I8="i8";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I8_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I8, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I9="i9";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I9_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I9, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final String I10="i10";
	
	/**
	 * 内容 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> I10_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,I10, java.lang.Integer.class, "内容", "内容", java.lang.Integer.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D1="d1";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D1_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D1, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D2="d2";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D2_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D2, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D3="d3";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D3_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D3, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D4="d4";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D4_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D4, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D5="d5";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D5_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D5, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D6="d6";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D6_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D6, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D7="d7";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D7_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D7, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final String D8="d8";
	
	/**
	 * 内容 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.math.BigDecimal> D8_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,D8, java.math.BigDecimal.class, "内容", "内容", java.math.BigDecimal.class, null);
	
	/**
	 * 内容 , 类型: java.util.Date
	*/
	public static final String DA1="da1";
	
	/**
	 * 内容 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.util.Date> DA1_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DA1, java.util.Date.class, "内容", "内容", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.util.Date
	*/
	public static final String DA2="da2";
	
	/**
	 * 内容 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.util.Date> DA2_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DA2, java.util.Date.class, "内容", "内容", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.util.Date
	*/
	public static final String DA3="da3";
	
	/**
	 * 内容 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.util.Date> DA3_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DA3, java.util.Date.class, "内容", "内容", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * cmdbModel , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final String CMDB_MODEL="cmdbModel";
	
	/**
	 * cmdbModel , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,com.dt.platform.domain.ops.CmdbModel> CMDB_MODEL_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,CMDB_MODEL, com.dt.platform.domain.ops.CmdbModel.class, "cmdbModel", "cmdbModel", com.dt.platform.domain.ops.CmdbModel.class, null);
	
	/**
	 * cmdbObjAttributeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbObjAttribute
	*/
	public static final String CMDB_OBJ_ATTRIBUTE_LIST="cmdbObjAttributeList";
	
	/**
	 * cmdbObjAttributeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbObjAttribute
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,com.dt.platform.domain.ops.CmdbObjAttribute> CMDB_OBJ_ATTRIBUTE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,CMDB_OBJ_ATTRIBUTE_LIST, java.util.List.class, "cmdbObjAttributeList", "cmdbObjAttributeList", com.dt.platform.domain.ops.CmdbObjAttribute.class, null);
	
	/**
	 * cmdbModelVParent , 类型: com.dt.platform.domain.ops.CmdbModelV
	*/
	public static final String CMDB_MODEL_V_PARENT="cmdbModelVParent";
	
	/**
	 * cmdbModelVParent , 类型: com.dt.platform.domain.ops.CmdbModelV
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelV,com.dt.platform.domain.ops.CmdbModelV> CMDB_MODEL_V_PARENT_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelV.class ,CMDB_MODEL_V_PARENT, com.dt.platform.domain.ops.CmdbModelV.class, "cmdbModelVParent", "cmdbModelVParent", com.dt.platform.domain.ops.CmdbModelV.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PID , MODEL_ID , MODEL_CODE , DATA_TRACE_CODE , V_STATUS , V_VERSION , OBJ_SOURCE_ID , NAME , DESC , S1 , S2 , S3 , S4 , S5 , S6 , S7 , S8 , M1 , M2 , M3 , M4 , M5 , M6 , M7 , M8 , M9 , M10 , BS1 , BS2 , BS3 , I1 , I2 , I3 , I4 , I5 , I6 , I7 , I8 , I9 , I10 , D1 , D2 , D3 , D4 , D5 , D6 , D7 , D8 , DA1 , DA2 , DA3 , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CMDB_MODEL , CMDB_OBJ_ATTRIBUTE_LIST , CMDB_MODEL_V_PARENT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CmdbModelV {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CmdbModelV setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 父
		 * @param pid 父
		 * @return 当前对象
		*/
		public CmdbModelV setPid(String pid) {
			super.change(PID,super.getPid(),pid);
			super.setPid(pid);
			return this;
		}
		
		/**
		 * 设置 模型
		 * @param modelId 模型
		 * @return 当前对象
		*/
		public CmdbModelV setModelId(String modelId) {
			super.change(MODEL_ID,super.getModelId(),modelId);
			super.setModelId(modelId);
			return this;
		}
		
		/**
		 * 设置 模型编码
		 * @param modelCode 模型编码
		 * @return 当前对象
		*/
		public CmdbModelV setModelCode(String modelCode) {
			super.change(MODEL_CODE,super.getModelCode(),modelCode);
			super.setModelCode(modelCode);
			return this;
		}
		
		/**
		 * 设置 数据跟踪
		 * @param dataTraceCode 数据跟踪
		 * @return 当前对象
		*/
		public CmdbModelV setDataTraceCode(String dataTraceCode) {
			super.change(DATA_TRACE_CODE,super.getDataTraceCode(),dataTraceCode);
			super.setDataTraceCode(dataTraceCode);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param vStatus 状态
		 * @return 当前对象
		*/
		public CmdbModelV setVStatus(String vStatus) {
			super.change(V_STATUS,super.getVStatus(),vStatus);
			super.setVStatus(vStatus);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param vVersion 版本
		 * @return 当前对象
		*/
		public CmdbModelV setVVersion(String vVersion) {
			super.change(V_VERSION,super.getVVersion(),vVersion);
			super.setVVersion(vVersion);
			return this;
		}
		
		/**
		 * 设置 对象
		 * @param objSourceId 对象
		 * @return 当前对象
		*/
		public CmdbModelV setObjSourceId(String objSourceId) {
			super.change(OBJ_SOURCE_ID,super.getObjSourceId(),objSourceId);
			super.setObjSourceId(objSourceId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CmdbModelV setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param desc 描述
		 * @return 当前对象
		*/
		public CmdbModelV setDesc(String desc) {
			super.change(DESC,super.getDesc(),desc);
			super.setDesc(desc);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s1 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS1(String s1) {
			super.change(S1,super.getS1(),s1);
			super.setS1(s1);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s2 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS2(String s2) {
			super.change(S2,super.getS2(),s2);
			super.setS2(s2);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s3 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS3(String s3) {
			super.change(S3,super.getS3(),s3);
			super.setS3(s3);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s4 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS4(String s4) {
			super.change(S4,super.getS4(),s4);
			super.setS4(s4);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s5 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS5(String s5) {
			super.change(S5,super.getS5(),s5);
			super.setS5(s5);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s6 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS6(String s6) {
			super.change(S6,super.getS6(),s6);
			super.setS6(s6);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s7 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS7(String s7) {
			super.change(S7,super.getS7(),s7);
			super.setS7(s7);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param s8 内容
		 * @return 当前对象
		*/
		public CmdbModelV setS8(String s8) {
			super.change(S8,super.getS8(),s8);
			super.setS8(s8);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m1 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM1(String m1) {
			super.change(M1,super.getM1(),m1);
			super.setM1(m1);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m2 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM2(String m2) {
			super.change(M2,super.getM2(),m2);
			super.setM2(m2);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m3 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM3(String m3) {
			super.change(M3,super.getM3(),m3);
			super.setM3(m3);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m4 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM4(String m4) {
			super.change(M4,super.getM4(),m4);
			super.setM4(m4);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m5 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM5(String m5) {
			super.change(M5,super.getM5(),m5);
			super.setM5(m5);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m6 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM6(String m6) {
			super.change(M6,super.getM6(),m6);
			super.setM6(m6);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m7 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM7(String m7) {
			super.change(M7,super.getM7(),m7);
			super.setM7(m7);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m8 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM8(String m8) {
			super.change(M8,super.getM8(),m8);
			super.setM8(m8);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m9 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM9(String m9) {
			super.change(M9,super.getM9(),m9);
			super.setM9(m9);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param m10 内容
		 * @return 当前对象
		*/
		public CmdbModelV setM10(String m10) {
			super.change(M10,super.getM10(),m10);
			super.setM10(m10);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param bs1 内容
		 * @return 当前对象
		*/
		public CmdbModelV setBs1(String bs1) {
			super.change(BS1,super.getBs1(),bs1);
			super.setBs1(bs1);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param bs2 内容
		 * @return 当前对象
		*/
		public CmdbModelV setBs2(String bs2) {
			super.change(BS2,super.getBs2(),bs2);
			super.setBs2(bs2);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param bs3 内容
		 * @return 当前对象
		*/
		public CmdbModelV setBs3(String bs3) {
			super.change(BS3,super.getBs3(),bs3);
			super.setBs3(bs3);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i1 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI1(Integer i1) {
			super.change(I1,super.getI1(),i1);
			super.setI1(i1);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i2 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI2(Integer i2) {
			super.change(I2,super.getI2(),i2);
			super.setI2(i2);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i3 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI3(Integer i3) {
			super.change(I3,super.getI3(),i3);
			super.setI3(i3);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i4 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI4(Integer i4) {
			super.change(I4,super.getI4(),i4);
			super.setI4(i4);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i5 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI5(Integer i5) {
			super.change(I5,super.getI5(),i5);
			super.setI5(i5);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i6 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI6(Integer i6) {
			super.change(I6,super.getI6(),i6);
			super.setI6(i6);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i7 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI7(Integer i7) {
			super.change(I7,super.getI7(),i7);
			super.setI7(i7);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i8 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI8(Integer i8) {
			super.change(I8,super.getI8(),i8);
			super.setI8(i8);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i9 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI9(Integer i9) {
			super.change(I9,super.getI9(),i9);
			super.setI9(i9);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param i10 内容
		 * @return 当前对象
		*/
		public CmdbModelV setI10(Integer i10) {
			super.change(I10,super.getI10(),i10);
			super.setI10(i10);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d1 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD1(BigDecimal d1) {
			super.change(D1,super.getD1(),d1);
			super.setD1(d1);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d2 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD2(BigDecimal d2) {
			super.change(D2,super.getD2(),d2);
			super.setD2(d2);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d3 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD3(BigDecimal d3) {
			super.change(D3,super.getD3(),d3);
			super.setD3(d3);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d4 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD4(BigDecimal d4) {
			super.change(D4,super.getD4(),d4);
			super.setD4(d4);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d5 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD5(BigDecimal d5) {
			super.change(D5,super.getD5(),d5);
			super.setD5(d5);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d6 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD6(BigDecimal d6) {
			super.change(D6,super.getD6(),d6);
			super.setD6(d6);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d7 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD7(BigDecimal d7) {
			super.change(D7,super.getD7(),d7);
			super.setD7(d7);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param d8 内容
		 * @return 当前对象
		*/
		public CmdbModelV setD8(BigDecimal d8) {
			super.change(D8,super.getD8(),d8);
			super.setD8(d8);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param da1 内容
		 * @return 当前对象
		*/
		public CmdbModelV setDa1(Date da1) {
			super.change(DA1,super.getDa1(),da1);
			super.setDa1(da1);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param da2 内容
		 * @return 当前对象
		*/
		public CmdbModelV setDa2(Date da2) {
			super.change(DA2,super.getDa2(),da2);
			super.setDa2(da2);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param da3 内容
		 * @return 当前对象
		*/
		public CmdbModelV setDa3(Date da3) {
			super.change(DA3,super.getDa3(),da3);
			super.setDa3(da3);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CmdbModelV setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CmdbModelV setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CmdbModelV setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CmdbModelV setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CmdbModelV setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CmdbModelV setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CmdbModelV setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CmdbModelV setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CmdbModelV setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CmdbModelV setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 cmdbModel
		 * @param cmdbModel cmdbModel
		 * @return 当前对象
		*/
		public CmdbModelV setCmdbModel(CmdbModel cmdbModel) {
			super.change(CMDB_MODEL,super.getCmdbModel(),cmdbModel);
			super.setCmdbModel(cmdbModel);
			return this;
		}
		
		/**
		 * 设置 cmdbObjAttributeList
		 * @param cmdbObjAttributeList cmdbObjAttributeList
		 * @return 当前对象
		*/
		public CmdbModelV setCmdbObjAttributeList(List<CmdbObjAttribute> cmdbObjAttributeList) {
			super.change(CMDB_OBJ_ATTRIBUTE_LIST,super.getCmdbObjAttributeList(),cmdbObjAttributeList);
			super.setCmdbObjAttributeList(cmdbObjAttributeList);
			return this;
		}
		
		/**
		 * 设置 cmdbModelVParent
		 * @param cmdbModelVParent cmdbModelVParent
		 * @return 当前对象
		*/
		public CmdbModelV setCmdbModelVParent(CmdbModelV cmdbModelVParent) {
			super.change(CMDB_MODEL_V_PARENT,super.getCmdbModelVParent(),cmdbModelVParent);
			super.setCmdbModelVParent(cmdbModelVParent);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CmdbModelV clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CmdbModelV duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
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

	}
}