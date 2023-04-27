package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoActionScript;
import com.dt.platform.domain.ops.AutoActionScriptVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 执行脚本  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 12:51:30
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoActionScriptServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoActionScriptServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-action-script
     */
    public static final String API_CONTEXT_PATH = "ops-auto-action-script";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加执行脚本
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除执行脚本
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除执行脚本
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新执行脚本
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存执行脚本
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个执行脚本
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个执行脚本
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询执行脚本
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询执行脚本
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoActionScriptVO") AutoActionScriptVO autoActionScriptVO);

    /**
     * 删除执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoActionScriptVO") AutoActionScriptVO autoActionScriptVO);

    /**
     * 更新执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoActionScriptVO") AutoActionScriptVO autoActionScriptVO);

    /**
     * 获取执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.GET_BY_ID)
    Result<AutoActionScript> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.GET_BY_IDS)
    Result<List<AutoActionScript>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.QUERY_LIST)
    Result<List<AutoActionScript>> queryList(@RequestParam(name = "sample") AutoActionScriptVO sample);

    /**
     * 分页查询执行脚本
     */
    @RequestMapping(AutoActionScriptServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoActionScript>> queryPagedList(@RequestParam(name = "sample") AutoActionScriptVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoActionScriptController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoActionScriptServiceProxy api() {
        return APIProxy.get(AutoActionScriptServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
