package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoBatchNode;
import com.dt.platform.domain.ops.AutoBatchNodeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 分组节点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 10:20:37
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoBatchNodeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoBatchNodeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-batch-node
     */
    public static final String API_CONTEXT_PATH = "ops-auto-batch-node";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加分组节点
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除分组节点
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除分组节点
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新分组节点
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存分组节点
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个分组节点
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个分组节点
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询分组节点
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询分组节点
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoBatchNodeVO") AutoBatchNodeVO autoBatchNodeVO);

    /**
     * 删除分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoBatchNodeVO") AutoBatchNodeVO autoBatchNodeVO);

    /**
     * 更新分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoBatchNodeVO") AutoBatchNodeVO autoBatchNodeVO);

    /**
     * 获取分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.GET_BY_ID)
    Result<AutoBatchNode> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.GET_BY_IDS)
    Result<List<AutoBatchNode>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.QUERY_LIST)
    Result<List<AutoBatchNode>> queryList(@RequestParam(name = "sample") AutoBatchNodeVO sample);

    /**
     * 分页查询分组节点
     */
    @RequestMapping(AutoBatchNodeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoBatchNode>> queryPagedList(@RequestParam(name = "sample") AutoBatchNodeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoBatchNodeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoBatchNodeServiceProxy api() {
        return APIProxy.get(AutoBatchNodeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
