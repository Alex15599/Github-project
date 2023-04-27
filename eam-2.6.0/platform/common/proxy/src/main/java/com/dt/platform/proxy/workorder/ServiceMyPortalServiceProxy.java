package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.ServiceMyPortal;
import com.dt.platform.domain.workorder.ServiceMyPortalVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 我的门户  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-08 21:59:47
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = ServiceMyPortalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServiceMyPortalServiceProxy {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-service-my-portal
     */
    public static final String API_CONTEXT_PATH = "wo-service-my-portal";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加我的门户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除我的门户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除我的门户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新我的门户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存我的门户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个我的门户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个我的门户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询我的门户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询我的门户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serviceMyPortalVO") ServiceMyPortalVO serviceMyPortalVO);

    /**
     * 删除我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serviceMyPortalVO") ServiceMyPortalVO serviceMyPortalVO);

    /**
     * 更新我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.SAVE)
    Result save(@RequestParam(name = "serviceMyPortalVO") ServiceMyPortalVO serviceMyPortalVO);

    /**
     * 获取我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.GET_BY_ID)
    Result<ServiceMyPortal> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.GET_BY_IDS)
    Result<List<ServiceMyPortal>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.QUERY_LIST)
    Result<List<ServiceMyPortal>> queryList(@RequestParam(name = "sample") ServiceMyPortalVO sample);

    /**
     * 分页查询我的门户
     */
    @RequestMapping(ServiceMyPortalServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServiceMyPortal>> queryPagedList(@RequestParam(name = "sample") ServiceMyPortalVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.ServiceMyPortalController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServiceMyPortalServiceProxy api() {
        return APIProxy.get(ServiceMyPortalServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
