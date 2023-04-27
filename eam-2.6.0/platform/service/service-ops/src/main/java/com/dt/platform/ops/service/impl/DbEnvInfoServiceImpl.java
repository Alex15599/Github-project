package com.dt.platform.ops.service.impl;

import javax.annotation.Resource;

import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.ops.service.ICiphertextBoxDataService;
import com.dt.platform.ops.service.ICiphertextBoxService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;

import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.ops.DbEnvInfo;
import com.dt.platform.domain.ops.DbEnvInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.ops.service.IDbEnvInfoService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 数据库环境服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-14 06:01:00
*/


@Service("OpsDbEnvInfoService")
public class DbEnvInfoServiceImpl extends SuperService<DbEnvInfo> implements IDbEnvInfoService {

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
	private ICiphertextBoxDataService ciphertextBoxDataService;


	@Autowired
	private ICiphertextBoxService ciphertextBoxService;



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param dbEnvInfo  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(DbEnvInfo dbEnvInfo,boolean throwsException) {
		String voucher=dbEnvInfo.getVoucher();
		dbEnvInfo.setVoucher("");
		Result r=super.insert(dbEnvInfo,throwsException);
		if(r.isSuccess()){

			//凭证保存密文，只有当首次没有密文时，才生效
			if(!StringUtil.isBlank(voucher)){
				//密文箱是否已存在
				if(dao.queryRecord("select 1 from ops_ciphertext_box_data where deleted=0 and box_type='database_instance_other' and source_id=?",dbEnvInfo.getId())==null){
					//密码箱没有密文数据，首次保存
					CiphertextBoxData box=new CiphertextBoxData();
					box.setBoxType("database_instance_other");
					box.setSourceId(dbEnvInfo.getId());
					box.setPlaintext(voucher);
					ciphertextBoxDataService.insert(box,false);
					Logger.info("密码箱没有密文数据，首次保存");
				}else{
					Logger.info("密码箱已有密文数据，不在保存");
				}
			}
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param dbEnvInfo 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(DbEnvInfo dbEnvInfo) {
		return this.insert(dbEnvInfo,true);



	}

	/**
	 * 批量插入实体，事务内
	 * @param dbEnvInfoList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<DbEnvInfo> dbEnvInfoList) {
		return super.insertList(dbEnvInfoList);
	}

	
	/**
	 * 按主键删除数据库环境
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		DbEnvInfo dbEnvInfo = new DbEnvInfo();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		dbEnvInfo.setId(id);
		try {
			boolean suc = dao.deleteEntity(dbEnvInfo);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除数据库环境
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		DbEnvInfo dbEnvInfo = new DbEnvInfo();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		dbEnvInfo.setId(id);
		dbEnvInfo.setDeleted(true);
		dbEnvInfo.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		dbEnvInfo.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(dbEnvInfo,SaveMode.NOT_NULL_FIELDS);
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
	 * @param dbEnvInfo 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DbEnvInfo dbEnvInfo , SaveMode mode) {

		return this.update(dbEnvInfo,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param dbEnvInfo 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DbEnvInfo dbEnvInfo , SaveMode mode,boolean throwsException) {
		String voucher=dbEnvInfo.getVoucher();
		dbEnvInfo.setVoucher("");
		if(StringUtil.isBlank(dbEnvInfo.getDbInstId())||"null".equals(dbEnvInfo.getDbInstId())){
			dbEnvInfo.setDbInstId(this.getById(dbEnvInfo.getId()).getDbInstId());
		}
		Result r=super.update(dbEnvInfo , mode , throwsException);

		if(r.isSuccess()){
			//凭证保存密文，只有当首次没有密文时，才生效
			if(!StringUtil.isBlank(voucher)){
				Rcd rs=dao.queryRecord("select * from ops_ciphertext_box_data where deleted=0 and box_type='database_instance_other' and source_id=?",dbEnvInfo.getId());
				if(rs==null){
					//密码箱没有密文数据，首次保存
					CiphertextBoxData box=new CiphertextBoxData();
					box.setBoxType("database_instance_other");
					box.setSourceId(dbEnvInfo.getId());
					box.setPlaintext(voucher);
					ciphertextBoxDataService.insert(box,false);
					Logger.info("密码箱没有密文数据，首次保存");
				}else{
					CiphertextBoxData box=new CiphertextBoxData();
					box.setId(rs.getString("id"));
					box.setSourceId(dbEnvInfo.getId());
					box.setPlaintext(voucher);
					ciphertextBoxDataService.update(box,SaveMode.NOT_NULL_FIELDS,false);
					Logger.info("密码箱已有密文数据，更新数据");
				}
			}

		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param dbEnvInfoList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<DbEnvInfo> dbEnvInfoList , SaveMode mode) {
		return super.updateList(dbEnvInfoList , mode);
	}

	
	/**
	 * 按主键更新数据库环境
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
	 * 按主键获取数据库环境
	 *
	 * @param id 主键
	 * @return DbEnvInfo 数据对象
	 */
	public DbEnvInfo getById(String id) {
		DbEnvInfo sample = new DbEnvInfo();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);

		DbEnvInfo info=dao.queryEntity(sample);

		boolean hasPriv=false;
		if(ciphertextBoxService.userEnDePermByBoxType("database_instance_other")){
			hasPriv=true;
		}
		if(hasPriv){
			Rcd rs=dao.queryRecord("select * from ops_ciphertext_box_data where deleted=0 and box_type='database_instance_other' and source_id=?",id);
			if(rs==null){
				info.setVoucher("");
			}else{
				info.setVoucher(ciphertextBoxDataService.getById(rs.getString("id")).getPlaintext());
			}
		}else{
			info.setVoucher("没有解密权限，不能查看");
		}


		return info;
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<DbEnvInfo> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<DbEnvInfo> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, DbEnvInfo> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, DbEnvInfo::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<DbEnvInfo> queryList(DbEnvInfoVO sample) {
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
	public PagedList<DbEnvInfo> queryPagedList(DbEnvInfoVO sample, int pageSize, int pageIndex) {
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
	public PagedList<DbEnvInfo> queryPagedList(DbEnvInfo sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param dbEnvInfo 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(DbEnvInfo dbEnvInfo) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(dbEnvInfo, SYS_ROLE.NAME);
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