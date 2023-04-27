package com.niuys.gdzc.web.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class UpdatepwdForm extends ValidatorForm {
	
private String username;
private String oldpwd;
private String newpwd;
private String renewpwd;
public UpdatepwdForm() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getOldpwd() {
	return oldpwd;
}
public void setOldpwd(String oldpwd) {
	this.oldpwd = oldpwd;
}
public String getNewpwd() {
	return newpwd;
}
public void setNewpwd(String newpwd) {
	this.newpwd = newpwd;
}
public String getRenewpwd() {
	return renewpwd;
}
public void setRenewpwd(String renewpwd) {
	this.renewpwd = renewpwd;
}



}
