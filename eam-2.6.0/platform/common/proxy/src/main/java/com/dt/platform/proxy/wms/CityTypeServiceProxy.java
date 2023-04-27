package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.CityType;
import com.dt.platform.domain.wms.CityTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 城市类型 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:32
 */
@FeignClient(value = ServiceNames.WMS, contextId = CityTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CityTypeServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-city-type
     */
    public static final String API_CONTEXT_PATH = "wms-city-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加城市类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除城市类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除城市类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新城市类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存城市类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个城市类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个城市类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询城市类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询城市类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加城市类型
     */
    @RequestMapping(CityTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cityTypeVO") CityTypeVO cityTypeVO);

    /**
     * 删除城市类型
     */
    @RequestMapping(CityTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除城市类型
     */
    @RequestMapping(CityTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新城市类型
     */
    @RequestMapping(CityTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cityTypeVO") CityTypeVO cityTypeVO);

    /**
     * 更新城市类型
     */
    @RequestMapping(CityTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "cityTypeVO") CityTypeVO cityTypeVO);

    /**
     * 获取城市类型
     */
    @RequestMapping(CityTypeServiceProxy.GET_BY_ID)
    Result<CityType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个城市类型
     */
    @RequestMapping(CityTypeServiceProxy.GET_BY_IDS)
    Result<List<CityType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询城市类型
     */
    @RequestMapping(CityTypeServiceProxy.QUERY_LIST)
    Result<List<CityType>> queryList(@RequestParam(name = "sample") CityTypeVO sample);

    /**
     * 分页查询城市类型
     */
    @RequestMapping(CityTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CityType>> queryPagedList(@RequestParam(name = "sample") CityTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.CityTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CityTypeServiceProxy api() {
        return APIProxy.get(CityTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
