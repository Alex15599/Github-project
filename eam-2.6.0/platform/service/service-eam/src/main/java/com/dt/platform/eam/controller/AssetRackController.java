package com.dt.platform.eam.controller;

import java.util.List;
import java.util.ArrayList;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.eam.AssetRackInfo;
import com.dt.platform.domain.eam.Position;
import com.github.foxnic.commons.lang.StringUtil;
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
import com.dt.platform.proxy.eam.AssetRackServiceProxy;
import com.dt.platform.domain.eam.meta.AssetRackVOMeta;
import com.dt.platform.domain.eam.AssetRack;
import com.dt.platform.domain.eam.AssetRackVO;
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
import com.dt.platform.domain.eam.meta.AssetRackMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetRackService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 设备机柜 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-27 22:14:55
 */
@Api(tags = "设备机柜")
@ApiSort(0)
@RestController("EamAssetRackController")
public class AssetRackController extends SuperController {

    @Autowired
    private IAssetRackService assetRackService;

    /**
     * 添加设备机柜
     */
    @ApiOperation(value = "添加设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.RACK_ID, value = "机柜", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetRackServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetRackVO assetRackVO) {
        assetRackVO.setSort(9999);
        if (StringUtil.isBlank(assetRackVO.getParentId())) {
            assetRackVO.setParentId("0");
        }
        Result result = assetRackService.insert(assetRackVO, false);
        if (result.success()) {
            AssetRack currentPosition = new AssetRack();
            currentPosition.setId(assetRackVO.getId());
            if ("0".equals(assetRackVO.getParentId())) {
                currentPosition.setHierarchy(assetRackVO.getId());
                currentPosition.setHierarchyName(assetRackVO.getName());
            } else {
                AssetRack parentPosition = assetRackService.getById(assetRackVO.getParentId());
                currentPosition.setHierarchy(parentPosition.getHierarchy() + "/" + assetRackVO.getId());
                currentPosition.setHierarchyName(parentPosition.getHierarchyName() + "/" + assetRackVO.getName());
            }
            assetRackService.update(currentPosition, SaveMode.NOT_NULL_FIELDS);
            assetRackVO.setHierarchy(currentPosition.getHierarchy());
            assetRackVO.setHierarchyName(currentPosition.getHierarchyName());
            result.data(assetRackVO);
        }
        return result;
    }

    /**
     * 删除设备机柜
     */
    @ApiOperation(value = "删除设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetRackServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        List<AssetRack> list = assetRackService.queryList(AssetRack.create().setParentId(id));
        if (list.size() > 0) {
            Result<Position> result = new Result<>();
            result.success(false).message("请先删除下级节点");
            return result;
        }
        // 引用校验
        ReferCause cause =  assetRackService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetRackService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除设备机柜 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetRackServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetRackService.hasRefers(ids);
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
            Result result = assetRackService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetRackService.deleteByIdsLogical(canDeleteIds);
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
     * 更新设备机柜
     */
    @ApiOperation(value = "更新设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.RACK_ID, value = "机柜", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetRackVOMeta.PAGE_INDEX, AssetRackVOMeta.PAGE_SIZE, AssetRackVOMeta.SEARCH_FIELD, AssetRackVOMeta.FUZZY_FIELD, AssetRackVOMeta.SEARCH_VALUE, AssetRackVOMeta.DIRTY_FIELDS, AssetRackVOMeta.SORT_FIELD, AssetRackVOMeta.SORT_TYPE, AssetRackVOMeta.IDS })
    @SentinelResource(value = AssetRackServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetRackVO assetRackVO) {
        Result result = assetRackService.update(assetRackVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            // 更新分类名称
            return assetRackService.updateHierarchy(assetRackVO.getId());
        }
        return result;
    }

    /**
     * 保存设备机柜
     */
    @ApiOperation(value = "保存设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.RACK_ID, value = "机柜", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetRackVOMeta.PAGE_INDEX, AssetRackVOMeta.PAGE_SIZE, AssetRackVOMeta.SEARCH_FIELD, AssetRackVOMeta.FUZZY_FIELD, AssetRackVOMeta.SEARCH_VALUE, AssetRackVOMeta.DIRTY_FIELDS, AssetRackVOMeta.SORT_FIELD, AssetRackVOMeta.SORT_TYPE, AssetRackVOMeta.IDS })
    @SentinelResource(value = AssetRackServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetRackVO assetRackVO) {
        Result result = assetRackService.save(assetRackVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            // 更新分类名称
            return assetRackService.updateHierarchy(assetRackVO.getId());
        }
        return result;
    }

    /**
     * 获取设备机柜
     */
    @ApiOperation(value = "获取设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetRackServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.GET_BY_ID)
    public Result<AssetRack> getById(String id) {
        Result<AssetRack> result = new Result<>();
        AssetRack assetRack = assetRackService.getById(id);
        // join 关联的对象
        assetRackService.dao().fill(assetRack).with(AssetRackMeta.RACK_INFO).execute();
        result.success(true).data(assetRack);
        return result;
    }

    /**
     * 批量获取设备机柜 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetRackServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.GET_BY_IDS)
    public Result<List<AssetRack>> getByIds(List<String> ids) {
        Result<List<AssetRack>> result = new Result<>();
        List<AssetRack> list = assetRackService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询设备机柜
     */
    @ApiOperation(value = "查询设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.RACK_ID, value = "机柜", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetRackVOMeta.PAGE_INDEX, AssetRackVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetRackServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.QUERY_LIST)
    public Result<List<AssetRack>> queryList(AssetRackVO sample) {
        Result<List<AssetRack>> result = new Result<>();
        List<AssetRack> list = assetRackService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询设备机柜
     */
    @ApiOperation(value = "分页查询设备机柜")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetRackVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.RACK_ID, value = "机柜", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetRackVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetRackVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetRackServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetRackServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetRack>> queryPagedList(AssetRackVO sample) {
        Result<PagedList<AssetRack>> result = new Result<>();
        PagedList<AssetRack> list = assetRackService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
