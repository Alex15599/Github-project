/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 20:11:28
 */

function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-eam/eam-asset";
    const selectmoduleURL="/service-eam/eam-asset-selected-data";

    var dataTable=null;
    var sort=null;
    var selectedListAction;
    var billdata;
    var dataType="refresh";
    var assetListColumn;
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {

        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
        assetListColumn=layui.assetListColumn;
        selectedListAction=admin.getTempData('eam-asset-selected-action'+ASSET_SELECTED_CODE);
        billdata=admin.getTempData('eam-asset-selected-data'+ASSET_SELECTED_CODE);

        if(window.pageExt.list.beforeInit) {
            window.pageExt.list.beforeInit();
        }
        //渲染表格
        renderTable();
        //初始化搜索输入框组件
        // initSearchFields();
        //绑定搜索框事件
        bindSearchEvent();
        //绑定按钮事件
        bindButtonEvent();
        //绑定行操作按钮事件
        //bindRowOperationEvent();
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
            if(window.pageExt.list.beforeQuery){
                window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
            }
            if(Object.keys(contitions).length>0) {
                ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
            }
            var templet=window.pageExt.list.templet;
            if(templet==null) {
                templet=function(field,value,row) {
                    if(value==null) return "";
                    return value;
                }
            }

            var checkboxhide=false;
            if (selectedListAction=="view"){
                checkboxhide=true;
            }
            var h=$(".search-bar").height();

            var COL_ALL_DATA= assetListColumn.getColumnList(templet);
            var COL_DATA=[{ fixed: 'left',type: 'numbers' },{ fixed: 'left',type:'checkbox', hide:checkboxhide}];
            for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
                if(ATTRIBUTE_LIST_DATA[i].attribute&&ATTRIBUTE_LIST_DATA[i].attribute.code){
                    var e=COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code];
                    e.title=ATTRIBUTE_LIST_DATA[i].attribute.label;
                    COL_DATA.push(e)
                }
            }

            dataTable=fox.renderTable({
                elem: '#data-table',
                toolbar: '#toolbarTemplate',
                defaultToolbar: ['filter','exports',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-list-by-selected?assetSelectedCode='+ASSET_SELECTED_CODE+"&assetOwnerId="+billdata.assetOwnerId+"&dataType="+dataType,
                height: 400,
                limit: 50,
                where: ps,
                cols: [COL_DATA],
                done: function (data) {
                    dataType="keep";
                    dataTable.config.url=moduleURL +'/query-paged-list-by-selected?assetSelectedCode='+ASSET_SELECTED_CODE+"&assetOwnerId="+billdata.assetOwnerId+"&dataType="+dataType;
                    window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
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
        var ps={};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
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
            table.reload('data-table', { where : ps , page:{ curr:1 } });
        } else {
            table.reload('data-table', { where : ps });
        }

    }


    function getDataListSize(){
        console.log(table.getData("data-table"));
        return table.getData("data-table").length;
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
            // //设置新增是初始化数据
            console.log("openCreateFrom");
            var data={};
            admin.putTempData('eam-asset-select-action', "create",true);
            admin.putTempData('eam-asset-select-data'+ASSET_SELECTED_CODE, billdata,true);
            console.log("selected page put billdata:",billdata)
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
                admin.request(selectmoduleURL+"/delete-by-ids", { ids: ids,assetSelectedCode:ASSET_SELECTED_CODE,assetOwnerId:billdata.assetOwnerId}, function (data) {
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
     * 打开编辑窗口
     */
    function showEditForm(data) {
        if(window.pageExt.list.beforeEdit) {
            var doNext=window.pageExt.list.beforeEdit(data);
            if(!doNext) return;
        }
        var formTop=2
        var index=admin.popupCenter({
            title: "选择资产",
            resize: false,
            offset: [formTop,null],
            area: ["80%","90%"],
            type: 2,
            id:"eam-asset-select-data-win",
            content: '/business/eam/stock/asset_stock_select_list.html?ownerCode='+OWNER_CODE+'&assetSelectedCode='+ASSET_SELECTED_CODE,
            finish: function () {
                console.log("select form finish,");
                refreshTableData();
            }
        });
        admin.putTempData('eam-asset-select-data-popup-index', index);
    };

    window.module={
        getDataListSize:getDataListSize,
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