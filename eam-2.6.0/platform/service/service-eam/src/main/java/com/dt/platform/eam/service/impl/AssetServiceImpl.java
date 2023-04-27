package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deepoove.poi.data.PictureType;
import com.deepoove.poi.data.Pictures;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.common.ResetOnCloseInputStream;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.*;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.treaty.DBTreaty;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.poi.ss.usermodel.*;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogData;
import org.github.foxnic.web.domain.pcm.DataQueryVo;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.proxy.changes.ChangeDefinitionServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 资产 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:
 */


@Service("EamAssetService")
public class AssetServiceImpl extends SuperService<Asset> implements IAssetService {

	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetDataService assetDataService;

	@Autowired
	private IAssetCategoryService assetCategoryService;

	@Autowired
	private IAssetItemService assetItemService;

	@Autowired
	private IAssetStatusRuleService assetStatusRuleService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;


	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
//        1、为了保证复制速度，一次最多可复制500个资产
//        2、以下资产信息不可被复制：
//        资产编码、资产编码（旧）
//        设备序列号、
//        使用人、
//        领用日期
//        入库时间
//        累计折旧
//        残值
//        净值
//        3、复制后的资产状态为空闲
	@Override
	public Result<List<String>> assetCopy(String id, int number) {
		//该功能只有在自动编码开启时才能使用
		Logger.info("自动创建资产assetId:"+id+",数量:"+number);
		if(!operateService.queryAssetCodeAutoCreate()){
			return ErrorDesc.failureMessage("当前资产编码自动生成未启用,无法使用复制的功能");
		}
		int limit=8000;
		if(number>limit){
			return ErrorDesc.failureMessage("复制数量过大，最大不可超过"+limit);
		}
		Asset asset=this.getById(id);
		if(asset==null){
			return ErrorDesc.failureMessage("复制的资产不存在");
		}
		List<String> idsList=new ArrayList<>();
		for(int i=0;i<number;i++){
			String assetId=IDGenerator.getSnowflakeIdString();
			asset.setId(assetId);
			asset.setAssetStatus(AssetStatusEnum.IDLE.code());
			asset.setAssetCode(null);
			asset.setSerialNumber(null);
			asset.setCreateBy(null);
			asset.setCreateTime(null);
			asset.setUpdateBy(null);
			asset.setUpdateTime(null);
			asset.setUseUserId(null);
			asset.setManagerId(null);
			asset.setBillId(null);
			asset.setOriginatorId(null);
			asset.setEntryTime(null);
			asset.setTaxAmountPrice(null);
			asset.setTaxAmountPrice(null);
			asset.setTotalAmountPrice(null);
			asset.setOriginalUnitPrice(null);
			asset.setCurrentYearDepreciation(null);
			asset.setDepreciationYear(null);
			asset.setAccumulatedDepreciation(null);
			asset.setMonthDepreciationPrice(null);
			asset.setResidualsRate(null);
			asset.setResidualsPrice(null);
			asset.setNavPrice(null);
			asset.setPurchaseUnitPrice(null);
			asset.setPurchaseDate(null);
			asset.setAssetNumber(1);
			Result insertResult=this.insert(asset);
			idsList.add(assetId);
		}
		Result<List<String>> result=new Result<>();
		result.success(true);
		result.data(idsList);
		return result;
	}


	public String applyAssetDataPermissions(Asset asset,ConditionExpr expr){
		String dp="";
		Logger.info("dataPermissions|applyAssetDataPermissions,ownerCode:"+AssetOwnerCodeEnum.ASSET.code());
		if(!StringUtil.isBlank(AssetOwnerCodeEnum.ASSET.code())){
			if(AssetOwnerCodeEnum.ASSET.code().equals(asset.getOwnerCode())){
				Logger.info("dataPermissions|queryAssetDataPermissions ");
				if(operateService.queryAssetDataPermissions()){
					Logger.info("dataPermissions|assetDataPermissions parameter enable");
					dp="eam_asset_global_data_permission";
				}else{
					Logger.info("dataPermissions|assetDataPermissions parameter disabled");
				}
			}else{
				Logger.info("dataPermissions|assetCode not matched.");
			}
		}
		Logger.info("dataPermissions|apply asset data permission finish,dp match result:"+dp);
		return dp;
	}

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	private String lineToHump(String str) {
		Pattern linePattern = Pattern.compile("_(\\w)");
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	private void syncBill(String id,ChangeEvent event) {
		Asset asset4Update=Asset.create();
		asset4Update.setId(id)
				//设置变更ID
				.setChangeInstanceId(event.getInstance().getId())
				//更新状态
				.setChsStatus(event.getInstance().getStatusEnum().code())
				//更新最后审批人
				.setLatestApproverId(event.getApproverId())
				.setLatestApproverName(event.getApproverName())
				//设置下一节点审批人
				.setNextApproverIds(event.getSimpleNextApproverIds())
				.setNextApproverNames(event.getSimpleNextApproverNames())
				//更新流程概要
				.setSummary(event.getDefinition().getName()+","+event.getApproveActionEnum().text());
		//执行更新
		this.update(asset4Update,SaveMode.BESET_FIELDS);
	}


	@Override
	public JSONArray queryAssetStatusList(String owner){
		JSONArray arr=new JSONArray();
		for(CodeTextEnum en:AssetStatusEnum.values()){
			boolean fill=false;
			if(AssetOwnerCodeEnum.ASSET.code().equals(owner)){
				if(AssetStatusEnum.ALLOCATING.code().equals(en.code())
						|| AssetStatusEnum.REPAIR.code().equals(en.code())
						||AssetStatusEnum.USING.code().equals(en.code())
						||AssetStatusEnum.SCRAP.code().equals(en.code())
						||AssetStatusEnum.BORROW.code().equals(en.code())
						||AssetStatusEnum.IDLE.code().equals(en.code())
				){
					fill=true;
				}
			}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(owner)){
			}
			if(fill){
				JSONObject e=new JSONObject();
				e.put("code",en.code());
				e.put("label",en.text());
				arr.add(e);
			}
		}
		return arr;
	}


	/**
	 *  changeMap只更新不是null部分
	 * */
	public HashMap<String,List<SQL>> parseAssetChangeRecordWithChangeAssetParallel(List<Asset> assetBefore, HashMap<String, Object> changeMap,String businessCode,String operType,String notes){

		int cnt=3;
		if(assetBefore.size()<10){
			cnt=5;
		}else if(assetBefore.size()<20){
			cnt=5;
		}else if(assetBefore.size()<100){
			cnt=20;
		}else if(assetBefore.size()<200){
			cnt=50;
		}else{
			cnt=assetBefore.size()%8;
		}

		HashMap<String,List<SQL>> result=new HashMap<>();
		List<SQL> changeSqls=new ArrayList<>();
		List<SQL> updateSqls=new ArrayList<>();
		Logger.info("并行运行,并行数:"+cnt);
		SimpleJoinForkTask<Asset,Integer> task=new SimpleJoinForkTask<>(assetBefore,cnt);
		List<Integer> rvs=task.execute(els->{
			HashMap<String,List<SQL>> data=parseAssetChangeRecordWithChangeAsset(els,changeMap,businessCode,operType,notes);
			List<SQL> sqls1=data.get("change");
			List<SQL> sqls2=data.get("update");
			if(sqls1.size()>0){
				changeSqls.addAll(sqls1);
			}
			if(sqls2.size()>0){
				updateSqls.addAll(sqls1);
			}
			return null;
		});
		result.put("change",changeSqls);
		result.put("update",updateSqls);
		return result;
	}


	private HashMap<String,SQL> parseAssetChange(Asset assetBefore,JSONObject assetJsonAfter,HashMap<String,Rcd> colsMap,HashMap<String, Object> changeMap,String businessCode,String operType,String notes){
		DBTableMeta tm=dao().getTableMeta(this.table());
		DBTreaty dbTreaty= dao().getDBTreaty();
		HashMap<String,SQL> data=new HashMap<>();
		JSONObject assetJsonBefore=BeanUtil.toJSONObject(assetBefore);
		Logger.info("assetJsonBefore:\n"+assetJsonBefore);
		Logger.info("assetJsonAfter:\n"+assetJsonAfter);
		Update ups=new Update("eam_asset");
		String ct="";
		String useUserId="";
		for(String key:changeMap.keySet()){
			Rcd rcd=colsMap.get(key);
			String label=rcd.getString("label");
			String valueType=rcd.getString("value_type");
			String valuePath=rcd.getString("value_path");
			String rkey=lineToHump(key);
			String before="-";
			String after="-";


			if(AssetAttributeValueTypeEnum.ENUM.code().equals(valueType)){
				if("asset_status".equals(key)){
					if(!StringUtil.isBlank(assetJsonBefore.getString(rkey))){
						CodeTextEnum v=EnumUtil.parseByCode(AssetStatusEnum.class,assetJsonBefore.getString(rkey));
						if(v!=null){
							before=v.text();
						}
					}
					if(!StringUtil.isBlank(assetJsonAfter.getString(rkey))){
						CodeTextEnum v=EnumUtil.parseByCode(AssetStatusEnum.class,assetJsonAfter.getString(rkey));
						if(v!=null){
							after=v.text();
						}
					}
				}else if("equipment_environment_code".equals(key)){
					if(!StringUtil.isBlank(assetJsonBefore.getString(rkey))){
						CodeTextEnum v=EnumUtil.parseByCode(AssetEquipmentStatusEnum.class,assetJsonBefore.getString(rkey));
						if(v!=null){
							before=v.text();
						}
					}
					if(!StringUtil.isBlank(assetJsonAfter.getString(rkey))){
						CodeTextEnum v=EnumUtil.parseByCode(AssetEquipmentStatusEnum.class,assetJsonAfter.getString(rkey));
						if(v!=null){
							after=v.text();
						}
					}
				}else{
					continue;
				}
			}else if(AssetAttributeValueTypeEnum.ENTITY.code().equals(valueType) || AssetAttributeValueTypeEnum.DICT.code().equals(valueType) ){
				if(!StringUtil.isBlank(valuePath)){
					String[] valuePathArr=valuePath.split(",");
					if(valuePathArr.length==2){
						String entity=valuePathArr[0];
						String name=valuePathArr[1];
						if(assetJsonBefore.getJSONObject(entity)!=null){
							before=assetJsonBefore.getJSONObject(entity).getString(name);
						}
						if(assetJsonAfter.getJSONObject(entity)!=null){
							after=assetJsonAfter.getJSONObject(entity).getString(name);
						}
					}
				}
			}else if(AssetAttributeValueTypeEnum.STRING.code().equals(valueType)
					||AssetAttributeValueTypeEnum.DOUBLE.code().equals(valueType)
					||AssetAttributeValueTypeEnum.DATE.code().equals(valueType)
					||AssetAttributeValueTypeEnum.INTEGER.code().equals(valueType)
			){
				before=assetJsonBefore.getString(rkey);
				after=assetJsonAfter.getString(rkey);
			}else{
				continue;
			}

			//只更新不是null部分
			ups.setIf(key,assetJsonAfter.get(rkey));
			//  ups.setIf(key,assetAfterRcd.getOriginalValue(key));
			if( !((before+"").equals(after+"") ) ){
				if("use_user_id".equals(key)){
					useUserId=assetJsonAfter.getString("useUserId");
				}
				ct=ct+"【"+label+"】由"+before+"变更为"+after+" ";
			}

		}
		//StringUtil.isBlank(assetJsonAfter.getOrDefault("useUserId",""))?null:assetJsonAfter.getOrDefault("useUserId","");
		Logger.info("资产编号:"+assetBefore.getAssetCode()+",变更内容:"+ct);
		//开始填充数据
		if(tm.getColumn(dbTreaty.getUpdateTimeField())!=null) {
			ups.set(dbTreaty.getUpdateTimeField(),new Date());
		}
		if(tm.getColumn(dbTreaty.getUpdateUserIdField())!=null) {
			ups.set(dbTreaty.getUpdateUserIdField(), dbTreaty.getLoginUserId());
		}
		ups.where().and("id=?",assetBefore.getId());
		Insert ins=new Insert("eam_asset_process_record");
		ins.set("id",IDGenerator.getSnowflakeIdString());
		ins.setIf("asset_id",assetBefore.getId());
		ins.setIf("business_code",businessCode);
		ins.setIf("process_type",operType);
		ins.setIf("notes",notes);
		ins.setIf("content",ct);
		ins.setIf("use_user_id",StringUtil.isBlank(useUserId)?null:useUserId);
		ins.set("processd_time",new Date());
		if(tm.getColumn(dbTreaty.getCreateTimeField())!=null) {
			ins.set(dbTreaty.getCreateTimeField(),new Date());
		}
		if(tm.getColumn(dbTreaty.getCreateUserIdField())!=null) {
			ins.set(dbTreaty.getCreateUserIdField(), dbTreaty.getLoginUserId());
		}
		if(tm.getColumn(dbTreaty.getDeletedField())!=null) {
			ins.set(dbTreaty.getDeletedField(), dbTreaty.getFalseValue());
		}

		data.put("update",ups);
		data.put("change",ins);
		return data;
	}

	@Override
	public Result generateAssetCode(String codeRule,JSONObject ctl,String defaultAssetCode) {

		//不自动生产编码
		if(!operateService.queryAssetCodeAutoCreate()){
			Result<String> codeResult=new Result<>();
			codeResult.success();
			codeResult.data(StringUtil.isBlank(defaultAssetCode)?"":defaultAssetCode);
			return codeResult;
		}
		//自动生产编码
		Logger.info("ctl:"+ctl.toJSONString());
		String ownOrgId=ctl.containsKey("ownOrgId")?ctl.getString("ownOrgId"):"";
		String useOrgId=ctl.containsKey("useOrgId")?ctl.getString("useOrgId"):"";
		String categoryId=ctl.containsKey("categoryId")?ctl.getString("categoryId"):"";
		Logger.info("to generate asset code,ownOrgId:"+ownOrgId+",useOrgId:"+useOrgId+",categoryId:"+categoryId);
		//String code=IDGenerator.getSnowflakeIdString();
		if(CodeModuleEnum.EAM_ASSET_CODE.code().equals(codeRule)){
			return CodeModuleServiceProxy.api().generateCodeByData(codeRule,ownOrgId,categoryId);
		}else{
			return CodeModuleServiceProxy.api().generateCode(codeRule) ;
		}

	}


	/**
	 *  changeMap只更新不是null部分
	 * */
	@Override
	public HashMap<String,List<SQL>> parseAssetChangeRecordWithChangeAsset(List<Asset> assetBefore, HashMap<String, Object> changeMap,String businessCode,String operType,String notes){

		HashMap<String,List<SQL>> data=new HashMap<>();
		List<SQL> changeSqls=new ArrayList<>();
		List<SQL> updateSqls=new ArrayList<>();
		//获取after数据
		String changeId="";
		if(changeMap.containsKey("id")){
			changeId=changeMap.get("id").toString();
		}else{
			changeId=IDGenerator.getSnowflakeIdString();
			Insert ins=new Insert("eam_asset");
			ins.set("owner_code",AssetOwnerCodeEnum.ASSET_CHANGE_RECORD.code());
			ins.setIf("tenant_id",SessionUser.getCurrent().getActivatedTenantId());
			for(String key:changeMap.keySet()){
				ins.set(key,changeMap.get(key));
			}
			ins.set("id",changeId);
			dao.execute(ins);
		}
		Asset assetAfter=getById(changeId);
		dao.fill(assetAfter).with(AssetMeta.CATEGORY)
				.with(AssetMeta.CATEGORY_FINANCE)
				.with(AssetMeta.GOODS)
				.with(AssetMeta.MANUFACTURER)
				.with(AssetMeta.POSITION)
				.with(AssetMeta.MAINTNAINER)
				.with(AssetMeta.SUPPLIER)
				.with(AssetMeta.REGION)
				.with(AssetMeta.OWNER_COMPANY)
				.with(AssetMeta.USE_ORGANIZATION)
				.with(AssetMeta.MANAGER)
				.with(AssetMeta.USE_USER)
				.with(AssetMeta.ORIGINATOR)
				.with(AssetMeta.RACK)
				.with(AssetMeta.SOURCE)
				.with(AssetMeta.SAFETY_LEVEL)
				.with(AssetMeta.ASSET_CYCLE_STATUS)
				.with(AssetMeta.EQUIPMENT_ENVIRONMENT)
				.with(AssetMeta.ASSET_MAINTENANCE_STATUS)
				.execute();
		dao().join(assetAfter.getManager(), Person.class);
		dao().join(assetAfter.getUseUser(), Person.class);
		JSONObject assetJsonAfter=BeanUtil.toJSONObject(assetAfter);

		//获取注册的允许变更记录的字段
		String sql="select id,code,label,value_type,value_path from eam_asset_attribute where code not in ('status','business_code','batch_code') and deleted=0 and tenant_id=?";
		RcdSet rs=dao.query(sql,SessionUser.getCurrent().getActivatedTenantId());
		HashMap<String,Rcd> colsMap=(HashMap<String,Rcd>)rs.getMappedRcds("code",String.class);
		//删除不存在的
		HashMap<String, Object> rChangeMap=new HashMap<>();
		for(String key:changeMap.keySet()){
			if(colsMap.containsKey(key)){
				rChangeMap.put(key,changeMap.get(key));
			}
		}
		Logger.info("需要更新的字段列表:"+rChangeMap);
		//获取before数据

		dao.fill(assetBefore).with(AssetMeta.CATEGORY)
				.with(AssetMeta.CATEGORY_FINANCE)
				.with(AssetMeta.GOODS)
				.with(AssetMeta.MANUFACTURER)
				.with(AssetMeta.POSITION)
				.with(AssetMeta.MAINTNAINER)
				.with(AssetMeta.SUPPLIER)
				.with(AssetMeta.OWNER_COMPANY)
				.with(AssetMeta.USE_ORGANIZATION)
				.with(AssetMeta.MANAGER)
				.with(AssetMeta.USE_USER)
				.with(AssetMeta.REGION)
				.with(AssetMeta.ORIGINATOR)
				.with(AssetMeta.RACK)
				.with(AssetMeta.ASSET_CYCLE_STATUS)
				.with(AssetMeta.SOURCE)
				.with(AssetMeta.SAFETY_LEVEL)
				.with(AssetMeta.EQUIPMENT_ENVIRONMENT)
				.with(AssetMeta.ASSET_MAINTENANCE_STATUS)
				.execute();
		List<Employee> managers= CollectorUtil.collectList(assetBefore,Asset::getManager);
		dao().join(managers, Person.class);
		List<Employee> useUser= CollectorUtil.collectList(assetBefore,Asset::getUseUser);
		dao().join(useUser, Person.class);

		for(Asset asset: assetBefore){
			HashMap<String,SQL> result=parseAssetChange(asset,assetJsonAfter,colsMap,rChangeMap,businessCode,operType,notes);
			updateSqls.add(result.get("update"));
			changeSqls.add(result.get("change"));
		}
		Logger.info("update change size:"+updateSqls.size());
		for(SQL s:updateSqls){
			Logger.info(s.getSQL());
		}

		Logger.info("change change size:"+changeSqls.size());
		for(SQL s:changeSqls){
			Logger.info(s.getSQL());
		}
		data.put("change",changeSqls);
		data.put("update",updateSqls);
		return data;
	}


	@Override
	public Result startProcess(ProcessStartVO startVO) {
		Result result=new Result();
		for (String id : startVO.getBillIds()) {
			Result<ChangeEvent> r=startProcess(id);
			if(r.failure()) {
				result.addError(r);
			} else {
				// 处理逻辑
				ChangeEvent event=r.data();
				syncBill(id,event);
			}
		}
		return ErrorDesc.success();
	}


	/**
	 * 启动
	 * */
	public Result startProcess(String id) {

		//变更后数据
		Asset assetAfter=this.getById(id);
		String changeType=AssetOperateEnum.EAM_ASSET_INSERT.code();
		if(assetAfter==null) {
			return ErrorDesc.failure().message("单据不存在");
		}

		//关联订单明细
		//  this.join(assetAfter, Asset.class);
		List<String> billIds=Arrays.asList(assetAfter.getId());

		//变更前数据
		Asset assetBefore=this.getById(assetAfter.getId());
//      this.join(assetBefore, Asset.class);

		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		ChangeRequestBody requestBody=new ChangeRequestBody(changeType, ChangeType.create);


		//后续可按审批人对接待办体系
		String simpleApprovers=dao.queryRecord("select simple_approvers from chs_change_definition where code=?",changeType).getString("simple_approvers");
		if(!StringUtil.isBlank(simpleApprovers)){
			List<Assignee> appoverList=new ArrayList<>();
			JSONArray sarr=JSONArray.parseArray(simpleApprovers);
			for(int i=0;i<sarr.size();i++){
				JSONObject e=sarr.getJSONObject(i);
				String targetId=e.getString("targetId");
				String targetType=e.getString("targetType");
				if("busi_role".equals(targetType)){
					List<Assignee> bpmRoleApprovers1=assistant.getBpmRoleApproversById(targetId);
					appoverList.addAll(bpmRoleApprovers1);
				}else if("employee".equals(targetType)){
					List<Assignee> approvers1=assistant.getEmployeeApproversById(targetId);
					appoverList.addAll(approvers1);
				}
			}
			requestBody.setNextNodeAppovers(appoverList);
		}


		//设置当前提交人
		requestBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		requestBody.setApproverName(SessionUser.getCurrent().getRealName());

		//
		requestBody.setDataType(Asset.class);

		//设置变更前数据,simple审批模式仅支持单据的独立审批
		requestBody.setDataBefore(assetAfter);
		//设置变更后数据,simple审批模式仅支持单据的独立审批
		requestBody.setDataAfter(assetBefore);

		//设置审批单据号
		requestBody.setBillIds(billIds);
		//设置审批意见
		requestBody.setOpinion("启动流程");
		//发起审批

		Result result=assistant.request(requestBody);

		return result;
	}



	@Override
	public Result approve(ProcessApproveVO approveVO) {
		Result result=new Result();
		if(approveVO.getInstanceIds()==null || approveVO.getInstanceIds().isEmpty()) {
			return result.success(false).message("至少指定一个变更ID");
		}
		In in=new In(EAMTables.EAM_ASSET.CHANGE_INSTANCE_ID,approveVO.getInstanceIds());

		List<Asset> assets=this.queryList(in.toConditionExpr());
		Map<String,List<Asset>> assetsMap= CollectorUtil.groupBy(assets,Asset::getChangeInstanceId);
		for (Map.Entry<String,List<Asset>> e : assetsMap.entrySet()) {
			Result<ChangeEvent> r=this.approve(e.getKey(),e.getValue(),approveVO.getAction(),approveVO.getOpinion());
			if(r.failure()){
				result.addError(r);
			} else {
				//同步订状态
				ChangeEvent event=r.data();
				for (Asset asset : e.getValue()) {
					syncBill(asset.getId(),event);
				}
			}
		}
		return result;
	}


	public Result approve(String instanceId, List<Asset> assets, String approveAction, String opinion) {

		ApprovalAction action=ApprovalAction.parseByCode(approveAction);

		//审批数据
		if(assets==null || assets.isEmpty()) {
			return ErrorDesc.failure().message("订单不存在");
		}
		Asset asset=assets.get(0);

		ChangeApproveBody approveBody=new ChangeApproveBody(AssetOperateEnum.EAM_ASSET_INSERT.code());
		//设置变更ID
		approveBody.setChangeInstanceId(asset.getChangeInstanceId());

		//设置当前提交人
		approveBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		approveBody.setApproverName(SessionUser.getCurrent().getRealName());
		approveBody.setApprovalAction(action);

		//设置审批意见
		approveBody.setOpinion(opinion);

		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		//发起审批
		Result result= assistant.approve(approveBody);

		//审批结束
		if(!result.isSuccess()){
			return result;
		}


		//审批结束后的动作
		Asset chs=new Asset();
		chs.setId(asset.getId());
		chs.setApprovalOpinion(opinion);
		if(ApprovalAction.agree.code().equals(approveAction)){
			chs.setStatus(AssetHandleStatusEnum.COMPLETE.code());
			//applyChange(asset.getId());
		}else if(ApprovalAction.reject.code().equals(approveAction)){
			chs.setStatus(AssetHandleStatusEnum.DENY.code());
		}else if(ApprovalAction.submit.code().equals(approveAction)){
			//chs.setStatus(AssetHandleStatusEnum.APPROVAL.code());
		}

		if(chs.getStatus()!=null){
			this.update(chs,SaveMode.NOT_NULL_FIELDS);
		}
		return result;
	}

	/**
	 * @Description:生成资产标签图片
	 * @param type
	 * @param data
	 */
	private BufferedImage createAssetPic(String type, String data) {
		BarcodeFormat format = BarcodeFormat.QR_CODE;
		int w = 500;
		int h = 500;
		if ("rwm".equals(type)) {
			format = BarcodeFormat.QR_CODE;
			w = 450;
			h = 450;
		} else if ("txm".equals(type)) {
			format = BarcodeFormat.CODE_128;
			h = 180;
			w = 450;
		}
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(data, format, w, h);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		BufferedImage buffImg = MatrixToImageWriter.toBufferedImage(bitMatrix);
		return buffImg;
	}

	@Override
	public List<Map<String, Object>> getBills(List<String> ids) {
		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",ids);
		PagedList<Asset> list= super.queryPagedList(new Asset(),expr,10000,1);
		joinData(list.getList());
		List<Map<String, Object>> data=new ArrayList<>();
		for(Asset e:list){
			Map<String, Object> map= BeanUtil.toMap(e);
			if(e.getStatus()!=null){
				CodeTextEnum en= EnumUtil.parseByCode(AssetHandleStatusEnum.class,e.getStatus());
				map.put("statusName", en==null?e.getStatus():en.text());
			}
			if(e.getAssetStatus()!=null){
				CodeTextEnum en= EnumUtil.parseByCode(AssetStatusEnum.class,e.getAssetStatus());
				map.put("assetStatusName", en==null?e.getAssetStatus():en.text());
			}

			String assetCode=e.getAssetCode()==null?"null":e.getAssetCode();
			map.put("assetTxm", Pictures.ofBufferedImage(createAssetPic("txm", assetCode), PictureType.PNG).size(190,50).create());
			map.put("assetRwm", Pictures.ofBufferedImage(createAssetPic("rwm", assetCode), PictureType.PNG).size(80,100).create());
			data.add(map);
		}
		return data;
	}

	@Override
	public Result<JSONObject> queryEmployeeHaveAsset(String userId) {
		if(StringUtil.isBlank(userId)){
			return ErrorDesc.failureMessage("请输入用户ID");
		}
		Rcd userRs=dao.queryRecord("select 1 from hrm_employee where deleted=0 and id=?",userId);
		if(userRs==null){
			return ErrorDesc.failureMessage("当前用户不存在");
		}
		Result<JSONObject> result=new Result<>();
		JSONObject r=new JSONObject();
		List<Asset> list=this.queryEmployeeAsset(userId);
		boolean hasAsset=false;
		if(list!=null&&list.size()>0){
			hasAsset=true;
		}
		r.put("hasAsset",hasAsset);
		r.put("assetCount",list.size());
		r.put("asset",list);
		return result.success(true).data(r);

	}


	@Override
	public List<Asset> queryEmployeeAsset(String userId) {
		AssetVO vo=new AssetVO();
		vo.setUseUserId(userId);
		vo.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		vo.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
		List<Asset> list=this.queryList(vo);
		return list;
	}

	/**
	  * 批量撤销
	  * @param ids 主键清单
	 * @return 是否成功
	 * */
	@Override
	public Result batchRevokeOperation(List<String> ids){

		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",ids);
		expr.andIn("status",AssetHandleStatusEnum.APPROVAL.code(),AssetHandleStatusEnum.DENY.code());
		List<Asset> list=this.queryList(expr);
		if(ids.size()!=list.size()){
			return ErrorDesc.failureMessage("当前选择的资产中部分资产不满足状态要求,无法进行操作");
		}

		List<Asset> upsList=new ArrayList<>();
		for(String id:ids){
			Asset as=new Asset();
			as.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
			as.setChangeInstanceId("");
			as.setChsStatus("");
			as.setId(id);
			upsList.add(as);
		}
		return super.updateList(upsList,SaveMode.NOT_NULL_FIELDS);

	}


	/**
	 * 批量送审batchConfirmOperation
	 * @param ids 主键清单
	 * @return 是否成功
	 * */
	public Result forBatchApproval(List<String> ids){

		ChangeDefinitionVO changeDefinitionVO=new ChangeDefinitionVO();
		changeDefinitionVO.setCode(AssetOperateEnum.EAM_ASSET_INSERT.code());
		Result<List<ChangeDefinition>> changeDefinitionResult= ChangeDefinitionServiceProxy.api().queryList(changeDefinitionVO);
		if(!changeDefinitionResult.isSuccess()){
			return ErrorDesc.failureMessage("获取流程配置失败");
		}else{
			if(changeDefinitionResult.getData().size()==0){
				return ErrorDesc.failureMessage("未配置流程信息");
			}
			ChangeDefinition ChangeDefinition=changeDefinitionResult.getData().get(0);
			if(!ApprovalMode.simple.code().equals(ChangeDefinition.getMode())){
				return ErrorDesc.failureMessage("当前只支持简单流程方式");
			}
		}

		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",ids);
		expr.and("status=?",AssetHandleStatusEnum.INCOMPLETE.code());
		List<Asset> list=this.queryList(expr);
		if(ids.size()!=list.size()){
			return ErrorDesc.failureMessage("当前选择的资产中部分资产不满足状态要求");
		}

		//进行送审
		//步骤一开始启动流程
		ProcessStartVO startVO=new ProcessStartVO();
		startVO.setOpinion("启动流程");
		startVO.setBillIds(ids);
		Result startReuslt= startProcess(startVO);
		if(!startReuslt.isSuccess()) return startReuslt;

		//步骤二进入提交阶段
		ProcessApproveVO processApproveVO=new ProcessApproveVO();
		ConditionExpr expr2=new ConditionExpr();
		expr2.and("status=?",AssetHandleStatusEnum.INCOMPLETE.code());
		expr2.andIn("id",ids);
	//	expr.setParent(null);
		List<String> instances =this.queryValues(EAMTables.EAM_ASSET.CHANGE_INSTANCE_ID,String.class,expr2);
		processApproveVO.setOpinion("提交流程");
		processApproveVO.setInstanceIds(instances);
		processApproveVO.setAction(ApprovalAction.submit.code());

		Result processApproveResult=approve(processApproveVO);
		if(!processApproveResult.isSuccess()) return processApproveResult;

		List<Asset> upsList=new ArrayList<>();
		for(String id:ids){
			Asset e=new Asset();
			e.setStatus(AssetHandleStatusEnum.APPROVAL.code());
			e.setId(id);
			upsList.add(e);
		}
		super.updateList(upsList,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.success();
	}


	/**
	 * 批量确认
	 * @param ids 主键清单
	 * @return 是否成功
	 * */
	@Override
	public Result batchConfirmOperation(List<String> ids,String bussinessCode){
		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",ids);
		expr.and("status=?",AssetHandleStatusEnum.INCOMPLETE.code());
		List<Asset> list=this.queryList(expr);
		if(ids.size()!=list.size()){
			return ErrorDesc.failureMessage("当前选择的资产中部分资产不满足状态要求");
		}
		if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_INSERT.code()) ) {
			return ErrorDesc.failureMessage("当前操作选用审核,请先送审");
		}
		List<Asset> updateAssetsList=new ArrayList<>();
		List<AssetProcessRecord> insertAssetsDtl=new ArrayList<>();
		for(String id:ids){
			Asset e=new Asset();
			e.setId(id);
			e.setStatus(AssetHandleStatusEnum.COMPLETE.code());
			updateAssetsList.add(e);

			//资产明显
			AssetProcessRecord record=new AssetProcessRecord();
			record.setAssetId(id);
			record.setProcessdTime(new Date());
			record.setBusinessCode(bussinessCode);
			record.setContent("资产入库");
			record.setProcessType(AssetOperateEnum.EAM_ASSET_INSERT.code());
			insertAssetsDtl.add(record);
		}

		updateList(updateAssetsList,SaveMode.NOT_NULL_FIELDS);
		assetProcessRecordService.insertList(insertAssetsDtl);
		return ErrorDesc.success();
	}




	@Override
	public AssetExtData getExtDataById(String ownerId, String categoryId){
		HashMap<String,Object> map=new HashMap<>();
		AssetExtData extData=new AssetExtData();
		extData.setOwnerId(ownerId);
		extData.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
		List<String> ids=new ArrayList<String>();
		ids.add(ownerId);
		DataQueryVo vo=new DataQueryVo();
		vo.setCatalogId(categoryId);
		vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
		vo.setOwnerIds(ids);
		Result categoryResult=CatalogServiceProxy.api().queryData(vo);
		if(categoryResult.isSuccess()){
			JSONArray dataArr=(JSONArray)categoryResult.getData();
			if(dataArr!=null&&dataArr.size()>0){
				JSONObject dataObj=dataArr.getJSONObject(0);
				for(String key:dataObj.keySet()){
					if("id".equals(key)) extData.setId(dataObj.getString(key));
					map.put(key, dataObj.get(key));
				}
			}
			extData.setData(map);
		}else{
			return null;
		}

		return extData;

	}

	/**
	 * 插入实体
	 * @param asset 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result sourceInsert(Asset asset) {
		return super.insert(asset);
	}


	/**
	 * 插入实体
	 * @param asset 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Asset asset) {

//		if(StringUtil.isBlank(asset.getOwnerCode())){
//			asset.setOwnerCode("idle");
//		}

		//制单人
		if(StringUtil.isBlank(asset.getOriginatorId())){
			asset.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(asset.getStatus())){
			asset.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//登记日期
		if(asset.getRegisterDate()==null){
			asset.setRegisterDate(new Date());
		}


		if(asset.getNavPrice()==null){
			asset.setNavPrice(asset.getPurchaseUnitPrice());
		}

		//编码
		String codeRule="";
		if(AssetOwnerCodeEnum.ASSET.code().equals(asset.getOwnerCode())){
			codeRule=CodeModuleEnum.EAM_ASSET_CODE.code();
			asset.setAssetNumber(1);
			asset.setRemainNumber(1);

		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(asset.getOwnerCode())){
			codeRule=CodeModuleEnum.EAM_ASSET_STOCK_CODE.code();
			if(asset.getAssetNumber()<1){
				asset.setAssetNumber(1);
			}
			asset.setRemainNumber(asset.getAssetNumber());

		}else if(AssetOwnerCodeEnum.ASSET_STOCK_DISTRIBUTE.code().equals(asset.getOwnerCode())){
			codeRule=AssetOwnerCodeEnum.ASSET_STOCK_DISTRIBUTE.code();
			asset.setRemainNumber(asset.getAssetNumber());


		}else if(AssetOwnerCodeEnum.ASSET_CONSUMABLES_COLLECTION.code().equals(asset.getOwnerCode())){
			codeRule=AssetOwnerCodeEnum.ASSET_CONSUMABLES_COLLECTION.code();
			asset.setRemainNumber(asset.getAssetNumber());

		}else if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(asset.getOwnerCode())){
			codeRule=CodeModuleEnum.EAM_ASSET_CONSUMABLES_CODE.code();
			if(asset.getAssetNumber()<1) {
				asset.setAssetNumber(1);
			}
			asset.setRemainNumber(asset.getAssetNumber());

		}else if(AssetOwnerCodeEnum.ASSET_SOFTWARE.code().equals(asset.getOwnerCode())){
			codeRule=CodeModuleEnum.EAM_ASSET_SOFTWARE_CODE.code();
			if(asset.getAssetNumber()<1) asset.setAssetNumber(1);
			asset.setRemainNumber(asset.getAssetNumber());
		}


		if(StringUtil.isBlank(asset.getAssetCode())){
			if(!StringUtil.isBlank(codeRule)){
				if(!StringUtil.isBlank(codeRule)){
					JSONObject codeObject=new JSONObject();
					codeObject.put("ownOrgId",asset.getOwnCompanyId());
					codeObject.put("useOrgId",asset.getUseOrganizationId());
					codeObject.put("categoryId",asset.getCategoryId());
					Result codeResult= generateAssetCode(codeRule,codeObject,asset.getAssetCode());
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						asset.setAssetCode(codeResult.getData().toString());
					}
				}
			}
		}

		//资产状态
		if(StringUtil.isBlank(asset.getAssetStatus())){
			if(AssetOwnerCodeEnum.ASSET.code().equals(asset.getOwnerCode())
				|| AssetOwnerCodeEnum.ASSET_STOCK.code().equals(asset.getOwnerCode())
				|| AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(asset.getOwnerCode())
				|| AssetOwnerCodeEnum.ASSET_SOFTWARE.code().equals(asset.getOwnerCode())
			){
				asset.setAssetStatus(AssetStatusEnum.IDLE.code());
			}
		}

		//判断是否序列号要唯一,满足非空唯一即可
		if(AssetOwnerCodeEnum.ASSET.code().equals(asset.getOwnerCode())&& !StringUtil.isBlank(asset.getSerialNumber()) && operateService.queryAssetSerialNumberNeedUnique() ){
			if(!operateService.queryAssetSerialNumberIsUnique(asset.getSerialNumber(),null)){
				return ErrorDesc.failure().message("当前资产序列号不唯一:"+asset.getSerialNumber());
			}
		}

		//盘点数据录入,没有问题时，在转
		if(AssetInternalControlLabelTypeEnum.INVENTORY_LABEL.code().equals(asset.getInternalControlLabel())){
			asset.setStatus(AssetHandleStatusEnum.COMPLETE.code());
			asset.setOwnerCode(AssetOwnerCodeEnum.INVENTORY_ASSET.code());
		}
		Result r=super.insert(asset);
		return r;
	}



	/**
	 * 批量插入实体，事务内
	 * @param assetList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Asset> assetList) {
		return super.insertList(assetList);
	}


	/**
	 * 按主键删除 资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Asset asset = new Asset();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		asset.setId(id);
		try {
			boolean suc = dao.deleteEntity(asset);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Asset asset = new Asset();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		asset.setId(id);
		asset.setDeleted(true);
		asset.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		asset.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(asset,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新实体
	 * @param asset 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Asset asset , SaveMode mode) {
		if(!StringUtil.isBlank(asset.getAssetCode())){
			asset.setAssetCode(null);
		}



		//判断是否序列号要唯一,满足非空唯一即可
		if(AssetOwnerCodeEnum.ASSET.code().equals(asset.getOwnerCode())&& !StringUtil.isBlank(asset.getSerialNumber()) && operateService.queryAssetSerialNumberNeedUnique() ){
			if(!operateService.queryAssetSerialNumberIsUnique(asset.getSerialNumber(),asset.getId())){
				return ErrorDesc.failure().message("当前资产序列号不唯一:"+asset.getSerialNumber());
			}
		}

		Logger.info("##############set save :"+asset.getOwnCompanyId());

		Result r=super.update(asset , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Asset> assetList , SaveMode mode) {
		return super.updateList(assetList , mode);
	}


	/**
	 * 按主键更新字段 资产
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 资产
	 *
	 * @param id 主键
	 * @return Asset 数据对象
	 */
	public Asset getById(String id) {
		Asset sample = new Asset();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Asset> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Asset> queryList(Asset sample) {
		String dp=applyAssetDataPermissions(sample,null);
		if(StringUtil.isBlank(dp)){
			return super.queryList(sample);
		}else{
			return super.queryList(sample, null, null,dp);
		}
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<Asset> queryPagedList(Asset sample, int pageSize, int pageIndex) {

//		Expr select=new Expr("select * from "+table()+" t ");
//		if(sample instanceof AssetVO) {
//			AssetVO vo=(AssetVO) sample;
//			if(!StringUtil.isBlank(vo.getUseOrganizationId())) {
//				expr.and("use_organization_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+vo.getUseOrganizationId()+"/%' or id=?))",vo.getUseOrganizationId());
//				vo.setUseOrganizationId(null);
//			}
//			if(!StringUtil.isBlank(vo.getCategoryId())) {
//				expr.and("category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%/"+vo.getCategoryId()+"/%' or id=?))",vo.getCategoryId());
//				vo.setCategoryId(null);
//			}
//			if(!StringUtil.isBlank(vo.getCategoryFinance())) {
//				expr.and("category_id in (select id from eam_category_finance where deleted=0 and (concat('/',hierarchy) like '%/"+vo.getCategoryFinance()+"/%' or id=?))",vo.getCategoryFinance());
//				vo.setFinancialCategoryId(null);
//			}
//			if(!StringUtil.isBlank(vo.getOwnCompanyId())) {
//				expr.and("own_company_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+vo.getOwnCompanyId()+"/%' or id=?))",vo.getOwnCompanyId());
//				vo.setOwnCompanyId(null);
//			}
//		}

		ConditionExpr expr=new ConditionExpr();
		if(StringUtil.isBlank(sample.getOwnerCode())){
			sample.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
		}
//		if(StringUtil.isBlank(sample.getCategoryId())){
//			if(AssetOwnerCodeEnum.ASSET.code().equals(sample.getOwnerCode())){
//				sample.setCategoryId(assetDataService.queryPcmIdByCode(AssetPcmCodeEnum.ASSET.code()));
//			}
//		}
		return queryPagedList(sample, expr, pageSize, pageIndex);
	}

	public Result conditionAssetBusinessType(String businessType,String assetCodeData,ConditionExpr queryCondition){


		if(businessType!=null&&"eam_asset_inventory_employ_mode".equals(businessType)){
			//盘点的时候单独处理
			if(StringUtil.isBlank(assetCodeData)){
				assetCodeData="-1";
			}
			queryCondition.and("id not in (select asset_id from eam_inventory_asset where deleted=0 and inventory_id=?)",assetCodeData);
			return ErrorDesc.success();
		}

		AssetStatusRule assetStatusRule=assetStatusRuleService.queryEntity(AssetStatusRule.create().setOperCode(businessType).setStatus(StatusEnableEnum.ENABLE.code()));
		if(assetStatusRule!=null){
			String condition=assetStatusRule.getOperCondition();
			String tenantId=SessionUser.getCurrent().getActivatedTenantId();
			if(AssetStatusRuleConditionEnum.NOT_IN.code().equals(condition)){
				queryCondition.and("asset_status not in (select status_code from eam_asset_status_rule_v where deleted=0 and tenant_id=? and oper_code=?)",tenantId,businessType);
			}else if (AssetStatusRuleConditionEnum.IN.code().equals(condition)){
				queryCondition.and("asset_status in (select status_code from eam_asset_status_rule_v where  deleted=0 and tenant_id=? and oper_code=?)",tenantId,businessType);
			}
		}
		Logger.info("conditionAssetBusinessType|oper:"+businessType+",conditionExpr:"+queryCondition.getSQL());
		return ErrorDesc.success().data(queryCondition);
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<Asset> queryPagedList(Asset sample, ConditionExpr condition, int pageSize, int pageIndex) {

		if(StringUtil.isBlank(sample.getCategoryId())){
			if(AssetOwnerCodeEnum.ASSET.code().equals(sample.getOwnerCode())){
				sample.setCategoryId(assetDataService.queryPcmIdByCode(AssetPcmCodeEnum.ASSET.code()));
			}
		}

		if(!StringUtil.isBlank(sample.getCategoryId())) {
			condition.and("category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%/"+sample.getCategoryId()+"/%' or id=?))",sample.getCategoryId());
			sample.setCategoryId(null);
		}

		if(!StringUtil.isBlank(sample.getUseOrganizationId())) {
			condition.and("use_organization_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+sample.getUseOrganizationId()+"/%' or id=?))",sample.getUseOrganizationId());
			sample.setUseOrganizationId(null);
		}

		if(!StringUtil.isBlank(sample.getOwnCompanyId())) {
			condition.and("own_company_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+sample.getOwnCompanyId()+"/%' or id=?))",sample.getOwnCompanyId());
			sample.setOwnCompanyId(null);
		}

		if(!StringUtil.isBlank(sample.getCategoryFinance())) {
			condition.and("category_id in (select id from eam_category_finance where deleted=0 and (concat('/',hierarchy) like '%/"+sample.getCategoryFinance()+"/%' or id=?))",sample.getCategoryFinance());
			sample.setFinancialCategoryId(null);
		}
		if(!StringUtil.isBlank(sample.getPositionId())) {
			condition.and("position_id in (select id from eam_position where deleted=0 and (concat('/',hierarchy) like '%/"+sample.getPositionId()+"/%' or id=?))",sample.getPositionId());
			sample.setPositionId(null);
		}



		String dp=applyAssetDataPermissions(sample,condition);
//		ConditionExpr base=this.buildQueryCondition(sample,"t");
//		expr.and(base);
//		select.append(expr.startWithWhere()+" order by create_time desc");
//		PagedList<Asset> pagedList=this.dao().queryPagedEntities(Asset.class,pageSize,pageIndex,select);
		//修正默认排序
		AssetVO vo=(AssetVO) sample;
		if(StringUtil.isBlank(vo.getSortField()) ){
			vo.setSortField("createTime");
			vo.setSortType("desc");
		}
		if(StringUtil.isBlank(dp)){
			return super.queryPagedList(vo, condition, pageSize, pageIndex);
		}else{
			return super.queryPagedList(vo, condition, pageSize, pageIndex,dp);
		}
	}


	@Override
	public PagedList<Asset> queryPagedListBySelect(AssetVO sample,String businessType,String assetOwnerId,String assetSelectData,String assetSearchContent) {

		ConditionExpr queryCondition=new ConditionExpr();

		if(StringUtil.isBlank(sample.getOwnerCode())){
			sample.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
		}

//		if(StringUtil.isBlank(sample.getCategoryId())){
//			if(AssetOwnerCodeEnum.ASSET.code().equals(sample.getOwnerCode())){
//				sample.setCategoryId(assetDataService.queryPcmIdByCode(AssetPcmCodeEnum.ASSET.code()));
//			}
//		}


		String tabalias=this.tableAlias();
		System.out.println("tableAlias:"+tabalias);
		this.tableAlias();
		//过滤资产已选数据
		if(!StringUtil.isBlank(assetOwnerId)) {
			queryCondition.andIf(tabalias+".id not in (select asset_id from eam_asset_item where deleted=0 and handle_id=?)" ,assetOwnerId);
		}else{
			if(!StringUtil.isBlank(assetSelectData)) {
				queryCondition.andIf(tabalias+".id not in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,assetSelectData);
			}
		}

		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(sample.getOwnerCode())){
			sample.setStatus(AssetHandleStatusEnum.COMPLETE.code());
			sample.setAssetStatus(AssetStatusEnum.IDLE.code());
		}else if (AssetOwnerCodeEnum.ASSET.code().equals(sample.getOwnerCode())){
			Result r=conditionAssetBusinessType(businessType,assetSelectData,queryCondition);
			if(r.isSuccess()){
				r.getData();
			}
		}
		PagedList<Asset> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}


	@Override
	public PagedList<Asset> queryPagedListBySelected(AssetVO sample,String assetSelectData,String assetOwnerId,String dataType){

		ConditionExpr queryCondition=new ConditionExpr();
		if(assetOwnerId!=null&&assetOwnerId.length()>0){
			//实现临时快照
			if("refresh".equals(dataType)){
				dao.execute("delete from eam_asset_item where crd in ('cd','c') and handle_id=?",assetOwnerId);
				dao.execute("update eam_asset_item set crd='r' where crd='d' and handle_id=?",assetOwnerId);
			}
			queryCondition.andIf("id in (select asset_id from eam_asset_item where crd in ('c','r') and deleted=0 and handle_id=?)" ,assetOwnerId);
		}else{
			if(assetSelectData!=null&&assetSelectData.length()>0){
				queryCondition.andIf("id  in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,assetSelectData);
			}
		}
		PagedList<Asset> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}


	@Override
	public PagedList<Asset> queryPagedListByEmployeeSelected(AssetVO sample, String selectedCode, String ownerId,String dataType) {
		ConditionExpr queryCondition=new ConditionExpr();
		if(ownerId!=null&&ownerId.length()>0){
			//实现临时快照
			if("refresh".equals(dataType)){
				dao.execute("delete from eam_asset_item where crd in ('cd','c') and handle_id=?",ownerId);
				dao.execute("update eam_asset_item set crd='r' where crd='d' and handle_id=?",ownerId);
			}
			queryCondition.andIf("id in (select asset_id from eam_asset_item where crd in ('c','r') and deleted=0 and handle_id=?)" ,ownerId);
		}else{
			if(selectedCode!=null&&selectedCode.length()>0){
				queryCondition.andIf("id  in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,selectedCode);
			}
		}
		PagedList<Asset> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}

	@Override
	public PagedList<Asset> queryPagedListByEmployeeSelect(AssetVO sample, String selectedCode, String ownerId) {
		ConditionExpr queryCondition=new ConditionExpr();
		sample.setUseUserId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());

		//过滤资产已选数据
		if(!StringUtil.isBlank(ownerId)) {
			queryCondition.andIf("id not in (select asset_id from eam_asset_item where deleted=0 and handle_id=?)" ,ownerId);
		}else{
			if(!StringUtil.isBlank(selectedCode)) {
				queryCondition.andIf("id not in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,selectedCode);
			}
		}
		PagedList<Asset> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}


	/**
	 * 插入实体
	 * @param businessType 业务类型
	 * @param assetIds 资产
	 * @return 插入是否成功
	 * */
	@Override
	public Result checkAssetDataForBusinessAction(String businessType,List<String> assetIds) {
		Result result=new Result();
		ConditionExpr queryCondition=new ConditionExpr();
		queryCondition.andIn("id",assetIds);
		Result r=conditionAssetBusinessType(businessType,"",queryCondition);
		if(!r.isSuccess()){
			return r;
		}
		List<Asset> list=queryList(queryCondition);
		Logger.info("current selected asset size:"+assetIds.size());
		Logger.info("match asset size:"+list.size());
		if(list.size()!=assetIds.size()){
			return ErrorDesc.failure().message("当前选择的资产中部分状态异常");
		}
		return result;
	}



	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param asset 数据对象
	 * @return 判断结果
	 */
	public Result<Asset> checkExists(Asset asset) {
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Asset sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return null;
	}

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


	public List<ValidateResult> importData(RcdSet rs,HashMap<String,List<CatalogAttribute>> attributeMap,boolean batch,String assetOwner,boolean dataType,String selectedCode) {
		List<ValidateResult> errors=new ArrayList<>();
		DBTableMeta tm=dao().getTableMeta(this.table());
		DBTreaty dbTreaty= dao().getDBTreaty();
		List<CatalogAttribute> catalogAttribteList=new ArrayList<>();
		List<CatalogData> catalogDataList=new ArrayList<>();
		List<String> assetSerialNumberList=new ArrayList<>();
		HashMap<String,HashMap<String,String>> matchMap=new HashMap<>();
		matchMap.put("organizationMap",assetDataService.queryOrganizationNodes(""));
		matchMap.put("categoryMap",assetDataService.queryAssetCategoryNodes("all"));
		matchMap.put("eam_safety_level", assetDataService.queryDictItemDataByDictCode("eam_safety_level"));
		matchMap.put("eam_equipment_environment",assetDataService.queryDictItemDataByDictCode("eam_equipment_environment"));
		matchMap.put("eam_source",assetDataService.queryDictItemDataByDictCode("eam_source"));
		matchMap.put("eam_maintenance_status",assetDataService.queryDictItemDataByDictCode("eam_maintenance_status"));
		matchMap.put("eam_suggest_maintenance_method",assetDataService.queryDictItemDataByDictCode("eam_suggest_maintenance_method"));
		matchMap.put("eam_maintenance_method",assetDataService.queryDictItemDataByDictCode("eam_maintenance_method"));
		matchMap.put("eam_expense_items",assetDataService.queryDictItemDataByDictCode("eam_expense_items"));
		matchMap.put("eam_financial_options",assetDataService.queryDictItemDataByDictCode("eam_financial_options"));
		String pcmCategoryId=null;
		if(attributeMap.size()>0){
			Logger.info("本次资产导入为自定义模式");
			for(String key:attributeMap.keySet()){
				pcmCategoryId=key;
			}
			catalogAttribteList=attributeMap.get(pcmCategoryId);
		}else{
			Logger.info("本次资产导入为通用模式");
		}
		String actionType="update";
		String assetId="";
		List<SQL> sqls=new ArrayList<>();
		int i=0;
		for (Rcd r:rs.getRcdList()) {
			i++;
			Logger.info("before asset data:"+r);
			//判断数据是插入或更新
			if(StringUtil.isBlank(r.getString(AssetDataExportColumnEnum.ASSET_ID.text()))){
				actionType="insert";
				assetId=IDGenerator.getSnowflakeIdString();
				r.set("id",assetId);
			}else{
				actionType="update";
				assetId=r.getString(AssetDataExportColumnEnum.ASSET_ID.text());
			}
			//校验数据
			Result verifyResult=assetDataService.verifyAssetRecord(r,matchMap,dataType);
			if(!verifyResult.isSuccess()){
				errors.add(new ValidateResult(null,(i+1),verifyResult.getMessage()));
				break;
			}
			//判断资产分类是否存在
			String categoryId=r.getString(AssetDataExportColumnEnum.ASSET_CATEGORY_NAME.text());
			if(StringUtil.isBlank(categoryId)){
				errors.add(new ValidateResult(null,(i+1),"当前资产分类不存在"+r.toString()));
				break;
			}
			//判断是否序列号要唯一,满足非空唯一即可
			if(AssetOwnerCodeEnum.ASSET.code().equals(assetOwner)&&!StringUtil.isBlank(r.getString("serial_number")) && operateService.queryAssetSerialNumberNeedUnique() ){
				String sn=r.getString("serial_number");
				if(!operateService.queryAssetSerialNumberIsUnique(sn,r.getString("id"))){
					errors.add(new ValidateResult(null,(i+1),"当前资产序列号不唯一:"+sn));
					break;
				}
				if(assetSerialNumberList.contains(sn)){
					errors.add(new ValidateResult(null,(i+1),"当前资产序列号不唯一:"+sn));
					break;
				}else{
					assetSerialNumberList.add(sn);
				}
			}
			//处理自定义属性
			if(pcmCategoryId!=null){
				if(categoryId.equals(pcmCategoryId)){
					Result<CatalogData> resultExtColumn=assetDataService.verifyAssetExtColumnRecord(r,catalogAttribteList,false);
					if(resultExtColumn.isSuccess()){
						catalogDataList.add(resultExtColumn.getData());
					}else{
						errors.add(new ValidateResult(null,(i+1),resultExtColumn.getMessage()));
						break;
					}
				}else{
					errors.add(new ValidateResult(null,(i+1),"当前资产分类不匹配,categoryId:"+categoryId+",pcmCategoryId:"+pcmCategoryId));
					break;
				}
			}
			//汇总更新数据
			String sql="";
			if("insert".equals(actionType)){
				String codeRule="";
				boolean codeGen=true;
				String approvalRule="";
				if(AssetOwnerCodeEnum.ASSET.code().equals(assetOwner)){
					//如果初始化模式开始
					codeRule=CodeModuleEnum.EAM_ASSET_CODE.code();
					approvalRule=AssetOperateEnum.EAM_ASSET_INSERT.code();
					if(operateService.queryAssetImportAssetCodeKeep()){
						codeGen=false;
					}
				}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(assetOwner)){
					codeRule=CodeModuleEnum.EAM_ASSET_STOCK_CODE.code();
					approvalRule=AssetOperateEnum.EAM_ASSET_STOCK_IN.code();
				}else if(AssetOwnerCodeEnum.ASSET_SOFTWARE.code().equals(assetOwner)){
					codeRule=CodeModuleEnum.EAM_ASSET_SOFTWARE_CODE.code();
					approvalRule=AssetOperateEnum.EAM_ASSET_SOFTWARE_INSERT.code();
				}else if(AssetOwnerCodeEnum.ASSET_STORAGE.code().equals(assetOwner)){
					codeRule=CodeModuleEnum.EAM_ASSET_STORAGE.code();
					approvalRule=AssetOperateEnum.EAM_ASSET_STORAGE.code();
				}
				else{
					errors.add(new ValidateResult(null,(i+1),"资产ownerCode设置错误"));
				}
				if(codeGen){
					//自动生产自动编号
					//Result codeResult= CodeModuleServiceProxy.api().generateCode(codeRule);
					JSONObject codeObject=new JSONObject();
					codeObject.put("ownOrgId",r.getString("own_company_id") );
					codeObject.put("useOrgId",r.getString("use_organization_id"));
					codeObject.put("categoryId",r.getString("category_id"));
					Result codeResult= generateAssetCode(codeRule,codeObject,r.getString("asset_code") );
					if(!codeResult.isSuccess()){
						//返回报错
						errors.add(new ValidateResult(null,(i+1),codeResult.getMessage()));
						break;
					}else{
						r.set("asset_code",codeResult.getData().toString());
					}
				}else{
					//导入新增保持原资产编号，不生成自动编号,但是如果编号为空，则自动生成
					if(StringUtil.isBlank(r.getString("asset_code"))){
						JSONObject codeObject=new JSONObject();
						codeObject.put("ownOrgId",r.getString("own_company_id") );
						codeObject.put("useOrgId",r.getString("use_organization_id"));
						codeObject.put("categoryId",r.getString("category_id"));
						Result codeResult= generateAssetCode(codeRule,codeObject,r.getString("asset_code") );
						if(!codeResult.isSuccess()){
							//返回报错
							errors.add(new ValidateResult(null,(i+1),codeResult.getMessage()));
							break;
						}else{
							r.set("asset_code",codeResult.getData().toString());
						}
					}
				}
				//转换Rcd 到Insert
				Insert insert = SQLBuilder.buildInsert(r,this.table(),this.dao(), true);
				insert.setIf("asset_selected_data",selectedCode);
				//办理情况,新增不管是否需要审批，默认为未完成状态
//				if(operateService.approvalRequired(approvalRule) ){
//					insert.set("status",AssetHandleStatusEnum.INCOMPLETE.code());
//					//提交审批
//				}else{
//					insert.set("status",AssetHandleStatusEnum.COMPLETE.code());
//				}
				insert.set("status",AssetHandleStatusEnum.INCOMPLETE.code());
				//数量
				if (StringUtil.isBlank(r.getString("asset_number"))){
					insert.set("asset_number",1);
				}
				if (StringUtil.isBlank(r.getString("remain_number"))){
					insert.set("remain_number",1);
				}
				//登记时间
				if (StringUtil.isBlank(r.getString("register_date"))){
					insert.set("register_date",new Date());
				}
				insert.set(AssetDataExportColumnEnum.ASSET_ID.text(),assetId);
				insert.set("tenant_id",SessionUser.getCurrent().getActivatedTenantId());
				insert.set("owner_code",assetOwner);
				//制单人
				insert.set("originator_id",SessionUser.getCurrent().getUser().getActivatedEmployeeId());

				//设置创建时间
				if(tm.getColumn(dbTreaty.getCreateTimeField())!=null) {
					insert.set(dbTreaty.getCreateTimeField(),new Date());
				}
				if(tm.getColumn(dbTreaty.getCreateUserIdField())!=null) {
					insert.set(dbTreaty.getCreateUserIdField(), dbTreaty.getLoginUserId());
				}
				if(tm.getColumn(dbTreaty.getDeletedField())!=null) {
					insert.set(dbTreaty.getDeletedField(), dbTreaty.getFalseValue());
				}
				if(batch) {
					sqls.add(insert);
				} else {
					this.dao().execute(insert);
				}
				sql=insert.getSQL();
			}else{
				//办理情况
				if(r.getOwnerSet().hasColumn(AssetDataExportColumnEnum.STATUS_NAME.text())){
//                  //r.getOwnerSet().removeColumn(AssetDataExportColumnEnum.STATUS_NAME.text());
				}
				if(r.getOwnerSet().hasColumn(AssetDataExportColumnEnum.ASSET_CODE.text())){
					//r.getOwnerSet().removeColumn(AssetDataExportColumnEnum.ASSET_CODE.text());
				}
				//不允许更新资产编号
				Update update=SQLBuilder.buildUpdate(r,SaveMode.ALL_FIELDS,this.table(),this.dao());
				update.setIf("asset_selected_data",selectedCode);

				//设置创建时间
				if(tm.getColumn(dbTreaty.getUpdateTimeField())!=null) {
					update.set(dbTreaty.getUpdateTimeField(),new Date());
				}
				if(tm.getColumn(dbTreaty.getUpdateUserIdField())!=null) {
					update.set(dbTreaty.getUpdateUserIdField(), dbTreaty.getLoginUserId());
				}
				if(batch) {
					sqls.add(update);
				} else {
					this.dao().execute(update);
				}
				sql=update.getSQL();

			}
			Logger.info("after:"+r);
		}

		if(batch) {
			try {
				if(errors.size()==0){
					Logger.info("执行的数据量:"+sqls.size());
					if(sqls.size()>500){
						List<SQL> sqlList=new ArrayList<>();
						List<List<SQL>> groupList=new ArrayList<>();
						int batchCnt=0;
						for(SQL item:sqlList){
							sqlList.add(item);
							if(batchCnt>250){
								groupList.add(sqlList);
								sqlList=new ArrayList<>();
								batchCnt=0;
							}
							batchCnt++;
						}
						if(sqlList.size()>0){
							groupList.add(sqlList);
						}
						SimpleJoinForkTask<List<SQL> ,int[]> task=new SimpleJoinForkTask<>(groupList,2);
						List<int[]> rvs2=task.execute(els->{
							Logger.info(Thread.currentThread().getName());
							List<int[]> rs2=new ArrayList<>();
							for (List<SQL> list2 : els) {
								rs2.add(dao().batchExecute(list2));
							}
							return rs2;
						});
					}else{
						dao().batchExecute(sqls);
					}
					if(catalogDataList.size()>0){
						//保存自定义数据
						Logger.info("catalogDataList:"+catalogDataList);
						CatalogServiceProxy.api().saveDataList(catalogDataList);
						for(CatalogData data:catalogDataList){
							Logger.info("getId"+data.getId());
							Logger.info("getOwnerId"+data.getOwnerId());
							Logger.info("getTenantId"+data.getTenantId());
							Logger.info("getCatalogId"+data.getCatalogId());
							Logger.info("getData"+data.getData());
						}
					}
				}

			} catch (Exception e) {
				errors.add(new ValidateResult(null,3,"批量导入失败"));
				throw  e;
			}
		}
		return errors;

	}


	@Override
	public Result joinData(List<Asset> list) {
		Logger.info("asset joinData:"+list.size());
		list.removeAll(Collections.singleton(null));
		// 关联出 资产分类 数据
			dao.fill(list).with(AssetMeta.CATEGORY)
					.with(AssetMeta.GOODS)
					.with(AssetMeta.MANUFACTURER)
					.with(AssetMeta.POSITION)
					.with(AssetMeta.MAINTNAINER)
					.with(AssetMeta.SUPPLIER)
					.with(AssetMeta.OWNER_COMPANY)
					.with(AssetMeta.USE_ORGANIZATION)
					.with(AssetMeta.MANAGER)
					.with(AssetMeta.USE_USER)
					.with(AssetMeta.ORIGINATOR)
					.with(AssetMeta.RACK)
					.with(AssetMeta.SOURCE)
					.with(AssetMeta.REGION)
					.with(AssetMeta.ASSET_CYCLE_STATUS)
					.with(AssetMeta.CATEGORY_FINANCE)
					.with(AssetMeta.SAFETY_LEVEL)
					.with(AssetMeta.EQUIPMENT_ENVIRONMENT)
					.with(AssetMeta.ASSET_MAINTENANCE_STATUS)
					.with(AssetMeta.SUGGEST_MAINTENANCE_METHOD_DATA)
					.with(AssetMeta.MAINTENANCE_METHOD_DATA)
					.with(AssetMeta.EXPENSE_ITEM_DICT)
					.with(AssetMeta.FINANCIAL_OPTION_DICT)
					.with(AssetMeta.ASSET_BORROW)
					.with(AssetMeta.ASSET_COLLECTION)
					.execute();
	//		List<Employee> originators= CollectorUtil.collectList(list,Asset::getOriginator);
	//		dao().join(originators, Person.class);

			List<Employee> managers= CollectorUtil.collectList(list,Asset::getManager);
			dao().join(managers, Person.class);
			List<Employee> useUser= CollectorUtil.collectList(list,Asset::getUseUser);
			dao().join(useUser, Person.class);

		return  ErrorDesc.success();
	}


	/**
	 * 检查 角色 是否已经存在
	 * @param input 资产数据输入留对象
	 * @param sheetIndex sheet
	 * @param batch 是否批量
	 * @param assetOwner ownerCode
	 * @param dataType dataType
	 * @param code code
	 * @return 判断结果
	 */
	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch,String assetOwner,boolean dataType,String code,String selectedCode) {

		List<ValidateResult> errors=new ArrayList<>();
		ExcelReader er=null;
		try {
			er=new ExcelReader(input);
		} catch (Exception e) {
			errors.add(new ValidateResult(null,-1,"缺少文件"));
			return errors;
		}
		//构建 Excel 结构
		ExcelStructure es=buildExcelStructure(input,code);
		HashMap<String,List<CatalogAttribute>> attributeMap=this.getPcmExtAttribute(input);
		//装换成记录集
		RcdSet rs=null;
		try {
			Logger.info("sheetIndex"+sheetIndex+","+es+"ind:"+es.getColumnReadEndIndex());
			rs=er.read(sheetIndex,es);

		} catch (Exception e) {
			Logger.error("Excel 导入错误",e);
			errors.add(new ValidateResult(null,-1,"Excel 读取失败"));
			return errors;
		}
		return importData(rs, attributeMap,batch, assetOwner, dataType,selectedCode);

	}



	public InputStream buildExcelTemplate(String categoryId,String code){
		//categoryId="12";
		InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
		Workbook workbook;
		if(inputStream!=null){
			try {
				BufferedInputStream bufferInput = new ResetOnCloseInputStream(inputStream);
				workbook = WorkbookFactory.create(bufferInput);
				CellStyle cs=workbook.createCellStyle();
				cs.setAlignment(HorizontalAlignment.CENTER);
				cs.setVerticalAlignment(VerticalAlignment.CENTER);
				Sheet sheet=workbook.getSheetAt(0);
//              if("data".equals(sheet.getSheetName())){
//              }
				Row firstRow=sheet.getRow(0);
				Row secondRow=sheet.getRow(1);
				Logger.info("SheetName:"+sheet.getSheetName());
				Logger.info("firstRow lastCellNum:"+firstRow.getLastCellNum());
				Logger.info("lastSecondRow lastCellNum:"+secondRow.getLastCellNum());
				Logger.info("lastSecondRow lastCellNum Value:"+secondRow.getCell(secondRow.getLastCellNum()-1));
				if(firstRow.getLastCellNum()!=secondRow.getLastCellNum()){
					return null;
				}
				Short lastNum=firstRow.getLastCellNum();
				if(!StringUtil.isBlank(categoryId)){
					List<CatalogAttribute> catalogAttributeList = assetCategoryService.queryCatalogAttributeByAssetCategory(categoryId);
					if(catalogAttributeList.size()>0){
						//修改SheetName
						Sheet categorySheet=workbook.createSheet("attribute");
						Row categoryFirstRow=categorySheet.createRow(0);

						Cell fcCategoryBase=categoryFirstRow.createCell(0, CellType.STRING);
						fcCategoryBase.setCellValue(categoryId);
						fcCategoryBase.setCellStyle(cs);
						int i=0;
						for(i=0;i<catalogAttributeList.size();i++){

							CatalogAttribute attribute=catalogAttributeList.get(i);
							//sheet2上在category上添加标记
							Cell fcCategory=categoryFirstRow.createCell(i+1, CellType.STRING);
							fcCategory.setCellValue("pcm_ext_"+attribute.getField()+"");
							fcCategory.setCellStyle(cs);

							//sheet1 上
							Cell fc=firstRow.createCell(lastNum+i, CellType.STRING);
							fc.setCellValue(attribute.getShortName());
							fc.setCellStyle(cs);

							Cell sc=secondRow.createCell(lastNum+i, CellType.STRING);
							sc.setCellStyle(cs);
							sc.setCellValue("t.pcm_ext_"+attribute.getField());

						}
						Cell fcCategory=categoryFirstRow.createCell(i+1, CellType.STRING);
						fcCategory.setCellValue("pcm_ext_id");
						fcCategory.setCellStyle(cs);
						Cell fc=firstRow.createCell(lastNum+i, CellType.STRING);
						fc.setCellValue("自定义属性主键");
						fc.setCellStyle(cs);
						Cell sc=secondRow.createCell(lastNum+i, CellType.STRING);
						sc.setCellStyle(cs);
						sc.setCellValue("t.pcm_ext_id}}");


						//修改原标记
						Cell sourceEndColumnCell=secondRow.getCell(lastNum-1);
						sourceEndColumnCell.setCellValue(sourceEndColumnCell.getStringCellValue().replaceFirst("}}",""));

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						workbook.write(out);
						return new ByteArrayInputStream(out.toByteArray());

					}
				}

			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
			}
		}
		return inputStream;

	}

	public HashMap<String,List<CatalogAttribute>> getPcmExtAttribute(InputStream dataInputStream){
		HashMap<String,List<CatalogAttribute>> map=new HashMap<>();
		//获取自定义属性
		if(dataInputStream!=null){
			Workbook dataWorkbook;
			Sheet sheetCategory = null;
			try {
				BufferedInputStream bufferInput = new ResetOnCloseInputStream(dataInputStream);
				dataWorkbook = WorkbookFactory.create(bufferInput);
				int sheetIndex=dataWorkbook.getSheetIndex("attribute");
				if(sheetIndex<=0) {
					Logger.info("当前分类数据中未找到自定义属性数据");
				}else{
					sheetCategory=dataWorkbook.getSheetAt(sheetIndex);
					Row firstRow=sheetCategory.getRow(0);
					String categoryId=firstRow.getCell(0).getStringCellValue();
					List<CatalogAttribute> catalogAttributeList = assetCategoryService.queryCatalogAttributeByAssetCategory(categoryId);
					Logger.info("当前分类数据中自定义属性字段数量为:"+catalogAttributeList.size());
					int i=0;
					List<CatalogAttribute> list=new ArrayList<>();
					//为了保持顺序
					for(i=1;i<firstRow.getLastCellNum();i++){
						String asset_column=firstRow.getCell(i).toString();
						CatalogAttribute attri=new CatalogAttribute();
						attri.setField(asset_column);
						attri.setShortName(asset_column);
						list.add(attri);
					}
					map.put(categoryId,list);
				}
			}catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
			}
		}
		return map;
	}


	@Override
	public ExcelStructure buildExcelStructure(InputStream dataInputStream,String code) {
		InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
		ExcelStructure es=new ExcelStructure();
	//	es.setDataColumnBegin(0);
		es.setDataRowBegin(2);

		Short lastNum=0;
		//从模板获取属性
		Workbook workbook;
		if ( inputStream != null) {
			try {
				workbook = WorkbookFactory.create(inputStream);
				Sheet sheet=workbook.getSheetAt(0);
				Row firstRow=sheet.getRow(0);
				Row secondRow=sheet.getRow(1);

				lastNum=firstRow.getLastCellNum();
				String charIndex="";
				for(int i=0;i<secondRow.getLastCellNum();i++){
					String asset_column=secondRow.getCell(i).toString().replaceFirst("\\{\\{\\$fe:","")
							.replaceFirst("dataList","")
							.replaceFirst("}}","")
							.replaceFirst("t.","").trim();

					String rAssetColumn="";
					//filter
					if(AssetDataExportColumnEnum.USE_USER_NAME.code().equals(asset_column)
							||AssetDataExportColumnEnum.MANAGER_NAME.code().equals(asset_column)
							||AssetDataExportColumnEnum.STATUS_NAME.code().equals(asset_column)){
						continue;
					}

					rAssetColumn=EnumUtil.parseByCode(AssetDataExportColumnEnum.class,asset_column)==null?
							BeanNameUtil.instance().depart(asset_column):
							EnumUtil.parseByCode(AssetDataExportColumnEnum.class,asset_column).text();


					Logger.info("asset_column:"+asset_column+",rAssetColumn:"+rAssetColumn);
					charIndex=ExcelUtil.toExcel26(i);
					Logger.info("cell:"+charIndex+","+secondRow.getCell(i)  +","+ firstRow.getCell(i)+","+asset_column+","+rAssetColumn);
					Logger.info("addColumn:"+rAssetColumn+","+firstRow.getCell(i).toString()+ ","+ExcelColumn.STRING_CELL_READER);
					es.addColumn(charIndex,rAssetColumn,firstRow.getCell(i).toString(), ExcelColumn.STRING_CELL_READER);
				}
				//追加自定义属性部分
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
				return es;
			}
		}

		HashMap<String,List<CatalogAttribute>> map=getPcmExtAttribute(dataInputStream);
		Logger.info("pcm_ext_map:"+map);
		List<CatalogAttribute> list=new ArrayList<>();
		for(String key:map.keySet()){
			list=map.get(key);
			break;
		}
		String charIndex="";
		for(int i=0;i<list.size();i++){
			CatalogAttribute attribute=list.get(i);
			charIndex=ExcelUtil.toExcel26(lastNum+i);
			Logger.info(charIndex+",自定义属性:"+attribute.getShortName()+","+ attribute.getField());
			es.addColumn(charIndex,attribute.getField(),attribute.getShortName(), ExcelColumn.STRING_CELL_READER);

		}


		return es;
	}

}
