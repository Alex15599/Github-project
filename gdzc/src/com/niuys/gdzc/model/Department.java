package com.niuys.gdzc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private String dept;
	private Set comployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(Set comployees) {
		this.comployees = comployees;
	}

	// Property accessors

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Set getComployees() {
		return this.comployees;
	}

	public void setComployees(Set comployees) {
		this.comployees = comployees;
	}

}