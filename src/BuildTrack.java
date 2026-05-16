import java.util.Scanner;
import java.util.InputMismatchException;

public class BuildTrack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("--- BuildTrack Construction System ---");
            System.out.print("Enter Cement Quantity: ");
            int qty = sc.nextInt();

            Resource cement = new Material("Cement", 101, qty, 1200);
            Resource eng = new Staff("Ali", 501, 40, 1000);

            System.out.println("Material Total: " + cement.calculateTotalValue());
            System.out.println("Staff Wage: " + eng.calculateTotalValue());

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a numeric value!");
        }
    }
}