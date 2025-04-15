class Knight extends Warrior implements SpecialAbility {
    protected int level; // Level can be used to scale abilities over time

    // Constructor: sets Knight-specific stats and equips a Sword
    public Knight(String name, Shield shield) {
        super(name, 110, 1, 13, 10, new Weapon("Sword", 10), shield);
        this.level = 1; // Knight starts at level 1, levels up one level after defeating an enemy
    }

    // Knight's special ability: Power Strike
    @Override
    public void useAbility(Fighter target) {
        if (abilityCharged) {
            // Extra damage is calculated from strength, weapon power, a base bonus, and level
            int extraDamage = strength + weapon.getAttackPower() + 10 + level;
            System.out.println(name + " uses Power Strike!");
            target.takeDamage(extraDamage); // Deal the damage to the target
            abilityCharged = false; // Ability needs to be recharged after use
        } else {
            // Inform player that ability is not ready
            System.out.println("Ability not charged! Use 'Charge' to ready it.");
        }
    }
}