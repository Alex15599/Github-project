package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ServiceDeskTypeEnum implements CodeTextEnum {

    PROCESS("process" , "流程"),
    OUTLINK("outlink" , "外链"),
    DIR("dir" , "目录");



    private String code;
    private String text;
    private ServiceDeskTypeEnum(String code, String text)  {
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
