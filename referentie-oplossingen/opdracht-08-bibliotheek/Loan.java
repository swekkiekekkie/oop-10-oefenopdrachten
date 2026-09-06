public class Loan {
    private int days;
    private Book book;
    private Member member;
    private boolean active;

    private static final int MAX_LOAN_DAYS = 21;

    public Loan(int days, Book book, Member member) {
        // EDGE CASE: Minimaal 1 dag
        this.days = Math.max(1, days);
        this.book = book;
        this.member = member;
        this.active = false;
    }

    public int getDays() {
        return days;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public boolean isActive() {
        return active;
    }

    // Loan weet zelf of het te laat is
    public boolean isOverdue() {
        return days > MAX_LOAN_DAYS;
    }

    // Start de uitlening (delegeert aan Book)
    public boolean start() {
        // EDGE CASE: Al actief
        if (active) {
            return false;
        }
        // EDGE CASE: Geen boek of lid
        if (book == null || member == null) {
            return false;
        }
        // Delegeer aan Book om zichzelf als uitgeleend te markeren
        boolean success = book.lend();
        if (success) {
            active = true;
        }
        return success;
    }

    // Beëindig de uitlening (delegeert aan Book)
    public boolean finish() {
        // EDGE CASE: Niet actief
        if (!active) {
            return false;
        }
        // EDGE CASE: Geen boek
        if (book == null) {
            return false;
        }
        // Delegeer aan Book om zichzelf als beschikbaar te markeren
        book.returnBook();
        active = false;
        return true;
    }

    // Verhoog aantal dagen (simuleer tijd)
    public void addDays(int extraDays) {
        // EDGE CASE: Negatieve dagen negeren
        if (extraDays > 0) {
            days += extraDays;
        }
    }
}
