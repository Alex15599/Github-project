package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CiphertextConfServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 权限配置 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 10:33:44
*/

@Controller("OpsCiphertextConfPageController")
@RequestMapping(CiphertextConfPageController.prefix)
public class CiphertextConfPageController extends ViewController {
	
	public static final String prefix="business/ops/ciphertext_conf";

	private CiphertextConfServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CiphertextConfServiceProxy proxy() {
		if(proxy==null) {
			proxy=CiphertextConfServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 权限配置 功能主页面
	 */
	@RequestMapping("/ciphertext_conf_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/ciphertext_conf_list";
	}

	/**
	 * 权限配置 表单页面
	 */
	@RequestMapping("/ciphertext_conf_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/ciphertext_conf_form";
	}
}