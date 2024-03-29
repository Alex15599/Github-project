package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.Position;
import com.dt.platform.domain.hr.PositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 工作岗位 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-02 14:12:25
 */
@FeignClient(value = ServiceNames.HR, contextId = PositionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PositionServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-position
     */
    public static final String API_CONTEXT_PATH = "hr-position";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加工作岗位
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除工作岗位
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除工作岗位
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新工作岗位
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存工作岗位
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个工作岗位
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个工作岗位
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询工作岗位
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询工作岗位
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加工作岗位
     */
    @RequestMapping(PositionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "positionVO") PositionVO positionVO);

    /**
     * 删除工作岗位
     */
    @RequestMapping(PositionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除工作岗位
     */
    @RequestMapping(PositionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新工作岗位
     */
    @RequestMapping(PositionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "positionVO") PositionVO positionVO);

    /**
     * 更新工作岗位
     */
    @RequestMapping(PositionServiceProxy.SAVE)
    Result save(@RequestParam(name = "positionVO") PositionVO positionVO);

    /**
     * 获取工作岗位
     */
    @RequestMapping(PositionServiceProxy.GET_BY_ID)
    Result<Position> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个工作岗位
     */
    @RequestMapping(PositionServiceProxy.GET_BY_IDS)
    Result<List<Position>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询工作岗位
     */
    @RequestMapping(PositionServiceProxy.QUERY_LIST)
    Result<List<Position>> queryList(@RequestParam(name = "sample") PositionVO sample);

    /**
     * 分页查询工作岗位
     */
    @RequestMapping(PositionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Position>> queryPagedList(@RequestParam(name = "sample") PositionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PositionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PositionServiceProxy api() {
        return APIProxy.get(PositionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
