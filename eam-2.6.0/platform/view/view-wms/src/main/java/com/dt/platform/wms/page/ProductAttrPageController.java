package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.ProductAttrServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 产品属性模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:56
*/

@Controller("WmsProductAttrPageController")
@RequestMapping(ProductAttrPageController.prefix)
public class ProductAttrPageController extends ViewController {

	public static final String prefix="business/wms/product_attr";

	private ProductAttrServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ProductAttrServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProductAttrServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 产品属性 功能主页面
	 */
	@RequestMapping("/product_attr_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"product_attr_list");
	}

	/**
	 * 产品属性 表单页面
	 */
	@RequestMapping("/product_attr_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"product_attr_form");
	}
}