package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.AutoVoucher;
import com.dt.platform.domain.ops.AutoVoucherVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 自动化凭证  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 14:09:43
 */
@FeignClient(value = ServiceNames.OPS, contextId = AutoVoucherServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AutoVoucherServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-auto-voucher
     */
    public static final String API_CONTEXT_PATH = "ops-auto-voucher";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加自动化凭证
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除自动化凭证
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除自动化凭证
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新自动化凭证
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存自动化凭证
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个自动化凭证
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个自动化凭证
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询自动化凭证
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询自动化凭证
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.INSERT)
    Result insert(@RequestParam(name = "autoVoucherVO") AutoVoucherVO autoVoucherVO);

    /**
     * 删除自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.UPDATE)
    Result update(@RequestParam(name = "autoVoucherVO") AutoVoucherVO autoVoucherVO);

    /**
     * 更新自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.SAVE)
    Result save(@RequestParam(name = "autoVoucherVO") AutoVoucherVO autoVoucherVO);

    /**
     * 获取自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.GET_BY_ID)
    Result<AutoVoucher> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.GET_BY_IDS)
    Result<List<AutoVoucher>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.QUERY_LIST)
    Result<List<AutoVoucher>> queryList(@RequestParam(name = "sample") AutoVoucherVO sample);

    /**
     * 分页查询自动化凭证
     */
    @RequestMapping(AutoVoucherServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AutoVoucher>> queryPagedList(@RequestParam(name = "sample") AutoVoucherVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.AutoVoucherController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AutoVoucherServiceProxy api() {
        return APIProxy.get(AutoVoucherServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
