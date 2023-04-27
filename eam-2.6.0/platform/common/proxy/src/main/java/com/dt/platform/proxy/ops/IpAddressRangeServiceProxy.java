package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.IpAddressRange;
import com.dt.platform.domain.ops.IpAddressRangeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * IP地址段  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-30 07:16:58
 */
@FeignClient(value = ServiceNames.OPS, contextId = IpAddressRangeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface IpAddressRangeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-ip-address-range
     */
    public static final String API_CONTEXT_PATH = "ops-ip-address-range";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加IP地址段
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除IP地址段
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除IP地址段
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新IP地址段
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存IP地址段
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个IP地址段
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个IP地址段
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询IP地址段
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询IP地址段
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ipAddressRangeVO") IpAddressRangeVO ipAddressRangeVO);

    /**
     * 删除IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ipAddressRangeVO") IpAddressRangeVO ipAddressRangeVO);

    /**
     * 更新IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.SAVE)
    Result save(@RequestParam(name = "ipAddressRangeVO") IpAddressRangeVO ipAddressRangeVO);

    /**
     * 获取IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.GET_BY_ID)
    Result<IpAddressRange> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.GET_BY_IDS)
    Result<List<IpAddressRange>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.QUERY_LIST)
    Result<List<IpAddressRange>> queryList(@RequestParam(name = "sample") IpAddressRangeVO sample);

    /**
     * 分页查询IP地址段
     */
    @RequestMapping(IpAddressRangeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<IpAddressRange>> queryPagedList(@RequestParam(name = "sample") IpAddressRangeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.IpAddressRangeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static IpAddressRangeServiceProxy api() {
        return APIProxy.get(IpAddressRangeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
