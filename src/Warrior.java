public abstract class Warrior extends Fighter {
    private Weapon weapon;

    public Warrior(double defence, double speed, int health, String name, int strength, SpecialAbility specialAbility, Weapon weapon) {
        super(defence, speed, health, name, strength, specialAbility);
        this.weapon = weapon;
    }

    // Abstract method som kommer att implementeras i subklasserna
    public abstract void attack(Fighter opponent);

    public void reloadPowers(){ //laddar upp en del av magikerns mana eller krigarens strength beroende på vilken karaktär man är

    }
}
