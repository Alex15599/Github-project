package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.Brand;
import com.dt.platform.domain.eam.BrandVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 品牌  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 07:12:17
 */
@FeignClient(value = ServiceNames.EAM, contextId = BrandServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BrandServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-brand
     */
    public static final String API_CONTEXT_PATH = "eam-brand";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加品牌
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除品牌
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除品牌
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新品牌
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存品牌
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个品牌
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个品牌
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询品牌
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询品牌
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加品牌
     */
    @RequestMapping(BrandServiceProxy.INSERT)
    Result insert(@RequestParam(name = "brandVO") BrandVO brandVO);

    /**
     * 删除品牌
     */
    @RequestMapping(BrandServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除品牌
     */
    @RequestMapping(BrandServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新品牌
     */
    @RequestMapping(BrandServiceProxy.UPDATE)
    Result update(@RequestParam(name = "brandVO") BrandVO brandVO);

    /**
     * 更新品牌
     */
    @RequestMapping(BrandServiceProxy.SAVE)
    Result save(@RequestParam(name = "brandVO") BrandVO brandVO);

    /**
     * 获取品牌
     */
    @RequestMapping(BrandServiceProxy.GET_BY_ID)
    Result<Brand> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个品牌
     */
    @RequestMapping(BrandServiceProxy.GET_BY_IDS)
    Result<List<Brand>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询品牌
     */
    @RequestMapping(BrandServiceProxy.QUERY_LIST)
    Result<List<Brand>> queryList(@RequestParam(name = "sample") BrandVO sample);

    /**
     * 分页查询品牌
     */
    @RequestMapping(BrandServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Brand>> queryPagedList(@RequestParam(name = "sample") BrandVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.BrandController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BrandServiceProxy api() {
        return APIProxy.get(BrandServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
