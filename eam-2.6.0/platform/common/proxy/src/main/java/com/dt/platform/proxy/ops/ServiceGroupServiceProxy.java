package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.ServiceGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务分组  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-12 22:05:33
 */
@FeignClient(value = ServiceNames.OPS, contextId = ServiceGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServiceGroupServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-service-group
     */
    public static final String API_CONTEXT_PATH = "ops-service-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加服务分组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除服务分组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除服务分组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新服务分组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存服务分组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个服务分组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个服务分组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询服务分组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询服务分组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serviceGroupVO") ServiceGroupVO serviceGroupVO);

    /**
     * 删除服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serviceGroupVO") ServiceGroupVO serviceGroupVO);

    /**
     * 更新服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "serviceGroupVO") ServiceGroupVO serviceGroupVO);

    /**
     * 获取服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.GET_BY_ID)
    Result<ServiceGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.GET_BY_IDS)
    Result<List<ServiceGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.QUERY_LIST)
    Result<List<ServiceGroup>> queryList(@RequestParam(name = "sample") ServiceGroupVO sample);

    /**
     * 分页查询服务分组
     */
    @RequestMapping(ServiceGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServiceGroup>> queryPagedList(@RequestParam(name = "sample") ServiceGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.ServiceGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServiceGroupServiceProxy api() {
        return APIProxy.get(ServiceGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
