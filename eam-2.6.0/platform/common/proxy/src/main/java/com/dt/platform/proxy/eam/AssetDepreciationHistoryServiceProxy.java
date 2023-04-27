package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDepreciationHistory;
import com.dt.platform.domain.eam.AssetDepreciationHistoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 折旧历史  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 17:13:19
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDepreciationHistoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDepreciationHistoryServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-depreciation-history
     */
    public static final String API_CONTEXT_PATH = "eam-asset-depreciation-history";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加折旧历史
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除折旧历史
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除折旧历史
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新折旧历史
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存折旧历史
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个折旧历史
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个折旧历史
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询折旧历史
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询折旧历史
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDepreciationHistoryVO") AssetDepreciationHistoryVO assetDepreciationHistoryVO);

    /**
     * 删除折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDepreciationHistoryVO") AssetDepreciationHistoryVO assetDepreciationHistoryVO);

    /**
     * 更新折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDepreciationHistoryVO") AssetDepreciationHistoryVO assetDepreciationHistoryVO);

    /**
     * 获取折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.GET_BY_ID)
    Result<AssetDepreciationHistory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.GET_BY_IDS)
    Result<List<AssetDepreciationHistory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.QUERY_LIST)
    Result<List<AssetDepreciationHistory>> queryList(@RequestParam(name = "sample") AssetDepreciationHistoryVO sample);

    /**
     * 分页查询折旧历史
     */
    @RequestMapping(AssetDepreciationHistoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDepreciationHistory>> queryPagedList(@RequestParam(name = "sample") AssetDepreciationHistoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDepreciationHistoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDepreciationHistoryServiceProxy api() {
        return APIProxy.get(AssetDepreciationHistoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
