package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetPcmCodeEnum;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStockGoodsServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 库存物品单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 17:52:47
*/

@Controller("EamAssetStockGoodsPageController")
@RequestMapping(AssetStockGoodsPageController.prefix)
public class AssetStockGoodsPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_stock_goods";

	private AssetStockGoodsServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetStockGoodsServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStockGoodsServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 库存物品单 功能主页面
	 */
	@RequestMapping("/asset_stock_goods_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_stock_goods_list";
	}

	/**
	 * 库存物品单 表单页面
	 */
	@RequestMapping("/asset_stock_goods_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_stock_goods_form";
	}


	/**
	 * 库存物品单 功能主页面
	 */
	@RequestMapping("/asset_stock_goods_select_tree.html")
	public String assetStockGoodsSelectTree(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode,String ownerType) {


		Result idResult= AssetCategoryServiceProxy.api().queryNodesByCode(AssetPcmCodeEnum.ASSET.code());
		model.addAttribute("categoryParentId",idResult.getData());
		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);
		return prefix+"/asset_stock_goods_list";
	}


}