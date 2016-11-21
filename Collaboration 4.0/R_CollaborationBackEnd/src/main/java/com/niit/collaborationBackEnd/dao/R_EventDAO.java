package com.niit.collaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationBackEnd.model.R_Event;

public interface R_EventDAO {
	public	boolean save(R_Event event);
	public boolean update(R_Event event);
	public boolean delete(R_Event event);
	public R_Event getEvent(String event_id);
	public List<R_Event> list();	
}
