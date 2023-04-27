package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AsseLabelPrintCodeEnum implements CodeTextEnum {

    SPECIAL("special" , "专用"),
    NORMAL("normal" , "常规");

    private String code;
    private String text;
    private AsseLabelPrintCodeEnum(String code, String text)  {
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