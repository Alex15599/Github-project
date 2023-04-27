package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ServiceDeskStatusEnum implements CodeTextEnum {


    ENABLE("enable" , "启用"),
    DISABLE("disable" , "停用");

    private String code;
    private String text;
    private ServiceDeskStatusEnum(String code, String text)  {
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


