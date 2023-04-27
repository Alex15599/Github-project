package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CCustRepiarItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 进度模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 14:04:36
*/

@Controller("EamCCustRepiarItemPageController")
@RequestMapping(CCustRepiarItemPageController.prefix)
public class CCustRepiarItemPageController extends ViewController {

	public static final String prefix="business/eam/c_cust_repiar_item";

	private CCustRepiarItemServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CCustRepiarItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=CCustRepiarItemServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 进度 功能主页面
	 */
	@RequestMapping("/c_cust_repiar_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"c_cust_repiar_item_list");
	}

	/**
	 * 进度 表单页面
	 */
	@RequestMapping("/c_cust_repiar_item_form.html")
	public String form(Model model,HttpServletRequest request , String id,String repairId) {
		model.addAttribute("repairId",repairId);
		return getTemplatePath(prefix,"c_cust_repiar_item_form");
	}
}