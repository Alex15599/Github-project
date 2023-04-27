package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.framework.view.aspect.PageHelper;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 资产库存 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-22 13:52:28
*/

@Controller("EamStockPageController")
@RequestMapping(StockPageController.prefix)
public class StockPageController extends ViewController {

	public static final String prefix="business/eam/stock";

	private StockServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public StockServiceProxy proxy() {
		if(proxy==null) {
			proxy=StockServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 资产库存 功能主页面
	 */
	@RequestMapping("/stock_asset_list.html")
	public String stockAssetList(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode) {
		String itemOwner= "";
		String categoryCode="";
		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			categoryCode= AssetPcmCodeEnum.ASSET_CONSUMABLES.code();
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_CONSUMABLES_BILL.code();
		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			categoryCode= AssetPcmCodeEnum.ASSET.code();
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_STOCK_BILL.code();
		}else if(AssetOwnerCodeEnum.ASSET_PURCHASE_APPLY.code().equals(ownerCode)){
			categoryCode= AssetPcmCodeEnum.ASSET.code();
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_STOCK_BILL.code();
		}


		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(itemOwner,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode", ownerCode);
		model.addAttribute("categoryCode", categoryCode);
		model.addAttribute("pageType", itemOwner);
		return prefix+"/stock_asset_list";
	}


	/**
	 * 资产库存 功能主页面
	 */
	@RequestMapping("/stock_book_list.html")
	public String stockBookList(Model model,HttpServletRequest request,String ownerCode) {
		String itemOwner="";
		String authPrefix="eam_"+ownerCode;
		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_CONSUMABLES_SHOW.code();
		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_STOCK_SHOW.code();
		}
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(itemOwner,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		model.addAttribute("ownerCode", ownerCode);



		PageHelper p=new PageHelper(request, SessionUser.getCurrent());
		model.addAttribute("layuiTableWidthConfig",p.getTableColumnWidthConfig("dt"+ownerCode));
		model.addAttribute("tableId","dt"+ownerCode);


		return prefix+"/stock_book_list";

	}

	/**
	 * 资产库存 功能主页面
	 */
	@RequestMapping("/stock_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode,String stockType,String operType) {

		String authPrefix="eam_"+ownerCode;
		model.addAttribute("forApprovalBtn", SessionUser.getCurrent().permission().checkAuth(authPrefix+":for-approval" ) );
		model.addAttribute("confirmDataBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":confirm"));
		model.addAttribute("revokeDataBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":revoke" ));
		model.addAttribute("agreeBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":agree") );
		model.addAttribute("denyBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":deny"));

		model.addAttribute("stockViewFormBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":view-form"));
		model.addAttribute("stockCreateBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":create") );
		model.addAttribute("stockModifyBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":update") );
		model.addAttribute("stockDeleteBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":delete") );
		model.addAttribute("stockQueryBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":query") );

		model.addAttribute("stockExportBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":export") );
		model.addAttribute("stockImportBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":import") );


		//审批
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(operType);
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);

		model.addAttribute("authPrefix",authPrefix);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("stockType",stockType);
		model.addAttribute("operType",operType);


		//表格显示
		PageHelper p=new PageHelper(request, SessionUser.getCurrent());
		model.addAttribute("layuiTableWidthConfig",p.getTableColumnWidthConfig("dt"+ownerCode+stockType+approvalRequired));
		model.addAttribute("tableId","dt"+ownerCode+stockType+approvalRequired);


		return prefix+"/stock_list";
	}

	/**
	 * 资产库存 表单页面
	 */
	@RequestMapping("/stock_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerCode,String stockType) {

		//默认公司
		OrganizationVO vo=new OrganizationVO();
		vo.setSearchField("sort");
		vo.setValid(1);
		vo.setType("com");
		Result<List<Organization>> orgResult= OrganizationServiceProxy.api().queryList(vo);
		if(orgResult.isSuccess()&&orgResult.getData().size()>0){
			model.addAttribute("assetDefaultOwnCompany",orgResult.getData().get(0));
		}

		String authPrefix="eam_"+ownerCode;
		model.addAttribute("authPrefix",authPrefix);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("stockType",stockType);

		model.addAttribute("billId",id);
		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			model.addAttribute("billType",AssetOperateEnum.EAM_ASSET_CONSUMABLES_STOCK_IN);

		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			model.addAttribute("billType",AssetOperateEnum.EAM_ASSET_STOCK_IN);
		}

		return prefix+"/stock_form";
	}


	/**
	 * 库存资产
	 */
	@RequestMapping("/asset_stock_selected_list.html")
	public String assetStockSelectedList(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode) {

		String itemOwner="";
		String authPrefix="eam_"+ownerCode;
		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_CONSUMABLES_SHOW.code();
		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_STOCK_SHOW.code();
		}else if(AssetOwnerCodeEnum.ASSET_PURCHASE_APPLY.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_PURCHASE_APPLY_SHOW.code();
		}
		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(itemOwner,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode", StringUtil.isBlank(ownerCode)? AssetOwnerCodeEnum.ASSET:ownerCode);
		return prefix+"/asset_stock_selected_list";
	}
	/**
	 * 库存资产
	 */
	@RequestMapping("/asset_stock_select_list.html")
	public String assetStockSelectList(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode) {

		String itemOwner="";
		String categoryCode="";
		String authPrefix="eam_"+ownerCode;
		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_CONSUMABLES_SHOW.code();
			categoryCode= AssetPcmCodeEnum.ASSET_CONSUMABLES.code();
		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_STOCK_SHOW.code();
			categoryCode= AssetPcmCodeEnum.ASSET.code();
		}
		Result idResult= AssetCategoryServiceProxy.api().queryNodesByCode(categoryCode);
		model.addAttribute("categoryParentId",idResult.getData());


		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode", ownerCode);
		return prefix+"/asset_stock_select_list";

	}

	/**
	 * 库存资产
	 */
	@RequestMapping("/asset_stock_basic_list.html")
	public String assetStockBasicList(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode) {
		String itemOwner="";
		String authPrefix="eam_"+ownerCode;

		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_CONSUMABLES_SHOW.code();
			model.addAttribute("stockCollectionBtn", true);
			model.addAttribute("stockDistributeBtn", false);

		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			itemOwner=AssetAttributeItemOwnerEnum.ASSET_STOCK_SHOW.code();
			model.addAttribute("stockCollectionBtn", false);
			model.addAttribute("stockDistributeBtn", true);

		}
		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(itemOwner,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}


		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode", ownerCode);
		model.addAttribute("categoryId",AssetDataServiceProxy.api().queryPcmIdByCode(AssetPcmCodeEnum.ASSET_CONSUMABLES.code()));
		return prefix+"/asset_stock_basic_list";

	}
}
