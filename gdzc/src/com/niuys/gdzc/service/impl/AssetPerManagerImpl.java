package com.niuys.gdzc.service.impl;

import java.util.List;

import com.niuys.gdzc.dao.IAssetPerDAO;
import com.niuys.gdzc.model.ZcWx;
import com.niuys.gdzc.service.IAssetPerManager;

public class AssetPerManagerImpl implements IAssetPerManager {
	
	private IAssetPerDAO assetPerDAOImpl;	

	public void setAssetPerDAOImpl(IAssetPerDAO assetPerDAOImpl) {
		this.assetPerDAOImpl = assetPerDAOImpl;
	}

	public List findPagePerAssets(int pageStartRow, int pageCount) {

		return assetPerDAOImpl.findPagePerAssets(pageStartRow, pageCount);

	}

	public List showAllPerAssets() {

		 return assetPerDAOImpl.showAllPerAssets();
	}

	public boolean insertPerAssets(ZcWx zcwx) {
		
		return assetPerDAOImpl.insertPerAssets(zcwx);
	}

	public boolean deletePerAsset(int zcno) {

		return assetPerDAOImpl.deletePerAsset(zcno);
	}

	public List findPerAssetbyid(int zcno) {

		return assetPerDAOImpl.findPerAssetbyid(zcno);
	}

	public boolean updatePerAsset(ZcWx zcwx) {

		return assetPerDAOImpl.updatePerAsset(zcwx);
	}

	public List findPerAssetbyPro(String sendtime,int no, String login_user, 
			String sender, String wx_result) {

		return assetPerDAOImpl.findPerAssetbyPro(sendtime,no, login_user,  sender, wx_result);    
	}

}
