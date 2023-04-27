<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.awt.*,com.niuys.gdzc.model.*,java.util.*,java.text.*"%>
<%@ page import="com.javareport.beans.*"%>
<%@ page extends="com.javareport.http.WebReportEngine"%> 
<%!

public Report createReport(HttpServletRequest request) throws Exception{
	ArrayList<ZcInfo> list =(ArrayList)request.getAttribute("list");
    //ʵ�����������
    Report report = new Report(); 
    //��ҳü������ı���Ϣ����
    report.addHeaderText("��ӡ��ⵥ");
    //�ڱ����ҳü���һ����ֱ��
    report.addHeaderSeparator(1);
    //��ҳβ���һ����ֱ�� 
    report.addFooterSeparator(1);
    //��ҳβ����ı���Ϣ����
    report.addFooterText("��{P}ҳ�� ��{N}ҳ");
    
	//�ڱ���������ı���Ϣ����
    report.addText("��ⵥһ����");
    //�ڱ�������ӻ��з���
    report.addBreak();
    //�ڱ�������ӱ��
    report.addTable(getTableA(list));
    //�ڱ�������ӻ��з���
    report.addBreak();
	
	//�ڱ���������ı���Ϣ����
    //report.addText("�������һ����(�ϲ����)��");
    //�ڱ�������ӻ��з���
    //report.addBreak();
    //�ڱ�������ӱ��
    //report.addTable(getTableB());
    //�ڱ�������ӻ��з���
    //report.addBreak();
	
    return report;
}
//------�õ��������һ�������------
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
//------�õ��������һ����(�ϲ����)����------
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

//���������������,ʵ�ʹ�����һ������ݿ��л�ȡ
public String[][] getData(ArrayList<ZcInfo> list){
     String[][] data = new String[list.size()+1][9];
		   data[0][0] = "�ʲ����"; data[0][1] = "�ʲ�����"; data[0][2] = "�ʲ�����"; 
		   data[0][3] = "��Ӧ��";data[0][4] = "����";
		   data[0][5] = "��������";data[0][6] = "��������";data[0][7] = "������";data[0][8] = "�ʲ�״̬";
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
//�õ����ۻ���ͳ������,ʵ�ʹ�����һ������ݿ��л�ȡ
public String[][] getTotalData(){
    String[][] data = new String[8][5];
    data[0][0] = "����"; data[0][1] = "�ϰ���"; data[0][3] = "�°���";
    data[1][1] = "��һ����"; data[1][2] = "�ڶ�����"; data[1][3] = "��������";data[1][4] = "���ļ���";
    data[2][0] = "���ϵ���"; data[2][1] = "��2,000,000"; data[2][2] = "��2,500,000";
	 data[2][3] = "��2,200,000";data[2][4] = "��0";
    data[3][0] = "��������"; data[3][1] = "��6,000,000"; data[3][2] = "��4,500,000";
	 data[3][3] = "��4,800,000";data[3][4] = "��0";
    data[4][0] = "���е���"; data[4][1] = "��500,000"; data[4][2] = "��400,000";
	data[4][3] = "��700,000";data[4][4] = "��0";
    data[5][0] = "��������"; data[5][1] = "��3,000,000"; data[5][2] = "��3,200,000";
	data[5][3] = "��2,500,000";data[5][4] = "��0";
    data[6][0] = "��������"; data[6][1] = "��4,000,000"; data[6][2] = "��5,000,000";
	 data[6][3] = "��4,400,000";data[6][4] = "��0";
    data[7][0] = "�ܼ�"; data[7][1] = "��15,500,000"; data[7][2] = "��15,600,000";
	data[7][3] = "��14,600,000";data[7][4] = "��0";
    return data;
}
//����Web������ҳ���ײ���ʾ�Ĺ�����Ϊ��׼����ʽ,����һ��"����"��ť,���ص���ҳ
public String getToolbarScript(HttpServletRequest request){
    return "<a href=\"/hms/storeInShowAll.do\"><img src=\""+request.getRequestURI()+
	"?op=Resource&name=/resource/back.gif\" border=\"0\" alt=\"����\"></a>";
}
%>
