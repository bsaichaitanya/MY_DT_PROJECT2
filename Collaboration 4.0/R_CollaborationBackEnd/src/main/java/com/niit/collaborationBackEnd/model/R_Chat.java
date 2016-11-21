package com.niit.collaborationBackEnd.model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_Chat {

	private String chat_id;
	private String user_id;
	private String friend_id;
	private String chat_msg;
	private Date chat_date_time;
	
	
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}
	public String getChat_msg() {
		return chat_msg;
	}
	public void setChat_msg(String chat_msg) {
		this.chat_msg = chat_msg;
	}
	public Date getChat_date_time() {
		return chat_date_time;
	}
	public void setChat_date_time(Date chat_date_time) {
		this.chat_date_time = chat_date_time;
	}
	
	
}
