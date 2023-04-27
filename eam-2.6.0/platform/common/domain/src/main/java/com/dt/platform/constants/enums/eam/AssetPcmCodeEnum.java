package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetPcmCodeEnum implements CodeTextEnum {

	ASSET("asset" , "资产"),
	ASSET_SOFTWARE("asset_software" , "软件资产"),
	ASSET_CONSUMABLES("asset_consumables" , "耗材"),
	ASSET_STOCK("asset_stock" , "库存"),
	ASSET_SPAREPARTS("asset_spareparts" , "备品备件"),
	ASSET_STOCK_GOODS("asset_stock_goods" , "物品档案")
	;
	private String code;
	private String text;
	private AssetPcmCodeEnum(String code, String text)  {
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