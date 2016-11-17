package com.niit.collaboration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationBackEnd.dao.R_BlogDAO;
import com.niit.collaborationBackEnd.model.R_Blog;

public class BlogTestCase {

	Logger log = LoggerFactory.getLogger(BlogTestCase.class);

	@Autowired
	R_BlogDAO r_BlogDAO;

	@Autowired
	R_Blog r_Blog;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationBackEnd");
		context.refresh();

		r_BlogDAO = (R_BlogDAO) context.getBean("r_BlogDAO");
		r_Blog = (R_Blog) context.getBean("r_Blog");

	}

	/*@Test
	 public void listR_Blog() {
	 log.debug("Entered in listR_Blog method.........");
	 assertEquals(r_BlogDAO.list().size(), 2);
	 }*/
	 

@Test
	public void addR_Blog() {
		r_Blog.setBlog_title("DUMMY");
		r_Blog.setBlog_reason("Testing ");
		r_Blog.setBlog_content(
				" In Informatics, dummy data is benign information that does not contain any useful data, but serves to reserve space where real data is nominally present. Dummy data can be used as a placeholder for both testing and operational purposes. For testing, dummy data can also be used as stubs or pad to avoid software testing issues by ensuring that all variables and data fields are occupied. In operational use, dummy data may be transmitted for OPSEC purposes. Dummy data must be rigorously evaluated and documented to ensure that it does not cause unintended effects. ");
		r_Blog.setUser_id("Roopesh");
		assertEquals(r_BlogDAO.save(r_Blog), true);
	}

	
/*	 @Test
	 public void updateR_Blog() { 
		 r_Blog.setBlog_id(550);
	 r_Blog.setBlog_title("R_Blog");
	 r_Blog.setBlog_content("This is my first blog using clob");
	  r_Blog.setUser_id("ROOP"); r_Blog.setBlog_status("approved");
	 r_Blog.setBlog_reason("Testing"); 
	 assertEquals(r_BlogDAO.update(r_Blog), true);
	 }*/
	 

/*@Test
	  public void deleteR_Blog(){ 
		r_Blog.setBlog_id(550);
	 assertEquals(r_BlogDAO.delete(r_Blog), true); 
	 }*/
	 
	 
/*	@Test 
	 public void getR_Blog() {
	assertEquals(r_BlogDAO.getBlog("600").getBlog_title(), "DUMMY"); 
	}	 */
	
}
