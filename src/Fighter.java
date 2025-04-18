// Abstract base class for all characters that can fight (players and enemies)
abstract class Fighter {
    protected String name;                   // Character's name
    protected int health;                    // Current health
    protected double speed;                  // Speed affects dodge chances
    protected int strength;                  // Damage potential
    protected int defense;                   // Base incoming damage reduction
    protected boolean abilityCharged = true; // Determines if special ability can be used
    protected int temporaryDefense = 0;      // Temporary defense bonus from shields
    protected int defenseRoundsLeft = 0;     // How many rounds the temporary defense lasts
    protected Shield shield;                 // The equipped shield (can be null)

    // Constructor to set fighter's base stats
    public Fighter(String name, int health, double speed, int strength, int defense) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.defense = defense;
    }

    //Returns the shield currently equipped
    public Shield getShield() {
        return shield;
    }

    // Checks if the fighter is still alive
    public boolean isAlive() {
        return health > 0;
    }

    // Apply temporary defense boost for a set number of rounds
    public void addTemporaryDefense(int amount, int rounds) {
        this.temporaryDefense += amount;
        this.defenseRoundsLeft = rounds;
    }

    // Reduces the round counter for temporary defense and removes it if expired
    public void reduceDefenseRound() {
        if (defenseRoundsLeft > 0) {
            defenseRoundsLeft--;
            if (defenseRoundsLeft == 0) {
                temporaryDefense = 0;
                System.out.println(name + "'s shield effect has worn off.");
            }
        }
    }

    // Returns how much temporary defense the fighter currently has
    public int getTemporaryDefense() {
        return temporaryDefense;
    }

    // Charges the special ability, but makes the fighter vulnerable during that round
    public void chargeAbility() {
        System.out.println(name + " is charging their ability... Vulnerable this round!");
        abilityCharged = true;
    }

    // Reduces health based on incoming damage and defense
    public void takeDamage(int dmg) {
        int reduced = (int) (dmg * (1 - defense / 100.0)); //Mechanism too determent reduced incoming damage based on players defence
        health -= Math.max(reduced, 0);
        System.out.println(name + " took " + reduced + " damage. Health: " + health);
    }

    // Abstract method to define how each subclass performs a basic attack implemented in subklasses
    public abstract void attack(Fighter enemy);

    // Abstract method for dodge behavior (to be implemented in subclasses)
    public abstract boolean dodge();


    //Returns the name of the fighter
    public String getName() {
        return name;
    }
    //This is for the potion class
    // Heals the fighter by a given amount
    public void heal(int amount) {
        health += amount;
        System.out.println(name + " healed for " + amount + ". Health: " + health);
    }

    // Increases speed temporarily or permanently (depending on use)
    public void boostSpeed(double amount) {
        speed += amount;
        System.out.println(name + " speed increased to " + speed);
    }

    // Increases strength stat
    public void boostStrength(int amount) {
        strength += amount;
        System.out.println(name + " strength increased to " + strength);
    }
}
