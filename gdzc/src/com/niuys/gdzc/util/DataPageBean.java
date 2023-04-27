package com.niuys.gdzc.util;

public class DataPageBean {
	private int currentPage;
	private int countRecord;
	private int countPage;
	private int sizePage;
	public void setAll(int _countRecord,int _sizePage){
		countRecord=_countRecord;
		sizePage=_sizePage;
		countPage=(countRecord+sizePage-1)/sizePage;
		currentPage=1;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getCountRecord() {
		return countRecord;
	}
	public void setCountRecord(int countRecord) {
		this.countRecord = countRecord;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSizePage() {
		return sizePage;
	}
	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}
}
