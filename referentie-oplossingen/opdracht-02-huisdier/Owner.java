public class Owner {
    private String name;
    private int age;

    public Owner(String name, int age) {
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

    // Owner weet zelf of hij/zij volwassen is
    public boolean isAdult() {
        return age >= 18;
    }
}
