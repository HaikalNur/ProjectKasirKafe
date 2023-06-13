package Kafe;

import java.util.Scanner;

public class LoginValidator {
    private LoginManager loginManager;
    private User loggedInUser;

    public LoginValidator() {
        loginManager = new LoginManager();
        // User lists
        loginManager.addUser(new Admin("admin1", "adminpass1"));
        loginManager.addUser(new Waitress("emp1", "emppass1"));
        loginManager.addUser(new Kasir("manager1", "managerpass1"));
    }

    public void validateLogin() {
        String inputUsername = getInput("Enter username: ");
        String inputPassword = getInput("Enter password: ");

        if (loginManager.isValidUser(inputUsername, inputPassword)) {
            loggedInUser = loginManager.getUser(inputUsername);
            System.out.println("Login successful!");

            // Display user lists based on the user's role
            if (loggedInUser instanceof Admin) {
                loginManager.displayUsersByClass(Admin.class);
                loginManager.displayUsersByClass(Waitress.class);
                loginManager.displayUsersByClass(Kasir.class);
            } else if (loggedInUser instanceof Waitress) {
                
            } else if (loggedInUser instanceof Kasir) {
                
            }
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
