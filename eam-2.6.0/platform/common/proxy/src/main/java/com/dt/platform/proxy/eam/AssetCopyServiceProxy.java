package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetCopy;
import com.dt.platform.domain.eam.AssetCopyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产复制 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-26 10:34:21
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetCopyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetCopyServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-copy
     */
    public static final String API_CONTEXT_PATH = "eam-asset-copy";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产复制
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产复制
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产复制
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产复制
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产复制
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产复制
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产复制
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产复制
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产复制
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetCopyVO") AssetCopyVO assetCopyVO);

    /**
     * 删除资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetCopyVO") AssetCopyVO assetCopyVO);

    /**
     * 更新资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetCopyVO") AssetCopyVO assetCopyVO);

    /**
     * 获取资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.GET_BY_ID)
    Result<AssetCopy> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.GET_BY_IDS)
    Result<List<AssetCopy>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.QUERY_LIST)
    Result<List<AssetCopy>> queryList(@RequestParam(name = "sample") AssetCopyVO sample);

    /**
     * 分页查询资产复制
     */
    @RequestMapping(AssetCopyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetCopy>> queryPagedList(@RequestParam(name = "sample") AssetCopyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetCopyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetCopyServiceProxy api() {
        return APIProxy.get(AssetCopyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
