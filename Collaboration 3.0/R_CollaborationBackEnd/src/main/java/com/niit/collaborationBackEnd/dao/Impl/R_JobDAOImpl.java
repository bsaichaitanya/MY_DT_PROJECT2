package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaborationBackEnd.dao.R_JobDAO;
import com.niit.collaborationBackEnd.model.R_Job;


@Repository(value="r_JobDAO")
@EnableTransactionManagement
public class R_JobDAOImpl implements R_JobDAO{
	Logger log=LoggerFactory.getLogger(R_JobDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	
@Transactional
public boolean save(R_Job r_Job) {
		try {
			log.debug("//////////////////start of save method//////////////////");
			sessionFactory.getCurrentSession().save(r_Job);
			log.debug("/////////////////////end of save method//////////");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


@Transactional
	public boolean update(R_Job r_Job) {
	try {
		sessionFactory.getCurrentSession().update(r_Job);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(R_Job r_Job) {
	try {
		sessionFactory.getCurrentSession().delete(r_Job);
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
