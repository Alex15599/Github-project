package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationResidualValueSelectEnum implements CodeTextEnum {

    FOLLOW_ASSET("follow_asset" , "跟随资产"),
    CURRENT_SCHEME("current_scheme" , "当前方案");
    private String code;
    private String text;
    private AssetDepreciationResidualValueSelectEnum(String code, String text)  {
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