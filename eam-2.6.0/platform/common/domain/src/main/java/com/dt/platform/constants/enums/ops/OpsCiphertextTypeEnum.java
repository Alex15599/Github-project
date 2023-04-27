package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum OpsCiphertextTypeEnum implements CodeTextEnum {


    DATABASE("database" , "数据库"),
    DATABASE_INSTANCE("database_instance" , "数据库实例"),
    DATABASE_INSTANCE_OTHER("database_instance_other" , "数据库实例_其他"),
    OPERATING_SYSTEM("operating_system" , "操作系统"),
    INFORMATION_SYSTEM("information_system" , "信息系统"),
    ASSET("asset" , "资产"),
    EQUIPMENT("equipment" , "设备"),
    OHTER("other" , "其他")
    ;



    private String code;
    private String text;
    private OpsCiphertextTypeEnum(String code, String text)  {
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