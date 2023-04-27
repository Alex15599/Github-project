package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbEnvInfo;
import com.dt.platform.domain.ops.DbEnvInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 数据库环境 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-14 06:01:00
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbEnvInfoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbEnvInfoServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-env-info
     */
    public static final String API_CONTEXT_PATH = "ops-db-env-info";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据库环境
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据库环境
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据库环境
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据库环境
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据库环境
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据库环境
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据库环境
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据库环境
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据库环境
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbEnvInfoVO") DbEnvInfoVO dbEnvInfoVO);

    /**
     * 删除数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbEnvInfoVO") DbEnvInfoVO dbEnvInfoVO);

    /**
     * 更新数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbEnvInfoVO") DbEnvInfoVO dbEnvInfoVO);

    /**
     * 获取数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.GET_BY_ID)
    Result<DbEnvInfo> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.GET_BY_IDS)
    Result<List<DbEnvInfo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.QUERY_LIST)
    Result<List<DbEnvInfo>> queryList(@RequestParam(name = "sample") DbEnvInfoVO sample);

    /**
     * 分页查询数据库环境
     */
    @RequestMapping(DbEnvInfoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbEnvInfo>> queryPagedList(@RequestParam(name = "sample") DbEnvInfoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbEnvInfoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbEnvInfoServiceProxy api() {
        return APIProxy.get(DbEnvInfoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
