package com.dt.platform.oa.controller;

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
import com.dt.platform.proxy.oa.VehicleInfoServiceProxy;
import com.dt.platform.domain.oa.meta.VehicleInfoVOMeta;
import com.dt.platform.domain.oa.VehicleInfo;
import com.dt.platform.domain.oa.VehicleInfoVO;
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
import com.dt.platform.domain.oa.meta.VehicleInfoMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.oa.service.IVehicleInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 车辆信息 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-28 13:01:07
 */
@Api(tags = "车辆信息")
@ApiSort(0)
@RestController("OaVehicleInfoController")
public class VehicleInfoController extends SuperController {

    @Autowired
    private IVehicleInfoService vehicleInfoService;

    /**
     * 添加车辆信息
     */
    @ApiOperation(value = "添加车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.CAR_BOAT_TAX, value = "车船税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE, value = "商业险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_DUE_DATE, value = "抢险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TECHNICAL_PARAMETER, value = "技术参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_COUNT, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = VehicleInfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(VehicleInfoVO vehicleInfoVO) {
        Result result = vehicleInfoService.insert(vehicleInfoVO, false);
        return result;
    }

    /**
     * 删除车辆信息
     */
    @ApiOperation(value = "删除车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = VehicleInfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  vehicleInfoService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = vehicleInfoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除车辆信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = VehicleInfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = vehicleInfoService.hasRefers(ids);
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
            Result result = vehicleInfoService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = vehicleInfoService.deleteByIdsLogical(canDeleteIds);
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
     * 更新车辆信息
     */
    @ApiOperation(value = "更新车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.CAR_BOAT_TAX, value = "车船税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE, value = "商业险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_DUE_DATE, value = "抢险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TECHNICAL_PARAMETER, value = "技术参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_COUNT, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { VehicleInfoVOMeta.PAGE_INDEX, VehicleInfoVOMeta.PAGE_SIZE, VehicleInfoVOMeta.SEARCH_FIELD, VehicleInfoVOMeta.FUZZY_FIELD, VehicleInfoVOMeta.SEARCH_VALUE, VehicleInfoVOMeta.DIRTY_FIELDS, VehicleInfoVOMeta.SORT_FIELD, VehicleInfoVOMeta.SORT_TYPE, VehicleInfoVOMeta.IDS })
    @SentinelResource(value = VehicleInfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(VehicleInfoVO vehicleInfoVO) {
        Result result = vehicleInfoService.update(vehicleInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存车辆信息
     */
    @ApiOperation(value = "保存车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.CAR_BOAT_TAX, value = "车船税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE, value = "商业险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_DUE_DATE, value = "抢险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TECHNICAL_PARAMETER, value = "技术参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_COUNT, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { VehicleInfoVOMeta.PAGE_INDEX, VehicleInfoVOMeta.PAGE_SIZE, VehicleInfoVOMeta.SEARCH_FIELD, VehicleInfoVOMeta.FUZZY_FIELD, VehicleInfoVOMeta.SEARCH_VALUE, VehicleInfoVOMeta.DIRTY_FIELDS, VehicleInfoVOMeta.SORT_FIELD, VehicleInfoVOMeta.SORT_TYPE, VehicleInfoVOMeta.IDS })
    @SentinelResource(value = VehicleInfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(VehicleInfoVO vehicleInfoVO) {
        Result result = vehicleInfoService.save(vehicleInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取车辆信息
     */
    @ApiOperation(value = "获取车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = VehicleInfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.GET_BY_ID)
    public Result<VehicleInfo> getById(String id) {
        Result<VehicleInfo> result = new Result<>();
        VehicleInfo vehicleInfo = vehicleInfoService.getById(id);
        // join 关联的对象
        vehicleInfoService.dao().fill(vehicleInfo).with("ownerCompany").with("useOrganization").with("useUser").with(InfoMeta.VEHICLE_STATUS_DICT).with(InfoMeta.VEHICLE_TYPE_DICT).execute();
        result.success(true).data(vehicleInfo);
        return result;
    }

    /**
     * 批量获取车辆信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = VehicleInfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.GET_BY_IDS)
    public Result<List<VehicleInfo>> getByIds(List<String> ids) {
        Result<List<VehicleInfo>> result = new Result<>();
        List<VehicleInfo> list = vehicleInfoService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询车辆信息
     */
    @ApiOperation(value = "查询车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.CAR_BOAT_TAX, value = "车船税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE, value = "商业险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_DUE_DATE, value = "抢险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TECHNICAL_PARAMETER, value = "技术参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_COUNT, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { VehicleInfoVOMeta.PAGE_INDEX, VehicleInfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = VehicleInfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.QUERY_LIST)
    public Result<List<VehicleInfo>> queryList(VehicleInfoVO sample) {
        Result<List<VehicleInfo>> result = new Result<>();
        List<VehicleInfo> list = vehicleInfoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询车辆信息
     */
    @ApiOperation(value = "分页查询车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VehicleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.CAR_BOAT_TAX, value = "车船税", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE, value = "商业险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.RESCUE_DUE_DATE, value = "抢险到期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.TECHNICAL_PARAMETER, value = "技术参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.VEHICLE_COUNT, value = "数量", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = VehicleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = VehicleInfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VehicleInfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<VehicleInfo>> queryPagedList(VehicleInfoVO sample) {
        Result<PagedList<VehicleInfo>> result = new Result<>();
        PagedList<VehicleInfo> list = vehicleInfoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        vehicleInfoService.dao().fill(list).with("ownerCompany").with("useOrganization").with("useUser").with(InfoMeta.VEHICLE_STATUS_DICT).with(InfoMeta.VEHICLE_TYPE_DICT).execute();
        result.success(true).data(list);
        return result;
    }
}
