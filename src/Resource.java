public abstract class Resource {
    private String name;
    private int id;

    public Resource(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public abstract double calculateTotalValue(); // Polymorphism foundation
}