public class Delivery {
    private double baseCost;
    private double distance;
    private Package deliveryPackage;
    private Address address;

    private static final double COST_PER_KM = 0.50;
    private static final double HEAVY_SURCHARGE = 5.00;

    public Delivery(double baseCost, double distance, Package deliveryPackage, Address address) {
        // EDGE CASE: Kosten en afstand mogen niet negatief zijn
        this.baseCost = Math.max(0.0, baseCost);
        this.distance = Math.max(0.0, distance);
        this.deliveryPackage = deliveryPackage;
        this.address = address;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getDistance() {
        return distance;
    }

    public Package getPackage() {
        return deliveryPackage;
    }

    public Address getAddress() {
        return address;
    }

    // Delivery berekent prijs door aan Package te vragen of het zwaar is
    public double calculatePrice() {
        double price = baseCost + (distance * COST_PER_KM);
        
        // EDGE CASE: Geen pakket gekoppeld
        if (deliveryPackage != null && deliveryPackage.isHeavy()) {
            price += HEAVY_SURCHARGE;
        }
        
        return price;
    }

    // Alias: getTotalPrice / getPrice voor PDF-stijl
    public double getTotalPrice() {
        return calculatePrice();
    }

    public double getPrice() {
        return calculatePrice();
    }

    // Delegeert aan Address voor volledige adresregel
    public String getDeliveryAddress() {
        // EDGE CASE: Geen adres gekoppeld
        if (address == null) {
            return "Onbekend adres";
        }
        return address.getFullAddress();
    }

    // Geef overzicht van bezorging
    public void printDetails() {
        System.out.println("Bezorging details:");
        System.out.println("  Adres: " + getDeliveryAddress());
        System.out.println("  Afstand: " + distance + " km");
        System.out.println("  Basiskosten: €" + baseCost);
        System.out.println("  Afstandskosten: €" + (distance * COST_PER_KM));
        
        if (deliveryPackage != null) {
            System.out.println("  Pakketgewicht: " + deliveryPackage.getWeight() + " kg");
            System.out.println("  Zwaar pakket (>10kg): " + deliveryPackage.isHeavy());
            if (deliveryPackage.isHeavy()) {
                System.out.println("  Zware-pakket toeslag: €" + HEAVY_SURCHARGE);
            }
        }
        
        System.out.printf("  Totaalprijs: €%.2f%n", calculatePrice());
    }
}
