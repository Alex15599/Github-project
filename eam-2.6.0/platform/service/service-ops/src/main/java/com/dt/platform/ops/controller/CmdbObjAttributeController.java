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
import com.dt.platform.proxy.ops.CmdbObjAttributeServiceProxy;
import com.dt.platform.domain.ops.meta.CmdbObjAttributeVOMeta;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.domain.ops.CmdbObjAttributeVO;
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
import com.dt.platform.domain.ops.meta.CmdbObjAttributeMeta;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbAttributeC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICmdbObjAttributeService;

/**
 * <p>
 * 配置属性接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 22:49:17
 */
@InDoc
@Api(tags = "null/配置属性")
@RestController("OpsCmdbObjAttributeController")
public class CmdbObjAttributeController extends SuperController {

    @Autowired
    private ICmdbObjAttributeService cmdbObjAttributeService;

    /**
     * 添加配置属性
     */
    @ApiOperation(value = "添加配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "636664521074671616"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.MODEL_ID, value = "模型对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_NAME, value = "属性名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_TYPE, value = "属性类型", required = false, dataTypeClass = String.class, example = "STRING"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SOURCE, value = "字段来源", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_FILL, value = "字段填充", required = false, dataTypeClass = String.class, example = "desc"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SHOW, value = "显示字段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbObjAttributeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.INSERT)
    public Result insert(CmdbObjAttributeVO cmdbObjAttributeVO) {
        Result result = cmdbObjAttributeService.insert(cmdbObjAttributeVO, false);
        return result;
    }

    /**
     * 删除配置属性
     */
    @ApiOperation(value = "删除配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "636664521074671616")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbObjAttributeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  cmdbObjAttributeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = cmdbObjAttributeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除配置属性 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbObjAttributeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cmdbObjAttributeService.hasRefers(ids);
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
            Result result = cmdbObjAttributeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cmdbObjAttributeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新配置属性
     */
    @ApiOperation(value = "更新配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "636664521074671616"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.MODEL_ID, value = "模型对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_NAME, value = "属性名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_TYPE, value = "属性类型", required = false, dataTypeClass = String.class, example = "STRING"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SOURCE, value = "字段来源", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_FILL, value = "字段填充", required = false, dataTypeClass = String.class, example = "desc"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SHOW, value = "显示字段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbObjAttributeVOMeta.PAGE_INDEX, CmdbObjAttributeVOMeta.PAGE_SIZE, CmdbObjAttributeVOMeta.SEARCH_FIELD, CmdbObjAttributeVOMeta.FUZZY_FIELD, CmdbObjAttributeVOMeta.SEARCH_VALUE, CmdbObjAttributeVOMeta.DIRTY_FIELDS, CmdbObjAttributeVOMeta.SORT_FIELD, CmdbObjAttributeVOMeta.SORT_TYPE, CmdbObjAttributeVOMeta.IDS })
    @SentinelResource(value = CmdbObjAttributeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.UPDATE)
    public Result update(CmdbObjAttributeVO cmdbObjAttributeVO) {
        Result result = cmdbObjAttributeService.update(cmdbObjAttributeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存配置属性
     */
    @ApiOperation(value = "保存配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "636664521074671616"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.MODEL_ID, value = "模型对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_NAME, value = "属性名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_TYPE, value = "属性类型", required = false, dataTypeClass = String.class, example = "STRING"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SOURCE, value = "字段来源", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_FILL, value = "字段填充", required = false, dataTypeClass = String.class, example = "desc"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SHOW, value = "显示字段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CmdbObjAttributeVOMeta.PAGE_INDEX, CmdbObjAttributeVOMeta.PAGE_SIZE, CmdbObjAttributeVOMeta.SEARCH_FIELD, CmdbObjAttributeVOMeta.FUZZY_FIELD, CmdbObjAttributeVOMeta.SEARCH_VALUE, CmdbObjAttributeVOMeta.DIRTY_FIELDS, CmdbObjAttributeVOMeta.SORT_FIELD, CmdbObjAttributeVOMeta.SORT_TYPE, CmdbObjAttributeVOMeta.IDS })
    @SentinelResource(value = CmdbObjAttributeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.SAVE)
    public Result save(CmdbObjAttributeVO cmdbObjAttributeVO) {
        Result result = cmdbObjAttributeService.save(cmdbObjAttributeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取配置属性
     */
    @ApiOperation(value = "获取配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbObjAttributeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.GET_BY_ID)
    public Result<CmdbObjAttribute> getById(String id) {
        Result<CmdbObjAttribute> result = new Result<>();
        CmdbObjAttribute cmdbObjAttribute = cmdbObjAttributeService.getById(id);
        // join 关联的对象
        cmdbObjAttributeService.dao().fill(cmdbObjAttribute).with(CmdbObjAttributeMeta.CMDB_ATTRIBUTE_C).with(CmdbObjAttributeMeta.CMDB_MODEL).execute();
        result.success(true).data(cmdbObjAttribute);
        return result;
    }

    /**
     * 批量获取配置属性 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbObjAttributeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.GET_BY_IDS)
    public Result<List<CmdbObjAttribute>> getByIds(List<String> ids) {
        Result<List<CmdbObjAttribute>> result = new Result<>();
        List<CmdbObjAttribute> list = cmdbObjAttributeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询配置属性
     */
    @ApiOperation(value = "查询配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "636664521074671616"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.MODEL_ID, value = "模型对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_NAME, value = "属性名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_TYPE, value = "属性类型", required = false, dataTypeClass = String.class, example = "STRING"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SOURCE, value = "字段来源", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_FILL, value = "字段填充", required = false, dataTypeClass = String.class, example = "desc"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SHOW, value = "显示字段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbObjAttributeVOMeta.PAGE_INDEX, CmdbObjAttributeVOMeta.PAGE_SIZE })
    @SentinelResource(value = CmdbObjAttributeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.QUERY_LIST)
    public Result<List<CmdbObjAttribute>> queryList(CmdbObjAttributeVO sample) {
        Result<List<CmdbObjAttribute>> result = new Result<>();
        List<CmdbObjAttribute> list = cmdbObjAttributeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询配置属性
     */
    @ApiOperation(value = "分页查询配置属性")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "636664521074671616"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.MODEL_ID, value = "模型对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_NAME, value = "属性名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_TYPE, value = "属性类型", required = false, dataTypeClass = String.class, example = "STRING"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SOURCE, value = "字段来源", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_FILL, value = "字段填充", required = false, dataTypeClass = String.class, example = "desc"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.ATTRIBUTE_COL_SHOW, value = "显示字段", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = CmdbObjAttributeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbObjAttributeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbObjAttributeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CmdbObjAttribute>> queryPagedList(CmdbObjAttributeVO sample) {
        Result<PagedList<CmdbObjAttribute>> result = new Result<>();
        PagedList<CmdbObjAttribute> list = cmdbObjAttributeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        cmdbObjAttributeService.dao().fill(list).with(CmdbObjAttributeMeta.CMDB_ATTRIBUTE_C).with(CmdbObjAttributeMeta.CMDB_MODEL).execute();
        result.success(true).data(list);
        return result;
    }
}
