package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_User;

@Repository
public interface R_UserDAO {
	public	boolean save(R_User user);
	public boolean update(R_User user);
	public boolean delete(R_User user);
	public R_User getUser(String user_id);
	public List<R_User> list();	
	public  R_User authenicate(String user_id, String password);
}
