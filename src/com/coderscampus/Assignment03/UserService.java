package com.coderscampus.Assignment03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UserService {
	private static User[] users; // Declare the users array
	private int length; // Declare the length instance variable

	// Constructor that reads users from a file and saves them in the users array
	public UserService(String fileName) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(fileName)); // Open the file for reading
		User[] users = new User[4]; // Initialize an array to hold the users
		length = 0; // Initialize the length variable to 0
		String line; // Declare a variable to hold each line of data from the file

		// Read each line from the file
		while ((line = fileReader.readLine()) != null) {
			String[] parts = line.split(","); // Split the line into three parts: username, password, name

			// If the line has three parts (username, password, and name), create a new User
			// object
			if (parts.length == 3) {
				String username = parts[0]; // Extract the username from the line
				String password = parts[1]; // Extract the password from the line
				String name = parts[2]; // Extract the name from the line
				User user = new User(username, password, name); // Create a new User object
				users[length] = user; // Add the new User object to the users array at the current index
				length++; // Increment the length variable
			}
		}

		this.users = Arrays.copyOf(users, length); // Copy the users array to a new array with the actual size of the
													// data
	}

	// Method to validate a user's login credentials
	public static User validateLogin(String username, String password) {
		for (User user : users) { // Loop through the users array
			if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
	            return user; // Return user

			}
		}
		return null; // Return null if there is no matching user
	}

	// Method to create a new User object and add it to the users array
	public User createUser(String username, String password, String name) {
		User user = new User(username, password, name); // Create a new User object
		this.users[length - 1] = user; // Add the new User object to the users array at the current index
		length++; // Increment the length variable
		this.users = Arrays.copyOf(this.users, length); // Copy the users array to a new array with the actual size of
														// the data
		return user; // Return the new User object
	}
}
