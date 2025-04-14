public class Knight extends Warrior {
    private double distance;

    public Knight(double defence, double speed, int health, String name, int strength, SpecialAbility specialAbility, Weapon weapon, double distance) {
        super(defence, speed, health, name, strength, specialAbility, weapon);
        this.distance = distance;
    }

    @Override
    public void attack(Fighter opponent) {

    }

    @Override
    public void useAbility(Fighter target) {

    }
}

