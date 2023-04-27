package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbAssociationTypeEnum implements CodeTextEnum {


    NONE("none", "无"),
    STAND_ALONE("stand_alone", "独立"),
    ASSOCIATE_PARENT("associate_parent", "关联上级");

    private String code;
    private String text;
    private OpsCmdbAssociationTypeEnum(String code, String text)  {
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
