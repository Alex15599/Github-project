package com.dt.platform.proxy.ops;

import com.dt.platform.proxy.ServiceNames;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 主机  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:49
*/

@FeignClient(value = ServiceNames.OPS, contextId = OpsDatabaseServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface OpsDatabaseServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 , ops-host
	*/
	public static final String API_CONTEXT_PATH = "ops-database";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";


	/**
	 * 插入数据库备份记录
	 */
	public static final String RECORD_DATABASE_BACKUP = API_PREFIX + "record-database-backup";

	/**
	 * 查询数据
	 */
	public static final String QUERY_DATABASE_DATA = API_PREFIX + "query-database-data";

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.OpsDatabaseController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static OpsDatabaseServiceProxy api() {
		return APIProxy.get(OpsDatabaseServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}