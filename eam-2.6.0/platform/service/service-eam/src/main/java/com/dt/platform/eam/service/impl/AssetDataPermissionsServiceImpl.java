package com.dt.platform.eam.service.impl;

import com.dt.platform.domain.eam.AssetDataPermissions;
import com.dt.platform.domain.eam.AssetDataPermissionsVO;
import com.dt.platform.eam.service.IAssetDataPermissionsService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资产数据权限 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-17 08:50:07
*/


@Service("EamAssetDataPermissionsService")
public class AssetDataPermissionsServiceImpl extends SuperService<AssetDataPermissions> implements IAssetDataPermissionsService {

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
	private AssetDataPermissionsPositionServiceImpl assetDataPermissionsPositionServiceImpl;
	@Autowired 
	private AssetDataPermissionsCatalogServiceImpl assetDataPermissionsCatalogServiceImpl;
	@Autowired 
	private AssetDataPermissionsOrgServiceImpl assetDataPermissionsOrgServiceImpl;
	@Autowired 
	private AssetDataPermissionsOOrgServiceImpl assetDataPermissionsOOrgServiceImpl;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetDataPermissions  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	@Transactional
	public Result insert(AssetDataPermissions assetDataPermissions,boolean throwsException) {
		Result r=super.insert(assetDataPermissions,throwsException);
		//保存关系
		if(r.success()) {
			assetDataPermissionsPositionServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getPositionIds());
			assetDataPermissionsCatalogServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getCategoryIds());
			assetDataPermissionsOrgServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getOrganizationIds());
			assetDataPermissionsOOrgServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getOwnOrganizationIds());
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetDataPermissions 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(AssetDataPermissions assetDataPermissions) {
		return this.insert(assetDataPermissions,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetDataPermissionsList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetDataPermissions> assetDataPermissionsList) {
		return super.insertList(assetDataPermissionsList);
	}

	
	/**
	 * 按主键删除 资产数据权限
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetDataPermissions assetDataPermissions = new AssetDataPermissions();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetDataPermissions.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetDataPermissions);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产数据权限
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetDataPermissions assetDataPermissions = new AssetDataPermissions();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetDataPermissions.setId(id);
		assetDataPermissions.setDeleted(true);
		assetDataPermissions.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetDataPermissions.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetDataPermissions,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetDataPermissions 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetDataPermissions assetDataPermissions , SaveMode mode) {
		return this.update(assetDataPermissions,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetDataPermissions 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetDataPermissions assetDataPermissions , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetDataPermissions , mode , throwsException);
		//保存关系
		if(r.success()) {
			assetDataPermissionsPositionServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getPositionIds());
			assetDataPermissionsCatalogServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getCategoryIds());
			assetDataPermissionsOrgServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getOrganizationIds());
			assetDataPermissionsOOrgServiceImpl.saveRelation(assetDataPermissions.getId(), assetDataPermissions.getOwnOrganizationIds());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetDataPermissionsList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetDataPermissions> assetDataPermissionsList , SaveMode mode) {
		return super.updateList(assetDataPermissionsList , mode);
	}

	
	/**
	 * 按主键更新字段 资产数据权限
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
	 * 按主键获取 资产数据权限
	 *
	 * @param id 主键
	 * @return AssetDataPermissions 数据对象
	 */
	public AssetDataPermissions getById(String id) {
		AssetDataPermissions sample = new AssetDataPermissions();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssetDataPermissions> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssetDataPermissions> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetDataPermissions> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetDataPermissions::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetDataPermissions> queryList(AssetDataPermissionsVO sample) {
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
	public PagedList<AssetDataPermissions> queryPagedList(AssetDataPermissionsVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetDataPermissions> queryPagedList(AssetDataPermissions sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetDataPermissions 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetDataPermissions assetDataPermissions) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetDataPermissions, SYS_ROLE.NAME);
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