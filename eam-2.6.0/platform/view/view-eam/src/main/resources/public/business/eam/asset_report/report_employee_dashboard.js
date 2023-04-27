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

        var api=moduleURL+"/query-asset-data-by-label";
        var param={}
        param.label="myAssetCountData,myAssetBusinessCountData";
        admin.post(api, param, function (data) {
            if (data.success) {
                var coutData=data.data.myAssetCountData;
                $("#myAssetCount").html(coutData.assetTotalCount);
                var businessData=data.data.myAssetBusinessCountData;
                $("#myBusinessCount").html(businessData.businessCount);

            } else {
            }
        }, {delayLoading:1000,elms:[]});



        $("#myasset").click(function(){

            admin.popupCenter({
                title: "我的资产",
                resize: false,
                offset: [null,null],
                area: ["80%","500px"],
                type: 2,
                id:"eam-asset-employee-myasset-form-data-win",
                content: '/business/eam/daily_management/myAsset_list.html',
                finish: function () {
                }
            });
        })

        function refreshTableData(){

        }
        function refreshRowData(){

        }

        $("#zcly").click(function(){
            admin.putTempData('eam-asset-employee-apply-form-data', {});

            var ps={
                title:"资产申请",
                priority:"normal", // priority 的可选值 urgency，normal
                displayTitle:true,
                displayPriority:false,
                displayDraftComment:false,
                displayApprovalComment:true,
            }

            bpm.openProcessView(null,null,false,{"formDefinitionCode":"eam_asset_employee_apply"},refreshTableData,refreshRowData,"bill",ps);
        })


        $("#zcjj").click(function(){
            var ps={
                title:"资产交接申请",
                priority:"normal", // priority 的可选值 urgency，normal
                displayTitle:true,
                displayPriority:false,
                displayDraftComment:false,
                displayApprovalComment:true,
            }
            admin.putTempData('eam-asset-employee-handover-form-data', {});
            bpm.openProcessView(null,null,false,{"formDefinitionCode":"eam_asset_employee_handover"},refreshTableData,refreshRowData,"bill",ps);


        })


        $("#zcbs").click(function(){
            var ps={
                title:"资产报失申请",
                priority:"normal", // priority 的可选值 urgency，normal
                displayTitle:true,
                displayPriority:false,
                displayDraftComment:false,
                displayApprovalComment:true,
            }
            admin.putTempData('eam-asset-employee-loss-form-data', {});
            bpm.openProcessView(null,null,false,{"formDefinitionCode":"eam_asset_employee_loss"},refreshTableData,refreshRowData,"bill",ps);

        })


        $("#zcbx").click(function(){
            var ps={
                title:"资产报修申请",
                priority:"normal", // priority 的可选值 urgency，normal
                displayTitle:true,
                displayPriority:false,
                displayDraftComment:false,
                displayApprovalComment:true,
            }
            admin.putTempData('eam-asset-employee-repair-form-data', {});
            bpm.openProcessView(null,null,false,{"formDefinitionCode":"eam_asset_employee_repair"},refreshTableData,refreshRowData,"bill",ps);

        })

        $("#softdownload").click(function(){

            var data={};
            queryString="?groupCode=eam_mobile"
            admin.popupCenter({
                title: "移动端下载",
                resize: false,
                offset: [2,null],
                area: ["80%","85%"],
                type: 2,
                id:"eam-asset-employee-repair-form-data-win",
                content: '/business/mobile/software_info/software_download_list.html' + queryString,
                finish: function () {

                }
            });
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