/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
	var settings,admin,table,layer,util,fox,upload,xmSelect,echarts;

	const moduleURL="/service-ops/ops-data";
	//模块基础路径
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
		echarts=layui.echarts;
		var host_os_type_show = echarts.init(document.getElementById('host_os_type_show'));
		var host_type_pie = echarts.init(document.getElementById('host_type_pie'));
		var host_backup_method_pie = echarts.init(document.getElementById('host_backup_method_pie'));
		var task=setTimeout(function(){layer.load(2);},1000);
		var ps={};
		ps.code="host_count,host_offline_count,host_database_count,host_type,host_backup_method,host_os_type"
		admin.request(moduleURL+"/query-host-data", ps, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if(data.success){
				var assetData=data.data;
				if(assetData.host_count&&assetData.host_count.count>0){
					$("#host_count").html(assetData.host_count.count);
				}

				if(assetData.host_offline_count&&assetData.host_offline_count.count>0){
					$("#host_offline_count").html(assetData.host_offline_count.count);
				}

				if(assetData.host_database_count&&assetData.host_database_count.count>0){
					$("#host_database_count").html(assetData.host_database_count.count);
				}


				var host_os_type_data=assetData.host_os_type;
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
						data: host_os_type_data.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '数量',
						type: 'bar', //柱状
						data: host_os_type_data.dataList,
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
				host_os_type_show.setOption(optionchart, true);

				//分布
				var host_type_data=assetData.host_type;
				host_type_pie.setOption({
					color: defColor,
					series : [
						{
							name: '主机类型分类占比',
							type: 'pie',    // 设置图表类型为饼图
							radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
							label:{
								normal:{
									show:true,
									formatter:'{b}:{c}({d}%)'
								}
							},
							data:host_type_data.pieData
						}
					]
				})

				var host_backup_method_data=assetData.host_backup_method;
				host_backup_method_pie.setOption({
					color: defColor,
					series : [
						{
							name: '备份方式情况占比',
							type: 'pie',    // 设置图表类型为饼图
							radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
							label:{
								normal:{
									show:true,
									formatter:'{b}:{c}({d}%)'
								}
							},
							data:host_backup_method_data.pieData
						}
					]
				})



			}else{
				alert("获取数据失败!");
			}
		});


	}

};


layui.use(['echarts', 'util', 'settings','admin'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});