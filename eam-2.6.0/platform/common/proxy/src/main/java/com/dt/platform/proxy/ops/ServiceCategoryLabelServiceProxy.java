package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.ServiceCategoryLabel;
import com.dt.platform.domain.ops.ServiceCategoryLabelVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 分类标签  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-10 08:40:52
 */
@FeignClient(value = ServiceNames.OPS, contextId = ServiceCategoryLabelServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ServiceCategoryLabelServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-service-category-label
     */
    public static final String API_CONTEXT_PATH = "ops-service-category-label";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加分类标签
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除分类标签
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除分类标签
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新分类标签
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存分类标签
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个分类标签
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个分类标签
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询分类标签
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询分类标签
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.INSERT)
    Result insert(@RequestParam(name = "serviceCategoryLabelVO") ServiceCategoryLabelVO serviceCategoryLabelVO);

    /**
     * 删除分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.UPDATE)
    Result update(@RequestParam(name = "serviceCategoryLabelVO") ServiceCategoryLabelVO serviceCategoryLabelVO);

    /**
     * 更新分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.SAVE)
    Result save(@RequestParam(name = "serviceCategoryLabelVO") ServiceCategoryLabelVO serviceCategoryLabelVO);

    /**
     * 获取分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.GET_BY_ID)
    Result<ServiceCategoryLabel> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.GET_BY_IDS)
    Result<List<ServiceCategoryLabel>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.QUERY_LIST)
    Result<List<ServiceCategoryLabel>> queryList(@RequestParam(name = "sample") ServiceCategoryLabelVO sample);

    /**
     * 分页查询分类标签
     */
    @RequestMapping(ServiceCategoryLabelServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ServiceCategoryLabel>> queryPagedList(@RequestParam(name = "sample") ServiceCategoryLabelVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.ServiceCategoryLabelController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ServiceCategoryLabelServiceProxy api() {
        return APIProxy.get(ServiceCategoryLabelServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
