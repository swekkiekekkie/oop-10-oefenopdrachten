public class Player {
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        // EDGE CASE: Gezondheid mag niet negatief starten
        this.health = Math.max(0, health);
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    // Player vraagt schade aan Weapon en laat Enemy de schade verwerken
    public void attack(Enemy enemy) {
        // EDGE CASE: Geen vijand of wapen
        if (enemy == null || weapon == null) {
            return;
        }
        // EDGE CASE: Niet aanvallen als vijand al verslagen is
        if (enemy.isDefeated()) {
            return;
        }
        // Delegeer: vraag wapen hoeveel schade, laat vijand schade verwerken
        int damage = weapon.getDamage();
        enemy.takeDamage(damage);
    }

    // Player beheert eigen gezondheid
    public void takeDamage(int amount) {
        // EDGE CASE: Negatieve schade negeren
        if (amount < 0) {
            return;
        }
        // EDGE CASE: Gezondheid mag niet onder 0 komen
        health = Math.max(0, health - amount);
    }

    public boolean isDefeated() {
        return health <= 0;
    }
}
