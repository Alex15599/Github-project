package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum OpsAutoActionNodeNumberTypeEnum implements CodeTextEnum {


    ONE("1" , "一节点"),
    TWO("2" , "两节点"),
    THREE("3" , "三节点")
    ;

    private String code;
    private String text;
    private OpsAutoActionNodeNumberTypeEnum(String code, String text)  {
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