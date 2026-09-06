import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        // EDGE CASE: Null studenten niet toevoegen
        if (student != null) {
            students.add(student);
        }
    }

    // School vraagt gemiddelde aan Student (delegatie)
    public double getStudentAverage(Student student) {
        // EDGE CASE: Geen student meegegeven
        if (student == null) {
            return 0.0;
        }
        return student.calculateAverage();
    }

    // School vraagt aan elke Student het gemiddelde en berekent schoolgemiddelde
    public double calculateSchoolAverage() {
        // EDGE CASE: Geen studenten
        if (students.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        int count = 0;
        for (Student student : students) {
            double avg = student.calculateAverage();
            // EDGE CASE: Studenten zonder cijfers niet meetellen
            if (student.getGrades().size() > 0) {
                sum += avg;
                count++;
            }
        }
        // EDGE CASE: Geen studenten met cijfers
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }

    public void printStudentReport(Student student) {
        System.out.println("=== Rapport " + student.getName() + " ===");
        System.out.println("Studentnummer: " + student.getStudentNumber());
        System.out.println();
        
        System.out.println("Cijfers:");
        for (Grade grade : student.getGrades()) {
            String status = grade.isPassing() ? "voldoende" : "onvoldoende";
            System.out.printf("  %s: %.1f (%s)%n", 
                grade.getCourseName(), grade.getValue(), status);
        }
        
        System.out.println();
        System.out.printf("Gemiddelde: %.2f%n", getStudentAverage(student));
        System.out.println("Aantal voldoendes: " + student.countPassingGrades());
        System.out.println("Aantal onvoldoendes: " + student.countFailingGrades());
    }
}
