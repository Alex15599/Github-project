/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 15:27:32
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	var assetListColumn;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset";
	var dataTable=null;
	var sort=null;
	var categorySelect;
	var menuSelect=[];
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {

		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;
		assetListColumn=layui.assetListColumn;

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
		function renderTableInternal() {

			var ps={};
			var contitions={};
			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions);
			}
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}
			// if(CATEGORY_ID&&CATEGORY_ID.length>0){
			// 	ps.categoryId=CATEGORY_ID;
			// }
			if(!ps.categoryId){
				ps.categoryId=CATEGORY_ID;
			}
			ps.ownerCode=OWNER_CODE;
			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			var COL_ALL_DATA= assetListColumn.getColumnList(templet);
			console.log(COL_ALL_DATA);

			var COL_DATA=[
				{ fixed: 'left',type: 'numbers' },
				{ fixed: 'left',type:'checkbox' }
			]
			for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
				if(ATTRIBUTE_LIST_DATA[i].attribute&&ATTRIBUTE_LIST_DATA[i].attribute.code){
					var e=COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code];
					e.title=ATTRIBUTE_LIST_DATA[i].attribute.label;
					COL_DATA.push(e)
				}
			}
			if(APPROVAL_REQUIRED){
				COL_DATA.push(COL_ALL_DATA["approval_opinion"]);
			}
			var oper={ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 360 };
			COL_DATA.push(oper)

			dataTable=fox.renderTable({
				elem: '#'+TABLE_ID,
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [COL_DATA],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
				// footer : {
				// 	exportExcel : admin.checkAuth(AUTH_PREFIX+":export"),
				// 	importExcel : admin.checkAuth(AUTH_PREFIX+":import")?{
				// 		params : {ownerCode:OWNER_CODE} ,
				// 		callback : function(r) {
				// 			if(r.success) {
				// 				layer.msg(fox.translate('数据导入成功')+"!");
				// 				refreshTableData(null,null,true);
				// 			} else {
				// 				var errs = [];
				// 				if (r.data&&r.data.length>0) {
				// 					for (var i = 0; i < r.data.length; i++) {
				// 						if (errs.indexOf(r.data[i].message) == -1) {
				// 							errs.push(r.data[i].message);
				// 						}
				// 					}
				// 					top.layer.msg(errs.join("<br>"), {time: 2000});
				// 				} else {
				// 					top.layer.msg(r.message, {time: 2000});
				// 				}
				//
				// 			}
				// 		}
				// 	}:false
				// }
			});
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
				refreshTableData(obj.field,obj.type);
			});



		}
		setTimeout(renderTableInternal,1);

		if(window.pageExt.list.afterRenderTable){
			window.pageExt.list.afterRenderTable();
		}
	};

	/**
	 * 刷新表格数据
	 */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		//value.businessCode={ inputType:"button",value: $("#businessCode").val()};
		value.status={ inputType:"select_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr") };
		value.assetCode={ inputType:"button",value: $("#assetCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
	//	value.assetStatus={ inputType:"select_box", value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr") };
		value.assetStatus={ inputType:"select_box", value: getSelectedValue("#assetStatus","value") ,fillBy:["assetCycleStatus"]  , label:getSelectedValue("#assetStatus","nameStr") };
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.manufacturerId={ inputType:"select_box", value: xmSelect.get("#manufacturerId",true).getValue("value") ,fillBy:["manufacturer"]  , label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
		value.model={ inputType:"button",value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.serialNumber={ inputType:"button",value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text() };
		value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text() };
		value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text() };
		value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
		value.positionId={ inputType:"select_box", value: xmSelect.get("#positionId",true).getValue("value") ,fillBy:["position"] ,label:xmSelect.get("#positionId",true).getValue("nameStr") };
		value.sourceId={ inputType:"select_box", value: xmSelect.get("#sourceId",true).getValue("value") ,fillBy:["source"]  , label:xmSelect.get("#sourceId",true).getValue("nameStr") };
		value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
		value.assetNotes={ inputType:"button",value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.maintainerId={ inputType:"select_box", value: xmSelect.get("#maintainerId",true).getValue("value") ,fillBy:["maintnainer"]  ,label:xmSelect.get("#maintainerId",true).getValue("nameStr") };
		value.equipmentIp={ inputType:"button",value: $("#equipmentIp").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.manageIp={ inputType:"button",value: $("#manageIp").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.equipmentLabel={ inputType:"button",value: $("#equipmentLabel").val()};
		value.equipmentEnvironmentCode={ inputType:"select_box", value: getSelectedValue("#equipmentEnvironmentCode","value") ,fillBy:["equipmentEnvironment"]  , label:getSelectedValue("#equipmentEnvironmentCode","nameStr") };

		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value)) return;
		}

		var ps={searchField: "$composite", searchValue: JSON.stringify(value)};

		// if(CATEGORY_ID&&CATEGORY_ID.length>0){
		// 	ps.categoryId=CATEGORY_ID;
		// }

		var categoryValue=categorySelect.getValue();
		if(categoryValue&&categoryValue.length>0){
			ps.categoryId=categoryValue[0].id;
		}
		ps.ownerCode=OWNER_CODE;
		if(!ps.categoryId){
			ps.categoryId=CATEGORY_ID;
		}
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
			sort={ field : sortField,type : sortType} ;
		} else {
			if(sort) {
				ps.sortField=sort.field;
				ps.sortType=sort.type;
			}
		}

		if(reset) {
			table.reload(TABLE_ID, { where : ps , page:{ curr:1 } });
		} else {
			table.reload(TABLE_ID, { where : ps });
		}

	}


	/**
	 * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	 */
	function getCheckedList(field) {
		console.log("to get it ")
		var checkStatus = table.checkStatus(TABLE_ID);
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
			radio: false,
			size: "small",
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});


		//渲染 categoryId 下拉字段
		categorySelect = xmSelect.render({
			el: '#categoryId',
			prop: {
				name: 'name',
				value: 'id',
			},
			tree: {
				// showFolderIcon: true,
				show: true,
				strict: true,
				expandedKeys: [ -1],
			},
			//处理方式
			on: function(data){
				if(data.isAdd){
					var result=data.change.slice(0, 1);
					return result;
				}
			},
			//显示为text模式
			model: { label: { type: 'text' } },
			//单选模式
			radio: true,
			//选中关闭
			clickClose: true,
			height: '450px',
			data:ASSET_CATEGORY_DATA
		})
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
			radio: false,
			size: "small",
			filterable: true,
			//转换数据
			searchField: "manufacturerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].manufacturerName,value:data[i].id});
				}
				return opts;
			}
		});


		//渲染 positionId 下拉字段
		fox.renderSelectBox({
			el: "positionId",
			radio: false,
			size: "small",
			filterable: true,
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
					opts.push({name:data[i].hierarchyName,value:data[i].id});
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
		//渲染 sourceId 下拉字段
		fox.renderSelectBox({
			el: "sourceId",
			radio: false,
			size: "small",
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#purchaseDate-begin',
			trigger:"click"
		});
		laydate.render({
			elem: '#purchaseDate-end',
			trigger:"click"
		});
		//渲染 maintainerId 下拉字段
		fox.renderSelectBox({
			el: "maintainerId",
			radio: false,
			size: "small",
			filterable: true,
			//转换数据
			searchField: "maintainerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].maintainerName,value:data[i].id});
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
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
			};
			fox.chooseOrgNode(ownCompanyIdDialogOptions);
		});
		// 请选择组织节点对话框
		$("#useOrganizationId-button").click(function(){
			var useOrganizationIdDialogOptions={
				field:"useOrganizationId",
				inputEl:$("#useOrganizationId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
			};
			fox.chooseOrgNode(useOrganizationIdDialogOptions);
		});
		// 请选择人员对话框
		$("#useUserId-button").click(function(){
			var useUserIdDialogOptions={
				field:"useUserId",
				inputEl:$("#useUserId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
			};
			fox.chooseEmployee(useUserIdDialogOptions);
		});

		// 请选择人员对话框
		$("#managerId-button").click(function(){
			var managerIdDialogOptions={
				field:"managerId",
				inputEl:$("#managerId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
			};
			fox.chooseEmployee(managerIdDialogOptions);
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

			switch(obj.event){
				case 'create':
					openCreateFrom();
					break;
				case 'tool-asset-data-change':
					window.pageExt.list.assetDataChange && window.pageExt.list.assetDataChange(selected,obj);
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'refresh-data':
					refreshTableData();
					break;
				case 'forBatchApproval':
					window.pageExt.list.forBatchApproval && window.pageExt.list.forBatchApproval(selected,obj);
					break;
				case 'batchRevoke':
					window.pageExt.list.batchRevokeOperation && window.pageExt.list.batchRevokeOperation(selected,obj);
					break;
				case 'bills':
					window.pageExt.list.downBills && window.pageExt.list.downBills(selected,obj);
					break;
				case 'highExportData':
					window.pageExt.list.highExportData && window.pageExt.list.highExportData(selected,obj);
					break;
				case 'batchConfirm':
					window.pageExt.list.batchConfirm && window.pageExt.list.batchConfirm(selected,obj);
					break;
				case 'batchInsert':
					window.pageExt.list.batchInsert && window.pageExt.list.batchInsert(selected,obj);
					break;
				case 'assetLabel':
					window.pageExt.list.assetLabel && window.pageExt.list.assetLabel(selected,obj);
					break;
				case 'printPdf':
					window.pageExt.list.printPdf && window.pageExt.list.printPdf(selected,obj);
					break;
				case 'printMore':
					//更多下拉菜单
					menuSelect=selected;
					var exportArr=[];
					if(admin.checkAuth("eam_asset:label")){
						exportArr.push({"code":"labelDown","id":"3","title":   fox.translate('下载资产标签') });
					}
					if(admin.checkAuth("eam_asset:card")){
						exportArr.push({"code":"card","id":"1","title":  fox.translate('打印资产卡片') });
					}
					if(admin.checkAuth("eam_asset:print-pdf")){
						exportArr.push({"code":"labelCard","id":"2","title":  fox.translate('打印资产标签') });
					}

					dropdown.render({
						elem: this
						,show: true //外部事件触发即显示
						,data: exportArr
						,click: function(menu, othis){
							window.pageExt.list.moreAction && window.pageExt.list.moreAction(menu,menuSelect, othis);
						}
						,align: 'right'
						,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);'
					});
					break;
				case 'exportMore':
					menuSelect=selected;
					var exportArr=[];
					if(admin.checkAuth("eam_asset:batch-insert")){
						exportArr.push({"code":"batchInsert","id":"1","title": fox.translate('在线批量导入') });
					}

					if(admin.checkAuth("eam_asset:batch-insert")){
						exportArr.push({"code":"excelInsert","id":"1","title": fox.translate('Excel批量导入') });
					}

					//eam_asset:import
					//eam_asset:high-export-data
					if(admin.checkAuth("eam_asset:high-export-data")){
						exportArr.push({"code":"highExportData","id":"2","title":  fox.translate('资产数据导出')});
					}
					// exportArr.push({"code":"downloadAssetTpl","id":"3","title":"下载导入模版"});
					dropdown.render({
						elem: this
						,show: true //外部事件触发即显示
						,data: exportArr
						,click: function(menu, othis){
							window.pageExt.list.moreAction && window.pageExt.list.moreAction(menu,menuSelect, othis);
						}
						,align: 'right'
						,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);'
					});
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产')+"!");
				return;
			}
			//调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产')+fox.translate('吗？'), function (i) {
				top.layer.close(i);
				top.layer.load(2);
				admin.request(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
					top.layer.closeAll('loading');
					if (data.success) {
						if(window.pageExt.list.afterBatchDelete) {
							var doNext=window.pageExt.list.afterBatchDelete(data);
							if(!doNext) return;
						}
						top.layer.msg(data.message, {icon: 1, time: 500});
						refreshTableData();
					} else {
						top.layer.msg(data.message, {icon: 2, time: 1500});
					}
				});

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
			admin.putTempData('eam-asset-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产')+fox.translate('吗？'), function (i) {
					top.layer.close(i);

					top.layer.load(2);
					admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
						top.layer.closeAll('loading');
						if (data.success) {
							if(window.pageExt.list.afterSingleDelete) {
								var doNext=window.pageExt.list.afterSingleDelete(data);
								if(!doNext) return;
							}
							top.layer.msg(data.message, {icon: 1, time: 500});
							refreshTableData();
						} else {
							top.layer.msg(data.message, {icon: 2, time: 1500});
						}
					});
				});

			}

			else if (layEvent === 'asset-data-change') { // 变更
				window.pageExt.list.assetDataChange(data);
			}
			else if (layEvent === 'asset-voucher') { // 变更
				window.pageExt.list.assetVoucher(data);
			}
			else if (layEvent === 'asset-box') { // 变更
				window.pageExt.list.boxWindow(data);
			}else if(obj.event === 'ops-more'){
				//更多下拉菜单
				var operList=[];
				var operSourceList=[
					{"perm":"eam_asset:copy","id":"assetCopy","title": fox.translate('复制')},
					{"perm":"eam_asset:asset-voucher","id":"assetVoucher","title":fox.translate('凭证') },
					{"perm":"eam_asset:box","id":"assetBox","title":fox.translate('密文箱')  },
					{"perm":"eam_asset:depreciation","id":"asssetDepreciation","title":fox.translate('折旧记录')  },
					{"perm":"eam_asset:rwm","id":"rwm","title":fox.translate('二维码')  }
				];



				if(UPDATE_BTN){
					operList.push({"perm":"updateBtn","id":"updateBtn","title":fox.translate('修改')})
				}
				for(var i=0;i<operSourceList.length;i++){
					if(admin.checkAuth(operSourceList[i].perm)){
						operList.push(operSourceList[i]);
					}
				}
				if(CHANGE_QUERY_BTN){
					operList.push({"perm":"changeQueryBtn","id":"changeQueryBtn","title":fox.translate('操作明细')})
				}
				if(DELETE_BTN){
					operList.push({"perm":"deleteBtn","id":"deleteBtn","title": fox.translate('删除')})
				}
				dropdown.render({
					elem: this
					,show: true //外部事件触发即显示
					,data: operList
					,click: function(menu, othis){
						if(menu.id=="updateBtn"||menu.id=="changeQueryBtn"||menu.id=="deleteBtn"){
							console.log("continue")
						}else{
							if(menu.perm && !admin.checkAuth(menu.perm)) {
								top.layer.msg(fox.translate('缺少操作权限'), {icon: 2, time: 1500});
								return;
							}
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
		var queryString="?ownerCode="+OWNER_CODE+"&pageType="+PAGE_TYPE+"&categoryCode="+CATEGORY_CODE;
		if(data && data.id){
			queryString=queryString+"&" + 'id=' + data.id;
		}
		admin.putTempData('eam-asset-form-data', data);
		var area=admin.getTempData('eam-asset-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('资产');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-asset-form-data-win",
			content: '/business/eam/asset/asset_info_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('eam-asset-form-data-popup-index', index);
	};



	window.module={
		showEditForm:showEditForm,
		refreshTableData: refreshTableData,
		getCheckedList: getCheckedList
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
