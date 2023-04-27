package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.ProductCategory;
import com.dt.platform.domain.wms.ProductCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 商品分类 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 08:50:26
 */
@FeignClient(value = ServiceNames.WMS, contextId = ProductCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProductCategoryServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-product-category
     */
    public static final String API_CONTEXT_PATH = "wms-product-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商品分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商品分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商品分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商品分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商品分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商品分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商品分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商品分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商品分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "productCategoryVO") ProductCategoryVO productCategoryVO);

    /**
     * 删除商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "productCategoryVO") ProductCategoryVO productCategoryVO);

    /**
     * 更新商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "productCategoryVO") ProductCategoryVO productCategoryVO);

    /**
     * 获取商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.GET_BY_ID)
    Result<ProductCategory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.GET_BY_IDS)
    Result<List<ProductCategory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.QUERY_LIST)
    Result<List<ProductCategory>> queryList(@RequestParam(name = "sample") ProductCategoryVO sample);

    /**
     * 分页查询商品分类
     */
    @RequestMapping(ProductCategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProductCategory>> queryPagedList(@RequestParam(name = "sample") ProductCategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.ProductCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProductCategoryServiceProxy api() {
        return APIProxy.get(ProductCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
