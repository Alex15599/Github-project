package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CiphertextBoxServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 密文箱 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-20 08:57:21
*/

@Controller("OpsCiphertextBoxPageController")
@RequestMapping(CiphertextBoxPageController.prefix)
public class CiphertextBoxPageController extends ViewController {
	
	public static final String prefix="business/ops/ciphertext_box";

	private CiphertextBoxServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CiphertextBoxServiceProxy proxy() {
		if(proxy==null) {
			proxy=CiphertextBoxServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 密文箱 功能主页面
	 */
	@RequestMapping("/ciphertext_box_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/ciphertext_box_list";
	}

	/**
	 * 密文箱 表单页面
	 */
	@RequestMapping("/ciphertext_box_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/ciphertext_box_form";
	}
}