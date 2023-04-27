package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.SoftwareBaseVersion;
import com.dt.platform.domain.ops.SoftwareBaseVersionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 软件基线版本 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 07:34:18
 */
@FeignClient(value = ServiceNames.OPS, contextId = SoftwareBaseVersionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SoftwareBaseVersionServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-software-base-version
     */
    public static final String API_CONTEXT_PATH = "ops-software-base-version";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加软件基线版本
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除软件基线版本
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除软件基线版本
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新软件基线版本
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存软件基线版本
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个软件基线版本
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个软件基线版本
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询软件基线版本
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询软件基线版本
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "softwareBaseVersionVO") SoftwareBaseVersionVO softwareBaseVersionVO);

    /**
     * 删除软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "softwareBaseVersionVO") SoftwareBaseVersionVO softwareBaseVersionVO);

    /**
     * 更新软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.SAVE)
    Result save(@RequestParam(name = "softwareBaseVersionVO") SoftwareBaseVersionVO softwareBaseVersionVO);

    /**
     * 获取软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.GET_BY_ID)
    Result<SoftwareBaseVersion> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.GET_BY_IDS)
    Result<List<SoftwareBaseVersion>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.QUERY_LIST)
    Result<List<SoftwareBaseVersion>> queryList(@RequestParam(name = "sample") SoftwareBaseVersionVO sample);

    /**
     * 分页查询软件基线版本
     */
    @RequestMapping(SoftwareBaseVersionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SoftwareBaseVersion>> queryPagedList(@RequestParam(name = "sample") SoftwareBaseVersionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.SoftwareBaseVersionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SoftwareBaseVersionServiceProxy api() {
        return APIProxy.get(SoftwareBaseVersionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
