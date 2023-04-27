package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.BillRelationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 单据关联 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-24 19:16:17
*/

@Controller("EamBillRelationPageController")
@RequestMapping(BillRelationPageController.prefix)
public class BillRelationPageController extends ViewController {
	
	public static final String prefix="business/eam/bill_relation";

	private BillRelationServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public BillRelationServiceProxy proxy() {
		if(proxy==null) {
			proxy=BillRelationServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 单据关联 功能主页面
	 */
	@RequestMapping("/bill_relation_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/bill_relation_list";
	}

	/**
	 * 单据关联 表单页面
	 */
	@RequestMapping("/bill_relation_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/bill_relation_form";
	}
}