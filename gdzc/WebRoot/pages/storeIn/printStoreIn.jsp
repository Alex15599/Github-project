<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.awt.*,com.niuys.gdzc.model.*,java.util.*,java.text.*"%>
<%@ page import="com.javareport.beans.*"%>
<%@ page extends="com.javareport.http.WebReportEngine"%> 
<%!

public Report createReport(HttpServletRequest request) throws Exception{
	ArrayList<ZcInfo> list =(ArrayList)request.getAttribute("list");
    //实例化报表对象
    Report report = new Report(); 
    //在页眉中添加文本信息内容
    report.addHeaderText("打印入库单");
    //在报表的页眉添加一条横直线
    report.addHeaderSeparator(1);
    //在页尾添加一条横直线 
    report.addFooterSeparator(1);
    //在页尾添加文本信息内容
    report.addFooterText("第{P}页， 共{N}页");
    
	//在报表中添加文本信息内容
    report.addText("入库单一览表：");
    //在报表中添加换行符号
    report.addBreak();
    //在报表中添加表格
    report.addTable(getTableA(list));
    //在报表中添加换行符号
    report.addBreak();
	
	//在报表中添加文本信息内容
    //report.addText("销售情况一览表(合并表格)：");
    //在报表中添加换行符号
    //report.addBreak();
    //在报表中添加表格
    //report.addTable(getTableB());
    //在报表中添加换行符号
    //report.addBreak();
	
    return report;
}
//------得到销售情况一览表对象------
public Table getTableA(ArrayList<ZcInfo> list){
    String[][] data = getData(list);
    Table table = new Table(data);
    table.setColBorder(0);
    table.setRowBorder(0);
    table.setRowBorder(0,1);
    table.setRowBackground(0,new Color(128,0,0));
    table.setRowForeground(0,Color.white);
    for(int i =1 ;i<=list.size() ;i++){
    	if(i%2==0) {
    	   table.setRowBackground(i,new Color(188,224,222));
    	}    		
  		 table.setRowForeground(i,Color.black);
  	}
    return table;
}
//------得到销售情况一览表(合并表格)对象------
public Table getTableB(){
    String[][] data = getTotalData();
    Table table = new Table(data);
    table.setAlignment(Table.H_CENTER + Table.V_CENTER);
    table.setColAutoSize(true);
    table.setRowBackground(0,Color.LIGHT_GRAY);
    table.setRowBackground(1,Color.LIGHT_GRAY);
    table.setColBackground(0,Color.LIGHT_GRAY);
    table.setRowBackground(7,new Color(255,255,128));
    table.setHeaderRowCount(2);
    table.setHeaderColCount(1);
    table.setRowBorder(table.LINE_THIN);
    table.setColBorder(table.LINE_THIN);
    table.setCellSpan(0,0,new Dimension(1,2));
    table.setCellSpan(0,1,new Dimension(2,1));
    table.setCellSpan(0,3,new Dimension(2,1));
    table.setCellSpan(0,3,new Dimension(2,1));
    return table;
}

//生成销售情况数据,实际工程中一般从数据库中获取
public String[][] getData(ArrayList<ZcInfo> list){
     String[][] data = new String[list.size()+1][9];
		   data[0][0] = "资产编号"; data[0][1] = "资产名称"; data[0][2] = "资产类型"; 
		   data[0][3] = "供应商";data[0][4] = "单价";
		   data[0][5] = "出产日期";data[0][6] = "购买日期";data[0][7] = "购买者";data[0][8] = "资产状态";
		   for(int i =1 ; i<=list.size() ; i++){
		    data[i][0] = list.get(i-1).getZcId(); 
		    data[i][1] = list.get(i-1).getZcName(); 
		    data[i][2] = list.get(i-1).getZcType(); 
		    data[i][3] = list.get(i-1).getZcFactory();
		    data[i][4] = list.get(i-1).getZcPrice()+"";
		    data[i][5] = list.get(i-1).getZcProduceTime(); 
		    data[i][6] = list.get(i-1).getZcBuyTime(); 
		    data[i][7] = list.get(i-1).getZcBuyer();
		    data[i][8] =list.get(i-1).getZcStatus();   
		   }
		                    
 
    return data;
}
//得到销售汇总统计数据,实际工程中一般从数据库中获取
public String[][] getTotalData(){
    String[][] data = new String[8][5];
    data[0][0] = "区域"; data[0][1] = "上半年"; data[0][3] = "下半年";
    data[1][1] = "第一季度"; data[1][2] = "第二季度"; data[1][3] = "第三季度";data[1][4] = "第四季度";
    data[2][0] = "华南地区"; data[2][1] = "￥2,000,000"; data[2][2] = "￥2,500,000";
	 data[2][3] = "￥2,200,000";data[2][4] = "￥0";
    data[3][0] = "华东地区"; data[3][1] = "￥6,000,000"; data[3][2] = "￥4,500,000";
	 data[3][3] = "￥4,800,000";data[3][4] = "￥0";
    data[4][0] = "华中地区"; data[4][1] = "￥500,000"; data[4][2] = "￥400,000";
	data[4][3] = "￥700,000";data[4][4] = "￥0";
    data[5][0] = "华北地区"; data[5][1] = "￥3,000,000"; data[5][2] = "￥3,200,000";
	data[5][3] = "￥2,500,000";data[5][4] = "￥0";
    data[6][0] = "东北地区"; data[6][1] = "￥4,000,000"; data[6][2] = "￥5,000,000";
	 data[6][3] = "￥4,400,000";data[6][4] = "￥0";
    data[7][0] = "总计"; data[7][1] = "￥15,500,000"; data[7][2] = "￥15,600,000";
	data[7][3] = "￥14,600,000";data[7][4] = "￥0";
    return data;
}
//定制Web报表在页面首部显示的工具栏为标准的样式,增加一个"返回"按钮,返回到首页
public String getToolbarScript(HttpServletRequest request){
    return "<a href=\"/hms/storeInShowAll.do\"><img src=\""+request.getRequestURI()+
	"?op=Resource&name=/resource/back.gif\" border=\"0\" alt=\"返回\"></a>";
}
%>
