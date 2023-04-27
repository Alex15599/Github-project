package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorObjectServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 监控对象 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 08:37:45
*/

@Controller("OpsMonitorObjectPageController")
@RequestMapping(MonitorObjectPageController.prefix)
public class MonitorObjectPageController extends ViewController {
	
	public static final String prefix="business/ops/monitor_object";

	private MonitorObjectServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MonitorObjectServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorObjectServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 监控对象 功能主页面
	 */
	@RequestMapping("/object_analyze.html")
	public String objectAnalyze(Model model,HttpServletRequest request,String id) {
		model.addAttribute("id",id);
		return prefix+"/object_analyze";
	}

	/**
	 * 监控对象 功能主页面
	 */
	@RequestMapping("/monitor_object_list.html")
	public String list(Model model,HttpServletRequest request,String groupCode) {

		model.addAttribute("groupCode",groupCode);
		return prefix+"/monitor_object_list";
	}

	/**
	 * 监控对象 表单页面
	 */
	@RequestMapping("/monitor_object_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/monitor_object_form";
	}
}