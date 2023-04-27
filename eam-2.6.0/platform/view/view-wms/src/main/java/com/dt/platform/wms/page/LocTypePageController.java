package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.LocTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 库位类型模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:37
*/

@Controller("WmsLocTypePageController")
@RequestMapping(LocTypePageController.prefix)
public class LocTypePageController extends ViewController {

	public static final String prefix="business/wms/loc_type";

	private LocTypeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public LocTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=LocTypeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 库位类型 功能主页面
	 */
	@RequestMapping("/loc_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"loc_type_list");
	}

	/**
	 * 库位类型 表单页面
	 */
	@RequestMapping("/loc_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"loc_type_form");
	}
}