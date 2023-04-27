package com.dt.platform.ops.service.impl;

import com.dt.platform.constants.enums.ops.OpsCiphertextHistoryDataTypeEnum;
import com.dt.platform.constants.enums.ops.OpsCiphertextTypeEnum;
import com.dt.platform.domain.ops.CiphertextBox;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.CiphertextBoxDataVO;
import com.dt.platform.domain.ops.CiphertextHistory;
import com.dt.platform.ops.service.ICiphertextBoxDataService;
import com.dt.platform.ops.service.ICiphertextBoxService;
import com.dt.platform.ops.service.ICiphertextHistoryService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.apache.commons.lang3.StringUtils;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 密文数据 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 10:30:20
*/


@Service("OpsCiphertextBoxDataService")
public class CiphertextBoxDataServiceImpl extends SuperService<CiphertextBoxData> implements ICiphertextBoxDataService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private ICiphertextHistoryService ciphertextHistoryService;

	@Autowired
	private ICiphertextBoxService ciphertextBoxService;
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
	 * @param ciphertextBoxData  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CiphertextBoxData ciphertextBoxData,boolean throwsException) {
		if(StringUtils.isBlank(ciphertextBoxData.getSourceId())){
			return ErrorDesc.failureMessage("来源为空");
		}
		if(StringUtils.isBlank(ciphertextBoxData.getBoxType())){
			return ErrorDesc.failureMessage("密文箱类型不能为空");
		}

		//######################密文箱
		CiphertextBox boxQuery=new CiphertextBox();
		boxQuery.setType(ciphertextBoxData.getBoxType());
		List<CiphertextBox> boxList=ciphertextBoxService.queryList(boxQuery);
		if(boxList==null||boxList.size()==0){
			return ErrorDesc.failureMessage("未找到密文箱配置");
		}
		if(boxList==null||boxList.size()>1){
			return ErrorDesc.failureMessage("存在多个密文箱配置");
		}
		CiphertextBox box=boxList.get(0);
		//######################密文箱

		String plaintext=ciphertextBoxData.getPlaintext();
		if(plaintext==null){
			plaintext="";
		}
		AESUtil aes=new AESUtil(box.getEncryptionKey());
		String encryptData=aes.encryptData(plaintext);
		ciphertextBoxData.setCiphertext(encryptData);
		ciphertextBoxData.setPlaintext("");
		ciphertextBoxData.setBoxId(box.getId());

		if(!ciphertextBoxService.userEnDePermByBoxType(ciphertextBoxData.getBoxType())){
			return ErrorDesc.failureMessage("当前用户没有密文箱加解密权限");
		}
		//######################
		Result r=super.insert(ciphertextBoxData,throwsException);
		return r;
	}




	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param ciphertextBoxData 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CiphertextBoxData ciphertextBoxData) {
		return this.insert(ciphertextBoxData,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param ciphertextBoxDataList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CiphertextBoxData> ciphertextBoxDataList) {
		return super.insertList(ciphertextBoxDataList);
	}

	
	/**
	 * 按主键删除 密文数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CiphertextBoxData ciphertextBoxData = new CiphertextBoxData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ciphertextBoxData.setId(id);
		try {
			boolean suc = dao.deleteEntity(ciphertextBoxData);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 密文数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CiphertextBoxData ciphertextBoxData = new CiphertextBoxData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ciphertextBoxData.setId(id);
		ciphertextBoxData.setDeleted(true);
		ciphertextBoxData.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		ciphertextBoxData.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(ciphertextBoxData,SaveMode.NOT_NULL_FIELDS);
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
	 * @param ciphertextBoxData 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CiphertextBoxData ciphertextBoxData , SaveMode mode) {
		return this.update(ciphertextBoxData,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param ciphertextBoxData 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CiphertextBoxData ciphertextBoxData , SaveMode mode,boolean throwsException) {

		ciphertextBoxData.setSourceId(null);
		ciphertextBoxData.setBoxId(null);
		ciphertextBoxData.setBoxType(null);

		CiphertextBoxData sourceBoxData=this.getById(ciphertextBoxData.getId());
		String ciphertext=sourceBoxData.getCiphertext();
		//######################密文箱
		CiphertextBox boxQuery=new CiphertextBox();
		boxQuery.setType(ciphertextBoxData.getBoxType());
		boxQuery.setId(sourceBoxData.getBoxId());
		List<CiphertextBox> boxList=ciphertextBoxService.queryList(boxQuery);
		if(boxList==null||boxList.size()==0){
			return ErrorDesc.failureMessage("未找到密文箱配置");
		}
		if(boxList==null||boxList.size()>1){
			return ErrorDesc.failureMessage("存在多个密文箱配置");
		}
		CiphertextBox box=boxList.get(0);
		//######################密文箱

		String plaintext=ciphertextBoxData.getPlaintext();
		if(plaintext==null){
			plaintext="";
		}
		AESUtil aes=new AESUtil(box.getEncryptionKey());
		String encryptData=aes.encryptData(plaintext);
		ciphertextBoxData.setCiphertext(encryptData);
		ciphertextBoxData.setPlaintext("");

		
		if(!ciphertextBoxService.userEnDePermByBoxType(sourceBoxData.getBoxType())){
			sourceBoxData.setPlaintext("当前用户没有密文箱加解密权限");
			return ErrorDesc.failureMessage("当前用户没有密文箱加解密权限");
		}

		//保存历史
		CiphertextHistory saveData=new CiphertextHistory();
		saveData.setEncryptionContent(ciphertext);
		saveData.setSourceValue(sourceBoxData.getId());
		saveData.setBoxType(sourceBoxData.getBoxType());
		saveData.setType(OpsCiphertextHistoryDataTypeEnum.CIPHERTEXT_BOX_DATA.code());
		ciphertextHistoryService.insert(saveData);
		Result r=super.update(ciphertextBoxData , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param ciphertextBoxDataList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CiphertextBoxData> ciphertextBoxDataList , SaveMode mode) {
		return super.updateList(ciphertextBoxDataList , mode);
	}

	
	/**
	 * 按主键更新字段 密文数据
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
	 * 按主键获取 密文数据
	 *
	 * @param id 主键
	 * @return CiphertextBoxData 数据对象
	 */
	public CiphertextBoxData getById(String id) {
		CiphertextBoxData sample = new CiphertextBoxData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);

		CiphertextBoxData data=dao.queryEntity(sample);
		if(data==null){
			return data;
		}
		//######################密文箱
		CiphertextBox boxQuery=new CiphertextBox();
		boxQuery.setType(data.getBoxType());
		List<CiphertextBox> boxList=ciphertextBoxService.queryList(boxQuery);
		if(boxList==null||boxList.size()==0){
			data.setPlaintext("未找到密文箱配置");
			return data;
		}
		if(boxList==null||boxList.size()>1){
			data.setPlaintext("存在多个密文箱配置");
			return data;
		}
		CiphertextBox box=boxList.get(0);
		//######################密文箱

		AESUtil aes=new AESUtil(box.getEncryptionKey());
		String plaintext=aes.decryptData(data.getCiphertext());

		data.setPlaintext(plaintext);

		if(!ciphertextBoxService.userEnDePermByBoxType(data.getBoxType())){
			data.setPlaintext("当前用户没有密文箱加解密权限");

		}
		return data;
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<CiphertextBoxData> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<CiphertextBoxData> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CiphertextBoxData> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CiphertextBoxData::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CiphertextBoxData> queryList(CiphertextBoxDataVO sample) {
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
	public PagedList<CiphertextBoxData> queryPagedList(CiphertextBoxDataVO sample, int pageSize, int pageIndex) {
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
	public PagedList<CiphertextBoxData> queryPagedList(CiphertextBoxData sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param ciphertextBoxData 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CiphertextBoxData ciphertextBoxData) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(ciphertextBoxData, SYS_ROLE.NAME);
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