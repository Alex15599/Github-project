package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum AutoModuleRoleTypeEnum implements CodeTextEnum {

    ROLE("role" , "功能角色"),
    BUSI_ROLE("busi_role" , "业务角色")
    ;


    private String code;
    private String text;
    private AutoModuleRoleTypeEnum(String code, String text)  {
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

