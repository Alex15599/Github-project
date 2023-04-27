package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.TemperatureAttribute;
import com.dt.platform.domain.wms.TemperatureAttributeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 温度属性 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:14
 */
@FeignClient(value = ServiceNames.WMS, contextId = TemperatureAttributeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TemperatureAttributeServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-temperature-attribute
     */
    public static final String API_CONTEXT_PATH = "wms-temperature-attribute";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加温度属性
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除温度属性
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除温度属性
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新温度属性
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存温度属性
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个温度属性
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个温度属性
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询温度属性
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询温度属性
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "temperatureAttributeVO") TemperatureAttributeVO temperatureAttributeVO);

    /**
     * 删除温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "temperatureAttributeVO") TemperatureAttributeVO temperatureAttributeVO);

    /**
     * 更新温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.SAVE)
    Result save(@RequestParam(name = "temperatureAttributeVO") TemperatureAttributeVO temperatureAttributeVO);

    /**
     * 获取温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.GET_BY_ID)
    Result<TemperatureAttribute> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.GET_BY_IDS)
    Result<List<TemperatureAttribute>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.QUERY_LIST)
    Result<List<TemperatureAttribute>> queryList(@RequestParam(name = "sample") TemperatureAttributeVO sample);

    /**
     * 分页查询温度属性
     */
    @RequestMapping(TemperatureAttributeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<TemperatureAttribute>> queryPagedList(@RequestParam(name = "sample") TemperatureAttributeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.TemperatureAttributeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TemperatureAttributeServiceProxy api() {
        return APIProxy.get(TemperatureAttributeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
