package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-10 14:39:12
*/

@Controller("OpsDbInfoPageController")
@RequestMapping(DbInfoPageController.prefix)
public class DbInfoPageController extends ViewController {
	
	public static final String prefix="business/ops/db_info";

	private DbInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DbInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbInfoServiceProxy.api();
		}
		return proxy;
	}
	/**
	 * 数据库统计
	 */
	@RequestMapping("/db_info_report_list.html")
	public String reportList(Model model,HttpServletRequest request) {
		return prefix+"/db_info_report_list";
	}


	/**
	 * 数据库备份统计
	 */
	@RequestMapping("/db_backup_report_list.html")
	public String backupList(Model model,HttpServletRequest request) {
		return prefix+"/db_backup_report_list";
	}

	/**
	 * 数据库 功能主页面
	 */
	@RequestMapping("/db_software_list.html")
	public String softwareList(Model model,HttpServletRequest request) {
		return prefix+"/db_software_list";
	}


	/**
	 * 数据库 功能主页面
	 */
	@RequestMapping("/db_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/db_info_list";
	}


	/**
	 * 数据库 功能主页面
	 */
	@RequestMapping("/db_info_public_list.html")
	public String publicList(Model model,HttpServletRequest request) {
		return prefix+"/db_info_public_list";
	}

	/**
	 * 数据库 表单页面
	 */
	@RequestMapping("/db_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/db_info_form";
	}


	/**
	 * 数据库 功能主页面
	 */
	@RequestMapping("/db_backup_detail_list.html")
	public String detailList(Model model,HttpServletRequest request) {
		return prefix+"/db_backup_detail_list";
	}


}