package com.dt.platform.ops.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.ops.OpsDbBackupLogProcessedEnum;
import com.dt.platform.domain.ops.DbBackupInfo;
import com.dt.platform.domain.ops.DbBackupRecord;
import com.dt.platform.ops.service.IDbBackupInfoService;
import com.dt.platform.ops.service.IDbBackupRecordService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.RcdSet;
import com.mysql.jdbc.log.Log;
import org.apache.poi.hssf.record.BackupRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;

import com.github.foxnic.commons.collection.MapUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


import com.dt.platform.domain.ops.DbBackupLog;
import com.dt.platform.domain.ops.DbBackupLogVO;
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
import com.dt.platform.ops.service.IDbBackupLogService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 备份日志服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-30 19:48:42
*/

@EnableScheduling
@Service("OpsDbBackupLogService")
public class DbBackupLogServiceImpl extends SuperService<DbBackupLog> implements IDbBackupLogService {


	@Autowired
	private IDbBackupRecordService dbBackupRecordService;


	@Autowired
	private IDbBackupInfoService dbBackupInfoService;

	public static void main(String[] args) {

	}

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Override
	//@Scheduled(cron="0 15 2 * * ? ")
	//@Scheduled(cron="*/3 * * * * ? ")
	@Scheduled(fixedRate = 1000*120)
	public Result parseLog(){
		DbBackupLogVO vo=new DbBackupLogVO();
		vo.setProcessed(OpsDbBackupLogProcessedEnum.NOT_PROCESSED.code());
		List<DbBackupLog> list=this.queryList(vo);
		Logger.info("本次处理数据量:"+list.size());
		for(DbBackupLog item:list){
			processRecord(item);
		}
		return ErrorDesc.success();
	}

	private Result processRecord(DbBackupLog obj){
		Logger.info("processRecord:"+obj.getId());
		obj.setLastProcessTime(new Date());
		obj.setProcessResult("");
		obj.setProcessed(OpsDbBackupLogProcessedEnum.PROCESS_SUCCESS.code());
		String source=obj.getSource();

		//为空
		if(StringUtil.isBlank(source)){
			obj.setProcessed(OpsDbBackupLogProcessedEnum.PROCESS_FAILED.code());
			obj.setProcessResult("本行为空");
			this.update(obj,SaveMode.NOT_NULL_FIELDS);
			return ErrorDesc.success();
		//	continue;
		}

		if(!source.startsWith("20")){
			obj.setProcessed(OpsDbBackupLogProcessedEnum.PROCESS_FAILED.code());
			obj.setProcessResult("本行数据格式不对");
			this.update(obj,SaveMode.NOT_NULL_FIELDS);
			return ErrorDesc.success();
		//	continue;
		}
		String dbBkId="";
		String dbId="";
		//String content="2023-01-02 02:00:00|method=local,uid=1234,action=finish,status=success,aliasname=123,dbname=12,ip=192.168.1.1,size=124,result=none,stime=2023-01-02 02:00:00,etime=2023-01-02 02:00:00";
		String content=obj.getSource();
		String[] strArr1=content.split("\\|");
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		if(strArr1.length>=2){
			String recTime=strArr1[0];
			if(recTime.length()>=19){
				try {
					Date date = sdf.parse(recTime);
					obj.setRecordTime(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			String[] dhArr=strArr1[1].split(",");
			for(int i=0;i<dhArr.length;i++){
				String[] itemArr=dhArr[i].split("=");
				if(itemArr.length==2){
					String key=itemArr[0];
					String value=itemArr[1].trim();
					if(key.equals("method")){
						obj.setMethod(value);
					}else if(key.equals("uid")){
						obj.setUid(value);
						RcdSet rs=dao.query("select * from ops_db_backup_info where deleted=0 and uid=?",value);
						if(rs==null){
							obj.setProcessed(OpsDbBackupLogProcessedEnum.PROCESS_FAILED.code());
							obj.setProcessResult("UID未找到定义,uid:"+value);
							this.update(obj,SaveMode.NOT_NULL_FIELDS);
							return ErrorDesc.success();
						}
						if(rs.size()>1){
							obj.setProcessed(OpsDbBackupLogProcessedEnum.PROCESS_FAILED.code());
							obj.setProcessResult("UID找到重复,uid:"+value);
							this.update(obj,SaveMode.NOT_NULL_FIELDS);
							return ErrorDesc.success();
						}
						if(rs.size()==0){
							obj.setProcessed(OpsDbBackupLogProcessedEnum.PROCESS_FAILED.code());
							obj.setProcessResult("UID未找到定义,uid:"+value);
							this.update(obj,SaveMode.NOT_NULL_FIELDS);
							return ErrorDesc.success();
						}
						dbBkId=rs.getRcd(0).getString("id");
						dbId=rs.getRcd(0).getString("database_id");
						obj.setDbId(dbBkId);

					}else if(key.equals("ip")){
						obj.setIp(value);
					}else if(key.equals("action")){
						obj.setAction(value);
					}else if(key.equals("status")){
						obj.setStatus(value);
					}else if(key.equals("aliasname")){
						System.out.println("none");
					}else if(key.equals("dbname")){
						obj.setDbName(value);
					}else if(key.equals("size")){
						obj.setSize(new BigDecimal(Integer.parseInt(value)));
					}else if(key.equals("stime")){
						if(value.length()>=19){
							try {
								Date date = sdf.parse(value);
								obj.setStime(date);
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
					}else if(key.equals("etime")){
						if(value.length()>=19){
							try {
								Date date = sdf.parse(value);
								obj.setEtime(date);
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
					}else if(key.equals("result")){
						obj.setResult(value);
					}
				}
			}
		}
		obj.setProcessResult("处理完成");

		Result r=this.update(obj,SaveMode.NOT_NULL_FIELDS);
		if(r.isSuccess()){
			//插入备份集
			DbBackupRecord bkRecord=new DbBackupRecord();
			bkRecord.setDbId(dbId);
			bkRecord.setDbBkId(dbBkId);
			bkRecord.setBackupResult(obj.getStatus());
			bkRecord.setBackupStime(obj.getStime());
			bkRecord.setBackupEtime(obj.getEtime());
			bkRecord.setBackupSize(obj.getSize());
			dbBackupRecordService.insert(bkRecord,false);

			//更新备份状态
			DbBackupInfo info=new DbBackupInfo();
			info.setId(dbId);
			info.setBackupSize(obj.getSize());
			info.setBackupTime(obj.getStime());
			info.setBackupSource(obj.getSource());
			info.setName(obj.getDbName());
			info.setBackupResultCt(obj.getResult());
			dbBackupInfoService.update(info,SaveMode.NOT_NULL_FIELDS);
		}

		return ErrorDesc.success();

	}

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param dbBackupLog  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(DbBackupLog dbBackupLog,boolean throwsException) {
		Result r=super.insert(dbBackupLog,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param dbBackupLog 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(DbBackupLog dbBackupLog) {
		return this.insert(dbBackupLog,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param dbBackupLogList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<DbBackupLog> dbBackupLogList) {
		return super.insertList(dbBackupLogList);
	}

	
	/**
	 * 按主键删除备份日志
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		DbBackupLog dbBackupLog = new DbBackupLog();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		dbBackupLog.setId(id);
		try {
			boolean suc = dao.deleteEntity(dbBackupLog);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除备份日志
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		DbBackupLog dbBackupLog = new DbBackupLog();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		dbBackupLog.setId(id);
		dbBackupLog.setDeleted(true);
		dbBackupLog.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		dbBackupLog.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(dbBackupLog,SaveMode.NOT_NULL_FIELDS);
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
	 * @param dbBackupLog 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DbBackupLog dbBackupLog , SaveMode mode) {
		return this.update(dbBackupLog,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param dbBackupLog 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DbBackupLog dbBackupLog , SaveMode mode,boolean throwsException) {
		Result r=super.update(dbBackupLog , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param dbBackupLogList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<DbBackupLog> dbBackupLogList , SaveMode mode) {
		return super.updateList(dbBackupLogList , mode);
	}

	
	/**
	 * 按主键更新备份日志
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
	 * 按主键获取备份日志
	 *
	 * @param id 主键
	 * @return DbBackupLog 数据对象
	 */
	public DbBackupLog getById(String id) {
		DbBackupLog sample = new DbBackupLog();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<DbBackupLog> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<DbBackupLog> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, DbBackupLog> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, DbBackupLog::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<DbBackupLog> queryList(DbBackupLogVO sample) {
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
	public PagedList<DbBackupLog> queryPagedList(DbBackupLogVO sample, int pageSize, int pageIndex) {
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
	public PagedList<DbBackupLog> queryPagedList(DbBackupLog sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param dbBackupLog 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(DbBackupLog dbBackupLog) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(dbBackupLog, SYS_ROLE.NAME);
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