package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AsseLabelTableCellTypeEnum implements CodeTextEnum {

    TITLE("title" , "标题"),
    LABEL("label" , "标签"),
    VALUE("value" , "值"),
    QR_CODE("qr_code" , "二维码"),
    BAR_CODE("bar_code" , "条形码");


    private String code;
    private String text;
    private AsseLabelTableCellTypeEnum(String code, String text)  {
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