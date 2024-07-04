package com.sunbeam.service;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.UserDao;
import com.sunbeam.entities.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User authenticateUser(String email, String password) {
		
		return userDao
				.findByEmailAndPassword(email, password)
				.orElseThrow(
					()->
					new AuthenticationException("Invalid Email or Password!!!"));
	}

}
