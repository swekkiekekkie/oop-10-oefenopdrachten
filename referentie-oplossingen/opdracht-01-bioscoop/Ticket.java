public class Ticket {
    private int seatNumber;
    private boolean used;
    private Movie movie;

    public Ticket(int seatNumber, Movie movie) {
        // EDGE CASE: Stoelnummer moet positief zijn
        this.seatNumber = Math.max(1, seatNumber);
        this.used = false;
        this.movie = movie;
    }

    public int getSeatNumber() {
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
