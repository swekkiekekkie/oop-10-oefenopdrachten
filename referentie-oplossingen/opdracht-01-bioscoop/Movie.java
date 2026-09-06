public class Movie {
    private String title;
    private int durationMinutes;
    private double ticketPrice;

    public Movie(String title, int durationMinutes, double ticketPrice) {
        // EDGE CASE: Duur moet positief zijn
        this.title = title;
        this.durationMinutes = Math.max(1, durationMinutes);
        // EDGE CASE: Prijs mag niet negatief zijn
        this.ticketPrice = Math.max(0.0, ticketPrice);
    }

    public String getTitle() {
        return title;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
