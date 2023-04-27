package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.CompanyAttrServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 企业属性模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:27:01
*/

@Controller("WmsCompanyAttrPageController")
@RequestMapping(CompanyAttrPageController.prefix)
public class CompanyAttrPageController extends ViewController {

	public static final String prefix="business/wms/company_attr";

	private CompanyAttrServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CompanyAttrServiceProxy proxy() {
		if(proxy==null) {
			proxy=CompanyAttrServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 企业属性 功能主页面
	 */
	@RequestMapping("/company_attr_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"company_attr_list");
	}

	/**
	 * 企业属性 表单页面
	 */
	@RequestMapping("/company_attr_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"company_attr_form");
	}
}