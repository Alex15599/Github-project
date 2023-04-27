package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.NodeLoad;
import com.dt.platform.domain.common.NodeLoadVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 节点负载 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:37:38
 */
@FeignClient(value = ServiceNames.COMMON, contextId = NodeLoadServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NodeLoadServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-node-load
     */
    public static final String API_CONTEXT_PATH = "sys-node-load";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点负载
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点负载
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点负载
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点负载
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点负载
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点负载
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点负载
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点负载
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点负载
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询节点负载
     */
    public static final String LOAD_DATA = API_PREFIX + "load-data";


    /**
     * 添加节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.INSERT)
    Result insert(@RequestParam(name = "nodeLoadVO") NodeLoadVO nodeLoadVO);

    /**
     * 删除节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.UPDATE)
    Result update(@RequestParam(name = "nodeLoadVO") NodeLoadVO nodeLoadVO);

    /**
     * 更新节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.SAVE)
    Result save(@RequestParam(name = "nodeLoadVO") NodeLoadVO nodeLoadVO);

    /**
     * 获取节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.GET_BY_ID)
    Result<NodeLoad> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.GET_BY_IDS)
    Result<List<NodeLoad>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.QUERY_LIST)
    Result<List<NodeLoad>> queryList(@RequestParam(name = "sample") NodeLoadVO sample);

    /**
     * 分页查询节点负载
     */
    @RequestMapping(NodeLoadServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NodeLoad>> queryPagedList(@RequestParam(name = "sample") NodeLoadVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.NodeLoadController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NodeLoadServiceProxy api() {
        return APIProxy.get(NodeLoadServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
