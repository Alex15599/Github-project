package com.dt.platform.workorder.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.workorder.SlbStrategyApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 负载策略申请 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-06 17:20:50
*/

@Controller("WoSlbStrategyApplyPageController")
@RequestMapping(SlbStrategyApplyPageController.prefix)
public class SlbStrategyApplyPageController extends ViewController {
	
	public static final String prefix="business/workorder/slb_strategy_apply";

	private SlbStrategyApplyServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SlbStrategyApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=SlbStrategyApplyServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 负载策略申请 功能主页面
	 */
	@RequestMapping("/slb_strategy_apply_list.html")
	public String list(Model model,HttpServletRequest request) {

		return prefix+"/slb_strategy_apply_list";
	}

	/**
	 * 负载策略申请 表单页面
	 */
	@RequestMapping("/slb_strategy_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/slb_strategy_apply_form";
	}
}