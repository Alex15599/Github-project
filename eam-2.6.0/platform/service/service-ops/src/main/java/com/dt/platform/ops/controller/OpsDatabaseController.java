package com.dt.platform.ops.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.deepoove.poi.util.PoitlIOUtils;
import com.dt.platform.constants.enums.ops.OpsOperateEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.ops.service.IOpsDataService;
import com.dt.platform.ops.service.IOpsDatabaseService;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.proxy.ops.OpsDataServiceProxy;
import com.dt.platform.proxy.ops.OpsDatabaseServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 主机 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:49
*/

@Api(tags = "数据库操作")
@ApiSort(0)
@RestController("OpsDatabaseController")
public class OpsDatabaseController extends SuperController {

    @Autowired
    IOpsDatabaseService opsDatabaseService;

    /**
     * 插入备份记录
     */
    @ApiOperation(value = "插入备份记录")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = OpsDatabaseServiceProxy.RECORD_DATABASE_BACKUP , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(OpsDatabaseServiceProxy.RECORD_DATABASE_BACKUP)
    public Result recordDatabaseBackup(DbBackupRecordVO dbBackupRecord){
        return opsDatabaseService.recordDatabaseBackup(dbBackupRecord);
    }

    /**
     * 插入备份记录
     */
    @ApiOperation(value = "获取数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = OpsDatabaseServiceProxy.QUERY_DATABASE_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(OpsDatabaseServiceProxy.QUERY_DATABASE_DATA)
    public Result queryDatabaseData(String code){
        return opsDatabaseService.queryDatabaseData(code);
    }



}