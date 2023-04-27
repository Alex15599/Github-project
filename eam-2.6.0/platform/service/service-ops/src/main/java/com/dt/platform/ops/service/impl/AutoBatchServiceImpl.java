package com.dt.platform.ops.service.impl;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.ops.AutoBatch;
import com.dt.platform.domain.ops.AutoBatchVO;
import com.dt.platform.ops.service.IAutoBatchService;
import com.dt.platform.ops.service.IAutoNodeSelectService;
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

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 节点批次 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 14:26:33
*/


@Service("OpsAutoBatchService")
public class AutoBatchServiceImpl extends SuperService<AutoBatch> implements IAutoBatchService {

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
	IAutoNodeSelectService autoNodeSelectService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param autoBatch  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AutoBatch autoBatch,boolean throwsException) {

		String selectedCode=autoBatch.getSelectedCode();
		if(autoBatch!=null||autoBatch.getNodeIds().size()==0){
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("selected_code",selectedCode==null?"":selectedCode);
			List<String> list=autoNodeSelectService.queryValues(OpsTables.OPS_AUTO_NODE_SELECT.NODE_ID,String.class,condition);
			autoBatch.setNodeIds(list);
		}

		if(autoBatch.getNodeIds().size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}

		Result r=super.insert(autoBatch,throwsException);
		if(r.isSuccess()){
			dao.execute("update ops_auto_node_select set owner_id=? where selected_code=?",autoBatch.getId(),selectedCode);
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param autoBatch 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AutoBatch autoBatch) {
		return this.insert(autoBatch,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param autoBatchList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AutoBatch> autoBatchList) {
		return super.insertList(autoBatchList);
	}

	
	/**
	 * 按主键删除 节点批次
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AutoBatch autoBatch = new AutoBatch();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		autoBatch.setId(id);
		try {
			boolean suc = dao.deleteEntity(autoBatch);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 节点批次
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AutoBatch autoBatch = new AutoBatch();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		autoBatch.setId(id);
		autoBatch.setDeleted(true);
		autoBatch.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		autoBatch.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(autoBatch,SaveMode.NOT_NULL_FIELDS);
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
	 * @param autoBatch 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AutoBatch autoBatch , SaveMode mode) {
		return this.update(autoBatch,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param autoBatch 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AutoBatch autoBatch , SaveMode mode,boolean throwsException) {
		Result r=super.update(autoBatch , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param autoBatchList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AutoBatch> autoBatchList , SaveMode mode) {
		return super.updateList(autoBatchList , mode);
	}

	
	/**
	 * 按主键更新字段 节点批次
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
	 * 按主键获取 节点批次
	 *
	 * @param id 主键
	 * @return AutoBatch 数据对象
	 */
	public AutoBatch getById(String id) {
		AutoBatch sample = new AutoBatch();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AutoBatch> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AutoBatch> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AutoBatch> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AutoBatch::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AutoBatch> queryList(AutoBatchVO sample) {
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
	public PagedList<AutoBatch> queryPagedList(AutoBatchVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AutoBatch> queryPagedList(AutoBatch sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param autoBatch 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AutoBatch autoBatch) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(autoBatch, SYS_ROLE.NAME);
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