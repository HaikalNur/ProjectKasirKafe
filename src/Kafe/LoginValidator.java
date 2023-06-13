package Kafe;

import Kafe.Menu;
import java.util.Scanner;

public class LoginValidator {
    private LoginManager loginManager;
    private User loggedInUser;
    private Waitress waitress;

    public LoginValidator() {
        loginManager = new LoginManager();
        // User lists
        loginManager.addUser(new Admin("admin1", "adminpass1"));
        loginManager.addUser(new Waitress("emp1", "emppass1"));
        loginManager.addUser(new Kasir("manager1", "managerpass1"));
    }

    public void validateLogin() {
    boolean loggedIn = false;

    while (!loggedIn) {
        String inputUsername = getInput("Enter username: ");
        String inputPassword = getInput("Enter password: ");

        if (inputUsername.equalsIgnoreCase("exit") || inputPassword.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the program...");
            break; // Exit the login loop
        }

        if (loginManager.isValidUser(inputUsername, inputPassword)) {
            loggedInUser = loginManager.getUser(inputUsername);
            System.out.println("Login successful!");

            // Display user lists based on the user's role
            if (loggedInUser instanceof Admin) {
                loginManager.displayUsersByClass(Admin.class);
                loginManager.displayUsersByClass(Waitress.class);
                loginManager.displayUsersByClass(Kasir.class);
            } else if (loggedInUser instanceof Waitress) {
                waitress = new Waitress(loggedInUser.getUsername(), loggedInUser.getPassword());
                Menu menu = new Menu();

                while (true) {
                    waitress.takeOrder(menu);

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Are you done taking orders? (Y/N)");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        break;
                    }
                }

                waitress.viewOrders();
            } else if (loggedInUser instanceof Kasir) {
                // Logic for Kasir
            }

            boolean logoutConfirmed = confirmLogout(); // Ask for confirmation to logout
            if (logoutConfirmed) {
                logout();
                loggedIn = true; // Continue the login loop
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}




    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public void logout() {
    loggedInUser = null;
    System.out.println("Logged out successfully!");
    }
    
    private boolean confirmLogout() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Are you sure you want to logout? (Y/N)");
    String choice = scanner.nextLine();
    return choice.equalsIgnoreCase("Y");
    }

    
}
