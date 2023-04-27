package com.niuys.gdzc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ZcInfo entity. @author MyEclipse Persistence Tools
 */

public class ZcInfo implements java.io.Serializable {

	// Fields

	private String zcId;
	private String zcNo;
	private String zcName;
	private Float zcPrice;
	private String zcFactory;
	private String zcProduceTime;
	private String zcBuyTime;
	private String zcBuyer;
	private String zcType;
	private String zcStatus;
	private String zcBzxx;
	private Set zcWxes = new HashSet(0);
	private Set zcInouts = new HashSet(0);

	// Constructors

	/** default constructor */
	public ZcInfo() {
	}

	/** minimal constructor */
	public ZcInfo(String zcNo, String zcName, Float zcPrice, String zcFactory,
			String zcProduceTime, String zcBuyTime, String zcBuyer,
			String zcType, String zcStatus) {
		this.zcNo = zcNo;
		this.zcName = zcName;
		this.zcPrice = zcPrice;
		this.zcFactory = zcFactory;
		this.zcProduceTime = zcProduceTime;
		this.zcBuyTime = zcBuyTime;
		this.zcBuyer = zcBuyer;
		this.zcType = zcType;
		this.zcStatus = zcStatus;
	}

	/** full constructor */
	public ZcInfo(String zcNo, String zcName, Float zcPrice, String zcFactory,
			String zcProduceTime, String zcBuyTime, String zcBuyer,
			String zcType, String zcStatus, String zcBzxx, Set zcWxes,
			Set zcInouts) {
		this.zcNo = zcNo;
		this.zcName = zcName;
		this.zcPrice = zcPrice;
		this.zcFactory = zcFactory;
		this.zcProduceTime = zcProduceTime;
		this.zcBuyTime = zcBuyTime;
		this.zcBuyer = zcBuyer;
		this.zcType = zcType;
		this.zcStatus = zcStatus;
		this.zcBzxx = zcBzxx;
		this.zcWxes = zcWxes;
		this.zcInouts = zcInouts;
	}

	// Property accessors

	public String getZcId() {
		return this.zcId;
	}

	public void setZcId(String zcId) {
		this.zcId = zcId;
	}

	public String getZcNo() {
		return this.zcNo;
	}

	public void setZcNo(String zcNo) {
		this.zcNo = zcNo;
	}

	public String getZcName() {
		return this.zcName;
	}

	public void setZcName(String zcName) {
		this.zcName = zcName;
	}

	public Float getZcPrice() {
		return this.zcPrice;
	}

	public void setZcPrice(Float zcPrice) {
		this.zcPrice = zcPrice;
	}

	public String getZcFactory() {
		return this.zcFactory;
	}

	public void setZcFactory(String zcFactory) {
		this.zcFactory = zcFactory;
	}

	public String getZcProduceTime() {
		return this.zcProduceTime;
	}

	public void setZcProduceTime(String zcProduceTime) {
		this.zcProduceTime = zcProduceTime;
	}

	public String getZcBuyTime() {
		return this.zcBuyTime;
	}

	public void setZcBuyTime(String zcBuyTime) {
		this.zcBuyTime = zcBuyTime;
	}

	public String getZcBuyer() {
		return this.zcBuyer;
	}

	public void setZcBuyer(String zcBuyer) {
		this.zcBuyer = zcBuyer;
	}

	public String getZcType() {
		return this.zcType;
	}

	public void setZcType(String zcType) {
		this.zcType = zcType;
	}

	public String getZcStatus() {
		return this.zcStatus;
	}

	public void setZcStatus(String zcStatus) {
		this.zcStatus = zcStatus;
	}

	public String getZcBzxx() {
		return this.zcBzxx;
	}

	public void setZcBzxx(String zcBzxx) {
		this.zcBzxx = zcBzxx;
	}

	public Set getZcWxes() {
		return this.zcWxes;
	}

	public void setZcWxes(Set zcWxes) {
		this.zcWxes = zcWxes;
	}

	public Set getZcInouts() {
		return this.zcInouts;
	}

	public void setZcInouts(Set zcInouts) {
		this.zcInouts = zcInouts;
	}

}