/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
	var settings,admin,table,layer,util,fox,upload,xmSelect,echarts;

	const moduleURL="/service-ops/ops-database";
	//模块基础路径
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {
		admin = layui.admin,settings = layui.settings,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
		echarts=layui.echarts;
		var db_software_info_show = echarts.init(document.getElementById('db_software_info_show'));
		var db_software_info_pie = echarts.init(document.getElementById('db_software_info_pie'));
		var task=setTimeout(function(){layer.load(2);},1000);
		var ps={};
		ps.code="db_software_count,db_software_type"
		admin.request(moduleURL+"/query-database-data", ps, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if(data.success){
				var assetData=data.data;
				if(assetData.db_software_count&&assetData.db_software_count.count>0){
					$("#db_software_count").html(assetData.db_software_count.count);
				}

				//分布
				var typeData=assetData.db_software_type;
				var html="<tr>\n" +
					"<th>名称</th>\n" +
					"<th>数量</th>\n" +
					"</tr>";
				if(typeData.data){
					for(var i=0;i<typeData.data.length;i++){
						html=html+" <tr>\n" +
							"    <td>"+typeData.data[i].categoryName+"</td>\n" +
							"    <td>"+typeData.data[i].cnt+"</td>\n" +
							"  </tr>"
					}
				}
				$("#db_software_info").html(html);

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
						data: typeData.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '数量',
						type: 'bar', //柱状
						data: typeData.dataList,
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
				db_software_info_show.setOption(optionchart, true);
				db_software_info_pie.setOption({
					color: defColor,
					series : [
						{
							name: '数据库分布占比',
							type: 'pie',    // 设置图表类型为饼图
							radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
							label:{
								normal:{
									show:true,
									formatter:'{b}:{c}({d}%)'
								}
							},
							data:typeData.pieData
						}
					]
				})
			}else{
				alert("获取数据失败!");
			}
		});

		var db_size_show = echarts.init(document.getElementById('db_size_show'));
		var db_info_show = echarts.init(document.getElementById('db_info_show'));
		var db_info_pie = echarts.init(document.getElementById('db_info_pie'));
		var task2=setTimeout(function(){layer.load(2);},1000);
		var pps={};
		pps.code="db_count,db_type,db_size"
		admin.request(moduleURL+"/query-database-data", pps, function (data) {
			clearTimeout(task2);
			layer.closeAll('loading');
			if(data.success){
				var assetData=data.data;
				if(assetData.db_count&&assetData.db_count.count>0){
					$("#db_count").html(assetData.db_count.count);
				}

				//分布
				var typeData=assetData.db_type;
				var html="<tr    >\n" +
					"<th >名称</th>\n" +
					"<th>数量</th>\n" +
					"</tr>";
				if(typeData.data){
					for(var i=0;i<typeData.data.length;i++){
						html=html+" <tr>\n" +
							"    <td>"+typeData.data[i].categoryName+"</td>\n" +
							"    <td>"+typeData.data[i].cnt+"</td>\n" +
							"  </tr>"
					}
				}
				$("#db_info").html(html);

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
						data: typeData.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '数量',
						type: 'bar', //柱状
						data: typeData.dataList,
						label:{
							normal:{
								show:true,
								position:"top",
							}
						},
						itemStyle: {
							normal: { //柱子颜色
								color: '#9966FF'
							}
						},
					}]
				};
				db_info_show.setOption(optionchart, true);

				var sizeData=assetData.db_size;
				var optionchart2 = {
					color: defColor,
					title: {
						text: ''
					},
					tooltip: {},
					legend: {
						data: ['大小(M)']
					},
					xAxis: {
						data: sizeData.labelList
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '大小(M)',
						type: 'bar', //柱状
						data: sizeData.dataList,
						label:{
							normal:{
								show:true,
								position:"top",
							}
						},
						itemStyle: {
							normal: { //柱子颜色
								color: '#6699CC'
							}
						},
					}]
				};
				db_size_show.setOption(optionchart2, true);

				db_info_pie.setOption({
					color: defColor,
					series : [
						{
							name: '数据库分布态占比',
							type: 'pie',    // 设置图表类型为饼图
							radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
							label:{
								normal:{
									show:true,
									formatter:'{b}:{c}({d}%)'
								}
							},
							data:typeData.pieData
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