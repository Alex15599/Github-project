package com.dt.platform.workorder.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.workorder.SlbStrategyInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 负载策略 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-06 17:18:58
*/

@Controller("WoSlbStrategyInfoPageController")
@RequestMapping(SlbStrategyInfoPageController.prefix)
public class SlbStrategyInfoPageController extends ViewController {
	
	public static final String prefix="business/workorder/slb_strategy_info";

	private SlbStrategyInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SlbStrategyInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=SlbStrategyInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 负载策略 功能主页面
	 */
	@RequestMapping("/slb_strategy_info_list.html")
	public String list(Model model,HttpServletRequest request,String pageType,String ownerId,String selectedCode) {

		model.addAttribute("pageType",pageType);
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/slb_strategy_info_list";
	}

	/**
	 * 负载策略 表单页面
	 */
	@RequestMapping("/slb_strategy_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/slb_strategy_info_form";
	}
}