package com.niit.collaboration.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationBackEnd.dao.R_EventDAO;
import com.niit.collaborationBackEnd.model.R_Event;


public class EventTestCase {
	@Autowired
	R_EventDAO r_EventDAO;

	@Autowired
	R_Event r_Event;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaborationBackEnd");
		context.refresh();

		r_EventDAO = (R_EventDAO) context.getBean("r_EventDAO");
		r_Event = (R_Event) context.getBean("r_Event");

	}
/*	@Test
	public void addTest() {
		r_Event.setEvent_title("Fest");
		r_Event.setEvent_venue("vizag");
		r_Event.setEvent_description("college Fest");
		r_Event.setUser_id("roopesh");
		//r_Event.setEvent_post_date(event_post_date);
	//	r_Event.setEvent_date(event_date);
		assertEquals(r_EventDAO.save(r_Event), true);
	}*/
	
	
	/*@Test
	public void updateTest(){
		r_Event.setEvent_id("EVEF97519B392FD");
		r_Event.setEvent_venue("vizag");
		r_Event.setEvent_title("Fest");
		r_Event.setEvent_description("college Fest");
		r_Event.setUser_id("roopesh");
		assertEquals(r_EventDAO.update(r_Event), true);
	}*/

/*	@Test
	public void deleteTest(){
		r_Event.setEvent_id("EVEF97519B392FD");
		 assertEquals(r_EventDAO.delete(r_Event), true); 
	}*/
	
	
	/*@Test 
	 public void getR_Event() {
	assertEquals(r_EventDAO.getEvent("EVE7640EB7E03AC").getEvent_title(), "Fest"); 
	}	*/
}
