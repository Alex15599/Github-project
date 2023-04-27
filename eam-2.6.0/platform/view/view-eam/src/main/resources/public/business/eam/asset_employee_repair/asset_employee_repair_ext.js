/**
 * 资产报修 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-23 10:10:53
 */

layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown','bpm'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload,bpm=layui.bpm;



    var bpmFunction=layui.bpmFunction;

    var processId=QueryString.get("processId");
    var processInstance=null;



    //模块基础路径
    const moduleURL="/service-eam/eam-asset-employee-repair";
    var formAction=admin.getTempData('eam-asset-employee-repair-form-data-form-action');
    var timestamp = Date.parse(new Date());


    //列表页的扩展
    var list={

        getBpmViewConfig:function () {
            return {
                title:"资产报修申请",
                priority:"normal", // priority 的可选值 urgency，normal
                displayTitle:true,
                displayPriority:false,
                displayDraftComment:false,
                displayApprovalComment:true,
            }
        },


        /**
         * 表单没有关联的流程时的处理逻辑
         * */
        handleNoProcessBill:function(idValue) {
            top.layer.msg('当前业务单据尚未关联流程', {icon: 2, time: 1500});
        },
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {

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
            for(var i=0;i<data.length;i++){
                bpmFunction.columnBpmOpenButtonStatus(data[i]);
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
        forApproval:function (data){
            console.log('forApproval',data);
        },
        confirmData:function (data){
            console.log('confirmData',data);
        },
        revokeData:function (data){
            console.log('revokeData',data);
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
         * 请求流程数据成功时
         * */
        onProcessInstanceReady:function (result) {


            // 可根据流程状态、当前审批节点判断和控制表单页面
            processInstance=result.data;
            console.log("processInstance",processInstance);
            // 获得所有待办节点
            var todoNodes=bpm.getTodoNodes(processInstance);
            console.log("todoNodes",todoNodes);
            // 判断是否为待办节点
            var isTodoNode=bpm.isTodoNodes(processInstance,"N1");
            console.log("isTodoNode:N1",isTodoNode);
            // 判断是否为当前账户的待办节点
            var isMyTodoNode=bpm.isCurrentUserTodoNode(processInstance,"N1");
            console.log("isMyTodoNode:N1",isMyTodoNode);
        },
        /**
         * 请求流程数据错误时
         * */
        onProcessInstanceError:function (result) {
            return true;
        },
        /**
         * 表单初始化前调用 , 并传入表单数据
         * */
        beforeInit:function (action,data) {
            $("#originatorUserName").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#originatorUserName").attr("placeholder","自动填充")
            console.log("list:beforeInit");
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
            if(data.status){
                if(data.status=="incomplete"){
                    console.log("can edit");
                }else{
                    fox.lockForm($("#data-form"),true);
                }
            }

            //iframe
            var ownerId="";
            if(data&&data.id){
                ownerId=data.id;
            }

            if(data.status=="incomplete"){
                formAction="modify";
            }else{
                formAction="view";
            }
            var queryString="?employeeId="+EMPLOYEE_ID+"&pageType="+formAction+"&selectedCode="+timestamp+"&ownerId="+ownerId;
            //设置地址
            console.log("queryString",queryString);
            $(".form-iframe")[0].contentWindow.location="/business/eam/asset/asset_search/employee_assetInfo_selected_list.html"+queryString
            $(".form-iframe")[0].height("400px");



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
         *  加载 物品列表
         */
        goodsSelectList:function (ifr,win,data) {
            // debugger
            console.log("goodsSelectList",ifr,data);
            //设置 iframe 高度
            ifr.height("400px");
            var ownerId="";
            if(data&&data.id){
            }else{
                formAction="create";
                var queryString="?employeeId="+EMPLOYEE_ID+"&pageType="+formAction+"&selectedCode="+timestamp+"&ownerId="+ownerId;
                //设置地址
                win.location="/business/eam/asset/asset_search/employee_assetInfo_selected_list.html"+queryString
            }
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