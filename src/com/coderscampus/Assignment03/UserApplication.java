package com.coderscampus.Assignment03;

public class UserApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		
		User[] users = new User[4];
		
		for (int i = 0; i < 4; i++) {
			users[i] = userService.createUser("user" + (i + 1), "password" + (i + 1), "name" + (i + 1));
		}
		
		System.out.println(users);
	}
}
