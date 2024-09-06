package com.coderscampus.Assignment03;

public class UserApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		
		User[] users = new User[4];
		
		for (int i = 0; i < 4; i++) {
			users[i] = userService.createUser("user" + (i + 1), "password" + (i + 1), "name" + (i + 1));
		}
		
		users[0] = userService.createUser("test@email.com", "passwordTest!1", "Test User");
		users[1] = userService.createUser("another@user.com", "another@user.com", "Another User");
		users[2] = userService.createUser("john.doe@mydomain.net", "Hdk398jf!", "John Doe");
		users[3] = userService.createUser("jane.doe@myotherdomain.com", "sunrise-sunset", "Jane Doe");
	}
}
