package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 监控模版  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:26:05
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorTplServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-tpl
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-tpl";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加监控模版
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除监控模版
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除监控模版
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新监控模版
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存监控模版
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个监控模版
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个监控模版
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询监控模版
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询监控模版
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorTplVO") MonitorTplVO monitorTplVO);

    /**
     * 删除监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorTplVO") MonitorTplVO monitorTplVO);

    /**
     * 更新监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorTplVO") MonitorTplVO monitorTplVO);

    /**
     * 获取监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.GET_BY_ID)
    Result<MonitorTpl> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.GET_BY_IDS)
    Result<List<MonitorTpl>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.QUERY_LIST)
    Result<List<MonitorTpl>> queryList(@RequestParam(name = "sample") MonitorTplVO sample);

    /**
     * 分页查询监控模版
     */
    @RequestMapping(MonitorTplServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorTpl>> queryPagedList(@RequestParam(name = "sample") MonitorTplVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorTplController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorTplServiceProxy api() {
        return APIProxy.get(MonitorTplServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
