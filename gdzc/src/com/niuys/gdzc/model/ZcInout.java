package com.niuys.gdzc.model;

import java.util.Date;

/**
 * ZcInout entity. @author MyEclipse Persistence Tools
 */

public class ZcInout implements java.io.Serializable {

	// Fields

	private Integer inoutNo;
	private ZcInfo zcInfo;
	private String comployeeNo;
	private String outTime;
	private String shouldTime;
	private String backTime;

	// Constructors

	/** default constructor */
	public ZcInout() {
	}

	/** minimal constructor */
	public ZcInout(ZcInfo zcInfo, String comployeeNo, String outTime,
			String shouldTime) {
		this.zcInfo = zcInfo;
		this.comployeeNo = comployeeNo;
		this.outTime = outTime;
		this.shouldTime = shouldTime;
	}

	/** full constructor */
	public ZcInout(ZcInfo zcInfo, String comployeeNo, String outTime,
			String shouldTime, String backTime) {
		this.zcInfo = zcInfo;
		this.comployeeNo = comployeeNo;
		this.outTime = outTime;
		this.shouldTime = shouldTime;
		this.backTime = backTime;
	}

	// Property accessors

	public Integer getInoutNo() {
		return this.inoutNo;
	}

	public void setInoutNo(Integer inoutNo) {
		this.inoutNo = inoutNo;
	}

	public ZcInfo getZcInfo() {
		return this.zcInfo;
	}

	public void setZcInfo(ZcInfo zcInfo) {
		this.zcInfo = zcInfo;
	}

	public String getComployeeNo() {
		return this.comployeeNo;
	}

	public void setComployeeNo(String comployeeNo) {
		this.comployeeNo = comployeeNo;
	}

	public String getOutTime() {
		return this.outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getShouldTime() {
		return this.shouldTime;
	}

	public void setShouldTime(String shouldTime) {
		this.shouldTime = shouldTime;
	}

	public String getBackTime() {
		return this.backTime;
	}

	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}

}