package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationBackEnd.dao.R_EventDAO;
import com.niit.collaborationBackEnd.model.R_Event;

@Repository("R_EventDAO")
@EnableTransactionManagement
public class R_EventDAOImpl implements R_EventDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(R_Event event) {
		try {
			sessionFactory.getCurrentSession().save(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(R_Event event) {
		try {
			sessionFactory.getCurrentSession().update(event);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean delete(R_Event event) {
		try {
			sessionFactory.getCurrentSession().delete(event);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public R_Event getEvent(String event_id) {
		// select *from R_Event where id='event_id'
		String hql = "from R_Event where id=" + "'" + event_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<R_Event> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public List<R_Event> list() {
		String hql = "from R_Event";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
