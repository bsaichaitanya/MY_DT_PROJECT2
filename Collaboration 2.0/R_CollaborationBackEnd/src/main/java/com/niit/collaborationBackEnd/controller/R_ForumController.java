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

import com.niit.collaborationBackEnd.dao.R_ForumDAO;
import com.niit.collaborationBackEnd.model.R_Forum;

@RestController
public class R_ForumController {
	@Autowired
	R_ForumDAO forumDAO;

	@GetMapping(value = "/forums")
	public ResponseEntity<List<R_Forum>> forumList() {
		// to get forum list
		List<R_Forum> forumList = forumDAO.list();
		if (forumList == null) {
			return new ResponseEntity<List<R_Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<R_Forum>>(HttpStatus.OK);
	}

	@PostMapping(value = "/forum/")
	// to create a forum
	public ResponseEntity<R_Forum> createForum(@RequestBody R_Forum forum, HttpSession session) {
		String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		forum.setUser_id(loggedInUserID);
		forumDAO.save(forum);
		return new ResponseEntity<R_Forum>(forum, HttpStatus.OK);
	}

	@DeleteMapping(value = "/forum/{forum_id}")
	public ResponseEntity<R_Forum> deleteForum(@PathVariable("forum_id") String id) {
		// to delete a particular forum
		R_Forum forum = forumDAO.getForum(id);
		if (forum == null) {
			forum = new R_Forum();
			forum.setErrorMessage("No forum exist with id : " + id);
			return new ResponseEntity<R_Forum>(forum, HttpStatus.NOT_FOUND);
		}
		forumDAO.delete(forum);
		return new ResponseEntity<R_Forum>(HttpStatus.OK);
	}

	@PutMapping(value = "/forum/{forum_id}")
	public ResponseEntity<R_Forum> updateForum(@PathVariable("forum_id") String id, @RequestBody R_Forum forum) {
		// too update a particular forum
		if (forumDAO.getForum(id) == null) {
			forum = new R_Forum();
			forum.setErrorMessage("No forum exist with id : " + id);
			return new ResponseEntity<R_Forum>(forum, HttpStatus.NOT_FOUND);
		}
		forumDAO.update(forum);
		return new ResponseEntity<R_Forum>(forum, HttpStatus.OK);
	}

	@GetMapping(value = "/forum/{id}")
	public ResponseEntity<R_Forum> getForum(@PathVariable("id") String id) {
		// to get a particular forum
		R_Forum forum = forumDAO.getForum(id);
		if (forum == null) {
			forum = new R_Forum();
			forum.setErrorMessage("No forum exist with id : " + id);
			return new ResponseEntity<R_Forum>(forum, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<R_Forum>(forum, HttpStatus.OK);
	}
}
