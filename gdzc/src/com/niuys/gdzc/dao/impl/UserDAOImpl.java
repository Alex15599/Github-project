package com.niuys.gdzc.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niuys.gdzc.dao.IUserDAO;

public class UserDAOImpl implements IUserDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean login(String userName, String password) {
		boolean flag = false;
		Session session = this.getSession();
		String hql = "select pwd from UserInfo where userName=:userName";
		try {
			Query query = session.createQuery(hql);
			query.setString("userName", userName);
			String pwd = (String) query.setMaxResults(1).uniqueResult();
			if (password.equals(pwd)) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
