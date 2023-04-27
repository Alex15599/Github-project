package com.dt.platform.eam.service.impl;


import com.alibaba.csp.sentinel.util.StringUtil;
import com.dt.platform.constants.enums.eam.AssetStockGoodsOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.GoodsStockVO;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import com.dt.platform.eam.service.IGoodsStockService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * 库存物品 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 11:41:53
*/


@Service("EamGoodsStockService")
public class GoodsStockServiceImpl extends SuperService<GoodsStock> implements IGoodsStockService {



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
	 * @param goodsStock  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(GoodsStock goodsStock,boolean throwsException) {
		Result r=super.insert(goodsStock,throwsException);
		return r;
	}




	//type:create,edit
	public Result saveOwnerData(String oid,String ownerType,List<GoodsStock> list){
		this.dao.execute("delete from eam_goods_stock where owner_id=?",oid);
		for(int i=0;i<list.size();i++){
			GoodsStock e=list.get(i);
			e.setId(null);
			e.setOwnerId(oid);
			e.setOwnerTmpId("none");
			e.setOwnerType(ownerType);
			super.insert(e,false);
		}
		return ErrorDesc.success();
	}

	private void fillStockWarnData(PagedList<GoodsStock> list){
		// join 关联的对象
		this.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		List<Employee> originatorList= CollectorUtil.collectList(list, GoodsStock::getOriginator);
		this.dao().join(originatorList, Person.class);
	}

	@Override
	public PagedList<GoodsStock> querySecurityStockWarn(GoodsStockVO sample) {
		ConditionExpr queryCondition=new ConditionExpr();
		String ownerCode=sample.getOwnerCode();
		if(!ownerCode.startsWith("real_")){
			ownerCode="real_none";
			sample.setOwnerCode(ownerCode);
		}
		String sql="select \n" +
				"data.stock_in_number,\n" +
				"goods.stock_min goods_stock_min,\n" +
				"goods.stock_max goods_stock_max,\n" +
				"goods.stock_security goods_stock_security,\n" +
				"data.id from eam_goods_stock data, eam_goods_stock goods\n" +
				"where data.goods_id=goods.id and data.owner_code=?\n" +
				"and data.stock_cur_number>goods.stock_security";
		List<String> idsList=dao.query(sql,ownerCode).getValueList("id",String.class);
		if(idsList.size()>0){
			queryCondition.andIn("id",idsList);
		}else{
			sample.setId("-1");
		}
		PagedList<GoodsStock> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		fillStockWarnData(list);
		return list;
	}

	@Override
	public PagedList<GoodsStock> queryMinStockWarn(GoodsStockVO sample) {
		ConditionExpr queryCondition=new ConditionExpr();
		String ownerCode=sample.getOwnerCode();
		if(!ownerCode.startsWith("real_")){
			ownerCode="real_none";
			sample.setOwnerCode(ownerCode);
		}
		String sql="select \n" +
				"data.stock_in_number,\n" +
				"goods.stock_min goods_stock_min,\n" +
				"goods.stock_max goods_stock_max,\n" +
				"goods.stock_security goods_stock_security,\n" +
				"data.id from eam_goods_stock data, eam_goods_stock goods\n" +
				"where data.goods_id=goods.id and data.owner_code=?\n" +
				"and data.stock_cur_number<goods.stock_min";
		List<String> idsList=dao.query(sql,ownerCode).getValueList("id",String.class);
		if(idsList.size()>0){
			queryCondition.andIn("id",idsList);
		}else{
			sample.setId("-1");
		}
		PagedList<GoodsStock> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		fillStockWarnData(list);
		return list;
	}

	@Override
	public PagedList<GoodsStock> queryMaxStockWarn(GoodsStockVO sample) {
		ConditionExpr queryCondition=new ConditionExpr();
		String ownerCode=sample.getOwnerCode();
		if(!ownerCode.startsWith("real_")){
			ownerCode="real_none";
			sample.setOwnerCode(ownerCode);
		}
		String sql="select \n" +
				"data.stock_in_number,\n" +
				"goods.stock_min goods_stock_min,\n" +
				"goods.stock_max goods_stock_max,\n" +
				"goods.stock_security goods_stock_security,\n" +
				"data.id from eam_goods_stock data, eam_goods_stock goods\n" +
				"where data.goods_id=goods.id and data.owner_code=?\n" +
				"and data.stock_cur_number>goods.stock_max";
		List<String> idsList=dao.query(sql,ownerCode).getValueList("id",String.class);
		if(idsList.size()>0){
			queryCondition.andIn("id",idsList);
		}else{
			sample.setId("-1");
		}
		PagedList<GoodsStock> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		fillStockWarnData(list);
		return list;
	}

	@Override
	public PagedList<GoodsStock> queryPagedListBySelected(GoodsStockVO sample, String operType,String dataType) {

		//重置数据
		String ownerTmpId=sample.getOwnerTmpId();
		if(!StringUtil.isBlank(ownerTmpId)){
			//存在ownerTmp,则为修改操作时查询，删除原来数据
			//saveOwner to TmpData
			if("reset".equals(dataType)){
				//删除原来数据
				this.dao.execute("delete from eam_goods_stock where owner_tmp_id=?",ownerTmpId);
				//插入新的数据
				GoodsStock qE=new GoodsStock();
				qE.setOwnerId(ownerTmpId);
				List<GoodsStock> list =super.queryList(qE);
				if(list.size()>0){
					for(int i=0;i<list.size();i++){
						GoodsStock e=list.get(i);
						e.setId(null);
						e.setOwnerCode(AssetStockGoodsOwnerEnum.DATA_SELECTED.code());
						e.setOwnerId("none");
						e.setOwnerTmpId(ownerTmpId);
						super.insert(e,false);
					}
				}
			}
		}
		ConditionExpr queryCondition=new ConditionExpr();
		if(!StringUtil.isBlank(sample.getCategoryId())) {
			queryCondition.and("category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%/"+sample.getCategoryId()+"/%' or id=?))",sample.getCategoryId());
			sample.setCategoryId(null);
		}
		PagedList<GoodsStock> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;

	}

	@Override
	public PagedList<GoodsStock> queryPagedListBySelect(GoodsStockVO sample, String assetSearchContent) {
		ConditionExpr queryCondition=new ConditionExpr();
		String ownerId=sample.getOwnerId();
		if(StringUtil.isBlank(ownerId)){
			sample.setOwnerId(null);
		}
		if(!StringUtil.isBlank(sample.getCategoryId())) {
			Logger.info("ownerCode="+sample.getOwnerCode());
			if("goods".equals(sample.getOwnerCode())){
				queryCondition.and("category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%/"+sample.getCategoryId()+"/%' or id=?))",sample.getCategoryId());
			}else{
				queryCondition.and("goods_id in (select id from eam_goods_stock where category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%"+sample.getCategoryId()+"%' or id=?)))",sample.getCategoryId());
			}
			sample.setCategoryId(null);
		}

		PagedList<GoodsStock> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param goodsStock 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(GoodsStock goodsStock) {
		return this.insert(goodsStock,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param goodsStockList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<GoodsStock> goodsStockList) {
		return super.insertList(goodsStockList);
	}

	@Override
	public PagedList<GoodsStock> queryGoodsStockRealAll(GoodsStockVO goodsVO) {


		String ownerCode="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(goodsVO.getOwnerType()) ){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_STOCK.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(goodsVO.getOwnerType())){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_CONSUMABLES.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(goodsVO.getOwnerType())){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_PART.code();
		}

		String sql="select goods_id,sum(stock_cur_number) stock_cur_number_total from eam_goods_stock where deleted=0 and owner_code=? group by goods_id";
		RcdSet rs=this.dao.query(sql,ownerCode);
		HashMap<String,Integer> map=new HashMap<>();
		List<String> goodsIds=new ArrayList<>();
		goodsIds.add("-1");
		for(int i=0;i<rs.size();i++){
			goodsIds.add(rs.getRcd(i).getString("goods_id"));
			map.put(rs.getRcd(i).getString("goods_id"),rs.getRcd(i).getInteger("stock_cur_number_total"));
		}
		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",goodsIds);
		goodsVO.setOwnerType(null);
		goodsVO.setOwnerCode(AssetStockGoodsOwnerEnum.GOODS.code());
		PagedList<GoodsStock> list=super.queryPagedList(goodsVO,expr,goodsVO.getPageSize(),goodsVO.getPageIndex());
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getId();
			Integer value=map.getOrDefault(id,0);
			list.get(i).setStockCurNumber(new BigDecimal(value));
			list.get(i).setGoodsId(id);
		}
		return list;
	}


	/**
	 * 按主键删除 库存物品
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		GoodsStock goodsStock = new GoodsStock();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		goodsStock.setId(id);
		try {
			boolean suc = dao.deleteEntity(goodsStock);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 库存物品
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		GoodsStock goodsStock = new GoodsStock();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		goodsStock.setId(id);
		goodsStock.setDeleted(1);
		goodsStock.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		goodsStock.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(goodsStock,SaveMode.NOT_NULL_FIELDS);
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
	 * @param goodsStock 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(GoodsStock goodsStock , SaveMode mode) {
		return this.update(goodsStock,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param goodsStock 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(GoodsStock goodsStock , SaveMode mode,boolean throwsException) {
		Result r=super.update(goodsStock , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param goodsStockList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<GoodsStock> goodsStockList , SaveMode mode) {
		return super.updateList(goodsStockList , mode);
	}


	/**
	 * 按主键更新字段 库存物品
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
	 * 按主键获取 库存物品
	 *
	 * @param id 主键
	 * @return GoodsStock 数据对象
	 */
	public GoodsStock getById(String id) {
		GoodsStock sample = new GoodsStock();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<GoodsStock> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<GoodsStock> queryList(GoodsStock sample) {
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
	public PagedList<GoodsStock> queryPagedList(GoodsStock sample, int pageSize, int pageIndex) {
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
	public PagedList<GoodsStock> queryPagedList(GoodsStock sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param goodsStock 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(GoodsStock goodsStock) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(goodsStock, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(GoodsStock sample) {
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
