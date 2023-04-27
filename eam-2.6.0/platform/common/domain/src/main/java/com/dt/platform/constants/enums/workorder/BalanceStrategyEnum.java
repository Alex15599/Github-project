package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum BalanceStrategyEnum implements CodeTextEnum {

    AVERAGE_WEIGHT("average_weight" , "平均权重"),
    ROTATION("rotation" , "轮训策略");

    private String code;
    private String text;
    private BalanceStrategyEnum(String code, String text)  {
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


