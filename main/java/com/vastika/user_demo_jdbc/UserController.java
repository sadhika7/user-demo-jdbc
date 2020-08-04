package com.vastika.user_demo_jdbc;

import java.util.List;
import java.util.Scanner;

import com.vastika.user_demo_jdbc.dao.UserDao;
import com.vastika.user_demo_jdbc.dao.UserDaoImpl;
import com.vastika.user_demo_jdbc.model.User;
import com.vastika.user_demo_jdbc.service.UserService;
import com.vastika.user_demo_jdbc.service.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class UserController 
{
    public static void main( String[] args ) throws ClassNotFoundException
    { 
    	UserService userService = new UserServiceImpl();
    	String decision = "";
    			
    	Scanner reader = new Scanner(System.in);
    	
    	do {
    		System.out.println("What operation do you want to perform? save update delete get list");
    		String choice = reader.next();
        	switch(choice) {
        	case "save":
        		User saveUser = getUserData(choice, reader);
        		int saved = userService.saveUserInfo(saveUser);    	
            	if(saved >= 1) {
            		System.out.println("User info is saved successfully!!!!");
            	}else {
            		System.out.println("Error in DB.");
            	}
        		break;
        	case "update":
        		User updateUser = getUserData(choice, reader);
        		int updated = userService.updateUserInfo(updateUser);    	
            	if(updated >= 1) {
            		System.out.println("User info is updated successfully!!!!");
            	}else {
            		System.out.println("Error in DB.");
            	}
        		break;
        	case "delete":
        		System.out.println("Enter id: ");
        		int deleteId = reader.nextInt();
        		userService.deleteUserInfo(deleteId);
        		System.out.println("User info is deleted!!!");
        		break;
        	case "get":
        		System.out.println("Enter id: ");
        		int getId = reader.nextInt();
        		User user = userService.getUserById(getId);
        		System.out.println("User id is: "+user.getId());
        		System.out.println("User name is: "+user.getUsername());
        		System.out.println("User password is: "+user.getPassword());
        		System.out.println("User address is: "+user.getAddress());
        		System.out.println("User Mobile number is: "+user.getMobileNo());
        		break;
        	case "list":
        		List<User> userList = userService.getAllUserInfo();
        		
        		for(User u: userList) {
        			System.out.println("User id is: "+u.getId());
            		System.out.println("User name is: "+u.getUsername());
            		System.out.println("User password is: "+u.getPassword());
            		System.out.println("User address is: "+u.getAddress());
            		System.out.println("User Mobile number is: "+u.getMobileNo());
            		System.out.println("===================");
        		}
        		break;
        	default:
        		System.out.println("wrong choice!!!");
        	}
        	
        	System.out.println("Do you want to perform next operation? Press y|Y for yes");
        	decision = reader.next();
    	}while(decision.equalsIgnoreCase("y"));
    		
    }
    
    public static User getUserData(String type, Scanner reader) {
    	
    	
    	User user = new User();
    	
    	if(type.contentEquals("update")) {
    		System.out.println("Enter id: ");
    		int id = reader.nextInt();
    		user.setId(id);
    	}
    	System.out.println("enter username: ");
    	String username = reader.next();
    	
    	System.out.println("enter password: ");
    	String password = reader.next();
    	
    	System.out.println("enter mobile no: ");
    	long mobileNo = reader.nextLong();
    	
    	System.out.println("enter address: ");
    	String address = reader.next();
    	
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setAddress(address);
    	user.setMobileNo(mobileNo);
    	
    	return user;
    	
    }
}
