package warehouse;

public class Main {
	public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        AlertService alertService = new AlertService();
        warehouse.addObserver(alertService);

        Product laptop = new Product("P001", "Laptop", 0, 5);
        warehouse.addProduct(laptop);

        warehouse.receiveShipment("P001", 10);
        warehouse.fulfillOrder("P001", 6);
    }
}



