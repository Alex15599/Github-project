package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.MonitorTplTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 模版类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-13 07:15:58
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorTplTypeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-tpl-type
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-tpl-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加模版类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除模版类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除模版类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新模版类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存模版类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个模版类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个模版类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询模版类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询模版类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorTplTypeVO") MonitorTplTypeVO monitorTplTypeVO);

    /**
     * 删除模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorTplTypeVO") MonitorTplTypeVO monitorTplTypeVO);

    /**
     * 更新模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorTplTypeVO") MonitorTplTypeVO monitorTplTypeVO);

    /**
     * 获取模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.GET_BY_ID)
    Result<MonitorTplType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.GET_BY_IDS)
    Result<List<MonitorTplType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.QUERY_LIST)
    Result<List<MonitorTplType>> queryList(@RequestParam(name = "sample") MonitorTplTypeVO sample);

    /**
     * 分页查询模版类型
     */
    @RequestMapping(MonitorTplTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorTplType>> queryPagedList(@RequestParam(name = "sample") MonitorTplTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorTplTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorTplTypeServiceProxy api() {
        return APIProxy.get(MonitorTplTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
