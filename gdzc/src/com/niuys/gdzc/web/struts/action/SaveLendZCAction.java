package com.niuys.gdzc.web.struts.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcInout;
import com.niuys.gdzc.web.struts.form.ZCForm;

public class SaveLendZCAction extends BaseAction {	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		ZcInout inout=new ZcInout();
		ZcInfo info=new ZcInfo();
		
		SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
		formatter.applyPattern("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String outTime = formatter.format(cal.getTime());
		
		//计算应还资产日期
		String[] outTime_numbers = outTime.split("-");
		int outTime_year = Integer.parseInt(outTime_numbers[0]);
		int outTime_month = Integer.parseInt(outTime_numbers[1]);
		int outTime_date = Integer.parseInt(outTime_numbers[2]);
		
		int shouldTime_year = 0;
		int shouldTime_month = 0;
		int shouldTime_date = 0;
		
		if(outTime_month==11){
			shouldTime_year=outTime_year+1;
			shouldTime_month=1;
			shouldTime_date=outTime_date;
		}else if(outTime_month==12){
			shouldTime_year=outTime_year+1;
			shouldTime_month=2;
		}else{
			shouldTime_year=outTime_year;
			shouldTime_month=outTime_month+2;
			shouldTime_date=outTime_date;			
		}
		
		String shouldTime=shouldTime_year+"-"+shouldTime_month+"-"+shouldTime_date;		
		String zcId=request.getParameter("zc_id");
		String comployeeNo=request.getParameter("em_id");
		
		info.setZcId(zcId);
		
		inout.setComployeeNo(comployeeNo);
		inout.setOutTime(outTime);
		inout.setShouldTime(shouldTime);
		inout.setZcInfo(info);
		
		
		if(inOutAssetManagerImpl.outZC(inout, zcId)){
			return mapping.findForward("success");
		}
		return mapping.findForward("fail");
	}
}
