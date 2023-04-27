package com.dt.platform.proxy.workorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.workorder.NetworkStrategyApply;
import com.dt.platform.domain.workorder.NetworkStrategyApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 网络策略申请  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 20:03:47
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = NetworkStrategyApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NetworkStrategyApplyServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-network-strategy-apply
     */
    public static final String API_CONTEXT_PATH = "wo-network-strategy-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加网络策略申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除网络策略申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除网络策略申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新网络策略申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存网络策略申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个网络策略申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个网络策略申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询网络策略申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询网络策略申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "networkStrategyApplyVO") NetworkStrategyApplyVO networkStrategyApplyVO);

    /**
     * 删除网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "networkStrategyApplyVO") NetworkStrategyApplyVO networkStrategyApplyVO);

    /**
     * 更新网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "networkStrategyApplyVO") NetworkStrategyApplyVO networkStrategyApplyVO);

    /**
     * 获取网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.GET_BY_ID)
    Result<NetworkStrategyApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.GET_BY_IDS)
    Result<List<NetworkStrategyApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.QUERY_LIST)
    Result<List<NetworkStrategyApply>> queryList(@RequestParam(name = "sample") NetworkStrategyApplyVO sample);

    /**
     * 分页查询网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<NetworkStrategyApply>> queryPagedList(@RequestParam(name = "sample") NetworkStrategyApplyVO sample);

    /**
     * 分页查询网络策略申请
     */
    @RequestMapping(NetworkStrategyApplyServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.NetworkStrategyApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NetworkStrategyApplyServiceProxy api() {
        return APIProxy.get(NetworkStrategyApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
