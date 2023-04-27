package com.niuys.gdzc.model;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String userName;
	private Comployee comployee;
	private String pwd;
	private String competence;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(Comployee comployee, String pwd, String competence) {
		this.comployee = comployee;
		this.pwd = pwd;
		this.competence = competence;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Comployee getComployee() {
		return this.comployee;
	}

	public void setComployee(Comployee comployee) {
		this.comployee = comployee;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCompetence() {
		return this.competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

}