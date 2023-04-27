package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModelVVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 配置值 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:33:56
 */
@FeignClient(value = ServiceNames.OPS, contextId = CmdbModelVServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CmdbModelVServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-cmdb-model-v
     */
    public static final String API_CONTEXT_PATH = "ops-cmdb-model-v";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加配置值
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除配置值
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除配置值
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新配置值
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存配置值
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个配置值
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个配置值
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询配置值
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询配置值
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cmdbModelVVO") CmdbModelVVO cmdbModelVVO);

    /**
     * 删除配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cmdbModelVVO") CmdbModelVVO cmdbModelVVO);

    /**
     * 更新配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.SAVE)
    Result save(@RequestParam(name = "cmdbModelVVO") CmdbModelVVO cmdbModelVVO);

    /**
     * 获取配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.GET_BY_ID)
    Result<CmdbModelV> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.GET_BY_IDS)
    Result<List<CmdbModelV>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.QUERY_LIST)
    Result<List<CmdbModelV>> queryList(@RequestParam(name = "sample") CmdbModelVVO sample);

    /**
     * 分页查询配置值
     */
    @RequestMapping(CmdbModelVServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CmdbModelV>> queryPagedList(@RequestParam(name = "sample") CmdbModelVVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CmdbModelVController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CmdbModelVServiceProxy api() {
        return APIProxy.get(CmdbModelVServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
