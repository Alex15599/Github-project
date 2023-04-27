package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.SafetyBaselineServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 安全基线 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-16 08:37:38
*/

@Controller("OpsSafetyBaselinePageController")
@RequestMapping(SafetyBaselinePageController.prefix)
public class SafetyBaselinePageController extends ViewController {
	
	public static final String prefix="business/ops/safety_baseline";

	private SafetyBaselineServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SafetyBaselineServiceProxy proxy() {
		if(proxy==null) {
			proxy=SafetyBaselineServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 安全基线 功能主页面
	 */
	@RequestMapping("/safety_baseline_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/safety_baseline_list";
	}

	/**
	 * 安全基线 表单页面
	 */
	@RequestMapping("/safety_baseline_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/safety_baseline_form";
	}
}