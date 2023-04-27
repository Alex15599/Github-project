package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DeployStandardServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 部署标准模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 08:27:14
*/

@Controller("OpsDeployStandardPageController")
@RequestMapping(DeployStandardPageController.prefix)
public class DeployStandardPageController extends ViewController {
	
	public static final String prefix="business/ops/deploy_standard";

	private DeployStandardServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DeployStandardServiceProxy proxy() {
		if(proxy==null) {
			proxy=DeployStandardServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 部署标准 功能主页面
	 */
	@RequestMapping("/deploy_standard_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/deploy_standard_list";
	}

	/**
	 * 部署标准 表单页面
	 */
	@RequestMapping("/deploy_standard_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/deploy_standard_form";
	}
}