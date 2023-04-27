package com.dt.platform.ops.controller;


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


import com.dt.platform.proxy.ops.CmdbModelVServiceProxy;
import com.dt.platform.domain.ops.meta.CmdbModelVVOMeta;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModelVVO;
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
import com.dt.platform.domain.ops.meta.CmdbModelVMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICmdbModelVService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 配置值接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:33:56
*/

@InDoc
@Api(tags = "配置值")
@RestController("OpsCmdbModelVController")
public class CmdbModelVController extends SuperController {

	@Autowired
	private ICmdbModelVService cmdbModelVService;


	/**
	 * 添加配置值
	*/
	@ApiOperation(value = "添加配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "636683116160745472"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.INSERT)
	public Result insert(CmdbModelVVO cmdbModelVVO) {
		Result result=cmdbModelVService.insert(cmdbModelVVO,false);
		return result;
	}



	/**
	 * 删除配置值
	*/
	@ApiOperation(value = "删除配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "636683116160745472")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cmdbModelVService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=cmdbModelVService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除配置值 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CmdbModelVServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cmdbModelVService.hasRefers(ids);
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
			Result result=cmdbModelVService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cmdbModelVService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新配置值
	*/
	@ApiOperation(value = "更新配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "636683116160745472"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CmdbModelVVOMeta.PAGE_INDEX , CmdbModelVVOMeta.PAGE_SIZE , CmdbModelVVOMeta.SEARCH_FIELD , CmdbModelVVOMeta.FUZZY_FIELD , CmdbModelVVOMeta.SEARCH_VALUE , CmdbModelVVOMeta.DIRTY_FIELDS , CmdbModelVVOMeta.SORT_FIELD , CmdbModelVVOMeta.SORT_TYPE , CmdbModelVVOMeta.IDS } )
	@SentinelResource(value = CmdbModelVServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.UPDATE)
	public Result update(CmdbModelVVO cmdbModelVVO) {
		Result result=cmdbModelVService.update(cmdbModelVVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存配置值
	*/
	@ApiOperation(value = "保存配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "636683116160745472"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CmdbModelVVOMeta.PAGE_INDEX , CmdbModelVVOMeta.PAGE_SIZE , CmdbModelVVOMeta.SEARCH_FIELD , CmdbModelVVOMeta.FUZZY_FIELD , CmdbModelVVOMeta.SEARCH_VALUE , CmdbModelVVOMeta.DIRTY_FIELDS , CmdbModelVVOMeta.SORT_FIELD , CmdbModelVVOMeta.SORT_TYPE , CmdbModelVVOMeta.IDS } )
	@SentinelResource(value = CmdbModelVServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.SAVE)
	public Result save(CmdbModelVVO cmdbModelVVO) {
		Result result=cmdbModelVService.save(cmdbModelVVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取配置值
	*/
	@ApiOperation(value = "获取配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.GET_BY_ID)
	public Result<CmdbModelV> getById(String id) {
		Result<CmdbModelV> result=new Result<>();
		CmdbModelV cmdbModelV=cmdbModelVService.getById(id);
		result.success(true).data(cmdbModelV);
		return result;
	}


	/**
	 * 批量获取配置值 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取配置值")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CmdbModelVVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CmdbModelVServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.GET_BY_IDS)
	public Result<List<CmdbModelV>> getByIds(List<String> ids) {
		Result<List<CmdbModelV>> result=new Result<>();
		List<CmdbModelV> list=cmdbModelVService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询配置值
	*/
	@ApiOperation(value = "查询配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "636683116160745472"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CmdbModelVVOMeta.PAGE_INDEX , CmdbModelVVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CmdbModelVServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.QUERY_LIST)
	public Result<List<CmdbModelV>> queryList(CmdbModelVVO sample) {
		Result<List<CmdbModelV>> result=new Result<>();
		List<CmdbModelV> list=cmdbModelVService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询配置值
	*/
	@ApiOperation(value = "分页查询配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "636683116160745472"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CmdbModelV>> queryPagedList(CmdbModelVVO sample) {
		Result<PagedList<CmdbModelV>> result=new Result<>();
		PagedList<CmdbModelV> list=cmdbModelVService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}