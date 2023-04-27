package com.dt.platform.proxy.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.mobile.SoftwareInfo;
import com.dt.platform.domain.mobile.SoftwareInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 软件信息  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 15:08:05
 */
@FeignClient(value = ServiceNames.MOBILE, contextId = SoftwareInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SoftwareInfoServiceProxy {

    /**
     * 基础路径 , service-mobile
     */
    public static final String API_BASIC_PATH = "service-mobile";

    /**
     * API 上下文路径 , app-software-info
     */
    public static final String API_CONTEXT_PATH = "app-software-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加软件信息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除软件信息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除软件信息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新软件信息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存软件信息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个软件信息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个软件信息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询软件信息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询软件信息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出软件信息数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载软件信息导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入软件信息数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "softwareInfoVO") SoftwareInfoVO softwareInfoVO);

    /**
     * 删除软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "softwareInfoVO") SoftwareInfoVO softwareInfoVO);

    /**
     * 更新软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "softwareInfoVO") SoftwareInfoVO softwareInfoVO);

    /**
     * 获取软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.GET_BY_ID)
    Result<SoftwareInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.GET_BY_IDS)
    Result<List<SoftwareInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.QUERY_LIST)
    Result<List<SoftwareInfo>> queryList(@RequestParam(name = "sample") SoftwareInfoVO sample);

    /**
     * 分页查询软件信息
     */
    @RequestMapping(SoftwareInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SoftwareInfo>> queryPagedList(@RequestParam(name = "sample") SoftwareInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.mobile.controller.SoftwareInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SoftwareInfoServiceProxy api() {
        return APIProxy.get(SoftwareInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
