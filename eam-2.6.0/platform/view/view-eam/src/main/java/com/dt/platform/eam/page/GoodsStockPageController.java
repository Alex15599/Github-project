package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.dt.platform.proxy.eam.AssetDataServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.aspect.PageHelper;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 库存物品 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 20:41:09
*/

@Controller("EamGoodsStockPageController")
@RequestMapping(GoodsStockPageController.prefix)
public class GoodsStockPageController extends ViewController {
	
	public static final String prefix="business/eam/goods_stock";

	private GoodsStockServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public GoodsStockServiceProxy proxy() {
		if(proxy==null) {
			proxy=GoodsStockServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/goods_stock_list";
	}

	/**
	 * 安全库存
	 */
	@RequestMapping("/goods_stock_security_warn_list.html")
	public String securityWarn(Model model,HttpServletRequest request,String ownerCode) {
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/goods_stock_security_warn_list";
	}

	/**
	 * 库存下限
	 */
	@RequestMapping("/goods_stock_min_warn_list.html")
	public String minWarn(Model model,HttpServletRequest request,String ownerCode) {
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/goods_stock_min_warn_list";
	}

	/**
	 * 库存上限
	 */
	@RequestMapping("/goods_stock_max_warn_list.html")
	public String maxWarn(Model model,HttpServletRequest request,String ownerCode) {
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/goods_stock_max_warn_list";
	}


	/**
	 * 库存物品 表单页面
	 */
	@RequestMapping("/goods_stock_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/goods_stock_form";
	}

	/**
	 * 库存物品 表单页面
	 */
	@RequestMapping("/goods_stock_selected_form.html")
	public String selectedForm(Model model,HttpServletRequest request , String id,String ownerType) {
		model.addAttribute("ownerType",ownerType);
		return prefix+"/goods_stock_selected_form";
	}



	//goods 物品档案
	//real 库存
	//type,		selected  select
	//库存
	//in:		stock goods
	//out:		stock real_goods
	//adjust:   stock real_goods
	//tranfer:  stock real_goods

	//备件
	//in:		part goods
	//out:		part real_part
	//adjust:   part real_part
	//tranfer:  part real_part

	//耗材
	//in:		consumables goods
	//out:		consumables real_consumables
	//adjust:   consumables real_consumables
	//tranfer:  consumables real_consumables

	public  static String PAGE_ACTION_SELECT="select";
	public  static String PAGE_ACTION_SELECTED="selected";


	private String getOwnerCodeByOperType(String operType,String ownerType,String pageAction){
		String ownerCode="";


		if(AssetStockGoodsTypeEnum.STOCK.code().equals(ownerType)){
			//库存
			if(PAGE_ACTION_SELECTED.equals(pageAction)){
				ownerCode=AssetStockGoodsOwnerEnum.STOCK.code();
			}else if(PAGE_ACTION_SELECT.equals(pageAction)){
				//类型
				if(AssetOperateEnum.EAM_ASSET_STOCK_GOODS_IN.code().equals(operType)){
					ownerCode=AssetStockGoodsOwnerEnum.GOODS.code();
				}else if(AssetOperateEnum.EAM_ASSET_STOCK_GOODS_OUT.code().equals(operType)
						||AssetOperateEnum.EAM_ASSET_STOCK_GOODS_ADJUST.code().equals(operType)
						||AssetOperateEnum.EAM_ASSET_STOCK_GOODS_TRANFER.code().equals(operType)){
					ownerCode=AssetStockGoodsOwnerEnum.REAL_STOCK.code();
				}
			}
		}

		//耗材
		if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(ownerType)){
			//库存
			if(PAGE_ACTION_SELECTED.equals(pageAction)){
				ownerCode=AssetStockGoodsOwnerEnum.CONSUMABLES.code();
			}else if(PAGE_ACTION_SELECT.equals(pageAction)){
				//类型
				if(AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.code().equals(operType)){
					ownerCode=AssetStockGoodsOwnerEnum.GOODS.code();
				}else if(AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code().equals(operType)
						||AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_ADJUST.code().equals(operType)
						||AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_TRANFER.code().equals(operType)){
					ownerCode=AssetStockGoodsOwnerEnum.REAL_CONSUMABLES.code();
				}
			}
		}

		//备件
		if(AssetStockGoodsTypeEnum.PART.code().equals(ownerType)){
			//库存
			if(PAGE_ACTION_SELECTED.equals(pageAction)){
				ownerCode=AssetStockGoodsOwnerEnum.PART.code();
			}else if(PAGE_ACTION_SELECT.equals(pageAction)){
				//类型
				if(AssetOperateEnum.EAM_ASSET_PART_GOODS_IN.code().equals(operType)){
					ownerCode=AssetStockGoodsOwnerEnum.GOODS.code();
				}else if(AssetOperateEnum.EAM_ASSET_PART_GOODS_OUT.code().equals(operType)
						||AssetOperateEnum.EAM_ASSET_PART_GOODS_ADJUST.code().equals(operType)
						||AssetOperateEnum.EAM_ASSET_PART_GOODS_TRANFER.code().equals(operType)){
					ownerCode=AssetStockGoodsOwnerEnum.REAL_PART.code();
				}
			}
		}


		return ownerCode;
	}


	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_select_tree.html")
	public String selectTree(Model model,HttpServletRequest request,String ownerTmpId,String operType,String pageType,String ownerType,String selectedCode) {

		Result idResult= AssetCategoryServiceProxy.api().queryNodesByCode(AssetPcmCodeEnum.ASSET_STOCK_GOODS.code());
		model.addAttribute("categoryParentId",idResult.getData());
		model.addAttribute("ownerCode",getOwnerCodeByOperType(operType,ownerType,PAGE_ACTION_SELECT));
		model.addAttribute("ownerTmpId",ownerTmpId);
		model.addAttribute("operType",operType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);

		return prefix+"/goods_stock_select_tree";
	}



	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_select_list.html")
	public String selectList(Model model,HttpServletRequest request,String ownerTmpId,String operType,String pageType,String ownerType,String selectedCode) {


		PageHelper p=new PageHelper(request, SessionUser.getCurrent());
		String tableId="dt_"+operType;
		model.addAttribute("layuiTableWidthConfig",p.getTableColumnWidthConfig(tableId));
		model.addAttribute("tableId",tableId);
		model.addAttribute("ownerCode",getOwnerCodeByOperType(operType,ownerType,PAGE_ACTION_SELECT));
		model.addAttribute("ownerTmpId",ownerTmpId);
		model.addAttribute("operType",operType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);

		//物品档案
		model.addAttribute("categoryId", AssetDataServiceProxy.api().queryPcmIdByCode(AssetPcmCodeEnum.ASSET_STOCK_GOODS.code()));


		//model.addAttribute("multiple",multiple);
		return prefix + "/goods_stock_select_list";
	}

	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,String ownerTmpId,String operType,String pageType,String ownerType,String selectedCode) {

		model.addAttribute("ownerCode",getOwnerCodeByOperType(operType,ownerType,PAGE_ACTION_SELECTED));
		model.addAttribute("ownerTmpId",ownerTmpId);
		model.addAttribute("operType",operType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/goods_stock_selected_list";
	}



}