package com.niit.collaborationBackEnd.model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_ForumComment {
	
	private String f_com_id;
	private String f_com_msg;
	private Date f_com_date;
	private String user_id;
	private String forum_id;
	
	
	public String getF_com_id() {
		return f_com_id;
	}
	public void setF_com_id(String f_com_id) {
		this.f_com_id = f_com_id;
	}
	public String getF_com_msg() {
		return f_com_msg;
	}
	public void setF_com_msg(String f_com_msg) {
		this.f_com_msg = f_com_msg;
	}
	public Date getF_com_date() {
		return f_com_date;
	}
	public void setF_com_date(Date f_com_date) {
		this.f_com_date = f_com_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	
	
	
}
