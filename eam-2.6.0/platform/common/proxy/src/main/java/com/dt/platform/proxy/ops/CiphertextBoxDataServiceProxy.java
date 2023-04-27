package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.CiphertextBoxDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 密文数据 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 20:34:32
 */
@FeignClient(value = ServiceNames.OPS, contextId = CiphertextBoxDataServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CiphertextBoxDataServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-ciphertext-box-data
     */
    public static final String API_CONTEXT_PATH = "ops-ciphertext-box-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加密文数据
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除密文数据
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除密文数据
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新密文数据
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存密文数据
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个密文数据
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个密文数据
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询密文数据
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询密文数据
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ciphertextBoxDataVO") CiphertextBoxDataVO ciphertextBoxDataVO);

    /**
     * 删除密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ciphertextBoxDataVO") CiphertextBoxDataVO ciphertextBoxDataVO);

    /**
     * 更新密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.SAVE)
    Result save(@RequestParam(name = "ciphertextBoxDataVO") CiphertextBoxDataVO ciphertextBoxDataVO);

    /**
     * 获取密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.GET_BY_ID)
    Result<CiphertextBoxData> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.GET_BY_IDS)
    Result<List<CiphertextBoxData>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.QUERY_LIST)
    Result<List<CiphertextBoxData>> queryList(@RequestParam(name = "sample") CiphertextBoxDataVO sample);

    /**
     * 分页查询密文数据
     */
    @RequestMapping(CiphertextBoxDataServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CiphertextBoxData>> queryPagedList(@RequestParam(name = "sample") CiphertextBoxDataVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CiphertextBoxDataController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CiphertextBoxDataServiceProxy api() {
        return APIProxy.get(CiphertextBoxDataServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
