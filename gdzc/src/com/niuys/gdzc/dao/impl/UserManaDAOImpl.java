package com.niuys.gdzc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niuys.gdzc.dao.IUserManaDAO;
import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.UserInfo;

public class UserManaDAOImpl implements IUserManaDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List findPageUsers(int pageStartRow, int pageCount) {
		List list = new ArrayList();
		String hql = "from UserInfo";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult(pageStartRow);
			query.setMaxResults(pageCount);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List showAllUsers() {
		List list = new ArrayList();
		String hql = "from UserInfo";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertUser(UserInfo user) {
		boolean flag=false;
		Session session = this.getSession();
		try {
			session.save(user);	
			flag=true;
		} catch (Exception e) {
			
		}
		return flag;	
	}

	public boolean deleteUser(String eno) {
		boolean flag=false;
		Session session = this.getSession();
		try {
			UserInfo user = (UserInfo)session.load(UserInfo.class, eno);
			session.delete(user);
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return flag;
	}

	public List findUserbyname(String name) {
		List list = new ArrayList();
		String hql = "from UserInfo  where userName=:name ";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setString("name", name);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateUser(UserInfo user) {
		boolean flag=false;
		Session session = this.getSession();	
		String hql="update UserInfo set competence=:competence where userName=:name";
		try {
			Query query = session.createQuery(hql);
			query.setString("competence", user.getCompetence());
			query.setString("name", user.getUserName());
			query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}

	public boolean ispwd(String username, String oldpwd) {
		boolean flag=false;
		Session session = this.getSession();		
		String hql="select pwd from UserInfo where userName=:username";
		try {
			Query query = session.createQuery(hql);
			query.setString("username", username);
			
			String pwd=(String)query.setMaxResults(1).uniqueResult();		
			if(oldpwd.equals(pwd)){
				flag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean changepwd(String username, String newpwd) {
		boolean flag=false;
		Session session = this.getSession();		
		String hql="update UserInfo set pwd=:newpwd where userName=:username";
		try {
			Query query = session.createQuery(hql);
			query.setString("newpwd",newpwd);
			query.setString("username", username);
			query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}

	//取用户权限
	public String competence(String userName){
		String competence=null;
		Session session = this.getSession();	
		String sql="select competence from UserInfo where userName=:userName";
		try {
			Query query = session.createQuery(sql);
			query.setString("userName",userName);
			competence=(String)query.setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return competence;	
	}

}
