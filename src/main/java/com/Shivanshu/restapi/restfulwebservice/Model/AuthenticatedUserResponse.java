package com.Shivanshu.restapi.restfulwebservice.Model;

import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserResponse {
	
	String Username;
	Boolean isValid;
	
	public AuthenticatedUserResponse() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticatedUserResponse(String username, Boolean isValid) {
		super();
		Username = username;
		this.isValid = isValid;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	

}
