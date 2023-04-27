package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InventoryFeedbackMsg;
import com.dt.platform.domain.eam.InventoryFeedbackMsgVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 反馈消息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:57:04
 */
@FeignClient(value = ServiceNames.EAM, contextId = InventoryFeedbackMsgServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InventoryFeedbackMsgServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inventory-feedback-msg
     */
    public static final String API_CONTEXT_PATH = "eam-inventory-feedback-msg";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加反馈消息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除反馈消息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除反馈消息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新反馈消息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存反馈消息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个反馈消息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个反馈消息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询反馈消息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询反馈消息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inventoryFeedbackMsgVO") InventoryFeedbackMsgVO inventoryFeedbackMsgVO);

    /**
     * 删除反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inventoryFeedbackMsgVO") InventoryFeedbackMsgVO inventoryFeedbackMsgVO);

    /**
     * 更新反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.SAVE)
    Result save(@RequestParam(name = "inventoryFeedbackMsgVO") InventoryFeedbackMsgVO inventoryFeedbackMsgVO);

    /**
     * 获取反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.GET_BY_ID)
    Result<InventoryFeedbackMsg> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.GET_BY_IDS)
    Result<List<InventoryFeedbackMsg>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.QUERY_LIST)
    Result<List<InventoryFeedbackMsg>> queryList(@RequestParam(name = "sample") InventoryFeedbackMsgVO sample);

    /**
     * 分页查询反馈消息
     */
    @RequestMapping(InventoryFeedbackMsgServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InventoryFeedbackMsg>> queryPagedList(@RequestParam(name = "sample") InventoryFeedbackMsgVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InventoryFeedbackMsgController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InventoryFeedbackMsgServiceProxy api() {
        return APIProxy.get(InventoryFeedbackMsgServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
