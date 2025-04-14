public class Enemy extends Fighter {
    private boolean isBoss; //bestämmer om fienden kommer vara en boss med specialattacker eller ej

    public Enemy(double protection, double speed, int health, String name, int strength, SpecialAbility specialAbility) {
        super(protection, speed, health, name, strength, specialAbility);
    }

    @Override
    public void attack(Fighter opponents) {

    }


    @Override
    public void useAbility(Fighter target) {

    }
}








