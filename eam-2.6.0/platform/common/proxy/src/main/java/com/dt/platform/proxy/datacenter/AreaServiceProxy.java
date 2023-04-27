package com.dt.platform.proxy.datacenter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.AreaVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 区域  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-22 21:40:43
 */
@FeignClient(value = ServiceNames.DATACENTER, contextId = AreaServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AreaServiceProxy {

    /**
     * 基础路径 , service-datacenter
     */
    public static final String API_BASIC_PATH = "service-datacenter";

    /**
     * API 上下文路径 , dc-area
     */
    public static final String API_CONTEXT_PATH = "dc-area";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加区域
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除区域
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除区域
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新区域
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存区域
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个区域
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个区域
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询区域
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询区域
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加区域
     */
    @RequestMapping(AreaServiceProxy.INSERT)
    Result insert(@RequestParam(name = "areaVO") AreaVO areaVO);

    /**
     * 删除区域
     */
    @RequestMapping(AreaServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除区域
     */
    @RequestMapping(AreaServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新区域
     */
    @RequestMapping(AreaServiceProxy.UPDATE)
    Result update(@RequestParam(name = "areaVO") AreaVO areaVO);

    /**
     * 更新区域
     */
    @RequestMapping(AreaServiceProxy.SAVE)
    Result save(@RequestParam(name = "areaVO") AreaVO areaVO);

    /**
     * 获取区域
     */
    @RequestMapping(AreaServiceProxy.GET_BY_ID)
    Result<Area> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个区域
     */
    @RequestMapping(AreaServiceProxy.GET_BY_IDS)
    Result<List<Area>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询区域
     */
    @RequestMapping(AreaServiceProxy.QUERY_LIST)
    Result<List<Area>> queryList(@RequestParam(name = "sample") AreaVO sample);

    /**
     * 分页查询区域
     */
    @RequestMapping(AreaServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Area>> queryPagedList(@RequestParam(name = "sample") AreaVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.datacenter.controller.AreaController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AreaServiceProxy api() {
        return APIProxy.get(AreaServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
