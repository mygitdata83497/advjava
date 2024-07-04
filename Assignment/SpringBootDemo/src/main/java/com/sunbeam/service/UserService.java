package com.sunbeam.service;

import com.sunbeam.entities.User;

public interface UserService {
	User authenticateUser(String email,String password);
}
