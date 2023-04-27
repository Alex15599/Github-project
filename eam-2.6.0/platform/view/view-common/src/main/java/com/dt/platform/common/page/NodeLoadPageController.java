package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.NodeLoadServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 节点负载模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:37:38
*/

@Controller("SysNodeLoadPageController")
@RequestMapping(NodeLoadPageController.prefix)
public class NodeLoadPageController extends ViewController {
	
	public static final String prefix="business/common/node_load";

	private NodeLoadServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public NodeLoadServiceProxy proxy() {
		if(proxy==null) {
			proxy=NodeLoadServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 节点负载 功能主页面
	 */
	@RequestMapping("/node_load_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/node_load_list";
	}

	/**
	 * 节点负载 功能主页面
	 */
	@RequestMapping("/node_load_dashboard.html")
	public String dashboard(Model model,HttpServletRequest request) {
		return prefix+"/node_load_dashboard";
	}

	/**
	 * 节点负载 表单页面
	 */
	@RequestMapping("/node_load_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/node_load_form";
	}
}