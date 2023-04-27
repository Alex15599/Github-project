package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.AutoRoleGrantRcd;
import com.dt.platform.domain.common.AutoRoleGrantRcdVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 操作日志 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:19:24
 */
@FeignClient(value = ServiceNames.COMMON, contextId = AutoRoleGrantRcdServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoRoleGrantRcdServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-auto-role-grant-rcd
     */
    public static final String API_CONTEXT_PATH = "sys-auto-role-grant-rcd";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加操作日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除操作日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除操作日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新操作日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存操作日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个操作日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个操作日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询操作日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询操作日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoRoleGrantRcdVO") AutoRoleGrantRcdVO autoRoleGrantRcdVO);

    /**
     * 删除操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoRoleGrantRcdVO") AutoRoleGrantRcdVO autoRoleGrantRcdVO);

    /**
     * 更新操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoRoleGrantRcdVO") AutoRoleGrantRcdVO autoRoleGrantRcdVO);

    /**
     * 获取操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.GET_BY_ID)
    Result<AutoRoleGrantRcd> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.GET_BY_IDS)
    Result<List<AutoRoleGrantRcd>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.QUERY_LIST)
    Result<List<AutoRoleGrantRcd>> queryList(@RequestParam(name = "sample") AutoRoleGrantRcdVO sample);

    /**
     * 分页查询操作日志
     */
    @RequestMapping(AutoRoleGrantRcdServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoRoleGrantRcd>> queryPagedList(@RequestParam(name = "sample") AutoRoleGrantRcdVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.AutoRoleGrantRcdController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoRoleGrantRcdServiceProxy api() {
        return APIProxy.get(AutoRoleGrantRcdServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
