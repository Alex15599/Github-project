package com.niuys.gdzc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niuys.gdzc.dao.IEmployeeDAO;
import com.niuys.gdzc.model.Comployee;

public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	//分页显示员工信息
	public List findPageEmployee(int pageStartRow, int pageCount) {
		List list = null;
		String hql = "from Comployee";
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

	public List showAllEmployee() {
		List list = null;
		String hql = "from Comployee";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List showAlldept() {
		List list = null;
		String hql = "from Department";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean insertEmployee(Comployee comp) {
		boolean flag=false;
		Session session = this.getSession();
		try {
			session.save(comp);	
			flag=true;
		} catch (Exception e) {
			
		}
		return flag;	
	}

	public boolean deleteEmployee(String eno) {
		boolean flag=false;
		Session session = this.getSession();
		try {
			Comployee comp = (Comployee)session.load(Comployee.class, eno);
			session.delete(comp);
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List findEmployeebyeno(String eno) {
		List list = null;
		String hql = "from Comployee  where comployeeNo=:eno ";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setString("eno", eno);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean updateEmployee(Comployee com) {
		boolean flag=false;
		Session session = this.getSession();
		try {
			session.update(com);	
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}

	public boolean isEmployeebyno(String eno) {
		boolean flag=false;
		List list=new ArrayList();
		String hql = "from Comployee  where comployeeNo=:eno ";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setString("eno", eno);
			list = query.list();
			if(list.size()!=0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean isEmployeebyname(String name) {
		boolean flag=false;
		List list=new ArrayList();
		String hql = "from Comployee  where comployeeName=:name ";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setString("name", name);
			list = query.list();
			if(list.size()==0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
