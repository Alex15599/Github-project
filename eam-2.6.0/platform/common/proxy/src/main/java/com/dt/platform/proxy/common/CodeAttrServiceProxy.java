package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.CodeAttr;
import com.dt.platform.domain.common.CodeAttrVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 编码属性 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 09:57:38
 */
@FeignClient(value = ServiceNames.COMMON, contextId = CodeAttrServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeAttrServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-code-attr
     */
    public static final String API_CONTEXT_PATH = "sys-code-attr";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加编码属性
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除编码属性
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除编码属性
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新编码属性
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存编码属性
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个编码属性
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个编码属性
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询编码属性
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询编码属性
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.INSERT)
    Result insert(@RequestParam(name = "codeAttrVO") CodeAttrVO codeAttrVO);

    /**
     * 删除编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.UPDATE)
    Result update(@RequestParam(name = "codeAttrVO") CodeAttrVO codeAttrVO);

    /**
     * 更新编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.SAVE)
    Result save(@RequestParam(name = "codeAttrVO") CodeAttrVO codeAttrVO);

    /**
     * 获取编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.GET_BY_ID)
    Result<CodeAttr> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.GET_BY_IDS)
    Result<List<CodeAttr>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.QUERY_LIST)
    Result<List<CodeAttr>> queryList(@RequestParam(name = "sample") CodeAttrVO sample);

    /**
     * 分页查询编码属性
     */
    @RequestMapping(CodeAttrServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CodeAttr>> queryPagedList(@RequestParam(name = "sample") CodeAttrVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.CodeAttrController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeAttrServiceProxy api() {
        return APIProxy.get(CodeAttrServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
