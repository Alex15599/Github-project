package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.BackupDbStrategyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 备份策略模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-24 15:48:35
*/

@Controller("SysBackupDbStrategyPageController")
@RequestMapping(BackupDbStrategyPageController.prefix)
public class BackupDbStrategyPageController extends ViewController {
	
	public static final String prefix="business/common/backup_db_strategy";

	private BackupDbStrategyServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public BackupDbStrategyServiceProxy proxy() {
		if(proxy==null) {
			proxy=BackupDbStrategyServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 备份策略 功能主页面
	 */
	@RequestMapping("/backup_db_strategy_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/backup_db_strategy_list";
	}

	/**
	 * 备份策略 表单页面
	 */
	@RequestMapping("/backup_db_strategy_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/backup_db_strategy_form";
	}
}