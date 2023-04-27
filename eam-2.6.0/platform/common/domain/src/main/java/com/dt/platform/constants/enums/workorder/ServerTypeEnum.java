package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ServerTypeEnum implements CodeTextEnum {

    VIRTUAL_MACHINE("virtual_machine" , "虚拟机"),
    PHYSICAL_MACHINE("physical_machine" , "物理机");

    private String code;
    private String text;
    private ServerTypeEnum(String code, String text)  {
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


