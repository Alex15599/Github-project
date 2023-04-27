package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.AutoModuleRoleItem;
import com.dt.platform.domain.common.AutoModuleRoleItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 赋权明细 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:04:25
 */
@FeignClient(value = ServiceNames.COMMON, contextId = AutoModuleRoleItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoModuleRoleItemServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-auto-module-role-item
     */
    public static final String API_CONTEXT_PATH = "sys-auto-module-role-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加赋权明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除赋权明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除赋权明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新赋权明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存赋权明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个赋权明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个赋权明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询赋权明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询赋权明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoModuleRoleItemVO") AutoModuleRoleItemVO autoModuleRoleItemVO);

    /**
     * 删除赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoModuleRoleItemVO") AutoModuleRoleItemVO autoModuleRoleItemVO);

    /**
     * 更新赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoModuleRoleItemVO") AutoModuleRoleItemVO autoModuleRoleItemVO);

    /**
     * 获取赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.GET_BY_ID)
    Result<AutoModuleRoleItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.GET_BY_IDS)
    Result<List<AutoModuleRoleItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.QUERY_LIST)
    Result<List<AutoModuleRoleItem>> queryList(@RequestParam(name = "sample") AutoModuleRoleItemVO sample);

    /**
     * 分页查询赋权明细
     */
    @RequestMapping(AutoModuleRoleItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoModuleRoleItem>> queryPagedList(@RequestParam(name = "sample") AutoModuleRoleItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.AutoModuleRoleItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoModuleRoleItemServiceProxy api() {
        return APIProxy.get(AutoModuleRoleItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
