package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.FeedbackServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 反馈信息模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:50:49
*/

@Controller("EamFeedbackPageController")
@RequestMapping(FeedbackPageController.prefix)
public class FeedbackPageController extends ViewController {
	
	public static final String prefix="business/eam/feedback";

	private FeedbackServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public FeedbackServiceProxy proxy() {
		if(proxy==null) {
			proxy=FeedbackServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 反馈信息 功能主页面
	 */
	@RequestMapping("/feedback_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/feedback_list";
	}

	/**
	 * 反馈信息 表单页面
	 */
	@RequestMapping("/feedback_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/feedback_form";
	}
}