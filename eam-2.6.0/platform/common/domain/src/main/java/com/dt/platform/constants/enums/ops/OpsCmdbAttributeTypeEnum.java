package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbAttributeTypeEnum implements CodeTextEnum {


    STRING("STRING", "字符串"),
    DECIMAL("decimal", "浮点"),
    INT("int", "整数"),
    DATE("date", "日期");

    private String code;
    private String text;
    private OpsCmdbAttributeTypeEnum(String code, String text)  {
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
