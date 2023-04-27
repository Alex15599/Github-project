package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 软件维保 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 16:44:03
*/

@Controller("EamAssetSoftwareMaintenancePageController")
@RequestMapping(AssetSoftwareMaintenancePageController.prefix)
public class AssetSoftwareMaintenancePageController extends ViewController {
	
	public static final String prefix="business/eam/asset_software_maintenance";

	private AssetSoftwareMaintenanceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetSoftwareMaintenanceServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetSoftwareMaintenanceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 软件维保 功能主页面
	 */
	@RequestMapping("/asset_software_maintenance_list.html")
	public String list(Model model,HttpServletRequest request) {

		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_SOFTWARE_MAINTENANCE.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);

		return prefix+"/asset_software_maintenance_list";
	}

	/**
	 * 软件维保 表单页面
	 */
	@RequestMapping("/asset_software_maintenance_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_software_maintenance_form";
	}
}