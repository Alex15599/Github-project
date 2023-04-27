package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbEnvInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库环境模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-14 06:01:01
*/

@Controller("OpsDbEnvInfoPageController")
@RequestMapping(DbEnvInfoPageController.prefix)
public class DbEnvInfoPageController extends ViewController {

	public static final String prefix="business/ops/db_env_info";

	private DbEnvInfoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DbEnvInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbEnvInfoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据库环境 功能主页面
	 */
	@RequestMapping("/db_env_info_list.html")
	public String list(Model model,HttpServletRequest request,String instId) {
		model.addAttribute("instId",instId);
		return getTemplatePath(prefix,"db_env_info_list");
	}

	/**
	 * 数据库环境 表单页面
	 */
	@RequestMapping("/db_env_info_form.html")
	public String form(Model model,HttpServletRequest request , String id,String instId) {
		model.addAttribute("instId",instId);
		return getTemplatePath(prefix,"db_env_info_form");
	}
}