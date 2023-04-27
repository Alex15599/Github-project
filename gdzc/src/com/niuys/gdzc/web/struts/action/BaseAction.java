package com.niuys.gdzc.web.struts.action;

import org.apache.struts.action.Action;

import com.niuys.gdzc.service.AssetManager;
import com.niuys.gdzc.service.IAssetPerManager;
import com.niuys.gdzc.service.IEmployeeManager;
import com.niuys.gdzc.service.IInOutAssetManager;
import com.niuys.gdzc.service.IUserManaManager;



public class BaseAction extends Action {

	protected AssetManager assetManagerImpl;
	public void setAssetManagerImpl(AssetManager assetManagerImpl) {
		this.assetManagerImpl = assetManagerImpl;
	}
	
	protected IAssetPerManager  assetPerManagerImpl;
	public void setAssetPerManagerImpl(IAssetPerManager assetPerManagerImpl) {
		this.assetPerManagerImpl = assetPerManagerImpl;
	}

	protected IInOutAssetManager  inOutAssetManagerImpl;
	public void setInOutAssetManagerImpl(IInOutAssetManager inOutAssetManagerImpl) {
		this.inOutAssetManagerImpl = inOutAssetManagerImpl;
	}
	
	
	protected IEmployeeManager employeeManagerImpl;

	public void setEmployeeManagerImpl(IEmployeeManager employeeManagerImpl) {
		this.employeeManagerImpl = employeeManagerImpl;
	}
	
	
	protected IUserManaManager userManaManagerImpl;
	
	public void setUserManaManagerImpl(IUserManaManager userManaManagerImpl) {
		this.userManaManagerImpl = userManaManagerImpl;
	}
	

	
}
