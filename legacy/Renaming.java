import java.util.Scanner;

/**
 * Project: BuildTrack - Construction Management System
 * Current State: Legacy Code (Messy Version)
 * Purpose: This represents the initial unorganized script before refactoring.
 */
public class Renaming {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Problem: Vague variable names (Requirement B: Rename Variable target)
        String mN = "Cement"; // Material Name
        int q = 100;          // Quantity
        double r = 1250.50;   // Rate per unit

        System.out.println("--- BuildTrack Site Management ---");

        // Display current inventory status
        System.out.println("Item: " + mN);
        System.out.println("Available Stock: " + q);

        // Problem: Direct calculation in main (Requirement B: Extract Method target)
        // Calculating total value with a hardcoded tax logic
        double total = q * r;
        double tax = total * 0.05; // 5% tax calculation - Hardcoded Magic Number
        double finalTotal = total + tax;

        System.out.println("Total Inventory Value (including tax): " + finalTotal);

        // Labor logic placeholder
        // Problem: Code duplication and lack of encapsulation
        String lName = "Worker A";
        int hours = 45;
        double wage = hours * 500; // Hardcoded wage calculation

        System.out.println("Labor Wage for " + lName + ": " + wage);
        
        // Problem: No Exception Handling. 
        // If a user were to input data here, any non-numeric value would crash the app.
    }
}