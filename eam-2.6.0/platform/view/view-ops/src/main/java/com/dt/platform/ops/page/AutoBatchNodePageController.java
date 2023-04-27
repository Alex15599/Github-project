package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoBatchNodeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 分组节点 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 10:20:37
*/

@Controller("OpsAutoBatchNodePageController")
@RequestMapping(AutoBatchNodePageController.prefix)
public class AutoBatchNodePageController extends ViewController {
	
	public static final String prefix="business/ops/auto_batch_node";

	private AutoBatchNodeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoBatchNodeServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoBatchNodeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 分组节点 功能主页面
	 */
	@RequestMapping("/auto_batch_node_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/auto_batch_node_list";
	}

	/**
	 * 分组节点 表单页面
	 */
	@RequestMapping("/auto_batch_node_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_batch_node_form";
	}
}