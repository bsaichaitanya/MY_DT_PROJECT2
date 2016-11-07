package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_Forum;

@Repository
public interface R_ForumDAO {
	public	boolean save(R_Forum forum);
	public boolean update(R_Forum forum);
	public boolean delete(R_Forum forum);
	public R_Forum getForum(String forum_id);
	public List<R_Forum> list();	
}
