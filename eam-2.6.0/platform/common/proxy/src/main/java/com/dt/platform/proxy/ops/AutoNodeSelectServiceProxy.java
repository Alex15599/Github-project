package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoNodeSelect;
import com.dt.platform.domain.ops.AutoNodeSelectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 节点选择  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 21:24:47
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoNodeSelectServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoNodeSelectServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-node-select
     */
    public static final String API_CONTEXT_PATH = "ops-auto-node-select";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点选择
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点选择
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点选择
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点选择
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点选择
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点选择
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点选择
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点选择
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点选择
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoNodeSelectVO") AutoNodeSelectVO autoNodeSelectVO);

    /**
     * 删除节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoNodeSelectVO") AutoNodeSelectVO autoNodeSelectVO);

    /**
     * 更新节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoNodeSelectVO") AutoNodeSelectVO autoNodeSelectVO);

    /**
     * 获取节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.GET_BY_ID)
    Result<AutoNodeSelect> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.GET_BY_IDS)
    Result<List<AutoNodeSelect>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.QUERY_LIST)
    Result<List<AutoNodeSelect>> queryList(@RequestParam(name = "sample") AutoNodeSelectVO sample);

    /**
     * 分页查询节点选择
     */
    @RequestMapping(AutoNodeSelectServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoNodeSelect>> queryPagedList(@RequestParam(name = "sample") AutoNodeSelectVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoNodeSelectController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoNodeSelectServiceProxy api() {
        return APIProxy.get(AutoNodeSelectServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
