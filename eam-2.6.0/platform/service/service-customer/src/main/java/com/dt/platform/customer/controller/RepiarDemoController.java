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


import com.dt.platform.proxy.customer.RepiarDemoServiceProxy;
import com.dt.platform.domain.customer.meta.RepiarDemoVOMeta;
import com.dt.platform.domain.customer.RepiarDemo;
import com.dt.platform.domain.customer.RepiarDemoVO;
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
import com.dt.platform.domain.customer.meta.RepiarDemoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.customer.service.IRepiarDemoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 报修接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 09:23:38
*/

@InDoc
@Api(tags = "报修")
@RestController("CustRepiarDemoController")
public class RepiarDemoController extends SuperController {

	@Autowired
	private IRepiarDemoService repiarDemoService;

	/**
	 * 添加报修
	*/
	@ApiOperation(value = "添加报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.ORG , value = "申报人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepiarDemoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.INSERT)
	public Result insert(RepiarDemoVO repiarDemoVO) {
		
		Result result=repiarDemoService.insert(repiarDemoVO,false);
		return result;
	}



	/**
	 * 删除报修
	*/
	@ApiOperation(value = "删除报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepiarDemoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.DELETE)
	public Result deleteById(Long id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  repiarDemoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=repiarDemoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除报修 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RepiarDemoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<Long> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<Long, ReferCause> causeMap = repiarDemoService.hasRefers(ids);
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
			Result result=repiarDemoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=repiarDemoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新报修
	*/
	@ApiOperation(value = "更新报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.ORG , value = "申报人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RepiarDemoVOMeta.PAGE_INDEX , RepiarDemoVOMeta.PAGE_SIZE , RepiarDemoVOMeta.SEARCH_FIELD , RepiarDemoVOMeta.FUZZY_FIELD , RepiarDemoVOMeta.SEARCH_VALUE , RepiarDemoVOMeta.DIRTY_FIELDS , RepiarDemoVOMeta.SORT_FIELD , RepiarDemoVOMeta.SORT_TYPE , RepiarDemoVOMeta.DATA_ORIGIN , RepiarDemoVOMeta.QUERY_LOGIC , RepiarDemoVOMeta.REQUEST_ACTION , RepiarDemoVOMeta.IDS } )
	@SentinelResource(value = RepiarDemoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.UPDATE)
	public Result update(RepiarDemoVO repiarDemoVO) {
		
		Result result=repiarDemoService.update(repiarDemoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存报修
	*/
	@ApiOperation(value = "保存报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.ORG , value = "申报人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepiarDemoVOMeta.PAGE_INDEX , RepiarDemoVOMeta.PAGE_SIZE , RepiarDemoVOMeta.SEARCH_FIELD , RepiarDemoVOMeta.FUZZY_FIELD , RepiarDemoVOMeta.SEARCH_VALUE , RepiarDemoVOMeta.DIRTY_FIELDS , RepiarDemoVOMeta.SORT_FIELD , RepiarDemoVOMeta.SORT_TYPE , RepiarDemoVOMeta.DATA_ORIGIN , RepiarDemoVOMeta.QUERY_LOGIC , RepiarDemoVOMeta.REQUEST_ACTION , RepiarDemoVOMeta.IDS } )
	@SentinelResource(value = RepiarDemoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.SAVE)
	public Result save(RepiarDemoVO repiarDemoVO) {
		
		Result result=repiarDemoService.save(repiarDemoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取报修
	*/
	@ApiOperation(value = "获取报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepiarDemoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.GET_BY_ID)
	public Result<RepiarDemo> getById(Long id) {
		
		Result<RepiarDemo> result=new Result<>();
		RepiarDemo repiarDemo=repiarDemoService.getById(id);
		result.success(true).data(repiarDemo);
		return result;
	}


	/**
	 * 批量获取报修 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取报修")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepiarDemoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RepiarDemoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.GET_BY_IDS)
	public Result<List<RepiarDemo>> getByIds(List<Long> ids) {
		
		Result<List<RepiarDemo>> result=new Result<>();
		List<RepiarDemo> list=repiarDemoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询报修
	*/
	@ApiOperation(value = "查询报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.ORG , value = "申报人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RepiarDemoVOMeta.PAGE_INDEX , RepiarDemoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepiarDemoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.QUERY_LIST)
	public Result<List<RepiarDemo>> queryList(RepiarDemoVO sample) {
		
		Result<List<RepiarDemo>> result=new Result<>();
		List<RepiarDemo> list=repiarDemoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询报修
	*/
	@ApiOperation(value = "分页查询报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepiarDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.USER , value = "姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.ORG , value = "申报人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepiarDemoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RepiarDemoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepiarDemoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepiarDemo>> queryPagedList(RepiarDemoVO sample) {
		
		Result<PagedList<RepiarDemo>> result=new Result<>();
		PagedList<RepiarDemo> list=repiarDemoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}