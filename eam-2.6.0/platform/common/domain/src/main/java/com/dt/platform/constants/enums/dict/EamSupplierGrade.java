package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2022-11-07 07:39:31
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum EamSupplierGrade implements CodeTextEnum {
	
	/**
	 * 一级
	*/
	ONE("one" , "一级"),
	
	/**
	 * 二级
	*/
	TWO("two" , "二级"),
	;
	
	private String code;
	private String text;
	private EamSupplierGrade(String code,String text)  {
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
	public static EamSupplierGrade parseByCode(String code) {
		return (EamSupplierGrade) EnumUtil.parseByCode(EamSupplierGrade.values(),code);
	}
}