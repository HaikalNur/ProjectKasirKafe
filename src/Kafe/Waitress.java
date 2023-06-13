/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Kafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waitress extends User {
    private List<List<String>> orders;

    public Waitress(String username, String password) {
        super(username, password);
        orders = new ArrayList<>();
    }

    public void takeOrder(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        menu.displayMenu();

        System.out.println("Please enter the table number:");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Please enter the number of the menu item to order:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice >= 1 && choice <= menu.getMenuItems().size()) {
            String menuItem = menu.getMenuItem(choice - 1);
            System.out.println("Please enter the quantity for the order:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Check if the table number already exists in the orders list
            if (tableNumber <= orders.size()) {
                List<String> tableOrders = orders.get(tableNumber - 1);
                tableOrders.add(quantity + " " + menuItem);
            } else {
                List<String> tableOrders = new ArrayList<>();
                tableOrders.add(quantity + " " + menuItem);
                orders.add(tableOrders);
            }

            System.out.println("Order received! You ordered: " + quantity + " " + menuItem + " for table " + tableNumber);
        } else {
            System.out.println("Invalid menu item selection.");
        }
    }

    public void viewOrders() {
        System.out.println("Orders:");
        for (int i = 0; i < orders.size(); i++) {
            List<String> tableOrders = orders.get(i);
            System.out.println("Table " + (i + 1) + ":");
            for (String order : tableOrders) {
                System.out.println("- " + order);
            }
            System.out.println();
        }
    }
}
