/**
 * Step 3: Implementing Abstraction
 * This is the abstract base class for all construction assets.
 */
public abstract class Resource {
    private String name;
    private int id;

    public Resource(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Encapsulation: Public Getters to access private fields safely
    public String getName() { 
        return name; 
    }

    public int getId() { 
        return id; 
    }

    /**
     * Abstract method for Polymorphism.
     * Every child class (Material/Staff) must implement its own calculation logic.
     */
    public abstract double calculateTotalValue();
}