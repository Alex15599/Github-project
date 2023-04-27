package com.dt.platform.common.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.common.service.IAutoModuleRoleService;
import com.dt.platform.common.service.ICodeModuleService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.common.MobileInfoServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.Rcd;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "编码生成")
@ApiSort(0)
@RestController("MobileInfoController")
public class MobileInfoController {
    @Autowired
    private IAutoModuleRoleService autoModuleRoleService;
    /*
    	获取登录后跳转地址
	*/
    @ApiOperation(value = "获取登录后跳转地址")
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MobileInfoServiceProxy.LOGIN_INDEX, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MobileInfoServiceProxy.LOGIN_INDEX)
    public Result<JSONObject> loginIndex() {
        Result<JSONObject> res=new Result<>();
        JSONObject obj=new JSONObject();
        Rcd rs=autoModuleRoleService.dao().queryRecord("select * from sys_config where id='eam.mobileLoginIndex'");
        if(rs!=null){
            obj=rs.toJSONObject();
        }
        res.data(obj);
        res.success(true);
        return res;
    }
}
