package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoActionSScriptServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 脚本选择 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 15:00:39
*/

@Controller("OpsAutoActionSScriptPageController")
@RequestMapping(AutoActionSScriptPageController.prefix)
public class AutoActionSScriptPageController extends ViewController {
	
	public static final String prefix="business/ops/auto_action_s_script";

	private AutoActionSScriptServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoActionSScriptServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoActionSScriptServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 脚本选择 功能主页面
	 */
	@RequestMapping("/auto_action_s_script_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/auto_action_s_script_list";
	}

	/**
	 * 脚本选择 表单页面
	 */
	@RequestMapping("/auto_action_s_script_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_action_s_script_form";
	}
}