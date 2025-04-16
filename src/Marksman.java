class Marksman extends Warrior implements SpecialAbility {
    protected int level; // Level can influence ability power

    // Constructor: initializes Marksman-specific stats and equips a Bow
    public Marksman(String name, Shield shield) {
        super(name, 100, 1.7, 12, 6, new Weapon("Bow", 9), shield);
        this.level = 1; // Marksman starts at level 1, levels up one level after defeating an enemy
    }

    // Implementation of the special ability (Fire Arrow) //Kanske ändra systemet men funkar som detta oxå
    @Override
    public void useAbility(Fighter target) {
        if (abilityCharged) { // Ability can only be used if charged
            // Calculates damage using strength, weapon power, bonus, and level
            int fireArrow = strength + weapon.getAttackPower() + 6 + level;
            System.out.println(name + " uses Fire Arrow!");
            target.takeDamage(fireArrow); // Deal the calculated damage to the target
            abilityCharged = false; // Ability must be recharged before next use
        } else {
            // Inform player that ability is not ready
            System.out.println("Ability not charged! Use 'Charge' to ready it.");
        }
    }
}