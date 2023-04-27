package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.DeliveryMethod;
import com.dt.platform.domain.wms.DeliveryMethodVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 提货方式 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:28
 */
@FeignClient(value = ServiceNames.WMS, contextId = DeliveryMethodServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DeliveryMethodServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-delivery-method
     */
    public static final String API_CONTEXT_PATH = "wms-delivery-method";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加提货方式
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除提货方式
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除提货方式
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新提货方式
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存提货方式
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个提货方式
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个提货方式
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询提货方式
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询提货方式
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.INSERT)
    Result insert(@RequestParam(name = "deliveryMethodVO") DeliveryMethodVO deliveryMethodVO);

    /**
     * 删除提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.UPDATE)
    Result update(@RequestParam(name = "deliveryMethodVO") DeliveryMethodVO deliveryMethodVO);

    /**
     * 更新提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.SAVE)
    Result save(@RequestParam(name = "deliveryMethodVO") DeliveryMethodVO deliveryMethodVO);

    /**
     * 获取提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.GET_BY_ID)
    Result<DeliveryMethod> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.GET_BY_IDS)
    Result<List<DeliveryMethod>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.QUERY_LIST)
    Result<List<DeliveryMethod>> queryList(@RequestParam(name = "sample") DeliveryMethodVO sample);

    /**
     * 分页查询提货方式
     */
    @RequestMapping(DeliveryMethodServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DeliveryMethod>> queryPagedList(@RequestParam(name = "sample") DeliveryMethodVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.DeliveryMethodController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DeliveryMethodServiceProxy api() {
        return APIProxy.get(DeliveryMethodServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
