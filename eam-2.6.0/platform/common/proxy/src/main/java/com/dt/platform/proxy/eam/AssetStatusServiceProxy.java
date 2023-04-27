package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetStatus;
import com.dt.platform.domain.eam.AssetStatusVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产状态  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-06 09:44:10
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetStatusServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetStatusServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-status
     */
    public static final String API_CONTEXT_PATH = "eam-asset-status";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产状态
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产状态
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产状态
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产状态
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产状态
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产状态
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产状态
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产状态
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产状态
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetStatusVO") AssetStatusVO assetStatusVO);

    /**
     * 删除资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetStatusVO") AssetStatusVO assetStatusVO);

    /**
     * 更新资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetStatusVO") AssetStatusVO assetStatusVO);

    /**
     * 获取资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.GET_BY_ID)
    Result<AssetStatus> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.GET_BY_IDS)
    Result<List<AssetStatus>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.QUERY_LIST)
    Result<List<AssetStatus>> queryList(@RequestParam(name = "sample") AssetStatusVO sample);

    /**
     * 分页查询资产状态
     */
    @RequestMapping(AssetStatusServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetStatus>> queryPagedList(@RequestParam(name = "sample") AssetStatusVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetStatusController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetStatusServiceProxy api() {
        return APIProxy.get(AssetStatusServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
