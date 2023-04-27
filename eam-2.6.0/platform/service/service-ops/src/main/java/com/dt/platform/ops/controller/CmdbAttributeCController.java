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
import com.dt.platform.proxy.ops.CmdbAttributeCServiceProxy;
import com.dt.platform.domain.ops.meta.CmdbAttributeCVOMeta;
import com.dt.platform.domain.ops.CmdbAttributeC;
import com.dt.platform.domain.ops.CmdbAttributeCVO;
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
import com.dt.platform.domain.ops.meta.CmdbAttributeCMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICmdbAttributeCService;

/**
 * <p>
 * 属性字段接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 22:46:00
 */
@InDoc
@Api(tags = "null/属性字段")
@RestController("OpsCmdbAttributeCController")
public class CmdbAttributeCController extends SuperController {

    @Autowired
    private ICmdbAttributeCService cmdbAttributeCService;

    /**
     * 添加属性字段
     */
    @ApiOperation(value = "添加属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635749764469620736"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.CODE, value = "字段", required = false, dataTypeClass = String.class, example = "name"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "名称"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.TYPE, value = "type", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbAttributeCServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.INSERT)
    public Result insert(CmdbAttributeCVO cmdbAttributeCVO) {
        Result result = cmdbAttributeCService.insert(cmdbAttributeCVO, false);
        return result;
    }

    /**
     * 删除属性字段
     */
    @ApiOperation(value = "删除属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635749764469620736")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbAttributeCServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  cmdbAttributeCService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = cmdbAttributeCService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除属性字段 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbAttributeCServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cmdbAttributeCService.hasRefers(ids);
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
            Result result = cmdbAttributeCService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cmdbAttributeCService.deleteByIdsLogical(canDeleteIds);
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
     * 更新属性字段
     */
    @ApiOperation(value = "更新属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635749764469620736"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.CODE, value = "字段", required = false, dataTypeClass = String.class, example = "name"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "名称"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.TYPE, value = "type", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbAttributeCVOMeta.PAGE_INDEX, CmdbAttributeCVOMeta.PAGE_SIZE, CmdbAttributeCVOMeta.SEARCH_FIELD, CmdbAttributeCVOMeta.FUZZY_FIELD, CmdbAttributeCVOMeta.SEARCH_VALUE, CmdbAttributeCVOMeta.DIRTY_FIELDS, CmdbAttributeCVOMeta.SORT_FIELD, CmdbAttributeCVOMeta.SORT_TYPE, CmdbAttributeCVOMeta.IDS })
    @SentinelResource(value = CmdbAttributeCServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.UPDATE)
    public Result update(CmdbAttributeCVO cmdbAttributeCVO) {
        Result result = cmdbAttributeCService.update(cmdbAttributeCVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存属性字段
     */
    @ApiOperation(value = "保存属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635749764469620736"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.CODE, value = "字段", required = false, dataTypeClass = String.class, example = "name"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "名称"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.TYPE, value = "type", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CmdbAttributeCVOMeta.PAGE_INDEX, CmdbAttributeCVOMeta.PAGE_SIZE, CmdbAttributeCVOMeta.SEARCH_FIELD, CmdbAttributeCVOMeta.FUZZY_FIELD, CmdbAttributeCVOMeta.SEARCH_VALUE, CmdbAttributeCVOMeta.DIRTY_FIELDS, CmdbAttributeCVOMeta.SORT_FIELD, CmdbAttributeCVOMeta.SORT_TYPE, CmdbAttributeCVOMeta.IDS })
    @SentinelResource(value = CmdbAttributeCServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.SAVE)
    public Result save(CmdbAttributeCVO cmdbAttributeCVO) {
        Result result = cmdbAttributeCService.save(cmdbAttributeCVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取属性字段
     */
    @ApiOperation(value = "获取属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbAttributeCServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.GET_BY_ID)
    public Result<CmdbAttributeC> getById(String id) {
        Result<CmdbAttributeC> result = new Result<>();
        CmdbAttributeC cmdbAttributeC = cmdbAttributeCService.getById(id);
        result.success(true).data(cmdbAttributeC);
        return result;
    }

    /**
     * 批量获取属性字段 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbAttributeCServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.GET_BY_IDS)
    public Result<List<CmdbAttributeC>> getByIds(List<String> ids) {
        Result<List<CmdbAttributeC>> result = new Result<>();
        List<CmdbAttributeC> list = cmdbAttributeCService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询属性字段
     */
    @ApiOperation(value = "查询属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635749764469620736"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.CODE, value = "字段", required = false, dataTypeClass = String.class, example = "name"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "名称"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.TYPE, value = "type", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbAttributeCVOMeta.PAGE_INDEX, CmdbAttributeCVOMeta.PAGE_SIZE })
    @SentinelResource(value = CmdbAttributeCServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.QUERY_LIST)
    public Result<List<CmdbAttributeC>> queryList(CmdbAttributeCVO sample) {
        Result<List<CmdbAttributeC>> result = new Result<>();
        List<CmdbAttributeC> list = cmdbAttributeCService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询属性字段
     */
    @ApiOperation(value = "分页查询属性字段")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635749764469620736"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.CODE, value = "字段", required = false, dataTypeClass = String.class, example = "name"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "名称"),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.TYPE, value = "type", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbAttributeCVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbAttributeCServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbAttributeCServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CmdbAttributeC>> queryPagedList(CmdbAttributeCVO sample) {
        Result<PagedList<CmdbAttributeC>> result = new Result<>();
        PagedList<CmdbAttributeC> list = cmdbAttributeCService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
