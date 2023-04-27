package com.dt.platform.mobile.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.mobile.SoftwareInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 软件信息 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 09:04:13
*/

@Controller("AppSoftwareInfoPageController")
@RequestMapping(SoftwareInfoPageController.prefix)
public class SoftwareInfoPageController extends ViewController {
	
	public static final String prefix="business/mobile/software_info";

	private SoftwareInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SoftwareInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=SoftwareInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 软件信息 功能主页面
	 */
	@RequestMapping("/software_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/software_info_list";
	}


	/**
	 * 软件信息 功能主页面
	 */
	@RequestMapping("/software_download_list.html")
	public String downloadList(Model model,HttpServletRequest request,String groupCode) {

		model.addAttribute("groupCode",groupCode);

		return prefix+"/software_download_list";
	}

	/**
	 * 软件信息 表单页面
	 */
	@RequestMapping("/software_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/software_info_form";
	}
}