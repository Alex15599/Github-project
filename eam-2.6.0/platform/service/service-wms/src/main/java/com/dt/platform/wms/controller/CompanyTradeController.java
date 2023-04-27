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


import com.dt.platform.proxy.wms.CompanyTradeServiceProxy;
import com.dt.platform.domain.wms.meta.CompanyTradeVOMeta;
import com.dt.platform.domain.wms.CompanyTrade;
import com.dt.platform.domain.wms.CompanyTradeVO;
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
import com.dt.platform.domain.wms.meta.CompanyTradeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ICompanyTradeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 行业信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:10
*/

@InDoc
@Api(tags = "行业信息")
@RestController("WmsCompanyTradeController")
public class CompanyTradeController extends SuperController {

	@Autowired
	private ICompanyTradeService companyTradeService;

	/**
	 * 添加行业信息
	*/
	@ApiOperation(value = "添加行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyTradeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.INSERT)
	public Result insert(CompanyTradeVO companyTradeVO) {
		
		Result result=companyTradeService.insert(companyTradeVO,false);
		return result;
	}



	/**
	 * 删除行业信息
	*/
	@ApiOperation(value = "删除行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyTradeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  companyTradeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=companyTradeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除行业信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CompanyTradeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = companyTradeService.hasRefers(ids);
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
			Result result=companyTradeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=companyTradeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新行业信息
	*/
	@ApiOperation(value = "更新行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CompanyTradeVOMeta.PAGE_INDEX , CompanyTradeVOMeta.PAGE_SIZE , CompanyTradeVOMeta.SEARCH_FIELD , CompanyTradeVOMeta.FUZZY_FIELD , CompanyTradeVOMeta.SEARCH_VALUE , CompanyTradeVOMeta.DIRTY_FIELDS , CompanyTradeVOMeta.SORT_FIELD , CompanyTradeVOMeta.SORT_TYPE , CompanyTradeVOMeta.DATA_ORIGIN , CompanyTradeVOMeta.QUERY_LOGIC , CompanyTradeVOMeta.REQUEST_ACTION , CompanyTradeVOMeta.IDS } )
	@SentinelResource(value = CompanyTradeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.UPDATE)
	public Result update(CompanyTradeVO companyTradeVO) {
		
		Result result=companyTradeService.update(companyTradeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存行业信息
	*/
	@ApiOperation(value = "保存行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyTradeVOMeta.PAGE_INDEX , CompanyTradeVOMeta.PAGE_SIZE , CompanyTradeVOMeta.SEARCH_FIELD , CompanyTradeVOMeta.FUZZY_FIELD , CompanyTradeVOMeta.SEARCH_VALUE , CompanyTradeVOMeta.DIRTY_FIELDS , CompanyTradeVOMeta.SORT_FIELD , CompanyTradeVOMeta.SORT_TYPE , CompanyTradeVOMeta.DATA_ORIGIN , CompanyTradeVOMeta.QUERY_LOGIC , CompanyTradeVOMeta.REQUEST_ACTION , CompanyTradeVOMeta.IDS } )
	@SentinelResource(value = CompanyTradeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.SAVE)
	public Result save(CompanyTradeVO companyTradeVO) {
		
		Result result=companyTradeService.save(companyTradeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取行业信息
	*/
	@ApiOperation(value = "获取行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyTradeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.GET_BY_ID)
	public Result<CompanyTrade> getById(String id) {
		
		Result<CompanyTrade> result=new Result<>();
		CompanyTrade companyTrade=companyTradeService.getById(id);
		result.success(true).data(companyTrade);
		return result;
	}


	/**
	 * 批量获取行业信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取行业信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CompanyTradeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CompanyTradeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.GET_BY_IDS)
	public Result<List<CompanyTrade>> getByIds(List<String> ids) {
		
		Result<List<CompanyTrade>> result=new Result<>();
		List<CompanyTrade> list=companyTradeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询行业信息
	*/
	@ApiOperation(value = "查询行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CompanyTradeVOMeta.PAGE_INDEX , CompanyTradeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CompanyTradeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.QUERY_LIST)
	public Result<List<CompanyTrade>> queryList(CompanyTradeVO sample) {
		
		Result<List<CompanyTrade>> result=new Result<>();
		List<CompanyTrade> list=companyTradeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询行业信息
	*/
	@ApiOperation(value = "分页查询行业信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyTradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyTradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyTradeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyTradeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CompanyTrade>> queryPagedList(CompanyTradeVO sample) {
		
		Result<PagedList<CompanyTrade>> result=new Result<>();
		PagedList<CompanyTrade> list=companyTradeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}