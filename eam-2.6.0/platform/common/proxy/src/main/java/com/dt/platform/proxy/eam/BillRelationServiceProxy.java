package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.BillRelation;
import com.dt.platform.domain.eam.BillRelationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 单据关联  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-24 19:16:17
 */
@FeignClient(value = ServiceNames.EAM, contextId = BillRelationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BillRelationServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-bill-relation
     */
    public static final String API_CONTEXT_PATH = "eam-bill-relation";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加单据关联
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除单据关联
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除单据关联
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新单据关联
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存单据关联
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个单据关联
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个单据关联
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询单据关联
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询单据关联
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出单据关联数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载单据关联导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入单据关联数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加单据关联
     */
    @RequestMapping(BillRelationServiceProxy.INSERT)
    Result insert(@RequestParam(name = "billRelationVO") BillRelationVO billRelationVO);

    /**
     * 删除单据关联
     */
    @RequestMapping(BillRelationServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除单据关联
     */
    @RequestMapping(BillRelationServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新单据关联
     */
    @RequestMapping(BillRelationServiceProxy.UPDATE)
    Result update(@RequestParam(name = "billRelationVO") BillRelationVO billRelationVO);

    /**
     * 更新单据关联
     */
    @RequestMapping(BillRelationServiceProxy.SAVE)
    Result save(@RequestParam(name = "billRelationVO") BillRelationVO billRelationVO);

    /**
     * 获取单据关联
     */
    @RequestMapping(BillRelationServiceProxy.GET_BY_ID)
    Result<BillRelation> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个单据关联
     */
    @RequestMapping(BillRelationServiceProxy.GET_BY_IDS)
    Result<List<BillRelation>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询单据关联
     */
    @RequestMapping(BillRelationServiceProxy.QUERY_LIST)
    Result<List<BillRelation>> queryList(@RequestParam(name = "sample") BillRelationVO sample);

    /**
     * 分页查询单据关联
     */
    @RequestMapping(BillRelationServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<BillRelation>> queryPagedList(@RequestParam(name = "sample") BillRelationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.BillRelationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BillRelationServiceProxy api() {
        return APIProxy.get(BillRelationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
