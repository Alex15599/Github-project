package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.ProductAttrVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 产品属性 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:56
 */
@FeignClient(value = ServiceNames.WMS, contextId = ProductAttrServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProductAttrServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-product-attr
     */
    public static final String API_CONTEXT_PATH = "wms-product-attr";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加产品属性
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除产品属性
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除产品属性
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新产品属性
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存产品属性
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个产品属性
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个产品属性
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询产品属性
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询产品属性
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.INSERT)
    Result insert(@RequestParam(name = "productAttrVO") ProductAttrVO productAttrVO);

    /**
     * 删除产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.UPDATE)
    Result update(@RequestParam(name = "productAttrVO") ProductAttrVO productAttrVO);

    /**
     * 更新产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.SAVE)
    Result save(@RequestParam(name = "productAttrVO") ProductAttrVO productAttrVO);

    /**
     * 获取产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.GET_BY_ID)
    Result<ProductAttr> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.GET_BY_IDS)
    Result<List<ProductAttr>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.QUERY_LIST)
    Result<List<ProductAttr>> queryList(@RequestParam(name = "sample") ProductAttrVO sample);

    /**
     * 分页查询产品属性
     */
    @RequestMapping(ProductAttrServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProductAttr>> queryPagedList(@RequestParam(name = "sample") ProductAttrVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.ProductAttrController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProductAttrServiceProxy api() {
        return APIProxy.get(ProductAttrServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
