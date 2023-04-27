package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationCalculationMethodTypeEnum implements CodeTextEnum {

    IDEL("idle" , "空"),
    NOT_NULL("not_null" , "不为NULL"),
    JEXL_EXPRESSION("jexl_expression" , "jexl表达式"),
    SCRIPT("script" , "脚本"),
    SQL("sql" , "sql");
    
    private String code;
    private String text;
    private AssetDepreciationCalculationMethodTypeEnum(String code, String text)  {
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