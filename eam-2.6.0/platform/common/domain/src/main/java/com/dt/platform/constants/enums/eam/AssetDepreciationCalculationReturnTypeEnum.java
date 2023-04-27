package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationCalculationReturnTypeEnum implements CodeTextEnum {

    TYPE_STRING("string" , "字符串"),
 //   type_integer("integer" , "整数"),
    TYPE_DOUBLE("double" , "浮点"),
    TYPE_BOOLEAN("boolean" , "Boolean"),
    TYPE_IDLE("idle" , "无");

    private String code;
    private String text;
    private AssetDepreciationCalculationReturnTypeEnum(String code, String text)  {
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