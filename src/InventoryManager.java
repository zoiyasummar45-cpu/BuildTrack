import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Step 11: File IO for Data Persistence with complete history logging.
 * Handles appending inventory logs with real-time Date and Time stamps.
 */
public class InventoryManager {
    private static final String FILE_PATH = "inventory.txt";

    // Saves the material inventory with date, time, and complete historical accumulation
    public static void saveInventory(List<Material> materials) {
        // 'true' inside FileWriter enables Append Mode so old history is never deleted
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            
            // Getting current Date and Time
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);

            for (Material m : materials) {
                // Saving: Date_Time, Name, ID, Quantity, Price, TotalValue
                writer.write("[" + formattedDateTime + "] " + 
                             "Name: " + m.getName() + " | " +
                             "ID: " + m.getId() + " | " +
                             "Qty: " + m.getQuantity() + " | " +
                             "Price: Rs. " + m.getUnitPrice() + " | " +
                             "Total Evaluated: Rs. " + m.calculateTotalValue());
                writer.newLine();
            }
            System.out.println("Storage Management: Resource changes appended to tracking history successfully.");
        } catch (IOException e) {
            System.out.println("Fault Tolerance Error: Could not log transaction history! " + e.getMessage());
        }
    }

    // Reads the entire history log from the text file to print on screen
    public static void printFullHistory() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("Storage Management: No log tracking history found.");
            return;
        }

        System.out.println("\n================= BUILDTRACK HISTORICAL LOGS =================");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("===============================================================");
        } catch (IOException e) {
            System.out.println("Fault Tolerance Error: Error reading transactional logs! " + e.getMessage());
        }
    }
    // Logs a deletion/removal entry into the historical tracker
    public static void logDeletion(String resourceName, int resourceId) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);

            // Writing a special REMOVED action flag to the file
            writer.write("[" + formattedDateTime + "] [ACTION: REMOVED] " + 
                         "Resource Name: " + resourceName + " | " +
                         "ID: " + resourceId + " has been deleted from active site operations.");
            writer.newLine();
            
            System.out.println("Storage Management: Deletion event logged successfully.");
        } catch (IOException e) {
            System.out.println("Fault Tolerance Error: Could not log deletion event! " + e.getMessage());
        }
    }
}