package com.dt.platform.eam.controller;


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


import com.dt.platform.proxy.eam.InventoryFeedbackMsgServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryFeedbackMsgVOMeta;
import com.dt.platform.domain.eam.InventoryFeedbackMsg;
import com.dt.platform.domain.eam.InventoryFeedbackMsgVO;
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
import com.dt.platform.domain.eam.meta.InventoryFeedbackMsgMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryFeedbackMsgService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 反馈消息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:57:04
*/

@InDoc
@Api(tags = "反馈消息")
@RestController("EamInventoryFeedbackMsgController")
public class InventoryFeedbackMsgController extends SuperController {

	@Autowired
	private IInventoryFeedbackMsgService inventoryFeedbackMsgService;


	/**
	 * 添加反馈消息
	*/
	@ApiOperation(value = "添加反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.FEEDBACK_ID , value = "反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.RECORD_TIME , value = "时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.INSERT)
	public Result insert(InventoryFeedbackMsgVO inventoryFeedbackMsgVO) {
		Result result=inventoryFeedbackMsgService.insert(inventoryFeedbackMsgVO,false);
		return result;
	}



	/**
	 * 删除反馈消息
	*/
	@ApiOperation(value = "删除反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inventoryFeedbackMsgService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=inventoryFeedbackMsgService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除反馈消息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inventoryFeedbackMsgService.hasRefers(ids);
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
			Result result=inventoryFeedbackMsgService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inventoryFeedbackMsgService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新反馈消息
	*/
	@ApiOperation(value = "更新反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.FEEDBACK_ID , value = "反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.RECORD_TIME , value = "时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InventoryFeedbackMsgVOMeta.PAGE_INDEX , InventoryFeedbackMsgVOMeta.PAGE_SIZE , InventoryFeedbackMsgVOMeta.SEARCH_FIELD , InventoryFeedbackMsgVOMeta.FUZZY_FIELD , InventoryFeedbackMsgVOMeta.SEARCH_VALUE , InventoryFeedbackMsgVOMeta.DIRTY_FIELDS , InventoryFeedbackMsgVOMeta.SORT_FIELD , InventoryFeedbackMsgVOMeta.SORT_TYPE , InventoryFeedbackMsgVOMeta.IDS } )
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.UPDATE)
	public Result update(InventoryFeedbackMsgVO inventoryFeedbackMsgVO) {
		Result result=inventoryFeedbackMsgService.update(inventoryFeedbackMsgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存反馈消息
	*/
	@ApiOperation(value = "保存反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.FEEDBACK_ID , value = "反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.RECORD_TIME , value = "时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryFeedbackMsgVOMeta.PAGE_INDEX , InventoryFeedbackMsgVOMeta.PAGE_SIZE , InventoryFeedbackMsgVOMeta.SEARCH_FIELD , InventoryFeedbackMsgVOMeta.FUZZY_FIELD , InventoryFeedbackMsgVOMeta.SEARCH_VALUE , InventoryFeedbackMsgVOMeta.DIRTY_FIELDS , InventoryFeedbackMsgVOMeta.SORT_FIELD , InventoryFeedbackMsgVOMeta.SORT_TYPE , InventoryFeedbackMsgVOMeta.IDS } )
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.SAVE)
	public Result save(InventoryFeedbackMsgVO inventoryFeedbackMsgVO) {
		Result result=inventoryFeedbackMsgService.save(inventoryFeedbackMsgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取反馈消息
	*/
	@ApiOperation(value = "获取反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.GET_BY_ID)
	public Result<InventoryFeedbackMsg> getById(String id) {
		Result<InventoryFeedbackMsg> result=new Result<>();
		InventoryFeedbackMsg inventoryFeedbackMsg=inventoryFeedbackMsgService.getById(id);
		// join 关联的对象
		inventoryFeedbackMsgService.dao().fill(inventoryFeedbackMsg)
			.with("user")
			.execute();
		result.success(true).data(inventoryFeedbackMsg);
		return result;
	}


	/**
	 * 批量获取反馈消息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取反馈消息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InventoryFeedbackMsgServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.GET_BY_IDS)
	public Result<List<InventoryFeedbackMsg>> getByIds(List<String> ids) {
		Result<List<InventoryFeedbackMsg>> result=new Result<>();
		List<InventoryFeedbackMsg> list=inventoryFeedbackMsgService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询反馈消息
	*/
	@ApiOperation(value = "查询反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.FEEDBACK_ID , value = "反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.RECORD_TIME , value = "时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InventoryFeedbackMsgVOMeta.PAGE_INDEX , InventoryFeedbackMsgVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.QUERY_LIST)
	public Result<List<InventoryFeedbackMsg>> queryList(InventoryFeedbackMsgVO sample) {
		Result<List<InventoryFeedbackMsg>> result=new Result<>();
		List<InventoryFeedbackMsg> list=inventoryFeedbackMsgService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询反馈消息
	*/
	@ApiOperation(value = "分页查询反馈消息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.FEEDBACK_ID , value = "反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.RECORD_TIME , value = "时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryFeedbackMsgVOMeta.PICTURE_ID , value = "照片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InventoryFeedbackMsgServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryFeedbackMsgServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryFeedbackMsg>> queryPagedList(InventoryFeedbackMsgVO sample) {
		Result<PagedList<InventoryFeedbackMsg>> result=new Result<>();
		PagedList<InventoryFeedbackMsg> list=inventoryFeedbackMsgService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inventoryFeedbackMsgService.dao().fill(list)
			.with("user")
			.execute();
		result.success(true).data(list);
		return result;
	}






}