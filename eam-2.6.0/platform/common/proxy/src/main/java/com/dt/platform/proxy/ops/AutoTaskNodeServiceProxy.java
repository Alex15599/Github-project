package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoTaskNode;
import com.dt.platform.domain.ops.AutoTaskNodeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 作业节点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 13:41:32
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoTaskNodeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoTaskNodeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-task-node
     */
    public static final String API_CONTEXT_PATH = "ops-auto-task-node";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加作业节点
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除作业节点
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除作业节点
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新作业节点
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存作业节点
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个作业节点
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个作业节点
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询作业节点
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询作业节点
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoTaskNodeVO") AutoTaskNodeVO autoTaskNodeVO);

    /**
     * 删除作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoTaskNodeVO") AutoTaskNodeVO autoTaskNodeVO);

    /**
     * 更新作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoTaskNodeVO") AutoTaskNodeVO autoTaskNodeVO);

    /**
     * 获取作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.GET_BY_ID)
    Result<AutoTaskNode> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.GET_BY_IDS)
    Result<List<AutoTaskNode>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.QUERY_LIST)
    Result<List<AutoTaskNode>> queryList(@RequestParam(name = "sample") AutoTaskNodeVO sample);

    /**
     * 分页查询作业节点
     */
    @RequestMapping(AutoTaskNodeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoTaskNode>> queryPagedList(@RequestParam(name = "sample") AutoTaskNodeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoTaskNodeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoTaskNodeServiceProxy api() {
        return APIProxy.get(AutoTaskNodeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
