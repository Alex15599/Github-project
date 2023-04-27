package com.niuys.gdzc.web.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class EditEmployeeForm extends ValidatorForm {
	
	private String eno;
	private String ename;
	private String esex="ÄÐ";
	private String eage;
	private String edept;
	private String epro;
	private String eaddr;
	private String ephone;
	private String estatus;
	public EditEmployeeForm() {
		super();
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}
	public String getEpro() {
		return epro;
	}
	public void setEpro(String epro) {
		this.epro = epro;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	

}
