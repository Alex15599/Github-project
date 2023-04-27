package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.Map;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import java.util.List;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产
 * <p>资产 , 数据表 eam_asset 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 18:19:38
 * @sign EE001FD2DFF6A8AB5FBE33BFCD3FBCE8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset")
@ApiModel(description = "资产 ; 资产 , 数据表 eam_asset 的PO类型")
public class Asset extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "515552857844350976")
	private String id;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 分类编码：分类编码
	*/
	@ApiModelProperty(required = false,value="分类编码" , notes = "分类编码")
	private String categoryCode;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 批次编码：批次编码
	*/
	@ApiModelProperty(required = false,value="批次编码" , notes = "批次编码")
	private String batchCode;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属" , example = "asset_change_record")
	private String ownerCode;
	
	/**
	 * 资产编号：资产编号
	*/
	@ApiModelProperty(required = false,value="资产编号" , notes = "资产编号")
	private String assetCode;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态")
	private String assetStatus;
	
	/**
	 * 是否显示：是否显示
	*/
	@ApiModelProperty(required = false,value="是否显示" , notes = "是否显示")
	private String display;
	
	/**
	 * 是否清理：是否清理
	*/
	@ApiModelProperty(required = false,value="是否清理" , notes = "是否清理" , example = "0")
	private String cleanOut;
	
	/**
	 * 标准物品档案：标准物品档案
	*/
	@ApiModelProperty(required = false,value="标准物品档案" , notes = "标准物品档案")
	private String goodsId;
	
	/**
	 * 标准型号资产名称：标准型号资产名称
	*/
	@ApiModelProperty(required = false,value="标准型号资产名称" , notes = "标准型号资产名称")
	private String name;
	
	/**
	 * 标准型号厂商：标准型号厂商
	*/
	@ApiModelProperty(required = false,value="标准型号厂商" , notes = "标准型号厂商")
	private String manufacturerId;
	
	/**
	 * 标准型号规格型号：标准型号规格型号
	*/
	@ApiModelProperty(required = false,value="标准型号规格型号" , notes = "标准型号规格型号")
	private String model;
	
	/**
	 * 标准型号物品图片：标准型号物品图片
	*/
	@ApiModelProperty(required = false,value="标准型号物品图片" , notes = "标准型号物品图片")
	private String pictureId;
	
	/**
	 * 标准型号计量单位：标准型号计量单位
	*/
	@ApiModelProperty(required = false,value="标准型号计量单位" , notes = "标准型号计量单位")
	private String unit;
	
	/**
	 * 使用期限：(月)
	*/
	@ApiModelProperty(required = false,value="使用期限" , notes = "(月)")
	private BigDecimal serviceLife;
	
	/**
	 * 安全等级：安全等级
	*/
	@ApiModelProperty(required = false,value="安全等级" , notes = "安全等级")
	private String safetyLevelCode;
	
	/**
	 * 序列号：序列号
	*/
	@ApiModelProperty(required = false,value="序列号" , notes = "序列号")
	private String serialNumber;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private String managerId;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private String useOrganizationId;
	
	/**
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private String useUserId;
	
	/**
	 * 存放区域：存放区域
	*/
	@ApiModelProperty(required = false,value="存放区域" , notes = "存放区域")
	private String regionId;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private String positionId;
	
	/**
	 * 详细位置：详细位置
	*/
	@ApiModelProperty(required = false,value="详细位置" , notes = "详细位置")
	private String positionDetail;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
	/**
	 * 库存物品：库存物品
	*/
	@ApiModelProperty(required = false,value="库存物品" , notes = "库存物品")
	private String goodsStockId;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String sourceId;
	
	/**
	 * 资产数量：资产数量
	*/
	@ApiModelProperty(required = false,value="资产数量" , notes = "资产数量")
	private Integer assetNumber;
	
	/**
	 * 剩余数量：剩余数量
	*/
	@ApiModelProperty(required = false,value="剩余数量" , notes = "剩余数量")
	private Integer remainNumber;
	
	/**
	 * 采购日期：采购日期
	*/
	@ApiModelProperty(required = false,value="采购日期" , notes = "采购日期")
	private Date purchaseDate;
	
	/**
	 * 生产日期：生产日期
	*/
	@ApiModelProperty(required = false,value="生产日期" , notes = "生产日期")
	private Date productionDate;
	
	/**
	 * 入账日期：入账日期
	*/
	@ApiModelProperty(required = false,value="入账日期" , notes = "入账日期")
	private Date registerDate;
	
	/**
	 * RFID标签：RFID标签
	*/
	@ApiModelProperty(required = false,value="RFID标签" , notes = "RFID标签")
	private String rfid;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 最近核对日期：最近核对日期
	*/
	@ApiModelProperty(required = false,value="最近核对日期" , notes = "最近核对日期" , example = "2022-01-06 12:00:00")
	private Date lastVerificationDate;
	
	/**
	 * 用途：用途
	*/
	@ApiModelProperty(required = false,value="用途" , notes = "用途")
	private String purpose;
	
	/**
	 * 资产备注：资产备注
	*/
	@ApiModelProperty(required = false,value="资产备注" , notes = "资产备注")
	private String assetNotes;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商")
	private String maintainerId;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商" , example = "121212")
	private String maintainerName;
	
	/**
	 * 维保状态：维保状态
	*/
	@ApiModelProperty(required = false,value="维保状态" , notes = "维保状态")
	private String maintenanceStatus;
	
	/**
	 * 维保价格：维保价格
	*/
	@ApiModelProperty(required = false,value="维保价格" , notes = "维保价格" , example = "0.00")
	private BigDecimal maintenancePrice;
	
	/**
	 * 维保方式：维保方式
	*/
	@ApiModelProperty(required = false,value="维保方式" , notes = "维保方式")
	private String maintenanceMethod;
	
	/**
	 * 建议维保方式：建议维保方式
	*/
	@ApiModelProperty(required = false,value="建议维保方式" , notes = "建议维保方式")
	private String suggestMaintenanceMethod;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contacts;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String director;
	
	/**
	 * 维保开始时间：维保开始时间
	*/
	@ApiModelProperty(required = false,value="维保开始时间" , notes = "维保开始时间")
	private Date maintenanceStartDate;
	
	/**
	 * 维保到期时间：维保到期时间
	*/
	@ApiModelProperty(required = false,value="维保到期时间" , notes = "维保到期时间")
	private Date maintenanceEndDate;
	
	/**
	 * 维保备注：维保备注
	*/
	@ApiModelProperty(required = false,value="维保备注" , notes = "维保备注")
	private String maintenanceNotes;
	
	/**
	 * 财务分类：财务分类
	*/
	@ApiModelProperty(required = false,value="财务分类" , notes = "财务分类")
	private String financialCategoryId;
	
	/**
	 * 财务编号：财务编号
	*/
	@ApiModelProperty(required = false,value="财务编号" , notes = "财务编号")
	private String financialCode;
	
	/**
	 * 财务选项：财务选项
	*/
	@ApiModelProperty(required = false,value="财务选项" , notes = "财务选项")
	private String financialOption;
	
	/**
	 * 费用项目：费用项目
	*/
	@ApiModelProperty(required = false,value="费用项目" , notes = "费用项目")
	private String expenseItem;
	
	/**
	 * 资产供应商：资产供应商
	*/
	@ApiModelProperty(required = false,value="资产供应商" , notes = "资产供应商")
	private String supplierId;
	
	/**
	 * 客户信息：客户信息
	*/
	@ApiModelProperty(required = false,value="客户信息" , notes = "客户信息")
	private String customerInfo;
	
	/**
	 * 含税总值：(含税数量>2)
	*/
	@ApiModelProperty(required = false,value="含税总值" , notes = "(含税数量>2)")
	private BigDecimal taxAmountPrice;
	
	/**
	 * 未税总值：(数量>2)
	*/
	@ApiModelProperty(required = false,value="未税总值" , notes = "(数量>2)")
	private BigDecimal totalAmountPrice;
	
	/**
	 * 含税单价：(含税)
	*/
	@ApiModelProperty(required = false,value="含税单价" , notes = "(含税)")
	private BigDecimal purchaseUnitPrice;
	
	/**
	 * 资产原值：(未税)
	*/
	@ApiModelProperty(required = false,value="资产原值" , notes = "(未税)" , example = "1000.00")
	private BigDecimal originalUnitPrice;
	
	/**
	 * 资产净值：(当前)
	*/
	@ApiModelProperty(required = false,value="资产净值" , notes = "(当前)" , example = "500.00")
	private BigDecimal navPrice;
	
	/**
	 * 已用期限：(月)
	*/
	@ApiModelProperty(required = false,value="已用期限" , notes = "(月)")
	private BigDecimal assetUsedServiceLife;
	
	/**
	 * 最后折旧：最后折旧
	*/
	@ApiModelProperty(required = false,value="最后折旧" , notes = "最后折旧")
	private String depreciationId;
	
	/**
	 * 最后折旧时间：最后折旧时间
	*/
	@ApiModelProperty(required = false,value="最后折旧时间" , notes = "最后折旧时间")
	private Date depreciationOperTime;
	
	/**
	 * residuals_rate：residuals_rate
	*/
	@ApiModelProperty(required = false,value="residuals_rate" , notes = "residuals_rate")
	private BigDecimal residualsRate;
	
	/**
	 * 残值：残值
	*/
	@ApiModelProperty(required = false,value="残值" , notes = "残值")
	private BigDecimal residualsPrice;
	
	/**
	 * 税额：税额
	*/
	@ApiModelProperty(required = false,value="税额" , notes = "税额")
	private BigDecimal taxAmountRate;
	
	/**
	 * 本年折旧：本年折旧
	*/
	@ApiModelProperty(required = false,value="本年折旧" , notes = "本年折旧")
	private BigDecimal currentYearDepreciation;
	
	/**
	 * 折旧年份：折旧年份
	*/
	@ApiModelProperty(required = false,value="折旧年份" , notes = "折旧年份")
	private Integer depreciationYear;
	
	/**
	 * 累计折旧：累计折旧
	*/
	@ApiModelProperty(required = false,value="累计折旧" , notes = "累计折旧")
	private BigDecimal accumulatedDepreciation;
	
	/**
	 * 月折金额：月折金额
	*/
	@ApiModelProperty(required = false,value="月折金额" , notes = "月折金额")
	private BigDecimal monthDepreciationPrice;
	
	/**
	 * 登记时间：登记时间
	*/
	@ApiModelProperty(required = false,value="登记时间" , notes = "登记时间")
	private Date entryTime;
	
	/**
	 * 财务备注：财务备注
	*/
	@ApiModelProperty(required = false,value="财务备注" , notes = "财务备注")
	private String financialNotes;
	
	/**
	 * 设备编号：设备编号
	*/
	@ApiModelProperty(required = false,value="设备编号" , notes = "设备编号")
	private String equipmentCode;
	
	/**
	 * 设备状态：设备状态
	*/
	@ApiModelProperty(required = false,value="设备状态" , notes = "设备状态")
	private String equipmentStatus;
	
	/**
	 * 设备IP：设备IP
	*/
	@ApiModelProperty(required = false,value="设备IP" , notes = "设备IP")
	private String equipmentIp;
	
	/**
	 * 管理IP：管理IP
	*/
	@ApiModelProperty(required = false,value="管理IP" , notes = "管理IP")
	private String manageIp;
	
	/**
	 * 设备CPU：设备CPU
	*/
	@ApiModelProperty(required = false,value="设备CPU" , notes = "设备CPU")
	private String equipmentCpu;
	
	/**
	 * 设备内存：设备内存
	*/
	@ApiModelProperty(required = false,value="设备内存" , notes = "设备内存")
	private String equipmentMemory;
	
	/**
	 * 设备标签：设备标签
	*/
	@ApiModelProperty(required = false,value="设备标签" , notes = "设备标签")
	private String equipmentLabel;
	
	/**
	 * 设备配置：设备配置
	*/
	@ApiModelProperty(required = false,value="设备配置" , notes = "设备配置")
	private String equipmentConf;
	
	/**
	 * 设备运行环境：设备运行环境
	*/
	@ApiModelProperty(required = false,value="设备运行环境" , notes = "设备运行环境")
	private String equipmentEnvironmentCode;
	
	/**
	 * 设备序列号：设备序列号
	*/
	@ApiModelProperty(required = false,value="设备序列号" , notes = "设备序列号")
	private String equipmentSerialNumber;
	
	/**
	 * 设备机柜：设备机柜
	*/
	@ApiModelProperty(required = false,value="设备机柜" , notes = "设备机柜")
	private String rackId;
	
	/**
	 * 设备机柜上位置：设备机柜上位置
	*/
	@ApiModelProperty(required = false,value="设备机柜上位置" , notes = "设备机柜上位置")
	private Integer rackUpNumber;
	
	/**
	 * 设备机柜下位置：设备机柜下位置
	*/
	@ApiModelProperty(required = false,value="设备机柜下位置" , notes = "设备机柜下位置")
	private Integer rackDownNumber;
	
	/**
	 * 短标签1：短标签1
	*/
	@ApiModelProperty(required = false,value="短标签1" , notes = "短标签1")
	private String label;
	
	/**
	 * 长标签2：长标签2
	*/
	@ApiModelProperty(required = false,value="长标签2" , notes = "长标签2")
	private String label2;
	
	/**
	 * 短标签3：短标签3
	*/
	@ApiModelProperty(required = false,value="短标签3" , notes = "短标签3")
	private String label3;
	
	/**
	 * 长标签4：长标签4
	*/
	@ApiModelProperty(required = false,value="长标签4" , notes = "长标签4")
	private String label4;
	
	/**
	 * 短标签5：短标签5
	*/
	@ApiModelProperty(required = false,value="短标签5" , notes = "短标签5")
	private String label5;
	
	/**
	 * 单据：单据
	*/
	@ApiModelProperty(required = false,value="单据" , notes = "单据")
	private String billId;
	
	/**
	 * 内部控制标签：内部控制标签
	*/
	@ApiModelProperty(required = false,value="内部控制标签" , notes = "内部控制标签")
	private String internalControlLabel;
	
	/**
	 * 领用ID：领用ID
	*/
	@ApiModelProperty(required = false,value="领用ID" , notes = "领用ID")
	private String collectionId;
	
	/**
	 * 借用ID：借用ID
	*/
	@ApiModelProperty(required = false,value="借用ID" , notes = "借用ID")
	private String borrowId;
	
	/**
	 * 报废ID：报废ID
	*/
	@ApiModelProperty(required = false,value="报废ID" , notes = "报废ID")
	private String scrapId;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "002")
	private String tenantId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String chsType;
	
	/**
	 * 变更状态：变更状态
	*/
	@ApiModelProperty(required = false,value="变更状态" , notes = "变更状态")
	private String chsStatus;
	
	/**
	 * 变更版本号：变更版本号
	*/
	@ApiModelProperty(required = false,value="变更版本号" , notes = "变更版本号")
	private String chsVersion;
	
	/**
	 * 变更ID：变更ID
	*/
	@ApiModelProperty(required = false,value="变更ID" , notes = "变更ID")
	private String changeInstanceId;
	
	/**
	 * 流程概要：流程概要
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "流程概要")
	private String summary;
	
	/**
	 * 最后审批人账户ID：最后审批人账户ID
	*/
	@ApiModelProperty(required = false,value="最后审批人账户ID" , notes = "最后审批人账户ID")
	private String latestApproverId;
	
	/**
	 * 最后审批人姓名：最后审批人姓名
	*/
	@ApiModelProperty(required = false,value="最后审批人姓名" , notes = "最后审批人姓名")
	private String latestApproverName;
	
	/**
	 * 下一节点审批人：下一节点审批人
	*/
	@ApiModelProperty(required = false,value="下一节点审批人" , notes = "下一节点审批人")
	private String nextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开")
	private String nextApproverNames;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String approvalOpinion;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String assetSelectedData;
	
	/**
	 * 扩展数据：扩展数据
	*/
	@ApiModelProperty(required = false,value="扩展数据" , notes = "扩展数据")
	private AssetExtData extData;
	
	/**
	 * PCM数据：PCM数据
	*/
	@ApiModelProperty(required = false,value="PCM数据" , notes = "PCM数据")
	private Map<String,Object> pcmData;
	
	/**
	 * 自定义数据属性字段：自定义数据属性字段
	*/
	@ApiModelProperty(required = false,value="自定义数据属性字段" , notes = "自定义数据属性字段")
	private List<CatalogAttribute> catalogAttribute;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
	/**
	 * 财务分类：财务分类
	*/
	@ApiModelProperty(required = false,value="财务分类" , notes = "财务分类")
	private CategoryFinance categoryFinance;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Catalog category;
	
	/**
	 * 物品档案：物品档案
	*/
	@ApiModelProperty(required = false,value="物品档案" , notes = "物品档案")
	private Goods goods;
	
	/**
	 * 生产厂商：生产厂商
	*/
	@ApiModelProperty(required = false,value="生产厂商" , notes = "生产厂商")
	private Manufacturer manufacturer;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
	/**
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private Employee useUser;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private Employee manager;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 维保商：维保商
	*/
	@ApiModelProperty(required = false,value="维保商" , notes = "维保商")
	private Maintainer maintnainer;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization ownerCompany;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private DictItem source;
	
	/**
	 * 设备运行环境：设备运行环境
	*/
	@ApiModelProperty(required = false,value="设备运行环境" , notes = "设备运行环境")
	private DictItem equipmentEnvironment;
	
	/**
	 * 安全等级：安全等级
	*/
	@ApiModelProperty(required = false,value="安全等级" , notes = "安全等级")
	private DictItem safetyLevel;
	
	/**
	 * 维保状态：维保状态
	*/
	@ApiModelProperty(required = false,value="维保状态" , notes = "维保状态")
	private DictItem assetMaintenanceStatus;
	
	/**
	 * 建议维保方式：建议维保方式
	*/
	@ApiModelProperty(required = false,value="建议维保方式" , notes = "建议维保方式")
	private DictItem suggestMaintenanceMethodData;
	
	/**
	 * 维保方式：维保方式
	*/
	@ApiModelProperty(required = false,value="维保方式" , notes = "维保方式")
	private DictItem maintenanceMethodData;
	
	/**
	 * assetCycleStatus：assetCycleStatus
	*/
	@ApiModelProperty(required = false,value="assetCycleStatus" , notes = "assetCycleStatus")
	private AssetStatus assetCycleStatus;
	
	/**
	 * 机柜：机柜
	*/
	@ApiModelProperty(required = false,value="机柜" , notes = "机柜")
	private AssetRack rack;
	
	/**
	 * 变更实例：变更实例
	*/
	@ApiModelProperty(required = false,value="变更实例" , notes = "变更实例")
	private ChangeInstance changeInstance;
	
	/**
	 * 库存物品：库存物品
	*/
	@ApiModelProperty(required = false,value="库存物品" , notes = "库存物品")
	private GoodsStock goodsStock;
	
	/**
	 * 存放区域：存放区域
	*/
	@ApiModelProperty(required = false,value="存放区域" , notes = "存放区域")
	private AssetRegion region;
	
	/**
	 * 财务选项：财务选项
	*/
	@ApiModelProperty(required = false,value="财务选项" , notes = "财务选项")
	private DictItem financialOptionDict;
	
	/**
	 * 费用项目：费用项目
	*/
	@ApiModelProperty(required = false,value="费用项目" , notes = "费用项目")
	private DictItem expenseItemDict;
	
	/**
	 * assetCollection：assetCollection
	*/
	@ApiModelProperty(required = false,value="assetCollection" , notes = "assetCollection")
	private AssetCollection assetCollection;
	
	/**
	 * assetBorrow：assetBorrow
	*/
	@ApiModelProperty(required = false,value="assetBorrow" , notes = "assetBorrow")
	private AssetBorrow assetBorrow;
	
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
	public Asset setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public Asset setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 分类编码<br>
	 * 分类编码
	 * @return 分类编码
	*/
	public String getCategoryCode() {
		return categoryCode;
	}
	
	/**
	 * 设置 分类编码
	 * @param categoryCode 分类编码
	 * @return 当前对象
	*/
	public Asset setCategoryCode(String categoryCode) {
		this.categoryCode=categoryCode;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public Asset setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public Asset setProcId(String procId) {
		this.procId=procId;
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
	public Asset setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 批次编码<br>
	 * 批次编码
	 * @return 批次编码
	*/
	public String getBatchCode() {
		return batchCode;
	}
	
	/**
	 * 设置 批次编码
	 * @param batchCode 批次编码
	 * @return 当前对象
	*/
	public Asset setBatchCode(String batchCode) {
		this.batchCode=batchCode;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public Asset setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 资产编号<br>
	 * 资产编号
	 * @return 资产编号
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 资产编号
	 * @param assetCode 资产编号
	 * @return 当前对象
	*/
	public Asset setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public String getAssetStatus() {
		return assetStatus;
	}
	
	/**
	 * 设置 资产状态
	 * @param assetStatus 资产状态
	 * @return 当前对象
	*/
	public Asset setAssetStatus(String assetStatus) {
		this.assetStatus=assetStatus;
		return this;
	}
	
	/**
	 * 获得 是否显示<br>
	 * 是否显示
	 * @return 是否显示
	*/
	public String getDisplay() {
		return display;
	}
	
	/**
	 * 设置 是否显示
	 * @param display 是否显示
	 * @return 当前对象
	*/
	public Asset setDisplay(String display) {
		this.display=display;
		return this;
	}
	
	/**
	 * 获得 是否清理<br>
	 * 是否清理
	 * @return 是否清理
	*/
	public String getCleanOut() {
		return cleanOut;
	}
	
	/**
	 * 设置 是否清理
	 * @param cleanOut 是否清理
	 * @return 当前对象
	*/
	public Asset setCleanOut(String cleanOut) {
		this.cleanOut=cleanOut;
		return this;
	}
	
	/**
	 * 获得 标准物品档案<br>
	 * 标准物品档案
	 * @return 标准物品档案
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 标准物品档案
	 * @param goodsId 标准物品档案
	 * @return 当前对象
	*/
	public Asset setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 标准型号资产名称<br>
	 * 标准型号资产名称
	 * @return 标准型号资产名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 标准型号资产名称
	 * @param name 标准型号资产名称
	 * @return 当前对象
	*/
	public Asset setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 标准型号厂商<br>
	 * 标准型号厂商
	 * @return 标准型号厂商
	*/
	public String getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * 设置 标准型号厂商
	 * @param manufacturerId 标准型号厂商
	 * @return 当前对象
	*/
	public Asset setManufacturerId(String manufacturerId) {
		this.manufacturerId=manufacturerId;
		return this;
	}
	
	/**
	 * 获得 标准型号规格型号<br>
	 * 标准型号规格型号
	 * @return 标准型号规格型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 标准型号规格型号
	 * @param model 标准型号规格型号
	 * @return 当前对象
	*/
	public Asset setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 标准型号物品图片<br>
	 * 标准型号物品图片
	 * @return 标准型号物品图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 标准型号物品图片
	 * @param pictureId 标准型号物品图片
	 * @return 当前对象
	*/
	public Asset setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 标准型号计量单位<br>
	 * 标准型号计量单位
	 * @return 标准型号计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 标准型号计量单位
	 * @param unit 标准型号计量单位
	 * @return 当前对象
	*/
	public Asset setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 使用期限<br>
	 * (月)
	 * @return 使用期限
	*/
	public BigDecimal getServiceLife() {
		return serviceLife;
	}
	
	/**
	 * 设置 使用期限
	 * @param serviceLife 使用期限
	 * @return 当前对象
	*/
	public Asset setServiceLife(BigDecimal serviceLife) {
		this.serviceLife=serviceLife;
		return this;
	}
	
	/**
	 * 获得 安全等级<br>
	 * 安全等级
	 * @return 安全等级
	*/
	public String getSafetyLevelCode() {
		return safetyLevelCode;
	}
	
	/**
	 * 设置 安全等级
	 * @param safetyLevelCode 安全等级
	 * @return 当前对象
	*/
	public Asset setSafetyLevelCode(String safetyLevelCode) {
		this.safetyLevelCode=safetyLevelCode;
		return this;
	}
	
	/**
	 * 获得 序列号<br>
	 * 序列号
	 * @return 序列号
	*/
	public String getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * 设置 序列号
	 * @param serialNumber 序列号
	 * @return 当前对象
	*/
	public Asset setSerialNumber(String serialNumber) {
		this.serialNumber=serialNumber;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownCompanyId 所属公司
	 * @return 当前对象
	*/
	public Asset setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 管理人员
	 * @param managerId 管理人员
	 * @return 当前对象
	*/
	public Asset setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganizationId 使用公司/部门
	 * @return 当前对象
	*/
	public Asset setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 使用人员<br>
	 * 使用人员
	 * @return 使用人员
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 使用人员
	 * @param useUserId 使用人员
	 * @return 当前对象
	*/
	public Asset setUseUserId(String useUserId) {
		this.useUserId=useUserId;
		return this;
	}
	
	/**
	 * 获得 存放区域<br>
	 * 存放区域
	 * @return 存放区域
	*/
	public String getRegionId() {
		return regionId;
	}
	
	/**
	 * 设置 存放区域
	 * @param regionId 存放区域
	 * @return 当前对象
	*/
	public Asset setRegionId(String regionId) {
		this.regionId=regionId;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 存放位置
	 * @param positionId 存放位置
	 * @return 当前对象
	*/
	public Asset setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 详细位置<br>
	 * 详细位置
	 * @return 详细位置
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 详细位置
	 * @param positionDetail 详细位置
	 * @return 当前对象
	*/
	public Asset setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public Asset setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
		return this;
	}
	
	/**
	 * 获得 库存物品<br>
	 * 库存物品
	 * @return 库存物品
	*/
	public String getGoodsStockId() {
		return goodsStockId;
	}
	
	/**
	 * 设置 库存物品
	 * @param goodsStockId 库存物品
	 * @return 当前对象
	*/
	public Asset setGoodsStockId(String goodsStockId) {
		this.goodsStockId=goodsStockId;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 来源
	 * @param sourceId 来源
	 * @return 当前对象
	*/
	public Asset setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 资产数量<br>
	 * 资产数量
	 * @return 资产数量
	*/
	public Integer getAssetNumber() {
		return assetNumber;
	}
	
	/**
	 * 设置 资产数量
	 * @param assetNumber 资产数量
	 * @return 当前对象
	*/
	public Asset setAssetNumber(Integer assetNumber) {
		this.assetNumber=assetNumber;
		return this;
	}
	
	/**
	 * 获得 剩余数量<br>
	 * 剩余数量
	 * @return 剩余数量
	*/
	public Integer getRemainNumber() {
		return remainNumber;
	}
	
	/**
	 * 设置 剩余数量
	 * @param remainNumber 剩余数量
	 * @return 当前对象
	*/
	public Asset setRemainNumber(Integer remainNumber) {
		this.remainNumber=remainNumber;
		return this;
	}
	
	/**
	 * 获得 采购日期<br>
	 * 采购日期
	 * @return 采购日期
	*/
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * 设置 采购日期
	 * @param purchaseDate 采购日期
	 * @return 当前对象
	*/
	public Asset setPurchaseDate(Date purchaseDate) {
		this.purchaseDate=purchaseDate;
		return this;
	}
	
	/**
	 * 获得 生产日期<br>
	 * 生产日期
	 * @return 生产日期
	*/
	public Date getProductionDate() {
		return productionDate;
	}
	
	/**
	 * 设置 生产日期
	 * @param productionDate 生产日期
	 * @return 当前对象
	*/
	public Asset setProductionDate(Date productionDate) {
		this.productionDate=productionDate;
		return this;
	}
	
	/**
	 * 获得 入账日期<br>
	 * 入账日期
	 * @return 入账日期
	*/
	public Date getRegisterDate() {
		return registerDate;
	}
	
	/**
	 * 设置 入账日期
	 * @param registerDate 入账日期
	 * @return 当前对象
	*/
	public Asset setRegisterDate(Date registerDate) {
		this.registerDate=registerDate;
		return this;
	}
	
	/**
	 * 获得 RFID标签<br>
	 * RFID标签
	 * @return RFID标签
	*/
	public String getRfid() {
		return rfid;
	}
	
	/**
	 * 设置 RFID标签
	 * @param rfid RFID标签
	 * @return 当前对象
	*/
	public Asset setRfid(String rfid) {
		this.rfid=rfid;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public Asset setAttach(String attach) {
		this.attach=attach;
		return this;
	}
	
	/**
	 * 获得 最近核对日期<br>
	 * 最近核对日期
	 * @return 最近核对日期
	*/
	public Date getLastVerificationDate() {
		return lastVerificationDate;
	}
	
	/**
	 * 设置 最近核对日期
	 * @param lastVerificationDate 最近核对日期
	 * @return 当前对象
	*/
	public Asset setLastVerificationDate(Date lastVerificationDate) {
		this.lastVerificationDate=lastVerificationDate;
		return this;
	}
	
	/**
	 * 获得 用途<br>
	 * 用途
	 * @return 用途
	*/
	public String getPurpose() {
		return purpose;
	}
	
	/**
	 * 设置 用途
	 * @param purpose 用途
	 * @return 当前对象
	*/
	public Asset setPurpose(String purpose) {
		this.purpose=purpose;
		return this;
	}
	
	/**
	 * 获得 资产备注<br>
	 * 资产备注
	 * @return 资产备注
	*/
	public String getAssetNotes() {
		return assetNotes;
	}
	
	/**
	 * 设置 资产备注
	 * @param assetNotes 资产备注
	 * @return 当前对象
	*/
	public Asset setAssetNotes(String assetNotes) {
		this.assetNotes=assetNotes;
		return this;
	}
	
	/**
	 * 获得 维保厂商<br>
	 * 维保厂商
	 * @return 维保厂商
	*/
	public String getMaintainerId() {
		return maintainerId;
	}
	
	/**
	 * 设置 维保厂商
	 * @param maintainerId 维保厂商
	 * @return 当前对象
	*/
	public Asset setMaintainerId(String maintainerId) {
		this.maintainerId=maintainerId;
		return this;
	}
	
	/**
	 * 获得 维保厂商<br>
	 * 维保厂商
	 * @return 维保厂商
	*/
	public String getMaintainerName() {
		return maintainerName;
	}
	
	/**
	 * 设置 维保厂商
	 * @param maintainerName 维保厂商
	 * @return 当前对象
	*/
	public Asset setMaintainerName(String maintainerName) {
		this.maintainerName=maintainerName;
		return this;
	}
	
	/**
	 * 获得 维保状态<br>
	 * 维保状态
	 * @return 维保状态
	*/
	public String getMaintenanceStatus() {
		return maintenanceStatus;
	}
	
	/**
	 * 设置 维保状态
	 * @param maintenanceStatus 维保状态
	 * @return 当前对象
	*/
	public Asset setMaintenanceStatus(String maintenanceStatus) {
		this.maintenanceStatus=maintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 维保价格<br>
	 * 维保价格
	 * @return 维保价格
	*/
	public BigDecimal getMaintenancePrice() {
		return maintenancePrice;
	}
	
	/**
	 * 设置 维保价格
	 * @param maintenancePrice 维保价格
	 * @return 当前对象
	*/
	public Asset setMaintenancePrice(BigDecimal maintenancePrice) {
		this.maintenancePrice=maintenancePrice;
		return this;
	}
	
	/**
	 * 获得 维保方式<br>
	 * 维保方式
	 * @return 维保方式
	*/
	public String getMaintenanceMethod() {
		return maintenanceMethod;
	}
	
	/**
	 * 设置 维保方式
	 * @param maintenanceMethod 维保方式
	 * @return 当前对象
	*/
	public Asset setMaintenanceMethod(String maintenanceMethod) {
		this.maintenanceMethod=maintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 建议维保方式<br>
	 * 建议维保方式
	 * @return 建议维保方式
	*/
	public String getSuggestMaintenanceMethod() {
		return suggestMaintenanceMethod;
	}
	
	/**
	 * 设置 建议维保方式
	 * @param suggestMaintenanceMethod 建议维保方式
	 * @return 当前对象
	*/
	public Asset setSuggestMaintenanceMethod(String suggestMaintenanceMethod) {
		this.suggestMaintenanceMethod=suggestMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContacts() {
		return contacts;
	}
	
	/**
	 * 设置 联系人
	 * @param contacts 联系人
	 * @return 当前对象
	*/
	public Asset setContacts(String contacts) {
		this.contacts=contacts;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInformation 联系方式
	 * @return 当前对象
	*/
	public Asset setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirector() {
		return director;
	}
	
	/**
	 * 设置 负责人
	 * @param director 负责人
	 * @return 当前对象
	*/
	public Asset setDirector(String director) {
		this.director=director;
		return this;
	}
	
	/**
	 * 获得 维保开始时间<br>
	 * 维保开始时间
	 * @return 维保开始时间
	*/
	public Date getMaintenanceStartDate() {
		return maintenanceStartDate;
	}
	
	/**
	 * 设置 维保开始时间
	 * @param maintenanceStartDate 维保开始时间
	 * @return 当前对象
	*/
	public Asset setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate=maintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 维保到期时间<br>
	 * 维保到期时间
	 * @return 维保到期时间
	*/
	public Date getMaintenanceEndDate() {
		return maintenanceEndDate;
	}
	
	/**
	 * 设置 维保到期时间
	 * @param maintenanceEndDate 维保到期时间
	 * @return 当前对象
	*/
	public Asset setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate=maintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 维保备注<br>
	 * 维保备注
	 * @return 维保备注
	*/
	public String getMaintenanceNotes() {
		return maintenanceNotes;
	}
	
	/**
	 * 设置 维保备注
	 * @param maintenanceNotes 维保备注
	 * @return 当前对象
	*/
	public Asset setMaintenanceNotes(String maintenanceNotes) {
		this.maintenanceNotes=maintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 财务分类<br>
	 * 财务分类
	 * @return 财务分类
	*/
	public String getFinancialCategoryId() {
		return financialCategoryId;
	}
	
	/**
	 * 设置 财务分类
	 * @param financialCategoryId 财务分类
	 * @return 当前对象
	*/
	public Asset setFinancialCategoryId(String financialCategoryId) {
		this.financialCategoryId=financialCategoryId;
		return this;
	}
	
	/**
	 * 获得 财务编号<br>
	 * 财务编号
	 * @return 财务编号
	*/
	public String getFinancialCode() {
		return financialCode;
	}
	
	/**
	 * 设置 财务编号
	 * @param financialCode 财务编号
	 * @return 当前对象
	*/
	public Asset setFinancialCode(String financialCode) {
		this.financialCode=financialCode;
		return this;
	}
	
	/**
	 * 获得 财务选项<br>
	 * 财务选项
	 * @return 财务选项
	*/
	public String getFinancialOption() {
		return financialOption;
	}
	
	/**
	 * 设置 财务选项
	 * @param financialOption 财务选项
	 * @return 当前对象
	*/
	public Asset setFinancialOption(String financialOption) {
		this.financialOption=financialOption;
		return this;
	}
	
	/**
	 * 获得 费用项目<br>
	 * 费用项目
	 * @return 费用项目
	*/
	public String getExpenseItem() {
		return expenseItem;
	}
	
	/**
	 * 设置 费用项目
	 * @param expenseItem 费用项目
	 * @return 当前对象
	*/
	public Asset setExpenseItem(String expenseItem) {
		this.expenseItem=expenseItem;
		return this;
	}
	
	/**
	 * 获得 资产供应商<br>
	 * 资产供应商
	 * @return 资产供应商
	*/
	public String getSupplierId() {
		return supplierId;
	}
	
	/**
	 * 设置 资产供应商
	 * @param supplierId 资产供应商
	 * @return 当前对象
	*/
	public Asset setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 客户信息<br>
	 * 客户信息
	 * @return 客户信息
	*/
	public String getCustomerInfo() {
		return customerInfo;
	}
	
	/**
	 * 设置 客户信息
	 * @param customerInfo 客户信息
	 * @return 当前对象
	*/
	public Asset setCustomerInfo(String customerInfo) {
		this.customerInfo=customerInfo;
		return this;
	}
	
	/**
	 * 获得 含税总值<br>
	 * (含税数量>2)
	 * @return 含税总值
	*/
	public BigDecimal getTaxAmountPrice() {
		return taxAmountPrice;
	}
	
	/**
	 * 设置 含税总值
	 * @param taxAmountPrice 含税总值
	 * @return 当前对象
	*/
	public Asset setTaxAmountPrice(BigDecimal taxAmountPrice) {
		this.taxAmountPrice=taxAmountPrice;
		return this;
	}
	
	/**
	 * 获得 未税总值<br>
	 * (数量>2)
	 * @return 未税总值
	*/
	public BigDecimal getTotalAmountPrice() {
		return totalAmountPrice;
	}
	
	/**
	 * 设置 未税总值
	 * @param totalAmountPrice 未税总值
	 * @return 当前对象
	*/
	public Asset setTotalAmountPrice(BigDecimal totalAmountPrice) {
		this.totalAmountPrice=totalAmountPrice;
		return this;
	}
	
	/**
	 * 获得 含税单价<br>
	 * (含税)
	 * @return 含税单价
	*/
	public BigDecimal getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	
	/**
	 * 设置 含税单价
	 * @param purchaseUnitPrice 含税单价
	 * @return 当前对象
	*/
	public Asset setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
		this.purchaseUnitPrice=purchaseUnitPrice;
		return this;
	}
	
	/**
	 * 获得 资产原值<br>
	 * (未税)
	 * @return 资产原值
	*/
	public BigDecimal getOriginalUnitPrice() {
		return originalUnitPrice;
	}
	
	/**
	 * 设置 资产原值
	 * @param originalUnitPrice 资产原值
	 * @return 当前对象
	*/
	public Asset setOriginalUnitPrice(BigDecimal originalUnitPrice) {
		this.originalUnitPrice=originalUnitPrice;
		return this;
	}
	
	/**
	 * 获得 资产净值<br>
	 * (当前)
	 * @return 资产净值
	*/
	public BigDecimal getNavPrice() {
		return navPrice;
	}
	
	/**
	 * 设置 资产净值
	 * @param navPrice 资产净值
	 * @return 当前对象
	*/
	public Asset setNavPrice(BigDecimal navPrice) {
		this.navPrice=navPrice;
		return this;
	}
	
	/**
	 * 获得 已用期限<br>
	 * (月)
	 * @return 已用期限
	*/
	public BigDecimal getAssetUsedServiceLife() {
		return assetUsedServiceLife;
	}
	
	/**
	 * 设置 已用期限
	 * @param assetUsedServiceLife 已用期限
	 * @return 当前对象
	*/
	public Asset setAssetUsedServiceLife(BigDecimal assetUsedServiceLife) {
		this.assetUsedServiceLife=assetUsedServiceLife;
		return this;
	}
	
	/**
	 * 获得 最后折旧<br>
	 * 最后折旧
	 * @return 最后折旧
	*/
	public String getDepreciationId() {
		return depreciationId;
	}
	
	/**
	 * 设置 最后折旧
	 * @param depreciationId 最后折旧
	 * @return 当前对象
	*/
	public Asset setDepreciationId(String depreciationId) {
		this.depreciationId=depreciationId;
		return this;
	}
	
	/**
	 * 获得 最后折旧时间<br>
	 * 最后折旧时间
	 * @return 最后折旧时间
	*/
	public Date getDepreciationOperTime() {
		return depreciationOperTime;
	}
	
	/**
	 * 设置 最后折旧时间
	 * @param depreciationOperTime 最后折旧时间
	 * @return 当前对象
	*/
	public Asset setDepreciationOperTime(Date depreciationOperTime) {
		this.depreciationOperTime=depreciationOperTime;
		return this;
	}
	
	/**
	 * 获得 residuals_rate<br>
	 * residuals_rate
	 * @return residuals_rate
	*/
	public BigDecimal getResidualsRate() {
		return residualsRate;
	}
	
	/**
	 * 设置 residuals_rate
	 * @param residualsRate residuals_rate
	 * @return 当前对象
	*/
	public Asset setResidualsRate(BigDecimal residualsRate) {
		this.residualsRate=residualsRate;
		return this;
	}
	
	/**
	 * 获得 残值<br>
	 * 残值
	 * @return 残值
	*/
	public BigDecimal getResidualsPrice() {
		return residualsPrice;
	}
	
	/**
	 * 设置 残值
	 * @param residualsPrice 残值
	 * @return 当前对象
	*/
	public Asset setResidualsPrice(BigDecimal residualsPrice) {
		this.residualsPrice=residualsPrice;
		return this;
	}
	
	/**
	 * 获得 税额<br>
	 * 税额
	 * @return 税额
	*/
	public BigDecimal getTaxAmountRate() {
		return taxAmountRate;
	}
	
	/**
	 * 设置 税额
	 * @param taxAmountRate 税额
	 * @return 当前对象
	*/
	public Asset setTaxAmountRate(BigDecimal taxAmountRate) {
		this.taxAmountRate=taxAmountRate;
		return this;
	}
	
	/**
	 * 获得 本年折旧<br>
	 * 本年折旧
	 * @return 本年折旧
	*/
	public BigDecimal getCurrentYearDepreciation() {
		return currentYearDepreciation;
	}
	
	/**
	 * 设置 本年折旧
	 * @param currentYearDepreciation 本年折旧
	 * @return 当前对象
	*/
	public Asset setCurrentYearDepreciation(BigDecimal currentYearDepreciation) {
		this.currentYearDepreciation=currentYearDepreciation;
		return this;
	}
	
	/**
	 * 获得 折旧年份<br>
	 * 折旧年份
	 * @return 折旧年份
	*/
	public Integer getDepreciationYear() {
		return depreciationYear;
	}
	
	/**
	 * 设置 折旧年份
	 * @param depreciationYear 折旧年份
	 * @return 当前对象
	*/
	public Asset setDepreciationYear(Integer depreciationYear) {
		this.depreciationYear=depreciationYear;
		return this;
	}
	
	/**
	 * 获得 累计折旧<br>
	 * 累计折旧
	 * @return 累计折旧
	*/
	public BigDecimal getAccumulatedDepreciation() {
		return accumulatedDepreciation;
	}
	
	/**
	 * 设置 累计折旧
	 * @param accumulatedDepreciation 累计折旧
	 * @return 当前对象
	*/
	public Asset setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
		this.accumulatedDepreciation=accumulatedDepreciation;
		return this;
	}
	
	/**
	 * 获得 月折金额<br>
	 * 月折金额
	 * @return 月折金额
	*/
	public BigDecimal getMonthDepreciationPrice() {
		return monthDepreciationPrice;
	}
	
	/**
	 * 设置 月折金额
	 * @param monthDepreciationPrice 月折金额
	 * @return 当前对象
	*/
	public Asset setMonthDepreciationPrice(BigDecimal monthDepreciationPrice) {
		this.monthDepreciationPrice=monthDepreciationPrice;
		return this;
	}
	
	/**
	 * 获得 登记时间<br>
	 * 登记时间
	 * @return 登记时间
	*/
	public Date getEntryTime() {
		return entryTime;
	}
	
	/**
	 * 设置 登记时间
	 * @param entryTime 登记时间
	 * @return 当前对象
	*/
	public Asset setEntryTime(Date entryTime) {
		this.entryTime=entryTime;
		return this;
	}
	
	/**
	 * 获得 财务备注<br>
	 * 财务备注
	 * @return 财务备注
	*/
	public String getFinancialNotes() {
		return financialNotes;
	}
	
	/**
	 * 设置 财务备注
	 * @param financialNotes 财务备注
	 * @return 当前对象
	*/
	public Asset setFinancialNotes(String financialNotes) {
		this.financialNotes=financialNotes;
		return this;
	}
	
	/**
	 * 获得 设备编号<br>
	 * 设备编号
	 * @return 设备编号
	*/
	public String getEquipmentCode() {
		return equipmentCode;
	}
	
	/**
	 * 设置 设备编号
	 * @param equipmentCode 设备编号
	 * @return 当前对象
	*/
	public Asset setEquipmentCode(String equipmentCode) {
		this.equipmentCode=equipmentCode;
		return this;
	}
	
	/**
	 * 获得 设备状态<br>
	 * 设备状态
	 * @return 设备状态
	*/
	public String getEquipmentStatus() {
		return equipmentStatus;
	}
	
	/**
	 * 设置 设备状态
	 * @param equipmentStatus 设备状态
	 * @return 当前对象
	*/
	public Asset setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus=equipmentStatus;
		return this;
	}
	
	/**
	 * 获得 设备IP<br>
	 * 设备IP
	 * @return 设备IP
	*/
	public String getEquipmentIp() {
		return equipmentIp;
	}
	
	/**
	 * 设置 设备IP
	 * @param equipmentIp 设备IP
	 * @return 当前对象
	*/
	public Asset setEquipmentIp(String equipmentIp) {
		this.equipmentIp=equipmentIp;
		return this;
	}
	
	/**
	 * 获得 管理IP<br>
	 * 管理IP
	 * @return 管理IP
	*/
	public String getManageIp() {
		return manageIp;
	}
	
	/**
	 * 设置 管理IP
	 * @param manageIp 管理IP
	 * @return 当前对象
	*/
	public Asset setManageIp(String manageIp) {
		this.manageIp=manageIp;
		return this;
	}
	
	/**
	 * 获得 设备CPU<br>
	 * 设备CPU
	 * @return 设备CPU
	*/
	public String getEquipmentCpu() {
		return equipmentCpu;
	}
	
	/**
	 * 设置 设备CPU
	 * @param equipmentCpu 设备CPU
	 * @return 当前对象
	*/
	public Asset setEquipmentCpu(String equipmentCpu) {
		this.equipmentCpu=equipmentCpu;
		return this;
	}
	
	/**
	 * 获得 设备内存<br>
	 * 设备内存
	 * @return 设备内存
	*/
	public String getEquipmentMemory() {
		return equipmentMemory;
	}
	
	/**
	 * 设置 设备内存
	 * @param equipmentMemory 设备内存
	 * @return 当前对象
	*/
	public Asset setEquipmentMemory(String equipmentMemory) {
		this.equipmentMemory=equipmentMemory;
		return this;
	}
	
	/**
	 * 获得 设备标签<br>
	 * 设备标签
	 * @return 设备标签
	*/
	public String getEquipmentLabel() {
		return equipmentLabel;
	}
	
	/**
	 * 设置 设备标签
	 * @param equipmentLabel 设备标签
	 * @return 当前对象
	*/
	public Asset setEquipmentLabel(String equipmentLabel) {
		this.equipmentLabel=equipmentLabel;
		return this;
	}
	
	/**
	 * 获得 设备配置<br>
	 * 设备配置
	 * @return 设备配置
	*/
	public String getEquipmentConf() {
		return equipmentConf;
	}
	
	/**
	 * 设置 设备配置
	 * @param equipmentConf 设备配置
	 * @return 当前对象
	*/
	public Asset setEquipmentConf(String equipmentConf) {
		this.equipmentConf=equipmentConf;
		return this;
	}
	
	/**
	 * 获得 设备运行环境<br>
	 * 设备运行环境
	 * @return 设备运行环境
	*/
	public String getEquipmentEnvironmentCode() {
		return equipmentEnvironmentCode;
	}
	
	/**
	 * 设置 设备运行环境
	 * @param equipmentEnvironmentCode 设备运行环境
	 * @return 当前对象
	*/
	public Asset setEquipmentEnvironmentCode(String equipmentEnvironmentCode) {
		this.equipmentEnvironmentCode=equipmentEnvironmentCode;
		return this;
	}
	
	/**
	 * 获得 设备序列号<br>
	 * 设备序列号
	 * @return 设备序列号
	*/
	public String getEquipmentSerialNumber() {
		return equipmentSerialNumber;
	}
	
	/**
	 * 设置 设备序列号
	 * @param equipmentSerialNumber 设备序列号
	 * @return 当前对象
	*/
	public Asset setEquipmentSerialNumber(String equipmentSerialNumber) {
		this.equipmentSerialNumber=equipmentSerialNumber;
		return this;
	}
	
	/**
	 * 获得 设备机柜<br>
	 * 设备机柜
	 * @return 设备机柜
	*/
	public String getRackId() {
		return rackId;
	}
	
	/**
	 * 设置 设备机柜
	 * @param rackId 设备机柜
	 * @return 当前对象
	*/
	public Asset setRackId(String rackId) {
		this.rackId=rackId;
		return this;
	}
	
	/**
	 * 获得 设备机柜上位置<br>
	 * 设备机柜上位置
	 * @return 设备机柜上位置
	*/
	public Integer getRackUpNumber() {
		return rackUpNumber;
	}
	
	/**
	 * 设置 设备机柜上位置
	 * @param rackUpNumber 设备机柜上位置
	 * @return 当前对象
	*/
	public Asset setRackUpNumber(Integer rackUpNumber) {
		this.rackUpNumber=rackUpNumber;
		return this;
	}
	
	/**
	 * 获得 设备机柜下位置<br>
	 * 设备机柜下位置
	 * @return 设备机柜下位置
	*/
	public Integer getRackDownNumber() {
		return rackDownNumber;
	}
	
	/**
	 * 设置 设备机柜下位置
	 * @param rackDownNumber 设备机柜下位置
	 * @return 当前对象
	*/
	public Asset setRackDownNumber(Integer rackDownNumber) {
		this.rackDownNumber=rackDownNumber;
		return this;
	}
	
	/**
	 * 获得 短标签1<br>
	 * 短标签1
	 * @return 短标签1
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 短标签1
	 * @param label 短标签1
	 * @return 当前对象
	*/
	public Asset setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 长标签2<br>
	 * 长标签2
	 * @return 长标签2
	*/
	public String getLabel2() {
		return label2;
	}
	
	/**
	 * 设置 长标签2
	 * @param label2 长标签2
	 * @return 当前对象
	*/
	public Asset setLabel2(String label2) {
		this.label2=label2;
		return this;
	}
	
	/**
	 * 获得 短标签3<br>
	 * 短标签3
	 * @return 短标签3
	*/
	public String getLabel3() {
		return label3;
	}
	
	/**
	 * 设置 短标签3
	 * @param label3 短标签3
	 * @return 当前对象
	*/
	public Asset setLabel3(String label3) {
		this.label3=label3;
		return this;
	}
	
	/**
	 * 获得 长标签4<br>
	 * 长标签4
	 * @return 长标签4
	*/
	public String getLabel4() {
		return label4;
	}
	
	/**
	 * 设置 长标签4
	 * @param label4 长标签4
	 * @return 当前对象
	*/
	public Asset setLabel4(String label4) {
		this.label4=label4;
		return this;
	}
	
	/**
	 * 获得 短标签5<br>
	 * 短标签5
	 * @return 短标签5
	*/
	public String getLabel5() {
		return label5;
	}
	
	/**
	 * 设置 短标签5
	 * @param label5 短标签5
	 * @return 当前对象
	*/
	public Asset setLabel5(String label5) {
		this.label5=label5;
		return this;
	}
	
	/**
	 * 获得 单据<br>
	 * 单据
	 * @return 单据
	*/
	public String getBillId() {
		return billId;
	}
	
	/**
	 * 设置 单据
	 * @param billId 单据
	 * @return 当前对象
	*/
	public Asset setBillId(String billId) {
		this.billId=billId;
		return this;
	}
	
	/**
	 * 获得 内部控制标签<br>
	 * 内部控制标签
	 * @return 内部控制标签
	*/
	public String getInternalControlLabel() {
		return internalControlLabel;
	}
	
	/**
	 * 设置 内部控制标签
	 * @param internalControlLabel 内部控制标签
	 * @return 当前对象
	*/
	public Asset setInternalControlLabel(String internalControlLabel) {
		this.internalControlLabel=internalControlLabel;
		return this;
	}
	
	/**
	 * 获得 领用ID<br>
	 * 领用ID
	 * @return 领用ID
	*/
	public String getCollectionId() {
		return collectionId;
	}
	
	/**
	 * 设置 领用ID
	 * @param collectionId 领用ID
	 * @return 当前对象
	*/
	public Asset setCollectionId(String collectionId) {
		this.collectionId=collectionId;
		return this;
	}
	
	/**
	 * 获得 借用ID<br>
	 * 借用ID
	 * @return 借用ID
	*/
	public String getBorrowId() {
		return borrowId;
	}
	
	/**
	 * 设置 借用ID
	 * @param borrowId 借用ID
	 * @return 当前对象
	*/
	public Asset setBorrowId(String borrowId) {
		this.borrowId=borrowId;
		return this;
	}
	
	/**
	 * 获得 报废ID<br>
	 * 报废ID
	 * @return 报废ID
	*/
	public String getScrapId() {
		return scrapId;
	}
	
	/**
	 * 设置 报废ID
	 * @param scrapId 报废ID
	 * @return 当前对象
	*/
	public Asset setScrapId(String scrapId) {
		this.scrapId=scrapId;
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
	public Asset setCreateBy(String createBy) {
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
	public Asset setCreateTime(Date createTime) {
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
	public Asset setUpdateBy(String updateBy) {
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
	public Asset setUpdateTime(Date updateTime) {
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
	public Asset setDeleted(Integer deleted) {
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
	public Asset setDeleted(Boolean deletedBool) {
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
	public Asset setDeleteBy(String deleteBy) {
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
	public Asset setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public Asset setVersion(Integer version) {
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
	public Asset setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public Asset setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getChsType() {
		return chsType;
	}
	
	/**
	 * 设置 变更类型
	 * @param chsType 变更类型
	 * @return 当前对象
	*/
	public Asset setChsType(String chsType) {
		this.chsType=chsType;
		return this;
	}
	
	/**
	 * 获得 变更状态<br>
	 * 变更状态
	 * @return 变更状态
	*/
	public String getChsStatus() {
		return chsStatus;
	}
	
	/**
	 * 设置 变更状态
	 * @param chsStatus 变更状态
	 * @return 当前对象
	*/
	public Asset setChsStatus(String chsStatus) {
		this.chsStatus=chsStatus;
		return this;
	}
	
	/**
	 * 获得 变更版本号<br>
	 * 变更版本号
	 * @return 变更版本号
	*/
	public String getChsVersion() {
		return chsVersion;
	}
	
	/**
	 * 设置 变更版本号
	 * @param chsVersion 变更版本号
	 * @return 当前对象
	*/
	public Asset setChsVersion(String chsVersion) {
		this.chsVersion=chsVersion;
		return this;
	}
	
	/**
	 * 获得 变更ID<br>
	 * 变更ID
	 * @return 变更ID
	*/
	public String getChangeInstanceId() {
		return changeInstanceId;
	}
	
	/**
	 * 设置 变更ID
	 * @param changeInstanceId 变更ID
	 * @return 当前对象
	*/
	public Asset setChangeInstanceId(String changeInstanceId) {
		this.changeInstanceId=changeInstanceId;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 流程概要
	 * @return 流程概要
	*/
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 设置 流程概要
	 * @param summary 流程概要
	 * @return 当前对象
	*/
	public Asset setSummary(String summary) {
		this.summary=summary;
		return this;
	}
	
	/**
	 * 获得 最后审批人账户ID<br>
	 * 最后审批人账户ID
	 * @return 最后审批人账户ID
	*/
	public String getLatestApproverId() {
		return latestApproverId;
	}
	
	/**
	 * 设置 最后审批人账户ID
	 * @param latestApproverId 最后审批人账户ID
	 * @return 当前对象
	*/
	public Asset setLatestApproverId(String latestApproverId) {
		this.latestApproverId=latestApproverId;
		return this;
	}
	
	/**
	 * 获得 最后审批人姓名<br>
	 * 最后审批人姓名
	 * @return 最后审批人姓名
	*/
	public String getLatestApproverName() {
		return latestApproverName;
	}
	
	/**
	 * 设置 最后审批人姓名
	 * @param latestApproverName 最后审批人姓名
	 * @return 当前对象
	*/
	public Asset setLatestApproverName(String latestApproverName) {
		this.latestApproverName=latestApproverName;
		return this;
	}
	
	/**
	 * 获得 下一节点审批人<br>
	 * 下一节点审批人
	 * @return 下一节点审批人
	*/
	public String getNextApproverIds() {
		return nextApproverIds;
	}
	
	/**
	 * 设置 下一节点审批人
	 * @param nextApproverIds 下一节点审批人
	 * @return 当前对象
	*/
	public Asset setNextApproverIds(String nextApproverIds) {
		this.nextApproverIds=nextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人姓名
	*/
	public String getNextApproverNames() {
		return nextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param nextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public Asset setNextApproverNames(String nextApproverNames) {
		this.nextApproverNames=nextApproverNames;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getApprovalOpinion() {
		return approvalOpinion;
	}
	
	/**
	 * 设置 审批意见
	 * @param approvalOpinion 审批意见
	 * @return 当前对象
	*/
	public Asset setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getAssetSelectedData() {
		return assetSelectedData;
	}
	
	/**
	 * 设置 选择
	 * @param assetSelectedData 选择
	 * @return 当前对象
	*/
	public Asset setAssetSelectedData(String assetSelectedData) {
		this.assetSelectedData=assetSelectedData;
		return this;
	}
	
	/**
	 * 获得 扩展数据<br>
	 * 扩展数据
	 * @return 扩展数据
	*/
	public AssetExtData getExtData() {
		return extData;
	}
	
	/**
	 * 设置 扩展数据
	 * @param extData 扩展数据
	 * @return 当前对象
	*/
	public Asset setExtData(AssetExtData extData) {
		this.extData=extData;
		return this;
	}
	
	/**
	 * 获得 PCM数据<br>
	 * PCM数据
	 * @return PCM数据
	*/
	public Map<String,Object> getPcmData() {
		return pcmData;
	}
	
	/**
	 * 设置 PCM数据
	 * @param pcmData PCM数据
	 * @return 当前对象
	*/
	public Asset setPcmData(Map<String,Object> pcmData) {
		this.pcmData=pcmData;
		return this;
	}
	
	/**
	 * 添加 PCM数据
	 * @param key 键
	 * @param pcmData PCM数据
	 * @return 当前对象
	*/
	public Asset putPcmData(String key,Object pcmData) {
		if(this.pcmData==null) this.pcmData=new HashMap<>();
		this.pcmData.put(key ,pcmData);
		return this;
	}
	
	/**
	 * 获得 自定义数据属性字段<br>
	 * 自定义数据属性字段
	 * @return 自定义数据属性字段
	*/
	public List<CatalogAttribute> getCatalogAttribute() {
		return catalogAttribute;
	}
	
	/**
	 * 设置 自定义数据属性字段
	 * @param catalogAttribute 自定义数据属性字段
	 * @return 当前对象
	*/
	public Asset setCatalogAttribute(List<CatalogAttribute> catalogAttribute) {
		this.catalogAttribute=catalogAttribute;
		return this;
	}
	
	/**
	 * 添加 自定义数据属性字段
	 * @param entity 自定义数据属性字段
	 * @return 当前对象
	*/
	public Asset addCatalogAttribute(CatalogAttribute... entity) {
		if(this.catalogAttribute==null) catalogAttribute=new ArrayList<>();
		this.catalogAttribute.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public Asset setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 财务分类<br>
	 * 财务分类
	 * @return 财务分类
	*/
	public CategoryFinance getCategoryFinance() {
		return categoryFinance;
	}
	
	/**
	 * 设置 财务分类
	 * @param categoryFinance 财务分类
	 * @return 当前对象
	*/
	public Asset setCategoryFinance(CategoryFinance categoryFinance) {
		this.categoryFinance=categoryFinance;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Catalog getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public Asset setCategory(Catalog category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 物品档案<br>
	 * 物品档案
	 * @return 物品档案
	*/
	public Goods getGoods() {
		return goods;
	}
	
	/**
	 * 设置 物品档案
	 * @param goods 物品档案
	 * @return 当前对象
	*/
	public Asset setGoods(Goods goods) {
		this.goods=goods;
		return this;
	}
	
	/**
	 * 获得 生产厂商<br>
	 * 生产厂商
	 * @return 生产厂商
	*/
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * 设置 生产厂商
	 * @param manufacturer 生产厂商
	 * @return 当前对象
	*/
	public Asset setManufacturer(Manufacturer manufacturer) {
		this.manufacturer=manufacturer;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public Asset setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
		return this;
	}
	
	/**
	 * 获得 使用人员<br>
	 * 使用人员
	 * @return 使用人员
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人员
	 * @param useUser 使用人员
	 * @return 当前对象
	*/
	public Asset setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人员
	 * @param manager 管理人员
	 * @return 当前对象
	*/
	public Asset setManager(Employee manager) {
		this.manager=manager;
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
	public Asset setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * 设置 供应商
	 * @param supplier 供应商
	 * @return 当前对象
	*/
	public Asset setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 维保商<br>
	 * 维保商
	 * @return 维保商
	*/
	public Maintainer getMaintnainer() {
		return maintnainer;
	}
	
	/**
	 * 设置 维保商
	 * @param maintnainer 维保商
	 * @return 当前对象
	*/
	public Asset setMaintnainer(Maintainer maintnainer) {
		this.maintnainer=maintnainer;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Organization getOwnerCompany() {
		return ownerCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownerCompany 所属公司
	 * @return 当前对象
	*/
	public Asset setOwnerCompany(Organization ownerCompany) {
		this.ownerCompany=ownerCompany;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganization 使用公司/部门
	 * @return 当前对象
	*/
	public Asset setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public DictItem getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public Asset setSource(DictItem source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 设备运行环境<br>
	 * 设备运行环境
	 * @return 设备运行环境
	*/
	public DictItem getEquipmentEnvironment() {
		return equipmentEnvironment;
	}
	
	/**
	 * 设置 设备运行环境
	 * @param equipmentEnvironment 设备运行环境
	 * @return 当前对象
	*/
	public Asset setEquipmentEnvironment(DictItem equipmentEnvironment) {
		this.equipmentEnvironment=equipmentEnvironment;
		return this;
	}
	
	/**
	 * 获得 安全等级<br>
	 * 安全等级
	 * @return 安全等级
	*/
	public DictItem getSafetyLevel() {
		return safetyLevel;
	}
	
	/**
	 * 设置 安全等级
	 * @param safetyLevel 安全等级
	 * @return 当前对象
	*/
	public Asset setSafetyLevel(DictItem safetyLevel) {
		this.safetyLevel=safetyLevel;
		return this;
	}
	
	/**
	 * 获得 维保状态<br>
	 * 维保状态
	 * @return 维保状态
	*/
	public DictItem getAssetMaintenanceStatus() {
		return assetMaintenanceStatus;
	}
	
	/**
	 * 设置 维保状态
	 * @param assetMaintenanceStatus 维保状态
	 * @return 当前对象
	*/
	public Asset setAssetMaintenanceStatus(DictItem assetMaintenanceStatus) {
		this.assetMaintenanceStatus=assetMaintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 建议维保方式<br>
	 * 建议维保方式
	 * @return 建议维保方式
	*/
	public DictItem getSuggestMaintenanceMethodData() {
		return suggestMaintenanceMethodData;
	}
	
	/**
	 * 设置 建议维保方式
	 * @param suggestMaintenanceMethodData 建议维保方式
	 * @return 当前对象
	*/
	public Asset setSuggestMaintenanceMethodData(DictItem suggestMaintenanceMethodData) {
		this.suggestMaintenanceMethodData=suggestMaintenanceMethodData;
		return this;
	}
	
	/**
	 * 获得 维保方式<br>
	 * 维保方式
	 * @return 维保方式
	*/
	public DictItem getMaintenanceMethodData() {
		return maintenanceMethodData;
	}
	
	/**
	 * 设置 维保方式
	 * @param maintenanceMethodData 维保方式
	 * @return 当前对象
	*/
	public Asset setMaintenanceMethodData(DictItem maintenanceMethodData) {
		this.maintenanceMethodData=maintenanceMethodData;
		return this;
	}
	
	/**
	 * 获得 assetCycleStatus<br>
	 * assetCycleStatus
	 * @return assetCycleStatus
	*/
	public AssetStatus getAssetCycleStatus() {
		return assetCycleStatus;
	}
	
	/**
	 * 设置 assetCycleStatus
	 * @param assetCycleStatus assetCycleStatus
	 * @return 当前对象
	*/
	public Asset setAssetCycleStatus(AssetStatus assetCycleStatus) {
		this.assetCycleStatus=assetCycleStatus;
		return this;
	}
	
	/**
	 * 获得 机柜<br>
	 * 机柜
	 * @return 机柜
	*/
	public AssetRack getRack() {
		return rack;
	}
	
	/**
	 * 设置 机柜
	 * @param rack 机柜
	 * @return 当前对象
	*/
	public Asset setRack(AssetRack rack) {
		this.rack=rack;
		return this;
	}
	
	/**
	 * 获得 变更实例<br>
	 * 变更实例
	 * @return 变更实例
	*/
	public ChangeInstance getChangeInstance() {
		return changeInstance;
	}
	
	/**
	 * 设置 变更实例
	 * @param changeInstance 变更实例
	 * @return 当前对象
	*/
	public Asset setChangeInstance(ChangeInstance changeInstance) {
		this.changeInstance=changeInstance;
		return this;
	}
	
	/**
	 * 获得 库存物品<br>
	 * 库存物品
	 * @return 库存物品
	*/
	public GoodsStock getGoodsStock() {
		return goodsStock;
	}
	
	/**
	 * 设置 库存物品
	 * @param goodsStock 库存物品
	 * @return 当前对象
	*/
	public Asset setGoodsStock(GoodsStock goodsStock) {
		this.goodsStock=goodsStock;
		return this;
	}
	
	/**
	 * 获得 存放区域<br>
	 * 存放区域
	 * @return 存放区域
	*/
	public AssetRegion getRegion() {
		return region;
	}
	
	/**
	 * 设置 存放区域
	 * @param region 存放区域
	 * @return 当前对象
	*/
	public Asset setRegion(AssetRegion region) {
		this.region=region;
		return this;
	}
	
	/**
	 * 获得 财务选项<br>
	 * 财务选项
	 * @return 财务选项
	*/
	public DictItem getFinancialOptionDict() {
		return financialOptionDict;
	}
	
	/**
	 * 设置 财务选项
	 * @param financialOptionDict 财务选项
	 * @return 当前对象
	*/
	public Asset setFinancialOptionDict(DictItem financialOptionDict) {
		this.financialOptionDict=financialOptionDict;
		return this;
	}
	
	/**
	 * 获得 费用项目<br>
	 * 费用项目
	 * @return 费用项目
	*/
	public DictItem getExpenseItemDict() {
		return expenseItemDict;
	}
	
	/**
	 * 设置 费用项目
	 * @param expenseItemDict 费用项目
	 * @return 当前对象
	*/
	public Asset setExpenseItemDict(DictItem expenseItemDict) {
		this.expenseItemDict=expenseItemDict;
		return this;
	}
	
	/**
	 * 获得 assetCollection<br>
	 * assetCollection
	 * @return assetCollection
	*/
	public AssetCollection getAssetCollection() {
		return assetCollection;
	}
	
	/**
	 * 设置 assetCollection
	 * @param assetCollection assetCollection
	 * @return 当前对象
	*/
	public Asset setAssetCollection(AssetCollection assetCollection) {
		this.assetCollection=assetCollection;
		return this;
	}
	
	/**
	 * 获得 assetBorrow<br>
	 * assetBorrow
	 * @return assetBorrow
	*/
	public AssetBorrow getAssetBorrow() {
		return assetBorrow;
	}
	
	/**
	 * 设置 assetBorrow
	 * @param assetBorrow assetBorrow
	 * @return 当前对象
	*/
	public Asset setAssetBorrow(AssetBorrow assetBorrow) {
		this.assetBorrow=assetBorrow;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Asset , 转换好的 Asset 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Asset , 转换好的 PoJo 对象
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
	public Asset clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Asset duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMeta.$$proxy$$();
		inst.setEquipmentCode(this.getEquipmentCode());
		inst.setCustomerInfo(this.getCustomerInfo());
		inst.setPurchaseUnitPrice(this.getPurchaseUnitPrice());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setNavPrice(this.getNavPrice());
		inst.setLabel4(this.getLabel4());
		inst.setLabel5(this.getLabel5());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setScrapId(this.getScrapId());
		inst.setEquipmentEnvironmentCode(this.getEquipmentEnvironmentCode());
		inst.setDirector(this.getDirector());
		inst.setMonthDepreciationPrice(this.getMonthDepreciationPrice());
		inst.setVersion(this.getVersion());
		inst.setSafetyLevelCode(this.getSafetyLevelCode());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setEntryTime(this.getEntryTime());
		inst.setManageIp(this.getManageIp());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFinancialNotes(this.getFinancialNotes());
		inst.setMaintenanceMethod(this.getMaintenanceMethod());
		inst.setFinancialOption(this.getFinancialOption());
		inst.setStatus(this.getStatus());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setRemainNumber(this.getRemainNumber());
		inst.setGoodsId(this.getGoodsId());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setEquipmentConf(this.getEquipmentConf());
		inst.setAssetNotes(this.getAssetNotes());
		inst.setOriginalUnitPrice(this.getOriginalUnitPrice());
		inst.setDepreciationId(this.getDepreciationId());
		inst.setPictureId(this.getPictureId());
		inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
		inst.setTotalAmountPrice(this.getTotalAmountPrice());
		inst.setServiceLife(this.getServiceLife());
		inst.setAttach(this.getAttach());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setCleanOut(this.getCleanOut());
		inst.setRackId(this.getRackId());
		inst.setDisplay(this.getDisplay());
		inst.setManufacturerId(this.getManufacturerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCategoryCode(this.getCategoryCode());
		inst.setManagerId(this.getManagerId());
		inst.setAccumulatedDepreciation(this.getAccumulatedDepreciation());
		inst.setLabel2(this.getLabel2());
		inst.setLabel3(this.getLabel3());
		inst.setAssetSelectedData(this.getAssetSelectedData());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setRfid(this.getRfid());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setLastVerificationDate(this.getLastVerificationDate());
		inst.setUseUserId(this.getUseUserId());
		inst.setContacts(this.getContacts());
		inst.setSourceId(this.getSourceId());
		inst.setProcId(this.getProcId());
		inst.setFinancialCategoryId(this.getFinancialCategoryId());
		inst.setMaintenancePrice(this.getMaintenancePrice());
		inst.setEquipmentIp(this.getEquipmentIp());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setDepreciationOperTime(this.getDepreciationOperTime());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setAssetCode(this.getAssetCode());
		inst.setSerialNumber(this.getSerialNumber());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setGoodsStockId(this.getGoodsStockId());
		inst.setTaxAmountRate(this.getTaxAmountRate());
		inst.setCurrentYearDepreciation(this.getCurrentYearDepreciation());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setEquipmentLabel(this.getEquipmentLabel());
		inst.setUnit(this.getUnit());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setBillId(this.getBillId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFinancialCode(this.getFinancialCode());
		inst.setRackUpNumber(this.getRackUpNumber());
		inst.setResidualsRate(this.getResidualsRate());
		inst.setAssetStatus(this.getAssetStatus());
		inst.setExpenseItem(this.getExpenseItem());
		inst.setChsVersion(this.getChsVersion());
		inst.setSupplierId(this.getSupplierId());
		inst.setPurpose(this.getPurpose());
		inst.setResidualsPrice(this.getResidualsPrice());
		inst.setInternalControlLabel(this.getInternalControlLabel());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setAssetUsedServiceLife(this.getAssetUsedServiceLife());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setChsStatus(this.getChsStatus());
		inst.setProductionDate(this.getProductionDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setCollectionId(this.getCollectionId());
		inst.setRegisterDate(this.getRegisterDate());
		inst.setSummary(this.getSummary());
		inst.setEquipmentSerialNumber(this.getEquipmentSerialNumber());
		inst.setBatchCode(this.getBatchCode());
		inst.setEquipmentCpu(this.getEquipmentCpu());
		inst.setEquipmentMemory(this.getEquipmentMemory());
		inst.setLabel(this.getLabel());
		inst.setEquipmentStatus(this.getEquipmentStatus());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setDepreciationYear(this.getDepreciationYear());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setTaxAmountPrice(this.getTaxAmountPrice());
		inst.setRegionId(this.getRegionId());
		inst.setChsType(this.getChsType());
		inst.setRackDownNumber(this.getRackDownNumber());
		inst.setBorrowId(this.getBorrowId());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
			inst.setSafetyLevel(this.getSafetyLevel());
			inst.setCategoryFinance(this.getCategoryFinance());
			inst.setGoods(this.getGoods());
			inst.setOriginator(this.getOriginator());
			inst.setSource(this.getSource());
			inst.setFinancialOptionDict(this.getFinancialOptionDict());
			inst.setManufacturer(this.getManufacturer());
			inst.setCatalogAttribute(this.getCatalogAttribute());
			inst.setExpenseItemDict(this.getExpenseItemDict());
			inst.setSupplier(this.getSupplier());
			inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
			inst.setUseUser(this.getUseUser());
			inst.setEquipmentEnvironment(this.getEquipmentEnvironment());
			inst.setAssetCycleStatus(this.getAssetCycleStatus());
			inst.setRack(this.getRack());
			inst.setManager(this.getManager());
			inst.setWarehouse(this.getWarehouse());
			inst.setPcmData(this.getPcmData());
			inst.setGoodsStock(this.getGoodsStock());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setAssetCollection(this.getAssetCollection());
			inst.setChangeInstance(this.getChangeInstance());
			inst.setExtData(this.getExtData());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setPosition(this.getPosition());
			inst.setAssetBorrow(this.getAssetBorrow());
			inst.setCategory(this.getCategory());
			inst.setRegion(this.getRegion());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Asset clone(boolean deep) {
		return EntityContext.clone(Asset.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Asset
	 * @param assetMap 包含实体信息的 Map 对象
	 * @return Asset , 转换好的的 Asset 对象
	*/
	@Transient
	public static Asset createFrom(Map<String,Object> assetMap) {
		if(assetMap==null) return null;
		Asset po = create();
		EntityContext.copyProperties(po,assetMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Asset
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Asset , 转换好的的 Asset 对象
	*/
	@Transient
	public static Asset createFrom(Object pojo) {
		if(pojo==null) return null;
		Asset po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Asset，等同于 new
	 * @return Asset 对象
	*/
	@Transient
	public static Asset create() {
		return new com.dt.platform.domain.eam.meta.AssetMeta.$$proxy$$();
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
			this.setEquipmentCode(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_CODE)));
			this.setCustomerInfo(DataParser.parse(String.class, map.get(AssetMeta.CUSTOMER_INFO)));
			this.setPurchaseUnitPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.PURCHASE_UNIT_PRICE)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetMeta.APPROVAL_OPINION)));
			this.setMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMeta.MAINTENANCE_STATUS)));
			this.setNavPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.NAV_PRICE)));
			this.setLabel4(DataParser.parse(String.class, map.get(AssetMeta.LABEL4)));
			this.setLabel5(DataParser.parse(String.class, map.get(AssetMeta.LABEL5)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetMeta.BUSINESS_CODE)));
			this.setAssetNumber(DataParser.parse(Integer.class, map.get(AssetMeta.ASSET_NUMBER)));
			this.setModel(DataParser.parse(String.class, map.get(AssetMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(AssetMeta.ID)));
			this.setScrapId(DataParser.parse(String.class, map.get(AssetMeta.SCRAP_ID)));
			this.setEquipmentEnvironmentCode(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE)));
			this.setDirector(DataParser.parse(String.class, map.get(AssetMeta.DIRECTOR)));
			this.setMonthDepreciationPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.MONTH_DEPRECIATION_PRICE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMeta.VERSION)));
			this.setSafetyLevelCode(DataParser.parse(String.class, map.get(AssetMeta.SAFETY_LEVEL_CODE)));
			this.setMaintainerId(DataParser.parse(String.class, map.get(AssetMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMeta.MAINTENANCE_NOTES)));
			this.setEntryTime(DataParser.parse(Date.class, map.get(AssetMeta.ENTRY_TIME)));
			this.setManageIp(DataParser.parse(String.class, map.get(AssetMeta.MANAGE_IP)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMeta.DELETE_TIME)));
			this.setFinancialNotes(DataParser.parse(String.class, map.get(AssetMeta.FINANCIAL_NOTES)));
			this.setMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMeta.MAINTENANCE_METHOD)));
			this.setFinancialOption(DataParser.parse(String.class, map.get(AssetMeta.FINANCIAL_OPTION)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetMeta.STATUS)));
			this.setPurchaseDate(DataParser.parse(Date.class, map.get(AssetMeta.PURCHASE_DATE)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetMeta.OWNER_CODE)));
			this.setRemainNumber(DataParser.parse(Integer.class, map.get(AssetMeta.REMAIN_NUMBER)));
			this.setGoodsId(DataParser.parse(String.class, map.get(AssetMeta.GOODS_ID)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetMeta.CHANGE_INSTANCE_ID)));
			this.setEquipmentConf(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_CONF)));
			this.setAssetNotes(DataParser.parse(String.class, map.get(AssetMeta.ASSET_NOTES)));
			this.setOriginalUnitPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.ORIGINAL_UNIT_PRICE)));
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetMeta.DEPRECIATION_ID)));
			this.setPictureId(DataParser.parse(String.class, map.get(AssetMeta.PICTURE_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setTotalAmountPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.TOTAL_AMOUNT_PRICE)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, map.get(AssetMeta.SERVICE_LIFE)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetMeta.ATTACH)));
			this.setMaintainerName(DataParser.parse(String.class, map.get(AssetMeta.MAINTAINER_NAME)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetMeta.ORIGINATOR_ID)));
			this.setCleanOut(DataParser.parse(String.class, map.get(AssetMeta.CLEAN_OUT)));
			this.setRackId(DataParser.parse(String.class, map.get(AssetMeta.RACK_ID)));
			this.setDisplay(DataParser.parse(String.class, map.get(AssetMeta.DISPLAY)));
			this.setManufacturerId(DataParser.parse(String.class, map.get(AssetMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, map.get(AssetMeta.CATEGORY_CODE)));
			this.setManagerId(DataParser.parse(String.class, map.get(AssetMeta.MANAGER_ID)));
			this.setAccumulatedDepreciation(DataParser.parse(BigDecimal.class, map.get(AssetMeta.ACCUMULATED_DEPRECIATION)));
			this.setLabel2(DataParser.parse(String.class, map.get(AssetMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, map.get(AssetMeta.LABEL3)));
			this.setAssetSelectedData(DataParser.parse(String.class, map.get(AssetMeta.ASSET_SELECTED_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(AssetMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMeta.TENANT_ID)));
			this.setRfid(DataParser.parse(String.class, map.get(AssetMeta.RFID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, map.get(AssetMeta.MAINTENANCE_START_DATE)));
			this.setLastVerificationDate(DataParser.parse(Date.class, map.get(AssetMeta.LAST_VERIFICATION_DATE)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetMeta.USE_USER_ID)));
			this.setContacts(DataParser.parse(String.class, map.get(AssetMeta.CONTACTS)));
			this.setSourceId(DataParser.parse(String.class, map.get(AssetMeta.SOURCE_ID)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetMeta.PROC_ID)));
			this.setFinancialCategoryId(DataParser.parse(String.class, map.get(AssetMeta.FINANCIAL_CATEGORY_ID)));
			this.setMaintenancePrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.MAINTENANCE_PRICE)));
			this.setEquipmentIp(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_IP)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, map.get(AssetMeta.MAINTENANCE_END_DATE)));
			this.setDepreciationOperTime(DataParser.parse(Date.class, map.get(AssetMeta.DEPRECIATION_OPER_TIME)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetMeta.NEXT_APPROVER_NAMES)));
			this.setAssetCode(DataParser.parse(String.class, map.get(AssetMeta.ASSET_CODE)));
			this.setSerialNumber(DataParser.parse(String.class, map.get(AssetMeta.SERIAL_NUMBER)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetMeta.LATEST_APPROVER_ID)));
			this.setGoodsStockId(DataParser.parse(String.class, map.get(AssetMeta.GOODS_STOCK_ID)));
			this.setTaxAmountRate(DataParser.parse(BigDecimal.class, map.get(AssetMeta.TAX_AMOUNT_RATE)));
			this.setCurrentYearDepreciation(DataParser.parse(BigDecimal.class, map.get(AssetMeta.CURRENT_YEAR_DEPRECIATION)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetMeta.USE_ORGANIZATION_ID)));
			this.setEquipmentLabel(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_LABEL)));
			this.setUnit(DataParser.parse(String.class, map.get(AssetMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetMeta.OWN_COMPANY_ID)));
			this.setBillId(DataParser.parse(String.class, map.get(AssetMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, map.get(AssetMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMeta.DELETE_BY)));
			this.setFinancialCode(DataParser.parse(String.class, map.get(AssetMeta.FINANCIAL_CODE)));
			this.setRackUpNumber(DataParser.parse(Integer.class, map.get(AssetMeta.RACK_UP_NUMBER)));
			this.setResidualsRate(DataParser.parse(BigDecimal.class, map.get(AssetMeta.RESIDUALS_RATE)));
			this.setAssetStatus(DataParser.parse(String.class, map.get(AssetMeta.ASSET_STATUS)));
			this.setExpenseItem(DataParser.parse(String.class, map.get(AssetMeta.EXPENSE_ITEM)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, map.get(AssetMeta.SUPPLIER_ID)));
			this.setPurpose(DataParser.parse(String.class, map.get(AssetMeta.PURPOSE)));
			this.setResidualsPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.RESIDUALS_PRICE)));
			this.setInternalControlLabel(DataParser.parse(String.class, map.get(AssetMeta.INTERNAL_CONTROL_LABEL)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetMeta.LATEST_APPROVER_NAME)));
			this.setAssetUsedServiceLife(DataParser.parse(BigDecimal.class, map.get(AssetMeta.ASSET_USED_SERVICE_LIFE)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetMeta.NEXT_APPROVER_IDS)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetMeta.CHS_STATUS)));
			this.setProductionDate(DataParser.parse(Date.class, map.get(AssetMeta.PRODUCTION_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMeta.UPDATE_BY)));
			this.setCollectionId(DataParser.parse(String.class, map.get(AssetMeta.COLLECTION_ID)));
			this.setRegisterDate(DataParser.parse(Date.class, map.get(AssetMeta.REGISTER_DATE)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetMeta.SUMMARY)));
			this.setEquipmentSerialNumber(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_SERIAL_NUMBER)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AssetMeta.BATCH_CODE)));
			this.setEquipmentCpu(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_CPU)));
			this.setEquipmentMemory(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_MEMORY)));
			this.setLabel(DataParser.parse(String.class, map.get(AssetMeta.LABEL)));
			this.setEquipmentStatus(DataParser.parse(String.class, map.get(AssetMeta.EQUIPMENT_STATUS)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetMeta.POSITION_DETAIL)));
			this.setDepreciationYear(DataParser.parse(Integer.class, map.get(AssetMeta.DEPRECIATION_YEAR)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(AssetMeta.CONTACT_INFORMATION)));
			this.setTaxAmountPrice(DataParser.parse(BigDecimal.class, map.get(AssetMeta.TAX_AMOUNT_PRICE)));
			this.setRegionId(DataParser.parse(String.class, map.get(AssetMeta.REGION_ID)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetMeta.CHS_TYPE)));
			this.setRackDownNumber(DataParser.parse(Integer.class, map.get(AssetMeta.RACK_DOWN_NUMBER)));
			this.setBorrowId(DataParser.parse(String.class, map.get(AssetMeta.BORROW_ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(AssetMeta.CATEGORY_ID)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetMeta.OWNER_COMPANY)));
			this.setSuggestMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMeta.SUGGEST_MAINTENANCE_METHOD_DATA)));
			this.setSafetyLevel(DataParser.parse(DictItem.class, map.get(AssetMeta.SAFETY_LEVEL)));
			this.setCategoryFinance(DataParser.parse(CategoryFinance.class, map.get(AssetMeta.CATEGORY_FINANCE)));
			this.setGoods(DataParser.parse(Goods.class, map.get(AssetMeta.GOODS)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetMeta.ORIGINATOR)));
			this.setSource(DataParser.parse(DictItem.class, map.get(AssetMeta.SOURCE)));
			this.setFinancialOptionDict(DataParser.parse(DictItem.class, map.get(AssetMeta.FINANCIAL_OPTION_DICT)));
			this.setManufacturer(DataParser.parse(Manufacturer.class, map.get(AssetMeta.MANUFACTURER)));
			this.setExpenseItemDict(DataParser.parse(DictItem.class, map.get(AssetMeta.EXPENSE_ITEM_DICT)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(AssetMeta.SUPPLIER)));
			this.setMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMeta.MAINTENANCE_METHOD_DATA)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(AssetMeta.USE_USER)));
			this.setEquipmentEnvironment(DataParser.parse(DictItem.class, map.get(AssetMeta.EQUIPMENT_ENVIRONMENT)));
			this.setAssetCycleStatus(DataParser.parse(AssetStatus.class, map.get(AssetMeta.ASSET_CYCLE_STATUS)));
			this.setRack(DataParser.parse(AssetRack.class, map.get(AssetMeta.RACK)));
			this.setManager(DataParser.parse(Employee.class, map.get(AssetMeta.MANAGER)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetMeta.WAREHOUSE)));
			this.setGoodsStock(DataParser.parse(GoodsStock.class, map.get(AssetMeta.GOODS_STOCK)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetMeta.USE_ORGANIZATION)));
			this.setAssetCollection(DataParser.parse(AssetCollection.class, map.get(AssetMeta.ASSET_COLLECTION)));
			this.setChangeInstance(DataParser.parse(ChangeInstance.class, map.get(AssetMeta.CHANGE_INSTANCE)));
			this.setExtData(DataParser.parse(AssetExtData.class, map.get(AssetMeta.EXT_DATA)));
			this.setMaintnainer(DataParser.parse(Maintainer.class, map.get(AssetMeta.MAINTNAINER)));
			this.setAssetMaintenanceStatus(DataParser.parse(DictItem.class, map.get(AssetMeta.ASSET_MAINTENANCE_STATUS)));
			this.setPosition(DataParser.parse(Position.class, map.get(AssetMeta.POSITION)));
			this.setAssetBorrow(DataParser.parse(AssetBorrow.class, map.get(AssetMeta.ASSET_BORROW)));
			this.setCategory(DataParser.parse(Catalog.class, map.get(AssetMeta.CATEGORY)));
			this.setRegion(DataParser.parse(AssetRegion.class, map.get(AssetMeta.REGION)));
			return true;
		} else {
			try {
				this.setEquipmentCode( (String)map.get(AssetMeta.EQUIPMENT_CODE));
				this.setCustomerInfo( (String)map.get(AssetMeta.CUSTOMER_INFO));
				this.setPurchaseUnitPrice( (BigDecimal)map.get(AssetMeta.PURCHASE_UNIT_PRICE));
				this.setApprovalOpinion( (String)map.get(AssetMeta.APPROVAL_OPINION));
				this.setMaintenanceStatus( (String)map.get(AssetMeta.MAINTENANCE_STATUS));
				this.setNavPrice( (BigDecimal)map.get(AssetMeta.NAV_PRICE));
				this.setLabel4( (String)map.get(AssetMeta.LABEL4));
				this.setLabel5( (String)map.get(AssetMeta.LABEL5));
				this.setBusinessCode( (String)map.get(AssetMeta.BUSINESS_CODE));
				this.setAssetNumber( (Integer)map.get(AssetMeta.ASSET_NUMBER));
				this.setModel( (String)map.get(AssetMeta.MODEL));
				this.setId( (String)map.get(AssetMeta.ID));
				this.setScrapId( (String)map.get(AssetMeta.SCRAP_ID));
				this.setEquipmentEnvironmentCode( (String)map.get(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE));
				this.setDirector( (String)map.get(AssetMeta.DIRECTOR));
				this.setMonthDepreciationPrice( (BigDecimal)map.get(AssetMeta.MONTH_DEPRECIATION_PRICE));
				this.setVersion( (Integer)map.get(AssetMeta.VERSION));
				this.setSafetyLevelCode( (String)map.get(AssetMeta.SAFETY_LEVEL_CODE));
				this.setMaintainerId( (String)map.get(AssetMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)map.get(AssetMeta.MAINTENANCE_NOTES));
				this.setEntryTime( (Date)map.get(AssetMeta.ENTRY_TIME));
				this.setManageIp( (String)map.get(AssetMeta.MANAGE_IP));
				this.setWarehouseId( (String)map.get(AssetMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)map.get(AssetMeta.DELETE_TIME));
				this.setFinancialNotes( (String)map.get(AssetMeta.FINANCIAL_NOTES));
				this.setMaintenanceMethod( (String)map.get(AssetMeta.MAINTENANCE_METHOD));
				this.setFinancialOption( (String)map.get(AssetMeta.FINANCIAL_OPTION));
				this.setStatus( (String)map.get(AssetMeta.STATUS));
				this.setPurchaseDate( (Date)map.get(AssetMeta.PURCHASE_DATE));
				this.setOwnerCode( (String)map.get(AssetMeta.OWNER_CODE));
				this.setRemainNumber( (Integer)map.get(AssetMeta.REMAIN_NUMBER));
				this.setGoodsId( (String)map.get(AssetMeta.GOODS_ID));
				this.setChangeInstanceId( (String)map.get(AssetMeta.CHANGE_INSTANCE_ID));
				this.setEquipmentConf( (String)map.get(AssetMeta.EQUIPMENT_CONF));
				this.setAssetNotes( (String)map.get(AssetMeta.ASSET_NOTES));
				this.setOriginalUnitPrice( (BigDecimal)map.get(AssetMeta.ORIGINAL_UNIT_PRICE));
				this.setDepreciationId( (String)map.get(AssetMeta.DEPRECIATION_ID));
				this.setPictureId( (String)map.get(AssetMeta.PICTURE_ID));
				this.setSuggestMaintenanceMethod( (String)map.get(AssetMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setTotalAmountPrice( (BigDecimal)map.get(AssetMeta.TOTAL_AMOUNT_PRICE));
				this.setServiceLife( (BigDecimal)map.get(AssetMeta.SERVICE_LIFE));
				this.setAttach( (String)map.get(AssetMeta.ATTACH));
				this.setMaintainerName( (String)map.get(AssetMeta.MAINTAINER_NAME));
				this.setOriginatorId( (String)map.get(AssetMeta.ORIGINATOR_ID));
				this.setCleanOut( (String)map.get(AssetMeta.CLEAN_OUT));
				this.setRackId( (String)map.get(AssetMeta.RACK_ID));
				this.setDisplay( (String)map.get(AssetMeta.DISPLAY));
				this.setManufacturerId( (String)map.get(AssetMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)map.get(AssetMeta.UPDATE_TIME));
				this.setCategoryCode( (String)map.get(AssetMeta.CATEGORY_CODE));
				this.setManagerId( (String)map.get(AssetMeta.MANAGER_ID));
				this.setAccumulatedDepreciation( (BigDecimal)map.get(AssetMeta.ACCUMULATED_DEPRECIATION));
				this.setLabel2( (String)map.get(AssetMeta.LABEL2));
				this.setLabel3( (String)map.get(AssetMeta.LABEL3));
				this.setAssetSelectedData( (String)map.get(AssetMeta.ASSET_SELECTED_DATA));
				this.setDeleted( (Integer)map.get(AssetMeta.DELETED));
				this.setPositionId( (String)map.get(AssetMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(AssetMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(AssetMeta.TENANT_ID));
				this.setRfid( (String)map.get(AssetMeta.RFID));
				this.setMaintenanceStartDate( (Date)map.get(AssetMeta.MAINTENANCE_START_DATE));
				this.setLastVerificationDate( (Date)map.get(AssetMeta.LAST_VERIFICATION_DATE));
				this.setUseUserId( (String)map.get(AssetMeta.USE_USER_ID));
				this.setContacts( (String)map.get(AssetMeta.CONTACTS));
				this.setSourceId( (String)map.get(AssetMeta.SOURCE_ID));
				this.setProcId( (String)map.get(AssetMeta.PROC_ID));
				this.setFinancialCategoryId( (String)map.get(AssetMeta.FINANCIAL_CATEGORY_ID));
				this.setMaintenancePrice( (BigDecimal)map.get(AssetMeta.MAINTENANCE_PRICE));
				this.setEquipmentIp( (String)map.get(AssetMeta.EQUIPMENT_IP));
				this.setMaintenanceEndDate( (Date)map.get(AssetMeta.MAINTENANCE_END_DATE));
				this.setDepreciationOperTime( (Date)map.get(AssetMeta.DEPRECIATION_OPER_TIME));
				this.setNextApproverNames( (String)map.get(AssetMeta.NEXT_APPROVER_NAMES));
				this.setAssetCode( (String)map.get(AssetMeta.ASSET_CODE));
				this.setSerialNumber( (String)map.get(AssetMeta.SERIAL_NUMBER));
				this.setLatestApproverId( (String)map.get(AssetMeta.LATEST_APPROVER_ID));
				this.setGoodsStockId( (String)map.get(AssetMeta.GOODS_STOCK_ID));
				this.setTaxAmountRate( (BigDecimal)map.get(AssetMeta.TAX_AMOUNT_RATE));
				this.setCurrentYearDepreciation( (BigDecimal)map.get(AssetMeta.CURRENT_YEAR_DEPRECIATION));
				this.setUseOrganizationId( (String)map.get(AssetMeta.USE_ORGANIZATION_ID));
				this.setEquipmentLabel( (String)map.get(AssetMeta.EQUIPMENT_LABEL));
				this.setUnit( (String)map.get(AssetMeta.UNIT));
				this.setOwnCompanyId( (String)map.get(AssetMeta.OWN_COMPANY_ID));
				this.setBillId( (String)map.get(AssetMeta.BILL_ID));
				this.setName( (String)map.get(AssetMeta.NAME));
				this.setDeleteBy( (String)map.get(AssetMeta.DELETE_BY));
				this.setFinancialCode( (String)map.get(AssetMeta.FINANCIAL_CODE));
				this.setRackUpNumber( (Integer)map.get(AssetMeta.RACK_UP_NUMBER));
				this.setResidualsRate( (BigDecimal)map.get(AssetMeta.RESIDUALS_RATE));
				this.setAssetStatus( (String)map.get(AssetMeta.ASSET_STATUS));
				this.setExpenseItem( (String)map.get(AssetMeta.EXPENSE_ITEM));
				this.setChsVersion( (String)map.get(AssetMeta.CHS_VERSION));
				this.setSupplierId( (String)map.get(AssetMeta.SUPPLIER_ID));
				this.setPurpose( (String)map.get(AssetMeta.PURPOSE));
				this.setResidualsPrice( (BigDecimal)map.get(AssetMeta.RESIDUALS_PRICE));
				this.setInternalControlLabel( (String)map.get(AssetMeta.INTERNAL_CONTROL_LABEL));
				this.setLatestApproverName( (String)map.get(AssetMeta.LATEST_APPROVER_NAME));
				this.setAssetUsedServiceLife( (BigDecimal)map.get(AssetMeta.ASSET_USED_SERVICE_LIFE));
				this.setNextApproverIds( (String)map.get(AssetMeta.NEXT_APPROVER_IDS));
				this.setChsStatus( (String)map.get(AssetMeta.CHS_STATUS));
				this.setProductionDate( (Date)map.get(AssetMeta.PRODUCTION_DATE));
				this.setUpdateBy( (String)map.get(AssetMeta.UPDATE_BY));
				this.setCollectionId( (String)map.get(AssetMeta.COLLECTION_ID));
				this.setRegisterDate( (Date)map.get(AssetMeta.REGISTER_DATE));
				this.setSummary( (String)map.get(AssetMeta.SUMMARY));
				this.setEquipmentSerialNumber( (String)map.get(AssetMeta.EQUIPMENT_SERIAL_NUMBER));
				this.setBatchCode( (String)map.get(AssetMeta.BATCH_CODE));
				this.setEquipmentCpu( (String)map.get(AssetMeta.EQUIPMENT_CPU));
				this.setEquipmentMemory( (String)map.get(AssetMeta.EQUIPMENT_MEMORY));
				this.setLabel( (String)map.get(AssetMeta.LABEL));
				this.setEquipmentStatus( (String)map.get(AssetMeta.EQUIPMENT_STATUS));
				this.setPositionDetail( (String)map.get(AssetMeta.POSITION_DETAIL));
				this.setDepreciationYear( (Integer)map.get(AssetMeta.DEPRECIATION_YEAR));
				this.setCreateBy( (String)map.get(AssetMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(AssetMeta.CONTACT_INFORMATION));
				this.setTaxAmountPrice( (BigDecimal)map.get(AssetMeta.TAX_AMOUNT_PRICE));
				this.setRegionId( (String)map.get(AssetMeta.REGION_ID));
				this.setChsType( (String)map.get(AssetMeta.CHS_TYPE));
				this.setRackDownNumber( (Integer)map.get(AssetMeta.RACK_DOWN_NUMBER));
				this.setBorrowId( (String)map.get(AssetMeta.BORROW_ID));
				this.setCategoryId( (String)map.get(AssetMeta.CATEGORY_ID));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetMeta.OWNER_COMPANY));
				this.setSuggestMaintenanceMethodData( (DictItem)map.get(AssetMeta.SUGGEST_MAINTENANCE_METHOD_DATA));
				this.setSafetyLevel( (DictItem)map.get(AssetMeta.SAFETY_LEVEL));
				this.setCategoryFinance( (CategoryFinance)map.get(AssetMeta.CATEGORY_FINANCE));
				this.setGoods( (Goods)map.get(AssetMeta.GOODS));
				this.setOriginator( (Employee)map.get(AssetMeta.ORIGINATOR));
				this.setSource( (DictItem)map.get(AssetMeta.SOURCE));
				this.setFinancialOptionDict( (DictItem)map.get(AssetMeta.FINANCIAL_OPTION_DICT));
				this.setManufacturer( (Manufacturer)map.get(AssetMeta.MANUFACTURER));
				this.setExpenseItemDict( (DictItem)map.get(AssetMeta.EXPENSE_ITEM_DICT));
				this.setSupplier( (Supplier)map.get(AssetMeta.SUPPLIER));
				this.setMaintenanceMethodData( (DictItem)map.get(AssetMeta.MAINTENANCE_METHOD_DATA));
				this.setUseUser( (Employee)map.get(AssetMeta.USE_USER));
				this.setEquipmentEnvironment( (DictItem)map.get(AssetMeta.EQUIPMENT_ENVIRONMENT));
				this.setAssetCycleStatus( (AssetStatus)map.get(AssetMeta.ASSET_CYCLE_STATUS));
				this.setRack( (AssetRack)map.get(AssetMeta.RACK));
				this.setManager( (Employee)map.get(AssetMeta.MANAGER));
				this.setWarehouse( (Warehouse)map.get(AssetMeta.WAREHOUSE));
				this.setGoodsStock( (GoodsStock)map.get(AssetMeta.GOODS_STOCK));
				this.setUseOrganization( (Organization)map.get(AssetMeta.USE_ORGANIZATION));
				this.setAssetCollection( (AssetCollection)map.get(AssetMeta.ASSET_COLLECTION));
				this.setChangeInstance( (ChangeInstance)map.get(AssetMeta.CHANGE_INSTANCE));
				this.setExtData( (AssetExtData)map.get(AssetMeta.EXT_DATA));
				this.setMaintnainer( (Maintainer)map.get(AssetMeta.MAINTNAINER));
				this.setAssetMaintenanceStatus( (DictItem)map.get(AssetMeta.ASSET_MAINTENANCE_STATUS));
				this.setPosition( (Position)map.get(AssetMeta.POSITION));
				this.setAssetBorrow( (AssetBorrow)map.get(AssetMeta.ASSET_BORROW));
				this.setCategory( (Catalog)map.get(AssetMeta.CATEGORY));
				this.setRegion( (AssetRegion)map.get(AssetMeta.REGION));
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
			this.setEquipmentCode(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_CODE)));
			this.setCustomerInfo(DataParser.parse(String.class, r.getValue(AssetMeta.CUSTOMER_INFO)));
			this.setPurchaseUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.PURCHASE_UNIT_PRICE)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetMeta.APPROVAL_OPINION)));
			this.setMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMeta.MAINTENANCE_STATUS)));
			this.setNavPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.NAV_PRICE)));
			this.setLabel4(DataParser.parse(String.class, r.getValue(AssetMeta.LABEL4)));
			this.setLabel5(DataParser.parse(String.class, r.getValue(AssetMeta.LABEL5)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetMeta.BUSINESS_CODE)));
			this.setAssetNumber(DataParser.parse(Integer.class, r.getValue(AssetMeta.ASSET_NUMBER)));
			this.setModel(DataParser.parse(String.class, r.getValue(AssetMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMeta.ID)));
			this.setScrapId(DataParser.parse(String.class, r.getValue(AssetMeta.SCRAP_ID)));
			this.setEquipmentEnvironmentCode(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE)));
			this.setDirector(DataParser.parse(String.class, r.getValue(AssetMeta.DIRECTOR)));
			this.setMonthDepreciationPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.MONTH_DEPRECIATION_PRICE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMeta.VERSION)));
			this.setSafetyLevelCode(DataParser.parse(String.class, r.getValue(AssetMeta.SAFETY_LEVEL_CODE)));
			this.setMaintainerId(DataParser.parse(String.class, r.getValue(AssetMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMeta.MAINTENANCE_NOTES)));
			this.setEntryTime(DataParser.parse(Date.class, r.getValue(AssetMeta.ENTRY_TIME)));
			this.setManageIp(DataParser.parse(String.class, r.getValue(AssetMeta.MANAGE_IP)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMeta.DELETE_TIME)));
			this.setFinancialNotes(DataParser.parse(String.class, r.getValue(AssetMeta.FINANCIAL_NOTES)));
			this.setMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMeta.MAINTENANCE_METHOD)));
			this.setFinancialOption(DataParser.parse(String.class, r.getValue(AssetMeta.FINANCIAL_OPTION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetMeta.STATUS)));
			this.setPurchaseDate(DataParser.parse(Date.class, r.getValue(AssetMeta.PURCHASE_DATE)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetMeta.OWNER_CODE)));
			this.setRemainNumber(DataParser.parse(Integer.class, r.getValue(AssetMeta.REMAIN_NUMBER)));
			this.setGoodsId(DataParser.parse(String.class, r.getValue(AssetMeta.GOODS_ID)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetMeta.CHANGE_INSTANCE_ID)));
			this.setEquipmentConf(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_CONF)));
			this.setAssetNotes(DataParser.parse(String.class, r.getValue(AssetMeta.ASSET_NOTES)));
			this.setOriginalUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.ORIGINAL_UNIT_PRICE)));
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetMeta.DEPRECIATION_ID)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(AssetMeta.PICTURE_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setTotalAmountPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.TOTAL_AMOUNT_PRICE)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.SERVICE_LIFE)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetMeta.ATTACH)));
			this.setMaintainerName(DataParser.parse(String.class, r.getValue(AssetMeta.MAINTAINER_NAME)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetMeta.ORIGINATOR_ID)));
			this.setCleanOut(DataParser.parse(String.class, r.getValue(AssetMeta.CLEAN_OUT)));
			this.setRackId(DataParser.parse(String.class, r.getValue(AssetMeta.RACK_ID)));
			this.setDisplay(DataParser.parse(String.class, r.getValue(AssetMeta.DISPLAY)));
			this.setManufacturerId(DataParser.parse(String.class, r.getValue(AssetMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, r.getValue(AssetMeta.CATEGORY_CODE)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(AssetMeta.MANAGER_ID)));
			this.setAccumulatedDepreciation(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.ACCUMULATED_DEPRECIATION)));
			this.setLabel2(DataParser.parse(String.class, r.getValue(AssetMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, r.getValue(AssetMeta.LABEL3)));
			this.setAssetSelectedData(DataParser.parse(String.class, r.getValue(AssetMeta.ASSET_SELECTED_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(AssetMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMeta.TENANT_ID)));
			this.setRfid(DataParser.parse(String.class, r.getValue(AssetMeta.RFID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, r.getValue(AssetMeta.MAINTENANCE_START_DATE)));
			this.setLastVerificationDate(DataParser.parse(Date.class, r.getValue(AssetMeta.LAST_VERIFICATION_DATE)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetMeta.USE_USER_ID)));
			this.setContacts(DataParser.parse(String.class, r.getValue(AssetMeta.CONTACTS)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(AssetMeta.SOURCE_ID)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetMeta.PROC_ID)));
			this.setFinancialCategoryId(DataParser.parse(String.class, r.getValue(AssetMeta.FINANCIAL_CATEGORY_ID)));
			this.setMaintenancePrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.MAINTENANCE_PRICE)));
			this.setEquipmentIp(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_IP)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, r.getValue(AssetMeta.MAINTENANCE_END_DATE)));
			this.setDepreciationOperTime(DataParser.parse(Date.class, r.getValue(AssetMeta.DEPRECIATION_OPER_TIME)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetMeta.NEXT_APPROVER_NAMES)));
			this.setAssetCode(DataParser.parse(String.class, r.getValue(AssetMeta.ASSET_CODE)));
			this.setSerialNumber(DataParser.parse(String.class, r.getValue(AssetMeta.SERIAL_NUMBER)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetMeta.LATEST_APPROVER_ID)));
			this.setGoodsStockId(DataParser.parse(String.class, r.getValue(AssetMeta.GOODS_STOCK_ID)));
			this.setTaxAmountRate(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.TAX_AMOUNT_RATE)));
			this.setCurrentYearDepreciation(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.CURRENT_YEAR_DEPRECIATION)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetMeta.USE_ORGANIZATION_ID)));
			this.setEquipmentLabel(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_LABEL)));
			this.setUnit(DataParser.parse(String.class, r.getValue(AssetMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetMeta.OWN_COMPANY_ID)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssetMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMeta.DELETE_BY)));
			this.setFinancialCode(DataParser.parse(String.class, r.getValue(AssetMeta.FINANCIAL_CODE)));
			this.setRackUpNumber(DataParser.parse(Integer.class, r.getValue(AssetMeta.RACK_UP_NUMBER)));
			this.setResidualsRate(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.RESIDUALS_RATE)));
			this.setAssetStatus(DataParser.parse(String.class, r.getValue(AssetMeta.ASSET_STATUS)));
			this.setExpenseItem(DataParser.parse(String.class, r.getValue(AssetMeta.EXPENSE_ITEM)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, r.getValue(AssetMeta.SUPPLIER_ID)));
			this.setPurpose(DataParser.parse(String.class, r.getValue(AssetMeta.PURPOSE)));
			this.setResidualsPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.RESIDUALS_PRICE)));
			this.setInternalControlLabel(DataParser.parse(String.class, r.getValue(AssetMeta.INTERNAL_CONTROL_LABEL)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetMeta.LATEST_APPROVER_NAME)));
			this.setAssetUsedServiceLife(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.ASSET_USED_SERVICE_LIFE)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetMeta.NEXT_APPROVER_IDS)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetMeta.CHS_STATUS)));
			this.setProductionDate(DataParser.parse(Date.class, r.getValue(AssetMeta.PRODUCTION_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMeta.UPDATE_BY)));
			this.setCollectionId(DataParser.parse(String.class, r.getValue(AssetMeta.COLLECTION_ID)));
			this.setRegisterDate(DataParser.parse(Date.class, r.getValue(AssetMeta.REGISTER_DATE)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetMeta.SUMMARY)));
			this.setEquipmentSerialNumber(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_SERIAL_NUMBER)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AssetMeta.BATCH_CODE)));
			this.setEquipmentCpu(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_CPU)));
			this.setEquipmentMemory(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_MEMORY)));
			this.setLabel(DataParser.parse(String.class, r.getValue(AssetMeta.LABEL)));
			this.setEquipmentStatus(DataParser.parse(String.class, r.getValue(AssetMeta.EQUIPMENT_STATUS)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetMeta.POSITION_DETAIL)));
			this.setDepreciationYear(DataParser.parse(Integer.class, r.getValue(AssetMeta.DEPRECIATION_YEAR)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(AssetMeta.CONTACT_INFORMATION)));
			this.setTaxAmountPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetMeta.TAX_AMOUNT_PRICE)));
			this.setRegionId(DataParser.parse(String.class, r.getValue(AssetMeta.REGION_ID)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetMeta.CHS_TYPE)));
			this.setRackDownNumber(DataParser.parse(Integer.class, r.getValue(AssetMeta.RACK_DOWN_NUMBER)));
			this.setBorrowId(DataParser.parse(String.class, r.getValue(AssetMeta.BORROW_ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(AssetMeta.CATEGORY_ID)));
			return true;
		} else {
			try {
				this.setEquipmentCode( (String)r.getValue(AssetMeta.EQUIPMENT_CODE));
				this.setCustomerInfo( (String)r.getValue(AssetMeta.CUSTOMER_INFO));
				this.setPurchaseUnitPrice( (BigDecimal)r.getValue(AssetMeta.PURCHASE_UNIT_PRICE));
				this.setApprovalOpinion( (String)r.getValue(AssetMeta.APPROVAL_OPINION));
				this.setMaintenanceStatus( (String)r.getValue(AssetMeta.MAINTENANCE_STATUS));
				this.setNavPrice( (BigDecimal)r.getValue(AssetMeta.NAV_PRICE));
				this.setLabel4( (String)r.getValue(AssetMeta.LABEL4));
				this.setLabel5( (String)r.getValue(AssetMeta.LABEL5));
				this.setBusinessCode( (String)r.getValue(AssetMeta.BUSINESS_CODE));
				this.setAssetNumber( (Integer)r.getValue(AssetMeta.ASSET_NUMBER));
				this.setModel( (String)r.getValue(AssetMeta.MODEL));
				this.setId( (String)r.getValue(AssetMeta.ID));
				this.setScrapId( (String)r.getValue(AssetMeta.SCRAP_ID));
				this.setEquipmentEnvironmentCode( (String)r.getValue(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE));
				this.setDirector( (String)r.getValue(AssetMeta.DIRECTOR));
				this.setMonthDepreciationPrice( (BigDecimal)r.getValue(AssetMeta.MONTH_DEPRECIATION_PRICE));
				this.setVersion( (Integer)r.getValue(AssetMeta.VERSION));
				this.setSafetyLevelCode( (String)r.getValue(AssetMeta.SAFETY_LEVEL_CODE));
				this.setMaintainerId( (String)r.getValue(AssetMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)r.getValue(AssetMeta.MAINTENANCE_NOTES));
				this.setEntryTime( (Date)r.getValue(AssetMeta.ENTRY_TIME));
				this.setManageIp( (String)r.getValue(AssetMeta.MANAGE_IP));
				this.setWarehouseId( (String)r.getValue(AssetMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)r.getValue(AssetMeta.DELETE_TIME));
				this.setFinancialNotes( (String)r.getValue(AssetMeta.FINANCIAL_NOTES));
				this.setMaintenanceMethod( (String)r.getValue(AssetMeta.MAINTENANCE_METHOD));
				this.setFinancialOption( (String)r.getValue(AssetMeta.FINANCIAL_OPTION));
				this.setStatus( (String)r.getValue(AssetMeta.STATUS));
				this.setPurchaseDate( (Date)r.getValue(AssetMeta.PURCHASE_DATE));
				this.setOwnerCode( (String)r.getValue(AssetMeta.OWNER_CODE));
				this.setRemainNumber( (Integer)r.getValue(AssetMeta.REMAIN_NUMBER));
				this.setGoodsId( (String)r.getValue(AssetMeta.GOODS_ID));
				this.setChangeInstanceId( (String)r.getValue(AssetMeta.CHANGE_INSTANCE_ID));
				this.setEquipmentConf( (String)r.getValue(AssetMeta.EQUIPMENT_CONF));
				this.setAssetNotes( (String)r.getValue(AssetMeta.ASSET_NOTES));
				this.setOriginalUnitPrice( (BigDecimal)r.getValue(AssetMeta.ORIGINAL_UNIT_PRICE));
				this.setDepreciationId( (String)r.getValue(AssetMeta.DEPRECIATION_ID));
				this.setPictureId( (String)r.getValue(AssetMeta.PICTURE_ID));
				this.setSuggestMaintenanceMethod( (String)r.getValue(AssetMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setTotalAmountPrice( (BigDecimal)r.getValue(AssetMeta.TOTAL_AMOUNT_PRICE));
				this.setServiceLife( (BigDecimal)r.getValue(AssetMeta.SERVICE_LIFE));
				this.setAttach( (String)r.getValue(AssetMeta.ATTACH));
				this.setMaintainerName( (String)r.getValue(AssetMeta.MAINTAINER_NAME));
				this.setOriginatorId( (String)r.getValue(AssetMeta.ORIGINATOR_ID));
				this.setCleanOut( (String)r.getValue(AssetMeta.CLEAN_OUT));
				this.setRackId( (String)r.getValue(AssetMeta.RACK_ID));
				this.setDisplay( (String)r.getValue(AssetMeta.DISPLAY));
				this.setManufacturerId( (String)r.getValue(AssetMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetMeta.UPDATE_TIME));
				this.setCategoryCode( (String)r.getValue(AssetMeta.CATEGORY_CODE));
				this.setManagerId( (String)r.getValue(AssetMeta.MANAGER_ID));
				this.setAccumulatedDepreciation( (BigDecimal)r.getValue(AssetMeta.ACCUMULATED_DEPRECIATION));
				this.setLabel2( (String)r.getValue(AssetMeta.LABEL2));
				this.setLabel3( (String)r.getValue(AssetMeta.LABEL3));
				this.setAssetSelectedData( (String)r.getValue(AssetMeta.ASSET_SELECTED_DATA));
				this.setDeleted( (Integer)r.getValue(AssetMeta.DELETED));
				this.setPositionId( (String)r.getValue(AssetMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(AssetMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(AssetMeta.TENANT_ID));
				this.setRfid( (String)r.getValue(AssetMeta.RFID));
				this.setMaintenanceStartDate( (Date)r.getValue(AssetMeta.MAINTENANCE_START_DATE));
				this.setLastVerificationDate( (Date)r.getValue(AssetMeta.LAST_VERIFICATION_DATE));
				this.setUseUserId( (String)r.getValue(AssetMeta.USE_USER_ID));
				this.setContacts( (String)r.getValue(AssetMeta.CONTACTS));
				this.setSourceId( (String)r.getValue(AssetMeta.SOURCE_ID));
				this.setProcId( (String)r.getValue(AssetMeta.PROC_ID));
				this.setFinancialCategoryId( (String)r.getValue(AssetMeta.FINANCIAL_CATEGORY_ID));
				this.setMaintenancePrice( (BigDecimal)r.getValue(AssetMeta.MAINTENANCE_PRICE));
				this.setEquipmentIp( (String)r.getValue(AssetMeta.EQUIPMENT_IP));
				this.setMaintenanceEndDate( (Date)r.getValue(AssetMeta.MAINTENANCE_END_DATE));
				this.setDepreciationOperTime( (Date)r.getValue(AssetMeta.DEPRECIATION_OPER_TIME));
				this.setNextApproverNames( (String)r.getValue(AssetMeta.NEXT_APPROVER_NAMES));
				this.setAssetCode( (String)r.getValue(AssetMeta.ASSET_CODE));
				this.setSerialNumber( (String)r.getValue(AssetMeta.SERIAL_NUMBER));
				this.setLatestApproverId( (String)r.getValue(AssetMeta.LATEST_APPROVER_ID));
				this.setGoodsStockId( (String)r.getValue(AssetMeta.GOODS_STOCK_ID));
				this.setTaxAmountRate( (BigDecimal)r.getValue(AssetMeta.TAX_AMOUNT_RATE));
				this.setCurrentYearDepreciation( (BigDecimal)r.getValue(AssetMeta.CURRENT_YEAR_DEPRECIATION));
				this.setUseOrganizationId( (String)r.getValue(AssetMeta.USE_ORGANIZATION_ID));
				this.setEquipmentLabel( (String)r.getValue(AssetMeta.EQUIPMENT_LABEL));
				this.setUnit( (String)r.getValue(AssetMeta.UNIT));
				this.setOwnCompanyId( (String)r.getValue(AssetMeta.OWN_COMPANY_ID));
				this.setBillId( (String)r.getValue(AssetMeta.BILL_ID));
				this.setName( (String)r.getValue(AssetMeta.NAME));
				this.setDeleteBy( (String)r.getValue(AssetMeta.DELETE_BY));
				this.setFinancialCode( (String)r.getValue(AssetMeta.FINANCIAL_CODE));
				this.setRackUpNumber( (Integer)r.getValue(AssetMeta.RACK_UP_NUMBER));
				this.setResidualsRate( (BigDecimal)r.getValue(AssetMeta.RESIDUALS_RATE));
				this.setAssetStatus( (String)r.getValue(AssetMeta.ASSET_STATUS));
				this.setExpenseItem( (String)r.getValue(AssetMeta.EXPENSE_ITEM));
				this.setChsVersion( (String)r.getValue(AssetMeta.CHS_VERSION));
				this.setSupplierId( (String)r.getValue(AssetMeta.SUPPLIER_ID));
				this.setPurpose( (String)r.getValue(AssetMeta.PURPOSE));
				this.setResidualsPrice( (BigDecimal)r.getValue(AssetMeta.RESIDUALS_PRICE));
				this.setInternalControlLabel( (String)r.getValue(AssetMeta.INTERNAL_CONTROL_LABEL));
				this.setLatestApproverName( (String)r.getValue(AssetMeta.LATEST_APPROVER_NAME));
				this.setAssetUsedServiceLife( (BigDecimal)r.getValue(AssetMeta.ASSET_USED_SERVICE_LIFE));
				this.setNextApproverIds( (String)r.getValue(AssetMeta.NEXT_APPROVER_IDS));
				this.setChsStatus( (String)r.getValue(AssetMeta.CHS_STATUS));
				this.setProductionDate( (Date)r.getValue(AssetMeta.PRODUCTION_DATE));
				this.setUpdateBy( (String)r.getValue(AssetMeta.UPDATE_BY));
				this.setCollectionId( (String)r.getValue(AssetMeta.COLLECTION_ID));
				this.setRegisterDate( (Date)r.getValue(AssetMeta.REGISTER_DATE));
				this.setSummary( (String)r.getValue(AssetMeta.SUMMARY));
				this.setEquipmentSerialNumber( (String)r.getValue(AssetMeta.EQUIPMENT_SERIAL_NUMBER));
				this.setBatchCode( (String)r.getValue(AssetMeta.BATCH_CODE));
				this.setEquipmentCpu( (String)r.getValue(AssetMeta.EQUIPMENT_CPU));
				this.setEquipmentMemory( (String)r.getValue(AssetMeta.EQUIPMENT_MEMORY));
				this.setLabel( (String)r.getValue(AssetMeta.LABEL));
				this.setEquipmentStatus( (String)r.getValue(AssetMeta.EQUIPMENT_STATUS));
				this.setPositionDetail( (String)r.getValue(AssetMeta.POSITION_DETAIL));
				this.setDepreciationYear( (Integer)r.getValue(AssetMeta.DEPRECIATION_YEAR));
				this.setCreateBy( (String)r.getValue(AssetMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(AssetMeta.CONTACT_INFORMATION));
				this.setTaxAmountPrice( (BigDecimal)r.getValue(AssetMeta.TAX_AMOUNT_PRICE));
				this.setRegionId( (String)r.getValue(AssetMeta.REGION_ID));
				this.setChsType( (String)r.getValue(AssetMeta.CHS_TYPE));
				this.setRackDownNumber( (Integer)r.getValue(AssetMeta.RACK_DOWN_NUMBER));
				this.setBorrowId( (String)r.getValue(AssetMeta.BORROW_ID));
				this.setCategoryId( (String)r.getValue(AssetMeta.CATEGORY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}