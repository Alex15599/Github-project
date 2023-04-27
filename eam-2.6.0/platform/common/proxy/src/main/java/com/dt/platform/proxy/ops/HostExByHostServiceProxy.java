package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.HostExByHost;
import com.dt.platform.domain.ops.HostExByHostVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 主机排除  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-11 16:26:30
 */
@FeignClient(value = ServiceNames.OPS, contextId = HostExByHostServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface HostExByHostServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-host-ex-by-host
     */
    public static final String API_CONTEXT_PATH = "ops-host-ex-by-host";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加主机排除
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除主机排除
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除主机排除
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新主机排除
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存主机排除
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个主机排除
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个主机排除
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询主机排除
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询主机排除
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.INSERT)
    Result insert(@RequestParam(name = "hostExByHostVO") HostExByHostVO hostExByHostVO);

    /**
     * 删除主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.UPDATE)
    Result update(@RequestParam(name = "hostExByHostVO") HostExByHostVO hostExByHostVO);

    /**
     * 更新主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.SAVE)
    Result save(@RequestParam(name = "hostExByHostVO") HostExByHostVO hostExByHostVO);

    /**
     * 获取主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.GET_BY_ID)
    Result<HostExByHost> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.GET_BY_IDS)
    Result<List<HostExByHost>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.QUERY_LIST)
    Result<List<HostExByHost>> queryList(@RequestParam(name = "sample") HostExByHostVO sample);

    /**
     * 分页查询主机排除
     */
    @RequestMapping(HostExByHostServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<HostExByHost>> queryPagedList(@RequestParam(name = "sample") HostExByHostVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.HostExByHostController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static HostExByHostServiceProxy api() {
        return APIProxy.get(HostExByHostServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
