package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoActionFile;
import com.dt.platform.domain.ops.AutoActionFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 执行介质  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 13:59:12
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoActionFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoActionFileServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-action-file
     */
    public static final String API_CONTEXT_PATH = "ops-auto-action-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加执行介质
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除执行介质
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除执行介质
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新执行介质
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存执行介质
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个执行介质
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个执行介质
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询执行介质
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询执行介质
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoActionFileVO") AutoActionFileVO autoActionFileVO);

    /**
     * 删除执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoActionFileVO") AutoActionFileVO autoActionFileVO);

    /**
     * 更新执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoActionFileVO") AutoActionFileVO autoActionFileVO);

    /**
     * 获取执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.GET_BY_ID)
    Result<AutoActionFile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.GET_BY_IDS)
    Result<List<AutoActionFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.QUERY_LIST)
    Result<List<AutoActionFile>> queryList(@RequestParam(name = "sample") AutoActionFileVO sample);

    /**
     * 分页查询执行介质
     */
    @RequestMapping(AutoActionFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoActionFile>> queryPagedList(@RequestParam(name = "sample") AutoActionFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoActionFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoActionFileServiceProxy api() {
        return APIProxy.get(AutoActionFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
