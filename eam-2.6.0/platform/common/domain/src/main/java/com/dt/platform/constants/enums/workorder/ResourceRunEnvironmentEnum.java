package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ResourceRunEnvironmentEnum implements CodeTextEnum {

    prod("prod" , "生产环境"),
    TEST("test" , "测试环境"),
    UAT("uat" , "UAT环境");


    private String code;
    private String text;
    private ResourceRunEnvironmentEnum(String code, String text)  {
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
