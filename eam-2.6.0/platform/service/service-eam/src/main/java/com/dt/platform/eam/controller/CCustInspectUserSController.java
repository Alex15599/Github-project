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


import com.dt.platform.proxy.eam.CCustInspectUserSServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectUserSVOMeta;
import com.dt.platform.domain.eam.CCustInspectUserS;
import com.dt.platform.domain.eam.CCustInspectUserSVO;
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
import com.dt.platform.domain.eam.meta.CCustInspectUserSMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectUserSService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检人员接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 08:37:30
*/

@InDoc
@Api(tags = "巡检人员")
@RestController("EamCCustInspectUserSController")
public class CCustInspectUserSController extends SuperController {

	@Autowired
	private ICCustInspectUserSService cCustInspectUserSService;

	/**
	 * 添加巡检人员
	*/
	@ApiOperation(value = "添加巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.OWNER_ID , value = "所属于" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserSServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.INSERT)
	public Result insert(CCustInspectUserSVO cCustInspectUserSVO) {
		
		Result result=cCustInspectUserSService.insert(cCustInspectUserSVO,false);
		return result;
	}



	/**
	 * 删除巡检人员
	*/
	@ApiOperation(value = "删除巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserSServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustInspectUserSService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustInspectUserSService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustInspectUserSServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustInspectUserSService.hasRefers(ids);
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
			Result result=cCustInspectUserSService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustInspectUserSService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.OWNER_ID , value = "所属于" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectUserSVOMeta.PAGE_INDEX , CCustInspectUserSVOMeta.PAGE_SIZE , CCustInspectUserSVOMeta.SEARCH_FIELD , CCustInspectUserSVOMeta.FUZZY_FIELD , CCustInspectUserSVOMeta.SEARCH_VALUE , CCustInspectUserSVOMeta.DIRTY_FIELDS , CCustInspectUserSVOMeta.SORT_FIELD , CCustInspectUserSVOMeta.SORT_TYPE , CCustInspectUserSVOMeta.DATA_ORIGIN , CCustInspectUserSVOMeta.QUERY_LOGIC , CCustInspectUserSVOMeta.REQUEST_ACTION , CCustInspectUserSVOMeta.IDS } )
	@SentinelResource(value = CCustInspectUserSServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.UPDATE)
	public Result update(CCustInspectUserSVO cCustInspectUserSVO) {
		
		Result result=cCustInspectUserSService.update(cCustInspectUserSVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检人员
	*/
	@ApiOperation(value = "保存巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.OWNER_ID , value = "所属于" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustInspectUserSVOMeta.PAGE_INDEX , CCustInspectUserSVOMeta.PAGE_SIZE , CCustInspectUserSVOMeta.SEARCH_FIELD , CCustInspectUserSVOMeta.FUZZY_FIELD , CCustInspectUserSVOMeta.SEARCH_VALUE , CCustInspectUserSVOMeta.DIRTY_FIELDS , CCustInspectUserSVOMeta.SORT_FIELD , CCustInspectUserSVOMeta.SORT_TYPE , CCustInspectUserSVOMeta.DATA_ORIGIN , CCustInspectUserSVOMeta.QUERY_LOGIC , CCustInspectUserSVOMeta.REQUEST_ACTION , CCustInspectUserSVOMeta.IDS } )
	@SentinelResource(value = CCustInspectUserSServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.SAVE)
	public Result save(CCustInspectUserSVO cCustInspectUserSVO) {
		
		Result result=cCustInspectUserSService.save(cCustInspectUserSVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检人员
	*/
	@ApiOperation(value = "获取巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserSServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.GET_BY_ID)
	public Result<CCustInspectUserS> getById(String id) {
		
		Result<CCustInspectUserS> result=new Result<>();
		CCustInspectUserS cCustInspectUserS=cCustInspectUserSService.getById(id);
		result.success(true).data(cCustInspectUserS);
		return result;
	}


	/**
	 * 批量获取巡检人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustInspectUserSVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustInspectUserSServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.GET_BY_IDS)
	public Result<List<CCustInspectUserS>> getByIds(List<String> ids) {
		
		Result<List<CCustInspectUserS>> result=new Result<>();
		List<CCustInspectUserS> list=cCustInspectUserSService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检人员
	*/
	@ApiOperation(value = "查询巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.OWNER_ID , value = "所属于" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectUserSVOMeta.PAGE_INDEX , CCustInspectUserSVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustInspectUserSServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.QUERY_LIST)
	public Result<List<CCustInspectUserS>> queryList(CCustInspectUserSVO sample) {
		
		Result<List<CCustInspectUserS>> result=new Result<>();
		List<CCustInspectUserS> list=cCustInspectUserSService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检人员
	*/
	@ApiOperation(value = "分页查询巡检人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.OWNER_ID , value = "所属于" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectUserSVOMeta.USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectUserSServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectUserSServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustInspectUserS>> queryPagedList(CCustInspectUserSVO sample) {
		
		Result<PagedList<CCustInspectUserS>> result=new Result<>();
		PagedList<CCustInspectUserS> list=cCustInspectUserSService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}