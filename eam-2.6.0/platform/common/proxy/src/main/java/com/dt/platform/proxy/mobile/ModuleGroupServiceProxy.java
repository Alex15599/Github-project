package com.dt.platform.proxy.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.mobile.ModuleGroup;
import com.dt.platform.domain.mobile.ModuleGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 移动端模块分组  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-28 20:41:10
 */
@FeignClient(value = ServiceNames.MOBILE, contextId = ModuleGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ModuleGroupServiceProxy {

    /**
     * 基础路径 , service-mobile
     */
    public static final String API_BASIC_PATH = "service-mobile";

    /**
     * API 上下文路径 , app-module-group
     */
    public static final String API_CONTEXT_PATH = "app-module-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加移动端模块分组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除移动端模块分组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除移动端模块分组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新移动端模块分组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存移动端模块分组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个移动端模块分组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个移动端模块分组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询移动端模块分组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询移动端模块分组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询移动端模块分组
     */
    public static final String QUERY_FOR_MOBILE = API_PREFIX + "query-for-mobile";

    /**
     * 导出移动端模块分组数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载移动端模块分组导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入移动端模块分组数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "moduleGroupVO") ModuleGroupVO moduleGroupVO);

    /**
     * 删除移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "moduleGroupVO") ModuleGroupVO moduleGroupVO);

    /**
     * 更新移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "moduleGroupVO") ModuleGroupVO moduleGroupVO);

    /**
     * 获取移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.GET_BY_ID)
    Result<ModuleGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.GET_BY_IDS)
    Result<List<ModuleGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.QUERY_LIST)
    Result<List<ModuleGroup>> queryList(@RequestParam(name = "sample") ModuleGroupVO sample);

    /**
     * 分页查询移动端模块分组
     */
    @RequestMapping(ModuleGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ModuleGroup>> queryPagedList(@RequestParam(name = "sample") ModuleGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.mobile.controller.ModuleGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ModuleGroupServiceProxy api() {
        return APIProxy.get(ModuleGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
