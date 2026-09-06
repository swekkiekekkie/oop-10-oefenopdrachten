public class Room {
    private int number;
    private double pricePerNight;
    private boolean available;

    public Room(int number, double pricePerNight) {
        this.number = number;
        // EDGE CASE: Prijs mag niet negatief zijn
        this.pricePerNight = Math.max(0.0, pricePerNight);
        this.available = true;
    }

    public int getNumber() {
        return number;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    // Room beheert zelf beschikbaarheid
    public void markAsBooked() {
        available = false;
    }

    public void markAsAvailable() {
        available = true;
    }
}
