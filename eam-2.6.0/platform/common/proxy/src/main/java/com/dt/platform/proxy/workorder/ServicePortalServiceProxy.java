package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.ServicePortal;
import com.dt.platform.domain.workorder.ServicePortalVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务门户  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-08 22:24:18
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = ServicePortalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServicePortalServiceProxy {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-service-portal
     */
    public static final String API_CONTEXT_PATH = "wo-service-portal";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加服务门户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除服务门户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除服务门户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新服务门户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存服务门户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个服务门户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个服务门户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询服务门户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询服务门户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.INSERT)
    Result insert(@RequestParam(name = "servicePortalVO") ServicePortalVO servicePortalVO);

    /**
     * 删除服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.UPDATE)
    Result update(@RequestParam(name = "servicePortalVO") ServicePortalVO servicePortalVO);

    /**
     * 更新服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.SAVE)
    Result save(@RequestParam(name = "servicePortalVO") ServicePortalVO servicePortalVO);

    /**
     * 获取服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.GET_BY_ID)
    Result<ServicePortal> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.GET_BY_IDS)
    Result<List<ServicePortal>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.QUERY_LIST)
    Result<List<ServicePortal>> queryList(@RequestParam(name = "sample") ServicePortalVO sample);

    /**
     * 分页查询服务门户
     */
    @RequestMapping(ServicePortalServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServicePortal>> queryPagedList(@RequestParam(name = "sample") ServicePortalVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.ServicePortalController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServicePortalServiceProxy api() {
        return APIProxy.get(ServicePortalServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
