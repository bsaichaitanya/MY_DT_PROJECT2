package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationBackEnd.dao.R_EventDAO;
import com.niit.collaborationBackEnd.model.R_Event;

@Repository(value="r_EventDAO")
@EnableTransactionManagement
public class R_EventDAOImpl implements R_EventDAO {
	Logger log=LoggerFactory.getLogger(R_EventDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(R_Event event) {
		try {
			log.debug("////////////////start of Event save method////////////////");
			sessionFactory.getCurrentSession().save(event);
			log.debug("//////////////////END OF EVENT SAVE METHOD//////////////");
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
			log.debug("////////////////update method start///////////////////");
			sessionFactory.getCurrentSession().update(event);
			log.debug("////////////////////update method end//////////////////");
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
			log.debug("////////////////////delete method start//////////////////");
			sessionFactory.getCurrentSession().delete(event);
			log.debug("////////////////////delete method end//////////////////");
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
		log.debug("////////////////////get event  method by id start//////////////////");
		String hql = "from R_Event where id=" + "'" + event_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<R_Event> list = query.list();
		log.debug("////////////////////get event  method by id end//////////////////");
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public List<R_Event> list() {
		log.debug("////////////////////list  method start//////////////////");
		String hql = "from R_Event";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("////////////////////list  method end//////////////////");
		return query.list();
	}

}
