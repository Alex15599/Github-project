package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CiphertextBox;
import com.dt.platform.domain.ops.CiphertextBoxVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 密文箱  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 14:45:36
 */
@FeignClient(value = ServiceNames.OPS, contextId = CiphertextBoxServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CiphertextBoxServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-ciphertext-box
     */
    public static final String API_CONTEXT_PATH = "ops-ciphertext-box";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加密文箱
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除密文箱
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除密文箱
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新密文箱
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存密文箱
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个密文箱
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个密文箱
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询密文箱
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询密文箱
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 判断用户是否有加解密权限
     */
    public static final String USER_EN_DE_PERM_BY_BOXTYPE = API_PREFIX + "user-en-de-perm-by-boxtype";

    /**
     * 添加密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ciphertextBoxVO") CiphertextBoxVO ciphertextBoxVO);

    /**
     * 删除密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ciphertextBoxVO") CiphertextBoxVO ciphertextBoxVO);

    /**
     * 更新密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.SAVE)
    Result save(@RequestParam(name = "ciphertextBoxVO") CiphertextBoxVO ciphertextBoxVO);

    /**
     * 获取密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.GET_BY_ID)
    Result<CiphertextBox> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.GET_BY_IDS)
    Result<List<CiphertextBox>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.QUERY_LIST)
    Result<List<CiphertextBox>> queryList(@RequestParam(name = "sample") CiphertextBoxVO sample);

    /**
     * 分页查询密文箱
     */
    @RequestMapping(CiphertextBoxServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CiphertextBox>> queryPagedList(@RequestParam(name = "sample") CiphertextBoxVO sample);



    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CiphertextBoxController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CiphertextBoxServiceProxy api() {
        return APIProxy.get(CiphertextBoxServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
