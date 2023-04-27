package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum SlbSessionKeepEnum implements CodeTextEnum {

    YES("yes" , "是"),
    NO("no" , "否");


    private String code;
    private String text;
    private SlbSessionKeepEnum(String code, String text)  {
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


