package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.AutoUserPredefined;
import com.dt.platform.domain.common.AutoUserPredefinedVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 预定用户 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:15:43
 */
@FeignClient(value = ServiceNames.COMMON, contextId = AutoUserPredefinedServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoUserPredefinedServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-auto-user-predefined
     */
    public static final String API_CONTEXT_PATH = "sys-auto-user-predefined";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加预定用户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除预定用户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除预定用户
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新预定用户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存预定用户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个预定用户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个预定用户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询预定用户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询预定用户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoUserPredefinedVO") AutoUserPredefinedVO autoUserPredefinedVO);

    /**
     * 删除预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoUserPredefinedVO") AutoUserPredefinedVO autoUserPredefinedVO);

    /**
     * 更新预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoUserPredefinedVO") AutoUserPredefinedVO autoUserPredefinedVO);

    /**
     * 获取预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.GET_BY_ID)
    Result<AutoUserPredefined> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.GET_BY_IDS)
    Result<List<AutoUserPredefined>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.QUERY_LIST)
    Result<List<AutoUserPredefined>> queryList(@RequestParam(name = "sample") AutoUserPredefinedVO sample);

    /**
     * 分页查询预定用户
     */
    @RequestMapping(AutoUserPredefinedServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoUserPredefined>> queryPagedList(@RequestParam(name = "sample") AutoUserPredefinedVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.AutoUserPredefinedController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoUserPredefinedServiceProxy api() {
        return APIProxy.get(AutoUserPredefinedServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
