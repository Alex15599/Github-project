package com.dt.platform.ops.controller;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.domain.ops.VoucherPriv;
import com.dt.platform.domain.ops.meta.VoucherOwnerMeta;
import com.dt.platform.ops.service.IVoucherPrivService;
import com.github.foxnic.sql.expr.ConditionExpr;
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
import com.dt.platform.proxy.ops.VoucherServiceProxy;
import com.dt.platform.domain.ops.meta.VoucherVOMeta;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.VoucherVO;
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
import com.dt.platform.domain.ops.meta.VoucherMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IVoucherService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 凭证 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:36:08
 */
@Api(tags = "凭证")
@ApiSort(0)
@RestController("OpsVoucherController")
public class VoucherController extends SuperController {

    @Autowired
    private IVoucherService voucherService;

    @Autowired
    private IVoucherPrivService voucherPrivService;

    /**
     * 添加凭证
     */
    @ApiOperation(value = "添加凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "485916761665843200"),
		@ApiImplicitParam(name = VoucherVOMeta.TYPE, value = "类别", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = VoucherVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VoucherVOMeta.USER_CODE, value = "用户", required = false, dataTypeClass = String.class, example = "voucher_root"),
		@ApiImplicitParam(name = VoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = VoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = VoucherServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(VoucherVO voucherVO) {
        String employeeId = this.getSessionUser().getUser().getActivatedEmployeeId();
        Result verify_result = voucherPrivService.verifyUserPermissions(voucherVO.getType(), employeeId);
        if (!verify_result.isSuccess()) {
            return verify_result;
        }
        Result result = voucherService.insert(voucherVO);
        return result;
    }

    /**
     * 删除凭证
     */
    @ApiOperation(value = "删除凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "485916761665843200")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = VoucherServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.DELETE)
    public Result deleteById(String id) {
        Voucher voucher = voucherService.getById(id);
        String employeeId = this.getSessionUser().getUser().getActivatedEmployeeId();
        Result verify_result = voucherPrivService.verifyUserPermissions(voucher.getType(), employeeId);
        if (!verify_result.isSuccess()) {
            return verify_result;
        }
        Result result = voucherService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除凭证 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = VoucherServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = voucherService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新凭证
     */
    @ApiOperation(value = "更新凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "485916761665843200"),
		@ApiImplicitParam(name = VoucherVOMeta.TYPE, value = "类别", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = VoucherVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VoucherVOMeta.USER_CODE, value = "用户", required = false, dataTypeClass = String.class, example = "voucher_root"),
		@ApiImplicitParam(name = VoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = VoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { VoucherVOMeta.PAGE_INDEX, VoucherVOMeta.PAGE_SIZE, VoucherVOMeta.SEARCH_FIELD, VoucherVOMeta.FUZZY_FIELD, VoucherVOMeta.SEARCH_VALUE, VoucherVOMeta.SORT_FIELD, VoucherVOMeta.SORT_TYPE, VoucherVOMeta.IDS })
    @SentinelResource(value = VoucherServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(VoucherVO voucherVO) {
        Result result = voucherService.update(voucherVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存凭证
     */
    @ApiOperation(value = "保存凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "485916761665843200"),
		@ApiImplicitParam(name = VoucherVOMeta.TYPE, value = "类别", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = VoucherVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VoucherVOMeta.USER_CODE, value = "用户", required = false, dataTypeClass = String.class, example = "voucher_root"),
		@ApiImplicitParam(name = VoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = VoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { VoucherVOMeta.PAGE_INDEX, VoucherVOMeta.PAGE_SIZE, VoucherVOMeta.SEARCH_FIELD, VoucherVOMeta.FUZZY_FIELD, VoucherVOMeta.SEARCH_VALUE, VoucherVOMeta.SORT_FIELD, VoucherVOMeta.SORT_TYPE, VoucherVOMeta.IDS })
    @SentinelResource(value = VoucherServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(VoucherVO voucherVO) {
        Result result = voucherService.save(voucherVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取凭证
     */
    @ApiOperation(value = "获取凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = VoucherServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.GET_BY_ID)
    public Result<Voucher> getById(String id) {
        Result<Voucher> result = new Result<>();
        Voucher voucher = voucherService.getById(id);
        String employeeId = this.getSessionUser().getUser().getActivatedEmployeeId();
        Result verify_result = voucherPrivService.verifyUserPermissions(voucher.getType(), employeeId);
        if (!verify_result.isSuccess()) {
            return verify_result;
        }
        voucherService.join(voucher, VoucherMeta.VOUCHER_TYPE);
        result.success(true).data(voucher);
        return result;
    }

    /**
     * 批量删除凭证 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = VoucherServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.GET_BY_IDS)
    public Result<List<Voucher>> getByIds(List<String> ids) {
        Result<List<Voucher>> result = new Result<>();
        List<Voucher> list = voucherService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询凭证
     */
    @ApiOperation(value = "查询凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "485916761665843200"),
		@ApiImplicitParam(name = VoucherVOMeta.TYPE, value = "类别", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = VoucherVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VoucherVOMeta.USER_CODE, value = "用户", required = false, dataTypeClass = String.class, example = "voucher_root"),
		@ApiImplicitParam(name = VoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = VoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { VoucherVOMeta.PAGE_INDEX, VoucherVOMeta.PAGE_SIZE })
    @SentinelResource(value = VoucherServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.QUERY_LIST)
    public Result<List<Voucher>> queryList(VoucherVO sample) {
        Result<List<Voucher>> result = new Result<>();
        List<Voucher> list = voucherService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询凭证
     */
    @ApiOperation(value = "分页查询凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = VoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "485916761665843200"),
		@ApiImplicitParam(name = VoucherVOMeta.TYPE, value = "类别", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = VoucherVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = VoucherVOMeta.USER_CODE, value = "用户", required = false, dataTypeClass = String.class, example = "voucher_root"),
		@ApiImplicitParam(name = VoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = VoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = VoucherServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(VoucherServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Voucher>> queryPagedList(VoucherVO sample) {
        Result<PagedList<Voucher>> result = new Result<>();
        String employeeId = this.getSessionUser().getUser().getActivatedEmployeeId();
        ConditionExpr condition = new ConditionExpr();
        VoucherPriv vp = new VoucherPriv();
        vp.setStatus(StatusValidEnum.VALID.code());
        vp.setEmplId(employeeId);
        VoucherPriv vp_data = voucherPrivService.queryEntity(vp);
        if (employeeId == null || vp_data == null) {
            condition.and("id=?", "0");
        } else {
            String[] objArr = vp_data.getType().split(",");
            List<String> items = new ArrayList<>();
            for (int i = 0; i < objArr.length; i++) {
                items.add(objArr[i]);
            }
            if (items.size() > 0) {
                condition.andIn("type", items);
            } else {
                condition.and("id=?", "0");
            }
        }
        PagedList<Voucher> list = voucherService.queryPagedList(sample, condition, sample.getPageSize(), sample.getPageIndex());
        for (int i = 0; i < list.size(); i++) {
            Voucher obj = list.get(i);
            String voucherStr = obj.getVoucher();
            if (voucherStr != null && voucherStr.length() > 5) {
                list.get(i).setVoucher(voucherStr.replaceFirst(voucherStr.substring(0, 4), "***") + "***");
            } else if (voucherStr != null && voucherStr.length() <= 5) {
                list.get(i).setVoucher("****");
            }
        }
        voucherService.join(list, VoucherMeta.VOUCHER_TYPE);
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = VoucherServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(VoucherServiceProxy.EXPORT_EXCEL)
    public void exportExcel(VoucherVO sample, HttpServletResponse response) throws Exception {
        // 生成 Excel 数据
        ExcelWriter ew = voucherService.exportExcel(sample);
        // 下载
        DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = VoucherServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(VoucherServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        // 生成 Excel 模版
        ExcelWriter ew = voucherService.exportExcelTemplate();
        // 下载
        DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
    }

    @SentinelResource(value = VoucherServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(VoucherServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = voucherService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
