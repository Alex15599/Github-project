package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.ServerOsType;
import com.dt.platform.domain.workorder.ServerOsTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 操作系统  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-13 14:56:12
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = ServerOsTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServerOsTypeServiceProxy {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-server-os-type
     */
    public static final String API_CONTEXT_PATH = "wo-server-os-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加操作系统
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除操作系统
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除操作系统
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新操作系统
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存操作系统
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个操作系统
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个操作系统
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询操作系统
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询操作系统
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serverOsTypeVO") ServerOsTypeVO serverOsTypeVO);

    /**
     * 删除操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serverOsTypeVO") ServerOsTypeVO serverOsTypeVO);

    /**
     * 更新操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "serverOsTypeVO") ServerOsTypeVO serverOsTypeVO);

    /**
     * 获取操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.GET_BY_ID)
    Result<ServerOsType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.GET_BY_IDS)
    Result<List<ServerOsType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.QUERY_LIST)
    Result<List<ServerOsType>> queryList(@RequestParam(name = "sample") ServerOsTypeVO sample);

    /**
     * 分页查询操作系统
     */
    @RequestMapping(ServerOsTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServerOsType>> queryPagedList(@RequestParam(name = "sample") ServerOsTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.ServerOsTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServerOsTypeServiceProxy api() {
        return APIProxy.get(ServerOsTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
