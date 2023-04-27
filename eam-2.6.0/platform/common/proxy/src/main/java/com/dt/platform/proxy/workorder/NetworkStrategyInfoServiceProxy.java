package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.NetworkStrategyInfo;
import com.dt.platform.domain.workorder.NetworkStrategyInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 网络策略  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-06 06:16:46
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = NetworkStrategyInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetworkStrategyInfoServiceProxy {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-network-strategy-info
     */
    public static final String API_CONTEXT_PATH = "wo-network-strategy-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加网络策略
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除网络策略
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除网络策略
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新网络策略
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存网络策略
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个网络策略
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个网络策略
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询网络策略
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询网络策略
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "networkStrategyInfoVO") NetworkStrategyInfoVO networkStrategyInfoVO);

    /**
     * 删除网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "networkStrategyInfoVO") NetworkStrategyInfoVO networkStrategyInfoVO);

    /**
     * 更新网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "networkStrategyInfoVO") NetworkStrategyInfoVO networkStrategyInfoVO);

    /**
     * 获取网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.GET_BY_ID)
    Result<NetworkStrategyInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.GET_BY_IDS)
    Result<List<NetworkStrategyInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.QUERY_LIST)
    Result<List<NetworkStrategyInfo>> queryList(@RequestParam(name = "sample") NetworkStrategyInfoVO sample);

    /**
     * 分页查询网络策略
     */
    @RequestMapping(NetworkStrategyInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetworkStrategyInfo>> queryPagedList(@RequestParam(name = "sample") NetworkStrategyInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.NetworkStrategyInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetworkStrategyInfoServiceProxy api() {
        return APIProxy.get(NetworkStrategyInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
