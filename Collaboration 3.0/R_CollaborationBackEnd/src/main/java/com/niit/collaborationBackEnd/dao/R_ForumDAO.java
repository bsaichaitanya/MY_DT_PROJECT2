package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_Forum;

public interface R_ForumDAO {
	public	boolean save(R_Forum r_Forum);
	public boolean update(R_Forum r_Forum);
	public boolean delete(R_Forum r_Forum);
	public R_Forum getForum(String forum_id);
	public List<R_Forum> list();	
}
