package com.dt.platform.mobile.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.mobile.ModuleInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 移动端模块 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-20 22:31:33
*/

@Controller("AppModuleInfoPageController")
@RequestMapping(ModuleInfoPageController.prefix)
public class ModuleInfoPageController extends ViewController {
	
	public static final String prefix="business/mobile/module_info";

	private ModuleInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ModuleInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=ModuleInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 移动端模块 功能主页面
	 */
	@RequestMapping("/module_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/module_info_list";
	}

	/**
	 * 移动端模块 表单页面
	 */
	@RequestMapping("/module_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/module_info_form";
	}
}