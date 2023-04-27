package com.dt.platform.ops.controller;

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


import com.dt.platform.proxy.ops.PublicContentServiceProxy;
import com.dt.platform.domain.ops.meta.PublicContentVOMeta;
import com.dt.platform.domain.ops.PublicContent;
import com.dt.platform.domain.ops.PublicContentVO;
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
import com.dt.platform.domain.ops.meta.PublicContentMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IPublicContentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 开放列接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-04 15:55:13
*/

@InDoc
@Api(tags = "开放列")
@RestController("OpsPublicContentController")
public class PublicContentController extends SuperController {

	@Autowired
	private IPublicContentService publicContentService;


	/**
	 * 添加开放列
	*/
	@ApiOperation(value = "添加开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "673971266721415168"),
		@ApiImplicitParam(name = PublicContentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PublicContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "list"),
		@ApiImplicitParam(name = PublicContentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "(仅内部使用误外传)-数据库例列表-(生产环境)"),
		@ApiImplicitParam(name = PublicContentVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html"),
		@ApiImplicitParam(name = PublicContentVOMeta.FILES , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PublicContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询"),
		@ApiImplicitParam(name = PublicContentVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "100"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PublicContentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.INSERT)
	public Result insert(PublicContentVO publicContentVO) {
		Result result=publicContentService.insert(publicContentVO,false);
		return result;
	}



	/**
	 * 删除开放列
	*/
	@ApiOperation(value = "删除开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "673971266721415168")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PublicContentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  publicContentService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=publicContentService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除开放列 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PublicContentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = publicContentService.hasRefers(ids);
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
			Result result=publicContentService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=publicContentService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新开放列
	*/
	@ApiOperation(value = "更新开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "673971266721415168"),
		@ApiImplicitParam(name = PublicContentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PublicContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "list"),
		@ApiImplicitParam(name = PublicContentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "(仅内部使用误外传)-数据库例列表-(生产环境)"),
		@ApiImplicitParam(name = PublicContentVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html"),
		@ApiImplicitParam(name = PublicContentVOMeta.FILES , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PublicContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询"),
		@ApiImplicitParam(name = PublicContentVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "100"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PublicContentVOMeta.PAGE_INDEX , PublicContentVOMeta.PAGE_SIZE , PublicContentVOMeta.SEARCH_FIELD , PublicContentVOMeta.FUZZY_FIELD , PublicContentVOMeta.SEARCH_VALUE , PublicContentVOMeta.DIRTY_FIELDS , PublicContentVOMeta.SORT_FIELD , PublicContentVOMeta.SORT_TYPE , PublicContentVOMeta.DATA_ORIGIN , PublicContentVOMeta.QUERY_LOGIC , PublicContentVOMeta.IDS } )
	@SentinelResource(value = PublicContentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.UPDATE)
	public Result update(PublicContentVO publicContentVO) {
		Result result=publicContentService.update(publicContentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存开放列
	*/
	@ApiOperation(value = "保存开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "673971266721415168"),
		@ApiImplicitParam(name = PublicContentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PublicContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "list"),
		@ApiImplicitParam(name = PublicContentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "(仅内部使用误外传)-数据库例列表-(生产环境)"),
		@ApiImplicitParam(name = PublicContentVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html"),
		@ApiImplicitParam(name = PublicContentVOMeta.FILES , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PublicContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询"),
		@ApiImplicitParam(name = PublicContentVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "100"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PublicContentVOMeta.PAGE_INDEX , PublicContentVOMeta.PAGE_SIZE , PublicContentVOMeta.SEARCH_FIELD , PublicContentVOMeta.FUZZY_FIELD , PublicContentVOMeta.SEARCH_VALUE , PublicContentVOMeta.DIRTY_FIELDS , PublicContentVOMeta.SORT_FIELD , PublicContentVOMeta.SORT_TYPE , PublicContentVOMeta.DATA_ORIGIN , PublicContentVOMeta.QUERY_LOGIC , PublicContentVOMeta.IDS } )
	@SentinelResource(value = PublicContentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.SAVE)
	public Result save(PublicContentVO publicContentVO) {
		Result result=publicContentService.save(publicContentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取开放列
	*/
	@ApiOperation(value = "获取开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PublicContentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.GET_BY_ID)
	public Result<PublicContent> getById(String id) {
		Result<PublicContent> result=new Result<>();
		PublicContent publicContent=publicContentService.getById(id);
		// join 关联的对象
		publicContentService.dao().fill(publicContent)
			.with(PublicContentMeta.TYPE_DATA)
			.execute();
		result.success(true).data(publicContent);
		return result;
	}


	/**
	 * 批量获取开放列 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取开放列")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PublicContentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PublicContentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.GET_BY_IDS)
	public Result<List<PublicContent>> getByIds(List<String> ids) {
		Result<List<PublicContent>> result=new Result<>();
		List<PublicContent> list=publicContentService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询开放列
	*/
	@ApiOperation(value = "查询开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "673971266721415168"),
		@ApiImplicitParam(name = PublicContentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PublicContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "list"),
		@ApiImplicitParam(name = PublicContentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "(仅内部使用误外传)-数据库例列表-(生产环境)"),
		@ApiImplicitParam(name = PublicContentVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html"),
		@ApiImplicitParam(name = PublicContentVOMeta.FILES , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PublicContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询"),
		@ApiImplicitParam(name = PublicContentVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "100"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PublicContentVOMeta.PAGE_INDEX , PublicContentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PublicContentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.QUERY_LIST)
	public Result<List<PublicContent>> queryList(PublicContentVO sample) {
		Result<List<PublicContent>> result=new Result<>();
		List<PublicContent> list=publicContentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询开放列
	*/
	@ApiOperation(value = "分页查询开放列")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PublicContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "673971266721415168"),
		@ApiImplicitParam(name = PublicContentVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = PublicContentVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "list"),
		@ApiImplicitParam(name = PublicContentVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "(仅内部使用误外传)-数据库例列表-(生产环境)"),
		@ApiImplicitParam(name = PublicContentVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html"),
		@ApiImplicitParam(name = PublicContentVOMeta.FILES , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PublicContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询"),
		@ApiImplicitParam(name = PublicContentVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "100"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PublicContentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PublicContentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PublicContent>> queryPagedList(PublicContentVO sample) {
		Result<PagedList<PublicContent>> result=new Result<>();
		PagedList<PublicContent> list=publicContentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		publicContentService.dao().fill(list)
			.with(PublicContentMeta.TYPE_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}






}