package com.niit.collaborationBackEnd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationBackEnd.dao.R_JobDAO;
import com.niit.collaborationBackEnd.model.R_Job;

@RestController
public class R_JobController {
	Logger log=LoggerFactory.getLogger(R_JobController.class);
	
	@Autowired
	R_Job r_Job;
	
	@Autowired
	R_JobDAO r_JobDAO;
	
	
@GetMapping("/jobs")
public ResponseEntity<List<R_Job>> getAllJobs(){
	List<R_Job> jobs=r_JobDAO.list();
	if(jobs==null){
		return new ResponseEntity<List<R_Job>>(HttpStatus.NO_CONTENT);	
	}
	return new ResponseEntity<List<R_Job>>(HttpStatus.OK);
}

	
	
	
	
	
	
	
	
	
}
