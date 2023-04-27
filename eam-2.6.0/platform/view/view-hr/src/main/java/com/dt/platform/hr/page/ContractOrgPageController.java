package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.ContractOrgServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 合同签订方模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:30:35
*/

@Controller("HrContractOrgPageController")
@RequestMapping(ContractOrgPageController.prefix)
public class ContractOrgPageController extends ViewController {
	
	public static final String prefix="business/hr/contract_org";

	private ContractOrgServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ContractOrgServiceProxy proxy() {
		if(proxy==null) {
			proxy=ContractOrgServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 合同签订方 功能主页面
	 */
	@RequestMapping("/contract_org_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/contract_org_list";
	}

	/**
	 * 合同签订方 表单页面
	 */
	@RequestMapping("/contract_org_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/contract_org_form";
	}
}