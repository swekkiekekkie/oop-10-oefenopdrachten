import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void addItem(ShoppingCartItem item) {
        // EDGE CASE: Null items niet toevoegen
        if (item != null) {
            items.add(item);
        }
    }

    public void removeItem(ShoppingCartItem item) {
        items.remove(item);
    }

    public void clear() {
        items.clear();
    }

    // Delegeert aan elk ShoppingCartItem voor regeltotaal
    public double calculateTotal() {
        double total = 0.0;
        for (ShoppingCartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Alias: getTotalPrice voor PDF-stijl
    public double getTotalPrice() {
        return calculateTotal();
    }

    public int getItemCount() {
        return items.size();
    }

    public int getTotalProducts() {
        int total = 0;
        for (ShoppingCartItem item : items) {
            total += item.getQuantity();
        }
        return total;
    }

    // Controleert voorraad voor alle items
    public boolean canCheckout() {
        for (ShoppingCartItem item : items) {
            if (!item.hasEnoughStock()) {
                return false;
            }
        }
        return !items.isEmpty();
    }
}
