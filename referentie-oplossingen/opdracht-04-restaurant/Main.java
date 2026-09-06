public class Main {
    public static void main(String[] args) {
        // Creëer een restaurant
        Restaurant restaurant = new Restaurant("Ristorante Italiano");
        System.out.println("Welkom bij " + restaurant.getName());
        System.out.println();

        // Creëer gerechten
        Dish pizza = new Dish("Pizza Margherita", 12.50);
        Dish pasta = new Dish("Spaghetti Bolognese", 14.00);
        Dish tiramisu = new Dish("Tiramisu", 6.50);

        System.out.println("Menu:");
        System.out.println("- " + pizza.getName() + ": €" + pizza.getPrice());
        System.out.println("- " + pasta.getName() + ": €" + pasta.getPrice());
        System.out.println("- " + tiramisu.getName() + ": €" + tiramisu.getPrice());
        System.out.println();

        // Creëer een bestelling
        Order order = new Order(1001);
        
        // Voeg items toe
        OrderItem item1 = new OrderItem(2, pizza);
        OrderItem item2 = new OrderItem(1, pasta);
        OrderItem item3 = new OrderItem(3, tiramisu);
        
        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);

        // Demonstreer delegatie
        System.out.println("--- Delegatie demonstratie ---");
        System.out.println("OrderItem (2x pizza) vraagt prijs aan Dish:");
        System.out.println("  2 x €" + pizza.getPrice() + " = €" + item1.calculateTotal());
        System.out.println();
        
        System.out.println("Order vraagt totaal aan alle OrderItems:");
        for (OrderItem item : order.getItems()) {
            System.out.println("  " + item.getQuantity() + "x " + item.getDish().getName() + 
                             " → €" + item.calculateTotal());
        }
        System.out.println("  Totaal: €" + order.calculateTotal());
        System.out.println();

        System.out.println("Restaurant vraagt totaal aan Order:");
        System.out.println("  €" + restaurant.getOrderTotal(order));
        System.out.println();

        // Print bon
        System.out.println("--- Kassabon ---");
        restaurant.printReceipt(order);
    }
}
