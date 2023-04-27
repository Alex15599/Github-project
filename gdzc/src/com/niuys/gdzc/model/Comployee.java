package com.niuys.gdzc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Comployee entity. @author MyEclipse Persistence Tools
 */

public class Comployee implements java.io.Serializable {

	// Fields

	private String comployeeNo;
	private Department department;
	private String comployeeName;
	private String sex;
	private Integer age;
	private String profession;
	private String address;
	private String phone;
	private String comployeeStatus;
	private Set userInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Comployee() {
	}

	/** minimal constructor */
	public Comployee(Department department, String comployeeName, String sex,
			Integer age, String profession, String address, String phone,
			String comployeeStatus) {
		this.department = department;
		this.comployeeName = comployeeName;
		this.sex = sex;
		this.age = age;
		this.profession = profession;
		this.address = address;
		this.phone = phone;
		this.comployeeStatus = comployeeStatus;
	}

	/** full constructor */
	public Comployee(Department department, String comployeeName, String sex,
			Integer age, String profession, String address, String phone,
			String comployeeStatus, Set userInfos) {
		this.department = department;
		this.comployeeName = comployeeName;
		this.sex = sex;
		this.age = age;
		this.profession = profession;
		this.address = address;
		this.phone = phone;
		this.comployeeStatus = comployeeStatus;
		this.userInfos = userInfos;
	}

	// Property accessors

	public String getComployeeNo() {
		return this.comployeeNo;
	}

	public void setComployeeNo(String comployeeNo) {
		this.comployeeNo = comployeeNo;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getComployeeName() {
		return this.comployeeName;
	}

	public void setComployeeName(String comployeeName) {
		this.comployeeName = comployeeName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComployeeStatus() {
		return this.comployeeStatus;
	}

	public void setComployeeStatus(String comployeeStatus) {
		this.comployeeStatus = comployeeStatus;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

}