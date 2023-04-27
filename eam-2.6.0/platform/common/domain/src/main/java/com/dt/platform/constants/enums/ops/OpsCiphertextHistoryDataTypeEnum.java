package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum OpsCiphertextHistoryDataTypeEnum implements CodeTextEnum {

    CIPHERTEXT_BOX("ciphertext_box" , " 密文箱配置"),
    CIPHERTEXT_BOX_CONF("ciphertext_box_conf" , " 密文箱"),
    CIPHERTEXT_BOX_DATA("ciphertext_box_data" , " 密文");

    private String code;
    private String text;
    private OpsCiphertextHistoryDataTypeEnum(String code, String text)  {
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