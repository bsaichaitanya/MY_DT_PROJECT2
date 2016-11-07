package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaborationBackEnd.dao.R_BlogDAO;
import com.niit.collaborationBackEnd.model.R_Blog;


@Repository("R_BlogDAO")
@EnableTransactionManagement
public class R_BlogDAOImpl implements R_BlogDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(R_Blog blog) {
		// save method
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(R_Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(R_Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public R_Blog getBlog(String blog_id) {
		// TODO Auto-generated method stub
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
