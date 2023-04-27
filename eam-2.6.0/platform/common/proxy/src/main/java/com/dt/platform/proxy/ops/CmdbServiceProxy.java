package com.dt.platform.proxy.ops;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModelVO;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 配置库 控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
 */
@FeignClient(value = ServiceNames.OPS, contextId = CmdbServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CmdbServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-cmdb-model
     */
    public static final String API_CONTEXT_PATH = "ops-cmdb";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加配置库
     */
    public static final String INSERT = API_PREFIX + "insert";


    public static final String DELETE_BY_SOURCE_ID = API_PREFIX + "delete-by-source-id";

    public static final String DELETE_BY_MODELVALUE_ID = API_PREFIX + "delete-by-modelvalue-id";

    public static final String GET_MODELVALUE_ID_BY_SOURCE_ID = API_PREFIX + "get-modelvalue-id-by-source-id";

    public static final String GET_BY_SOURCE_ID = API_PREFIX + "get-by-source-id";

    public static final String GET_BY_MODELVALUE_ID = API_PREFIX + "get_by_modelvalue_id";

    public static final String UPDATE_BY_MODELVALUE = API_PREFIX + "update-by-modelvalue";

    public static final String UPDATE_BY_MODELV_JSONOBJECT = API_PREFIX + "update-by-modelv-jsonobject";

    public static final String INSERT_MODELVALUE_OBJECT = API_PREFIX + "insert-modelvalue-object";

    public static final String INSERT_MODELVALUE = API_PREFIX + "insert-modelvalue";

    public static final String VERIFY_MODEL = API_PREFIX + "verify-model";

//    Result deleteBySourceId(String sourceId);
//
//    Result deleteByModelValueId(String id);
//
//    Result<String> getModelValueIdBySourceId(String sourceId,String defaultFill);
//
//    Result<JSONObject> getBySourceId(String sourceId);
//
//    Result<JSONObject> getByModelValueId(String id);
//
//    Result updateByModelValue(CmdbModelV modelV);
//
//    Result updateByJSONObject(JSONObject obj);
//
//    Result insertModelValueObject(JSONObject modelV);
//
//    Result insertModelValue(JSONObject modelV);
//
//    Result verifyModel(CmdbModel model);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CmdbController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CmdbServiceProxy api() {
        return APIProxy.get(CmdbServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
