package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CiphertextBoxDataServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 密文数据 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 14:40:39
*/

@Controller("OpsCiphertextBoxDataPageController")
@RequestMapping(CiphertextBoxDataPageController.prefix)
public class CiphertextBoxDataPageController extends ViewController {
	
	public static final String prefix="business/ops/ciphertext_box_data";

	private CiphertextBoxDataServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CiphertextBoxDataServiceProxy proxy() {
		if(proxy==null) {
			proxy=CiphertextBoxDataServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 密文数据 功能主页面
	 */
	@RequestMapping("/ciphertext_box_data_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/ciphertext_box_data_list";
	}

	/**
	 * 密文数据 表单页面
	 */
	@RequestMapping("/ciphertext_box_data_form.html")
	public String form(Model model,HttpServletRequest request , String id,String sourceId,String boxType) {
		model.addAttribute("sourceId",sourceId);
		model.addAttribute("boxType",boxType);
		return prefix+"/ciphertext_box_data_form";
	}
}