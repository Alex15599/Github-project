/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 18:19:40
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	
	//模块基础路径
	const moduleURL="/service-eam/eam-asset";
	var dataTable=null;
	var sort=null;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;

		if(window.pageExt.list.beforeInit) {
			window.pageExt.list.beforeInit();
		}
     	//渲染表格
     	renderTable();
		//初始化搜索输入框组件
		initSearchFields();
		//绑定搜索框事件
		bindSearchEvent();
		//绑定按钮事件
		bindButtonEvent();
		//绑定行操作按钮事件
    	bindRowOperationEvent();
     }


     /**
      * 渲染表格
      */
    function renderTable() {
		$(window).resize(function() {
			fox.adjustSearchElement();
		});
		fox.adjustSearchElement();
		//
		 var marginTop=$(".search-bar").height()+$(".search-bar").css("padding-top")+$(".search-bar").css("padding-bottom")
		 $("#table-area").css("margin-top",marginTop+"px");
		//
		function renderTableInternal() {

			var ps={searchField: "$composite"};
			var contitions={};

			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			}
			ps.searchValue=JSON.stringify(contitions);

			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			var tableConfig={
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: fox.translate('刷新数据','','cmp:table'),layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产分类'), templet: function (d) { return templet('categoryId' ,fox.joinLabel(d.category,"name",',','','categoryId'),d);}}
					,{ field: 'categoryCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('分类编码') , templet: function (d) { return templet('categoryCode',d.categoryCode,d);}  }
					,{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
					,{ field: 'procId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('流程') , templet: function (d) { return templet('procId',d.procId,d);}  }
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('办理状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status,'','status'),d);}}
					,{ field: 'batchCode', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('批次编码') , templet: function (d) { return templet('batchCode',d.batchCode,d);}  }
					,{ field: 'ownerCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('归属') , templet: function (d) { return templet('ownerCode',d.ownerCode,d);}  }
					,{ field: 'assetCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产编号') , templet: function (d) { return templet('assetCode',d.assetCode,d);}  }
					,{ field: 'assetStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产状态'), templet: function (d) { return templet('assetStatus' ,fox.joinLabel(d.assetCycleStatus,"name",',','','assetStatus'),d);}}
					,{ field: 'goodsId', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('物品档案'), templet: function (d) { return templet('goodsId' ,fox.joinLabel(d.goods,"name",',','','goodsId'),d);}}
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'manufacturerId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('厂商'), templet: function (d) { return templet('manufacturerId' ,fox.joinLabel(d.manufacturer,"manufacturerName",',','','manufacturerId'),d);}}
					,{ field: 'model', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('规格型号') , templet: function (d) { return templet('model',d.model,d);}  }
					,{ field: 'unit', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('计量单位') , templet: function (d) { return templet('unit',d.unit,d);}  }
					,{ field: 'serviceLife', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('使用期限') , templet: function (d) { return templet('serviceLife',d.serviceLife,d);}  }
					,{ field: 'safetyLevelCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('安全等级'), templet: function (d) { return templet('safetyLevelCode' ,fox.joinLabel(d.safetyLevel,"label",',','','safetyLevelCode'),d);}}
					,{ field: 'serialNumber', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('序列号') , templet: function (d) { return templet('serialNumber',d.serialNumber,d);}  }
					,{ field: 'ownCompanyId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('所属公司') , templet: function (d) { return templet('ownCompanyId',fox.getProperty(d,["ownerCompany","fullName"],0,'','ownCompanyId'),d);} }
					,{ field: 'managerId', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('管理人员') , templet: function (d) { return templet('managerId',fox.getProperty(d,["manager","name"],0,'','managerId'),d);} }
					,{ field: 'useOrganizationId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('使用公司/部门') , templet: function (d) { return templet('useOrganizationId',fox.getProperty(d,["useOrganization","fullName"],0,'','useOrganizationId'),d);} }
					,{ field: 'useUserId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('使用人员') , templet: function (d) { return templet('useUserId',fox.getProperty(d,["useUser","name"],0,'','useUserId'),d);} }
					,{ field: 'regionId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('存放区域') , templet: function (d) { return templet('regionId',d.regionId,d);}  }
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('位置'), templet: function (d) { return templet('positionId' ,fox.joinLabel(d.position,"hierarchyName",',','','positionId'),d);}}
					,{ field: 'positionDetail', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('详细位置') , templet: function (d) { return templet('positionDetail',d.positionDetail,d);}  }
					,{ field: 'warehouseId', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('仓库'), templet: function (d) { return templet('warehouseId' ,fox.joinLabel(d.warehouse,"warehouseName",',','','warehouseId'),d);}}
					,{ field: 'goodsStockId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('库存物品'), templet: function (d) { return templet('goodsStockId' ,fox.joinLabel(d.goodsStock,"name",',','','goodsStockId'),d);}}
					,{ field: 'sourceId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('来源'), templet: function (d) { return templet('sourceId' ,fox.joinLabel(d.source,"label",',','','sourceId'),d);}}
					,{ field: 'assetNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('资产数量') , templet: function (d) { return templet('assetNumber',d.assetNumber,d);}  }
					,{ field: 'remainNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('剩余数量') , templet: function (d) { return templet('remainNumber',d.remainNumber,d);}  }
					,{ field: 'purchaseDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('采购日期') ,templet: function (d) { return templet('purchaseDate',fox.dateFormat(d.purchaseDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'productionDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('生产日期') ,templet: function (d) { return templet('productionDate',fox.dateFormat(d.productionDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'registerDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('入账日期') ,templet: function (d) { return templet('registerDate',fox.dateFormat(d.registerDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'rfid', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('RFID标签') , templet: function (d) { return templet('rfid',d.rfid,d);}  }
					,{ field: 'lastVerificationDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('最近核对日期') ,templet: function (d) { return templet('lastVerificationDate',fox.dateFormat(d.lastVerificationDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'purpose', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('用途') , templet: function (d) { return templet('purpose',d.purpose,d);}  }
					,{ field: 'assetNotes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产备注') , templet: function (d) { return templet('assetNotes',d.assetNotes,d);}  }
					,{ field: 'maintainerId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('维保商'), templet: function (d) { return templet('maintainerId' ,fox.joinLabel(d.maintnainer,"maintainerName",',','','maintainerId'),d);}}
					,{ field: 'maintainerName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('维保厂商') , templet: function (d) { return templet('maintainerName',d.maintainerName,d);}  }
					,{ field: 'maintenanceStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('维保状态'), templet: function (d) { return templet('maintenanceStatus' ,fox.joinLabel(d.assetMaintenanceStatus,"label",',','','maintenanceStatus'),d);}}
					,{ field: 'maintenancePrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('维保价格') , templet: function (d) { return templet('maintenancePrice',d.maintenancePrice,d);}  }
					,{ field: 'maintenanceMethod', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('维保方式'), templet: function (d) { return templet('maintenanceMethod' ,fox.joinLabel(d.maintenanceMethodData,"label",',','','maintenanceMethod'),d);}}
					,{ field: 'suggestMaintenanceMethod', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('建议维保方式'), templet: function (d) { return templet('suggestMaintenanceMethod' ,fox.joinLabel(d.suggestMaintenanceMethodData,"label",',','','suggestMaintenanceMethod'),d);}}
					,{ field: 'contacts', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('联系人') , templet: function (d) { return templet('contacts',d.contacts,d);}  }
					,{ field: 'contactInformation', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('联系方式') , templet: function (d) { return templet('contactInformation',d.contactInformation,d);}  }
					,{ field: 'director', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('负责人') , templet: function (d) { return templet('director',d.director,d);}  }
					,{ field: 'maintenanceStartDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('维保开始时间') ,templet: function (d) { return templet('maintenanceStartDate',fox.dateFormat(d.maintenanceStartDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'maintenanceEndDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('维保到期时间') ,templet: function (d) { return templet('maintenanceEndDate',fox.dateFormat(d.maintenanceEndDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'maintenanceNotes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('维保备注') , templet: function (d) { return templet('maintenanceNotes',d.maintenanceNotes,d);}  }
					,{ field: 'financialCategoryId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('财务分类'), templet: function (d) { return templet('financialCategoryId' ,fox.joinLabel(d.categoryFinance,"hierarchyName",',','','financialCategoryId'),d);}}
					,{ field: 'financialCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('财务编号') , templet: function (d) { return templet('financialCode',d.financialCode,d);}  }
					,{ field: 'financialOption', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('财务选项'), templet: function (d) { return templet('financialOption' ,fox.joinLabel(d.financialOptionDict,"label",',','','financialOption'),d);}}
					,{ field: 'expenseItem', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('费用项目'), templet: function (d) { return templet('expenseItem' ,fox.joinLabel(d.expenseItemDict,"label",',','','expenseItem'),d);}}
					,{ field: 'supplierId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('供应商'), templet: function (d) { return templet('supplierId' ,fox.joinLabel(d.supplier,"supplierName",',','','supplierId'),d);}}
					,{ field: 'customerInfo', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('客户信息') , templet: function (d) { return templet('customerInfo',d.customerInfo,d);}  }
					,{ field: 'taxAmountPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('含税总值') , templet: function (d) { return templet('taxAmountPrice',d.taxAmountPrice,d);}  }
					,{ field: 'totalAmountPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('未税总值') , templet: function (d) { return templet('totalAmountPrice',d.totalAmountPrice,d);}  }
					,{ field: 'purchaseUnitPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('含税单价') , templet: function (d) { return templet('purchaseUnitPrice',d.purchaseUnitPrice,d);}  }
					,{ field: 'originalUnitPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('资产原值') , templet: function (d) { return templet('originalUnitPrice',d.originalUnitPrice,d);}  }
					,{ field: 'navPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('资产净值') , templet: function (d) { return templet('navPrice',d.navPrice,d);}  }
					,{ field: 'assetUsedServiceLife', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('已用期限') , templet: function (d) { return templet('assetUsedServiceLife',d.assetUsedServiceLife,d);}  }
					,{ field: 'depreciationId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('最后折旧') , templet: function (d) { return templet('depreciationId',d.depreciationId,d);}  }
					,{ field: 'depreciationOperTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('最后折旧时间') ,templet: function (d) { return templet('depreciationOperTime',fox.dateFormat(d.depreciationOperTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'residualsRate', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('residuals_rate') , templet: function (d) { return templet('residualsRate',d.residualsRate,d);}  }
					,{ field: 'residualsPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('残值') , templet: function (d) { return templet('residualsPrice',d.residualsPrice,d);}  }
					,{ field: 'taxAmountRate', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('税额') , templet: function (d) { return templet('taxAmountRate',d.taxAmountRate,d);}  }
					,{ field: 'currentYearDepreciation', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('本年折旧') , templet: function (d) { return templet('currentYearDepreciation',d.currentYearDepreciation,d);}  }
					,{ field: 'depreciationYear', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('折旧年份') , templet: function (d) { return templet('depreciationYear',d.depreciationYear,d);}  }
					,{ field: 'accumulatedDepreciation', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('累计折旧') , templet: function (d) { return templet('accumulatedDepreciation',d.accumulatedDepreciation,d);}  }
					,{ field: 'monthDepreciationPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('月折金额') , templet: function (d) { return templet('monthDepreciationPrice',d.monthDepreciationPrice,d);}  }
					,{ field: 'entryTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('登记时间') ,templet: function (d) { return templet('entryTime',fox.dateFormat(d.entryTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'financialNotes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('财务备注') , templet: function (d) { return templet('financialNotes',d.financialNotes,d);}  }
					,{ field: 'equipmentCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备编号') , templet: function (d) { return templet('equipmentCode',d.equipmentCode,d);}  }
					,{ field: 'equipmentStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备状态'), templet:function (d){ return templet('equipmentStatus',fox.getEnumText(SELECT_EQUIPMENTSTATUS_DATA,d.equipmentStatus,'','equipmentStatus'),d);}}
					,{ field: 'equipmentIp', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备IP') , templet: function (d) { return templet('equipmentIp',d.equipmentIp,d);}  }
					,{ field: 'manageIp', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('管理IP') , templet: function (d) { return templet('manageIp',d.manageIp,d);}  }
					,{ field: 'equipmentCpu', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备CPU') , templet: function (d) { return templet('equipmentCpu',d.equipmentCpu,d);}  }
					,{ field: 'equipmentMemory', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备内存') , templet: function (d) { return templet('equipmentMemory',d.equipmentMemory,d);}  }
					,{ field: 'equipmentLabel', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备标签') , templet: function (d) { return templet('equipmentLabel',d.equipmentLabel,d);}  }
					,{ field: 'equipmentConf', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备配置') , templet: function (d) { return templet('equipmentConf',d.equipmentConf,d);}  }
					,{ field: 'equipmentEnvironmentCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('运行环境'), templet: function (d) { return templet('equipmentEnvironmentCode' ,fox.joinLabel(d.equipmentEnvironment,"label",',','','equipmentEnvironmentCode'),d);}}
					,{ field: 'equipmentSerialNumber', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备序列号') , templet: function (d) { return templet('equipmentSerialNumber',d.equipmentSerialNumber,d);}  }
					,{ field: 'rackId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('机柜'), templet: function (d) { return templet('rackId' ,fox.joinLabel(d.rack,"name",',','','rackId'),d);}}
					,{ field: 'rackUpNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('设备机柜上位置') , templet: function (d) { return templet('rackUpNumber',d.rackUpNumber,d);}  }
					,{ field: 'rackDownNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('设备机柜下位置') , templet: function (d) { return templet('rackDownNumber',d.rackDownNumber,d);}  }
					,{ field: 'label', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('短标签1') , templet: function (d) { return templet('label',d.label,d);}  }
					,{ field: 'label2', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('长标签2') , templet: function (d) { return templet('label2',d.label2,d);}  }
					,{ field: 'label3', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('短标签3') , templet: function (d) { return templet('label3',d.label3,d);}  }
					,{ field: 'label4', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('长标签4') , templet: function (d) { return templet('label4',d.label4,d);}  }
					,{ field: 'label5', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('短标签5') , templet: function (d) { return templet('label5',d.label5,d);}  }
					,{ field: 'billId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('单据') , templet: function (d) { return templet('billId',d.billId,d);}  }
					,{ field: 'internalControlLabel', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('内部控制标签') , templet: function (d) { return templet('internalControlLabel',d.internalControlLabel,d);}  }
					,{ field: 'collectionId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('领用ID') , templet: function (d) { return templet('collectionId',d.collectionId,d);}  }
					,{ field: 'borrowId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('借用ID') , templet: function (d) { return templet('borrowId',d.borrowId,d);}  }
					,{ field: 'scrapId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('报废ID') , templet: function (d) { return templet('scrapId',d.scrapId,d);}  }
					,{ field: 'originatorId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',d.originatorId,d);}  }
					,{ field: 'chsType', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('变更类型') , templet: function (d) { return templet('chsType',d.chsType,d);}  }
					,{ field: 'chsStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('变更状态') , templet: function (d) { return templet('chsStatus',d.chsStatus,d);}  }
					,{ field: 'chsVersion', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('变更版本号') , templet: function (d) { return templet('chsVersion',d.chsVersion,d);}  }
					,{ field: 'changeInstanceId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('变更ID') , templet: function (d) { return templet('changeInstanceId',d.changeInstanceId,d);}  }
					,{ field: 'summary', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('流程概要') , templet: function (d) { return templet('summary',d.summary,d);}  }
					,{ field: 'latestApproverId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('最后审批人账户ID') , templet: function (d) { return templet('latestApproverId',d.latestApproverId,d);}  }
					,{ field: 'latestApproverName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('最后审批人姓名') , templet: function (d) { return templet('latestApproverName',d.latestApproverName,d);}  }
					,{ field: 'nextApproverIds', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('下一节点审批人') , templet: function (d) { return templet('nextApproverIds',d.nextApproverIds,d);}  }
					,{ field: 'nextApproverNames', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('下一个审批节点审批人姓名') , templet: function (d) { return templet('nextApproverNames',d.nextApproverNames,d);}  }
					,{ field: 'approvalOpinion', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('审批意见') , templet: function (d) { return templet('approvalOpinion',d.approvalOpinion,d);}  }
					,{ field: 'assetSelectedData', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('选择') , templet: function (d) { return templet('assetSelectedData',d.assetSelectedData,d);}  }
					,{ field: fox.translate('空白列','','cmp:table'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作','','cmp:table'), width: 160 }
				]],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
				footer : {
					exportExcel : false ,
					importExcel : false 
				}
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			dataTable=fox.renderTable(tableConfig);
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
			  refreshTableData(obj.sortField,obj.type);
			});
			window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
		}
		setTimeout(renderTableInternal,1);
    };

	/**
	 * 刷新单号数据
	 * */
	function refreshRowData(data,remote) {
		var context=dataTable.getDataRowContext( { id : data.id } );
		if(context==null) return;
		if(remote) {
			admin.post(moduleURL+"/get-by-id", { id : data.id }, function (r) {
				if (r.success) {
					data = r.data;
					context.update(data);
					fox.renderFormInputs(form);
				} else {
					fox.showMessage(data);
				}
			});
		} else {
			context.update(data);
			fox.renderFormInputs(form);
		}
	}

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.status={ inputType:"select_box", value: getSelectedValue("#status","value"), label:getSelectedValue("#status","nameStr") };
		value.assetCode={ inputType:"button",value: $("#assetCode").val()};
		value.assetStatus={ inputType:"select_box", value: getSelectedValue("#assetStatus","value") ,fillBy:["assetCycleStatus"]  , label:getSelectedValue("#assetStatus","nameStr") };
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.manufacturerId={ inputType:"select_box", value: getSelectedValue("#manufacturerId","value") ,fillBy:["manufacturer"]  , label:getSelectedValue("#manufacturerId","nameStr") };
		value.model={ inputType:"button",value: $("#model").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.serialNumber={ inputType:"button",value: $("#serialNumber").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text() };
		value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text() };
		value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text() };
		value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
		value.positionId={ inputType:"select_box", value: getSelectedValue("#positionId","value") ,fillBy:["position"]  , label:getSelectedValue("#positionId","nameStr") };
		value.sourceId={ inputType:"select_box", value: getSelectedValue("#sourceId","value") ,fillBy:["source"]  , label:getSelectedValue("#sourceId","nameStr") };
		value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() ,matchType:"auto" };
		value.assetNotes={ inputType:"button",value: $("#assetNotes").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.maintainerId={ inputType:"select_box", value: getSelectedValue("#maintainerId","value") ,fillBy:["maintnainer"]  , label:getSelectedValue("#maintainerId","nameStr") };
		value.equipmentIp={ inputType:"button",value: $("#equipmentIp").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.manageIp={ inputType:"button",value: $("#manageIp").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.equipmentLabel={ inputType:"button",value: $("#equipmentLabel").val()};
		value.equipmentEnvironmentCode={ inputType:"select_box", value: getSelectedValue("#equipmentEnvironmentCode","value") ,fillBy:["equipmentEnvironment"]  , label:getSelectedValue("#equipmentEnvironmentCode","nameStr") };
		var ps={searchField:"$composite"};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
		}
		ps.searchValue=JSON.stringify(value);
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
			sort={ field : sortField,type : sortType} ;
		} else {
			if(sort) {
				ps.sortField=sort.field;
				ps.sortType=sort.type;
			} 		}
		if(reset) {
			table.reload('data-table', { where : ps , page:{ curr:1 } });
		} else {
			table.reload('data-table', { where : ps });
		}
	}


	/**
	  * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	  */
	function getCheckedList(field) {
		var checkStatus = table.checkStatus('data-table');
		var data = checkStatus.data;
		if(!field) return data;
		for(var i=0;i<data.length;i++) data[i]=data[i][field];
		return data;
	}

	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {
		$('#search-field').val("");
		$('#search-input').val("");
		layui.form.render();
	}

	function initSearchFields() {

		fox.switchSearchRow(1);

		//渲染 status 下拉字段
		fox.renderSelectBox({
			el: "status",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("status",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({data:data[i],name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 assetStatus 下拉字段
		fox.renderSelectBox({
			el: "assetStatus",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("assetStatus",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].name,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 manufacturerId 下拉字段
		fox.renderSelectBox({
			el: "manufacturerId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("manufacturerId",data.arr,data.change,data.isAdd);
				},1);
			},
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "manufacturerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].manufacturerName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 positionId 下拉字段
		fox.renderSelectBox({
			el: "positionId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("positionId",data.arr,data.change,data.isAdd);
				},1);
			},
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "hierarchyName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].hierarchyName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 sourceId 下拉字段
		fox.renderSelectBox({
			el: "sourceId",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("sourceId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].label,value:data[i].code});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#purchaseDate-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("purchaseDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#purchaseDate-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("purchaseDate",value, date, endDate);
				},1);
			}
		});
		//渲染 maintainerId 下拉字段
		fox.renderSelectBox({
			el: "maintainerId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("maintainerId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "maintainerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].maintainerName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 equipmentEnvironmentCode 下拉字段
		fox.renderSelectBox({
			el: "equipmentEnvironmentCode",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("equipmentEnvironmentCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].label,value:data[i].code});
				}
				return opts;
			}
		});
		fox.renderSearchInputs();
		window.pageExt.list.afterSearchInputReady && window.pageExt.list.afterSearchInputReady();
	}

	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {
		//回车键查询
        $(".search-input").keydown(function(event) {
			if(event.keyCode !=13) return;
		  	refreshTableData(null,null,true);
        });

        // 搜索按钮点击事件
        $('#search-button').click(function () {
			refreshTableData(null,null,true);
        });

		// 搜索按钮点击事件
		$('#search-button-advance').click(function () {
			fox.switchSearchRow(1,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
		});

		// 请选择公司对话框
		$("#ownCompanyId-button").click(function(){
			var ownCompanyIdDialogOptions={
				field:"ownCompanyId",
				inputEl:$("#ownCompanyId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseOrgNode(ownCompanyIdDialogOptions);
		});
		// 请选择人员对话框
		$("#managerId-button").click(function(){
				var managerIdDialogOptions={
				field:"managerId",
				inputEl:$("#managerId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseEmployee(managerIdDialogOptions);
		});
		// 请选择组织节点对话框
		$("#useOrganizationId-button").click(function(){
			var useOrganizationIdDialogOptions={
				field:"useOrganizationId",
				inputEl:$("#useOrganizationId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseOrgNode(useOrganizationIdDialogOptions);
		});
		// 请选择人员对话框
		$("#useUserId-button").click(function(){
				var useUserIdDialogOptions={
				field:"useUserId",
				inputEl:$("#useUserId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseEmployee(useUserIdDialogOptions);
		});
	}

	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {

		//头工具栏事件
		table.on('toolbar(data-table)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
			var selected=getCheckedList("id");
			if(window.pageExt.list.beforeToolBarButtonEvent) {
				var doNext=window.pageExt.list.beforeToolBarButtonEvent(selected,obj);
				if(!doNext) return;
			}
			switch(obj.event){
				case 'create':
					admin.putTempData('eam-asset-form-data', {});
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'refresh-data':
					refreshTableData();
					break;
				case 'other':
					break;
			};
		});


		//添加按钮点击事件
        function openCreateFrom() {
        	//设置新增是初始化数据
        	var data={};
			admin.putTempData('eam-asset-form-data-form-action', "create",true);
            showEditForm(data);
        };

        //批量删除按钮点击事件
        function batchDelete(selected) {

        	if(window.pageExt.list.beforeBatchDelete) {
				var doNext=window.pageExt.list.beforeBatchDelete(selected);
				if(!doNext) return;
			}

			var ids=getCheckedList("id");
            if(ids.length==0) {
				top.layer.msg(fox.translate('请选择需要删除的'+'资产'+"!"));
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的'+'资产'+'吗？'), function (i) {
                top.layer.close(i);
				admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    if (data.success) {
						if(window.pageExt.list.afterBatchDelete) {
							var doNext=window.pageExt.list.afterBatchDelete(data);
							if(!doNext) return;
						}
						fox.showMessage(data);
                        refreshTableData();
                    } else {
						if(data.data>0) {
							refreshTableData();
						}
						fox.showMessage(data);
                    }
                },{delayLoading:200,elms:[$("#delete-button")]});
			});
        }
	}

    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {
		// 工具条点击事件
		table.on('tool(data-table)', function (obj) {
			var data = obj.data;
			var layEvent = obj.event;

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('eam-asset-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-asset-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 fox.showMessage(data);
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-asset-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						fox.showMessage(data);
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}

				top.layer.confirm(fox.translate('确定删除此'+'资产'+'吗？'), function (i) {
					top.layer.close(i);
					admin.post(moduleURL+"/delete", { id : data.id }, function (data) {
						top.layer.closeAll('loading');
						if (data.success) {
							if(window.pageExt.list.afterSingleDelete) {
								var doNext=window.pageExt.list.afterSingleDelete(data);
								if(!doNext) return;
							}
							fox.showMessage(data);
							refreshTableData();
						} else {
							fox.showMessage(data);
						}
					},{delayLoading:100, elms:[$(".ops-delete-button[data-id='"+data.id+"']")]});
				});
			}
			else if (layEvent === 'asset-data-change') { // 变更
				window.pageExt.list.assetDataChange(data,this);
			}
			else if(obj.event === 'ops-more'){
				//更多下拉菜单
				var  items = [{"perm":"id1","id":"id1","title":"测试1"},{"perm":"id1","id":"id1","title":"测试2"}];
				items=items.filter(function (item,i,arr){
					if(!item.perm) return true;
					else return admin.checkAuth(item.perm);
				});
				dropdown.render({
					elem: this
					,show: true //外部事件触发即显示
					,data: items
					,click: function(menu, othis){
						if(menu.perm && !admin.checkAuth(menu.perm)) {
							top.layer.msg(fox.translate('缺少操作权限','','cmp:table'), {icon: 2, time: 1500});
							return;
						}
						window.pageExt.list.moreAction && window.pageExt.list.moreAction(menu,data, othis);
					}
					,align: 'right'
					,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);'
				});
			}
			
		});

    };

    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {
		if(window.pageExt.list.beforeEdit) {
			var doNext=window.pageExt.list.beforeEdit(data);
			if(!doNext) return;
		}
		var action=admin.getTempData('eam-asset-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('eam-asset-form-data', data);
		var area=admin.getTempData('eam-asset-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('资产');
		if(action=="create") title=fox.translate('添加','','cmp:table')+title;
		else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
		else if(action=="view") title=fox.translate('查看','','cmp:table')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-asset-form-data-win",
			content: '/business/eam/asset/asset_form.html' + (queryString?("?"+queryString):""),
			finish: function () {
				if(action=="create") {
					refreshTableData();
				}
				if(action=="edit") {
					false?refreshTableData():refreshRowData(data,true);
				}
			}
		});
	};

	window.module={
		refreshTableData: refreshTableData,
		refreshRowData: refreshRowData,
		getCheckedList: getCheckedList,
		showEditForm: showEditForm
	};

	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});