package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbBackupLog;
import com.dt.platform.domain.ops.DbBackupLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 备份日志 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-30 20:06:33
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbBackupLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbBackupLogServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-backup-log
     */
    public static final String API_CONTEXT_PATH = "ops-db-backup-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加备份日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除备份日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除备份日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新备份日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存备份日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个备份日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个备份日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询备份日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询备份日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询备份日志
     */
    public static final String PARSE_LOG = API_PREFIX + "parse-log";




    /**
     * 添加备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbBackupLogVO") DbBackupLogVO dbBackupLogVO);

    /**
     * 删除备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbBackupLogVO") DbBackupLogVO dbBackupLogVO);

    /**
     * 更新备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbBackupLogVO") DbBackupLogVO dbBackupLogVO);

    /**
     * 获取备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.GET_BY_ID)
    Result<DbBackupLog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.GET_BY_IDS)
    Result<List<DbBackupLog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.QUERY_LIST)
    Result<List<DbBackupLog>> queryList(@RequestParam(name = "sample") DbBackupLogVO sample);

    /**
     * 分页查询备份日志
     */
    @RequestMapping(DbBackupLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbBackupLog>> queryPagedList(@RequestParam(name = "sample") DbBackupLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbBackupLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbBackupLogServiceProxy api() {
        return APIProxy.get(DbBackupLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
