package com.niit.collaborationBackEnd.dao;

import java.util.List;

import com.niit.collaborationBackEnd.model.R_Blog;

public interface R_BlogDAO {
		public	boolean save(R_Blog r_Blog);
		public boolean update(R_Blog r_Blog);
		public boolean delete(R_Blog r_Blog);
		public R_Blog getBlog(String blog_id);
		public List<R_Blog> list();	
}
