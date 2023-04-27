package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetInventoryModeEnum implements CodeTextEnum {

	EMPLOY_INVENTORY_MODE("employ_inventory_mode" , "全员盘点"),
	FULL_INVENTORY_MODE("full_inventory_mode" , "普通盘点");

	private String code;
	private String text;

	private AssetInventoryModeEnum(String code, String text)  {
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