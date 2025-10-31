package warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private Map<String, Product> inventory = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
        System.out.println("✅ Added product: " + product);
    }

    public void receiveShipment(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            System.out.println("📦 Shipment received: +" + quantity + " " + product.getName());
        } else {
            System.out.println("❌ Invalid Product ID!");
        }
    }

    public void fulfillOrder(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("❌ Invalid Product ID!");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("❌ Insufficient stock for " + product.getName());
            return;
        }

        product.setQuantity(product.getQuantity() - quantity);
        System.out.println("🛒 Fulfilled order: -" + quantity + " " + product.getName());

        if (product.getQuantity() < product.getReorderThreshold()) {
            for (StockObserver obs : observers) {
                obs.onLowStock(product);
            }
        }
    }
}


