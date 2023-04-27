package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDataPermissionsOOrg;
import com.dt.platform.domain.eam.AssetDataPermissionsOOrgVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 所属  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-17 06:31:21
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataPermissionsOOrgServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDataPermissionsOOrgServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-data-permissions-o-org
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data-permissions-o-org";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加所属
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除所属
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除所属
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新所属
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存所属
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个所属
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个所属
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询所属
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询所属
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDataPermissionsOOrgVO") AssetDataPermissionsOOrgVO assetDataPermissionsOOrgVO);

    /**
     * 删除所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDataPermissionsOOrgVO") AssetDataPermissionsOOrgVO assetDataPermissionsOOrgVO);

    /**
     * 更新所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDataPermissionsOOrgVO") AssetDataPermissionsOOrgVO assetDataPermissionsOOrgVO);

    /**
     * 获取所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.GET_BY_ID)
    Result<AssetDataPermissionsOOrg> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.GET_BY_IDS)
    Result<List<AssetDataPermissionsOOrg>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.QUERY_LIST)
    Result<List<AssetDataPermissionsOOrg>> queryList(@RequestParam(name = "sample") AssetDataPermissionsOOrgVO sample);

    /**
     * 分页查询所属
     */
    @RequestMapping(AssetDataPermissionsOOrgServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDataPermissionsOOrg>> queryPagedList(@RequestParam(name = "sample") AssetDataPermissionsOOrgVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDataPermissionsOOrgController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDataPermissionsOOrgServiceProxy api() {
        return APIProxy.get(AssetDataPermissionsOOrgServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
