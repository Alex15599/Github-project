package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetMaintenanceRecordU;
import com.dt.platform.domain.eam.AssetMaintenanceRecordUVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维保更新记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 15:12:32
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetMaintenanceRecordUServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetMaintenanceRecordUServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-maintenance-record-u
     */
    public static final String API_CONTEXT_PATH = "eam-asset-maintenance-record-u";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维保更新记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维保更新记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维保更新记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维保更新记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维保更新记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维保更新记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维保更新记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维保更新记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维保更新记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetMaintenanceRecordUVO") AssetMaintenanceRecordUVO assetMaintenanceRecordUVO);

    /**
     * 删除维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetMaintenanceRecordUVO") AssetMaintenanceRecordUVO assetMaintenanceRecordUVO);

    /**
     * 更新维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetMaintenanceRecordUVO") AssetMaintenanceRecordUVO assetMaintenanceRecordUVO);

    /**
     * 获取维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.GET_BY_ID)
    Result<AssetMaintenanceRecordU> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.GET_BY_IDS)
    Result<List<AssetMaintenanceRecordU>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.QUERY_LIST)
    Result<List<AssetMaintenanceRecordU>> queryList(@RequestParam(name = "sample") AssetMaintenanceRecordUVO sample);

    /**
     * 分页查询维保更新记录
     */
    @RequestMapping(AssetMaintenanceRecordUServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetMaintenanceRecordU>> queryPagedList(@RequestParam(name = "sample") AssetMaintenanceRecordUVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetMaintenanceRecordUController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetMaintenanceRecordUServiceProxy api() {
        return APIProxy.get(AssetMaintenanceRecordUServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
