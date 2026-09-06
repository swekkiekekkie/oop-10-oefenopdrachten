public class Main {
    public static void main(String[] args) {
        // Creëer een school
        School school = new School("Hogeschool Java");
        System.out.println("=== " + school.getName() + " ===");
        System.out.println();

        // Creëer vakken
        Course programming = new Course("Programmeren");
        Course databases = new Course("Databases");
        Course webdev = new Course("Webontwikkeling");
        Course math = new Course("Wiskunde");

        // Creëer student 1
        Student alice = new Student("Alice van Dam", 1001);
        alice.addGrade(new Grade(7.5, programming));
        alice.addGrade(new Grade(8.0, databases));
        alice.addGrade(new Grade(6.5, webdev));
        alice.addGrade(new Grade(5.0, math));  // onvoldoende
        
        school.addStudent(alice);

        // Creëer student 2
        Student bob = new Student("Bob de Groot", 1002);
        bob.addGrade(new Grade(6.0, programming));
        bob.addGrade(new Grade(5.5, databases));  // net voldoende
        bob.addGrade(new Grade(4.5, webdev));     // onvoldoende
        bob.addGrade(new Grade(7.0, math));
        
        school.addStudent(bob);

        // Demonstreer delegatie voor cijfers
        System.out.println("--- Delegatie demonstratie ---");
        Grade testGrade = alice.getGrades().get(0);
        System.out.println("Cijfer: " + testGrade.getValue());
        System.out.println("Grade bepaalt zelf of het voldoende is: " + testGrade.isPassing());
        System.out.println("Grade vraagt vaknaam aan Course: " + testGrade.getCourseName());
        System.out.println();

        // Rapporten
        school.printStudentReport(alice);
        System.out.println();
        school.printStudentReport(bob);
        System.out.println();

        // Schoolgemiddelde
        System.out.println("--- Schoolstatistieken ---");
        System.out.printf("Schoolgemiddelde: %.2f%n", school.calculateSchoolAverage());
        System.out.println();

        // Demonstreer delegatieketen
        System.out.println("--- Delegatieketen ---");
        System.out.println("School vraagt studentgemiddelde:");
        System.out.println("  School → vraagt aan Student calculateAverage()");
        System.out.println("  Student → vraagt aan elke Grade getValue()");
        System.out.println();
        System.out.println("School vraagt voldoendes:");
        System.out.println("  School → vraagt aan Student countPassingGrades()");
        System.out.println("  Student → vraagt aan elke Grade isPassing()");
        System.out.println("  Grade bepaalt ZELF of het een voldoende is (>=5.5)");
    }
}
