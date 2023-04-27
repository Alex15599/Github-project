package com.dt.platform.ops.service;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModelVO;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 配置库服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
*/

public interface ICmdbService extends  ISimpleIdService<CmdbModel,String> {


    Result deleteBySourceId(String sourceId);

    Result deleteByModelValueId(String id);

    Result<String> getModelValueIdBySourceId(String sourceId,String defaultFill);

    Result<JSONObject> getBySourceId(String sourceId);

    Result<JSONObject> getByModelValueId(String id);

    Result updateByModelValue(CmdbModelV modelV);

    Result updateByModelValueJSONObject(JSONObject modelV);

    Result insertModelValueObject(JSONObject modelV);

    Result insertModelValue(CmdbModelV modelV);

    Result verifyModel(CmdbModel model);

    Result<JSONObject> translateRow(CmdbModelV value, List<CmdbObjAttribute> attributeList);







}