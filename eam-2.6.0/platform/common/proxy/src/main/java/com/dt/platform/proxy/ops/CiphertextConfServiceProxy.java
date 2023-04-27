package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CiphertextConf;
import com.dt.platform.domain.ops.CiphertextConfVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 权限配置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 10:33:43
 */
@FeignClient(value = ServiceNames.OPS, contextId = CiphertextConfServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CiphertextConfServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-ciphertext-conf
     */
    public static final String API_CONTEXT_PATH = "ops-ciphertext-conf";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加权限配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除权限配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除权限配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新权限配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存权限配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个权限配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个权限配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询权限配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询权限配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ciphertextConfVO") CiphertextConfVO ciphertextConfVO);

    /**
     * 删除权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ciphertextConfVO") CiphertextConfVO ciphertextConfVO);

    /**
     * 更新权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.SAVE)
    Result save(@RequestParam(name = "ciphertextConfVO") CiphertextConfVO ciphertextConfVO);

    /**
     * 获取权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.GET_BY_ID)
    Result<CiphertextConf> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.GET_BY_IDS)
    Result<List<CiphertextConf>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.QUERY_LIST)
    Result<List<CiphertextConf>> queryList(@RequestParam(name = "sample") CiphertextConfVO sample);

    /**
     * 分页查询权限配置
     */
    @RequestMapping(CiphertextConfServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CiphertextConf>> queryPagedList(@RequestParam(name = "sample") CiphertextConfVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CiphertextConfController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CiphertextConfServiceProxy api() {
        return APIProxy.get(CiphertextConfServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
