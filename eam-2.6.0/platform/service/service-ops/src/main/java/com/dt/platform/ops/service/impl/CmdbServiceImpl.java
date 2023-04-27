package com.dt.platform.ops.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.ops.OpsCmdbAttributeTypeEnum;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModelVVO;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.domain.ops.meta.CmdbModelMeta;
import com.dt.platform.domain.ops.meta.CmdbModelVMeta;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 配置库服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
*/


@Service("OpsCmdbService")
public class CmdbServiceImpl extends SuperService<CmdbModel> implements ICmdbService {




	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Autowired
	private ICmdbModelService cmdbModelService;

	@Autowired
	private ICmdbModelVService cmdbModelVService;

	@Autowired
	private ICmdbLogService cmdbLogService;


	@Autowired
	private ICmdbModelVHService cmdbModelVHService;



	@Override
	public Result deleteByIdPhysical(String s) {
		return null;
	}

	@Override
	public CmdbModel getById(String s) {

		return null;
	}

	@Override
	public List<CmdbModel> getByIds(List<String> list) {
		return null;
	}




	@Override
	public Result deleteBySourceId(String sourceId){
		Result queryResult=getModelValueIdBySourceId(sourceId,"__none__");
		if(queryResult.isSuccess()){
			return deleteByModelValueId(queryResult.getData().toString());
		}else{
			return queryResult;
		}
	}
	@Override
	public Result deleteByModelValueId(String id){
		return cmdbModelVService.deleteByIdLogical(id);
	}

	@Override
	public Result<String> getModelValueIdBySourceId(String sourceId,String defaultFill){
		String id="";
		Result<String> res=new Result<>();
		res.success();
		CmdbModelVVO vQuery=new CmdbModelVVO();
		vQuery.setObjSourceId(sourceId);
		vQuery.setVStatus(StatusEnableEnum.ENABLE.code());
		List<CmdbModelV> valueList=cmdbModelVService.queryList(vQuery);
		if(valueList.size()==0){
			id="";
		}else if(valueList.size()==1){
			id=valueList.get(0).getId();
		}else{
			return ErrorDesc.failureMessage("根据sourceId返回了多行数据，请检查");
		}
		if(StringUtil.isBlank(id)){
			res.data(defaultFill);
		}else{
			res.data(id);
		}
		return res;
	}


	@Override
	public Result insertModelValue(CmdbModelV modelV){
		return ErrorDesc.success();
	}


	@Override
	public Result insertModelValueObject(JSONObject modelV){

		return ErrorDesc.success();
	}

	@Override
	public Result updateByModelValue(CmdbModelV modelV){

		modelV.setVersion(0);
		return cmdbModelVService.update(modelV,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,true);
	}

	@Override
	public Result updateByModelValueJSONObject(JSONObject obj){

		String id=obj.getString("id");

		if(StringUtil.isBlank(id)){
			return ErrorDesc.failureMessage("请输入主键ID");
		}


		String modelId=obj.getString("modelId");
		if(StringUtil.isBlank(modelId)){
			modelId=cmdbModelVService.getById(id).getModelId();
		}

		CmdbModel cmdbModel=cmdbModelService.getById(modelId);
		Result verifyResult=verifyModel(cmdbModel);
		if(!verifyResult.isSuccess()){
			return verifyResult;
		}

		Update ups=new Update();

		return ErrorDesc.success();
	}


	@Override
	public Result<JSONObject> getBySourceId(String sourceId){
		Result<JSONObject> res=new Result<>();
		res.success();
		Result queryResult=getModelValueIdBySourceId(sourceId,"__none__");
		if(queryResult.success()){
			return getByModelValueId(queryResult.getData().toString());
		}else{
			return res;
		}
	}

	@Override
	public Result<JSONObject> getByModelValueId(String id){
		CmdbModelV value=cmdbModelVService.getById(id);
		cmdbModelVService.dao().fill(value)
				.with(CmdbModelVMeta.CMDB_MODEL)
				.with(CmdbModelVMeta.CMDB_OBJ_ATTRIBUTE_LIST)
				.execute();

		Result verifyResult= verifyModel(value.getCmdbModel());
		if(!verifyResult.isSuccess()){
			return verifyResult;
		}
		return translateRow(value,value.getCmdbObjAttributeList());
	}



	public Result<JSONArray> translateFast(CmdbModelV value, List<CmdbObjAttribute> attributeList){
		return null;
	}
	/*
	 *  直接进行转换，不对数据进行验证
	 **/
	public Result<JSONObject> translateRow(CmdbModelV value,List<CmdbObjAttribute> attributeList){

		JSONObject obj=new JSONObject();
		JSONObject sourceObj=BeanUtil.toJSONObject(value);
		Logger.info(sourceObj);
		obj.put("id",value.getId());
		obj.put("pid",value.getPid());
		obj.put("modelId",value.getModelId());
		obj.put("vStatus",value.getVStatus());
		obj.put("vVersion",value.getVVersion());
		obj.put("objSourceId",value.getObjSourceId());
		obj.put("name",value.getName());
		obj.put("desc",value.getDesc());
		obj.put("notes",value.getNotes());
		for(CmdbObjAttribute attr:attributeList){
			if(StatusEnableEnum.ENABLE.code().equals(attr.getStatus())){
				String colFill=attr.getAttributeColFill();
				String colShow=attr.getAttributeColShow();
				Logger.info("colFill:"+colFill+",colShow:"+colShow);
				if(OpsCmdbAttributeTypeEnum.STRING.code().equals(attr.getAttributeType())){
					if(sourceObj.containsKey(colFill)){
						obj.put(colShow,sourceObj.getString(colFill));
					}else{
						obj.put(colShow,"");
					}
				}else if(OpsCmdbAttributeTypeEnum.INT.code().equals(attr.getAttributeType())){
					if(sourceObj.containsKey(colFill)){
						obj.put(colShow,sourceObj.getInteger(colFill));
					}
				}else if(OpsCmdbAttributeTypeEnum.DECIMAL.code().equals(attr.getAttributeType())){
					if(sourceObj.containsKey(colFill)){
						obj.put(colShow,sourceObj.getDoubleValue(colFill));
					}
				}else{
					for (Map.Entry<String, Object> stringObjectEntry : sourceObj.entrySet()) {
						String key = stringObjectEntry.getKey();
						Object value1 = stringObjectEntry.getValue();
						if(key.equals(colFill)){
							obj.put(colShow,value1);
							break;
						}
					}
				}
			}
		}

		Result<JSONObject> res=new Result<>();
		res.data(obj);
		res.success();
		Logger.info("obj\n"+obj.toJSONString());
		return res;
	}


	/*
	* 传入参数.with(CmdbModelMeta.CMDB_OBJ_ATTRIBUTE_LIST)
	* */
	public Result verifyModel(CmdbModel model){
		if(model==null){
			Logger.info("模型对象为空");
			return ErrorDesc.failureMessage("模型对象为空");
		}
		Logger.info("model name:"+model.getName());
		if(!StatusEnableEnum.ENABLE.code().equals(model.getStatus())){
			Logger.info("当前对象模型未启用,请先启用");
			return ErrorDesc.failureMessage("当前对象模型未启用,请先启用");
		}
		if(model.getCmdbObjAttributeList()==null){
			cmdbModelService.dao().fill(model)
					.with(CmdbModelMeta.CMDB_OBJ_ATTRIBUTE_LIST)
					.execute();
		}
		if(model.getCmdbObjAttributeList()==null||model.getCmdbObjAttributeList().size()==0){
			Logger.info("当前对象模型未配置属性");
			return ErrorDesc.failureMessage("当前对象模型未配置属性");
		}
		List<CmdbObjAttribute> attributeList= model.getCmdbObjAttributeList();
		Logger.info("model column size:"+attributeList.size());
		List<CmdbObjAttribute> attributeEnableList= new ArrayList<>();
		for(CmdbObjAttribute attribute:attributeEnableList){
			if(!StatusEnableEnum.ENABLE.code().equals(attribute.getStatus())){
				continue;
			}
			attributeEnableList.add(attribute);
		}
		Logger.info("model enable column size:"+attributeEnableList.size());
		if(attributeEnableList.size()==0){
			Logger.info("当前对象模型属性未启用");
			return ErrorDesc.failureMessage("当前对象模型属性未启用");
		}
		return ErrorDesc.success();

	}

}