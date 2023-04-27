package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetDepreciationHistoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 折旧历史 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-29 20:24:39
*/

@Controller("EamAssetDepreciationHistoryPageController")
@RequestMapping(AssetDepreciationHistoryPageController.prefix)
public class AssetDepreciationHistoryPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_depreciation_history";

	private AssetDepreciationHistoryServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetDepreciationHistoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDepreciationHistoryServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 折旧历史 功能主页面
	 */
	@RequestMapping("/asset_depreciation_history_list.html")
	public String list(Model model,HttpServletRequest request,String assetId) {
		model.addAttribute("assetId",assetId);
		return prefix+"/asset_depreciation_history_list";
	}

	/**
	 * 折旧历史 表单页面
	 */
	@RequestMapping("/asset_depreciation_history_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_depreciation_history_form";
	}
}