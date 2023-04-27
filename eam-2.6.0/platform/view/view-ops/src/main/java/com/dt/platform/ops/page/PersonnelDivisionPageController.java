package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.PersonnelDivisionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员分工模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-04 13:59:54
*/

@Controller("OpsPersonnelDivisionPageController")
@RequestMapping(PersonnelDivisionPageController.prefix)
public class PersonnelDivisionPageController extends ViewController {

	public static final String prefix="business/ops/personnel_division";

	private PersonnelDivisionServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public PersonnelDivisionServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonnelDivisionServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 人员分工 功能主页面
	 */
	@RequestMapping("/personnel_division_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"personnel_division_list");
	}

	/**
	 * 人员分工 功能主页面
	 */
	@RequestMapping("/personnel_division_public_list.html")
	public String publicList(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"personnel_division_public_list");
	}

	/**
	 * 人员分工 表单页面
	 */
	@RequestMapping("/personnel_division_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"personnel_division_form");
	}
}