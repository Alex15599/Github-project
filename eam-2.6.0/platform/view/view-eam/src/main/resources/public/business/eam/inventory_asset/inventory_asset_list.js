/**
 * 盘点明细 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-05 11:04:54
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-inventory-asset";
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

			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}

			var templet2=function(field,value,row) {
				console.log(field,value)
				if(value==null) return "";
				return value;
			}

			var templetPic=function(field,value,row) {
				console.log(field,value)
				if(value==null) return "";
				var html="";
				if(value.length>5){
					var ids=value.split(',')
					for(var i=0;i<ids.length;i++){
						var id=ids[i];
						var e="<img style=\"height:100%;\" filetype=\"image/png\" onClick=\"window.previewImage(this)\" src=\"/service-storage/sys-file/image?id="+id+"\"> ";
						html=html+e;
					}
				}
				return html;
			}

			var dataUrl=moduleURL +'/query-paged-list';
			if(INVENTORY_MODE){
				if(INVENTORY_MODE=="employ_inventory_mode"){
					dataUrl="/service-eam/eam-inventory/query-my-asset-by-employee-mode-paged-list"
				}
			}
			var h=$(".search-bar").height();
			var tableConfig={
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url:dataUrl,
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
				//	,{ field: 'inventoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('盘点') , templet: function (d) { return templet('inventoryId',d.inventoryId,d);}  }
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}}
					,{ field: 'operEmplId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('盘点人员') , templet: function (d) { return templet('operEmplId',fox.getProperty(d,["operater","name"]),d);} }
					,{ field: 'operDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('操作时间') ,templet: function (d) { return templet('operDate',fox.dateFormat(d.operDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('盘点备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
					,{ field: 'assetId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产') , templet: function (d) { return templet('assetId',d.assetId,d);}  }
					,{ field: 'pictureId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('盘点图片') , templet: function (d) { return templetPic('pictureId',d.pictureId,d);}  }
					,{ field: 'assetCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产编号') , templet: function (d) { return templet('assetCode',d.asset.assetCode,d);}}
					,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产分类'), templet: function (d) { return templet('categoryId',fox.joinLabel(d.asset.category,"name"),d);}}
					,{ field: 'assetStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产状态'), templet:function (d){ return templet('assetStatus',fox.getEnumText(SELECT_ASSETSTATUS_DATA,d.asset.assetStatus),d);}}
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('名称') , templet: function (d) { return templet('name',d.asset.name,d);}  }
					,{ field: 'model', align:"left",fixed:false, hide:false, sort: true, title: fox.translate('规格型号') , templet: function (d) { return templet('model',d.asset.model,d);}  }
					,{ field: 'serialNumber', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('序列号') , templet: function (d) { return templet('serialNumber',d.asset.serialNumber,d);}  }
					,{ field: 'ownCompanyId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所属公司') , templet: function (d) { return templet('ownCompanyId',fox.getProperty(d.asset,["ownerCompany","fullName"]),d);} }
					,{ field: 'managerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('管理人员') , templet: function (d) { return templet('managerId',fox.getProperty(d.asset,["manager","name"]),d);} }
					,{field: 'useOrganizationId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用公司/部门') , templet: function (d) { return templet('useOrganizationId',fox.getProperty(d.asset,["useOrganization","fullName"]),d);} }
					, { field: 'useUserId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用人员') , templet: function (d) { return templet('useUserId',fox.getProperty(d.asset,["useUser","name"]),d);} }
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('位置'), templet: function (d) { return templet('positionId',fox.joinLabel(d.asset.position,"hierarchyName"),d);}}
					, { field: 'positionDetail', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('详细位置') , templet: function (d) { return templet('positionDetail',d.asset.positionDetail,d);}  }
				//	,{ field: 'assetNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产备注') , templet: function (d) { return templet('assetNotes',d.asset.assetNotes,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
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
							// 是否执行后续逻辑：错误提示
							return false;
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
		value.status={ inputType:"select_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr") };
		value.notes={ inputType:"button",value: $("#notes").val()};
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
			radio: false,
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

	}

	function assetInsertForm(data) {
		var timestamp = Date.parse(new Date());
		var OWNER_CODE="asset";
		var PAGE_TYPE="base";
		var CATEGORY_CODE="asset";
		var action=admin.getTempData('eam-asset-form-data-form-action');
		var TRACE_ID=timestamp;
		var INTERNAL_CONTROL_LABEL="inventory_label";
		var queryString="?internalControlLabel="+INTERNAL_CONTROL_LABEL+"&traceId="+TRACE_ID+"&ownerCode="+OWNER_CODE+"&pageType="+PAGE_TYPE+"&categoryCode="+CATEGORY_CODE;
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

		console.log("assetInsertForm action:"+action);
		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-asset-form-data-win",
			content: '/business/eam/asset/asset_info_form.html' + queryString,
			finish: function () {
				var resData=admin.getTempData('asset-data-'+TRACE_ID);
				console.log("resData",resData);
				if(action=="create"){
					if(resData&&resData.id){
						console.log("insert inventoryData")
						admin.post("/service-eam/eam-inventory/asset-plus-data", { inventoryId: INVENTORY_ID,assetId:resData.id},function (resultData) {
							if (resultData.success) {
								refreshTableData();
							} else {
								top.layer.msg(resultData.message, {icon: 2, time: 1500});
							}
						});
					}
				}else{
					refreshTableData();
				}
			}
		});
		admin.putTempData('eam-asset-form-data-popup-index', index);
	};

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
				case 'download-asset':
					window.pageExt.list.downloadAsset(selected);
					break;
				case 'asset-add':
					window.pageExt.list.assetAdd(selected);
					break;
				case 'asset-plus':
					console.log("asset-plus start");
					var data={};
					admin.putTempData('eam-asset-form-data-form-action', "create",true);
					assetInsertForm(data);
					break;
				case 'other':
					break;
			};
		});

		/**
		 * 打开编辑窗口
		 */



		//添加按钮点击事件
        function openCreateFrom() {
        	//设置新增是初始化数据
        	var data={};
			admin.putTempData('eam-inventory-asset-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('盘点明细')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('盘点明细')+fox.translate('吗？'), function (i) {
                admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
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

			admin.putTempData('eam-inventory-asset-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-inventory-asset-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-inventory-asset-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'modify-asset') { // 查

				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request("/service-eam/eam-asset/get-by-id", { id : data.assetId }, function (assetResult) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(assetResult.success) {
						admin.putTempData('eam-asset-form-data-form-action', "edit",true);

						assetInsertForm(assetResult.data);

					} else {
						layer.msg(assetResult.message, {icon: 1, time: 1500});
					}
				});


			}else if (layEvent === 'detail') { // 查

				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request("/service-eam/eam-asset/get-by-id", { id : data.assetId }, function (assetResult) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(assetResult.success) {
						var assetData=assetResult.data;
						admin.putTempData('eam-asset-form-data-form-action', "view",true);
						var queryString="?pageType=base";
						if(assetData && assetData.id) queryString=queryString+"&" + 'id=' + assetData.id;
						admin.putTempData('eam-asset-form-data', assetData);
						var area=admin.getTempData('eam-asset-form-area');
						var height= (area && area.height) ? area.height : ($(window).height()*0.6);
						var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
						var title = fox.translate('查看资产');

						var index=admin.popupCenter({
							title: title,
							resize: false,
							offset: [2,null],
							area: ["80%",height+"px"],
							type: 2,
							id:"eam-asset-form-data-win",
							content: '/business/eam/asset/asset_info_form.html' + queryString,
							finish: function () {

							}
						});
						admin.putTempData('eam-asset-form-data-popup-index', index);

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
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('盘点明细')+fox.translate('吗？'), function (i) {
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
		var action=admin.getTempData('eam-inventory-asset-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('eam-inventory-asset-form-data', data);
		var area=admin.getTempData('eam-inventory-asset-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('盘点明细');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-inventory-asset-form-data-win",
			content: '/business/eam/inventory_asset/inventory_asset_form.html' + (queryString?("?"+queryString):""),
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