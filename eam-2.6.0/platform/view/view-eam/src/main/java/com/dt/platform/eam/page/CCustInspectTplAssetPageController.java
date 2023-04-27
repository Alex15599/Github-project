package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CCustInspectTplAssetServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 设备模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-08 19:00:26
*/

@Controller("EamCCustInspectTplAssetPageController")
@RequestMapping(CCustInspectTplAssetPageController.prefix)
public class CCustInspectTplAssetPageController extends ViewController {

	public static final String prefix="business/eam/c_cust_inspect_tpl_asset";

	private CCustInspectTplAssetServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CCustInspectTplAssetServiceProxy proxy() {
		if(proxy==null) {
			proxy=CCustInspectTplAssetServiceProxy.api();
		}
		return proxy;
	}



	/**
	 * 设备 功能主页面
	 */
	@RequestMapping("/c_cust_inspect_tpl_asset_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"c_cust_inspect_tpl_asset_list");
	}

	/**
	 * 设备 表单页面
	 */
	@RequestMapping("/c_cust_inspect_tpl_asset_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_inspect_tpl_asset_form");
	}
}