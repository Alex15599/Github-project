package com.dt.platform.eam.controller;


import java.util.List;
import java.util.ArrayList;


import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.eam.AssetCopyServiceProxy;
import com.dt.platform.domain.eam.meta.AssetCopyVOMeta;
import com.dt.platform.domain.eam.AssetCopy;
import com.dt.platform.domain.eam.AssetCopyVO;
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
import com.dt.platform.domain.eam.meta.AssetCopyMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetCopyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产复制接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-26 10:34:21
*/

@InDoc
@Api(tags = "资产复制")
@RestController("EamAssetCopyController")
public class AssetCopyController extends SuperController {

	@Autowired
	private IAssetCopyService assetCopyService;

	@Autowired
	private IAssetService assetService;
	/**
	 * 添加资产复制
	*/
	@ApiOperation(value = "添加资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_NUMBER , value = "复制数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetCopyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.INSERT)
	public Result insert(AssetCopyVO assetCopyVO) {
		return assetService.assetCopy(assetCopyVO.getAssetId(),assetCopyVO.getAssetNumber());

	}



	/**
	 * 删除资产复制
	*/
	@ApiOperation(value = "删除资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetCopyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetCopyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=assetCopyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产复制 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetCopyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetCopyService.hasRefers(ids);
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
			Result result=assetCopyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetCopyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新资产复制
	*/
	@ApiOperation(value = "更新资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_NUMBER , value = "复制数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetCopyVOMeta.PAGE_INDEX , AssetCopyVOMeta.PAGE_SIZE , AssetCopyVOMeta.SEARCH_FIELD , AssetCopyVOMeta.FUZZY_FIELD , AssetCopyVOMeta.SEARCH_VALUE , AssetCopyVOMeta.DIRTY_FIELDS , AssetCopyVOMeta.SORT_FIELD , AssetCopyVOMeta.SORT_TYPE , AssetCopyVOMeta.IDS } )
	@SentinelResource(value = AssetCopyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.UPDATE)
	public Result update(AssetCopyVO assetCopyVO) {
		Result result=assetCopyService.update(assetCopyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产复制
	*/
	@ApiOperation(value = "保存资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_NUMBER , value = "复制数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCopyVOMeta.PAGE_INDEX , AssetCopyVOMeta.PAGE_SIZE , AssetCopyVOMeta.SEARCH_FIELD , AssetCopyVOMeta.FUZZY_FIELD , AssetCopyVOMeta.SEARCH_VALUE , AssetCopyVOMeta.DIRTY_FIELDS , AssetCopyVOMeta.SORT_FIELD , AssetCopyVOMeta.SORT_TYPE , AssetCopyVOMeta.IDS } )
	@SentinelResource(value = AssetCopyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.SAVE)
	public Result save(AssetCopyVO assetCopyVO) {
		Result result=assetCopyService.save(assetCopyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产复制
	*/
	@ApiOperation(value = "获取资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetCopyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.GET_BY_ID)
	public Result<AssetCopy> getById(String id) {
		Result<AssetCopy> result=new Result<>();
		AssetCopy assetCopy=assetCopyService.getById(id);
		result.success(true).data(assetCopy);
		return result;
	}


	/**
	 * 批量获取资产复制 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产复制")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetCopyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetCopyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.GET_BY_IDS)
	public Result<List<AssetCopy>> getByIds(List<String> ids) {
		Result<List<AssetCopy>> result=new Result<>();
		List<AssetCopy> list=assetCopyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产复制
	*/
	@ApiOperation(value = "查询资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_NUMBER , value = "复制数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetCopyVOMeta.PAGE_INDEX , AssetCopyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetCopyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.QUERY_LIST)
	public Result<List<AssetCopy>> queryList(AssetCopyVO sample) {
		Result<List<AssetCopy>> result=new Result<>();
		List<AssetCopy> list=assetCopyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产复制
	*/
	@ApiOperation(value = "分页查询资产复制")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCopyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.ASSET_NUMBER , value = "复制数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetCopyVOMeta.NOTES , value = "说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetCopyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCopyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetCopy>> queryPagedList(AssetCopyVO sample) {
		Result<PagedList<AssetCopy>> result=new Result<>();
		PagedList<AssetCopy> list=assetCopyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}