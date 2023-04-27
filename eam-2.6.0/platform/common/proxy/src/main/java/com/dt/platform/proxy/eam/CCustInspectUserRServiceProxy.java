package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CCustInspectUserR;
import com.dt.platform.domain.eam.CCustInspectUserRVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检人员 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 08:37:48
 */
@FeignClient(value = ServiceNames.EAM, contextId = CCustInspectUserRServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CCustInspectUserRServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-c-cust-inspect-user-r
     */
    public static final String API_CONTEXT_PATH = "eam-c-cust-inspect-user-r";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检人员
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检人员
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检人员
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检人员
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检人员
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检人员
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检人员
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检人员
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检人员
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cCustInspectUserRVO") CCustInspectUserRVO cCustInspectUserRVO);

    /**
     * 删除巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cCustInspectUserRVO") CCustInspectUserRVO cCustInspectUserRVO);

    /**
     * 更新巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.SAVE)
    Result save(@RequestParam(name = "cCustInspectUserRVO") CCustInspectUserRVO cCustInspectUserRVO);

    /**
     * 获取巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.GET_BY_ID)
    Result<CCustInspectUserR> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.GET_BY_IDS)
    Result<List<CCustInspectUserR>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.QUERY_LIST)
    Result<List<CCustInspectUserR>> queryList(@RequestParam(name = "sample") CCustInspectUserRVO sample);

    /**
     * 分页查询巡检人员
     */
    @RequestMapping(CCustInspectUserRServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CCustInspectUserR>> queryPagedList(@RequestParam(name = "sample") CCustInspectUserRVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CCustInspectUserRController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CCustInspectUserRServiceProxy api() {
        return APIProxy.get(CCustInspectUserRServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
