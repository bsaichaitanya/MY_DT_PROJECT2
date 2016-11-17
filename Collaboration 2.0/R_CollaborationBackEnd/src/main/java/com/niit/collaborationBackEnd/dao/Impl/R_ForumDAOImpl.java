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
import com.niit.collaborationBackEnd.dao.R_ForumDAO;
import com.niit.collaborationBackEnd.model.R_Forum;


@Repository("r_ForumDAO")
@EnableTransactionManagement
public class R_ForumDAOImpl implements R_ForumDAO {
Logger log=LoggerFactory.getLogger(R_ForumDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(R_Forum r_Forum) {
		try {
			log.debug("///////////////start of  save method/////////////");
			sessionFactory.getCurrentSession().save(r_Forum);
			log.debug("///////////////end of  save method/////////////");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(R_Forum r_Forum) {
		try {
			log.debug("///////////////start of  update method/////////////");
			sessionFactory.getCurrentSession().update(r_Forum);
			log.debug("///////////////end of  update method/////////////");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean delete(R_Forum r_Forum) {
		try {
			log.debug("///////////////start of  delete method/////////////");
			sessionFactory.getCurrentSession().delete(r_Forum);
			log.debug("///////////////end of  delete method/////////////");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public R_Forum getForum(String forum_id) {
		log.debug("/////getForum by id"+forum_id+"///////////");
		// select *from R_Forum where id='r_Forum_id'
		String hql = "from R_Forum where id=" + "'" +forum_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<R_Forum> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public List<R_Forum> list() {
		log.debug("///////////////list method////////////////////");
		String hql = "from R_Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
