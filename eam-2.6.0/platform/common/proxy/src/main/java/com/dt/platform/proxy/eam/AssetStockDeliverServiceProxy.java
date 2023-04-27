package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetStockDeliver;
import com.dt.platform.domain.eam.AssetStockDeliverVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 库存出库  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 19:24:29
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetStockDeliverServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetStockDeliverServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-stock-deliver
     */
    public static final String API_CONTEXT_PATH = "eam-asset-stock-deliver";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加库存出库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除库存出库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除库存出库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新库存出库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存库存出库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个库存出库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个库存出库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询库存出库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询库存出库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出库存出库数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载库存出库导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入库存出库数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";


    /**
     * 添加库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetStockDeliverVO") AssetStockDeliverVO assetStockDeliverVO);

    /**
     * 删除库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetStockDeliverVO") AssetStockDeliverVO assetStockDeliverVO);

    /**
     * 更新库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetStockDeliverVO") AssetStockDeliverVO assetStockDeliverVO);

    /**
     * 获取库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.GET_BY_ID)
    Result<AssetStockDeliver> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.GET_BY_IDS)
    Result<List<AssetStockDeliver>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.QUERY_LIST)
    Result<List<AssetStockDeliver>> queryList(@RequestParam(name = "sample") AssetStockDeliverVO sample);

    /**
     * 分页查询库存出库
     */
    @RequestMapping(AssetStockDeliverServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetStockDeliver>> queryPagedList(@RequestParam(name = "sample") AssetStockDeliverVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetStockDeliverController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetStockDeliverServiceProxy api() {
        return APIProxy.get(AssetStockDeliverServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
