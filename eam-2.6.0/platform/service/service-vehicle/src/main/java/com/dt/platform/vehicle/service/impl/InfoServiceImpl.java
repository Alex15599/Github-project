package com.dt.platform.vehicle.service.impl;


import com.dt.platform.constants.enums.vehicle.VehicleDataExportColumnEnum;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.vehicle.service.IInfoService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.DateUtil;
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
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.apache.poi.ss.usermodel.*;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 车辆信息 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 13:04:04
*/


@Service("VehicleInfoService")
public class InfoServiceImpl extends SuperService<Info> implements IInfoService {

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
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param info  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Info info,boolean throwsException) {
		Result r=super.insert(info,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param info 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Info info) {
		return this.insert(info,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param infoList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Info> infoList) {

		return super.insertList(infoList);
	}


	/**
	 * 按主键删除 车辆信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Info info = new Info();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		info.setId(id);
		try {
			boolean suc = dao.deleteEntity(info);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 车辆信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Info info = new Info();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		info.setId(id);
		info.setDeleted(1);
		info.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		info.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(info,SaveMode.NOT_NULL_FIELDS);
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
	 * @param info 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Info info , SaveMode mode) {
		return this.update(info,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param info 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Info info , SaveMode mode,boolean throwsException) {
		Result r=super.update(info , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param infoList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Info> infoList , SaveMode mode) {
		return super.updateList(infoList , mode);
	}


	/**
	 * 按主键更新字段 车辆信息
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
	 * 按主键获取 车辆信息
	 *
	 * @param id 主键
	 * @return Info 数据对象
	 */
	public Info getById(String id) {
		Info sample = new Info();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Info> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Info> queryList(Info sample) {
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
	public PagedList<Info> queryPagedList(Info sample, int pageSize, int pageIndex) {
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
	public PagedList<Info> queryPagedList(Info sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param info 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Info info) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(info, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(Info sample){
	DBTableMeta tm=this.dao().getTableMeta(this.table());


	String tableAlais="t";
	OrderBy orderBy=this.buildOrderBy(sample);
		if(orderBy==null) {
		DBColumnMeta cm=dao().getTableColumnMeta(table(), dao().getDBTreaty().getCreateTimeField());
		if(cm!=null) {
			orderBy=OrderBy.byDesc(tableAlais+"."+cm.getColumn());
		}
	}

	Expr select=buildQuerySQL(sample,tableAlais,null,orderBy);

	String subsql=" id ,  name ," +
			"  (select label from sys_dict_item a where dict_code='vehicle_status' and a.code=t.vehicle_status) vehicle_status," +
			"  (select label from sys_dict_item a where dict_code='vehicle_type' and a.code=t.type) type , " +
			" code ,  model ,  registrant ," +
			"  (select full_name from hrm_organization where id=t.owner_org_id) owner_org_id , " +
			" (select full_name from hrm_organization where id=t.use_org_id) use_org_id, " +
			" (select name from hrm_person where id in (select person_id from hrm_employee  where id=t.use_user_id) )use_user_id , " +
			" color ,  engine_number ,  frame_number ,  driving_license ,  kilometers ,  rescue_money ,  commercial_insurance_money ,  insurance_company ,  licensing_time ,  insurance_expire_date ,  version ,  scrap_time ,  position_detail ,  pictures ,  originator_id ,  technical_parameter ,  vehicle_count ,  notes ,  create_by ,  create_time ,  update_by ,  update_time ,  deleted ,  delete_by ,  delete_time ,  tenant_id ";
	String sql="select "+subsql+" from vehicle_info t WHERE ( ( t.deleted= 0 AND t.tenant_id= 'T001' )) ORDER BY t.create_time DESC";
	//查询数据

	RcdSet rs=this.dao().query(sql);
	//写入
	ExcelWriter ew=new ExcelWriter();
	ExcelStructure es=buildExcelStructure(true);
	//ExcelStructure es1=ExcelStructure.parse(rs,true);

	//Sheet sheet=ew.fillSheet(rs, tm.getShortTopic()+"清单",es);
	ew.setWorkBookName(tm.getShortTopic()+"清单-"+ DateUtil.format(new Date(),"yyyyMMdd-HHmmss") +".xlsx");
	Logger.info("导出 "+this.table()+" 数据 "+rs.size() +" 行");
		return ew;

	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public InputStream buildExcelTemplate(String code) {
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
				Row firstRow=sheet.getRow(0);
				Row secondRow=sheet.getRow(1);
				Logger.info("SheetName:"+sheet.getSheetName());
				Logger.info("firstRow lastCellNum:"+firstRow.getLastCellNum());
				Logger.info("lastSecondRow lastCellNum:"+secondRow.getLastCellNum());
				Logger.info("lastSecondRow lastCellNum Value:"+secondRow.getCell(secondRow.getLastCellNum()-1));
				if(firstRow.getLastCellNum()!=secondRow.getLastCellNum()){
					return null;
				}
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
			}
		}
		return inputStream;
	}


	//type:all,org,part,
	@Override
	public HashMap<String,String> queryOrganizationNodes(String type){
		//id name
		HashMap<String,String> map=new HashMap<String,String>();
		OrganizationVO vo=new OrganizationVO();
		vo.setIsLoadAllDescendants(1);
		vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
		Result r= OrganizationServiceProxy.api().queryNodesFlatten(vo);
		if(r.isSuccess()){
			List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
			for( ZTreeNode node:list){
				String path="";
				for(int j=0;j<node.getNamePathArray().size();j++){
					if(j==0){
						path=node.getNamePathArray().get(j);
					}else{
						path=path+"/"+node.getNamePathArray().get(j);
					}
				}
				Logger.info(node.getId()+","+path);
				map.put(node.getId(),path);
			}
		}
		return map;
	}



	@Override
	public Map<String, Object> queryVehicleInfoMap(Info sample) {

		List<Info> list=this.queryList(sample);
		HashMap<String,String> orgMap=queryOrganizationNodes("");
		Map<String,Object> map=new HashMap<>();
		dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("useUser")
				.with(InfoMeta.VEHICLE_STATUS_DICT)
				.with(InfoMeta.VEHICLE_TYPE_DICT)
				.execute();

		List<Employee> useUser= CollectorUtil.collectList(list, Info::getUseUser);
		dao().join(useUser, Person.class);

		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++){
			Info infoItem=list.get(i);
			Map<String, Object> infoMap= BeanUtil.toMap(infoItem);
			String ownerOrgName=orgMap.get(infoItem.getOwnerOrgId());
			infoMap.put(VehicleDataExportColumnEnum.OWNER_ORG_NAME.code(),ownerOrgName);
			String useOrgName=orgMap.get(infoItem.getUseOrgId());
			infoMap.put(VehicleDataExportColumnEnum.USE_ORG_NAME.code(),useOrgName);
			if(infoItem.getUseUser()!=null){
				infoMap.put(VehicleDataExportColumnEnum.USE_USER_NAME_BADGE.code(),infoItem.getUseUser().getNameAndBadge());
				infoMap.put(VehicleDataExportColumnEnum.USE_USER_NAME.code(),infoItem.getUseUser().getName());
				infoMap.put(VehicleDataExportColumnEnum.USE_USER_BADGE.code(),infoItem.getUseUser().getBadge());
			}
			if(infoItem.getVehicleStatusDict()!=null){
				infoMap.put(VehicleDataExportColumnEnum.VEHICLE_STATUS_NAME.code(),infoItem.getVehicleStatusDict().getLabel());
			}
			if(infoItem.getVehicleTypeDict()!=null){
				infoMap.put(VehicleDataExportColumnEnum.TYPE_NAME.code(),infoItem.getVehicleTypeDict().getLabel());
			}
			listMap.add(infoMap);
		}
		map.put("dataList", listMap);
		return map;
	}


	@Override
	public ExcelStructure buildExcelStructure(InputStream dataInputStream, String code) {
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
					if(VehicleDataExportColumnEnum.USE_USER_NAME.code().equals(asset_column)){
						continue;
					}

					rAssetColumn=EnumUtil.parseByCode(VehicleDataExportColumnEnum.class,asset_column)==null?
							BeanNameUtil.instance().depart(asset_column):
							EnumUtil.parseByCode(VehicleDataExportColumnEnum.class,asset_column).text();

					charIndex= ExcelUtil.toExcel26(i);
					Logger.info(charIndex+","+secondRow.getCell(i)  +","+ firstRow.getCell(i)+","+asset_column+","+rAssetColumn);
					es.addColumn(charIndex,rAssetColumn,firstRow.getCell(i).toString(), ExcelColumn.STRING_CELL_READER);
				}
				//追加自定义属性部分
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
				return es;
			}
		}

		return es;

	}



	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch,String code,String selectedCode) {

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
		return importData(rs, batch,selectedCode);
	}

	public HashMap<String,String> queryDictItemDataByDictCode(String dictCode){
		HashMap<String,String> map=new HashMap<>();
		DictItemVO vo=new DictItemVO();
		vo.setDictCode(dictCode);
		Result<List<DictItem>> result= DictItemServiceProxy.api().queryList(vo);
		if(result.isSuccess()){
			List<DictItem> list=result.getData();
			for(int i=0;i<list.size();i++){
				map.put(list.get(i).getCode(),list.get(i).getLabel());
			}
		}else{
		}
		return map;
	}



	public Result verifyAssetRecord(Rcd rcd,HashMap<String,HashMap<String,String>> matchMap){

		HashMap<String,String> orgMap=matchMap.get("organizationMap");
		HashMap<String,String> dictColumns=new HashMap<>();
		dictColumns.put(InfoMeta.VEHICLE_STATUS,"vehicle_status, 车辆状态");
		dictColumns.put(InfoMeta.TYPE,"vehicle_type,车辆类型");
		for(String key:dictColumns.keySet()){
			//来源
			String keyValue=dictColumns.get(key);
			String[] keyValueArr=keyValue.split(",");
			String dict=keyValueArr[0];
			String notes=keyValueArr[1];
			HashMap<String,String> map=matchMap.get(dict);
			String col=BeanNameUtil.instance().depart(key);
			String valueCol=rcd.getString(col);
			if(!StringUtil.isBlank(valueCol)){
				if(map.containsValue(valueCol)){
					Logger.info("dict set:"+col+","+queryMapKeyByValue(map,valueCol));
					rcd.setValue(col, queryMapKeyByValue(map,valueCol));
				}else{
					return ErrorDesc.failureMessage(notes+":"+valueCol);
				}
			}
		}

		String ownerOrgId=BeanNameUtil.instance().depart(InfoMeta.OWNER_ORG_ID);
		String valueOwnerOrg=rcd.getString(ownerOrgId);
		if(!StringUtil.isBlank(valueOwnerOrg)){
			if(orgMap.containsValue(valueOwnerOrg.trim())){
				String key= queryMapKeyByValue(orgMap,valueOwnerOrg);
				rcd.setValue(ownerOrgId,key);
			}else{
				//返回报错
				return ErrorDesc.failureMessage("组织节点未匹配到:"+valueOwnerOrg);
			}
		}

		String useOrgId=BeanNameUtil.instance().depart(InfoMeta.USE_ORG_ID);
		String valueUseOrg=rcd.getString(useOrgId);
		if(!StringUtil.isBlank(valueUseOrg)){
			if(orgMap.containsValue(valueUseOrg.trim())){
				String key= queryMapKeyByValue(orgMap,valueUseOrg);
				rcd.setValue(useOrgId,key);
			}else{
				//返回报错
				return ErrorDesc.failureMessage("组织节点未匹配到:"+valueUseOrg);
			}
		}



		String[] dateColumns = {InfoMeta.RESCUE_DUE_DATE,InfoMeta.INSURANCE_EXPIRE_DATE,InfoMeta.LICENSING_TIME,InfoMeta.LICENSING_TIME,InfoMeta.SCRAP_TIME};
		for(int j=0;j<dateColumns.length;j++){
			String dateColumn=dateColumns[j];
			String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
			if(!StringUtil.isBlank(value)){
				int valueLen=value.trim().length();
				try {
					DateFormat format1=null;
					if(valueLen==10){
						format1 = new SimpleDateFormat("yyyy-MM-dd");
					}else if(valueLen==19){
						format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					}else{
						return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
					}
					Date date = format1.parse(value);
					rcd.set(dateColumn,date);
				} catch (ParseException e) {
					return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
				}
			}
		}

		String useUser=BeanNameUtil.instance().depart(InfoMeta.USE_USER_ID);
		String valueUseUser=rcd.getString(useUser);
		if(!StringUtil.isBlank(valueUseUser)){
			Result<Employee> resEmp=EmployeeServiceProxy.api().getByBadge(valueUseUser);
			if(resEmp.isSuccess()){
				String empId=resEmp.getData().getId();
				rcd.setValue(useUser,empId);
			}else{
				Logger.info("获取人员失败:"+resEmp.getMessage());
				return ErrorDesc.failureMessage("使用人员不存在:"+valueUseUser);
			}
		}
		return ErrorDesc.success();

	}


	public String queryMapKeyByValue(HashMap<String,String> map, String value){
		String key = null;
		//Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
		for(String getKey: map.keySet()){
			if(map.get(getKey).equals(value)){
				key = getKey;
				return key;
			}
		}
		return key;
	}

	public List<ValidateResult> importData(RcdSet rs,boolean batch,String selectedCode) {
		List<ValidateResult> errors=new ArrayList<>();
		DBTableMeta tm=dao().getTableMeta(this.table());
		DBTreaty dbTreaty= dao().getDBTreaty();
		HashMap<String,HashMap<String,String>> matchMap=new HashMap<>();
		matchMap.put("organizationMap",this.queryOrganizationNodes(""));
		matchMap.put("vehicle_status", this.queryDictItemDataByDictCode("vehicle_status"));
		matchMap.put("vehicle_type",this.queryDictItemDataByDictCode("vehicle_type"));

		String actionType="update";
		String id="";
		List<SQL> sqls=new ArrayList<>();
		int i=0;
		for (Rcd r:rs.getRcdList()) {
			i++;
			Logger.info("before:"+r);
			//判断数据是插入或更新
			if(StringUtil.isBlank(r.getString(VehicleDataExportColumnEnum.ID.text()))){
				actionType="insert";
				id=IDGenerator.getSnowflakeIdString();
				r.set("id",id);
			}else{
				actionType="update";
				id=r.getString(VehicleDataExportColumnEnum.ID.text());
			}


			//校验数据
			Result verifyResult=this.verifyAssetRecord(r,matchMap);
			if(!verifyResult.isSuccess()){
				errors.add(new ValidateResult(null,(i+1),verifyResult.getMessage()));
				break;
			}

			//汇总更新数据
			String sql="";
			if("insert".equals(actionType)){
				Insert insert = SQLBuilder.buildInsert(r,this.table(),this.dao(), true);

				//租户ID
				insert.set("tenant_id",SessionUser.getCurrent().getActivatedTenantId());
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

				Update update=SQLBuilder.buildUpdate(r,SaveMode.ALL_FIELDS,this.table(),this.dao());
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
					dao().batchExecute(sqls);
				}

			} catch (Exception e) {
				errors.add(new ValidateResult(null,3,"批量导入失败"));
				throw  e;
			}
		}
		return errors;

	}


	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
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
	public File saveTempFile(InputStream is, String fileName){

		int BYTESIZE=1024;
		String path = System.getProperty("java.io.tmpdir");
		File temp = new File(path +File.separator+ fileName);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(new FileOutputStream(temp));                            //把文件流转为文件，保存在临时目录
			int len = 0;
			byte[] buf = new byte[10*BYTESIZE];                                                    //缓冲区
			while((len=bis.read(buf)) != -1){
				bos.write(buf, 0, len);
			}
			bos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(bos!=null) bos.close();
				if(bis!=null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}





}
