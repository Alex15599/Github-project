package com.dt.platform.knowledgebase.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.knowledgebase.ContentServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 知识库内容模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 18:39:15
*/

@Controller("KnContentPageController")
@RequestMapping(ContentPageController.prefix)
public class ContentPageController extends ViewController {

	public static final String prefix="business/knowledgebase/content";

	private ContentServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ContentServiceProxy proxy() {
		if(proxy==null) {
			proxy=ContentServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 知识库内容 功能主页面
	 */
	@RequestMapping("/content_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"content_list");
	}

	/**
	 * 知识库内容 表单页面
	 */
	@RequestMapping("/content_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"content_form");
	}
}