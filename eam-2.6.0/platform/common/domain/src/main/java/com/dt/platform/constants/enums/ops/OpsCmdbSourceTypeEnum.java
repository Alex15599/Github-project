package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbSourceTypeEnum implements CodeTextEnum {


    NONE("none", "空"),
    STATIC("static", "静态"),
    SQL("sql", "SQL"),
    API("api", "接口");

    private String code;
    private String text;
    private OpsCmdbSourceTypeEnum(String code, String text)  {
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
