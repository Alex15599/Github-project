package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.SoftwareBaseVersionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 软件基线版本 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-16 08:30:07
*/

@Controller("OpsSoftwareBaseVersionPageController")
@RequestMapping(SoftwareBaseVersionPageController.prefix)
public class SoftwareBaseVersionPageController extends ViewController {
	
	public static final String prefix="business/ops/software_base_version";

	private SoftwareBaseVersionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SoftwareBaseVersionServiceProxy proxy() {
		if(proxy==null) {
			proxy=SoftwareBaseVersionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 软件基线版本 功能主页面
	 */
	@RequestMapping("/software_base_version_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/software_base_version_list";
	}

	/**
	 * 软件基线版本 功能主页面
	 */
	@RequestMapping("/software_base_version_public_list.html")
	public String publicList(Model model,HttpServletRequest request) {
		return prefix+"/software_base_version_public_list";
	}


	/**
	 * 软件基线版本 表单页面
	 */
	@RequestMapping("/software_base_version_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/software_base_version_form";
	}
}