/**
 * 维修工单 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 19:33:23
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
    const moduleURL="/service-eam/eam-repair-order";

    var timestamp = Date.parse(new Date());
    var formAction=admin.getTempData('eam-repair-order-form-data-form-action');
    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            if(APPROVAL_REQUIRED){
                var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
                document.getElementById("tableOperationTemplate").innerHTML=operHtml;
            }else{
                var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                operHtml=operHtml.replace(/lay-event="revoke-data"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="for-approval"/i, "style=\"display:none\"")
                document.getElementById("tableOperationTemplate").innerHTML=operHtml;
            }
            console.log("list:beforeInit");
        },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
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
            for (var i = 0; i < data.length; i++) {
                //如果审批中或审批通过的不允许编辑
                if(data[i].status=="complete") {
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    if(data[i].repairStatus=="repairing"){
                    }else{
                        fox.disableButton($('.finish-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    }
                }else if(data[i].status=="incomplete"){
                    // fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-data-button').filter("[data-id='" + data[i].id + "']"), true);

                }else if(data[i].status=="deny"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="approval"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="cancel"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.finish-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }
            }

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
        },
        billOper:function(url,btnClass,ps,successMessage){
            var btn=$('.'+btnClass).filter("[data-id='" +ps.id + "']");
            var api=moduleURL+"/"+url;
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, ps, function (r) {
                    if (r.success) {
                        top.layer.msg(successMessage, {time: 1000});
                        window.module.refreshTableData();
                    } else {
                        var errs = [];
                        if(r.errors&&r.errors.length>0){
                            for (var i = 0; i < r.errors.length; i++) {
                                if (errs.indexOf(r.errors[i].message) == -1) {
                                    errs.push(r.errors[i].message);
                                }
                            }
                            top.layer.msg(errs.join("<br>"), {time: 2000});
                        } else {
                            top.layer.msg(r.message, {time: 2000});
                        }
                    }
                }, {delayLoading: 1000, elms: [btn]});
            });
        },
        confirmData:function (item){
            list.billOper("confirm-operation","confirm-data-button",{id:item.id},"已确认");
        },
        forApproval:function (item){
            list.billOper("for-approval","for-approval-button",{id:item.id},"已送审");
        },
        revokeData:function (item){
            list.billOper("revoke-operation","revoke-data-button",{id:item.id},"已撤销");
        },
        finishData:function (item){
            console.log('fnish');
            list.billOper("finish-repair","finish-data-button",{id:item.id},"维修结束");
        },
        downloadBill:function (data){
            console.log('downloadBill',data);
        },
         dispatchForm:function(data) {
                admin.putTempData('eam-repair-order-act-form-data-form-action', "create",true);
                var action="create";
                var queryString="?orderId="+data.orderId;
              //  var queryString=""
                admin.putTempData('eam-repair-order-act-form-data', data);
                var area=admin.getTempData('eam-repair-order-act-form-area');
                var height= (area && area.height) ? area.height : ($(window).height()*0.6);
                var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
                var title = fox.translate('维修工单');
                if(action=="create") title=fox.translate('添加')+title;
                else if(action=="edit") title=fox.translate('修改')+title;
                else if(action=="view") title=fox.translate('查看')+title;
                admin.popupCenter({
                    title: title,
                    resize: false,
                    offset: [top,null],
                    area: ["80%",height+"px"],
                    type: 2,
                    id:"eam-repair-order-act-form-data-win",
                    content: '/business/eam/repair_order_act/repair_order_act_form.html' + queryString,
                    finish: function () {
                        window.module.refreshTableData();
                    }
                });
         },
        dispatchOrder:function(selected,obj){
            if(selected.length==0){
                top.layer.msg("请选择工单进行派发", {time: 1000});
                return 1
            }
            if(selected.length>1){
                top.layer.msg("请选择一个工单进行派发", {time: 1000});
                return 1
            }
            list.dispatchForm({orderId:selected[0]})
            console.log(selected);
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
            var dataListSize=$(".form-iframe")[0].contentWindow.module.getDataListSize();
            if(dataListSize==0){
                layer.msg("请选择资产数据", {icon: 2, time: 1000});
                return false;
            }
            data.selectedCode=timestamp;
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
         *  加载 资产列表
         */
        assetSelectList:function (ifr,win,data) {
            console.log("assetSelectList",ifr,data);
            //设置 iframe 高度
            ifr.height("450px");
            //设置地址
            var data={};
            data.searchContent={};
            data.assetSelectedCode=timestamp;
            data.assetBusinessType=BILL_TYPE
            data.action=formAction;
            data.ownerCode="asset";
            if(BILL_ID==null)BILL_ID="";
            data.assetOwnerId=BILL_ID;
          //  console.log("DATA:",data);
            admin.putTempData('eam-asset-selected-data'+timestamp,data,true);
            admin.putTempData('eam-asset-selected-action'+timestamp,formAction,true);
            win.location="/business/eam/asset/asset_selected_list.html?pageType="+formAction+"&assetSelectedCode="+timestamp+"&pageType="+formAction;
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