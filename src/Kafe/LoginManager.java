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

    public void displayUsersByClass(Class<?> clazz) {
        if (Admin.class.equals(clazz)) {
            System.out.println("Users of type Admin:");
            for (User user : userList) {
                if (user instanceof Admin) {
                    System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
                }
            }
        } else if (Waitress.class.equals(clazz)) {
            System.out.println("Users of type Waitress:");
            for (User user : userList) {
                if (user instanceof Waitress) {
                    System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
                }
            }
        } else if (Kasir.class.equals(clazz)) {
            System.out.println("Users of type Kasir:");
            for (User user : userList) {
                if (user instanceof Kasir) {
                    System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
                }
            }
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
