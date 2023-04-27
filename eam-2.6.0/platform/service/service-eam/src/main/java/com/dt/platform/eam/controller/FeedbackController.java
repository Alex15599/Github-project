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


import com.dt.platform.proxy.eam.FeedbackServiceProxy;
import com.dt.platform.domain.eam.meta.FeedbackVOMeta;
import com.dt.platform.domain.eam.Feedback;
import com.dt.platform.domain.eam.FeedbackVO;
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
import com.dt.platform.domain.eam.meta.FeedbackMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IFeedbackService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 反馈信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:50:48
*/

@InDoc
@Api(tags = "反馈信息")
@RestController("EamFeedbackController")
public class FeedbackController extends SuperController {

	@Autowired
	private IFeedbackService feedbackService;


	/**
	 * 添加反馈信息
	*/
	@ApiOperation(value = "添加反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FeedbackServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.INSERT)
	public Result insert(FeedbackVO feedbackVO) {
		Result result=feedbackService.insert(feedbackVO,false);
		return result;
	}



	/**
	 * 删除反馈信息
	*/
	@ApiOperation(value = "删除反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FeedbackServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  feedbackService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=feedbackService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除反馈信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = FeedbackServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = feedbackService.hasRefers(ids);
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
			Result result=feedbackService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=feedbackService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新反馈信息
	*/
	@ApiOperation(value = "更新反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FeedbackVOMeta.PAGE_INDEX , FeedbackVOMeta.PAGE_SIZE , FeedbackVOMeta.SEARCH_FIELD , FeedbackVOMeta.FUZZY_FIELD , FeedbackVOMeta.SEARCH_VALUE , FeedbackVOMeta.DIRTY_FIELDS , FeedbackVOMeta.SORT_FIELD , FeedbackVOMeta.SORT_TYPE , FeedbackVOMeta.IDS } )
	@SentinelResource(value = FeedbackServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.UPDATE)
	public Result update(FeedbackVO feedbackVO) {
		Result result=feedbackService.update(feedbackVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存反馈信息
	*/
	@ApiOperation(value = "保存反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FeedbackVOMeta.PAGE_INDEX , FeedbackVOMeta.PAGE_SIZE , FeedbackVOMeta.SEARCH_FIELD , FeedbackVOMeta.FUZZY_FIELD , FeedbackVOMeta.SEARCH_VALUE , FeedbackVOMeta.DIRTY_FIELDS , FeedbackVOMeta.SORT_FIELD , FeedbackVOMeta.SORT_TYPE , FeedbackVOMeta.IDS } )
	@SentinelResource(value = FeedbackServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.SAVE)
	public Result save(FeedbackVO feedbackVO) {
		Result result=feedbackService.save(feedbackVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取反馈信息
	*/
	@ApiOperation(value = "获取反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FeedbackServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.GET_BY_ID)
	public Result<Feedback> getById(String id) {
		Result<Feedback> result=new Result<>();
		Feedback feedback=feedbackService.getById(id);
		// join 关联的对象
		feedbackService.dao().fill(feedback)
			.with("user")
			.execute();
		result.success(true).data(feedback);
		return result;
	}


	/**
	 * 批量获取反馈信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取反馈信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FeedbackVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = FeedbackServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.GET_BY_IDS)
	public Result<List<Feedback>> getByIds(List<String> ids) {
		Result<List<Feedback>> result=new Result<>();
		List<Feedback> list=feedbackService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询反馈信息
	*/
	@ApiOperation(value = "查询反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { FeedbackVOMeta.PAGE_INDEX , FeedbackVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FeedbackServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.QUERY_LIST)
	public Result<List<Feedback>> queryList(FeedbackVO sample) {
		Result<List<Feedback>> result=new Result<>();
		List<Feedback> list=feedbackService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询反馈信息
	*/
	@ApiOperation(value = "分页查询反馈信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FeedbackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FeedbackVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = FeedbackServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FeedbackServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Feedback>> queryPagedList(FeedbackVO sample) {
		Result<PagedList<Feedback>> result=new Result<>();
		PagedList<Feedback> list=feedbackService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		feedbackService.dao().fill(list)
			.with("user")
			.execute();
		result.success(true).data(list);
		return result;
	}






}