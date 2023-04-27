package com.dt.platform.ops.controller;

import java.util.*;

import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.ops.service.ICiphertextBoxDataService;
import com.dt.platform.ops.service.ICiphertextBoxService;
import com.github.foxnic.commons.lang.StringUtil;
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


import com.dt.platform.proxy.ops.DbEnvInfoServiceProxy;
import com.dt.platform.domain.ops.meta.DbEnvInfoVOMeta;
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
import com.dt.platform.domain.ops.meta.DbEnvInfoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbEnvInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库环境接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-14 06:01:00
*/

@InDoc
@Api(tags = "数据库环境")
@RestController("OpsDbEnvInfoController")
public class DbEnvInfoController extends SuperController {

	@Autowired
	private IDbEnvInfoService dbEnvInfoService;

	@Autowired
	private ICiphertextBoxService ciphertextBoxService;

	@Autowired
	private ICiphertextBoxDataService ciphertextBoxDataService;

	/**
	 * 添加数据库环境
	*/
	@ApiOperation(value = "添加数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "677563001003311104"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "dev"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB_INST_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbEnvInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.INSERT)
	public Result insert(DbEnvInfoVO dbEnvInfoVO) {
		
		Result result=dbEnvInfoService.insert(dbEnvInfoVO,false);
		return result;
	}



	/**
	 * 删除数据库环境
	*/
	@ApiOperation(value = "删除数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "677563001003311104")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbEnvInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbEnvInfoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbEnvInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库环境 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbEnvInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbEnvInfoService.hasRefers(ids);
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
			Result result=dbEnvInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbEnvInfoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库环境
	*/
	@ApiOperation(value = "更新数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "677563001003311104"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "dev"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB_INST_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbEnvInfoVOMeta.PAGE_INDEX , DbEnvInfoVOMeta.PAGE_SIZE , DbEnvInfoVOMeta.SEARCH_FIELD , DbEnvInfoVOMeta.FUZZY_FIELD , DbEnvInfoVOMeta.SEARCH_VALUE , DbEnvInfoVOMeta.DIRTY_FIELDS , DbEnvInfoVOMeta.SORT_FIELD , DbEnvInfoVOMeta.SORT_TYPE , DbEnvInfoVOMeta.DATA_ORIGIN , DbEnvInfoVOMeta.QUERY_LOGIC , DbEnvInfoVOMeta.REQUEST_ACTION , DbEnvInfoVOMeta.IDS } )
	@SentinelResource(value = DbEnvInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.UPDATE)
	public Result update(DbEnvInfoVO dbEnvInfoVO) {



		Result result=dbEnvInfoService.update(dbEnvInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库环境
	*/
	@ApiOperation(value = "保存数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "677563001003311104"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "dev"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB_INST_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbEnvInfoVOMeta.PAGE_INDEX , DbEnvInfoVOMeta.PAGE_SIZE , DbEnvInfoVOMeta.SEARCH_FIELD , DbEnvInfoVOMeta.FUZZY_FIELD , DbEnvInfoVOMeta.SEARCH_VALUE , DbEnvInfoVOMeta.DIRTY_FIELDS , DbEnvInfoVOMeta.SORT_FIELD , DbEnvInfoVOMeta.SORT_TYPE , DbEnvInfoVOMeta.DATA_ORIGIN , DbEnvInfoVOMeta.QUERY_LOGIC , DbEnvInfoVOMeta.REQUEST_ACTION , DbEnvInfoVOMeta.IDS } )
	@SentinelResource(value = DbEnvInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.SAVE)
	public Result save(DbEnvInfoVO dbEnvInfoVO) {
		
		Result result=dbEnvInfoService.save(dbEnvInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库环境
	*/
	@ApiOperation(value = "获取数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbEnvInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.GET_BY_ID)
	public Result<DbEnvInfo> getById(String id) {
		
		Result<DbEnvInfo> result=new Result<>();
		DbEnvInfo dbEnvInfo=dbEnvInfoService.getById(id);
		// join 关联的对象
		dbEnvInfoService.dao().fill(dbEnvInfo)
			.with("host")
			.with("dbInfo")
			.execute();
		result.success(true).data(dbEnvInfo);
		return result;
	}


	/**
	 * 批量获取数据库环境 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库环境")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbEnvInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbEnvInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.GET_BY_IDS)
	public Result<List<DbEnvInfo>> getByIds(List<String> ids) {
		
		Result<List<DbEnvInfo>> result=new Result<>();
		List<DbEnvInfo> list=dbEnvInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库环境
	*/
	@ApiOperation(value = "查询数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "677563001003311104"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "dev"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB_INST_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbEnvInfoVOMeta.PAGE_INDEX , DbEnvInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbEnvInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.QUERY_LIST)
	public Result<List<DbEnvInfo>> queryList(DbEnvInfoVO sample) {
		
		Result<List<DbEnvInfo>> result=new Result<>();
		List<DbEnvInfo> list=dbEnvInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库环境
	*/
	@ApiOperation(value = "分页查询数据库环境")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbEnvInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "677563001003311104"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class , example = "dev"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB_INST_ID , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.DB , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbEnvInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbEnvInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbEnvInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbEnvInfo>> queryPagedList(DbEnvInfoVO sample) {
		
		Result<PagedList<DbEnvInfo>> result=new Result<>();
		PagedList<DbEnvInfo> list=dbEnvInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbEnvInfoService.dao().fill(list)
			.with(DbEnvInfoMeta.CIPHERTEXT_BOX_DATA)
			.with("host")
			.with("dbInfo")
				.with("dbInfo")
			.execute();
		boolean hasPriv=false;

		if(ciphertextBoxService.userEnDePermByBoxType("database_instance_other")){
			hasPriv=true;
		}
		List<DbEnvInfo> list2=list.getList();
		for(int i=0;i<list2.size();i++){
			if(!hasPriv){
				list2.get(i).setVoucher("没有解密权限，不能查看");
				continue;
			}
			if(!StringUtil.isBlank(list2.get(i).getCiphertextBoxData())){
				//进行解密
				CiphertextBoxData box=list2.get(i).getCiphertextBoxData();
				CiphertextBoxData afterBox=ciphertextBoxDataService.getById(box.getId());
				list2.get(i).setVoucher(afterBox.getPlaintext());
			}else{
				list2.get(i).setVoucher("");
			}
		}
		result.success(true).data(list);

		result.success(true).data(list);
		return result;
	}





}