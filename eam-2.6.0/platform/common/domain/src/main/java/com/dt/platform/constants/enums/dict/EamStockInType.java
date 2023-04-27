package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2022-11-07 07:39:31
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum EamStockInType implements CodeTextEnum {
	
	/**
	 * 常规入库
	*/
	NORMAL("normal" , "常规入库"),
	;
	
	private String code;
	private String text;
	private EamStockInType(String code,String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
	
	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static EamStockInType parseByCode(String code) {
		return (EamStockInType) EnumUtil.parseByCode(EamStockInType.values(),code);
	}
}