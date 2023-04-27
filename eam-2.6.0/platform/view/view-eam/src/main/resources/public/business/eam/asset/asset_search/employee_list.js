
function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-hrm/hrm-employee";
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
            var h=$(".search-bar").height();
            dataTable=fox.renderTable({
                elem: '#data-table',
                toolbar: '#toolbarTemplate',
                defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-list',
                height: 'full-'+(h+28),
                limit: 50,
                where: ps,
                cols: [[
                    { fixed: 'left',type: 'numbers' },
                    { fixed: 'left',type:'checkbox' }
                    ,{ field: 'companyId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('公司ID') , templet: function (d) { return templet('companyId',d.companyId,d);}  }
                    ,{ field: 'badge', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('工号') , templet: function (d) { return templet('badge',d.badge,d);}  }
                    ,{ field: 'name', align:"",fixed:false,  hide:false, sort: true, title: fox.translate('姓名') , templet: function (d) { return templet('name',fox.getProperty(d,["person","name"]),d);} }
                    ,{ field: 'phone', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('手机号') , templet: function (d) { return templet('phone',d.phone,d);}  }
                    ,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('创建时间'), templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime),d); }}
                    ,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
                    ,{ field: 'personId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('人员ID') , templet: function (d) { return templet('personId',d.personId,d);}  }
                    ,{ field: 'status', align:"left", fixed:false, hide:true, sort: true, title: fox.translate('状态'), templet:function (d){ return templet('status',fox.getDictText(RADIO_STATUS_DATA,d.status),d);}}
                    ,{ field: 'identity', align:"",fixed:false,  hide:true, sort: true, title: fox.translate('身份证') , templet: function (d) { return templet('identity',fox.getProperty(d,["person","identity"]),d);} }
                    ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
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
        value.badge={ value: $("#badge").val() ,fuzzy: true,valuePrefix:"",valueSuffix:""};
        value.phone={ value: $("#phone").val()};
        value.status={ value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
        value.name={ value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"",fillBy:["person","name"] };
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

        //渲染 status 搜索框
        fox.renderSelectBox({
            el: "status",
            size: "small",
            radio: false,
            //toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({name:data[i].text,value:data[i].code});
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
                   // openCreateFrom();
                    break;
                case 'batch-del':
                   // batchDelete(selected);
                    break;
                case 'refresh-data':
                    refreshTableData();
                    break;
                case 'other':
                    break;
            };
        });



    }

    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {
        // 工具条点击事件
        table.on('tool(data-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            admin.putTempData('hrm-employee-form-data-form-action', "",true);
            if (layEvent === 'view') { // 修改
                //延迟显示加载动画，避免界面闪动
                var task=setTimeout(function(){layer.load(2);},1000);
                admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    clearTimeout(task);
                    layer.closeAll('loading');
                    if(data.success) {
                        admin.putTempData('hrm-employee-form-data-form-action', "view",true);
                        showEditForm(data.data);
                    } else {
                        layer.msg(data.message, {icon: 1, time: 1500});
                    }
                });
            } else if (layEvent === 'viewAssetInfo') { // 查看

                var queryString="?employeeId="+obj.data.id;

                console.log(1111,obj,queryString);
                var area=admin.getTempData('hrm-employee-form-area');
                var height= (area && area.height) ? area.height : ($(window).height()*0.6);
                var index=admin.popupCenter({
                    title: "员工资产",
                    resize: false,
                    offset: [20,null],
                    area: ["80%","80%"],
                    type: 2,
                    id:"hrm-employee-list-data-win",
                    content: '/business/eam/asset/asset_search/employee_assetInfo_list.html' + queryString,
                    finish: function () {
                        refreshTableData();
                    }
                });
                admin.putTempData('hrm-employee-list-data-popup-index', index);

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
        var action=admin.getTempData('hrm-employee-form-data-form-action');
        var queryString="";
        if(data && data.id) queryString="?" + 'id=' + data.id;
        admin.putTempData('hrm-employee-form-data', data);
        var area=admin.getTempData('hrm-employee-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('员工');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;

        var index=admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["80%",height+"px"],
            type: 2,
            id:"hrm-employee-form-data-win",
            content: '/business/hrm/employee/employee_form.html' + queryString,
            finish: function () {
                refreshTableData();
            }
        });
        admin.putTempData('hrm-employee-form-data-popup-index', index);
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