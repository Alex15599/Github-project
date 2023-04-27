package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum BackupStatusEnum implements CodeTextEnum {

    VALID("valid" , "有效"),
    INVALID("invalid" , "失效"),
    PROCESSING("processing" , "处理中" ),
    FAILED("failed" , "失败" );


    private String code;
    private String text;
    private BackupStatusEnum(String code, String text)  {
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

