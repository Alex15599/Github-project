package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.OperType;
import com.dt.platform.domain.wms.OperTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 操作类型 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:49
 */
@FeignClient(value = ServiceNames.WMS, contextId = OperTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface OperTypeServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-oper-type
     */
    public static final String API_CONTEXT_PATH = "wms-oper-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加操作类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除操作类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除操作类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新操作类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存操作类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个操作类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个操作类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询操作类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询操作类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加操作类型
     */
    @RequestMapping(OperTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "operTypeVO") OperTypeVO operTypeVO);

    /**
     * 删除操作类型
     */
    @RequestMapping(OperTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除操作类型
     */
    @RequestMapping(OperTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新操作类型
     */
    @RequestMapping(OperTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "operTypeVO") OperTypeVO operTypeVO);

    /**
     * 更新操作类型
     */
    @RequestMapping(OperTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "operTypeVO") OperTypeVO operTypeVO);

    /**
     * 获取操作类型
     */
    @RequestMapping(OperTypeServiceProxy.GET_BY_ID)
    Result<OperType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个操作类型
     */
    @RequestMapping(OperTypeServiceProxy.GET_BY_IDS)
    Result<List<OperType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询操作类型
     */
    @RequestMapping(OperTypeServiceProxy.QUERY_LIST)
    Result<List<OperType>> queryList(@RequestParam(name = "sample") OperTypeVO sample);

    /**
     * 分页查询操作类型
     */
    @RequestMapping(OperTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<OperType>> queryPagedList(@RequestParam(name = "sample") OperTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.OperTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static OperTypeServiceProxy api() {
        return APIProxy.get(OperTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
