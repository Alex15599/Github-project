package com.dt.platform.common.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.IBackupDbStrategyService;
import com.dt.platform.constants.enums.common.BackupStatusEnum;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.common.BackupDbStrategy;
import com.dt.platform.domain.ops.DbBackupInfo;
import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.mysql.jdbc.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;

import com.github.foxnic.commons.collection.MapUtil;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


import com.dt.platform.domain.common.BackupDb;
import com.dt.platform.domain.common.BackupDbVO;
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

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import com.dt.platform.common.service.IBackupDbService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 备份记录服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-26 11:21:40
*/

@EnableScheduling
@Service("SysBackupDbService")
public class BackupDbServiceImpl extends SuperService<BackupDb> implements IBackupDbService {


	@Value("${spring.datasource.druid.primary.encrypt}")
	private String encryptEnable;

	@Value("${spring.datasource.druid.primary.password}")
	private String jdbcPassword;

	@Value("${develop.encrypt.file.linux}")
	private String linuxFile;

	@Value("${develop.encrypt.file.mac}")
	private String macFile;

	@Value("${develop.encrypt.file.windows}")
	private String windowFile;



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
	private IBackupDbStrategyService backupDbStrategyService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param backupDb  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(BackupDb backupDb,boolean throwsException) {
		Result r=super.insert(backupDb,throwsException);
		return r;
	}
	/**
	 * @Description:获取备份工具
	 */
	private String getBackupToolMysqldump() {
		String res = "mysqldump";
		String sql="select * from sys_config where id='system.tool.mysqldump'";
		Rcd rs=dao.queryRecord(sql);
		if(rs!=null){
			if(!StringUtil.isBlank(rs.getString("value"))){
				res=rs.getString("value");
			}
		}
		Logger.info("res:"+res);
		return res;
	}


	/**
	 * @Description:压缩操作
	 */
	public void zip(String sourceFileName, String zipFileName) throws Exception {

		//创建zip输出流
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		//创建缓冲输出流
		BufferedOutputStream bos = new BufferedOutputStream(out);
		File sourceFile = new File(sourceFileName);
		//调用函数
		compress(out, bos, sourceFile, sourceFile.getName());
		bos.close();
		out.close();
	}

	/**
	 * @Description:压缩操作
	 */
	public void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String base) throws Exception {
		//如果路径为目录（文件夹）
		if (sourceFile.isDirectory()) {
			//取出文件夹中的文件（或子文件夹）
			File[] flist = sourceFile.listFiles();

			if (flist.length == 0)//如果文件夹为空，则只需在目的地zip文件中写入一个目录进入点
			{
				out.putNextEntry(new ZipEntry(base + "/"));
			} else//如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
			{
				for (int i = 0; i < flist.length; i++) {
					compress(out, bos, flist[i], base + "/" + flist[i].getName());
				}
			}
		} else//如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
		{
			out.putNextEntry(new ZipEntry(base));
			FileInputStream fos = new FileInputStream(sourceFile);
			BufferedInputStream bis = new BufferedInputStream(fos);
			int tag;
			//将源文件写入到zip文件中
			while ((tag = bis.read()) != -1) {
				bos.write(tag);
			}
			bis.close();
			fos.close();

		}
	}

	private  Result valid(File file) {
		File parentPath = file.getParentFile();
		if ((!parentPath.exists()) && (!parentPath.mkdirs())) {
			return ErrorDesc.failureMessage("创建文件失败");
		}
		if (!parentPath.canWrite()) {
			return ErrorDesc.failureMessage("不可写");
		}
		return ErrorDesc.success();
	}

	@Override
	@Scheduled(cron="0 15 2 * * ? ")
	public Result executeBackup() {
		Logger.info("backup start");
		BackupDbStrategy backupDbStrategy=backupDbStrategyService.getById("001");
		if(backupDbStrategy==null){
			return ErrorDesc.failureMessage("无备份策略");
		}
		if(StatusEnableEnum.DISABLE.code().equals(backupDbStrategy.getStatus())){
			return ErrorDesc.failureMessage("备份策略未启用");
		}
		String dataPath=backupDbStrategy.getDataPath();
		if(StringUtil.isBlank(dataPath)){
			return ErrorDesc.failureMessage("未找到备份路径");
		}
		File path=new File(backupDbStrategy.getDataPath());
		Logger.info("data absolute path:"+path.getAbsolutePath());
		Logger.info("data Path:"+path.getPath());
        if (!path.exists()) {
			path.mkdirs();
        }
		if(!dataPath.endsWith(File.separator)){
			dataPath = dataPath + File.separator;
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		String rq=formatter.format(calendar.getTime());
		String sqlFileName="backup_db_"+rq+"";
		String sqlFileNameRoute=dataPath+sqlFileName;
		//sqlFileNameRoute="/tmp/101";
		Logger.info("sqlFileName:"+sqlFileNameRoute);
		Logger.info("connect url:"+dao.getUrl());
		String url=dao.getUrl();
		String[] urlArr = url.split(":");
		String dbName=dao.getSchema();
		String userName=dao.getUserName();
		String password="xxxx";
		if ("false".equals(encryptEnable)){
			password=jdbcPassword;
		}else if("true".equals(encryptEnable)){
			Logger.info("jdbc password:"+jdbcPassword);
			String mw="";
			String osName=System.getProperty("os.name");
			Logger.info("os name:"+osName);
			if(!StringUtil.isBlank(osName)){
				if(osName.startsWith("Linux")){
					mw=FileUtil.readText(new File(linuxFile));
				}else if(osName.startsWith("Mac")){
					mw=FileUtil.readText(new File(macFile));
				}else if(osName.startsWith("Window")){
					mw=FileUtil.readText(new File(windowFile));
				}
			}
			Logger.info("passwd mw:"+mw);
			AESUtil aes=new AESUtil(mw);
			password=aes.decryptData(jdbcPassword);
		}
		String host= urlArr[2].replaceAll("//", "");
		String port= urlArr[3].split("/")[0];
		Logger.info("backup Start,host info:" + host + ",port:" + port + ",db:" + dbName, "user:" + userName);
		BackupDb record=new BackupDb();
		String recordId=IDGenerator.getSnowflakeIdString();
		record.setId(recordId);
		record.setDbName(dbName);
		record.setStartTime(new Date());
		record.setStatus(BackupStatusEnum.PROCESSING.code());
		record.setFileRoute(sqlFileNameRoute+".zip");
		this.insert(record);
		//开始备份
		Logger.info("开始备份,文件路径:"+sqlFileNameRoute+".sql");
		Result backupResult = backup(host, Integer.parseInt(port), dbName, userName, password, sqlFileNameRoute+".sql");
	//	Result backupResult=new Result();
	//	backupResult.success(true);
		//验证备份返回
		Logger.info("验证备份结果");
		if (!backupResult.isSuccess() ) {
			record.setStatus(BackupStatusEnum.FAILED.code());
			record.setContent(backupResult.getMessage());
			record.setEndTime(new Date());
			this.update(record,SaveMode.NOT_NULL_FIELDS,false);
			return backupResult;
		}
		//验证sql文件
		Logger.info("验证备份文件,"+sqlFileNameRoute+".sql");
		Result validFile = valid(new File(sqlFileNameRoute+".sql"));
		if (!validFile.isSuccess() ) {
			record.setStatus(BackupStatusEnum.FAILED.code());
			record.setContent(validFile.getMessage());
			record.setEndTime(new Date());
			this.update(record,SaveMode.NOT_NULL_FIELDS,false);
			return backupResult;
		}
		//进行zip压缩
		Logger.info("开始进行zip压缩,"+sqlFileNameRoute+".zip");
		try {
			zip(sqlFileNameRoute+".sql", sqlFileNameRoute+".zip");
		} catch (Exception e) {
			e.printStackTrace();
			record.setStatus(BackupStatusEnum.FAILED.code());
			record.setContent(e.getMessage());
			record.setEndTime(new Date());
			this.update(record,SaveMode.NOT_NULL_FIELDS,false);
			return ErrorDesc.failureMessage(e.getMessage());
		}
		//验证zip文件
		Logger.info("验证压缩后的文件,"+sqlFileNameRoute+".zip");
		Result validFile2= valid(new File(sqlFileNameRoute+".zip"));
		if (!validFile2.isSuccess() ) {
			record.setStatus(BackupStatusEnum.FAILED.code());
			record.setContent(validFile2.getMessage());
			record.setEndTime(new Date());
			this.update(record,SaveMode.NOT_NULL_FIELDS,false);
			return backupResult;
		}

		File tf = new File(sqlFileNameRoute+".zip");
		record.setStatus(BackupStatusEnum.VALID.code());
		record.setContent("备份成功");
		record.setEndTime(new Date());
		record.setFileSize(new BigDecimal(tf.length()));
		//更新备份成功
		this.update(record,SaveMode.NOT_NULL_FIELDS,false);
		//删除临时文件
		Logger.info("删除原始sql文件,"+sqlFileNameRoute+".sql");
		File sourceFile = new File(sqlFileNameRoute+".sql");
		if(sourceFile.exists()){
			sourceFile.delete();
		}

		///删除临时文件 删除文件
		this.clearBackupData();
		return ErrorDesc.success();
	}

	private  void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private String decideMysqldumpColumnStatistics() {
		StringBuilder result = new StringBuilder();
		Process process = null;
		BufferedReader bufrIn = null;
		BufferedReader bufrError = null;
		try {
			String[] commands = new String[3];
			String os = System.getProperties().getProperty("os.name");
			if (os.startsWith("Win")) {
				commands[0] = "cmd.exe";
				commands[1] = "/c";
			} else {
				commands[0] = "/bin/sh";
				commands[1] = "-c";
			}

			commands[2] = getBackupToolMysqldump() + " --help";
			// 执行命令, 返回一个子进程对象（命令在子进程中执行）
			process = Runtime.getRuntime().exec(commands, null);
			// 方法阻塞, 等待命令执行完成（成功会返回0）
			process.waitFor();
			// 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
			bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
			bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8));
			// 读取输出
			String line;
			while ((line = bufrIn.readLine()) != null) {
				result.append(line + "\n");
			}
			while ((line = bufrError.readLine()) != null) {
				result.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(bufrIn);
			closeStream(bufrError);
			// 销毁子进程
			if (process != null) {
				process.destroy();
			}
			// 返回执行结果
			if (result.toString().indexOf("column-statistics") > 0) {
				return "--column-statistics=0";
			}
			return "";
		}

	}

	private Result clearBackupData(){

		BackupDbStrategy backupDbStrategy=backupDbStrategyService.getById("001");
		int day=backupDbStrategy.getDataKeep();
		if(day<=0){
			return ErrorDesc.success();
		}
		Logger.info("start to clear backup data.");
		ConditionExpr expr=new ConditionExpr();
		expr.and(" status='valid' ");
		expr.and(" DATE(create_time)< DATE_SUB(CURDATE(), INTERVAL "+day+" DAY) ");
		List<BackupDb> list=this.queryList(expr);
		for(BackupDb item:list){
			File f=new File(item.getFileRoute());
			if(f.exists()){
				Logger.info("start to delete backup,file:"+item.getFileRoute());
				f.delete();
			}
			item.setStatus(BackupStatusEnum.INVALID.code());
			item.setInvalidTime(new Date());
			this.update(item,SaveMode.NOT_NULL_FIELDS, false);
		}
		return ErrorDesc.success();
	}

	/**
	 * @Description:备份操作
	 */
	public Result backup(String host, int port, String dbName, String username, String password, String filePath) {
		Long starttime = System.currentTimeMillis();
		JSONObject res = new JSONObject();
		try {
			File file = new File(filePath);
			String[] commands = new String[3];
			String os = System.getProperties().getProperty("os.name");
			if (os.startsWith("Win")) {
				commands[0] = "cmd.exe";
				commands[1] = "/c";
			} else {
				commands[0] = "/bin/sh";
				commands[1] = "-c";
			}
			StringBuilder mysqldump = new StringBuilder();
			StringBuilder mysqldump2 = new StringBuilder();
			mysqldump.append(getBackupToolMysqldump());
			mysqldump2.append(getBackupToolMysqldump());
			mysqldump.append(" " + decideMysqldumpColumnStatistics() + " ");
			mysqldump2.append(" " + decideMysqldumpColumnStatistics() + " ");
			mysqldump.append("  --opt");
			mysqldump2.append("  --opt");
			mysqldump.append(" --user=").append(username);
			mysqldump2.append(" --user=").append(username);
			mysqldump.append(" --password=").append(password);
			mysqldump2.append(" --password=").append("xxxxxxxx");
			mysqldump.append(" --host=").append(host);
			mysqldump2.append(" --host=").append(host);
			mysqldump.append(" --protocol=tcp");
			mysqldump2.append(" --protocol=tcp");
			mysqldump.append(" --port=").append(port);
			mysqldump2.append(" --port=").append(port);
			mysqldump.append(" --default-character-set=utf8");
			mysqldump2.append(" --default-character-set=utf8");
			//mysqldump.append(" --single-transaction=TRUE");
			//mysqldump.append(" --routines");
			//mysqldump.append(" --events");
			mysqldump.append(" ").append(dbName);
			mysqldump2.append(" ").append(dbName);
			mysqldump.append(" > ");
			mysqldump2.append(" > ");
			mysqldump.append(" ").append(filePath);
			mysqldump2.append(" ").append(filePath);
			String command = mysqldump.toString();
			commands[2] = command;
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(commands);
			Logger.info("execute command:"+mysqldump2);
			if (process.waitFor() == 0) {
				Long endtime = System.currentTimeMillis();
				Long distance = endtime - starttime;
				Logger.info("【" + dbName + "】备份成功，耗时：" + distance + "ms");
				res.put("distance", distance);
				return ErrorDesc.success();
			} else {
				InputStream is = process.getErrorStream();
				if (is != null) {
					BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
					String line;
					StringBuilder sb = new StringBuilder();
					while ((line = in.readLine()) != null) {
						sb.append(line);
					}
					Logger.info("数据库备【" + dbName + "】份失败\r\n" + sb.toString());
					return ErrorDesc.failureMessage("数据库备份失败" +sb.toString());
				}
			}
		} catch (Exception e) {
			Logger.error("数据库备【" + dbName + "】份失败", e);


		}
		return ErrorDesc.success();
	}
	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param backupDb 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(BackupDb backupDb) {
		return this.insert(backupDb,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param backupDbList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<BackupDb> backupDbList) {
		return super.insertList(backupDbList);
	}


	/**
	 * 按主键删除备份记录
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		BackupDb backupDb = new BackupDb();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		backupDb.setId(id);
		try {
			boolean suc = dao.deleteEntity(backupDb);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除备份记录
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		BackupDb backupDb = new BackupDb();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		backupDb.setId(id);
		backupDb.setDeleted(true);
		backupDb.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		backupDb.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(backupDb,SaveMode.NOT_NULL_FIELDS);
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
	 * @param backupDb 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(BackupDb backupDb , SaveMode mode) {
		return this.update(backupDb,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param backupDb 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(BackupDb backupDb , SaveMode mode,boolean throwsException) {
		Result r=super.update(backupDb , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param backupDbList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<BackupDb> backupDbList , SaveMode mode) {
		return super.updateList(backupDbList , mode);
	}


	/**
	 * 按主键更新备份记录
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
	 * 按主键获取备份记录
	 *
	 * @param id 主键
	 * @return BackupDb 数据对象
	 */
	public BackupDb getById(String id) {
		BackupDb sample = new BackupDb();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<BackupDb> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<BackupDb> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, BackupDb> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, BackupDb::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<BackupDb> queryList(BackupDbVO sample) {
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
	public PagedList<BackupDb> queryPagedList(BackupDbVO sample, int pageSize, int pageIndex) {
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
	public PagedList<BackupDb> queryPagedList(BackupDb sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param backupDb 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(BackupDb backupDb) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(backupDb, SYS_ROLE.NAME);
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
