	package com.niit.collaboration.test;

	import static org.junit.Assert.*;

	import org.junit.Before;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;
	import com.niit.collaborationBackEnd.dao.R_JobDAO;
	import com.niit.collaborationBackEnd.model.R_Job;

public class JobTestCase {

		@Autowired
		R_JobDAO r_JobDAO;

		@Autowired
		R_Job r_Job;

		AnnotationConfigApplicationContext context;

		@Before
		public void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.collaborationBackEnd");
			context.refresh();

			r_JobDAO = (R_JobDAO) context.getBean("r_JobDAO");
			r_Job = (R_Job) context.getBean("r_Job");

		}
		
	@Test
		public void addTest() {
			r_Job.setJob_details("Testing");
			r_Job.setJob_status("A");
			r_Job.setJob_title("xzxxxxx");
			r_Job.setUser_id("roopesh");
			
			assertEquals(r_JobDAO.save(r_Job), true);
		}
		
		
	/*	@Test
		public void updateTest(){
			r_Job.setJob_id("FORF4089E140D36");
			r_Job.setJob_topic("Edited");
			r_Job.setUser_id("roopesh");
			assertEquals(r_JobDAO.update(r_Job), true);
		}*/

	/*@Test
		public void deleteTest(){
			r_Job.setJob_id("FOR5810C48F4FB5");
			 assertEquals(r_JobDAO.delete(r_Job), true); 
		}*/
		
		
		/*@Test 
		 public void getR_Job() {
		assertEquals(r_JobDAO.getJob("EVE7640EB7E03AC").getJob_title(), "Fest"); 
		}	*/
	}



