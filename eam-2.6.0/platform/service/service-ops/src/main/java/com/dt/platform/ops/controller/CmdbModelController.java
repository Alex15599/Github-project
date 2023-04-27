package com.dt.platform.ops.controller;

import java.util.List;
import java.util.ArrayList;
import com.dt.platform.domain.eam.Position;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
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
import com.dt.platform.proxy.ops.CmdbModelServiceProxy;
import com.dt.platform.domain.ops.meta.CmdbModelVOMeta;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbModelVO;
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
import com.dt.platform.domain.ops.meta.CmdbModelMeta;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.domain.ops.CmdbModelV;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICmdbModelService;

/**
 * <p>
 * 配置库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:28:39
 */
@InDoc
@Api(tags = "null/配置库")
@RestController("OpsCmdbModelController")
public class CmdbModelController extends SuperController {

    @Autowired
    private ICmdbModelService cmdbModelService;

    /**
     * 添加配置库
     */
    @ApiOperation(value = "添加配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.MODEL_TYPE, value = "模型类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SOURCE_TYPE, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.DATA_SOURCE, value = "来源方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbModelServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.INSERT)
    public Result insert(CmdbModelVO cmdbModelVO) {
        cmdbModelVO.setSort(9999);
        if (StringUtil.isBlank(cmdbModelVO.getParentId())) {
            cmdbModelVO.setParentId("0");
        }
        cmdbModelVO.setFullName(cmdbModelVO.getName());
        cmdbModelVO.setCode(IDGenerator.getSnowflakeIdString());
        Result result = cmdbModelService.insert(cmdbModelVO, false);
        if (result.success()) {
            CmdbModel currentCmdbModel = new CmdbModel();
            currentCmdbModel.setId(cmdbModelVO.getId());
            if ("0".equals(cmdbModelVO.getParentId())) {
                currentCmdbModel.setHierarchy(cmdbModelVO.getId());
                currentCmdbModel.setHierarchyName(cmdbModelVO.getName());
            } else {
                CmdbModel parentCmdbModel = cmdbModelService.getById(cmdbModelVO.getParentId());
                currentCmdbModel.setHierarchy(parentCmdbModel.getHierarchy() + "/" + cmdbModelVO.getId());
                currentCmdbModel.setHierarchyName(parentCmdbModel.getHierarchyName() + "/" + cmdbModelVO.getName());
            }
            cmdbModelService.update(currentCmdbModel, SaveMode.NOT_NULL_FIELDS);
            cmdbModelVO.setHierarchy(currentCmdbModel.getHierarchy());
            cmdbModelVO.setHierarchyName(currentCmdbModel.getHierarchyName());
            result.data(cmdbModelVO);
        }
        return result;
    }

    /**
     * 删除配置库
     */
    @ApiOperation(value = "删除配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbModelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.DELETE)
    public Result deleteById(String id) {
        List<CmdbModel> list = cmdbModelService.queryList(CmdbModel.create().setParentId(id));
        if (list.size() > 0) {
            Result<CmdbModel> result = new Result<>();
            result.success(false).message("请先删除下级节点");
            return result;
        }
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  cmdbModelService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = cmdbModelService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除配置库 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbModelServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cmdbModelService.hasRefers(ids);
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
            Result result = cmdbModelService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cmdbModelService.deleteByIdsLogical(canDeleteIds);
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
     * 更新配置库
     */
    @ApiOperation(value = "更新配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.MODEL_TYPE, value = "模型类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SOURCE_TYPE, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.DATA_SOURCE, value = "来源方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbModelVOMeta.PAGE_INDEX, CmdbModelVOMeta.PAGE_SIZE, CmdbModelVOMeta.SEARCH_FIELD, CmdbModelVOMeta.FUZZY_FIELD, CmdbModelVOMeta.SEARCH_VALUE, CmdbModelVOMeta.DIRTY_FIELDS, CmdbModelVOMeta.SORT_FIELD, CmdbModelVOMeta.SORT_TYPE, CmdbModelVOMeta.IDS })
    @SentinelResource(value = CmdbModelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.UPDATE)
    public Result update(CmdbModelVO cmdbModelVO) {
        Result result = cmdbModelService.update(cmdbModelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            return cmdbModelService.updateHierarchy(cmdbModelVO.getId());
        }
        return result;
    }

    /**
     * 保存配置库
     */
    @ApiOperation(value = "保存配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.MODEL_TYPE, value = "模型类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SOURCE_TYPE, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.DATA_SOURCE, value = "来源方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CmdbModelVOMeta.PAGE_INDEX, CmdbModelVOMeta.PAGE_SIZE, CmdbModelVOMeta.SEARCH_FIELD, CmdbModelVOMeta.FUZZY_FIELD, CmdbModelVOMeta.SEARCH_VALUE, CmdbModelVOMeta.DIRTY_FIELDS, CmdbModelVOMeta.SORT_FIELD, CmdbModelVOMeta.SORT_TYPE, CmdbModelVOMeta.IDS })
    @SentinelResource(value = CmdbModelServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.SAVE)
    public Result save(CmdbModelVO cmdbModelVO) {
        Result result = cmdbModelService.save(cmdbModelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            return cmdbModelService.updateHierarchy(cmdbModelVO.getId());
        }
        return result;
    }

    /**
     * 获取配置库
     */
    @ApiOperation(value = "获取配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbModelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.GET_BY_ID)
    public Result<CmdbModel> getById(String id) {
        Result<CmdbModel> result = new Result<>();
        CmdbModel cmdbModel = cmdbModelService.getById(id);
        result.success(true).data(cmdbModel);
        return result;
    }

    /**
     * 批量获取配置库 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbModelServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.GET_BY_IDS)
    public Result<List<CmdbModel>> getByIds(List<String> ids) {
        Result<List<CmdbModel>> result = new Result<>();
        List<CmdbModel> list = cmdbModelService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询配置库
     */
    @ApiOperation(value = "查询配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.MODEL_TYPE, value = "模型类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SOURCE_TYPE, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.DATA_SOURCE, value = "来源方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbModelVOMeta.PAGE_INDEX, CmdbModelVOMeta.PAGE_SIZE })
    @SentinelResource(value = CmdbModelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.QUERY_LIST)
    public Result<List<CmdbModel>> queryList(CmdbModelVO sample) {
        Result<List<CmdbModel>> result = new Result<>();
        List<CmdbModel> list = cmdbModelService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询配置库
     */
    @ApiOperation(value = "分页查询配置库")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CmdbModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.FULL_NAME, value = "全称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.MODEL_TYPE, value = "模型类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SOURCE_TYPE, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.DATA_SOURCE, value = "来源方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = CmdbModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.SOURCE", value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = "CmdbModelVOMeta.STORAGE_TYPE", value = "存储方式", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbModelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbModelServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CmdbModel>> queryPagedList(CmdbModelVO sample) {
        Result<PagedList<CmdbModel>> result = new Result<>();
        PagedList<CmdbModel> list = cmdbModelService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
