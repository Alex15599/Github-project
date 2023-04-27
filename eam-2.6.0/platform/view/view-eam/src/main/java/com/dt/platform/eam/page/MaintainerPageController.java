package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维保厂商 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-30 22:05:17
*/

@Controller("EamMaintainerPageController")
@RequestMapping(MaintainerPageController.prefix)
public class MaintainerPageController extends ViewController {
	
	public static final String prefix="business/eam/maintainer";

	private MaintainerServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MaintainerServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintainerServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 维保厂商 功能主页面
	 */
	@RequestMapping("/maintainer_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/maintainer_list";
	}

	/**
	 * 维保厂商 表单页面
	 */
	@RequestMapping("/maintainer_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/maintainer_form";
	}
}