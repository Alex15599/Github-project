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


import com.dt.platform.proxy.ops.CmdbModelVHServiceProxy;
import com.dt.platform.domain.ops.meta.CmdbModelVHVOMeta;
import com.dt.platform.domain.ops.CmdbModelVH;
import com.dt.platform.domain.ops.CmdbModelVHVO;
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
import com.dt.platform.domain.ops.meta.CmdbModelVHMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.domain.ops.CmdbModelV;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICmdbModelVHService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 配置值接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:34:05
*/

@InDoc
@Api(tags = "配置值")
@RestController("OpsCmdbModelVHController")
public class CmdbModelVHController extends SuperController {

	@Autowired
	private ICmdbModelVHService cmdbModelVHService;


	/**
	 * 添加配置值
	*/
	@ApiOperation(value = "添加配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVHServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.INSERT)
	public Result insert(CmdbModelVHVO cmdbModelVHVO) {
		Result result=cmdbModelVHService.insert(cmdbModelVHVO,false);
		return result;
	}



	/**
	 * 删除配置值
	*/
	@ApiOperation(value = "删除配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVHServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cmdbModelVHService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=cmdbModelVHService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除配置值 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CmdbModelVHServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cmdbModelVHService.hasRefers(ids);
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
			Result result=cmdbModelVHService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cmdbModelVHService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CmdbModelVHVOMeta.PAGE_INDEX , CmdbModelVHVOMeta.PAGE_SIZE , CmdbModelVHVOMeta.SEARCH_FIELD , CmdbModelVHVOMeta.FUZZY_FIELD , CmdbModelVHVOMeta.SEARCH_VALUE , CmdbModelVHVOMeta.DIRTY_FIELDS , CmdbModelVHVOMeta.SORT_FIELD , CmdbModelVHVOMeta.SORT_TYPE , CmdbModelVHVOMeta.IDS } )
	@SentinelResource(value = CmdbModelVHServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.UPDATE)
	public Result update(CmdbModelVHVO cmdbModelVHVO) {
		Result result=cmdbModelVHService.update(cmdbModelVHVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存配置值
	*/
	@ApiOperation(value = "保存配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true,ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CmdbModelVHVOMeta.PAGE_INDEX , CmdbModelVHVOMeta.PAGE_SIZE , CmdbModelVHVOMeta.SEARCH_FIELD , CmdbModelVHVOMeta.FUZZY_FIELD , CmdbModelVHVOMeta.SEARCH_VALUE , CmdbModelVHVOMeta.DIRTY_FIELDS , CmdbModelVHVOMeta.SORT_FIELD , CmdbModelVHVOMeta.SORT_TYPE , CmdbModelVHVOMeta.IDS } )
	@SentinelResource(value = CmdbModelVHServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.SAVE)
	public Result save(CmdbModelVHVO cmdbModelVHVO) {
		Result result=cmdbModelVHService.save(cmdbModelVHVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取配置值
	*/
	@ApiOperation(value = "获取配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVHServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.GET_BY_ID)
	public Result<CmdbModelVH> getById(String id) {
		Result<CmdbModelVH> result=new Result<>();
		CmdbModelVH cmdbModelVH=cmdbModelVHService.getById(id);
		result.success(true).data(cmdbModelVH);
		return result;
	}


	/**
	 * 批量获取配置值 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取配置值")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CmdbModelVHVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CmdbModelVHServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.GET_BY_IDS)
	public Result<List<CmdbModelVH>> getByIds(List<String> ids) {
		Result<List<CmdbModelVH>> result=new Result<>();
		List<CmdbModelVH> list=cmdbModelVHService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询配置值
	*/
	@ApiOperation(value = "查询配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CmdbModelVHVOMeta.PAGE_INDEX , CmdbModelVHVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CmdbModelVHServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.QUERY_LIST)
	public Result<List<CmdbModelVH>> queryList(CmdbModelVHVO sample) {
		Result<List<CmdbModelVH>> result=new Result<>();
		List<CmdbModelVH> list=cmdbModelVHService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询配置值
	*/
	@ApiOperation(value = "分页查询配置值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVHVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.PID , value = "父" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_ID , value = "模型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.MODEL_CODE , value = "模型编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DATA_TRACE_CODE , value = "数据跟踪" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.V_VERSION , value = "版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.OBJ_SOURCE_ID , value = "对象" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.S8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M4 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M5 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M6 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M7 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M8 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M9 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.M10 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS1 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS2 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.BS3 , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I1 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I2 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I3 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I4 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I5 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I6 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I7 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I8 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I9 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.I10 , value = "内容" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D1 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D2 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D3 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D4 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D5 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D6 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D7 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.D8 , value = "内容" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA1 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA2 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.DA3 , value = "内容" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CmdbModelVHVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CmdbModelVHServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CmdbModelVHServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CmdbModelVH>> queryPagedList(CmdbModelVHVO sample) {
		Result<PagedList<CmdbModelVH>> result=new Result<>();
		PagedList<CmdbModelVH> list=cmdbModelVHService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}