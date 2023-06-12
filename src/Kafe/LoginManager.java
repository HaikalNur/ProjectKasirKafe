package Kafe;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private List<User> userList;

    public LoginManager() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean isValidUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void displayUsersByClass(User loggedInUser, Class<?> clazz) {
        if (loggedInUser instanceof Admin) {
            System.out.println("Users of type " + clazz.getSimpleName() + ":");
            for (User user : userList) {
                if (clazz.isInstance(user)) {
                    System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
                }
            }
        } else {
            System.out.println("Access denied. Only administrators can view user lists.");
        }
    }

    public User getUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
