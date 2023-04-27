package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.ProductCategoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 商品分类模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 08:50:26
*/

@Controller("WmsProductCategoryPageController")
@RequestMapping(ProductCategoryPageController.prefix)
public class ProductCategoryPageController extends ViewController {

	public static final String prefix="business/wms/product_category";

	private ProductCategoryServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ProductCategoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProductCategoryServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 商品分类 功能主页面
	 */
	@RequestMapping("/product_category_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"product_category_list");
	}

	/**
	 * 商品分类 表单页面
	 */
	@RequestMapping("/product_category_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"product_category_form");
	}
}