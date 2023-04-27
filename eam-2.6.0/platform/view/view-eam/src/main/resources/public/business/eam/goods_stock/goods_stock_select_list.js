/**
 * 库存物品 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 12:25:22
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-eam/eam-goods-stock";
    var dataTable=null;


    var multiple=true;
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
          // ps.ownerType=OWNER_TYPE;
          //  ps.selectedCode=SELECTED_CODE;
            ps.operType=OPER_TYPE;
            if(OWNER_TMP_ID&&OWNER_TMP_ID.length>5){
                ps.ownerTplId=OWNER_TMP_ID;
            }

            if(CATEGORY_ID){
                ps.categoryId=CATEGORY_ID;
            }
            var templet=window.pageExt.list.templet;
            if(templet==null) {
                templet=function(field,value,row) {
                    if(value==null) return "";
                    return value;
                }
            }

            var operCol={ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 };
            var COLS=[];
            var GOODS_COLS=[
                { fixed: 'left',type: 'numbers' },
                { fixed: 'left',type:'checkbox'}
                ,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
                ,{ field: 'goodsId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('物品'), templet: function (d) { return templet('goodsId' ,fox.joinLabel(d.goods,"name"),d);}}
                ,{ field: 'goodsModel', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('物品型号'), templet: function (d) { return templet('goodsModel' ,fox.joinLabel(d.goods,"model"),d);}}
                ,{ field: 'warehouseId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('仓库'), templet: function (d) { return templet('warehouseId' ,fox.joinLabel(d.warehouse,"warehouseName"),d);}}
                ,{ field: 'stockCurNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('当前数量') , templet: function (d) { return templet('stockCurNumber',d.stockCurNumber,d);}  }
                ,{ field: 'goodsStockMax', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('库存上限'), templet: function (d) { return templet('goodsStockMax' ,fox.joinLabel(d.goods,"stockMax"),d);}}
                ,{ field: 'goodsStockMin', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('库存下限'), templet: function (d) { return templet('goodsStockMin' ,fox.joinLabel(d.goods,"stockMin"),d);}}
             //   ,{ field: 'goodsStockSecurity', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('安全库存'), templet: function (d) { return templet('goodsStockSecurity' ,fox.joinLabel(d.goods,"stockSecurity"),d);}}
                ,{ field: 'goodsUnit', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('计量单位'), templet: function (d) { return templet('goodsUnit' ,fox.joinLabel(d.goods,"unit"),d);}}
                ,{ field: 'goodsCode', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('物品编码'), templet: function (d) { return templet('goodsCode' ,fox.joinLabel(d.goods,"code"),d);}}
            //    ,{ field: 'goodsBarCode', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('物品条码'), templet: function (d) { return templet('goodsBarCode' ,fox.joinLabel(d.goods,"barCode"),d);}}
             //   ,{ field: 'goodsNotes', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('备注'), templet: function (d) { return templet('goodsNotes' ,fox.joinLabel(d.goods,"notes"),d);}}

            ];
            var GOODS_DEF_COLS=[
                { fixed: 'left',type: 'numbers' },
                { fixed: 'left',type:'checkbox'}
                ,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
                ,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('分类'), templet: function (d) { return templet('categoryId' ,fox.joinLabel(d.category,"name"),d);}}
                ,{ field: 'goodsStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('状态'), templet:function (d){ return templet('goodsStatus',fox.getEnumText(SELECT_GOODSSTATUS_DATA,d.goodsStatus),d);}}
                ,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('物品编码') , templet: function (d) { return templet('code',d.code,d);}  }
                ,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('物品名称') , templet: function (d) { return templet('name',d.name,d);}  }
                ,{ field: 'model', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('规格型号') , templet: function (d) { return templet('model',d.model,d);}  }
             //   ,{ field: 'barCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('物品条码') , templet: function (d) { return templet('barCode',d.barCode,d);}  }
                ,{ field: 'manufacturerId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('厂商'), templet: function (d) { return templet('manufacturerId' ,fox.joinLabel(d.manufacturer,"manufacturerName"),d);}}
                ,{ field: 'brandId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('品牌'), templet: function (d) { return templet('brandId' ,fox.joinLabel(d.brand,"brandName"),d);}}
             //   ,{ field: 'unitPrice', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('默认单价') , templet: function (d) { return templet('unitPrice',d.unitPrice,d);}  }
                ,{ field: 'unit', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('计量单位') , templet: function (d) { return templet('unit',d.unit,d);}  }
                ,{ field: 'stockMin', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('安全库存下限') , templet: function (d) { return templet('stockMin',d.stockMin,d);}  }
                ,{ field: 'stockMax', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('安全库存上限') , templet: function (d) { return templet('stockMax',d.stockMax,d);}  }
             //   ,{ field: 'stockSecurity', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('安全库存') , templet: function (d) { return templet('stockSecurity',d.stockSecurity,d);}  }
          //      ,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
             ]
            if(OWNER_CODE=="real_stock"||OWNER_CODE=="real_consumables"||OWNER_CODE=="real_part"){
                COLS=GOODS_COLS;
            }else if(OWNER_CODE=="goods") {
                COLS=GOODS_DEF_COLS;
            }

         //   COLS.push(operCol);
            var h=$(".search-bar").height();
            var tableConfig={
                elem: '#'+TABLE_ID,
                toolbar: '#toolbarTemplate',
                defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-list-by-select',
                height: 'full-'+(h+28),
                limit: 50,
                where: ps,
                cols: [COLS],
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
        // value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        // value.manufacturerId={ inputType:"select_box", value: getSelectedValue("#manufacturerId","value") ,fillBy:["manufacturer"]  , label:getSelectedValue("#manufacturerId","nameStr") };
        // value.batchCode={ inputType:"button",value: $("#batchCode").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        // value.warehouseId={ inputType:"select_box", value: getSelectedValue("#warehouseId","value") ,fillBy:["warehouse"]  , label:getSelectedValue("#warehouseId","nameStr") };
        // value.storageDate={ inputType:"date_input", begin: $("#storageDate-begin").val(), end: $("#storageDate-end").val() ,matchType:"auto" };


        value.goodsStatus={ inputType:"select_box", value: getSelectedValue("#goodsStatus","value"), label:getSelectedValue("#goodsStatus","nameStr") };
        value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.model={ inputType:"button",value: $("#model").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.code={ inputType:"button",value: $("#code").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.barCode={ inputType:"button",value: $("#barCode").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.manufacturerId={ inputType:"select_box", value: getSelectedValue("#manufacturerId","value") ,fillBy:["manufacturer"]  , label:getSelectedValue("#manufacturerId","nameStr") };
        value.brandId={ inputType:"select_box", value: getSelectedValue("#brandId","value") ,fillBy:["brand"]  , label:getSelectedValue("#brandId","nameStr") };
        value.warehouseId={ inputType:"select_box", value: getSelectedValue("#warehouseId","value") ,fillBy:["warehouse"]  , label:getSelectedValue("#warehouseId","nameStr") };
        value.storageDate={ inputType:"date_input", begin: $("#storageDate-begin").val(), end: $("#storageDate-end").val() ,matchType:"auto" };


        var ps={searchField:"$composite"};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
        }

        if(CATEGORY_ID&&CATEGORY_ID.length>5){
            ps.categoryId=CATEGORY_ID;
        }

        ps.ownerCode=OWNER_CODE;
     //   ps.ownerType=OWNER_TYPE;
      //  ps.selectedCode=SELECTED_CODE;
        ps.operType=OPER_TYPE;
        if(OWNER_TMP_ID&&OWNER_TMP_ID.length>5){
             ps.ownerTplId=OWNER_TMP_ID;
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



        fox.switchSearchRow(2);
        //渲染 goodsStatus 下拉字段
        fox.renderSelectBox({
            el: "goodsStatus",
            radio: true,
            size: "small",
            filterable: false,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("goodsStatus",data.arr,data.change,data.isAdd);
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

        //渲染 brandId 下拉字段
        fox.renderSelectBox({
            el: "brandId",
            radio: true,
            size: "small",
            filterable: true,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("brandId",data.arr,data.change,data.isAdd);
                },1);
            },
            paging: true,
            pageRemote: true,
            //转换数据
            searchField: "brandName", //请自行调整用于搜索的字段名称
            extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({data:data[i],name:data[i].brandName,value:data[i].id});
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
        //渲染 warehouseId 下拉字段
        fox.renderSelectBox({
            el: "warehouseId",
            radio: true,
            size: "small",
            filterable: true,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("warehouseId",data.arr,data.change,data.isAdd);
                },1);
            },
            paging: true,
            pageRemote: true,
            //转换数据
            searchField: "warehouseName", //请自行调整用于搜索的字段名称
            extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({data:data[i],name:data[i].warehouseName,value:data[i].id});
                }
                return opts;
            }
        });
        laydate.render({
            elem: '#storageDate-begin',
            trigger:"click",
            done: function(value, date, endDate) {
                setTimeout(function () {
                    window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("storageDate",value, date, endDate);
                },1);
            }
        });
        laydate.render({
            elem: '#storageDate-end',
            trigger:"click",
            done: function(value, date, endDate) {
                setTimeout(function () {
                    window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("storageDate",value, date, endDate);
                },1);
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
            admin.putTempData('eam-goods-stock-form-data-form-action', "create",true);
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
                top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('库存物品')+"!");
                return;
            }
            //调用批量删除接口
            top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('库存物品')+fox.translate('吗？'), function (i) {
                admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    if (data.success) {
                        if(window.pageExt.list.afterBatchDelete) {
                            var doNext=window.pageExt.list.afterBatchDelete(data);
                            if(!doNext) return;
                        }
                        fox.showMessage(data);
                        refreshTableData();
                    } else {
                        fox.showMessage(data);
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

            admin.putTempData('eam-goods-stock-form-data-form-action', "",true);
            if (layEvent === 'edit') { // 修改
                admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    if(data.success) {
                        admin.putTempData('eam-goods-stock-form-data-form-action', "edit",true);
                        showEditForm(data.data);
                    } else {
                        fox.showMessage(data);
                    }
                });
            } else if (layEvent === 'view') { // 查看
                admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    if(data.success) {
                        admin.putTempData('eam-goods-stock-form-data-form-action', "view",true);
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
                top.layer.confirm(fox.translate('确定删除此')+fox.translate('库存物品')+fox.translate('吗？'), function (i) {
                    top.layer.close(i);

                    top.layer.load(2);
                    admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
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
        var action=admin.getTempData('eam-goods-stock-form-data-form-action');
        var queryString="";
        if(data && data.id) queryString='id=' + data.id;
        if(window.pageExt.list.makeFormQueryString) {
            queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
        }
        admin.putTempData('eam-goods-stock-form-data', data);
        var area=admin.getTempData('eam-goods-stock-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('库存物品');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;

        admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["80%",height+"px"],
            type: 2,
            id:"eam-goods-stock-form-data-win",
            content: '/business/eam/goods_stock/goods_stock_form.html' + (queryString?("?"+queryString):""),
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

    function searchCategory(categoryId){
        CATEGORY_ID=categoryId;
        refreshTableData()
    }

    function saveSelectData(callback){
        var postData={};
        postData.operType=OPER_TYPE;
        postData.selectedCode=SELECTED_CODE;
        postData.ownerTmpId=OWNER_TMP_ID;
        postData.ids=getCheckedList("id");
        if(postData.ids.length==0){
            top.layer.msg("请选择数据", {icon: 2, time: 1500});
            return;
        }

        var api=moduleURL+"/save-by-ids";
        admin.post(api,postData,function (r){
            if (r.success) {
                callback(postData.ids);
                layer.msg(r.message, {icon: 1, time: 500});
            } else {
                layer.msg(r.message, {icon: 2, time: 1000});
            }
        },{delayLoading:1000,elms:[]});
    }


    window.module={
        searchCategory:searchCategory,
        refreshTableData: refreshTableData,
        refreshRowData: refreshRowData,
        getCheckedList: getCheckedList,
        saveSelectData:saveSelectData
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