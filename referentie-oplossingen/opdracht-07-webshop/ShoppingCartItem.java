public class ShoppingCartItem {
    private int quantity;
    private Product product;

    public ShoppingCartItem(int quantity, Product product) {
        // EDGE CASE: Minimaal 1 product
        this.quantity = Math.max(1, quantity);
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        // EDGE CASE: Minimaal 1 product
        this.quantity = Math.max(1, quantity);
    }

    // Delegeert prijs aan Product
    public double calculateLineTotal() {
        // EDGE CASE: Geen product gekoppeld
        if (product == null) {
            return 0.0;
        }
        return quantity * product.getPrice();
    }

    // Alias: getTotalPrice voor PDF-stijl
    public double getTotalPrice() {
        return calculateLineTotal();
    }

    // Controleert voorraad via Product
    public boolean hasEnoughStock() {
        // EDGE CASE: Geen product gekoppeld
        if (product == null) {
            return false;
        }
        return product.hasStockFor(quantity);
    }
}
