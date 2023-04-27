package com.dt.platform.eam.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.eam.service.IAssetRepairService;
import com.dt.platform.eam.service.IAssetReportService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.proxy.eam.AssetReportServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "资产报表")
@ApiSort(0)
@RestController("AssetReportController")
public class AssetReportController extends SuperController {

    @Autowired
    private IAssetService assetService;

    @Autowired
    private IAssetReportService assetReportService;

    @ApiOperation(value = "组织资产数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_ORGANIZATION_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_ORGANIZATION_DATA)
    public Result<JSONArray> queryOrganizationData(Asset sample) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryOrganizationData(sample));
        return result;
    }


    @ApiOperation(value = "资产所属数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_OWN_COMPANY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_OWN_COMPANY_DATA)
    public Result<JSONArray> queryOwnCompanyData(Asset sample) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryOwnCompanyData(sample));
        return result;
    }

    @ApiOperation(value = "分类资产数据")
    @ApiOperationSupport(order=2)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_CATEGORY_STATUS_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_CATEGORY_STATUS_DATA)
    public Result<JSONArray> queryCategoryStatusData(Asset sample) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryCategoryStatusData(sample));
        return result;
    }

    @ApiOperation(value = "分类资产数据")
    @ApiOperationSupport(order=2)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_CATEGORY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_CATEGORY_DATA)
    public Result<JSONArray> queryCategoryData(Asset sample) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryCategoryData(sample));
        return result;
    }


    @ApiOperation(value = "面板数据")
    @ApiOperationSupport(order=3)
    @SentinelResource(value = AssetReportServiceProxy.DASHBOARD , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.DASHBOARD)
    public Result<JSONObject> dashBoard() {
        Result<JSONObject> result=new Result<>();
        return assetReportService.dashboard();
    }

    @ApiOperation(value = "面板数据")
    @ApiOperationSupport(order=4)
    @SentinelResource(value = AssetReportServiceProxy.DASHBOARD_MRO , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.DASHBOARD_MRO)
    public Result<JSONObject> dashBoardMro() {
        return assetReportService.dashboardMro();
    }



    @ApiOperation(value = "资产数据")
    @ApiOperationSupport(order=5)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_ASSET_DATA_BY_LABEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_ASSET_DATA_BY_LABEL)
    public Result<JSONObject> dashBoardMro(String label) {
        return assetReportService.queryAssetDataByLabel(label);
    }



    @ApiOperation(value = "分类数据")
    @ApiOperationSupport(order=6)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_AUX_CATEGORY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_AUX_CATEGORY_DATA)
    public Result<JSONArray> queryCategoryData() {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryAuxCategoryData());
        return result;
    }

    @ApiOperation(value = "分类数据")
    @ApiOperationSupport(order=6)
    @SentinelResource(value = AssetReportServiceProxy.ASSET_OPER_DATA_REPORT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.ASSET_OPER_DATA_REPORT)
    public Result<JSONArray> assetOperDataReport(AssetVO assetVo) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.assetOperDataReport(assetVo));
        return result;
    }

    @ApiOperation(value = "报表数据")
    @ApiOperationSupport(order=6)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_INSPECT_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_INSPECT_DATA)
    public Result<JSONArray> query_inspect_data() {
        Result<JSONArray> result=new Result<>();
        String sql="select a.name name,count(1) cnt from eam_inspection_point a,eam_inspection_task_point b,eam_inspection_task c where a.id=b.point_id and c.id=b.task_id and c.task_status='finish' group by a.name";
        JSONArray data=new JSONArray();
        data=assetService.dao().query(sql).toJSONArrayWithJSONObject();
        result.success(true);
        result.data(data);
        return result;
    }


    @ApiOperation(value = "分类数据")
    @ApiOperationSupport(order=8)
    @SentinelResource(value = AssetReportServiceProxy.ASSET_FOR_LEAVE_EMPLOYEE_REPORT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.ASSET_FOR_LEAVE_EMPLOYEE_REPORT)
    public Result<PagedList<Asset>> assetForLeaveEmployeeReport(AssetVO sample) {
        Result<PagedList<Asset>> result = new Result<>();
        PagedList<Asset> list = assetReportService.assetForLeaveEmployeeReport(sample, sample.getPageSize(), sample.getPageIndex());
        assetService.joinData(list.getList());
        result.success(true).data(list);
        return result;
    }





}
