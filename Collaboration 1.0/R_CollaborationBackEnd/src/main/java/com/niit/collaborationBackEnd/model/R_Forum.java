package com.niit.collaborationBackEnd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_Forum extends R_BaseDomain implements Serializable {
	 public R_Forum() {
		this.forum_id="FORUM"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
  private static final long serialVersionUID = 1L;
	@Id
	private String forum_id;
	private String forum_topic;
	private String user_id;
	private Date forum_post_date;
	
	
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_topic() {
		return forum_topic;
	}
	public void setForum_topic(String forum_topic) {
		this.forum_topic = forum_topic;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getForum_post_date() {
		return forum_post_date;
	}
	public void setForum_post_date(Date forum_post_date) {
		this.forum_post_date = forum_post_date;
	}
	
	
	
	
	

}
