package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplIndicatorVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 模版指标  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:33:31
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplIndicatorServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorTplIndicatorServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-tpl-indicator
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-tpl-indicator";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加模版指标
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除模版指标
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除模版指标
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新模版指标
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存模版指标
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个模版指标
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个模版指标
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询模版指标
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询模版指标
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorTplIndicatorVO") MonitorTplIndicatorVO monitorTplIndicatorVO);

    /**
     * 删除模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorTplIndicatorVO") MonitorTplIndicatorVO monitorTplIndicatorVO);

    /**
     * 更新模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorTplIndicatorVO") MonitorTplIndicatorVO monitorTplIndicatorVO);

    /**
     * 获取模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.GET_BY_ID)
    Result<MonitorTplIndicator> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.GET_BY_IDS)
    Result<List<MonitorTplIndicator>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.QUERY_LIST)
    Result<List<MonitorTplIndicator>> queryList(@RequestParam(name = "sample") MonitorTplIndicatorVO sample);

    /**
     * 分页查询模版指标
     */
    @RequestMapping(MonitorTplIndicatorServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorTplIndicator>> queryPagedList(@RequestParam(name = "sample") MonitorTplIndicatorVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorTplIndicatorController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorTplIndicatorServiceProxy api() {
        return APIProxy.get(MonitorTplIndicatorServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
