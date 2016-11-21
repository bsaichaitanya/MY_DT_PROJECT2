package com.niit.collaborationBackEnd.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationBackEnd.dao.R_ForumCommentDAO;
import com.niit.collaborationBackEnd.model.R_Event;
import com.niit.collaborationBackEnd.model.R_ForumComment;

@Repository(value="R_ForumCommentDAO")
@EnableTransactionManagement
public class R_ForumCommentDAOImpl implements R_ForumCommentDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean save(R_ForumComment f_comment) {
		try {
			sessionFactory.getCurrentSession().save(f_comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(R_ForumComment f_comment) {
		try {
			sessionFactory.getCurrentSession().update(f_comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(R_ForumComment f_comment) {
		try {
			sessionFactory.getCurrentSession().delete(f_comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public R_ForumComment getForumComment(String f_com_id) {
		String hql = "from R_ForumComment where id=" + "'" + f_com_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<R_ForumComment> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<R_ForumComment> list() {

		String hql = "from R_ForumComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	
	}

}
