package com.niuys.gdzc.web.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class AddUserForm extends ValidatorForm {
	private String userName;
	private String password;
	private String rePassword;
	private String competence;
	private String comployeeNo;
	public AddUserForm() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public String getComployeeNo() {
		return comployeeNo;
	}
	public void setComployeeNo(String comployeeNo) {
		this.comployeeNo = comployeeNo;
	}
	
	
	

}
