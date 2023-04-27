package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbStorageTypeEnum implements CodeTextEnum {


    DIRECT("direct", "直接"),
    VERSION("version", "版本");

    private String code;
    private String text;
    private OpsCmdbStorageTypeEnum(String code, String text)  {
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
