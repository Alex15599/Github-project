/**
 * 数据变更 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:29
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

    const moduleURL="/service-eam/eam-asset-data-change";
    var formAction=admin.getTempData('eam-asset-data-change-form-data-form-action');

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
            var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
            var toolbarHtml=document.getElementById("toolbarTemplate").innerHTML;
            if(APPROVAL_REQUIRED){
                //隐藏确认
                operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
            }else{
                operHtml=operHtml.replace(/lay-event="revoke-data"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="for-approval"/i, "style=\"display:none\"")
            }

            if(PAGE_TYPE&&PAGE_TYPE=="approval"){
                $("#status-search-unit").hide();
                toolbarHtml=toolbarHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="revoke-data"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="for-approval"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="edit"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="del"/i, "style=\"display:none\"")
            }else if( PAGE_TYPE&&PAGE_TYPE=="asset_change"){
                operHtml=operHtml.replace(/lay-event="agree"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="deny"/i, "style=\"display:none\"")
            }
            document.getElementById("toolbarTemplate").innerHTML=toolbarHtml;
            document.getElementById("tableOperationTemplate").innerHTML=operHtml;
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
            param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
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
                }else if(data[i].status=="incomplete"){
                   // fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                   // fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                   // fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                   // fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="deny"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                  //  fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="approval"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                   // fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="cancel"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }
            }



        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {

            if(field=="maintenanceNotes"
                ||field=="status"
                ||field=="businessCode"
                ||field=="changeDate"
                ||field=="businessName"
                ||field=="chsApprovalOpinion"
                ||field=="originatorId"){

                if(value==null)
                    return "";
                return value;
            }
            console.log("@@@"+field+"  "+value);

            //处理变更
            if(value){
                console.log("###"+field+" "+value+" ,,"+(value+"").length);
                //处理数字问题
                var v=(value+"");
                if(v.length>0){
                    if(v==null)
                        return "";
                    return v;
                }
            }else{
                return "未变更";
            }

            return "未知状态"
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
        beforeToolBarButtonEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            if(obj.event=="edit") {
                if(data.status=="complete"||data.status=="approval"){
                    layer.msg("当前状态不允许修改", {icon: 2, time: 1000});
                    return false;
                }
            }

            if(obj.event=="del") {
                if(data.status=="complete"||data.status=="approval"){
                    layer.msg("当前状态不允许修改", {icon: 2, time: 1000});
                    return false;
                }
            }
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
        approvalData:function(data,type){
            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            var btn=$('#'+type+'-button');
        },
        agreeData:function(data){
            console.log("agree",data);
            var api=moduleURL+"/approve";
            var successMessage="审批结束"
            var ps={};
            ps.instanceIds=[];
            ps.instanceIds.push(data.chsChangeInstanceId);
            ps.opinion="";
            ps.action="agree"
            var btn=$('.agree-button').filter("[data-id='" +data.id + "']");
            layer.prompt({
                formType: 2,
                value: "同意 ",
                title: '请输入审批意见',
                area: ['320px', '150px'] //自定义文本域宽高
            }, function(value, index, elem){
                ps.opinion=value;
                admin.post(api, ps, function (r) {
                    layer.close(index);
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
        denyData:function(data){

            var api=moduleURL+"/approve";
            var ps={};
            var successMessage="审批结束"
            ps.instanceIds=[];
            ps.instanceIds.push(data.chsChangeInstanceId);
            ps.opinion="";
            ps.action="reject"
            var btn=$('.deny-button').filter("[data-id='" +data.id + "']");
            layer.prompt({
                formType: 2,
                value: "拒绝 ",
                title: '请输入审批意见',
                area: ['320px', '150px'] //自定义文本域宽高
            }, function(value, index, elem){
                ps.opinion=value;
                admin.post(api, ps, function (r) {
                    layer.close(index);
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
         * 表单初始化前调用
         * */
        beforeInit:function () {
            $("#ownCompanyId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#useOrganizationId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#managerId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#useUserId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            //获取参数，并调整下拉框查询用的URL
            $("#businessCode").attr("disabled","disabled").css("background-color","#e6e6e6");
            console.log("form:beforeInit")
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            if(data&&data.id){
                $("#assetCode").attr('placeholder','请输入资产编码');
                if(data.purchaseDate&&data.purchaseDate.length>10){
                    data.purchaseDate= data.purchaseDate.substr(0,10);
                }
                if(data.productionDate&&data.productionDate.length>10){
                    data.productionDate= data.productionDate.substr(0,10);
                }
                if(data.maintenanceStartDate&&data.maintenanceStartDate.length>10){
                    data.maintenanceStartDate= data.maintenanceStartDate.substr(0,10);
                }
                if(data.maintenanceEndDate&&data.maintenanceEndDate.length>10){
                    data.maintenanceEndDate= data.maintenanceEndDate.substr(0,10);
                }

            }else{
                $("#businessCode").attr('placeholder','系统自动生成');
                setTimeout(function(){
                    var now = new Date();
                    var day = ("0" + now.getDate()).slice(-2);
                    var month = ("0" + (now.getMonth() + 1)).slice(-2);
                    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
                    $('#changeDate').val(today);
                },100)
            }
            console.log('beforeDataFill',data);
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {

            if(data&&data.id) {

                if (formAction == "view") {
                    setTimeout(function () {
                        $('#extData').find("input").attr('placeholder', '未变更');

                        $('#extData').find("textarea").attr('placeholder', '未变更');

                        $('#extData').find("button").each(function (index, e) {
                            var not_Btn=$(e).find("i");
                            if(not_Btn.length>0){
                                var txt = $(e).text();
                                if (txt && txt.length > 0 && txt.includes("选择")) {
                                    $(e).html("未变更");
                                }
                            }
                        })
                        //html("未变更")
                        $('#data-form').find(".xm-tips").each(function(index,e){
                            console.log($(e).html());
                            $(e).html("未变更");
                        });
                    }, 500);
                }
            }
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
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
            admin.putTempData('eam-asset-selected-data'+timestamp,data,true);
            admin.putTempData('eam-asset-selected-action'+timestamp,formAction,true);
            win.location="/business/eam/asset/asset_selected_list.html?assetSelectedCode="+timestamp+"&pageType="+formAction;

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