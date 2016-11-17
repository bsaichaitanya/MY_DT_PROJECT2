package com.niit.collaborationBackEnd.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.collaborationBackEnd.dao.R_UserDAO;
import com.niit.collaborationBackEnd.model.R_User;

@RestController
public class R_UserController {

	Logger log = LoggerFactory.getLogger(R_UserController.class);

	@Autowired
	R_UserDAO r_UserDAO;

	@Autowired
	R_User r_User;

	@GetMapping("/r_User")
	public ResponseEntity<List<R_User>> listUser() {
		log.debug("////////////////In listUser method////////////////////");
		List<R_User> list = r_UserDAO.list();

		if (list.isEmpty()) {
			log.debug("////////////////////list is empty////////////////////");
			return new ResponseEntity<List<R_User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<R_User>>(HttpStatus.OK);
	}

	@PostMapping("/createUser")
	public ResponseEntity<R_User> createUser(@RequestBody R_User r_User) {
		log.debug("//////////////////in create user method//////////////");
		if (r_UserDAO.getUser(r_User.getUser_id()) == null) {
			r_UserDAO.save(r_User);
			return new ResponseEntity<R_User>(HttpStatus.OK);
		} else {
			r_User.setErrorMessage("userId exists");
			log.debug("//////user id already exist" + r_User.getUser_id());
			return new ResponseEntity<R_User>(HttpStatus.OK);
		}

	}

	@PutMapping(value = "/user/{id}")
	public ResponseEntity<R_User> updateUser(@PathVariable("id") String id, @RequestBody R_User r_User) {
		log.debug("//////////in update method");
		if (r_UserDAO.getUser(id) == null) {
			r_User.setErrorMessage("user Does Not Exist");
			log.debug("///////userId doest not exist//////////");
			return new ResponseEntity<R_User>(HttpStatus.NO_CONTENT);
		}

		r_UserDAO.update(r_User);
		log.debug("////////////updated///////");
		return new ResponseEntity<R_User>(HttpStatus.OK);

	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<R_User> getUser(@PathVariable("id") String id) {
		log.debug("////////////Starting of getUser() method/////////////////////");
		R_User r_User = r_UserDAO.getUser(id);
		if (r_User == null) {
			r_User = new R_User();
			r_User.setErrorMessage("User does not exist with id : " + id);
			log.error("User does not exist with id : " + id);
			return new ResponseEntity<R_User>(r_User, HttpStatus.NOT_FOUND);
		}
		log.debug("////////////////////End of getUser() method///////////////////////");
		return new ResponseEntity<R_User>(r_User, HttpStatus.OK);
	}

	@PostMapping(value = "/user/login")
	public ResponseEntity<R_User> login(@RequestBody R_User r_User, HttpSession session) {
		log.debug("////////////////Starting of login() method/////////////////////////");
		r_User = r_UserDAO.authenicate(r_User.getUser_id(), r_User.getPassword());
		if (r_User == null) {
			r_User = new R_User(); // we need to create new r_User object to set
									// errorMsg and errorCode...
			r_User.setErrorCode("404");
			r_User.setErrorMessage("Invalid userId or password...");
			log.error("Invalid userId or password...");
		} else {
			session.setAttribute("loggedInUser", r_User);
			session.setAttribute("loggedInUserID", r_User.getUser_id());
		}
		log.debug("////////////End of login() method/////////////");
		return new ResponseEntity<R_User>(r_User, HttpStatus.OK);
	}

	@GetMapping(value = "/user/logout")
	public ResponseEntity<R_User> logout(HttpSession session) {
		log.debug("**********Starting of logout() method.");

		String userId = (String) session.getAttribute("loggedInUserID");

		log.debug("////////////" + userId + "/////////////");

		session.invalidate();
		log.debug("//////////////////End of logout() method//////////////");
		return new ResponseEntity<R_User>(HttpStatus.OK);
	}

}
