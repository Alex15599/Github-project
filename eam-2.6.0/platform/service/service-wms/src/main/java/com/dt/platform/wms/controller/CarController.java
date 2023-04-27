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


import com.dt.platform.proxy.wms.CarServiceProxy;
import com.dt.platform.domain.wms.meta.CarVOMeta;
import com.dt.platform.domain.wms.Car;
import com.dt.platform.domain.wms.CarVO;
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
import com.dt.platform.domain.wms.meta.CarMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ICarService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆管理接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:01:46
*/

@InDoc
@Api(tags = "车辆管理")
@RestController("WmsCarController")
public class CarController extends SuperController {

	@Autowired
	private ICarService carService;

	/**
	 * 添加车辆管理
	*/
	@ApiOperation(value = "添加车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_NUMBER , value = "车号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_MODEL , value = "车型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_WEIGHT , value = "最大载重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_VOLUMN , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_PEOPLE , value = "载人数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.DRIVE_NUMBER , value = "驾照" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MOBILE , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_VALUE , value = "车牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.AREA , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CarServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.INSERT)
	public Result insert(CarVO carVO) {
		
		Result result=carService.insert(carVO,false);
		return result;
	}



	/**
	 * 删除车辆管理
	*/
	@ApiOperation(value = "删除车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CarServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  carService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=carService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆管理 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CarServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = carService.hasRefers(ids);
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
			Result result=carService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=carService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆管理
	*/
	@ApiOperation(value = "更新车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_NUMBER , value = "车号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_MODEL , value = "车型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_WEIGHT , value = "最大载重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_VOLUMN , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_PEOPLE , value = "载人数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.DRIVE_NUMBER , value = "驾照" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MOBILE , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_VALUE , value = "车牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.AREA , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CarVOMeta.PAGE_INDEX , CarVOMeta.PAGE_SIZE , CarVOMeta.SEARCH_FIELD , CarVOMeta.FUZZY_FIELD , CarVOMeta.SEARCH_VALUE , CarVOMeta.DIRTY_FIELDS , CarVOMeta.SORT_FIELD , CarVOMeta.SORT_TYPE , CarVOMeta.DATA_ORIGIN , CarVOMeta.QUERY_LOGIC , CarVOMeta.REQUEST_ACTION , CarVOMeta.IDS } )
	@SentinelResource(value = CarServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.UPDATE)
	public Result update(CarVO carVO) {
		
		Result result=carService.update(carVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆管理
	*/
	@ApiOperation(value = "保存车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_NUMBER , value = "车号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_MODEL , value = "车型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_WEIGHT , value = "最大载重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_VOLUMN , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_PEOPLE , value = "载人数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.DRIVE_NUMBER , value = "驾照" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MOBILE , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_VALUE , value = "车牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.AREA , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CarVOMeta.PAGE_INDEX , CarVOMeta.PAGE_SIZE , CarVOMeta.SEARCH_FIELD , CarVOMeta.FUZZY_FIELD , CarVOMeta.SEARCH_VALUE , CarVOMeta.DIRTY_FIELDS , CarVOMeta.SORT_FIELD , CarVOMeta.SORT_TYPE , CarVOMeta.DATA_ORIGIN , CarVOMeta.QUERY_LOGIC , CarVOMeta.REQUEST_ACTION , CarVOMeta.IDS } )
	@SentinelResource(value = CarServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.SAVE)
	public Result save(CarVO carVO) {
		
		Result result=carService.save(carVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆管理
	*/
	@ApiOperation(value = "获取车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CarServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.GET_BY_ID)
	public Result<Car> getById(String id) {
		
		Result<Car> result=new Result<>();
		Car car=carService.getById(id);
		result.success(true).data(car);
		return result;
	}


	/**
	 * 批量获取车辆管理 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆管理")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CarVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CarServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.GET_BY_IDS)
	public Result<List<Car>> getByIds(List<String> ids) {
		
		Result<List<Car>> result=new Result<>();
		List<Car> list=carService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆管理
	*/
	@ApiOperation(value = "查询车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_NUMBER , value = "车号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_MODEL , value = "车型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_WEIGHT , value = "最大载重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_VOLUMN , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_PEOPLE , value = "载人数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.DRIVE_NUMBER , value = "驾照" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MOBILE , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_VALUE , value = "车牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.AREA , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CarVOMeta.PAGE_INDEX , CarVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CarServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.QUERY_LIST)
	public Result<List<Car>> queryList(CarVO sample) {
		
		Result<List<Car>> result=new Result<>();
		List<Car> list=carService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆管理
	*/
	@ApiOperation(value = "分页查询车辆管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CarVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_NUMBER , value = "车号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_MODEL , value = "车型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_WEIGHT , value = "最大载重" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_VOLUMN , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.MAX_PEOPLE , value = "载人数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CarVOMeta.DRIVE_NUMBER , value = "驾照" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.MOBILE , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.CAR_VALUE , value = "车牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.AREA , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CarVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CarServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CarServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Car>> queryPagedList(CarVO sample) {
		
		Result<PagedList<Car>> result=new Result<>();
		PagedList<Car> list=carService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}