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
import com.dt.platform.proxy.ops.DbInstanceServiceProxy;
import com.dt.platform.domain.ops.meta.DbInstanceVOMeta;
import com.dt.platform.domain.ops.DbInstance;
import com.dt.platform.domain.ops.DbInstanceVO;
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
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.HostMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbInstanceService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 数据库实例 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-04 06:17:08
 */
@Api(tags = "数据库实例")
@ApiSort(0)
@RestController("OpsDbInstanceController")
public class DbInstanceController extends SuperController {

    @Autowired
    private IDbInstanceService dbInstanceService;

    /**
     * 添加数据库实例
     */
    @ApiOperation(value = "添加数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "599945424333176832"),
		@ApiImplicitParam(name = DbInstanceVOMeta.HOST_ID, value = "主机编号", required = false, dataTypeClass = String.class, example = "599944128997883904"),
		@ApiImplicitParam(name = DbInstanceVOMeta.DATABASE_ID, value = "数据库编号", required = false, dataTypeClass = String.class, example = "473626988658032641"),
		@ApiImplicitParam(name = DbInstanceVOMeta.NAME, value = "实例名称", required = false, dataTypeClass = String.class, example = "ORCL"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LOG_METHOD, value = "日志模式", required = false, dataTypeClass = String.class, example = "metholog"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STRATEGY, value = "备份策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TYPE, value = "备份类型", required = false, dataTypeClass = String.class, example = "physical"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_DATAKEEP, value = "备份保留时长", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STATUS, value = "备份状态", required = false, dataTypeClass = String.class, example = "success"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_METHOD, value = "备份方式", required = false, dataTypeClass = String.class, example = "incr7"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TIME, value = "上次备份", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_SIZE, value = "备份大小", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LABELS, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = DbInstanceServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(DbInstanceVO dbInstanceVO) {
        Result result = dbInstanceService.insert(dbInstanceVO, false);
        return result;
    }

    /**
     * 删除数据库实例
     */
    @ApiOperation(value = "删除数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "599945424333176832")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = DbInstanceServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  dbInstanceService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = dbInstanceService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除数据库实例 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = DbInstanceServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = dbInstanceService.hasRefers(ids);
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
            Result result = dbInstanceService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = dbInstanceService.deleteByIdsLogical(canDeleteIds);
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
     * 更新数据库实例
     */
    @ApiOperation(value = "更新数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "599945424333176832"),
		@ApiImplicitParam(name = DbInstanceVOMeta.HOST_ID, value = "主机编号", required = false, dataTypeClass = String.class, example = "599944128997883904"),
		@ApiImplicitParam(name = DbInstanceVOMeta.DATABASE_ID, value = "数据库编号", required = false, dataTypeClass = String.class, example = "473626988658032641"),
		@ApiImplicitParam(name = DbInstanceVOMeta.NAME, value = "实例名称", required = false, dataTypeClass = String.class, example = "ORCL"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LOG_METHOD, value = "日志模式", required = false, dataTypeClass = String.class, example = "metholog"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STRATEGY, value = "备份策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TYPE, value = "备份类型", required = false, dataTypeClass = String.class, example = "physical"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_DATAKEEP, value = "备份保留时长", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STATUS, value = "备份状态", required = false, dataTypeClass = String.class, example = "success"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_METHOD, value = "备份方式", required = false, dataTypeClass = String.class, example = "incr7"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TIME, value = "上次备份", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_SIZE, value = "备份大小", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LABELS, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { DbInstanceVOMeta.PAGE_INDEX, DbInstanceVOMeta.PAGE_SIZE, DbInstanceVOMeta.SEARCH_FIELD, DbInstanceVOMeta.FUZZY_FIELD, DbInstanceVOMeta.SEARCH_VALUE, DbInstanceVOMeta.DIRTY_FIELDS, DbInstanceVOMeta.SORT_FIELD, DbInstanceVOMeta.SORT_TYPE, DbInstanceVOMeta.IDS })
    @SentinelResource(value = DbInstanceServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(DbInstanceVO dbInstanceVO) {
        Result result = dbInstanceService.update(dbInstanceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存数据库实例
     */
    @ApiOperation(value = "保存数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "599945424333176832"),
		@ApiImplicitParam(name = DbInstanceVOMeta.HOST_ID, value = "主机编号", required = false, dataTypeClass = String.class, example = "599944128997883904"),
		@ApiImplicitParam(name = DbInstanceVOMeta.DATABASE_ID, value = "数据库编号", required = false, dataTypeClass = String.class, example = "473626988658032641"),
		@ApiImplicitParam(name = DbInstanceVOMeta.NAME, value = "实例名称", required = false, dataTypeClass = String.class, example = "ORCL"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LOG_METHOD, value = "日志模式", required = false, dataTypeClass = String.class, example = "metholog"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STRATEGY, value = "备份策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TYPE, value = "备份类型", required = false, dataTypeClass = String.class, example = "physical"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_DATAKEEP, value = "备份保留时长", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STATUS, value = "备份状态", required = false, dataTypeClass = String.class, example = "success"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_METHOD, value = "备份方式", required = false, dataTypeClass = String.class, example = "incr7"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TIME, value = "上次备份", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_SIZE, value = "备份大小", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LABELS, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { DbInstanceVOMeta.PAGE_INDEX, DbInstanceVOMeta.PAGE_SIZE, DbInstanceVOMeta.SEARCH_FIELD, DbInstanceVOMeta.FUZZY_FIELD, DbInstanceVOMeta.SEARCH_VALUE, DbInstanceVOMeta.DIRTY_FIELDS, DbInstanceVOMeta.SORT_FIELD, DbInstanceVOMeta.SORT_TYPE, DbInstanceVOMeta.IDS })
    @SentinelResource(value = DbInstanceServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(DbInstanceVO dbInstanceVO) {
        Result result = dbInstanceService.save(dbInstanceVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取数据库实例
     */
    @ApiOperation(value = "获取数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = DbInstanceServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.GET_BY_ID)
    public Result<DbInstance> getById(String id) {
        Result<DbInstance> result = new Result<>();
        DbInstance dbInstance = dbInstanceService.getById(id);
        // join 关联的对象
        dbInstanceService.dao().fill(dbInstance).with(DbInstanceMeta.HOST).with(DbInstanceMeta.HOST).with(DbInstanceMeta.DATABASE).execute();
        result.success(true).data(dbInstance);
        return result;
    }

    /**
     * 批量获取数据库实例 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = DbInstanceServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.GET_BY_IDS)
    public Result<List<DbInstance>> getByIds(List<String> ids) {
        Result<List<DbInstance>> result = new Result<>();
        List<DbInstance> list = dbInstanceService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询数据库实例
     */
    @ApiOperation(value = "查询数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "599945424333176832"),
		@ApiImplicitParam(name = DbInstanceVOMeta.HOST_ID, value = "主机编号", required = false, dataTypeClass = String.class, example = "599944128997883904"),
		@ApiImplicitParam(name = DbInstanceVOMeta.DATABASE_ID, value = "数据库编号", required = false, dataTypeClass = String.class, example = "473626988658032641"),
		@ApiImplicitParam(name = DbInstanceVOMeta.NAME, value = "实例名称", required = false, dataTypeClass = String.class, example = "ORCL"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LOG_METHOD, value = "日志模式", required = false, dataTypeClass = String.class, example = "metholog"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STRATEGY, value = "备份策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TYPE, value = "备份类型", required = false, dataTypeClass = String.class, example = "physical"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_DATAKEEP, value = "备份保留时长", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STATUS, value = "备份状态", required = false, dataTypeClass = String.class, example = "success"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_METHOD, value = "备份方式", required = false, dataTypeClass = String.class, example = "incr7"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TIME, value = "上次备份", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_SIZE, value = "备份大小", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LABELS, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { DbInstanceVOMeta.PAGE_INDEX, DbInstanceVOMeta.PAGE_SIZE })
    @SentinelResource(value = DbInstanceServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.QUERY_LIST)
    public Result<List<DbInstance>> queryList(DbInstanceVO sample) {
        Result<List<DbInstance>> result = new Result<>();
        List<DbInstance> list = dbInstanceService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询数据库实例
     */
    @ApiOperation(value = "分页查询数据库实例")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = DbInstanceVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "599945424333176832"),
		@ApiImplicitParam(name = DbInstanceVOMeta.HOST_ID, value = "主机编号", required = false, dataTypeClass = String.class, example = "599944128997883904"),
		@ApiImplicitParam(name = DbInstanceVOMeta.DATABASE_ID, value = "数据库编号", required = false, dataTypeClass = String.class, example = "473626988658032641"),
		@ApiImplicitParam(name = DbInstanceVOMeta.NAME, value = "实例名称", required = false, dataTypeClass = String.class, example = "ORCL"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LOG_METHOD, value = "日志模式", required = false, dataTypeClass = String.class, example = "metholog"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STRATEGY, value = "备份策略", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TYPE, value = "备份类型", required = false, dataTypeClass = String.class, example = "physical"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_DATAKEEP, value = "备份保留时长", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_STATUS, value = "备份状态", required = false, dataTypeClass = String.class, example = "success"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_METHOD, value = "备份方式", required = false, dataTypeClass = String.class, example = "incr7"),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_TIME, value = "上次备份", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.BACKUP_SIZE, value = "备份大小", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = DbInstanceVOMeta.LABELS, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbInstanceVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = DbInstanceServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbInstanceServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DbInstance>> queryPagedList(DbInstanceVO sample) {
        Result<PagedList<DbInstance>> result = new Result<>();
        PagedList<DbInstance> list = dbInstanceService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        dbInstanceService.dao().fill(list).with(DbInstanceMeta.HOST).with(DbInstanceMeta.HOST).with(DbInstanceMeta.DATABASE).execute();
        result.success(true).data(list);
        return result;
    }
}
