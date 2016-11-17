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
import com.niit.collaborationBackEnd.dao.R_BlogDAO;
import com.niit.collaborationBackEnd.model.R_Blog;

@RestController
public class R_BlogController {
	
	@Autowired
	R_BlogDAO r_BlogDAO;
	@GetMapping(value = "/blogs")
	public ResponseEntity<List<R_Blog>> blogList() {
		// to get blog list
		List<R_Blog>  blogs = r_BlogDAO.list();
		if (blogs.isEmpty()) {
			return new ResponseEntity<List<R_Blog>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("//////////////");
		//log.debug("**********End of listBlogs() method.");
		return new ResponseEntity<List<R_Blog>>(HttpStatus.OK);
	}

	@PostMapping(value = "/blog/")
	// to create a blog
	public ResponseEntity<R_Blog> createBlog(@RequestBody R_Blog blog, HttpSession session) {
		String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		blog.setUser_id(loggedInUserID);
		r_BlogDAO.save(blog);
		return new ResponseEntity<R_Blog>(blog, HttpStatus.OK);
	}

	@DeleteMapping(value = "/blog/{blog_id}")
	public ResponseEntity<R_Blog> deleteBlog(@PathVariable("blog_id") String id) {
		// to delete a particular blog
		R_Blog blog = r_BlogDAO.getBlog(id);
		if (blog == null) {
			blog = new R_Blog();
			blog.setErrorMessage("No blog exist with id : " + id);
			return new ResponseEntity<R_Blog>(blog, HttpStatus.NOT_FOUND);
		}
		r_BlogDAO.delete(blog);
		return new ResponseEntity<R_Blog>(HttpStatus.OK);
	}

	@PutMapping(value = "/blog/{blog_id}")
	public ResponseEntity<R_Blog> updateBlog(@PathVariable("blog_id") String id, @RequestBody R_Blog blog) {
		// too update a particular blog
		if (r_BlogDAO.getBlog(id) == null) {
			blog = new R_Blog();
			blog.setErrorMessage("No blog exist with id : " + id);
			return new ResponseEntity<R_Blog>(blog, HttpStatus.NOT_FOUND);
		}
		r_BlogDAO.update(blog);
		return new ResponseEntity<R_Blog>(blog, HttpStatus.OK);
	}

	@GetMapping(value = "/blog/{id}")
	public ResponseEntity<R_Blog> getBlog(@PathVariable("id") String id) {
		// to get a particular blog
		R_Blog blog = r_BlogDAO.getBlog(id);
		if (blog == null) {
			blog = new R_Blog();
			blog.setErrorMessage("No blog exist with id : " + id);
			return new ResponseEntity<R_Blog>(blog, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<R_Blog>(blog, HttpStatus.OK);
	}
}