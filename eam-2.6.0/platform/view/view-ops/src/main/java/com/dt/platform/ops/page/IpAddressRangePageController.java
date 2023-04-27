package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.IpAddressRangeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * IP地址段 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-30 07:16:58
*/

@Controller("OpsIpAddressRangePageController")
@RequestMapping(IpAddressRangePageController.prefix)
public class IpAddressRangePageController extends ViewController {
	
	public static final String prefix="business/ops/ip_address_range";

	private IpAddressRangeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public IpAddressRangeServiceProxy proxy() {
		if(proxy==null) {
			proxy=IpAddressRangeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * IP地址段 功能主页面
	 */
	@RequestMapping("/ip_address_range_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/ip_address_range_list";
	}

	/**
	 * IP地址段 表单页面
	 */
	@RequestMapping("/ip_address_range_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/ip_address_range_form";
	}
}