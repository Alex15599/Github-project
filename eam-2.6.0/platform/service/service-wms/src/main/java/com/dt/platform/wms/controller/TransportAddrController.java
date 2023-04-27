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


import com.dt.platform.proxy.wms.TransportAddrServiceProxy;
import com.dt.platform.domain.wms.meta.TransportAddrVOMeta;
import com.dt.platform.domain.wms.TransportAddr;
import com.dt.platform.domain.wms.TransportAddrVO;
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
import com.dt.platform.domain.wms.meta.TransportAddrMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ITransportAddrService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 地址管理接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:06:55
*/

@InDoc
@Api(tags = "地址管理")
@RestController("WmsTransportAddrController")
public class TransportAddrController extends SuperController {

	@Autowired
	private ITransportAddrService transportAddrService;

	/**
	 * 添加地址管理
	*/
	@ApiOperation(value = "添加地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.USER , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.MOBILE , value = "联系电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TransportAddrServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.INSERT)
	public Result insert(TransportAddrVO transportAddrVO) {
		
		Result result=transportAddrService.insert(transportAddrVO,false);
		return result;
	}



	/**
	 * 删除地址管理
	*/
	@ApiOperation(value = "删除地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TransportAddrServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  transportAddrService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=transportAddrService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除地址管理 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = TransportAddrServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = transportAddrService.hasRefers(ids);
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
			Result result=transportAddrService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=transportAddrService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新地址管理
	*/
	@ApiOperation(value = "更新地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.USER , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.MOBILE , value = "联系电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TransportAddrVOMeta.PAGE_INDEX , TransportAddrVOMeta.PAGE_SIZE , TransportAddrVOMeta.SEARCH_FIELD , TransportAddrVOMeta.FUZZY_FIELD , TransportAddrVOMeta.SEARCH_VALUE , TransportAddrVOMeta.DIRTY_FIELDS , TransportAddrVOMeta.SORT_FIELD , TransportAddrVOMeta.SORT_TYPE , TransportAddrVOMeta.DATA_ORIGIN , TransportAddrVOMeta.QUERY_LOGIC , TransportAddrVOMeta.REQUEST_ACTION , TransportAddrVOMeta.IDS } )
	@SentinelResource(value = TransportAddrServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.UPDATE)
	public Result update(TransportAddrVO transportAddrVO) {
		
		Result result=transportAddrService.update(transportAddrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存地址管理
	*/
	@ApiOperation(value = "保存地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.USER , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.MOBILE , value = "联系电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TransportAddrVOMeta.PAGE_INDEX , TransportAddrVOMeta.PAGE_SIZE , TransportAddrVOMeta.SEARCH_FIELD , TransportAddrVOMeta.FUZZY_FIELD , TransportAddrVOMeta.SEARCH_VALUE , TransportAddrVOMeta.DIRTY_FIELDS , TransportAddrVOMeta.SORT_FIELD , TransportAddrVOMeta.SORT_TYPE , TransportAddrVOMeta.DATA_ORIGIN , TransportAddrVOMeta.QUERY_LOGIC , TransportAddrVOMeta.REQUEST_ACTION , TransportAddrVOMeta.IDS } )
	@SentinelResource(value = TransportAddrServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.SAVE)
	public Result save(TransportAddrVO transportAddrVO) {
		
		Result result=transportAddrService.save(transportAddrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取地址管理
	*/
	@ApiOperation(value = "获取地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TransportAddrServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.GET_BY_ID)
	public Result<TransportAddr> getById(String id) {
		
		Result<TransportAddr> result=new Result<>();
		TransportAddr transportAddr=transportAddrService.getById(id);
		result.success(true).data(transportAddr);
		return result;
	}


	/**
	 * 批量获取地址管理 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取地址管理")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TransportAddrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = TransportAddrServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.GET_BY_IDS)
	public Result<List<TransportAddr>> getByIds(List<String> ids) {
		
		Result<List<TransportAddr>> result=new Result<>();
		List<TransportAddr> list=transportAddrService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询地址管理
	*/
	@ApiOperation(value = "查询地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.USER , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.MOBILE , value = "联系电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TransportAddrVOMeta.PAGE_INDEX , TransportAddrVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TransportAddrServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.QUERY_LIST)
	public Result<List<TransportAddr>> queryList(TransportAddrVO sample) {
		
		Result<List<TransportAddr>> result=new Result<>();
		List<TransportAddr> list=transportAddrService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询地址管理
	*/
	@ApiOperation(value = "分页查询地址管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TransportAddrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.USER , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.CONTACT , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.MOBILE , value = "联系电话" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TransportAddrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TransportAddrServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TransportAddrServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<TransportAddr>> queryPagedList(TransportAddrVO sample) {
		
		Result<PagedList<TransportAddr>> result=new Result<>();
		PagedList<TransportAddr> list=transportAddrService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}