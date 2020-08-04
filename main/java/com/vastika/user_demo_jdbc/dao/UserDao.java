package com.vastika.user_demo_jdbc.dao;

import java.util.List;

import com.vastika.user_demo_jdbc.model.User;

public interface UserDao {

	int saveUserInfo(User user) throws ClassNotFoundException;
	
	int updateUserInfo(User user);
	
	void deleteUserInfo(int id);
	
	User getUserById(int id);
	
	List<User> getAllUserInfo();
	
}
