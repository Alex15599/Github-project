package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.eam.AssetMaintenanceRecordBatchUpdateTypeEnum;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.AssetMaintenanceRecordU;
import com.dt.platform.domain.eam.AssetMaintenanceRecordUVO;
import com.dt.platform.eam.service.IAssetItemService;
import com.dt.platform.eam.service.IAssetMaintenanceRecordUService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维保更新记录服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 13:54:09
*/


@Service("EamAssetMaintenanceRecordUService")
public class AssetMaintenanceRecordUServiceImpl extends SuperService<AssetMaintenanceRecordU> implements IAssetMaintenanceRecordUService {

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
	private IAssetItemService assetItemService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetMaintenanceRecordU  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetMaintenanceRecordU assetMaintenanceRecordU,boolean throwsException) {

		if(StringUtil.isBlank(assetMaintenanceRecordU.getMaintenanceUpdateId())){
			return ErrorDesc.failureMessage("maintenanceUpdateId参数未设置");
		}

		List<String> recordIdList=new ArrayList<>();
		if(assetMaintenanceRecordU.getRecordIdList()!=null&&assetMaintenanceRecordU.getRecordIdList().size()>0){
			recordIdList=assetMaintenanceRecordU.getRecordIdList();
		}


		Result r=super.insert(assetMaintenanceRecordU,throwsException);

		String updateId=assetMaintenanceRecordU.getMaintenanceUpdateId();
		String id=assetMaintenanceRecordU.getId();

		if(recordIdList.size()>0){
			for(String rId:recordIdList){
				AssetItem item=new AssetItem();
				item.setHandleId(id);
				item.setAssetId(rId);
				assetItemService.insert(item);
			}
		}

		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintainerId())){
			dao.execute("update eam_asset_maintenance_record a set a.maintainer_id=(select maintainer_id from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintainerId())){
			dao.execute("update eam_asset_maintenance_record a set a.maintainer_id=(select maintainer_id from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintainerId())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintainer_id=(select s_maintainer_id from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintainerId())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintainer_id=(select s_maintainer_id from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}


		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintainerName())){
			dao.execute("update eam_asset_maintenance_record a set a.maintainer_name=(select maintainer_name from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintainerName())){
			dao.execute("update eam_asset_maintenance_record a set a.maintainer_name=(select maintainer_name from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintainerName())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintainer_name=(select s_maintainer_name from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintainerName())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintainer_name=(select s_maintainer_name from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}


		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintenanceStatus())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_status=(select maintenance_status from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintenanceStatus())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_status=(select maintenance_status from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintenanceStatus())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_status=(select s_maintenance_status from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintenanceStatus())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_status=(select s_maintenance_status from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}


		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_method=(select maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_method=(select maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_method=(select s_maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_method=(select s_maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}

		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSuggestMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.suggest_maintenance_method=(select suggest_maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSuggestMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.suggest_maintenance_method=(select suggest_maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSSuggestMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.s_suggest_maintenance_method=(select s_suggest_maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSSuggestMaintenanceMethod())){
			dao.execute("update eam_asset_maintenance_record a set a.s_suggest_maintenance_method=(select s_suggest_maintenance_method from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=? and id in (select asset_id from eam_asset_item where handle_id=?)",id,updateId,id);
		}


		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUContacts())){
			dao.execute("update eam_asset_maintenance_record a set a.contacts=(select contacts from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUContacts())){
			dao.execute("update eam_asset_maintenance_record a set a.contacts=(select contacts from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSContacts())){
			dao.execute("update eam_asset_maintenance_record a set a.s_contacts=(select s_contacts from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSContacts())){
			dao.execute("update eam_asset_maintenance_record a set a.s_contacts=(select s_contacts from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}

		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUDirector())){
			dao.execute("update eam_asset_maintenance_record a set a.director=(select director from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUDirector())){
			dao.execute("update eam_asset_maintenance_record a set a.director=(select director from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSDirector())){
			dao.execute("update eam_asset_maintenance_record a set a.s_director=(select s_director from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSDirector())){
			dao.execute("update eam_asset_maintenance_record a set a.s_director=(select s_director from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}

		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUContactInformation())){
			dao.execute("update eam_asset_maintenance_record a set a.contact_information=(select contact_information from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUContactInformation())){
			dao.execute("update eam_asset_maintenance_record a set a.contact_information=(select contact_information from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSContactInformation())){
			dao.execute("update eam_asset_maintenance_record a set a.s_contact_information=(select s_contact_information from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSContactInformation())){
			dao.execute("update eam_asset_maintenance_record a set a.s_contact_information=(select s_contact_information from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}

		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintenanceNotes())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_notes=(select maintenance_notes from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintenanceNotes())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_notes=(select maintenance_notes from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintenanceNotes())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_notes=(select s_maintenance_notes from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintenanceNotes())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_notes=(select s_maintenance_notes from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}

		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintenanceStartDate())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_start_date=(select maintenance_start_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintenanceStartDate())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_start_date=(select maintenance_start_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintenanceStartDate())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_start_date=(select s_maintenance_start_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintenanceStartDate())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_start_date=(select s_maintenance_start_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}


		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUMaintenanceEndDate())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_end_date=(select maintenance_end_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUMaintenanceEndDate())){
			dao.execute("update eam_asset_maintenance_record a set a.maintenance_end_date=(select maintenance_end_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}
		if(AssetMaintenanceRecordBatchUpdateTypeEnum.ALL.code().equals(assetMaintenanceRecordU.getUSMaintenanceEndDate())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_end_date=(select s_maintenance_end_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}else if(recordIdList.size()>0&&AssetMaintenanceRecordBatchUpdateTypeEnum.SELECTED.code().equals(assetMaintenanceRecordU.getUSMaintenanceEndDate())){
			dao.execute("update eam_asset_maintenance_record a set a.s_maintenance_end_date=(select s_maintenance_end_date from eam_asset_maintenance_record_u where id=?) where maintenance_update_id=?",id,updateId);
		}


		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetMaintenanceRecordU 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetMaintenanceRecordU assetMaintenanceRecordU) {
		return this.insert(assetMaintenanceRecordU,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetMaintenanceRecordUList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetMaintenanceRecordU> assetMaintenanceRecordUList) {
		return super.insertList(assetMaintenanceRecordUList);
	}

	
	/**
	 * 按主键删除维保更新记录
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetMaintenanceRecordU assetMaintenanceRecordU = new AssetMaintenanceRecordU();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetMaintenanceRecordU.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetMaintenanceRecordU);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除维保更新记录
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetMaintenanceRecordU assetMaintenanceRecordU = new AssetMaintenanceRecordU();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetMaintenanceRecordU.setId(id);
		assetMaintenanceRecordU.setDeleted(true);
		assetMaintenanceRecordU.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetMaintenanceRecordU.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetMaintenanceRecordU,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetMaintenanceRecordU 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetMaintenanceRecordU assetMaintenanceRecordU , SaveMode mode) {
		return this.update(assetMaintenanceRecordU,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetMaintenanceRecordU 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetMaintenanceRecordU assetMaintenanceRecordU , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetMaintenanceRecordU , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetMaintenanceRecordUList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetMaintenanceRecordU> assetMaintenanceRecordUList , SaveMode mode) {
		return super.updateList(assetMaintenanceRecordUList , mode);
	}

	
	/**
	 * 按主键更新维保更新记录
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
	 * 按主键获取维保更新记录
	 *
	 * @param id 主键
	 * @return AssetMaintenanceRecordU 数据对象
	 */
	public AssetMaintenanceRecordU getById(String id) {
		AssetMaintenanceRecordU sample = new AssetMaintenanceRecordU();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssetMaintenanceRecordU> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssetMaintenanceRecordU> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetMaintenanceRecordU> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetMaintenanceRecordU::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetMaintenanceRecordU> queryList(AssetMaintenanceRecordUVO sample) {
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
	public PagedList<AssetMaintenanceRecordU> queryPagedList(AssetMaintenanceRecordUVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetMaintenanceRecordU> queryPagedList(AssetMaintenanceRecordU sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetMaintenanceRecordU 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetMaintenanceRecordU assetMaintenanceRecordU) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetMaintenanceRecordU, SYS_ROLE.NAME);
		//return exists;
		return false;
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






}