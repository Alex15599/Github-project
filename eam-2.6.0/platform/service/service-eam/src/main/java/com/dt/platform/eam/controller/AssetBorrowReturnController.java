package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetCollectionReturnVOMeta;
import com.dt.platform.proxy.eam.AssetCollectionReturnServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.eam.AssetBorrowReturnServiceProxy;
import com.dt.platform.domain.eam.meta.AssetBorrowReturnVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetBorrowReturnMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetBorrowReturnService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产归还接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 10:13:24
*/

@InDoc
@Api(tags = "资产归还")
@RestController("EamAssetBorrowReturnController")
public class AssetBorrowReturnController extends SuperController {

	@Autowired
	private IAssetBorrowReturnService assetBorrowReturnService;


	/**
	 * 添加资产归还
	*/
	@ApiOperation(value = "添加资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID , value = "归还后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_ID , value = "归还后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_USER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetBorrowReturnServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.INSERT)
	public Result insert(AssetBorrowReturnVO assetBorrowReturnVO) {
		Result result=assetBorrowReturnService.insert(assetBorrowReturnVO,false);
		return result;
	}



	/**
	 * 删除资产归还
	*/
	@ApiOperation(value = "删除资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetBorrowReturnServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetBorrowReturnService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=assetBorrowReturnService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产归还 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetBorrowReturnServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetBorrowReturnService.hasRefers(ids);
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
			Result result=assetBorrowReturnService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetBorrowReturnService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新资产归还
	*/
	@ApiOperation(value = "更新资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID , value = "归还后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_ID , value = "归还后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_USER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetBorrowReturnVOMeta.PAGE_INDEX , AssetBorrowReturnVOMeta.PAGE_SIZE , AssetBorrowReturnVOMeta.SEARCH_FIELD , AssetBorrowReturnVOMeta.FUZZY_FIELD , AssetBorrowReturnVOMeta.SEARCH_VALUE , AssetBorrowReturnVOMeta.DIRTY_FIELDS , AssetBorrowReturnVOMeta.SORT_FIELD , AssetBorrowReturnVOMeta.SORT_TYPE , AssetBorrowReturnVOMeta.IDS } )
	@SentinelResource(value = AssetBorrowReturnServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.UPDATE)
	public Result update(AssetBorrowReturnVO assetBorrowReturnVO) {
		Result result=assetBorrowReturnService.update(assetBorrowReturnVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产归还
	*/
	@ApiOperation(value = "保存资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID , value = "归还后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_ID , value = "归还后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_USER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowReturnVOMeta.PAGE_INDEX , AssetBorrowReturnVOMeta.PAGE_SIZE , AssetBorrowReturnVOMeta.SEARCH_FIELD , AssetBorrowReturnVOMeta.FUZZY_FIELD , AssetBorrowReturnVOMeta.SEARCH_VALUE , AssetBorrowReturnVOMeta.DIRTY_FIELDS , AssetBorrowReturnVOMeta.SORT_FIELD , AssetBorrowReturnVOMeta.SORT_TYPE , AssetBorrowReturnVOMeta.IDS } )
	@SentinelResource(value = AssetBorrowReturnServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.SAVE)
	public Result save(AssetBorrowReturnVO assetBorrowReturnVO) {
		Result result=assetBorrowReturnService.save(assetBorrowReturnVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产归还
	*/
	@ApiOperation(value = "获取资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetBorrowReturnServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.GET_BY_ID)
	public Result<AssetBorrowReturn> getById(String id) {
		Result<AssetBorrowReturn> result=new Result<>();
		AssetBorrowReturn assetBorrowReturn=assetBorrowReturnService.getById(id);
		// join 关联的对象
		assetBorrowReturnService.dao().fill(assetBorrowReturn)
			.with("originator")
			.with(AssetBorrowReturnMeta.POSITION)
				.with(AssetBorrowReturnMeta.USE_USER)
				.with(AssetBorrowReturnMeta.USE_ORGANIZATION)
				.with(AssetBorrowReturnMeta.MANAGER)
			.execute();
		assetBorrowReturnService.dao().join(assetBorrowReturn.getOriginator(), Person.class);
		assetBorrowReturnService.dao().join(assetBorrowReturn.getManager(), Person.class);
		assetBorrowReturnService.dao().join(assetBorrowReturn.getUseUser(), Person.class);


		result.success(true).data(assetBorrowReturn);
		return result;
	}


	/**
	 * 批量获取资产归还 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产归还")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetBorrowReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetBorrowReturnServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.GET_BY_IDS)
	public Result<List<AssetBorrowReturn>> getByIds(List<String> ids) {
		Result<List<AssetBorrowReturn>> result=new Result<>();
		List<AssetBorrowReturn> list=assetBorrowReturnService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产归还
	*/
	@ApiOperation(value = "查询资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID , value = "归还后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_ID , value = "归还后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_USER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetBorrowReturnVOMeta.PAGE_INDEX , AssetBorrowReturnVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetBorrowReturnServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.QUERY_LIST)
	public Result<List<AssetBorrowReturn>> queryList(AssetBorrowReturnVO sample) {
		Result<List<AssetBorrowReturn>> result=new Result<>();
		List<AssetBorrowReturn> list=assetBorrowReturnService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产归还
	*/
	@ApiOperation(value = "分页查询资产归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID , value = "归还后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_ID , value = "归还后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.USE_USER_ID , value = "使用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetBorrowReturnServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetBorrowReturn>> queryPagedList(AssetBorrowReturnVO sample) {
		Result<PagedList<AssetBorrowReturn>> result=new Result<>();
		PagedList<AssetBorrowReturn> list=assetBorrowReturnService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetBorrowReturnService.dao().fill(list)
			.with("originator")
				.with(AssetBorrowReturnMeta.POSITION)
				.with(AssetBorrowReturnMeta.USE_USER)
				.with(AssetBorrowReturnMeta.USE_ORGANIZATION)
				.with(AssetBorrowReturnMeta.MANAGER)
			.execute();

		List<Employee> originatorList = CollectorUtil.collectList(list.getList(), AssetBorrowReturn::getOriginator);
		List<Employee> managerList = CollectorUtil.collectList(list.getList(), AssetBorrowReturn::getManager);
		List<Employee> userList = CollectorUtil.collectList(list.getList(), AssetBorrowReturn::getUseUser);
		assetBorrowReturnService.dao().join(originatorList, Person.class);
		assetBorrowReturnService.dao().join(managerList, Person.class);
		assetBorrowReturnService.dao().join(userList, Person.class);

		result.success(true).data(list);
		return result;
	}



	/**
	 * 确认
	 */
	@ApiOperation(value = "借用归还确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
	@ApiOperationSupport(order = 13)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.CONFIRM_OPERATION, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(AssetBorrowReturnServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id) {
		return assetBorrowReturnService.confirmOperation(id);
	}


}