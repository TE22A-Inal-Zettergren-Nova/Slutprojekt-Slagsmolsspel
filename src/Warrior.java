// Abstract class for all warrior-type characters (Knight, Marksman, etc.)
abstract class Warrior extends Fighter {
    protected Weapon weapon;  // The weapon equipped by the warrior, which affects damage output
    protected int level; // Level can influence ability power and strenght

    // Constructor to initialize the warrior's stats, weapon, and shield // Sheild and level is not initilized in this class but is used in the subclasses
    public Warrior(String name, int health, double speed, int strength, int defense, Weapon weapon, Shield shield, int level) {
        super(name, health, speed, strength, defense); // Initialize base Fighter stats (health, speed, strength, etc.)
        this.weapon = weapon;  // Set the warrior's weapon
        this.level = 1; // start level
    }

    // Warrior's attack method - uses both strength and weapon attack power
    @Override
    public void attack(Fighter enemy) {
        // Calculate total damage by adding strength and weapons attack power
        int totalDamage = strength + weapon.getAttackPower();
        System.out.println(name + " attacks with " + weapon.getName() + " for " + totalDamage + " damage.");

        // apply the calculated damage to the enemy
        enemy.takeDamage(totalDamage);
    }


    // Warrior's dodge ability, uses speed to determine dodge chance
    @Override
    public boolean dodge() {
        // If a random value is less than the warrior's speed (scaled by 0.2), the dodge succeeds
        if (Math.random() < speed * 0.2) {
            System.out.println(name + " dodged the attack!");
            return true;
        } else {
            System.out.println(name + " failed to dodge.");
            return false;
        }
    }

}