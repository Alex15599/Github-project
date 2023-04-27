package com.dt.platform.eam.controller;

import java.util.List;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.CCustInspectItemMeta;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
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
import com.dt.platform.proxy.eam.InspectionTaskPointServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionTaskPointVOMeta;
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
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionTaskPointService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 巡检点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-12 21:07:10
 */
@Api(tags = "巡检点")
@ApiSort(0)
@RestController("EamInspectionTaskPointController")
public class InspectionTaskPointController extends SuperController {

    @Autowired
    private IInspectionTaskPointService inspectionTaskPointService;

    /**
     * 添加巡检点
     */
    @ApiOperation(value = "添加巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_STATUS, value = "巡检状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.CONTENT, value = "巡检结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NAME, value = "检", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS, value = "位置详情", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_ID, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ID, value = "巡检点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = InspectionTaskPointServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(InspectionTaskPointVO inspectionTaskPointVO) {
        Result result = inspectionTaskPointService.insert(inspectionTaskPointVO, false);
        return result;
    }

    /**
     * 删除巡检点
     */
    @ApiOperation(value = "删除巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = InspectionTaskPointServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = inspectionTaskPointService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除巡检点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InspectionTaskPointServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = inspectionTaskPointService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新巡检点
     */
    @ApiOperation(value = "更新巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_STATUS, value = "巡检状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.CONTENT, value = "巡检结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NAME, value = "检", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS, value = "位置详情", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_ID, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ID, value = "巡检点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { InspectionTaskPointVOMeta.PAGE_INDEX, InspectionTaskPointVOMeta.PAGE_SIZE, InspectionTaskPointVOMeta.SEARCH_FIELD, InspectionTaskPointVOMeta.FUZZY_FIELD, InspectionTaskPointVOMeta.SEARCH_VALUE, InspectionTaskPointVOMeta.DIRTY_FIELDS, InspectionTaskPointVOMeta.SORT_FIELD, InspectionTaskPointVOMeta.SORT_TYPE, InspectionTaskPointVOMeta.IDS })
    @SentinelResource(value = InspectionTaskPointServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(InspectionTaskPointVO inspectionTaskPointVO) {
        Result result = inspectionTaskPointService.update(inspectionTaskPointVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存巡检点
     */
    @ApiOperation(value = "保存巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_STATUS, value = "巡检状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.CONTENT, value = "巡检结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NAME, value = "检", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS, value = "位置详情", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_ID, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ID, value = "巡检点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InspectionTaskPointVOMeta.PAGE_INDEX, InspectionTaskPointVOMeta.PAGE_SIZE, InspectionTaskPointVOMeta.SEARCH_FIELD, InspectionTaskPointVOMeta.FUZZY_FIELD, InspectionTaskPointVOMeta.SEARCH_VALUE, InspectionTaskPointVOMeta.DIRTY_FIELDS, InspectionTaskPointVOMeta.SORT_FIELD, InspectionTaskPointVOMeta.SORT_TYPE, InspectionTaskPointVOMeta.IDS })
    @SentinelResource(value = InspectionTaskPointServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(InspectionTaskPointVO inspectionTaskPointVO) {
        Result result = inspectionTaskPointService.save(inspectionTaskPointVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取巡检点
     */
    @ApiOperation(value = "获取巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = InspectionTaskPointServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.GET_BY_ID)
    public Result<InspectionTaskPoint> getById(String id) {
        Result<InspectionTaskPoint> result = new Result<>();
        InspectionTaskPoint inspectionTaskPoint = inspectionTaskPointService.getById(id);
        // join 关联的对象
        inspectionTaskPointService.dao().fill(inspectionTaskPoint).with(InspectionTaskPointMeta.ROUTE).with(InspectionTaskPointMeta.INSPECTION_POINT_POS).execute();
        result.success(true).data(inspectionTaskPoint);
        return result;
    }

    /**
     * 批量获取巡检点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InspectionTaskPointServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.GET_BY_IDS)
    public Result<List<InspectionTaskPoint>> getByIds(List<String> ids) {
        Result<List<InspectionTaskPoint>> result = new Result<>();
        List<InspectionTaskPoint> list = inspectionTaskPointService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询巡检点
     */
    @ApiOperation(value = "查询巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_STATUS, value = "巡检状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.CONTENT, value = "巡检结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NAME, value = "检", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS, value = "位置详情", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_ID, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ID, value = "巡检点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InspectionTaskPointVOMeta.PAGE_INDEX, InspectionTaskPointVOMeta.PAGE_SIZE })
    @SentinelResource(value = InspectionTaskPointServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.QUERY_LIST)
    public Result<List<InspectionTaskPoint>> queryList(InspectionTaskPointVO sample) {
        Result<List<InspectionTaskPoint>> result = new Result<>();
        List<InspectionTaskPoint> list = inspectionTaskPointService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询巡检点
     */
    @ApiOperation(value = "分页查询巡检点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID, value = "任务", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_STATUS, value = "巡检状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_TIME, value = "操作时间", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.CONTENT, value = "巡检结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NAME, value = "检", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_CONTENT, value = "巡检内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ROUTE_ID, value = "巡检路线", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_RFID, value = "RFID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS, value = "位置详情", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LONGITUDE, value = "位置经度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_LATITUDE, value = "位置纬度", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_POS_ID, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.OPER_ID, value = "操作人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.POINT_ID, value = "巡检点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = InspectionTaskPointServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InspectionTaskPointServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<InspectionTaskPoint>> queryPagedList(InspectionTaskPointVO sample) {
        Result<PagedList<InspectionTaskPoint>> result = new Result<>();
        PagedList<InspectionTaskPoint> list = inspectionTaskPointService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        inspectionTaskPointService.dao().fill(list).with(InspectionTaskPointMeta.ROUTE).with(InspectionTaskPointMeta.OPER_USER).with(InspectionTaskPointMeta.INSPECTION_POINT_POS).execute();
        List<Employee> user2 = CollectorUtil.collectList(list, InspectionTaskPoint::getOperUser);
        inspectionTaskPointService.dao().join(user2, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = InspectionTaskPointServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InspectionTaskPointServiceProxy.EXPORT_EXCEL)
    public void exportExcel(InspectionTaskPointVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = inspectionTaskPointService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = InspectionTaskPointServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InspectionTaskPointServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = inspectionTaskPointService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = InspectionTaskPointServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InspectionTaskPointServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input = null;
        for (MultipartFile mf : map.values()) {
            input = StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if (input == null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = inspectionTaskPointService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
