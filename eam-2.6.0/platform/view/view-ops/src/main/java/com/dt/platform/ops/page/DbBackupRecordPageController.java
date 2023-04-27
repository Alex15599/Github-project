package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.DbBackupRecordServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 备份记录 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-11 21:41:54
*/

@Controller("OpsDbBackupRecordPageController")
@RequestMapping(DbBackupRecordPageController.prefix)
public class DbBackupRecordPageController extends ViewController {
	
	public static final String prefix="business/ops/db_backup_record";

	private DbBackupRecordServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DbBackupRecordServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbBackupRecordServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 备份记录 功能主页面
	 */
	@RequestMapping("/db_backup_record_list.html")
	public String list(Model model,HttpServletRequest request,String dbId,String backupResult) {
		model.addAttribute("dbId",dbId);
		model.addAttribute("backupResult",backupResult);
		return prefix+"/db_backup_record_list";
	}

	/**
	 * 备份记录 表单页面
	 */
	@RequestMapping("/db_backup_record_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/db_backup_record_form";
	}
}