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


import com.dt.platform.proxy.hr.CertificateServiceProxy;
import com.dt.platform.domain.hr.meta.CertificateVOMeta;
import com.dt.platform.domain.hr.Certificate;
import com.dt.platform.domain.hr.CertificateVO;
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
import com.dt.platform.domain.hr.meta.CertificateMeta;
import com.dt.platform.domain.hr.CertificateType;
import com.dt.platform.domain.hr.CertificateLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ICertificateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书管理接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 09:46:21
*/

@InDoc
@Api(tags = "证书管理")
@RestController("HrCertificateController")
public class CertificateController extends SuperController {

	@Autowired
	private ICertificateService certificateService;


	/**
	 * 添加证书管理
	*/
	@ApiOperation(value = "添加证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.CERT_LEVEL , value = "级别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.INSERT)
	public Result insert(CertificateVO certificateVO) {
		Result result=certificateService.insert(certificateVO,false);
		return result;
	}



	/**
	 * 删除证书管理
	*/
	@ApiOperation(value = "删除证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  certificateService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=certificateService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除证书管理 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CertificateServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = certificateService.hasRefers(ids);
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
			Result result=certificateService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=certificateService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新证书管理
	*/
	@ApiOperation(value = "更新证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.CERT_LEVEL , value = "级别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CertificateVOMeta.PAGE_INDEX , CertificateVOMeta.PAGE_SIZE , CertificateVOMeta.SEARCH_FIELD , CertificateVOMeta.FUZZY_FIELD , CertificateVOMeta.SEARCH_VALUE , CertificateVOMeta.DIRTY_FIELDS , CertificateVOMeta.SORT_FIELD , CertificateVOMeta.SORT_TYPE , CertificateVOMeta.DATA_ORIGIN , CertificateVOMeta.QUERY_LOGIC , CertificateVOMeta.IDS } )
	@SentinelResource(value = CertificateServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.UPDATE)
	public Result update(CertificateVO certificateVO) {
		Result result=certificateService.update(certificateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存证书管理
	*/
	@ApiOperation(value = "保存证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.CERT_LEVEL , value = "级别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateVOMeta.PAGE_INDEX , CertificateVOMeta.PAGE_SIZE , CertificateVOMeta.SEARCH_FIELD , CertificateVOMeta.FUZZY_FIELD , CertificateVOMeta.SEARCH_VALUE , CertificateVOMeta.DIRTY_FIELDS , CertificateVOMeta.SORT_FIELD , CertificateVOMeta.SORT_TYPE , CertificateVOMeta.DATA_ORIGIN , CertificateVOMeta.QUERY_LOGIC , CertificateVOMeta.IDS } )
	@SentinelResource(value = CertificateServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.SAVE)
	public Result save(CertificateVO certificateVO) {
		Result result=certificateService.save(certificateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取证书管理
	*/
	@ApiOperation(value = "获取证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.GET_BY_ID)
	public Result<Certificate> getById(String id) {
		Result<Certificate> result=new Result<>();
		Certificate certificate=certificateService.getById(id);
		// join 关联的对象
		certificateService.dao().fill(certificate)
			.with(CertificateMeta.CERTIFICATE_TYPE)
			.with(CertificateMeta.CERTIFICATE_LEVEL)
			.execute();
		result.success(true).data(certificate);
		return result;
	}


	/**
	 * 批量获取证书管理 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取证书管理")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CertificateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CertificateServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.GET_BY_IDS)
	public Result<List<Certificate>> getByIds(List<String> ids) {
		Result<List<Certificate>> result=new Result<>();
		List<Certificate> list=certificateService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询证书管理
	*/
	@ApiOperation(value = "查询证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.CERT_LEVEL , value = "级别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CertificateVOMeta.PAGE_INDEX , CertificateVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CertificateServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.QUERY_LIST)
	public Result<List<Certificate>> queryList(CertificateVO sample) {
		Result<List<Certificate>> result=new Result<>();
		List<Certificate> list=certificateService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询证书管理
	*/
	@ApiOperation(value = "分页查询证书管理")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.CERT_LEVEL , value = "级别" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Certificate>> queryPagedList(CertificateVO sample) {
		Result<PagedList<Certificate>> result=new Result<>();
		PagedList<Certificate> list=certificateService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		certificateService.dao().fill(list)
			.with(CertificateMeta.CERTIFICATE_TYPE)
			.with(CertificateMeta.CERTIFICATE_LEVEL)
			.execute();
		result.success(true).data(list);
		return result;
	}






}