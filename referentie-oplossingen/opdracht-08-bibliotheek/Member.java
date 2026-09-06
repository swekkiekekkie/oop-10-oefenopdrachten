public class Member {
    private String name;
    private int memberNumber;
    private int age;

    public Member(String name, int memberNumber, int age) {
        this.name = name;
        this.memberNumber = memberNumber;
        // EDGE CASE: Leeftijd mag niet negatief zijn
        this.age = Math.max(0, age);
    }

    public String getName() {
        return name;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public int getAge() {
        return age;
    }

    // Member weet zelf of hij/zij volwassen is
    public boolean isAdult() {
        return age >= 18;
    }
}
