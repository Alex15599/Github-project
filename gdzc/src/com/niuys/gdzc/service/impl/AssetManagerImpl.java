package com.niuys.gdzc.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.niuys.gdzc.dao.IAssetsDAO;
import com.niuys.gdzc.dao.IUserDAO;
import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.service.AssetManager;

public class AssetManagerImpl implements AssetManager {

	private IUserDAO userDAOImpl;
	private IAssetsDAO assetDAOImpl;

	public void setUserDAOImpl(IUserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	public void setAssetDAOImpl(IAssetsDAO assetDAOImpl) {
		this.assetDAOImpl = assetDAOImpl;
	}

	public boolean login(String username, String password) {
		return userDAOImpl.login(username, password);
	}

	public List showAllAssets() {
		return assetDAOImpl.showAllAssets();
	}

	public List findPageAssets(int pageStartRow, int pageCount) {
		return assetDAOImpl.findPageAssets(pageStartRow, pageCount);

	}
	
	public boolean checkZCID(String zc_id){
		return assetDAOImpl.checkZCID(zc_id);
	}

	public boolean addAssets(ZcInfo zcinfo) {

		return assetDAOImpl.addAssets(zcinfo);
	}
	
	public ZcInfo getOneZc(String id){
		return assetDAOImpl.getOneZc(id);
	}
	
	public void saveUpdate(ZcInfo zcinfo){
		assetDAOImpl.saveUpdate(zcinfo);
	}

	public boolean deleteAsset(String zc_id) {
		return assetDAOImpl.deleteAsset(zc_id);
	}
	
	public List checkZC(String zcId,	String zcFactory,String zcNo,
			String zcName,String zcType,String zcStatus,
			String zcBuyer){
		return assetDAOImpl.checkZC(zcId, zcFactory, zcNo, zcName, 
									zcType, zcStatus, zcBuyer);
	}
}
