package com.dt.platform.eam.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.domain.eam.AssetAttributeItemVO;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.framework.view.aspect.PageHelper;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 资产 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 16:11:51
*/

@Controller("EamAssetPageController")
@RequestMapping(AssetPageController.prefix)
public class AssetPageController extends ViewController {
	
	public static final String prefix="business/eam/asset";

	private AssetServiceProxy proxy;

	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetServiceProxy.api();
		}
		return proxy;
	}


	/**
	 * 资产
	 */
	@RequestMapping("/asset_code_custom.html")
	public String assetCodeCustom(Model model,HttpServletRequest request) {
		return prefix+"/asset_code_custom";
	}

	/**
	 * 资产
	 */
	@RequestMapping("/asset_excel_oper.html")
	public String excelOper(Model model,HttpServletRequest request) {
		Result r=AssetDataServiceProxy.api().queryAssetLuckySheet("",50,null);
		JSONObject conf= (JSONObject) r.getData();
		model.addAttribute("sheetConfig", JSON.toJSONString(conf, SerializerFeature.DisableCircularReferenceDetect));
		return prefix+"/asset_excel_oper";
	}

	/**
	 * 资产
	 */
	@RequestMapping("/asset_select_basic_list.html")
	public String basicLlist(Model model,HttpServletRequest request,String assetSelectedCode) {
		//设置字段布局
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_SELECT.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		model.addAttribute("categoryId",AssetDataServiceProxy.api().queryPcmIdByCode(AssetPcmCodeEnum.ASSET.code()));
		model.addAttribute("assetSelectedCode",assetSelectedCode);
		return prefix+"/asset_select_basic_list";
	}


	/**
	 * 资产
	 */
	@RequestMapping("/asset_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode,String pageType) {

		String itemOwner=AssetAttributeItemOwnerEnum.ASSET_BILL.code();
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(itemOwner,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		model.addAttribute("pageType",pageType);
		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode",StringUtil.isBlank(ownerCode)?AssetOwnerCodeEnum.ASSET:ownerCode);
		return prefix+"/asset_selected_list";
	}

	/**
	 * 资产
	 */
	@RequestMapping("/asset_select_list.html")
	public String selectLlist(Model model,HttpServletRequest request,String assetSelectedCode,String ownerCode) {

		Result idResult=AssetCategoryServiceProxy.api().queryNodesByCode(AssetPcmCodeEnum.ASSET.code());
		model.addAttribute("categoryParentId",idResult.getData());
		model.addAttribute("assetSelectedCode",assetSelectedCode);
		model.addAttribute("ownerCode",StringUtil.isBlank(ownerCode)?AssetOwnerCodeEnum.ASSET:ownerCode);
		return prefix+"/asset_select_list";
	}

	/**
	 * 资产 人员资产信息
	 */
	@RequestMapping("/asset_search/employee_assetInfo_list.html")
	public String employeeAssetInfoList(Model model,HttpServletRequest request,String employeeId) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.PUBLIC_SHOW.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		model.addAttribute("employeeId",employeeId);
		return prefix+"/asset_search/employee_assetInfo_list";
	}


	/**
	 * 资产 人员资产信息
	 */
	@RequestMapping("/asset_search/employee_assetInfo_selected_list.html")
	public String employeeAssetInfoSelectedList(Model model,HttpServletRequest request,String employeeId,String ownerId,String selectedCode,String pageType) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.PUBLIC_SHOW.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		model.addAttribute("employeeId",employeeId);
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("pageType",pageType);
		return prefix+"/asset_search/employee_assetInfo_selected_list";

	}

	/**
	 * 资产 人员资产信息
	 */
	@RequestMapping("/asset_search/employee_assetInfo_select_list.html")
	public String employeeAssetInfoSelectList(Model model,HttpServletRequest request,String employeeId,String ownerId,String selectedCode,String pageType) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.PUBLIC_SHOW.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		model.addAttribute("employeeId",employeeId);
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("pageType",pageType);
		return prefix+"/asset_search/employee_assetInfo_select_list";
	}



	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/employee_list.html")
	public String employeeList(Model model,HttpServletRequest request) {

		return prefix+"/asset_search/employee_list";
	}

	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/employee_tree.html")
	public String employeeTree(Model model,HttpServletRequest request) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/employee_tree";
	}


	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/category_tree.html")
	public String categoryTree(Model model,HttpServletRequest request) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}


		Result idResult=AssetCategoryServiceProxy.api().queryNodesByCode(AssetPcmCodeEnum.ASSET.code());
		model.addAttribute("categoryParentId",idResult.getData());
		return prefix+"/asset_search/category_tree";
	}

	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/org_tree.html")
	public String orgTree(Model model,HttpServletRequest request) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/org_tree";
	}


	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/belong_org_tree.html")
	public String belongOrgTree(Model model,HttpServletRequest request) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/belong_org_tree";
	}


	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/position_tree.html")
	public String positionTree(Model model,HttpServletRequest request) {
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/position_tree";
	}


	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/asset_wait_clean_search.html")
	public String searchWaitCleanList(Model model,HttpServletRequest request) {


		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/asset_wait_clean_search";
	}



	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/asset_clean_search.html")
	public String searchCleanList(Model model,HttpServletRequest request) {


		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/asset_clean_search";
	}

	/**
	 * 资产 台账
	 */
	@RequestMapping("/asset_search/asset_search.html")
	public String searchList(Model model,HttpServletRequest request) {


		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_search/asset_search";
	}



	/**
	 * 资产登记审批
	 */
	@RequestMapping("/approval/asset_register_list.html")
	public String assetApprove(Model model,HttpServletRequest request,String pageType) {

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(pageType,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/approval/asset_register_list";
	}



	/**
	 * 资产 功能主页面
	 */
	@RequestMapping("/asset_list.html")
	public String list(Model model,HttpServletRequest request) {

		return prefix+"/asset_list";
	}

	/**
	 * 资产 功能主页面
	 */
	@RequestMapping("/asset_data_export_list.html")
	public String dataExportList(Model model,HttpServletRequest request) {

		return prefix+"/asset_data_export_list";
	}



	/**
	 * 资产 表单页面
	 */
	@RequestMapping("/asset_form.html")
	public String form(Model model,HttpServletRequest request , String id) {

		return prefix+"/asset_form";
	}



	/**
	 * 资产 表单页面
	 */
	@RequestMapping("/asset_import_form.html")
	public String importForm(Model model,HttpServletRequest request) {

		return prefix+"/asset_import_form";
	}


	/**
	 * 资产 功能主页面
	 */
	@RequestMapping("/asset_info_list.html")
	public String infoList(Model model,HttpServletRequest request,String pageType,String pageFunc,String categoryCode,String ownerCode) {

		String authPrefix="eam_"+ownerCode;

		model.addAttribute("forBatchApprovalBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":for-batch-approval" ) );
		model.addAttribute("batchConfirmBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":batch-confirm"));
		model.addAttribute("batchRevokeBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":batch-revoke" ));
		model.addAttribute("changeQueryBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":change-query" ));
		model.addAttribute("billsBtgn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":bills" ));


		model.addAttribute("agreeBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":agree") );
		model.addAttribute("denyBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":deny"));

		model.addAttribute("createBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":create") );
		model.addAttribute("updateBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":update") );
		model.addAttribute("deleteBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":delete") );
		model.addAttribute("deleteByIdsBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":delete-by-ids") );
		model.addAttribute("queryBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":query") );
		model.addAttribute("viewFormBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":view-form") );

		model.addAttribute("printPdfBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":print-pdf") );
		model.addAttribute("cardBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":card" ));
		model.addAttribute("labelBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":label" ));
		model.addAttribute("highExportDataBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":high-export-data" ));
		model.addAttribute("batchInsertBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":batch-insert") );

		//页面类型，pageType=AssetAttributeItemOwnerEnum.BASE.code();
		model.addAttribute("pageType",pageType);
		model.addAttribute("pageFunc",pageFunc);
		model.addAttribute("ownerCode",ownerCode);


		//table宽度
		PageHelper p=new PageHelper(request,SessionUser.getCurrent());
		model.addAttribute("layuiTableWidthConfig",p.getTableColumnWidthConfig("data-table-"+pageType));
		model.addAttribute("tableId","data-table-"+pageType);


		//是否需要审批设置
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_INSERT.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);




		//设置字段布局
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(pageType,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		//设置资产分类
		CatalogVO catalog=new CatalogVO();
		if(StringUtil.isBlank(categoryCode)){
			catalog.setCode(AssetPcmCodeEnum.ASSET.code());
		}else{
			catalog.setCode(categoryCode);
		}
		model.addAttribute("categoryCode",categoryCode);
		Result<List<Catalog>> catalogListResult=CatalogServiceProxy.api().queryList(catalog);
		String categoryId="";
		if(catalogListResult.isSuccess()){
			List<Catalog> catalogList=catalogListResult.getData();
			if(catalogList.size()>0){
				categoryId=catalogList.get(0).getId();
				CatalogVO catalog2=new CatalogVO();
				catalog2.setParentId(categoryId);
				System.out.println("categoryId:"+categoryId);
				catalog2.setIsLoadAllDescendants(1);
				Result<List<ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
				System.out.println("assetCategoryData:"+treeResult);
				model.addAttribute("assetCategoryData",treeResult.getData());
			}
		}
		model.addAttribute("categoryId",categoryId);
		return prefix+"/asset_info_list";
	}

	@RequestMapping("/asset_info_batch_form.html")
	public String infoBatchForm(Model model,HttpServletRequest request , String id,String pageType,String categoryCode,String ownerCode,String internalControlLabel) {

		//页面类型
		model.addAttribute("pageType",pageType);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("internalControlLabel",internalControlLabel);



		//设置字段布局
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryFormColumnByModule(pageType,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			System.out.println(data.get("attributeData3Column1"));
			System.out.println(data.get("attributeData3Column2"));
			System.out.println(data.get("attributeData3Column3"));
			System.out.println(data.get("attributeData1Column1"));

			model.addAttribute("attributeData3Column1",data.get("attributeData3Column1"));
			model.addAttribute("attributeData3Column2",data.get("attributeData3Column2") );
			model.addAttribute("attributeData3Column3",data.get("attributeData3Column3") );
			model.addAttribute("attributeData1Column1",data.get("attributeData1Column1") );

		}


		//设置字段必选
		AssetAttributeItemVO attributeItem=new AssetAttributeItemVO();
		attributeItem.setOwnerCode(pageType);
		attributeItem.setRequired("1");
		attributeItem.setFormShow("1");
		Result<List<AssetAttributeItem>> attributeItemRequiredListResult = AssetAttributeItemServiceProxy.api().queryList(attributeItem);
		JSONObject attributeItemRequiredObject=new JSONObject();
		if(attributeItemRequiredListResult.isSuccess()){
			List<AssetAttributeItem>  attributeItemRequiredList = attributeItemRequiredListResult.getData();
			if(attributeItemRequiredList.size()>0){
				for(int i=0;i<attributeItemRequiredList.size();i++){
					JSONObject obj=new JSONObject();
					if(AssetAttributeDimensionEnum.ATTRIBUTION.code().equals(attributeItemRequiredList.get(i).getDimension())
							||AssetAttributeDimensionEnum.FINANCIAL.code().equals(attributeItemRequiredList.get(i).getDimension())
							||AssetAttributeDimensionEnum.MAINTAINER.code().equals(attributeItemRequiredList.get(i).getDimension())
							||AssetAttributeDimensionEnum.EQUIPMENT.code().equals(attributeItemRequiredList.get(i).getDimension())
					){
						obj.put("labelInForm",attributeItemRequiredList.get(i).getAttribute().getLabel());
						obj.put("inputType",attributeItemRequiredList.get(i).getAttribute().getComponentType());
						obj.put("required",true);
					}
					attributeItemRequiredObject.put(BeanNameUtil.instance().getPropertyName(attributeItemRequiredList.get(i).getAttribute().getCode()),obj);
				}
			}
		}


		model.addAttribute("attributeRequiredData",attributeItemRequiredObject);


		//设置资产分类
		CatalogVO catalog=new CatalogVO();
		if(StringUtil.isBlank(categoryCode)||"null".equals(categoryCode.toLowerCase())){
			catalog.setCode(AssetPcmCodeEnum.ASSET.code());
		}else{
			catalog.setCode(categoryCode);
		}
		Result<List<Catalog>> catalogListResult=CatalogServiceProxy.api().queryList(catalog);
		String categoryId="";
		if(catalogListResult.isSuccess()){
			List<Catalog> catalogList=catalogListResult.getData();
			if(catalogList.size()>0){
				categoryId=catalogList.get(0).getId();
				CatalogVO catalog2=new CatalogVO();
				catalog2.setParentId(categoryId);
				catalog2.setIsLoadAllDescendants(1);
				Result<List<ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
				model.addAttribute("assetCategoryData",treeResult.getData());
			}
		}


		//
		Result updateModeResult=OperateServiceProxy.api().queryAssetDirectUpdateMode();
		boolean updateMode=false;
		if(updateModeResult.isSuccess()){
			updateMode=(boolean)updateModeResult.getData();
		}
		model.addAttribute("assetDirectUpdateMode",updateMode);



		Result assetStatusColumnDisableResult=OperateServiceProxy.api().queryAssetStatusColumnDisable();
		boolean assetStatusDisable=false;
		if(assetStatusColumnDisableResult.isSuccess()){
			assetStatusDisable=(boolean)assetStatusColumnDisableResult.getData();
		}
		model.addAttribute("assetStatusColumnDisable",assetStatusDisable);



		//默认公司
		OrganizationVO vo=new OrganizationVO();
		vo.setSearchField("sort");
		vo.setValid(1);
		vo.setType("com");
		Result<List<Organization>> orgResult=OrganizationServiceProxy.api().queryList(vo);
		if(orgResult.isSuccess()&&orgResult.getData().size()>0){
			model.addAttribute("assetDefaultOwnCompany",orgResult.getData().get(0));
		}

		return prefix+"/asset_info_batch_form";
	}


		/**
         * 资产 表单页面
         */
	@RequestMapping("/asset_info_form.html")
	public String infoForm(Model model,HttpServletRequest request ,String id,String pageType,String categoryCode,String ownerCode,String internalControlLabel,String traceId) {

		//页面类型
		model.addAttribute("pageType",pageType);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("internalControlLabel",internalControlLabel);
		model.addAttribute("traceId",traceId);


		//设置字段布局
		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryFormColumnByModule(pageType,null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			System.out.println(data.get("attributeData3Column1"));
			System.out.println(data.get("attributeData3Column2"));
			System.out.println(data.get("attributeData3Column3"));
			System.out.println(data.get("attributeData1Column1"));

			model.addAttribute("attributeData3Column1",data.get("attributeData3Column1"));
			model.addAttribute("attributeData3Column2",data.get("attributeData3Column2") );
			model.addAttribute("attributeData3Column3",data.get("attributeData3Column3") );
			model.addAttribute("attributeData1Column1",data.get("attributeData1Column1") );

		}

		//是否自动生产编码,以及前端验证
		boolean assetCodeAutoCreate=true;
		Result assetCodeAutoCreateResult= OperateServiceProxy.api().queryAssetCodeAutoCreate();
		if(assetCodeAutoCreateResult.isSuccess()){
			assetCodeAutoCreate= (boolean) assetCodeAutoCreateResult.getData();
		}
		model.addAttribute("assetCodeAutoCreate",assetCodeAutoCreate);

		//设置字段必选
		AssetAttributeItemVO attributeItem=new AssetAttributeItemVO();
		attributeItem.setOwnerCode(pageType);
		attributeItem.setRequired("1");
		attributeItem.setFormShow("1");
		Result<List<AssetAttributeItem>> attributeItemRequiredListResult = AssetAttributeItemServiceProxy.api().queryList(attributeItem);
		JSONObject attributeItemRequiredObject=new JSONObject();
		if(attributeItemRequiredListResult.isSuccess()){
			List<AssetAttributeItem>  attributeItemRequiredList = attributeItemRequiredListResult.getData();
			if(attributeItemRequiredList.size()>0){
				for(int i=0;i<attributeItemRequiredList.size();i++){
					JSONObject obj=new JSONObject();
					if(AssetAttributeDimensionEnum.ATTRIBUTION.code().equals(attributeItemRequiredList.get(i).getDimension())
					||AssetAttributeDimensionEnum.FINANCIAL.code().equals(attributeItemRequiredList.get(i).getDimension())
					||AssetAttributeDimensionEnum.MAINTAINER.code().equals(attributeItemRequiredList.get(i).getDimension())
					||AssetAttributeDimensionEnum.EQUIPMENT.code().equals(attributeItemRequiredList.get(i).getDimension())
					){
						obj.put("labelInForm",attributeItemRequiredList.get(i).getAttribute().getLabel());
						obj.put("inputType",attributeItemRequiredList.get(i).getAttribute().getComponentType());
						obj.put("required",true);
					}
					//System.out.println("put name:"+BeanNameUtil.instance().getPropertyName(attributeItemRequiredList.get(i).getAttribute().getCode()));
					attributeItemRequiredObject.put(BeanNameUtil.instance().getPropertyName(attributeItemRequiredList.get(i).getAttribute().getCode()),obj);
				}
			}
		}

		//加入资产编号验证
		if(!assetCodeAutoCreate){
			JSONObject obj=new JSONObject();
			obj.put("labelInForm","资产编号");
			obj.put("inputType","text_input");
			obj.put("required",true);
			attributeItemRequiredObject.put("assetCode",obj);
		}

		model.addAttribute("attributeRequiredData",attributeItemRequiredObject);

		//设置资产分类
		CatalogVO catalog=new CatalogVO();
		if(StringUtil.isBlank(categoryCode)||"null".equals(categoryCode.toLowerCase())){
			catalog.setCode(AssetPcmCodeEnum.ASSET.code());
		}else{
			catalog.setCode(categoryCode);
		}
		Result<List<Catalog>> catalogListResult=CatalogServiceProxy.api().queryList(catalog);
		String categoryId="";
		if(catalogListResult.isSuccess()){
			List<Catalog> catalogList=catalogListResult.getData();
			if(catalogList.size()>0){
				categoryId=catalogList.get(0).getId();
				CatalogVO catalog2=new CatalogVO();
				catalog2.setParentId(categoryId);
				catalog2.setIsLoadAllDescendants(1);
				Result<List<ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
				model.addAttribute("assetCategoryData",treeResult.getData());
			}
		}


		//
		Result updateModeResult=OperateServiceProxy.api().queryAssetDirectUpdateMode();
		boolean updateMode=false;
		if(updateModeResult.isSuccess()){
			updateMode=(boolean)updateModeResult.getData();
		}
		model.addAttribute("assetDirectUpdateMode",updateMode);


		Result assetStatusColumnDisableResult=OperateServiceProxy.api().queryAssetStatusColumnDisable();
		boolean assetStatusDisable=false;
		if(assetStatusColumnDisableResult.isSuccess()){
			assetStatusDisable=(boolean)assetStatusColumnDisableResult.getData();
		}
		model.addAttribute("assetStatusColumnDisable",assetStatusDisable);

		//默认公司
		OrganizationVO vo=new OrganizationVO();
		vo.setSearchField("sort");
		vo.setValid(1);
		vo.setType("com");
		Result<List<Organization>> orgResult=OrganizationServiceProxy.api().queryList(vo);
		if(orgResult.isSuccess()&&orgResult.getData().size()>0){
			model.addAttribute("assetDefaultOwnCompany",orgResult.getData().get(0));
		}

		return prefix+"/asset_info_form";
	}


}