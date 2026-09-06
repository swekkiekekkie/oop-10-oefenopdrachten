public class Restaurant {
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Restaurant vraagt totaal aan Order (delegatie)
    public double getOrderTotal(Order order) {
        // EDGE CASE: Geen bestelling meegegeven
        if (order == null) {
            return 0.0;
        }
        return order.calculateTotal();
    }

    public void printReceipt(Order order) {
        System.out.println("=== " + name + " ===");
        System.out.println("Bestelling #" + order.getOrderNumber());
        System.out.println("--------------------------");
        
        for (OrderItem item : order.getItems()) {
            String dishName = item.getDish().getName();
            int qty = item.getQuantity();
            double itemTotal = item.calculateTotal();
            System.out.printf("%dx %s: €%.2f%n", qty, dishName, itemTotal);
        }
        
        System.out.println("--------------------------");
        System.out.printf("Totaal: €%.2f%n", getOrderTotal(order));
    }
}
