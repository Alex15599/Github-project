package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum AutoModuleEnum implements CodeTextEnum {

    EAM("eam" , "资产系统");


    private String code;
    private String text;
    private AutoModuleEnum(String code, String text)  {
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

