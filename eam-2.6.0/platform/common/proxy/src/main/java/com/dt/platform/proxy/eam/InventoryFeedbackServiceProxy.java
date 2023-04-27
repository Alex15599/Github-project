package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InventoryFeedback;
import com.dt.platform.domain.eam.InventoryFeedbackVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 盘点反馈 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 07:00:15
 */
@FeignClient(value = ServiceNames.EAM, contextId = InventoryFeedbackServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InventoryFeedbackServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inventory-feedback
     */
    public static final String API_CONTEXT_PATH = "eam-inventory-feedback";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加盘点反馈
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除盘点反馈
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除盘点反馈
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新盘点反馈
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存盘点反馈
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个盘点反馈
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个盘点反馈
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询盘点反馈
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询盘点反馈
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inventoryFeedbackVO") InventoryFeedbackVO inventoryFeedbackVO);

    /**
     * 删除盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inventoryFeedbackVO") InventoryFeedbackVO inventoryFeedbackVO);

    /**
     * 更新盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.SAVE)
    Result save(@RequestParam(name = "inventoryFeedbackVO") InventoryFeedbackVO inventoryFeedbackVO);

    /**
     * 获取盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.GET_BY_ID)
    Result<InventoryFeedback> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.GET_BY_IDS)
    Result<List<InventoryFeedback>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.QUERY_LIST)
    Result<List<InventoryFeedback>> queryList(@RequestParam(name = "sample") InventoryFeedbackVO sample);

    /**
     * 分页查询盘点反馈
     */
    @RequestMapping(InventoryFeedbackServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InventoryFeedback>> queryPagedList(@RequestParam(name = "sample") InventoryFeedbackVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InventoryFeedbackController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InventoryFeedbackServiceProxy api() {
        return APIProxy.get(InventoryFeedbackServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
