package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CCustInspectPlan;
import com.dt.platform.domain.eam.CCustInspectPlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检计划 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-07 10:57:13
 */
@FeignClient(value = ServiceNames.EAM, contextId = CCustInspectPlanServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CCustInspectPlanServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-c-cust-inspect-plan
     */
    public static final String API_CONTEXT_PATH = "eam-c-cust-inspect-plan";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检计划
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检计划
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检计划
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检计划
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检计划
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检计划
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检计划
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检计划
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检计划
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询巡检计划
     */
    public static final String EXECUTE = API_PREFIX + "execute";

    /**
     * 分页查询巡检计划
     */
    public static final String CREATE_TASK = API_PREFIX + "create-task";

    /**
     * 执行计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.EXECUTE)
    Result execute();

    /**
     * 添加巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cCustInspectPlanVO") CCustInspectPlanVO cCustInspectPlanVO);

    /**
     * 删除巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cCustInspectPlanVO") CCustInspectPlanVO cCustInspectPlanVO);

    /**
     * 更新巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.SAVE)
    Result save(@RequestParam(name = "cCustInspectPlanVO") CCustInspectPlanVO cCustInspectPlanVO);

    /**
     * 获取巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.GET_BY_ID)
    Result<CCustInspectPlan> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.GET_BY_IDS)
    Result<List<CCustInspectPlan>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.QUERY_LIST)
    Result<List<CCustInspectPlan>> queryList(@RequestParam(name = "sample") CCustInspectPlanVO sample);

    /**
     * 分页查询巡检计划
     */
    @RequestMapping(CCustInspectPlanServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CCustInspectPlan>> queryPagedList(@RequestParam(name = "sample") CCustInspectPlanVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CCustInspectPlanController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CCustInspectPlanServiceProxy api() {
        return APIProxy.get(CCustInspectPlanServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
