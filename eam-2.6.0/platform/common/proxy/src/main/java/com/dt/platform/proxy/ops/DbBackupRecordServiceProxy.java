package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbBackupRecord;
import com.dt.platform.domain.ops.DbBackupRecordVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 备份记录  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-12 16:56:55
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbBackupRecordServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbBackupRecordServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-backup-record
     */
    public static final String API_CONTEXT_PATH = "ops-db-backup-record";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加备份记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除备份记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除备份记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新备份记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存备份记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个备份记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个备份记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询备份记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询备份记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbBackupRecordVO") DbBackupRecordVO dbBackupRecordVO);

    /**
     * 删除备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbBackupRecordVO") DbBackupRecordVO dbBackupRecordVO);

    /**
     * 更新备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbBackupRecordVO") DbBackupRecordVO dbBackupRecordVO);

    /**
     * 获取备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.GET_BY_ID)
    Result<DbBackupRecord> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.GET_BY_IDS)
    Result<List<DbBackupRecord>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.QUERY_LIST)
    Result<List<DbBackupRecord>> queryList(@RequestParam(name = "sample") DbBackupRecordVO sample);

    /**
     * 分页查询备份记录
     */
    @RequestMapping(DbBackupRecordServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbBackupRecord>> queryPagedList(@RequestParam(name = "sample") DbBackupRecordVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbBackupRecordController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbBackupRecordServiceProxy api() {
        return APIProxy.get(DbBackupRecordServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
