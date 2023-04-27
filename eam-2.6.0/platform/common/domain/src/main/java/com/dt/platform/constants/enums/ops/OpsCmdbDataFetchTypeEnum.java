package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbDataFetchTypeEnum implements CodeTextEnum {

    NONE("none", "无"),
    ACTIVE("active", "主动"),
    PASSIVE("passive", "被动");

    private String code;
    private String text;
    private OpsCmdbDataFetchTypeEnum(String code, String text)  {
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
