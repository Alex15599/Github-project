/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
    var settings,admin,table,layer,util,fox,upload,xmSelect,echarts;

    const moduleURL="/service-eam/eam-asset-report";
    //模块基础路径
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

        $("#djsp").click(function(){
            admin.popupCenter({
                title: "资产登记审批清单",
                resize: false,
                offset: [null,null],
                area: ["80%","500px"],
                type: 2,
                id:"eam-asset-employee-approval-form-data-win",
                content: '/business/eam/asset_data_change/asset_data_change_list.html',
                finish: function () {
                }
            });
        })


        $("#changeJC").click(function(){
            admin.popupCenter({
                title: "资产基础变更审批清单",
                resize: false,
                offset: [null,null],
                area: ["80%","500px"],
                type: 2,
                id:"eam-asset-employee-approval-form-data-win",
                content: '/business/eam/asset_data_change/asset_data_change_list.html?changeType=eam_asset_change_base_info&pageType=approval',
                finish: function () {
                }
            });
        })

        $("#changeWB").click(function(){
            admin.popupCenter({
                title: "资产维保变更审批清单",
                resize: false,
                offset: [null,null],
                area: ["80%","500px"],
                type: 2,
                id:"eam-asset-employee-approval-form-data-win",
                content: '/business/eam/asset_data_change/asset_data_change_list.html?changeType=eam_asset_change_maintenance&pageType=approval',
                finish: function () {
                }
            });
        })

        $("#changeCW").click(function(){
            admin.popupCenter({
                title: "资产财务变更审批清单",
                resize: false,
                offset: [null,null],
                area: ["80%","500px"],
                type: 2,
                id:"eam-asset-employee-approval-form-data-win",
                content: '/business/eam/asset_data_change/asset_data_change_list.html?changeType=eam_asset_change_financial&pageType=approval',
                finish: function () {
                }
            });
        })


        $("#rjdj").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-software-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;
            admin.putTempData('eam-asset-software-form-data', data);
            var area=admin.getTempData('eam-asset-software-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('软件资产');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-software-form-data-win",
                content: '/business/eam/asset_software/asset_software_form.html' + (queryString?("?"+queryString):""),
                finish: function () {
                }
            });
        })


        $("#rjff").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-software-distribute-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;

            admin.putTempData('eam-asset-software-distribute-form-data', data);
            var area=admin.getTempData('eam-asset-software-distribute-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('软件分发');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-software-distribute-form-data-win",
                content: '/business/eam/asset_software_distribute/asset_software_distribute_form.html' + (queryString?("?"+queryString):""),
                finish: function () {

                }
            });


        })


        $("#rjwb").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-software-maintenance-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;

            admin.putTempData('eam-asset-software-maintenance-form-data', data);
            var area=admin.getTempData('eam-asset-software-maintenance-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('软件维保');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-software-maintenance-form-data-win",
                content: '/business/eam/asset_software_maintenance/asset_software_maintenance_form.html' + (queryString?("?"+queryString):""),
                finish: function () {

                }
            });
        })












        $("#zcrk").click(function(){
            var data={};
            var action=admin.getTempData('eam-asset-storage-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString='id=' + data.id;

            admin.putTempData('eam-asset-storage-form-data', data);
            var area=admin.getTempData('eam-asset-storage-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产入库');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                // area: ["100%",height+"px"],
                area: ["100%","100%"],
                type: 2,
                id:"eam-asset-storage-form-data-win",
                content: '/business/eam/asset_storage/asset_storage_form.html' + (queryString?("?"+queryString):""),
                finish: function () {

                }
            });
        })

        $("#zcpf").click(function(){
            var data={}
            var action=admin.getTempData('eam-asset-collection-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString="?" + 'id=' + data.id;

            admin.putTempData('eam-asset-collection-form-data', data);
            var area=admin.getTempData('eam-asset-collection-form-area');

            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产派发');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            var index=admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-collection-form-data-win",
                content: '/business/eam/asset_collection/asset_collection_form.html' + queryString,
                finish: function () {

                }
            });
            admin.putTempData('eam-asset-collection-form-data-popup-index', index);
        })


        $("#zcbf").click(function(){
          var data={}
            var action=admin.getTempData('eam-asset-scrap-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString="?" + 'id=' + data.id;
            admin.putTempData('eam-asset-scrap-form-data', data);
            var area=admin.getTempData('eam-asset-scrap-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产报废');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            var index=admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-scrap-form-data-win",
                content: '/business/eam/asset_scrap/asset_scrap_form.html' + queryString,
                finish: function () {

                }
            });
            admin.putTempData('eam-asset-scrap-form-data-popup-index', index);
        })


        $("#zcdb").click(function(){
            var data={};

            var action=admin.getTempData('eam-asset-allocation-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString="?" + 'id=' + data.id;
            admin.putTempData('eam-asset-allocation-form-data', data);
            var area=admin.getTempData('eam-asset-allocation-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产调拨');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            var index=admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-allocation-form-data-win",
                content: '/business/eam/asset_allocation/asset_allocation_form.html' + queryString,
                finish: function () {

                }
            });
            admin.putTempData('eam-asset-allocation-form-data-popup-index', index);
        })


        $("#zczy").click(function(){
            var data={};

            var action=admin.getTempData('eam-asset-tranfer-form-data-form-action');
            var queryString="";
            if(data && data.id) queryString="?" + 'id=' + data.id;
            admin.putTempData('eam-asset-tranfer-form-data', data);
            var area=admin.getTempData('eam-asset-tranfer-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('资产转移');
            if(action=="create") title=fox.translate('添加')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

            var index=admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["80%",height+"px"],
                type: 2,
                id:"eam-asset-tranfer-form-data-win",
                content: '/business/eam/asset_tranfer/asset_tranfer_form.html' + queryString,
                finish: function () {
                    refreshTableData();
                }
            });
            admin.putTempData('eam-asset-tranfer-form-data-popup-index', index);
        })










    }



};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
    var task=setInterval(function (){
        if(!window["pageExt"]) return;
        clearInterval(task);
        (new ListPage()).init(layui);
    },1);
});