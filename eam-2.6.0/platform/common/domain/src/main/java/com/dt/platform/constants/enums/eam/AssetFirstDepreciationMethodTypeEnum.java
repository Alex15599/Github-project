package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetFirstDepreciationMethodTypeEnum implements CodeTextEnum {

    REGISTER_CUR_MONTH("register_cur_month" , "入账当月"),
    REGISTER_NEXT_MONTH("register_next_month" , "入账次月");

    private String code;
    private String text;
    private AssetFirstDepreciationMethodTypeEnum(String code, String text)  {
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