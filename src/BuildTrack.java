import java.util.ArrayList;
import java.util.List;

/**
 * Project: BuildTrack - Construction Management System
 * State: UI Separation Update
 * Focus: Shows only present session activity in terminal while preserving full logs in file.
 */
public class BuildTrack {
    public static void main(String[] args) {
        System.out.println("--- BuildTrack Site Management ---");

        List<Material> currentBatch = new ArrayList<>();
        
        // Present Session Entries
        currentBatch.add(new Material("Cement Batch B", 101, 80, 1250.0));
        currentBatch.add(new Material("Steel rods Heavy", 102, 15, 4800.0));

        System.out.println("\n[System Action] Appending entries to permanent file storage...");
        
        // 1. Permanent file backing main sari historical data chali jayegi (puraani entries delete nahi hongi)
        InventoryManager.saveInventory(currentBatch);

        // 2. ONLY Present Session Status Display on Terminal
        System.out.println("\n================= CURRENT SESSION ACTIVE ITEMS =================");
        for (Material m : currentBatch) {
            System.out.println("Active Resource: " + m.getName() + 
                               " | ID: " + m.getId() + 
                               " | Qty: " + m.getQuantity() + 
                               " | Session Valuation: Rs. " + m.calculateTotalValue());
        }

        // 3. Simulating a live deletion action in this session
        System.out.println("\nExecuting user deletion request...");
        InventoryManager.logDeletion("Cement Batch B", 101);
        
        // UI Notification for current session instead of printing the whole messy log file
        System.out.println("Active Notice: 'Cement Batch B' successfully flagged as REMOVED for this session.");
        System.out.println("=================================================================");
    }
}