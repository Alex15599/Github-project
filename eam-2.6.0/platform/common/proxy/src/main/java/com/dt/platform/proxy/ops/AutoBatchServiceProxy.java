package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoBatch;
import com.dt.platform.domain.ops.AutoBatchVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 节点批次  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 14:26:33
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoBatchServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoBatchServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-batch
     */
    public static final String API_CONTEXT_PATH = "ops-auto-batch";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点批次
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点批次
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点批次
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点批次
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点批次
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点批次
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点批次
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点批次
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点批次
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoBatchVO") AutoBatchVO autoBatchVO);

    /**
     * 删除节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoBatchVO") AutoBatchVO autoBatchVO);

    /**
     * 更新节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoBatchVO") AutoBatchVO autoBatchVO);

    /**
     * 获取节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.GET_BY_ID)
    Result<AutoBatch> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.GET_BY_IDS)
    Result<List<AutoBatch>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.QUERY_LIST)
    Result<List<AutoBatch>> queryList(@RequestParam(name = "sample") AutoBatchVO sample);

    /**
     * 分页查询节点批次
     */
    @RequestMapping(AutoBatchServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoBatch>> queryPagedList(@RequestParam(name = "sample") AutoBatchVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoBatchController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoBatchServiceProxy api() {
        return APIProxy.get(AutoBatchServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
