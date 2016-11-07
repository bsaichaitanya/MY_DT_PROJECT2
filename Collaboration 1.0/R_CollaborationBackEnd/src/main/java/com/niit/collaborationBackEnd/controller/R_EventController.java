package com.niit.collaborationBackEnd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationBackEnd.dao.R_EventDAO;
import com.niit.collaborationBackEnd.model.R_Event;
@RestController
public class R_EventController {
	@Autowired
	R_EventDAO eventDAO;

	@GetMapping(value = "/events")
	public ResponseEntity<List<R_Event>> eventList() {
		// to get event list
		List<R_Event> eventList = eventDAO.list();
		if (eventList == null) {
			return new ResponseEntity<List<R_Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<R_Event>>(HttpStatus.OK);
	}

	@PostMapping(value = "/event/")
	// to create a event
	public ResponseEntity<R_Event> createEvent(@RequestBody R_Event event, HttpSession session) {
		String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		event.setUser_id(loggedInUserID);
		eventDAO.save(event);
		return new ResponseEntity<R_Event>(event, HttpStatus.OK);
	}

	@DeleteMapping(value = "/event/{event_id}")
	public ResponseEntity<R_Event> deleteEvent(@PathVariable("event_id") String id) {
		// to delete a particular event
		R_Event event = eventDAO.getEvent(id);
		if (event == null) {
			event = new R_Event();
			event.setErrorMessage("No event exist with id : " + id);
			return new ResponseEntity<R_Event>(event, HttpStatus.NOT_FOUND);
		}
		eventDAO.delete(event);
		return new ResponseEntity<R_Event>(HttpStatus.OK);
	}

	@PutMapping(value = "/event/{event_id}")
	public ResponseEntity<R_Event> updateEvent(@PathVariable("event_id") String id, @RequestBody R_Event event) {
		// too update a particular event
		if (eventDAO.getEvent(id) == null) {
			event = new R_Event();
			event.setErrorMessage("No event exist with id : " + id);
			return new ResponseEntity<R_Event>(event, HttpStatus.NOT_FOUND);
		}
		eventDAO.update(event);
		return new ResponseEntity<R_Event>(event, HttpStatus.OK);
	}

	@GetMapping(value = "/event/{id}")
	public ResponseEntity<R_Event> getEvent(@PathVariable("id") String id) {
		// to get a particular event
		R_Event event = eventDAO.getEvent(id);
		if (event == null) {
			event = new R_Event();
			event.setErrorMessage("No event exist with id : " + id);
			return new ResponseEntity<R_Event>(event, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<R_Event>(event, HttpStatus.OK);
	}
}
