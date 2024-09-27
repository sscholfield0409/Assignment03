package com.coderscampus.Assignment03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	private static User[] users; // Declare the users array
	private int length; // Declare the length instance variable

	// Constructor that reads users from a file and saves them in the users array
	public UserService(String fileName) throws IOException {
		UserService.users = readUsersFromFile("data.txt"); // read users from file and store in users array
		length = users.length; // Set the length variable to the actual length of the users array
	}

	// Method to read users from a file
	private static User[] readUsersFromFile(String fileName) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader("data.txt")); // Open the file for reading
		User[] users = new User[4]; // Initialize an array to hold the users
		int length = 0; // Initialize the length variable to 0
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

		return users; // Return the array
	}

	public User validateLogin(String username, String password) {
		for (User user : users) { // Loop through the users array
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user; // Return user
			}
		}
		return null; // Return null if there is no matching user
	}

	public User createUser(String username, String password, String name) {
		User newUser = new User(username, password, name); // Create a new User object with the given parameters
		User[] newUsers = new User[users.length + 1]; // Create a new array with size one more than the current users
														// array
		for (int i = 0; i < users.length; i++) {
			newUsers[i] = users[i]; // Copy the existing users array into the new array
		}
		newUsers[newUsers.length - 1] = newUser; // Add the new user to the end of the new array
		users = newUsers; // Set the class variable `users` to the new array
		length++; // Increment the length instance variable
		return newUser;
	}
}