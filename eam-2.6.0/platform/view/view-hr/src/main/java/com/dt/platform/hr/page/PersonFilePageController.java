package com.dt.platform.hr.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.hr.PersonFileServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员档案模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:18:22
*/

@Controller("HrPersonFilePageController")
@RequestMapping(PersonFilePageController.prefix)
public class PersonFilePageController extends ViewController {
	
	public static final String prefix="business/hr/person_file";

	private PersonFileServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public PersonFileServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonFileServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 人员档案 功能主页面
	 */
	@RequestMapping("/person_file_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/person_file_list";
	}

	/**
	 * 人员档案 表单页面
	 */
	@RequestMapping("/person_file_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/person_file_form";
	}
}