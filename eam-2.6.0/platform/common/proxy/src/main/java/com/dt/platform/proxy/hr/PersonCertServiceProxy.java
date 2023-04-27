package com.dt.platform.proxy.hr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.hr.PersonCert;
import com.dt.platform.domain.hr.PersonCertVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 人员证书 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:12:49
 */
@FeignClient(value = ServiceNames.HR, contextId = PersonCertServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PersonCertServiceProxy {

    /**
     * 基础路径 , service-hr
     */
    public static final String API_BASIC_PATH = "service-hr";

    /**
     * API 上下文路径 , hr-person-cert
     */
    public static final String API_CONTEXT_PATH = "hr-person-cert";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加人员证书
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除人员证书
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除人员证书
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新人员证书
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存人员证书
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个人员证书
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个人员证书
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询人员证书
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询人员证书
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加人员证书
     */
    @RequestMapping(PersonCertServiceProxy.INSERT)
    Result insert(@RequestParam(name = "personCertVO") PersonCertVO personCertVO);

    /**
     * 删除人员证书
     */
    @RequestMapping(PersonCertServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除人员证书
     */
    @RequestMapping(PersonCertServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新人员证书
     */
    @RequestMapping(PersonCertServiceProxy.UPDATE)
    Result update(@RequestParam(name = "personCertVO") PersonCertVO personCertVO);

    /**
     * 更新人员证书
     */
    @RequestMapping(PersonCertServiceProxy.SAVE)
    Result save(@RequestParam(name = "personCertVO") PersonCertVO personCertVO);

    /**
     * 获取人员证书
     */
    @RequestMapping(PersonCertServiceProxy.GET_BY_ID)
    Result<PersonCert> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个人员证书
     */
    @RequestMapping(PersonCertServiceProxy.GET_BY_IDS)
    Result<List<PersonCert>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询人员证书
     */
    @RequestMapping(PersonCertServiceProxy.QUERY_LIST)
    Result<List<PersonCert>> queryList(@RequestParam(name = "sample") PersonCertVO sample);

    /**
     * 分页查询人员证书
     */
    @RequestMapping(PersonCertServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PersonCert>> queryPagedList(@RequestParam(name = "sample") PersonCertVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.hr.controller.PersonCertController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PersonCertServiceProxy api() {
        return APIProxy.get(PersonCertServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
