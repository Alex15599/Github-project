package com.dt.platform.ops.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.domain.ops.SoftwareBaseVersion;
import com.dt.platform.domain.ops.SoftwareBaseVersionVO;
import com.dt.platform.domain.ops.meta.SoftwareBaseVersionMeta;
import com.dt.platform.domain.ops.meta.SoftwareBaseVersionVOMeta;
import com.dt.platform.ops.service.ISoftwareBaseVersionService;
import com.dt.platform.proxy.ops.SoftwareBaseVersionServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 软件基线版本接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 07:34:18
*/

@InDoc
@Api(tags = "软件基线版本")
@RestController("OpsSoftwareBaseVersionController")
public class SoftwareBaseVersionController extends SuperController {

	@Autowired
	private ISoftwareBaseVersionService softwareBaseVersionService;


	/**
	 * 添加软件基线版本
	*/
	@ApiOperation(value = "添加软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.INSERT)
	public Result insert(SoftwareBaseVersionVO softwareBaseVersionVO) {
		Result result=softwareBaseVersionService.insert(softwareBaseVersionVO,false);
		return result;
	}



	/**
	 * 删除软件基线版本
	*/
	@ApiOperation(value = "删除软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  softwareBaseVersionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=softwareBaseVersionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件基线版本 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = softwareBaseVersionService.hasRefers(ids);
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
			Result result=softwareBaseVersionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=softwareBaseVersionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新软件基线版本
	*/
	@ApiOperation(value = "更新软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SoftwareBaseVersionVOMeta.PAGE_INDEX , SoftwareBaseVersionVOMeta.PAGE_SIZE , SoftwareBaseVersionVOMeta.SEARCH_FIELD , SoftwareBaseVersionVOMeta.FUZZY_FIELD , SoftwareBaseVersionVOMeta.SEARCH_VALUE , SoftwareBaseVersionVOMeta.DIRTY_FIELDS , SoftwareBaseVersionVOMeta.SORT_FIELD , SoftwareBaseVersionVOMeta.SORT_TYPE , SoftwareBaseVersionVOMeta.IDS } )
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.UPDATE)
	public Result update(SoftwareBaseVersionVO softwareBaseVersionVO) {
		Result result=softwareBaseVersionService.update(softwareBaseVersionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件基线版本
	*/
	@ApiOperation(value = "保存软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SoftwareBaseVersionVOMeta.PAGE_INDEX , SoftwareBaseVersionVOMeta.PAGE_SIZE , SoftwareBaseVersionVOMeta.SEARCH_FIELD , SoftwareBaseVersionVOMeta.FUZZY_FIELD , SoftwareBaseVersionVOMeta.SEARCH_VALUE , SoftwareBaseVersionVOMeta.DIRTY_FIELDS , SoftwareBaseVersionVOMeta.SORT_FIELD , SoftwareBaseVersionVOMeta.SORT_TYPE , SoftwareBaseVersionVOMeta.IDS } )
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.SAVE)
	public Result save(SoftwareBaseVersionVO softwareBaseVersionVO) {
		Result result=softwareBaseVersionService.save(softwareBaseVersionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件基线版本
	*/
	@ApiOperation(value = "获取软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.GET_BY_ID)
	public Result<SoftwareBaseVersion> getById(String id) {
		Result<SoftwareBaseVersion> result=new Result<>();
		SoftwareBaseVersion softwareBaseVersion=softwareBaseVersionService.getById(id);
		// join 关联的对象
		softwareBaseVersionService.dao().fill(softwareBaseVersion)
			.with(SoftwareBaseVersionMeta.SOFTWARE_BASE_TYPE)
			.execute();
		result.success(true).data(softwareBaseVersion);
		return result;
	}


	/**
	 * 批量获取软件基线版本 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件基线版本")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SoftwareBaseVersionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.GET_BY_IDS)
	public Result<List<SoftwareBaseVersion>> getByIds(List<String> ids) {
		Result<List<SoftwareBaseVersion>> result=new Result<>();
		List<SoftwareBaseVersion> list=softwareBaseVersionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件基线版本
	*/
	@ApiOperation(value = "查询软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SoftwareBaseVersionVOMeta.PAGE_INDEX , SoftwareBaseVersionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.QUERY_LIST)
	public Result<List<SoftwareBaseVersion>> queryList(SoftwareBaseVersionVO sample) {
		Result<List<SoftwareBaseVersion>> result=new Result<>();
		List<SoftwareBaseVersion> list=softwareBaseVersionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件基线版本
	*/
	@ApiOperation(value = "分页查询软件基线版本")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "593892461445652480"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class , example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.SOFTWARE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "7.9"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.PATCH_INFO , value = "补丁" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "effect"),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.USAGE_SCENARIOS , value = "使用场景" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.FILE_ID , value = "软件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SoftwareBaseVersionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareBaseVersionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareBaseVersionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SoftwareBaseVersion>> queryPagedList(SoftwareBaseVersionVO sample) {
		Result<PagedList<SoftwareBaseVersion>> result=new Result<>();
		PagedList<SoftwareBaseVersion> list=softwareBaseVersionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		softwareBaseVersionService.dao().fill(list)
			.with(SoftwareBaseVersionMeta.SOFTWARE_BASE_TYPE)
			.execute();
		result.success(true).data(list);
		return result;
	}






}