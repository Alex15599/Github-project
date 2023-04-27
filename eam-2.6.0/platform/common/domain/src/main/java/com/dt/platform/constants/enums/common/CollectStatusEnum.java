package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum CollectStatusEnum implements CodeTextEnum {

    VALID("valid" , "有效"),
    INVALID("invalid" , "失效");


    private String code;
    private String text;
    private CollectStatusEnum(String code, String text)  {
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

