package com.dt.platform.workorder.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.workorder.ServerInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 服务器资源 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 21:27:33
*/

@Controller("WoServerInfoPageController")
@RequestMapping(ServerInfoPageController.prefix)
public class ServerInfoPageController extends ViewController {
	
	public static final String prefix="business/workorder/server_info";

	private ServerInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ServerInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=ServerInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 服务器资源 功能主页面
	 */
	@RequestMapping("/server_info_list.html")
	public String list(Model model,HttpServletRequest request,String pageType,String ownerId,String selectedCode) {

		model.addAttribute("pageType",pageType);
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);

		return prefix+"/server_info_list";
	}

	/**
	 * 服务器资源 表单页面
	 */
	@RequestMapping("/server_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/server_info_form";
	}
}