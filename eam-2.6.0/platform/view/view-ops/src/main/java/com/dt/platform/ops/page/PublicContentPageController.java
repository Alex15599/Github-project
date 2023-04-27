package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.PublicContentServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 开放列模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-03 19:22:05
*/

@Controller("OpsPublicContentPageController")
@RequestMapping(PublicContentPageController.prefix)
public class PublicContentPageController extends ViewController {

	public static final String prefix="business/ops/public_content";

	private PublicContentServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PublicContentServiceProxy proxy() {
		if(proxy==null) {
			proxy=PublicContentServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 开放列 功能主页面
	 */
	@RequestMapping("/public_content_list.html")
	public String list(Model model,HttpServletRequest request) {
		model.addAttribute("showType","console");
		return getTemplatePath(prefix,"public_content_list");
	}


	@RequestMapping("/public_content_public_list.html")
	public String publicList(Model model,HttpServletRequest request) {
		model.addAttribute("showType","public");
		return getTemplatePath(prefix,"public_content_public_list");
	}


	/**
	 * 开放列 表单页面
	 */
	@RequestMapping("/public_content_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"public_content_form");
	}
}