package com.dt.platform.ops.service.impl;

import com.dt.platform.constants.enums.ops.OpsCiphertextHistoryDataTypeEnum;
import com.dt.platform.domain.ops.CiphertextBox;
import com.dt.platform.domain.ops.CiphertextBoxVO;
import com.dt.platform.domain.ops.CiphertextHistory;
import com.dt.platform.ops.service.ICiphertextBoxService;
import com.dt.platform.ops.service.ICiphertextHistoryService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.apache.commons.lang3.StringUtils;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 密文箱 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 09:38:02
*/


@Service("OpsCiphertextBoxService")
public class CiphertextBoxServiceImpl extends SuperService<CiphertextBox> implements ICiphertextBoxService {


	@Autowired
	private ICiphertextHistoryService ciphertextHistoryService;
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
	 * @param ciphertextBox  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CiphertextBox ciphertextBox,boolean throwsException) {
		if(StringUtils.isBlank(ciphertextBox.getEncryptionKey())){
			ciphertextBox.setEncryptionKey(IDGenerator.getSnowflakeIdString());
		}

		CiphertextBox queryBox=new CiphertextBox();
		queryBox.setType(ciphertextBox.getType());
		if(this.queryList(queryBox).size()>0){
			return ErrorDesc.failureMessage("密文类型重复");
		}
		Result r=super.insert(ciphertextBox,throwsException);
		return r;
	}

	@Override
	public boolean userEnDePermByBoxType(String boxType) {
		if(StringUtils.isBlank(boxType)){
			return false;
		}
		String userId= SessionUser.getCurrent().getUser().getActivatedEmployeeId();
		String sql="select 1 from ops_ciphertext_conf a,ops_ciphertext_box b where a.box_id=b.id and a.deleted=0 and b.deleted=0 and b.type=? and a.decryption_perm_status='enable' and user_id=?";
		RcdSet rs=dao.query(sql,boxType,userId);
		if(rs.size()>0){
			return true;
		}
		return false;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param ciphertextBox 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CiphertextBox ciphertextBox) {


		return this.insert(ciphertextBox,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param ciphertextBoxList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CiphertextBox> ciphertextBoxList) {
		return super.insertList(ciphertextBoxList);
	}

	
	/**
	 * 按主键删除 密文箱
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CiphertextBox box=this.getById(id);
		CiphertextHistory history=new CiphertextHistory();
		history.setBoxType(box.getType());
		history.setSourceValue(box.getId());
		history.setContent("key="+box.getEncryptionKey());
		history.setType(OpsCiphertextHistoryDataTypeEnum.CIPHERTEXT_BOX.code());
		ciphertextHistoryService.insert(history,false);

		CiphertextBox ciphertextBox = new CiphertextBox();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ciphertextBox.setId(id);
		try {
			boolean suc = dao.deleteEntity(ciphertextBox);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 密文箱
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {


		CiphertextBox box=this.getById(id);
		CiphertextHistory history=new CiphertextHistory();
		history.setBoxType(box.getType());
		history.setSourceValue(box.getId());
		history.setContent("key="+box.getEncryptionKey());
		history.setType(OpsCiphertextHistoryDataTypeEnum.CIPHERTEXT_BOX.code());
		ciphertextHistoryService.insert(history,false);

		CiphertextBox ciphertextBox = new CiphertextBox();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ciphertextBox.setId(id);
		ciphertextBox.setDeleted(true);
		ciphertextBox.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		ciphertextBox.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(ciphertextBox,SaveMode.NOT_NULL_FIELDS);
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
	 * @param ciphertextBox 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CiphertextBox ciphertextBox , SaveMode mode) {
		return this.update(ciphertextBox,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param ciphertextBox 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CiphertextBox ciphertextBox , SaveMode mode,boolean throwsException) {
		ciphertextBox.setEncryptionKey(null);
		//ciphertextBox.setType(null);
		Result r=super.update(ciphertextBox , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param ciphertextBoxList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CiphertextBox> ciphertextBoxList , SaveMode mode) {
		return super.updateList(ciphertextBoxList , mode);
	}

	
	/**
	 * 按主键更新字段 密文箱
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
	 * 按主键获取 密文箱
	 *
	 * @param id 主键
	 * @return CiphertextBox 数据对象
	 */
	public CiphertextBox getById(String id) {
		CiphertextBox sample = new CiphertextBox();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<CiphertextBox> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<CiphertextBox> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CiphertextBox> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CiphertextBox::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CiphertextBox> queryList(CiphertextBoxVO sample) {
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
	public PagedList<CiphertextBox> queryPagedList(CiphertextBoxVO sample, int pageSize, int pageIndex) {
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
	public PagedList<CiphertextBox> queryPagedList(CiphertextBox sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param ciphertextBox 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CiphertextBox ciphertextBox) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(ciphertextBox, SYS_ROLE.NAME);
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