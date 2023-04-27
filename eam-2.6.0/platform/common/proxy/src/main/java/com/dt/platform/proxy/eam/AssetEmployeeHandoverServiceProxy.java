package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetEmployeeHandover;
import com.dt.platform.domain.eam.AssetEmployeeHandoverVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产交接  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 22:09:25
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetEmployeeHandoverServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetEmployeeHandoverServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-employee-handover
     */
    public static final String API_CONTEXT_PATH = "eam-asset-employee-handover";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产交接
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产交接
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产交接
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产交接
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产交接
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产交接
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产交接
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产交接
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产交接
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产交接数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产交接导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产交接数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetEmployeeHandoverVO") AssetEmployeeHandoverVO assetEmployeeHandoverVO);

    /**
     * 删除资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetEmployeeHandoverVO") AssetEmployeeHandoverVO assetEmployeeHandoverVO);

    /**
     * 更新资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetEmployeeHandoverVO") AssetEmployeeHandoverVO assetEmployeeHandoverVO);

    /**
     * 获取资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.GET_BY_ID)
    Result<AssetEmployeeHandover> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.GET_BY_IDS)
    Result<List<AssetEmployeeHandover>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.QUERY_LIST)
    Result<List<AssetEmployeeHandover>> queryList(@RequestParam(name = "sample") AssetEmployeeHandoverVO sample);

    /**
     * 分页查询资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetEmployeeHandover>> queryPagedList(@RequestParam(name = "sample") AssetEmployeeHandoverVO sample);

    /**
     * 分页查询资产交接
     */
    @RequestMapping(AssetEmployeeHandoverServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetEmployeeHandoverController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetEmployeeHandoverServiceProxy api() {
        return APIProxy.get(AssetEmployeeHandoverServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
