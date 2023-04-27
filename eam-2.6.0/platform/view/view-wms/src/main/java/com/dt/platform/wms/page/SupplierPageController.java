package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.SupplierServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 供应商模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:09
*/

@Controller("WmsSupplierPageController")
@RequestMapping(SupplierPageController.prefix)
public class SupplierPageController extends ViewController {

	public static final String prefix="business/wms/supplier";

	private SupplierServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SupplierServiceProxy proxy() {
		if(proxy==null) {
			proxy=SupplierServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 供应商 功能主页面
	 */
	@RequestMapping("/supplier_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"supplier_list");
	}

	/**
	 * 供应商 表单页面
	 */
	@RequestMapping("/supplier_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"supplier_form");
	}
}