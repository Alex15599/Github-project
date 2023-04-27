/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:29
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-eam/eam-asset";
    const selectmoduleURL="/service-eam/eam-asset-selected-data";
    var dataTable=null;
    var sort=null;
    var assetListColumn;
    var searchContent_categoryId;
    var selectedListAction;
    var billdata;
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {

        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
        assetListColumn=layui.assetListColumn;
        selectedListAction=admin.getTempData('eam-asset-select-action'+ASSET_SELECTED_CODE);
        billdata=admin.getTempData('eam-asset-select-data'+ASSET_SELECTED_CODE);
        console.log("##asset baseinfo billdata:",billdata);

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

            var ps={};
            var contitions={};
            console.log("billdata",billdata);
            contitions.status={ value: "complete", label:"完成"};

            if(window.pageExt.list.beforeQuery){
                window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
            }
            if(Object.keys(contitions).length>0) {
                ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};

            }
            ps.assetSelectedCode=ASSET_SELECTED_CODE;
            ps.assetBusinessType=billdata.assetBusinessType;
            ps.assetOwnerId=billdata.assetOwnerId;
            if(CATEGORY_ID){
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
            console.log("full-",h+50,ps)

            var COL_ALL_DATA= assetListColumn.getColumnList(templet);
            var COL_DATA=[{ fixed: 'left',type: 'numbers' },{ fixed: 'left',type:'checkbox' }]
            for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
                if(ATTRIBUTE_LIST_DATA[i].attribute&&ATTRIBUTE_LIST_DATA[i].attribute.code){
                    var e=COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code];
                    e.title=ATTRIBUTE_LIST_DATA[i].attribute.label;
                    COL_DATA.push(e)
                }
            }
            COL_DATA.push({ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 });

            dataTable=fox.renderTable({
                elem: '#data-table',
                toolbar: '#toolbarTemplate',
                defaultToolbar: ['filter',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-list-by-select',
                height: 'full-'+(h+120),
                limit: 50,
                limits:['50','100','500','1000','5000'],
                where: ps,
                cols: [COL_DATA],
                done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
                footer : {
                }
            });
            //绑定排序事件
            table.on('sort(data-table)', function(obj){
                refreshTableData(obj.field,obj.type);
            });
        }
        setTimeout(renderTableInternal,1);
    };

    /**
     * 刷新表格数据
     */
    function refreshTableData(sortField,sortType,reset) {
        var value = {};

        value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };

        //value.businessCode={ inputType:"button",value: $("#businessCode").val()};
        value.status={ inputType:"select_box", value:"complete", label:"完成" };
        value.assetCode={ inputType:"button",value: $("#assetCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
      //  value.assetStatus={ inputType:"select_box", value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr")};
        value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        value.manufacturerId={ inputType:"select_box", value: xmSelect.get("#manufacturerId",true).getValue("value") ,fillBy:["manufacturer"]  , label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
        value.model={ inputType:"button",value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
     //   value.serialNumber={ inputType:"button",value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text() };
        value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text() };
        value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text() };
      //  value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
        value.positionId={ inputType:"select_box", value: xmSelect.get("#positionId",true).getValue("value") ,fillBy:["position"]  ,  label:xmSelect.get("#positionId",true).getValue("nameStr") };
        value.sourceId={ inputType:"select_box", value: xmSelect.get("#sourceId",true).getValue("value") ,fillBy:["source"] , label:xmSelect.get("#sourceId",true).getValue("nameStr") };
        value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
        value.assetNotes={ inputType:"button",value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        value.maintainerId={ inputType:"select_box", value: xmSelect.get("#maintainerId",true).getValue("value") ,fillBy:["maintnainer"]  , label:xmSelect.get("#maintainerId",true).getValue("nameStr") };


        value.status={ value:"complete", label:"完成"};
        var ps={searchField:"$composite"};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
        }


        if(searchContent_categoryId){
            if(value.categoryId){
                delete value.categoryId ;
            }
            ps.categoryId=searchContent_categoryId;
        }
        ps.assetSelectedCode=ASSET_SELECTED_CODE;
        ps.assetBusinessType=billdata.assetBusinessType;
        ps.assetOwnerId=billdata.assetOwnerId;
        ps.searchValue=JSON.stringify(value);
        ps.ownerCode=OWNER_CODE;

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
        for(var i=0;i<data.length;i++) {
            if(field){
                data[i]=data[i][field];
            }else{
                data[i]=data[i];
            }
        }
        return data;
    }



    function searchCategory(categoryId){
        searchContent_categoryId=categoryId;
        refreshTableData()
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

        //渲染 assetStatus 下拉字段
        // fox.renderSelectBox({
        //     el: "assetStatus",
        //     radio: false,
        //     size: "small",
        //     filterable: false,
        //     //转换数据
        //     transform:function(data) {
        //         //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
        //         var opts=[];
        //         if(!data) return opts;
        //         for (var i = 0; i < data.length; i++) {
        //             opts.push({name:data[i].text,value:data[i].code});
        //         }
        //         return opts;
        //     }
        // });

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
            fox.switchSearchRow(2,function (ex){
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
        // $("#useUserId-button").click(function(){
        //     var useUserIdDialogOptions={
        //         field:"useUserId",
        //         inputEl:$("#useUserId"),
        //         buttonEl:$(this),
        //         single:true,
        //         //限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
        //         root: "",
        //         targetType:"emp",
        //         prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
        //         callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
        //     };
        //     fox.chooseEmployee(useUserIdDialogOptions);
        // });

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


    function stockCollect(obj){

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


            if (layEvent === 'stockCollection') { // 修改
                layer.open({
                    id:1,
                    type:1,
                    title:"请输入领用数量",
                    style:"width:50%:height:auto;",
                    content:"<div style='display:flex;justify-content:center;'><input id='area' type='number' style='width:100%;height:30px;margin-left:5px;margin-right:5px'></input></div>",
                    btn:['保存','取消'],
                    yes:function(index,layero){
                        var closeContent=top.$("#area").val()||$("#area").val();
                        if(closeContent){
                            var param={};
                            param=billdata;
                            param.assetSelectedCode=ASSET_SELECTED_CODE;
                            param.sourceAssetId=data.id;
                            param.cnt=closeContent;
                            var api="/service-eam/eam-asset-stock-collection/stock-collection";
                            admin.post(api, param, function (data) {
                                if (data.success) {
                                    var index=admin.getTempData('eam-asset-select-data-popup-index');
                                    admin.finishPopupCenter(index);
                                } else {
                                    layer.msg(data.message, {icon: 2, time: 1500});
                                }
                            }, {delayLoading:1000,elms:[]});

                        }else{
                            alert("请输入领用数量");
                        }
                    },
                    no:function(index,layer){
                        layer.close(index);
                    }


                })

            } else if (layEvent === 'stockDistribute') { // 查看
                layer.open({
                    id:1,
                    type:1,
                    title:"请输入分配数量",
                    style:"width:50%:height:auto;",
                    content:"<div style='display:flex;justify-content:center;'><input id='area' type='number' style='width:100%;height:30px;margin-left:5px;margin-right:5px'></input></div>",
                    btn:['保存','取消'],
                    yes:function(index,layero){
                        var closeContent=top.$("#area").val()||$("#area").val();
                        if(closeContent){
                            var param={};
                            param=billdata;
                            param.assetSelectedCode=ASSET_SELECTED_CODE;
                            param.sourceAssetId=data.id;
                            param.cnt=closeContent;
                            var api="/service-eam/eam-asset-stock-collection/stock-distribute";
                            admin.post(api, param, function (data) {
                                if (data.success) {
                                    var index=admin.getTempData('eam-asset-select-data-popup-index');
                                    admin.finishPopupCenter(index);
                                } else {
                                    layer.msg(data.message, {icon: 2, time: 1500});
                                }
                            }, {delayLoading:1000,elms:[]});

                        }else{
                            alert("请输入分配数量");
                        }
                    },
                    no:function(index,layer){
                        layer.close(index);
                    }
                })



            }

        });

    };



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

    function saveSelectData(callback){
        var postData=billdata;
        postData.assetSelectedCode=ASSET_SELECTED_CODE;
        postData.ids=getCheckedList("id");


        if(postData.ids.length==0){
            top.layer.msg("请选择资产", {icon: 2, time: 1500});
            return;
        }

        var api=selectmoduleURL+"/save-by-ids";
        admin.post(api,postData,function (r){
            if (r.success) {
                callback(postData.ids);
                layer.msg(r.message, {icon: 1, time: 500});
            } else {
                layer.msg(r.message, {icon: 2, time: 1000});
            }
        },{delayLoading:1000,elms:[]});


    }
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
        if(data && data.id) queryString="?" + 'id=' + data.id;
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
            content: '/business/eam/asset/asset_form.html' + queryString,
            finish: function () {
                refreshTableData();
            }
        });
        admin.putTempData('eam-asset-form-data-popup-index', index);
    };

    window.module={
        searchCategory:searchCategory,
        refreshTableData: refreshTableData,
        getCheckedList: getCheckedList,
        // stockCollect:stockCollect,
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