/**
 * 车辆申请 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:49:06
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
    const moduleURL="/service-vehicle/vehicle-apply";

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
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
            list.billOper("confirm","confirm-data-button",{id:item.id},"已确认");
        },
        cancelData:function (item){
            list.billOper("cancel","cancel-data-button",{id:item.id},"已取消");
        },
        returnData:function (item){


            layer.open({
                id:1,
                type:1,
                title:"归还",
                style:"width:50%:height:auto;",
                content:"<div style='display:flex;justify-content:center;'><input id='area'  style='width:100%;height:30px;margin-left:5px;margin-right:5px'></input></div>",
                btn:['保存','取消'],
                yes:function(index,layero){
                    var closeContent=top.$("#area").val()||$("#area").val();
                    if(closeContent){

                        var url="action-return";
                        var btnClass="return-data-button";
                        var btn=$('.'+btnClass).filter("[data-id='" +item.id + "']");
                        var api=moduleURL+"/"+url;
                        top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                            top.layer.close(i);
                            var ps={};
                            ps.id=item.id;
                            ps.notes=closeContent;
                            var successMessage="归还成功"
                            admin.post(api, ps, function (r) {
                                if (r.success) {
                                    layer.close(index);
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

                    }else{
                        alert("请输入归还备注");
                    }
                },
                no:function(index,layer){
                    layer.close(index);
                }
            })

           // list.billOper("action-return","return-data-button",{id:item.id},"已归还");
        },

        beforeInit:function () {
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


                if(data[i].status=="complete") {
                    if(data[i].ifReturn=="Y"){
                        fox.disableButton($('.return-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    }
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }
                 else if (data[i].status=="incomplete"){
                    fox.disableButton($('.return-data-button').filter("[data-id='" + data[i].id + "']"), true);
                   //  fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                   // fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                   // fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-data-button').filter("[data-id='" + data[i].id + "']"), true);
                 }
                 else {
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.cancel-data-button').filter("[data-id='" + data[i].id + "']"), true);
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
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            var dataListSize=$(".form-iframe")[0].contentWindow.module.getCheckedData();
            if(dataListSize==0){
                layer.msg("请选择车辆", {icon: 2, time: 1000});
                return false;
            }
            data.vehicleInfoIds=dataListSize;
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
         *  加载 车辆列表
         */
        vehicleSelectList:function (ifr,win,data) {
            // debugger
            console.log("vehicleSelectList ifr",ifr);
            console.log("vehicleSelectList data",data);
            //设置 iframe 高度
            ifr.height("300px");
            var ids="";
            if(data&&data.vehicleInfoList){
                for(var i=0;i<data.vehicleInfoList.length;i++){
                    if(i==0){
                        ids=ids+data.vehicleInfoList[i].id;
                    }else{
                        ids=ids+","+data.vehicleInfoList[i].id;
                    }
                }
            }
            var tAction=admin.getTempData('vehicle-apply-form-data-form-action');
            //设置地址 JSON.parse(string);
            win.location="/business/vehicle/info/selected_info_list.html?action="+tAction+"&type=vehicle_apply&ids="+ids
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