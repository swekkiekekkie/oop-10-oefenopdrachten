import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addBook(Book book) {
        // EDGE CASE: Null boeken niet toevoegen
        if (book != null) {
            books.add(book);
        }
    }

    public void addMember(Member member) {
        // EDGE CASE: Null leden niet toevoegen
        if (member != null) {
            members.add(member);
        }
    }

    // Maak nieuwe uitlening en start deze
    public Loan lendBook(Book book, Member member, int days) {
        // EDGE CASE: Geen boek of lid
        if (book == null || member == null) {
            return null;
        }
        // EDGE CASE: Boek niet in collectie
        if (!books.contains(book)) {
            return null;
        }
        
        Loan loan = new Loan(days, book, member);
        boolean success = loan.start();
        
        if (success) {
            loans.add(loan);
            return loan;
        }
        return null;
    }

    // Retourneer boek (delegeert aan Loan)
    public boolean returnBook(Loan loan) {
        // EDGE CASE: Geen uitlening
        if (loan == null) {
            return false;
        }
        return loan.finish();
    }

    // Vind beschikbare boeken
    public List<Book> findAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    // Vind te late uitleningen (delegeert aan Loan)
    public List<Loan> findOverdueLoans() {
        List<Loan> overdue = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isActive() && loan.isOverdue()) {
                overdue.add(loan);
            }
        }
        return overdue;
    }

    public void printStatus() {
        System.out.println("=== " + name + " ===");
        System.out.println("Boeken in collectie: " + books.size());
        System.out.println("Beschikbaar: " + findAvailableBooks().size());
        System.out.println("Leden: " + members.size());
        System.out.println("Actieve uitleningen: " + countActiveLoans());
        System.out.println("Te late uitleningen: " + findOverdueLoans().size());
    }

    private int countActiveLoans() {
        int count = 0;
        for (Loan loan : loans) {
            if (loan.isActive()) {
                count++;
            }
        }
        return count;
    }
}
