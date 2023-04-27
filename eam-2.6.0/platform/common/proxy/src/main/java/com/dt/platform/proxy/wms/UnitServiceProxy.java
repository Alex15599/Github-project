package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.Unit;
import com.dt.platform.domain.wms.UnitVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 计量单位 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:22
 */
@FeignClient(value = ServiceNames.WMS, contextId = UnitServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface UnitServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-unit
     */
    public static final String API_CONTEXT_PATH = "wms-unit";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加计量单位
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除计量单位
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除计量单位
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新计量单位
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存计量单位
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个计量单位
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个计量单位
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询计量单位
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询计量单位
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加计量单位
     */
    @RequestMapping(UnitServiceProxy.INSERT)
    Result insert(@RequestParam(name = "unitVO") UnitVO unitVO);

    /**
     * 删除计量单位
     */
    @RequestMapping(UnitServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除计量单位
     */
    @RequestMapping(UnitServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新计量单位
     */
    @RequestMapping(UnitServiceProxy.UPDATE)
    Result update(@RequestParam(name = "unitVO") UnitVO unitVO);

    /**
     * 更新计量单位
     */
    @RequestMapping(UnitServiceProxy.SAVE)
    Result save(@RequestParam(name = "unitVO") UnitVO unitVO);

    /**
     * 获取计量单位
     */
    @RequestMapping(UnitServiceProxy.GET_BY_ID)
    Result<Unit> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个计量单位
     */
    @RequestMapping(UnitServiceProxy.GET_BY_IDS)
    Result<List<Unit>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询计量单位
     */
    @RequestMapping(UnitServiceProxy.QUERY_LIST)
    Result<List<Unit>> queryList(@RequestParam(name = "sample") UnitVO sample);

    /**
     * 分页查询计量单位
     */
    @RequestMapping(UnitServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Unit>> queryPagedList(@RequestParam(name = "sample") UnitVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.UnitController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static UnitServiceProxy api() {
        return APIProxy.get(UnitServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
