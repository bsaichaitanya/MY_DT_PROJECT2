package com.niit.collaborationBackEnd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_Event extends R_BaseDomain implements Serializable {
	 public R_Event() {
		this.event_id="EVENT"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
   private static final long serialVersionUID = 1L;
	@Id
	private String event_id;
	private String event_title;
	private String event_description;
	private String event_venue;
	private Date event_date;
	private String user_id;
	private Date event_post_date;
	
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public String getEvent_venue() {
		return event_venue;
	}
	public void setEvent_venue(String event_venue) {
		this.event_venue = event_venue;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getEvent_post_date() {
		return event_post_date;
	}
	public void setEvent_post_date(Date event_post_date) {
		this.event_post_date = event_post_date;
	}
	
	
}
