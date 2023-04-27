package com.dt.platform.wms.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.wms.StorelocationServiceProxy;
import com.dt.platform.domain.wms.meta.StorelocationVOMeta;
import com.dt.platform.domain.wms.Storelocation;
import com.dt.platform.domain.wms.StorelocationVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.wms.meta.StorelocationMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.wms.Storehouse;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.LocType;
import com.dt.platform.domain.wms.TemperatureAttribute;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IStorelocationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 储位接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 13:53:30
*/

@InDoc
@Api(tags = "储位")
@RestController("WmsStorelocationController")
public class StorelocationController extends SuperController {

	@Autowired
	private IStorelocationService storelocationService;

	/**
	 * 添加储位
	*/
	@ApiOperation(value = "添加储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STOREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CUSTOMER_ID , value = "所属客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.BAR_CODE , value = "条码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_GROUP , value = "仓库组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_ATTRIBUTE , value = "库位属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.RFID , value = "RFID标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MIN_BATCH , value = "最小批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_BATCH , value = "最大批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.X_COORDINATE , value = "X坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Y_COORDINATE , value = "Y坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Z_COORDINATE , value = "Z坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES1 , value = "备注1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES2 , value = "备注2" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorelocationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.INSERT)
	public Result insert(StorelocationVO storelocationVO) {
		
		Result result=storelocationService.insert(storelocationVO,false);
		return result;
	}



	/**
	 * 删除储位
	*/
	@ApiOperation(value = "删除储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorelocationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  storelocationService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=storelocationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除储位 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = StorelocationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = storelocationService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=storelocationService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=storelocationService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新储位
	*/
	@ApiOperation(value = "更新储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STOREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CUSTOMER_ID , value = "所属客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.BAR_CODE , value = "条码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_GROUP , value = "仓库组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_ATTRIBUTE , value = "库位属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.RFID , value = "RFID标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MIN_BATCH , value = "最小批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_BATCH , value = "最大批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.X_COORDINATE , value = "X坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Y_COORDINATE , value = "Y坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Z_COORDINATE , value = "Z坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES1 , value = "备注1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES2 , value = "备注2" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StorelocationVOMeta.PAGE_INDEX , StorelocationVOMeta.PAGE_SIZE , StorelocationVOMeta.SEARCH_FIELD , StorelocationVOMeta.FUZZY_FIELD , StorelocationVOMeta.SEARCH_VALUE , StorelocationVOMeta.DIRTY_FIELDS , StorelocationVOMeta.SORT_FIELD , StorelocationVOMeta.SORT_TYPE , StorelocationVOMeta.DATA_ORIGIN , StorelocationVOMeta.QUERY_LOGIC , StorelocationVOMeta.REQUEST_ACTION , StorelocationVOMeta.IDS } )
	@SentinelResource(value = StorelocationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.UPDATE)
	public Result update(StorelocationVO storelocationVO) {
		
		Result result=storelocationService.update(storelocationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存储位
	*/
	@ApiOperation(value = "保存储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STOREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CUSTOMER_ID , value = "所属客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.BAR_CODE , value = "条码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_GROUP , value = "仓库组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_ATTRIBUTE , value = "库位属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.RFID , value = "RFID标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MIN_BATCH , value = "最小批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_BATCH , value = "最大批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.X_COORDINATE , value = "X坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Y_COORDINATE , value = "Y坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Z_COORDINATE , value = "Z坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES1 , value = "备注1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES2 , value = "备注2" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StorelocationVOMeta.PAGE_INDEX , StorelocationVOMeta.PAGE_SIZE , StorelocationVOMeta.SEARCH_FIELD , StorelocationVOMeta.FUZZY_FIELD , StorelocationVOMeta.SEARCH_VALUE , StorelocationVOMeta.DIRTY_FIELDS , StorelocationVOMeta.SORT_FIELD , StorelocationVOMeta.SORT_TYPE , StorelocationVOMeta.DATA_ORIGIN , StorelocationVOMeta.QUERY_LOGIC , StorelocationVOMeta.REQUEST_ACTION , StorelocationVOMeta.IDS } )
	@SentinelResource(value = StorelocationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.SAVE)
	public Result save(StorelocationVO storelocationVO) {
		
		Result result=storelocationService.save(storelocationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取储位
	*/
	@ApiOperation(value = "获取储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorelocationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.GET_BY_ID)
	public Result<Storelocation> getById(String id) {
		
		Result<Storelocation> result=new Result<>();
		Storelocation storelocation=storelocationService.getById(id);
		// join 关联的对象
		storelocationService.dao().fill(storelocation)
			.with(StorelocationMeta.PRODUCT_ATTR_LIST)
			.with(StorelocationMeta.CUSTOMER)
			.with(StorelocationMeta.STOREHOUSE)
			.with(StorelocationMeta.LOC_TYPE)
			.with(StorelocationMeta.TEMPERATURE_ATTRIBUTE)
			.execute();
		result.success(true).data(storelocation);
		return result;
	}


	/**
	 * 批量获取储位 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取储位")
		@ApiImplicitParams({
				@ApiImplicitParam(name = StorelocationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = StorelocationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.GET_BY_IDS)
	public Result<List<Storelocation>> getByIds(List<String> ids) {
		
		Result<List<Storelocation>> result=new Result<>();
		List<Storelocation> list=storelocationService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询储位
	*/
	@ApiOperation(value = "查询储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STOREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CUSTOMER_ID , value = "所属客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.BAR_CODE , value = "条码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_GROUP , value = "仓库组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_ATTRIBUTE , value = "库位属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.RFID , value = "RFID标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MIN_BATCH , value = "最小批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_BATCH , value = "最大批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.X_COORDINATE , value = "X坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Y_COORDINATE , value = "Y坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Z_COORDINATE , value = "Z坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES1 , value = "备注1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES2 , value = "备注2" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StorelocationVOMeta.PAGE_INDEX , StorelocationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = StorelocationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.QUERY_LIST)
	public Result<List<Storelocation>> queryList(StorelocationVO sample) {
		
		Result<List<Storelocation>> result=new Result<>();
		List<Storelocation> list=storelocationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询储位
	*/
	@ApiOperation(value = "分页查询储位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorelocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STOREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CUSTOMER_ID , value = "所属客户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.BAR_CODE , value = "条码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_GROUP , value = "仓库组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LOCATION_ATTRIBUTE , value = "库位属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.RFID , value = "RFID标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MIN_BATCH , value = "最小批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.MAX_BATCH , value = "最大批量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.X_COORDINATE , value = "X坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Y_COORDINATE , value = "Y坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.Z_COORDINATE , value = "Z坐标" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES1 , value = "备注1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StorelocationVOMeta.NOTES2 , value = "备注2" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorelocationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorelocationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Storelocation>> queryPagedList(StorelocationVO sample) {
		
		Result<PagedList<Storelocation>> result=new Result<>();
		PagedList<Storelocation> list=storelocationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		storelocationService.dao().fill(list)
			.with(StorelocationMeta.PRODUCT_ATTR_LIST)
			.with(StorelocationMeta.CUSTOMER)
			.with(StorelocationMeta.STOREHOUSE)
			.with(StorelocationMeta.LOC_TYPE)
			.with(StorelocationMeta.TEMPERATURE_ATTRIBUTE)
			.execute();
		result.success(true).data(list);
		return result;
	}





}