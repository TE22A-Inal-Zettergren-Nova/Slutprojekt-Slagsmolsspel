public class Marksman extends Warrior {
    private int ammunition; //Hur mycket ammo spelaren har, vid 0 behövs den laddas upp

    public Marksman(double defence, double speed, int health, String name, int strength, SpecialAbility specialAbility, Weapon weapon, int ammunition) {
        super(defence, speed, health, name, strength, specialAbility, weapon);
        this.ammunition = ammunition;
    }

    @Override
    public void attack(Fighter opponent) {

    }

    @Override
    public void useAbility(Fighter target) {

    }
}


