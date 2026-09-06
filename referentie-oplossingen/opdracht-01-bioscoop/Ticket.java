public class Ticket {
    private String seatNumber;
    private boolean used;
    private Movie movie;

    public Ticket(String seatNumber, Movie movie) {
        this.seatNumber = seatNumber;
        this.used = false;
        this.movie = movie;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isUsed() {
        return used;
    }

    public Movie getMovie() {
        return movie;
    }

    // Delegeert de prijsvraag aan Movie
    public double getPrice() {
        return movie.getTicketPrice();
    }

    // Ticket markeert zichzelf als gebruikt
    public boolean use() {
        // EDGE CASE: Ticket kan maar één keer gebruikt worden
        if (used) {
            return false;
        }
        used = true;
        return true;
    }
}
