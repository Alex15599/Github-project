package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.PersonnelDivision;
import com.dt.platform.domain.ops.PersonnelDivisionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 人员分工 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-04 15:22:09
 */
@FeignClient(value = ServiceNames.OPS, contextId = PersonnelDivisionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonnelDivisionServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-personnel-division
     */
    public static final String API_CONTEXT_PATH = "ops-personnel-division";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加人员分工
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除人员分工
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除人员分工
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新人员分工
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存人员分工
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个人员分工
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个人员分工
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询人员分工
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询人员分工
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personnelDivisionVO") PersonnelDivisionVO personnelDivisionVO);

    /**
     * 删除人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personnelDivisionVO") PersonnelDivisionVO personnelDivisionVO);

    /**
     * 更新人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.SAVE)
    Result save(@RequestParam(name = "personnelDivisionVO") PersonnelDivisionVO personnelDivisionVO);

    /**
     * 获取人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.GET_BY_ID)
    Result<PersonnelDivision> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.GET_BY_IDS)
    Result<List<PersonnelDivision>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.QUERY_LIST)
    Result<List<PersonnelDivision>> queryList(@RequestParam(name = "sample") PersonnelDivisionVO sample);

    /**
     * 分页查询人员分工
     */
    @RequestMapping(PersonnelDivisionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonnelDivision>> queryPagedList(@RequestParam(name = "sample") PersonnelDivisionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.PersonnelDivisionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonnelDivisionServiceProxy api() {
        return APIProxy.get(PersonnelDivisionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
