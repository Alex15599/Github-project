/**
 * 数据变更 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:31
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset-data-change";
	var dataTable=null;
	var sort=null;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
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
		function renderTableInternal() {

			var ps={searchField: "$composite"};
			var contitions={};

			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			}

			if(PAGE_TYPE&&PAGE_TYPE=="approval"){
				ps.status='approval';

			}
			ps.pageType=PAGE_TYPE;
			ps.searchValue=JSON.stringify(contitions);
			ps.changeType=CHANGE_TYPE;
			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();

			var COL_ALL_DATA= assetListColumn.getColumnList(templet);

			var COL_DATA=[
				{ fixed: 'left',type: 'numbers' },
				{ fixed: 'left',type:'checkbox'},
				{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  },
				{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('办理状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}},
				{ field: 'businessName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务名称'), templet:function (d){ return templet('businessName',d.businessName,d);}  },
				{ field: 'changeDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('变更日期'), templet: function (d) { return templet('changeDate',fox.dateFormat(d.changeDate,"yyyy-MM-dd"),d); }},
				{ field: 'originatorId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',fox.getProperty(d,["originator","name"]),d);}}
			];
			for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
				if(ATTRIBUTE_LIST_DATA[i].attribute&&ATTRIBUTE_LIST_DATA[i].attribute.code){
					var code=ATTRIBUTE_LIST_DATA[i].attribute.code;
					var e=COL_ALL_DATA[code];
					e.title=ATTRIBUTE_LIST_DATA[i].attribute.label;
					COL_DATA.push(e);
				}
			}

			if(APPROVAL_REQUIRED){
			    var ap={ field: 'chsApprovalOpinion', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('审批意见') , templet: function (d) { return templet('chsApprovalOpinion',d.chsApprovalOpinion,d);}  };
				COL_DATA.push(ap);
			}

			var oper={ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 360 };
			COL_DATA.push(oper)

			var responseData=[];
			var tableConfig={
				elem: '#'+TABLE_ID,
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [COL_DATA],
				done: function (data) {window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(responseData); },
				parseData:function(res){
					if (!res.success) {
						alert(res.message);
						return null;
					}
					var data=[];
					for(var i=0;i<res.data.list.length;i++){
						if(res.data.list[i].changeData){
							var d=res.data.list[i].changeData;
							d.status=res.data.list[i].status;
							d.changeDate=res.data.list[i].changeDate;
							d.originator=res.data.list[i].originator;
							d.businessName=res.data.list[i].businessName;
							if(res.data.list[i].changeInstanceId)
								d.chsChangeInstanceId=res.data.list[i].changeInstanceId;
							if(res.data.list[i].approvalOpinion)
								d.chsApprovalOpinion=res.data.list[i].approvalOpinion;

							data.push(d);
						}
					}
					responseData=data;
					return {
						"code": res.code == "00" ? 0 : -1, //解析接口状态
						"msg": res.message, //解析提示文本
						"count": res.data.totalRowCount, //解析数据长度
						"data": data //解析数据列表
					};
				},
				footer : {

				}
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			debugger
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

		value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:""};
		value.status={ inputType:"select_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
		value.changeDate={ inputType:"date_input", begin: $("#changeDate-begin").val(), end: $("#changeDate-end").val() };
		value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:""};
		var ps={searchField:"$composite"};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
		}
		ps.changeType=CHANGE_TYPE;

		if(PAGE_TYPE&&PAGE_TYPE=="approval"){
			delete value.status ;
			ps.status='approval';
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


		ps.pageType=PAGE_TYPE;

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
		laydate.render({
			elem: '#changeDate-begin',
			trigger:"click"
		});
		laydate.render({
			elem: '#changeDate-end',
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
			fox.switchSearchRow(1,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
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
				case 'agree':
					window.pageExt.list.agreeData(selected,obj);
					break;
				case 'deny':
					window.pageExt.list.denyData(selected,obj);
					break;
				case 'other':
					break;
			};
		});


		//添加按钮点击事件
        function openCreateFrom() {
        	//设置新增是初始化数据
        	var data={};
			admin.putTempData('eam-asset-data-change-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('数据变更')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('数据变更')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('eam-asset-data-change-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-data-change-form-data-form-action', "edit",true);
						data.data.changeData.status=data.data.status;
						data.data.changeData.businessCode=data.data.businessCode;
						data.data.changeData.businessName=data.data.businessName;

						if(data.data.changeDate)
							data.data.changeData.changeDate=data.data.changeDate;
						if(data.data.changeNotes)
							data.data.changeData.changeNotes=data.data.changeNotes;
						if(data.data.businessName)
							data.data.changeData.businessName=data.data.businessName;
						showEditForm(data.data.changeData);
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
						admin.putTempData('eam-asset-data-change-form-data-form-action', "view",true);
						data.data.changeData.status=data.data.status;
						data.data.changeData.businessCode=data.data.businessCode;
						if(data.data.changeDate)
							data.data.changeData.changeDate=data.data.changeDate;
						if(data.data.changeNotes)
							data.data.changeData.changeNotes=data.data.changeNotes;
						if(data.data.businessName)
							data.data.changeData.businessName=data.data.businessName;
						showEditForm(data.data.changeData);
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

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('数据变更')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'agree') { // 同意
				window.pageExt.list.agreeData(data);
			}
			else if (layEvent === 'deny') { // 拒绝
				window.pageExt.list.denyData(data);
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
		var action=admin.getTempData('eam-asset-data-change-form-data-form-action');
		var queryString="";

		if(data && data.id) {
			queryString="?" + 'id=' + data.id+"&changeType="+CHANGE_TYPE;
		}else{
			queryString="?changeType="+CHANGE_TYPE;
		}
		queryString=queryString+"&pageType="+PAGE_TYPE;

		admin.putTempData('eam-asset-data-change-form-data', data);
		var area=admin.getTempData('eam-asset-data-change-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('数据变更');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"eam-asset-data-change-form-data-win",
			content: '/business/eam/asset_data_change/asset_data_change_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('eam-asset-data-change-form-data-popup-index', index);
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
