import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    private String name;
    private List<Delivery> deliveries;

    public DeliveryService(String name) {
        this.name = name;
        this.deliveries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void addDelivery(Delivery delivery) {
        // EDGE CASE: Null bezorgingen niet toevoegen
        if (delivery != null) {
            deliveries.add(delivery);
        }
    }

    // Delegeert aan Delivery voor prijs
    public double getDeliveryPrice(Delivery delivery) {
        // EDGE CASE: Geen bezorging meegegeven
        if (delivery == null) {
            return 0.0;
        }
        return delivery.calculatePrice();
    }

    // Bereken totale omzet
    public double calculateTotalRevenue() {
        double total = 0.0;
        for (Delivery delivery : deliveries) {
            total += delivery.calculatePrice();
        }
        return total;
    }

    // Tel zware pakketten (delegeert via Delivery naar Package)
    public int countHeavyPackages() {
        int count = 0;
        for (Delivery delivery : deliveries) {
            if (delivery.getPackage() != null && delivery.getPackage().isHeavy()) {
                count++;
            }
        }
        return count;
    }

    public void printAllDeliveries() {
        System.out.println("=== " + name + " ===");
        System.out.println("Totaal bezorgingen: " + deliveries.size());
        System.out.println("Zware pakketten: " + countHeavyPackages());
        System.out.printf("Totale omzet: €%.2f%n", calculateTotalRevenue());
        System.out.println();
        
        int nr = 1;
        for (Delivery delivery : deliveries) {
            System.out.println("--- Bezorging " + nr + " ---");
            delivery.printDetails();
            System.out.println();
            nr++;
        }
    }
}
