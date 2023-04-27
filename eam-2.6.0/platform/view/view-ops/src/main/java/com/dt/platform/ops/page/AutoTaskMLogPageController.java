package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoTaskMLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 执行日志 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 14:42:15
*/

@Controller("OpsAutoTaskMLogPageController")
@RequestMapping(AutoTaskMLogPageController.prefix)
public class AutoTaskMLogPageController extends ViewController {
	
	public static final String prefix="business/ops/auto_task_m_log";

	private AutoTaskMLogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoTaskMLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoTaskMLogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 执行日志 功能主页面
	 */
	@RequestMapping("/auto_task_m_log_list.html")
	public String list(Model model,HttpServletRequest request,String taskId) {

		model.addAttribute("taskId",taskId);
		return prefix+"/auto_task_m_log_list";
	}

	/**
	 * 执行日志 表单页面
	 */
	@RequestMapping("/auto_task_m_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_task_m_log_form";
	}
}