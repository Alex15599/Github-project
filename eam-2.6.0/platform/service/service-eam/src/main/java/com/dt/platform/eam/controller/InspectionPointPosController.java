package com.dt.platform.eam.controller;

import java.util.*;

import com.dt.platform.domain.eam.Position;
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


import com.dt.platform.proxy.eam.InspectionPointPosServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPointPosVOMeta;
import com.dt.platform.domain.eam.InspectionPointPos;
import com.dt.platform.domain.eam.InspectionPointPosVO;
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
import com.dt.platform.domain.eam.meta.InspectionPointPosMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPointPosService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点位接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-10 09:39:30
*/

@InDoc
@Api(tags = "巡检点位")
@RestController("EamInspectionPointPosController")
public class InspectionPointPosController extends SuperController {

	@Autowired
	private IInspectionPointPosService inspectionPointPosService;

	/**
	 * 添加巡检点位
	*/
	@ApiOperation(value = "添加巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointPosServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.INSERT)
	public Result insert(InspectionPointPosVO positionVO) {
		positionVO.setSort(9999);
		if (StringUtil.isBlank(positionVO.getParentId())) {
			positionVO.setParentId("0");
		}
		Result result = inspectionPointPosService.insert(positionVO, false);
		if (result.success()) {
			InspectionPointPos currentPosition = new InspectionPointPos();
			currentPosition.setId(positionVO.getId());
			if ("0".equals(positionVO.getParentId())) {
				currentPosition.setHierarchy(positionVO.getId());
				currentPosition.setHierarchyName(positionVO.getName());
			} else {
				InspectionPointPos parentPosition = inspectionPointPosService.getById(positionVO.getParentId());
				currentPosition.setHierarchy(parentPosition.getHierarchy() + "/" + positionVO.getId());
				currentPosition.setHierarchyName(parentPosition.getHierarchyName() + "/" + positionVO.getName());
			}
			inspectionPointPosService.update(currentPosition, SaveMode.NOT_NULL_FIELDS);
			positionVO.setHierarchy(currentPosition.getHierarchy());
			positionVO.setHierarchyName(currentPosition.getHierarchyName());
			result.data(positionVO);
		}
		return result;

	}



	/**
	 * 删除巡检点位
	*/
	@ApiOperation(value = "删除巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointPosServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.DELETE)
	public Result deleteById(String id) {

		List<InspectionPointPos> list = inspectionPointPosService.queryList(InspectionPointPos.create().setParentId(id));
		if (list.size() > 0) {
			Result<InspectionPointPos> result = new Result<>();
			result.success(false).message("请先删除下级节点");
			return result;
		}

		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  inspectionPointPosService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=inspectionPointPosService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点位 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = InspectionPointPosServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = inspectionPointPosService.hasRefers(ids);
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
			Result result=inspectionPointPosService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=inspectionPointPosService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检点位
	*/
	@ApiOperation(value = "更新巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionPointPosVOMeta.PAGE_INDEX , InspectionPointPosVOMeta.PAGE_SIZE , InspectionPointPosVOMeta.SEARCH_FIELD , InspectionPointPosVOMeta.FUZZY_FIELD , InspectionPointPosVOMeta.SEARCH_VALUE , InspectionPointPosVOMeta.DIRTY_FIELDS , InspectionPointPosVOMeta.SORT_FIELD , InspectionPointPosVOMeta.SORT_TYPE , InspectionPointPosVOMeta.DATA_ORIGIN , InspectionPointPosVOMeta.QUERY_LOGIC , InspectionPointPosVOMeta.REQUEST_ACTION , InspectionPointPosVOMeta.IDS } )
	@SentinelResource(value = InspectionPointPosServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.UPDATE)
	public Result update(InspectionPointPosVO inspectionPointPosVO) {

		Result result = inspectionPointPosService.update(inspectionPointPosVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
		if (result.isSuccess()) {
			// 更新分类名称
			return inspectionPointPosService.updateHierarchy(inspectionPointPosVO.getId());
		}
		return result;

	}


	/**
	 * 保存巡检点位
	*/
	@ApiOperation(value = "保存巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointPosVOMeta.PAGE_INDEX , InspectionPointPosVOMeta.PAGE_SIZE , InspectionPointPosVOMeta.SEARCH_FIELD , InspectionPointPosVOMeta.FUZZY_FIELD , InspectionPointPosVOMeta.SEARCH_VALUE , InspectionPointPosVOMeta.DIRTY_FIELDS , InspectionPointPosVOMeta.SORT_FIELD , InspectionPointPosVOMeta.SORT_TYPE , InspectionPointPosVOMeta.DATA_ORIGIN , InspectionPointPosVOMeta.QUERY_LOGIC , InspectionPointPosVOMeta.REQUEST_ACTION , InspectionPointPosVOMeta.IDS } )
	@SentinelResource(value = InspectionPointPosServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.SAVE)
	public Result save(InspectionPointPosVO inspectionPointPosVO) {
		
		Result result=inspectionPointPosService.save(inspectionPointPosVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点位
	*/
	@ApiOperation(value = "获取巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointPosServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.GET_BY_ID)
	public Result<InspectionPointPos> getById(String id) {
		
		Result<InspectionPointPos> result=new Result<>();
		InspectionPointPos inspectionPointPos=inspectionPointPosService.getById(id);
		result.success(true).data(inspectionPointPos);
		return result;
	}


	/**
	 * 批量获取巡检点位 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点位")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPointPosVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = InspectionPointPosServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPointPos>> getByIds(List<String> ids) {
		
		Result<List<InspectionPointPos>> result=new Result<>();
		List<InspectionPointPos> list=inspectionPointPosService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点位
	*/
	@ApiOperation(value = "查询巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { InspectionPointPosVOMeta.PAGE_INDEX , InspectionPointPosVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPointPosServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.QUERY_LIST)
	public Result<List<InspectionPointPos>> queryList(InspectionPointPosVO sample) {
		
		Result<List<InspectionPointPos>> result=new Result<>();
		List<InspectionPointPos> list=inspectionPointPosService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点位
	*/
	@ApiOperation(value = "分页查询巡检点位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointPosVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointPosVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = InspectionPointPosServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointPosServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPointPos>> queryPagedList(InspectionPointPosVO sample) {
		
		Result<PagedList<InspectionPointPos>> result=new Result<>();
		PagedList<InspectionPointPos> list=inspectionPointPosService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}