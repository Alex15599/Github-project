package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.ServiceDesk;
import com.dt.platform.domain.workorder.ServiceDeskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务台  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-07 07:36:40
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = ServiceDeskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServiceDeskServiceProxy {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-service-desk
     */
    public static final String API_CONTEXT_PATH = "wo-service-desk";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加服务台
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除服务台
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除服务台
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新服务台
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存服务台
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个服务台
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个服务台
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询服务台
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询服务台
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serviceDeskVO") ServiceDeskVO serviceDeskVO);

    /**
     * 删除服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serviceDeskVO") ServiceDeskVO serviceDeskVO);

    /**
     * 更新服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.SAVE)
    Result save(@RequestParam(name = "serviceDeskVO") ServiceDeskVO serviceDeskVO);

    /**
     * 获取服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.GET_BY_ID)
    Result<ServiceDesk> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.GET_BY_IDS)
    Result<List<ServiceDesk>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.QUERY_LIST)
    Result<List<ServiceDesk>> queryList(@RequestParam(name = "sample") ServiceDeskVO sample);

    /**
     * 分页查询服务台
     */
    @RequestMapping(ServiceDeskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServiceDesk>> queryPagedList(@RequestParam(name = "sample") ServiceDeskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.ServiceDeskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServiceDeskServiceProxy api() {
        return APIProxy.get(ServiceDeskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
