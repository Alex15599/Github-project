package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CCustInspectTplAsset;
import com.dt.platform.domain.eam.CCustInspectTplAssetVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 设备 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-08 19:00:26
 */
@FeignClient(value = ServiceNames.EAM, contextId = CCustInspectTplAssetServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CCustInspectTplAssetServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-c-cust-inspect-tpl-asset
     */
    public static final String API_CONTEXT_PATH = "eam-c-cust-inspect-tpl-asset";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加设备
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除设备
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除设备
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新设备
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存设备
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个设备
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个设备
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询设备
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询设备
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.INSERT)
    Result insert(@RequestParam(name = "cCustInspectTplAssetVO") CCustInspectTplAssetVO cCustInspectTplAssetVO);

    /**
     * 删除设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.UPDATE)
    Result update(@RequestParam(name = "cCustInspectTplAssetVO") CCustInspectTplAssetVO cCustInspectTplAssetVO);

    /**
     * 更新设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.SAVE)
    Result save(@RequestParam(name = "cCustInspectTplAssetVO") CCustInspectTplAssetVO cCustInspectTplAssetVO);

    /**
     * 获取设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.GET_BY_ID)
    Result<CCustInspectTplAsset> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.GET_BY_IDS)
    Result<List<CCustInspectTplAsset>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.QUERY_LIST)
    Result<List<CCustInspectTplAsset>> queryList(@RequestParam(name = "sample") CCustInspectTplAssetVO sample);

    /**
     * 分页查询设备
     */
    @RequestMapping(CCustInspectTplAssetServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CCustInspectTplAsset>> queryPagedList(@RequestParam(name = "sample") CCustInspectTplAssetVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CCustInspectTplAssetController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CCustInspectTplAssetServiceProxy api() {
        return APIProxy.get(CCustInspectTplAssetServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
