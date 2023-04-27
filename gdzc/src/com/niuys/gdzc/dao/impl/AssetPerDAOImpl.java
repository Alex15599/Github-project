package com.niuys.gdzc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niuys.gdzc.dao.IAssetPerDAO;
import com.niuys.gdzc.model.ZcWx;

public class AssetPerDAOImpl implements IAssetPerDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List findPagePerAssets(int pageStartRow, int pageCount) {
		List list = null;
		String hql = "from ZcWx";
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

	public List showAllPerAssets() {
		List list = null;
		String hql = "from ZcWx";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertPerAssets(ZcWx zcwx) {
		boolean flag=false;
		Session session = this.getSession();
		String zcid=zcwx.getZcInfo().getZcId();
		String sql="update ZcInfo set zcStatus='Î¬ÐÞ' where zcId=:zcId";		
		try {
			session.save(zcwx);	
			Query query = session.createQuery(sql);
			query.setString("zcId", zcid);
			query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			System.out.println("================");
		}
		return flag;	
	}

  	public boolean deletePerAsset(int zcno) {
		boolean flag=false;
		Session session = this.getSession();
		String hql = "delete from ZcWx where repairNo=:zcno";
		try {
			Query query = session.createQuery(hql);
			query.setInteger("zcno", zcno);
			query.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}


	public List findPerAssetbyid(int zcno) {
		List list = null;
		String hql = "from ZcWx c where c.repairNo=:zcno ";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setInteger("zcno", zcno);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public boolean updatePerAsset(ZcWx zcwx) {
		boolean flag=false;
		Session session = this.getSession();
		try {
			session.update(zcwx);	
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}

	public List findPerAssetbyPro(String sendtime,int no, String login_user, 
			String sender, String wx_result) {
		List list = null;
		String hql = "from ZcWx  where sendTime=:sendtime or repairNo=:zcno or loginUser=:login_user or sender=:sender or wx_result=:wx_result";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setInteger("zcno", no);
			query.setString("sendtime", sendtime);
			query.setString("login_user", login_user);
			query.setString("sender", sender);
			query.setString("wx_result", wx_result);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	


}
