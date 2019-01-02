package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.UserInfo;
@Service
public class UserServiceImplementation implements UserService {
	UserDao userDao;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<UserInfo> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	public UserInfo findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserbyUsername(username);
	}

	public void update(String username, String password) {
		// TODO Auto-generated method stub
		userDao.update(username, passwordEncoder.encode(password));
		
	}

	public void add(String username, String password) {
		// TODO Auto-generated method stub
		userDao.add(username, passwordEncoder.encode(password));
		
	}

	public boolean userExist(String username) {
		// TODO Auto-generated method stub
		
		return userDao.userExist(username);
	}

	
}
