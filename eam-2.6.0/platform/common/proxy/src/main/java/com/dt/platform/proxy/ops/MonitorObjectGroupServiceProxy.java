package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorObjectGroup;
import com.dt.platform.domain.ops.MonitorObjectGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 对象分组  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 07:36:30
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorObjectGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorObjectGroupServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-object-group
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-object-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加对象分组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除对象分组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除对象分组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新对象分组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存对象分组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个对象分组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个对象分组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询对象分组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询对象分组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorObjectGroupVO") MonitorObjectGroupVO monitorObjectGroupVO);

    /**
     * 删除对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorObjectGroupVO") MonitorObjectGroupVO monitorObjectGroupVO);

    /**
     * 更新对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorObjectGroupVO") MonitorObjectGroupVO monitorObjectGroupVO);

    /**
     * 获取对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.GET_BY_ID)
    Result<MonitorObjectGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.GET_BY_IDS)
    Result<List<MonitorObjectGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.QUERY_LIST)
    Result<List<MonitorObjectGroup>> queryList(@RequestParam(name = "sample") MonitorObjectGroupVO sample);

    /**
     * 分页查询对象分组
     */
    @RequestMapping(MonitorObjectGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorObjectGroup>> queryPagedList(@RequestParam(name = "sample") MonitorObjectGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorObjectGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorObjectGroupServiceProxy api() {
        return APIProxy.get(MonitorObjectGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
