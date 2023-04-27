package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoActionSFile;
import com.dt.platform.domain.ops.AutoActionSFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 介质选择  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 15:00:31
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoActionSFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoActionSFileServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-action-s-file
     */
    public static final String API_CONTEXT_PATH = "ops-auto-action-s-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加介质选择
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除介质选择
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除介质选择
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新介质选择
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存介质选择
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个介质选择
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个介质选择
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询介质选择
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询介质选择
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoActionSFileVO") AutoActionSFileVO autoActionSFileVO);

    /**
     * 删除介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoActionSFileVO") AutoActionSFileVO autoActionSFileVO);

    /**
     * 更新介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoActionSFileVO") AutoActionSFileVO autoActionSFileVO);

    /**
     * 获取介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.GET_BY_ID)
    Result<AutoActionSFile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.GET_BY_IDS)
    Result<List<AutoActionSFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.QUERY_LIST)
    Result<List<AutoActionSFile>> queryList(@RequestParam(name = "sample") AutoActionSFileVO sample);

    /**
     * 分页查询介质选择
     */
    @RequestMapping(AutoActionSFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoActionSFile>> queryPagedList(@RequestParam(name = "sample") AutoActionSFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoActionSFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoActionSFileServiceProxy api() {
        return APIProxy.get(AutoActionSFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
