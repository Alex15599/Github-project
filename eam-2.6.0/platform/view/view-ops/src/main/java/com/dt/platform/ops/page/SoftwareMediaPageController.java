package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.SoftwareMediaServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 软件介质模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-29 21:21:46
*/

@Controller("OpsSoftwareMediaPageController")
@RequestMapping(SoftwareMediaPageController.prefix)
public class SoftwareMediaPageController extends ViewController {
	
	public static final String prefix="business/ops/software_media";

	private SoftwareMediaServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SoftwareMediaServiceProxy proxy() {
		if(proxy==null) {
			proxy=SoftwareMediaServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 软件介质 功能主页面
	 */
	@RequestMapping("/software_media_public_list.html")
	public String publicList(Model model,HttpServletRequest request) {
		return prefix+"/software_media_public_list";
	}
	
	/**
	 * 软件介质 功能主页面
	 */
	@RequestMapping("/software_media_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/software_media_list";
	}

	/**
	 * 软件介质 表单页面
	 */
	@RequestMapping("/software_media_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/software_media_form";
	}
}