package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.CustomerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 客户 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 12:16:10
 */
@FeignClient(value = ServiceNames.WMS, contextId = CustomerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CustomerServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-customer
     */
    public static final String API_CONTEXT_PATH = "wms-customer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加客户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除客户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除客户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新客户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存客户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个客户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个客户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询客户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询客户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加客户
     */
    @RequestMapping(CustomerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "customerVO") CustomerVO customerVO);

    /**
     * 删除客户
     */
    @RequestMapping(CustomerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除客户
     */
    @RequestMapping(CustomerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新客户
     */
    @RequestMapping(CustomerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "customerVO") CustomerVO customerVO);

    /**
     * 更新客户
     */
    @RequestMapping(CustomerServiceProxy.SAVE)
    Result save(@RequestParam(name = "customerVO") CustomerVO customerVO);

    /**
     * 获取客户
     */
    @RequestMapping(CustomerServiceProxy.GET_BY_ID)
    Result<Customer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个客户
     */
    @RequestMapping(CustomerServiceProxy.GET_BY_IDS)
    Result<List<Customer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询客户
     */
    @RequestMapping(CustomerServiceProxy.QUERY_LIST)
    Result<List<Customer>> queryList(@RequestParam(name = "sample") CustomerVO sample);

    /**
     * 分页查询客户
     */
    @RequestMapping(CustomerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Customer>> queryPagedList(@RequestParam(name = "sample") CustomerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.CustomerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CustomerServiceProxy api() {
        return APIProxy.get(CustomerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
