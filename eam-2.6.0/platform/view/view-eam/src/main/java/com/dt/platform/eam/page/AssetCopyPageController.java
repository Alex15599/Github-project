package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetCopyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产复制模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-26 10:34:21
*/

@Controller("EamAssetCopyPageController")
@RequestMapping(AssetCopyPageController.prefix)
public class AssetCopyPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_copy";

	private AssetCopyServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetCopyServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetCopyServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产复制 功能主页面
	 */
	@RequestMapping("/asset_copy_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_copy_list";
	}

	/**
	 * 资产复制 表单页面
	 */
	@RequestMapping("/asset_copy_form.html")
	public String form(Model model,HttpServletRequest request , String id,String assetId) {
		model.addAttribute("assetId",assetId);
		return prefix+"/asset_copy_form";
	}
}