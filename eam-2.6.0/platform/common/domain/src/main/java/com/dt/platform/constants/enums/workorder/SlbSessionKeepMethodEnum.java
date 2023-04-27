package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum SlbSessionKeepMethodEnum implements CodeTextEnum {

    SESSION("session" , "基于Session"),
    HASH_IP("hash_ip" , "HASH IP");


    private String code;
    private String text;
    private SlbSessionKeepMethodEnum(String code, String text)  {
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


