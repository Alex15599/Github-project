package com.dt.platform.proxy.wms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.wms.AreaInfo;
import com.dt.platform.domain.wms.AreaInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 地区信息 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:25
 */
@FeignClient(value = ServiceNames.WMS, contextId = AreaInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AreaInfoServiceProxy {

    /**
     * 基础路径 , service-wms
     */
    public static final String API_BASIC_PATH = "service-wms";

    /**
     * API 上下文路径 , wms-area-info
     */
    public static final String API_CONTEXT_PATH = "wms-area-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加地区信息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除地区信息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除地区信息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新地区信息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存地区信息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个地区信息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个地区信息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询地区信息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询地区信息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "areaInfoVO") AreaInfoVO areaInfoVO);

    /**
     * 删除地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "areaInfoVO") AreaInfoVO areaInfoVO);

    /**
     * 更新地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "areaInfoVO") AreaInfoVO areaInfoVO);

    /**
     * 获取地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.GET_BY_ID)
    Result<AreaInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.GET_BY_IDS)
    Result<List<AreaInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.QUERY_LIST)
    Result<List<AreaInfo>> queryList(@RequestParam(name = "sample") AreaInfoVO sample);

    /**
     * 分页查询地区信息
     */
    @RequestMapping(AreaInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AreaInfo>> queryPagedList(@RequestParam(name = "sample") AreaInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.wms.controller.AreaInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AreaInfoServiceProxy api() {
        return APIProxy.get(AreaInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
