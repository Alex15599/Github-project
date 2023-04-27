package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.AutoNodeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 节点 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 13:57:10
*/

@Controller("OpsAutoNodePageController")
@RequestMapping(AutoNodePageController.prefix)
public class AutoNodePageController extends ViewController {
	
	public static final String prefix="business/ops/auto_node";

	private AutoNodeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoNodeServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoNodeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 节点 功能主页面
	 */
	@RequestMapping("/auto_node_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,String ownerId,String pageType,String selectedCode) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/auto_node_selected_list";
	}

	/**
	 * 节点 功能主页面
	 */
	@RequestMapping("/auto_node_select_list.html")
	public String selectList(Model model,HttpServletRequest request,String ownerId,String selectedCode) {

		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/auto_node_select_list";
	}


	/**
	 * 节点 功能主页面
	 */
	@RequestMapping("/auto_node_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/auto_node_list";
	}



	/**
	 * 节点 表单页面
	 */
	@RequestMapping("/auto_node_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_node_form";
	}
}