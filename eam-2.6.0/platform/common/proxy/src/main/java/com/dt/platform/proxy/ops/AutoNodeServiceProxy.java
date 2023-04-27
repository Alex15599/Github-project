package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoNode;
import com.dt.platform.domain.ops.AutoNodeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 节点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 13:57:10
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoNodeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoNodeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-node
     */
    public static final String API_CONTEXT_PATH = "ops-auto-node";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     */
    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";

    /**
     */
    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";


    /**
     * 分页查询节点选择
     */
    public static final String SAVE_SELECTED_NODE = API_PREFIX + "save-selected-node";

    /**
     * 分页查询节点选择
     */
    public static final String REMOVE_SELECTED_NODE = API_PREFIX + "remove-selected-node";
    /**
     * 添加节点
     */
    @RequestMapping(AutoNodeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoNodeVO") AutoNodeVO autoNodeVO);

    /**
     * 删除节点
     */
    @RequestMapping(AutoNodeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点
     */
    @RequestMapping(AutoNodeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点
     */
    @RequestMapping(AutoNodeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoNodeVO") AutoNodeVO autoNodeVO);

    /**
     * 更新节点
     */
    @RequestMapping(AutoNodeServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoNodeVO") AutoNodeVO autoNodeVO);

    /**
     * 获取节点
     */
    @RequestMapping(AutoNodeServiceProxy.GET_BY_ID)
    Result<AutoNode> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点
     */
    @RequestMapping(AutoNodeServiceProxy.GET_BY_IDS)
    Result<List<AutoNode>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点
     */
    @RequestMapping(AutoNodeServiceProxy.QUERY_LIST)
    Result<List<AutoNode>> queryList(@RequestParam(name = "sample") AutoNodeVO sample);

    /**
     * 分页查询节点
     */
    @RequestMapping(AutoNodeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoNode>> queryPagedList(@RequestParam(name = "sample") AutoNodeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoNodeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoNodeServiceProxy api() {
        return APIProxy.get(AutoNodeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
