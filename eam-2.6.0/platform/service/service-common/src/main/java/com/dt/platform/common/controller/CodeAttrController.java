package com.dt.platform.common.controller;


import java.util.List;
import java.util.ArrayList;


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


import com.dt.platform.proxy.common.CodeAttrServiceProxy;
import com.dt.platform.domain.common.meta.CodeAttrVOMeta;
import com.dt.platform.domain.common.CodeAttr;
import com.dt.platform.domain.common.CodeAttrVO;
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
import com.dt.platform.domain.common.meta.CodeAttrMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ICodeAttrService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 编码属性接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 09:57:38
*/

@InDoc
@Api(tags = "编码属性")
@RestController("SysCodeAttrController")
public class CodeAttrController extends SuperController {

	@Autowired
	private ICodeAttrService codeAttrService;


	/**
	 * 添加编码属性
	*/
	@ApiOperation(value = "添加编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476322206368923648"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CodeAttrServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.INSERT)
	public Result insert(CodeAttrVO codeAttrVO) {
		Result result=codeAttrService.insert(codeAttrVO,false);
		return result;
	}



	/**
	 * 删除编码属性
	*/
	@ApiOperation(value = "删除编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476322206368923648")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CodeAttrServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  codeAttrService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=codeAttrService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除编码属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CodeAttrServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = codeAttrService.hasRefers(ids);
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
			Result result=codeAttrService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=codeAttrService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新编码属性
	*/
	@ApiOperation(value = "更新编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476322206368923648"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CodeAttrVOMeta.PAGE_INDEX , CodeAttrVOMeta.PAGE_SIZE , CodeAttrVOMeta.SEARCH_FIELD , CodeAttrVOMeta.FUZZY_FIELD , CodeAttrVOMeta.SEARCH_VALUE , CodeAttrVOMeta.DIRTY_FIELDS , CodeAttrVOMeta.SORT_FIELD , CodeAttrVOMeta.SORT_TYPE , CodeAttrVOMeta.IDS } )
	@SentinelResource(value = CodeAttrServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.UPDATE)
	public Result update(CodeAttrVO codeAttrVO) {
		Result result=codeAttrService.update(codeAttrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存编码属性
	*/
	@ApiOperation(value = "保存编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476322206368923648"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeAttrVOMeta.PAGE_INDEX , CodeAttrVOMeta.PAGE_SIZE , CodeAttrVOMeta.SEARCH_FIELD , CodeAttrVOMeta.FUZZY_FIELD , CodeAttrVOMeta.SEARCH_VALUE , CodeAttrVOMeta.DIRTY_FIELDS , CodeAttrVOMeta.SORT_FIELD , CodeAttrVOMeta.SORT_TYPE , CodeAttrVOMeta.IDS } )
	@SentinelResource(value = CodeAttrServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.SAVE)
	public Result save(CodeAttrVO codeAttrVO) {
		Result result=codeAttrService.save(codeAttrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取编码属性
	*/
	@ApiOperation(value = "获取编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CodeAttrServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.GET_BY_ID)
	public Result<CodeAttr> getById(String id) {
		Result<CodeAttr> result=new Result<>();
		CodeAttr codeAttr=codeAttrService.getById(id);
		result.success(true).data(codeAttr);
		return result;
	}


	/**
	 * 批量获取编码属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取编码属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CodeAttrServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.GET_BY_IDS)
	public Result<List<CodeAttr>> getByIds(List<String> ids) {
		Result<List<CodeAttr>> result=new Result<>();
		List<CodeAttr> list=codeAttrService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询编码属性
	*/
	@ApiOperation(value = "查询编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476322206368923648"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CodeAttrVOMeta.PAGE_INDEX , CodeAttrVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeAttrServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.QUERY_LIST)
	public Result<List<CodeAttr>> queryList(CodeAttrVO sample) {
		Result<List<CodeAttr>> result=new Result<>();
		List<CodeAttr> list=codeAttrService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询编码属性
	*/
	@ApiOperation(value = "分页查询编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "476322206368923648"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CodeAttrServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeAttr>> queryPagedList(CodeAttrVO sample) {
		Result<PagedList<CodeAttr>> result=new Result<>();
		PagedList<CodeAttr> list=codeAttrService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}