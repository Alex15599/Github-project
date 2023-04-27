package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.ContractOrg;
import com.dt.platform.domain.hr.ContractOrgVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 合同签订方 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:30:35
 */
@FeignClient(value = ServiceNames.HR, contextId = ContractOrgServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ContractOrgServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-contract-org
     */
    public static final String API_CONTEXT_PATH = "hr-contract-org";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加合同签订方
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除合同签订方
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除合同签订方
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新合同签订方
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存合同签订方
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个合同签订方
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个合同签订方
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询合同签订方
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询合同签订方
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.INSERT)
    Result insert(@RequestParam(name = "contractOrgVO") ContractOrgVO contractOrgVO);

    /**
     * 删除合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.UPDATE)
    Result update(@RequestParam(name = "contractOrgVO") ContractOrgVO contractOrgVO);

    /**
     * 更新合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.SAVE)
    Result save(@RequestParam(name = "contractOrgVO") ContractOrgVO contractOrgVO);

    /**
     * 获取合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.GET_BY_ID)
    Result<ContractOrg> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.GET_BY_IDS)
    Result<List<ContractOrg>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.QUERY_LIST)
    Result<List<ContractOrg>> queryList(@RequestParam(name = "sample") ContractOrgVO sample);

    /**
     * 分页查询合同签订方
     */
    @RequestMapping(ContractOrgServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ContractOrg>> queryPagedList(@RequestParam(name = "sample") ContractOrgVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.ContractOrgController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ContractOrgServiceProxy api() {
        return APIProxy.get(ContractOrgServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
