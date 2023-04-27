package com.dt.platform.eam.common;

import com.github.foxnic.api.error.ErrorDefinition;
import com.github.foxnic.api.error.ErrorDesc;


public class AssetCommonError extends ErrorDefinition {

    public static final String SUCCESS_TEXT = "操作成功";
    public static final String FALIURE_TEXT = "操作失败";

    // 设定前缀
    private static final String PREFIX = "";
    // 定义通用错误
    /**
     * 操作成功
     */
    public static final String SUCCESS = PREFIX + "00";
    /**
     * 操作失败
     */
    public static final String FALIURE = PREFIX + "01";

    /**
     * 操作失败
     */
    public static final String ASSET_DATA_NOT_SELECT = PREFIX + "01";

    /**
     * 操作失败
     */
    public static final String ASSET_DATA_NOT_SELECT_TXT = "未选择资产";


    public void init() {
        try {

            new ErrorDesc(this,SUCCESS, SUCCESS_TEXT);
            new ErrorDesc(this,FALIURE, FALIURE_TEXT);
            new ErrorDesc(this,ASSET_DATA_NOT_SELECT, ASSET_DATA_NOT_SELECT_TXT);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
