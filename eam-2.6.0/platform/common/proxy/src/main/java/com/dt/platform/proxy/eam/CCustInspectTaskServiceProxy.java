package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CCustInspectTask;
import com.dt.platform.domain.eam.CCustInspectTaskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检任务单 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 10:32:46
 */
@FeignClient(value = ServiceNames.EAM, contextId = CCustInspectTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CCustInspectTaskServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-c-cust-inspect-task
     */
    public static final String API_CONTEXT_PATH = "eam-c-cust-inspect-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检任务单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检任务单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检任务单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检任务单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检任务单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检任务单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检任务单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检任务单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检任务单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String INSPECT = API_PREFIX + "inspect";

    public static final String CANCEL = API_PREFIX + "cancel";

    public static final String FINISH = API_PREFIX + "finish";

    public static final String START = API_PREFIX + "start";

    public static final String INSPECT_SCAN = API_PREFIX + "inspect-scan";

    /**
     * 添加巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cCustInspectTaskVO") CCustInspectTaskVO cCustInspectTaskVO);

    /**
     * 删除巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cCustInspectTaskVO") CCustInspectTaskVO cCustInspectTaskVO);

    /**
     * 更新巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "cCustInspectTaskVO") CCustInspectTaskVO cCustInspectTaskVO);

    /**
     * 获取巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.GET_BY_ID)
    Result<CCustInspectTask> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.GET_BY_IDS)
    Result<List<CCustInspectTask>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.QUERY_LIST)
    Result<List<CCustInspectTask>> queryList(@RequestParam(name = "sample") CCustInspectTaskVO sample);

    /**
     * 分页查询巡检任务单
     */
    @RequestMapping(CCustInspectTaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CCustInspectTask>> queryPagedList(@RequestParam(name = "sample") CCustInspectTaskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CCustInspectTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CCustInspectTaskServiceProxy api() {
        return APIProxy.get(CCustInspectTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
