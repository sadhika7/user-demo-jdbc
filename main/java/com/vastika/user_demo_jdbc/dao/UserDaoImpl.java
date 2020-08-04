package com.vastika.user_demo_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.user_demo_jdbc.model.User;
import com.vastika.user_demo_jdbc.util.DBUtil;
import com.vastika.user_demo_jdbc.util.QueryUtil;

public class UserDaoImpl implements UserDao{

	public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/user_db?serverTimezone=UTC";
	public static final String USER_NAME="root";
	public static final String PASSWORD="password";
	
	public int saveUserInfo(User user) throws ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		int saved = 0;
		
		try(
			Connection con = DriverManager.getConnection(DRIVER_NAME, USER_NAME, PASSWORD);
			PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setString(4,user.getAddress());
			saved = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return saved;
		
	}

	public int updateUserInfo(User user) {
		int updated = 0;
		
		try(Connection con = DriverManager.getConnection(DRIVER_NAME, USER_NAME, PASSWORD);
			PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setLong(3, user.getMobileNo());
			ps.setString(4,user.getAddress());
			updated = ps.executeUpdate();
			ps.setInt(1,user.getId());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return updated;
		
	}

	public void deleteUserInfo(int id) {
		
		try(Connection con = DriverManager.getConnection(DRIVER_NAME, USER_NAME, PASSWORD);
			PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL);){
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public User getUserById(int id) {
		User user = new User();
		try(Connection con = DriverManager.getConnection(DRIVER_NAME, USER_NAME, PASSWORD);
			PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL);){
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setMobileNo(rs.getLong("mobile_no"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	public List<User> getAllUserInfo() {

		List<User> userList = new ArrayList<>();
		try(Connection con =DriverManager.getConnection(DRIVER_NAME, USER_NAME, PASSWORD);
			PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL);){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setMobileNo(rs.getLong("mobile_no"));
				userList.add(user);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
		
	}

}
