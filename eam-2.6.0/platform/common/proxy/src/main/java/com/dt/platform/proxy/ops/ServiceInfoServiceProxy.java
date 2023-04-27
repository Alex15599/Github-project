package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.ServiceInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-12 22:05:38
 */
@FeignClient(value = ServiceNames.OPS, contextId = ServiceInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServiceInfoServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-service-info
     */
    public static final String API_CONTEXT_PATH = "ops-service-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加服务
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除服务
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除服务
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新服务
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存服务
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个服务
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个服务
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询服务
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询服务
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加服务
     */
    @RequestMapping(ServiceInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serviceInfoVO") ServiceInfoVO serviceInfoVO);

    /**
     * 删除服务
     */
    @RequestMapping(ServiceInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除服务
     */
    @RequestMapping(ServiceInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新服务
     */
    @RequestMapping(ServiceInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serviceInfoVO") ServiceInfoVO serviceInfoVO);

    /**
     * 更新服务
     */
    @RequestMapping(ServiceInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "serviceInfoVO") ServiceInfoVO serviceInfoVO);

    /**
     * 获取服务
     */
    @RequestMapping(ServiceInfoServiceProxy.GET_BY_ID)
    Result<ServiceInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个服务
     */
    @RequestMapping(ServiceInfoServiceProxy.GET_BY_IDS)
    Result<List<ServiceInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询服务
     */
    @RequestMapping(ServiceInfoServiceProxy.QUERY_LIST)
    Result<List<ServiceInfo>> queryList(@RequestParam(name = "sample") ServiceInfoVO sample);

    /**
     * 分页查询服务
     */
    @RequestMapping(ServiceInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServiceInfo>> queryPagedList(@RequestParam(name = "sample") ServiceInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.ServiceInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServiceInfoServiceProxy api() {
        return APIProxy.get(ServiceInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
