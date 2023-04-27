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


import com.dt.platform.proxy.ops.SoftwareMediaServiceProxy;
import com.dt.platform.domain.ops.meta.SoftwareMediaVOMeta;
import com.dt.platform.domain.ops.SoftwareMedia;
import com.dt.platform.domain.ops.SoftwareMediaVO;
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
import com.dt.platform.domain.ops.meta.SoftwareMediaMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ISoftwareMediaService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件介质接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-29 22:53:53
*/

@InDoc
@Api(tags = "软件介质")
@RestController("OpsSoftwareMediaController")
public class SoftwareMediaController extends SuperController {

	@Autowired
	private ISoftwareMediaService softwareMediaService;


	/**
	 * 添加软件介质
	*/
	@ApiOperation(value = "添加软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "672189298241437696"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Redis客户端"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "672189289701834752"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "支持单节点、哨兵模式、集群模式"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.REC_TIME , value = "修改时间" , required = false , dataTypeClass=Date.class , example = "2023-01-29 10:52:43"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareMediaServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.INSERT)
	public Result insert(SoftwareMediaVO softwareMediaVO) {
		Result result=softwareMediaService.insert(softwareMediaVO,false);
		return result;
	}



	/**
	 * 删除软件介质
	*/
	@ApiOperation(value = "删除软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "672189298241437696")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareMediaServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  softwareMediaService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=softwareMediaService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件介质 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SoftwareMediaServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = softwareMediaService.hasRefers(ids);
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
			Result result=softwareMediaService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=softwareMediaService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新软件介质
	*/
	@ApiOperation(value = "更新软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "672189298241437696"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Redis客户端"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "672189289701834752"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "支持单节点、哨兵模式、集群模式"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.REC_TIME , value = "修改时间" , required = false , dataTypeClass=Date.class , example = "2023-01-29 10:52:43"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SoftwareMediaVOMeta.PAGE_INDEX , SoftwareMediaVOMeta.PAGE_SIZE , SoftwareMediaVOMeta.SEARCH_FIELD , SoftwareMediaVOMeta.FUZZY_FIELD , SoftwareMediaVOMeta.SEARCH_VALUE , SoftwareMediaVOMeta.DIRTY_FIELDS , SoftwareMediaVOMeta.SORT_FIELD , SoftwareMediaVOMeta.SORT_TYPE , SoftwareMediaVOMeta.DATA_ORIGIN , SoftwareMediaVOMeta.QUERY_LOGIC , SoftwareMediaVOMeta.IDS } )
	@SentinelResource(value = SoftwareMediaServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.UPDATE)
	public Result update(SoftwareMediaVO softwareMediaVO) {
		Result result=softwareMediaService.update(softwareMediaVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件介质
	*/
	@ApiOperation(value = "保存软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "672189298241437696"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Redis客户端"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "672189289701834752"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "支持单节点、哨兵模式、集群模式"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.REC_TIME , value = "修改时间" , required = false , dataTypeClass=Date.class , example = "2023-01-29 10:52:43"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SoftwareMediaVOMeta.PAGE_INDEX , SoftwareMediaVOMeta.PAGE_SIZE , SoftwareMediaVOMeta.SEARCH_FIELD , SoftwareMediaVOMeta.FUZZY_FIELD , SoftwareMediaVOMeta.SEARCH_VALUE , SoftwareMediaVOMeta.DIRTY_FIELDS , SoftwareMediaVOMeta.SORT_FIELD , SoftwareMediaVOMeta.SORT_TYPE , SoftwareMediaVOMeta.DATA_ORIGIN , SoftwareMediaVOMeta.QUERY_LOGIC , SoftwareMediaVOMeta.IDS } )
	@SentinelResource(value = SoftwareMediaServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.SAVE)
	public Result save(SoftwareMediaVO softwareMediaVO) {
		Result result=softwareMediaService.save(softwareMediaVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件介质
	*/
	@ApiOperation(value = "获取软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareMediaServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.GET_BY_ID)
	public Result<SoftwareMedia> getById(String id) {
		Result<SoftwareMedia> result=new Result<>();
		SoftwareMedia softwareMedia=softwareMediaService.getById(id);
		// join 关联的对象
		softwareMediaService.dao().fill(softwareMedia)
			.with(SoftwareMediaMeta.TYPE_DATA)
			.execute();
		result.success(true).data(softwareMedia);
		return result;
	}


	/**
	 * 批量获取软件介质 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件介质")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SoftwareMediaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SoftwareMediaServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.GET_BY_IDS)
	public Result<List<SoftwareMedia>> getByIds(List<String> ids) {
		Result<List<SoftwareMedia>> result=new Result<>();
		List<SoftwareMedia> list=softwareMediaService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件介质
	*/
	@ApiOperation(value = "查询软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "672189298241437696"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Redis客户端"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "672189289701834752"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "支持单节点、哨兵模式、集群模式"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.REC_TIME , value = "修改时间" , required = false , dataTypeClass=Date.class , example = "2023-01-29 10:52:43"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SoftwareMediaVOMeta.PAGE_INDEX , SoftwareMediaVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SoftwareMediaServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.QUERY_LIST)
	public Result<List<SoftwareMedia>> queryList(SoftwareMediaVO sample) {
		Result<List<SoftwareMedia>> result=new Result<>();
		List<SoftwareMedia> list=softwareMediaService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件介质
	*/
	@ApiOperation(value = "分页查询软件介质")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SoftwareMediaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "672189298241437696"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Redis客户端"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class , example = "672189289701834752"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "支持单节点、哨兵模式、集群模式"),
		@ApiImplicitParam(name = SoftwareMediaVOMeta.REC_TIME , value = "修改时间" , required = false , dataTypeClass=Date.class , example = "2023-01-29 10:52:43"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SoftwareMediaServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SoftwareMediaServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SoftwareMedia>> queryPagedList(SoftwareMediaVO sample) {
		Result<PagedList<SoftwareMedia>> result=new Result<>();
		PagedList<SoftwareMedia> list=softwareMediaService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		softwareMediaService.dao().fill(list)
			.with(SoftwareMediaMeta.TYPE_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}






}