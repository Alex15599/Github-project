package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.PlanExecuteLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 执行日志模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:35:39
*/

@Controller("EamPlanExecuteLogPageController")
@RequestMapping(PlanExecuteLogPageController.prefix)
public class PlanExecuteLogPageController extends ViewController {

	public static final String prefix="business/eam/plan_execute_log";

	private PlanExecuteLogServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PlanExecuteLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=PlanExecuteLogServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 执行日志 功能主页面
	 */
	@RequestMapping("/plan_execute_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"plan_execute_log_list");
	}

	/**
	 * 执行日志 表单页面
	 */
	@RequestMapping("/plan_execute_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"plan_execute_log_form");
	}
}