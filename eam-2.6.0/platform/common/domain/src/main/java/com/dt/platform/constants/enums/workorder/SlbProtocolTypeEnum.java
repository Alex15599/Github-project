package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum SlbProtocolTypeEnum implements CodeTextEnum {

    HTTP("http" , "HTTP协议"),
    HTTPS("https" , "HTTPS协议"),
    TCP("tcp" , "TCP协议"),
    UDP("udp" , "TCP协议"),
    SOCKET("socket" , "Socket");


    private String code;
    private String text;
    private SlbProtocolTypeEnum(String code, String text)  {
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
