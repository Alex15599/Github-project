package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetDepreciationExcludeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 折旧排除模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-28 20:42:06
*/

@Controller("EamAssetDepreciationExcludePageController")
@RequestMapping(AssetDepreciationExcludePageController.prefix)
public class AssetDepreciationExcludePageController extends ViewController {
	
	public static final String prefix="business/eam/asset_depreciation_exclude";

	private AssetDepreciationExcludeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetDepreciationExcludeServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDepreciationExcludeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 折旧排除 功能主页面
	 */
	@RequestMapping("/asset_depreciation_exclude_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_depreciation_exclude_list";
	}

	/**
	 * 折旧排除 表单页面
	 */
	@RequestMapping("/asset_depreciation_exclude_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_depreciation_exclude_form";
	}
}