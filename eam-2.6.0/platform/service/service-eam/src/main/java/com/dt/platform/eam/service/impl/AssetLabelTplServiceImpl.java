package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.AssetLabelTpl;
import com.dt.platform.domain.eam.AssetLabelTplItem;
import com.dt.platform.eam.service.IAssetLabelTplItemService;
import com.dt.platform.eam.service.IAssetLabelTplService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签模版 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 08:08:21
*/


@Service("EamAssetLabelTplService")
public class AssetLabelTplServiceImpl extends SuperService<AssetLabelTpl> implements IAssetLabelTplService {


	@Autowired
	private IAssetLabelTplItemService assetLabelTplItemService;
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
	 * @param assetLabelTpl  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetLabelTpl assetLabelTpl,boolean throwsException) {

		String ids=assetLabelTpl.getColIds();
		JSONArray idsArr=JSONArray.parseArray(ids);
		if(idsArr==null||idsArr.size()==0){
			return ErrorDesc.failureMessage("请选择标签字段");
		}

		Result r=super.insert(assetLabelTpl,throwsException);
		if(r.isSuccess()){
			for(int i=0;i<idsArr.size();i++){
				AssetLabelTplItem item=new AssetLabelTplItem();
				item.setColId(idsArr.getString(i));
				item.setSort(i);
				item.setTplId(assetLabelTpl.getId());
				assetLabelTplItemService.insert(item,false);
			}
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetLabelTpl 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetLabelTpl assetLabelTpl) {
		return this.insert(assetLabelTpl,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetLabelTplList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetLabelTpl> assetLabelTplList) {
		return super.insertList(assetLabelTplList);
	}

	
	/**
	 * 按主键删除 标签模版
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetLabelTpl assetLabelTpl = new AssetLabelTpl();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetLabelTpl.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetLabelTpl);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 标签模版
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetLabelTpl assetLabelTpl = new AssetLabelTpl();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetLabelTpl.setId(id);
		assetLabelTpl.setDeleted(1);
		assetLabelTpl.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetLabelTpl.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetLabelTpl,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetLabelTpl 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetLabelTpl assetLabelTpl , SaveMode mode) {
		return this.update(assetLabelTpl,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetLabelTpl 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetLabelTpl assetLabelTpl , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetLabelTpl , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetLabelTplList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetLabelTpl> assetLabelTplList , SaveMode mode) {
		return super.updateList(assetLabelTplList , mode);
	}

	
	/**
	 * 按主键更新字段 标签模版
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
	 * 按主键获取 标签模版
	 *
	 * @param id 主键
	 * @return AssetLabelTpl 数据对象
	 */
	public AssetLabelTpl getById(String id) {
		AssetLabelTpl sample = new AssetLabelTpl();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetLabelTpl> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetLabelTpl> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetLabelTpl::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetLabelTpl> queryList(AssetLabelTpl sample) {
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
	public PagedList<AssetLabelTpl> queryPagedList(AssetLabelTpl sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetLabelTpl> queryPagedList(AssetLabelTpl sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetLabelTpl 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetLabelTpl assetLabelTpl) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetLabelTpl, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetLabelTpl sample) {
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