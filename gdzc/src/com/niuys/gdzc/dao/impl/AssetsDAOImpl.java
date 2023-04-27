package com.niuys.gdzc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niuys.gdzc.dao.IAssetsDAO;
import com.niuys.gdzc.model.ZcInfo;

public class AssetsDAOImpl implements IAssetsDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	//��ѯ�����ʲ��������ܼ�¼��
	public List showAllAssets() {
		List list = new ArrayList();
		String hql = "from ZcInfo c order by c.zcId desc";
		Session session = this.getSession();
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//���ط�ҳ��ʾ
	public List findPageAssets(int pageStartRow, int pageCount) {
		List list = null;
		String hql = "from ZcInfo c";
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
	
	//���ID���Ƿ����
	public boolean checkZCID(String zcId){
		boolean flag=false;
		Session session = this.getSession();
		String sql = "select zcName from ZcInfo c where zcId=:zcId";
		try {
			Query query = session.createQuery(sql);
			query.setString("zcId", zcId);
			String zc_name = (String) query.setMaxResults(1).uniqueResult();
			if (zc_name==null) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;		
	}

	//����ʲ�
	public boolean addAssets(ZcInfo zcinfo){
		boolean flag=false;
		Session session = this.getSession();
		try {
			session.save(zcinfo);	
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//��ȡһ����Ʒ����ϸ��Ϣ
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
	
	//�����޸��ʲ���Ϣ
	public void saveUpdate(ZcInfo zcinfo){
		boolean flag=false;
		Session session = this.getSession();
		try {
			session.update(zcinfo);	
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ɾ���ʲ�
	public boolean deleteAsset(String zcId){
		boolean flag=false;
		Session session = this.getSession();
		try {
			ZcInfo zc = (ZcInfo)session.get(ZcInfo.class, zcId);
			session.delete(zc);
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;	
	}
	
	//����������ѯ�ʲ�
	public List checkZC(String zcId,String zcFactory,String zcNo,
							String zcName,String zcType,String zcStatus,
							String zcBuyer){
		List list=null;
		Session session = this.getSession();
		String sql = "from ZcInfo where zcId=:zcId or zcNo=:zcNo or zcName=:zcName or zcType=:zcType or zcStatus=:zcStatus or zcFactory=:zcFactory or zcBuyer=:zcBuyer";					
		try {
			Query query = session.createQuery(sql);
			query.setString("zcId", zcId);
			query.setString("zcNo", zcNo);
			query.setString("zcName", zcName);
			query.setString("zcType", zcType);
			query.setString("zcStatus", zcStatus);
			query.setString("zcBuyer", zcBuyer);
			query.setString("zcFactory", zcFactory);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;	
	}
}
