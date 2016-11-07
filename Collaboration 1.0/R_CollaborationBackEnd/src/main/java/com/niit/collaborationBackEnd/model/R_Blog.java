package com.niit.collaborationBackEnd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_Blog extends R_BaseDomain implements Serializable {
	 public R_Blog() {
		this.blog_id="BLOG"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
    private static final long serialVersionUID = 1L;
	@Id
	private String blog_id;
	private String blog_title;
	private String user_id;
	private Date blog_post_date;
	private String blog_content;
	private String blog_status;
	private String blog_reason;
	
	
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBlog_status() {
		return blog_status;
	}
	public void setBlog_status(String blog_status) {
		this.blog_status = blog_status;
	}
	public String getBlog_reason() {
		return blog_reason;
	}
	public void setBlog_reason(String blog_reason) {
		this.blog_reason = blog_reason;
	}

	public Date getBlog_post_date() {
		return blog_post_date;
	}
	public void setBlog_post_date(Date blog_post_date) {
		this.blog_post_date = blog_post_date;
	}
	public String getBlog_content() {
		return blog_content;
	}
	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}
	
	
	
}
