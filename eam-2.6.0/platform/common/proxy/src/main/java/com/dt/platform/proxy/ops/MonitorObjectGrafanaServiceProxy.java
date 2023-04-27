package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorObjectGrafana;
import com.dt.platform.domain.ops.MonitorObjectGrafanaVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * grafana配置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 07:25:52
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorObjectGrafanaServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorObjectGrafanaServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-object-grafana
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-object-grafana";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加grafana配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除grafana配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除grafana配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新grafana配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存grafana配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个grafana配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个grafana配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询grafana配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询grafana配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorObjectGrafanaVO") MonitorObjectGrafanaVO monitorObjectGrafanaVO);

    /**
     * 删除grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorObjectGrafanaVO") MonitorObjectGrafanaVO monitorObjectGrafanaVO);

    /**
     * 更新grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorObjectGrafanaVO") MonitorObjectGrafanaVO monitorObjectGrafanaVO);

    /**
     * 获取grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.GET_BY_ID)
    Result<MonitorObjectGrafana> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.GET_BY_IDS)
    Result<List<MonitorObjectGrafana>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.QUERY_LIST)
    Result<List<MonitorObjectGrafana>> queryList(@RequestParam(name = "sample") MonitorObjectGrafanaVO sample);

    /**
     * 分页查询grafana配置
     */
    @RequestMapping(MonitorObjectGrafanaServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorObjectGrafana>> queryPagedList(@RequestParam(name = "sample") MonitorObjectGrafanaVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorObjectGrafanaController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorObjectGrafanaServiceProxy api() {
        return APIProxy.get(MonitorObjectGrafanaServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
