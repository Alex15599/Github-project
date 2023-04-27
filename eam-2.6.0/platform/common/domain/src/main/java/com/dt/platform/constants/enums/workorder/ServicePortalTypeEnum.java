package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ServicePortalTypeEnum implements CodeTextEnum {

    OUTLINK("outlink" , "外链");

    private String code;
    private String text;
    private ServicePortalTypeEnum(String code, String text)  {
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
