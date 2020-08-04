//dao - data access object

package com.vastika.user_demo_jdbc.service;

import java.util.List;

import com.vastika.user_demo_jdbc.dao.UserDao;
import com.vastika.user_demo_jdbc.dao.UserDaoImpl;
import com.vastika.user_demo_jdbc.model.User;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public int saveUserInfo(User user) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return userDao.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserInfo(user);
	}

	@Override
	public void deleteUserInfo(int id) {
		userDao.deleteUserInfo(id);
		
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		return userDao.getAllUserInfo();
	}

}
