package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetRegion;
import com.dt.platform.domain.eam.AssetRegionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 存放区域 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-25 22:19:46
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetRegionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetRegionServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-region
     */
    public static final String API_CONTEXT_PATH = "eam-asset-region";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加存放区域
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除存放区域
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除存放区域
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新存放区域
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存存放区域
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个存放区域
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个存放区域
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询存放区域
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询存放区域
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetRegionVO") AssetRegionVO assetRegionVO);

    /**
     * 删除存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetRegionVO") AssetRegionVO assetRegionVO);

    /**
     * 更新存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetRegionVO") AssetRegionVO assetRegionVO);

    /**
     * 获取存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.GET_BY_ID)
    Result<AssetRegion> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.GET_BY_IDS)
    Result<List<AssetRegion>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.QUERY_LIST)
    Result<List<AssetRegion>> queryList(@RequestParam(name = "sample") AssetRegionVO sample);

    /**
     * 分页查询存放区域
     */
    @RequestMapping(AssetRegionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetRegion>> queryPagedList(@RequestParam(name = "sample") AssetRegionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetRegionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetRegionServiceProxy api() {
        return APIProxy.get(AssetRegionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
