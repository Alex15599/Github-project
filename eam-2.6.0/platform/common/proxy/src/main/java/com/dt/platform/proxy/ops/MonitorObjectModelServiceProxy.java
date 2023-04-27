package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorObjectModel;
import com.dt.platform.domain.ops.MonitorObjectModelVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 对象模型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-11 00:00:47
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorObjectModelServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorObjectModelServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-object-model
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-object-model";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加对象模型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除对象模型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除对象模型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新对象模型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存对象模型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个对象模型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个对象模型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询对象模型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询对象模型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorObjectModelVO") MonitorObjectModelVO monitorObjectModelVO);

    /**
     * 删除对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorObjectModelVO") MonitorObjectModelVO monitorObjectModelVO);

    /**
     * 更新对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorObjectModelVO") MonitorObjectModelVO monitorObjectModelVO);

    /**
     * 获取对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.GET_BY_ID)
    Result<MonitorObjectModel> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.GET_BY_IDS)
    Result<List<MonitorObjectModel>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.QUERY_LIST)
    Result<List<MonitorObjectModel>> queryList(@RequestParam(name = "sample") MonitorObjectModelVO sample);

    /**
     * 分页查询对象模型
     */
    @RequestMapping(MonitorObjectModelServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorObjectModel>> queryPagedList(@RequestParam(name = "sample") MonitorObjectModelVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorObjectModelController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorObjectModelServiceProxy api() {
        return APIProxy.get(MonitorObjectModelServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
