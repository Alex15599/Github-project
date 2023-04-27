package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 配置库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
 */
@FeignClient(value = ServiceNames.OPS, contextId = CmdbModelServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CmdbModelServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-cmdb-model
     */
    public static final String API_CONTEXT_PATH = "ops-cmdb-model";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加配置库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除配置库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除配置库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新配置库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存配置库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个配置库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个配置库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询配置库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询配置库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加配置库
     */
    @RequestMapping(CmdbModelServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cmdbModelVO") CmdbModelVO cmdbModelVO);

    /**
     * 删除配置库
     */
    @RequestMapping(CmdbModelServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除配置库
     */
    @RequestMapping(CmdbModelServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新配置库
     */
    @RequestMapping(CmdbModelServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cmdbModelVO") CmdbModelVO cmdbModelVO);

    /**
     * 更新配置库
     */
    @RequestMapping(CmdbModelServiceProxy.SAVE)
    Result save(@RequestParam(name = "cmdbModelVO") CmdbModelVO cmdbModelVO);

    /**
     * 获取配置库
     */
    @RequestMapping(CmdbModelServiceProxy.GET_BY_ID)
    Result<CmdbModel> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个配置库
     */
    @RequestMapping(CmdbModelServiceProxy.GET_BY_IDS)
    Result<List<CmdbModel>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询配置库
     */
    @RequestMapping(CmdbModelServiceProxy.QUERY_LIST)
    Result<List<CmdbModel>> queryList(@RequestParam(name = "sample") CmdbModelVO sample);

    /**
     * 分页查询配置库
     */
    @RequestMapping(CmdbModelServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CmdbModel>> queryPagedList(@RequestParam(name = "sample") CmdbModelVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CmdbModelController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CmdbModelServiceProxy api() {
        return APIProxy.get(CmdbModelServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
