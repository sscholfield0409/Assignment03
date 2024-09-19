package com.coderscampus.Assignment03;

import java.util.Scanner;

public class UserApplication {

	public static void main(String[] args) throws Exception {

		UserService userService = new UserService("data.txt");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your email: ");
		String inputUsername = scanner.nextLine();
		System.out.print("Enter your password: ");
		String inputPassword = scanner.nextLine();

		boolean loginSuccess = false;
		int attempts = 0;
		String fullName = "";

		while (attempts < 5 && !loginSuccess) {
			User validatedUser = UserService.validateLogin(inputUsername.toLowerCase(), inputPassword);
				if (validatedUser != null) {
					loginSuccess = true;
					fullName = validatedUser.getName();
					System.out.println("Welcome " + fullName + "!");
				} else {
					attempts++;
					if (attempts < 5) {
						System.out.println("Invalid login, please try again ");
						System.out.println("Enter your email: ");
						inputUsername = scanner.nextLine();
						System.out.println("Enter your password: ");
						inputPassword = scanner.nextLine();
				}
			}
		}
		if (!loginSuccess && attempts == 5) {
			System.out.println("Too many failed login attempts, you are now locked out");
		}
		scanner.close();
		return;
	}

}