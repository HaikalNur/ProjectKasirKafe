/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package muhammadhaikal_2110010180;




import Kafe.LoginManager;
import Kafe.LoginValidator;
import java.util.Scanner;
import Kafe.LoginValidator;
import Kafe.Admin;
import Kafe.Kasir;
import Kafe.Waitress;



/**
 *
 * @author moxy
 */
public class MuhammadHaikal_2110010180 {

    /**
     * @param args the command line arguments
     */
    /**public static void main(String[] args) {
        // TODO code application logic here
    }*/
    
    
    //<Iterasi Pertama>
    /**
    public static void main(String[] args) {
        // Admin baru 
        Admin admin = new Admin("admin", "password");

        // Display 
        admin.displayAdminDetails();

        // Update Nama
        admin.setUsername("newadmin");

        // Update Display
        admin.displayAdminDetails();
    }
    */
    
    //Iterasi <2nd Login w Admin>
    /**public static void main(String[] args) {
        // Create an instance of Login
        Admin admin = new Admin("admin", "password");
        Login login = new Login("haikal", "12345");

        // Prompt the user for credentials
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        // Authenticate the user
        if (login.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Login successful!");
        } else if (admin.authenticate(enteredUsername, enteredPassword)){
            System.out.println("Login in as Admin");
        }else{
            System.out.println("Invalid username or password.");
        }
         Info for Cafe
        Kafe kafe = new Kafe("KAFE MERIAU 900", "JL TARDARA", "0821890121");
        kafe.DisplayInfo();
        
    }*/
    
    
    //Iterasi <3rd Informasi Kafe + Waitress Class>
    
    public static void main(String[] args) {
        //Info Kafe
        
        
        //Login Prompt
        LoginValidator loginValidator = new LoginValidator();
        loginValidator.validateLogin();    
    } 
    
}

        
       
        
        
       
        
        
        
    
        
    
    
    
    
    
