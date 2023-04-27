package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum AutoModuleIDEnum implements CodeTextEnum {

    EAM_ROLE("eam_role" , "资产系统-用户自动配置功能角色"),
    EAM_DATA_ROLE("eam_data_role" , "资产系统-用户自动配置数据角色");


    private String code;
    private String text;
    private AutoModuleIDEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }

}

