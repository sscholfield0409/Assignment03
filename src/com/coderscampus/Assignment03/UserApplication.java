package com.coderscampus.Assignment03;

public class UserApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		
		User testUser = userService.createUser("test@email.com", "passwordTest!1", "Test User");
		System.out.println(testUser);
	}

}
