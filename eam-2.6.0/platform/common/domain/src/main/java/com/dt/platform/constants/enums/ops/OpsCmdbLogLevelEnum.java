package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbLogLevelEnum implements CodeTextEnum {


    INFO("info", "信息"),
    WARN("warn", "警告"),
    DEBUG("debug", "调试"),
    ERROR("error", "报错");

    private String code;
    private String text;
    private OpsCmdbLogLevelEnum(String code, String text)  {
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
