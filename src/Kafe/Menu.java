/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kafe;

/**
 *
 * @author moxy
 */


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        // Add menu items
        menuItems.add("Kopi");
        menuItems.add("Latte");
        menuItems.add("Mocha");
        // Add more items as needed
    }
    

    public List<String> getMenuItems() {
        return menuItems;
    }

    public String getMenuItem(int index) {
        return menuItems.get(index);
    }

    public void displayMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }
}


