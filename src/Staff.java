public class Staff extends Resource {
    private int hours;
    private double rate;

    public Staff(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculateTotalValue() {
        return hours * rate;
    }
}