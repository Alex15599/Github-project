package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.CertificateLevelServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 证书级别模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 09:31:04
*/

@Controller("HrCertificateLevelPageController")
@RequestMapping(CertificateLevelPageController.prefix)
public class CertificateLevelPageController extends ViewController {
	
	public static final String prefix="business/hr/certificate_level";

	private CertificateLevelServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CertificateLevelServiceProxy proxy() {
		if(proxy==null) {
			proxy=CertificateLevelServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 证书级别 功能主页面
	 */
	@RequestMapping("/certificate_level_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/certificate_level_list";
	}

	/**
	 * 证书级别 表单页面
	 */
	@RequestMapping("/certificate_level_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/certificate_level_form";
	}
}