import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<OrderItem> items;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        // EDGE CASE: Null items niet toevoegen
        if (item != null) {
            items.add(item);
        }
    }

    // Order sommeert totalen door aan elk OrderItem te vragen
    // Order berekent NIET zelf de gerechtprijzen opnieuw
    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.calculateTotal();
        }
        return total;
    }

    public int getItemCount() {
        return items.size();
    }
}
