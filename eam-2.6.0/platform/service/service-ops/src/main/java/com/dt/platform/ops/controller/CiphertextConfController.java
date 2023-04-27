package com.dt.platform.ops.controller;

import java.util.List;
import java.util.ArrayList;
import com.dt.platform.domain.eam.AssetScrap;
import com.dt.platform.domain.eam.meta.AssetScrapMeta;
import com.github.foxnic.commons.collection.CollectorUtil;
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
import com.dt.platform.proxy.ops.CiphertextConfServiceProxy;
import com.dt.platform.domain.ops.meta.CiphertextConfVOMeta;
import com.dt.platform.domain.ops.CiphertextConf;
import com.dt.platform.domain.ops.CiphertextConfVO;
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
import com.dt.platform.domain.ops.meta.CiphertextConfMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.CiphertextBox;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICiphertextConfService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 权限配置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 10:33:43
 */
@Api(tags = "权限配置")
@ApiSort(0)
@RestController("OpsCiphertextConfController")
public class CiphertextConfController extends SuperController {

    @Autowired
    private ICiphertextConfService ciphertextConfService;

    /**
     * 添加权限配置
     */
    @ApiOperation(value = "添加权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635056198374129664"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.BOX_ID, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextConfVOMeta.USER_ID, value = "人员", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.DECRYPTION_PERM_STATUS, value = "解密权限", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = CiphertextConfServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(CiphertextConfVO ciphertextConfVO) {
        Result result = ciphertextConfService.insert(ciphertextConfVO, false);
        return result;
    }

    /**
     * 删除权限配置
     */
    @ApiOperation(value = "删除权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635056198374129664")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = CiphertextConfServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  ciphertextConfService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = ciphertextConfService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除权限配置 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = CiphertextConfServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = ciphertextConfService.hasRefers(ids);
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
            Result result = ciphertextConfService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = ciphertextConfService.deleteByIdsLogical(canDeleteIds);
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
     * 更新权限配置
     */
    @ApiOperation(value = "更新权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635056198374129664"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.BOX_ID, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextConfVOMeta.USER_ID, value = "人员", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.DECRYPTION_PERM_STATUS, value = "解密权限", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { CiphertextConfVOMeta.PAGE_INDEX, CiphertextConfVOMeta.PAGE_SIZE, CiphertextConfVOMeta.SEARCH_FIELD, CiphertextConfVOMeta.FUZZY_FIELD, CiphertextConfVOMeta.SEARCH_VALUE, CiphertextConfVOMeta.DIRTY_FIELDS, CiphertextConfVOMeta.SORT_FIELD, CiphertextConfVOMeta.SORT_TYPE, CiphertextConfVOMeta.IDS })
    @SentinelResource(value = CiphertextConfServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(CiphertextConfVO ciphertextConfVO) {
        Result result = ciphertextConfService.update(ciphertextConfVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存权限配置
     */
    @ApiOperation(value = "保存权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635056198374129664"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.BOX_ID, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextConfVOMeta.USER_ID, value = "人员", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.DECRYPTION_PERM_STATUS, value = "解密权限", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { CiphertextConfVOMeta.PAGE_INDEX, CiphertextConfVOMeta.PAGE_SIZE, CiphertextConfVOMeta.SEARCH_FIELD, CiphertextConfVOMeta.FUZZY_FIELD, CiphertextConfVOMeta.SEARCH_VALUE, CiphertextConfVOMeta.DIRTY_FIELDS, CiphertextConfVOMeta.SORT_FIELD, CiphertextConfVOMeta.SORT_TYPE, CiphertextConfVOMeta.IDS })
    @SentinelResource(value = CiphertextConfServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(CiphertextConfVO ciphertextConfVO) {
        Result result = ciphertextConfService.save(ciphertextConfVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取权限配置
     */
    @ApiOperation(value = "获取权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = CiphertextConfServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.GET_BY_ID)
    public Result<CiphertextConf> getById(String id) {
        Result<CiphertextConf> result = new Result<>();
        CiphertextConf ciphertextConf = ciphertextConfService.getById(id);
        // join 关联的对象
        ciphertextConfService.dao().fill(ciphertextConf).with("user").with(CiphertextConfMeta.BOX).execute();
        result.success(true).data(ciphertextConf);
        return result;
    }

    /**
     * 批量获取权限配置 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = CiphertextConfServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.GET_BY_IDS)
    public Result<List<CiphertextConf>> getByIds(List<String> ids) {
        Result<List<CiphertextConf>> result = new Result<>();
        List<CiphertextConf> list = ciphertextConfService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询权限配置
     */
    @ApiOperation(value = "查询权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635056198374129664"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.BOX_ID, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextConfVOMeta.USER_ID, value = "人员", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.DECRYPTION_PERM_STATUS, value = "解密权限", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { CiphertextConfVOMeta.PAGE_INDEX, CiphertextConfVOMeta.PAGE_SIZE })
    @SentinelResource(value = CiphertextConfServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.QUERY_LIST)
    public Result<List<CiphertextConf>> queryList(CiphertextConfVO sample) {
        Result<List<CiphertextConf>> result = new Result<>();
        List<CiphertextConf> list = ciphertextConfService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询权限配置
     */
    @ApiOperation(value = "分页查询权限配置")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CiphertextConfVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "635056198374129664"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.BOX_ID, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CiphertextConfVOMeta.USER_ID, value = "人员", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.DECRYPTION_PERM_STATUS, value = "解密权限", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = CiphertextConfVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = CiphertextConfServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CiphertextConfServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CiphertextConf>> queryPagedList(CiphertextConfVO sample) {
        Result<PagedList<CiphertextConf>> result = new Result<>();
        PagedList<CiphertextConf> list = ciphertextConfService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        ciphertextConfService.dao().fill(list).with("user").with(CiphertextConfMeta.BOX).execute();
        List<Employee> employees = CollectorUtil.collectList(list, CiphertextConf::getUser);
        ciphertextConfService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }
}
