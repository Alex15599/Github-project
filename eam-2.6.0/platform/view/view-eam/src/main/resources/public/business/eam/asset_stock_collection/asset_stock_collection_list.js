/**
 * 资产领用 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-29 13:22:25
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset-stock-collection";
	var dataTable=null;
	var sort=null;
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {

		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

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
		function renderTableInternal() {

			var ps={searchField: "$composite"};
			var contitions={};

			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			}
			ps.searchValue=JSON.stringify(contitions);
			ps.ownerCode=OWNER_CODE;
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
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('办理状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}}
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'useOrganizationId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('领用后公司/部门') , templet: function (d) { return templet('useOrganizationId',fox.getProperty(d,["useOrganization","fullName"]),d);} }
					,{ field: 'useUserId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用人员') , templet: function (d) { return templet('useUserId',fox.getProperty(d,["useUser","name"]),d);} }
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('存放位置'), templet: function (d) { return templet('positionId' ,fox.joinLabel(d.position,"name"),d);}}
					,{ field: 'positionDetail', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('详细位置') , templet: function (d) { return templet('positionDetail',d.positionDetail,d);}  }
					,{ field: 'collectionDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('领用日期') ,templet: function (d) { return templet('collectionDate',fox.dateFormat(d.collectionDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'content', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('领用说明') , templet: function (d) { return templet('content',d.content,d);}  }
					// ,{ field: 'originatorId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',fox.getProperty(d,["originator","name"]),d);} }
					,{ field: 'businessDate', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('业务日期') ,templet: function (d) { return templet('businessDate',fox.dateFormat(d.businessDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'selectedCode', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('选择数据') , templet: function (d) { return templet('selectedCode',d.selectedCode,d);}  }
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 350 }
				]],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
				footer : {
					exportExcel : admin.checkAuth(AUTH_PREFIX+":export"),
					importExcel : admin.checkAuth(AUTH_PREFIX+":import")?{
						params : {} ,
						callback : function(r) {
							if(r.success) {
								layer.msg(fox.translate('数据导入成功')+"!");
							} else {
								layer.msg(fox.translate('数据导入失败')+"!");
							}
						}
					}:false
				}
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			dataTable=fox.renderTable(tableConfig);
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
				refreshTableData(obj.field,obj.type);
			});
			window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
		}
		setTimeout(renderTableInternal,1);
	};

	/**
	 * 刷新表格数据
	 */
	function refreshTableData(sortField,sortType,reset) {
		var value = {};
		value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.status={ inputType:"select_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr") };
		value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
		value.positionId={ inputType:"select_box", value: xmSelect.get("#positionId",true).getValue("value") ,fillBy:["position"]  , label:xmSelect.get("#positionId",true).getValue("nameStr") };
		value.collectionDate={ inputType:"date_input", begin: $("#collectionDate-begin").val(), end: $("#collectionDate-end").val() };
		value.content={ inputType:"button",value: $("#content").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
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
			}
		}
		ps.ownerCode=OWNER_CODE;
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

		fox.switchSearchRow(2);

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
		//渲染 positionId 下拉字段
		fox.renderSelectBox({
			el: "positionId",
			radio: false,
			size: "small",
			filterable: true,
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
		laydate.render({
			elem: '#collectionDate-begin',
			trigger:"click"
		});
		laydate.render({
			elem: '#collectionDate-end',
			trigger:"click"
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
			fox.switchSearchRow(2,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
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
			admin.putTempData('eam-asset-stock-collection-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产领用')+"!");
				return;
			}
			//调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产领用')+fox.translate('吗？'), function (i) {
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

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('eam-asset-stock-collection-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-stock-collection-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				//延迟显示加载动画，避免界面闪动
				admin.putTempData('eam-asset-stock-collection-form-data-form-action', "view",true);
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-stock-collection-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产领用')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'for-approval') { // 送审
				window.pageExt.list.forApproval(data);
			}
			else if (layEvent === 'confirm-data') { // 确认
				window.pageExt.list.confirmData(data);
			}
			else if (layEvent === 'revoke-data') { // 撤销
				window.pageExt.list.revokeData(data);
			}
			else if (layEvent === 'download-bill') { // 单据
				window.pageExt.list.downloadBill(data);
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
		var action=admin.getTempData('eam-asset-stock-collection-form-data-form-action');
		var queryString="";
		if(data && data.id) {
			queryString=queryString+"&id=" + data.id;
		}
		admin.putTempData('eam-asset-stock-collection-form-data', data);
		var area=admin.getTempData('eam-asset-stock-collection-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('资产领用');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;


		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-asset-stock-collection-form-data-win",
			content: '/business/eam/asset_stock_collection/asset_stock_collection_form.html?ownerCode=' + OWNER_CODE+queryString,
			finish: function () {
				refreshTableData();
			}
		});
	};

	window.module={
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