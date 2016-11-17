package com.niit.collaborationBackEnd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class R_User extends R_BaseDomain implements Serializable{
	
	 public R_User() {
			this.user_id="US"+UUID.randomUUID().toString().substring(24).toUpperCase();
		}
	
	private static final long serialVersionUID = 10L;
	
	@Id
	private String user_id;
	private String user_name;
	private String user_email;
	private String user_address;
	private String user_contact;
	private String user_gender;
	private String user_role;
	private String password;
	//private Date date_of_birth;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_contact() {
		return user_contact;
	}
	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}*/
	
	
	
	
	
	
	
}
