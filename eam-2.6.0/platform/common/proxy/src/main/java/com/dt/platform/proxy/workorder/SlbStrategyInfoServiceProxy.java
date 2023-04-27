package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.SlbStrategyInfo;
import com.dt.platform.domain.workorder.SlbStrategyInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 负载策略  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-27 20:38:50
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = SlbStrategyInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SlbStrategyInfoServiceProxy {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-slb-strategy-info
     */
    public static final String API_CONTEXT_PATH = "wo-slb-strategy-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加负载策略
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除负载策略
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除负载策略
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新负载策略
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存负载策略
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个负载策略
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个负载策略
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询负载策略
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询负载策略
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "slbStrategyInfoVO") SlbStrategyInfoVO slbStrategyInfoVO);

    /**
     * 删除负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "slbStrategyInfoVO") SlbStrategyInfoVO slbStrategyInfoVO);

    /**
     * 更新负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "slbStrategyInfoVO") SlbStrategyInfoVO slbStrategyInfoVO);

    /**
     * 获取负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.GET_BY_ID)
    Result<SlbStrategyInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.GET_BY_IDS)
    Result<List<SlbStrategyInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.QUERY_LIST)
    Result<List<SlbStrategyInfo>> queryList(@RequestParam(name = "sample") SlbStrategyInfoVO sample);

    /**
     * 分页查询负载策略
     */
    @RequestMapping(SlbStrategyInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SlbStrategyInfo>> queryPagedList(@RequestParam(name = "sample") SlbStrategyInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.SlbStrategyInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SlbStrategyInfoServiceProxy api() {
        return APIProxy.get(SlbStrategyInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
