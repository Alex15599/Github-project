/**
 * 软件信息 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 09:04:13
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-mobile/app-software-info";
	var dataTable=null;
	var sort=null;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

		if(window.pageExt.list.beforeInit) {
			window.pageExt.list.beforeInit();
		}
		initData();

     }

     function initData(){
		var api="/service-mobile/app-software-group/query-list";
		var param={};
		 param.groupCode="eam_mobile"
		 admin.post(api, param, function (data) {
			 if (data.success) {
			 	 if(data.data&&data.data.length==1){
			 	 	var group=data.data[0];
			 	 	var list=group.softwareInfoList;
			 	 	if(list&&list.length>0){
			 	 		var html="";
			 	 		for(var i=0;i<list.length;i++){
							var soft=list[i];
							if(soft.status=="enable"){
								//http://127.0.0.1:8089/service-storage/sys-file/download?id=593457868280172544&inline=0

								// <div className="box">
								// 	<div className="boxItem">
								// 		<div className="boxPng">
								// 			<image className="boxPngValue"
								// 				   src="/assets/libs/image/employee_dashboard/zcly.png" alt=""/>
								// 		</div>
								// 		<div className="boxLabel">
								// 			苹果移动端下载
								// 		</div>
								// 	</div>
								// </div>
								html= html+"    <div class=\"box\">\n" +
									"                            <div class=\"boxItem\">\n" +
									"                                <div class=\"boxPng\">\n" +
									"                                    <image class=\"boxPngValue\" src=\"/assets/libs/image/employee_dashboard/zcly.png\" alt=\"\" />\n" +
									"                                </div>\n" +
									"                                <div class=\"boxLabel\">\n" +
									 "<a href=\"/service-storage/sys-file/download?id="+soft.fileId+"&inline=0\"> "+soft.name+"下载</a>"+
									"                                </div>\n" +
									"                            </div>\n" +
									"                        </div>"
							}
						}
			 	 		console.log(html);
			 	 		$("#downList").html(html);

					}else{
			 	 		console.log("soft is blank")
					}
				 }
			 } else {
			 }
		 }, {delayLoading:1000,elms:[]});

    };

     /**
      * 渲染表格
      */
    function renderTable() {

    };

	/**
	 * 刷新单号数据
	 * */
	function refreshRowData(data,remote) {

	}

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {

	}


	/**
	  * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	  */
	function getCheckedList(field) {

	}

	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {
		$('#search-field').val("");
		$('#search-input').val("");
		layui.form.render();
	}

	function initSearchFields() {


	}

	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {

	}

	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {

	}

    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {

    };

    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {

	};

	window.module={
		refreshTableData: refreshTableData,
		refreshRowData: refreshRowData,
		getCheckedList: getCheckedList,
		showEditForm: showEditForm
	};

	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});