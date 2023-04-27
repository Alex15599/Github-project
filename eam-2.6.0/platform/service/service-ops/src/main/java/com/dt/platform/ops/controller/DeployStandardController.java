package com.dt.platform.ops.controller;


import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.ops.DeployStandardServiceProxy;
import com.dt.platform.domain.ops.meta.DeployStandardVOMeta;
import com.dt.platform.domain.ops.DeployStandard;
import com.dt.platform.domain.ops.DeployStandardVO;
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
import com.dt.platform.domain.ops.meta.DeployStandardMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDeployStandardService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 部署标准接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 09:20:28
*/

@InDoc
@Api(tags = "部署标准")
@RestController("OpsDeployStandardController")
public class DeployStandardController extends SuperController {

	@Autowired
	private IDeployStandardService deployStandardService;


	/**
	 * 添加部署标准
	*/
	@ApiOperation(value = "添加部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "640473848730353664"),
		@ApiImplicitParam(name = DeployStandardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Mysql数据库"),
		@ApiImplicitParam(name = DeployStandardVOMeta.TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.USER_CONTENT , value = "用户标准" , required = false , dataTypeClass=String.class , example = "操作系统用户 mysql  数据库用户 管理员:root 应用:app"),
		@ApiImplicitParam(name = DeployStandardVOMeta.DIR_CONTENT , value = "目录标准" , required = false , dataTypeClass=String.class , example = "mysql安装目录 /db  mysql备份目录 /dbbackup  "),
		@ApiImplicitParam(name = DeployStandardVOMeta.DEPLOY_CONTENT , value = "部署标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.CREATE_DB_CONTENT , value = "实例标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.MAINTENANCE_CONTENT , value = "日常维护" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.BACKUP_SCRIPT , value = "备份脚本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.RELEASE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "1.0"),
		@ApiImplicitParam(name = DeployStandardVOMeta.ATTACH_ID , value = "附件人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeployStandardServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.INSERT)
	public Result insert(DeployStandardVO deployStandardVO) {
		Result result=deployStandardService.insert(deployStandardVO,false);
		return result;
	}



	/**
	 * 删除部署标准
	*/
	@ApiOperation(value = "删除部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "640473848730353664")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeployStandardServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  deployStandardService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=deployStandardService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除部署标准 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DeployStandardServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = deployStandardService.hasRefers(ids);
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
			Result result=deployStandardService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=deployStandardService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新部署标准
	*/
	@ApiOperation(value = "更新部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "640473848730353664"),
		@ApiImplicitParam(name = DeployStandardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Mysql数据库"),
		@ApiImplicitParam(name = DeployStandardVOMeta.TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.USER_CONTENT , value = "用户标准" , required = false , dataTypeClass=String.class , example = "操作系统用户 mysql  数据库用户 管理员:root 应用:app"),
		@ApiImplicitParam(name = DeployStandardVOMeta.DIR_CONTENT , value = "目录标准" , required = false , dataTypeClass=String.class , example = "mysql安装目录 /db  mysql备份目录 /dbbackup  "),
		@ApiImplicitParam(name = DeployStandardVOMeta.DEPLOY_CONTENT , value = "部署标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.CREATE_DB_CONTENT , value = "实例标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.MAINTENANCE_CONTENT , value = "日常维护" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.BACKUP_SCRIPT , value = "备份脚本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.RELEASE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "1.0"),
		@ApiImplicitParam(name = DeployStandardVOMeta.ATTACH_ID , value = "附件人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeployStandardVOMeta.PAGE_INDEX , DeployStandardVOMeta.PAGE_SIZE , DeployStandardVOMeta.SEARCH_FIELD , DeployStandardVOMeta.FUZZY_FIELD , DeployStandardVOMeta.SEARCH_VALUE , DeployStandardVOMeta.DIRTY_FIELDS , DeployStandardVOMeta.SORT_FIELD , DeployStandardVOMeta.SORT_TYPE , DeployStandardVOMeta.IDS } )
	@SentinelResource(value = DeployStandardServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.UPDATE)
	public Result update(DeployStandardVO deployStandardVO) {
		Result result=deployStandardService.update(deployStandardVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存部署标准
	*/
	@ApiOperation(value = "保存部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "640473848730353664"),
		@ApiImplicitParam(name = DeployStandardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Mysql数据库"),
		@ApiImplicitParam(name = DeployStandardVOMeta.TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.USER_CONTENT , value = "用户标准" , required = false , dataTypeClass=String.class , example = "操作系统用户 mysql  数据库用户 管理员:root 应用:app"),
		@ApiImplicitParam(name = DeployStandardVOMeta.DIR_CONTENT , value = "目录标准" , required = false , dataTypeClass=String.class , example = "mysql安装目录 /db  mysql备份目录 /dbbackup  "),
		@ApiImplicitParam(name = DeployStandardVOMeta.DEPLOY_CONTENT , value = "部署标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.CREATE_DB_CONTENT , value = "实例标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.MAINTENANCE_CONTENT , value = "日常维护" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.BACKUP_SCRIPT , value = "备份脚本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.RELEASE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "1.0"),
		@ApiImplicitParam(name = DeployStandardVOMeta.ATTACH_ID , value = "附件人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DeployStandardVOMeta.PAGE_INDEX , DeployStandardVOMeta.PAGE_SIZE , DeployStandardVOMeta.SEARCH_FIELD , DeployStandardVOMeta.FUZZY_FIELD , DeployStandardVOMeta.SEARCH_VALUE , DeployStandardVOMeta.DIRTY_FIELDS , DeployStandardVOMeta.SORT_FIELD , DeployStandardVOMeta.SORT_TYPE , DeployStandardVOMeta.IDS } )
	@SentinelResource(value = DeployStandardServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.SAVE)
	public Result save(DeployStandardVO deployStandardVO) {
		Result result=deployStandardService.save(deployStandardVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取部署标准
	*/
	@ApiOperation(value = "获取部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeployStandardServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.GET_BY_ID)
	public Result<DeployStandard> getById(String id) {
		Result<DeployStandard> result=new Result<>();
		DeployStandard deployStandard=deployStandardService.getById(id);
		result.success(true).data(deployStandard);
		return result;
	}


	/**
	 * 批量获取部署标准 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取部署标准")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DeployStandardVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DeployStandardServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.GET_BY_IDS)
	public Result<List<DeployStandard>> getByIds(List<String> ids) {
		Result<List<DeployStandard>> result=new Result<>();
		List<DeployStandard> list=deployStandardService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询部署标准
	*/
	@ApiOperation(value = "查询部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "640473848730353664"),
		@ApiImplicitParam(name = DeployStandardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Mysql数据库"),
		@ApiImplicitParam(name = DeployStandardVOMeta.TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.USER_CONTENT , value = "用户标准" , required = false , dataTypeClass=String.class , example = "操作系统用户 mysql  数据库用户 管理员:root 应用:app"),
		@ApiImplicitParam(name = DeployStandardVOMeta.DIR_CONTENT , value = "目录标准" , required = false , dataTypeClass=String.class , example = "mysql安装目录 /db  mysql备份目录 /dbbackup  "),
		@ApiImplicitParam(name = DeployStandardVOMeta.DEPLOY_CONTENT , value = "部署标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.CREATE_DB_CONTENT , value = "实例标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.MAINTENANCE_CONTENT , value = "日常维护" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.BACKUP_SCRIPT , value = "备份脚本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.RELEASE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "1.0"),
		@ApiImplicitParam(name = DeployStandardVOMeta.ATTACH_ID , value = "附件人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeployStandardVOMeta.PAGE_INDEX , DeployStandardVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DeployStandardServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.QUERY_LIST)
	public Result<List<DeployStandard>> queryList(DeployStandardVO sample) {
		Result<List<DeployStandard>> result=new Result<>();
		List<DeployStandard> list=deployStandardService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询部署标准
	*/
	@ApiOperation(value = "分页查询部署标准")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeployStandardVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "640473848730353664"),
		@ApiImplicitParam(name = DeployStandardVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Mysql数据库"),
		@ApiImplicitParam(name = DeployStandardVOMeta.TYPE_ID , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.USER_CONTENT , value = "用户标准" , required = false , dataTypeClass=String.class , example = "操作系统用户 mysql  数据库用户 管理员:root 应用:app"),
		@ApiImplicitParam(name = DeployStandardVOMeta.DIR_CONTENT , value = "目录标准" , required = false , dataTypeClass=String.class , example = "mysql安装目录 /db  mysql备份目录 /dbbackup  "),
		@ApiImplicitParam(name = DeployStandardVOMeta.DEPLOY_CONTENT , value = "部署标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.CREATE_DB_CONTENT , value = "实例标准" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.MAINTENANCE_CONTENT , value = "日常维护" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.BACKUP_SCRIPT , value = "备份脚本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.RELEASE_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "1.0"),
		@ApiImplicitParam(name = DeployStandardVOMeta.ATTACH_ID , value = "附件人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeployStandardVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeployStandardServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeployStandardServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DeployStandard>> queryPagedList(DeployStandardVO sample) {
		Result<PagedList<DeployStandard>> result=new Result<>();
		PagedList<DeployStandard> list=deployStandardService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}