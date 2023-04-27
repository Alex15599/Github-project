package com.dt.platform.workorder.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.workorder.NetworkStrategyInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 网络策略 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 21:22:04
*/

@Controller("WoNetworkStrategyInfoPageController")
@RequestMapping(NetworkStrategyInfoPageController.prefix)
public class NetworkStrategyInfoPageController extends ViewController {
	
	public static final String prefix="business/workorder/network_strategy_info";

	private NetworkStrategyInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public NetworkStrategyInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=NetworkStrategyInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 网络策略 功能主页面
	 */
	@RequestMapping("/network_strategy_info_list.html")
	public String list(Model model,HttpServletRequest request,String pageType,String ownerId,String selectedCode) {

		model.addAttribute("pageType",pageType);
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/network_strategy_info_list";
	}

	/**
	 * 网络策略 表单页面
	 */
	@RequestMapping("/network_strategy_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/network_strategy_info_form";
	}
}