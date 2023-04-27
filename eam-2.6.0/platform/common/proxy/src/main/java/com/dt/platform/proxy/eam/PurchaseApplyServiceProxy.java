package com.dt.platform.proxy.eam;

import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.PurchaseApply;
import com.dt.platform.domain.eam.PurchaseApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 采购申请  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 22:09:37
 */
@FeignClient(value = ServiceNames.EAM, contextId = PurchaseApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PurchaseApplyServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-purchase-apply
     */
    public static final String API_CONTEXT_PATH = "eam-purchase-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加采购申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除采购申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除采购申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新采购申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存采购申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个采购申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个采购申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询采购申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询采购申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出采购申请数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载采购申请导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入采购申请数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";

    /**
     * 验收
     */
    public static final String CHECK = API_PREFIX + "check";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";
    /**
     * 分页查询资产报失
     */
    @RequestMapping(PurchaseApplyServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);



    /**
     * 添加采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "purchaseApplyVO") PurchaseApplyVO purchaseApplyVO);

    /**
     * 删除采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "purchaseApplyVO") PurchaseApplyVO purchaseApplyVO);

    /**
     * 更新采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "purchaseApplyVO") PurchaseApplyVO purchaseApplyVO);

    /**
     * 获取采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.GET_BY_ID)
    Result<PurchaseApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.GET_BY_IDS)
    Result<List<PurchaseApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.QUERY_LIST)
    Result<List<PurchaseApply>> queryList(@RequestParam(name = "sample") PurchaseApplyVO sample);

    /**
     * 分页查询采购申请
     */
    @RequestMapping(PurchaseApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PurchaseApply>> queryPagedList(@RequestParam(name = "sample") PurchaseApplyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.PurchaseApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PurchaseApplyServiceProxy api() {
        return APIProxy.get(PurchaseApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
