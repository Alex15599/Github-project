package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CiphertextHistory;
import com.dt.platform.domain.ops.CiphertextHistoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 历史记录  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 14:16:45
 */
@FeignClient(value = ServiceNames.OPS, contextId = CiphertextHistoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CiphertextHistoryServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-ciphertext-history
     */
    public static final String API_CONTEXT_PATH = "ops-ciphertext-history";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加历史记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除历史记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除历史记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新历史记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存历史记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个历史记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个历史记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询历史记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询历史记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ciphertextHistoryVO") CiphertextHistoryVO ciphertextHistoryVO);

    /**
     * 删除历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ciphertextHistoryVO") CiphertextHistoryVO ciphertextHistoryVO);

    /**
     * 更新历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "ciphertextHistoryVO") CiphertextHistoryVO ciphertextHistoryVO);

    /**
     * 获取历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.GET_BY_ID)
    Result<CiphertextHistory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.GET_BY_IDS)
    Result<List<CiphertextHistory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.QUERY_LIST)
    Result<List<CiphertextHistory>> queryList(@RequestParam(name = "sample") CiphertextHistoryVO sample);

    /**
     * 分页查询历史记录
     */
    @RequestMapping(CiphertextHistoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CiphertextHistory>> queryPagedList(@RequestParam(name = "sample") CiphertextHistoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CiphertextHistoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CiphertextHistoryServiceProxy api() {
        return APIProxy.get(CiphertextHistoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
