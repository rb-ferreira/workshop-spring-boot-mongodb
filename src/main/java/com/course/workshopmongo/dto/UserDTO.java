package com.course.workshopmongo.dto;

import java.io.Serializable;
import java.util.Optional;

import com.course.workshopmongo.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	
	public UserDTO(Optional<User> obj) {
		
		id = obj.get().getId();
		name = obj.get().getName();
		email = obj.get().getEmail();
		
		
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
