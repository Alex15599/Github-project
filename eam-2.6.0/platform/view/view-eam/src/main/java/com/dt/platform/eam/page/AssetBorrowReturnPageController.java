package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetBorrowReturnServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产归还模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 10:13:25
*/

@Controller("EamAssetBorrowReturnPageController")
@RequestMapping(AssetBorrowReturnPageController.prefix)
public class AssetBorrowReturnPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_borrow_return";

	private AssetBorrowReturnServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetBorrowReturnServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetBorrowReturnServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产归还 功能主页面
	 */
	@RequestMapping("/asset_borrow_return_list.html")
	public String list(Model model,HttpServletRequest request) {
		model.addAttribute("approvalRequired",false);
		return prefix+"/asset_borrow_return_list";
	}

	/**
	 * 资产归还 表单页面
	 */
	@RequestMapping("/asset_borrow_return_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		model.addAttribute("billId",id);
		model.addAttribute("billType", AssetOperateEnum.EAM_ASSET_BORROW_RETURN.code());
		return prefix+"/asset_borrow_return_form";
	}
}