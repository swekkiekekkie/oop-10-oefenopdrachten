public class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        // EDGE CASE: Schade mag niet negatief zijn
        this.damage = Math.max(0, damage);
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
