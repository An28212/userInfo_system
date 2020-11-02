package user;

import java.util.Scanner;

import controller.UserController;

public class UserTest {
	public static void main(String[]args) {
		UserController controller = new UserController();
		Scanner input = new Scanner(System.in);
		controller.saveUserInfo(input);
	System.out.println("Enter which db operation do you want to perform? save|update|delete|get|list");
	String choice= input.next();
		
		String decision="";
		do {
		switch(choice) {
			case "save":
			controller.saveUserInfo(input);
			break;
			
			case "update":
			controller.updateUserInfo(input);
			break;
			
			case "delete":
			controller.deleteUserInfo(input);
			break;
			
			case "get":
			controller.getUserById(input);
			break;
			
			case "list":
			controller.getAllUser();
			break;
			default:
				System.out.println("wrong choice!!!");
			}
			System.out.println("do you want to continue?");
			decision = input.next();
		}while(decision.equalsIgnoreCase("yes"));
		
		System.out.println("byye byee!!!Happy Coding.");
		}
		
		
	}

		
	

