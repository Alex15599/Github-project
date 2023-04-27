package com.dt.platform.eam.controller;

import java.math.BigDecimal;
import java.util.*;

import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.eam.meta.AssetVOMeta;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
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


import com.dt.platform.proxy.eam.CCustInspectTplServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectTplVOMeta;
import com.dt.platform.domain.eam.CCustInspectTpl;
import com.dt.platform.domain.eam.CCustInspectTplVO;
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
import com.dt.platform.domain.eam.meta.CCustInspectTplMeta;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检模版接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-08 19:01:16
*/

@InDoc
@Api(tags = "巡检模版")
@RestController("EamCCustInspectTplController")
public class CCustInspectTplController extends SuperController {

	@Autowired
	private ICCustInspectTplService cCustInspectTplService;

	@Autowired
	private IAssetService assetService;

	/**
	 * 添加巡检模版
	*/
	@ApiOperation(value = "添加巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "696280340544618496"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class , example = "测试巡检无效"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "invalid"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "测试"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.INSERT)
	public Result insert(CCustInspectTplVO cCustInspectTplVO) {
		
		Result result=cCustInspectTplService.insert(cCustInspectTplVO,false);
		return result;
	}



	/**
	 * 删除巡检模版
	*/
	@ApiOperation(value = "删除巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "696280340544618496")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustInspectTplService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustInspectTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustInspectTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustInspectTplService.hasRefers(ids);
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
			Result result=cCustInspectTplService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustInspectTplService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新巡检模版
	*/
	@ApiOperation(value = "更新巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "696280340544618496"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class , example = "测试巡检无效"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "invalid"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "测试"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectTplVOMeta.PAGE_INDEX , CCustInspectTplVOMeta.PAGE_SIZE , CCustInspectTplVOMeta.SEARCH_FIELD , CCustInspectTplVOMeta.FUZZY_FIELD , CCustInspectTplVOMeta.SEARCH_VALUE , CCustInspectTplVOMeta.DIRTY_FIELDS , CCustInspectTplVOMeta.SORT_FIELD , CCustInspectTplVOMeta.SORT_TYPE , CCustInspectTplVOMeta.DATA_ORIGIN , CCustInspectTplVOMeta.QUERY_LOGIC , CCustInspectTplVOMeta.REQUEST_ACTION , CCustInspectTplVOMeta.IDS } )
	@SentinelResource(value = CCustInspectTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.UPDATE)
	public Result update(CCustInspectTplVO cCustInspectTplVO) {
		
		Result result=cCustInspectTplService.update(cCustInspectTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检模版
	*/
	@ApiOperation(value = "保存巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "696280340544618496"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class , example = "测试巡检无效"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "invalid"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "测试"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustInspectTplVOMeta.PAGE_INDEX , CCustInspectTplVOMeta.PAGE_SIZE , CCustInspectTplVOMeta.SEARCH_FIELD , CCustInspectTplVOMeta.FUZZY_FIELD , CCustInspectTplVOMeta.SEARCH_VALUE , CCustInspectTplVOMeta.DIRTY_FIELDS , CCustInspectTplVOMeta.SORT_FIELD , CCustInspectTplVOMeta.SORT_TYPE , CCustInspectTplVOMeta.DATA_ORIGIN , CCustInspectTplVOMeta.QUERY_LOGIC , CCustInspectTplVOMeta.REQUEST_ACTION , CCustInspectTplVOMeta.IDS } )
	@SentinelResource(value = CCustInspectTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.SAVE)
	public Result save(CCustInspectTplVO cCustInspectTplVO) {
		
		Result result=cCustInspectTplService.save(cCustInspectTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检模版
	*/
	@ApiOperation(value = "获取巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.GET_BY_ID)
	public Result<CCustInspectTpl> getById(String id) {
		
		Result<CCustInspectTpl> result=new Result<>();
		CCustInspectTpl cCustInspectTpl=cCustInspectTplService.getById(id);
		result.success(true).data(cCustInspectTpl);
		return result;
	}


	/**
	 * 批量获取巡检模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustInspectTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustInspectTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.GET_BY_IDS)
	public Result<List<CCustInspectTpl>> getByIds(List<String> ids) {
		
		Result<List<CCustInspectTpl>> result=new Result<>();
		List<CCustInspectTpl> list=cCustInspectTplService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检模版
	*/
	@ApiOperation(value = "查询巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "696280340544618496"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class , example = "测试巡检无效"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "invalid"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "测试"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectTplVOMeta.PAGE_INDEX , CCustInspectTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustInspectTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.QUERY_LIST)
	public Result<List<CCustInspectTpl>> queryList(CCustInspectTplVO sample) {
		
		Result<List<CCustInspectTpl>> result=new Result<>();
		List<CCustInspectTpl> list=cCustInspectTplService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检模版
	*/
	@ApiOperation(value = "分页查询巡检模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "696280340544618496"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NAME , value = "标题" , required = false , dataTypeClass=String.class , example = "测试巡检无效"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "invalid"),
		@ApiImplicitParam(name = CCustInspectTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "测试"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustInspectTpl>> queryPagedList(CCustInspectTplVO sample) {
		
		Result<PagedList<CCustInspectTpl>> result=new Result<>();
		PagedList<CCustInspectTpl> list=cCustInspectTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产
	 */
	@ApiOperation(value = "分页查询资产")
	@ApiOperationSupport(order = 10)
	@SentinelResource(value = CCustInspectTplServiceProxy.QUERY_ASSET_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CCustInspectTplServiceProxy.QUERY_ASSET_PAGED_LIST)
	public Result<PagedList<Asset>> queryPagedListBySelected(AssetVO sample, String insepectOwnerId) {
		Result<PagedList<Asset>> result = new Result<>();
		ConditionExpr queryCondition=new ConditionExpr();
		if(StringUtil.isBlank(insepectOwnerId)){
			insepectOwnerId="-1";
		}
		queryCondition.andIf("id in (select asset_id from eam_c_cust_inspect_tpl_asset where deleted=0 and owner_id=?)" ,insepectOwnerId);
		PagedList<Asset> list= assetService.queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		assetService.joinData(list.getList());
		result.success(true).data(list);
		return result;
	}

	/**
	 * 删除资产
	 */
	@ApiOperation(value = "删除资产")
	@ApiOperationSupport(order = 10)
	@SentinelResource(value = CCustInspectTplServiceProxy.REMOVE_ASSET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(CCustInspectTplServiceProxy.REMOVE_ASSET)
	public Result removeAsset(String tplId,String assetId) {
		return cCustInspectTplService.removeAsset(tplId,assetId);
	}

}