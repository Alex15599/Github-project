/**
 * 主机 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-18 11:19:29
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	
	//模块基础路径
	const moduleURL="/service-ops/ops-host";
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
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'systemId', align:"left",fixed:false,  hide:false, sort: false  , title: fox.translate('信息系统'), templet: function (d) { return templet('systemId' ,fox.joinLabel(d.infoSystem,"name",',','','systemId'),d);}}
					,{ field: 'hostType', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('主机类型'), templet:function (d){ return templet('hostType',fox.getDictText(SELECT_HOSTTYPE_DATA,d.hostType,'','hostType'),d);}}
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('主机状态'), templet:function (d){ return templet('status',fox.getEnumText(RADIO_STATUS_DATA,d.status,'','status'),d);}}
					,{ field: 'hostName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('名称') , templet: function (d) { return templet('hostName',d.hostName,d);}  }
					,{ field: 'hostIp', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('物理IP') , templet: function (d) { return templet('hostIp',d.hostIp,d);}  }
					,{ field: 'hostVip', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('虚拟VIP') , templet: function (d) { return templet('hostVip',d.hostVip,d);}  }
					,{ field: 'hostIpv6', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('IPV6') , templet: function (d) { return templet('hostIpv6',d.hostIpv6,d);}  }
					,{ field: 'environment', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('所在环境'), templet:function (d){ return templet('environment',fox.getDictText(SELECT_ENVIRONMENT_DATA,d.environment,'','environment'),d);}}
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: false  , title: fox.translate('所在位置'), templet: function (d) { return templet('positionId' ,fox.joinLabel(d.position,"name",',','','positionId'),d);}}
					,{ field: 'monitorStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('监控状态'), templet:function (d){ return templet('monitorStatus',fox.getEnumText(RADIO_MONITORSTATUS_DATA,d.monitorStatus,'','monitorStatus'),d);}}
					,{ field: 'directorUsername', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('负责人') , templet: function (d) { return templet('directorUsername',d.directorUsername,d);}  }
					,{ field: 'hostMemory', align:"right",fixed:false,  hide:true, sort: true  , title: fox.translate('内存') , templet: function (d) { return templet('hostMemory',d.hostMemory,d);}  }
					,{ field: 'hostCpu', align:"right",fixed:false,  hide:true, sort: true  , title: fox.translate('CPU') , templet: function (d) { return templet('hostCpu',d.hostCpu,d);}  }
					,{ field: 'hostConf', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('其他配置') , templet: function (d) { return templet('hostConf',d.hostConf,d);}  }
					,{ field: 'portList', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('端口列表') , templet: function (d) { return templet('portList',d.portList,d);}  }
					,{ field: 'userOsAdmin', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('系统管理员') , templet: function (d) { return templet('userOsAdmin',d.userOsAdmin,d);}  }
					,{ field: 'userDbAdmin', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('数据库管理员') , templet: function (d) { return templet('userDbAdmin',d.userDbAdmin,d);}  }
					,{ field: 'userDbUsed', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('数据库使用用户') , templet: function (d) { return templet('userDbUsed',d.userDbUsed,d);}  }
					,{ field: 'userAppUsed', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('应用使用用户') , templet: function (d) { return templet('userAppUsed',d.userAppUsed,d);}  }
					,{ field: 'userOpsOper', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('运维操作用户') , templet: function (d) { return templet('userOpsOper',d.userOpsOper,d);}  }
					,{ field: 'userOther', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('其他用户') , templet: function (d) { return templet('userOther',d.userOther,d);}  }
					,{ field: 'passwordStrategyId', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('改密策略'), templet:function (d){ return templet('passwordStrategyId',fox.getDictText(SELECT_PASSWORDSTRATEGYID_DATA,d.passwordStrategyId,'','passwordStrategyId'),d);}}
					,{ field: 'hostBackupMethod', align:"left",fixed:false,  hide:false, sort: false  , title: fox.translate('备份方式'), templet: function (d) { return templet('hostBackupMethod' ,fox.joinLabel(d.backupMethod,"label",',','','hostBackupMethod'),d);}}
					,{ field: 'hostBackupInfo', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('备份情况') , templet: function (d) { return templet('hostBackupInfo',d.hostBackupInfo,d);}  }
					,{ field: 'offlineTime', align:"right", fixed:false, hide:true, sort: true   ,title: fox.translate('下线时间') ,templet: function (d) { return templet('offlineTime',fox.dateFormat(d.offlineTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'onlineTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('上线时间') ,templet: function (d) { return templet('onlineTime',fox.dateFormat(d.onlineTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'labels', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('标签') , templet: function (d) { return templet('labels',d.labels,d);}  }
					,{ field: 'hostNotes', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('备注') , templet: function (d) { return templet('hostNotes',d.hostNotes,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:true, sort: true   ,title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'hostDbIds', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('数据库'), templet: function (d) { return templet('hostDbIds' ,fox.joinLabel(d.hostDbList,"name",',','','hostDbIds'),d);}}
					,{ field: 'hostMiddlewareIds', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('中间件'), templet: function (d) { return templet('hostMiddlewareIds' ,fox.joinLabel(d.hostMiddlewareList,"name",',','','hostMiddlewareIds'),d);}}
					,{ field: 'hostOsIds', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('操作系统'), templet: function (d) { return templet('hostOsIds' ,fox.joinLabel(d.hostOsList,"name",',','','hostOsIds'),d);}}
					,{ field: 'voucherIds', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('用户凭证'), templet: function (d) { return templet('voucherIds' ,fox.joinLabel(d.voucherList,"voucher",',','','voucherIds'),d);}}
					,{ field: fox.translate('空白列','','cmp:table'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作','','cmp:table'), width: 250 }
				]],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
				footer : {
					exportExcel : false ,
					importExcel :  admin.checkAuth(AUTH_PREFIX+":import")?{
						params : {} ,
						callback : function(r) {
							if(r.success) {
								layer.msg(fox.translate('数据导入成功','','cmp:table')+"!");
							} else {
								layer.msg(fox.translate('数据导入失败','','cmp:table')+"!");
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
		value.systemId={ inputType:"select_box", value: getSelectedValue("#systemId","value") ,fillBy:["infoSystem"]  , label:getSelectedValue("#systemId","nameStr") };
		value.status={ inputType:"radio_box", value: getSelectedValue("#status","value"), label:getSelectedValue("#status","nameStr") };
		value.hostName={ inputType:"button",value: $("#hostName").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.hostIp={ inputType:"button",value: $("#hostIp").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.hostVip={ inputType:"button",value: $("#hostVip").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.environment={ inputType:"select_box", value: getSelectedValue("#environment","value"), label:getSelectedValue("#environment","nameStr") };
		value.positionId={ inputType:"select_box", value: getSelectedValue("#positionId","value") ,fillBy:["position"]  , label:getSelectedValue("#positionId","nameStr") };
		value.labels={ inputType:"button",value: $("#labels").val()};
		value.hostNotes={ inputType:"button",value: $("#hostNotes").val()};
		value.hostDbIds={ inputType:"select_box", value: getSelectedValue("#hostDbIds","value") ,fillBy:["hostDbList"]  , label:getSelectedValue("#hostDbIds","nameStr") };
		value.hostMiddlewareIds={ inputType:"select_box", value: getSelectedValue("#hostMiddlewareIds","value") ,fillBy:["hostMiddlewareList"]  , label:getSelectedValue("#hostMiddlewareIds","nameStr") };
		value.hostOsIds={ inputType:"select_box", value: getSelectedValue("#hostOsIds","value") ,fillBy:["hostOsList"]  , label:getSelectedValue("#hostOsIds","nameStr") };
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

		fox.switchSearchRow(2);

		//渲染 systemId 下拉字段
		fox.renderSelectBox({
			el: "systemId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("systemId",data.arr,data.change,data.isAdd);
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
					opts.push({data:data[i],name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 status 搜索框
		fox.renderSelectBox({
			el: "status",
			size: "small",
			radio: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("status",data.arr,data.change,data.isAdd);
				},1);
			},
			//toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
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
		//渲染 environment 下拉字段
		fox.renderSelectBox({
			el: "environment",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("environment",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].text,value:data[i].code});
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
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 hostDbIds 下拉字段
		fox.renderSelectBox({
			el: "hostDbIds",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("hostDbIds",data.arr,data.change,data.isAdd);
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
					opts.push({data:data[i],name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 hostMiddlewareIds 下拉字段
		fox.renderSelectBox({
			el: "hostMiddlewareIds",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("hostMiddlewareIds",data.arr,data.change,data.isAdd);
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
					opts.push({data:data[i],name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 hostOsIds 下拉字段
		fox.renderSelectBox({
			el: "hostOsIds",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("hostOsIds",data.arr,data.change,data.isAdd);
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
					opts.push({data:data[i],name:data[i].name,value:data[i].id});
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
			fox.switchSearchRow(2,function (ex){
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
					admin.putTempData('ops-host-form-data', {});
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'tool-export-host':
					window.pageExt.list.exportHost && window.pageExt.list.exportHost(selected,obj);
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
			admin.putTempData('ops-host-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的'+'主机'+"!"));
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的'+'主机'+'吗？'), function (i) {
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

			admin.putTempData('ops-host-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('ops-host-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 fox.showMessage(data);
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('ops-host-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此'+'主机'+'吗？'), function (i) {
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
			else if (layEvent === 'open-host-voucher-window') { // 凭证
				window.pageExt.list.openHostVoucherWindow(data,this);
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
		var action=admin.getTempData('ops-host-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('ops-host-form-data', data);
		var area=admin.getTempData('ops-host-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('主机');
		if(action=="create") title=fox.translate('添加','','cmp:table')+title;
		else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
		else if(action=="view") title=fox.translate('查看','','cmp:table')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["80%",height+"px"],
			type: 2,
			id:"ops-host-form-data-win",
			content: '/business/ops/host/host_form.html' + (queryString?("?"+queryString):""),
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