package com.niuys.gdzc.web.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class AddPerAssetForm extends ValidatorForm {
	
	public String zc_id;
	public String send_time;
	public String  sender;
	public String login_user;
	public String reason;
	public AddPerAssetForm() {
		super();
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
	

}
