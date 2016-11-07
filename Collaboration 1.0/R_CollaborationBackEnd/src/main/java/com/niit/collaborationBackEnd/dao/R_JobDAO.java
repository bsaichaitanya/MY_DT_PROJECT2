package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_Job;

@Repository
public interface R_JobDAO {
	public	boolean save(R_Job job);
	public boolean update(R_Job job);
	public boolean delete(R_Job job);
	public R_Job getJob(String job_id);
	public List<R_Job> list();	
}
