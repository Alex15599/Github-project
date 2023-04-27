package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.dt.platform.domain.eam.AssetCollectionReturnVO;
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
 * 资产退库  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 17:01:53
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetCollectionReturnServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetCollectionReturnServiceProxy extends BpmCallbackController{

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-collection-return
     */
    public static final String API_CONTEXT_PATH = "eam-asset-collection-return";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产退库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产退库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产退库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产退库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产退库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产退库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产退库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产退库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产退库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产退库数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产退库导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产退库数据(Excel)
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
     * 添加资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetCollectionReturnVO") AssetCollectionReturnVO assetCollectionReturnVO);

    /**
     * 删除资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetCollectionReturnVO") AssetCollectionReturnVO assetCollectionReturnVO);

    /**
     * 更新资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetCollectionReturnVO") AssetCollectionReturnVO assetCollectionReturnVO);

    /**
     * 获取资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.GET_BY_ID)
    Result<AssetCollectionReturn> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.GET_BY_IDS)
    Result<List<AssetCollectionReturn>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.QUERY_LIST)
    Result<List<AssetCollectionReturn>> queryList(@RequestParam(name = "sample") AssetCollectionReturnVO sample);

    /**
     * 分页查询资产退库
     */
    @RequestMapping(AssetCollectionReturnServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetCollectionReturn>> queryPagedList(@RequestParam(name = "sample") AssetCollectionReturnVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetCollectionReturnController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetCollectionReturnServiceProxy api() {
        return APIProxy.get(AssetCollectionReturnServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
