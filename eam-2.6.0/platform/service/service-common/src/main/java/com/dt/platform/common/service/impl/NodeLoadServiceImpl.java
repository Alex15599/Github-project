package com.dt.platform.common.service.impl;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.encrypt.MD5Util;
import com.github.foxnic.commons.log.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.dt.platform.domain.common.NodeLoad;
import com.dt.platform.domain.common.NodeLoadVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.dt.platform.common.service.INodeLoadService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

/**
 * <p>
 * 节点负载服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:37:38
*/

@EnableScheduling
@Service("SysNodeLoadService")
public class NodeLoadServiceImpl extends SuperService<NodeLoad> implements INodeLoadService {

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
	 * @Description: 获取序列号
	 */
	public static String createUniqueSn() {
		String uid = "";
		SystemInfo si = new SystemInfo();
		String str = "";
		//return "123";
		try {
			HardwareAbstractionLayer hal = si.getHardware();
			ComputerSystem computerSystem = hal.getComputerSystem();
			str = str + computerSystem.getManufacturer() + computerSystem.getSerialNumber();
			final Firmware firmware = computerSystem.getFirmware();
			str = str + firmware.getName();
			final Baseboard baseboard = computerSystem.getBaseboard();
			str = str + baseboard.getSerialNumber();
			uid = MD5Util.encrypt32(str);
		} catch (Exception e){
			System.out.println("Get Sn error");
		}
		return uid;
	}

	private JSONObject getMemInfo(){
		JSONObject r = new JSONObject();
		SystemInfo systemInfo = new SystemInfo();
		GlobalMemory memory = systemInfo.getHardware().getMemory();
		//总内存
		long totalByte = memory.getTotal();
		//剩余
		long acaliableByte = memory.getAvailable();
		r.put("totalmem", formatByte(totalByte));
		r.put("used", formatByte(totalByte - acaliableByte));
		r.put("aliable", formatByte(acaliableByte));
		r.put("usage", new DecimalFormat("#.##%").format((totalByte - acaliableByte) * 1.0 / totalByte));
		return r;
	}
	private JSONObject getSysInfo(){
		JSONObject r = new JSONObject();
		Properties props = System.getProperties();
		//系统名称
		String osName = props.getProperty("os.name");
		//架构名称
		String osArch = props.getProperty("os.arch");
		r.put("osname", osName);
		r.put("osarch", osArch);
		r.put("ip", IpUtils.getHostIp());
		r.put("hostname", IpUtils.getHostName());
		return r;
	}
	private JSONObject getJvmInfo(){
		JSONObject r = new JSONObject();
		Properties props = System.getProperties();
		Runtime runtime = Runtime.getRuntime();
		RuntimeMXBean runtime2 = ManagementFactory.getRuntimeMXBean();
		//jvm总内存
		long jvmTotalMemoryByte = runtime.totalMemory();
		//jvm最大可申请
		long jvmMaxMoryByte = runtime.maxMemory();
		//空闲空间
		long freeMemoryByte = runtime.freeMemory();
		//jdk版本
		String jdkVersion = props.getProperty("java.version");
		//jdk路径
		String dir = props.getProperty("user.dir");
		//启动时间
		long time = ManagementFactory.getRuntimeMXBean().getStartTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String jdkHome = props.getProperty("java.home");
		//jvm内存总量
		r.put("jvmtotal", formatByte(jvmTotalMemoryByte));
		//jvm已使用内存
		r.put("jvmused", formatByte(jvmTotalMemoryByte - freeMemoryByte));
		//jvm剩余内存
		r.put("jvmfree", formatByte(freeMemoryByte));
		//jvm内存使用率
		r.put("jvmusage", new DecimalFormat("#.##%").format((jvmTotalMemoryByte - freeMemoryByte) * 1.0 / jvmTotalMemoryByte));
		//安装路径
		r.put("jdkhome", jdkHome);
		//java版本
		r.put("javaversion", jdkVersion);
		//启动时间
		r.put("starttime", sdf.format(new Date(time)));
		//项目路径
		r.put("dir", dir);
		r.put("javaname", runtime2.getVmName());
		r.put("uptime", runtime2.getUptime());

		return r;
	}
	private JSONArray getSysFiles(){
		JSONArray r = new JSONArray();
		SystemInfo si = new SystemInfo();
		OperatingSystem os = si.getOperatingSystem();
		try {
			FileSystem fileSystem = os.getFileSystem();
			List<OSFileStore> fsArray = fileSystem.getFileStores();
			for (OSFileStore fs : fsArray) {
				long free = fs.getUsableSpace();
				long total = fs.getTotalSpace();
				long used = total - free;
				JSONObject e = new JSONObject();
				e.put("DirName", fs.getMount());
				e.put("SysTypeName", fs.getType());
				e.put("TypeName", fs.getName());
				e.put("Total", convertFileSize(total));
				e.put("Free", convertFileSize(free));
				e.put("Used", convertFileSize(used));
				e.put("Usage", mul(div(used, total, 4), 100));
				r.add(e);
			}
		}catch (java.lang.IllegalArgumentException excep){
			System.out.println(excep);
		}
		return r;
	}
	private JSONObject getCpuInfo(){
		JSONObject r = new JSONObject();
		SystemInfo systemInfo = new SystemInfo();
		CentralProcessor processor = systemInfo.getHardware().getProcessor();
		long[] prevTicks = processor.getSystemCpuLoadTicks();
		try {
			// 睡眠1s
			TimeUnit.SECONDS.sleep(1);
			long[] ticks = processor.getSystemCpuLoadTicks();
			long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
			long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
			long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
			long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
			long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
			long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
			long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
			long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
			long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
			r.put("core", processor.getLogicalProcessorCount());
			r.put("sysusage", new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
			r.put("usrusage", new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
			r.put("iowaitusage", new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
			r.put("usage", new DecimalFormat("#.##%").format(1.0 - (idle * 1.0 / totalCpu)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * @Description: 格式转化
	 */
	public static String formatByte(long byteNumber) {
		//换算单位
		double FORMAT = 1024.0;
		double kbNumber = byteNumber / FORMAT;
		if (kbNumber < FORMAT) {
			return new DecimalFormat("#.##KB").format(kbNumber);
		}
		double mbNumber = kbNumber / FORMAT;
		if (mbNumber < FORMAT) {
			return new DecimalFormat("#.##MB").format(mbNumber);
		}
		double gbNumber = mbNumber / FORMAT;
		if (gbNumber < FORMAT) {
			return new DecimalFormat("#.##GB").format(gbNumber);
		}
		double tbNumber = gbNumber / FORMAT;
		return new DecimalFormat("#.##TB").format(tbNumber);
	}

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		if (b1.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO.doubleValue();
		}
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}


	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static String convertFileSize(long size) {
		long kb = 1024;
		long mb = kb * 1024;
		long gb = mb * 1024;
		if (size >= gb) {
			return String.format("%.1f GB", (float) size / gb);
		} else if (size >= mb) {
			float f = (float) size / mb;
			return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
		} else if (size >= kb) {
			float f = (float) size / kb;
			return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
		} else {
			return String.format("%d B", size);
		}
	}
	@Override
	public Result<JSONObject> loadData(String ctl) {
		Result<JSONObject> res=new Result<>();
		JSONObject r = new JSONObject();
		r.put("mem", this.getMemInfo());
		r.put("sysinfo", this.getSysInfo());
		r.put("jvm", this.getJvmInfo());
		r.put("sysfiles", this.getSysFiles());
		r.put("cpu", this.getCpuInfo());
		res.success(true).data(r);
		return res;
	}

	@Scheduled(fixedRate = 1000*60*5)
	@Override
	public Result collectData() {
		NodeLoad data=new NodeLoad();
		Logger.info("start to collect node data.");
		//info
		String ip= IpUtils.getHostIp();
		String hostName= IpUtils.getHostName();
		data.setIp(ip);
		data.setNode(hostName);
		//mem
		SystemInfo systemInfo = new SystemInfo();
		GlobalMemory memory = systemInfo.getHardware().getMemory();
		long totalByte = memory.getTotal();
		long acaliableByte = memory.getAvailable();
		data.setMemoryUsed(new BigDecimal(totalByte - acaliableByte));
		String memUsedPct= new DecimalFormat("#.##").format((totalByte - acaliableByte) * 1.0 / totalByte);
		data.setMemoryUsedPct(new BigDecimal(memUsedPct));
		//cpu
		CentralProcessor processor = systemInfo.getHardware().getProcessor();
		long[] prevTicks = processor.getSystemCpuLoadTicks();
		try {
			// 睡眠1s
			TimeUnit.SECONDS.sleep(1);
			long[] ticks = processor.getSystemCpuLoadTicks();
			long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
			long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
			long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
			long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
			long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
			long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
			long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
			long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
			long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
			String sysStr= new DecimalFormat("#.##").format(cSys * 1.0 / totalCpu);
			String usrStr= new DecimalFormat("#.##").format(user * 1.0 / totalCpu);
			String wioStr= new DecimalFormat("#.##").format(iowait * 1.0 / totalCpu);
			String idleStr= new DecimalFormat("#.##").format(idle * 1.0 / totalCpu);
			Logger.info("cpu info,sys:"+sysStr+",usr:"+usrStr+"wio:"+wioStr+",idle"+idleStr);
			data.setSys(new BigDecimal(sysStr));
			data.setUser(new BigDecimal(usrStr));
			data.setWio(new BigDecimal(wioStr));
			data.setIdle(new BigDecimal(idleStr));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.insert(data);
		return ErrorDesc.success();
	}


	@Scheduled(cron="0 15 2 * * ? ")
	@Override
	public Result clearData() {
		Logger.info("start to clear data");
		String sql="delete from sys_node_load where DATE(create_time)< DATE_SUB(CURDATE(), INTERVAL 90 DAY)";
		dao.execute(sql);
		return ErrorDesc.success();
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param nodeLoad  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(NodeLoad nodeLoad,boolean throwsException) {
		Result r=super.insert(nodeLoad,throwsException);
		return r;
	}



	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param nodeLoad 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(NodeLoad nodeLoad) {
		return this.insert(nodeLoad,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param nodeLoadList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<NodeLoad> nodeLoadList) {
		return super.insertList(nodeLoadList);
	}

	
	/**
	 * 按主键删除节点负载
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		NodeLoad nodeLoad = new NodeLoad();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		nodeLoad.setId(id);
		try {
			boolean suc = dao.deleteEntity(nodeLoad);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除节点负载
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		NodeLoad nodeLoad = new NodeLoad();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		nodeLoad.setId(id);
		nodeLoad.setDeleted(true);
		nodeLoad.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		nodeLoad.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(nodeLoad,SaveMode.NOT_NULL_FIELDS);
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
	 * @param nodeLoad 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NodeLoad nodeLoad , SaveMode mode) {
		return this.update(nodeLoad,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param nodeLoad 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(NodeLoad nodeLoad , SaveMode mode,boolean throwsException) {
		Result r=super.update(nodeLoad , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param nodeLoadList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<NodeLoad> nodeLoadList , SaveMode mode) {
		return super.updateList(nodeLoadList , mode);
	}

	
	/**
	 * 按主键更新节点负载
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
	 * 按主键获取节点负载
	 *
	 * @param id 主键
	 * @return NodeLoad 数据对象
	 */
	public NodeLoad getById(String id) {
		NodeLoad sample = new NodeLoad();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<NodeLoad> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<NodeLoad> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, NodeLoad> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, NodeLoad::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<NodeLoad> queryList(NodeLoadVO sample) {
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
	public PagedList<NodeLoad> queryPagedList(NodeLoadVO sample, int pageSize, int pageIndex) {
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
	public PagedList<NodeLoad> queryPagedList(NodeLoad sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param nodeLoad 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(NodeLoad nodeLoad) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(nodeLoad, SYS_ROLE.NAME);
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