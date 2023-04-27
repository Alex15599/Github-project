package com.dt.platform.datacenter.controller;

import java.util.List;
import java.util.ArrayList;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.dt.platform.domain.datacenter.meta.LayerVOMeta;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.LayerVO;
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
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import com.dt.platform.domain.datacenter.Area;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.ILayerService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 层级 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-22 21:41:05
 */
@Api(tags = "层级")
@ApiSort(0)
@RestController("DcLayerController")
public class LayerController extends SuperController {

    @Autowired
    private ILayerService layerService;

    /**
     * 添加层级
     */
    @ApiOperation(value = "添加层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "565457784187916288"),
		@ApiImplicitParam(name = LayerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "楼层1"),
		@ApiImplicitParam(name = LayerVOMeta.AREA_ID, value = "区域", required = false, dataTypeClass = String.class, example = "575433967289761792"),
		@ApiImplicitParam(name = LayerVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = LayerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = LayerServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(LayerVO layerVO) {
        Result result = layerService.insert(layerVO, false);
        return result;
    }

    /**
     * 删除层级
     */
    @ApiOperation(value = "删除层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "565457784187916288")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = LayerServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  layerService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = layerService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除层级 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = LayerServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = layerService.hasRefers(ids);
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
            Result result = layerService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = layerService.deleteByIdsLogical(canDeleteIds);
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
     * 更新层级
     */
    @ApiOperation(value = "更新层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "565457784187916288"),
		@ApiImplicitParam(name = LayerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "楼层1"),
		@ApiImplicitParam(name = LayerVOMeta.AREA_ID, value = "区域", required = false, dataTypeClass = String.class, example = "575433967289761792"),
		@ApiImplicitParam(name = LayerVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = LayerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { LayerVOMeta.PAGE_INDEX, LayerVOMeta.PAGE_SIZE, LayerVOMeta.SEARCH_FIELD, LayerVOMeta.FUZZY_FIELD, LayerVOMeta.SEARCH_VALUE, LayerVOMeta.DIRTY_FIELDS, LayerVOMeta.SORT_FIELD, LayerVOMeta.SORT_TYPE, LayerVOMeta.IDS })
    @SentinelResource(value = LayerServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(LayerVO layerVO) {
        Result result = layerService.update(layerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存层级
     */
    @ApiOperation(value = "保存层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "565457784187916288"),
		@ApiImplicitParam(name = LayerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "楼层1"),
		@ApiImplicitParam(name = LayerVOMeta.AREA_ID, value = "区域", required = false, dataTypeClass = String.class, example = "575433967289761792"),
		@ApiImplicitParam(name = LayerVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = LayerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { LayerVOMeta.PAGE_INDEX, LayerVOMeta.PAGE_SIZE, LayerVOMeta.SEARCH_FIELD, LayerVOMeta.FUZZY_FIELD, LayerVOMeta.SEARCH_VALUE, LayerVOMeta.DIRTY_FIELDS, LayerVOMeta.SORT_FIELD, LayerVOMeta.SORT_TYPE, LayerVOMeta.IDS })
    @SentinelResource(value = LayerServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(LayerVO layerVO) {
        Result result = layerService.save(layerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取层级
     */
    @ApiOperation(value = "获取层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = LayerServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.GET_BY_ID)
    public Result<Layer> getById(String id) {
        Result<Layer> result = new Result<>();
        Layer layer = layerService.getById(id);
        // join 关联的对象
        layerService.dao().fill(layer).with(LayerMeta.AREA).execute();
        result.success(true).data(layer);
        return result;
    }

    /**
     * 批量获取层级 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = LayerServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.GET_BY_IDS)
    public Result<List<Layer>> getByIds(List<String> ids) {
        Result<List<Layer>> result = new Result<>();
        List<Layer> list = layerService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询层级
     */
    @ApiOperation(value = "查询层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "565457784187916288"),
		@ApiImplicitParam(name = LayerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "楼层1"),
		@ApiImplicitParam(name = LayerVOMeta.AREA_ID, value = "区域", required = false, dataTypeClass = String.class, example = "575433967289761792"),
		@ApiImplicitParam(name = LayerVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = LayerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { LayerVOMeta.PAGE_INDEX, LayerVOMeta.PAGE_SIZE })
    @SentinelResource(value = LayerServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.QUERY_LIST)
    public Result<List<Layer>> queryList(LayerVO sample) {
        Result<List<Layer>> result = new Result<>();
        List<Layer> list = layerService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询层级
     */
    @ApiOperation(value = "分页查询层级")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = LayerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "565457784187916288"),
		@ApiImplicitParam(name = LayerVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "楼层1"),
		@ApiImplicitParam(name = LayerVOMeta.AREA_ID, value = "区域", required = false, dataTypeClass = String.class, example = "575433967289761792"),
		@ApiImplicitParam(name = LayerVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = LayerVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = LayerServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LayerServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Layer>> queryPagedList(LayerVO sample) {
        Result<PagedList<Layer>> result = new Result<>();
        PagedList<Layer> list = layerService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        layerService.dao().fill(list).with(LayerMeta.AREA).execute();
        result.success(true).data(list);
        return result;
    }
}
