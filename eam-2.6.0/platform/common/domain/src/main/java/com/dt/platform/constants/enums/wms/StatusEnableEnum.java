package com.dt.platform.constants.enums.wms;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum StatusEnableEnum implements CodeTextEnum {


    ENABLE("enable" , "启用"),
    DISABLE("disable" , "停用"),
    NOT_INIT("not_init" , "未初始化");

    private String code;
    private String text;
    private StatusEnableEnum(String code, String text)  {
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


