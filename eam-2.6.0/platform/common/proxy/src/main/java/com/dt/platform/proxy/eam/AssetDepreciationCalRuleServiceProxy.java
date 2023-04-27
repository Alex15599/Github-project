package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDepreciationCalRule;
import com.dt.platform.domain.eam.AssetDepreciationCalRuleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 计算方法 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 17:04:42
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDepreciationCalRuleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDepreciationCalRuleServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-depreciation-cal-rule
     */
    public static final String API_CONTEXT_PATH = "eam-asset-depreciation-cal-rule";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加计算方法
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除计算方法
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除计算方法
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新计算方法
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存计算方法
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个计算方法
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个计算方法
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询计算方法
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询计算方法
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDepreciationCalRuleVO") AssetDepreciationCalRuleVO assetDepreciationCalRuleVO);

    /**
     * 删除计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDepreciationCalRuleVO") AssetDepreciationCalRuleVO assetDepreciationCalRuleVO);

    /**
     * 更新计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDepreciationCalRuleVO") AssetDepreciationCalRuleVO assetDepreciationCalRuleVO);

    /**
     * 获取计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.GET_BY_ID)
    Result<AssetDepreciationCalRule> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.GET_BY_IDS)
    Result<List<AssetDepreciationCalRule>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.QUERY_LIST)
    Result<List<AssetDepreciationCalRule>> queryList(@RequestParam(name = "sample") AssetDepreciationCalRuleVO sample);

    /**
     * 分页查询计算方法
     */
    @RequestMapping(AssetDepreciationCalRuleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDepreciationCalRule>> queryPagedList(@RequestParam(name = "sample") AssetDepreciationCalRuleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDepreciationCalRuleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDepreciationCalRuleServiceProxy api() {
        return APIProxy.get(AssetDepreciationCalRuleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
