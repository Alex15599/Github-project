package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostExByDbServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库排除 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-11 16:23:27
*/

@Controller("OpsHostExByDbPageController")
@RequestMapping(HostExByDbPageController.prefix)
public class HostExByDbPageController extends ViewController {
	
	public static final String prefix="business/ops/host_ex_by_db";

	private HostExByDbServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public HostExByDbServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostExByDbServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据库排除 功能主页面
	 */
	@RequestMapping("/host_ex_by_db_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/host_ex_by_db_list";
	}

	/**
	 * 数据库排除 表单页面
	 */
	@RequestMapping("/host_ex_by_db_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/host_ex_by_db_form";
	}
}