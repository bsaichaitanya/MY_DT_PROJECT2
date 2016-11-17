package com.niit.collaborationBackEnd.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class R_Blog extends R_BaseDomain implements Serializable {

	/**
	 * 
	 */
private static final long serialVersionUID = 10L;

	/**
	 *  declare the database column names for Blog... 
	 */
	
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
@SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_AUTO_BLOG_ID")

	private int  blog_id;
	
	private String blog_title;
	
	private String blog_reason;
	
	private String blog_content;
	
	/*@Column(name = "post_date")
	private Date postDate;*/
	/*@Column(name = "user_blog_id")*/
	private String user_id;
		
	private String blog_status;



	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_reason() {
		return blog_reason;
	}

	public void setBlog_reason(String blog_reason) {
		this.blog_reason = blog_reason;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
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
	
	/**
	 *  getters/setters for all the fields taken... 
	 */

	



	/*public Date getPostDate() {
		return postDate;
	}
	public voblog_id setPostDate(Date postDate) {
		this.postDate = postDate;
	}*/

}
