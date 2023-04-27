package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CiphertextHistoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 历史记录 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 14:16:45
*/

@Controller("OpsCiphertextHistoryPageController")
@RequestMapping(CiphertextHistoryPageController.prefix)
public class CiphertextHistoryPageController extends ViewController {
	
	public static final String prefix="business/ops/ciphertext_history";

	private CiphertextHistoryServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CiphertextHistoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=CiphertextHistoryServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 历史记录 功能主页面
	 */
	@RequestMapping("/ciphertext_history_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/ciphertext_history_list";
	}

	/**
	 * 历史记录 表单页面
	 */
	@RequestMapping("/ciphertext_history_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/ciphertext_history_form";
	}
}