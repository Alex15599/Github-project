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


import com.dt.platform.proxy.wms.CompanyLevelServiceProxy;
import com.dt.platform.domain.wms.meta.CompanyLevelVOMeta;
import com.dt.platform.domain.wms.CompanyLevel;
import com.dt.platform.domain.wms.CompanyLevelVO;
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
import com.dt.platform.domain.wms.meta.CompanyLevelMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ICompanyLevelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 企业等级接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:47
*/

@InDoc
@Api(tags = "企业等级")
@RestController("WmsCompanyLevelController")
public class CompanyLevelController extends SuperController {

	@Autowired
	private ICompanyLevelService companyLevelService;

	/**
	 * 添加企业等级
	*/
	@ApiOperation(value = "添加企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyLevelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.INSERT)
	public Result insert(CompanyLevelVO companyLevelVO) {
		
		Result result=companyLevelService.insert(companyLevelVO,false);
		return result;
	}



	/**
	 * 删除企业等级
	*/
	@ApiOperation(value = "删除企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyLevelServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  companyLevelService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=companyLevelService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除企业等级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CompanyLevelServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = companyLevelService.hasRefers(ids);
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
			Result result=companyLevelService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=companyLevelService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新企业等级
	*/
	@ApiOperation(value = "更新企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CompanyLevelVOMeta.PAGE_INDEX , CompanyLevelVOMeta.PAGE_SIZE , CompanyLevelVOMeta.SEARCH_FIELD , CompanyLevelVOMeta.FUZZY_FIELD , CompanyLevelVOMeta.SEARCH_VALUE , CompanyLevelVOMeta.DIRTY_FIELDS , CompanyLevelVOMeta.SORT_FIELD , CompanyLevelVOMeta.SORT_TYPE , CompanyLevelVOMeta.DATA_ORIGIN , CompanyLevelVOMeta.QUERY_LOGIC , CompanyLevelVOMeta.REQUEST_ACTION , CompanyLevelVOMeta.IDS } )
	@SentinelResource(value = CompanyLevelServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.UPDATE)
	public Result update(CompanyLevelVO companyLevelVO) {
		
		Result result=companyLevelService.update(companyLevelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存企业等级
	*/
	@ApiOperation(value = "保存企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyLevelVOMeta.PAGE_INDEX , CompanyLevelVOMeta.PAGE_SIZE , CompanyLevelVOMeta.SEARCH_FIELD , CompanyLevelVOMeta.FUZZY_FIELD , CompanyLevelVOMeta.SEARCH_VALUE , CompanyLevelVOMeta.DIRTY_FIELDS , CompanyLevelVOMeta.SORT_FIELD , CompanyLevelVOMeta.SORT_TYPE , CompanyLevelVOMeta.DATA_ORIGIN , CompanyLevelVOMeta.QUERY_LOGIC , CompanyLevelVOMeta.REQUEST_ACTION , CompanyLevelVOMeta.IDS } )
	@SentinelResource(value = CompanyLevelServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.SAVE)
	public Result save(CompanyLevelVO companyLevelVO) {
		
		Result result=companyLevelService.save(companyLevelVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取企业等级
	*/
	@ApiOperation(value = "获取企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyLevelServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.GET_BY_ID)
	public Result<CompanyLevel> getById(String id) {
		
		Result<CompanyLevel> result=new Result<>();
		CompanyLevel companyLevel=companyLevelService.getById(id);
		result.success(true).data(companyLevel);
		return result;
	}


	/**
	 * 批量获取企业等级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取企业等级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CompanyLevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CompanyLevelServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.GET_BY_IDS)
	public Result<List<CompanyLevel>> getByIds(List<String> ids) {
		
		Result<List<CompanyLevel>> result=new Result<>();
		List<CompanyLevel> list=companyLevelService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询企业等级
	*/
	@ApiOperation(value = "查询企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CompanyLevelVOMeta.PAGE_INDEX , CompanyLevelVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CompanyLevelServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.QUERY_LIST)
	public Result<List<CompanyLevel>> queryList(CompanyLevelVO sample) {
		
		Result<List<CompanyLevel>> result=new Result<>();
		List<CompanyLevel> list=companyLevelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询企业等级
	*/
	@ApiOperation(value = "分页查询企业等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyLevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CompanyLevelVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyLevelServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyLevelServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CompanyLevel>> queryPagedList(CompanyLevelVO sample) {
		
		Result<PagedList<CompanyLevel>> result=new Result<>();
		PagedList<CompanyLevel> list=companyLevelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}