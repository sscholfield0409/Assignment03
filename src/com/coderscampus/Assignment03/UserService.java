package com.coderscampus.Assignment03;

public class UserService {
	public User createUser (String username, String password, String name) {
		User user = new User();
		user.setUsername("test@email.com");
		user.setPassword("passwordTest!1");
		user.setName("Test User");
		return user;
	}
}
