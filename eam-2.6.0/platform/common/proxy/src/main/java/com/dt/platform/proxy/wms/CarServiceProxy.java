package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.Car;
import com.dt.platform.domain.wms.CarVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆管理 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:01:46
 */
@FeignClient(value = ServiceNames.WMS, contextId = CarServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CarServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-car
     */
    public static final String API_CONTEXT_PATH = "wms-car";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆管理
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆管理
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆管理
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆管理
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆管理
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆管理
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆管理
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆管理
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆管理
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆管理
     */
    @RequestMapping(CarServiceProxy.INSERT)
    Result insert(@RequestParam(name = "carVO") CarVO carVO);

    /**
     * 删除车辆管理
     */
    @RequestMapping(CarServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆管理
     */
    @RequestMapping(CarServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆管理
     */
    @RequestMapping(CarServiceProxy.UPDATE)
    Result update(@RequestParam(name = "carVO") CarVO carVO);

    /**
     * 更新车辆管理
     */
    @RequestMapping(CarServiceProxy.SAVE)
    Result save(@RequestParam(name = "carVO") CarVO carVO);

    /**
     * 获取车辆管理
     */
    @RequestMapping(CarServiceProxy.GET_BY_ID)
    Result<Car> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆管理
     */
    @RequestMapping(CarServiceProxy.GET_BY_IDS)
    Result<List<Car>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆管理
     */
    @RequestMapping(CarServiceProxy.QUERY_LIST)
    Result<List<Car>> queryList(@RequestParam(name = "sample") CarVO sample);

    /**
     * 分页查询车辆管理
     */
    @RequestMapping(CarServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Car>> queryPagedList(@RequestParam(name = "sample") CarVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.CarController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CarServiceProxy api() {
        return APIProxy.get(CarServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
