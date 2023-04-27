package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import com.dt.platform.domain.eam.AssetMaintenanceUpdateVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维保更新 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 22:25:07
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetMaintenanceUpdateServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetMaintenanceUpdateServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-maintenance-update
     */
    public static final String API_CONTEXT_PATH = "eam-asset-maintenance-update";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维保更新
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维保更新
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维保更新
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维保更新
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维保更新
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维保更新
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维保更新
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维保更新
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维保更新
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";



    /**
     * 取消
     */
    public static final String CANCEL = API_PREFIX + "cancel";


    /**
     * 插入
     */
    public static final String INSERT_ASSET = API_PREFIX + "insert-asset";


    /**
     * 更新
     */
    public static final String ACTION_UPDATE = API_PREFIX + "action-update";

    /**
     * 更新
     */
    public static final String BATCH_OPER = API_PREFIX + "batch-oper";

    /**
     * 更新
     */
    public static final String FILL_DATA = API_PREFIX + "fill-data";

    /**
     * 添加维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetMaintenanceUpdateVO") AssetMaintenanceUpdateVO assetMaintenanceUpdateVO);

    /**
     * 删除维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetMaintenanceUpdateVO") AssetMaintenanceUpdateVO assetMaintenanceUpdateVO);

    /**
     * 更新维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetMaintenanceUpdateVO") AssetMaintenanceUpdateVO assetMaintenanceUpdateVO);

    /**
     * 获取维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.GET_BY_ID)
    Result<AssetMaintenanceUpdate> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.GET_BY_IDS)
    Result<List<AssetMaintenanceUpdate>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.QUERY_LIST)
    Result<List<AssetMaintenanceUpdate>> queryList(@RequestParam(name = "sample") AssetMaintenanceUpdateVO sample);

    /**
     * 分页查询维保更新
     */
    @RequestMapping(AssetMaintenanceUpdateServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetMaintenanceUpdate>> queryPagedList(@RequestParam(name = "sample") AssetMaintenanceUpdateVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetMaintenanceUpdateController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetMaintenanceUpdateServiceProxy api() {
        return APIProxy.get(AssetMaintenanceUpdateServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
