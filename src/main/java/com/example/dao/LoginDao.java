package com.example.dao;

import java.util.List;

import com.example.model.UserInfo;

public interface LoginDao {
	
	UserInfo findUserInfo(String username);
	
	List<String> getUserRoles(String username);

}
