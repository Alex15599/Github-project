package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.ManufacturerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 生产厂商  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-30 22:05:30
 */
@FeignClient(value = ServiceNames.EAM, contextId = ManufacturerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ManufacturerServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-manufacturer
     */
    public static final String API_CONTEXT_PATH = "eam-manufacturer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加生产厂商
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除生产厂商
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除生产厂商
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新生产厂商
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存生产厂商
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个生产厂商
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个生产厂商
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询生产厂商
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询生产厂商
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "manufacturerVO") ManufacturerVO manufacturerVO);

    /**
     * 删除生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "manufacturerVO") ManufacturerVO manufacturerVO);

    /**
     * 更新生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.SAVE)
    Result save(@RequestParam(name = "manufacturerVO") ManufacturerVO manufacturerVO);

    /**
     * 获取生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.GET_BY_ID)
    Result<Manufacturer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.GET_BY_IDS)
    Result<List<Manufacturer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.QUERY_LIST)
    Result<List<Manufacturer>> queryList(@RequestParam(name = "sample") ManufacturerVO sample);

    /**
     * 分页查询生产厂商
     */
    @RequestMapping(ManufacturerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Manufacturer>> queryPagedList(@RequestParam(name = "sample") ManufacturerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.ManufacturerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ManufacturerServiceProxy api() {
        return APIProxy.get(ManufacturerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
