package com.dt.platform.eam.authority;


import org.github.foxnic.web.framework.module.ModuleAuthority;
import org.springframework.stereotype.Component;

@Component
public class EamAuthority extends ModuleAuthority {

    /**
     * 返回最顶层菜单的权限Key
     * */
    @Override
    public String[] getAuthorities() {
        return new String[] {
                "eam","infrastructure","eam_employee","eam_equipment_mgr"
        };
    }
}
