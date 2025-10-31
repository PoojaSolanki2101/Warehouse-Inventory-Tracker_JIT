package warehouse;

public class Product {
	private String id;
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Product(String id, String name, int quantity, int reorderThreshold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderThreshold = reorderThreshold;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getReorderThreshold() { return reorderThreshold; }

    @Override
    public String toString() {
        return name + " (Qty: " + quantity + ", Threshold: " + reorderThreshold + ")";
    }
    
    }



