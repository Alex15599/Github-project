package com.dt.platform.proxy.customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.customer.RepiarDemo;
import com.dt.platform.domain.customer.RepiarDemoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 报修 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 09:23:38
 */
@FeignClient(value = ServiceNames.CUSTOMER, contextId = RepiarDemoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepiarDemoServiceProxy {

    /**
     * 基础路径 , service-customer
     */
    public static final String API_BASIC_PATH = "service-customer";

    /**
     * API 上下文路径 , cust-repiar-demo
     */
    public static final String API_CONTEXT_PATH = "cust-repiar-demo";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加报修
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除报修
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除报修
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新报修
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存报修
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个报修
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个报修
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询报修
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询报修
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加报修
     */
    @RequestMapping(RepiarDemoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repiarDemoVO") RepiarDemoVO repiarDemoVO);

    /**
     * 删除报修
     */
    @RequestMapping(RepiarDemoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Long id);

    /**
     * 批量删除报修
     */
    @RequestMapping(RepiarDemoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 更新报修
     */
    @RequestMapping(RepiarDemoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repiarDemoVO") RepiarDemoVO repiarDemoVO);

    /**
     * 更新报修
     */
    @RequestMapping(RepiarDemoServiceProxy.SAVE)
    Result save(@RequestParam(name = "repiarDemoVO") RepiarDemoVO repiarDemoVO);

    /**
     * 获取报修
     */
    @RequestMapping(RepiarDemoServiceProxy.GET_BY_ID)
    Result<RepiarDemo> getById(@RequestParam(name = "id") Long id);

    /**
     * 获取多个报修
     */
    @RequestMapping(RepiarDemoServiceProxy.GET_BY_IDS)
    Result<List<RepiarDemo>> getByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 查询报修
     */
    @RequestMapping(RepiarDemoServiceProxy.QUERY_LIST)
    Result<List<RepiarDemo>> queryList(@RequestParam(name = "sample") RepiarDemoVO sample);

    /**
     * 分页查询报修
     */
    @RequestMapping(RepiarDemoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepiarDemo>> queryPagedList(@RequestParam(name = "sample") RepiarDemoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.customer.controller.RepiarDemoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepiarDemoServiceProxy api() {
        return APIProxy.get(RepiarDemoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
