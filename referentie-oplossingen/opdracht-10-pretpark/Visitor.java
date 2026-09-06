public class Visitor {
    private String name;
    private int age;

    public Visitor(String name, int age) {
        this.name = name;
        // EDGE CASE: Leeftijd mag niet negatief zijn
        this.age = Math.max(0, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
