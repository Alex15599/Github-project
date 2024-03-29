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


import com.dt.platform.proxy.hr.PersonCertServiceProxy;
import com.dt.platform.domain.hr.meta.PersonCertVOMeta;
import com.dt.platform.domain.hr.PersonCert;
import com.dt.platform.domain.hr.PersonCertVO;
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
import com.dt.platform.domain.hr.meta.PersonCertMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.IPersonCertService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员证书接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:12:49
*/

@InDoc
@Api(tags = "人员证书")
@RestController("HrPersonCertController")
public class PersonCertController extends SuperController {

	@Autowired
	private IPersonCertService personCertService;


	/**
	 * 添加人员证书
	*/
	@ApiOperation(value = "添加人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.CERT_ID , value = "证书" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonCertServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.INSERT)
	public Result insert(PersonCertVO personCertVO) {
		Result result=personCertService.insert(personCertVO,false);
		return result;
	}



	/**
	 * 删除人员证书
	*/
	@ApiOperation(value = "删除人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonCertServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  personCertService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=personCertService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除人员证书 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PersonCertServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = personCertService.hasRefers(ids);
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
			Result result=personCertService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=personCertService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新人员证书
	*/
	@ApiOperation(value = "更新人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.CERT_ID , value = "证书" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonCertVOMeta.PAGE_INDEX , PersonCertVOMeta.PAGE_SIZE , PersonCertVOMeta.SEARCH_FIELD , PersonCertVOMeta.FUZZY_FIELD , PersonCertVOMeta.SEARCH_VALUE , PersonCertVOMeta.DIRTY_FIELDS , PersonCertVOMeta.SORT_FIELD , PersonCertVOMeta.SORT_TYPE , PersonCertVOMeta.DATA_ORIGIN , PersonCertVOMeta.QUERY_LOGIC , PersonCertVOMeta.IDS } )
	@SentinelResource(value = PersonCertServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.UPDATE)
	public Result update(PersonCertVO personCertVO) {
		Result result=personCertService.update(personCertVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存人员证书
	*/
	@ApiOperation(value = "保存人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.CERT_ID , value = "证书" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PersonCertVOMeta.PAGE_INDEX , PersonCertVOMeta.PAGE_SIZE , PersonCertVOMeta.SEARCH_FIELD , PersonCertVOMeta.FUZZY_FIELD , PersonCertVOMeta.SEARCH_VALUE , PersonCertVOMeta.DIRTY_FIELDS , PersonCertVOMeta.SORT_FIELD , PersonCertVOMeta.SORT_TYPE , PersonCertVOMeta.DATA_ORIGIN , PersonCertVOMeta.QUERY_LOGIC , PersonCertVOMeta.IDS } )
	@SentinelResource(value = PersonCertServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.SAVE)
	public Result save(PersonCertVO personCertVO) {
		Result result=personCertService.save(personCertVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取人员证书
	*/
	@ApiOperation(value = "获取人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonCertServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.GET_BY_ID)
	public Result<PersonCert> getById(String id) {
		Result<PersonCert> result=new Result<>();
		PersonCert personCert=personCertService.getById(id);
		result.success(true).data(personCert);
		return result;
	}


	/**
	 * 批量获取人员证书 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取人员证书")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PersonCertVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PersonCertServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.GET_BY_IDS)
	public Result<List<PersonCert>> getByIds(List<String> ids) {
		Result<List<PersonCert>> result=new Result<>();
		List<PersonCert> list=personCertService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询人员证书
	*/
	@ApiOperation(value = "查询人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.CERT_ID , value = "证书" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PersonCertVOMeta.PAGE_INDEX , PersonCertVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PersonCertServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.QUERY_LIST)
	public Result<List<PersonCert>> queryList(PersonCertVO sample) {
		Result<List<PersonCert>> result=new Result<>();
		List<PersonCert> list=personCertService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询人员证书
	*/
	@ApiOperation(value = "分页查询人员证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PersonCertVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.PERSON_ID , value = "人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PersonCertVOMeta.CERT_ID , value = "证书" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PersonCertServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PersonCertServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PersonCert>> queryPagedList(PersonCertVO sample) {
		Result<PagedList<PersonCert>> result=new Result<>();
		PagedList<PersonCert> list=personCertService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}