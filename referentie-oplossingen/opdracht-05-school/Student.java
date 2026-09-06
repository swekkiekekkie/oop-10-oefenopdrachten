import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int studentNumber;
    private List<Grade> grades;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        // EDGE CASE: Null cijfers niet toevoegen
        if (grade != null) {
            grades.add(grade);
        }
    }

    // Student berekent gemiddelde door cijfers aan Grades te vragen
    public double calculateAverage() {
        // EDGE CASE: Geen cijfers
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Grade grade : grades) {
            sum += grade.getValue();
        }
        return sum / grades.size();
    }

    // Heeft de student een voldoende voor een bepaald cijfer?
    // Delegeert aan Grade.isPassing() - Student controleert NIET zelf de waarde
    public boolean hasPassingGrade(Grade grade) {
        // EDGE CASE: Null grade
        if (grade == null) {
            return false;
        }
        // Delegeer aan Grade om te bepalen of het een voldoende is
        return grade.isPassing();
    }

    // Student telt voldoendes door aan elke Grade te vragen of het een voldoende is
    public int countPassingGrades() {
        int count = 0;
        for (Grade grade : grades) {
            if (hasPassingGrade(grade)) {
                count++;
            }
        }
        return count;
    }

    public int countFailingGrades() {
        return grades.size() - countPassingGrades();
    }
}
