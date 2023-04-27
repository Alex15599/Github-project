package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.Storehouse;
import com.dt.platform.domain.wms.StorehouseVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 仓库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:40
 */
@FeignClient(value = ServiceNames.WMS, contextId = StorehouseServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface StorehouseServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-storehouse
     */
    public static final String API_CONTEXT_PATH = "wms-storehouse";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加仓库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除仓库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除仓库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新仓库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存仓库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个仓库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个仓库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询仓库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询仓库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加仓库
     */
    @RequestMapping(StorehouseServiceProxy.INSERT)
    Result insert(@RequestParam(name = "storehouseVO") StorehouseVO storehouseVO);

    /**
     * 删除仓库
     */
    @RequestMapping(StorehouseServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除仓库
     */
    @RequestMapping(StorehouseServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新仓库
     */
    @RequestMapping(StorehouseServiceProxy.UPDATE)
    Result update(@RequestParam(name = "storehouseVO") StorehouseVO storehouseVO);

    /**
     * 更新仓库
     */
    @RequestMapping(StorehouseServiceProxy.SAVE)
    Result save(@RequestParam(name = "storehouseVO") StorehouseVO storehouseVO);

    /**
     * 获取仓库
     */
    @RequestMapping(StorehouseServiceProxy.GET_BY_ID)
    Result<Storehouse> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个仓库
     */
    @RequestMapping(StorehouseServiceProxy.GET_BY_IDS)
    Result<List<Storehouse>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询仓库
     */
    @RequestMapping(StorehouseServiceProxy.QUERY_LIST)
    Result<List<Storehouse>> queryList(@RequestParam(name = "sample") StorehouseVO sample);

    /**
     * 分页查询仓库
     */
    @RequestMapping(StorehouseServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Storehouse>> queryPagedList(@RequestParam(name = "sample") StorehouseVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.StorehouseController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static StorehouseServiceProxy api() {
        return APIProxy.get(StorehouseServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
