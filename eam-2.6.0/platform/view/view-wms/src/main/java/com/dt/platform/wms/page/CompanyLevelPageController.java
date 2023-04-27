package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.CompanyLevelServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 企业等级模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:47
*/

@Controller("WmsCompanyLevelPageController")
@RequestMapping(CompanyLevelPageController.prefix)
public class CompanyLevelPageController extends ViewController {

	public static final String prefix="business/wms/company_level";

	private CompanyLevelServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CompanyLevelServiceProxy proxy() {
		if(proxy==null) {
			proxy=CompanyLevelServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 企业等级 功能主页面
	 */
	@RequestMapping("/company_level_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"company_level_list");
	}

	/**
	 * 企业等级 表单页面
	 */
	@RequestMapping("/company_level_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"company_level_form");
	}
}