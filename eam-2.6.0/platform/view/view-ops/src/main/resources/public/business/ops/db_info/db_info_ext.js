/**
 * 数据库 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-10 14:39:12
 */
//   自动运行后修改下面
//  opts.push({data:data[i],name:data[i].hostName+"-"+data[i].hostIp,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});

layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    //模块基础路径
    const moduleURL="/service-ops/ops-db-info";

   var actionType=admin.getTempData('ops-db-info-form-data-form-action');
    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            cfg.defaultToolbar= ['filter', 'print','exports',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}];
            cfg.limit=500;
            console.log("list:beforeTableRender",cfg);
        },
        /**
         * 表格渲染后调用
         * */
        afterTableRender :function (){

        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * @param location 调用的代码位置
         * */
        beforeQuery:function (conditions,param,location) {
            console.log('beforeQuery',conditions,param,location);
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(value==null) return "";
            return value;
        },
        /**
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {

            return queryString;
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            console.log('beforeEdit',data);
            return true;
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            return true;
        },
        afterSingleDelete:function (data){
            console.log('beforeSingleDelete',data);
            return true;
        },
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        /**
         * 批量删除后调用，若返回false则不执行后续操作
         * */
        afterBatchDelete:function (data) {
            console.log('afterBatchDelete',data);
            return true;
        },
        /**
         * 工具栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeToolBarButtonEvent:function (selected,obj) {
            console.log('beforeToolBarButtonEvent',selected,obj);
            return true;
        },
        /**
         * 列表操作栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeRowOperationEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
            console.log(menu.id);
            if(menu.id=="backup"){
                this.openBackupWindow(data,it);
            }else if (menu.id=="box"){
                this.boxWindow(data,it);
            }else if (menu.id=="env"){
                this.actionEnv(data,it);
            }
        },
        actionEnv:function (data,it){
            admin.putTempData("instId",data.id,true);
            var q="?instId="+data.id;
            var index = admin.popupCenter({
                title: "备份记录",
                resize: false,
                id: 'openEnvWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/db_env_info/db_env_info_list.html"+q
            });


            // var action=admin.getTempData('ops-db-env-info-form-data-form-action');
            // var q="?instId="+data.id;
            // if(data && data.id) queryString='id=' + data.id;
            // if(window.pageExt.list.makeFormQueryString) {
            //     queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
            // }
            // admin.putTempData('ops-db-env-info-form-data', data);
            // var area=admin.getTempData('ops-db-env-info-form-area');
            // var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            // var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            // var title = fox.translate('数据库环境');
            // if(action=="create") title=fox.translate('添加','','cmp:table')+title;
            // else if(action=="edit") title=fox.translate('修改','','cmp:table')+title;
            // else if(action=="view") title=fox.translate('查看','','cmp:table')+title;
            //
            // admin.popupCenter({
            //     title: "环境信息",
            //     resize: false,
            //     offset: [top,null],
            //     area: ["80%","600px"],
            //     type: 2,
            //     id:"ops-db-env-info-form-data-win",
            //     content: '/business/ops/db_env_info/db_env_info_form.html' +q,
            //     finish: function () {
            //         if(action=="create") {
            //             refreshTableData();
            //         }
            //         if(action=="edit") {
            //             false?refreshTableData():refreshRowData(data,true);
            //         }
            //     }
            // });


        },
        dbSearch:function (selected,obj){
            console.log("go to search!");
            window.open("/business/ops/db_info/db_info_public_list.html")

        },
        openBackupWindow:function (data, it){
            admin.putTempData("ownerId",data.id,true);
            var q="?dbId="+data.id;
            var index = admin.popupCenter({
                title: "备份记录",
                resize: false,
                id: 'openBackupWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/db_backup_record/db_backup_record_list.html"+q
            });
        },
        showEditBoxForm:function(data,sourceId,boxType) {
            console.log("#######showEditBoxForm#########")
            var action="view";
            var queryString="?boxType="+boxType+"&sourceId="+sourceId;
            if(data&&data.id) {
                queryString=queryString+'&id=' + data.id;
                action="edit";
            }else{
                action="create";
            }
            admin.putTempData('ops-ciphertext-box-data-form-data-form-action', action,true);
            admin.putTempData('ops-ciphertext-box-data-form-data', data);
            var area=admin.getTempData('ops-ciphertext-box-data-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('密文数据');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            console.log("action"+action)
            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"ops-ciphertext-box-data-form-data-win",
                content: '/business/ops/ciphertext_box_data/ciphertext_box_data_form.html' + queryString,
                finish: function () {
                }
            });
            },
        boxWindow:function (data, it){
            console.log("boxWindow",data.id);
            var ps={};
            ps.sourceId=data.id;
            var boxType="database_instance";
            admin.post("/service-ops/ops-ciphertext-box/user-en-de-perm-by-boxtype", {boxType:boxType}, function (rrr) {
                if (rrr.success) {
                   if(rrr.data=="false"){
                       layer.msg("用户无加解密权限，请先配置用户权限", {icon: 2, time: 1000});
                   }else{
                       admin.post("/service-ops/ops-ciphertext-box-data/query-list", ps, function (rr) {
                           if (rr.success) {
                               var boxdata = rr.data;
                               console.log("/service-ops/ops-ciphertext-box-data/query-list",data)
                               if(boxdata.length==0){
                                   var td={}
                                   list.showEditBoxForm(td,data.id,boxType);
                               }else if (boxdata.length==1){
                                   admin.post("/service-ops/ops-ciphertext-box-data/get-by-id", {id:boxdata[0].id}, function (r2) {
                                       if (r2.success) {
                                           list.showEditBoxForm(r2.data,data.id,boxType);
                                       } else {
                                           layer.msg("请求异常", {icon: 2, time: 1000});
                                       }
                                   });
                               }else{
                                   layer.msg("数据异常", {icon: 2, time: 1000});
                               }
                           } else {
                               layer.msg( "请求异常", {icon: 2, time: 1000});
                           }
                       });
                   }
                } else {
                    layer.msg("请求异常", {icon: 2, time: 1000});
                }
            });
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    var timestamp = Date.parse(new Date());

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用 , 并传入表单数据
         * */
        beforeInit:function (action,data) {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        /**
         * 窗口调节前
         * */
        beforeAdjustPopup:function () {
            console.log('beforeAdjustPopup');
            return true;
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {


            var boxType="database_instance";
            admin.post("/service-ops/ops-ciphertext-box/user-en-de-perm-by-boxtype", {boxType:boxType}, function (rrr) {
                if (rrr.success) {
                    if(rrr.data=="false"){
                        var e=$("#voucherStr");
                        if(e){
                            e.attr("readonly","readonly");
                            e.css("background","#ccc");
                            e.attr("placeholder","没有权限操作该字段。");
                        }
                    }
                } else {
                    layer.msg("请求异常", {icon: 2, time: 1000});
                }
            });
            console.log('beforeDataFill',data);
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        onRadioBoxChanged:function(id,data,checked) {
            console.log('onRadioChanged',id,data,checked);
        },
        onCheckBoxChanged:function(id,data,checked) {
            console.log('onCheckBoxChanged',id,data,checked);
        },

        /**
         * 在流程提交前处理表单数据
         * */
        processFormData4Bpm:function(processInstanceId,param,callback) {
            // 设置流程变量，并通过回调返回
            var variables={};
            // 此回调是必须的，否则流程提交会被中断
            callback(variables);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            data.selectedCode=timestamp;
            console.log("beforeSubmit",data);
            return true;
        },
        /**
         * 数据提交后窗口关闭前，如果返回 false，停止后续步骤的执行
         * */
        betweenFormSubmitAndClose:function (param,result) {
            console.log("betweenFormSubmitAndClose",result);
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },

        /**
         *  加载 备份情况
         */
        backInfoList:function (ifr,win,data) {
            // debugger
            console.log("backInfoList",ifr,data);
            //设置 iframe 高度
            ifr.height("400px");
            var selectedCode=timestamp;
            var q="?selectedCode="+selectedCode+"&pageType="+actionType
            if(data&&data.id){
                q=q+"&dbId="+data.id;
            }else{
                q=q+"&dbId="+timestamp;
            }
            //设置地址
            win.location="/business/ops/db_backup_info/db_backup_info_list.html"+q;
        },
        /**
         * 文件上传组件回调
         *  event 类型包括：
         *  afterPreview ：文件选择后，未上传前触发；
         *  afterUpload ：文件上传后触发
         *  beforeRemove ：文件删除前触发
         *  afterRemove ：文件删除后触发
         * */
        onUploadEvent: function(e) {
            console.log("onUploadEvent",e);
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    //
    window.pageExt={form:form,list:list};
});