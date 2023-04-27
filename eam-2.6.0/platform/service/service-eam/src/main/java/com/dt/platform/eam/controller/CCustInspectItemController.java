package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.domain.eam.CCustRepairApply;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.CCustInspectItemServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectItemVOMeta;
import com.dt.platform.domain.eam.CCustInspectItem;
import com.dt.platform.domain.eam.CCustInspectItemVO;
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
import com.dt.platform.domain.eam.meta.CCustInspectItemMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 10:22:08
*/

@InDoc
@Api(tags = "巡检记录")
@RestController("EamCCustInspectItemController")
public class CCustInspectItemController extends SuperController {

	@Autowired
	private ICCustInspectItemService cCustInspectItemService;

	/**
	 * 添加巡检记录
	*/
	@ApiOperation(value = "添加巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.INSPECT_USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_NAME , value = "设备名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_MODEL , value = "设备型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_SEQ , value = "设备序列" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.INSERT)
	public Result insert(CCustInspectItemVO cCustInspectItemVO) {
		
		Result result=cCustInspectItemService.insert(cCustInspectItemVO,false);
		return result;
	}



	/**
	 * 删除巡检记录
	*/
	@ApiOperation(value = "删除巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustInspectItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustInspectItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustInspectItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustInspectItemService.hasRefers(ids);
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
			Result result=cCustInspectItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustInspectItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检记录
	*/
	@ApiOperation(value = "更新巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.INSPECT_USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_NAME , value = "设备名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_MODEL , value = "设备型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_SEQ , value = "设备序列" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectItemVOMeta.PAGE_INDEX , CCustInspectItemVOMeta.PAGE_SIZE , CCustInspectItemVOMeta.SEARCH_FIELD , CCustInspectItemVOMeta.FUZZY_FIELD , CCustInspectItemVOMeta.SEARCH_VALUE , CCustInspectItemVOMeta.DIRTY_FIELDS , CCustInspectItemVOMeta.SORT_FIELD , CCustInspectItemVOMeta.SORT_TYPE , CCustInspectItemVOMeta.DATA_ORIGIN , CCustInspectItemVOMeta.QUERY_LOGIC , CCustInspectItemVOMeta.REQUEST_ACTION , CCustInspectItemVOMeta.IDS } )
	@SentinelResource(value = CCustInspectItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.UPDATE)
	public Result update(CCustInspectItemVO cCustInspectItemVO) {
		
		Result result=cCustInspectItemService.update(cCustInspectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检记录
	*/
	@ApiOperation(value = "保存巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.INSPECT_USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_NAME , value = "设备名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_MODEL , value = "设备型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_SEQ , value = "设备序列" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustInspectItemVOMeta.PAGE_INDEX , CCustInspectItemVOMeta.PAGE_SIZE , CCustInspectItemVOMeta.SEARCH_FIELD , CCustInspectItemVOMeta.FUZZY_FIELD , CCustInspectItemVOMeta.SEARCH_VALUE , CCustInspectItemVOMeta.DIRTY_FIELDS , CCustInspectItemVOMeta.SORT_FIELD , CCustInspectItemVOMeta.SORT_TYPE , CCustInspectItemVOMeta.DATA_ORIGIN , CCustInspectItemVOMeta.QUERY_LOGIC , CCustInspectItemVOMeta.REQUEST_ACTION , CCustInspectItemVOMeta.IDS } )
	@SentinelResource(value = CCustInspectItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.SAVE)
	public Result save(CCustInspectItemVO cCustInspectItemVO) {
		
		Result result=cCustInspectItemService.save(cCustInspectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检记录
	*/
	@ApiOperation(value = "获取巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.GET_BY_ID)
	public Result<CCustInspectItem> getById(String id) {
		
		Result<CCustInspectItem> result=new Result<>();
		CCustInspectItem cCustInspectItem=cCustInspectItemService.getById(id);
		// join 关联的对象
		cCustInspectItemService.dao().fill(cCustInspectItem)
			.with("inspectUser")
			.execute();
		cCustInspectItemService.dao().join(cCustInspectItem.getInspectUser(), Person.class);

		result.success(true).data(cCustInspectItem);
		return result;
	}


	/**
	 * 批量获取巡检记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustInspectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustInspectItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.GET_BY_IDS)
	public Result<List<CCustInspectItem>> getByIds(List<String> ids) {
		
		Result<List<CCustInspectItem>> result=new Result<>();
		List<CCustInspectItem> list=cCustInspectItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检记录
	*/
	@ApiOperation(value = "查询巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.INSPECT_USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_NAME , value = "设备名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_MODEL , value = "设备型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_SEQ , value = "设备序列" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectItemVOMeta.PAGE_INDEX , CCustInspectItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustInspectItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.QUERY_LIST)
	public Result<List<CCustInspectItem>> queryList(CCustInspectItemVO sample) {
		
		Result<List<CCustInspectItem>> result=new Result<>();
		List<CCustInspectItem> list=cCustInspectItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检记录
	*/
	@ApiOperation(value = "分页查询巡检记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.INSPECT_USER_ID , value = "巡检人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.CT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_NAME , value = "设备名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_MODEL , value = "设备型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectItemVOMeta.ASSET_SEQ , value = "设备序列" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustInspectItem>> queryPagedList(CCustInspectItemVO sample) {
		
		Result<PagedList<CCustInspectItem>> result=new Result<>();
		PagedList<CCustInspectItem> list=cCustInspectItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		cCustInspectItemService.dao().fill(list)
			.with("inspectUser")
			.execute();

		List<Employee> user1 = CollectorUtil.collectList(list, CCustInspectItem::getInspectUser);
		cCustInspectItemService.dao().join(user1, Person.class);

		result.success(true).data(list);
		return result;
	}





}