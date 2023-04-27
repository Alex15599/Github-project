package com.dt.platform.proxy.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.mobile.SoftwareGroup;
import com.dt.platform.domain.mobile.SoftwareGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 软件组  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 08:16:10
 */
@FeignClient(value = ServiceNames.MOBILE, contextId = SoftwareGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SoftwareGroupServiceProxy {

    /**
     * 基础路径 , service-mobile
     */
    public static final String API_BASIC_PATH = "service-mobile";

    /**
     * API 上下文路径 , app-software-group
     */
    public static final String API_CONTEXT_PATH = "app-software-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加软件组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除软件组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除软件组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新软件组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存软件组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个软件组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个软件组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询软件组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询软件组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出软件组数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载软件组导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入软件组数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "softwareGroupVO") SoftwareGroupVO softwareGroupVO);

    /**
     * 删除软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "softwareGroupVO") SoftwareGroupVO softwareGroupVO);

    /**
     * 更新软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "softwareGroupVO") SoftwareGroupVO softwareGroupVO);

    /**
     * 获取软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.GET_BY_ID)
    Result<SoftwareGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.GET_BY_IDS)
    Result<List<SoftwareGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.QUERY_LIST)
    Result<List<SoftwareGroup>> queryList(@RequestParam(name = "sample") SoftwareGroupVO sample);

    /**
     * 分页查询软件组
     */
    @RequestMapping(SoftwareGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SoftwareGroup>> queryPagedList(@RequestParam(name = "sample") SoftwareGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.mobile.controller.SoftwareGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SoftwareGroupServiceProxy api() {
        return APIProxy.get(SoftwareGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
