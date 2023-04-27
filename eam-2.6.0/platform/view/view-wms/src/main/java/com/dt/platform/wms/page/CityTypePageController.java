package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.CityTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 城市类型模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:32
*/

@Controller("WmsCityTypePageController")
@RequestMapping(CityTypePageController.prefix)
public class CityTypePageController extends ViewController {

	public static final String prefix="business/wms/city_type";

	private CityTypeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CityTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=CityTypeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 城市类型 功能主页面
	 */
	@RequestMapping("/city_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"city_type_list");
	}

	/**
	 * 城市类型 表单页面
	 */
	@RequestMapping("/city_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"city_type_form");
	}
}