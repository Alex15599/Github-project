package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CCustRepairApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 报修申请模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 13:45:49
*/

@Controller("EamCCustRepairApplyPageController")
@RequestMapping(CCustRepairApplyPageController.prefix)
public class CCustRepairApplyPageController extends ViewController {

	public static final String prefix="business/eam/c_cust_repair_apply";

	private CCustRepairApplyServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CCustRepairApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=CCustRepairApplyServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 报修申请 功能主页面
	 */
	@RequestMapping("/c_cust_repair_apply_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"c_cust_repair_apply_list");
	}

	/**
	 * 报修申请 功能主页面
	 */
	@RequestMapping("/c_cust_repair_apply_list_public.html")
	public String listPublic(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"c_cust_repair_apply_list_public");
	}


	/**
	 * 报修申请 表单页面
	 */
	@RequestMapping("/c_cust_repair_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_repair_apply_form");
	}



	@RequestMapping("/c_cust_repair_apply_form_public.html")
	public String formPublic(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_repair_apply_form_public");
	}

	/**
	 * 报修申请 表单页面
	 */
	@RequestMapping("/c_cust_repair_apply_form_full.html")
	public String formFull(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_repair_apply_form_full");
	}

	/**
	 * 报修申请 表单页面
	 */
	@RequestMapping("/c_cust_repair_apply_form_full_p.html")
	public String formFullP(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_repair_apply_form_full_p");
	}
}