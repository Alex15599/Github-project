package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.CCustRepiarItemServiceProxy;
import com.dt.platform.domain.eam.meta.CCustRepiarItemVOMeta;
import com.dt.platform.domain.eam.CCustRepiarItem;
import com.dt.platform.domain.eam.CCustRepiarItemVO;
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
import com.dt.platform.domain.eam.meta.CCustRepiarItemMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustRepiarItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 内容接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 22:17:36
*/

@InDoc
@Api(tags = "内容")
@RestController("EamCCustRepiarItemController")
public class CCustRepiarItemController extends SuperController {

	@Autowired
	private ICCustRepiarItemService cCustRepiarItemService;

	/**
	 * 添加内容
	*/
	@ApiOperation(value = "添加内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "694644264046428160"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.REPAIR_ID , value = "报修" , required = false , dataTypeClass=String.class , example = "694583157466333184"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.PROCESS_USER_ID , value = "处理人" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class , example = "开始处理"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-04-01 08:28:18"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepiarItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.INSERT)
	public Result insert(CCustRepiarItemVO cCustRepiarItemVO) {
		
		Result result=cCustRepiarItemService.insert(cCustRepiarItemVO,false);
		return result;
	}



	/**
	 * 删除内容
	*/
	@ApiOperation(value = "删除内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "694644264046428160")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepiarItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustRepiarItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustRepiarItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除内容 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustRepiarItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustRepiarItemService.hasRefers(ids);
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
			Result result=cCustRepiarItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustRepiarItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新内容
	*/
	@ApiOperation(value = "更新内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "694644264046428160"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.REPAIR_ID , value = "报修" , required = false , dataTypeClass=String.class , example = "694583157466333184"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.PROCESS_USER_ID , value = "处理人" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class , example = "开始处理"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-04-01 08:28:18"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustRepiarItemVOMeta.PAGE_INDEX , CCustRepiarItemVOMeta.PAGE_SIZE , CCustRepiarItemVOMeta.SEARCH_FIELD , CCustRepiarItemVOMeta.FUZZY_FIELD , CCustRepiarItemVOMeta.SEARCH_VALUE , CCustRepiarItemVOMeta.DIRTY_FIELDS , CCustRepiarItemVOMeta.SORT_FIELD , CCustRepiarItemVOMeta.SORT_TYPE , CCustRepiarItemVOMeta.DATA_ORIGIN , CCustRepiarItemVOMeta.QUERY_LOGIC , CCustRepiarItemVOMeta.REQUEST_ACTION , CCustRepiarItemVOMeta.IDS } )
	@SentinelResource(value = CCustRepiarItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.UPDATE)
	public Result update(CCustRepiarItemVO cCustRepiarItemVO) {
		
		Result result=cCustRepiarItemService.update(cCustRepiarItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存内容
	*/
	@ApiOperation(value = "保存内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "694644264046428160"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.REPAIR_ID , value = "报修" , required = false , dataTypeClass=String.class , example = "694583157466333184"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.PROCESS_USER_ID , value = "处理人" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class , example = "开始处理"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-04-01 08:28:18"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustRepiarItemVOMeta.PAGE_INDEX , CCustRepiarItemVOMeta.PAGE_SIZE , CCustRepiarItemVOMeta.SEARCH_FIELD , CCustRepiarItemVOMeta.FUZZY_FIELD , CCustRepiarItemVOMeta.SEARCH_VALUE , CCustRepiarItemVOMeta.DIRTY_FIELDS , CCustRepiarItemVOMeta.SORT_FIELD , CCustRepiarItemVOMeta.SORT_TYPE , CCustRepiarItemVOMeta.DATA_ORIGIN , CCustRepiarItemVOMeta.QUERY_LOGIC , CCustRepiarItemVOMeta.REQUEST_ACTION , CCustRepiarItemVOMeta.IDS } )
	@SentinelResource(value = CCustRepiarItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.SAVE)
	public Result save(CCustRepiarItemVO cCustRepiarItemVO) {
		
		Result result=cCustRepiarItemService.save(cCustRepiarItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取内容
	*/
	@ApiOperation(value = "获取内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepiarItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.GET_BY_ID)
	public Result<CCustRepiarItem> getById(String id) {
		
		Result<CCustRepiarItem> result=new Result<>();
		CCustRepiarItem cCustRepiarItem=cCustRepiarItemService.getById(id);
		// join 关联的对象
		cCustRepiarItemService.dao().fill(cCustRepiarItem)
			.with("processUser")
			.execute();
		result.success(true).data(cCustRepiarItem);
		return result;
	}


	/**
	 * 批量获取内容 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取内容")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustRepiarItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustRepiarItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.GET_BY_IDS)
	public Result<List<CCustRepiarItem>> getByIds(List<String> ids) {
		
		Result<List<CCustRepiarItem>> result=new Result<>();
		List<CCustRepiarItem> list=cCustRepiarItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询内容
	*/
	@ApiOperation(value = "查询内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "694644264046428160"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.REPAIR_ID , value = "报修" , required = false , dataTypeClass=String.class , example = "694583157466333184"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.PROCESS_USER_ID , value = "处理人" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class , example = "开始处理"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-04-01 08:28:18"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustRepiarItemVOMeta.PAGE_INDEX , CCustRepiarItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustRepiarItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.QUERY_LIST)
	public Result<List<CCustRepiarItem>> queryList(CCustRepiarItemVO sample) {
		
		Result<List<CCustRepiarItem>> result=new Result<>();
		List<CCustRepiarItem> list=cCustRepiarItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询内容
	*/
	@ApiOperation(value = "分页查询内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "694644264046428160"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.REPAIR_ID , value = "报修" , required = false , dataTypeClass=String.class , example = "694583157466333184"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.PROCESS_USER_ID , value = "处理人" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class , example = "开始处理"),
		@ApiImplicitParam(name = CCustRepiarItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class , example = "2023-04-01 08:28:18"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustRepiarItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustRepiarItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustRepiarItem>> queryPagedList(CCustRepiarItemVO sample) {
		
		Result<PagedList<CCustRepiarItem>> result=new Result<>();
		PagedList<CCustRepiarItem> list=cCustRepiarItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		cCustRepiarItemService.dao().fill(list)
			.with("processUser")
			.execute();
		result.success(true).data(list);
		return result;
	}





}