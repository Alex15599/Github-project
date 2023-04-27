package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetStatusRuleV;
import com.dt.platform.domain.eam.AssetStatusRuleVVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 状态规则值 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-13 13:02:58
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetStatusRuleVServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetStatusRuleVServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-status-rule-v
     */
    public static final String API_CONTEXT_PATH = "eam-asset-status-rule-v";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加状态规则值
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除状态规则值
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除状态规则值
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新状态规则值
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存状态规则值
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个状态规则值
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个状态规则值
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询状态规则值
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询状态规则值
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetStatusRuleVVO") AssetStatusRuleVVO assetStatusRuleVVO);

    /**
     * 删除状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetStatusRuleVVO") AssetStatusRuleVVO assetStatusRuleVVO);

    /**
     * 更新状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetStatusRuleVVO") AssetStatusRuleVVO assetStatusRuleVVO);

    /**
     * 获取状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.GET_BY_ID)
    Result<AssetStatusRuleV> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.GET_BY_IDS)
    Result<List<AssetStatusRuleV>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.QUERY_LIST)
    Result<List<AssetStatusRuleV>> queryList(@RequestParam(name = "sample") AssetStatusRuleVVO sample);

    /**
     * 分页查询状态规则值
     */
    @RequestMapping(AssetStatusRuleVServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetStatusRuleV>> queryPagedList(@RequestParam(name = "sample") AssetStatusRuleVVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetStatusRuleVController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetStatusRuleVServiceProxy api() {
        return APIProxy.get(AssetStatusRuleVServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
