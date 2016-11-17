package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaborationBackEnd.dao.R_BlogDAO;
import com.niit.collaborationBackEnd.model.R_Blog;

@Repository(value = "r_BlogDAO")
@EnableTransactionManagement
public class R_BlogDAOImpl implements R_BlogDAO {
	private static final Logger log = LoggerFactory.getLogger(R_BlogDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(R_Blog r_Blog) {
		// save method
		try {
			log.info("////////////////////Start of save method/////////////////");
			r_Blog.setBlog_status("N"); // N = New, R = Rejected, A = Approved
			sessionFactory.getCurrentSession().save(r_Blog);
			log.info("/////////////end of save method//////////////");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(R_Blog r_Blog) {
		// TODO Auto-generated method stub
		try {
			log.debug("/////////////////////////////start of update method/////////////////");
			sessionFactory.getCurrentSession().update(r_Blog);
			log.debug("//////////////////////end of update method////////////////////////////");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(R_Blog r_Blog) {
		// TODO Auto-generated method stub
		try {
			log.debug("///////////////////start of blog delete method/////////////////");
			sessionFactory.getCurrentSession().delete(r_Blog);
			log.debug("///////////////////end of blog delete method/////////////////");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public R_Blog getBlog(String blog_id) {
		log.debug("//////////////////get Blog by blog_id/////////////////");
		String hql = " from R_Blog where id =" + "'" + blog_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<R_Blog> list = (List<R_Blog>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public List<R_Blog> list() {
		// TODO Auto-generated method stub
		String hql = "from R_Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
