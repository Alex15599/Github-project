package com.niuys.gdzc.model;

import java.util.Date;

/**
 * ZcWx entity. @author MyEclipse Persistence Tools
 */

public class ZcWx implements java.io.Serializable {

	// Fields

	private Integer repairNo;
	private ZcInfo zcInfo;
	private String sendTime;
	private String sender;
	private String loginUser;
	private String reason;
	private String wx_comment;
	private String wx_result;
	private String wx_time;
	private float cost;


	// Constructors

	/** default constructor */
	public ZcWx() {
	}

	/** minimal constructor */
	public ZcWx(ZcInfo zcInfo, String sendTime, String sender, String loginUser) {
		this.zcInfo = zcInfo;
		this.sendTime = sendTime;
		this.sender = sender;
		this.loginUser = loginUser;
	}

	/** full constructor */
	public ZcWx(ZcInfo zcInfo, String sendTime, String sender, String loginUser,
			String reason) {
		this.zcInfo = zcInfo;
		this.sendTime = sendTime;
		this.sender = sender;
		this.loginUser = loginUser;
		this.reason = reason;
	}

	// Property accessors

	public Integer getRepairNo() {
		return this.repairNo;
	}

	public void setRepairNo(Integer repairNo) {
		this.repairNo = repairNo;
	}

	public ZcInfo getZcInfo() {
		return this.zcInfo;
	}

	public void setZcInfo(ZcInfo zcInfo) {
		this.zcInfo = zcInfo;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getLoginUser() {
		return this.loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getWx_comment() {
		return wx_comment;
	}

	public void setWx_comment(String wx_comment) {
		this.wx_comment = wx_comment;
	}

	public String getWx_result() {
		return wx_result;
	}

	public void setWx_result(String wx_result) {
		this.wx_result = wx_result;
	}

	public String getWx_time() {
		return wx_time;
	}

	public void setWx_time(String wx_time) {
		this.wx_time = wx_time;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}


	

	
}