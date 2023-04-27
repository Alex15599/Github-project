package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoActionScriptServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 执行脚本 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 12:51:30
*/

@Controller("OpsAutoActionScriptPageController")
@RequestMapping(AutoActionScriptPageController.prefix)
public class AutoActionScriptPageController extends ViewController {
	
	public static final String prefix="business/ops/auto_action_script";

	private AutoActionScriptServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoActionScriptServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoActionScriptServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 执行脚本 功能主页面
	 */
	@RequestMapping("/auto_action_script_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/auto_action_script_list";
	}

	/**
	 * 执行脚本 表单页面
	 */
	@RequestMapping("/auto_action_script_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_action_script_form";
	}
}