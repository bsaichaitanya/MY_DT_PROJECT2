package com.niit.collaboration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationBackEnd.dao.R_UserDAO;
import com.niit.collaborationBackEnd.model.R_User;

public class UserTestCase {
	@Autowired
	R_User r_User;
	
	@Autowired
	R_UserDAO r_UserDAO;
	
	AnnotationConfigApplicationContext context;
	
	
	@Before
	public void init(){
context=new AnnotationConfigApplicationContext();
context.scan("com.niit.collaborationBackEnd");
context.refresh();
r_UserDAO=(R_UserDAO) context.getBean("r_UserDAO");	
r_User=(R_User) context.getBean("r_User");

	}

	@Test
	public void addtest() {
		r_User.setUser_email("r@gmail.com");
		r_User.setPassword("xxx");
		r_User.setUser_contact("789456");
		r_User.setUser_gender("M");
		r_User.setUser_address("hyd");
		r_User.setUser_name("roopesh");
		r_User.setUser_role("ROLE_STUDENT");
		//r_User.setDate_of_birth(null);
		assertEquals(r_UserDAO.save(r_User), true);
	}
	
	/*@Test
	public void updatetest() {
		r_User.setUser_email("r@gmail.com");
		r_User.setPassword("xxx");
		r_User.setUser_contact("789456");
		r_User.setUser_gender("M");
		r_User.setUser_address("hyd");
		r_User.setUser_name("roopesh");
		r_User.setUser_role("ROLE_STUDENT");
		//r_User.setDate_of_birth(null);
		assertEquals(r_UserDAO.update(r_User), true);
	}*/
	
/*	@Test
	public void deletetest() {
		r_User.setUser_id("r@gmail.com");
		assertEquals(r_UserDAO.delete(r_User), true);
	}*/
	
	/*@Test
	public void getUserTest(){
		assertEquals(r_UserDAO.getUser("").getUser_name(), "");
	}*/
	
	/*@Test
	public void listTest(){
		assertEquals(r_UserDAO.list().size(), 2);
	}*/
	
}
