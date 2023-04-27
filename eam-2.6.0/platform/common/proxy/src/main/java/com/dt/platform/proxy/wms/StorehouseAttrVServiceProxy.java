package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.StorehouseAttrV;
import com.dt.platform.domain.wms.StorehouseAttrVVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 仓库属性 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:29
 */
@FeignClient(value = ServiceNames.WMS, contextId = StorehouseAttrVServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface StorehouseAttrVServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-storehouse-attr-v
     */
    public static final String API_CONTEXT_PATH = "wms-storehouse-attr-v";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加仓库属性
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除仓库属性
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除仓库属性
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新仓库属性
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存仓库属性
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个仓库属性
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个仓库属性
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询仓库属性
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询仓库属性
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.INSERT)
    Result insert(@RequestParam(name = "storehouseAttrVVO") StorehouseAttrVVO storehouseAttrVVO);

    /**
     * 删除仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.UPDATE)
    Result update(@RequestParam(name = "storehouseAttrVVO") StorehouseAttrVVO storehouseAttrVVO);

    /**
     * 更新仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.SAVE)
    Result save(@RequestParam(name = "storehouseAttrVVO") StorehouseAttrVVO storehouseAttrVVO);

    /**
     * 获取仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.GET_BY_ID)
    Result<StorehouseAttrV> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.GET_BY_IDS)
    Result<List<StorehouseAttrV>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.QUERY_LIST)
    Result<List<StorehouseAttrV>> queryList(@RequestParam(name = "sample") StorehouseAttrVVO sample);

    /**
     * 分页查询仓库属性
     */
    @RequestMapping(StorehouseAttrVServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<StorehouseAttrV>> queryPagedList(@RequestParam(name = "sample") StorehouseAttrVVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.StorehouseAttrVController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static StorehouseAttrVServiceProxy api() {
        return APIProxy.get(StorehouseAttrVServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
