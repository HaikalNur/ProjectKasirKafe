package Kafe;

import java.util.Scanner;

public class LoginValidator {
    private LoginManager loginManager;

    public LoginValidator() {
        loginManager = new LoginManager();
        //UserLists
        loginManager.addUser(new Admin("admin1", "adminpass1"));
        loginManager.addUser(new Waitress("emp1", "emppass1"));
        loginManager.addUser(new Kasir("manager1", "managerpass1"));
    }

    public void validateLogin() {
        String inputUsername = getInput("Enter username: ");
        String inputPassword = getInput("Enter password: ");

        if (loginManager.isValidUser(inputUsername, inputPassword)) {
            User loggedInUser = loginManager.getUser(inputUsername);
            System.out.println("Login successful!");
            System.out.println("=========================================");

            // Display user lists based on the user's role
            loginManager.displayUsersByClass(loggedInUser, Admin.class);
            System.out.println("-----------------------------------------");
            loginManager.displayUsersByClass(loggedInUser, Waitress.class);
            System.out.println("-----------------------------------------");
            loginManager.displayUsersByClass(loggedInUser, Kasir.class);
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        LoginValidator loginValidator = new LoginValidator();
        loginValidator.validateLogin();
    }
}
