package com.dt.platform.ops.service.impl;


import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.domain.ops.VoucherPriv;
import com.dt.platform.ops.service.IVoucherPrivService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 凭证权限 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-04 15:56:25
*/


@Service("OpsVoucherPrivService")
public class VoucherPrivServiceImpl extends SuperService<VoucherPriv> implements IVoucherPrivService {
	
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
	 * 验证用户权限
	 * @param type 类型
	 * @param user_id 用户ID
	 * @return 插入是否成功
	 * */
	@Override
	public Result verifyUserPermissions(String type,String user_id) {
 
		if(user_id==null||"".equals(user_id)){
			return ErrorDesc.failureMessage("当前用户EmplID为:"+user_id+",未匹配到权限资源。");
		}
		VoucherPriv vp_query=new VoucherPriv();
		vp_query.setEmplId(user_id);
		vp_query.setStatus(StatusValidEnum.VALID.code());
		ConditionExpr ce=new ConditionExpr();
		ce.andLike("type",type);
		if(this.queryList(vp_query, ce).size()==0){
			return ErrorDesc.failureMessage("当前用户无权限");
		}
		return ErrorDesc.success();
	}
	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 插入实体
	 * @param voucherPriv 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(VoucherPriv voucherPriv) {
		Result r=super.insert(voucherPriv);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param voucherPrivList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<VoucherPriv> voucherPrivList) {
		return super.insertList(voucherPrivList);
	}
	
	
	/**
	 * 按主键删除 凭证权限
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		VoucherPriv voucherPriv = new VoucherPriv();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		voucherPriv.setId(id);
		try {
			boolean suc = dao.deleteEntity(voucherPriv);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 凭证权限
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		VoucherPriv voucherPriv = new VoucherPriv();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		voucherPriv.setId(id);
		voucherPriv.setDeleted(1);
		voucherPriv.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		voucherPriv.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(voucherPriv,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 更新实体
	 * @param voucherPriv 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(VoucherPriv voucherPriv , SaveMode mode) {
		Result r=super.update(voucherPriv , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param voucherPrivList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<VoucherPriv> voucherPrivList , SaveMode mode) {
		return super.updateList(voucherPrivList , mode);
	}
	
	
	/**
	 * 按主键更新字段 凭证权限
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
	 * 按主键获取 凭证权限
	 *
	 * @param id 主键
	 * @return VoucherPriv 数据对象
	 */
	public VoucherPriv getById(String id) {
		VoucherPriv sample = new VoucherPriv();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<VoucherPriv> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<VoucherPriv> queryList(VoucherPriv sample) {
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
	public PagedList<VoucherPriv> queryPagedList(VoucherPriv sample, int pageSize, int pageIndex) {
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
	public PagedList<VoucherPriv> queryPagedList(VoucherPriv sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param voucherPriv 数据对象
	 * @return 判断结果
	 */
	public Result<VoucherPriv> checkExists(VoucherPriv voucherPriv) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(voucherPriv, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(VoucherPriv sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
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
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
