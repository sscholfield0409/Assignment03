package com.coderscampus.Assignment03;

import java.util.Scanner;

public class UserApplication {
	public static void main(String[] args) throws Exception {
		UserService userService = new UserService("data.txt"); // Create a new instance of the UserService class and
																// read data from the "data.txt" file

		Scanner scanner = new Scanner(System.in); // Create a new Scanner object to read user input
		System.out.print("Enter your email: "); // Prompt the user to enter their email address
		String inputUsername = scanner.nextLine(); // Read the user's email address
		System.out.print("Enter your password: "); // Prompt the user to enter their password
		String inputPassword = scanner.nextLine(); // Read the user's password

		boolean loginSuccess = false; // Initialize a boolean variable to false to track whether or not the user has
										// successfully logged in
		int attempts = 0; // Initialize an integer variable to track the number of login attempts
		String fullName = ""; // Initialize a string variable to hold the user's full name

		while (attempts < 5 && !loginSuccess && inputUsername != null && inputPassword != null) {
		    // If the maximum number of login attempts has been reached, notify the user that they are locked out
		    if (attempts == 4) {
		        System.out.println("Too many failed login attempts, you are now locked out");
		        scanner.close(); // Close the Scanner object
		        return; // Exit the program
		    }

			User validatedUser = userService.validateLogin(inputUsername.toLowerCase(), inputPassword); // Validate the
																										// user's login
																										// credentials

			// If the user's login credentials are valid, set the loginSuccess variable to
			// true and set the fullName variable to the user's name
			if (validatedUser == null) { // If the user is not validated, increment the attempts variable and prompt the
											// user to try again (if there are login attempts remaining)
				attempts++;

				System.out.println("Invalid login, please try again ");
				System.out.println("Enter your email: ");
				inputUsername = scanner.nextLine();
				System.out.println("Enter your password: ");
				inputPassword = scanner.nextLine();
			} else { // If the user is validated, set the loginSuccess variable to true and store
						// their name
				loginSuccess = true;
				fullName = validatedUser.getName();
				System.out.println("Welcome " + fullName + "!");

				// Create an array of User objects and fill it with data
				User[] users = new User[4];
				for (int i = 0; i < 4; i++) {
					users[i] = userService.createUser("user" + (i + 1), "password" + (i + 1), "fullName" + (i + 1));
				}
			}
		}
	}
}