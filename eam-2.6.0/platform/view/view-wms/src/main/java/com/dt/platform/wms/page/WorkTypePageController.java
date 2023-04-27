package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.WorkTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 作业类型模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:29
*/

@Controller("WmsWorkTypePageController")
@RequestMapping(WorkTypePageController.prefix)
public class WorkTypePageController extends ViewController {

	public static final String prefix="business/wms/work_type";

	private WorkTypeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public WorkTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=WorkTypeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 作业类型 功能主页面
	 */
	@RequestMapping("/work_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"work_type_list");
	}

	/**
	 * 作业类型 表单页面
	 */
	@RequestMapping("/work_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"work_type_form");
	}
}