package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.UnitServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 计量单位模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:22
*/

@Controller("WmsUnitPageController")
@RequestMapping(UnitPageController.prefix)
public class UnitPageController extends ViewController {

	public static final String prefix="business/wms/unit";

	private UnitServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public UnitServiceProxy proxy() {
		if(proxy==null) {
			proxy=UnitServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 计量单位 功能主页面
	 */
	@RequestMapping("/unit_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"unit_list");
	}

	/**
	 * 计量单位 表单页面
	 */
	@RequestMapping("/unit_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"unit_form");
	}
}