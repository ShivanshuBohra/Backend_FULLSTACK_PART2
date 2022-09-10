package com.Shivanshu.restapi.restfulwebservice.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Shivanshu.restapi.restfulwebservice.Model.AuthenticatedUserResponse;
import com.Shivanshu.restapi.restfulwebservice.Model.LoginDetails;
import com.Shivanshu.restapi.restfulwebservice.Model.Todo;

@Component
public class AuthenticationDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	AuthenticatedUserResponse authenticatedUserResponse;

	@Transactional
	public AuthenticatedUserResponse  authenticateUser(LoginDetails loginDetails) {
		Session currentSession = entityManager.unwrap(Session.class);
		authenticatedUserResponse.setIsValid(false);
		authenticatedUserResponse.setUsername(loginDetails.getUsername());
	   String username = loginDetails.getUsername();
	   String password = loginDetails.getPassword();
		Query isUserNameAndPasswordPresent= currentSession.createQuery("from LoginDetails where username = :username"+ " and "+ "password = :password");
		isUserNameAndPasswordPresent.setParameter("username", username);
		isUserNameAndPasswordPresent.setParameter("password", password);
		 List<LoginDetails> listOfusers = isUserNameAndPasswordPresent.list();
		 if(listOfusers!=null && listOfusers.size()>0) {
			 authenticatedUserResponse.setUsername(username);
			 authenticatedUserResponse.setIsValid(true);
		 }
		 
		 return authenticatedUserResponse;
		
	}

	@Transactional
	public AuthenticatedUserResponse registerUser(LoginDetails loginDetails) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(loginDetails);
		authenticatedUserResponse.setUsername(loginDetails.getUsername());
		return authenticatedUserResponse;
	}

}
