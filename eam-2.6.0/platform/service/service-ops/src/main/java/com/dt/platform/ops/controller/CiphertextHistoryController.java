package com.dt.platform.ops.controller;

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
import com.dt.platform.proxy.ops.CiphertextHistoryServiceProxy;
import com.dt.platform.domain.ops.meta.CiphertextHistoryVOMeta;
import com.dt.platform.domain.ops.CiphertextHistory;
import com.dt.platform.domain.ops.CiphertextHistoryVO;
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
import com.dt.platform.domain.ops.meta.CiphertextHistoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICiphertextHistoryService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 历史记录 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 14:16:45
 */
@Api(tags = "历史记录")
@ApiSort(0)
@RestController("OpsCiphertextHistoryController")
public class CiphertextHistoryController extends SuperController {

    @Autowired
    private ICiphertextHistoryService ciphertextHistoryService;

    /**
     * 添加历史记录
     */
    @ApiOperation(value = "添加历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635053950277517312"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "ciphertext_box_conf"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.BOX_TYPE, value = "密文箱类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.SOURCE_VALUE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ENCRYPTION_CONTENT, value = "加密内容", required = false, dataTypeClass = String.class, example = "121212dsf")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = CiphertextHistoryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(CiphertextHistoryVO ciphertextHistoryVO) {
        Result result = ciphertextHistoryService.insert(ciphertextHistoryVO, false);
        return result;
    }

    /**
     * 删除历史记录
     */
    @ApiOperation(value = "删除历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635053950277517312")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = CiphertextHistoryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  ciphertextHistoryService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = ciphertextHistoryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除历史记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = CiphertextHistoryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = ciphertextHistoryService.hasRefers(ids);
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
            Result result = ciphertextHistoryService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = ciphertextHistoryService.deleteByIdsLogical(canDeleteIds);
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
     * 更新历史记录
     */
    @ApiOperation(value = "更新历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635053950277517312"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "ciphertext_box_conf"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.BOX_TYPE, value = "密文箱类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.SOURCE_VALUE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ENCRYPTION_CONTENT, value = "加密内容", required = false, dataTypeClass = String.class, example = "121212dsf")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { CiphertextHistoryVOMeta.PAGE_INDEX, CiphertextHistoryVOMeta.PAGE_SIZE, CiphertextHistoryVOMeta.SEARCH_FIELD, CiphertextHistoryVOMeta.FUZZY_FIELD, CiphertextHistoryVOMeta.SEARCH_VALUE, CiphertextHistoryVOMeta.DIRTY_FIELDS, CiphertextHistoryVOMeta.SORT_FIELD, CiphertextHistoryVOMeta.SORT_TYPE, CiphertextHistoryVOMeta.IDS })
    @SentinelResource(value = CiphertextHistoryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(CiphertextHistoryVO ciphertextHistoryVO) {
        Result result = ciphertextHistoryService.update(ciphertextHistoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存历史记录
     */
    @ApiOperation(value = "保存历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635053950277517312"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "ciphertext_box_conf"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.BOX_TYPE, value = "密文箱类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.SOURCE_VALUE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ENCRYPTION_CONTENT, value = "加密内容", required = false, dataTypeClass = String.class, example = "121212dsf")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { CiphertextHistoryVOMeta.PAGE_INDEX, CiphertextHistoryVOMeta.PAGE_SIZE, CiphertextHistoryVOMeta.SEARCH_FIELD, CiphertextHistoryVOMeta.FUZZY_FIELD, CiphertextHistoryVOMeta.SEARCH_VALUE, CiphertextHistoryVOMeta.DIRTY_FIELDS, CiphertextHistoryVOMeta.SORT_FIELD, CiphertextHistoryVOMeta.SORT_TYPE, CiphertextHistoryVOMeta.IDS })
    @SentinelResource(value = CiphertextHistoryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(CiphertextHistoryVO ciphertextHistoryVO) {
        Result result = ciphertextHistoryService.save(ciphertextHistoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取历史记录
     */
    @ApiOperation(value = "获取历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = CiphertextHistoryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.GET_BY_ID)
    public Result<CiphertextHistory> getById(String id) {
        Result<CiphertextHistory> result = new Result<>();
        CiphertextHistory ciphertextHistory = ciphertextHistoryService.getById(id);
        result.success(true).data(ciphertextHistory);
        return result;
    }

    /**
     * 批量获取历史记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = CiphertextHistoryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.GET_BY_IDS)
    public Result<List<CiphertextHistory>> getByIds(List<String> ids) {
        Result<List<CiphertextHistory>> result = new Result<>();
        List<CiphertextHistory> list = ciphertextHistoryService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询历史记录
     */
    @ApiOperation(value = "查询历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635053950277517312"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "ciphertext_box_conf"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.BOX_TYPE, value = "密文箱类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.SOURCE_VALUE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ENCRYPTION_CONTENT, value = "加密内容", required = false, dataTypeClass = String.class, example = "121212dsf")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { CiphertextHistoryVOMeta.PAGE_INDEX, CiphertextHistoryVOMeta.PAGE_SIZE })
    @SentinelResource(value = CiphertextHistoryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.QUERY_LIST)
    public Result<List<CiphertextHistory>> queryList(CiphertextHistoryVO sample) {
        Result<List<CiphertextHistory>> result = new Result<>();
        List<CiphertextHistory> list = ciphertextHistoryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询历史记录
     */
    @ApiOperation(value = "分页查询历史记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635053950277517312"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "ciphertext_box_conf"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.BOX_TYPE, value = "密文箱类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.SOURCE_VALUE, value = "来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = CiphertextHistoryVOMeta.ENCRYPTION_CONTENT, value = "加密内容", required = false, dataTypeClass = String.class, example = "121212dsf")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = CiphertextHistoryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextHistoryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CiphertextHistory>> queryPagedList(CiphertextHistoryVO sample) {
        Result<PagedList<CiphertextHistory>> result = new Result<>();
        PagedList<CiphertextHistory> list = ciphertextHistoryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
