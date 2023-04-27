package com.niuys.gdzc.service;

import java.util.List;

import com.niuys.gdzc.model.UserInfo;

public interface IUserManaManager {

	public List showAllUsers();
	
	public List findPageUsers(int pageStartRow, int pageCount);
	
	public boolean insertUser(UserInfo user);
	
	public boolean deleteUser(String eno);
	
	public List findUserbyname(String name);
	
	public boolean updateUser(UserInfo user);
	
	public boolean ispwd(String username, String oldpwd);
	
	public boolean changepwd(String username, String newpwd);
	
	public String competence(String userName);
}
