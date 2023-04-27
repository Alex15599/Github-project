package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.BackupDbStrategy;
import com.dt.platform.domain.common.BackupDbStrategyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 备份策略 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-26 18:37:10
 */
@FeignClient(value = ServiceNames.COMMON, contextId = BackupDbStrategyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BackupDbStrategyServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-backup-db-strategy
     */
    public static final String API_CONTEXT_PATH = "sys-backup-db-strategy";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加备份策略
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除备份策略
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除备份策略
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新备份策略
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存备份策略
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个备份策略
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个备份策略
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询备份策略
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询备份策略
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "backupDbStrategyVO") BackupDbStrategyVO backupDbStrategyVO);

    /**
     * 删除备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "backupDbStrategyVO") BackupDbStrategyVO backupDbStrategyVO);

    /**
     * 更新备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.SAVE)
    Result save(@RequestParam(name = "backupDbStrategyVO") BackupDbStrategyVO backupDbStrategyVO);

    /**
     * 获取备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.GET_BY_ID)
    Result<BackupDbStrategy> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.GET_BY_IDS)
    Result<List<BackupDbStrategy>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.QUERY_LIST)
    Result<List<BackupDbStrategy>> queryList(@RequestParam(name = "sample") BackupDbStrategyVO sample);

    /**
     * 分页查询备份策略
     */
    @RequestMapping(BackupDbStrategyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<BackupDbStrategy>> queryPagedList(@RequestParam(name = "sample") BackupDbStrategyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.BackupDbStrategyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BackupDbStrategyServiceProxy api() {
        return APIProxy.get(BackupDbStrategyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
