public class Main {
    public static void main(String[] args) {
        // Creëer een bioscoop
        Cinema cinema = new Cinema("Pathé City");
        System.out.println("Welkom bij " + cinema.getName());
        System.out.println();

        // Creëer een film
        Movie movie = new Movie("The Matrix", 136, 12.50);
        System.out.println("Film: " + movie.getTitle());
        System.out.println("Duur: " + movie.getDurationMinutes() + " minuten");
        System.out.println("Ticketprijs: €" + movie.getTicketPrice());
        System.out.println();

        // Koop een ticket
        Ticket ticket = new Ticket("A15", movie);
        System.out.println("Ticket gekocht voor stoel: " + ticket.getSeatNumber());
        System.out.println("Ticket is voor film: " + ticket.getMovie().getTitle());
        System.out.println("Ticketprijs (via delegatie): €" + ticket.getPrice());
        System.out.println("Ticket gebruikt: " + ticket.isUsed());
        System.out.println();

        // Gebruik het ticket
        System.out.println("Ticket gebruiken...");
        boolean success = ticket.use();
        System.out.println("Gebruik gelukt: " + success);
        System.out.println("Ticket nu gebruikt: " + ticket.isUsed());
        System.out.println();

        // Probeer ticket nogmaals te gebruiken (EDGE CASE)
        System.out.println("Probeer ticket nogmaals te gebruiken...");
        boolean secondUse = ticket.use();
        System.out.println("Tweede gebruik gelukt: " + secondUse);
        System.out.println();

        // Bereken opbrengst voor de bioscoop
        System.out.println("Opbrengst bioscoop voor dit ticket: €" + cinema.calculateEarnings(ticket));
    }
}
