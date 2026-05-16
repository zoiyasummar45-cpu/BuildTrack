public class Material extends Resource {
    private int quantity;
    private double unitPrice;

    public Material(String name, int id, int quantity, double unitPrice) {
        super(name, id);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public double calculateTotalValue() {
        return quantity * unitPrice * 1.05; // 5% tax included
    }
}