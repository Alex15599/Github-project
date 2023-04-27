package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetLabelPaperServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 纸张类型模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-03 12:56:15
*/

@Controller("EamAssetLabelPaperPageController")
@RequestMapping(AssetLabelPaperPageController.prefix)
public class AssetLabelPaperPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_label_paper";

	private AssetLabelPaperServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetLabelPaperServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetLabelPaperServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 纸张类型 功能主页面
	 */
	@RequestMapping("/asset_label_paper_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_label_paper_list";
	}

	/**
	 * 纸张类型 表单页面
	 */
	@RequestMapping("/asset_label_paper_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_label_paper_form";
	}
}