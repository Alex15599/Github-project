package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetCollection;
import com.dt.platform.domain.eam.AssetCollectionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
/**
 * <p>
 * 资产领用  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 17:00:01
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetCollectionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetCollectionServiceProxy
        extends BpmCallbackController{

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-collection
     */
    public static final String API_CONTEXT_PATH = "eam-asset-collection";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产领用
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产领用
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产领用
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产领用
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产领用
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产领用
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产领用
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产领用
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产领用
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产领用数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产领用导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产领用数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

   
    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";


    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";
    /**
     * 分页查询资产报失
     */
    @RequestMapping(AssetRepairServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 添加资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetCollectionVO") AssetCollectionVO assetCollectionVO);

    /**
     * 删除资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetCollectionVO") AssetCollectionVO assetCollectionVO);

    /**
     * 更新资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetCollectionVO") AssetCollectionVO assetCollectionVO);

    /**
     * 获取资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.GET_BY_ID)
    Result<AssetCollection> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.GET_BY_IDS)
    Result<List<AssetCollection>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.QUERY_LIST)
    Result<List<AssetCollection>> queryList(@RequestParam(name = "sample") AssetCollectionVO sample);

    /**
     * 分页查询资产领用
     */
    @RequestMapping(AssetCollectionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetCollection>> queryPagedList(@RequestParam(name = "sample") AssetCollectionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetCollectionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetCollectionServiceProxy api() {
        return APIProxy.get(AssetCollectionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
