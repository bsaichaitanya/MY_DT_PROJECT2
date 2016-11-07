package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_ForumComment;


@Repository
public interface R_ForumCommentDAO {
	public	boolean save(R_ForumComment f_comment);
	public boolean update(R_ForumComment f_comment);
	public boolean delete(R_ForumComment f_comment);
	public R_ForumComment getForumComment(String f_com_id);
	public List<R_ForumComment> list();	
}
