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


import com.dt.platform.proxy.eam.CCustInspectUserRServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectUserRVOMeta;
import com.dt.platform.domain.eam.CCustInspectUserR;
import com.dt.platform.domain.eam.CCustInspectUserRVO;
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
import com.dt.platform.domain.eam.meta.CCustInspectUserRMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectUserRService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检人员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 08:37:48
*/

@InDoc
@Api(tags = "巡检人员")
@RestController("EamCCustInspectUserRController")
public class CCustInspectUserRController extends SuperController {

	@Autowired
	private ICCustInspectUserRService cCustInspectUserRService;

	/**
	 * 添加巡检人员
	*/
	@ApiOperation(value = "添加巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.GROUP , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserRServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.INSERT)
	public Result insert(CCustInspectUserRVO cCustInspectUserRVO) {
		
		Result result=cCustInspectUserRService.insert(cCustInspectUserRVO,false);
		return result;
	}



	/**
	 * 删除巡检人员
	*/
	@ApiOperation(value = "删除巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserRServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustInspectUserRService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustInspectUserRService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustInspectUserRServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustInspectUserRService.hasRefers(ids);
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
			Result result=cCustInspectUserRService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustInspectUserRService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检人员
	*/
	@ApiOperation(value = "更新巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.GROUP , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectUserRVOMeta.PAGE_INDEX , CCustInspectUserRVOMeta.PAGE_SIZE , CCustInspectUserRVOMeta.SEARCH_FIELD , CCustInspectUserRVOMeta.FUZZY_FIELD , CCustInspectUserRVOMeta.SEARCH_VALUE , CCustInspectUserRVOMeta.DIRTY_FIELDS , CCustInspectUserRVOMeta.SORT_FIELD , CCustInspectUserRVOMeta.SORT_TYPE , CCustInspectUserRVOMeta.DATA_ORIGIN , CCustInspectUserRVOMeta.QUERY_LOGIC , CCustInspectUserRVOMeta.REQUEST_ACTION , CCustInspectUserRVOMeta.IDS } )
	@SentinelResource(value = CCustInspectUserRServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.UPDATE)
	public Result update(CCustInspectUserRVO cCustInspectUserRVO) {
		
		Result result=cCustInspectUserRService.update(cCustInspectUserRVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检人员
	*/
	@ApiOperation(value = "保存巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.GROUP , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustInspectUserRVOMeta.PAGE_INDEX , CCustInspectUserRVOMeta.PAGE_SIZE , CCustInspectUserRVOMeta.SEARCH_FIELD , CCustInspectUserRVOMeta.FUZZY_FIELD , CCustInspectUserRVOMeta.SEARCH_VALUE , CCustInspectUserRVOMeta.DIRTY_FIELDS , CCustInspectUserRVOMeta.SORT_FIELD , CCustInspectUserRVOMeta.SORT_TYPE , CCustInspectUserRVOMeta.DATA_ORIGIN , CCustInspectUserRVOMeta.QUERY_LOGIC , CCustInspectUserRVOMeta.REQUEST_ACTION , CCustInspectUserRVOMeta.IDS } )
	@SentinelResource(value = CCustInspectUserRServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.SAVE)
	public Result save(CCustInspectUserRVO cCustInspectUserRVO) {
		
		Result result=cCustInspectUserRService.save(cCustInspectUserRVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检人员
	*/
	@ApiOperation(value = "获取巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserRServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.GET_BY_ID)
	public Result<CCustInspectUserR> getById(String id) {
		
		Result<CCustInspectUserR> result=new Result<>();
		CCustInspectUserR cCustInspectUserR=cCustInspectUserRService.getById(id);
		result.success(true).data(cCustInspectUserR);
		return result;
	}


	/**
	 * 批量获取巡检人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustInspectUserRVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustInspectUserRServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.GET_BY_IDS)
	public Result<List<CCustInspectUserR>> getByIds(List<String> ids) {
		
		Result<List<CCustInspectUserR>> result=new Result<>();
		List<CCustInspectUserR> list=cCustInspectUserRService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检人员
	*/
	@ApiOperation(value = "查询巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.GROUP , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectUserRVOMeta.PAGE_INDEX , CCustInspectUserRVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustInspectUserRServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.QUERY_LIST)
	public Result<List<CCustInspectUserR>> queryList(CCustInspectUserRVO sample) {
		
		Result<List<CCustInspectUserR>> result=new Result<>();
		List<CCustInspectUserR> list=cCustInspectUserRService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检人员
	*/
	@ApiOperation(value = "分页查询巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.GROUP , value = "分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserRVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserRServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserRServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustInspectUserR>> queryPagedList(CCustInspectUserRVO sample) {
		
		Result<PagedList<CCustInspectUserR>> result=new Result<>();
		PagedList<CCustInspectUserR> list=cCustInspectUserRService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}