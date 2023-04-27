package com.niuys.gdzc.web.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class FindPerAssetForm extends ValidatorForm {
	private String repair_no;
	private String zc_id;
	private String send_time;
	private String sender;
	private String login_user;
	private String reason;
	private String  wx_time;
	private String wx_result;
	private String cost;
	private String wx_comment;
	
	
	
	public FindPerAssetForm() {
		super();
	}
	public String getRepair_no() {
		return repair_no;
	}
	public void setRepair_no(String repair_no) {
		this.repair_no = repair_no;
	}
	public String getZc_id() {
		return zc_id;
	}
	public void setZc_id(String zc_id) {
		this.zc_id = zc_id;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getLogin_user() {
		return login_user;
	}
	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getWx_time() {
		return wx_time;
	}
	public void setWx_time(String wx_time) {
		this.wx_time = wx_time;
	}
	public String getWx_result() {
		return wx_result;
	}
	public void setWx_result(String wx_result) {
		this.wx_result = wx_result;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getWx_comment() {
		return wx_comment;
	}
	public void setWx_comment(String wx_comment) {
		this.wx_comment = wx_comment;
	}
	

	
}
