package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetHandleStatusEnum implements CodeTextEnum {

	COMPLETE("complete" , "已完成"),
	INCOMPLETE("incomplete" , "草稿"),
	DENY("deny" , "拒绝"),
	APPROVAL("approval" , "审批中"),
	CANCEL("cancel" , "取消")
	;
	private String code;
	private String text;
	private AssetHandleStatusEnum(String code, String text)  {
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