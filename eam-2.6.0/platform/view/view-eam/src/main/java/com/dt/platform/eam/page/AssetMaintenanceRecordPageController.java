package com.dt.platform.eam.page;

import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import com.dt.platform.proxy.eam.AssetMaintenanceUpdateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetMaintenanceRecordServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维保更新记录模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 19:59:57
*/

@Controller("EamAssetMaintenanceRecordPageController")
@RequestMapping(AssetMaintenanceRecordPageController.prefix)
public class AssetMaintenanceRecordPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_maintenance_record";

	private AssetMaintenanceRecordServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetMaintenanceRecordServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetMaintenanceRecordServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 维保更新记录 功能主页面
	 */
	@RequestMapping("/asset_maintenance_record_list.html")
	public String list(Model model,HttpServletRequest request,String maintenanceUpdateId) {

		Result<AssetMaintenanceUpdate> result=AssetMaintenanceUpdateServiceProxy.api().getById(maintenanceUpdateId);
		if(result.isSuccess()){
			model.addAttribute("maintenanceUpdateData",result.getData());
		}else{
			model.addAttribute("maintenanceUpdateData","{}");
		}
		model.addAttribute("maintenanceUpdateId",maintenanceUpdateId);
		return prefix+"/asset_maintenance_record_list";
	}

	/**
	 * 维保更新记录 表单页面
	 */
	@RequestMapping("/asset_maintenance_record_form.html")
	public String form(Model model,HttpServletRequest request , String id,String maintenanceUpdateId) {
		model.addAttribute("maintenanceUpdateId",maintenanceUpdateId);
		return prefix+"/asset_maintenance_record_form";
	}
}