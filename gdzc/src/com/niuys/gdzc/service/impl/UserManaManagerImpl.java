package com.niuys.gdzc.service.impl;

import java.util.List;

import com.niuys.gdzc.dao.IUserManaDAO;
import com.niuys.gdzc.model.UserInfo;
import com.niuys.gdzc.service.IUserManaManager;

public class UserManaManagerImpl implements IUserManaManager {
	
	private IUserManaDAO userManaDAOImpl;

	public void setUserManaDAOImpl(IUserManaDAO userManaDAOImpl) {
		this.userManaDAOImpl = userManaDAOImpl;
	}

	public List findPageUsers(int pageStartRow, int pageCount) {

		return userManaDAOImpl.findPageUsers(pageStartRow, pageCount);
	}

	public List showAllUsers() {

		return userManaDAOImpl.showAllUsers();
	}

	public boolean insertUser(UserInfo user) {

		return userManaDAOImpl.insertUser(user);
	}

	public boolean deleteUser(String eno) {

		return userManaDAOImpl.deleteUser(eno);
	}

	public List findUserbyname(String name) {
		return userManaDAOImpl.findUserbyname(name);
	}

	public boolean updateUser(UserInfo user) {

		return userManaDAOImpl.updateUser(user);
	}

	public boolean ispwd(String username, String oldpwd) {

		return userManaDAOImpl.ispwd(username, oldpwd);
	}

	public boolean changepwd(String username, String newpwd) {

		return userManaDAOImpl.changepwd(username, newpwd);
	}

	public String competence(String userName) {
		return userManaDAOImpl.competence(userName);
	}

}
