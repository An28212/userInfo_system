package controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.vastika.userInfo_system.User;

import service.UserService;
import service.UserServiceImpl;

public class UserController {
private static final User user = null;
UserService userService = new UserServiceImpl();
private int id;
public void saveUserInfo(Scanner input) {
	 User user = new User();
	 System.out.println("Enter Username:");
	 String username = input.nextLine();
	 System.out.println("Enter Password:");
	 String password = input.nextLine();
	 System.out.println("Enter Email:");
	 String email = input.nextLine();
	 System.out.println("Enter dob:");
	 String dob = input.nextLine();
	 System.out.println("Enter mobile no:");
	 String mobileNo = input.nextLine();
	 user.setUsername(username);
	 user.setPassword(password);
	 user.setEmail(email);
	 user.setMobileNo(mobileNo);
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 try {
		java.util.Date d =  sdf.parse(dob);
		 user.setDob(d);
	 }catch (ParseException e) {
	 e.printStackTrace();
	 }
	 int saved = userService.SaveUserInfo(user);
	 if(saved>=1) {
		 System.out.println("User info is saved in db successfully!!!");
	 }else {
		 System.out.println("error in db");
	 }
}
public void updateUserInfo(Scanner input){
	User user = getUserData(input);
	System.out.println("Enter id:");
int id = input.nextInt();
	user.setId(id);
	int updated = userService.updateUserInfo(user);
	if(updated>=1) {
		System.out.println("User info is updated in db sucessfully!!!");
	}else {
		System.out.println("error in db.");
	}
}
public void deleteUserInfo(Scanner input) {
	


System.out.println("Enter id:");
int id = input.nextInt();
	
	int deleted = userService.deleteUserInfo(id);
	if(deleted>=1) {
		System.out.println("User info is deleted in db sucessfully!!!");
	}else {
		System.out.println("error in db.");
	}
	}
	public void getUserById(Scanner input) {
		System.out.println("Enter id:");
		int id = input.nextInt();
			
			User user = userService.getUserById(id);
			
				System.out.println("User id is:" + user.getId());
			
				System.out.println("User name is:" + user.getUsername());
				System.out.println("User password is:" + user.getPassword());
				System.out.println("User email is:" + user.getEmail());
				System.out.println("User mobile no is:" + user.getMobileNo());
				System.out.println("User dob is:" + user.getDob());
	}
	
public void getAllUser() {
	List<User> userList = userService.getAllUser();

	
		System.out.println("User id is:" + user.getId());
		
		System.out.println("User name is:" + user.getUsername());
		System.out.println("User password is:" + user.getPassword());
		System.out.println("User email is:" + user.getEmail());
		System.out.println("User mobile no is:" + user.getMobileNo());
		System.out.println("User dob is:" + user.getDob());
		System.out.println("==================");
	}
private User getUserData(Scanner input) {
	 User user = new User();
	 System.out.println("Enter Username:");
	 String username = input.nextLine();
	 System.out.println("Enter Password:");
	 String password = input.nextLine();
	 System.out.println("Enter Email:");
	 String email = input.nextLine();
	 System.out.println("Enter dob:");
	 String dob = input.nextLine();
	 System.out.println("Enter mobile no:");
	 String mobileNo = input.nextLine();
	 user.setUsername(username);
	 user.setPassword(password);
	 user.setEmail(email);
	 user.setMobileNo(mobileNo);
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 try {
		 java.util.Date d = sdf.parse(dob);
		 user.setDob(d);
	 }catch (ParseException e) {
	 e.printStackTrace();
	 }
	 return user;
}
}

