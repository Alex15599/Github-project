package com.niuys.gdzc.service;

import java.util.List;

import com.niuys.gdzc.model.ZcWx;


public interface IAssetPerManager {
	
	public List showAllPerAssets();
	
	public List findPagePerAssets(int pageStartRow, int pageCount);

	public boolean insertPerAssets(ZcWx zcwx);

	public boolean deletePerAsset(int zcno);
	
	public List findPerAssetbyid(int zcno); 
	
	public boolean updatePerAsset(ZcWx zcwx);
	
	public List findPerAssetbyPro(String sendtime,int no, String login_user, 
			String sender, String wx_result);
}
