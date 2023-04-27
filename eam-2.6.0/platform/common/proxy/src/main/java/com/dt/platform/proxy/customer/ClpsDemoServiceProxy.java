package com.dt.platform.proxy.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.customer.ClpsDemo;
import com.dt.platform.domain.customer.ClpsDemoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * CLPS测试 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 08:52:09
 */
@FeignClient(value = ServiceNames.CUSTOMER, contextId = ClpsDemoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ClpsDemoServiceProxy {

    /**
     * 基础路径 , service-cust
     */
    public static final String API_BASIC_PATH = "service-cust";

    /**
     * API 上下文路径 , cust-clps-demo
     */
    public static final String API_CONTEXT_PATH = "cust-clps-demo";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加CLPS测试
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除CLPS测试
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除CLPS测试
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新CLPS测试
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存CLPS测试
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个CLPS测试
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个CLPS测试
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询CLPS测试
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询CLPS测试
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "clpsDemoVO") ClpsDemoVO clpsDemoVO);

    /**
     * 删除CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Long id);

    /**
     * 批量删除CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 更新CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "clpsDemoVO") ClpsDemoVO clpsDemoVO);

    /**
     * 更新CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.SAVE)
    Result save(@RequestParam(name = "clpsDemoVO") ClpsDemoVO clpsDemoVO);

    /**
     * 获取CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.GET_BY_ID)
    Result<ClpsDemo> getById(@RequestParam(name = "id") Long id);

    /**
     * 获取多个CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.GET_BY_IDS)
    Result<List<ClpsDemo>> getByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 查询CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.QUERY_LIST)
    Result<List<ClpsDemo>> queryList(@RequestParam(name = "sample") ClpsDemoVO sample);

    /**
     * 分页查询CLPS测试
     */
    @RequestMapping(ClpsDemoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ClpsDemo>> queryPagedList(@RequestParam(name = "sample") ClpsDemoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.customer.controller.ClpsDemoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ClpsDemoServiceProxy api() {
        return APIProxy.get(ClpsDemoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
