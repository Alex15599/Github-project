package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.PurchaseOrder;
import com.dt.platform.domain.eam.PurchaseOrderVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 采购订单  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 06:42:56
 */
@FeignClient(value = ServiceNames.EAM, contextId = PurchaseOrderServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PurchaseOrderServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-purchase-order
     */
    public static final String API_CONTEXT_PATH = "eam-purchase-order";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加采购订单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除采购订单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除采购订单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新采购订单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存采购订单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个采购订单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个采购订单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询采购订单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询采购订单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.INSERT)
    Result insert(@RequestParam(name = "purchaseOrderVO") PurchaseOrderVO purchaseOrderVO);

    /**
     * 删除采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.UPDATE)
    Result update(@RequestParam(name = "purchaseOrderVO") PurchaseOrderVO purchaseOrderVO);

    /**
     * 更新采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.SAVE)
    Result save(@RequestParam(name = "purchaseOrderVO") PurchaseOrderVO purchaseOrderVO);

    /**
     * 获取采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.GET_BY_ID)
    Result<PurchaseOrder> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.GET_BY_IDS)
    Result<List<PurchaseOrder>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.QUERY_LIST)
    Result<List<PurchaseOrder>> queryList(@RequestParam(name = "sample") PurchaseOrderVO sample);

    /**
     * 分页查询采购订单
     */
    @RequestMapping(PurchaseOrderServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PurchaseOrder>> queryPagedList(@RequestParam(name = "sample") PurchaseOrderVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.PurchaseOrderController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PurchaseOrderServiceProxy api() {
        return APIProxy.get(PurchaseOrderServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
