package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStatusServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产状态 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-06 09:44:10
*/

@Controller("EamAssetStatusPageController")
@RequestMapping(AssetStatusPageController.prefix)
public class AssetStatusPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_status";

	private AssetStatusServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetStatusServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStatusServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产状态 功能主页面
	 */
	@RequestMapping("/asset_status_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_status_list";
	}

	/**
	 * 资产状态 表单页面
	 */
	@RequestMapping("/asset_status_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_status_form";
	}
}