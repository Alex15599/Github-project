package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetCopyRecord;
import com.dt.platform.domain.eam.AssetCopyRecordVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产复制记录 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-26 11:37:43
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetCopyRecordServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetCopyRecordServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-copy-record
     */
    public static final String API_CONTEXT_PATH = "eam-asset-copy-record";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产复制记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产复制记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产复制记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产复制记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产复制记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产复制记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产复制记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产复制记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产复制记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetCopyRecordVO") AssetCopyRecordVO assetCopyRecordVO);

    /**
     * 删除资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetCopyRecordVO") AssetCopyRecordVO assetCopyRecordVO);

    /**
     * 更新资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetCopyRecordVO") AssetCopyRecordVO assetCopyRecordVO);

    /**
     * 获取资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.GET_BY_ID)
    Result<AssetCopyRecord> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.GET_BY_IDS)
    Result<List<AssetCopyRecord>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.QUERY_LIST)
    Result<List<AssetCopyRecord>> queryList(@RequestParam(name = "sample") AssetCopyRecordVO sample);

    /**
     * 分页查询资产复制记录
     */
    @RequestMapping(AssetCopyRecordServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetCopyRecord>> queryPagedList(@RequestParam(name = "sample") AssetCopyRecordVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetCopyRecordController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetCopyRecordServiceProxy api() {
        return APIProxy.get(AssetCopyRecordServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
