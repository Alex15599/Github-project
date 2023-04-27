package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.PlanExecuteLog;
import com.dt.platform.domain.eam.PlanExecuteLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 执行日志 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:35:39
 */
@FeignClient(value = ServiceNames.EAM, contextId = PlanExecuteLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PlanExecuteLogServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-plan-execute-log
     */
    public static final String API_CONTEXT_PATH = "eam-plan-execute-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加执行日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除执行日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除执行日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新执行日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存执行日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个执行日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个执行日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询执行日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询执行日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "planExecuteLogVO") PlanExecuteLogVO planExecuteLogVO);

    /**
     * 删除执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "planExecuteLogVO") PlanExecuteLogVO planExecuteLogVO);

    /**
     * 更新执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "planExecuteLogVO") PlanExecuteLogVO planExecuteLogVO);

    /**
     * 获取执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.GET_BY_ID)
    Result<PlanExecuteLog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.GET_BY_IDS)
    Result<List<PlanExecuteLog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.QUERY_LIST)
    Result<List<PlanExecuteLog>> queryList(@RequestParam(name = "sample") PlanExecuteLogVO sample);

    /**
     * 分页查询执行日志
     */
    @RequestMapping(PlanExecuteLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PlanExecuteLog>> queryPagedList(@RequestParam(name = "sample") PlanExecuteLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.PlanExecuteLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PlanExecuteLogServiceProxy api() {
        return APIProxy.get(PlanExecuteLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
