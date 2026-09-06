public class Grade {
    private double value;
    private Course course;

    public Grade(double value, Course course) {
        // EDGE CASE: Cijfer moet tussen 1.0 en 10.0 liggen
        this.value = Math.max(1.0, Math.min(10.0, value));
        this.course = course;
    }

    public double getValue() {
        return value;
    }

    public Course getCourse() {
        return course;
    }

    // Grade weet zelf of het een voldoende is
    public boolean isPassing() {
        return value >= 5.5;
    }

    // Grade kent de vaknaam via Course
    public String getCourseName() {
        // EDGE CASE: Geen vak gekoppeld
        if (course == null) {
            return "Onbekend";
        }
        return course.getName();
    }
}
