package com.niuys.gdzc.service.impl;

import java.util.List;

import com.niuys.gdzc.dao.IInOutAssetsDAO;
import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcInout;
import com.niuys.gdzc.service.IInOutAssetManager;

public class InOutAssetManagerImpl implements IInOutAssetManager {

	private IInOutAssetsDAO inOutAssetsDAOImpl;	
	public void setInOutAssetsDAOImpl(IInOutAssetsDAO inOutAssetsDAOImpl) {
		this.inOutAssetsDAOImpl = inOutAssetsDAOImpl;
	}


	public List showLendAssets(){
		return inOutAssetsDAOImpl.showLendAssets();
	}
	
	public List findPageLendAssets(int pageStartRow, int pageCount){
		return inOutAssetsDAOImpl.findPageLendAssets(pageStartRow, pageCount);
	}
	
	public Comployee getOneEmployee(String comployeeNo){
		return inOutAssetsDAOImpl.getOneEmployee(comployeeNo);
	}
	
	public ZcInfo getOneZc(String zcId){
		return inOutAssetsDAOImpl.getOneZc(zcId);
	}
	
	public boolean backZC(String inoutNo, String zcId){
		return inOutAssetsDAOImpl.backZC(inoutNo, zcId);
	}
	
	public String zcStatus(String zcId){
		return inOutAssetsDAOImpl.zcStatus(zcId);
	}
	
	public boolean outZC(ZcInout inout,String zcId) {
		return inOutAssetsDAOImpl.outZC(inout, zcId);
	}
	
	public List ZCInOut(ZcInout inout){
		return inOutAssetsDAOImpl.ZCInOut(inout);
	}
}
