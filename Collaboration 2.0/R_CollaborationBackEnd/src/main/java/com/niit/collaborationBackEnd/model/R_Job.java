package com.niit.collaborationBackEnd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_Job extends R_BaseDomain implements Serializable {
	 public R_Job() {
		this.job_id="JOB"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
 private static final long serialVersionUID = 1L;
	@Id
	private String job_id;
	private String job_details;
	private String job_title;
	//private Date job_post_date;
	//private Date job_lastdate_apply;
	private String user_id;
	private String job_status;
	
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_details() {
		return job_details;
	}
	public void setJob_details(String job_details) {
		this.job_details = job_details;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
/*	public Date getJob_post_date() {
		return job_post_date;
	}
	public void setJob_post_date(Date job_post_date) {
		this.job_post_date = job_post_date;
	}
	public Date getJob_lastdate_apply() {
		return job_lastdate_apply;
	}
	public void setJob_lastdate_apply(Date job_lastdate_apply) {
		this.job_lastdate_apply = job_lastdate_apply;
	}*/
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}

	
	
	
	
	

}
