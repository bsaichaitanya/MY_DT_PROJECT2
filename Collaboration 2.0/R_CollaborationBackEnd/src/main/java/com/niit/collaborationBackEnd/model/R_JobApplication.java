package com.niit.collaborationBackEnd.model;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_JobApplication {
	
	private String job_app_id;
	private String job_id;
	private String job_app_status;
	private String user_id;
	
	
	public String getJob_app_id() {
		return job_app_id;
	}
	public void setJob_app_id(String job_app_id) {
		this.job_app_id = job_app_id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_app_status() {
		return job_app_status;
	}
	public void setJob_app_status(String job_app_status) {
		this.job_app_status = job_app_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
