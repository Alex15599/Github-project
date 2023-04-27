package com.dt.platform.proxy.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.mobile.ModuleInfo;
import com.dt.platform.domain.mobile.ModuleInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 移动端模块  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-20 22:31:33
 */
@FeignClient(value = ServiceNames.MOBILE, contextId = ModuleInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ModuleInfoServiceProxy {

    /**
     * 基础路径 , service-mobile
     */
    public static final String API_BASIC_PATH = "service-mobile";

    /**
     * API 上下文路径 , app-module-info
     */
    public static final String API_CONTEXT_PATH = "app-module-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加移动端模块
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除移动端模块
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除移动端模块
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新移动端模块
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存移动端模块
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个移动端模块
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个移动端模块
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询移动端模块
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询移动端模块
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "moduleInfoVO") ModuleInfoVO moduleInfoVO);

    /**
     * 删除移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "moduleInfoVO") ModuleInfoVO moduleInfoVO);

    /**
     * 更新移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "moduleInfoVO") ModuleInfoVO moduleInfoVO);

    /**
     * 获取移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.GET_BY_ID)
    Result<ModuleInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.GET_BY_IDS)
    Result<List<ModuleInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.QUERY_LIST)
    Result<List<ModuleInfo>> queryList(@RequestParam(name = "sample") ModuleInfoVO sample);

    /**
     * 分页查询移动端模块
     */
    @RequestMapping(ModuleInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ModuleInfo>> queryPagedList(@RequestParam(name = "sample") ModuleInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.mobile.controller.ModuleInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ModuleInfoServiceProxy api() {
        return APIProxy.get(ModuleInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
