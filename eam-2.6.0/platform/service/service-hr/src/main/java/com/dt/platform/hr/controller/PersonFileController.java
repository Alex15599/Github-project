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


import com.dt.platform.proxy.hr.PersonFileServiceProxy;
import com.dt.platform.domain.hr.meta.PersonFileVOMeta;
import com.dt.platform.domain.hr.PersonFile;
import com.dt.platform.domain.hr.PersonFileVO;
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
import com.dt.platform.domain.hr.meta.PersonFileMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonFileService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员档案接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:18:22
*/

@InDoc
@Api(tags = "人员档案")
@RestController("HrPersonFileController")
public class PersonFileController extends SuperController {

	@Autowired
	private IPersonFileService personFileService;


	/**
	 * 添加人员档案
	*/
	@ApiOperation(value = "添加人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.CODE , value = "档案编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.STATUS , value = "档案状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.IF_NEW , value = "是否新建档" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.SAVE_LOC , value = "档案保管地" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.WORK_START_DATE , value = "参加工作时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.FILE , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.INSERT)
	public Result insert(PersonFileVO personFileVO) {
		Result result=personFileService.insert(personFileVO,false);
		return result;
	}



	/**
	 * 删除人员档案
	*/
	@ApiOperation(value = "删除人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personFileService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personFileService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员档案 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonFileServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personFileService.hasRefers(ids);
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
			Result result=personFileService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personFileService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新人员档案
	*/
	@ApiOperation(value = "更新人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.CODE , value = "档案编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.STATUS , value = "档案状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.IF_NEW , value = "是否新建档" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.SAVE_LOC , value = "档案保管地" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.WORK_START_DATE , value = "参加工作时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.FILE , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonFileVOMeta.PAGE_INDEX , PersonFileVOMeta.PAGE_SIZE , PersonFileVOMeta.SEARCH_FIELD , PersonFileVOMeta.FUZZY_FIELD , PersonFileVOMeta.SEARCH_VALUE , PersonFileVOMeta.DIRTY_FIELDS , PersonFileVOMeta.SORT_FIELD , PersonFileVOMeta.SORT_TYPE , PersonFileVOMeta.DATA_ORIGIN , PersonFileVOMeta.QUERY_LOGIC , PersonFileVOMeta.IDS } )
	@SentinelResource(value = PersonFileServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.UPDATE)
	public Result update(PersonFileVO personFileVO) {
		Result result=personFileService.update(personFileVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员档案
	*/
	@ApiOperation(value = "保存人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.CODE , value = "档案编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.STATUS , value = "档案状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.IF_NEW , value = "是否新建档" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.SAVE_LOC , value = "档案保管地" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.WORK_START_DATE , value = "参加工作时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.FILE , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonFileVOMeta.PAGE_INDEX , PersonFileVOMeta.PAGE_SIZE , PersonFileVOMeta.SEARCH_FIELD , PersonFileVOMeta.FUZZY_FIELD , PersonFileVOMeta.SEARCH_VALUE , PersonFileVOMeta.DIRTY_FIELDS , PersonFileVOMeta.SORT_FIELD , PersonFileVOMeta.SORT_TYPE , PersonFileVOMeta.DATA_ORIGIN , PersonFileVOMeta.QUERY_LOGIC , PersonFileVOMeta.IDS } )
	@SentinelResource(value = PersonFileServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.SAVE)
	public Result save(PersonFileVO personFileVO) {
		Result result=personFileService.save(personFileVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员档案
	*/
	@ApiOperation(value = "获取人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.GET_BY_ID)
	public Result<PersonFile> getById(String id) {
		Result<PersonFile> result=new Result<>();
		PersonFile personFile=personFileService.getById(id);
		result.success(true).data(personFile);
		return result;
	}


	/**
	 * 批量获取人员档案 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员档案")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonFileServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.GET_BY_IDS)
	public Result<List<PersonFile>> getByIds(List<String> ids) {
		Result<List<PersonFile>> result=new Result<>();
		List<PersonFile> list=personFileService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员档案
	*/
	@ApiOperation(value = "查询人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.CODE , value = "档案编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.STATUS , value = "档案状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.IF_NEW , value = "是否新建档" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.SAVE_LOC , value = "档案保管地" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.WORK_START_DATE , value = "参加工作时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.FILE , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonFileVOMeta.PAGE_INDEX , PersonFileVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonFileServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.QUERY_LIST)
	public Result<List<PersonFile>> queryList(PersonFileVO sample) {
		Result<List<PersonFile>> result=new Result<>();
		List<PersonFile> list=personFileService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员档案
	*/
	@ApiOperation(value = "分页查询人员档案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.CODE , value = "档案编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.STATUS , value = "档案状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.IF_NEW , value = "是否新建档" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.SAVE_LOC , value = "档案保管地" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.WORK_START_DATE , value = "参加工作时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.FILE , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonFileVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonFileServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonFileServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonFile>> queryPagedList(PersonFileVO sample) {
		Result<PagedList<PersonFile>> result=new Result<>();
		PagedList<PersonFile> list=personFileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}