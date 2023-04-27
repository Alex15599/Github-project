package com.dt.platform.eam.controller;

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
import com.dt.platform.proxy.eam.AssetDataPermissionsOOrgServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDataPermissionsOOrgVOMeta;
import com.dt.platform.domain.eam.AssetDataPermissionsOOrg;
import com.dt.platform.domain.eam.AssetDataPermissionsOOrgVO;
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
import com.dt.platform.domain.eam.meta.AssetDataPermissionsOOrgMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDataPermissionsOOrgService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 所属 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-17 06:31:21
 */
@Api(tags = "所属")
@ApiSort(0)
@RestController("EamAssetDataPermissionsOOrgController")
public class AssetDataPermissionsOOrgController extends SuperController {

    @Autowired
    private IAssetDataPermissionsOOrgService assetDataPermissionsOOrgService;

    /**
     * 添加所属
     */
    @ApiOperation(value = "添加所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.PERMISSION_ID, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.VALUE, value = "值", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetDataPermissionsOOrgVO assetDataPermissionsOOrgVO) {
        Result result = assetDataPermissionsOOrgService.insert(assetDataPermissionsOOrgVO, false);
        return result;
    }

    /**
     * 删除所属
     */
    @ApiOperation(value = "删除所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetDataPermissionsOOrgService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetDataPermissionsOOrgService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除所属 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetDataPermissionsOOrgService.hasRefers(ids);
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
            Result result = assetDataPermissionsOOrgService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetDataPermissionsOOrgService.deleteByIdsLogical(canDeleteIds);
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
     * 更新所属
     */
    @ApiOperation(value = "更新所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.PERMISSION_ID, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.VALUE, value = "值", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetDataPermissionsOOrgVOMeta.PAGE_INDEX, AssetDataPermissionsOOrgVOMeta.PAGE_SIZE, AssetDataPermissionsOOrgVOMeta.SEARCH_FIELD, AssetDataPermissionsOOrgVOMeta.FUZZY_FIELD, AssetDataPermissionsOOrgVOMeta.SEARCH_VALUE, AssetDataPermissionsOOrgVOMeta.DIRTY_FIELDS, AssetDataPermissionsOOrgVOMeta.SORT_FIELD, AssetDataPermissionsOOrgVOMeta.SORT_TYPE, AssetDataPermissionsOOrgVOMeta.IDS })
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetDataPermissionsOOrgVO assetDataPermissionsOOrgVO) {
        Result result = assetDataPermissionsOOrgService.update(assetDataPermissionsOOrgVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存所属
     */
    @ApiOperation(value = "保存所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.PERMISSION_ID, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.VALUE, value = "值", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetDataPermissionsOOrgVOMeta.PAGE_INDEX, AssetDataPermissionsOOrgVOMeta.PAGE_SIZE, AssetDataPermissionsOOrgVOMeta.SEARCH_FIELD, AssetDataPermissionsOOrgVOMeta.FUZZY_FIELD, AssetDataPermissionsOOrgVOMeta.SEARCH_VALUE, AssetDataPermissionsOOrgVOMeta.DIRTY_FIELDS, AssetDataPermissionsOOrgVOMeta.SORT_FIELD, AssetDataPermissionsOOrgVOMeta.SORT_TYPE, AssetDataPermissionsOOrgVOMeta.IDS })
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetDataPermissionsOOrgVO assetDataPermissionsOOrgVO) {
        Result result = assetDataPermissionsOOrgService.save(assetDataPermissionsOOrgVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取所属
     */
    @ApiOperation(value = "获取所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.GET_BY_ID)
    public Result<AssetDataPermissionsOOrg> getById(String id) {
        Result<AssetDataPermissionsOOrg> result = new Result<>();
        AssetDataPermissionsOOrg assetDataPermissionsOOrg = assetDataPermissionsOOrgService.getById(id);
        result.success(true).data(assetDataPermissionsOOrg);
        return result;
    }

    /**
     * 批量获取所属 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.GET_BY_IDS)
    public Result<List<AssetDataPermissionsOOrg>> getByIds(List<String> ids) {
        Result<List<AssetDataPermissionsOOrg>> result = new Result<>();
        List<AssetDataPermissionsOOrg> list = assetDataPermissionsOOrgService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询所属
     */
    @ApiOperation(value = "查询所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.PERMISSION_ID, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.VALUE, value = "值", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetDataPermissionsOOrgVOMeta.PAGE_INDEX, AssetDataPermissionsOOrgVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.QUERY_LIST)
    public Result<List<AssetDataPermissionsOOrg>> queryList(AssetDataPermissionsOOrgVO sample) {
        Result<List<AssetDataPermissionsOOrg>> result = new Result<>();
        List<AssetDataPermissionsOOrg> list = assetDataPermissionsOOrgService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询所属
     */
    @ApiOperation(value = "分页查询所属")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.PERMISSION_ID, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOOrgVOMeta.VALUE, value = "值", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetDataPermissionsOOrgServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDataPermissionsOOrgServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetDataPermissionsOOrg>> queryPagedList(AssetDataPermissionsOOrgVO sample) {
        Result<PagedList<AssetDataPermissionsOOrg>> result = new Result<>();
        PagedList<AssetDataPermissionsOOrg> list = assetDataPermissionsOOrgService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
