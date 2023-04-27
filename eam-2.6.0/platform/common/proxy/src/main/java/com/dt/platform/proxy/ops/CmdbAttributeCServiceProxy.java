package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CmdbAttributeC;
import com.dt.platform.domain.ops.CmdbAttributeCVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 属性字段 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 22:46:00
 */
@FeignClient(value = ServiceNames.OPS, contextId = CmdbAttributeCServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CmdbAttributeCServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-cmdb-attribute-c
     */
    public static final String API_CONTEXT_PATH = "ops-cmdb-attribute-c";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加属性字段
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除属性字段
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除属性字段
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新属性字段
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存属性字段
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个属性字段
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个属性字段
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询属性字段
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询属性字段
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cmdbAttributeCVO") CmdbAttributeCVO cmdbAttributeCVO);

    /**
     * 删除属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cmdbAttributeCVO") CmdbAttributeCVO cmdbAttributeCVO);

    /**
     * 更新属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.SAVE)
    Result save(@RequestParam(name = "cmdbAttributeCVO") CmdbAttributeCVO cmdbAttributeCVO);

    /**
     * 获取属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.GET_BY_ID)
    Result<CmdbAttributeC> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.GET_BY_IDS)
    Result<List<CmdbAttributeC>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.QUERY_LIST)
    Result<List<CmdbAttributeC>> queryList(@RequestParam(name = "sample") CmdbAttributeCVO sample);

    /**
     * 分页查询属性字段
     */
    @RequestMapping(CmdbAttributeCServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CmdbAttributeC>> queryPagedList(@RequestParam(name = "sample") CmdbAttributeCVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CmdbAttributeCController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CmdbAttributeCServiceProxy api() {
        return APIProxy.get(CmdbAttributeCServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
