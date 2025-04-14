public class Magician extends Warrior {
    private int mana; //Hur mycket mana spelaren har, kan laddas upp 1 gång per nivå.

    public Magician(double defence, double speed, int health, String name, int strength, SpecialAbility specialAbility, Weapon weapon, int mana) {
        super(defence, speed, health, name, strength, specialAbility, weapon);
        this.mana = mana;
    }

    @Override
    public void attack(Fighter opponent) {

    }


    @Override
    public void useAbility(Fighter target) {

    }
}

