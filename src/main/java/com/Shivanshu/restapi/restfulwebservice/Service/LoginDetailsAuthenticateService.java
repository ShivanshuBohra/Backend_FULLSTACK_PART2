package com.Shivanshu.restapi.restfulwebservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Shivanshu.restapi.restfulwebservice.Dao.AuthenticationDao;
import com.Shivanshu.restapi.restfulwebservice.Model.AuthenticatedUserResponse;
import com.Shivanshu.restapi.restfulwebservice.Model.LoginDetails;

@Component
public class LoginDetailsAuthenticateService {
	
	@Autowired
	AuthenticationDao authenticationDao;

	@Transactional
	public AuthenticatedUserResponse  authenticate(LoginDetails loginDetails) {
		// TODO Auto-generated method 
	return 	authenticationDao.authenticateUser(loginDetails);
		
	}

	@Transactional
	public AuthenticatedUserResponse registerUser(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		return 	authenticationDao.registerUser(loginDetails);
	}

}
