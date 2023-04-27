package com.dt.platform.customer.controller;

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


import com.dt.platform.proxy.customer.ClpsDemoServiceProxy;
import com.dt.platform.domain.customer.meta.ClpsDemoVOMeta;
import com.dt.platform.domain.customer.ClpsDemo;
import com.dt.platform.domain.customer.ClpsDemoVO;
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
import com.dt.platform.domain.customer.meta.ClpsDemoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.customer.service.IClpsDemoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * CLPS测试接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 08:52:09
*/

@InDoc
@Api(tags = "CLPS测试")
@RestController("CustClpsDemoController")
public class ClpsDemoController extends SuperController {

	@Autowired
	private IClpsDemoService clpsDemoService;

	/**
	 * 添加CLPS测试
	*/
	@ApiOperation(value = "添加CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643412672607420416"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "11"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ClpsDemoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.INSERT)
	public Result insert(ClpsDemoVO clpsDemoVO) {
		
		Result result=clpsDemoService.insert(clpsDemoVO,false);
		return result;
	}



	/**
	 * 删除CLPS测试
	*/
	@ApiOperation(value = "删除CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643412672607420416")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ClpsDemoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.DELETE)
	public Result deleteById(Long id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  clpsDemoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=clpsDemoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除CLPS测试 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ClpsDemoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Long> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<Long, ReferCause> causeMap = clpsDemoService.hasRefers(ids);
		// 收集可以删除的ID值
		List<Long> canDeleteIds = new ArrayList<>();
		for (Map.Entry<Long, ReferCause> e : causeMap.entrySet()) {
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
			Result result=clpsDemoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=clpsDemoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新CLPS测试
	*/
	@ApiOperation(value = "更新CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643412672607420416"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "11"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ClpsDemoVOMeta.PAGE_INDEX , ClpsDemoVOMeta.PAGE_SIZE , ClpsDemoVOMeta.SEARCH_FIELD , ClpsDemoVOMeta.FUZZY_FIELD , ClpsDemoVOMeta.SEARCH_VALUE , ClpsDemoVOMeta.DIRTY_FIELDS , ClpsDemoVOMeta.SORT_FIELD , ClpsDemoVOMeta.SORT_TYPE , ClpsDemoVOMeta.DATA_ORIGIN , ClpsDemoVOMeta.QUERY_LOGIC , ClpsDemoVOMeta.REQUEST_ACTION , ClpsDemoVOMeta.IDS } )
	@SentinelResource(value = ClpsDemoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.UPDATE)
	public Result update(ClpsDemoVO clpsDemoVO) {
		
		Result result=clpsDemoService.update(clpsDemoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存CLPS测试
	*/
	@ApiOperation(value = "保存CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643412672607420416"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "11"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ClpsDemoVOMeta.PAGE_INDEX , ClpsDemoVOMeta.PAGE_SIZE , ClpsDemoVOMeta.SEARCH_FIELD , ClpsDemoVOMeta.FUZZY_FIELD , ClpsDemoVOMeta.SEARCH_VALUE , ClpsDemoVOMeta.DIRTY_FIELDS , ClpsDemoVOMeta.SORT_FIELD , ClpsDemoVOMeta.SORT_TYPE , ClpsDemoVOMeta.DATA_ORIGIN , ClpsDemoVOMeta.QUERY_LOGIC , ClpsDemoVOMeta.REQUEST_ACTION , ClpsDemoVOMeta.IDS } )
	@SentinelResource(value = ClpsDemoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.SAVE)
	public Result save(ClpsDemoVO clpsDemoVO) {
		
		Result result=clpsDemoService.save(clpsDemoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取CLPS测试
	*/
	@ApiOperation(value = "获取CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ClpsDemoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.GET_BY_ID)
	public Result<ClpsDemo> getById(Long id) {
		
		Result<ClpsDemo> result=new Result<>();
		ClpsDemo clpsDemo=clpsDemoService.getById(id);
		result.success(true).data(clpsDemo);
		return result;
	}


	/**
	 * 批量获取CLPS测试 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取CLPS测试")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ClpsDemoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ClpsDemoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.GET_BY_IDS)
	public Result<List<ClpsDemo>> getByIds(List<Long> ids) {
		
		Result<List<ClpsDemo>> result=new Result<>();
		List<ClpsDemo> list=clpsDemoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询CLPS测试
	*/
	@ApiOperation(value = "查询CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643412672607420416"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "11"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ClpsDemoVOMeta.PAGE_INDEX , ClpsDemoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ClpsDemoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.QUERY_LIST)
	public Result<List<ClpsDemo>> queryList(ClpsDemoVO sample) {
		
		Result<List<ClpsDemo>> result=new Result<>();
		List<ClpsDemo> list=clpsDemoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询CLPS测试
	*/
	@ApiOperation(value = "分页查询CLPS测试")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ClpsDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "643412672607420416"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NAME , value = "姓名" , required = false , dataTypeClass=String.class , example = "11"),
		@ApiImplicitParam(name = ClpsDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "11"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ClpsDemoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ClpsDemoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ClpsDemo>> queryPagedList(ClpsDemoVO sample) {
		
		Result<PagedList<ClpsDemo>> result=new Result<>();
		PagedList<ClpsDemo> list=clpsDemoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}