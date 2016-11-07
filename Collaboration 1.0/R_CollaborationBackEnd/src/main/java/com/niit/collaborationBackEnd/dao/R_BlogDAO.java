package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_Blog;

@Repository
public interface R_BlogDAO {
		public	boolean save(R_Blog blog);
		public boolean update(R_Blog blog);
		public boolean delete(R_Blog blog);
		public R_Blog getBlog(String blog_id);
		public List<R_Blog> list();	
}
