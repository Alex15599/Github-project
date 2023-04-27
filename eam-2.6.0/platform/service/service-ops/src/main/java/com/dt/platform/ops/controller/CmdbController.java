package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.CmdbModelVO;
import com.dt.platform.domain.ops.CmdbModelVVO;
import com.dt.platform.ops.service.ICmdbService;
import com.dt.platform.proxy.ops.CmdbServiceProxy;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 配置库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
 */
@InDoc
@Api(tags = "null/配置库")
@RestController("CmdbController")
public class CmdbController extends SuperController {

    @Autowired
    private ICmdbService cmdbService;


    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.DELETE_BY_SOURCE_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.DELETE_BY_SOURCE_ID)
    public Result deleteBySourceId(String id) {
        return cmdbService.deleteBySourceId(id);
    }

    @ApiOperation(value = "2")
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.DELETE_BY_MODELVALUE_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.DELETE_BY_MODELVALUE_ID)
    public Result deleteByModelValueId(String id) {
        return cmdbService.deleteByModelValueId(id);
    }


    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.GET_MODELVALUE_ID_BY_SOURCE_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.GET_MODELVALUE_ID_BY_SOURCE_ID)
    public Result<String> getModelValueIdBySourceId(String id) {
        return cmdbService.getModelValueIdBySourceId(id,"__none__");
    }

    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.GET_BY_SOURCE_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.GET_BY_SOURCE_ID)
    public Result<JSONObject> getBySourceId(String id) {
        return cmdbService.getBySourceId(id);
    }


    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.GET_BY_MODELVALUE_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.GET_BY_MODELVALUE_ID)
    public Result<JSONObject> getByModelValueId(String id) {
        return cmdbService.getByModelValueId(id);
    }


    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.UPDATE_BY_MODELVALUE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.UPDATE_BY_MODELVALUE)
    public Result updateByModelValue(CmdbModelVVO modelV) {
        return cmdbService.updateByModelValue(modelV);
    }

    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 7, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.UPDATE_BY_MODELV_JSONOBJECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.UPDATE_BY_MODELV_JSONOBJECT)
    public Result updateByModelValueJSONObject(JSONObject obj) {
        return cmdbService.updateByModelValueJSONObject(obj);
    }


    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.INSERT_MODELVALUE_OBJECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.INSERT_MODELVALUE_OBJECT)
    public Result insertModelValueObject(JSONObject obj) {
        return cmdbService.insertModelValueObject(obj);
    }


    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 9, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.INSERT_MODELVALUE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.INSERT_MODELVALUE)
    public Result insertModelValue(CmdbModelVVO modelV) {
        return cmdbService.insertModelValue(modelV);
    }

    @ApiOperation(value = "1")
    @ApiOperationSupport(order = 10, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbServiceProxy.VERIFY_MODEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbServiceProxy.VERIFY_MODEL)
    public Result verifyModel(CmdbModelVO modelVO) {
        return cmdbService.verifyModel(modelVO);
    }





}
