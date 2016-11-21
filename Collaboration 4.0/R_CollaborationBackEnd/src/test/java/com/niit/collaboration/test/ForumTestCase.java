package com.niit.collaboration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationBackEnd.dao.R_ForumDAO;
import com.niit.collaborationBackEnd.model.R_Forum;


public class ForumTestCase {
	@Autowired
	R_ForumDAO r_ForumDAO;

	@Autowired
	R_Forum r_Forum;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationBackEnd");
		context.refresh();

		r_ForumDAO = (R_ForumDAO) context.getBean("r_ForumDAO");
		r_Forum = (R_Forum) context.getBean("r_Forum");

	}
	
/*@Test
	public void addTest() {
		r_Forum.setForum_topic("Testing");
		r_Forum.setUser_id("roopesh");
		
		assertEquals(r_ForumDAO.save(r_Forum), true);
	}*/
	
	
/*	@Test
	public void updateTest(){
		r_Forum.setForum_id("FORF4089E140D36");
		r_Forum.setForum_topic("Edited");
		r_Forum.setUser_id("roopesh");
		assertEquals(r_ForumDAO.update(r_Forum), true);
	}*/

/*@Test
	public void deleteTest(){
		r_Forum.setForum_id("FOR5810C48F4FB5");
		 assertEquals(r_ForumDAO.delete(r_Forum), true); 
	}*/
	
	
	/*@Test 
	 public void getR_Forum() {
	assertEquals(r_ForumDAO.getForum("EVE7640EB7E03AC").getForum_title(), "Fest"); 
	}	*/
}
