package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionPointPosServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检点位模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-10 09:39:30
*/

@Controller("EamInspectionPointPosPageController")
@RequestMapping(InspectionPointPosPageController.prefix)
public class InspectionPointPosPageController extends ViewController {

	public static final String prefix="business/eam/inspection_point_pos";

	private InspectionPointPosServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public InspectionPointPosServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionPointPosServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 巡检点位 功能主页面
	 */
	@RequestMapping("/inspection_point_pos_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"inspection_point_pos_list");
	}

	/**
	 * 巡检点位 表单页面
	 */
	@RequestMapping("/inspection_point_pos_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"inspection_point_pos_form");
	}
}