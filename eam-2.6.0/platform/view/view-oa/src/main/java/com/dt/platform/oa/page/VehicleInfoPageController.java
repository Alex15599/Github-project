package com.dt.platform.oa.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.oa.VehicleInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 车辆信息 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-28 13:01:07
*/

@Controller("OaVehicleInfoPageController")
@RequestMapping(VehicleInfoPageController.prefix)
public class VehicleInfoPageController extends ViewController {
	
	public static final String prefix="business/oa/vehicle_info";

	private VehicleInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public VehicleInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=VehicleInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 车辆信息 功能主页面
	 */
	@RequestMapping("/vehicle_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/vehicle_info_list";
	}

	/**
	 * 车辆信息 表单页面
	 */
	@RequestMapping("/vehicle_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/vehicle_info_form";
	}
}