package com.niuys.gdzc.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niuys.gdzc.dao.IInOutAssetsDAO;
import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcInout;

public class InOutAssetsDAOImpl implements IInOutAssetsDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//�����ѽ�����ʲ�
	public List showLendAssets(){
		List list = null;
		String hql = "from ZcInout";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	//��ҳ��ʾ�ѽ���ʲ�
	public List findPageLendAssets(int pageStartRow, int pageCount) {
		List list = null;
		String hql = "from ZcInout";
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
	
	//��ѯ���ʲ���Ա����Ϣ
	public Comployee getOneEmployee(String comployeeNo){
		Comployee comployee=new Comployee();
		Session session = this.getSession();
		String sql = "from Comployee c where comployeeNo=:comployeeNo";
		try {
			Query query = session.createQuery(sql);
			query.setString("comployeeNo", comployeeNo);
			comployee= (Comployee) query.setMaxResults(1).uniqueResult();		
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return comployee;	
	}
	
	//��ѯ����ʲ�����ϸ��Ϣ
		public ZcInfo getOneZc(String zcId){
			ZcInfo zcinfo=new ZcInfo();
			Session session = this.getSession();
			String sql = "from ZcInfo c where zcId=:zcId";
			try {
				Query query = session.createQuery(sql);
				query.setString("zcId", zcId);
				zcinfo= (ZcInfo) query.setMaxResults(1).uniqueResult();		
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return zcinfo;		
		}

		//�黹�ѽ�����ʲ�
		public boolean backZC(String inoutNo, String zcId) {
			boolean flag=false;
			SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
			formatter.applyPattern("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			String backTime = formatter.format(cal.getTime());
			System.out.println(backTime);
			
			String sql1="update ZcInout set backTime=:backTime where inoutNo=:inoutNo";		
			String sql2="update ZcInfo set zcStatus='����' where zcId=:zcId";
			
			Session session = this.getSession();
			
			try {
				Query query1 = session.createQuery(sql1);
				query1.setString("inoutNo", inoutNo);
				query1.setString("backTime", backTime);
				query1.executeUpdate();
				Query query2 = session.createQuery(sql2);
				query2.setString("zcId", zcId);
				query2.executeUpdate();
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return flag;
		}
		
		//��ѯ�ʲ���״̬
		public String zcStatus(String zcId){
			String status="";
			Session session = this.getSession();
			String sql = "select zcStatus from ZcInfo c where zcId=:zcId";
			try {
				Query query = session.createQuery(sql);
				query.setString("zcId", zcId);
				status=(String) query.setMaxResults(1).uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return status;
		}

		//����ʲ�
		public boolean outZC(ZcInout inout,String zcId) {
			boolean flag=false;
			Session session = this.getSession();		
			String sql="update ZcInfo set zcStatus='���' where zcId=:zcId";			
			try {
				session.save(inout);
				Query query = session.createQuery(sql);
				query.setString("zcId", zcId);
				query.executeUpdate();
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return flag;
		}

		public List ZCInOut(ZcInout inout){
			List list=new ArrayList();
			Session session = this.getSession();
			String comployeeNo=inout.getComployeeNo();
			String zcId=inout.getZcInfo().getZcId();
			String sql = "from ZcInout where zcInfo.zcId=:zcId or comployeeNo=:comployeeNo";					
			try {
				Query query = session.createQuery(sql);
				query.setString("zcId", zcId);
				query.setString("comployeeNo", comployeeNo);
				list = query.list();
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return list;	
		}	
}
