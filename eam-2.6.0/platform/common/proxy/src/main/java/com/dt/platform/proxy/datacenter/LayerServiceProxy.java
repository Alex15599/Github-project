package com.dt.platform.proxy.datacenter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.LayerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 层级  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-22 21:41:05
 */
@FeignClient(value = ServiceNames.DATACENTER, contextId = LayerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface LayerServiceProxy {

    /**
     * 基础路径 , service-datacenter
     */
    public static final String API_BASIC_PATH = "service-datacenter";

    /**
     * API 上下文路径 , dc-layer
     */
    public static final String API_CONTEXT_PATH = "dc-layer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加层级
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除层级
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除层级
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新层级
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存层级
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个层级
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个层级
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询层级
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询层级
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加层级
     */
    @RequestMapping(LayerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "layerVO") LayerVO layerVO);

    /**
     * 删除层级
     */
    @RequestMapping(LayerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除层级
     */
    @RequestMapping(LayerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新层级
     */
    @RequestMapping(LayerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "layerVO") LayerVO layerVO);

    /**
     * 更新层级
     */
    @RequestMapping(LayerServiceProxy.SAVE)
    Result save(@RequestParam(name = "layerVO") LayerVO layerVO);

    /**
     * 获取层级
     */
    @RequestMapping(LayerServiceProxy.GET_BY_ID)
    Result<Layer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个层级
     */
    @RequestMapping(LayerServiceProxy.GET_BY_IDS)
    Result<List<Layer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询层级
     */
    @RequestMapping(LayerServiceProxy.QUERY_LIST)
    Result<List<Layer>> queryList(@RequestParam(name = "sample") LayerVO sample);

    /**
     * 分页查询层级
     */
    @RequestMapping(LayerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Layer>> queryPagedList(@RequestParam(name = "sample") LayerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.datacenter.controller.LayerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static LayerServiceProxy api() {
        return APIProxy.get(LayerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
