package com.dt.platform.ops.page;

import com.dt.platform.proxy.ops.PublicContentServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 开放列模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-03 19:22:05
*/

@Controller("RootSharePageController")
@RequestMapping(RootSharePageController.prefix)
public class RootSharePageController extends ViewController {

	public static final String prefix="/";

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


	@RequestMapping("/public.html")
	public String list(Model model,HttpServletRequest request) {
		System.out.println("test");
		return "business/ops/public_content/public_content_public_list";
	}


}