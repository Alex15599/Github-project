package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.MaintainerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维保厂商  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-30 22:05:17
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainerServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintainer
     */
    public static final String API_CONTEXT_PATH = "eam-maintainer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维保厂商
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维保厂商
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维保厂商
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维保厂商
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维保厂商
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维保厂商
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维保厂商
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维保厂商
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维保厂商
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "maintainerVO") MaintainerVO maintainerVO);

    /**
     * 删除维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "maintainerVO") MaintainerVO maintainerVO);

    /**
     * 更新维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.SAVE)
    Result save(@RequestParam(name = "maintainerVO") MaintainerVO maintainerVO);

    /**
     * 获取维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.GET_BY_ID)
    Result<Maintainer> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.GET_BY_IDS)
    Result<List<Maintainer>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.QUERY_LIST)
    Result<List<Maintainer>> queryList(@RequestParam(name = "sample") MaintainerVO sample);

    /**
     * 分页查询维保厂商
     */
    @RequestMapping(MaintainerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Maintainer>> queryPagedList(@RequestParam(name = "sample") MaintainerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainerServiceProxy api() {
        return APIProxy.get(MaintainerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
