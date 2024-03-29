package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.VacationData;
import com.dt.platform.domain.hr.VacationDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 人员休假 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-02 14:35:28
 */
@FeignClient(value = ServiceNames.HR, contextId = VacationDataServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VacationDataServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-vacation-data
     */
    public static final String API_CONTEXT_PATH = "hr-vacation-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加人员休假
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除人员休假
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除人员休假
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新人员休假
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存人员休假
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个人员休假
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个人员休假
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询人员休假
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询人员休假
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加人员休假
     */
    @RequestMapping(VacationDataServiceProxy.INSERT)
    Result insert(@RequestParam(name = "vacationDataVO") VacationDataVO vacationDataVO);

    /**
     * 删除人员休假
     */
    @RequestMapping(VacationDataServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除人员休假
     */
    @RequestMapping(VacationDataServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新人员休假
     */
    @RequestMapping(VacationDataServiceProxy.UPDATE)
    Result update(@RequestParam(name = "vacationDataVO") VacationDataVO vacationDataVO);

    /**
     * 更新人员休假
     */
    @RequestMapping(VacationDataServiceProxy.SAVE)
    Result save(@RequestParam(name = "vacationDataVO") VacationDataVO vacationDataVO);

    /**
     * 获取人员休假
     */
    @RequestMapping(VacationDataServiceProxy.GET_BY_ID)
    Result<VacationData> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个人员休假
     */
    @RequestMapping(VacationDataServiceProxy.GET_BY_IDS)
    Result<List<VacationData>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询人员休假
     */
    @RequestMapping(VacationDataServiceProxy.QUERY_LIST)
    Result<List<VacationData>> queryList(@RequestParam(name = "sample") VacationDataVO sample);

    /**
     * 分页查询人员休假
     */
    @RequestMapping(VacationDataServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VacationData>> queryPagedList(@RequestParam(name = "sample") VacationDataVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.VacationDataController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VacationDataServiceProxy api() {
        return APIProxy.get(VacationDataServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
