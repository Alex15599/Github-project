package com.dt.platform.workorder.authority;


import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;

@Component
public class WorkOrderAuthority extends ModuleAuthority {

    /**
     * 返回最顶层菜单的权限Key
     * */
    @Override
    public String[] getAuthorities() {
        return new String[] {
                "workorder"
        };
    }
}
