package com.dt.platform.vehicle.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.vehicle.VehicleOperationEnum;
import com.dt.platform.constants.enums.vehicle.VehicleStatusEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.domain.hrm.Person;
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
import com.dt.platform.proxy.vehicle.InfoServiceProxy;
import com.dt.platform.domain.vehicle.meta.InfoVOMeta;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.InfoVO;
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
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 车辆信息 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 17:59:08
 */
@Api(tags = "车辆信息")
@ApiSort(0)
@RestController("VehicleInfoController")
public class InfoController extends SuperController {

    @Autowired
    private IInfoService infoService;

    /**
     * 添加车辆信息
     */
    @ApiOperation(value = "添加车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352"),
		@ApiImplicitParam(name = InfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "idle"),
		@ApiImplicitParam(name = InfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class, example = "jiaoche"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class, example = "1212.00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class, example = "121"),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_EXPIRE_DATE, value = "保险到期", required = false, dataTypeClass = Date.class, example = "2022-03-30 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class, example = "562616951503847424"),
		@ApiImplicitParam(name = InfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = InfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(InfoVO infoVO) {
        Result result = infoService.insert(infoVO, false);
        return result;
    }

    /**
     * 删除车辆信息
     */
    @ApiOperation(value = "删除车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = InfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = infoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除车辆信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = infoService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新车辆信息
     */
    @ApiOperation(value = "更新车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352"),
		@ApiImplicitParam(name = InfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "idle"),
		@ApiImplicitParam(name = InfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class, example = "jiaoche"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class, example = "1212.00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class, example = "121"),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_EXPIRE_DATE, value = "保险到期", required = false, dataTypeClass = Date.class, example = "2022-03-30 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class, example = "562616951503847424"),
		@ApiImplicitParam(name = InfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { InfoVOMeta.PAGE_INDEX, InfoVOMeta.PAGE_SIZE, InfoVOMeta.SEARCH_FIELD, InfoVOMeta.FUZZY_FIELD, InfoVOMeta.SEARCH_VALUE, InfoVOMeta.DIRTY_FIELDS, InfoVOMeta.SORT_FIELD, InfoVOMeta.SORT_TYPE, InfoVOMeta.IDS })
    @SentinelResource(value = InfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(InfoVO infoVO) {
        Result result = infoService.update(infoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存车辆信息
     */
    @ApiOperation(value = "保存车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352"),
		@ApiImplicitParam(name = InfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "idle"),
		@ApiImplicitParam(name = InfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class, example = "jiaoche"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class, example = "1212.00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class, example = "121"),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_EXPIRE_DATE, value = "保险到期", required = false, dataTypeClass = Date.class, example = "2022-03-30 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class, example = "562616951503847424"),
		@ApiImplicitParam(name = InfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InfoVOMeta.PAGE_INDEX, InfoVOMeta.PAGE_SIZE, InfoVOMeta.SEARCH_FIELD, InfoVOMeta.FUZZY_FIELD, InfoVOMeta.SEARCH_VALUE, InfoVOMeta.DIRTY_FIELDS, InfoVOMeta.SORT_FIELD, InfoVOMeta.SORT_TYPE, InfoVOMeta.IDS })
    @SentinelResource(value = InfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(InfoVO infoVO) {
        Result result = infoService.save(infoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取车辆信息
     */
    @ApiOperation(value = "获取车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = InfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.GET_BY_ID)
    public Result<Info> getById(String id) {
        Result<Info> result = new Result<>();
        Info info = infoService.getById(id);
        // join 关联的对象
        infoService.dao().fill(info).with("ownerCompany").with("useOrganization").with("useUser").with(InfoMeta.VEHICLE_STATUS_DICT).with(InfoMeta.VEHICLE_TYPE_DICT).execute();
        result.success(true).data(info);
        return result;
    }

    /**
     * 批量获取车辆信息 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.GET_BY_IDS)
    public Result<List<Info>> getByIds(List<String> ids) {
        Result<List<Info>> result = new Result<>();
        List<Info> list = infoService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询车辆信息
     */
    @ApiOperation(value = "查询车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352"),
		@ApiImplicitParam(name = InfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "idle"),
		@ApiImplicitParam(name = InfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class, example = "jiaoche"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class, example = "1212.00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class, example = "121"),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_EXPIRE_DATE, value = "保险到期", required = false, dataTypeClass = Date.class, example = "2022-03-30 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class, example = "562616951503847424"),
		@ApiImplicitParam(name = InfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InfoVOMeta.PAGE_INDEX, InfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = InfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.QUERY_LIST)
    public Result<List<Info>> queryList(InfoVO sample) {
        Result<List<Info>> result = new Result<>();
        List<Info> list = infoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询车辆信息
     */
    @ApiOperation(value = "分页查询车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352"),
		@ApiImplicitParam(name = InfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "idle"),
		@ApiImplicitParam(name = InfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class, example = "jiaoche"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class, example = "1212.00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class, example = "121"),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_EXPIRE_DATE, value = "保险到期", required = false, dataTypeClass = Date.class, example = "2022-03-30 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class, example = "562616951503847424"),
		@ApiImplicitParam(name = InfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = InfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Info>> queryPagedList(InfoVO sample) {
        Result<PagedList<Info>> result = new Result<>();
        PagedList<Info> list = infoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        infoService.dao().fill(list).with("ownerCompany").with("useOrganization").with("useUser").with(InfoMeta.VEHICLE_STATUS_DICT).with(InfoMeta.VEHICLE_TYPE_DICT).execute();
        List<Employee> useUser = CollectorUtil.collectList(list, Info::getUseUser);
        infoService.dao().join(useUser, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询车辆信息
     */
    @ApiOperation(value = "分页查询车辆信息")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = InfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "562616955517796352"),
		@ApiImplicitParam(name = InfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "idle"),
		@ApiImplicitParam(name = InfoVOMeta.TYPE, value = "车辆类型", required = false, dataTypeClass = String.class, example = "jiaoche"),
		@ApiImplicitParam(name = InfoVOMeta.VEHICLE_CODE, value = "车牌号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.MODEL, value = "品牌型号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT, value = "登记人", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.OWNER_ORG_ID, value = "所属组织", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_ORG_ID, value = "使用部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.USE_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR, value = "颜色", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER, value = "发动机号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER, value = "车架号", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE, value = "行驶证", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS, value = "公里数", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY, value = "抢险(元)", required = false, dataTypeClass = BigDecimal.class, example = "12.00"),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY, value = "商业险(元)", required = false, dataTypeClass = BigDecimal.class, example = "1212.00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY, value = "保险公司", required = false, dataTypeClass = String.class, example = "121"),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME, value = "上牌时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_EXPIRE_DATE, value = "保险到期", required = false, dataTypeClass = Date.class, example = "2022-03-30 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME, value = "报废时间", required = false, dataTypeClass = Date.class, example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL, value = "存放位置", required = false, dataTypeClass = String.class, example = "12121212"),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES, value = "图片", required = false, dataTypeClass = String.class, example = "562616951503847424"),
		@ApiImplicitParam(name = InfoVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 9)
    @SentinelResource(value = InfoServiceProxy.QUERY_PAGED_SELECT_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InfoServiceProxy.QUERY_PAGED_SELECT_LIST)
    public Result<PagedList<Info>> queryPagedSelectList(InfoVO sample, String businessType) {
        Result<PagedList<Info>> result = new Result<>();
        ConditionExpr expr = new ConditionExpr();
        if (VehicleOperationEnum.VEHICLE_APPLY.code().equals(businessType)) {
            expr.andIn("vehicle_status", VehicleStatusEnum.IDLE.code());
        } else if (VehicleOperationEnum.VEHICLE_MAINTENANCE.code().equals(businessType)) {
            expr.andNotIn("vehicle_status", VehicleStatusEnum.SCRAP.code());
        }
        if (!StringUtil.isBlank(sample.getSelectIds())) {
            String[] strArr = sample.getSelectIds().split(",");
            expr.andNotIn("id", strArr);
        }
        PagedList<Info> list = infoService.queryPagedList(sample, expr, sample.getPageSize(), sample.getPageIndex());
        infoService.dao().fill(list).with("ownerCompany").with("useOrganization").with("useUser").with(InfoMeta.VEHICLE_STATUS_DICT).with(InfoMeta.VEHICLE_TYPE_DICT).execute();
        List<Employee> useUser = CollectorUtil.collectList(list, Info::getUseUser);
        infoService.dao().join(useUser, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = InfoServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InfoServiceProxy.EXPORT_EXCEL)
    public void exportExcel(InfoVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            InputStream inputstream = infoService.buildExcelTemplate(VehicleOperationEnum.VEHICLE_INFO_DOWNLOAD.code());
            if (inputstream == null) {
                return;
            }
            File f = infoService.saveTempFile(inputstream, "tmp_vehicle_info_download.xls");
            Map<String, Object> map = infoService.queryVehicleInfoMap(sample);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("车辆数据.xls", "UTF-8"))));
            response.setContentType("application/vnd.ms-excel");
            // 下载
            DownloadUtil.writeToOutput(response, workbook, "车辆数据.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = InfoServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InfoServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        // 生成 Excel 模版
        // categoryId="497488128370540545";
        try {
            InputStream inputstream = infoService.buildExcelTemplate(VehicleOperationEnum.VEHICLE_INFO_DOWNLOAD.code());
            if (inputstream == null) {
            }
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("车辆模板.xls", "UTF-8"))));
            response.setContentType("application/vnd.ms-excel");
            OutputStream out = response.getOutputStream();
            IOUtils.copy(inputstream, out);
            out.flush();
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = InfoServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InfoServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = infoService.importExcel(input, 0, true, VehicleOperationEnum.VEHICLE_INFO_DOWNLOAD.code(), IDGenerator.getSnowflakeIdString());
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            Logger.info("import Result:");
            String msg = "导入失败";
            for (int i = 0; i < errors.size(); i++) {
                Logger.info(i + ":" + errors.get(i).message);
                msg = errors.get(i).message;
            }
            return ErrorDesc.failure().message(msg).data(errors);
        }
    }
}
