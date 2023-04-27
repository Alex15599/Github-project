package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoActionSScript;
import com.dt.platform.domain.ops.AutoActionSScriptVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 脚本选择  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 15:00:39
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoActionSScriptServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoActionSScriptServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-action-s-script
     */
    public static final String API_CONTEXT_PATH = "ops-auto-action-s-script";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加脚本选择
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除脚本选择
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除脚本选择
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新脚本选择
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存脚本选择
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个脚本选择
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个脚本选择
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询脚本选择
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询脚本选择
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoActionSScriptVO") AutoActionSScriptVO autoActionSScriptVO);

    /**
     * 删除脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoActionSScriptVO") AutoActionSScriptVO autoActionSScriptVO);

    /**
     * 更新脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoActionSScriptVO") AutoActionSScriptVO autoActionSScriptVO);

    /**
     * 获取脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.GET_BY_ID)
    Result<AutoActionSScript> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.GET_BY_IDS)
    Result<List<AutoActionSScript>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.QUERY_LIST)
    Result<List<AutoActionSScript>> queryList(@RequestParam(name = "sample") AutoActionSScriptVO sample);

    /**
     * 分页查询脚本选择
     */
    @RequestMapping(AutoActionSScriptServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoActionSScript>> queryPagedList(@RequestParam(name = "sample") AutoActionSScriptVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoActionSScriptController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoActionSScriptServiceProxy api() {
        return APIProxy.get(AutoActionSScriptServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
