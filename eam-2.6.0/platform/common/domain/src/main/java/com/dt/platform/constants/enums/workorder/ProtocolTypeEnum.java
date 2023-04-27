package com.dt.platform.constants.enums.workorder;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ProtocolTypeEnum implements CodeTextEnum {

    TCP("tcp" , "TCP协议"),
    UDP("udp" , "UDP协议"),
    SOCKET("socket" , "Socket"),
    HTTP("http" , "HTTP协议");

    private String code;
    private String text;
    private ProtocolTypeEnum(String code, String text)  {
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
