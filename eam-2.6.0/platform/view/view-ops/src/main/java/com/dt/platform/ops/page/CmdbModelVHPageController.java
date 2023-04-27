package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CmdbModelVHServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 配置值模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:34:05
*/

@Controller("OpsCmdbModelVHPageController")
@RequestMapping(CmdbModelVHPageController.prefix)
public class CmdbModelVHPageController extends ViewController {
	
	public static final String prefix="business/ops/cmdb_model_vh";

	private CmdbModelVHServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CmdbModelVHServiceProxy proxy() {
		if(proxy==null) {
			proxy=CmdbModelVHServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 配置值 功能主页面
	 */
	@RequestMapping("/cmdb_model_vh_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/cmdb_model_vh_list";
	}

	/**
	 * 配置值 表单页面
	 */
	@RequestMapping("/cmdb_model_vh_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/cmdb_model_vh_form";
	}
}