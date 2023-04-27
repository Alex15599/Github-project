package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.AutoModuleRole;
import com.dt.platform.domain.common.AutoModuleRoleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 模块角色 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-04 15:14:30
 */
@FeignClient(value = ServiceNames.COMMON, contextId = AutoModuleRoleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoModuleRoleServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-auto-module-role
     */
    public static final String API_CONTEXT_PATH = "sys-auto-module-role";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加模块角色
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除模块角色
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除模块角色
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新模块角色
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存模块角色
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个模块角色
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个模块角色
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询模块角色
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询模块角色
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询模块角色
     */
    public static final String PERMISSION_DOWNGRADE = API_PREFIX + "permission-downgrade";

    /**
     * 添加模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoModuleRoleVO") AutoModuleRoleVO autoModuleRoleVO);

    /**
     * 删除模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoModuleRoleVO") AutoModuleRoleVO autoModuleRoleVO);

    /**
     * 更新模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoModuleRoleVO") AutoModuleRoleVO autoModuleRoleVO);

    /**
     * 获取模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.GET_BY_ID)
    Result<AutoModuleRole> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.GET_BY_IDS)
    Result<List<AutoModuleRole>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.QUERY_LIST)
    Result<List<AutoModuleRole>> queryList(@RequestParam(name = "sample") AutoModuleRoleVO sample);

    /**
     * 分页查询模块角色
     */
    @RequestMapping(AutoModuleRoleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoModuleRole>> queryPagedList(@RequestParam(name = "sample") AutoModuleRoleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.AutoModuleRoleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoModuleRoleServiceProxy api() {
        return APIProxy.get(AutoModuleRoleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
