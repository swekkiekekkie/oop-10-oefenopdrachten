public class Main {
    public static void main(String[] args) {
        // Creëer bibliotheek
        Library library = new Library("Openbare Bibliotheek Amsterdam");
        
        // Voeg boeken toe
        Book book1 = new Book("De Aanslag", "Harry Mulisch");
        Book book2 = new Book("Het Achterhuis", "Anne Frank");
        Book book3 = new Book("Turks Fruit", "Jan Wolkers");
        Book book4 = new Book("De Ontdekking van de Hemel", "Harry Mulisch");
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // Voeg leden toe
        Member alice = new Member("Alice van Berg", 1001, 25);
        Member bob = new Member("Bob Jansen", 1002, 17);  // Minderjarig
        Member carol = new Member("Carol de Wit", 1003, 45);
        
        library.addMember(alice);
        library.addMember(bob);
        library.addMember(carol);

        // Toon beginstatus
        System.out.println("--- Beginstatus ---");
        library.printStatus();
        System.out.println();

        // Toon leden
        System.out.println("--- Leden ---");
        System.out.println(alice.getName() + " (nr: " + alice.getMemberNumber() + ", volwassen: " + alice.isAdult() + ")");
        System.out.println(bob.getName() + " (nr: " + bob.getMemberNumber() + ", volwassen: " + bob.isAdult() + ")");
        System.out.println(carol.getName() + " (nr: " + carol.getMemberNumber() + ", volwassen: " + carol.isAdult() + ")");
        System.out.println();

        // Uitlening 1: Alice leent boek voor 14 dagen
        System.out.println("--- Uitlening 1 ---");
        Loan loan1 = library.lendBook(book1, alice, 14);
        if (loan1 != null) {
            System.out.println(alice.getName() + " leent '" + book1.getTitle() + "'");
            System.out.println("Dagen: " + loan1.getDays());
            System.out.println("Te laat (>21 dagen): " + loan1.isOverdue());
            System.out.println("Boek nog beschikbaar: " + book1.isAvailable());
        }
        System.out.println();

        // Uitlening 2: Bob leent boek voor 25 dagen (te laat!)
        System.out.println("--- Uitlening 2 ---");
        Loan loan2 = library.lendBook(book2, bob, 25);
        if (loan2 != null) {
            System.out.println(bob.getName() + " leent '" + book2.getTitle() + "'");
            System.out.println("Dagen: " + loan2.getDays());
            System.out.println("Te laat (>21 dagen): " + loan2.isOverdue());
        }
        System.out.println();

        // EDGE CASE: Probeer hetzelfde boek nogmaals uit te lenen
        System.out.println("--- EDGE CASE: Dubbele uitlening ---");
        Loan duplicateLoan = library.lendBook(book1, carol, 7);
        System.out.println("Dubbele uitlening gelukt: " + (duplicateLoan != null));
        System.out.println("(Boek was al uitgeleend)");
        System.out.println();

        // Tussenstatus
        System.out.println("--- Tussenstatus ---");
        library.printStatus();
        System.out.println();

        // Simuleer tijd: voeg dagen toe aan uitlening 1
        System.out.println("--- Tijd simuleren ---");
        System.out.println("10 dagen later...");
        loan1.addDays(10);
        System.out.println("Uitlening 1 nu " + loan1.getDays() + " dagen");
        System.out.println("Te laat: " + loan1.isOverdue());
        System.out.println();

        // Retourneer boek 1
        System.out.println("--- Boek retourneren ---");
        boolean returned = library.returnBook(loan1);
        System.out.println("Retourneren gelukt: " + returned);
        System.out.println("Boek '" + book1.getTitle() + "' weer beschikbaar: " + book1.isAvailable());
        System.out.println("Uitlening nog actief: " + loan1.isActive());
        System.out.println();

        // Eindstatus
        System.out.println("--- Eindstatus ---");
        library.printStatus();
        System.out.println();

        // Delegatieketen
        System.out.println("--- Delegatieketen ---");
        System.out.println("Boek uitlenen:");
        System.out.println("  Library → maakt Loan → Loan.start() → Book.lend()");
        System.out.println("  Book markeert ZICHZELF als uitgeleend");
        System.out.println();
        System.out.println("Boek retourneren:");
        System.out.println("  Library → Loan.finish() → Book.returnBook()");
        System.out.println("  Book markeert ZICHZELF als beschikbaar");
    }
}
