public class OrderItem {
    private int quantity;
    private Dish dish;

    public OrderItem(int quantity, Dish dish) {
        // EDGE CASE: Aantal moet minimaal 1 zijn
        this.quantity = Math.max(1, quantity);
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public Dish getDish() {
        return dish;
    }

    // OrderItem berekent totaal door prijs aan Dish te vragen
    public double calculateTotal() {
        // EDGE CASE: Geen gerecht gekoppeld
        if (dish == null) {
            return 0.0;
        }
        return quantity * dish.getPrice();
    }
}
