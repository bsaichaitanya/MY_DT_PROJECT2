package com.niit.collaborationBackEnd.model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_BlogComment {
	
	private String b_com_id;
	private String b_com_msg;
	private Date b_com_date;
	private String user_id;
	private String blog_id;
	
	
	public String getB_com_id() {
		return b_com_id;
	}
	public void setB_com_id(String b_com_id) {
		this.b_com_id = b_com_id;
	}
	public String getB_com_msg() {
		return b_com_msg;
	}
	public void setB_com_msg(String b_com_msg) {
		this.b_com_msg = b_com_msg;
	}
	public Date getB_com_date() {
		return b_com_date;
	}
	public void setB_com_date(Date b_com_date) {
		this.b_com_date = b_com_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	
	
	
	

}
