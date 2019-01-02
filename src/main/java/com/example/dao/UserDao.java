package com.example.dao;

import java.util.List;

import com.example.model.UserInfo;

public interface UserDao {
	
	public List<UserInfo> list ();
	
	public UserInfo findUserbyUsername(String username);
	public void update(String username, String password);
	public void add(String username, String password);
	public boolean userExist(String username);

}
