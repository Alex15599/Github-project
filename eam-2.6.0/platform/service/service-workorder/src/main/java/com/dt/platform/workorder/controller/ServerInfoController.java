package com.dt.platform.workorder.controller;

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
import com.dt.platform.proxy.workorder.ServerInfoServiceProxy;
import com.dt.platform.domain.workorder.meta.ServerInfoVOMeta;
import com.dt.platform.domain.workorder.ServerInfo;
import com.dt.platform.domain.workorder.ServerInfoVO;
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
import com.dt.platform.domain.workorder.meta.ServerInfoMeta;
import com.dt.platform.domain.workorder.ServerOsType;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.workorder.service.IServerInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 服务器资源 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-22 06:38:45
 */
@Api(tags = "服务器资源")
@ApiSort(0)
@RestController("WoServerInfoController")
public class ServerInfoController extends SuperController {

    @Autowired
    private IServerInfoService serverInfoService;

    /**
     * 添加服务器资源
     */
    @ApiOperation(value = "添加服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "602750624248893440"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试服务器"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_TYPE, value = "服务器类型", required = false, dataTypeClass = String.class, example = "virtual_machine"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OS_VERSION, value = "系统版本", required = false, dataTypeClass = String.class, example = "599614904982306816"),
		@ApiImplicitParam(name = ServerInfoVOMeta.IP, value = "IP地址", required = false, dataTypeClass = String.class, example = "192,268,1,1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.DATABASE_VERSION, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.MIDDLEWARE_VERSION, value = "中间件", required = false, dataTypeClass = String.class, example = "Tomcat"),
		@ApiImplicitParam(name = ServerInfoVOMeta.CPU, value = "CPU数", required = false, dataTypeClass = Integer.class, example = "2"),
		@ApiImplicitParam(name = ServerInfoVOMeta.MEMORY, value = "内存(G)", required = false, dataTypeClass = Integer.class, example = "4"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SPACE_SIZE, value = "空间(G)", required = false, dataTypeClass = Integer.class, example = "100"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.USERLIST, value = "用户列表", required = false, dataTypeClass = String.class, example = "root"),
		@ApiImplicitParam(name = ServerInfoVOMeta.PORTLIST, value = "端口列表", required = false, dataTypeClass = String.class, example = "8080"),
		@ApiImplicitParam(name = ServerInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServerInfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServerInfoVO serverInfoVO) {
        Result result = serverInfoService.insert(serverInfoVO, false);
        return result;
    }

    /**
     * 删除服务器资源
     */
    @ApiOperation(value = "删除服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "602750624248893440")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServerInfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serverInfoService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serverInfoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除服务器资源 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServerInfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serverInfoService.hasRefers(ids);
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
            Result result = serverInfoService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serverInfoService.deleteByIdsLogical(canDeleteIds);
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
     * 更新服务器资源
     */
    @ApiOperation(value = "更新服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "602750624248893440"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试服务器"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_TYPE, value = "服务器类型", required = false, dataTypeClass = String.class, example = "virtual_machine"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OS_VERSION, value = "系统版本", required = false, dataTypeClass = String.class, example = "599614904982306816"),
		@ApiImplicitParam(name = ServerInfoVOMeta.IP, value = "IP地址", required = false, dataTypeClass = String.class, example = "192,268,1,1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.DATABASE_VERSION, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.MIDDLEWARE_VERSION, value = "中间件", required = false, dataTypeClass = String.class, example = "Tomcat"),
		@ApiImplicitParam(name = ServerInfoVOMeta.CPU, value = "CPU数", required = false, dataTypeClass = Integer.class, example = "2"),
		@ApiImplicitParam(name = ServerInfoVOMeta.MEMORY, value = "内存(G)", required = false, dataTypeClass = Integer.class, example = "4"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SPACE_SIZE, value = "空间(G)", required = false, dataTypeClass = Integer.class, example = "100"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.USERLIST, value = "用户列表", required = false, dataTypeClass = String.class, example = "root"),
		@ApiImplicitParam(name = ServerInfoVOMeta.PORTLIST, value = "端口列表", required = false, dataTypeClass = String.class, example = "8080"),
		@ApiImplicitParam(name = ServerInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServerInfoVOMeta.PAGE_INDEX, ServerInfoVOMeta.PAGE_SIZE, ServerInfoVOMeta.SEARCH_FIELD, ServerInfoVOMeta.FUZZY_FIELD, ServerInfoVOMeta.SEARCH_VALUE, ServerInfoVOMeta.DIRTY_FIELDS, ServerInfoVOMeta.SORT_FIELD, ServerInfoVOMeta.SORT_TYPE, ServerInfoVOMeta.IDS })
    @SentinelResource(value = ServerInfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServerInfoVO serverInfoVO) {
        Result result = serverInfoService.update(serverInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存服务器资源
     */
    @ApiOperation(value = "保存服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "602750624248893440"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试服务器"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_TYPE, value = "服务器类型", required = false, dataTypeClass = String.class, example = "virtual_machine"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OS_VERSION, value = "系统版本", required = false, dataTypeClass = String.class, example = "599614904982306816"),
		@ApiImplicitParam(name = ServerInfoVOMeta.IP, value = "IP地址", required = false, dataTypeClass = String.class, example = "192,268,1,1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.DATABASE_VERSION, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.MIDDLEWARE_VERSION, value = "中间件", required = false, dataTypeClass = String.class, example = "Tomcat"),
		@ApiImplicitParam(name = ServerInfoVOMeta.CPU, value = "CPU数", required = false, dataTypeClass = Integer.class, example = "2"),
		@ApiImplicitParam(name = ServerInfoVOMeta.MEMORY, value = "内存(G)", required = false, dataTypeClass = Integer.class, example = "4"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SPACE_SIZE, value = "空间(G)", required = false, dataTypeClass = Integer.class, example = "100"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.USERLIST, value = "用户列表", required = false, dataTypeClass = String.class, example = "root"),
		@ApiImplicitParam(name = ServerInfoVOMeta.PORTLIST, value = "端口列表", required = false, dataTypeClass = String.class, example = "8080"),
		@ApiImplicitParam(name = ServerInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServerInfoVOMeta.PAGE_INDEX, ServerInfoVOMeta.PAGE_SIZE, ServerInfoVOMeta.SEARCH_FIELD, ServerInfoVOMeta.FUZZY_FIELD, ServerInfoVOMeta.SEARCH_VALUE, ServerInfoVOMeta.DIRTY_FIELDS, ServerInfoVOMeta.SORT_FIELD, ServerInfoVOMeta.SORT_TYPE, ServerInfoVOMeta.IDS })
    @SentinelResource(value = ServerInfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServerInfoVO serverInfoVO) {
        Result result = serverInfoService.save(serverInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取服务器资源
     */
    @ApiOperation(value = "获取服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServerInfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.GET_BY_ID)
    public Result<ServerInfo> getById(String id) {
        Result<ServerInfo> result = new Result<>();
        ServerInfo serverInfo = serverInfoService.getById(id);
        // join 关联的对象
        serverInfoService.dao().fill(serverInfo).with(ServerInfoMeta.SERVER_OS_TYPE).execute();
        result.success(true).data(serverInfo);
        return result;
    }

    /**
     * 批量获取服务器资源 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServerInfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.GET_BY_IDS)
    public Result<List<ServerInfo>> getByIds(List<String> ids) {
        Result<List<ServerInfo>> result = new Result<>();
        List<ServerInfo> list = serverInfoService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询服务器资源
     */
    @ApiOperation(value = "查询服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "602750624248893440"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试服务器"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_TYPE, value = "服务器类型", required = false, dataTypeClass = String.class, example = "virtual_machine"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OS_VERSION, value = "系统版本", required = false, dataTypeClass = String.class, example = "599614904982306816"),
		@ApiImplicitParam(name = ServerInfoVOMeta.IP, value = "IP地址", required = false, dataTypeClass = String.class, example = "192,268,1,1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.DATABASE_VERSION, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.MIDDLEWARE_VERSION, value = "中间件", required = false, dataTypeClass = String.class, example = "Tomcat"),
		@ApiImplicitParam(name = ServerInfoVOMeta.CPU, value = "CPU数", required = false, dataTypeClass = Integer.class, example = "2"),
		@ApiImplicitParam(name = ServerInfoVOMeta.MEMORY, value = "内存(G)", required = false, dataTypeClass = Integer.class, example = "4"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SPACE_SIZE, value = "空间(G)", required = false, dataTypeClass = Integer.class, example = "100"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.USERLIST, value = "用户列表", required = false, dataTypeClass = String.class, example = "root"),
		@ApiImplicitParam(name = ServerInfoVOMeta.PORTLIST, value = "端口列表", required = false, dataTypeClass = String.class, example = "8080"),
		@ApiImplicitParam(name = ServerInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServerInfoVOMeta.PAGE_INDEX, ServerInfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServerInfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.QUERY_LIST)
    public Result<List<ServerInfo>> queryList(ServerInfoVO sample) {
        Result<List<ServerInfo>> result = new Result<>();
        List<ServerInfo> list = serverInfoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询服务器资源
     */
    @ApiOperation(value = "分页查询服务器资源")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServerInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "602750624248893440"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试服务器"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_TYPE, value = "服务器类型", required = false, dataTypeClass = String.class, example = "virtual_machine"),
		@ApiImplicitParam(name = ServerInfoVOMeta.OS_VERSION, value = "系统版本", required = false, dataTypeClass = String.class, example = "599614904982306816"),
		@ApiImplicitParam(name = ServerInfoVOMeta.IP, value = "IP地址", required = false, dataTypeClass = String.class, example = "192,268,1,1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.DATABASE_VERSION, value = "数据库", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.MIDDLEWARE_VERSION, value = "中间件", required = false, dataTypeClass = String.class, example = "Tomcat"),
		@ApiImplicitParam(name = ServerInfoVOMeta.CPU, value = "CPU数", required = false, dataTypeClass = Integer.class, example = "2"),
		@ApiImplicitParam(name = ServerInfoVOMeta.MEMORY, value = "内存(G)", required = false, dataTypeClass = Integer.class, example = "4"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SPACE_SIZE, value = "空间(G)", required = false, dataTypeClass = Integer.class, example = "100"),
		@ApiImplicitParam(name = ServerInfoVOMeta.SERVER_NUMBER, value = "数量", required = false, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = ServerInfoVOMeta.USERLIST, value = "用户列表", required = false, dataTypeClass = String.class, example = "root"),
		@ApiImplicitParam(name = ServerInfoVOMeta.PORTLIST, value = "端口列表", required = false, dataTypeClass = String.class, example = "8080"),
		@ApiImplicitParam(name = ServerInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServerInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServerInfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServerInfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServerInfo>> queryPagedList(ServerInfoVO sample) {
        Result<PagedList<ServerInfo>> result = new Result<>();
        PagedList<ServerInfo> list = serverInfoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        serverInfoService.dao().fill(list).with(ServerInfoMeta.SERVER_OS_TYPE).execute();
        result.success(true).data(list);
        return result;
    }
}
