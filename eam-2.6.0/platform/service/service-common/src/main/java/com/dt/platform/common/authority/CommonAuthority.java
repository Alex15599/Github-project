package com.dt.platform.common.authority;


import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;

@Component
public class CommonAuthority extends ModuleAuthority {

    /**
     * 返回最顶层菜单的权限Key
     * */
    @Override
    public String[] getAuthorities() {
        return new String[] {
                "common_system","data_backup","auto_perm","sys_tpl_file:mngr","system_monitor"
        };
    }
}
