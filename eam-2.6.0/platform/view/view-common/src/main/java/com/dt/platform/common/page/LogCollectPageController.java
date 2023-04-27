package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.LogCollectServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 日志收集模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-18 12:18:12
*/

@Controller("SysLogCollectPageController")
@RequestMapping(LogCollectPageController.prefix)
public class LogCollectPageController extends ViewController {

	public static final String prefix="business/common/log_collect";

	private LogCollectServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public LogCollectServiceProxy proxy() {
		if(proxy==null) {
			proxy=LogCollectServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 日志收集 功能主页面
	 */
	@RequestMapping("/log_collect_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"log_collect_list");
	}

	/**
	 * 日志收集 表单页面
	 */
	@RequestMapping("/log_collect_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"log_collect_form");
	}
}