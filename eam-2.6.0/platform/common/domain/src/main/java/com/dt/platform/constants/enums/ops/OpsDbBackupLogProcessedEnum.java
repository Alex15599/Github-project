package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum OpsDbBackupLogProcessedEnum implements CodeTextEnum {


    PROCESS_SUCCESS("process_sucess" , "成功成功"),
    PROCESS_FAILED("process_failed" , "处理失败"),
    NOT_PROCESSED("not_processed" , "未处理");


    private String code;
    private String text;
    private OpsDbBackupLogProcessedEnum(String code, String text)  {
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