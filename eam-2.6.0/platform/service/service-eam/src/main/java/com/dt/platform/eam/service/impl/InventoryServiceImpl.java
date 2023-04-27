package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetProcessRecord;
import com.dt.platform.domain.eam.Inventory;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.meta.InventoryAssetMeta;
import com.dt.platform.eam.service.IAssetDataService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IInventoryService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 资产盘点 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-20 12:34:49
*/


@Service("EamInventoryService")
public class InventoryServiceImpl extends SuperService<Inventory> implements IInventoryService {


	@Autowired
	InventoryAssetServiceImpl inventoryAssetService;

	@Autowired
	IAssetService assetService;


	@Autowired
	private IAssetDataService assetDataService;

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired 
	private InventoryUserServiceImpl inventoryUserServiceImpl;

	@Autowired 
	private InventoryDirectorServiceImpl inventoryDirectorServiceImpl;

	@Autowired 
	private InventoryManagerServiceImpl inventoryManagerServiceImpl;

	@Autowired
	private InventoryPositionServiceImpl inventoryPositionServiceImpl;

	@Autowired
	private InventoryWarehouseServiceImpl inventoryWarehouseServiceImpl;

	@Autowired
	private InventoryCatalogServiceImpl inventoryCatalogServiceImpl;

	@Autowired
	private InventoryAssetServiceImpl inventoryAssetServiceImpl;

	@Autowired
	private AssetProcessRecordServiceImpl assetProcessRecordServiceImpl;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param type:full_inventory_mode,employ_inventory_mode
	 * @param inventoryId 盘点单据
	 * @param assetId 盘点单据
	 * @param assetCode 盘点单据
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result<JSONObject> queryAssetByInventory(String inventoryId, String assetId, String assetCode, String type) {

		Result<JSONObject> res=new Result<>();
		if(StringUtil.isBlank(inventoryId)){
			return ErrorDesc.failureMessage("盘点单据ID为空");
		}
		if(StringUtil.isBlank(type)){
			return ErrorDesc.failureMessage("盘点类型为空");
		}
		if(StringUtil.isBlank(assetId) &&StringUtil.isBlank(assetCode)){
			return ErrorDesc.failureMessage("资产为空");
		}

		//assetId如果为空，则从assetCode获取
		String userId="";
		String managerId="";
		String assetStatus="-1";
		if(StringUtil.isBlank(assetId)){
			RcdSet rs=dao.query("select * from eam_asset where asset_code=? and owner_code='asset' and deleted=0",assetCode);
			if(rs.size()==0){
				return ErrorDesc.failureMessage("不存在该资产,资产编号:"+assetCode);
			}else if(rs.size()>1){
				return ErrorDesc.failureMessage("存在重复的资产,资产编号:"+assetCode);
			}
			assetId=rs.getRcd(0).getString("id");
			userId=rs.getRcd(0).getString("use_user_id");
			managerId=rs.getRcd(0).getString("manager_id");
			assetStatus=rs.getRcd(0).getString("asset_status","-1");
		}else{
			Rcd rs=dao.queryRecord("select * from eam_asset where id=? and owner_code='asset' and deleted=0",assetId);
			userId=rs.getString("use_user_id");
			managerId=rs.getString("manager_id");
			assetStatus=rs.getString("asset_status","-1");
			if(rs==null){
				return ErrorDesc.failureMessage("不存在该资产,资产ID:"+assetId);
			}
		}

		//盘点是否在本次盘点清单中
		Rcd inventoryAssetRs=dao.queryRecord("select * from eam_inventory_asset where deleted=0 and inventory_id=? and asset_id=?",inventoryId,assetId);
		if(inventoryAssetRs==null){
			return ErrorDesc.failureMessage("当前资产并未在本次盘点清单中");
		}

		if(AssetInventoryModeEnum.EMPLOY_INVENTORY_MODE.code().equals(type)){
			//全员盘点的情况
			String loginUserId=SessionUser.getCurrent().getActivatedEmployeeId();
			//盘点是否是行政人员
			String managerSql="select 1 from sys_busi_role a,sys_busi_role_member b where a.code='employ_inventory_manag_role' and a.id=b.role_id and a.deleted=0 and b.member_type='employee' and b.member_id=?";
			Rcd managerRs=dao.queryRecord(managerSql,loginUserId);
			if(managerRs==null){
				//普通员工盘点，盘点当前获取的资产是否是本人
				if(loginUserId.equals(userId)){
					return res.success(true).data(inventoryAssetRs.toJSONObject());
				}else{
					return ErrorDesc.failureMessage("当前用户没有权限盘点本资产");
				}
			}else{
				//行政管理人员盘点，盘点当前管理人员是否是行政人员
				String sql="select id from eam_asset where id=? and deleted=0 and manager_id=? and asset_status in (select status_code from eam_asset_status_rule_v where deleted=0 and oper_code='eam_asset_inventory_employ_mode')\n" +
						"union all\n" +
						"select id from eam_asset where deleted=0 and use_user_id=? and id=?";
				Rcd rs=dao.queryRecord(sql,assetId,loginUserId,loginUserId,assetId);
				if(rs==null){
					return ErrorDesc.failureMessage("当前用户没有权限盘点本资产");
				}else{
					return res.success(true).data(inventoryAssetRs.toJSONObject());
				}
			}
		}else if(AssetInventoryModeEnum.FULL_INVENTORY_MODE.code().equals(type)){
			return res.success(true).data(inventoryAssetRs.toJSONObject());
		}else{
			return ErrorDesc.failureMessage("盘点类型错误，当前类型:"+type);
		}

	}

	@Override
	public Map<String, Object> queryInventoryAssetMap(String inventoryId) {

		Map<String,Object> map=new HashMap<>();

		Inventory inventory=this.getById(inventoryId);
		if(inventory==null){
			return map;
		}else{
			map=BeanUtil.toMap(inventory);
			if(inventory.getInventoryStatus()!=null){
				CodeTextEnum en= EnumUtil.parseByCode(AssetInventoryActionStatusEnum.class,inventory.getInventoryStatus());
				map.put("inventoryStatusName", en==null?inventory.getInventoryStatus():en.text());
			}
			if(inventory.getAllEmployee()!=null){
				CodeTextEnum en= EnumUtil.parseByCode(StatusEnableEnum.class,inventory.getAllEmployee());
				map.put("allEmployeeEnable", en==null?inventory.getAllEmployee():en.text());
			}
		}

		HashMap<String,String> orgMap=assetDataService.queryOrganizationNodes("");
		HashMap<String,String> categoryMap=assetDataService.queryAssetCategoryNodes("");

		InventoryAsset inventoryAssetQuery=new InventoryAsset();
		inventoryAssetQuery.setInventoryId(inventoryId);

		List<InventoryAsset> list=inventoryAssetServiceImpl.queryList(inventoryAssetQuery);

		// join 关联的对象
		inventoryAssetService.dao().fill(list).with(InventoryAssetMeta.OPERATER).with(InventoryAssetMeta.ASSET).execute();

		List<Employee> operList = CollectorUtil.collectList(list, InventoryAsset::getOperater);
		inventoryAssetService.dao().join(operList, Person.class);

		List<Asset> assetList = CollectorUtil.collectList(list, InventoryAsset::getAsset);
		assetService.joinData(assetList);


		map.put("assetList",list);

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++){
			InventoryAsset assetItem=list.get(i);
			Map<String, Object> assetMap= BeanUtil.toMap(assetItem);
			if(assetItem.getStatus()!=null){
				CodeTextEnum statusName= EnumUtil.parseByCode(AssetInventoryDetailStatusEnum.class,assetItem.getStatus());
				assetMap.put("statusName",statusName.text());
			}


			if(assetItem.getOperater()!=null){
				assetMap.put("assetWithOperUserNameAndBadge",assetItem.getOperater().getNameAndBadge());
				assetMap.put("assetWithOperUserName",assetItem.getOperater().getName());
				assetMap.put("assetWithOperUserBadge",assetItem.getOperater().getBadge());
			}


			if(assetItem.getAsset()!=null){
				Asset asset=assetItem.getAsset();
				//资产状态
				if(asset.getAssetCycleStatus()!=null){
					assetMap.put("assetWithAssetStatusName",asset.getAssetCycleStatus().getName());
				}
				assetMap.put("assetWithAssetCode",asset.getAssetCode());
				assetMap.put("assetWithAssetSerialNumber",asset.getSerialNumber());
				assetMap.put("assetWithAssetName",asset.getName());
				assetMap.put("assetWithAssetModel",asset.getModel());
				assetMap.put("assetWithAssetNotes",asset.getAssetNotes());
				String categoryName=categoryMap.get(asset.getCategoryId());
				assetMap.put("assetWithAssetCategoryName",categoryName);
				String companyName=orgMap.get(asset.getOwnCompanyId());
				assetMap.put("assetWithOwnCompanyName",companyName);
				String orgName=orgMap.get(asset.getUseOrganizationId());
				assetMap.put("assetWithUseOrganizationName",orgName);
//				CodeTextEnum vStatus= EnumUtil.parseByCode(AssetHandleStatusEnum.class,asset.getStatus());
//				assetMap.put("assetWithAssetStatusName",vStatus==null?"":vStatus.text());
				if(asset.getPosition()!=null){
					// 关联出 存放位置 数据
					assetMap.put("assetWithAssetPositionName",asset.getPosition().getHierarchyName());
				}
				if(asset.getManager()!=null){

					assetMap.put("assetWithManagerNameAndBadge",asset.getManager().getNameAndBadge());
					assetMap.put("assetWithManagerName",asset.getManager().getName());
					assetMap.put("assetWithManagerBadge",asset.getManager().getBadge());
				}
				if(asset.getUseUser()!=null){

					assetMap.put("assetWithUseUserNameAndBadge",asset.getUseUser().getNameAndBadge());
					assetMap.put("assetWithUseUserName",asset.getUseUser().getName());
					assetMap.put("assetWithUseUserNameBadge",asset.getUseUser().getBadge());
				}
			}
			listMap.add(assetMap);
		}
		map.put("dataList", listMap);

		return map;
	}

	@Override
	public Map<String, Object> getBill(String inventroyId) {
		return queryInventoryAssetMap(inventroyId);
	}


	@Override
	public Result DownLoadAsset(String inventroyId) {

		return null;
	}

	@Override
	public Result assetPlusData(String inventroyId, String assetId) {
		InventoryAsset inventoryAsset=new InventoryAsset();
		inventoryAsset.setAssetId(assetId);
		inventoryAsset.setOperEmplId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		inventoryAsset.setOperDate(new Date());
		inventoryAsset.setInventoryId(inventroyId);
		inventoryAsset.setStatus(AssetInventoryDetailStatusEnum.SURPLUS.code());
		inventoryAsset.setFlag(AssetInventoryDetailStatusEnum.SURPLUS.code());
		inventoryAsset.setSource(AssetInventoryDetailDataSourceEnum.ASSET_PLUS.code());
		inventoryAssetServiceImpl.insert(inventoryAsset,false);
		return ErrorDesc.success();
	}

	@Override
	public PagedList<Inventory> queryByEmployeeModePagedList(Inventory sample,int pageSize,int pageIndex) {
		sample.setAllEmployee(StatusEnableEnum.ENABLE.code());
		return this.queryPagedList(sample,pageSize,pageIndex);
	}

	/** 全员盘点搜索数据逻辑，我的盘点接口 */
	@Override
	public PagedList<InventoryAsset> queryMyAssetByEmployeeModePagedList(InventoryAsset sample,int pageSize,int pageIndex) {
		//全员盘点
		String inventoryId=sample.getInventoryId();
		if(StringUtil.isBlank(sample.getInventoryId())){
			sample.setInventoryId("-1");
		}
		ConditionExpr expr=new ConditionExpr();
		String curUserId=SessionUser.getCurrent().getUser().getActivatedEmployeeId();
		expr.and(" asset_id in (select id from eam_asset where deleted=0)");

		//盘点是否是行政人员
		String managerSql="select 1 from sys_busi_role a,sys_busi_role_member b where a.code='employ_inventory_manag_role' and a.id=b.role_id and a.deleted=0 and b.member_type='employee' and b.member_id=?";
		Rcd managerRs=dao.queryRecord(managerSql,curUserId);
		if(managerRs==null){
			Logger.info("普通员工盘点查询");
			//普通员工盘点，盘点当前获取的资产是否是本人
			expr.and("asset_id in (select id from eam_asset where deleted=0 and use_user_id=?)",curUserId);
		}else{
			//行政管理人员盘点，盘点当前管理人员是否是行政人员，并且资产状态为idle
			Logger.info("管理人员盘点查询");
			String sql="select id from eam_asset where deleted=0 and manager_id=? and asset_status in (select status_code from eam_asset_status_rule_v where deleted=0 and oper_code='eam_asset_inventory_employ_mode')\n" +
					"union all\n" +
					"select id from eam_asset where deleted=0 and use_user_id=?";
			expr.and("asset_id in ("+sql+")",curUserId,curUserId);

		}
		return inventoryAssetService.queryPagedList(sample,expr,pageSize,pageIndex);
	}

	@Override
	public PagedList<Asset> queryAssetByEmployeeModePagedList(String inventoryId) {
		return null;
	}

	@Override
	public Result createAssetRecord(String id) {
		Inventory inventory=this.getById(id);
		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		dao.execute("delete from eam_inventory_asset where inventory_id=?",id);
		String sql="insert into eam_inventory_asset (id,inventory_id,status,asset_id,create_time)" +
				"select uuid(),'"+id+"','"+AssetInventoryDetailStatusEnum.NOT_COUNTED.code()+"',id,now() from eam_asset where deleted=0 and tenant_id='"+tenantId+"' and owner_code='"+inventory.getType()+"' and status='"+AssetHandleStatusEnum.COMPLETE.code()+"' ";
		//资产状态
		sql=sql+" and clean_out='0'";
		if(!StringUtil.isBlank(inventory.getAssetStatus())) {
			String[] statusArr=inventory.getAssetStatus().split(",");
			String s="";
			for(int i=0;i<statusArr.length;i++){
				if(i==0){
					s="'"+statusArr[i]+"'";}
				else{
					s=s+",'"+statusArr[i]+"'";
				}
			}
			sql=sql+" and asset_status in ("+s+")";
		}
		//购置时间
		//开始时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date purchaseStartDate= inventory.getPurchaseStartDate();
		if(purchaseStartDate!=null){
			sql=sql+" and purchase_date>'"+sdf1.format(purchaseStartDate)+"'";
		}

		//结束时间
		Date purchaseEndDate= inventory.getPurchaseEndDate();
		if(purchaseEndDate!=null){
			sql=sql+" and purchase_date<'"+sdf1.format(purchaseEndDate)+"'";
		}

		//管理人员
		String csql1="select count(1) cnt from eam_inventory_manager where inventory_id=? and deleted=0 and user_id is not null and user_id<>''";
		if(dao.queryRecord(csql1,id).getInteger("cnt")>0){
			sql=sql+" and manager_id in (select user_id from eam_inventory_manager where inventory_id='"+id+"' and deleted=0 and user_id is not null and user_id<>''  )";
		}

		//位置
		String csql2="select count(1) cnt from eam_inventory_position where inventory_id=? and deleted=0 and value is not null and value<>''";
		if(dao.queryRecord(csql2,id).getInteger("cnt")>0){
			sql=sql+" and position_id in (select value from eam_inventory_position where inventory_id='"+id+"' and deleted=0 and value is not null and value<>'')";
		}

		//仓库
		String csql3="select count(1) cnt from eam_inventory_warehouse where inventory_id=? and deleted=0 and value is not null and value<>''";
		if(dao.queryRecord(csql3,id).getInteger("cnt")>0){
			sql=sql+" and warehouse_id in (select value from eam_inventory_warehouse where inventory_id='"+id+"' and deleted=0 and value is not null and value<>'')";
		}

		//资产分类
		String csql4="select count(1) cnt from eam_inventory_catalog where inventory_id=? and deleted=0 and value is not null and value<>''";
		if(dao.queryRecord(csql4,id).getInteger("cnt")>0){
			sql=sql+" and category_id in (select value from eam_inventory_catalog where inventory_id='"+id+"' and deleted=0 and value is not null and value<>'')";
		}

		//所属公司
		String companyId=inventory.getOwnCompanyId();
		if(!StringUtil.isBlank(companyId)){
			String[] companyIdArr=companyId.split(",");
			if(companyIdArr.length>0){
				String subsql="(";
				for(int i=0;i<companyIdArr.length;i++){
					if(i==0){
						subsql=subsql+"'"+companyIdArr[i]+"'";
					}else{
						subsql=subsql+",'"+companyIdArr[i]+"'";
					}
				}
				subsql=subsql+")";
				sql=sql+ " and own_company_id in " +subsql;
			}
		}


		//使用部门
		String orgId=inventory.getUseOrganizationId();
		if(!StringUtil.isBlank(orgId)){
			String[] orgIdArr=orgId.split(",");
			if(orgIdArr.length>0){
				String subsql="(";
				for(int i=0;i<orgIdArr.length;i++){
					if(i==0){
						subsql=subsql+"'"+orgIdArr[i]+"'";
					}else{
						subsql=subsql+",'"+orgIdArr[i]+"'";
					}
				}
				subsql=subsql+")";
				sql=sql+ " and use_organization_id in " +subsql;
			}
		}

		Logger.info("盘点初始化获取资产数据SQL\n"+sql);
		dao.execute(sql);
		return ErrorDesc.success();
	}



	@Override
	public Result start(String id) {
		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.NOT_START.code().equals(inventory.getInventoryStatus())
		){
			Result r=createAssetRecord(id);
			if(!r.success()){
				return r;
			}
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.ACTING.code());
			inventory.setStartTime(new Date());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


	}

	@Override
	public Result cancel(String id) {
		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.NOT_START.code().equals(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.CANCEL.code());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}
	}

	@Override
	public Result finish(String id) {
		InventoryAsset q=new InventoryAsset();
		q.setInventoryId(id);
		q.setStatus(AssetInventoryDetailStatusEnum.NOT_COUNTED.code());
		if(inventoryAssetServiceImpl.queryList(q).size()>0){
			return ErrorDesc.failure().message("资产未盘点完，不能进行结束操作!");
		}

		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.ACTING.code().equals(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.FINISH.code());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}
	}

	@Override
	public Result dataSync(String id) {
		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.FINISH.code().equals(inventory.getInventoryStatus())
			&&AssetInventoryDataStatusEnum.NOT_SYNC.code().equals(inventory.getDataStatus())) {

			InventoryAsset q=new InventoryAsset();
			q.setInventoryId(id);
			List<InventoryAsset> inventoryAssetList=inventoryAssetServiceImpl.queryList(q);

			if(inventoryAssetList.size()>0){
				List<AssetProcessRecord> rcdsList=new ArrayList<>();
				for(int i=0;i<inventoryAssetList.size();i++){
					AssetProcessRecord r=new AssetProcessRecord();
					r.setAssetId(inventoryAssetList.get(i).getAssetId());
					r.setBusinessCode(inventory.getBusinessCode());
					r.setProcessdTime(new Date());
					r.setProcessType(AssetOperateEnum.EAM_ASSET_INVENTORY.code());
					r.setContent("盘点操作结束 "+inventoryAssetList.get(i).getNotes());
					rcdsList.add(r);
				}
				assetProcessRecordServiceImpl.insertList(rcdsList);
			}

			//追加的盘赢数据
			dao.execute("update eam_asset set owner_code='asset' where owner_code='inventory_asset' and id in (select asset_id from eam_inventory_asset where deleted=0 and source='asset_plus' and inventory_id=?)",id);
			//更新核对时间
			dao.execute("update eam_inventory set data_status='"+AssetInventoryDataStatusEnum.SYNC.code()+"' where id=?",id);
			dao.execute("update eam_asset set last_verification_date=now() where id in (select  asset_id from eam_inventory_asset where deleted=0 and inventory_id=?)",id);


		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


		return ErrorDesc.success();
	}

	@Override
	public Result inventoryAsset(String id,String assetId, String action,String notes) {
		Inventory inventory=this.getById(id);
		if(!AssetInventoryActionStatusEnum.ACTING.code().equals(inventory.getInventoryStatus()) ) {
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}

		InventoryAsset q=new InventoryAsset();
		q.setInventoryId(id);
		q.setAssetId(assetId);
		InventoryAsset inventoryAsset=inventoryAssetServiceImpl.queryEntity(q);
		inventoryAsset.setStatus(action);
		inventoryAsset.setNotes(notes);
		inventoryAsset.setOperEmplId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		inventoryAsset.setOperDate(new Date());
		return inventoryAssetServiceImpl.update(inventoryAsset,SaveMode.NOT_NULL_FIELDS);

	}



	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param inventory  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	@Transactional
	public Result insert(Inventory inventory,boolean throwsException) {

		if(StringUtil.isBlank(inventory.getType())){
			inventory.setType(AssetOwnerCodeEnum.ASSET.code());
		}

		if(StringUtil.isBlank(inventory.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INVENTORY.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				inventory.setBusinessCode(codeResult.getData().toString());
			}
		}

		if(StringUtil.isBlank(inventory.getStatus())){
			inventory.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		}
		if(StringUtil.isBlank(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.NOT_START.code());
		}

		if(StringUtil.isBlank(inventory.getDataStatus())){
			inventory.setDataStatus(AssetInventoryDataStatusEnum.NOT_SYNC.code());
		}

		if(StringUtil.isBlank(inventory.getOriginatorId())){
			inventory.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		if(StringUtil.isBlank(inventory.getBusinessDate())){
			inventory.setBusinessDate(new Date());
		}



		Result r=super.insert(inventory,throwsException);
		//保存关系
		if(r.success()) {
			inventoryUserServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryUserIds());
			inventoryDirectorServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryDirectorIds());
			inventoryManagerServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryManagerIds());
			inventoryPositionServiceImpl.saveRelation(inventory.getId(), inventory.getPositionIds());
			inventoryWarehouseServiceImpl.saveRelation(inventory.getId(), inventory.getWarehouseIds());
			inventoryCatalogServiceImpl.saveRelation(inventory.getId(), inventory.getCategoryIds());
		}

		//this.createAssetRecord(inventory.getId());
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inventory 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(Inventory inventory) {
		return this.insert(inventory,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inventoryList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Inventory> inventoryList) {
		return super.insertList(inventoryList);
	}

	
	/**
	 * 按主键删除 资产盘点
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Inventory inventory = new Inventory();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inventory.setId(id);
		try {
			boolean suc = dao.deleteEntity(inventory);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产盘点
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {

		Inventory inventoryData=this.getById(id);
		if(AssetInventoryActionStatusEnum.FINISH.code().equals(inventoryData.getInventoryStatus())
		||AssetInventoryActionStatusEnum.ACTING.code().equals(inventoryData.getInventoryStatus())
		){
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


		Inventory inventory = new Inventory();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inventory.setId(id);
		inventory.setDeleted(true);
		inventory.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inventory.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inventory,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param inventory 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Inventory inventory , SaveMode mode) {
		return this.update(inventory,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inventory 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Inventory inventory , SaveMode mode,boolean throwsException) {
		Result r=super.update(inventory , mode , throwsException);
		//保存关系
		if(r.success()) {
			inventoryUserServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryUserIds());
			inventoryDirectorServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryDirectorIds());
			inventoryManagerServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryManagerIds());
			inventoryPositionServiceImpl.saveRelation(inventory.getId(), inventory.getPositionIds());
			inventoryWarehouseServiceImpl.saveRelation(inventory.getId(), inventory.getWarehouseIds());
			inventoryCatalogServiceImpl.saveRelation(inventory.getId(), inventory.getCategoryIds());

		}
		//this.createAssetRecord(inventory.getId());
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param inventoryList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Inventory> inventoryList , SaveMode mode) {
		return super.updateList(inventoryList , mode);

	}

	
	/**
	 * 按主键更新字段 资产盘点
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
	 * 按主键获取 资产盘点
	 *
	 * @param id 主键
	 * @return Inventory 数据对象
	 */
	public Inventory getById(String id) {
		Inventory sample = new Inventory();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Inventory> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Inventory> queryList(Inventory sample) {
		return super.queryList(sample);
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
	public PagedList<Inventory> queryPagedList(Inventory sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
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
	public PagedList<Inventory> queryPagedList(Inventory sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param inventory 数据对象
	 * @return 判断结果
	 */
	public Result<Inventory> checkExists(Inventory inventory) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(inventory, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Inventory sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
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

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
