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
import com.dt.platform.domain.workorder.SlbStrategyApply;
import com.dt.platform.domain.workorder.SlbStrategyApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 负载策略申请  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 20:04:21
 */
@FeignClient(value = ServiceNames.WORKORDER, contextId = SlbStrategyApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SlbStrategyApplyServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-workorder
     */
    public static final String API_BASIC_PATH = "service-workorder";

    /**
     * API 上下文路径 , wo-slb-strategy-apply
     */
    public static final String API_CONTEXT_PATH = "wo-slb-strategy-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加负载策略申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除负载策略申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除负载策略申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新负载策略申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存负载策略申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个负载策略申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个负载策略申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询负载策略申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询负载策略申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "slbStrategyApplyVO") SlbStrategyApplyVO slbStrategyApplyVO);

    /**
     * 删除负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "slbStrategyApplyVO") SlbStrategyApplyVO slbStrategyApplyVO);

    /**
     * 更新负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "slbStrategyApplyVO") SlbStrategyApplyVO slbStrategyApplyVO);

    /**
     * 获取负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.GET_BY_ID)
    Result<SlbStrategyApply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.GET_BY_IDS)
    Result<List<SlbStrategyApply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.QUERY_LIST)
    Result<List<SlbStrategyApply>> queryList(@RequestParam(name = "sample") SlbStrategyApplyVO sample);

    /**
     * 分页查询负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SlbStrategyApply>> queryPagedList(@RequestParam(name = "sample") SlbStrategyApplyVO sample);

    /**
     * 分页查询负载策略申请
     */
    @RequestMapping(SlbStrategyApplyServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.workorder.controller.SlbStrategyApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SlbStrategyApplyServiceProxy api() {
        return APIProxy.get(SlbStrategyApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
