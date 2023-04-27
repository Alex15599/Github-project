package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CmdbAttributeCServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 属性字段模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-21 08:03:13
*/

@Controller("OpsCmdbAttributeCPageController")
@RequestMapping(CmdbAttributeCPageController.prefix)
public class CmdbAttributeCPageController extends ViewController {
	
	public static final String prefix="business/ops/cmdb_attribute_c";

	private CmdbAttributeCServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CmdbAttributeCServiceProxy proxy() {
		if(proxy==null) {
			proxy=CmdbAttributeCServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 属性字段 功能主页面
	 */
	@RequestMapping("/cmdb_attribute_c_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/cmdb_attribute_c_list";
	}

	/**
	 * 属性字段 表单页面
	 */
	@RequestMapping("/cmdb_attribute_c_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/cmdb_attribute_c_form";
	}
}