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

        $("#serverApply").click(function(){
            admin.putTempData('eam-asset-employee-apply-form-data', {});
            bpm.openProcessView(null,null,false,{"formDefinitionCode":"wo_server_apply"},refreshTableData,refreshRowData,"bill");
        })


        $("#networkApply").click(function(){
            admin.putTempData('wo-server-apply-form-data', {});
            bpm.openProcessView(null,null,false,{"formDefinitionCode":"wo_network_strategy_apply"},refreshTableData,refreshRowData,"bill");


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