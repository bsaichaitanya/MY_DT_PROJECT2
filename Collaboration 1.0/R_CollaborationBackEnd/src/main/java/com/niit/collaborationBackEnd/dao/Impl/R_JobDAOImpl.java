package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaborationBackEnd.dao.R_JobDAO;
import com.niit.collaborationBackEnd.model.R_Job;


@Repository("R_JobDAO")
@EnableTransactionManagement
public class R_JobDAOImpl implements R_JobDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	
@Transactional
public boolean save(R_Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(R_Job job) {
	try {
		sessionFactory.getCurrentSession().update(job);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(R_Job job) {
	try {
		sessionFactory.getCurrentSession().delete(job);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public R_Job getJob(String job_id) {
		String hql="from R_Job where id="+"'"+job_id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<R_Job> list=query.list();
		if(!list.isEmpty() && list!=null){
			return list.get(0);
		}else{
			return  null;
		}
	}
@Transactional
	public List<R_Job> list() {
		String hql="from R_Job";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}

}
