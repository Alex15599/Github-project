package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionPointPos;
import com.dt.platform.domain.eam.InspectionPointPosVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检点位 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-10 09:39:30
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionPointPosServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionPointPosServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-point-pos
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-point-pos";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检点位
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检点位
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检点位
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检点位
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检点位
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检点位
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检点位
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检点位
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检点位
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionPointPosVO") InspectionPointPosVO inspectionPointPosVO);

    /**
     * 删除巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionPointPosVO") InspectionPointPosVO inspectionPointPosVO);

    /**
     * 更新巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionPointPosVO") InspectionPointPosVO inspectionPointPosVO);

    /**
     * 获取巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.GET_BY_ID)
    Result<InspectionPointPos> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.GET_BY_IDS)
    Result<List<InspectionPointPos>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.QUERY_LIST)
    Result<List<InspectionPointPos>> queryList(@RequestParam(name = "sample") InspectionPointPosVO sample);

    /**
     * 分页查询巡检点位
     */
    @RequestMapping(InspectionPointPosServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionPointPos>> queryPagedList(@RequestParam(name = "sample") InspectionPointPosVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionPointPosController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionPointPosServiceProxy api() {
        return APIProxy.get(InspectionPointPosServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
