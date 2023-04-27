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


import com.dt.platform.proxy.hr.CertificateTypeServiceProxy;
import com.dt.platform.domain.hr.meta.CertificateTypeVOMeta;
import com.dt.platform.domain.hr.CertificateType;
import com.dt.platform.domain.hr.CertificateTypeVO;
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
import com.dt.platform.domain.hr.meta.CertificateTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.hr.service.ICertificateTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 09:41:58
*/

@InDoc
@Api(tags = "证书类型")
@RestController("HrCertificateTypeController")
public class CertificateTypeController extends SuperController {

	@Autowired
	private ICertificateTypeService certificateTypeService;


	/**
	 * 添加证书类型
	*/
	@ApiOperation(value = "添加证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.INSERT)
	public Result insert(CertificateTypeVO certificateTypeVO) {
		Result result=certificateTypeService.insert(certificateTypeVO,false);
		return result;
	}



	/**
	 * 删除证书类型
	*/
	@ApiOperation(value = "删除证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  certificateTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=certificateTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除证书类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CertificateTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = certificateTypeService.hasRefers(ids);
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
			Result result=certificateTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=certificateTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新证书类型
	*/
	@ApiOperation(value = "更新证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CertificateTypeVOMeta.PAGE_INDEX , CertificateTypeVOMeta.PAGE_SIZE , CertificateTypeVOMeta.SEARCH_FIELD , CertificateTypeVOMeta.FUZZY_FIELD , CertificateTypeVOMeta.SEARCH_VALUE , CertificateTypeVOMeta.DIRTY_FIELDS , CertificateTypeVOMeta.SORT_FIELD , CertificateTypeVOMeta.SORT_TYPE , CertificateTypeVOMeta.DATA_ORIGIN , CertificateTypeVOMeta.QUERY_LOGIC , CertificateTypeVOMeta.IDS } )
	@SentinelResource(value = CertificateTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.UPDATE)
	public Result update(CertificateTypeVO certificateTypeVO) {
		Result result=certificateTypeService.update(certificateTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存证书类型
	*/
	@ApiOperation(value = "保存证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateTypeVOMeta.PAGE_INDEX , CertificateTypeVOMeta.PAGE_SIZE , CertificateTypeVOMeta.SEARCH_FIELD , CertificateTypeVOMeta.FUZZY_FIELD , CertificateTypeVOMeta.SEARCH_VALUE , CertificateTypeVOMeta.DIRTY_FIELDS , CertificateTypeVOMeta.SORT_FIELD , CertificateTypeVOMeta.SORT_TYPE , CertificateTypeVOMeta.DATA_ORIGIN , CertificateTypeVOMeta.QUERY_LOGIC , CertificateTypeVOMeta.IDS } )
	@SentinelResource(value = CertificateTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.SAVE)
	public Result save(CertificateTypeVO certificateTypeVO) {
		Result result=certificateTypeService.save(certificateTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取证书类型
	*/
	@ApiOperation(value = "获取证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.GET_BY_ID)
	public Result<CertificateType> getById(String id) {
		Result<CertificateType> result=new Result<>();
		CertificateType certificateType=certificateTypeService.getById(id);
		result.success(true).data(certificateType);
		return result;
	}


	/**
	 * 批量获取证书类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取证书类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CertificateTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CertificateTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.GET_BY_IDS)
	public Result<List<CertificateType>> getByIds(List<String> ids) {
		Result<List<CertificateType>> result=new Result<>();
		List<CertificateType> list=certificateTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询证书类型
	*/
	@ApiOperation(value = "查询证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CertificateTypeVOMeta.PAGE_INDEX , CertificateTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CertificateTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.QUERY_LIST)
	public Result<List<CertificateType>> queryList(CertificateTypeVO sample) {
		Result<List<CertificateType>> result=new Result<>();
		List<CertificateType> list=certificateTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询证书类型
	*/
	@ApiOperation(value = "分页查询证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTE , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CertificateTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CertificateType>> queryPagedList(CertificateTypeVO sample) {
		Result<PagedList<CertificateType>> result=new Result<>();
		PagedList<CertificateType> list=certificateTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}