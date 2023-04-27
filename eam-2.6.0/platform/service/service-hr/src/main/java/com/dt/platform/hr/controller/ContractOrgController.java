package com.dt.platform.hr.controller;

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


import com.dt.platform.proxy.hr.ContractOrgServiceProxy;
import com.dt.platform.domain.hr.meta.ContractOrgVOMeta;
import com.dt.platform.domain.hr.ContractOrg;
import com.dt.platform.domain.hr.ContractOrgVO;
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
import com.dt.platform.domain.hr.meta.ContractOrgMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IContractOrgService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 合同签订方接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:30:35
*/

@InDoc
@Api(tags = "合同签订方")
@RestController("HrContractOrgController")
public class ContractOrgController extends SuperController {

	@Autowired
	private IContractOrgService contractOrgService;


	/**
	 * 添加合同签订方
	*/
	@ApiOperation(value = "添加合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractOrgVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ContractOrgServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.INSERT)
	public Result insert(ContractOrgVO contractOrgVO) {
		Result result=contractOrgService.insert(contractOrgVO,false);
		return result;
	}



	/**
	 * 删除合同签订方
	*/
	@ApiOperation(value = "删除合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ContractOrgServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  contractOrgService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=contractOrgService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除合同签订方 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ContractOrgServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = contractOrgService.hasRefers(ids);
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
			Result result=contractOrgService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=contractOrgService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新合同签订方
	*/
	@ApiOperation(value = "更新合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractOrgVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ContractOrgVOMeta.PAGE_INDEX , ContractOrgVOMeta.PAGE_SIZE , ContractOrgVOMeta.SEARCH_FIELD , ContractOrgVOMeta.FUZZY_FIELD , ContractOrgVOMeta.SEARCH_VALUE , ContractOrgVOMeta.DIRTY_FIELDS , ContractOrgVOMeta.SORT_FIELD , ContractOrgVOMeta.SORT_TYPE , ContractOrgVOMeta.DATA_ORIGIN , ContractOrgVOMeta.QUERY_LOGIC , ContractOrgVOMeta.IDS } )
	@SentinelResource(value = ContractOrgServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.UPDATE)
	public Result update(ContractOrgVO contractOrgVO) {
		Result result=contractOrgService.update(contractOrgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存合同签订方
	*/
	@ApiOperation(value = "保存合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractOrgVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractOrgVOMeta.PAGE_INDEX , ContractOrgVOMeta.PAGE_SIZE , ContractOrgVOMeta.SEARCH_FIELD , ContractOrgVOMeta.FUZZY_FIELD , ContractOrgVOMeta.SEARCH_VALUE , ContractOrgVOMeta.DIRTY_FIELDS , ContractOrgVOMeta.SORT_FIELD , ContractOrgVOMeta.SORT_TYPE , ContractOrgVOMeta.DATA_ORIGIN , ContractOrgVOMeta.QUERY_LOGIC , ContractOrgVOMeta.IDS } )
	@SentinelResource(value = ContractOrgServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.SAVE)
	public Result save(ContractOrgVO contractOrgVO) {
		Result result=contractOrgService.save(contractOrgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取合同签订方
	*/
	@ApiOperation(value = "获取合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ContractOrgServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.GET_BY_ID)
	public Result<ContractOrg> getById(String id) {
		Result<ContractOrg> result=new Result<>();
		ContractOrg contractOrg=contractOrgService.getById(id);
		result.success(true).data(contractOrg);
		return result;
	}


	/**
	 * 批量获取合同签订方 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取合同签订方")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractOrgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ContractOrgServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.GET_BY_IDS)
	public Result<List<ContractOrg>> getByIds(List<String> ids) {
		Result<List<ContractOrg>> result=new Result<>();
		List<ContractOrg> list=contractOrgService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询合同签订方
	*/
	@ApiOperation(value = "查询合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractOrgVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ContractOrgVOMeta.PAGE_INDEX , ContractOrgVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractOrgServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.QUERY_LIST)
	public Result<List<ContractOrg>> queryList(ContractOrgVO sample) {
		Result<List<ContractOrg>> result=new Result<>();
		List<ContractOrg> list=contractOrgService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询合同签订方
	*/
	@ApiOperation(value = "分页查询合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractOrgVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ContractOrgServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractOrgServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ContractOrg>> queryPagedList(ContractOrgVO sample) {
		Result<PagedList<ContractOrg>> result=new Result<>();
		PagedList<ContractOrg> list=contractOrgService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}