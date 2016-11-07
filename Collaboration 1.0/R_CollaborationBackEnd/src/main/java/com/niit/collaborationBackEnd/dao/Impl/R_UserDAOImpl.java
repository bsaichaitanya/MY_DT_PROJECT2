package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationBackEnd.dao.R_UserDAO;
import com.niit.collaborationBackEnd.model.R_User;


	@Repository("R_UserDAO")
	@EnableTransactionManagement
	public class R_UserDAOImpl implements R_UserDAO {
		@Autowired
		private SessionFactory sessionFactory;

		@Transactional
		public boolean save(R_User user) {
			try {
				sessionFactory.getCurrentSession().save(user);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		@Transactional
		public boolean update(R_User user) {
			try {
				sessionFactory.getCurrentSession().update(user);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		
		@Transactional
		public boolean delete(R_User user) {
			try {
				sessionFactory.getCurrentSession().delete(user);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		@Transactional
		public R_User getUser(String user_id) {
			// select *from R_User where id='user_id'
			String hql = "from R_User where id=" + "'" + user_id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<R_User> list = query.list();
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				return null;
			}
		}

		@Transactional
		public List<R_User> list() {
			String hql = "from R_User";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}

		@Transactional
		public R_User authenicate(String user_id, String password) {	
			//select *from R_User where id='x' and password='x';
		String hql = "from Users where id = '" + user_id + "' and " + "password = '" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<R_User> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
		}
}
