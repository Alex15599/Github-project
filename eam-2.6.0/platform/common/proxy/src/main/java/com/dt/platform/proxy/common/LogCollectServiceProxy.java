package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.LogCollect;
import com.dt.platform.domain.common.LogCollectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 日志收集 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-17 10:53:57
 */
@FeignClient(value = ServiceNames.COMMON, contextId = LogCollectServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface LogCollectServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-log-collect
     */
    public static final String API_CONTEXT_PATH = "sys-log-collect";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加日志收集
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除日志收集
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除日志收集
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新日志收集
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存日志收集
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个日志收集
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个日志收集
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询日志收集
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 查询日志收集
     */
    public static final String COLLECT = API_PREFIX + "collect";

    /**
     * 分页查询日志收集
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加日志收集
     */
    @RequestMapping(LogCollectServiceProxy.INSERT)
    Result insert(@RequestParam(name = "logCollectVO") LogCollectVO logCollectVO);

    /**
     * 删除日志收集
     */
    @RequestMapping(LogCollectServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除日志收集
     */
    @RequestMapping(LogCollectServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新日志收集
     */
    @RequestMapping(LogCollectServiceProxy.UPDATE)
    Result update(@RequestParam(name = "logCollectVO") LogCollectVO logCollectVO);

    /**
     * 更新日志收集
     */
    @RequestMapping(LogCollectServiceProxy.SAVE)
    Result save(@RequestParam(name = "logCollectVO") LogCollectVO logCollectVO);

    /**
     * 获取日志收集
     */
    @RequestMapping(LogCollectServiceProxy.GET_BY_ID)
    Result<LogCollect> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个日志收集
     */
    @RequestMapping(LogCollectServiceProxy.GET_BY_IDS)
    Result<List<LogCollect>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询日志收集
     */
    @RequestMapping(LogCollectServiceProxy.QUERY_LIST)
    Result<List<LogCollect>> queryList(@RequestParam(name = "sample") LogCollectVO sample);

    /**
     * 分页查询日志收集
     */
    @RequestMapping(LogCollectServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<LogCollect>> queryPagedList(@RequestParam(name = "sample") LogCollectVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.LogCollectController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static LogCollectServiceProxy api() {
        return APIProxy.get(LogCollectServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
