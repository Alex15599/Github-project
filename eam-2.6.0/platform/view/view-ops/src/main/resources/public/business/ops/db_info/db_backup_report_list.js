/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
	var settings,admin,form,table,layer,util,fox,upload;
	var echarts;

	const moduleURL="/service-ops/ops-database";
	var dataTable=null;
	var sort=null;
	//模块基础路径
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,dropdown=layui.dropdown;

		echarts=layui.echarts;

		var backup_result_dist_show = echarts.init(document.getElementById('backup_result_dist_show'));
		var backup_result_dist_pie = echarts.init(document.getElementById('backup_result_dist_pie'));

		var task=setTimeout(function(){layer.load(2);},1000);
		var ps={};
		ps.code="backup_count,task_count,backup_result_dist,backup_task_setting_none_count,db_backup_info_today"
		admin.request(moduleURL+"/query-database-data", ps, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if(data.success){


				var assetData=data.data;
				if(assetData.backup_count&&assetData.backup_count.count>0){
					$("#backup_count").html(assetData.backup_count.count);
				}

				if(assetData.task_count&&assetData.task_count.count>0){
					$("#task_count").html(assetData.task_count.count);
				}

				if(assetData.backup_task_setting_none_count&&assetData.backup_task_setting_none_count.count>0){
					$("#backup_task_setting_none_count").html(assetData.backup_task_setting_none_count.count);
				}
				if(assetData.db_backup_info_today&&assetData.db_backup_info_today.data) {
					var d = assetData.db_backup_info_today.data;
					$("#backupNoneCount").html(d.backupNoneCount);
					$("#backupSuccessCount").html(d.backupSuccessCount);
					$("#backupFailedCount").html(d.backupFailedCount);
					$("#backupDataSize").html(d.backupDataSize);
				}


				var backup_result_dist_data=assetData.backup_result_dist;
				var defColor=['#8095FE','#D9E0E3','#7DD699','#F8CE52','#EF9590'];
				//分类
				var optionchart = {
					color: defColor,
					title: {
						text: ''
					},
					tooltip: {},
					legend: {
						data: ['数量']
					},
					xAxis: {
						data: backup_result_dist_data.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '数量',
						type: 'bar', //柱状
						data: backup_result_dist_data.dataList,
						label:{
							normal:{
								show:true,
								position:"top",
							}
						},
						itemStyle: {
							normal: { //柱子颜色
								color: '#7CD8A5'
							}
						},
					}]
				};
				backup_result_dist_show.setOption(optionchart, true);

				backup_result_dist_pie.setOption({
					color: defColor,
					series : [
						{
							name: '数据库任务执行占比',
							type: 'pie',    // 设置图表类型为饼图
							radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
							label:{
								normal:{
									show:true,
									formatter:'{b}:{c}({d}%)'
								}
							},
							data:backup_result_dist_data.pieData
						}
					]
				})
			}else{
				alert("获取数据失败!");
			}
		});


		var backup_count_trend = echarts.init(document.getElementById('backup_count_trend'));
		var backup_failed_count_trend = echarts.init(document.getElementById('backup_failed_count_trend'));
		var db_backup_time_top = echarts.init(document.getElementById('db_backup_time_top'));

		var task2=setTimeout(function(){layer.load(2);},1000);
		var pps={};
		pps.code="backup_count_trend,backup_failed_count_trend,db_backup_time_top"
		admin.request(moduleURL+"/query-database-data", pps, function (data) {
			clearTimeout(task2);
			layer.closeAll('loading');
			if(data.success){
				var assetData=data.data;

				var db_backup_time_top_data=assetData.db_backup_time_top;
				var defColor=['#8095FE','#D9E0E3','#7DD699','#F8CE52','#EF9590'];

				var optionchart3 = {
					color: defColor,
					title: {
						text: ''
					},
					tooltip: {},
					legend: {
						data: ['时间(分)']
					},
					xAxis: {
						data: db_backup_time_top_data.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '时间(分)',
						type: 'bar', //柱状

						data: db_backup_time_top_data.dataList,
						label:{
							normal:{
								show:true,
								position:"top",
							}
						},
						itemStyle: {
							normal: { //柱子颜色
								color: '#7CD8A5'
							}
						},
					}]
				};
				db_backup_time_top.setOption(optionchart3, true);

				var backup_count_trend_data=assetData.backup_count_trend;
				var defColor=['#8095FE','#D9E0E3','#7DD699','#F8CE52','#EF9590'];
				//分类
				var optionchart = {
					color: defColor,
					title: {
						text: ''
					},
					tooltip: {},
					legend: {
						data: ['数量']
					},
					xAxis: {
						data: backup_count_trend_data.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '数量',
						type: 'line', //柱状

						data: backup_count_trend_data.dataList,
						label:{
							normal:{
								show:true,
								position:"top",
							}
						},
						itemStyle: {
							normal: { //柱子颜色
								color: '#7CD8A5'
							}
						},
					}]
				};
				backup_count_trend.setOption(optionchart, true);


				var backup_failed_count_trend_data=assetData.backup_failed_count_trend;
				var defColor=['#FF0000','#D9E0E3','#7DD699','#F8CE52','#EF9590'];
				//分类
				var optionchart2 = {
					color: defColor,
					title: {
						text: ''
					},
					tooltip: {},
					legend: {
						data: ['数量']
					},
					xAxis: {
						data: backup_failed_count_trend_data.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '数量',
						type: 'line', //柱状

						data: backup_failed_count_trend_data.dataList,
						label:{
							normal:{
								show:true,
								position:"top",
							}
						},
						itemStyle: {
							normal: { //柱子颜色
								color: '#FF0000'
							}
						},
					}]
				};
				backup_failed_count_trend.setOption(optionchart2, true);

			}else{
				alert("获取数据失败!");
			}
		});




		 renderTable();
	}



	function renderTable() {
		// $(window).resize(function() {
		// 	fox.adjustSearchElement();
		// });
		// fox.adjustSearchElement();
		//
		var marginTop=$(".search-bar").height()+$(".search-bar").css("padding-top")+$(".search-bar").css("padding-bottom")
		$("#table-area").css("margin-top",marginTop+"px");
		//
		function renderTableInternal() {

			var ps={searchField: "$composite"};
			var contitions={};


			ps.code="db_backup_info_detail_list";
			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			var tableConfig={
				elem: '#data-table',
			//	toolbar: '#toolbarTemplate',
			//	defaultToolbar: ['filter',{title: fox.translate('刷新数据','','cmp:table'),layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-database-data',
				height: 'full-'+(h+28),
				limit: 1000,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' }
					,{ field: 'hostName', align:"left",fixed:false,  hide:false, sort: true  , title: '主机名' , templet: function (d) { return templet('hostName',d.hostName,d);}  }
					,{ field: 'hostIp', align:"left",fixed:false,  hide:false, sort: true  , title: '主机IP', templet: function (d) { return templet('hostIp',d.hostIp,d);}  }
					,{ field: 'dbInfoName', align:"left",fixed:false,  hide:false, sort: true  , title: '数据库名' , templet: function (d) { return templet('dbInfoName',d.dbInfoName,d);}  }
					,{ field: 'backupSize', align:"left",fixed:false,  hide:false, sort: true  , title: '备份大小', templet: function (d) { return templet('backupSize',d.backupSize,d);}  }
					,{ field: 'backupStime', align:"left",fixed:false,  hide:false, sort: true  , title: '备份开始时间', templet: function (d) { return templet('backupStime',d.backupStime,d);}  }
					,{ field: 'backupEtime', align:"left",fixed:false,  hide:false, sort: true  , title: '备份结束时间' , templet: function (d) { return templet('backupEtime',d.backupEtime,d);}  }
					,{ field: 'backupResult', align:"left",fixed:false,  hide:false, sort: true  , title: '备份结果', templet: function (d) { return templet('backupResult',d.backupResult,d);}  }
				]],
				parseData:function(res){
					console.log("parese res:",res);
					var d=res.data.db_backup_info_detail_list.data;
					return {
						"code": res.code == "00" ? 0 : -1, //解析接口状态
						"msg": res.message, //解析提示文本
						"count": d.length, //解析数据长度
						"data": d //解析数据列表
					};
				},
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
				footer : {
				}
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			dataTable=fox.renderTable(tableConfig);
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
				refreshTableData(obj.sortField,obj.type);
			});
			window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
		}
		setTimeout(renderTableInternal,1);
	};


};

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});

//
// layui.use(['echarts', 'util', 'settings','admin'],function() {
// 	var task=setInterval(function (){
// 		if(!window["pageExt"]) return;
// 		clearInterval(task);
// 		(new ListPage()).init(layui);
// 	},1);
// });