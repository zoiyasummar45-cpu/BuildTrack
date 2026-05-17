public class Material extends Resource {
    private int quantity;
    private double unitPrice;
    private static final double TAX_RATE = 0.05;

    public Material(String name, int id, int quantity, double unitPrice) {
        super(name, id);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Encapsulation: Accessors for File I/O operations
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }

    @Override
    public double calculateTotalValue() {
        double subTotal = quantity * unitPrice;
        return subTotal + (subTotal * TAX_RATE);
    }
}