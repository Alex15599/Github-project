package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetBorrowReturn;
import com.dt.platform.domain.eam.AssetBorrowReturnVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产归还 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 10:13:24
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetBorrowReturnServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetBorrowReturnServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-borrow-return
     */
    public static final String API_CONTEXT_PATH = "eam-asset-borrow-return";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产归还
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产归还
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产归还
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产归还
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产归还
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产归还
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产归还
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产归还
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产归还
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";

    /**
     * 添加资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetBorrowReturnVO") AssetBorrowReturnVO assetBorrowReturnVO);

    /**
     * 删除资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetBorrowReturnVO") AssetBorrowReturnVO assetBorrowReturnVO);

    /**
     * 更新资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetBorrowReturnVO") AssetBorrowReturnVO assetBorrowReturnVO);

    /**
     * 获取资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.GET_BY_ID)
    Result<AssetBorrowReturn> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.GET_BY_IDS)
    Result<List<AssetBorrowReturn>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.QUERY_LIST)
    Result<List<AssetBorrowReturn>> queryList(@RequestParam(name = "sample") AssetBorrowReturnVO sample);

    /**
     * 分页查询资产归还
     */
    @RequestMapping(AssetBorrowReturnServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetBorrowReturn>> queryPagedList(@RequestParam(name = "sample") AssetBorrowReturnVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetBorrowReturnController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetBorrowReturnServiceProxy api() {
        return APIProxy.get(AssetBorrowReturnServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
