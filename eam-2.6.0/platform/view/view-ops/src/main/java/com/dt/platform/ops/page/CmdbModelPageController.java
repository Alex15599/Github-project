package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CmdbModelServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 配置库模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-21 08:10:56
*/

@Controller("OpsCmdbModelPageController")
@RequestMapping(CmdbModelPageController.prefix)
public class CmdbModelPageController extends ViewController {
	
	public static final String prefix="business/ops/cmdb_model";

	private CmdbModelServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CmdbModelServiceProxy proxy() {
		if(proxy==null) {
			proxy=CmdbModelServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 配置库 功能主页面
	 */
	@RequestMapping("/cmdb_model_tree_list.html")
	public String treeList(Model model,HttpServletRequest request) {

		return prefix+"/cmdb_model_list";
	}


	/**
	 * 配置库 功能主页面
	 */
	@RequestMapping("/cmdb_model_list.html")
	public String list(Model model,HttpServletRequest request) {

		return prefix+"/cmdb_model_list";
	}



	/**
	 * 配置库 表单页面
	 */
	@RequestMapping("/cmdb_model_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/cmdb_model_form";
	}
}