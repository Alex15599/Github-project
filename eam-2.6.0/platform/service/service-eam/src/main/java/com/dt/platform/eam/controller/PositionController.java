package com.dt.platform.eam.controller;

import java.util.List;
import java.util.ArrayList;
import com.dt.platform.domain.eam.CategoryFinance;
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
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.domain.eam.meta.PositionVOMeta;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.PositionVO;
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
import com.dt.platform.domain.eam.meta.PositionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPositionService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 存放位置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-27 20:42:29
 */
@Api(tags = "存放位置")
@ApiSort(0)
@RestController("EamPositionController")
public class PositionController extends SuperController {

    @Autowired
    private IPositionService positionService;

    /**
     * 添加存放位置
     */
    @ApiOperation(value = "添加存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = PositionServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(PositionVO positionVO) {
        positionVO.setSort(9999);

        if (StringUtil.isBlank(positionVO.getParentId())) {
            positionVO.setParentId("0");
        }
        Result result = positionService.insert(positionVO, false);
        if (result.success()) {
            Position currentPosition = new Position();
            currentPosition.setId(positionVO.getId());
            if ("0".equals(positionVO.getParentId())) {
                currentPosition.setHierarchy(positionVO.getId());
                currentPosition.setHierarchyName(positionVO.getName());
            } else {
                Position parentPosition = positionService.getById(positionVO.getParentId());
                currentPosition.setHierarchy(parentPosition.getHierarchy() + "/" + positionVO.getId());
                currentPosition.setHierarchyName(parentPosition.getHierarchyName() + "/" + positionVO.getName());
            }
            positionService.update(currentPosition, SaveMode.NOT_NULL_FIELDS);
            positionVO.setHierarchy(currentPosition.getHierarchy());
            positionVO.setHierarchyName(currentPosition.getHierarchyName());
            result.data(positionVO);
        }
        return result;
    }

    /**
     * 删除存放位置
     */
    @ApiOperation(value = "删除存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = PositionServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.DELETE)
    public Result deleteById(String id) {
        List<Position> list = positionService.queryList(Position.create().setParentId(id));
        if (list.size() > 0) {
            Result<Position> result = new Result<>();
            result.success(false).message("请先删除下级节点");
            return result;
        }
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  positionService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = positionService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除存放位置 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = PositionServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = positionService.hasRefers(ids);
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
            Result result = positionService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = positionService.deleteByIdsLogical(canDeleteIds);
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
     * 更新存放位置
     */
    @ApiOperation(value = "更新存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { PositionVOMeta.PAGE_INDEX, PositionVOMeta.PAGE_SIZE, PositionVOMeta.SEARCH_FIELD, PositionVOMeta.FUZZY_FIELD, PositionVOMeta.SEARCH_VALUE, PositionVOMeta.DIRTY_FIELDS, PositionVOMeta.SORT_FIELD, PositionVOMeta.SORT_TYPE, PositionVOMeta.IDS })
    @SentinelResource(value = PositionServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(PositionVO positionVO) {
        Result result = positionService.update(positionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            // 更新分类名称
            return positionService.updateHierarchy(positionVO.getId());
        }
        return result;
    }

    /**
     * 保存存放位置
     */
    @ApiOperation(value = "保存存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { PositionVOMeta.PAGE_INDEX, PositionVOMeta.PAGE_SIZE, PositionVOMeta.SEARCH_FIELD, PositionVOMeta.FUZZY_FIELD, PositionVOMeta.SEARCH_VALUE, PositionVOMeta.DIRTY_FIELDS, PositionVOMeta.SORT_FIELD, PositionVOMeta.SORT_TYPE, PositionVOMeta.IDS })
    @SentinelResource(value = PositionServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(PositionVO positionVO) {
        Result result = positionService.save(positionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        if (result.isSuccess()) {
            // 更新分类名称
            return positionService.updateHierarchy(positionVO.getId());
        }
        return result;
    }

    /**
     * 获取存放位置
     */
    @ApiOperation(value = "获取存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = PositionServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.GET_BY_ID)
    public Result<Position> getById(String id) {
        Result<Position> result = new Result<>();
        Position position = positionService.getById(id);
        result.success(true).data(position);
        return result;
    }

    /**
     * 批量获取存放位置 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = PositionServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.GET_BY_IDS)
    public Result<List<Position>> getByIds(List<String> ids) {
        Result<List<Position>> result = new Result<>();
        List<Position> list = positionService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询存放位置
     */
    @ApiOperation(value = "查询存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { PositionVOMeta.PAGE_INDEX, PositionVOMeta.PAGE_SIZE })
    @SentinelResource(value = PositionServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.QUERY_LIST)
    public Result<List<Position>> queryList(PositionVO sample) {
        Result<List<Position>> result = new Result<>();
        List<Position> list = positionService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询存放位置
     */
    @ApiOperation(value = "分页查询存放位置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PositionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.PARENT_ID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY, value = "节点路径", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.HIERARCHY_NAME, value = "节点路径名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PositionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = PositionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = PositionServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PositionServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Position>> queryPagedList(PositionVO sample) {
        Result<PagedList<Position>> result = new Result<>();
        PagedList<Position> list = positionService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
