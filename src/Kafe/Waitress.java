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

            // Check if the menu item already exists in the table orders
            boolean itemExists = false;
            for (int i = 0; i < tableOrders.size(); i++) {
                String order = tableOrders.get(i);
                if (order.contains(menuItem)) {
                    // Update the quantity for the existing order
                    int prevQuantity = Integer.parseInt(order.split(" ")[0]);
                    int newQuantity = prevQuantity + quantity;
                    tableOrders.set(i, newQuantity + " " + menuItem);
                    itemExists = true;
                    break;
                }
            }

            // If the menu item doesn't exist, add a new entry
            if (!itemExists) {
                tableOrders.add(quantity + " " + menuItem);
            }
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
