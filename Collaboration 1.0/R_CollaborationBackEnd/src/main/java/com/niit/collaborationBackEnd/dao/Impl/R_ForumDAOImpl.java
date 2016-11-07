package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaborationBackEnd.dao.R_ForumDAO;
import com.niit.collaborationBackEnd.model.R_Forum;


@Repository("R_ForumDAO")
@EnableTransactionManagement
public class R_ForumDAOImpl implements R_ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(R_Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(R_Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean delete(R_Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public R_Forum getForum(String forum_id) {
		// select *from R_Forum where id='forum_id'
		String hql = "from R_Forum where id=" + "'" + forum_id + "'";
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
		String hql = "from R_Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
