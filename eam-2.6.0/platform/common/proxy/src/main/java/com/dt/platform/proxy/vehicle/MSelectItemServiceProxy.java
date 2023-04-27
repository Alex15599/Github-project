package com.dt.platform.proxy.vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.vehicle.MSelectItem;
import com.dt.platform.domain.vehicle.MSelectItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆数据 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-03 07:27:12
 */
@FeignClient(value = ServiceNames.VEHICLE, contextId = MSelectItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MSelectItemServiceProxy {

    /**
     * 基础路径 , service-vehicle
     */
    public static final String API_BASIC_PATH = "service-vehicle";

    /**
     * API 上下文路径 , vehicle-m-select-item
     */
    public static final String API_CONTEXT_PATH = "vehicle-m-select-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加车辆数据
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆数据
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆数据
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆数据
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆数据
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆数据
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆数据
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆数据
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆数据
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "mSelectItemVO") MSelectItemVO mSelectItemVO);

    /**
     * 删除车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "mSelectItemVO") MSelectItemVO mSelectItemVO);

    /**
     * 更新车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "mSelectItemVO") MSelectItemVO mSelectItemVO);

    /**
     * 获取车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.GET_BY_ID)
    Result<MSelectItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.GET_BY_IDS)
    Result<List<MSelectItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.QUERY_LIST)
    Result<List<MSelectItem>> queryList(@RequestParam(name = "sample") MSelectItemVO sample);

    /**
     * 分页查询车辆数据
     */
    @RequestMapping(MSelectItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MSelectItem>> queryPagedList(@RequestParam(name = "sample") MSelectItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.vehicle.controller.MSelectItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MSelectItemServiceProxy api() {
        return APIProxy.get(MSelectItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
