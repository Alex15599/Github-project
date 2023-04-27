package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.PublicContent;
import com.dt.platform.domain.ops.PublicContentVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 开放列 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-04 15:55:13
 */
@FeignClient(value = ServiceNames.OPS, contextId = PublicContentServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PublicContentServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-public-content
     */
    public static final String API_CONTEXT_PATH = "ops-public-content";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加开放列
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除开放列
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除开放列
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新开放列
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存开放列
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个开放列
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个开放列
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询开放列
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询开放列
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加开放列
     */
    @RequestMapping(PublicContentServiceProxy.INSERT)
    Result insert(@RequestParam(name = "publicContentVO") PublicContentVO publicContentVO);

    /**
     * 删除开放列
     */
    @RequestMapping(PublicContentServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除开放列
     */
    @RequestMapping(PublicContentServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新开放列
     */
    @RequestMapping(PublicContentServiceProxy.UPDATE)
    Result update(@RequestParam(name = "publicContentVO") PublicContentVO publicContentVO);

    /**
     * 更新开放列
     */
    @RequestMapping(PublicContentServiceProxy.SAVE)
    Result save(@RequestParam(name = "publicContentVO") PublicContentVO publicContentVO);

    /**
     * 获取开放列
     */
    @RequestMapping(PublicContentServiceProxy.GET_BY_ID)
    Result<PublicContent> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个开放列
     */
    @RequestMapping(PublicContentServiceProxy.GET_BY_IDS)
    Result<List<PublicContent>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询开放列
     */
    @RequestMapping(PublicContentServiceProxy.QUERY_LIST)
    Result<List<PublicContent>> queryList(@RequestParam(name = "sample") PublicContentVO sample);

    /**
     * 分页查询开放列
     */
    @RequestMapping(PublicContentServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PublicContent>> queryPagedList(@RequestParam(name = "sample") PublicContentVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.PublicContentController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PublicContentServiceProxy api() {
        return APIProxy.get(PublicContentServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
