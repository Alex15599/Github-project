package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2022-11-07 07:39:31
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrmPersonTalentLevel implements CodeTextEnum {
	
	/**
	 * 初级
	*/
	CJ("cj" , "初级"),
	
	/**
	 * 中级
	*/
	ZJ("zj" , "中级"),
	
	/**
	 * 高级
	*/
	GJ("gj" , "高级"),
	;
	
	private String code;
	private String text;
	private HrmPersonTalentLevel(String code,String text)  {
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
	public static HrmPersonTalentLevel parseByCode(String code) {
		return (HrmPersonTalentLevel) EnumUtil.parseByCode(HrmPersonTalentLevel.values(),code);
	}
}