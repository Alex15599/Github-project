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


import com.dt.platform.proxy.eam.AssetMaintenanceUpdateServiceProxy;
import com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateVOMeta;
import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import com.dt.platform.domain.eam.AssetMaintenanceUpdateVO;
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
import com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetMaintenanceUpdateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维保更新接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 22:25:07
*/

@InDoc
@Api(tags = "维保更新")
@RestController("EamAssetMaintenanceUpdateController")
public class AssetMaintenanceUpdateController extends SuperController {

	@Autowired
	private IAssetMaintenanceUpdateService assetMaintenanceUpdateService;


	/**
	 * 添加维保更新
	*/
	@ApiOperation(value = "添加维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "638495539125551104"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "C2147483647"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.HANDLE_STATUS , value = "处理状态" , required = false , dataTypeClass=String.class , example = "finish"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.INSERT)
	public Result insert(AssetMaintenanceUpdateVO assetMaintenanceUpdateVO) {
		Result result=assetMaintenanceUpdateService.insert(assetMaintenanceUpdateVO,false);
		return result;
	}



	/**
	 * 删除维保更新
	*/
	@ApiOperation(value = "删除维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "638495539125551104")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetMaintenanceUpdateService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=assetMaintenanceUpdateService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除维保更新 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetMaintenanceUpdateService.hasRefers(ids);
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
			Result result=assetMaintenanceUpdateService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetMaintenanceUpdateService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新维保更新
	*/
	@ApiOperation(value = "更新维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "638495539125551104"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "C2147483647"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.HANDLE_STATUS , value = "处理状态" , required = false , dataTypeClass=String.class , example = "finish"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetMaintenanceUpdateVOMeta.PAGE_INDEX , AssetMaintenanceUpdateVOMeta.PAGE_SIZE , AssetMaintenanceUpdateVOMeta.SEARCH_FIELD , AssetMaintenanceUpdateVOMeta.FUZZY_FIELD , AssetMaintenanceUpdateVOMeta.SEARCH_VALUE , AssetMaintenanceUpdateVOMeta.DIRTY_FIELDS , AssetMaintenanceUpdateVOMeta.SORT_FIELD , AssetMaintenanceUpdateVOMeta.SORT_TYPE , AssetMaintenanceUpdateVOMeta.IDS } )
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.UPDATE)
	public Result update(AssetMaintenanceUpdateVO assetMaintenanceUpdateVO) {
		Result result=assetMaintenanceUpdateService.update(assetMaintenanceUpdateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存维保更新
	*/
	@ApiOperation(value = "保存维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "638495539125551104"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "C2147483647"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.HANDLE_STATUS , value = "处理状态" , required = false , dataTypeClass=String.class , example = "finish"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetMaintenanceUpdateVOMeta.PAGE_INDEX , AssetMaintenanceUpdateVOMeta.PAGE_SIZE , AssetMaintenanceUpdateVOMeta.SEARCH_FIELD , AssetMaintenanceUpdateVOMeta.FUZZY_FIELD , AssetMaintenanceUpdateVOMeta.SEARCH_VALUE , AssetMaintenanceUpdateVOMeta.DIRTY_FIELDS , AssetMaintenanceUpdateVOMeta.SORT_FIELD , AssetMaintenanceUpdateVOMeta.SORT_TYPE , AssetMaintenanceUpdateVOMeta.IDS } )
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.SAVE)
	public Result save(AssetMaintenanceUpdateVO assetMaintenanceUpdateVO) {
		Result result=assetMaintenanceUpdateService.save(assetMaintenanceUpdateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取维保更新
	*/
	@ApiOperation(value = "获取维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.GET_BY_ID)
	public Result<AssetMaintenanceUpdate> getById(String id) {
		Result<AssetMaintenanceUpdate> result=new Result<>();
		AssetMaintenanceUpdate assetMaintenanceUpdate=assetMaintenanceUpdateService.getById(id);
		result.success(true).data(assetMaintenanceUpdate);
		return result;
	}


	/**
	 * 批量获取维保更新 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取维保更新")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.GET_BY_IDS)
	public Result<List<AssetMaintenanceUpdate>> getByIds(List<String> ids) {
		Result<List<AssetMaintenanceUpdate>> result=new Result<>();
		List<AssetMaintenanceUpdate> list=assetMaintenanceUpdateService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询维保更新
	*/
	@ApiOperation(value = "查询维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "638495539125551104"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "C2147483647"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.HANDLE_STATUS , value = "处理状态" , required = false , dataTypeClass=String.class , example = "finish"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetMaintenanceUpdateVOMeta.PAGE_INDEX , AssetMaintenanceUpdateVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.QUERY_LIST)
	public Result<List<AssetMaintenanceUpdate>> queryList(AssetMaintenanceUpdateVO sample) {
		Result<List<AssetMaintenanceUpdate>> result=new Result<>();
		List<AssetMaintenanceUpdate> list=assetMaintenanceUpdateService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询维保更新
	*/
	@ApiOperation(value = "分页查询维保更新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "638495539125551104"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "C2147483647"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.HANDLE_STATUS , value = "处理状态" , required = false , dataTypeClass=String.class , example = "finish"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.REASON , value = "原因" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceUpdateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetMaintenanceUpdate>> queryPagedList(AssetMaintenanceUpdateVO sample) {
		Result<PagedList<AssetMaintenanceUpdate>> result=new Result<>();
		PagedList<AssetMaintenanceUpdate> list=assetMaintenanceUpdateService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





	/**
	 * 取消维保更新
	 */
	@ApiOperation(value = "取消维保更新")
	@ApiOperationSupport(order=9 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.CANCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.CANCEL)
	public Result cancel(String id) {
		return assetMaintenanceUpdateService.cancel(id);
	}



	/**
	 * 插入资产
	 */
	@ApiOperation(value = "插入资产")
	@ApiOperationSupport(order=10 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.INSERT_ASSET , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.INSERT_ASSET)
	public Result getById(String id,String selectedCode) {
		return assetMaintenanceUpdateService.insertAsset(id,selectedCode);
	}



	/**
	 * update资产
	 */
	@ApiOperation(value = "update资产")
	@ApiOperationSupport(order=10 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.ACTION_UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.ACTION_UPDATE)
	public Result actionUpdate(String id) {
		return assetMaintenanceUpdateService.actionUpdate(id);
	}


	/**
	 * update资产
	 */
	@ApiOperation(value = "update资产")
	@ApiOperationSupport(order=10 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.BATCH_OPER , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.BATCH_OPER)
	public Result batchOper(String id) {
		return assetMaintenanceUpdateService.batchOper(id);
	}


	/**
	 * update资产
	 */
	@ApiOperation(value = "update资产")
	@ApiOperationSupport(order=10 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceUpdateServiceProxy.FILL_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceUpdateServiceProxy.FILL_DATA)
	public Result fillData(List<String> ids) {
		return assetMaintenanceUpdateService.fillData(ids);
	}




}