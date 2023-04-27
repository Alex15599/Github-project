/**
 * 维保更新记录 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 20:52:59
 */

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
    const moduleURL="/service-eam/eam-asset-maintenance-record";



    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit",MAINTENANCE_UPDATE_DATA);
            var hide=false;
            if(MAINTENANCE_UPDATE_DATA.handleStatus=="draft"){
                hide=false;
            }else{
                hide=true;
            }
            if(hide){
                var operHtml=document.getElementById("toolbarTemplate").innerHTML;
                operHtml=operHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="batch-del"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="tool-select-asset"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="tool-import-asset"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="tool-data-fill"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="tool-finish"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="tool-batch-modify"/i, "style=\"display:none\"")
                document.getElementById("toolbarTemplate").innerHTML=operHtml;
            }

            var operHtml=document.getElementById("toolbarTemplate").innerHTML;
            operHtml=operHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
            operHtml=operHtml.replace(/lay-event="tool-import-asset"/i, "style=\"display:none\"")
            document.getElementById("toolbarTemplate").innerHTML=operHtml;
        },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            console.log("list:beforeTableRender",cfg);
            cfg.defaultToolbar=['filter', 'print','exports',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}];
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
            param.maintenanceUpdateId=MAINTENANCE_UPDATE_ID;
            console.log('beforeQuery',conditions,param,location);
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {
            for (var i = 0; i < data.length; i++) {
                //如果审批中或审批通过的不允许编辑
                if(! (MAINTENANCE_UPDATE_DATA.handleStatus=="draft" )){
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                } else{
                }
            }
        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {

            function formatValue(value,c){
                console.log("value",value)
                console.log("c",c)
                if(c){
                    if(value==""){
                        value="【未配置内容】"
                    }
                    if(c=="enable"){
                        return "<span style=\"font-weight:bold;color: green\">"+value+"</span>"
                    }else{
                        return "<span style=\"font-weight:bold;color: red\">"+value+"</span>"
                    }
                }else{
                    return value;
                }
            }
            // console.log("field",field);
            // console.log("value",value);
            console.log("############## Start")
            console.log("#r",r);
            console.log("#value",value);
            console.log("#field",field);
            if(value==null) return "";

            var valueFormat="";
            if(field){
                if(field=="maintainerId"){
                    valueFormat=formatValue(value,r.sMaintainerId);
                }else if(field=="maintainerName"){
                    valueFormat=formatValue(value,r.sMaintainerName);
                }else if(field=="maintenanceStatus"){
                    valueFormat=formatValue(value,r.sMaintenanceStatus);
                }else if(field=="maintenanceMethod"){
                    valueFormat=formatValue(value,r.sMaintenanceMethod);
                }else if(field=="suggestMaintenanceMethod"){
                    valueFormat=formatValue(value,r.sSuggestMaintenanceMethod);
                }else if(field=="contacts"){
                    valueFormat=formatValue(value,r.sContacts);
                }else if(field=="contactInformation"){
                    valueFormat=formatValue(value,r.sContactInformation);
                }else if(field=="maintenanceStartDate"){
                    valueFormat=formatValue(value,r.sMaintenanceStartDate);
                }else if(field=="maintenanceEndDate"){
                    valueFormat=formatValue(value,r.sMaintenanceEndDate);
                }else if(field=="maintenanceNotes"){
                    valueFormat=formatValue(value,r.sMaintenanceNotes);
                }else if(field=="director"){
                    valueFormat=formatValue(value,r.sDirector);
                }else{
                    console.log("field:"+field+" not match");
                    valueFormat=value
                }
            }
            console.log("############## END")
            return valueFormat;
        },
        /**
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {
            queryString="maintenanceUpdateId="+MAINTENANCE_UPDATE_ID
            if(data.id){
                queryString=queryString+"&id="+data.id;
            }
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
        },
        selectAsset:function (selected,it){
            console.log('selectAsset',selected,it);

            var timestamp = Date.parse(new Date());
            var ASSET_SELECTED_CODE=timestamp;
            var data={};
            var billdata={};
            admin.putTempData('eam-asset-select-action', "create",true);
            admin.putTempData('eam-asset-select-data'+ASSET_SELECTED_CODE, billdata,true);
            console.log("selected page put billdata:",billdata)
            var formTop=2
            var index=admin.popupCenter({
                title: "选择资产",
                resize: false,
                offset: [formTop,null],
                area: ["80%","90%"],
                type: 2,
                id:"eam-asset-select-data-win",
                content: '/business/eam/asset/asset_select_list.html?assetSelectedCode='+ASSET_SELECTED_CODE,
                finish: function () {
                    console.log("select form finish,");
                    admin.post("/service-eam/eam-asset-maintenance-update/insert-asset", {id:MAINTENANCE_UPDATE_ID,selectedCode:ASSET_SELECTED_CODE}, function (r) {
                        if (r.success) {
                            window.module.refreshTableData();
                        } else {
                            fox.showMessage(r);
                        }
                    });
                }
            });
            admin.putTempData('eam-asset-select-data-popup-index', index);


        },
        importAsset:function (selected,it){
            console.log('importAsset',selected,it);
        },
        updateAsset:function (selected,it){
            console.log('updateAsset',selected,it);
        },
        batchModify:function (selected,it){
            console.log('batchModify',selected,it);
            var formTop=2
            var query="?maintenanceUpdateId="+MAINTENANCE_UPDATE_ID;
            admin.putTempData('eam-asset-maintenance-record-u', selected);
            var index=admin.popupCenter({
                title: "批量修改,已选中资产数据"+selected.length+"行",
                resize: false,
                offset: [formTop,null],
                area: ["95%","95%"],
                type: 2,
                id:"eam-asset-maintenance-record-u-form-data-win",
                content: '/business/eam/asset_maintenance_record_u/asset_maintenance_record_u_form.html'+query,
                finish: function () {
                    console.log('11');
                }
            });
            admin.putTempData('eam-asset-maintenance-record-u-data-popup-index', index);

        },
        dataFill:function (selected,it){
            if(selected.length==0) {
                top.layer.msg(fox.translate('请选择需要填充的')+fox.translate('资产')+"!");
                return;
            }
            admin.post("/service-eam/eam-asset-maintenance-update/fill-data", {ids:selected}, function (r) {
                if (r.success) {
                    window.module.refreshTableData();
                    fox.showMessage(r);
                } else {
                    fox.showMessage(r);
                }
            });
            console.log('dataFill',selected,it);
        },
        finish:function (selected,it){
            top.layer.confirm(fox.translate('确定完成本次维保变更吗？'), function (i) {
                    top.layer.close(i);
                    admin.post("/service-eam/eam-asset-maintenance-update/action-update", { id: MAINTENANCE_UPDATE_ID }, function (data) {
                        if (data.success) {
                            fox.showMessage(data);
                            window.module.refreshTableData();
                        } else {
                            fox.showMessage(data);
                        }
                    },{delayLoading:200,elms:[$("#delete-button")]});
            });
        },


        /**
         * 末尾执行
         */
        ending:function() {

        }
    }

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
            console.log("beforeSubmit",data);
            data.maintenanceUpdateId=MAINTENANCE_UPDATE_ID;
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