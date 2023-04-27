/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 08:26:48
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

    const moduleURL="/service-eam/eam-asset";
    var formAction=admin.getTempData('eam-asset-form-data-form-action');
    //列表页的扩展
    var list={
        /**
         * 表格右侧操作列更多按钮事件
         * */

        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
            if(menu.code){
                if(menu.code=="card"){
                    window.pageExt.list.downBills(data);
                }else if(menu.code=="labelCard"){
                    window.pageExt.list.printPdf(data);
                }else if(menu.code=="labelDown"){
                    window.pageExt.list.assetLabel(data);
                }else if(menu.code=="batchInsert"){
                    window.pageExt.list.batchInsert(data,null);
                }else if(menu.code=="highExportData"){
                    window.pageExt.list.highExportData(data,null);
                }else if(menu.code=="downloadAssetTpl"){
                    window.pageExt.list.downloadAssetTpl(data,null);
                }else if(menu.code=="excelInsert"){
                    window.pageExt.list.importData(data,null);
                }
            }
            if(menu.id){
                if(menu.id=="deleteBtn"){
                    top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产')+fox.translate('吗？'), function (i) {
                        top.layer.close(i);
                        top.layer.load(2);
                        admin.request(moduleURL+"/delete", { id : data.id }, function (resData) {
                            top.layer.closeAll('loading');
                            if (resData.success) {
                                top.layer.msg(resData.message, {icon: 1, time: 500});
                                window.module.refreshTableData();
                            } else {
                                top.layer.msg(resData.message, {icon: 2, time: 1500});
                            }
                        });
                    });
                }else if(menu.id=="updateBtn"){
                    //延迟显示加载动画，避免界面闪动
                    var task=setTimeout(function(){layer.load(2);},1000);
                    admin.request(moduleURL+"/get-by-id", { id : data.id }, function (resData) {
                        clearTimeout(task);
                        layer.closeAll('loading');
                        if(resData.success) {
                            admin.putTempData('eam-asset-form-data-form-action', "edit",true);
                            window.module.showEditForm(resData.data);
                        } else {
                            layer.msg(resData.message, {icon: 1, time: 1500});
                        }
                    });
                }else if(menu.id=="changeQueryBtn"){
                    window.pageExt.list.assetDataChange(data);
                }else if(menu.id=="assetVoucher"){
                    window.pageExt.list.assetVoucher(data);
                }else if(menu.id=="assetBox"){
                    window.pageExt.list.boxWindow(data,it);
                }else if(menu.id=="assetCopy"){
                    window.pageExt.list.assetCopy(data,it);
                }else if(menu.id=="asssetDepreciation"){
                    window.pageExt.list.asssetDepreciation(data,it);
                }else if(menu.id=="rwm") {
                    window.pageExt.list.rwm(data, it);
                    var textValue = data.assetCode;
                    var type = "auto";
                    var text = data.assetCode
                    layer.open({
                        type: 1
                        , offset: type
                        ,title:"二维码"
                        , area: ["60%", "60%"]
                        , id: 'layerAsset_' + type //防止重复弹出
                        , content: '<div style="padding: 20px 100px;">' + text + '</div> ' +
                            '<div style="margin-left:20px;margin-right: 20px;margin-top:20px;margin-bottom: 20px;" id="assetCodePic"></div>'
                        , btn: '关闭'
                        , btnAlign: 'c' //按钮居中
                        , shade: 0 //不显示遮罩
                        , success: function (layero) {
                            console.log("open success",layero);
                            $("#assetCodePic").qrcode({
                                render: "canvas",
                                wihth: 250,
                                height: 250,
                                text: textValue
                            });
                        }
                        ,yes: function(){
                            layer.closeAll();
                        }
                    });
                }
            }
        },
        rwm:function(data,it){
            console.log("it");
        },
        importData:function(data){
            admin.putTempData("assetId",data.id,true);
            var index = admin.popupCenter({
                title: "资产数据导入",
                resize: false,
                id: 'assetDataImport',
                area: ["60%", "50%"],
                type: 2,
                content: '/business/eam/asset/asset_import_form.html',
            });
        },
        asssetDepreciation:function(data){
            admin.putTempData("assetId",data.id,true);
            var index = admin.popupCenter({
                title: "资产折旧记录",
                resize: false,
                id: 'asssetDepreciation',
                area: ["98%", "80%"],
                type: 2,
                content: '/business/eam/asset_depreciation_detail/asset_depreciation_detail_history_list.html?assetId='+data.id ,
            });
        },
        assetCopy:function(data){
            var queryString="?assetId="+data.id
            var index=admin.popupCenter({
                title: "资产复制",
                resize: false,
                offset: [15,null],
                area: ["50%","50%"],
                type: 2,
                id:"eam-asset-copy-form-data-win",
                content: '/business/eam/asset_copy/asset_copy_form.html' + queryString,
                finish: function () {
                    window.module.refreshTableData();
                }
            });
            admin.putTempData('eam-asset-copy-form-data-form-action', "create",true);
        },
        downloadAssetTpl:function (data){
            var categoryId;
            var assetCategorySelect= xmSelect.get('#categoryId',true);
            if(assetCategorySelect){
                categoryValue= assetCategorySelect.getValue();
                console.log("categoryValue:"+categoryValue);
                if(categoryValue&&categoryValue.length>0){
                    categoryId=categoryValue[0].id;
                }
            }
            var value = {};
            value.businessCode={ inputType:"button",value: "1234567890" ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
            var ps={searchField: "$composite", searchValue: JSON.stringify(value)};
            var downloadUrl="/service-eam/eam-asset/export-excel";
            if(categoryId){
                ps.categoryId=categoryId;
            }
            ps.ownerCode="TPL";
            ps.businessCode="123456789";
            fox.submit(downloadUrl,ps,"post",function(){
                console.log("execute finish");
            });
        },
        assetVoucher:function (data){
            admin.putTempData("ownerId",data.id,true);
            var index = admin.popupCenter({
                title: "凭证条目",
                resize: false,
                id: 'hostVoucherWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/voucher/voucher_list.html"
            });
        },
        downBills:function (data){
            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            console.log('downloadBill',data);
            var downloadUrl="/service-eam/eam-asset-bill/query-asset-register-bills";
            fox.submit(downloadUrl,{ids:data});

        },
        printPdf:function(data){
            function downloadFile(file) {
                var a = document.createElement('a');
                a.id = 'tempId';
                document.body.appendChild(a);
                a.download = "assetLabel-" + moment().format('L') + '.pdf';
                a.href = URL.createObjectURL(file);
                a.click();
                const tempA = document.getElementById('tempId');
                if (tempA) {
                    tempA.parentNode.removeChild(tempA);
                }
            }

            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            var ps={ids:data}
            var xhr = new XMLHttpRequest()
            xhr.open('POST', "/service-eam/eam-asset-data/print-pdf")
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.responseType = 'arraybuffer'
            xhr.onload = function (e) {
                var ct = xhr.response
                let blob = new Blob([ct], {type: 'application/pdf'});
                let link = document.createElement('a')
                link.href = window.URL.createObjectURL(blob)
                window.open(link.href);
            }
            xhr.send(JSON.stringify(ps));
        },
        assetLabel:function(data){
            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            var downloadUrl="/service-eam/eam-asset-bill/query-asset-labels";
            fox.submit(downloadUrl,{ids:data});
        },
        assetDataChange:function (data){
            var queryString="?assetId="+data.id;
            var index=admin.popupCenter({
                title: "变更明细",
                resize: false,
                offset: [15,null],
                area: ["80%","98%"],
                type: 2,
                id:"eam-asset-data-change-detail-form-data-win",
                content: '/business/eam/asset_process_record/asset_process_record_list.html' + queryString,
                finish: function () {
                    window.module.refreshTableData();
                }
            });
            admin.putTempData('eam-asset-data-change-form-data-popup-index', index);
        },
        batchInsert:function(data,item){

            var queryString=""
            var index=admin.popupCenter({
                title: "数据导入",
                resize: false,
                offset: [15,null],
                area: ["98%","98%"],
                type: 2,
                id:"eam-asset-data-batch-insert-data-win",
                content: '/business/eam/asset/asset_excel_oper.html' + queryString,
                finish: function () {
                    window.module.refreshTableData();
                }
            });
            admin.putTempData('eam-asset-data-batch-insert-data-popup-index', index);

        },

        batchConfirm:function(data,item){
            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            top.layer.confirm('是否对选择的资产进行确认?', function (i) {
                var api=moduleURL+"/batch-confirm-operation";
                var ps={ids:data};
                admin.post(api,ps,function (r){
                    if(r.success) {
                        top.layer.msg("操作成功",{time:1000});
                        window.module.refreshTableData();
                    } else {
                        var errs=[];
                        if(r.errors&&r.errors.length>0){
                            for (var i = 0; i < r.errors.length; i++) {
                                if(errs.indexOf(r.errors[i].message)==-1) {
                                    errs.push(r.errors[i].message);
                                }
                            }
                            top.layer.msg(errs.join("<br>"),{time:2000});
                        }else{
                            top.layer.msg(r.message,{time:2000});
                        }
                    }
                },{delayLoading:1000,elms:[ $('#batchConfirm-button')  ]});
            });

        },
        highExportData:function(data,item){
            var categoryId;
            var assetCategorySelect= xmSelect.get('#categoryId',true);
            if(assetCategorySelect){
               categoryValue= assetCategorySelect.getValue();
               if(categoryValue&&categoryValue.length>0){
                    categoryId=categoryValue[0].id;
               }else{
                   categoryId=CATEGORY_ID;
               }
            }else{
                categoryId=CATEGORY_ID;
            }
            var value = {};
            value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
            value.status={ inputType:"select_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr") };
            value.assetCode={ inputType:"button",value: $("#assetCode").val()};
            value.assetStatus={ inputType:"select_box", value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr") };
            value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
            value.manufacturerId={ inputType:"select_box", value: xmSelect.get("#manufacturerId",true).getValue("value") ,fillBy:["manufacturer"]   , label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
            value.model={ inputType:"button",value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
            value.serialNumber={ inputType:"button",value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
            value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text() };
            value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text() };
            value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text() };
            value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
            value.positionId={ inputType:"select_box", value: xmSelect.get("#positionId",true).getValue("value") ,fillBy:["position"]  ,  label:xmSelect.get("#positionId",true).getValue("nameStr") };
            value.sourceId={ inputType:"select_box", value: xmSelect.get("#sourceId",true).getValue("value") ,fillBy:["source"]  , label:xmSelect.get("#sourceId",true).getValue("nameStr") };
            value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
            value.assetNotes={ inputType:"button",value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
            value.maintainerId={ inputType:"select_box", value: xmSelect.get("#maintainerId",true).getValue("value") ,fillBy:["maintnainer"]  ,  label:xmSelect.get("#maintainerId",true).getValue("nameStr") };

            var ps={searchField: "$composite", searchValue: JSON.stringify(value)};
            var downloadUrl="/service-eam/eam-asset/export-excel";
            if(categoryId){
                ps.categoryId=categoryId;
            }
            ps.ownerCode=OWNER_CODE;
            fox.submit(downloadUrl,ps,"post",function(r){
                console.log("execute finish",r,"r");
            });


        },

        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            if(APPROVAL_REQUIRED){
                var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                toolHtml=toolHtml.replace(/lay-event="batchConfirm"/i, "style=\"display:none\"")
                document.getElementById("toolbarTemplate").innerHTML=toolHtml;
            }else{
                var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                toolHtml=toolHtml.replace(/lay-event="batchRevoke"/i, "style=\"display:none\"")
                toolHtml=toolHtml.replace(/lay-event="forBatchApproval"/i, "style=\"display:none\"")
                document.getElementById("toolbarTemplate").innerHTML=toolHtml;
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
            param.title="组织/人员选择对话框";
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

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(value==null) return "";
            return value;
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


        forBatchApproval:function(data,item){
            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            var api=moduleURL+"/for-batch-approval";
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api,data,function (r){
                    if (r.success) {
                        top.layer.msg("操作成功", {time: 2000});
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
                },{delayLoading:1000,elms:[$("#forBatchApproval-button")]});
            });
        },
        batchRevokeOperation:function(data,item){
            if(data.length==0){
                top.layer.msg("请选择要操作的资产数据!");
                return ;
            }
            var api=moduleURL+"/batch-revoke-operation";
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, data, function (r) {
                    if (r.success) {
                        top.layer.msg("操作成功", {time: 2000});
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

                }, {delayLoading: 1000, elms: [$("#batchRevoke-button")]});
            });
        },

        showEditBoxForm:function(data,sourceId,boxType) {
            console.log("#######showEditBoxForm#########")
            console.log(data)
            console.log(sourceId)
            console.log(boxType)
            var action="view";
            var queryString="?boxType="+boxType+"&sourceId="+sourceId;
            if(data&&data.id) {
                queryString=queryString+'&id=' + data.id;
                action="edit";
            }else{
                action="create";
            }
            admin.putTempData('ops-ciphertext-box-data-form-data', data);
            admin.putTempData('ops-ciphertext-box-data-form-data-form-action', action,true);
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
            var boxType="asset";
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

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {

            if(!ASSET_CODE_AUTO_CREATE){
                setTimeout(function(){
                    $("#assetCode").removeAttr("disabled");
                    $("#assetCode").removeAttr("style");
                    $("#assetCode").attr("placeholder","请输入资产编号");
                    $("#assetCodeLabel").html("<div>资产编号</div><div class=\"layui-required\">*</div>")
                },200)
            }
            $("#ownCompanyId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#useOrganizationId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#managerId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#useUserId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});


            if( $("#attribution-tab-ct").find(".layui-form-item").length==0 ){
                $("#attribution-tab-ct").hide();
                $("#attribution-tab").hide();
            }
            if( $("#maintainer-tab-ct").find(".layui-form-item").length==0 ){
                $("#maintainer-tab-ct").hide();
                $("#maintainer-tab").hide();
            }
            if( $("#financial-tab-ct").find(".layui-form-item").length==0 ){
                $("#financial-tab-ct").hide();
                $("#financial-tab").hide();
            }
            if( $("#equipment-tab-ct").find(".layui-form-item").length==0 ){
                $("#equipment-tab-ct").hide();
                $("#equipment-tab").hide();
            }
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            if($("#assetCode")){
                $("#assetCode").attr("disabled","disabled").css("background-color","#e6e6e6");
            }
            if(data&&data.id){
                setTimeout(function() {
                    var assetCategorySelect = xmSelect.get('#categoryId', true);
                    if (assetCategorySelect) {
                        assetCategorySelect.update({disabled: true})
                    }
                },500);
                if(!ASSET_DIRECT_UPDATE_MODE){
                    fox.lockForm($("#data-form"),true);
                }
                if("view"==formAction){
                    $('#data-form').find("input").attr('placeholder','');
                }
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
                if(ASSET_DEFAULT_OWN_COMPANY&&ASSET_DEFAULT_OWN_COMPANY.id){

                    $('#ownCompanyId-button').find("span").each(function (index, e) {
                        $(e).html(ASSET_DEFAULT_OWN_COMPANY.fullName);
                        // var not_Btn=$(e).find("i");
                        // if(not_Btn.length>0){
                        //     var txt = $(e).text();
                        //     // if (txt && txt.length > 0 && txt.includes("选择")) {
                        //
                        //     //}
                        // }
                    })
                    $('#ownCompanyId').val(ASSET_DEFAULT_OWN_COMPANY.id);

                }
            }

            if(ASSET_STATUS_COLUMN_DISABLE){
                setTimeout(function(){
                    var assetStatusSelect= xmSelect.get('#assetStatus',true);
                    if(assetStatusSelect){
                        assetStatusSelect.update({disabled:true})
                    }
                },500)
            }

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
            param.title="组织/人员选择对话框";
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
            console.log("beforeSubmit",data);
            data.ownerCode=OWNER_CODE;
            data.internalControlLabel=INTERNAL_CONTROL_LABEL;
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
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