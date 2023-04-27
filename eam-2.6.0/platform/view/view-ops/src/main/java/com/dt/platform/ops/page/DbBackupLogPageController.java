package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbBackupLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 备份日志模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 22:15:39
*/

@Controller("OpsDbBackupLogPageController")
@RequestMapping(DbBackupLogPageController.prefix)
public class DbBackupLogPageController extends ViewController {
	
	public static final String prefix="business/ops/db_backup_log";

	private DbBackupLogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DbBackupLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbBackupLogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 备份日志 功能主页面
	 */
	@RequestMapping("/db_backup_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/db_backup_log_list";
	}

	/**
	 * 备份日志 表单页面
	 */
	@RequestMapping("/db_backup_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/db_backup_log_form";
	}
}