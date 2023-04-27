package com.dt.platform.eam.controller;

import java.util.List;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetLabelTplMeta;
import com.dt.platform.domain.eam.meta.AssetStockGoodsOutMeta;
import com.dt.platform.eam.service.IAssetLabelTplService;
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
import com.dt.platform.proxy.eam.AssetLabelServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetLabelMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产标签 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-21 07:16:58
 */
@Api(tags = "资产标签")
@ApiSort(0)
@RestController("EamAssetLabelController")
public class AssetLabelController extends SuperController {

    @Autowired
    private IAssetLabelService assetLabelService;

    @Autowired
    private IAssetLabelTplService assetLabelTplService;

    /**
     * 添加资产标签
     */
    @ApiOperation(value = "添加资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetLabelVOMeta.CODE, value = "编码", required = true, dataTypeClass = String.class, example = "label"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TPL_ID, value = "标签", required = false, dataTypeClass = String.class, example = "50"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_WIDTH, value = "标签宽度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "8.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_HEIGHT, value = "标签高度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "3.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.PAPER_TYPE_ID, value = "纸张类型", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_LAYOUT, value = "标签布局(暂时不用)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN, value = "标签间隔", required = false, dataTypeClass = BigDecimal.class, example = "2.10"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_WIDTH, value = "Key宽度", required = false, dataTypeClass = BigDecimal.class, example = "20.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT, value = "专用标签", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_WIDTH, value = "专用标签", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_HEIGHT, value = "专用标签", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_TOP, value = "图片marginTop", required = false, dataTypeClass = BigDecimal.class, example = "2.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM, value = "图片marginBottom", required = false, dataTypeClass = BigDecimal.class, example = "5.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP, value = "表格marginTop(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM, value = "表格marginBottom(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT, value = "表格marginLeft(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT, value = "表格marginRight(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_LEFT, value = "图片marginLeft", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_RIGHT, value = "图片marginRight", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_TYPE, value = "字体", required = false, dataTypeClass = String.class, example = "MYSH"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_PATH, value = "字体路径", required = false, dataTypeClass = String.class, example = "/Users/lankl/IdeaProjects/eam/bin/simhei.ttf")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetLabelServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetLabelVO assetLabelVO) {
        Result result = assetLabelService.insert(assetLabelVO, false);
        return result;
    }

    /**
     * 删除资产标签
     */
    @ApiOperation(value = "删除资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetLabelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = assetLabelService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产标签 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetLabelServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = assetLabelService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新资产标签
     */
    @ApiOperation(value = "更新资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetLabelVOMeta.CODE, value = "编码", required = true, dataTypeClass = String.class, example = "label"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TPL_ID, value = "标签", required = false, dataTypeClass = String.class, example = "50"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_WIDTH, value = "标签宽度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "8.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_HEIGHT, value = "标签高度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "3.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.PAPER_TYPE_ID, value = "纸张类型", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_LAYOUT, value = "标签布局(暂时不用)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN, value = "标签间隔", required = false, dataTypeClass = BigDecimal.class, example = "2.10"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_WIDTH, value = "Key宽度", required = false, dataTypeClass = BigDecimal.class, example = "20.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT, value = "专用标签", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_WIDTH, value = "专用标签", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_HEIGHT, value = "专用标签", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_TOP, value = "图片marginTop", required = false, dataTypeClass = BigDecimal.class, example = "2.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM, value = "图片marginBottom", required = false, dataTypeClass = BigDecimal.class, example = "5.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP, value = "表格marginTop(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM, value = "表格marginBottom(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT, value = "表格marginLeft(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT, value = "表格marginRight(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_LEFT, value = "图片marginLeft", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_RIGHT, value = "图片marginRight", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_TYPE, value = "字体", required = false, dataTypeClass = String.class, example = "MYSH"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_PATH, value = "字体路径", required = false, dataTypeClass = String.class, example = "/Users/lankl/IdeaProjects/eam/bin/simhei.ttf")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetLabelVOMeta.PAGE_INDEX, AssetLabelVOMeta.PAGE_SIZE, AssetLabelVOMeta.SEARCH_FIELD, AssetLabelVOMeta.FUZZY_FIELD, AssetLabelVOMeta.SEARCH_VALUE, AssetLabelVOMeta.DIRTY_FIELDS, AssetLabelVOMeta.SORT_FIELD, AssetLabelVOMeta.SORT_TYPE, AssetLabelVOMeta.IDS })
    @SentinelResource(value = AssetLabelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetLabelVO assetLabelVO) {
        Result result = assetLabelService.update(assetLabelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资产标签
     */
    @ApiOperation(value = "保存资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetLabelVOMeta.CODE, value = "编码", required = true, dataTypeClass = String.class, example = "label"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TPL_ID, value = "标签", required = false, dataTypeClass = String.class, example = "50"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_WIDTH, value = "标签宽度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "8.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_HEIGHT, value = "标签高度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "3.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.PAPER_TYPE_ID, value = "纸张类型", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_LAYOUT, value = "标签布局(暂时不用)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN, value = "标签间隔", required = false, dataTypeClass = BigDecimal.class, example = "2.10"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_WIDTH, value = "Key宽度", required = false, dataTypeClass = BigDecimal.class, example = "20.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT, value = "专用标签", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_WIDTH, value = "专用标签", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_HEIGHT, value = "专用标签", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_TOP, value = "图片marginTop", required = false, dataTypeClass = BigDecimal.class, example = "2.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM, value = "图片marginBottom", required = false, dataTypeClass = BigDecimal.class, example = "5.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP, value = "表格marginTop(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM, value = "表格marginBottom(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT, value = "表格marginLeft(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT, value = "表格marginRight(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_LEFT, value = "图片marginLeft", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_RIGHT, value = "图片marginRight", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_TYPE, value = "字体", required = false, dataTypeClass = String.class, example = "MYSH"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_PATH, value = "字体路径", required = false, dataTypeClass = String.class, example = "/Users/lankl/IdeaProjects/eam/bin/simhei.ttf")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetLabelVOMeta.PAGE_INDEX, AssetLabelVOMeta.PAGE_SIZE, AssetLabelVOMeta.SEARCH_FIELD, AssetLabelVOMeta.FUZZY_FIELD, AssetLabelVOMeta.SEARCH_VALUE, AssetLabelVOMeta.DIRTY_FIELDS, AssetLabelVOMeta.SORT_FIELD, AssetLabelVOMeta.SORT_TYPE, AssetLabelVOMeta.IDS })
    @SentinelResource(value = AssetLabelServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetLabelVO assetLabelVO) {
        Result result = assetLabelService.save(assetLabelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资产标签
     */
    @ApiOperation(value = "获取资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetLabelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.GET_BY_ID)
    public Result<AssetLabel> getById(String id) {
        Result<AssetLabel> result = new Result<>();
        AssetLabel assetLabel = assetLabelService.getById(id);
        result.success(true).data(assetLabel);
        return result;
    }

    /**
     * 批量获取资产标签 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetLabelServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.GET_BY_IDS)
    public Result<List<AssetLabel>> getByIds(List<String> ids) {
        Result<List<AssetLabel>> result = new Result<>();
        List<AssetLabel> list = assetLabelService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产标签
     */
    @ApiOperation(value = "查询资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetLabelVOMeta.CODE, value = "编码", required = true, dataTypeClass = String.class, example = "label"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TPL_ID, value = "标签", required = false, dataTypeClass = String.class, example = "50"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_WIDTH, value = "标签宽度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "8.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_HEIGHT, value = "标签高度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "3.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.PAPER_TYPE_ID, value = "纸张类型", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_LAYOUT, value = "标签布局(暂时不用)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN, value = "标签间隔", required = false, dataTypeClass = BigDecimal.class, example = "2.10"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_WIDTH, value = "Key宽度", required = false, dataTypeClass = BigDecimal.class, example = "20.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT, value = "专用标签", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_WIDTH, value = "专用标签", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_HEIGHT, value = "专用标签", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_TOP, value = "图片marginTop", required = false, dataTypeClass = BigDecimal.class, example = "2.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM, value = "图片marginBottom", required = false, dataTypeClass = BigDecimal.class, example = "5.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP, value = "表格marginTop(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM, value = "表格marginBottom(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT, value = "表格marginLeft(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT, value = "表格marginRight(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_LEFT, value = "图片marginLeft", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_RIGHT, value = "图片marginRight", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_TYPE, value = "字体", required = false, dataTypeClass = String.class, example = "MYSH"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_PATH, value = "字体路径", required = false, dataTypeClass = String.class, example = "/Users/lankl/IdeaProjects/eam/bin/simhei.ttf")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetLabelVOMeta.PAGE_INDEX, AssetLabelVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetLabelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.QUERY_LIST)
    public Result<List<AssetLabel>> queryList(AssetLabelVO sample) {
        Result<List<AssetLabel>> result = new Result<>();
        List<AssetLabel> list = assetLabelService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产标签
     */
    @ApiOperation(value = "分页查询资产标签")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetLabelVOMeta.CODE, value = "编码", required = true, dataTypeClass = String.class, example = "label"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TPL_ID, value = "标签", required = false, dataTypeClass = String.class, example = "50"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_WIDTH, value = "标签宽度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "8.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_HEIGHT, value = "标签高度(cm)", required = false, dataTypeClass = BigDecimal.class, example = "3.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.PAPER_TYPE_ID, value = "纸张类型", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_LAYOUT, value = "标签布局(暂时不用)", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN, value = "标签间隔", required = false, dataTypeClass = BigDecimal.class, example = "2.10"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_KEY_WIDTH, value = "Key宽度", required = false, dataTypeClass = BigDecimal.class, example = "20.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE, value = "字体大小(mm)", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT, value = "专用标签", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_WIDTH, value = "专用标签", required = false, dataTypeClass = Integer.class, example = "0"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_HEIGHT, value = "专用标签", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_TOP, value = "图片marginTop", required = false, dataTypeClass = BigDecimal.class, example = "2.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM, value = "图片marginBottom", required = false, dataTypeClass = BigDecimal.class, example = "5.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP, value = "表格marginTop(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM, value = "表格marginBottom(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT, value = "表格marginLeft(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT, value = "表格marginRight(mm)", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_LEFT, value = "图片marginLeft", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.IMAGE_MARGIN_RIGHT, value = "图片marginRight", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_TYPE, value = "字体", required = false, dataTypeClass = String.class, example = "MYSH"),
		@ApiImplicitParam(name = AssetLabelVOMeta.FONT_PATH, value = "字体路径", required = false, dataTypeClass = String.class, example = "/Users/lankl/IdeaProjects/eam/bin/simhei.ttf")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetLabelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetLabel>> queryPagedList(AssetLabelVO sample) {
        Result<PagedList<AssetLabel>> result = new Result<>();
        PagedList<AssetLabel> list = assetLabelService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 标签
     */
    @ApiOperation(value = "标签")
    @ApiOperationSupport(order = 9)
    @SentinelResource(value = AssetLabelServiceProxy.QUERY_ASSET_LABEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.QUERY_ASSET_LABEL)
    public Result<AssetLabel> queryAssetLabel() {
        Result<AssetLabel> result = new Result<>();
        AssetLabel assetLabel = assetLabelService.queryAssetLabel();
        return result.success(true).data(assetLabel);
    }

    /**
     * 标签
     */
    @ApiOperation(value = "标签")
    @ApiOperationSupport(order = 10)
    @SentinelResource(value = AssetLabelServiceProxy.SAVE_ASSET_LABEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.SAVE_ASSET_LABEL)
    public Result saveAssetLabel(AssetLabelVO assetLabelVO) {
        return assetLabelService.saveAssetLabel(assetLabelVO);
    }

    /**
     * 标签
     */
    @ApiOperation(value = "标签")
    @ApiOperationSupport(order = 11)
    @SentinelResource(value = AssetLabelServiceProxy.SAVE_ASSET_LABEL_CUSTOM_TPL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetLabelServiceProxy.SAVE_ASSET_LABEL_CUSTOM_TPL)
    public Result saveAssetLabelCustomTpl(AssetLabelTplVO assetLabelTplVO) {
        return assetLabelService.saveAssetLabelCustomTpl(assetLabelTplVO);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AssetLabelServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetLabelServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AssetLabelVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = assetLabelService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AssetLabelServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetLabelServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = assetLabelService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = AssetLabelServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetLabelServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = assetLabelService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
