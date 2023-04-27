package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetEmployeeApply;
import com.dt.platform.domain.eam.AssetEmployeeApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 领用申请  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 22:09:46
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetEmployeeApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetEmployeeApplyServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-employee-apply
     */
    public static final String API_CONTEXT_PATH = "eam-asset-employee-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加领用申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除领用申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除领用申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新领用申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存领用申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个领用申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个领用申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询领用申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询领用申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出领用申请数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载领用申请导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入领用申请数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetEmployeeApplyVO") AssetEmployeeApplyVO assetEmployeeApplyVO);

    /**
     * 删除领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetEmployeeApplyVO") AssetEmployeeApplyVO assetEmployeeApplyVO);

    /**
     * 更新领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetEmployeeApplyVO") AssetEmployeeApplyVO assetEmployeeApplyVO);

    /**
     * 获取领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.GET_BY_ID)
    Result<AssetEmployeeApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.GET_BY_IDS)
    Result<List<AssetEmployeeApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.QUERY_LIST)
    Result<List<AssetEmployeeApply>> queryList(@RequestParam(name = "sample") AssetEmployeeApplyVO sample);

    /**
     * 分页查询领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetEmployeeApply>> queryPagedList(@RequestParam(name = "sample") AssetEmployeeApplyVO sample);

    /**
     * 分页查询领用申请
     */
    @RequestMapping(AssetEmployeeApplyServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetEmployeeApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetEmployeeApplyServiceProxy api() {
        return APIProxy.get(AssetEmployeeApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
