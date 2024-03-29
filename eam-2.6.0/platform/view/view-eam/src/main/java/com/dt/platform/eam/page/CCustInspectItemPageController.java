package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CCustInspectItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 10:22:08
*/

@Controller("EamCCustInspectItemPageController")
@RequestMapping(CCustInspectItemPageController.prefix)
public class CCustInspectItemPageController extends ViewController {

	public static final String prefix="business/eam/c_cust_inspect_item";

	private CCustInspectItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CCustInspectItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=CCustInspectItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 巡检记录 功能主页面
	 */
	@RequestMapping("/c_cust_inspect_item_list.html")
	public String list(Model model,HttpServletRequest request,String inspectId) {

		model.addAttribute("inspectId",inspectId);
		return getTemplatePath(prefix,"c_cust_inspect_item_list");
	}

	/**
	 * 巡检记录 表单页面
	 */
	@RequestMapping("/c_cust_inspect_item_form.html")
	public String form(Model model,HttpServletRequest request , String id,String inspectId) {
		model.addAttribute("inspectId",inspectId);
		return getTemplatePath(prefix,"c_cust_inspect_item_form");
	}
}