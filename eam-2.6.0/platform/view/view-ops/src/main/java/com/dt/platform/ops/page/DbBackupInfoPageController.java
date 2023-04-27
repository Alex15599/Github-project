package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbBackupInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库备份 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-10 13:50:27
*/

@Controller("OpsDbBackupInfoPageController")
@RequestMapping(DbBackupInfoPageController.prefix)
public class DbBackupInfoPageController extends ViewController {
	
	public static final String prefix="business/ops/db_backup_info";

	private DbBackupInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DbBackupInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbBackupInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据库备份 功能主页面
	 */
	@RequestMapping("/db_backup_info_list.html")
	public String list(Model model,HttpServletRequest request,String dbId,String pageType,String selectedCode) {
		model.addAttribute("dbId",dbId);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/db_backup_info_list";
	}

	/**
	 * 数据库备份 表单页面
	 */
	@RequestMapping("/db_backup_info_form.html")
	public String form(Model model,HttpServletRequest request , String id,String dbId,String selectedCode) {
		model.addAttribute("dbId",dbId);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/db_backup_info_form";
	}
}