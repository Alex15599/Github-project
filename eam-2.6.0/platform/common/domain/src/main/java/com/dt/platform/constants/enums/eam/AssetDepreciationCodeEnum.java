package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationCodeEnum implements CodeTextEnum {

    MONTHLY("monthly" , "按月计算"),
    TEST("test" , "测试");

    private String code;
    private String text;
    private AssetDepreciationCodeEnum(String code, String text)  {
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